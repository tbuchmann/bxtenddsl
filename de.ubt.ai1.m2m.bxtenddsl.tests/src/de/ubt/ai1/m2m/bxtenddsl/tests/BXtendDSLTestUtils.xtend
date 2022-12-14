package de.ubt.ai1.m2m.bxtenddsl.tests

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI
import static org.junit.Assert.*;
import org.eclipse.emf.ecore.EPackage

final class BXtendDSLTestUtils {
	def static ResourceSet buildGlobalScope(ResourceSet globalScope, String... platformURIs) {
		for (uri : platformURIs) {
			assertTrue(uri.startsWith("platform:/resource"))
			val fileUri = URI.createFileURI(uri.replaceFirst("platform:/resource", BXtendDSLTestConfig.workspace))
			try {
				globalScope.getResource(fileUri, true)
				val loadedRes = globalScope.resources.get(globalScope.resources.size() - 1)
				loadedRes.URI = URI.createURI((loadedRes.contents.get(0) as EPackage).nsURI)
			} catch (RuntimeException e) {
				val loadedRes = globalScope.resources.get(globalScope.resources.size() - 1)
				if (uri == BXtendDSLTestConfig.pdb1InvalidUri) {
					loadedRes.URI = URI.createURI("http://de.ubt.ai1.bw.qvt.examples.pdb1invalid.ecore")
				} else if (uri == BXtendDSLTestConfig.pdb1EClassUri) {
					loadedRes.URI = URI.createURI("http://de.ubt.ai1.bw.qvt.examples.pdb1eclass.ecore")
				} else {
					throw e
				}
			}
		}
		return globalScope
	}
	
	private new() {
	}
}