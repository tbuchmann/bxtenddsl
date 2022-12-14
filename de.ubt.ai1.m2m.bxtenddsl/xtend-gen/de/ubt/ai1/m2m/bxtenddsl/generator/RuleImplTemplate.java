package de.ubt.ai1.m2m.bxtenddsl.generator;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Template for a rule implementation stub.
 */
@SuppressWarnings("all")
public final class RuleImplTemplate {
  /**
   * Returns the content of a rule implementation stub file.
   */
  public static String getCode(final String rule, final String trafo, final String rootPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(rootPackage);
    _builder.append(".rules;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(rootPackage);
    _builder.append(".trafo.");
    _builder.append(trafo);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    _builder.append(rule);
    _builder.append("Impl extends ");
    _builder.append(rule);
    _builder.append(" {\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("new(");
    _builder.append(trafo, "\t");
    _builder.append(" trafo) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(trafo)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private RuleImplTemplate() {
  }
}
