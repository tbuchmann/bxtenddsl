package de.ubt.ai1.m2m.bxtenddsl.generator;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Template for the entry class of the transformation.
 */
@SuppressWarnings("all")
public final class EntryClassTemplate {
  /**
   * Returns the content of the entry class for the given transformation and adds all rules.
   */
  public static String getCode(final BXtendDSL dsl, final String trafo, final String rootPackage, final List<String> rules) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(rootPackage);
    _builder.append(".trafo");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("import java.util.HashMap");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.Resource");
    _builder.newLine();
    _builder.append("import ");
    _builder.append(rootPackage);
    _builder.append(".rules.Elem2Elem");
    _builder.newLineIfNotEmpty();
    {
      for(final String rule : rules) {
        _builder.append("import ");
        _builder.append(rootPackage);
        _builder.append(".rules.");
        _builder.append(rule);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("class ");
    _builder.append(trafo);
    _builder.append(" extends Abstract");
    _builder.append(trafo);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<String> _options = dsl.getConfig().getOptions();
      for(final String option : _options) {
        _builder.append("\t");
        _builder.append("public static val OPT_");
        _builder.append(option, "\t");
        _builder.append(" = \"");
        _builder.append(option, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("static val options = #{");
    final Function1<String, String> _function = (String it) -> {
      return ("OPT_" + it);
    };
    String _join = IterableExtensions.join(ListExtensions.<String, String>map(dsl.getConfig().getOptions(), _function), ", ");
    _builder.append(_join, "\t");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val configuration = new HashMap<String, Object>()");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Resource source, Resource target, Resource correspondence) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(source, target, correspondence)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override Object getOption(String option) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!options.contains(option)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new IllegalArgumentException(\"Invalid option \'\" + option + \"\'! Valid options are \" + options + \".\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return configuration.get(option)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override void setOption(String option, Object value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!options.contains(option)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new IllegalArgumentException(\"Invalid option \'\" + option + \"\'! Valid options are \" + options + \".\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configuration.put(option, value)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override protected List<Elem2Elem> createRules() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var result = new ArrayList<Elem2Elem>()");
    _builder.newLine();
    {
      for(final String rule_1 : rules) {
        _builder.append("\t\t");
        _builder.append("result += new ");
        _builder.append(rule_1, "\t\t");
        _builder.append("(this)");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return result");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private EntryClassTemplate() {
  }
}
