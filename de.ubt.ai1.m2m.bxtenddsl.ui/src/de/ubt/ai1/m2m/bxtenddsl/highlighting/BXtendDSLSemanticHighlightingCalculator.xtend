package de.ubt.ai1.m2m.bxtenddsl.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import com.google.inject.Inject
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess
import java.util.Random
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL

class BXtendDSLSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	override protected doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator)
		
		for (node : resource?.parseResult?.rootNode?.asTreeIterable ?: #[]) {
			switch node.grammarElement {
				case grammerAccess.configAccess.optionsIDTerminalRuleCall_1_2_0: {
					acceptor.addPosition(node.offset, node.length, BXtendDSLHighlightingConfiguration.OPTION_ID)
				}
				
				case grammerAccess.classMatcherModifierAccess.groupGroupKeyword_1_0_2_0,
				case grammerAccess.classMatcherModifierAccess.groupGroupKeyword_1_1_1_0_0_0,
				case grammerAccess.classMatcherModifierAccess.groupGroupKeyword_1_2_1_0_0_0,
				case grammerAccess.classMatcherModifierAccess.groupGroupKeyword_1_3_1_0_0_0,
				case grammerAccess.classMatcherModifierAccess.groupGroupKeyword_1_4_1_0_0_0,
				case grammerAccess.classMatcherModifierAccess.filterFilterKeyword_1_0_1_0_0_0,
				case grammerAccess.classMatcherModifierAccess.filterFilterKeyword_1_1_2_0,
				case grammerAccess.classMatcherModifierAccess.filterFilterKeyword_1_2_1_1_0_0,
				case grammerAccess.classMatcherModifierAccess.filterFilterKeyword_1_3_1_1_0_0,
				case grammerAccess.classMatcherModifierAccess.filterFilterKeyword_1_4_1_1_0_0,
				case grammerAccess.classMatcherModifierAccess.sortSortKeyword_1_0_1_1_0_0,
				case grammerAccess.classMatcherModifierAccess.sortSortKeyword_1_1_1_1_0_0,
				case grammerAccess.classMatcherModifierAccess.sortSortKeyword_1_2_2_0,
				case grammerAccess.classMatcherModifierAccess.sortSortKeyword_1_3_1_2_0_0,
				case grammerAccess.classMatcherModifierAccess.sortSortKeyword_1_4_1_2_0_0,
				case grammerAccess.classMatcherModifierAccess.creationCreationKeyword_1_0_1_2_0_0,
				case grammerAccess.classMatcherModifierAccess.creationCreationKeyword_1_1_1_2_0_0,
				case grammerAccess.classMatcherModifierAccess.creationCreationKeyword_1_2_1_2_0_0,
				case grammerAccess.classMatcherModifierAccess.creationCreationKeyword_1_3_2_0,
				case grammerAccess.classMatcherModifierAccess.creationCreationKeyword_1_4_1_3_0_0,
				case grammerAccess.classMatcherModifierAccess.deletionDeletionKeyword_1_0_1_3_0_0,
				case grammerAccess.classMatcherModifierAccess.deletionDeletionKeyword_1_1_1_3_0_0,
				case grammerAccess.classMatcherModifierAccess.deletionDeletionKeyword_1_2_1_3_0_0,
				case grammerAccess.classMatcherModifierAccess.deletionDeletionKeyword_1_3_1_3_0_0,
				case grammerAccess.classMatcherModifierAccess.deletionDeletionKeyword_1_4_2_0: {
					acceptor.addPosition(node.offset, node.length, BXtendDSLHighlightingConfiguration.MODIFIER_ID)
				}
				
				case grammerAccess.srcClassMatcherAccess.nameIDTerminalRuleCall_1_0,
				case grammerAccess.trgClassMatcherAccess.nameIDTerminalRuleCall_1_0,
				case grammerAccess.featureMappingAccess.srcClassesClassMatcherCrossReference_0_1_0,
				case grammerAccess.featureMappingAccess.trgClassesClassMatcherCrossReference_2_1_0: {
					acceptor.addPosition(node.offset, node.length, BXtendDSLHighlightingConfiguration.MATCHER_ID)
				}
				case grammerAccess.srcMappingFeatureAccess.featureEStructuralFeatureCrossReference_0_0,
				case grammerAccess.trgMappingFeatureAccess.featureEStructuralFeatureCrossReference_0_0: {
					val matcherLength = node.text.trim().indexOf(".")
					acceptor.addPosition(node.offset, matcherLength, BXtendDSLHighlightingConfiguration.MATCHER_ID)
				}
				
				case grammerAccess.srcMappingFeatureAccess.featureEStructuralFeatureCrossReference_1_1_0,
				case grammerAccess.trgMappingFeatureAccess.featureEStructuralFeatureCrossReference_1_1_0: {
					val matcherLength = node.text.trim().indexOf(".")
					acceptor.addPosition(node.offset, matcherLength, BXtendDSLHighlightingConfiguration.CORR_MATCHER_ID)
					val corrFeatureId = BXtendDSLHighlightingConfiguration.CORR_FEATURE_ID
					acceptor.addPosition(node.offset + matcherLength, node.length - matcherLength, corrFeatureId)
				}
			}
		}
		
		if ((resource.contents.get(0) as BXtendDSL).config.options.contains("CHEA")) {
			for (node : resource?.parseResult?.rootNode?.asTreeIterable ?: #[]) {
				val style = switch ((new Random()).nextInt(8) + 1) {
					case 1: BXtendDSLHighlightingConfiguration.CHEA_1_ID
					case 2: BXtendDSLHighlightingConfiguration.CHEA_2_ID
					case 3: BXtendDSLHighlightingConfiguration.CHEA_3_ID
					case 4: BXtendDSLHighlightingConfiguration.CHEA_4_ID
					case 5: BXtendDSLHighlightingConfiguration.CHEA_5_ID
					case 6: BXtendDSLHighlightingConfiguration.CHEA_6_ID
					case 7: BXtendDSLHighlightingConfiguration.CHEA_7_ID
					case 8: BXtendDSLHighlightingConfiguration.CHEA_8_ID
					default: throw new AssertionError("Random int should be between 1 and 8!")
				}
				acceptor.addPosition(node.offset, node.length, style)
			}
		}
	}
	
	@Inject BXtendDSLGrammarAccess grammerAccess
}
