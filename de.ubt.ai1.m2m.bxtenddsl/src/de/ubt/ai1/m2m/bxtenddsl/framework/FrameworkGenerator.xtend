package de.ubt.ai1.m2m.bxtenddsl.framework

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import java.io.ByteArrayInputStream
import java.util.Properties
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.jdt.core.JavaCore

/**
 * Generator for the framework classes, which are CorrModel, Transformation and Elem2Elem.
 */
final class FrameworkGenerator {
	/**
	 * Regenerates the framework classes for the given project, properties and dsl.
	 */
	def static void generate(IProject project, Properties properties, BXtendDSL dsl) throws CoreException {
		regenerateBxtendFolder(project)
		createFiles(project, properties, dsl)
	}
	
	def private static void regenerateBxtendFolder(IProject project) throws CoreException {
		val framework = project.getFolder("BXtend")
		framework.delete(true, null)
		framework.create(true, true, null)
		
		val javaProject = JavaCore.create(project)
		val classpath = newArrayList(javaProject.rawClasspath)
		if (!classpath.contains(JavaCore.newSourceEntry(framework.fullPath))) {
			classpath.add(1, JavaCore.newSourceEntry(framework.fullPath))
		}
		javaProject.setRawClasspath(classpath, null)
	}
	
	def private static void createFiles(IProject project, Properties properties, BXtendDSL dsl) throws CoreException {
		val config = new FrameworkConfig(project, properties, dsl)
		
		CorrModelGenerator.generate(config)
		
		val trafo = project.getFolder("BXtend/" + config.rootPackage.replace(".", "/") + "/trafo")
		trafo.create(true, true, null)
		val entryClass = trafo.getFile("Abstract" + properties.getProperty("trafo") + ".xtend")
		val entryClassSource = new ByteArrayInputStream(AbstractEntryClassTemplate.getCode(config).getBytes())
		entryClass.create(entryClassSource, true, null)
		
		val rules = project.getFolder("BXtend/" + config.rootPackage.replace(".", "/") + "/rules")
		rules.create(true, true, null)
		val baseClass = rules.getFile("Elem2Elem.xtend")
		val baseClassSource = new ByteArrayInputStream(BaseClassTemplate.getCode(config).getBytes())
		baseClass.create(baseClassSource, true, null)
	}
	
	private new() {
	}
}
