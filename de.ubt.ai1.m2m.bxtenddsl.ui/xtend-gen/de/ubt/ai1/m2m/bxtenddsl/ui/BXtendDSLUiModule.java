/**
 * generated by Xtext 2.15.0
 */
package de.ubt.ai1.m2m.bxtenddsl.ui;

import de.ubt.ai1.m2m.bxtenddsl.highlighting.BXtendDSLHighlightingConfiguration;
import de.ubt.ai1.m2m.bxtenddsl.highlighting.BXtendDSLSemanticHighlightingCalculator;
import de.ubt.ai1.m2m.bxtenddsl.ui.hovering.BXtendDSLDispatchingTextHover;
import de.ubt.ai1.m2m.bxtenddsl.ui.hovering.BXtendDSLHoverProvider;
import de.ubt.ai1.m2m.bxtenddsl.ui.hyperlinking.BXtendDSLHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BXtendDSLUiModule extends AbstractBXtendDSLUiModule {
  public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
    return BXtendDSLHighlightingConfiguration.class;
  }
  
  public Class<? extends DefaultSemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
    return BXtendDSLSemanticHighlightingCalculator.class;
  }
  
  @Override
  public Class<? extends IEObjectHover> bindIEObjectHover() {
    return BXtendDSLDispatchingTextHover.class;
  }
  
  public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
    return BXtendDSLHoverProvider.class;
  }
  
  public Class<? extends HyperlinkHelper> bindHyperlinkHelper() {
    return BXtendDSLHyperlinkHelper.class;
  }
  
  public BXtendDSLUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
