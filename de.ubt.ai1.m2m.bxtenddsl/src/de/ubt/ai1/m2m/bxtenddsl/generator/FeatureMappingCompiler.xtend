package de.ubt.ai1.m2m.bxtenddsl.generator

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.emf.ecore.EStructuralFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collection
import java.util.LinkedHashMap
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature
import java.util.List
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import java.util.Set
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
import org.eclipse.emf.ecore.EClass
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher
import org.eclipse.xtext.xbase.lib.Functions.Function0
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EEnum
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature
import java.util.Properties

/**
 * A compiler for feature mappings.
 */
class FeatureMappingCompiler extends Compiler {
	@Data static class Method {
		String call
		String typeClass
		String method
	}
	
	Properties modelsProperties
	
	def void setModelsProperties(Properties modelsProperties) {
		this.modelsProperties = modelsProperties
	}
	
	/**
	 * Returns true, if a feature mapping is compileable as assignment.
	 */
	def boolean compileableToAssignment(boolean srcToTrg, FeatureMapping mapping) {
		return compileableToAssignmentSimple(srcToTrg, mapping)
				|| compileableToAssignmentSingleCorr(srcToTrg, mapping)
				|| compileableToAssignmentMultiCorr(srcToTrg, mapping)
	}
	
	/**
	 * Compiles a feature mapping as assignment.
	 */
	def String compileToAssignment(boolean srcToTrg, FeatureMapping mapping, IdentifierScope localScope) {
		if (compileableToAssignmentSimple(srcToTrg, mapping)) {
			compileToAssignmentSimple(srcToTrg, mapping)
		} else if (compileableToAssignmentSingleCorr(srcToTrg, mapping)) {
			compileToAssignmentSingleCorr(srcToTrg, mapping)
		} else if (compileableToAssignmentMultiCorr(srcToTrg, mapping)) {
			compileToAssignmentMultiCorr(srcToTrg, mapping, localScope)
		} else {
			throw new IllegalArgumentException("The feature mapping is not compileable as assignment!")
		}
	}
	
	/**
	 * Compiles a feature mapping as method. Returns the call of the generated method, the actual method and
	 * a nested class that is used as return type of the method.
	 */
	def Method compileToMethod(boolean srcToTrg, FeatureMapping mapping, IdentifierScope ruleScope,
			IdentifierScope localScope) {
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		val paramToId = new LinkedHashMap<PreprocessedMapping.Parameter, String>()
		
		val outputDescription = preprocessed.output.map[suggestedIdentifier].join("_")
		val methodId = ruleScope.addIdentifier(outputDescription + "From", IdentifierScope.Group.METHOD)
		val fromPos = methodId.lastIndexOf("From")
		val fromLessId = methodId.substring(0, fromPos) + methodId.substring(fromPos + 4, methodId.length())
		
		val type = ruleScope.addIdentifier("Type4" + fromLessId, IdentifierScope.Group.CLASS)
		val typeScope = new IdentifierScope()
		val typeClass = '''
		@Data protected static class «type» {
			«FOR param : preprocessed.output»
				«param.javaType» «{
					val suggested = param.suggestedIdentifier
					val actual = typeScope.addIdentifier(suggested, IdentifierScope.Group.VARIABLE)
					paramToId.put(param, actual)
					actual
				}»
			«ENDFOR»
		}
		'''
		
		val methodScope = new IdentifierScope()
		var methodParams = new ArrayList<String>()
		for (param : preprocessed.input) {
			val suggested = param.suggestedIdentifier
			val actual = methodScope.addIdentifier(suggested, IdentifierScope.Group.VARIABLE)
			paramToId.put(param, actual)
			methodParams += param.javaType + " " + actual
		}
		val method = '''
		def protected abstract «type» «methodId»(«methodParams.join(", ")»);
		'''
		
		val callParamComputations = new ArrayList<String>()
		val callParams = new ArrayList<String>()
		for (in : preprocessed.input) {
			if (in.read.apply().length() > 24 && in.suggestedIdentifier.length() < in.read.apply().length()) {
				val callParamId = localScope.addIdentifier("_" + in.suggestedIdentifier, IdentifierScope.Group.VARIABLE)
				callParamComputations += '''val «callParamId» = «in.read.apply()»'''
				callParams += callParamId
			} else {
				callParams += in.read.apply()
			}
		}
		val resultId = localScope.addIdentifier("_" + fromLessId, IdentifierScope.Group.VARIABLE)
		val call = '''
		«FOR feature : (if (srcToTrg) mapping.srcFeatures else mapping.trgFeatures).filter[corr]»
			«IF feature.feature.upperBound == 1»
				«feature.getter»?.corr?.assertRuleId(«feature.corrs.map[rule.name].join(", ", ['''"«it»"'''])»)
			«ELSE»
				«feature.getter».forEach[corr.assertRuleId(«feature.corrs.map[rule.name].join(", ", ['''"«it»"'''])»)]
			«ENDIF»
		«ENDFOR»
		«FOR computation : callParamComputations»
			«computation»
		«ENDFOR»
		val «resultId» = «methodId»(«callParams.join(", ")»)
		«FOR param : preprocessed.output»
			«param.write.apply('''«resultId».«paramToId.get(param)»''')»
		«ENDFOR»
		'''
		
		return new Method(call, typeClass, method)
	}
	
