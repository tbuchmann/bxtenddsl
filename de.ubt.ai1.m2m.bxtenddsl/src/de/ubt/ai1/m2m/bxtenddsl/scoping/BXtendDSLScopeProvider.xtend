/*
 * generated by Xtext 2.15.0
 */
package de.ubt.ai1.m2m.bxtenddsl.scoping

import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.eclipse.xtext.naming.SimpleNameProvider
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.emf.ecore.util.EcoreUtil
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.naming.QualifiedName
import java.util.ArrayList
import org.eclipse.emf.ecore.EPackage
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import java.util.List
import java.util.stream.Stream
import org.eclipse.xtext.resource.IEObjectDescription
import java.util.stream.StreamSupport
import java.util.stream.Collectors
import org.eclipse.xtext.scoping.impl.SimpleScope
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class BXtendDSLScopeProvider extends AbstractBXtendDSLScopeProvider {
	override IScope getScope(EObject context, EReference reference) {
		var scope = switch (context) {
			SrcClassMatcher case reference == BXtendDSLPackage.eINSTANCE.classMatcher_Clazz: srcMetamodelScope(context)
			TrgClassMatcher case reference == BXtendDSLPackage.eINSTANCE.classMatcher_Clazz: trgMetamodelScope(context)
			
			SrcMappingFeature case reference == BXtendDSLPackage.eINSTANCE.mappingFeature_Feature:
					srcMatcherScope(context.eContainer.eContainer as TransformationRule)
			TrgMappingFeature case reference == BXtendDSLPackage.eINSTANCE.mappingFeature_Feature:
					trgMatcherScope(context.eContainer.eContainer as TransformationRule)
			
			Correspondence case reference == BXtendDSLPackage.eINSTANCE.correspondence_Matchers:
					if (context.eContainer instanceof SrcMappingFeature && context.rule !== null) {
						Scopes.scopeFor(context.rule.trgMatcher)
					} else if (context.eContainer instanceof TrgMappingFeature && context.rule !== null) {
						Scopes.scopeFor(context.rule.srcMatcher)
					} else {
						IScope.NULLSCOPE
					}
			
			default: return super.getScope(context, reference)
		}
		new FilteringScope(scope, [reference.EReferenceType.isSuperTypeOf(it.EClass)])
	}
	
	/**
	 * Returns a scope containing all objects specified in the source/target metamodel. The objects are identified
	 * by their packageless name. Returns the NULLSCOPE, if there is no valid source/target metamodel.
	 */
	def IScope srcMetamodelScope(EObject context) {
		val sourcemodel = (EcoreUtil.getRootContainer(context) as BXtendDSL)?.metamodels?.sourcemodel
		if (this.sourcemodel == sourcemodel) {
			srcScope
		} else {
			this.sourcemodel = sourcemodel
			srcScope = try {
				scopeFor(MetamodelLoader.load(sourcemodel, context.eResource.resourceSet))
			} catch (Exception e) {
				IScope.NULLSCOPE
			}
		}
	}
	def IScope trgMetamodelScope(EObject context) {
		val targetmodel = (EcoreUtil.getRootContainer(context) as BXtendDSL)?.metamodels?.targetmodel
		if (this.targetmodel == targetmodel) {
			trgScope
		} else {
			this.targetmodel = targetmodel
			trgScope = try {
				scopeFor(MetamodelLoader.load(targetmodel, context.eResource.resourceSet))
			} catch (Exception e) {
				IScope.NULLSCOPE
			}
		}
	}
	
	/**
	 * Returns the scope containing all elements matched by the source/target matcher of the given rule.
	 */
	def IScope srcMatcherScope(TransformationRule rule) {
		return classMatcherScope(rule.srcMatcher?.map([it as ClassMatcher]) ?: #[])
	}
	def IScope trgMatcherScope(TransformationRule rule) {
		return classMatcherScope(rule.trgMatcher?.map([it as ClassMatcher]) ?: #[])
	}
	
	@Inject SimpleNameProvider simpleNameProvider
	@Inject IQualifiedNameConverter qualifiedNameConverter;
	
	var String sourcemodel
	var IScope srcScope = IScope.NULLSCOPE
	var String targetmodel
	var IScope trgScope = IScope.NULLSCOPE
	
	/**
	 * Computes a scope for the given metamodel using packageless names as identifiers.
	 */
	def private IScope scopeFor(Resource metamodel) {
		Scopes.scopeFor(metamodel.allContents.toSet(), [e | getPackagelessName(e)], IScope.NULLSCOPE)
	}
	
	/**
	 * Builds the packagless name for a given EObject. This name consists of the objects name prefixed by the dot
	 * separated names of all containing objects until the first EPackage.
	 */
	def private QualifiedName getPackagelessName(EObject e) {
		var current = e
		val packegelessName = new ArrayList<QualifiedName>()
		while (!(current instanceof EPackage) && current !== null) {
			val name = simpleNameProvider.getFullyQualifiedName(current)
			if (name === null) {
				return null
			}
			packegelessName += name
			current = current.eContainer
		}
		
		if (packegelessName.empty) {
			return null
		} else {
			return qualifiedNameConverter.toQualifiedName(packegelessName.reverse().join("."))
		}
	}
	
	/**
	 * Computes a scope containing the structural features of all non group matchers out of the given class matchers.
	 */
	def private IScope classMatcherScope(List<ClassMatcher> classMatcher) {
		var Stream<IEObjectDescription> scopedElements = Stream.empty()
		for (matcher : classMatcher.filter[e | !e.clazz.eIsProxy && !e.modifier.group]) {
			scopedElements = Stream.concat(scopedElements, StreamSupport.stream(
					Scopes.scopedElementsFor(matcher.clazz.EAllStructuralFeatures, [e |
						if (matcher.name === null || e.name === null) {
							null
						} else {
							qualifiedNameConverter.toQualifiedName(matcher.name + "." + e.name)
						}
					]).spliterator(), false))
		}
		new SimpleScope(IScope.NULLSCOPE, scopedElements.collect(Collectors.toList()))
	}
}