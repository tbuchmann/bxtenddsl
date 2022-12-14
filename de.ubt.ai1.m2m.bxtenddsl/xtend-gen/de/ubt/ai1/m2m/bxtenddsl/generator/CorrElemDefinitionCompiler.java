package de.ubt.ai1.m2m.bxtenddsl.generator;

import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * A compiler for correspondence model element definitions.
 */
@SuppressWarnings("all")
public class CorrElemDefinitionCompiler extends de.ubt.ai1.m2m.bxtenddsl.generator.Compiler {
  /**
   * Compiles all correspondence model element definitions needed for the given matchers in the direction srcToTrg.
   */
  public String compile(final boolean srcToTrg, final List<? extends ClassMatcher> relSrcMatcher, final List<? extends ClassMatcher> relTrgMatcher, final List<? extends ClassMatcher> usedRelTrgMatcher, final IdentifierScope localScope) {
    String _xifexpression = null;
    if (srcToTrg) {
      _xifexpression = "updateOrCreateCorrSrc";
    } else {
      _xifexpression = "updateOrCreateCorrTrg";
    }
    final String corrMethod = _xifexpression;
    String _xifexpression_1 = null;
    if (srcToTrg) {
      _xifexpression_1 = "getOrCreateTrg";
    } else {
      _xifexpression_1 = "getOrCreateSrc";
    }
    final String corrElemMethod = _xifexpression_1;
    String _xifexpression_2 = null;
    if (srcToTrg) {
      _xifexpression_2 = "_trg";
    } else {
      _xifexpression_2 = "_src";
    }
    final String relTrgSuggestion = _xifexpression_2;
    for (final ClassMatcher matcher : relTrgMatcher) {
      localScope.addIdentifier(matcher.getName(), IdentifierScope.Group.VARIABLE);
    }
    final String corr = localScope.addIdentifier("_corr", IdentifierScope.Group.VARIABLE);
    final Function1<ClassMatcher, String> _function = (ClassMatcher it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("wrap(");
      String _name = it.getName();
      _builder.append(_name);
      _builder.append(")");
      return _builder.toString();
    };
    final String additionalRelSrcElems = IterableExtensions.join(ListExtensions.map(relSrcMatcher.subList(1, relSrcMatcher.size()), _function), ", ");
    ArrayList<String> typeIds = new ArrayList<String>();
    ArrayList<String> types = new ArrayList<String>();
    for (final ClassMatcher matcher_1 : relTrgMatcher) {
      {
        String _name = matcher_1.getName();
        String _plus = ("_" + _name);
        String _plus_1 = (_plus + "Type");
        final String typeId = localScope.addIdentifier(_plus_1, IdentifierScope.Group.VARIABLE);
        typeIds.add(typeId);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("val ");
        _builder.append(typeId);
        _builder.append(" = new CorrElemType(\"");
        String _name_1 = matcher_1.getClazz().getName();
        _builder.append(_name_1);
        _builder.append("\", ");
        boolean _isGroup = matcher_1.getModifier().isGroup();
        _builder.append(_isGroup);
        _builder.append(")");
        types.add(_builder.toString());
      }
    }
    final String relTrg = localScope.addIdentifier(relTrgSuggestion, IdentifierScope.Group.VARIABLE);
    ArrayList<String> relTrgElements = new ArrayList<String>();
    for (int i = 0; (i < usedRelTrgMatcher.size()); i++) {
      {
        String _xifexpression_3 = null;
        boolean _isGroup = usedRelTrgMatcher.get(i).getModifier().isGroup();
        boolean _not = (!_isGroup);
        if (_not) {
          String _xblockexpression = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("import *rootPackage.corrmodel.SingleElem");
            this.neededImports.add(_builder.toString());
            _xblockexpression = "SingleElem";
          }
          _xifexpression_3 = _xblockexpression;
        } else {
          String _xblockexpression_1 = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("import *rootPackage.corrmodel.MultiElem");
            this.neededImports.add(_builder.toString());
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("import java.util.List");
            this.neededImports.add(_builder_1.toString());
            _xblockexpression_1 = "MultiElem";
          }
          _xifexpression_3 = _xblockexpression_1;
        }
        final String corrElemClass = _xifexpression_3;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("val ");
        String _name = usedRelTrgMatcher.get(i).getName();
        _builder.append(_name);
        _builder.append(" = unwrap(");
        _builder.append(relTrg);
        _builder.append(".get(");
        _builder.append(i);
        _builder.append(") as ");
        _builder.append(corrElemClass);
        _builder.append(")");
        _builder.append(" as ");
        String _qualifiedType = this._utils.qualifiedType(usedRelTrgMatcher.get(i));
        _builder.append(_qualifiedType);
        relTrgElements.add(_builder.toString());
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ");
    _builder.append(corr);
    _builder.append(" = wrap(");
    String _name = relSrcMatcher.get(0).getName();
    _builder.append(_name);
    _builder.append(").");
    _builder.append(corrMethod);
    _builder.append("(");
    _builder.append(additionalRelSrcElems);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final String type : types) {
        _builder.append(type);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isEmpty = relTrgElements.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("val ");
        _builder.append(relTrg);
        _builder.append(" = ");
      }
    }
    _builder.append(corr);
    _builder.append(".");
    _builder.append(corrElemMethod);
    _builder.append("(");
    String _join = IterableExtensions.join(typeIds, ", ");
    _builder.append(_join);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final String relTrgElement : relTrgElements) {
        _builder.append(relTrgElement);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  @Inject
  @Extension
  private Utils _utils;
}