	/**
	 * Returns if the compilation of this mapping contains any abstract method.
	 * This method assumes mappings are compiled as assignment whenever possible.
	 */
	def boolean anyAbstractMethod(boolean srcToTrg, FeatureMapping mapping) {
		return !compileableToAssignment(srcToTrg, mapping)
	}
	/**
	 * Returns if the compilation of this mapping contains any use of the given class matcher.
	 */
	def boolean anyUseOf(boolean srcToTrg, FeatureMapping mapping, String matcher) {
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		return preprocessed.input.exists[it.matcher == matcher] || preprocessed.output.exists[it.matcher == matcher]
	}
	/**
	 * Returns all imports that the compilation of this mapping needs.
	 * This method assumes mappings are compiled as assignment whenever possible.
	 */
	def Set<String> neededImports(boolean srcToTrg, FeatureMapping mapping, String rootPackage) {
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		
		var imports = super.neededImports(rootPackage)
		if (srcToTrg) {
			if (mapping.srcFeatures.exists[corrs.exists[it.allMatchers.exists[!modifier.group]]]) {
				imports += ('''import «rootPackage».corrmodel.SingleElem''')
			}
			if (mapping.srcFeatures.exists[corrs.exists[it.allMatchers.exists[modifier.group]]]) {
				imports += ('''import «rootPackage».corrmodel.MultiElem''')
				imports += ("import java.util.List")
			}
		} else {
			if (mapping.trgFeatures.exists[corrs.exists[it.allMatchers.exists[!modifier.group]]]) {
				imports += ('''import «rootPackage».corrmodel.SingleElem''')
			}
			if (mapping.trgFeatures.exists[corrs.exists[it.allMatchers.exists[modifier.group]]]) {
				imports += ('''import «rootPackage».corrmodel.MultiElem''')
				imports += ("import java.util.List")
			}
		}
		if (!compileableToAssignment(srcToTrg, mapping)) {
			imports += ("import org.eclipse.xtend.lib.annotations.Data")
			
			if (preprocessed.input.exists[javaType.startsWith("List<")]
					|| preprocessed.output.exists[javaType.startsWith("List<")]) {
				imports += ("import java.util.List")
			}
		}
		return imports
	}
	override Set<String> neededImports(String rootPackage) {
		val message = "Compiler interface not yet supported, use the neededImports method with parameters!"
		throw new UnsupportedOperationException(message)
	}
	
	@Data private static class PreprocessedMapping {
		@Data static class Parameter {
			String matcher
			String javaType
			String suggestedIdentifier
			Function0<String> read
			Function1<String, String> write
		}
		
		Collection<Parameter> input
		Collection<Parameter> output
	}
	
	@Inject extension Utils
	
