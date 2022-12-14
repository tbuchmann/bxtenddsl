package de.ubt.ai1.m2m.bxtenddsl.ui.hyperlinking;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author    Jonas Fraas <jonas.fraas(at)uni-bayreuth.de>
 * @date      2019-06-14
 */
@SuppressWarnings("all")
public class BXtendDSLHyperlink implements IHyperlink {
  private final IRegion hyperlinkRegion;
  
  private final String label;
  
  private final Procedure0 callback;
  
  public BXtendDSLHyperlink(final IRegion hyperlinkRegion, final String label, final Procedure0 callback) {
    this.hyperlinkRegion = hyperlinkRegion;
    this.callback = callback;
    this.label = label;
  }
  
  @Override
  public IRegion getHyperlinkRegion() {
    return this.hyperlinkRegion;
  }
  
  @Override
  public String getHyperlinkText() {
    return this.label;
  }
  
  @Override
  public String getTypeLabel() {
    return this.label;
  }
  
  @Override
  public void open() {
    if ((this.callback != null)) {
      this.callback.apply();
    }
  }
}
