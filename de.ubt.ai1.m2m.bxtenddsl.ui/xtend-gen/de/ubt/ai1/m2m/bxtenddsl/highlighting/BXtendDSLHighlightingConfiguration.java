package de.ubt.ai1.m2m.bxtenddsl.highlighting;

import java.util.Random;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BXtendDSLHighlightingConfiguration extends DefaultHighlightingConfiguration {
  public static final String OPTION_ID = "OPTION_ID";
  
  public static final String MODIFIER_ID = "MODIFIER_ID";
  
  public static final String MATCHER_ID = "MATCHER_ID";
  
  public static final String CORR_MATCHER_ID = "CORR_MATCHER_ID";
  
  public static final String CORR_FEATURE_ID = "CORR_FEATURE_ID";
  
  public static final String CHEA_1_ID = "CHEA_1_ID";
  
  public static final String CHEA_2_ID = "CHEA_2_ID";
  
  public static final String CHEA_3_ID = "CHEA_3_ID";
  
  public static final String CHEA_4_ID = "CHEA_4_ID";
  
  public static final String CHEA_5_ID = "CHEA_5_ID";
  
  public static final String CHEA_6_ID = "CHEA_6_ID";
  
  public static final String CHEA_7_ID = "CHEA_7_ID";
  
  public static final String CHEA_8_ID = "CHEA_8_ID";
  
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    super.configure(acceptor);
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.OPTION_ID, "Option", this.optionTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.MODIFIER_ID, "Modifier", this.modifierTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.MATCHER_ID, "Matcher", this.matcherTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CORR_MATCHER_ID, "CorrMatcher", this.corrMatcherTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CORR_FEATURE_ID, "CorrFeature", this.corrFeatureTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_1_ID, "CHEA_1", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_2_ID, "CHEA_2", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_3_ID, "CHEA_3", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_4_ID, "CHEA_4", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_5_ID, "CHEA_5", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_6_ID, "CHEA_6", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_7_ID, "CHEA_7", this.cheaTextStyle());
    acceptor.acceptDefaultHighlighting(BXtendDSLHighlightingConfiguration.CHEA_8_ID, "CHEA_8", this.cheaTextStyle());
  }
  
  private TextStyle optionTextStyle() {
    TextStyle _textStyle = new TextStyle();
    final Procedure1<TextStyle> _function = (TextStyle it) -> {
      RGB _rGB = new RGB(0, 0, 192);
      it.setColor(_rGB);
      it.setStyle(SWT.ITALIC);
    };
    return ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
  }
  
  private TextStyle modifierTextStyle() {
    TextStyle _textStyle = new TextStyle();
    final Procedure1<TextStyle> _function = (TextStyle it) -> {
      RGB _rGB = new RGB(127, 0, 85);
      it.setColor(_rGB);
      it.setStyle((SWT.ITALIC | SWT.BOLD));
    };
    return ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
  }
  
  private TextStyle matcherTextStyle() {
    TextStyle _textStyle = new TextStyle();
    final Procedure1<TextStyle> _function = (TextStyle it) -> {
      RGB _rGB = new RGB(0, 26, 171);
      it.setColor(_rGB);
    };
    return ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
  }
  
  private TextStyle corrMatcherTextStyle() {
    TextStyle _textStyle = new TextStyle();
    final Procedure1<TextStyle> _function = (TextStyle it) -> {
      RGB _rGB = new RGB(0, 26, 171);
      it.setColor(_rGB);
      it.setStyle(SWT.ITALIC);
    };
    return ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
  }
  
  private TextStyle corrFeatureTextStyle() {
    TextStyle _textStyle = new TextStyle();
    final Procedure1<TextStyle> _function = (TextStyle it) -> {
      it.setStyle(SWT.ITALIC);
    };
    return ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
  }
  
  private TextStyle cheaTextStyle() {
    TextStyle _xblockexpression = null;
    {
      final Random random = new Random();
      TextStyle _textStyle = new TextStyle();
      final Procedure1<TextStyle> _function = (TextStyle it) -> {
        int _nextInt = random.nextInt(256);
        int _nextInt_1 = random.nextInt(256);
        int _nextInt_2 = random.nextInt(256);
        RGB _rGB = new RGB(_nextInt, _nextInt_1, _nextInt_2);
        it.setColor(_rGB);
      };
      _xblockexpression = ObjectExtensions.<TextStyle>operator_doubleArrow(_textStyle, _function);
    }
    return _xblockexpression;
  }
}
