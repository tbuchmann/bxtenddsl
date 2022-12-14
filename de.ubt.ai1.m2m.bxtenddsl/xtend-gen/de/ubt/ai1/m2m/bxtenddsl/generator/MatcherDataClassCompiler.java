package de.ubt.ai1.m2m.bxtenddsl.generator;

import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Compiler that generates a data class for all source and all target matcher of a rule.
 */
@SuppressWarnings("all")
public class MatcherDataClassCompiler extends de.ubt.ai1.m2m.bxtenddsl.generator.Compiler {
  /**
   * Compiles a Source and a Target data class from srcMatcher/trgMatcher. Also generates methods to create a
   * Source/Target instance from a correspondence.
   */
  public String compile(final List<SrcClassMatcher> srcMatcher, final List<TrgClassMatcher> trgMatcher, final IdentifierScope ruleScope) {
    this.neededImports.add("import org.eclipse.xtend.lib.annotations.Data");
    if ((IterableExtensions.<SrcClassMatcher>exists(srcMatcher, ((Function1<SrcClassMatcher, Boolean>) (SrcClassMatcher it) -> {
      return Boolean.valueOf(it.getModifier().isGroup());
    })) || IterableExtensions.<TrgClassMatcher>exists(trgMatcher, ((Function1<TrgClassMatcher, Boolean>) (TrgClassMatcher it) -> {
      return Boolean.valueOf(it.getModifier().isGroup());
    })))) {
      this.neededImports.add("import java.util.List");
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import *rootPackage.corrmodel.Corr");
    this.neededImports.add(_builder.toString());
    ruleScope.addIdentifier("Source", IdentifierScope.Group.CLASS);
    ruleScope.addIdentifier("source", IdentifierScope.Group.METHOD);
    ruleScope.addIdentifier("Target", IdentifierScope.Group.CLASS);
    ruleScope.addIdentifier("target", IdentifierScope.Group.METHOD);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Data protected static class Source {");
    _builder_1.newLine();
    {
      for(final SrcClassMatcher matcher : srcMatcher) {
        _builder_1.append("\t");
        String _qualifiedType = this._utils.qualifiedType(matcher);
        _builder_1.append(_qualifiedType, "\t");
        _builder_1.append(" ");
        String _name = matcher.getName();
        _builder_1.append(_name, "\t");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("def protected static Source source(Corr _corr) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("_corr.assertRuleId(\"");
    EObject _eContainer = srcMatcher.get(0).eContainer();
    String _name_1 = ((TransformationRule) _eContainer).getName();
    _builder_1.append(_name_1, "\t");
    _builder_1.append("\")");
    _builder_1.newLineIfNotEmpty();
    {
      for(final SrcClassMatcher matcher_1 : srcMatcher) {
        _builder_1.append("\t");
        _builder_1.append("val ");
        String _name_2 = matcher_1.getName();
        _builder_1.append(_name_2, "\t");
        _builder_1.append(" = unwrap(_corr.source.get(");
        int _indexOf = srcMatcher.indexOf(matcher_1);
        _builder_1.append(_indexOf, "\t");
        _builder_1.append(")) as ");
        String _qualifiedType_1 = this._utils.qualifiedType(matcher_1);
        _builder_1.append(_qualifiedType_1, "\t");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("\t");
    _builder_1.append("return new Source(");
    final Function1<SrcClassMatcher, String> _function = (SrcClassMatcher it) -> {
      return it.getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<SrcClassMatcher, String>map(srcMatcher, _function), ", ");
    _builder_1.append(_join, "\t");
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("@Data protected static class Target {");
    _builder_1.newLine();
    {
      for(final TrgClassMatcher matcher_2 : trgMatcher) {
        _builder_1.append("\t");
        String _qualifiedType_2 = this._utils.qualifiedType(matcher_2);
        _builder_1.append(_qualifiedType_2, "\t");
        _builder_1.append(" ");
        String _name_3 = matcher_2.getName();
        _builder_1.append(_name_3, "\t");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("def protected static Target target(Corr _corr) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("_corr.assertRuleId(\"");
    EObject _eContainer_1 = trgMatcher.get(0).eContainer();
    String _name_4 = ((TransformationRule) _eContainer_1).getName();
    _builder_1.append(_name_4, "\t");
    _builder_1.append("\")");
    _builder_1.newLineIfNotEmpty();
    {
      for(final TrgClassMatcher matcher_3 : trgMatcher) {
        _builder_1.append("\t");
        _builder_1.append("val ");
        String _name_5 = matcher_3.getName();
        _builder_1.append(_name_5, "\t");
        _builder_1.append(" = unwrap(_corr.target.get(");
        int _indexOf_1 = trgMatcher.indexOf(matcher_3);
        _builder_1.append(_indexOf_1, "\t");
        _builder_1.append(")) as ");
        String _qualifiedType_3 = this._utils.qualifiedType(matcher_3);
        _builder_1.append(_qualifiedType_3, "\t");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("\t");
    _builder_1.append("return new Target(");
    final Function1<TrgClassMatcher, String> _function_1 = (TrgClassMatcher it) -> {
      return it.getName();
    };
    String _join_1 = IterableExtensions.join(ListExtensions.<TrgClassMatcher, String>map(trgMatcher, _function_1), ", ");
    _builder_1.append(_join_1, "\t");
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    return _builder_1.toString();
  }
  
  @Inject
  @Extension
  private Utils _utils;
}
