package de.ubt.ai1.m2m.bxtenddsl.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT
import java.util.Random

class BXtendDSLHighlightingConfiguration extends DefaultHighlightingConfiguration {
	public static val OPTION_ID = "OPTION_ID"
	public static val MODIFIER_ID = "MODIFIER_ID"
	public static val MATCHER_ID = "MATCHER_ID"
	public static val CORR_MATCHER_ID = "CORR_MATCHER_ID"
	public static val CORR_FEATURE_ID = "CORR_FEATURE_ID"
	
	public static val CHEA_1_ID = "CHEA_1_ID"
	public static val CHEA_2_ID = "CHEA_2_ID"
	public static val CHEA_3_ID = "CHEA_3_ID"
	public static val CHEA_4_ID = "CHEA_4_ID"
	public static val CHEA_5_ID = "CHEA_5_ID"
	public static val CHEA_6_ID = "CHEA_6_ID"
	public static val CHEA_7_ID = "CHEA_7_ID"
	public static val CHEA_8_ID = "CHEA_8_ID"
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)
		
		acceptor.acceptDefaultHighlighting(OPTION_ID, "Option", optionTextStyle)
		acceptor.acceptDefaultHighlighting(MODIFIER_ID, "Modifier", modifierTextStyle)
		acceptor.acceptDefaultHighlighting(MATCHER_ID, "Matcher", matcherTextStyle)
		acceptor.acceptDefaultHighlighting(CORR_MATCHER_ID, "CorrMatcher", corrMatcherTextStyle)
		acceptor.acceptDefaultHighlighting(CORR_FEATURE_ID, "CorrFeature", corrFeatureTextStyle)
		
		acceptor.acceptDefaultHighlighting(CHEA_1_ID, "CHEA_1", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_2_ID, "CHEA_2", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_3_ID, "CHEA_3", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_4_ID, "CHEA_4", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_5_ID, "CHEA_5", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_6_ID, "CHEA_6", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_7_ID, "CHEA_7", cheaTextStyle)
		acceptor.acceptDefaultHighlighting(CHEA_8_ID, "CHEA_8", cheaTextStyle)
	}
	
	def private TextStyle optionTextStyle() {
		new TextStyle() => [
			color = new RGB(0, 0, 192)
			style = SWT.ITALIC
		]
	}
	def private TextStyle modifierTextStyle() {
		new TextStyle() => [
			color = new RGB(127, 0, 85)
			style = SWT.ITALIC.bitwiseOr(SWT.BOLD)
		]
	}
	def private TextStyle matcherTextStyle() {
		new TextStyle() => [
			color = new RGB(0, 26, 171)
		]
	}
	def private TextStyle corrMatcherTextStyle() {
		new TextStyle() => [
			color = new RGB(0, 26, 171)
			style = SWT.ITALIC
		]
	}
	def private TextStyle corrFeatureTextStyle() {
		new TextStyle() => [
			style = SWT.ITALIC
		]
	}
	
	def private TextStyle cheaTextStyle() {
		val random = new Random()
		new TextStyle() => [
			color = new RGB(random.nextInt(256), random.nextInt(256), random.nextInt(256))
		]
	}
}
