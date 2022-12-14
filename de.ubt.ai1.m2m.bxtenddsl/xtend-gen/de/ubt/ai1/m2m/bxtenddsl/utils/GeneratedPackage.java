package de.ubt.ai1.m2m.bxtenddsl.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Provides a static method to find extensions with type "org.eclipse.emf.ecore.generated_package".
 */
@Data
@SuppressWarnings("all")
public class GeneratedPackage {
  @Data
  private static class ParsedGeneratedPackage {
    private final IProject project;
    
    private final String uri;
    
    private final String clazz;
    
    private final String genModel;
    
    public ParsedGeneratedPackage(final IProject project, final String uri, final String clazz, final String genModel) {
      super();
      this.project = project;
      this.uri = uri;
      this.clazz = clazz;
      this.genModel = genModel;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
      result = prime * result + ((this.uri== null) ? 0 : this.uri.hashCode());
      result = prime * result + ((this.clazz== null) ? 0 : this.clazz.hashCode());
      return prime * result + ((this.genModel== null) ? 0 : this.genModel.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      GeneratedPackage.ParsedGeneratedPackage other = (GeneratedPackage.ParsedGeneratedPackage) obj;
      if (this.project == null) {
        if (other.project != null)
          return false;
      } else if (!this.project.equals(other.project))
        return false;
      if (this.uri == null) {
        if (other.uri != null)
          return false;
      } else if (!this.uri.equals(other.uri))
        return false;
      if (this.clazz == null) {
        if (other.clazz != null)
          return false;
      } else if (!this.clazz.equals(other.clazz))
        return false;
      if (this.genModel == null) {
        if (other.genModel != null)
          return false;
      } else if (!this.genModel.equals(other.genModel))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("project", this.project);
      b.add("uri", this.uri);
      b.add("clazz", this.clazz);
      b.add("genModel", this.genModel);
      return b.toString();
    }
    
    @Pure
    public IProject getProject() {
      return this.project;
    }
    
    @Pure
    public String getUri() {
      return this.uri;
    }
    
    @Pure
    public String getClazz() {
      return this.clazz;
    }
    
    @Pure
    public String getGenModel() {
      return this.genModel;
    }
  }
  
  private static class GeneratedPackageHandler extends DefaultHandler {
    public GeneratedPackageHandler(final IProject project) {
      this.project = project;
    }
    
    @Override
    public void startElement(final String namespaceURI, final String localName, final String qName, final Attributes atts) {
      if ((Objects.equal(qName, "extension") && Objects.equal(atts.getValue("point"), "org.eclipse.emf.ecore.generated_package"))) {
        this.generatedPackageExtension = true;
      } else {
        if ((Objects.equal(qName, "package") && this.generatedPackageExtension)) {
          final String uri = atts.getValue("uri");
          final String clazz = atts.getValue("class");
          final String genModel = atts.getValue("genModel");
          if ((((uri != null) && (clazz != null)) && (genModel != null))) {
            GeneratedPackage.ParsedGeneratedPackage _parsedGeneratedPackage = new GeneratedPackage.ParsedGeneratedPackage(this.project, uri, clazz, genModel);
            this.generatedPackages.add(_parsedGeneratedPackage);
          }
        }
      }
    }
    
    @Override
    public void endElement(final String uri, final String localName, final String qName) {
      boolean _equals = Objects.equal(qName, "extension");
      if (_equals) {
        this.generatedPackageExtension = false;
      }
    }
    
    private final IProject project;
    
    private boolean generatedPackageExtension = false;
    
    private List<GeneratedPackage.ParsedGeneratedPackage> generatedPackages = CollectionLiterals.<GeneratedPackage.ParsedGeneratedPackage>newArrayList();
  }
  
  /**
   * Finds extensions with type "org.eclipse.emf.ecore.generated_package" of all projects in the workspace.
   * The referenced ecore and generator model must be present in the project declaring the extension,
   * else the extension is ignored.
   * 
   * @return all generated packages in the workspace.
   */
  public static List<GeneratedPackage> fromWorkspace() {
    final ArrayList<GeneratedPackage> result = new ArrayList<GeneratedPackage>();
    List<GeneratedPackage.ParsedGeneratedPackage> _parseGeneratedPackages = GeneratedPackage.parseGeneratedPackages();
    for (final GeneratedPackage.ParsedGeneratedPackage parsedGeneratedPackage : _parseGeneratedPackages) {
      {
        final List<EPackage> ecoreModels = GeneratedPackage.loadEcoreModels(parsedGeneratedPackage.project);
        final Function1<EPackage, Boolean> _function = (EPackage it) -> {
          String _nsURI = it.getNsURI();
          return Boolean.valueOf(Objects.equal(_nsURI, parsedGeneratedPackage.uri));
        };
        final EPackage ePackage = IterableExtensions.<EPackage>findFirst(ecoreModels, _function);
        final GenModel genModel = GeneratedPackage.loadGenModel(parsedGeneratedPackage.project, parsedGeneratedPackage.genModel);
        if (((ePackage != null) && (genModel != null))) {
          GeneratedPackage _generatedPackage = new GeneratedPackage(parsedGeneratedPackage.project, ePackage, genModel);
          result.add(_generatedPackage);
        }
      }
    }
    return result;
  }
  