	def private boolean compileableToAssignmentSimple(boolean srcToTrg, FeatureMapping mapping) {
		val inFeatures = if (srcToTrg) mapping.srcFeatures else mapping.trgFeatures
		val outFeatures = if (srcToTrg) mapping.trgFeatures else mapping.srcFeatures
		val inClasses = if (srcToTrg) mapping.srcClasses else mapping.trgClasses
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		
		if (preprocessed.input.size() != 1 || preprocessed.output.size() != 1) {
			return false
		}
		if (!inFeatures.empty && inFeatures.get(0).corr) {
			return false
		}
		
		val inputEClass = if (!inFeatures.empty) {
			inFeatures.get(0).feature.EType
		} else {
			inClasses.get(0).clazz
		}
		val outputEClass = outFeatures.get(0).feature.EType
		if (inputEClass instanceof EDataType || outputEClass instanceof EDataType) {
			return preprocessed.input.get(0).javaType == preprocessed.output.get(0).javaType
		}
		if (!(inputEClass instanceof EClass) || !(outputEClass instanceof EClass)) {
			return false
		}
		
		val inputMultivalued = if (!inFeatures.empty) {
			inFeatures.get(0).feature.upperBound != 1
		} else {
			inClasses.get(0).modifier.group
		}
		val outputMultivalued = outFeatures.get(0).feature.upperBound != 1
		
		return (outputEClass as EClass).isSuperTypeOf(inputEClass as EClass) && inputMultivalued == outputMultivalued
	}
	def private boolean compileableToAssignmentSingleCorr(boolean srcToTrg, FeatureMapping mapping) {
		val input = if (srcToTrg) mapping.srcFeatures else mapping.trgFeatures
		val output = if (srcToTrg) mapping.trgFeatures else mapping.srcFeatures
		
		if (!mapping.srcClasses.empty || !mapping.trgClasses.empty) {
			return false
		}
		if (input.size() != 1 || input.get(0).feature.upperBound != 1) {
			return false
		}
		if (output.size() != 1 || output.get(0).feature.upperBound != 1) {
			return false
		}
		
		val matchersInputCorrs = if (!input.get(0).corr) {
			return false
		} else {
			input.get(0).corrs.map[it.allMatchers]
		}
		val outputEClass = if (!(output.get(0).feature.EType instanceof EClass)) {
			return false
		} else {
			output.get(0).feature.EType as EClass
		}
		
		for (matchers : matchersInputCorrs) {
			if (matchers.size() != 1 || matchers.get(0).modifier.group) {
				return false
			}
			
			if (!outputEClass.isSuperTypeOf(matchers.get(0).clazz)) {
				return false
			}
		}
		
		return true
	}
	def private boolean compileableToAssignmentMultiCorr(boolean srcToTrg, FeatureMapping mapping) {
		val input = if (srcToTrg) mapping.srcFeatures else mapping.trgFeatures
		val output = if (srcToTrg) mapping.trgFeatures else mapping.srcFeatures
		
		if (!mapping.srcClasses.empty || !mapping.trgClasses.empty) {
			return false
		}
		if (input.size() != 1) {
			return false
		}
		if (output.size() != 1 || output.get(0).feature.upperBound == 1) {
			return false
		}
		
		val matchersInputCorrs = if (!input.get(0).corr) {
			return false
		} else {
			input.get(0).corrs.map[it.allMatchers]
		}
		val outputEClass = if (!(output.get(0).feature.EType instanceof EClass)) {
			return false
		} else {
			output.get(0).feature.EType as EClass
		}
		
		for (matchers : matchersInputCorrs) {
			if (matchers.exists[!modifier.group] && input.get(0).feature.upperBound == 1) {
				return false
			}
			
			if (matchers.exists[!outputEClass.isSuperTypeOf(clazz)]) {
				return false
			}
		}
		
		return true
	}
	
