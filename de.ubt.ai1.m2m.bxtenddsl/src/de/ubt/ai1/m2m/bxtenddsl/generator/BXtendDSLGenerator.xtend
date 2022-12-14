/*
 * generated by Xtext 2.15.0
 */
package de.ubt.ai1.m2m.bxtenddsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule
import com.google.inject.Inject
import java.util.List
import java.util.ArrayList
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Direction
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher
import de.ubt.ai1.m2m.bxtenddsl.generator.FeatureMappingCompiler
import org.eclipse.xtend.lib.annotations.Data
import java.util.Properties
import java.io.IOException
import org.eclipse.xtext.util.RuntimeIOException
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.CoreException
import java.util.HashSet
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils
import java.util.Map
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import java.util.HashMap
import de.ubt.ai1.m2m.bxtenddsl.framework.FrameworkGenerator
import org.eclipse.core.resources.IFolder

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class BXtendDSLGenerator extends AbstractGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val bxdProperties = new Properties()
		var InputStream in = null
		try {
			in = fsa.readBinaryFile("../BXtend.properties")
			bxdProperties.load(in)
		} catch (IOException e) {
			throw new RuntimeIOException("Loading the BXtend.properties file failed!", e)
		} finally {
			if (in !== null) {
				try {
					in.close()
				} catch (IOException e) {
					// close quietly
				}
			}
		}
		val rootPackage = bxdProperties.getProperty("package")
		val packagePath = rootPackage.replace(".", "/")
		val trafo = bxdProperties.getProperty("trafo")
		
		val modelsProperties = new Properties()
		if (fsa.isFile("../models.properties")) {
			in = null
			try {
				in = fsa.readBinaryFile("../models.properties")
				modelsProperties.load(in)
			} catch (IOException e) {
				throw new RuntimeIOException("Loading the models.properties file failed!", e)
			} finally {
				if (in !== null) {
					try {
						in.close()
					} catch (IOException e) {
						// close quietly
					}
				}
			}
		}
		featureMappingCompiler.modelsProperties = modelsProperties
		
		val workspacePath = fsa.getURI("").toPlatformString(true)
		val project = ResourcesPlugin.workspace.root.getFolder(new Path(workspacePath)).project
		val dsl = resource.contents.get(0) as BXtendDSL
		
		try {
			if (!ResourcesPlugin.workspace.root.exists(new Path(workspacePath + "/../BXtend"))) {
				FrameworkGenerator.generate(project, bxdProperties, dsl)
			}
			regenerateGenFolder(project.getFolder("src-gen"), rootPackage)
			regenerateGenFolder(project.getFolder("xtend-gen"), rootPackage)
			
		} catch (CoreException e) {
			e.printStackTrace()
		}
		
		var rules = new ArrayList<String>()
		val generatedXtendFiles = new ArrayList<IFile>()
		
		for (rule : dsl.rules) {
			val rulePathFsa = packagePath + "/rules/" + rule.name + ".xtend"
			fsa.generateFile(rulePathFsa, compile(rule, trafo, rootPackage))
			val rulePath = new Path(workspacePath + "/" + rulePathFsa)
			generatedXtendFiles += ResourcesPlugin.workspace.root.getFile(rulePath)
			
			if (anyAbstractMethod(rule)) {
				val ruleImplPathFsa = "../src/" + packagePath + "/rules/" + rule.name + "Impl.xtend"
				val ruleImplPath = new Path(workspacePath + "/" + ruleImplPathFsa)
				rules += rule.name + "Impl"
				generatedXtendFiles += ResourcesPlugin.workspace.root.getFile(ruleImplPath)
				
				if (!fsa.isFile(ruleImplPathFsa)) {
					fsa.generateFile(ruleImplPathFsa, RuleImplTemplate.getCode(rule.name, trafo, rootPackage))
					try {
						ResourcesPlugin.workspace.root.getFile(ruleImplPath).setDerived(false, null)
					} catch (CoreException e) {
						e.printStackTrace()
					}
				}
				
			} else {
				rules += rule.name
			}
		}
		
		val abstractEntryClassPath = new Path('''�workspacePath�/../BXtend/�packagePath�/trafo/Abstract�trafo�.xtend''')
		generatedXtendFiles += ResourcesPlugin.workspace.root.getFile(abstractEntryClassPath)
		val baseClassPath = new Path('''�workspacePath�/../BXtend/�packagePath�/rules/Elem2Elem.xtend''')
		generatedXtendFiles += ResourcesPlugin.workspace.root.getFile(baseClassPath)
		val entryClassPathFsa = packagePath + "/trafo/" + trafo + ".xtend"
		fsa.generateFile(entryClassPathFsa, EntryClassTemplate.getCode(dsl, trafo, rootPackage, rules))
		val entryClassPath = new Path('''�workspacePath�/�entryClassPathFsa�''')
		generatedXtendFiles += ResourcesPlugin.workspace.root.getFile(entryClassPath)
		
		// Forces the compilation of all generated .xtend-files.
		// Compilation doesn't work in bxtend generator, because bxtend and xtend are using the same builder.
		val job = Job.create("force Xtend compilation", [
			for (xtendFile : generatedXtendFiles) {
				try {
					if (xtendFile.exists()) {
						xtendFile.touch(null)
					}
				} catch (CoreException e) {
					e.printStackTrace()
				}
			}
		])
		job.schedule()
	}
	
	@Data private static class CompilationArtifacts {
		IdentifierScope ruleScope = new IdentifierScope()
		ArrayList<String> groupKeyFunctions = new ArrayList<String>()
		Map<ClassMatcher, String> matcherToGroupsId = new HashMap<ClassMatcher, String>()
		ArrayList<String> customFilter = new ArrayList<String>()
		ArrayList<String> matchCompareFunctions = new ArrayList<String>()
		ArrayList<FeatureMappingCompiler.Method> methodFeatureMappings = new ArrayList<FeatureMappingCompiler.Method>()
	}
	
	@Inject extension Utils
	@Inject MatcherDataClassCompiler matcherDataClassCompiler
	@Inject ClassMatcherModifierCompiler classMatcherModifierCompiler
	@Inject CreationDeletionModifierCompiler creationDeletionCompiler
	@Inject CorrElemDefinitionCompiler corrElemDefinitionCompiler
	@Inject FeatureMappingCompiler featureMappingCompiler
	
	def private String compile(TransformationRule rule, String trafo, String rootPackage) {
		val artifacts = new CompilationArtifacts()
		artifacts.ruleScope.addIdentifier("CorrModelDelta", IdentifierScope.Group.CLASS)
		artifacts.ruleScope.addIdentifier("sourceToTarget", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("onTrgElemCreation", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("onTrgElemDeletion", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("targetToSource", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("onSrcElemCreation", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("onSrcElemDeletion", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("hasCorr", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getCorr", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getCorrElemPosition", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("assertRuleId", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("wrap", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("unwrap", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("updateOrCreateCorrSrc", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("updateOrCreateCorrTrg", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getOrCreateSrc", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getOrCreateTrg", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getSrcRoot", IdentifierScope.Group.METHOD)
		artifacts.ruleScope.addIdentifier("getTrgRoot", IdentifierScope.Group.METHOD)
		
		val metamodels = (rule.eContainer as BXtendDSL).metamodels
		val srcModel = try {
			MetamodelLoader.load(metamodels.sourcemodel, metamodels.eResource.resourceSet)
		} catch (IOException e) {
			throw new AssertionError("Validation should ensure the src metamodel can be loaded!", e)
		}
		val srcRootClass = srcModel.rootEClass
		val trgModel = try {
			MetamodelLoader.load(metamodels.targetmodel, metamodels.eResource.resourceSet)
		} catch (IOException e) {
			throw new AssertionError("Validation should ensure the trg metamodel can be loaded!", e)
		}
		val trgRootClass = trgModel.rootEClass
		
		return '''
		package �rootPackage�.rules;
		
		import *
		
		�IF anyAbstractMethod(rule)�abstract �ENDIF�class �rule.name� extends Elem2Elem {
			new(�trafo� trafo) {
				super("�rule.name�", trafo)
			}
			
			override CorrModelDelta sourceToTarget(Set<EObject> _detachedCorrElems) {
				�compile(true, rule.srcMatcher, rule.trgMatcher, rule.mappings, new IdentifierScope(), artifacts)�
			}
			�creationDeletionCompiler.compile(false, true, rule, artifacts.ruleScope)�
			
			override CorrModelDelta targetToSource(Set<EObject> _detachedCorrElems) {
				�compile(false, rule.srcMatcher, rule.trgMatcher, rule.mappings, new IdentifierScope(), artifacts)�
			}
			�creationDeletionCompiler.compile(true, false, rule, artifacts.ruleScope)�
			�IF !artifacts.groupKeyFunctions.empty�
				
				�FOR keyFunction : artifacts.groupKeyFunctions�
					�keyFunction�
				�ENDFOR�
			�ENDIF�
			�IF !artifacts.customFilter.empty�
				
				�FOR filter : artifacts.customFilter�
					�filter�
				�ENDFOR�
			�ENDIF�
			�IF !artifacts.matchCompareFunctions.empty�
				
				�FOR compareFunction : artifacts.matchCompareFunctions�
					�compareFunction�
				�ENDFOR�
			�ENDIF�
			�FOR method : artifacts.methodFeatureMappings�
				
				�method.typeClass�
				�method.method�
			�ENDFOR�
			
			�matcherDataClassCompiler.compile(rule.srcMatcher, rule.trgMatcher, artifacts.ruleScope)�
���			not implemented in Elem2Elem, because metamodels are not validated in the wizard
			�IF srcRootClass !== null || trgRootClass !== null�
			
			�ENDIF�
			�IF srcRootClass !== null�
				def protected �srcRootClass.qualifiedName� getSrcRoot() {
					if (!sourceModel.contents.empty) {
						return sourceModel.contents.get(0) as �srcRootClass.qualifiedName�
					} else {
						return null
					}
				}
			�ENDIF�
			�IF trgRootClass !== null�
				def protected �trgRootClass.qualifiedName� getTrgRoot() {
					if (!targetModel.contents.empty) {
						return targetModel.contents.get(0) as �trgRootClass.qualifiedName�
					} else {
						return null
					}
				}
			�ENDIF�
		}
		'''.toString().replace("import *", computeImports(rule, trafo, rootPackage))
	}
	
	def private String compile(boolean srcToTrg, List<SrcClassMatcher> srcMatcher, List<TrgClassMatcher> trgMatcher,
			List<FeatureMapping> mappings, IdentifierScope scope, CompilationArtifacts artifacts) {
		val relSrc = '''�IF srcToTrg�Source�ELSE�Target�ENDIF�'''
		val relSrcMatcher = if (srcToTrg) srcMatcher else trgMatcher
		val relTrgMatcher = if (srcToTrg) trgMatcher else srcMatcher
		val inDirectionMappings = mappings.filter[
			if (srcToTrg) {
				direction == Direction.FWD || direction == Direction.BX
			} else {
				direction == Direction.BWD || direction == Direction.BX
			}
		].toList()
		val usedRelTrgMatcher = relTrgMatcher.filter[matcher |
			inDirectionMappings.exists[featureMappingCompiler.anyUseOf(srcToTrg, it, matcher.name)]
		].toList()
		
		val group = classMatcherModifierCompiler.compileGroupModifier(relSrcMatcher, artifacts.ruleScope, scope)
		artifacts.groupKeyFunctions += group.keyFunctions
		artifacts.matcherToGroupsId += group.matcherToGroupsId
		val groupDefinitions = group.definitions
		
		val compareId = if (relSrcMatcher.exists[modifier.sort]) {
			val compareId = artifacts.ruleScope.addIdentifier('''compare�relSrc�''', IdentifierScope.Group.METHOD)
			artifacts.matchCompareFunctions += '''def protected abstract int �compareId�(�relSrc� lhs, �relSrc� rhs);'''
			compareId
		}
		
		scope.addIdentifier("_detachedCorrElems", IdentifierScope.Group.VARIABLE)
		scope.addIdentifier("_matches", IdentifierScope.Group.VARIABLE)
		scope.addIdentifier("_match", IdentifierScope.Group.VARIABLE)
		return '''
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		�groupDefinitions�
		val _matches = new ArrayList<�relSrc�>()
		�compile(srcToTrg, 0, relSrcMatcher, scope, artifacts)�
		
		�IF relSrcMatcher.exists[modifier.sort]�
			_matches.sort([lhs, rhs | �compareId�(lhs, rhs)])
			
		�ENDIF�
		for (_match : _matches) {
			�FOR matcher : relSrcMatcher�
				val �matcher.name� = _match.�matcher.name�
			�ENDFOR�
			
			�corrElemDefinitionCompiler.compile(srcToTrg, relSrcMatcher, relTrgMatcher, usedRelTrgMatcher, scope)�
			�compile(srcToTrg, inDirectionMappings, scope, artifacts)�
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
		'''
	}
	
	def private String compile(boolean srcToTrg, int currentMatcher, List<? extends ClassMatcher> matcher,
			IdentifierScope scope, CompilationArtifacts artifacts) {
		if (currentMatcher >= matcher.size()) {
			return '''_matches += new �IF srcToTrg�Source�ELSE�Target�ENDIF�(�matcher.map[name].join(", ")�)'''
		}
		
		val current = matcher.get(currentMatcher)
		val before = matcher.subList(0, currentMatcher)
		val filter = classMatcherModifierCompiler.compileFilterModifier(current, before, artifacts.ruleScope)
		if (filter.filter !== null) {
			artifacts.customFilter += filter.filter
		}
		
		scope.addIdentifier(current.name, IdentifierScope.Group.VARIABLE) // matcher names are unique
		val model = if (srcToTrg) "sourceModel" else "targetModel"
		return '''
		for (�current.name� : �
			IF !artifacts.matcherToGroupsId.containsKey(current)
				��model�.allContents.filter(typeof(�current.clazz.qualifiedName�))�filter.call�.toIterable()) {
			�ELSE�
				�artifacts.matcherToGroupsId.get(current)��filter.call�) {
			�ENDIF�
			�compile(srcToTrg, currentMatcher + 1, matcher, scope, artifacts)�
		}
		'''
	}
	
	def private String compile(boolean srcToTrg, List<FeatureMapping> inDirectionMappings, IdentifierScope scope,
			CompilationArtifacts artifacts) {
		var compiledMappings = new ArrayList<String>()
		var lastCompiledToAssignment = false
		for (mapping : inDirectionMappings) {
			if (featureMappingCompiler.compileableToAssignment(srcToTrg, mapping)) {
				if (!lastCompiledToAssignment) {
					compiledMappings += System.lineSeparator()
					lastCompiledToAssignment = true
				}
				
				compiledMappings += featureMappingCompiler.compileToAssignment(srcToTrg, mapping, scope)
				
			} else {
				val method = featureMappingCompiler.compileToMethod(srcToTrg, mapping, artifacts.ruleScope, scope)
				compiledMappings += System.lineSeparator()
				compiledMappings += method.call
				artifacts.methodFeatureMappings += method
			}
		}
		compiledMappings.join()
	}
	
	def private void regenerateGenFolder(IFolder genFolder, String rootPackage) throws CoreException {
			if (!genFolder.exists()) {
				genFolder.create(true, true, null)
			}
			genFolder.setDerived(true, null)
			for (member : genFolder.members) {
				member.delete(true, null)
			}
			
			var packageSegment = genFolder
			for (segmentString : rootPackage.split("\\.")) {
				packageSegment = packageSegment.getFolder(segmentString)
				packageSegment.create(true, true, null)
				packageSegment.setDerived(true, null)
			}
			packageSegment.getFolder("rules").create(true, true, null)
			packageSegment.getFolder("rules").setDerived(true, null)
			packageSegment.getFolder("trafo").create(true, true, null)
			packageSegment.getFolder("trafo").setDerived(true, null)
	}
	
	def private String computeImports(TransformationRule rule, String trafo, String rootPackage) {
		var imports = new HashSet<String>()
		
		imports += '''import �rootPackage�.rules.Elem2Elem'''
		imports += '''import �rootPackage�.trafo.�trafo�'''
		imports += "import java.util.Set"
		imports += "import org.eclipse.emf.ecore.EObject"
		imports += "import java.util.ArrayList"
		
		imports += classMatcherModifierCompiler.neededImports(rule.srcMatcher)
		imports += classMatcherModifierCompiler.neededImports(rule.trgMatcher)
		imports += creationDeletionCompiler.neededImports(true, true, rule)
		imports += directionalMappings(true, rule)
				.map[featureMappingCompiler.neededImports(true, it, rootPackage)].flatten()
		imports += directionalMappings(false, rule)
				.map[featureMappingCompiler.neededImports(false, it, rootPackage)].flatten()
				
		imports += matcherDataClassCompiler.neededImports(rootPackage)
		imports += corrElemDefinitionCompiler.neededImports(rootPackage)
		
		imports.sort().join(System.lineSeparator())
	}
	
	def private boolean anyAbstractMethod(TransformationRule rule) {
		(classMatcherModifierCompiler.anyAbstractMethod(rule.srcMatcher))
				|| (classMatcherModifierCompiler.anyAbstractMethod(rule.trgMatcher))
				|| creationDeletionCompiler.anyAbstractMethod(true, true, rule)
				|| directionalMappings(true, rule).exists[featureMappingCompiler.anyAbstractMethod(true, it)]
				|| directionalMappings(false, rule).exists[featureMappingCompiler.anyAbstractMethod(false, it)]
	}
	
	def private directionalMappings(boolean srcToTrg, TransformationRule rule) {
		return rule.mappings.filter[
			if (srcToTrg) {
				direction == Direction.FWD || direction == Direction.BX
			} else {
				direction == Direction.BWD || direction == Direction.BX
			}
		]
	}
}
