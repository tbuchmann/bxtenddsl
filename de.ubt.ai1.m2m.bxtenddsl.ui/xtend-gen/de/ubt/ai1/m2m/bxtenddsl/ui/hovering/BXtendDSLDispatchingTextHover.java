package de.ubt.ai1.m2m.bxtenddsl.ui.hovering;

import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

@SuppressWarnings("all")
public class BXtendDSLDispatchingTextHover extends DispatchingEObjectTextHover {
  @Override
  public Object getHoverInfo(final EObject first, final ITextViewer textViewer, final IRegion hoverRegion) {
    if ((first instanceof EStructuralFeature)) {
      final IEObjectHoverProvider.IInformationControlCreatorProvider creatorProvider = this.hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
      if ((creatorProvider == null)) {
        return null;
      } else {
        this.lastCreatorProvider = creatorProvider;
        return creatorProvider.getInfo();
      }
    } else {
      return super.getHoverInfo(first, textViewer, hoverRegion);
    }
  }
  
  @Inject
  private IEObjectHoverProvider hoverProvider;
}
