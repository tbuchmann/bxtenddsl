package de.ubt.ai1.m2m.bxtenddsl.utils

import org.eclipse.xtend.lib.annotations.Data
import java.util.List
import org.eclipse.core.resources.IProject
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import javax.xml.parsers.SAXParserFactory
import java.io.InputStream
import org.eclipse.emf.ecore.resource.URIConverter
import java.io.IOException
import javax.xml.parsers.ParserConfigurationException
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler
import org.xml.sax.Attributes
import org.eclipse.emf.ecore.EPackage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.util.WrappedException

/**
 * Provides a static method to find extensions with type "org.eclipse.emf.ecore.generated_package". 
 */
@Data class GeneratedPackage {
	/**
	 * Finds extensions with type "org.eclipse.emf.ecore.generated_package" of all projects in the workspace.
	 * The referenced ecore and generator model must be present in the project declaring the extension,
	 * else the extension is ignored.
	 * 
	 * @return all generated packages in the workspace.
	 */
	def static List<GeneratedPackage> fromWorkspace() {
		val result = new ArrayList<GeneratedPackage>
		
		for (parsedGeneratedPackage : parseGeneratedPackages()) {
			val ecoreModels = loadEcoreModels(parsedGeneratedPackage.project)
			val ePackage = ecoreModels.findFirst[nsURI == parsedGeneratedPackage.uri]
			val genModel = loadGenModel(parsedGeneratedPackage.project, parsedGeneratedPackage.genModel)
			if (ePackage !== null && genModel !== null) {
				result += new GeneratedPackage(parsedGeneratedPackage.project, ePackage, genModel)
			}
		}
		
		return result
	}
	
	IProject project
	EPackage ePackage
	GenModel genModel
	
	def private static List<EPackage> loadEcoreModels(IProject project) {
		val ecoreModels = new ArrayList<EPackage>()
		
		val resSet = new ResourceSetImpl()
		try {
			val members = newArrayList(project.members)
			while (!members.empty) {
				val current = members.remove(0)
				if (current instanceof IContainer) {
					members += current.members
				} else if (current instanceof IFile && current.fileExtension == "ecore") {
					val res = try {
						resSet.getResource(URI.createFileURI(current.locationURI.path), true)
					} catch (WrappedException e) { // wraps e.g. FileNotFoundException
						null
					}
					if (res !== null && !res.contents.empty && res.contents.get(0) instanceof EPackage) {
						ecoreModels += res.contents.get(0) as EPackage
					}
				}
			}
		} catch (CoreException e) {
			// can't get project members, ignore the project
		}
		
		return ecoreModels
	}
	
	def private static GenModel loadGenModel(IProject project, String path) {
		val resSet = new ResourceSetImpl()
		val genModelUri = URI.createFileURI(project.getFile(path).locationURI.path)
		val res = try {
			resSet.getResource(genModelUri, true)
		} catch (WrappedException e) { // wraps e.g. FileNotFoundException
			return null
		}
		if (!res.contents.empty && res.contents.get(0) instanceof GenModel) {
			return res.contents.get(0) as GenModel
		} else {
			return null
		}
	}
	
	@Data private static class ParsedGeneratedPackage {
		IProject project
		String uri
		String clazz
		String genModel
	}
	def private static List<ParsedGeneratedPackage> parseGeneratedPackages() {
		val result = new ArrayList<ParsedGeneratedPackage>
		
		val projects = ResourcesPlugin.workspace.root.projects
		for (project : projects.filter[findMember("plugin.xml") !== null]) {
			val pluginXmlResource = project.findMember("plugin.xml")
			val pluginXmlUri = URI.createFileURI(pluginXmlResource.locationURI.path)
			
			val factory = SAXParserFactory.newInstance()
			factory.setValidating(true)
			var InputStream in = null
			try {
				val saxParser = factory.newSAXParser()
				in = URIConverter.INSTANCE.createInputStream(pluginXmlUri)
				val handler = new GeneratedPackageHandler(project)
				saxParser.parse(in, handler)
				result += handler.generatedPackages
			} catch (IOException | ParserConfigurationException | SAXException e) {
				// invalid plugin.xml, ignore the plugin.xml
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
		
		return result
	}
	private static class GeneratedPackageHandler extends DefaultHandler {
		new (IProject project) {
			this.project = project
		}
		
		override void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
			if (qName == "extension" && atts.getValue("point") == "org.eclipse.emf.ecore.generated_package") {
				generatedPackageExtension = true
				
			} else if (qName == "package" && generatedPackageExtension) {
				val uri = atts.getValue("uri")
				val clazz = atts.getValue("class")
				val genModel = atts.getValue("genModel")
				if (uri !== null && clazz !== null && genModel !== null) {
					generatedPackages += new ParsedGeneratedPackage(project, uri, clazz, genModel)
				}
			}
		}
		
		override void endElement(String uri, String localName, String qName) {
			if (qName == "extension") {
				generatedPackageExtension = false
			}
		}
		
		final IProject project
		boolean generatedPackageExtension = false
		List<ParsedGeneratedPackage> generatedPackages = newArrayList()
	}
}
