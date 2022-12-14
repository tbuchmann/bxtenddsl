package de.ubt.ai1.m2m.bxtenddsl.utils;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public final class MetamodelLoader {
  /**
   * In test mode the URI to load is only resolved against the given resource set.
   * No generator model or eclipse environment is necessary.
   */
  public static boolean testMode = false;
  
  /**
   * Loads an ecore model into a ResourceSet using the given URI.
   * The URI must be resolvable, e.g. trough the package registry, or the model to load must be in
   * the workspace and referenced by an "org.eclipse.emf.ecore.generated_package" extension.
   * 
   * @param uriString of the ecore model to load.
   * @param resSet ResourceSet to load the model into.
   * @return the loaded resource.
   */
  public static Resource load(final String uriString, final ResourceSet resSet) throws IOException {
    final URI uri = URI.createURI(uriString);
    if (MetamodelLoader.testMode) {
      Resource _resource = resSet.getResource(uri, false);
      boolean _tripleEquals = (_resource == null);
      if (_tripleEquals) {
        throw new IOException((("\'" + uriString) + "\' not found in the package registry or workspace!"));
      }
      return resSet.getResource(uri, false);
    }
    Resource _resource_1 = resSet.getResource(uri, false);
    boolean _tripleEquals_1 = (_resource_1 == null);
    if (_tripleEquals_1) {
      final Function1<GeneratedPackage, Boolean> _function = (GeneratedPackage it) -> {
        String _nsURI = it.getEPackage().getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, uriString));
      };
      final GeneratedPackage workspacePackage = IterableExtensions.<GeneratedPackage>findFirst(GeneratedPackage.fromWorkspace(), _function);
      if ((workspacePackage != null)) {
        final Resource res = resSet.createResource(uri);
        res.getContents().add(workspacePackage.getEPackage());
        MetamodelLoader.nsUriToGenModel.put(uriString, workspacePackage.getGenModel());
      } else {
        throw new IOException((("\'" + uriString) + "\' not found in the package registry or workspace!"));
      }
    } else {
      boolean _containsKey = MetamodelLoader.nsUriToGenModel.containsKey(uriString);
      boolean _not = (!_containsKey);
      if (_not) {
        final URI genModelUri = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).get(uriString);
        if ((genModelUri == null)) {
          throw new IOException((("Genmodel for \'" + uriString) + "\' not found!"));
        }
        Resource _xtrycatchfinallyexpression = null;
        try {
          Resource _xblockexpression = null;
          {
            final ResourceSetImpl genModelResSet = new ResourceSetImpl();
            genModelResSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(true));
            _xblockexpression = genModelResSet.getResource(genModelUri, true);
          }
          _xtrycatchfinallyexpression = _xblockexpression;
        } catch (final Throwable _t) {
          if (_t instanceof WrappedException) {
            final WrappedException e = (WrappedException)_t;
            throw new IOException((("Genmodel for \'" + uriString) + "\' not found!"), e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        final Resource genModelRes = _xtrycatchfinallyexpression;
        if (((!genModelRes.getContents().isEmpty()) && (genModelRes.getContents().get(0) instanceof GenModel))) {
          EObject _get = genModelRes.getContents().get(0);
          MetamodelLoader.nsUriToGenModel.put(uriString, ((GenModel) _get));
        } else {
          throw new IOException((("Genmodel for \'" + uriString) + "\' could not be loaded!"));
        }
      }
    }
    return resSet.getResource(uri, false);
  }
  
  /**
   * Returns the generator model of the previously loaded model with the given nsUri. Returns null, if no model with
   * the given nsUri was loaded.
   */
  public static GenModel genModel(final String nsUri) {
    return MetamodelLoader.nsUriToGenModel.get(nsUri);
  }
  
  private static Map<String, GenModel> nsUriToGenModel = CollectionLiterals.<String, GenModel>newHashMap();
  
  private MetamodelLoader() {
  }
}
