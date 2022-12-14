package de.ubt.ai1.m2m.bxtenddsl.ui.hovering;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

@SuppressWarnings("all")
public class BXtendDSLHoverProvider extends DefaultEObjectHoverProvider {
  @Override
  protected String getHoverInfoAsHtml(final EObject o) {
    if ((o instanceof EStructuralFeature)) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = ((EStructuralFeature)o).getEType().getName();
      _builder.append(_name);
      _builder.append(" <b>");
      String _name_1 = ((EStructuralFeature)o).getName();
      _builder.append(_name_1);
      _builder.append("</b>");
      return _builder.toString();
    } else {
      if ((o instanceof ClassMatcher)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_2 = ((ClassMatcher)o).getClazz().getName();
        _builder_1.append(_name_2);
        _builder_1.append(" <b>");
        String _name_3 = ((ClassMatcher)o).getName();
        _builder_1.append(_name_3);
        _builder_1.append("</b>");
        return _builder_1.toString();
      }
    }
    return super.getHoverInfoAsHtml(o);
  }
}
