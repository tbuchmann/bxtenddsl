package de.ubt.ai1.m2m.bxtenddsl.ui.hovering

import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.ITextViewer
import org.eclipse.jface.text.IRegion
import org.eclipse.emf.ecore.EStructuralFeature
import javax.inject.Inject
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider

class BXtendDSLDispatchingTextHover extends DispatchingEObjectTextHover {
	override Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		if (first instanceof EStructuralFeature) {
			val creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion)
			if (creatorProvider === null) {
				return null
			} else {
				lastCreatorProvider = creatorProvider
				return creatorProvider.info
			}
		} else {
			return super.getHoverInfo(first, textViewer, hoverRegion)
		}
	}
	
	@Inject IEObjectHoverProvider hoverProvider
}
