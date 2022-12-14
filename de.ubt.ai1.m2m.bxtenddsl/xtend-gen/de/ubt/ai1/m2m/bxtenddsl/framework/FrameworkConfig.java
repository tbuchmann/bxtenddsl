package de.ubt.ai1.m2m.bxtenddsl.framework;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader;
import java.util.Properties;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Configuration for the various framework generators and templates.
 */
@Data
@SuppressWarnings("all")
public class FrameworkConfig {
  private final String project;
  
  private final String rootPackage;
  
  private final String trafo;
  
  private final String srcUri;
  
  private final String trgUri;
  
  private final String sourcePackage;
  
  private final String targetPackage;
  
  private final String sourceFactory;
  
  private final String targetFactory;
  
  /**
   * Creates a framework configuration for the given project, properties and dsl.
   */
  public FrameworkConfig(final IProject project, final Properties properties, final BXtendDSL dsl) {
    this.project = project.getName();
    this.rootPackage = properties.getProperty("package");
    this.trafo = properties.getProperty("trafo");
    this.srcUri = dsl.getMetamodels().getSourcemodel();
    this.trgUri = dsl.getMetamodels().getTargetmodel();
    final GenPackage srcGenPkg = MetamodelLoader.genModel(this.srcUri).getGenPackages().get(0);
    final GenPackage trgGenPkg = MetamodelLoader.genModel(this.trgUri).getGenPackages().get(0);
    String _xifexpression = null;
    if (((srcGenPkg.getBasePackage() != null) && (srcGenPkg.getBasePackage().length() > 0))) {
      StringConcatenation _builder = new StringConcatenation();
      String _basePackage = srcGenPkg.getBasePackage();
      _builder.append(_basePackage);
      _builder.append(".");
      String _packageName = srcGenPkg.getPackageName();
      _builder.append(_packageName);
      _builder.append(".");
      String _basicPackageName = srcGenPkg.getBasicPackageName();
      _builder.append(_basicPackageName);
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _packageName_1 = srcGenPkg.getPackageName();
      _builder_1.append(_packageName_1);
      _builder_1.append(".");
      String _basicPackageName_1 = srcGenPkg.getBasicPackageName();
      _builder_1.append(_basicPackageName_1);
      _xifexpression = _builder_1.toString();
    }
    this.sourcePackage = _xifexpression;
    String _xifexpression_1 = null;
    if (((trgGenPkg.getBasePackage() != null) && (trgGenPkg.getBasePackage().length() > 0))) {
      StringConcatenation _builder_2 = new StringConcatenation();
      String _basePackage_1 = trgGenPkg.getBasePackage();
      _builder_2.append(_basePackage_1);
      _builder_2.append(".");
      String _packageName_2 = trgGenPkg.getPackageName();
      _builder_2.append(_packageName_2);
      _builder_2.append(".");
      String _basicPackageName_2 = trgGenPkg.getBasicPackageName();
      _builder_2.append(_basicPackageName_2);
      _xifexpression_1 = _builder_2.toString();
    } else {
      StringConcatenation _builder_3 = new StringConcatenation();
      String _packageName_3 = trgGenPkg.getPackageName();
      _builder_3.append(_packageName_3);
      _builder_3.append(".");
      String _basicPackageName_3 = trgGenPkg.getBasicPackageName();
      _builder_3.append(_basicPackageName_3);
      _xifexpression_1 = _builder_3.toString();
    }
    this.targetPackage = _xifexpression_1;
    int _length = this.sourcePackage.length();
    int _minus = (_length - 7);
    String _substring = this.sourcePackage.substring(0, _minus);
    String _plus = (_substring + "Factory");
    this.sourceFactory = _plus;
    int _length_1 = this.targetPackage.length();
    int _minus_1 = (_length_1 - 7);
    String _substring_1 = this.targetPackage.substring(0, _minus_1);
    String _plus_1 = (_substring_1 + "Factory");
    this.targetFactory = _plus_1;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
    result = prime * result + ((this.rootPackage== null) ? 0 : this.rootPackage.hashCode());
    result = prime * result + ((this.trafo== null) ? 0 : this.trafo.hashCode());
    result = prime * result + ((this.srcUri== null) ? 0 : this.srcUri.hashCode());
    result = prime * result + ((this.trgUri== null) ? 0 : this.trgUri.hashCode());
    result = prime * result + ((this.sourcePackage== null) ? 0 : this.sourcePackage.hashCode());
    result = prime * result + ((this.targetPackage== null) ? 0 : this.targetPackage.hashCode());
    result = prime * result + ((this.sourceFactory== null) ? 0 : this.sourceFactory.hashCode());
    return prime * result + ((this.targetFactory== null) ? 0 : this.targetFactory.hashCode());
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
    FrameworkConfig other = (FrameworkConfig) obj;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    if (this.rootPackage == null) {
      if (other.rootPackage != null)
        return false;
    } else if (!this.rootPackage.equals(other.rootPackage))
      return false;
    if (this.trafo == null) {
      if (other.trafo != null)
        return false;
    } else if (!this.trafo.equals(other.trafo))
      return false;
    if (this.srcUri == null) {
      if (other.srcUri != null)
        return false;
    } else if (!this.srcUri.equals(other.srcUri))
      return false;
    if (this.trgUri == null) {
      if (other.trgUri != null)
        return false;
    } else if (!this.trgUri.equals(other.trgUri))
      return false;
    if (this.sourcePackage == null) {
      if (other.sourcePackage != null)
        return false;
    } else if (!this.sourcePackage.equals(other.sourcePackage))
      return false;
    if (this.targetPackage == null) {
      if (other.targetPackage != null)
        return false;
    } else if (!this.targetPackage.equals(other.targetPackage))
      return false;
    if (this.sourceFactory == null) {
      if (other.sourceFactory != null)
        return false;
    } else if (!this.sourceFactory.equals(other.sourceFactory))
      return false;
    if (this.targetFactory == null) {
      if (other.targetFactory != null)
        return false;
    } else if (!this.targetFactory.equals(other.targetFactory))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("project", this.project);
    b.add("rootPackage", this.rootPackage);
    b.add("trafo", this.trafo);
    b.add("srcUri", this.srcUri);
    b.add("trgUri", this.trgUri);
    b.add("sourcePackage", this.sourcePackage);
    b.add("targetPackage", this.targetPackage);
    b.add("sourceFactory", this.sourceFactory);
    b.add("targetFactory", this.targetFactory);
    return b.toString();
  }
  
  @Pure
  public String getProject() {
    return this.project;
  }
  
  @Pure
  public String getRootPackage() {
    return this.rootPackage;
  }
  
  @Pure
  public String getTrafo() {
    return this.trafo;
  }
  
  @Pure
  public String getSrcUri() {
    return this.srcUri;
  }
  
  @Pure
  public String getTrgUri() {
    return this.trgUri;
  }
  
  @Pure
  public String getSourcePackage() {
    return this.sourcePackage;
  }
  
  @Pure
  public String getTargetPackage() {
    return this.targetPackage;
  }
  
  @Pure
  public String getSourceFactory() {
    return this.sourceFactory;
  }
  
  @Pure
  public String getTargetFactory() {
    return this.targetFactory;
  }
}
