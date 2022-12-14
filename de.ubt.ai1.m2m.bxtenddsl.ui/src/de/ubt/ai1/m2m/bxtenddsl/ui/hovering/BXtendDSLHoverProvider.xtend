package de.ubt.ai1.m2m.bxtenddsl.ui.hovering

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher

class BXtendDSLHoverProvider extends DefaultEObjectHoverProvider {
	override protected String getHoverInfoAsHtml(EObject o) {
		if (o instanceof EStructuralFeature) {
			return '''«o.EType.name» <b>«o.name»</b>'''
		} else if (o instanceof ClassMatcher) {
			return '''«o.clazz.name» <b>«o.name»</b>'''
		}
		return super.getHoverInfoAsHtml(o)
	}
}
