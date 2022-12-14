package de.ubt.ai1.m2m.bxtenddsl.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A compiler for class matcher modifier. The creation and deletion modifier are compiled by
 * the CreationDeletionModifierCompiler.
 */
@SuppressWarnings("all")
public class ClassMatcherModifierCompiler {
  @Data
  public static class Group {
    private final String definitions;
    
    private final Collection<String> keyFunctions;
    
    private final Map<ClassMatcher, String> matcherToGroupsId;
    
    public Group(final String definitions, final Collection<String> keyFunctions, final Map<ClassMatcher, String> matcherToGroupsId) {
      super();
      this.definitions = definitions;
      this.keyFunctions = keyFunctions;
      this.matcherToGroupsId = matcherToGroupsId;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.definitions== null) ? 0 : this.definitions.hashCode());
      result = prime * result + ((this.keyFunctions== null) ? 0 : this.keyFunctions.hashCode());
      return prime * result + ((this.matcherToGroupsId== null) ? 0 : this.matcherToGroupsId.hashCode());
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
      ClassMatcherModifierCompiler.Group other = (ClassMatcherModifierCompiler.Group) obj;
      if (this.definitions == null) {
        if (other.definitions != null)
          return false;
      } else if (!this.definitions.equals(other.definitions))
        return false;
      if (this.keyFunctions == null) {
        if (other.keyFunctions != null)
          return false;
      } else if (!this.keyFunctions.equals(other.keyFunctions))
        return false;
      if (this.matcherToGroupsId == null) {
        if (other.matcherToGroupsId != null)
          return false;
      } else if (!this.matcherToGroupsId.equals(other.matcherToGroupsId))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("definitions", this.definitions);
      b.add("keyFunctions", this.keyFunctions);
      b.add("matcherToGroupsId", this.matcherToGroupsId);
      return b.toString();
    }
    
    @Pure
    public String getDefinitions() {
      return this.definitions;
    }
    
    @Pure
    public Collection<String> getKeyFunctions() {
      return this.keyFunctions;
    }
    
    @Pure
    public Map<ClassMatcher, String> getMatcherToGroupsId() {
      return this.matcherToGroupsId;
    }
  }
  
  @Data
  public static class Filter {
    private final String call;
    
    private final String filter;
    
    public Filter(final String call, final String filter) {
      super();
      this.call = call;
      this.filter = filter;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.call== null) ? 0 : this.call.hashCode());
      return prime * result + ((this.filter== null) ? 0 : this.filter.hashCode());
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
      ClassMatcherModifierCompiler.Filter other = (ClassMatcherModifierCompiler.Filter) obj;
      if (this.call == null) {
        if (other.call != null)
          return false;
      } else if (!this.call.equals(other.call))
        return false;
      if (this.filter == null) {
        if (other.filter != null)
          return false;
      } else if (!this.filter.equals(other.filter))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("call", this.call);
      b.add("filter", this.filter);
      return b.toString();
    }
    
    @Pure
    public String getCall() {
      return this.call;
    }
    
    @Pure
    public String getFilter() {
      return this.filter;
    }
  }
  
  /**
   * Compiles all group modifiers of the given matchers.
   */
  public ClassMatcherModifierCompiler.Group compileGroupModifier(final List<? extends ClassMatcher> matcher, final IdentifierScope ruleScope, final IdentifierScope localScope) {
    String _xifexpression = null;
    ClassMatcher _get = matcher.get(0);
    if ((_get instanceof SrcClassMatcher)) {
      _xifexpression = "sourceModel";
    } else {
      _xifexpression = "targetModel";
    }
    final String model = _xifexpression;
    ArrayList<String> definitions = new ArrayList<String>();
    ArrayList<String> keyFunctions = new ArrayList<String>();
    HashMap<ClassMatcher, String> matcherToGroupsId = new HashMap<ClassMatcher, String>();
    final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
      return Boolean.valueOf(it.getModifier().isGroup());
    };
    Iterable<? extends ClassMatcher> _filter = IterableExtensions.filter(matcher, _function);
    for (final ClassMatcher e : _filter) {
      {
        String _firstUpper = StringExtensions.toFirstUpper(e.getName());
        String _plus = ("group" + _firstUpper);
        final String keyFunctionIdSuggestion = (_plus + "Elem");
        final String keyFunctionId = ruleScope.addIdentifier(keyFunctionIdSuggestion, IdentifierScope.Group.METHOD);
        final String matcherType = this._utils.qualifiedName(e.getClazz());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("def protected abstract String ");
        _builder.append(keyFunctionId);
        _builder.append("(");
        _builder.append(matcherType);
        _builder.append(" ");
        String _name = e.getName();
        _builder.append(_name);
        _builder.append("Elem);");
        keyFunctions.add(_builder.toString());
        String _name_1 = e.getName();
        String _plus_1 = ("_" + _name_1);
        String _plus_2 = (_plus_1 + "GroupsMap");
        final String groupsMapId = localScope.addIdentifier(_plus_2, IdentifierScope.Group.VARIABLE);
        String _name_2 = e.getName();
        String _plus_3 = ("_" + _name_2);
        String _plus_4 = (_plus_3 + "Groups");
        final String groupsId = localScope.addIdentifier(_plus_4, IdentifierScope.Group.VARIABLE);
        matcherToGroupsId.put(e, groupsId);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("val ");
        _builder_1.append(groupsMapId);
        _builder_1.append(" = ");
        _builder_1.append(model);
        _builder_1.append(".allContents.filter(typeof(");
        _builder_1.append(matcherType);
        _builder_1.append(")).groupBy[");
        _builder_1.append(keyFunctionId);
        _builder_1.append("(it)]");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("val ");
        _builder_1.append(groupsId);
        _builder_1.append(" = new ArrayList<List<");
        _builder_1.append(matcherType);
        _builder_1.append(">>() => [");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("it += new ArrayList<");
        _builder_1.append(matcherType, "\t");
        _builder_1.append(">()");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("it += ");
        _builder_1.append(groupsMapId, "\t");
        _builder_1.append(".filter[key, value | key !== null].values");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("]");
        _builder_1.newLine();
        definitions.add(_builder_1.toString());
      }
    }
    boolean _isEmpty = definitions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _lineSeparator = System.lineSeparator();
      definitions.add(_lineSeparator);
    }
    String _join = IterableExtensions.join(definitions);
    return new ClassMatcherModifierCompiler.Group(_join, keyFunctions, matcherToGroupsId);
  }
  
  /**
   * Compiles the filter modifier of the given matcher.
   */
  public ClassMatcherModifierCompiler.Filter compileFilterModifier(final ClassMatcher current, final List<? extends ClassMatcher> before, final IdentifierScope ruleScope) {
    boolean _isFilter = current.getModifier().isFilter();
    if (_isFilter) {
      String _firstUpper = StringExtensions.toFirstUpper(current.getName());
      final String filterIdSuggestion = ("filter" + _firstUpper);
      final String filterId = ruleScope.addIdentifier(filterIdSuggestion, IdentifierScope.Group.METHOD);
      ArrayList<String> filterParams = new ArrayList<String>();
      String _qualifiedType = this._utils.qualifiedType(current);
      String _plus = (_qualifiedType + " ");
      String _name = current.getName();
      String _plus_1 = (_plus + _name);
      filterParams.add(_plus_1);
      final Function1<ClassMatcher, String> _function = (ClassMatcher it) -> {
        String _qualifiedType_1 = this._utils.qualifiedType(it);
        String _plus_2 = (_qualifiedType_1 + " ");
        String _name_1 = it.getName();
        return (_plus_2 + _name_1);
      };
      List<String> _map = ListExtensions.<ClassMatcher, String>map(ListExtensions.<ClassMatcher>reverse(new ArrayList<ClassMatcher>(before)), _function);
      Iterables.<String>addAll(filterParams, _map);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def protected abstract boolean ");
      _builder.append(filterId);
      _builder.append("(");
      String _join = IterableExtensions.join(filterParams, ", ");
      _builder.append(_join);
      _builder.append(");");
      final String filter = _builder.toString();
      ArrayList<String> filterCallParams = new ArrayList<String>();
      filterCallParams.add("it");
      final Function1<ClassMatcher, String> _function_1 = (ClassMatcher it) -> {
        return it.getName();
      };
      List<String> _map_1 = ListExtensions.<ClassMatcher, String>map(ListExtensions.<ClassMatcher>reverse(new ArrayList<ClassMatcher>(before)), _function_1);
      Iterables.<String>addAll(filterCallParams, _map_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(".filter[");
      _builder_1.append(filterId);
      _builder_1.append("(");
      String _join_1 = IterableExtensions.join(filterCallParams, ", ");
      _builder_1.append(_join_1);
      _builder_1.append(")]");
      final String filterCall = _builder_1.toString();
      return new ClassMatcherModifierCompiler.Filter(filterCall, filter);
    } else {
      return new ClassMatcherModifierCompiler.Filter("", null);
    }
  }
  
  /**
   * Returns if the compilation of this matchers contains any abstract method.
   */
  public boolean anyAbstractMethod(final List<? extends ClassMatcher> matcher) {
    final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
      return Boolean.valueOf((it.getModifier().isGroup() || it.getModifier().isFilter()));
    };
    return IterableExtensions.exists(matcher, _function);
  }
  
  /**
   * Returns all imports that the compilation of this matchers needs.
   */
  public Set<String> neededImports(final List<? extends ClassMatcher> matcher) {
    HashSet<String> imports = new HashSet<String>();
    final Function1<ClassMatcher, Boolean> _function = (ClassMatcher it) -> {
      return Boolean.valueOf((it.getModifier().isGroup() && it.getModifier().isFilter()));
    };
    boolean _exists = IterableExtensions.exists(matcher, _function);
    if (_exists) {
      imports.add("import java.util.List");
    }
    final Function1<ClassMatcher, Boolean> _function_1 = (ClassMatcher it) -> {
      return Boolean.valueOf(it.getModifier().isGroup());
    };
    boolean _exists_1 = IterableExtensions.exists(matcher, _function_1);
    if (_exists_1) {
      imports.add("import java.util.ArrayList");
    }
    return imports;
  }
  
  @Inject
  @Extension
  private Utils _utils;
}
