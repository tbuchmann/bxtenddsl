package de.ubt.ai1.m2m.bxtenddsl.highlighting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess;
import java.util.Collections;
import java.util.Random;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class BXtendDSLSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
  @Override
  protected void doProvideHighlightingFor(final XtextResource resource, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    super.doProvideHighlightingFor(resource, acceptor, cancelIndicator);
    Iterable<INode> _elvis = null;
    IParseResult _parseResult = null;
    if (resource!=null) {
      _parseResult=resource.getParseResult();
    }
    ICompositeNode _rootNode = null;
    if (_parseResult!=null) {
      _rootNode=_parseResult.getRootNode();
    }
    BidiTreeIterable<INode> _asTreeIterable = null;
    if (_rootNode!=null) {
      _asTreeIterable=_rootNode.getAsTreeIterable();
    }
    if (_asTreeIterable != null) {
      _elvis = _asTreeIterable;
    } else {
      _elvis = Collections.<INode>unmodifiableList(CollectionLiterals.<INode>newArrayList());
    }
    for (final INode node : _elvis) {
      EObject _grammarElement = node.getGrammarElement();
      boolean _matched = false;
      RuleCall _optionsIDTerminalRuleCall_1_2_0 = this.grammerAccess.getConfigAccess().getOptionsIDTerminalRuleCall_1_2_0();
      if (Objects.equal(_grammarElement, _optionsIDTerminalRuleCall_1_2_0)) {
        _matched=true;
        acceptor.addPosition(node.getOffset(), node.getLength(), BXtendDSLHighlightingConfiguration.OPTION_ID);
      }
      if (!_matched) {
        Keyword _groupGroupKeyword_1_0_2_0 = this.grammerAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0();
        if (Objects.equal(_grammarElement, _groupGroupKeyword_1_0_2_0)) {
          _matched=true;
        }
        if (!_matched) {
          Keyword _groupGroupKeyword_1_1_1_0_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0();
          if (Objects.equal(_grammarElement, _groupGroupKeyword_1_1_1_0_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _groupGroupKeyword_1_2_1_0_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0();
          if (Objects.equal(_grammarElement, _groupGroupKeyword_1_2_1_0_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _groupGroupKeyword_1_3_1_0_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0();
          if (Objects.equal(_grammarElement, _groupGroupKeyword_1_3_1_0_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _groupGroupKeyword_1_4_1_0_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0();
          if (Objects.equal(_grammarElement, _groupGroupKeyword_1_4_1_0_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _filterFilterKeyword_1_0_1_0_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0();
          if (Objects.equal(_grammarElement, _filterFilterKeyword_1_0_1_0_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _filterFilterKeyword_1_1_2_0 = this.grammerAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0();
          if (Objects.equal(_grammarElement, _filterFilterKeyword_1_1_2_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _filterFilterKeyword_1_2_1_1_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0();
          if (Objects.equal(_grammarElement, _filterFilterKeyword_1_2_1_1_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _filterFilterKeyword_1_3_1_1_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0();
          if (Objects.equal(_grammarElement, _filterFilterKeyword_1_3_1_1_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _filterFilterKeyword_1_4_1_1_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0();
          if (Objects.equal(_grammarElement, _filterFilterKeyword_1_4_1_1_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _sortSortKeyword_1_0_1_1_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0();
          if (Objects.equal(_grammarElement, _sortSortKeyword_1_0_1_1_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _sortSortKeyword_1_1_1_1_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0();
          if (Objects.equal(_grammarElement, _sortSortKeyword_1_1_1_1_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _sortSortKeyword_1_2_2_0 = this.grammerAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0();
          if (Objects.equal(_grammarElement, _sortSortKeyword_1_2_2_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _sortSortKeyword_1_3_1_2_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0();
          if (Objects.equal(_grammarElement, _sortSortKeyword_1_3_1_2_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _sortSortKeyword_1_4_1_2_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0();
          if (Objects.equal(_grammarElement, _sortSortKeyword_1_4_1_2_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _creationCreationKeyword_1_0_1_2_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0();
          if (Objects.equal(_grammarElement, _creationCreationKeyword_1_0_1_2_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _creationCreationKeyword_1_1_1_2_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0();
          if (Objects.equal(_grammarElement, _creationCreationKeyword_1_1_1_2_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _creationCreationKeyword_1_2_1_2_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0();
          if (Objects.equal(_grammarElement, _creationCreationKeyword_1_2_1_2_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _creationCreationKeyword_1_3_2_0 = this.grammerAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0();
          if (Objects.equal(_grammarElement, _creationCreationKeyword_1_3_2_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _creationCreationKeyword_1_4_1_3_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0();
          if (Objects.equal(_grammarElement, _creationCreationKeyword_1_4_1_3_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _deletionDeletionKeyword_1_0_1_3_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0();
          if (Objects.equal(_grammarElement, _deletionDeletionKeyword_1_0_1_3_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _deletionDeletionKeyword_1_1_1_3_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0();
          if (Objects.equal(_grammarElement, _deletionDeletionKeyword_1_1_1_3_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _deletionDeletionKeyword_1_2_1_3_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0();
          if (Objects.equal(_grammarElement, _deletionDeletionKeyword_1_2_1_3_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _deletionDeletionKeyword_1_3_1_3_0_0 = this.grammerAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0();
          if (Objects.equal(_grammarElement, _deletionDeletionKeyword_1_3_1_3_0_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          Keyword _deletionDeletionKeyword_1_4_2_0 = this.grammerAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0();
          if (Objects.equal(_grammarElement, _deletionDeletionKeyword_1_4_2_0)) {
            _matched=true;
          }
        }
        if (_matched) {
          acceptor.addPosition(node.getOffset(), node.getLength(), BXtendDSLHighlightingConfiguration.MODIFIER_ID);
        }
      }
      if (!_matched) {
        RuleCall _nameIDTerminalRuleCall_1_0 = this.grammerAccess.getSrcClassMatcherAccess().getNameIDTerminalRuleCall_1_0();
        if (Objects.equal(_grammarElement, _nameIDTerminalRuleCall_1_0)) {
          _matched=true;
        }
        if (!_matched) {
          RuleCall _nameIDTerminalRuleCall_1_0_1 = this.grammerAccess.getTrgClassMatcherAccess().getNameIDTerminalRuleCall_1_0();
          if (Objects.equal(_grammarElement, _nameIDTerminalRuleCall_1_0_1)) {
            _matched=true;
          }
        }
        if (!_matched) {
          CrossReference _srcClassesClassMatcherCrossReference_0_1_0 = this.grammerAccess.getFeatureMappingAccess().getSrcClassesClassMatcherCrossReference_0_1_0();
          if (Objects.equal(_grammarElement, _srcClassesClassMatcherCrossReference_0_1_0)) {
            _matched=true;
          }
        }
        if (!_matched) {
          CrossReference _trgClassesClassMatcherCrossReference_2_1_0 = this.grammerAccess.getFeatureMappingAccess().getTrgClassesClassMatcherCrossReference_2_1_0();
          if (Objects.equal(_grammarElement, _trgClassesClassMatcherCrossReference_2_1_0)) {
            _matched=true;
          }
        }
        if (_matched) {
          acceptor.addPosition(node.getOffset(), node.getLength(), BXtendDSLHighlightingConfiguration.MATCHER_ID);
        }
      }
      if (!_matched) {
        CrossReference _featureEStructuralFeatureCrossReference_0_0 = this.grammerAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0();
        if (Objects.equal(_grammarElement, _featureEStructuralFeatureCrossReference_0_0)) {
          _matched=true;
        }
        if (!_matched) {
          CrossReference _featureEStructuralFeatureCrossReference_0_0_1 = this.grammerAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0();
          if (Objects.equal(_grammarElement, _featureEStructuralFeatureCrossReference_0_0_1)) {
            _matched=true;
          }
        }
        if (_matched) {
          final int matcherLength = node.getText().trim().indexOf(".");
          acceptor.addPosition(node.getOffset(), matcherLength, BXtendDSLHighlightingConfiguration.MATCHER_ID);
        }
      }
      if (!_matched) {
        CrossReference _featureEStructuralFeatureCrossReference_1_1_0 = this.grammerAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0();
        if (Objects.equal(_grammarElement, _featureEStructuralFeatureCrossReference_1_1_0)) {
          _matched=true;
        }
        if (!_matched) {
          CrossReference _featureEStructuralFeatureCrossReference_1_1_0_1 = this.grammerAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0();
          if (Objects.equal(_grammarElement, _featureEStructuralFeatureCrossReference_1_1_0_1)) {
            _matched=true;
          }
        }
        if (_matched) {
          final int matcherLength_1 = node.getText().trim().indexOf(".");
          acceptor.addPosition(node.getOffset(), matcherLength_1, BXtendDSLHighlightingConfiguration.CORR_MATCHER_ID);
          final String corrFeatureId = BXtendDSLHighlightingConfiguration.CORR_FEATURE_ID;
          int _offset = node.getOffset();
          int _plus = (_offset + matcherLength_1);
          int _length = node.getLength();
          int _minus = (_length - matcherLength_1);
          acceptor.addPosition(_plus, _minus, corrFeatureId);
        }
      }
    }
    EObject _get = resource.getContents().get(0);
    boolean _contains = ((BXtendDSL) _get).getConfig().getOptions().contains("CHEA");
    if (_contains) {
      Iterable<INode> _elvis_1 = null;
      IParseResult _parseResult_1 = null;
      if (resource!=null) {
        _parseResult_1=resource.getParseResult();
      }
      ICompositeNode _rootNode_1 = null;
      if (_parseResult_1!=null) {
        _rootNode_1=_parseResult_1.getRootNode();
      }
      BidiTreeIterable<INode> _asTreeIterable_1 = null;
      if (_rootNode_1!=null) {
        _asTreeIterable_1=_rootNode_1.getAsTreeIterable();
      }
      if (_asTreeIterable_1 != null) {
        _elvis_1 = _asTreeIterable_1;
      } else {
        _elvis_1 = Collections.<INode>unmodifiableList(CollectionLiterals.<INode>newArrayList());
      }
      for (final INode node_1 : _elvis_1) {
        {
          String _switchResult_1 = null;
          int _nextInt = new Random().nextInt(8);
          int _plus_1 = (_nextInt + 1);
          switch (_plus_1) {
            case 1:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_1_ID;
              break;
            case 2:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_2_ID;
              break;
            case 3:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_3_ID;
              break;
            case 4:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_4_ID;
              break;
            case 5:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_5_ID;
              break;
            case 6:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_6_ID;
              break;
            case 7:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_7_ID;
              break;
            case 8:
              _switchResult_1 = BXtendDSLHighlightingConfiguration.CHEA_8_ID;
              break;
            default:
              throw new AssertionError("Random int should be between 1 and 8!");
          }
          final String style = _switchResult_1;
          acceptor.addPosition(node_1.getOffset(), node_1.getLength(), style);
        }
      }
    }
  }
  
  @Inject
  private BXtendDSLGrammarAccess grammerAccess;
}
