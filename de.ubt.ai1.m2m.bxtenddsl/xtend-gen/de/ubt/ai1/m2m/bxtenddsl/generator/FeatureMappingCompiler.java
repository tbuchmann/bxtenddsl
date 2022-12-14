package de.ubt.ai1.m2m.bxtenddsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature;
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A compiler for feature mappings.
 */
@SuppressWarnings("all")
public class FeatureMappingCompiler extends de.ubt.ai1.m2m.bxtenddsl.generator.Compiler {
  @Data
  public static class Method {
    private final String call;
    
    private final String typeClass;
    
    private final String method;
    
    public Method(final String call, final String typeClass, final String method) {
      super();
      this.call = call;
      this.typeClass = typeClass;
      this.method = method;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.call== null) ? 0 : this.call.hashCode());
      result = prime * result + ((this.typeClass== null) ? 0 : this.typeClass.hashCode());
      return prime * result + ((this.method== null) ? 0 : this.method.hashCode());
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
      FeatureMappingCompiler.Method other = (FeatureMappingCompiler.Method) obj;
      if (this.call == null) {
        if (other.call != null)
          return false;
      } else if (!this.call.equals(other.call))
        return false;
      if (this.typeClass == null) {
        if (other.typeClass != null)
          return false;
      } else if (!this.typeClass.equals(other.typeClass))
        return false;
      if (this.method == null) {
        if (other.method != null)
          return false;
      } else if (!this.method.equals(other.method))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("call", this.call);
      b.add("typeClass", this.typeClass);
      b.add("method", this.method);
      return b.toString();
    }
    
    @Pure
    public String getCall() {
      return this.call;
    }
    
    @Pure
    public String getTypeClass() {
      return this.typeClass;
    }
    
    @Pure
    public String getMethod() {
      return this.method;
    }
  }
  
  @Data
  private static class PreprocessedMapping {
    @Data
    public static class Parameter {
      private final String matcher;
      
      private final String javaType;
      
      private final String suggestedIdentifier;
      
      private final Function0<String> read;
      
      private final Function1<String, String> write;
      
      public Parameter(final String matcher, final String javaType, final String suggestedIdentifier, final Function0<String> read, final Function1<String, String> write) {
        super();
        this.matcher = matcher;
        this.javaType = javaType;
        this.suggestedIdentifier = suggestedIdentifier;
        this.read = read;
        this.write = write;
      }
      
      @Override
      @Pure
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.matcher== null) ? 0 : this.matcher.hashCode());
        result = prime * result + ((this.javaType== null) ? 0 : this.javaType.hashCode());
        result = prime * result + ((this.suggestedIdentifier== null) ? 0 : this.suggestedIdentifier.hashCode());
        result = prime * result + ((this.read== null) ? 0 : this.read.hashCode());
        return prime * result + ((this.write== null) ? 0 : this.write.hashCode());
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
        FeatureMappingCompiler.PreprocessedMapping.Parameter other = (FeatureMappingCompiler.PreprocessedMapping.Parameter) obj;
        if (this.matcher == null) {
          if (other.matcher != null)
            return false;
        } else if (!this.matcher.equals(other.matcher))
          return false;
        if (this.javaType == null) {
          if (other.javaType != null)
            return false;
        } else if (!this.javaType.equals(other.javaType))
          return false;
        if (this.suggestedIdentifier == null) {
          if (other.suggestedIdentifier != null)
            return false;
        } else if (!this.suggestedIdentifier.equals(other.suggestedIdentifier))
          return false;
        if (this.read == null) {
          if (other.read != null)
            return false;
        } else if (!this.read.equals(other.read))
          return false;
        if (this.write == null) {
          if (other.write != null)
            return false;
        } else if (!this.write.equals(other.write))
          return false;
        return true;
      }
      
      @Override
      @Pure
      public String toString() {
        ToStringBuilder b = new ToStringBuilder(this);
        b.add("matcher", this.matcher);
        b.add("javaType", this.javaType);
        b.add("suggestedIdentifier", this.suggestedIdentifier);
        b.add("read", this.read);
        b.add("write", this.write);
        return b.toString();
      }
      
      @Pure
      public String getMatcher() {
        return this.matcher;
      }
      
      @Pure
      public String getJavaType() {
        return this.javaType;
      }
      
      @Pure
      public String getSuggestedIdentifier() {
        return this.suggestedIdentifier;
      }
      
      @Pure
      public Function0<String> getRead() {
        return this.read;
      }
      
      @Pure
      public Function1<String, String> getWrite() {
        return this.write;
      }
    }
    
    private final Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> input;
    
    private final Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> output;
    
    public PreprocessedMapping(final Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> input, final Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> output) {
      super();
      this.input = input;
      this.output = output;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.input== null) ? 0 : this.input.hashCode());
      return prime * result + ((this.output== null) ? 0 : this.output.hashCode());
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
      FeatureMappingCompiler.PreprocessedMapping other = (FeatureMappingCompiler.PreprocessedMapping) obj;
      if (this.input == null) {
        if (other.input != null)
          return false;
      } else if (!this.input.equals(other.input))
        return false;
      if (this.output == null) {
        if (other.output != null)
          return false;
      } else if (!this.output.equals(other.output))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("input", this.input);
      b.add("output", this.output);
      return b.toString();
    }
    
    @Pure
    public Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> getInput() {
      return this.input;
    }
    
    @Pure
    public Collection<FeatureMappingCompiler.PreprocessedMapping.Parameter> getOutput() {
      return this.output;
    }
  }
  
  private Properties modelsProperties;
  
  public void setModelsProperties(final Properties modelsProperties) {
    this.modelsProperties = modelsProperties;
  }
  
  /**
   * Returns true, if a feature mapping is compileable as assignment.
   */
  public boolean compileableToAssignment(final boolean srcToTrg, final FeatureMapping mapping) {
    return ((this.compileableToAssignmentSimple(srcToTrg, mapping) || this.compileableToAssignmentSingleCorr(srcToTrg, mapping)) || this.compileableToAssignmentMultiCorr(srcToTrg, mapping));
  }
  
  /**
   * Compiles a feature mapping as assignment.
   */
  public String compileToAssignment(final boolean srcToTrg, final FeatureMapping mapping, final IdentifierScope localScope) {
    String _xifexpression = null;
    boolean _compileableToAssignmentSimple = this.compileableToAssignmentSimple(srcToTrg, mapping);
    if (_compileableToAssignmentSimple) {
      _xifexpression = this.compileToAssignmentSimple(srcToTrg, mapping);
    } else {
      String _xifexpression_1 = null;
      boolean _compileableToAssignmentSingleCorr = this.compileableToAssignmentSingleCorr(srcToTrg, mapping);
      if (_compileableToAssignmentSingleCorr) {
        _xifexpression_1 = this.compileToAssignmentSingleCorr(srcToTrg, mapping);
      } else {
        String _xifexpression_2 = null;
        boolean _compileableToAssignmentMultiCorr = this.compileableToAssignmentMultiCorr(srcToTrg, mapping);
        if (_compileableToAssignmentMultiCorr) {
          _xifexpression_2 = this.compileToAssignmentMultiCorr(srcToTrg, mapping, localScope);
        } else {
          throw new IllegalArgumentException("The feature mapping is not compileable as assignment!");
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Compiles a feature mapping as method. Returns the call of the generated method, the actual method and
   * a nested class that is used as return type of the method.
   */
  public FeatureMappingCompiler.Method compileToMethod(final boolean srcToTrg, final FeatureMapping mapping, final IdentifierScope ruleScope, final IdentifierScope localScope) {
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    final LinkedHashMap<FeatureMappingCompiler.PreprocessedMapping.Parameter, String> paramToId = new LinkedHashMap<FeatureMappingCompiler.PreprocessedMapping.Parameter, String>();
    final Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, String> _function = (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
      return it.suggestedIdentifier;
    };
    final String outputDescription = IterableExtensions.join(IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter, String>map(preprocessed.output, _function), "_");
    final String methodId = ruleScope.addIdentifier((outputDescription + "From"), IdentifierScope.Group.METHOD);
    final int fromPos = methodId.lastIndexOf("From");
    String _substring = methodId.substring(0, fromPos);
    String _substring_1 = methodId.substring((fromPos + 4), methodId.length());
    final String fromLessId = (_substring + _substring_1);
    final String type = ruleScope.addIdentifier(("Type4" + fromLessId), IdentifierScope.Group.CLASS);
    final IdentifierScope typeScope = new IdentifierScope();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data protected static class ");
    _builder.append(type);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      for(final FeatureMappingCompiler.PreprocessedMapping.Parameter param : preprocessed.output) {
        _builder.append("\t");
        _builder.append(param.javaType, "\t");
        _builder.append(" ");
        String _xblockexpression = null;
        {
          final String suggested = param.suggestedIdentifier;
          final String actual = typeScope.addIdentifier(suggested, IdentifierScope.Group.VARIABLE);
          paramToId.put(param, actual);
          _xblockexpression = actual;
        }
        _builder.append(_xblockexpression, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    final String typeClass = _builder.toString();
    final IdentifierScope methodScope = new IdentifierScope();
    ArrayList<String> methodParams = new ArrayList<String>();
    for (final FeatureMappingCompiler.PreprocessedMapping.Parameter param_1 : preprocessed.input) {
      {
        final String suggested = param_1.suggestedIdentifier;
        final String actual = methodScope.addIdentifier(suggested, IdentifierScope.Group.VARIABLE);
        paramToId.put(param_1, actual);
        methodParams.add(((param_1.javaType + " ") + actual));
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def protected abstract ");
    _builder_1.append(type);
    _builder_1.append(" ");
    _builder_1.append(methodId);
    _builder_1.append("(");
    String _join = IterableExtensions.join(methodParams, ", ");
    _builder_1.append(_join);
    _builder_1.append(");");
    _builder_1.newLineIfNotEmpty();
    final String method = _builder_1.toString();
    final ArrayList<String> callParamComputations = new ArrayList<String>();
    final ArrayList<String> callParams = new ArrayList<String>();
    for (final FeatureMappingCompiler.PreprocessedMapping.Parameter in : preprocessed.input) {
      if (((in.read.apply().length() > 24) && (in.suggestedIdentifier.length() < in.read.apply().length()))) {
        final String callParamId = localScope.addIdentifier(("_" + in.suggestedIdentifier), IdentifierScope.Group.VARIABLE);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("val ");
        _builder_2.append(callParamId);
        _builder_2.append(" = ");
        String _apply = in.read.apply();
        _builder_2.append(_apply);
        callParamComputations.add(_builder_2.toString());
        callParams.add(callParamId);
      } else {
        String _apply_1 = in.read.apply();
        callParams.add(_apply_1);
      }
    }
    final String resultId = localScope.addIdentifier(("_" + fromLessId), IdentifierScope.Group.VARIABLE);
    StringConcatenation _builder_3 = new StringConcatenation();
    {
      EList<? extends MappingFeature> _xifexpression = null;
      if (srcToTrg) {
        _xifexpression = mapping.getSrcFeatures();
      } else {
        _xifexpression = mapping.getTrgFeatures();
      }
      final Function1<MappingFeature, Boolean> _function_1 = (MappingFeature it) -> {
        return Boolean.valueOf(it.isCorr());
      };
      Iterable<? extends MappingFeature> _filter = IterableExtensions.filter(_xifexpression, _function_1);
      for(final MappingFeature feature : _filter) {
        {
          int _upperBound = feature.getFeature().getUpperBound();
          boolean _equals = (_upperBound == 1);
          if (_equals) {
            String _ter = this.getter(feature);
            _builder_3.append(_ter);
            _builder_3.append("?.corr?.assertRuleId(");
            final Function1<Correspondence, String> _function_2 = (Correspondence it) -> {
              return it.getRule().getName();
            };
            final Function1<String, CharSequence> _function_3 = (String it) -> {
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("\"");
              _builder_4.append(it);
              _builder_4.append("\"");
              return _builder_4.toString();
            };
            String _join_1 = IterableExtensions.<String>join(ListExtensions.<Correspondence, String>map(feature.getCorrs(), _function_2), ", ", _function_3);
            _builder_3.append(_join_1);
            _builder_3.append(")");
            _builder_3.newLineIfNotEmpty();
          } else {
            String _ter_1 = this.getter(feature);
            _builder_3.append(_ter_1);
            _builder_3.append(".forEach[corr.assertRuleId(");
            final Function1<Correspondence, String> _function_4 = (Correspondence it) -> {
              return it.getRule().getName();
            };
            final Function1<String, CharSequence> _function_5 = (String it) -> {
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("\"");
              _builder_4.append(it);
              _builder_4.append("\"");
              return _builder_4.toString();
            };
            String _join_2 = IterableExtensions.<String>join(ListExtensions.<Correspondence, String>map(feature.getCorrs(), _function_4), ", ", _function_5);
            _builder_3.append(_join_2);
            _builder_3.append(")]");
            _builder_3.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final String computation : callParamComputations) {
        _builder_3.append(computation);
        _builder_3.newLineIfNotEmpty();
      }
    }
    _builder_3.append("val ");
    _builder_3.append(resultId);
    _builder_3.append(" = ");
    _builder_3.append(methodId);
    _builder_3.append("(");
    String _join_3 = IterableExtensions.join(callParams, ", ");
    _builder_3.append(_join_3);
    _builder_3.append(")");
    _builder_3.newLineIfNotEmpty();
    {
      for(final FeatureMappingCompiler.PreprocessedMapping.Parameter param_2 : preprocessed.output) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append(resultId);
        _builder_4.append(".");
        String _get = paramToId.get(param_2);
        _builder_4.append(_get);
        String _apply_2 = param_2.write.apply(_builder_4.toString());
        _builder_3.append(_apply_2);
        _builder_3.newLineIfNotEmpty();
      }
    }
    final String call = _builder_3.toString();
    return new FeatureMappingCompiler.Method(call, typeClass, method);
  }
  
  /**
   * Returns if the compilation of this mapping contains any abstract method.
   * This method assumes mappings are compiled as assignment whenever possible.
   */
  public boolean anyAbstractMethod(final boolean srcToTrg, final FeatureMapping mapping) {
    boolean _compileableToAssignment = this.compileableToAssignment(srcToTrg, mapping);
    return (!_compileableToAssignment);
  }
  
  /**
   * Returns if the compilation of this mapping contains any use of the given class matcher.
   */
  public boolean anyUseOf(final boolean srcToTrg, final FeatureMapping mapping, final String matcher) {
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    return (IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter>exists(preprocessed.input, ((Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, Boolean>) (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
      return Boolean.valueOf(Objects.equal(it.matcher, matcher));
    })) || IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter>exists(preprocessed.output, ((Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, Boolean>) (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
      return Boolean.valueOf(Objects.equal(it.matcher, matcher));
    })));
  }
  
  /**
   * Returns all imports that the compilation of this mapping needs.
   * This method assumes mappings are compiled as assignment whenever possible.
   */
  public Set<String> neededImports(final boolean srcToTrg, final FeatureMapping mapping, final String rootPackage) {
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    Set<String> imports = super.neededImports(rootPackage);
    if (srcToTrg) {
      final Function1<SrcMappingFeature, Boolean> _function = (SrcMappingFeature it) -> {
        final Function1<Correspondence, Boolean> _function_1 = (Correspondence it_1) -> {
          final Function1<ClassMatcher, Boolean> _function_2 = (ClassMatcher it_2) -> {
            boolean _isGroup = it_2.getModifier().isGroup();
            return Boolean.valueOf((!_isGroup));
          };
          return Boolean.valueOf(IterableExtensions.exists(this.allMatchers(it_1), _function_2));
        };
        return Boolean.valueOf(IterableExtensions.<Correspondence>exists(it.getCorrs(), _function_1));
      };
      boolean _exists = IterableExtensions.<SrcMappingFeature>exists(mapping.getSrcFeatures(), _function);
      if (_exists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("import ");
        _builder.append(rootPackage);
        _builder.append(".corrmodel.SingleElem");
        imports.add(_builder.toString());
      }
      final Function1<SrcMappingFeature, Boolean> _function_1 = (SrcMappingFeature it) -> {
        final Function1<Correspondence, Boolean> _function_2 = (Correspondence it_1) -> {
          final Function1<ClassMatcher, Boolean> _function_3 = (ClassMatcher it_2) -> {
            return Boolean.valueOf(it_2.getModifier().isGroup());
          };
          return Boolean.valueOf(IterableExtensions.exists(this.allMatchers(it_1), _function_3));
        };
        return Boolean.valueOf(IterableExtensions.<Correspondence>exists(it.getCorrs(), _function_2));
      };
      boolean _exists_1 = IterableExtensions.<SrcMappingFeature>exists(mapping.getSrcFeatures(), _function_1);
      if (_exists_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import ");
        _builder_1.append(rootPackage);
        _builder_1.append(".corrmodel.MultiElem");
        imports.add(_builder_1.toString());
        imports.add("import java.util.List");
      }
    } else {
      final Function1<TrgMappingFeature, Boolean> _function_2 = (TrgMappingFeature it) -> {
        final Function1<Correspondence, Boolean> _function_3 = (Correspondence it_1) -> {
          final Function1<ClassMatcher, Boolean> _function_4 = (ClassMatcher it_2) -> {
            boolean _isGroup = it_2.getModifier().isGroup();
            return Boolean.valueOf((!_isGroup));
          };
          return Boolean.valueOf(IterableExtensions.exists(this.allMatchers(it_1), _function_4));
        };
        return Boolean.valueOf(IterableExtensions.<Correspondence>exists(it.getCorrs(), _function_3));
      };
      boolean _exists_2 = IterableExtensions.<TrgMappingFeature>exists(mapping.getTrgFeatures(), _function_2);
      if (_exists_2) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("import ");
        _builder_2.append(rootPackage);
        _builder_2.append(".corrmodel.SingleElem");
        imports.add(_builder_2.toString());
      }
      final Function1<TrgMappingFeature, Boolean> _function_3 = (TrgMappingFeature it) -> {
        final Function1<Correspondence, Boolean> _function_4 = (Correspondence it_1) -> {
          final Function1<ClassMatcher, Boolean> _function_5 = (ClassMatcher it_2) -> {
            return Boolean.valueOf(it_2.getModifier().isGroup());
          };
          return Boolean.valueOf(IterableExtensions.exists(this.allMatchers(it_1), _function_5));
        };
        return Boolean.valueOf(IterableExtensions.<Correspondence>exists(it.getCorrs(), _function_4));
      };
      boolean _exists_3 = IterableExtensions.<TrgMappingFeature>exists(mapping.getTrgFeatures(), _function_3);
      if (_exists_3) {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("import ");
        _builder_3.append(rootPackage);
        _builder_3.append(".corrmodel.MultiElem");
        imports.add(_builder_3.toString());
        imports.add("import java.util.List");
      }
    }
    boolean _compileableToAssignment = this.compileableToAssignment(srcToTrg, mapping);
    boolean _not = (!_compileableToAssignment);
    if (_not) {
      imports.add("import org.eclipse.xtend.lib.annotations.Data");
      if ((IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter>exists(preprocessed.input, ((Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, Boolean>) (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
        return Boolean.valueOf(it.javaType.startsWith("List<"));
      })) || IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter>exists(preprocessed.output, ((Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, Boolean>) (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
        return Boolean.valueOf(it.javaType.startsWith("List<"));
      })))) {
        imports.add("import java.util.List");
      }
    }
    return imports;
  }
  
  @Override
  public Set<String> neededImports(final String rootPackage) {
    final String message = "Compiler interface not yet supported, use the neededImports method with parameters!";
    throw new UnsupportedOperationException(message);
  }
  
  @Inject
  @Extension
  private Utils _utils;
  
  private boolean compileableToAssignmentSimple(final boolean srcToTrg, final FeatureMapping mapping) {
    EList<? extends MappingFeature> _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = mapping.getSrcFeatures();
    } else {
      _xifexpression = mapping.getTrgFeatures();
    }
    final EList<? extends MappingFeature> inFeatures = _xifexpression;
    EList<? extends MappingFeature> _xifexpression_1 = null;
    if (srcToTrg) {
      _xifexpression_1 = mapping.getTrgFeatures();
    } else {
      _xifexpression_1 = mapping.getSrcFeatures();
    }
    final EList<? extends MappingFeature> outFeatures = _xifexpression_1;
    EList<ClassMatcher> _xifexpression_2 = null;
    if (srcToTrg) {
      _xifexpression_2 = mapping.getSrcClasses();
    } else {
      _xifexpression_2 = mapping.getTrgClasses();
    }
    final EList<ClassMatcher> inClasses = _xifexpression_2;
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    if (((preprocessed.input.size() != 1) || (preprocessed.output.size() != 1))) {
      return false;
    }
    if (((!inFeatures.isEmpty()) && inFeatures.get(0).isCorr())) {
      return false;
    }
    EClassifier _xifexpression_3 = null;
    boolean _isEmpty = inFeatures.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      _xifexpression_3 = inFeatures.get(0).getFeature().getEType();
    } else {
      _xifexpression_3 = inClasses.get(0).getClazz();
    }
    final EClassifier inputEClass = _xifexpression_3;
    final EClassifier outputEClass = outFeatures.get(0).getFeature().getEType();
    if (((inputEClass instanceof EDataType) || (outputEClass instanceof EDataType))) {
      return Objects.equal((((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.input, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).javaType, (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).javaType);
    }
    if (((!(inputEClass instanceof EClass)) || (!(outputEClass instanceof EClass)))) {
      return false;
    }
    boolean _xifexpression_4 = false;
    boolean _isEmpty_1 = inFeatures.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      int _upperBound = inFeatures.get(0).getFeature().getUpperBound();
      _xifexpression_4 = (_upperBound != 1);
    } else {
      _xifexpression_4 = inClasses.get(0).getModifier().isGroup();
    }
    final boolean inputMultivalued = _xifexpression_4;
    int _upperBound_1 = outFeatures.get(0).getFeature().getUpperBound();
    final boolean outputMultivalued = (_upperBound_1 != 1);
    return (((EClass) outputEClass).isSuperTypeOf(((EClass) inputEClass)) && (inputMultivalued == outputMultivalued));
  }
  
  private boolean compileableToAssignmentSingleCorr(final boolean srcToTrg, final FeatureMapping mapping) {
    EList<? extends MappingFeature> _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = mapping.getSrcFeatures();
    } else {
      _xifexpression = mapping.getTrgFeatures();
    }
    final EList<? extends MappingFeature> input = _xifexpression;
    EList<? extends MappingFeature> _xifexpression_1 = null;
    if (srcToTrg) {
      _xifexpression_1 = mapping.getTrgFeatures();
    } else {
      _xifexpression_1 = mapping.getSrcFeatures();
    }
    final EList<? extends MappingFeature> output = _xifexpression_1;
    if (((!mapping.getSrcClasses().isEmpty()) || (!mapping.getTrgClasses().isEmpty()))) {
      return false;
    }
    if (((input.size() != 1) || (input.get(0).getFeature().getUpperBound() != 1))) {
      return false;
    }
    if (((output.size() != 1) || (output.get(0).getFeature().getUpperBound() != 1))) {
      return false;
    }
    List<List<? extends ClassMatcher>> _xifexpression_2 = null;
    boolean _isCorr = input.get(0).isCorr();
    boolean _not = (!_isCorr);
    if (_not) {
      return false;
    } else {
      final Function1<Correspondence, List<? extends ClassMatcher>> _function = (Correspondence it) -> {
        return this.allMatchers(it);
      };
      _xifexpression_2 = ListExtensions.<Correspondence, List<? extends ClassMatcher>>map(input.get(0).getCorrs(), _function);
    }
    final List<List<? extends ClassMatcher>> matchersInputCorrs = _xifexpression_2;
    EClass _xifexpression_3 = null;
    EClassifier _eType = output.get(0).getFeature().getEType();
    boolean _not_1 = (!(_eType instanceof EClass));
    if (_not_1) {
      return false;
    } else {
      EClassifier _eType_1 = output.get(0).getFeature().getEType();
      _xifexpression_3 = ((EClass) _eType_1);
    }
    final EClass outputEClass = _xifexpression_3;
    for (final List<? extends ClassMatcher> matchers : matchersInputCorrs) {
      {
        if (((matchers.size() != 1) || matchers.get(0).getModifier().isGroup())) {
          return false;
        }
        boolean _isSuperTypeOf = outputEClass.isSuperTypeOf(matchers.get(0).getClazz());
        boolean _not_2 = (!_isSuperTypeOf);
        if (_not_2) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean compileableToAssignmentMultiCorr(final boolean srcToTrg, final FeatureMapping mapping) {
    EList<? extends MappingFeature> _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = mapping.getSrcFeatures();
    } else {
      _xifexpression = mapping.getTrgFeatures();
    }
    final EList<? extends MappingFeature> input = _xifexpression;
    EList<? extends MappingFeature> _xifexpression_1 = null;
    if (srcToTrg) {
      _xifexpression_1 = mapping.getTrgFeatures();
    } else {
      _xifexpression_1 = mapping.getSrcFeatures();
    }
    final EList<? extends MappingFeature> output = _xifexpression_1;
    if (((!mapping.getSrcClasses().isEmpty()) || (!mapping.getTrgClasses().isEmpty()))) {
      return false;
    }
    int _size = input.size();
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      return false;
    }
    if (((output.size() != 1) || (output.get(0).getFeature().getUpperBound() == 1))) {
      return false;
    }
    List<List<? extends ClassMatcher>> _xifexpression_2 = null;
    boolean _isCorr = input.get(0).isCorr();
    boolean _not = (!_isCorr);
    if (_not) {
      return false;
    } else {
      final Function1<Correspondence, List<? extends ClassMatcher>> _function = (Correspondence it) -> {
        return this.allMatchers(it);
      };
      _xifexpression_2 = ListExtensions.<Correspondence, List<? extends ClassMatcher>>map(input.get(0).getCorrs(), _function);
    }
    final List<List<? extends ClassMatcher>> matchersInputCorrs = _xifexpression_2;
    EClass _xifexpression_3 = null;
    EClassifier _eType = output.get(0).getFeature().getEType();
    boolean _not_1 = (!(_eType instanceof EClass));
    if (_not_1) {
      return false;
    } else {
      EClassifier _eType_1 = output.get(0).getFeature().getEType();
      _xifexpression_3 = ((EClass) _eType_1);
    }
    final EClass outputEClass = _xifexpression_3;
    for (final List<? extends ClassMatcher> matchers : matchersInputCorrs) {
      {
        if ((IterableExtensions.exists(matchers, ((Function1<ClassMatcher, Boolean>) (ClassMatcher it) -> {
          boolean _isGroup = it.getModifier().isGroup();
          return Boolean.valueOf((!_isGroup));
        })) && (input.get(0).getFeature().getUpperBound() == 1))) {
          return false;
        }
        final Function1<ClassMatcher, Boolean> _function_1 = (ClassMatcher it) -> {
          boolean _isSuperTypeOf = outputEClass.isSuperTypeOf(it.getClazz());
          return Boolean.valueOf((!_isSuperTypeOf));
        };
        boolean _exists = IterableExtensions.exists(matchers, _function_1);
        if (_exists) {
          return false;
        }
      }
    }
    return true;
  }
  
  private String compileToAssignmentSimple(final boolean srcToTrg, final FeatureMapping mapping) {
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    StringConcatenation _builder = new StringConcatenation();
    String _apply = (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).write.apply((((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.input, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).read.apply());
    _builder.append(_apply);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String compileToAssignmentSingleCorr(final boolean srcToTrg, final FeatureMapping mapping) {
    MappingFeature _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = mapping.getSrcFeatures().get(0);
    } else {
      _xifexpression = mapping.getTrgFeatures().get(0);
    }
    final MappingFeature input = _xifexpression;
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    StringConcatenation _builder = new StringConcatenation();
    String _ter = this.getter(input);
    _builder.append(_ter);
    _builder.append("?.corr?.assertRuleId(");
    final Function1<Correspondence, String> _function = (Correspondence it) -> {
      return it.getRule().getName();
    };
    final Function1<String, CharSequence> _function_1 = (String it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"");
      _builder_1.append(it);
      _builder_1.append("\"");
      return _builder_1.toString();
    };
    String _join = IterableExtensions.<String>join(ListExtensions.<Correspondence, String>map(input.getCorrs(), _function), ", ", _function_1);
    _builder.append(_join);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    final Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, String> _function_2 = (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
      return it.read.apply();
    };
    String _apply = (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).write.apply(IterableExtensions.join(IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter, String>map(preprocessed.input, _function_2), " else "));
    _builder.append(_apply);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String compileToAssignmentMultiCorr(final boolean srcToTrg, final FeatureMapping mapping, final IdentifierScope localScope) {
    MappingFeature _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = mapping.getSrcFeatures().get(0);
    } else {
      _xifexpression = mapping.getTrgFeatures().get(0);
    }
    final MappingFeature input = _xifexpression;
    final FeatureMappingCompiler.PreprocessedMapping preprocessed = this.preprocessFeatureMapping(srcToTrg, mapping);
    final String outputIdSuggestion = ("_" + (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).suggestedIdentifier);
    final String outputId = localScope.addIdentifier(outputIdSuggestion, IdentifierScope.Group.VARIABLE);
    final ArrayList<String> flatAccessExpressions = new ArrayList<String>();
    for (final FeatureMappingCompiler.PreprocessedMapping.Parameter preprocessedInput : preprocessed.input) {
      boolean _startsWith = preprocessedInput.javaType.startsWith("List<List<");
      if (_startsWith) {
        String _apply = preprocessedInput.read.apply();
        String _plus = (_apply + ".flatten()");
        flatAccessExpressions.add(_plus);
      } else {
        String _apply_1 = preprocessedInput.read.apply();
        flatAccessExpressions.add(_apply_1);
      }
    }
    this.neededImports.add("import java.util.List");
    StringConcatenation _builder = new StringConcatenation();
    {
      int _upperBound = input.getFeature().getUpperBound();
      boolean _equals = (_upperBound == 1);
      if (_equals) {
        String _ter = this.getter(input);
        _builder.append(_ter);
        _builder.append("?.corr?.assertRuleId(");
        final Function1<Correspondence, String> _function = (Correspondence it) -> {
          return it.getRule().getName();
        };
        final Function1<String, CharSequence> _function_1 = (String it) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\"");
          _builder_1.append(it);
          _builder_1.append("\"");
          return _builder_1.toString();
        };
        String _join = IterableExtensions.<String>join(ListExtensions.<Correspondence, String>map(input.getCorrs(), _function), ", ", _function_1);
        _builder.append(_join);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("val ");
        _builder.append((((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).javaType);
        _builder.append(" ");
        _builder.append(outputId);
        _builder.append(" = newArrayList()");
        _builder.newLineIfNotEmpty();
        {
          final Function1<FeatureMappingCompiler.PreprocessedMapping.Parameter, String> _function_2 = (FeatureMappingCompiler.PreprocessedMapping.Parameter it) -> {
            return it.read.apply();
          };
          Iterable<String> _map = IterableExtensions.<FeatureMappingCompiler.PreprocessedMapping.Parameter, String>map(preprocessed.input, _function_2);
          for(final String accessExpression : _map) {
            _builder.append(outputId);
            _builder.append(" += ");
            _builder.append(accessExpression);
            _builder.append(" ?: newArrayList()");
            _builder.newLineIfNotEmpty();
          }
        }
        String _apply_2 = (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).write.apply(outputId);
        _builder.append(_apply_2);
        _builder.newLineIfNotEmpty();
      } else {
        String _ter_1 = this.getter(input);
        _builder.append(_ter_1);
        _builder.append(".forEach[corr.assertRuleId(");
        final Function1<Correspondence, String> _function_3 = (Correspondence it) -> {
          return it.getRule().getName();
        };
        final Function1<String, CharSequence> _function_4 = (String it) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\"");
          _builder_1.append(it);
          _builder_1.append("\"");
          return _builder_1.toString();
        };
        String _join_1 = IterableExtensions.<String>join(ListExtensions.<Correspondence, String>map(input.getCorrs(), _function_3), ", ", _function_4);
        _builder.append(_join_1);
        _builder.append(")]");
        _builder.newLineIfNotEmpty();
        _builder.append("val ");
        _builder.append((((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).javaType);
        _builder.append(" ");
        _builder.append(outputId);
        _builder.append(" = newArrayList()");
        _builder.newLineIfNotEmpty();
        {
          for(final String flatAccessExpression : flatAccessExpressions) {
            _builder.append(outputId);
            _builder.append(" += ");
            _builder.append(flatAccessExpression);
            _builder.newLineIfNotEmpty();
          }
        }
        String _apply_3 = (((FeatureMappingCompiler.PreprocessedMapping.Parameter[])Conversions.unwrapArray(preprocessed.output, FeatureMappingCompiler.PreprocessedMapping.Parameter.class))[0]).write.apply(outputId);
        _builder.append(_apply_3);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Computes for all parameters of a mapping its java type, multiplicity,
   * a suggested identifier and an expression to access the parameter.
   */
  private FeatureMappingCompiler.PreprocessedMapping preprocessFeatureMapping(final boolean srcToTrg, final FeatureMapping mapping) {
    ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessedSrc = CollectionLiterals.<FeatureMappingCompiler.PreprocessedMapping.Parameter>newArrayList();
    if (srcToTrg) {
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesUpdater = this.preprocessClassesUpdater(IterableExtensions.<TrgClassMatcher>toList(Iterables.<TrgClassMatcher>filter(mapping.getTrgClasses(), TrgClassMatcher.class)));
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedSrc, _preprocessClassesUpdater);
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesPure = this.preprocessClassesPure(mapping.getSrcClasses());
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedSrc, _preprocessClassesPure);
    } else {
      final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
        return Boolean.valueOf((it.getModifier().isGroup() && (it instanceof SrcClassMatcher)));
      };
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesPure_1 = this.preprocessClassesPure(
        IterableExtensions.<ClassMatcher>toList(IterableExtensions.<ClassMatcher>filter(mapping.getSrcClasses(), _function)));
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedSrc, _preprocessClassesPure_1);
    }
    List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessFeatures = this.preprocessFeatures(mapping.getSrcFeatures(), srcToTrg);
    Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedSrc, _preprocessFeatures);
    ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessedTrg = CollectionLiterals.<FeatureMappingCompiler.PreprocessedMapping.Parameter>newArrayList();
    if ((!srcToTrg)) {
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesUpdater_1 = this.preprocessClassesUpdater(IterableExtensions.<SrcClassMatcher>toList(Iterables.<SrcClassMatcher>filter(mapping.getSrcClasses(), SrcClassMatcher.class)));
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedTrg, _preprocessClassesUpdater_1);
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesPure_2 = this.preprocessClassesPure(mapping.getTrgClasses());
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedTrg, _preprocessClassesPure_2);
    } else {
      final Function1<ClassMatcher, Boolean> _function_1 = (ClassMatcher it) -> {
        return Boolean.valueOf((it.getModifier().isGroup() && (it instanceof TrgClassMatcher)));
      };
      List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessClassesPure_3 = this.preprocessClassesPure(
        IterableExtensions.<ClassMatcher>toList(IterableExtensions.<ClassMatcher>filter(mapping.getTrgClasses(), _function_1)));
      Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedTrg, _preprocessClassesPure_3);
    }
    List<FeatureMappingCompiler.PreprocessedMapping.Parameter> _preprocessFeatures_1 = this.preprocessFeatures(mapping.getTrgFeatures(), (!srcToTrg));
    Iterables.<FeatureMappingCompiler.PreprocessedMapping.Parameter>addAll(preprocessedTrg, _preprocessFeatures_1);
    if (srcToTrg) {
      return new FeatureMappingCompiler.PreprocessedMapping(preprocessedSrc, preprocessedTrg);
    } else {
      return new FeatureMappingCompiler.PreprocessedMapping(preprocessedTrg, preprocessedSrc);
    }
  }
  
  private List<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessFeatures(final List<? extends MappingFeature> features, final boolean resolveCorrs) {
    ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessedFeatures = new ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter>();
    for (final MappingFeature rawFeature : features) {
      {
        final String classMatcher = this._utils.token(rawFeature).substring(0, this._utils.token(rawFeature).indexOf("."));
        int _upperBound = rawFeature.getFeature().getUpperBound();
        final boolean multi = (_upperBound != 1);
        if ((resolveCorrs && rawFeature.isCorr())) {
          EList<Correspondence> _corrs = rawFeature.getCorrs();
          for (final Correspondence corr : _corrs) {
            List<? extends ClassMatcher> _allMatchers = this.allMatchers(corr);
            for (final ClassMatcher matcher : _allMatchers) {
              {
                String type = this._utils.qualifiedType(matcher);
                if (multi) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("List<");
                  _builder.append(type);
                  _builder.append(">");
                  type = _builder.toString();
                }
                EObject _eContainer = rawFeature.eContainer().eContainer();
                final TransformationRule rule = ((TransformationRule) _eContainer);
                String _xifexpression = null;
                boolean _isNameAmbigious = this.isNameAmbigious(rawFeature.getFeature(), rule);
                if (_isNameAmbigious) {
                  _xifexpression = this._utils.token(rawFeature);
                } else {
                  _xifexpression = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(this._utils.token(rawFeature).split("\\."))));
                }
                String identifier = _xifexpression;
                String _identifier = identifier;
                String _xifexpression_1 = null;
                int _size = rawFeature.getCorrs().size();
                boolean _greaterThan = (_size > 1);
                if (_greaterThan) {
                  String _name = corr.getRule().getName();
                  _xifexpression_1 = ("." + _name);
                } else {
                  _xifexpression_1 = "";
                }
                identifier = (_identifier + _xifexpression_1);
                String _identifier_1 = identifier;
                String _name_1 = matcher.getName();
                String _plus = ("." + _name_1);
                identifier = (_identifier_1 + _plus);
                identifier = this.shortenIdentifier(identifier);
                String _xifexpression_2 = null;
                if ((rawFeature instanceof SrcMappingFeature)) {
                  _xifexpression_2 = "target";
                } else {
                  _xifexpression_2 = "source";
                }
                final String corrSide = _xifexpression_2;
                int _xifexpression_3 = (int) 0;
                if ((rawFeature instanceof SrcMappingFeature)) {
                  _xifexpression_3 = corr.getRule().getTrgMatcher().indexOf(matcher);
                } else {
                  _xifexpression_3 = corr.getRule().getSrcMatcher().indexOf(matcher);
                }
                final int index = _xifexpression_3;
                String _xifexpression_4 = null;
                boolean _isGroup = matcher.getModifier().isGroup();
                boolean _not = (!_isGroup);
                if (_not) {
                  _xifexpression_4 = "SingleElem";
                } else {
                  _xifexpression_4 = "MultiElem";
                }
                final String corrElem = _xifexpression_4;
                final String corrElemType = this._utils.qualifiedType(matcher);
                StringConcatenation _builder_1 = new StringConcatenation();
                {
                  if ((!multi)) {
                    _builder_1.append("if (");
                    String _ter = this.getter(rawFeature);
                    _builder_1.append(_ter);
                    _builder_1.append(" !== null && ");
                    String _ter_1 = this.getter(rawFeature);
                    _builder_1.append(_ter_1);
                    _builder_1.append(".corr.ruleId == \"");
                    String _name_2 = corr.getRule().getName();
                    _builder_1.append(_name_2);
                    _builder_1.append("\") {");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("\t");
                    _builder_1.append("unwrap(");
                    String _ter_2 = this.getter(rawFeature);
                    _builder_1.append(_ter_2, "\t");
                    _builder_1.append(".corr.");
                    _builder_1.append(corrSide, "\t");
                    _builder_1.append(".get(");
                    _builder_1.append(index, "\t");
                    _builder_1.append(") as ");
                    _builder_1.append(corrElem, "\t");
                    _builder_1.append(") as ");
                    _builder_1.append(corrElemType, "\t");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("}");
                  } else {
                    _builder_1.newLineIfNotEmpty();
                    String _ter_3 = this.getter(rawFeature);
                    _builder_1.append(_ter_3);
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("\t\t");
                    _builder_1.append(".filter[corr.ruleId == \"");
                    String _name_3 = corr.getRule().getName();
                    _builder_1.append(_name_3, "\t\t");
                    _builder_1.append("\"]");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("\t\t");
                    _builder_1.append(".map[unwrap(corr.");
                    _builder_1.append(corrSide, "\t\t");
                    _builder_1.append(".get(");
                    _builder_1.append(index, "\t\t");
                    _builder_1.append(") as ");
                    _builder_1.append(corrElem, "\t\t");
                    _builder_1.append(") as ");
                    _builder_1.append(corrElemType, "\t\t");
                    _builder_1.append("]");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("\t\t");
                    _builder_1.append(".toList()");
                  }
                }
                final String access = _builder_1.toString();
                final Function0<String> _function = () -> {
                  return access;
                };
                final Function1<String, String> _function_1 = (String it) -> {
                  throw new UnsupportedOperationException(
                    "A resolved corr mapping feature can only be used as input of a mapping!");
                };
                FeatureMappingCompiler.PreprocessedMapping.Parameter _parameter = new FeatureMappingCompiler.PreprocessedMapping.Parameter(classMatcher, type, identifier, _function, _function_1);
                preprocessedFeatures.add(_parameter);
              }
            }
          }
        } else {
          if ((((!resolveCorrs) && rawFeature.isCorr()) && IterableExtensions.exists(features, ((Function1<MappingFeature, Boolean>) (MappingFeature it) -> {
            return Boolean.valueOf((Objects.equal(it.getFeature(), rawFeature.getFeature()) && (!it.isCorr())));
          })))) {
          } else {
            String type = this.featureType(rawFeature.getFeature());
            if (multi) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("List<");
              _builder.append(type);
              _builder.append(">");
              type = _builder.toString();
            }
            EObject _eContainer = rawFeature.eContainer().eContainer();
            final TransformationRule rule = ((TransformationRule) _eContainer);
            String _xifexpression = null;
            boolean _isNameAmbigious = this.isNameAmbigious(rawFeature.getFeature(), rule);
            if (_isNameAmbigious) {
              _xifexpression = this.shortenIdentifier(this._utils.token(rawFeature));
            } else {
              _xifexpression = this.shortenIdentifier(IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(this._utils.token(rawFeature).split("\\.")))));
            }
            final String identifier = _xifexpression;
            final Function0<String> _function = () -> {
              return this.getter(rawFeature);
            };
            Function1<String, String> _xifexpression_1 = null;
            boolean _startsWith = type.startsWith("List<");
            boolean _not = (!_startsWith);
            if (_not) {
              final Function1<String, String> _function_1 = (String value) -> {
                return this.setter(rawFeature, value);
              };
              _xifexpression_1 = _function_1;
            } else {
              final Function1<String, String> _function_2 = (String value) -> {
                StringConcatenation _builder_1 = new StringConcatenation();
                String _ter = this.getter(rawFeature);
                _builder_1.append(_ter);
                _builder_1.append(".clear()");
                _builder_1.newLineIfNotEmpty();
                String _ter_1 = this.getter(rawFeature);
                _builder_1.append(_ter_1);
                _builder_1.append(".addAll(");
                _builder_1.append(value);
                _builder_1.append(")");
                _builder_1.newLineIfNotEmpty();
                return _builder_1.toString();
              };
              _xifexpression_1 = _function_2;
            }
            FeatureMappingCompiler.PreprocessedMapping.Parameter _parameter = new FeatureMappingCompiler.PreprocessedMapping.Parameter(classMatcher, type, identifier, _function, _xifexpression_1);
            preprocessedFeatures.add(_parameter);
          }
        }
      }
    }
    return preprocessedFeatures;
  }
  
  private List<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessClassesPure(final List<ClassMatcher> classes) {
    ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessedClasses = new ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter>();
    for (final ClassMatcher class_ : classes) {
      {
        final String clazz = this._utils.qualifiedName(class_.getClazz());
        String _xifexpression = null;
        boolean _isGroup = class_.getModifier().isGroup();
        boolean _not = (!_isGroup);
        if (_not) {
          _xifexpression = clazz;
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("List<");
          _builder.append(clazz);
          _builder.append(">");
          _xifexpression = _builder.toString();
        }
        final String type = _xifexpression;
        final String id = this.prefixKeyword(class_.getName());
        String _name = class_.getName();
        final Function0<String> _function = () -> {
          return class_.getName();
        };
        Function1<String, String> _xifexpression_1 = null;
        boolean _startsWith = type.startsWith("List<");
        boolean _not_1 = (!_startsWith);
        if (_not_1) {
          final Function1<String, String> _function_1 = (String it) -> {
            throw new UnsupportedOperationException(
              "A not grouped pure class can only be used as input of a mapping!");
          };
          _xifexpression_1 = _function_1;
        } else {
          final Function1<String, String> _function_2 = (String value) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name_1 = class_.getName();
            _builder_1.append(_name_1);
            _builder_1.append(".clear()");
            _builder_1.newLineIfNotEmpty();
            String _name_2 = class_.getName();
            _builder_1.append(_name_2);
            _builder_1.append(".addAll(");
            _builder_1.append(value);
            _builder_1.append(")");
            _builder_1.newLineIfNotEmpty();
            return _builder_1.toString();
          };
          _xifexpression_1 = _function_2;
        }
        FeatureMappingCompiler.PreprocessedMapping.Parameter _parameter = new FeatureMappingCompiler.PreprocessedMapping.Parameter(_name, type, id, _function, _xifexpression_1);
        preprocessedClasses.add(_parameter);
      }
    }
    return preprocessedClasses;
  }
  
  private List<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessClassesUpdater(final List<? extends ClassMatcher> classes) {
    ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter> preprocessedClasses = new ArrayList<FeatureMappingCompiler.PreprocessedMapping.Parameter>();
    final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
      return Boolean.valueOf(it.getModifier().isGroup());
    };
    Iterable<? extends ClassMatcher> _filter = IterableExtensions.filter(classes, _function);
    for (final ClassMatcher class_ : _filter) {
      {
        String _xifexpression = null;
        if ((class_ instanceof SrcClassMatcher)) {
          _xifexpression = "SrcMultiElemUpdater";
        } else {
          _xifexpression = "TrgMultiElemUpdater";
        }
        final String updater = _xifexpression;
        final String clazz = this._utils.qualifiedName(class_.getClazz());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(updater);
        _builder.append("<");
        _builder.append(clazz);
        _builder.append(">");
        final String updaterType = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name = class_.getName();
        _builder_1.append(_name);
        _builder_1.append("Updater");
        final String updaterId = this.prefixKeyword(_builder_1.toString());
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("new ");
        _builder_2.append(updater);
        _builder_2.append("<");
        _builder_2.append(clazz);
        _builder_2.append(">(");
        String _name_1 = class_.getName();
        _builder_2.append(_name_1);
        _builder_2.append(", \"");
        String _name_2 = class_.getClazz().getName();
        _builder_2.append(_name_2);
        _builder_2.append("\", this,  _corr)");
        final String updaterAccess = _builder_2.toString();
        String _name_3 = class_.getName();
        final Function0<String> _function_1 = () -> {
          return updaterAccess;
        };
        final Function1<String, String> _function_2 = (String it) -> {
          throw new UnsupportedOperationException("An Updater can only be used as input of a mapping!");
        };
        FeatureMappingCompiler.PreprocessedMapping.Parameter _parameter = new FeatureMappingCompiler.PreprocessedMapping.Parameter(_name_3, updaterType, updaterId, _function_1, _function_2);
        preprocessedClasses.add(_parameter);
      }
    }
    return preprocessedClasses;
  }
  
  private String featureType(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      String _switchResult = null;
      boolean _matched = false;
      if (feature instanceof EAttribute) {
        _matched=true;
        String _xifexpression = null;
        EClassifier _eType = ((EAttribute)feature).getEType();
        if ((_eType instanceof EEnum)) {
          _xifexpression = this._utils.qualifiedName(((EAttribute)feature).getEType());
        } else {
          _xifexpression = ((EAttribute)feature).getEType().getInstanceTypeName();
        }
        _switchResult = _xifexpression;
      }
      if (!_matched) {
        if (feature instanceof EReference) {
          _matched=true;
          _switchResult = this._utils.qualifiedName(((EReference)feature).getEType());
        }
      }
      if (!_matched) {
        throw new AssertionError("EStructuralFeature should be EAttribute or EReference!");
      }
      String type = _switchResult;
      _xblockexpression = type = type.replaceFirst("\\Ajava.lang.", "");
    }
    return _xblockexpression;
  }
  
  private String shortenIdentifier(final String token) {
    final String[] tokenSegments = token.split("\\.");
    String identifier = "";
    for (int i = 0; (i < tokenSegments.length); i++) {
      {
        String segment = tokenSegments[i];
        int _length = tokenSegments.length;
        int _minus = (_length - 1);
        boolean _lessThan = (i < _minus);
        if (_lessThan) {
          segment = segment.substring(0, Math.min(3, segment.length()));
        }
        if (((i == 0) && (!segment.isEmpty()))) {
          String _identifier = identifier;
          char _lowerCase = Character.toLowerCase(segment.charAt(0));
          String _substring = segment.substring(1);
          String _plus = (Character.valueOf(_lowerCase) + _substring);
          identifier = (_identifier + _plus);
        } else {
          boolean _isEmpty = segment.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            String _identifier_1 = identifier;
            char _upperCase = Character.toUpperCase(segment.charAt(0));
            String _substring_1 = segment.substring(1);
            String _plus_1 = (Character.valueOf(_upperCase) + _substring_1);
            identifier = (_identifier_1 + _plus_1);
          }
        }
      }
    }
    return this.prefixKeyword(identifier);
  }
  
  /**
   * Prefixes the given keyword with an 'x', if it is an Xtend keyword.
   */
  private String prefixKeyword(final String keyword) {
    boolean _isXtendKeyword = this._utils.isXtendKeyword(keyword);
    if (_isXtendKeyword) {
      String _firstUpper = StringExtensions.toFirstUpper(keyword);
      return ("x" + _firstUpper);
    } else {
      return keyword;
    }
  }
  
  private String getter(final MappingFeature feature) {
    String _xifexpression = null;
    if ((feature instanceof SrcMappingFeature)) {
      _xifexpression = "src";
    } else {
      _xifexpression = "trg";
    }
    final String model = _xifexpression;
    final String[] segments = this._utils.token(feature).split("\\.");
    final String classMatcher = segments[0];
    final String structuralFeature = segments[1];
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(model);
    _builder.append(">get>");
    String _name = feature.getFeature().getEContainingClass().getName();
    _builder.append(_name);
    _builder.append(".");
    _builder.append(structuralFeature);
    final String featureProperty = _builder.toString();
    String _xifexpression_1 = null;
    boolean _contains = this.modelsProperties.stringPropertyNames().contains(featureProperty);
    if (_contains) {
      _xifexpression_1 = this.modelsProperties.getProperty(featureProperty);
    } else {
      String _xifexpression_2 = null;
      EClassifier _eType = feature.getFeature().getEType();
      boolean _equals = Objects.equal(_eType, EcorePackage.Literals.EBOOLEAN);
      if (_equals) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("is");
        String _firstUpper = StringExtensions.toFirstUpper(structuralFeature);
        _builder_1.append(_firstUpper);
        _xifexpression_2 = _builder_1.toString();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(structuralFeature);
        _builder_2.append(_firstUpper_1);
        _xifexpression_2 = _builder_2.toString();
      }
      _xifexpression_1 = _xifexpression_2;
    }
    final String featureAccess = _xifexpression_1;
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(classMatcher);
    _builder_3.append(".");
    _builder_3.append(featureAccess);
    _builder_3.append("()");
    return _builder_3.toString();
  }
  
  private String setter(final MappingFeature feature, final String value) {
    String _xifexpression = null;
    if ((feature instanceof SrcMappingFeature)) {
      _xifexpression = "src";
    } else {
      _xifexpression = "trg";
    }
    final String model = _xifexpression;
    final String[] segments = this._utils.token(feature).split("\\.");
    final String classMatcher = segments[0];
    final String structuralFeature = segments[1];
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(model);
    _builder.append(">set>");
    String _name = feature.getFeature().getEContainingClass().getName();
    _builder.append(_name);
    _builder.append(".");
    _builder.append(structuralFeature);
    final String featureProperty = _builder.toString();
    String _xifexpression_1 = null;
    boolean _contains = this.modelsProperties.stringPropertyNames().contains(featureProperty);
    if (_contains) {
      _xifexpression_1 = this.modelsProperties.getProperty(featureProperty);
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("set");
      String _firstUpper = StringExtensions.toFirstUpper(structuralFeature);
      _builder_1.append(_firstUpper);
      _xifexpression_1 = _builder_1.toString();
    }
    final String featureAccess = _xifexpression_1;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(classMatcher);
    _builder_2.append(".");
    _builder_2.append(featureAccess);
    _builder_2.append("(");
    _builder_2.append(value);
    _builder_2.append(")");
    return _builder_2.toString();
  }
  
  private boolean isNameAmbigious(final EStructuralFeature feature, final TransformationRule rule) {
    boolean _xblockexpression = false;
    {
      final ArrayList<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
      final Function1<SrcClassMatcher, EList<EStructuralFeature>> _function = (SrcClassMatcher it) -> {
        return it.getClazz().getEAllStructuralFeatures();
      };
      Iterable<EStructuralFeature> _flatten = Iterables.<EStructuralFeature>concat(ListExtensions.<SrcClassMatcher, EList<EStructuralFeature>>map(rule.getSrcMatcher(), _function));
      Iterables.<EStructuralFeature>addAll(features, _flatten);
      final Function1<TrgClassMatcher, EList<EStructuralFeature>> _function_1 = (TrgClassMatcher it) -> {
        return it.getClazz().getEAllStructuralFeatures();
      };
      Iterable<EStructuralFeature> _flatten_1 = Iterables.<EStructuralFeature>concat(ListExtensions.<TrgClassMatcher, EList<EStructuralFeature>>map(rule.getTrgMatcher(), _function_1));
      Iterables.<EStructuralFeature>addAll(features, _flatten_1);
      final Function1<EStructuralFeature, Boolean> _function_2 = (EStructuralFeature it) -> {
        String _name = it.getName();
        String _name_1 = feature.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<EStructuralFeature>filter(features, _function_2), Object.class)).length;
      _xblockexpression = (_length > 1);
    }
    return _xblockexpression;
  }
  
  private List<? extends ClassMatcher> allMatchers(final Correspondence corr) {
    boolean _isEmpty = corr.getMatchers().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return corr.getMatchers();
    } else {
      EObject _eContainer = corr.eContainer();
      if ((_eContainer instanceof SrcMappingFeature)) {
        return corr.getRule().getTrgMatcher();
      } else {
        EObject _eContainer_1 = corr.eContainer();
        if ((_eContainer_1 instanceof TrgMappingFeature)) {
          return corr.getRule().getSrcMatcher();
        } else {
          final String message = "The container of a Correspondence should be SrcMappingFeature or TrgMappingFeature!";
          throw new AssertionError(message);
        }
      }
    }
  }
}
