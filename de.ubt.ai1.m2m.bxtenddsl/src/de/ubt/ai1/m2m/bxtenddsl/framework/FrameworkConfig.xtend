package de.ubt.ai1.m2m.bxtenddsl.framework

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader
import java.util.Properties
import org.eclipse.core.resources.IProject
import org.eclipse.xtend.lib.annotations.Data

/**
 * Configuration for the various framework generators and templates.
 */
@Data class FrameworkConfig {
	String project
	String rootPackage
	String trafo
	
	String srcUri
	String trgUri
	String sourcePackage
	String targetPackage
	String sourceFactory
	String targetFactory
	
	/**
	 * Creates a framework configuration for the given project, properties and dsl.
	 */
	new(IProject project, Properties properties, BXtendDSL dsl) {
		this.project = project.name
		this.rootPackage = properties.getProperty("package")
		this.trafo = properties.getProperty("trafo")
		
		this.srcUri = dsl.metamodels.sourcemodel
		this.trgUri = dsl.metamodels.targetmodel
		val srcGenPkg = MetamodelLoader.genModel(srcUri).genPackages.get(0)
		val trgGenPkg = MetamodelLoader.genModel(trgUri).genPackages.get(0)
		this.sourcePackage = if (srcGenPkg.basePackage !== null && srcGenPkg.basePackage.length() > 0) {
			'''«srcGenPkg.basePackage».«srcGenPkg.packageName».«srcGenPkg.basicPackageName»'''
		} else {
			'''«srcGenPkg.packageName».«srcGenPkg.basicPackageName»'''
		}
		this.targetPackage = if (trgGenPkg.basePackage !== null && trgGenPkg.basePackage.length() > 0) {
			'''«trgGenPkg.basePackage».«trgGenPkg.packageName».«trgGenPkg.basicPackageName»'''
		} else {
			'''«trgGenPkg.packageName».«trgGenPkg.basicPackageName»'''
		}
		this.sourceFactory = sourcePackage.substring(0, sourcePackage.length() - 7) + "Factory"
		this.targetFactory = targetPackage.substring(0, targetPackage.length() - 7) + "Factory"
	}
}