	def private String compileToAssignmentSimple(boolean srcToTrg, FeatureMapping mapping) {
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		return '''
		«preprocessed.output.get(0).write.apply(preprocessed.input.get(0).read.apply())»
		'''
	}
	def private String compileToAssignmentSingleCorr(boolean srcToTrg, FeatureMapping mapping) {
		val input = if (srcToTrg) mapping.srcFeatures.get(0) else mapping.trgFeatures.get(0)
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		
		return '''
		«input.getter»?.corr?.assertRuleId(«input.corrs.map[rule.name].join(", ", ['''"«it»"'''])»)
		«preprocessed.output.get(0).write.apply(preprocessed.input.map[read.apply()].join(" else "))»
		'''
	}
	def private String compileToAssignmentMultiCorr(boolean srcToTrg, FeatureMapping mapping,
			IdentifierScope localScope) {
		val input = if (srcToTrg) mapping.srcFeatures.get(0) else mapping.trgFeatures.get(0)
		val preprocessed = preprocessFeatureMapping(srcToTrg, mapping)
		
		val outputIdSuggestion = "_" + preprocessed.output.get(0).suggestedIdentifier
		val outputId = localScope.addIdentifier(outputIdSuggestion, IdentifierScope.Group.VARIABLE)
		val flatAccessExpressions = new ArrayList<String>()
		for (preprocessedInput : preprocessed.input) {
			if (preprocessedInput.javaType.startsWith("List<List<")) {
				flatAccessExpressions += preprocessedInput.read.apply() + ".flatten()"
			} else {
				flatAccessExpressions += preprocessedInput.read.apply()
			}
		}
		
		neededImports += "import java.util.List"
		return '''
		«IF input.feature.upperBound == 1»
			«input.getter»?.corr?.assertRuleId(«input.corrs.map[rule.name].join(", ", ['''"«it»"'''])»)
			val «preprocessed.output.get(0).javaType» «outputId» = newArrayList()
			«FOR accessExpression : preprocessed.input.map[read.apply()]»
				«outputId» += «accessExpression» ?: newArrayList()
			«ENDFOR»
			«preprocessed.output.get(0).write.apply(outputId)»
		«ELSE»
			«input.getter».forEach[corr.assertRuleId(«input.corrs.map[rule.name].join(", ", ['''"«it»"'''])»)]
			val «preprocessed.output.get(0).javaType» «outputId» = newArrayList()
			«FOR flatAccessExpression : flatAccessExpressions»
				«outputId» += «flatAccessExpression»
			«ENDFOR»
			«preprocessed.output.get(0).write.apply(outputId)»
		«ENDIF»
		'''
	}
	
	/**
	 * Computes for all parameters of a mapping its java type, multiplicity,
	 * a suggested identifier and an expression to access the parameter.
	 */
	def private PreprocessedMapping preprocessFeatureMapping(boolean srcToTrg, FeatureMapping mapping) {
		var preprocessedSrc = newArrayList()
		if (srcToTrg) {
			preprocessedSrc += preprocessClassesUpdater(mapping.trgClasses.filter(typeof(TrgClassMatcher)).toList())
			preprocessedSrc += preprocessClassesPure(mapping.srcClasses)
		} else {
			preprocessedSrc += preprocessClassesPure(
					mapping.srcClasses.filter[modifier.group && it instanceof SrcClassMatcher].toList())
		}
		preprocessedSrc += preprocessFeatures(mapping.srcFeatures, srcToTrg)
		
		var preprocessedTrg = newArrayList()
		if (!srcToTrg) {
			preprocessedTrg += preprocessClassesUpdater(mapping.srcClasses.filter(typeof(SrcClassMatcher)).toList())
			preprocessedTrg += preprocessClassesPure(mapping.trgClasses)
		} else {
			preprocessedTrg += preprocessClassesPure(
					mapping.trgClasses.filter[modifier.group && it instanceof TrgClassMatcher].toList())
		}
		preprocessedTrg += preprocessFeatures(mapping.trgFeatures, !srcToTrg)
		
		if (srcToTrg) {
			return new PreprocessedMapping(preprocessedSrc, preprocessedTrg)
		} else {
			return new PreprocessedMapping(preprocessedTrg, preprocessedSrc)
		}
	}
	
