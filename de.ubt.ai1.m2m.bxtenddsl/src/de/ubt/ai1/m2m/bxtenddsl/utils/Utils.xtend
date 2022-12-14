package de.ubt.ai1.m2m.bxtenddsl.utils

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EReference
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import com.google.inject.Inject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.ecore.EPackage

/**
 * Collection of useful functions for the BXtendDSL.
 */
class Utils {
	/**
	 * Returns null, if there is no root EClass or multiple root EClasses.
	 */
	def EClass rootEClass(Resource res) {
		val containments = res.allContents.filter(EReference).filter[containment]
		val nonCyclicContainments = containments.filter[!EReferenceType.EReferences.contains(it)]
		val containmentsType = nonCyclicContainments.map[EReferenceType].toList()
		val eclasses = res.allContents.filter(EClass)
		val roots = eclasses.filter[eclass | !containmentsType.exists[it.isSuperTypeOf(eclass)]].toList()
		if (roots.size() < 1 || roots.size() > 1) {
			return null
		} else {
			return roots.get(0)
		}
	}
	
	/**
	 * The qualified name of obj prefixed with the base package from its generator model.
	 * The root of obj must be an EPackage that was loaded with the MetamodelLoader.
	 */
	def String qualifiedName(EObject obj) {
		val rootPackage = try {
			EcoreUtil2.getRootContainer(obj) as EPackage
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("The root of 'obj' must be an EPackage!")
		}
		val genModel = if (MetamodelLoader.genModel(rootPackage.nsURI) !== null) {
			MetamodelLoader.genModel(rootPackage.nsURI)
		} else {
			throw new IllegalArgumentException("The root of 'obj' must have been loaded with the MetamodelLoader!")
		}
		if (!genModel.genPackages.empty && genModel.genPackages.get(0).basePackage !== null) {
			return genModel.genPackages.get(0).basePackage + "." + obj.fullyQualifiedName.toString()
		} else {
			return obj.fullyQualifiedName.toString()
		}
	}
	
	/**
	 * The qualified name of the clazz attribute of the given matcher. Multivalued, if the group modifier is set.
	 */
	def String qualifiedType(ClassMatcher matcher) {
		if (!matcher.modifier.group) {
			return matcher.clazz.qualifiedName
		} else {
			return '''List<«matcher.clazz.qualifiedName»>'''
		}
	}
	
	/**
	 * The token parsed for the given feature.
	 */
	def String token(MappingFeature feature) {
		val literal = BXtendDSLPackage.Literals.MAPPING_FEATURE__FEATURE
		val node = NodeModelUtils.findNodesForFeature(feature, literal)
		return NodeModelUtils.getTokenText(node.get(0))
	}
	
	/**
	 * Returns true, if the given keyword is an Xtend keyword.
	 */
	def boolean isXtendKeyword(String keyword) {
		return keyword == "class" || keyword == "package" || keyword == "abstract" || keyword == "interface"
	}
	
	@Inject extension DefaultDeclarativeQualifiedNameProvider
}
