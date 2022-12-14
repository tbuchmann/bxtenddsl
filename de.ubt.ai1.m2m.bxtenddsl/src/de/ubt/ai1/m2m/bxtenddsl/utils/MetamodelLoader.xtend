package de.ubt.ai1.m2m.bxtenddsl.utils

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import java.io.IOException
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.WrappedException

final class MetamodelLoader {
	/**
	 * In test mode the URI to load is only resolved against the given resource set.
	 * No generator model or eclipse environment is necessary.
	 */
	public static boolean testMode = false
	
	/**
	 * Loads an ecore model into a ResourceSet using the given URI.
	 * The URI must be resolvable, e.g. trough the package registry, or the model to load must be in
	 * the workspace and referenced by an "org.eclipse.emf.ecore.generated_package" extension.
	 * 
	 * @param uriString of the ecore model to load.
	 * @param resSet ResourceSet to load the model into.
	 * @return the loaded resource.
	 */
	def static Resource load(String uriString, ResourceSet resSet) throws IOException {
		val uri = URI.createURI(uriString)
		
		if (testMode) {
			if (resSet.getResource(uri, false) === null) {
				throw new IOException("'" + uriString + "' not found in the package registry or workspace!");
			}
			return resSet.getResource(uri, false)
		}
		
		if (resSet.getResource(uri, false) === null) {
			val workspacePackage = GeneratedPackage.fromWorkspace().findFirst[EPackage.nsURI == uriString]
			if (workspacePackage !== null) {
				val res = resSet.createResource(uri)
				res.contents.add(workspacePackage.EPackage)
				nsUriToGenModel.put(uriString, workspacePackage.genModel)
			} else {
				throw new IOException("'" + uriString + "' not found in the package registry or workspace!")
			}
			
		} else if (!nsUriToGenModel.containsKey(uriString)) {
			val genModelUri = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).get(uriString)
			if (genModelUri === null) {
				throw new IOException("Genmodel for '" + uriString + "' not found!")
			}
			val genModelRes = try {
				val genModelResSet = new ResourceSetImpl()
				genModelResSet.URIConverter.URIMap.putAll(EcorePlugin.computePlatformURIMap(true))
				genModelResSet.getResource(genModelUri, true)
			} catch (WrappedException e) { // wraps e.g. FileNotFoundException
				throw new IOException("Genmodel for '" + uriString + "' not found!", e)
			}
			if (!genModelRes.contents.empty && genModelRes.contents.get(0) instanceof GenModel) {
				nsUriToGenModel.put(uriString, genModelRes.contents.get(0) as GenModel)
			} else {
				throw new IOException("Genmodel for '" + uriString + "' could not be loaded!")
			}
		}
		
		return resSet.getResource(uri, false)
	}
	
	/**
	 * Returns the generator model of the previously loaded model with the given nsUri. Returns null, if no model with
	 * the given nsUri was loaded.
	 */
	def static GenModel genModel(String nsUri) {
		return nsUriToGenModel.get(nsUri)
	}
	
	static Map<String, GenModel> nsUriToGenModel = newHashMap()
	
	private new() {
	}
}