	def private List<PreprocessedMapping.Parameter> preprocessFeatures(List<? extends MappingFeature> features,
			boolean resolveCorrs) {
		var preprocessedFeatures = new ArrayList<PreprocessedMapping.Parameter>()
		
		for (rawFeature : features) {
			val classMatcher = rawFeature.token.substring(0, rawFeature.token.indexOf("."))
			val multi = rawFeature.feature.upperBound != 1
			
			if (resolveCorrs && rawFeature.corr) {
				for (corr : rawFeature.corrs) {
					for (matcher : corr.allMatchers) {
						var type = matcher.qualifiedType()
						if (multi) {
							type = '''List<«type»>'''
						}
						val TransformationRule rule = rawFeature.eContainer.eContainer as TransformationRule
						
						var identifier = if (isNameAmbigious(rawFeature.feature, rule)) {
							rawFeature.token
						} else {
							rawFeature.token.split("\\.").last()
						}
						identifier += if (rawFeature.corrs.size() > 1) {
							"." + corr.rule.name
						} else {
							""
						}
						identifier += "." + matcher.name
						identifier = shortenIdentifier(identifier)
						
						val corrSide = if (rawFeature instanceof SrcMappingFeature) "target" else "source"
						val index = if (rawFeature instanceof SrcMappingFeature) {
							corr.rule.trgMatcher.indexOf(matcher)
						} else {
							corr.rule.srcMatcher.indexOf(matcher)
						}
						val corrElem = if (!matcher.modifier.group) "SingleElem" else "MultiElem"
						val corrElemType = matcher.qualifiedType()
						val access = '''
						«IF !multi»
							if («rawFeature.getter» !== null && «rawFeature.getter».corr.ruleId == "«corr.rule.name»") {
								unwrap(«rawFeature.getter».corr.«corrSide».get(«index») as «corrElem») as «corrElemType»
							}«
						ELSE»
							«rawFeature.getter»
									.filter[corr.ruleId == "«corr.rule.name»"]
									.map[unwrap(corr.«corrSide».get(«index») as «corrElem») as «corrElemType»]
									.toList()«
						ENDIF»'''
						
						preprocessedFeatures += new PreprocessedMapping.Parameter(classMatcher, type, identifier, [
							access
						], [
							throw new UnsupportedOperationException(
								"A resolved corr mapping feature can only be used as input of a mapping!")
						])
					}
				}
				
			} else if (!resolveCorrs && rawFeature.corr && features.exists[feature == rawFeature.feature && !corr]) {
				// ignore to avoid duplicates, will be handled by the non corr version
				
			} else {
				var type = featureType(rawFeature.feature)
				if (multi) {
					type = '''List<«type»>'''
				}
				val TransformationRule rule = rawFeature.eContainer.eContainer as TransformationRule
				val identifier = if (isNameAmbigious(rawFeature.feature, rule)) {
					shortenIdentifier(rawFeature.token)
				} else {
					shortenIdentifier(rawFeature.token.split("\\.").last())
				}
				preprocessedFeatures += new PreprocessedMapping.Parameter(classMatcher, type, identifier, [
					rawFeature.getter
				], if (!type.startsWith("List<")) [value |
					rawFeature.setter(value)
				] else [value | '''
					«rawFeature.getter».clear()
					«rawFeature.getter».addAll(«value»)
				'''])
			}
		}
		
		return preprocessedFeatures
	}
	
	def private List<PreprocessedMapping.Parameter> preprocessClassesPure(List<ClassMatcher> classes) {
		var preprocessedClasses = new ArrayList<PreprocessedMapping.Parameter>()
		
		for (class : classes) {
			val clazz = class.clazz.qualifiedName
			val type = if (!class.modifier.group) clazz else '''List<«clazz»>'''
			val id = prefixKeyword(class.name)
			preprocessedClasses += new PreprocessedMapping.Parameter(class.name, type, id, [class.name],
					if (!type.startsWith("List<")) [
						throw new UnsupportedOperationException(
								"A not grouped pure class can only be used as input of a mapping!")
					] else [value | '''
						«class.name».clear()
						«class.name».addAll(«value»)
					'''])
		}
		
		return preprocessedClasses
	}
	
	def private List<PreprocessedMapping.Parameter> preprocessClassesUpdater(List<? extends ClassMatcher> classes) {
		var preprocessedClasses = new ArrayList<PreprocessedMapping.Parameter>()
		
		for (class : classes.filter[modifier.group]) {
			val updater = if (class instanceof SrcClassMatcher) "SrcMultiElemUpdater" else "TrgMultiElemUpdater"
			val clazz = class.clazz.qualifiedName
			val updaterType = '''«updater»<«clazz»>'''
			val updaterId = prefixKeyword('''«class.name»Updater''')
			val updaterAccess = '''new «updater»<«clazz»>(«class.name», "«class.clazz.name»", this,  _corr)'''
			preprocessedClasses += new PreprocessedMapping.Parameter(class.name, updaterType, updaterId, [
				updaterAccess
			], [
				throw new UnsupportedOperationException("An Updater can only be used as input of a mapping!")
			])
		}
		
		return preprocessedClasses
	}
	
