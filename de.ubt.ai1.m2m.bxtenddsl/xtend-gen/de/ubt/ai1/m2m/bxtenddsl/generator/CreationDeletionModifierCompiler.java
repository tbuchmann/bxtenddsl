package de.ubt.ai1.m2m.bxtenddsl.generator;

import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A compiler for creation and deletion modifier.
 */
@SuppressWarnings("all")
public class CreationDeletionModifierCompiler {
  /**
   * Compiles all selected creation and deletion modifiers of the given transformation rule.
   */
  public String compile(final boolean srcModifiers, final boolean trgModifiers, final TransformationRule rule, final IdentifierScope ruleScope) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (srcModifiers) {
        String _compileModifier = this.compileModifier(true, true, rule, ruleScope);
        _builder.append(_compileModifier);
        _builder.newLineIfNotEmpty();
        String _compileModifier_1 = this.compileModifier(true, false, rule, ruleScope);
        _builder.append(_compileModifier_1);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if (trgModifiers) {
        String _compileModifier_2 = this.compileModifier(false, true, rule, ruleScope);
        _builder.append(_compileModifier_2);
        _builder.newLineIfNotEmpty();
        String _compileModifier_3 = this.compileModifier(false, false, rule, ruleScope);
        _builder.append(_compileModifier_3);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Returns if the compilation of this rule contains any abstract method.
   */
  public boolean anyAbstractMethod(final boolean srcModifiers, final boolean trgModifiers, final TransformationRule rule) {
    return ((((srcModifiers && this.anyModifierSet(true, true, rule)) || (trgModifiers && this.anyModifierSet(false, true, rule))) || (srcModifiers && this.anyModifierSet(true, false, rule))) || (trgModifiers && this.anyModifierSet(false, false, rule)));
  }
  
  /**
   * Returns all imports that the compilation of this rule needs.
   */
  public Set<String> neededImports(final boolean srcModifiers, final boolean trgModifiers, final TransformationRule rule) {
    HashSet<String> imports = new HashSet<String>();
    if (((((srcModifiers && this.anyModifierSet(true, true, rule)) || (trgModifiers && this.anyModifierSet(false, true, rule))) || (srcModifiers && this.anyModifierSet(true, false, rule))) || (trgModifiers && this.anyModifierSet(false, false, rule)))) {
      imports.add("import org.eclipse.emf.ecore.EObject");
    }
    return imports;
  }
  
  @Inject
  @Extension
  private Utils _utils;
  
  private boolean anyModifierSet(final boolean srcModifier, final boolean creation, final TransformationRule rule) {
    EList<? extends ClassMatcher> _xifexpression = null;
    if (srcModifier) {
      _xifexpression = rule.getSrcMatcher();
    } else {
      _xifexpression = rule.getTrgMatcher();
    }
    final EList<? extends ClassMatcher> matcher = _xifexpression;
    if (creation) {
      final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
        return Boolean.valueOf(it.getModifier().isCreation());
      };
      return IterableExtensions.exists(matcher, _function);
    } else {
      final Function1<ClassMatcher, Boolean> _function_1 = (ClassMatcher it) -> {
        return Boolean.valueOf(it.getModifier().isDeletion());
      };
      return IterableExtensions.exists(matcher, _function_1);
    }
  }
  
  private String compileModifier(final boolean srcModifier, final boolean creation, final TransformationRule rule, final IdentifierScope ruleScope) {
    boolean _anyModifierSet = this.anyModifierSet(srcModifier, creation, rule);
    boolean _not = (!_anyModifierSet);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      return _builder.toString();
    }
    EList<? extends ClassMatcher> _xifexpression = null;
    if (srcModifier) {
      _xifexpression = rule.getSrcMatcher();
    } else {
      _xifexpression = rule.getTrgMatcher();
    }
    final EList<? extends ClassMatcher> matcher = _xifexpression;
    String _xifexpression_1 = null;
    if (creation) {
      _xifexpression_1 = "Creation";
    } else {
      _xifexpression_1 = "Deletion";
    }
    final String action = _xifexpression_1;
    String _xifexpression_2 = null;
    if (creation) {
      String _xifexpression_3 = null;
      if (srcModifier) {
        _xifexpression_3 = "onSrcElemCreation";
      } else {
        _xifexpression_3 = "onTrgElemCreation";
      }
      _xifexpression_2 = _xifexpression_3;
    } else {
      String _xifexpression_4 = null;
      if (srcModifier) {
        _xifexpression_4 = "onSrcElemDeletion";
      } else {
        _xifexpression_4 = "onTrgElemDeletion";
      }
      _xifexpression_2 = _xifexpression_4;
    }
    final String overrideId = _xifexpression_2;
    String _xifexpression_5 = null;
    if (srcModifier) {
      _xifexpression_5 = "srcElem";
    } else {
      _xifexpression_5 = "trgElem";
    }
    final String overrideParam = _xifexpression_5;
    ArrayList<String> hooks = new ArrayList<String>();
    ArrayList<String> hookCalls = new ArrayList<String>();
    for (int i = 0; (i < matcher.size()); i++) {
      {
        final ClassMatcher current = matcher.get(i);
        if (((creation && current.getModifier().isCreation()) || ((!creation) && current.getModifier().isDeletion()))) {
          String _xifexpression_6 = null;
          boolean _isGroup = current.getModifier().isGroup();
          boolean _not_1 = (!_isGroup);
          if (_not_1) {
            _xifexpression_6 = current.getName();
          } else {
            String _name = current.getName();
            _xifexpression_6 = (_name + "Elem");
          }
          final String currentId = _xifexpression_6;
          String _firstUpper = StringExtensions.toFirstUpper(currentId);
          String _plus = ("on" + _firstUpper);
          final String hookIdSuggestion = (_plus + action);
          final String hookId = ruleScope.addIdentifier(hookIdSuggestion, IdentifierScope.Group.METHOD);
          String _qualifiedName = this._utils.qualifiedName(current.getClazz());
          String _plus_1 = (_qualifiedName + " ");
          final String hookParam = (_plus_1 + currentId);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("def protected abstract void ");
          _builder_1.append(hookId);
          _builder_1.append("(");
          _builder_1.append(hookParam);
          _builder_1.append(");");
          hooks.add(_builder_1.toString());
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("case ");
          _builder_2.append(i);
          _builder_2.append(": ");
          _builder_2.append(hookId);
          _builder_2.append("(");
          _builder_2.append(overrideParam);
          _builder_2.append(" as ");
          String _qualifiedName_1 = this._utils.qualifiedName(current.getClazz());
          _builder_2.append(_qualifiedName_1);
          _builder_2.append(")");
          hookCalls.add(_builder_2.toString());
        }
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.newLine();
    _builder_1.append("override void ");
    _builder_1.append(overrideId);
    _builder_1.append("(EObject ");
    _builder_1.append(overrideParam);
    _builder_1.append(") {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("switch (");
    _builder_1.append(overrideParam, "\t");
    _builder_1.append(".corrElemPosition) {");
    _builder_1.newLineIfNotEmpty();
    {
      for(final String call : hookCalls) {
        _builder_1.append("\t\t");
        _builder_1.append(call, "\t\t");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    {
      for(final String hook : hooks) {
        _builder_1.append(hook);
        _builder_1.newLineIfNotEmpty();
      }
    }
    return _builder_1.toString();
  }
}
