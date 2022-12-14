package de.ubt.ai1.m2m.bxtenddsl.tests;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;

@SuppressWarnings("all")
public final class BXtendDSLTestUtils {
  public static ResourceSet buildGlobalScope(final ResourceSet globalScope, final String... platformURIs) {
    for (final String uri : platformURIs) {
      {
        Assert.assertTrue(uri.startsWith("platform:/resource"));
        final URI fileUri = URI.createFileURI(uri.replaceFirst("platform:/resource", BXtendDSLTestConfig.workspace));
        try {
          globalScope.getResource(fileUri, true);
          EList<Resource> _resources = globalScope.getResources();
          int _size = globalScope.getResources().size();
          int _minus = (_size - 1);
          final Resource loadedRes = _resources.get(_minus);
          EObject _get = loadedRes.getContents().get(0);
          loadedRes.setURI(URI.createURI(((EPackage) _get).getNsURI()));
        } catch (final Throwable _t) {
          if (_t instanceof RuntimeException) {
            final RuntimeException e = (RuntimeException)_t;
            EList<Resource> _resources_1 = globalScope.getResources();
            int _size_1 = globalScope.getResources().size();
            int _minus_1 = (_size_1 - 1);
            final Resource loadedRes_1 = _resources_1.get(_minus_1);
            boolean _equals = Objects.equal(uri, BXtendDSLTestConfig.pdb1InvalidUri);
            if (_equals) {
              loadedRes_1.setURI(URI.createURI("http://de.ubt.ai1.bw.qvt.examples.pdb1invalid.ecore"));
            } else {
              boolean _equals_1 = Objects.equal(uri, BXtendDSLTestConfig.pdb1EClassUri);
              if (_equals_1) {
                loadedRes_1.setURI(URI.createURI("http://de.ubt.ai1.bw.qvt.examples.pdb1eclass.ecore"));
              } else {
                throw e;
              }
            }
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return globalScope;
  }
  
  private BXtendDSLTestUtils() {
  }
}