	def private String featureType(EStructuralFeature feature) {
		var type = switch feature {
			EAttribute:
				if (feature.EType instanceof EEnum) {
					feature.EType.qualifiedName
				} else {
					feature.EType.instanceTypeName
				}
			EReference:
				feature.EType.qualifiedName
			default:
				throw new AssertionError("EStructuralFeature should be EAttribute or EReference!")
		}
		type = type.replaceFirst("\\Ajava.lang.", "")
	}
	
	def private String shortenIdentifier(String token) {
		val tokenSegments = token.split("\\.")
    	var identifier = ""
    	
    	for (var i = 0; i < tokenSegments.length; i++) {
    		var segment = tokenSegments.get(i)
    		if (i < tokenSegments.length - 1) {
    			segment = segment.substring(0, Math.min(3, segment.length()))
    		}
    		
    		if (i == 0 && !segment.isEmpty()) {
    			identifier += Character.toLowerCase(segment.charAt(0)) + segment.substring(1)
    		} else if (!segment.isEmpty()) {
    			identifier += Character.toUpperCase(segment.charAt(0)) + segment.substring(1)
    		}
    	}
    	
    	return prefixKeyword(identifier)
	}
	
	/**
	 * Prefixes the given keyword with an 'x', if it is an Xtend keyword.
	 */
	def private String prefixKeyword(String keyword) {
		if (isXtendKeyword(keyword)) {
			return "x" + keyword.toFirstUpper()
		} else {
			return keyword
		}
	}
	
	def private String getter(MappingFeature feature) {
		val model = if (feature instanceof SrcMappingFeature) "src" else "trg"
		val segments = feature.token.split("\\.")
		val classMatcher = segments.get(0)
		val structuralFeature = segments.get(1)
		val featureProperty = '''«model»>get>«feature.feature.EContainingClass.name».«structuralFeature»'''.toString()
		
		val featureAccess = if (modelsProperties.stringPropertyNames.contains(featureProperty)) {
			modelsProperties.getProperty(featureProperty)
		} else if (feature.feature.EType == EcorePackage.Literals.EBOOLEAN) {
			'''is«structuralFeature.toFirstUpper()»'''
		} else {
			'''get«structuralFeature.toFirstUpper()»'''
		}
		
		return '''«classMatcher».«featureAccess»()'''
	}
	def private String setter(MappingFeature feature, String value) {
		val model = if (feature instanceof SrcMappingFeature) "src" else "trg"
		val segments = feature.token.split("\\.")
		val classMatcher = segments.get(0)
		val structuralFeature = segments.get(1)
		val featureProperty = '''«model»>set>«feature.feature.EContainingClass.name».«structuralFeature»'''.toString()
		
		val featureAccess = if (modelsProperties.stringPropertyNames.contains(featureProperty)) {
			modelsProperties.getProperty(featureProperty)
		} else {
			'''set«structuralFeature.toFirstUpper()»'''
		}
		
		return '''«classMatcher».«featureAccess»(«value»)'''
	}
	
	def private boolean isNameAmbigious(EStructuralFeature feature, TransformationRule rule) {
		val features = new ArrayList<EStructuralFeature>()
		features += rule.srcMatcher.map[clazz.EAllStructuralFeatures].flatten()
		features += rule.trgMatcher.map[clazz.EAllStructuralFeatures].flatten()
		features.filter[name == feature.name].length() > 1
	}
	
	def private List<? extends ClassMatcher> allMatchers(Correspondence corr) {
		if (!corr.matchers.empty) {
			return corr.matchers
		} else {
			if (corr.eContainer instanceof SrcMappingFeature) {
				return corr.rule.trgMatcher
			} else if (corr.eContainer instanceof TrgMappingFeature) {
				return corr.rule.srcMatcher
			} else {
				val message = "The container of a Correspondence should be SrcMappingFeature or TrgMappingFeature!"
				throw new AssertionError(message)
			}
		}
	}
}