  private final IProject project;
  
  private final EPackage ePackage;
  
  private final GenModel genModel;
  
  private static List<EPackage> loadEcoreModels(final IProject project) {
    final ArrayList<EPackage> ecoreModels = new ArrayList<EPackage>();
    final ResourceSetImpl resSet = new ResourceSetImpl();
    try {
      final ArrayList<IResource> members = CollectionLiterals.<IResource>newArrayList(project.members());
      while ((!members.isEmpty())) {
        {
          final IResource current = members.remove(0);
          if ((current instanceof IContainer)) {
            IResource[] _members = ((IContainer)current).members();
            Iterables.<IResource>addAll(members, ((Iterable<? extends IResource>)Conversions.doWrapArray(_members)));
          } else {
            if (((current instanceof IFile) && Objects.equal(current.getFileExtension(), "ecore"))) {
              Resource _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = resSet.getResource(URI.createFileURI(current.getLocationURI().getPath()), true);
              } catch (final Throwable _t) {
                if (_t instanceof WrappedException) {
                  _xtrycatchfinallyexpression = null;
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              final Resource res = _xtrycatchfinallyexpression;
              if ((((res != null) && (!res.getContents().isEmpty())) && (res.getContents().get(0) instanceof EPackage))) {
                EObject _get = res.getContents().get(0);
                ecoreModels.add(((EPackage) _get));
              }
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return ecoreModels;
  }
  
  private static GenModel loadGenModel(final IProject project, final String path) {
    final ResourceSetImpl resSet = new ResourceSetImpl();
    final URI genModelUri = URI.createFileURI(project.getFile(path).getLocationURI().getPath());
    Resource _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = resSet.getResource(genModelUri, true);
    } catch (final Throwable _t) {
      if (_t instanceof WrappedException) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final Resource res = _xtrycatchfinallyexpression;
    if (((!res.getContents().isEmpty()) && (res.getContents().get(0) instanceof GenModel))) {
      EObject _get = res.getContents().get(0);
      return ((GenModel) _get);
    } else {
      return null;
    }
  }
  
  private static List<GeneratedPackage.ParsedGeneratedPackage> parseGeneratedPackages() {
    final ArrayList<GeneratedPackage.ParsedGeneratedPackage> result = new ArrayList<GeneratedPackage.ParsedGeneratedPackage>();
    final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    final Function1<IProject, Boolean> _function = (IProject it) -> {
      IResource _findMember = it.findMember("plugin.xml");
      return Boolean.valueOf((_findMember != null));
    };
    Iterable<IProject> _filter = IterableExtensions.<IProject>filter(((Iterable<IProject>)Conversions.doWrapArray(projects)), _function);
    for (final IProject project : _filter) {
      {
        final IResource pluginXmlResource = project.findMember("plugin.xml");
        final URI pluginXmlUri = URI.createFileURI(pluginXmlResource.getLocationURI().getPath());
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        InputStream in = null;
        try {
          final SAXParser saxParser = factory.newSAXParser();
          in = URIConverter.INSTANCE.createInputStream(pluginXmlUri);
          final GeneratedPackage.GeneratedPackageHandler handler = new GeneratedPackage.GeneratedPackageHandler(project);
          saxParser.parse(in, handler);
          Iterables.<GeneratedPackage.ParsedGeneratedPackage>addAll(result, handler.generatedPackages);
        } catch (final Throwable _t) {
          if (_t instanceof IOException || _t instanceof ParserConfigurationException || _t instanceof SAXException) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          if ((in != null)) {
            try {
              in.close();
            } catch (final Throwable _t_1) {
              if (_t_1 instanceof IOException) {
              } else {
                throw Exceptions.sneakyThrow(_t_1);
              }
            }
          }
        }
      }
    }
    return result;
  }
  
  public GeneratedPackage(final IProject project, final EPackage ePackage, final GenModel genModel) {
    super();
    this.project = project;
    this.ePackage = ePackage;
    this.genModel = genModel;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
    result = prime * result + ((this.ePackage== null) ? 0 : this.ePackage.hashCode());
    return prime * result + ((this.genModel== null) ? 0 : this.genModel.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GeneratedPackage other = (GeneratedPackage) obj;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    if (this.ePackage == null) {
      if (other.ePackage != null)
        return false;
    } else if (!this.ePackage.equals(other.ePackage))
      return false;
    if (this.genModel == null) {
      if (other.genModel != null)
        return false;
    } else if (!this.genModel.equals(other.genModel))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("project", this.project);
    b.add("ePackage", this.ePackage);
    b.add("genModel", this.genModel);
    return b.toString();
  }
  
  @Pure
  public IProject getProject() {
    return this.project;
  }
  
  @Pure
  public EPackage getEPackage() {
    return this.ePackage;
  }
  
  @Pure
  public GenModel getGenModel() {
    return this.genModel;
  }
}
