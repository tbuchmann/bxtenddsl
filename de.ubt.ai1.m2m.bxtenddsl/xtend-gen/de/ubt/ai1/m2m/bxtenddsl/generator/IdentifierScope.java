package de.ubt.ai1.m2m.bxtenddsl.generator;

import java.util.HashSet;

/**
 * A set of unique identifiers.
 */
@SuppressWarnings("all")
public class IdentifierScope {
  public enum Group {
    CLASS,
    
    METHOD,
    
    VARIABLE;
  }
  
  /**
   * Adds an identifier similar to suggestion to the scope.
   * The added identifier is unique regarding its group.
   * Returns the added identifier.
   */
  public String addIdentifier(final String suggestion, final IdentifierScope.Group group) {
    HashSet<String> _switchResult = null;
    if (group != null) {
      switch (group) {
        case CLASS:
          _switchResult = this.classScope;
          break;
        case METHOD:
          _switchResult = this.methodScope;
          break;
        case VARIABLE:
          _switchResult = this.variableScope;
          break;
        default:
          throw new AssertionError("Group should be CLASS, METHOD or VARIABLE!");
      }
    } else {
      throw new AssertionError("Group should be CLASS, METHOD or VARIABLE!");
    }
    final HashSet<String> scope = _switchResult;
    boolean _contains = scope.contains(suggestion);
    boolean _not = (!_contains);
    if (_not) {
      scope.add(suggestion);
      return suggestion;
    } else {
      for (int i = 2; (i <= 65536); i++) {
        {
          final String uniqueSuggestion = ((suggestion + "_") + Integer.valueOf(i));
          boolean _contains_1 = scope.contains(uniqueSuggestion);
          boolean _not_1 = (!_contains_1);
          if (_not_1) {
            scope.add(uniqueSuggestion);
            return uniqueSuggestion;
          }
        }
      }
      throw new AssertionError("Only 65536 different identifiers can be computed for a suggestion!");
    }
  }
  
  private final HashSet<String> classScope = new HashSet<String>();
  
  private final HashSet<String> methodScope = new HashSet<String>();
  
  private final HashSet<String> variableScope = new HashSet<String>();
}
