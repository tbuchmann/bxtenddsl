package de.ubt.ai1.m2m.bxtenddsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBXtendDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Sourcemodel", "Targetmodel", "Creation", "Deletion", "Options", "Filter", "Group", "LessThanSignHyphenMinusHyphenMinusGreaterThanSign", "Rule", "Sort", "HyphenMinusHyphenMinusGreaterThanSign", "LessThanSignHyphenMinusHyphenMinus", "Get", "Set", "Src", "Trg", "As", "Comma", "FullStop", "Colon", "Semicolon", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_INDENTATION", "RULE_SL_COMMENT", "RULE_TAB_INDENTED_BLOCK_BEGIN", "RULE_TAB_INDENTED_BLOCK_END"
    };
    public static final int Options=8;
    public static final int Group=10;
    public static final int Set=17;
    public static final int Src=18;
    public static final int Trg=19;
    public static final int RULE_STRING=31;
    public static final int RULE_SL_COMMENT=34;
    public static final int Comma=21;
    public static final int As=20;
    public static final int LessThanSignHyphenMinusHyphenMinusGreaterThanSign=11;
    public static final int Deletion=7;
    public static final int Sort=13;
    public static final int Colon=23;
    public static final int RightCurlyBracket=29;
    public static final int EOF=-1;
    public static final int RightSquareBracket=26;
    public static final int FullStop=22;
    public static final int Creation=6;
    public static final int RULE_ID=30;
    public static final int RULE_WS=32;
    public static final int RULE_TAB_INDENTED_BLOCK_BEGIN=35;
    public static final int LeftCurlyBracket=27;
    public static final int Sourcemodel=4;
    public static final int Semicolon=24;
    public static final int RULE_INDENTATION=33;
    public static final int RULE_TAB_INDENTED_BLOCK_END=36;
    public static final int LessThanSignHyphenMinusHyphenMinus=15;
    public static final int Targetmodel=5;
    public static final int Filter=9;
    public static final int HyphenMinusHyphenMinusGreaterThanSign=14;
    public static final int VerticalLine=28;
    public static final int Get=16;
    public static final int LeftSquareBracket=25;
    public static final int Rule=12;

    // delegates
    // delegators


        public InternalBXtendDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBXtendDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBXtendDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBXtendDSLParser.g"; }



     	private BXtendDSLGrammarAccess grammarAccess;

        public InternalBXtendDSLParser(TokenStream input, BXtendDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "BXtendDSL";
       	}

       	@Override
       	protected BXtendDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBXtendDSL"
    // InternalBXtendDSLParser.g:58:1: entryRuleBXtendDSL returns [EObject current=null] : iv_ruleBXtendDSL= ruleBXtendDSL EOF ;
    public final EObject entryRuleBXtendDSL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBXtendDSL = null;


        try {
            // InternalBXtendDSLParser.g:58:50: (iv_ruleBXtendDSL= ruleBXtendDSL EOF )
            // InternalBXtendDSLParser.g:59:2: iv_ruleBXtendDSL= ruleBXtendDSL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBXtendDSLRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBXtendDSL=ruleBXtendDSL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBXtendDSL; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBXtendDSL"


    // $ANTLR start "ruleBXtendDSL"
    // InternalBXtendDSLParser.g:65:1: ruleBXtendDSL returns [EObject current=null] : ( ( (lv_metamodels_0_0= ruleMetamodels ) ) ( (lv_config_1_0= ruleConfig ) ) ( (lv_rules_2_0= ruleTransformationRule ) )* ) ;
    public final EObject ruleBXtendDSL() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodels_0_0 = null;

        EObject lv_config_1_0 = null;

        EObject lv_rules_2_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:71:2: ( ( ( (lv_metamodels_0_0= ruleMetamodels ) ) ( (lv_config_1_0= ruleConfig ) ) ( (lv_rules_2_0= ruleTransformationRule ) )* ) )
            // InternalBXtendDSLParser.g:72:2: ( ( (lv_metamodels_0_0= ruleMetamodels ) ) ( (lv_config_1_0= ruleConfig ) ) ( (lv_rules_2_0= ruleTransformationRule ) )* )
            {
            // InternalBXtendDSLParser.g:72:2: ( ( (lv_metamodels_0_0= ruleMetamodels ) ) ( (lv_config_1_0= ruleConfig ) ) ( (lv_rules_2_0= ruleTransformationRule ) )* )
            // InternalBXtendDSLParser.g:73:3: ( (lv_metamodels_0_0= ruleMetamodels ) ) ( (lv_config_1_0= ruleConfig ) ) ( (lv_rules_2_0= ruleTransformationRule ) )*
            {
            // InternalBXtendDSLParser.g:73:3: ( (lv_metamodels_0_0= ruleMetamodels ) )
            // InternalBXtendDSLParser.g:74:4: (lv_metamodels_0_0= ruleMetamodels )
            {
            // InternalBXtendDSLParser.g:74:4: (lv_metamodels_0_0= ruleMetamodels )
            // InternalBXtendDSLParser.g:75:5: lv_metamodels_0_0= ruleMetamodels
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBXtendDSLAccess().getMetamodelsMetamodelsParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_metamodels_0_0=ruleMetamodels();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBXtendDSLRule());
              					}
              					set(
              						current,
              						"metamodels",
              						lv_metamodels_0_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Metamodels");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:92:3: ( (lv_config_1_0= ruleConfig ) )
            // InternalBXtendDSLParser.g:93:4: (lv_config_1_0= ruleConfig )
            {
            // InternalBXtendDSLParser.g:93:4: (lv_config_1_0= ruleConfig )
            // InternalBXtendDSLParser.g:94:5: lv_config_1_0= ruleConfig
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBXtendDSLAccess().getConfigConfigParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_config_1_0=ruleConfig();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBXtendDSLRule());
              					}
              					set(
              						current,
              						"config",
              						lv_config_1_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Config");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:111:3: ( (lv_rules_2_0= ruleTransformationRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Rule) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:112:4: (lv_rules_2_0= ruleTransformationRule )
            	    {
            	    // InternalBXtendDSLParser.g:112:4: (lv_rules_2_0= ruleTransformationRule )
            	    // InternalBXtendDSLParser.g:113:5: lv_rules_2_0= ruleTransformationRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBXtendDSLAccess().getRulesTransformationRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_rules_2_0=ruleTransformationRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBXtendDSLRule());
            	      					}
            	      					add(
            	      						current,
            	      						"rules",
            	      						lv_rules_2_0,
            	      						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.TransformationRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBXtendDSL"


    // $ANTLR start "entryRuleMetamodels"
    // InternalBXtendDSLParser.g:134:1: entryRuleMetamodels returns [EObject current=null] : iv_ruleMetamodels= ruleMetamodels EOF ;
    public final EObject entryRuleMetamodels() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodels = null;


        try {
            // InternalBXtendDSLParser.g:134:51: (iv_ruleMetamodels= ruleMetamodels EOF )
            // InternalBXtendDSLParser.g:135:2: iv_ruleMetamodels= ruleMetamodels EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMetamodelsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMetamodels=ruleMetamodels();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMetamodels; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetamodels"


    // $ANTLR start "ruleMetamodels"
    // InternalBXtendDSLParser.g:141:1: ruleMetamodels returns [EObject current=null] : (otherlv_0= Sourcemodel ( (lv_sourcemodel_1_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? otherlv_5= Targetmodel ( (lv_targetmodel_6_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )? ) ;
    public final EObject ruleMetamodels() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_sourcemodel_1_0=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_2=null;
        Token this_TAB_INDENTED_BLOCK_END_4=null;
        Token otherlv_5=null;
        Token lv_targetmodel_6_0=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_7=null;
        Token this_TAB_INDENTED_BLOCK_END_9=null;
        EObject lv_customizedSrcElements_3_0 = null;

        EObject lv_customizedTrgElements_8_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:147:2: ( (otherlv_0= Sourcemodel ( (lv_sourcemodel_1_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? otherlv_5= Targetmodel ( (lv_targetmodel_6_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )? ) )
            // InternalBXtendDSLParser.g:148:2: (otherlv_0= Sourcemodel ( (lv_sourcemodel_1_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? otherlv_5= Targetmodel ( (lv_targetmodel_6_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )? )
            {
            // InternalBXtendDSLParser.g:148:2: (otherlv_0= Sourcemodel ( (lv_sourcemodel_1_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? otherlv_5= Targetmodel ( (lv_targetmodel_6_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )? )
            // InternalBXtendDSLParser.g:149:3: otherlv_0= Sourcemodel ( (lv_sourcemodel_1_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? otherlv_5= Targetmodel ( (lv_targetmodel_6_0= RULE_STRING ) ) (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )?
            {
            otherlv_0=(Token)match(input,Sourcemodel,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMetamodelsAccess().getSourcemodelKeyword_0());
              		
            }
            // InternalBXtendDSLParser.g:153:3: ( (lv_sourcemodel_1_0= RULE_STRING ) )
            // InternalBXtendDSLParser.g:154:4: (lv_sourcemodel_1_0= RULE_STRING )
            {
            // InternalBXtendDSLParser.g:154:4: (lv_sourcemodel_1_0= RULE_STRING )
            // InternalBXtendDSLParser.g:155:5: lv_sourcemodel_1_0= RULE_STRING
            {
            lv_sourcemodel_1_0=(Token)match(input,RULE_STRING,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_sourcemodel_1_0, grammarAccess.getMetamodelsAccess().getSourcemodelSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMetamodelsRule());
              					}
              					setWithLastConsumed(
              						current,
              						"sourcemodel",
              						lv_sourcemodel_1_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.STRING");
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:171:3: (this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBXtendDSLParser.g:172:4: this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END
                    {
                    this_TAB_INDENTED_BLOCK_BEGIN_2=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_2, grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2_0());
                      			
                    }
                    // InternalBXtendDSLParser.g:176:4: ( (lv_customizedSrcElements_3_0= ruleCustomizedElement ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=Get && LA2_0<=Set)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:177:5: (lv_customizedSrcElements_3_0= ruleCustomizedElement )
                    	    {
                    	    // InternalBXtendDSLParser.g:177:5: (lv_customizedSrcElements_3_0= ruleCustomizedElement )
                    	    // InternalBXtendDSLParser.g:178:6: lv_customizedSrcElements_3_0= ruleCustomizedElement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsCustomizedElementParserRuleCall_2_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_customizedSrcElements_3_0=ruleCustomizedElement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getMetamodelsRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"customizedSrcElements",
                    	      							lv_customizedSrcElements_3_0,
                    	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.CustomizedElement");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    this_TAB_INDENTED_BLOCK_END_4=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_END_4, grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_2_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,Targetmodel,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getMetamodelsAccess().getTargetmodelKeyword_3());
              		
            }
            // InternalBXtendDSLParser.g:204:3: ( (lv_targetmodel_6_0= RULE_STRING ) )
            // InternalBXtendDSLParser.g:205:4: (lv_targetmodel_6_0= RULE_STRING )
            {
            // InternalBXtendDSLParser.g:205:4: (lv_targetmodel_6_0= RULE_STRING )
            // InternalBXtendDSLParser.g:206:5: lv_targetmodel_6_0= RULE_STRING
            {
            lv_targetmodel_6_0=(Token)match(input,RULE_STRING,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_targetmodel_6_0, grammarAccess.getMetamodelsAccess().getTargetmodelSTRINGTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMetamodelsRule());
              					}
              					setWithLastConsumed(
              						current,
              						"targetmodel",
              						lv_targetmodel_6_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.STRING");
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:222:3: (this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBXtendDSLParser.g:223:4: this_TAB_INDENTED_BLOCK_BEGIN_7= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+ this_TAB_INDENTED_BLOCK_END_9= RULE_TAB_INDENTED_BLOCK_END
                    {
                    this_TAB_INDENTED_BLOCK_BEGIN_7=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_7, grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0());
                      			
                    }
                    // InternalBXtendDSLParser.g:227:4: ( (lv_customizedTrgElements_8_0= ruleCustomizedElement ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=Get && LA4_0<=Set)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:228:5: (lv_customizedTrgElements_8_0= ruleCustomizedElement )
                    	    {
                    	    // InternalBXtendDSLParser.g:228:5: (lv_customizedTrgElements_8_0= ruleCustomizedElement )
                    	    // InternalBXtendDSLParser.g:229:6: lv_customizedTrgElements_8_0= ruleCustomizedElement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsCustomizedElementParserRuleCall_5_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_customizedTrgElements_8_0=ruleCustomizedElement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getMetamodelsRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"customizedTrgElements",
                    	      							lv_customizedTrgElements_8_0,
                    	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.CustomizedElement");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    this_TAB_INDENTED_BLOCK_END_9=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_END_9, grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetamodels"


    // $ANTLR start "entryRuleCustomizedElement"
    // InternalBXtendDSLParser.g:255:1: entryRuleCustomizedElement returns [EObject current=null] : iv_ruleCustomizedElement= ruleCustomizedElement EOF ;
    public final EObject entryRuleCustomizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomizedElement = null;


        try {
            // InternalBXtendDSLParser.g:255:58: (iv_ruleCustomizedElement= ruleCustomizedElement EOF )
            // InternalBXtendDSLParser.g:256:2: iv_ruleCustomizedElement= ruleCustomizedElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomizedElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCustomizedElement=ruleCustomizedElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomizedElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomizedElement"


    // $ANTLR start "ruleCustomizedElement"
    // InternalBXtendDSLParser.g:262:1: ruleCustomizedElement returns [EObject current=null] : (this_CustomizedGetter_0= ruleCustomizedGetter | this_CustomizedSetter_1= ruleCustomizedSetter ) ;
    public final EObject ruleCustomizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_CustomizedGetter_0 = null;

        EObject this_CustomizedSetter_1 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:268:2: ( (this_CustomizedGetter_0= ruleCustomizedGetter | this_CustomizedSetter_1= ruleCustomizedSetter ) )
            // InternalBXtendDSLParser.g:269:2: (this_CustomizedGetter_0= ruleCustomizedGetter | this_CustomizedSetter_1= ruleCustomizedSetter )
            {
            // InternalBXtendDSLParser.g:269:2: (this_CustomizedGetter_0= ruleCustomizedGetter | this_CustomizedSetter_1= ruleCustomizedSetter )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Get) ) {
                alt6=1;
            }
            else if ( (LA6_0==Set) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBXtendDSLParser.g:270:3: this_CustomizedGetter_0= ruleCustomizedGetter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCustomizedElementAccess().getCustomizedGetterParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CustomizedGetter_0=ruleCustomizedGetter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CustomizedGetter_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:279:3: this_CustomizedSetter_1= ruleCustomizedSetter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCustomizedElementAccess().getCustomizedSetterParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CustomizedSetter_1=ruleCustomizedSetter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CustomizedSetter_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomizedElement"


    // $ANTLR start "entryRuleCustomizedGetter"
    // InternalBXtendDSLParser.g:291:1: entryRuleCustomizedGetter returns [EObject current=null] : iv_ruleCustomizedGetter= ruleCustomizedGetter EOF ;
    public final EObject entryRuleCustomizedGetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomizedGetter = null;


        try {
            // InternalBXtendDSLParser.g:291:57: (iv_ruleCustomizedGetter= ruleCustomizedGetter EOF )
            // InternalBXtendDSLParser.g:292:2: iv_ruleCustomizedGetter= ruleCustomizedGetter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomizedGetterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCustomizedGetter=ruleCustomizedGetter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomizedGetter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomizedGetter"


    // $ANTLR start "ruleCustomizedGetter"
    // InternalBXtendDSLParser.g:298:1: ruleCustomizedGetter returns [EObject current=null] : (otherlv_0= Get ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) ) ;
    public final EObject ruleCustomizedGetter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_customId_3_0=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:304:2: ( (otherlv_0= Get ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) ) )
            // InternalBXtendDSLParser.g:305:2: (otherlv_0= Get ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) )
            {
            // InternalBXtendDSLParser.g:305:2: (otherlv_0= Get ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) )
            // InternalBXtendDSLParser.g:306:3: otherlv_0= Get ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Get,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCustomizedGetterAccess().getGetKeyword_0());
              		
            }
            // InternalBXtendDSLParser.g:310:3: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:311:4: ( ruleFeatureAccess )
            {
            // InternalBXtendDSLParser.g:311:4: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:312:5: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCustomizedGetterRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCustomizedGetterAccess().getElementEStructuralFeatureCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,As,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCustomizedGetterAccess().getAsKeyword_2());
              		
            }
            // InternalBXtendDSLParser.g:330:3: ( (lv_customId_3_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:331:4: (lv_customId_3_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:331:4: (lv_customId_3_0= RULE_ID )
            // InternalBXtendDSLParser.g:332:5: lv_customId_3_0= RULE_ID
            {
            lv_customId_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_customId_3_0, grammarAccess.getCustomizedGetterAccess().getCustomIdIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCustomizedGetterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"customId",
              						lv_customId_3_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomizedGetter"


    // $ANTLR start "entryRuleCustomizedSetter"
    // InternalBXtendDSLParser.g:352:1: entryRuleCustomizedSetter returns [EObject current=null] : iv_ruleCustomizedSetter= ruleCustomizedSetter EOF ;
    public final EObject entryRuleCustomizedSetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomizedSetter = null;


        try {
            // InternalBXtendDSLParser.g:352:57: (iv_ruleCustomizedSetter= ruleCustomizedSetter EOF )
            // InternalBXtendDSLParser.g:353:2: iv_ruleCustomizedSetter= ruleCustomizedSetter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomizedSetterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCustomizedSetter=ruleCustomizedSetter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomizedSetter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomizedSetter"


    // $ANTLR start "ruleCustomizedSetter"
    // InternalBXtendDSLParser.g:359:1: ruleCustomizedSetter returns [EObject current=null] : (otherlv_0= Set ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) ) ;
    public final EObject ruleCustomizedSetter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_customId_3_0=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:365:2: ( (otherlv_0= Set ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) ) )
            // InternalBXtendDSLParser.g:366:2: (otherlv_0= Set ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) )
            {
            // InternalBXtendDSLParser.g:366:2: (otherlv_0= Set ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) ) )
            // InternalBXtendDSLParser.g:367:3: otherlv_0= Set ( ( ruleFeatureAccess ) ) otherlv_2= As ( (lv_customId_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Set,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCustomizedSetterAccess().getSetKeyword_0());
              		
            }
            // InternalBXtendDSLParser.g:371:3: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:372:4: ( ruleFeatureAccess )
            {
            // InternalBXtendDSLParser.g:372:4: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:373:5: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCustomizedSetterRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCustomizedSetterAccess().getElementEStructuralFeatureCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,As,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCustomizedSetterAccess().getAsKeyword_2());
              		
            }
            // InternalBXtendDSLParser.g:391:3: ( (lv_customId_3_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:392:4: (lv_customId_3_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:392:4: (lv_customId_3_0= RULE_ID )
            // InternalBXtendDSLParser.g:393:5: lv_customId_3_0= RULE_ID
            {
            lv_customId_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_customId_3_0, grammarAccess.getCustomizedSetterAccess().getCustomIdIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCustomizedSetterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"customId",
              						lv_customId_3_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomizedSetter"


    // $ANTLR start "entryRuleConfig"
    // InternalBXtendDSLParser.g:413:1: entryRuleConfig returns [EObject current=null] : iv_ruleConfig= ruleConfig EOF ;
    public final EObject entryRuleConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfig = null;


        try {
            // InternalBXtendDSLParser.g:413:47: (iv_ruleConfig= ruleConfig EOF )
            // InternalBXtendDSLParser.g:414:2: iv_ruleConfig= ruleConfig EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConfig=ruleConfig();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConfig; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // InternalBXtendDSLParser.g:420:1: ruleConfig returns [EObject current=null] : ( () (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? ) ;
    public final EObject ruleConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_2=null;
        Token lv_options_3_0=null;
        Token this_TAB_INDENTED_BLOCK_END_4=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:426:2: ( ( () (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? ) )
            // InternalBXtendDSLParser.g:427:2: ( () (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? )
            {
            // InternalBXtendDSLParser.g:427:2: ( () (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )? )
            // InternalBXtendDSLParser.g:428:3: () (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )?
            {
            // InternalBXtendDSLParser.g:428:3: ()
            // InternalBXtendDSLParser.g:429:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getConfigAccess().getConfigAction_0(),
              					current);
              			
            }

            }

            // InternalBXtendDSLParser.g:435:3: (otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Options) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBXtendDSLParser.g:436:4: otherlv_1= Options this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_options_3_0= RULE_ID ) )+ this_TAB_INDENTED_BLOCK_END_4= RULE_TAB_INDENTED_BLOCK_END
                    {
                    otherlv_1=(Token)match(input,Options,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getConfigAccess().getOptionsKeyword_1_0());
                      			
                    }
                    this_TAB_INDENTED_BLOCK_BEGIN_2=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_2, grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_1_1());
                      			
                    }
                    // InternalBXtendDSLParser.g:444:4: ( (lv_options_3_0= RULE_ID ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:445:5: (lv_options_3_0= RULE_ID )
                    	    {
                    	    // InternalBXtendDSLParser.g:445:5: (lv_options_3_0= RULE_ID )
                    	    // InternalBXtendDSLParser.g:446:6: lv_options_3_0= RULE_ID
                    	    {
                    	    lv_options_3_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(lv_options_3_0, grammarAccess.getConfigAccess().getOptionsIDTerminalRuleCall_1_2_0());
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElement(grammarAccess.getConfigRule());
                    	      						}
                    	      						addWithLastConsumed(
                    	      							current,
                    	      							"options",
                    	      							lv_options_3_0,
                    	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    this_TAB_INDENTED_BLOCK_END_4=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_END_4, grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRuleTransformationRule"
    // InternalBXtendDSLParser.g:471:1: entryRuleTransformationRule returns [EObject current=null] : iv_ruleTransformationRule= ruleTransformationRule EOF ;
    public final EObject entryRuleTransformationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationRule = null;


        try {
            // InternalBXtendDSLParser.g:471:59: (iv_ruleTransformationRule= ruleTransformationRule EOF )
            // InternalBXtendDSLParser.g:472:2: iv_ruleTransformationRule= ruleTransformationRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTransformationRule=ruleTransformationRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationRule"


    // $ANTLR start "ruleTransformationRule"
    // InternalBXtendDSLParser.g:478:1: ruleTransformationRule returns [EObject current=null] : (otherlv_0= Rule ( (lv_name_1_0= RULE_ID ) ) this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN otherlv_3= Src ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )? otherlv_8= Trg ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )? ( (lv_mappings_13_0= ruleFeatureMapping ) )* this_TAB_INDENTED_BLOCK_END_14= RULE_TAB_INDENTED_BLOCK_END ) ;
    public final EObject ruleTransformationRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_5=null;
        Token this_TAB_INDENTED_BLOCK_END_7=null;
        Token otherlv_8=null;
        Token this_TAB_INDENTED_BLOCK_BEGIN_10=null;
        Token this_TAB_INDENTED_BLOCK_END_12=null;
        Token this_TAB_INDENTED_BLOCK_END_14=null;
        EObject lv_srcMatcher_4_0 = null;

        EObject lv_srcMatcher_6_0 = null;

        EObject lv_trgMatcher_9_0 = null;

        EObject lv_trgMatcher_11_0 = null;

        EObject lv_mappings_13_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:484:2: ( (otherlv_0= Rule ( (lv_name_1_0= RULE_ID ) ) this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN otherlv_3= Src ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )? otherlv_8= Trg ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )? ( (lv_mappings_13_0= ruleFeatureMapping ) )* this_TAB_INDENTED_BLOCK_END_14= RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:485:2: (otherlv_0= Rule ( (lv_name_1_0= RULE_ID ) ) this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN otherlv_3= Src ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )? otherlv_8= Trg ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )? ( (lv_mappings_13_0= ruleFeatureMapping ) )* this_TAB_INDENTED_BLOCK_END_14= RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:485:2: (otherlv_0= Rule ( (lv_name_1_0= RULE_ID ) ) this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN otherlv_3= Src ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )? otherlv_8= Trg ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )? ( (lv_mappings_13_0= ruleFeatureMapping ) )* this_TAB_INDENTED_BLOCK_END_14= RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:486:3: otherlv_0= Rule ( (lv_name_1_0= RULE_ID ) ) this_TAB_INDENTED_BLOCK_BEGIN_2= RULE_TAB_INDENTED_BLOCK_BEGIN otherlv_3= Src ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )? otherlv_8= Trg ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) ) (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )? ( (lv_mappings_13_0= ruleFeatureMapping ) )* this_TAB_INDENTED_BLOCK_END_14= RULE_TAB_INDENTED_BLOCK_END
            {
            otherlv_0=(Token)match(input,Rule,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTransformationRuleAccess().getRuleKeyword_0());
              		
            }
            // InternalBXtendDSLParser.g:490:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:491:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:491:4: (lv_name_1_0= RULE_ID )
            // InternalBXtendDSLParser.g:492:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTransformationRuleAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTransformationRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
              				
            }

            }


            }

            this_TAB_INDENTED_BLOCK_BEGIN_2=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_2, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2());
              		
            }
            otherlv_3=(Token)match(input,Src,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTransformationRuleAccess().getSrcKeyword_3());
              		
            }
            // InternalBXtendDSLParser.g:516:3: ( (lv_srcMatcher_4_0= ruleSrcClassMatcher ) )
            // InternalBXtendDSLParser.g:517:4: (lv_srcMatcher_4_0= ruleSrcClassMatcher )
            {
            // InternalBXtendDSLParser.g:517:4: (lv_srcMatcher_4_0= ruleSrcClassMatcher )
            // InternalBXtendDSLParser.g:518:5: lv_srcMatcher_4_0= ruleSrcClassMatcher
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_srcMatcher_4_0=ruleSrcClassMatcher();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTransformationRuleRule());
              					}
              					add(
              						current,
              						"srcMatcher",
              						lv_srcMatcher_4_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.SrcClassMatcher");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:535:3: (this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBXtendDSLParser.g:536:4: this_TAB_INDENTED_BLOCK_BEGIN_5= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_7= RULE_TAB_INDENTED_BLOCK_END
                    {
                    this_TAB_INDENTED_BLOCK_BEGIN_5=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_5, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0());
                      			
                    }
                    // InternalBXtendDSLParser.g:540:4: ( (lv_srcMatcher_6_0= ruleSrcClassMatcher ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:541:5: (lv_srcMatcher_6_0= ruleSrcClassMatcher )
                    	    {
                    	    // InternalBXtendDSLParser.g:541:5: (lv_srcMatcher_6_0= ruleSrcClassMatcher )
                    	    // InternalBXtendDSLParser.g:542:6: lv_srcMatcher_6_0= ruleSrcClassMatcher
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_5_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_srcMatcher_6_0=ruleSrcClassMatcher();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getTransformationRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"srcMatcher",
                    	      							lv_srcMatcher_6_0,
                    	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.SrcClassMatcher");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    this_TAB_INDENTED_BLOCK_END_7=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_END_7, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,Trg,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getTransformationRuleAccess().getTrgKeyword_6());
              		
            }
            // InternalBXtendDSLParser.g:568:3: ( (lv_trgMatcher_9_0= ruleTrgClassMatcher ) )
            // InternalBXtendDSLParser.g:569:4: (lv_trgMatcher_9_0= ruleTrgClassMatcher )
            {
            // InternalBXtendDSLParser.g:569:4: (lv_trgMatcher_9_0= ruleTrgClassMatcher )
            // InternalBXtendDSLParser.g:570:5: lv_trgMatcher_9_0= ruleTrgClassMatcher
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_7_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_trgMatcher_9_0=ruleTrgClassMatcher();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTransformationRuleRule());
              					}
              					add(
              						current,
              						"trgMatcher",
              						lv_trgMatcher_9_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.TrgClassMatcher");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:587:3: (this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBXtendDSLParser.g:588:4: this_TAB_INDENTED_BLOCK_BEGIN_10= RULE_TAB_INDENTED_BLOCK_BEGIN ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+ this_TAB_INDENTED_BLOCK_END_12= RULE_TAB_INDENTED_BLOCK_END
                    {
                    this_TAB_INDENTED_BLOCK_BEGIN_10=(Token)match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_BEGIN_10, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_8_0());
                      			
                    }
                    // InternalBXtendDSLParser.g:592:4: ( (lv_trgMatcher_11_0= ruleTrgClassMatcher ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:593:5: (lv_trgMatcher_11_0= ruleTrgClassMatcher )
                    	    {
                    	    // InternalBXtendDSLParser.g:593:5: (lv_trgMatcher_11_0= ruleTrgClassMatcher )
                    	    // InternalBXtendDSLParser.g:594:6: lv_trgMatcher_11_0= ruleTrgClassMatcher
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_8_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_trgMatcher_11_0=ruleTrgClassMatcher();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getTransformationRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"trgMatcher",
                    	      							lv_trgMatcher_11_0,
                    	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.TrgClassMatcher");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    this_TAB_INDENTED_BLOCK_END_12=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TAB_INDENTED_BLOCK_END_12, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_8_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBXtendDSLParser.g:616:3: ( (lv_mappings_13_0= ruleFeatureMapping ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==LeftCurlyBracket||LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:617:4: (lv_mappings_13_0= ruleFeatureMapping )
            	    {
            	    // InternalBXtendDSLParser.g:617:4: (lv_mappings_13_0= ruleFeatureMapping )
            	    // InternalBXtendDSLParser.g:618:5: lv_mappings_13_0= ruleFeatureMapping
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTransformationRuleAccess().getMappingsFeatureMappingParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_mappings_13_0=ruleFeatureMapping();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTransformationRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"mappings",
            	      						lv_mappings_13_0,
            	      						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.FeatureMapping");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            this_TAB_INDENTED_BLOCK_END_14=(Token)match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TAB_INDENTED_BLOCK_END_14, grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_10());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationRule"


    // $ANTLR start "entryRuleSrcClassMatcher"
    // InternalBXtendDSLParser.g:643:1: entryRuleSrcClassMatcher returns [EObject current=null] : iv_ruleSrcClassMatcher= ruleSrcClassMatcher EOF ;
    public final EObject entryRuleSrcClassMatcher() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSrcClassMatcher = null;


        try {
            // InternalBXtendDSLParser.g:643:56: (iv_ruleSrcClassMatcher= ruleSrcClassMatcher EOF )
            // InternalBXtendDSLParser.g:644:2: iv_ruleSrcClassMatcher= ruleSrcClassMatcher EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSrcClassMatcherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSrcClassMatcher=ruleSrcClassMatcher();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSrcClassMatcher; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSrcClassMatcher"


    // $ANTLR start "ruleSrcClassMatcher"
    // InternalBXtendDSLParser.g:650:1: ruleSrcClassMatcher returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleSrcClassMatcher() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_modifier_2_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:656:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon ) )
            // InternalBXtendDSLParser.g:657:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon )
            {
            // InternalBXtendDSLParser.g:657:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon )
            // InternalBXtendDSLParser.g:658:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon
            {
            // InternalBXtendDSLParser.g:658:3: ( (otherlv_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:659:4: (otherlv_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:659:4: (otherlv_0= RULE_ID )
            // InternalBXtendDSLParser.g:660:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSrcClassMatcherRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getSrcClassMatcherAccess().getClazzEClassCrossReference_0_0());
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:671:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:672:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:672:4: (lv_name_1_0= RULE_ID )
            // InternalBXtendDSLParser.g:673:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSrcClassMatcherAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSrcClassMatcherRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:689:3: ( (lv_modifier_2_0= ruleClassMatcherModifier ) )
            // InternalBXtendDSLParser.g:690:4: (lv_modifier_2_0= ruleClassMatcherModifier )
            {
            // InternalBXtendDSLParser.g:690:4: (lv_modifier_2_0= ruleClassMatcherModifier )
            // InternalBXtendDSLParser.g:691:5: lv_modifier_2_0= ruleClassMatcherModifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSrcClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_modifier_2_0=ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSrcClassMatcherRule());
              					}
              					set(
              						current,
              						"modifier",
              						lv_modifier_2_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ClassMatcherModifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSrcClassMatcherAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSrcClassMatcher"


    // $ANTLR start "entryRuleTrgClassMatcher"
    // InternalBXtendDSLParser.g:716:1: entryRuleTrgClassMatcher returns [EObject current=null] : iv_ruleTrgClassMatcher= ruleTrgClassMatcher EOF ;
    public final EObject entryRuleTrgClassMatcher() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrgClassMatcher = null;


        try {
            // InternalBXtendDSLParser.g:716:56: (iv_ruleTrgClassMatcher= ruleTrgClassMatcher EOF )
            // InternalBXtendDSLParser.g:717:2: iv_ruleTrgClassMatcher= ruleTrgClassMatcher EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTrgClassMatcherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTrgClassMatcher=ruleTrgClassMatcher();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTrgClassMatcher; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrgClassMatcher"


    // $ANTLR start "ruleTrgClassMatcher"
    // InternalBXtendDSLParser.g:723:1: ruleTrgClassMatcher returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleTrgClassMatcher() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_modifier_2_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:729:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon ) )
            // InternalBXtendDSLParser.g:730:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon )
            {
            // InternalBXtendDSLParser.g:730:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon )
            // InternalBXtendDSLParser.g:731:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_modifier_2_0= ruleClassMatcherModifier ) ) otherlv_3= Semicolon
            {
            // InternalBXtendDSLParser.g:731:3: ( (otherlv_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:732:4: (otherlv_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:732:4: (otherlv_0= RULE_ID )
            // InternalBXtendDSLParser.g:733:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTrgClassMatcherRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getTrgClassMatcherAccess().getClazzEClassCrossReference_0_0());
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:744:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:745:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:745:4: (lv_name_1_0= RULE_ID )
            // InternalBXtendDSLParser.g:746:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTrgClassMatcherAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTrgClassMatcherRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ID");
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:762:3: ( (lv_modifier_2_0= ruleClassMatcherModifier ) )
            // InternalBXtendDSLParser.g:763:4: (lv_modifier_2_0= ruleClassMatcherModifier )
            {
            // InternalBXtendDSLParser.g:763:4: (lv_modifier_2_0= ruleClassMatcherModifier )
            // InternalBXtendDSLParser.g:764:5: lv_modifier_2_0= ruleClassMatcherModifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTrgClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_modifier_2_0=ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTrgClassMatcherRule());
              					}
              					set(
              						current,
              						"modifier",
              						lv_modifier_2_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.ClassMatcherModifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTrgClassMatcherAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrgClassMatcher"


    // $ANTLR start "entryRuleClassMatcherModifier"
    // InternalBXtendDSLParser.g:789:1: entryRuleClassMatcherModifier returns [EObject current=null] : iv_ruleClassMatcherModifier= ruleClassMatcherModifier EOF ;
    public final EObject entryRuleClassMatcherModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassMatcherModifier = null;


        try {
            // InternalBXtendDSLParser.g:789:61: (iv_ruleClassMatcherModifier= ruleClassMatcherModifier EOF )
            // InternalBXtendDSLParser.g:790:2: iv_ruleClassMatcherModifier= ruleClassMatcherModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassMatcherModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassMatcherModifier=ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassMatcherModifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassMatcherModifier"


    // $ANTLR start "ruleClassMatcherModifier"
    // InternalBXtendDSLParser.g:796:1: ruleClassMatcherModifier returns [EObject current=null] : ( () ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )? ) ;
    public final EObject ruleClassMatcherModifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_filter_3_0=null;
        Token otherlv_4=null;
        Token lv_sort_5_0=null;
        Token otherlv_6=null;
        Token lv_creation_7_0=null;
        Token otherlv_8=null;
        Token lv_deletion_9_0=null;
        Token otherlv_10=null;
        Token lv_group_11_0=null;
        Token otherlv_12=null;
        Token lv_group_14_0=null;
        Token otherlv_15=null;
        Token lv_sort_16_0=null;
        Token otherlv_17=null;
        Token lv_creation_18_0=null;
        Token otherlv_19=null;
        Token lv_deletion_20_0=null;
        Token otherlv_21=null;
        Token lv_filter_22_0=null;
        Token otherlv_23=null;
        Token lv_group_25_0=null;
        Token otherlv_26=null;
        Token lv_filter_27_0=null;
        Token otherlv_28=null;
        Token lv_creation_29_0=null;
        Token otherlv_30=null;
        Token lv_deletion_31_0=null;
        Token otherlv_32=null;
        Token lv_sort_33_0=null;
        Token otherlv_34=null;
        Token lv_group_36_0=null;
        Token otherlv_37=null;
        Token lv_filter_38_0=null;
        Token otherlv_39=null;
        Token lv_sort_40_0=null;
        Token otherlv_41=null;
        Token lv_deletion_42_0=null;
        Token otherlv_43=null;
        Token lv_creation_44_0=null;
        Token otherlv_45=null;
        Token lv_group_47_0=null;
        Token otherlv_48=null;
        Token lv_filter_49_0=null;
        Token otherlv_50=null;
        Token lv_sort_51_0=null;
        Token otherlv_52=null;
        Token lv_creation_53_0=null;
        Token otherlv_54=null;
        Token lv_deletion_55_0=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:802:2: ( ( () ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )? ) )
            // InternalBXtendDSLParser.g:803:2: ( () ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )? )
            {
            // InternalBXtendDSLParser.g:803:2: ( () ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )? )
            // InternalBXtendDSLParser.g:804:3: () ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )?
            {
            // InternalBXtendDSLParser.g:804:3: ()
            // InternalBXtendDSLParser.g:805:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getClassMatcherModifierAccess().getClassMatcherModifierAction_0(),
              					current);
              			
            }

            }

            // InternalBXtendDSLParser.g:811:3: ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )?
            int alt19=6;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalBXtendDSLParser.g:812:4: (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) )
                    {
                    // InternalBXtendDSLParser.g:812:4: (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) )
                    // InternalBXtendDSLParser.g:813:5: otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) )
                    {
                    otherlv_1=(Token)match(input,VerticalLine,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_0_0());
                      				
                    }
                    // InternalBXtendDSLParser.g:817:5: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) )
                    // InternalBXtendDSLParser.g:818:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) )
                    {
                    // InternalBXtendDSLParser.g:818:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) )
                    // InternalBXtendDSLParser.g:819:7: ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());
                    // InternalBXtendDSLParser.g:822:7: ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* )
                    // InternalBXtendDSLParser.g:823:8: ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )*
                    {
                    // InternalBXtendDSLParser.g:823:8: ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )*
                    loop14:
                    do {
                        int alt14=5;
                        int LA14_0 = input.LA(1);

                        if ( LA14_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                            alt14=1;
                        }
                        else if ( LA14_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                            alt14=2;
                        }
                        else if ( LA14_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                            alt14=3;
                        }
                        else if ( LA14_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                            alt14=4;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:824:6: ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:824:6: ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:825:7: {...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0)");
                    	    }
                    	    // InternalBXtendDSLParser.g:825:123: ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:826:8: ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0);
                    	    // InternalBXtendDSLParser.g:829:11: ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) )
                    	    // InternalBXtendDSLParser.g:829:12: {...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:829:21: ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma )
                    	    // InternalBXtendDSLParser.g:829:22: ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:829:22: ( (lv_filter_3_0= Filter ) )
                    	    // InternalBXtendDSLParser.g:830:12: (lv_filter_3_0= Filter )
                    	    {
                    	    // InternalBXtendDSLParser.g:830:12: (lv_filter_3_0= Filter )
                    	    // InternalBXtendDSLParser.g:831:13: lv_filter_3_0= Filter
                    	    {
                    	    lv_filter_3_0=(Token)match(input,Filter,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_filter_3_0, grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "filter", true, "filter");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_4, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_0_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLParser.g:853:6: ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:853:6: ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:854:7: {...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1)");
                    	    }
                    	    // InternalBXtendDSLParser.g:854:123: ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:855:8: ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1);
                    	    // InternalBXtendDSLParser.g:858:11: ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) )
                    	    // InternalBXtendDSLParser.g:858:12: {...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:858:21: ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma )
                    	    // InternalBXtendDSLParser.g:858:22: ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:858:22: ( (lv_sort_5_0= Sort ) )
                    	    // InternalBXtendDSLParser.g:859:12: (lv_sort_5_0= Sort )
                    	    {
                    	    // InternalBXtendDSLParser.g:859:12: (lv_sort_5_0= Sort )
                    	    // InternalBXtendDSLParser.g:860:13: lv_sort_5_0= Sort
                    	    {
                    	    lv_sort_5_0=(Token)match(input,Sort,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_sort_5_0, grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "sort", true, "sort");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_6=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_6, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_1_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBXtendDSLParser.g:882:6: ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:882:6: ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:883:7: {...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2)");
                    	    }
                    	    // InternalBXtendDSLParser.g:883:123: ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:884:8: ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2);
                    	    // InternalBXtendDSLParser.g:887:11: ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) )
                    	    // InternalBXtendDSLParser.g:887:12: {...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:887:21: ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma )
                    	    // InternalBXtendDSLParser.g:887:22: ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:887:22: ( (lv_creation_7_0= Creation ) )
                    	    // InternalBXtendDSLParser.g:888:12: (lv_creation_7_0= Creation )
                    	    {
                    	    // InternalBXtendDSLParser.g:888:12: (lv_creation_7_0= Creation )
                    	    // InternalBXtendDSLParser.g:889:13: lv_creation_7_0= Creation
                    	    {
                    	    lv_creation_7_0=(Token)match(input,Creation,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_creation_7_0, grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "creation", true, "creation");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_8, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_2_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalBXtendDSLParser.g:911:6: ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:911:6: ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:912:7: {...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3)");
                    	    }
                    	    // InternalBXtendDSLParser.g:912:123: ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:913:8: ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3);
                    	    // InternalBXtendDSLParser.g:916:11: ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) )
                    	    // InternalBXtendDSLParser.g:916:12: {...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:916:21: ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma )
                    	    // InternalBXtendDSLParser.g:916:22: ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:916:22: ( (lv_deletion_9_0= Deletion ) )
                    	    // InternalBXtendDSLParser.g:917:12: (lv_deletion_9_0= Deletion )
                    	    {
                    	    // InternalBXtendDSLParser.g:917:12: (lv_deletion_9_0= Deletion )
                    	    // InternalBXtendDSLParser.g:918:13: lv_deletion_9_0= Deletion
                    	    {
                    	    lv_deletion_9_0=(Token)match(input,Deletion,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_deletion_9_0, grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "deletion", true, "deletion");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_10, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_3_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());

                    }

                    // InternalBXtendDSLParser.g:947:5: ( (lv_group_11_0= Group ) )
                    // InternalBXtendDSLParser.g:948:6: (lv_group_11_0= Group )
                    {
                    // InternalBXtendDSLParser.g:948:6: (lv_group_11_0= Group )
                    // InternalBXtendDSLParser.g:949:7: lv_group_11_0= Group
                    {
                    lv_group_11_0=(Token)match(input,Group,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_group_11_0, grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                      							}
                      							setWithLastConsumed(current, "group", true, "group");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:963:4: (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) )
                    {
                    // InternalBXtendDSLParser.g:963:4: (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) )
                    // InternalBXtendDSLParser.g:964:5: otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) )
                    {
                    otherlv_12=(Token)match(input,VerticalLine,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_12, grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_1_0());
                      				
                    }
                    // InternalBXtendDSLParser.g:968:5: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) )
                    // InternalBXtendDSLParser.g:969:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) )
                    {
                    // InternalBXtendDSLParser.g:969:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) )
                    // InternalBXtendDSLParser.g:970:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());
                    // InternalBXtendDSLParser.g:973:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* )
                    // InternalBXtendDSLParser.g:974:8: ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )*
                    {
                    // InternalBXtendDSLParser.g:974:8: ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )*
                    loop15:
                    do {
                        int alt15=5;
                        int LA15_0 = input.LA(1);

                        if ( LA15_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                            alt15=1;
                        }
                        else if ( LA15_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                            alt15=2;
                        }
                        else if ( LA15_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                            alt15=3;
                        }
                        else if ( LA15_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                            alt15=4;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:975:6: ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:975:6: ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:976:7: {...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0)");
                    	    }
                    	    // InternalBXtendDSLParser.g:976:123: ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:977:8: ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0);
                    	    // InternalBXtendDSLParser.g:980:11: ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) )
                    	    // InternalBXtendDSLParser.g:980:12: {...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:980:21: ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma )
                    	    // InternalBXtendDSLParser.g:980:22: ( (lv_group_14_0= Group ) ) otherlv_15= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:980:22: ( (lv_group_14_0= Group ) )
                    	    // InternalBXtendDSLParser.g:981:12: (lv_group_14_0= Group )
                    	    {
                    	    // InternalBXtendDSLParser.g:981:12: (lv_group_14_0= Group )
                    	    // InternalBXtendDSLParser.g:982:13: lv_group_14_0= Group
                    	    {
                    	    lv_group_14_0=(Token)match(input,Group,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_group_14_0, grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "group", true, "group");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_15=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_15, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_0_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLParser.g:1004:6: ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1004:6: ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1005:7: {...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1005:123: ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1006:8: ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1);
                    	    // InternalBXtendDSLParser.g:1009:11: ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) )
                    	    // InternalBXtendDSLParser.g:1009:12: {...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1009:21: ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma )
                    	    // InternalBXtendDSLParser.g:1009:22: ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1009:22: ( (lv_sort_16_0= Sort ) )
                    	    // InternalBXtendDSLParser.g:1010:12: (lv_sort_16_0= Sort )
                    	    {
                    	    // InternalBXtendDSLParser.g:1010:12: (lv_sort_16_0= Sort )
                    	    // InternalBXtendDSLParser.g:1011:13: lv_sort_16_0= Sort
                    	    {
                    	    lv_sort_16_0=(Token)match(input,Sort,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_sort_16_0, grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "sort", true, "sort");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_17, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_1_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBXtendDSLParser.g:1033:6: ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1033:6: ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1034:7: {...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1034:123: ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1035:8: ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2);
                    	    // InternalBXtendDSLParser.g:1038:11: ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) )
                    	    // InternalBXtendDSLParser.g:1038:12: {...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1038:21: ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma )
                    	    // InternalBXtendDSLParser.g:1038:22: ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1038:22: ( (lv_creation_18_0= Creation ) )
                    	    // InternalBXtendDSLParser.g:1039:12: (lv_creation_18_0= Creation )
                    	    {
                    	    // InternalBXtendDSLParser.g:1039:12: (lv_creation_18_0= Creation )
                    	    // InternalBXtendDSLParser.g:1040:13: lv_creation_18_0= Creation
                    	    {
                    	    lv_creation_18_0=(Token)match(input,Creation,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_creation_18_0, grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "creation", true, "creation");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_19=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_19, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_2_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalBXtendDSLParser.g:1062:6: ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1062:6: ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1063:7: {...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1063:123: ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1064:8: ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3);
                    	    // InternalBXtendDSLParser.g:1067:11: ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) )
                    	    // InternalBXtendDSLParser.g:1067:12: {...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1067:21: ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma )
                    	    // InternalBXtendDSLParser.g:1067:22: ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1067:22: ( (lv_deletion_20_0= Deletion ) )
                    	    // InternalBXtendDSLParser.g:1068:12: (lv_deletion_20_0= Deletion )
                    	    {
                    	    // InternalBXtendDSLParser.g:1068:12: (lv_deletion_20_0= Deletion )
                    	    // InternalBXtendDSLParser.g:1069:13: lv_deletion_20_0= Deletion
                    	    {
                    	    lv_deletion_20_0=(Token)match(input,Deletion,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_deletion_20_0, grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "deletion", true, "deletion");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_21=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_21, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_3_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());

                    }

                    // InternalBXtendDSLParser.g:1098:5: ( (lv_filter_22_0= Filter ) )
                    // InternalBXtendDSLParser.g:1099:6: (lv_filter_22_0= Filter )
                    {
                    // InternalBXtendDSLParser.g:1099:6: (lv_filter_22_0= Filter )
                    // InternalBXtendDSLParser.g:1100:7: lv_filter_22_0= Filter
                    {
                    lv_filter_22_0=(Token)match(input,Filter,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_filter_22_0, grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                      							}
                      							setWithLastConsumed(current, "filter", true, "filter");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:1114:4: (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) )
                    {
                    // InternalBXtendDSLParser.g:1114:4: (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) )
                    // InternalBXtendDSLParser.g:1115:5: otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) )
                    {
                    otherlv_23=(Token)match(input,VerticalLine,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_23, grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_2_0());
                      				
                    }
                    // InternalBXtendDSLParser.g:1119:5: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) )
                    // InternalBXtendDSLParser.g:1120:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) )
                    {
                    // InternalBXtendDSLParser.g:1120:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) )
                    // InternalBXtendDSLParser.g:1121:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());
                    // InternalBXtendDSLParser.g:1124:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* )
                    // InternalBXtendDSLParser.g:1125:8: ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )*
                    {
                    // InternalBXtendDSLParser.g:1125:8: ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )*
                    loop16:
                    do {
                        int alt16=5;
                        int LA16_0 = input.LA(1);

                        if ( LA16_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                            alt16=1;
                        }
                        else if ( LA16_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                            alt16=2;
                        }
                        else if ( LA16_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                            alt16=3;
                        }
                        else if ( LA16_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                            alt16=4;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1126:6: ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1126:6: ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1127:7: {...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1127:123: ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1128:8: ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0);
                    	    // InternalBXtendDSLParser.g:1131:11: ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) )
                    	    // InternalBXtendDSLParser.g:1131:12: {...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1131:21: ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma )
                    	    // InternalBXtendDSLParser.g:1131:22: ( (lv_group_25_0= Group ) ) otherlv_26= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1131:22: ( (lv_group_25_0= Group ) )
                    	    // InternalBXtendDSLParser.g:1132:12: (lv_group_25_0= Group )
                    	    {
                    	    // InternalBXtendDSLParser.g:1132:12: (lv_group_25_0= Group )
                    	    // InternalBXtendDSLParser.g:1133:13: lv_group_25_0= Group
                    	    {
                    	    lv_group_25_0=(Token)match(input,Group,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_group_25_0, grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "group", true, "group");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_26=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_26, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_0_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLParser.g:1155:6: ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1155:6: ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1156:7: {...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1156:123: ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1157:8: ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1);
                    	    // InternalBXtendDSLParser.g:1160:11: ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) )
                    	    // InternalBXtendDSLParser.g:1160:12: {...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1160:21: ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma )
                    	    // InternalBXtendDSLParser.g:1160:22: ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1160:22: ( (lv_filter_27_0= Filter ) )
                    	    // InternalBXtendDSLParser.g:1161:12: (lv_filter_27_0= Filter )
                    	    {
                    	    // InternalBXtendDSLParser.g:1161:12: (lv_filter_27_0= Filter )
                    	    // InternalBXtendDSLParser.g:1162:13: lv_filter_27_0= Filter
                    	    {
                    	    lv_filter_27_0=(Token)match(input,Filter,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_filter_27_0, grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "filter", true, "filter");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_28=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_28, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_1_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBXtendDSLParser.g:1184:6: ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1184:6: ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1185:7: {...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1185:123: ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1186:8: ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2);
                    	    // InternalBXtendDSLParser.g:1189:11: ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) )
                    	    // InternalBXtendDSLParser.g:1189:12: {...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1189:21: ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma )
                    	    // InternalBXtendDSLParser.g:1189:22: ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1189:22: ( (lv_creation_29_0= Creation ) )
                    	    // InternalBXtendDSLParser.g:1190:12: (lv_creation_29_0= Creation )
                    	    {
                    	    // InternalBXtendDSLParser.g:1190:12: (lv_creation_29_0= Creation )
                    	    // InternalBXtendDSLParser.g:1191:13: lv_creation_29_0= Creation
                    	    {
                    	    lv_creation_29_0=(Token)match(input,Creation,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_creation_29_0, grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "creation", true, "creation");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_30=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_30, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_2_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalBXtendDSLParser.g:1213:6: ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1213:6: ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1214:7: {...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1214:123: ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1215:8: ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3);
                    	    // InternalBXtendDSLParser.g:1218:11: ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) )
                    	    // InternalBXtendDSLParser.g:1218:12: {...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1218:21: ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma )
                    	    // InternalBXtendDSLParser.g:1218:22: ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1218:22: ( (lv_deletion_31_0= Deletion ) )
                    	    // InternalBXtendDSLParser.g:1219:12: (lv_deletion_31_0= Deletion )
                    	    {
                    	    // InternalBXtendDSLParser.g:1219:12: (lv_deletion_31_0= Deletion )
                    	    // InternalBXtendDSLParser.g:1220:13: lv_deletion_31_0= Deletion
                    	    {
                    	    lv_deletion_31_0=(Token)match(input,Deletion,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_deletion_31_0, grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "deletion", true, "deletion");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_32=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_32, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_3_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());

                    }

                    // InternalBXtendDSLParser.g:1249:5: ( (lv_sort_33_0= Sort ) )
                    // InternalBXtendDSLParser.g:1250:6: (lv_sort_33_0= Sort )
                    {
                    // InternalBXtendDSLParser.g:1250:6: (lv_sort_33_0= Sort )
                    // InternalBXtendDSLParser.g:1251:7: lv_sort_33_0= Sort
                    {
                    lv_sort_33_0=(Token)match(input,Sort,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_sort_33_0, grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                      							}
                      							setWithLastConsumed(current, "sort", true, "sort");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:1265:4: (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) )
                    {
                    // InternalBXtendDSLParser.g:1265:4: (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) )
                    // InternalBXtendDSLParser.g:1266:5: otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) )
                    {
                    otherlv_34=(Token)match(input,VerticalLine,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_34, grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_3_0());
                      				
                    }
                    // InternalBXtendDSLParser.g:1270:5: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) )
                    // InternalBXtendDSLParser.g:1271:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) )
                    {
                    // InternalBXtendDSLParser.g:1271:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) )
                    // InternalBXtendDSLParser.g:1272:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());
                    // InternalBXtendDSLParser.g:1275:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* )
                    // InternalBXtendDSLParser.g:1276:8: ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )*
                    {
                    // InternalBXtendDSLParser.g:1276:8: ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )*
                    loop17:
                    do {
                        int alt17=5;
                        int LA17_0 = input.LA(1);

                        if ( LA17_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                            alt17=1;
                        }
                        else if ( LA17_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                            alt17=2;
                        }
                        else if ( LA17_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                            alt17=3;
                        }
                        else if ( LA17_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                            alt17=4;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1277:6: ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1277:6: ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1278:7: {...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1278:123: ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1279:8: ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0);
                    	    // InternalBXtendDSLParser.g:1282:11: ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) )
                    	    // InternalBXtendDSLParser.g:1282:12: {...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1282:21: ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma )
                    	    // InternalBXtendDSLParser.g:1282:22: ( (lv_group_36_0= Group ) ) otherlv_37= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1282:22: ( (lv_group_36_0= Group ) )
                    	    // InternalBXtendDSLParser.g:1283:12: (lv_group_36_0= Group )
                    	    {
                    	    // InternalBXtendDSLParser.g:1283:12: (lv_group_36_0= Group )
                    	    // InternalBXtendDSLParser.g:1284:13: lv_group_36_0= Group
                    	    {
                    	    lv_group_36_0=(Token)match(input,Group,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_group_36_0, grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "group", true, "group");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_37=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_37, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_0_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLParser.g:1306:6: ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1306:6: ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1307:7: {...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1307:123: ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1308:8: ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1);
                    	    // InternalBXtendDSLParser.g:1311:11: ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) )
                    	    // InternalBXtendDSLParser.g:1311:12: {...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1311:21: ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma )
                    	    // InternalBXtendDSLParser.g:1311:22: ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1311:22: ( (lv_filter_38_0= Filter ) )
                    	    // InternalBXtendDSLParser.g:1312:12: (lv_filter_38_0= Filter )
                    	    {
                    	    // InternalBXtendDSLParser.g:1312:12: (lv_filter_38_0= Filter )
                    	    // InternalBXtendDSLParser.g:1313:13: lv_filter_38_0= Filter
                    	    {
                    	    lv_filter_38_0=(Token)match(input,Filter,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_filter_38_0, grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "filter", true, "filter");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_39=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_39, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_1_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBXtendDSLParser.g:1335:6: ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1335:6: ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1336:7: {...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1336:123: ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1337:8: ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2);
                    	    // InternalBXtendDSLParser.g:1340:11: ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) )
                    	    // InternalBXtendDSLParser.g:1340:12: {...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1340:21: ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma )
                    	    // InternalBXtendDSLParser.g:1340:22: ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1340:22: ( (lv_sort_40_0= Sort ) )
                    	    // InternalBXtendDSLParser.g:1341:12: (lv_sort_40_0= Sort )
                    	    {
                    	    // InternalBXtendDSLParser.g:1341:12: (lv_sort_40_0= Sort )
                    	    // InternalBXtendDSLParser.g:1342:13: lv_sort_40_0= Sort
                    	    {
                    	    lv_sort_40_0=(Token)match(input,Sort,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_sort_40_0, grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "sort", true, "sort");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_41=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_41, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_2_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalBXtendDSLParser.g:1364:6: ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1364:6: ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1365:7: {...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1365:123: ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1366:8: ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3);
                    	    // InternalBXtendDSLParser.g:1369:11: ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) )
                    	    // InternalBXtendDSLParser.g:1369:12: {...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1369:21: ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma )
                    	    // InternalBXtendDSLParser.g:1369:22: ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1369:22: ( (lv_deletion_42_0= Deletion ) )
                    	    // InternalBXtendDSLParser.g:1370:12: (lv_deletion_42_0= Deletion )
                    	    {
                    	    // InternalBXtendDSLParser.g:1370:12: (lv_deletion_42_0= Deletion )
                    	    // InternalBXtendDSLParser.g:1371:13: lv_deletion_42_0= Deletion
                    	    {
                    	    lv_deletion_42_0=(Token)match(input,Deletion,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_deletion_42_0, grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "deletion", true, "deletion");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_43=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_43, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_3_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());

                    }

                    // InternalBXtendDSLParser.g:1400:5: ( (lv_creation_44_0= Creation ) )
                    // InternalBXtendDSLParser.g:1401:6: (lv_creation_44_0= Creation )
                    {
                    // InternalBXtendDSLParser.g:1401:6: (lv_creation_44_0= Creation )
                    // InternalBXtendDSLParser.g:1402:7: lv_creation_44_0= Creation
                    {
                    lv_creation_44_0=(Token)match(input,Creation,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_creation_44_0, grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                      							}
                      							setWithLastConsumed(current, "creation", true, "creation");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBXtendDSLParser.g:1416:4: (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) )
                    {
                    // InternalBXtendDSLParser.g:1416:4: (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) )
                    // InternalBXtendDSLParser.g:1417:5: otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) )
                    {
                    otherlv_45=(Token)match(input,VerticalLine,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_45, grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_4_0());
                      				
                    }
                    // InternalBXtendDSLParser.g:1421:5: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) )
                    // InternalBXtendDSLParser.g:1422:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) )
                    {
                    // InternalBXtendDSLParser.g:1422:6: ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) )
                    // InternalBXtendDSLParser.g:1423:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());
                    // InternalBXtendDSLParser.g:1426:7: ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* )
                    // InternalBXtendDSLParser.g:1427:8: ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )*
                    {
                    // InternalBXtendDSLParser.g:1427:8: ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        int LA18_0 = input.LA(1);

                        if ( LA18_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                            alt18=1;
                        }
                        else if ( LA18_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                            alt18=2;
                        }
                        else if ( LA18_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                            alt18=3;
                        }
                        else if ( LA18_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                            alt18=4;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1428:6: ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1428:6: ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1429:7: {...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1429:123: ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1430:8: ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0);
                    	    // InternalBXtendDSLParser.g:1433:11: ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) )
                    	    // InternalBXtendDSLParser.g:1433:12: {...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1433:21: ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma )
                    	    // InternalBXtendDSLParser.g:1433:22: ( (lv_group_47_0= Group ) ) otherlv_48= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1433:22: ( (lv_group_47_0= Group ) )
                    	    // InternalBXtendDSLParser.g:1434:12: (lv_group_47_0= Group )
                    	    {
                    	    // InternalBXtendDSLParser.g:1434:12: (lv_group_47_0= Group )
                    	    // InternalBXtendDSLParser.g:1435:13: lv_group_47_0= Group
                    	    {
                    	    lv_group_47_0=(Token)match(input,Group,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_group_47_0, grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "group", true, "group");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_48=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_48, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_0_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLParser.g:1457:6: ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1457:6: ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1458:7: {...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1458:123: ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1459:8: ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1);
                    	    // InternalBXtendDSLParser.g:1462:11: ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) )
                    	    // InternalBXtendDSLParser.g:1462:12: {...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1462:21: ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma )
                    	    // InternalBXtendDSLParser.g:1462:22: ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1462:22: ( (lv_filter_49_0= Filter ) )
                    	    // InternalBXtendDSLParser.g:1463:12: (lv_filter_49_0= Filter )
                    	    {
                    	    // InternalBXtendDSLParser.g:1463:12: (lv_filter_49_0= Filter )
                    	    // InternalBXtendDSLParser.g:1464:13: lv_filter_49_0= Filter
                    	    {
                    	    lv_filter_49_0=(Token)match(input,Filter,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_filter_49_0, grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "filter", true, "filter");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_50=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_50, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_1_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBXtendDSLParser.g:1486:6: ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1486:6: ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1487:7: {...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1487:123: ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1488:8: ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2);
                    	    // InternalBXtendDSLParser.g:1491:11: ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) )
                    	    // InternalBXtendDSLParser.g:1491:12: {...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1491:21: ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma )
                    	    // InternalBXtendDSLParser.g:1491:22: ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1491:22: ( (lv_sort_51_0= Sort ) )
                    	    // InternalBXtendDSLParser.g:1492:12: (lv_sort_51_0= Sort )
                    	    {
                    	    // InternalBXtendDSLParser.g:1492:12: (lv_sort_51_0= Sort )
                    	    // InternalBXtendDSLParser.g:1493:13: lv_sort_51_0= Sort
                    	    {
                    	    lv_sort_51_0=(Token)match(input,Sort,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_sort_51_0, grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "sort", true, "sort");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_52=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_52, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_2_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalBXtendDSLParser.g:1515:6: ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) )
                    	    {
                    	    // InternalBXtendDSLParser.g:1515:6: ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) )
                    	    // InternalBXtendDSLParser.g:1516:7: {...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3)");
                    	    }
                    	    // InternalBXtendDSLParser.g:1516:123: ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) )
                    	    // InternalBXtendDSLParser.g:1517:8: ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3);
                    	    // InternalBXtendDSLParser.g:1520:11: ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) )
                    	    // InternalBXtendDSLParser.g:1520:12: {...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleClassMatcherModifier", "true");
                    	    }
                    	    // InternalBXtendDSLParser.g:1520:21: ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma )
                    	    // InternalBXtendDSLParser.g:1520:22: ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma
                    	    {
                    	    // InternalBXtendDSLParser.g:1520:22: ( (lv_creation_53_0= Creation ) )
                    	    // InternalBXtendDSLParser.g:1521:12: (lv_creation_53_0= Creation )
                    	    {
                    	    // InternalBXtendDSLParser.g:1521:12: (lv_creation_53_0= Creation )
                    	    // InternalBXtendDSLParser.g:1522:13: lv_creation_53_0= Creation
                    	    {
                    	    lv_creation_53_0=(Token)match(input,Creation,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      													newLeafNode(lv_creation_53_0, grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0());
                    	      												
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      													if (current==null) {
                    	      														current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                    	      													}
                    	      													setWithLastConsumed(current, "creation", true, "creation");
                    	      												
                    	    }

                    	    }


                    	    }

                    	    otherlv_54=(Token)match(input,Comma,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      											newLeafNode(otherlv_54, grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_3_1());
                    	      										
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());

                    }

                    // InternalBXtendDSLParser.g:1551:5: ( (lv_deletion_55_0= Deletion ) )
                    // InternalBXtendDSLParser.g:1552:6: (lv_deletion_55_0= Deletion )
                    {
                    // InternalBXtendDSLParser.g:1552:6: (lv_deletion_55_0= Deletion )
                    // InternalBXtendDSLParser.g:1553:7: lv_deletion_55_0= Deletion
                    {
                    lv_deletion_55_0=(Token)match(input,Deletion,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_deletion_55_0, grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClassMatcherModifierRule());
                      							}
                      							setWithLastConsumed(current, "deletion", true, "deletion");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassMatcherModifier"


    // $ANTLR start "entryRuleFeatureMapping"
    // InternalBXtendDSLParser.g:1571:1: entryRuleFeatureMapping returns [EObject current=null] : iv_ruleFeatureMapping= ruleFeatureMapping EOF ;
    public final EObject entryRuleFeatureMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureMapping = null;


        try {
            // InternalBXtendDSLParser.g:1571:55: (iv_ruleFeatureMapping= ruleFeatureMapping EOF )
            // InternalBXtendDSLParser.g:1572:2: iv_ruleFeatureMapping= ruleFeatureMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureMapping=ruleFeatureMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureMapping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureMapping"


    // $ANTLR start "ruleFeatureMapping"
    // InternalBXtendDSLParser.g:1578:1: ruleFeatureMapping returns [EObject current=null] : ( ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+ ( (lv_direction_2_0= ruleDirection ) ) ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= Semicolon ) ;
    public final EObject ruleFeatureMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_srcFeatures_0_0 = null;

        Enumerator lv_direction_2_0 = null;

        EObject lv_trgFeatures_3_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:1584:2: ( ( ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+ ( (lv_direction_2_0= ruleDirection ) ) ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= Semicolon ) )
            // InternalBXtendDSLParser.g:1585:2: ( ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+ ( (lv_direction_2_0= ruleDirection ) ) ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= Semicolon )
            {
            // InternalBXtendDSLParser.g:1585:2: ( ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+ ( (lv_direction_2_0= ruleDirection ) ) ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= Semicolon )
            // InternalBXtendDSLParser.g:1586:3: ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+ ( (lv_direction_2_0= ruleDirection ) ) ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= Semicolon
            {
            // InternalBXtendDSLParser.g:1586:3: ( ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) ) | ( (otherlv_1= RULE_ID ) ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=3;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==LessThanSignHyphenMinusHyphenMinusGreaterThanSign||(LA20_2>=HyphenMinusHyphenMinusGreaterThanSign && LA20_2<=LessThanSignHyphenMinusHyphenMinus)||LA20_2==LeftCurlyBracket||LA20_2==RULE_ID) ) {
                        alt20=2;
                    }
                    else if ( (LA20_2==FullStop) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==LeftCurlyBracket) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1587:4: ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) )
            	    {
            	    // InternalBXtendDSLParser.g:1587:4: ( (lv_srcFeatures_0_0= ruleSrcMappingFeature ) )
            	    // InternalBXtendDSLParser.g:1588:5: (lv_srcFeatures_0_0= ruleSrcMappingFeature )
            	    {
            	    // InternalBXtendDSLParser.g:1588:5: (lv_srcFeatures_0_0= ruleSrcMappingFeature )
            	    // InternalBXtendDSLParser.g:1589:6: lv_srcFeatures_0_0= ruleSrcMappingFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFeatureMappingAccess().getSrcFeaturesSrcMappingFeatureParserRuleCall_0_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_srcFeatures_0_0=ruleSrcMappingFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFeatureMappingRule());
            	      						}
            	      						add(
            	      							current,
            	      							"srcFeatures",
            	      							lv_srcFeatures_0_0,
            	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.SrcMappingFeature");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBXtendDSLParser.g:1607:4: ( (otherlv_1= RULE_ID ) )
            	    {
            	    // InternalBXtendDSLParser.g:1607:4: ( (otherlv_1= RULE_ID ) )
            	    // InternalBXtendDSLParser.g:1608:5: (otherlv_1= RULE_ID )
            	    {
            	    // InternalBXtendDSLParser.g:1608:5: (otherlv_1= RULE_ID )
            	    // InternalBXtendDSLParser.g:1609:6: otherlv_1= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getFeatureMappingRule());
            	      						}
            	      					
            	    }
            	    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_1, grammarAccess.getFeatureMappingAccess().getSrcClassesClassMatcherCrossReference_0_1_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // InternalBXtendDSLParser.g:1621:3: ( (lv_direction_2_0= ruleDirection ) )
            // InternalBXtendDSLParser.g:1622:4: (lv_direction_2_0= ruleDirection )
            {
            // InternalBXtendDSLParser.g:1622:4: (lv_direction_2_0= ruleDirection )
            // InternalBXtendDSLParser.g:1623:5: lv_direction_2_0= ruleDirection
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFeatureMappingAccess().getDirectionDirectionEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_direction_2_0=ruleDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFeatureMappingRule());
              					}
              					set(
              						current,
              						"direction",
              						lv_direction_2_0,
              						"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Direction");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:1640:3: ( ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) ) | ( (otherlv_4= RULE_ID ) ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==FullStop) ) {
                        alt21=1;
                    }
                    else if ( (LA21_2==Semicolon||LA21_2==LeftCurlyBracket||LA21_2==RULE_ID) ) {
                        alt21=2;
                    }


                }
                else if ( (LA21_0==LeftCurlyBracket) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1641:4: ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) )
            	    {
            	    // InternalBXtendDSLParser.g:1641:4: ( (lv_trgFeatures_3_0= ruleTrgMappingFeature ) )
            	    // InternalBXtendDSLParser.g:1642:5: (lv_trgFeatures_3_0= ruleTrgMappingFeature )
            	    {
            	    // InternalBXtendDSLParser.g:1642:5: (lv_trgFeatures_3_0= ruleTrgMappingFeature )
            	    // InternalBXtendDSLParser.g:1643:6: lv_trgFeatures_3_0= ruleTrgMappingFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFeatureMappingAccess().getTrgFeaturesTrgMappingFeatureParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_trgFeatures_3_0=ruleTrgMappingFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFeatureMappingRule());
            	      						}
            	      						add(
            	      							current,
            	      							"trgFeatures",
            	      							lv_trgFeatures_3_0,
            	      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.TrgMappingFeature");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBXtendDSLParser.g:1661:4: ( (otherlv_4= RULE_ID ) )
            	    {
            	    // InternalBXtendDSLParser.g:1661:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalBXtendDSLParser.g:1662:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalBXtendDSLParser.g:1662:5: (otherlv_4= RULE_ID )
            	    // InternalBXtendDSLParser.g:1663:6: otherlv_4= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getFeatureMappingRule());
            	      						}
            	      					
            	    }
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_4, grammarAccess.getFeatureMappingAccess().getTrgClassesClassMatcherCrossReference_2_1_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            otherlv_5=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFeatureMappingAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureMapping"


    // $ANTLR start "entryRuleSrcMappingFeature"
    // InternalBXtendDSLParser.g:1683:1: entryRuleSrcMappingFeature returns [EObject current=null] : iv_ruleSrcMappingFeature= ruleSrcMappingFeature EOF ;
    public final EObject entryRuleSrcMappingFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSrcMappingFeature = null;


        try {
            // InternalBXtendDSLParser.g:1683:58: (iv_ruleSrcMappingFeature= ruleSrcMappingFeature EOF )
            // InternalBXtendDSLParser.g:1684:2: iv_ruleSrcMappingFeature= ruleSrcMappingFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSrcMappingFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSrcMappingFeature=ruleSrcMappingFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSrcMappingFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSrcMappingFeature"


    // $ANTLR start "ruleSrcMappingFeature"
    // InternalBXtendDSLParser.g:1690:1: ruleSrcMappingFeature returns [EObject current=null] : ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) ) ;
    public final EObject ruleSrcMappingFeature() throws RecognitionException {
        EObject current = null;

        Token lv_corr_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_corrs_4_0 = null;

        EObject lv_corrs_6_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:1696:2: ( ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) ) )
            // InternalBXtendDSLParser.g:1697:2: ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) )
            {
            // InternalBXtendDSLParser.g:1697:2: ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            else if ( (LA23_0==LeftCurlyBracket) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalBXtendDSLParser.g:1698:3: ( ( ruleFeatureAccess ) )
                    {
                    // InternalBXtendDSLParser.g:1698:3: ( ( ruleFeatureAccess ) )
                    // InternalBXtendDSLParser.g:1699:4: ( ruleFeatureAccess )
                    {
                    // InternalBXtendDSLParser.g:1699:4: ( ruleFeatureAccess )
                    // InternalBXtendDSLParser.g:1700:5: ruleFeatureAccess
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getSrcMappingFeatureRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleFeatureAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:1715:3: ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket )
                    {
                    // InternalBXtendDSLParser.g:1715:3: ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket )
                    // InternalBXtendDSLParser.g:1716:4: ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket
                    {
                    // InternalBXtendDSLParser.g:1716:4: ( (lv_corr_1_0= LeftCurlyBracket ) )
                    // InternalBXtendDSLParser.g:1717:5: (lv_corr_1_0= LeftCurlyBracket )
                    {
                    // InternalBXtendDSLParser.g:1717:5: (lv_corr_1_0= LeftCurlyBracket )
                    // InternalBXtendDSLParser.g:1718:6: lv_corr_1_0= LeftCurlyBracket
                    {
                    lv_corr_1_0=(Token)match(input,LeftCurlyBracket,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_corr_1_0, grammarAccess.getSrcMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSrcMappingFeatureRule());
                      						}
                      						setWithLastConsumed(current, "corr", true, "{");
                      					
                    }

                    }


                    }

                    // InternalBXtendDSLParser.g:1730:4: ( ( ruleFeatureAccess ) )
                    // InternalBXtendDSLParser.g:1731:5: ( ruleFeatureAccess )
                    {
                    // InternalBXtendDSLParser.g:1731:5: ( ruleFeatureAccess )
                    // InternalBXtendDSLParser.g:1732:6: ruleFeatureAccess
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSrcMappingFeatureRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    ruleFeatureAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,Colon,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getSrcMappingFeatureAccess().getColonKeyword_1_2());
                      			
                    }
                    // InternalBXtendDSLParser.g:1750:4: ( (lv_corrs_4_0= ruleCorrespondence ) )
                    // InternalBXtendDSLParser.g:1751:5: (lv_corrs_4_0= ruleCorrespondence )
                    {
                    // InternalBXtendDSLParser.g:1751:5: (lv_corrs_4_0= ruleCorrespondence )
                    // InternalBXtendDSLParser.g:1752:6: lv_corrs_4_0= ruleCorrespondence
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_corrs_4_0=ruleCorrespondence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSrcMappingFeatureRule());
                      						}
                      						add(
                      							current,
                      							"corrs",
                      							lv_corrs_4_0,
                      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Correspondence");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBXtendDSLParser.g:1769:4: (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==Comma) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1770:5: otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getSrcMappingFeatureAccess().getCommaKeyword_1_4_0());
                    	      				
                    	    }
                    	    // InternalBXtendDSLParser.g:1774:5: ( (lv_corrs_6_0= ruleCorrespondence ) )
                    	    // InternalBXtendDSLParser.g:1775:6: (lv_corrs_6_0= ruleCorrespondence )
                    	    {
                    	    // InternalBXtendDSLParser.g:1775:6: (lv_corrs_6_0= ruleCorrespondence )
                    	    // InternalBXtendDSLParser.g:1776:7: lv_corrs_6_0= ruleCorrespondence
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_corrs_6_0=ruleCorrespondence();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getSrcMappingFeatureRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"corrs",
                    	      								lv_corrs_6_0,
                    	      								"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Correspondence");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getSrcMappingFeatureAccess().getRightCurlyBracketKeyword_1_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSrcMappingFeature"


    // $ANTLR start "entryRuleTrgMappingFeature"
    // InternalBXtendDSLParser.g:1803:1: entryRuleTrgMappingFeature returns [EObject current=null] : iv_ruleTrgMappingFeature= ruleTrgMappingFeature EOF ;
    public final EObject entryRuleTrgMappingFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrgMappingFeature = null;


        try {
            // InternalBXtendDSLParser.g:1803:58: (iv_ruleTrgMappingFeature= ruleTrgMappingFeature EOF )
            // InternalBXtendDSLParser.g:1804:2: iv_ruleTrgMappingFeature= ruleTrgMappingFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTrgMappingFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTrgMappingFeature=ruleTrgMappingFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTrgMappingFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrgMappingFeature"


    // $ANTLR start "ruleTrgMappingFeature"
    // InternalBXtendDSLParser.g:1810:1: ruleTrgMappingFeature returns [EObject current=null] : ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) ) ;
    public final EObject ruleTrgMappingFeature() throws RecognitionException {
        EObject current = null;

        Token lv_corr_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_corrs_4_0 = null;

        EObject lv_corrs_6_0 = null;



        	enterRule();

        try {
            // InternalBXtendDSLParser.g:1816:2: ( ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) ) )
            // InternalBXtendDSLParser.g:1817:2: ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) )
            {
            // InternalBXtendDSLParser.g:1817:2: ( ( ( ruleFeatureAccess ) ) | ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            else if ( (LA25_0==LeftCurlyBracket) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalBXtendDSLParser.g:1818:3: ( ( ruleFeatureAccess ) )
                    {
                    // InternalBXtendDSLParser.g:1818:3: ( ( ruleFeatureAccess ) )
                    // InternalBXtendDSLParser.g:1819:4: ( ruleFeatureAccess )
                    {
                    // InternalBXtendDSLParser.g:1819:4: ( ruleFeatureAccess )
                    // InternalBXtendDSLParser.g:1820:5: ruleFeatureAccess
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTrgMappingFeatureRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleFeatureAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:1835:3: ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket )
                    {
                    // InternalBXtendDSLParser.g:1835:3: ( ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket )
                    // InternalBXtendDSLParser.g:1836:4: ( (lv_corr_1_0= LeftCurlyBracket ) ) ( ( ruleFeatureAccess ) ) otherlv_3= Colon ( (lv_corrs_4_0= ruleCorrespondence ) ) (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )* otherlv_7= RightCurlyBracket
                    {
                    // InternalBXtendDSLParser.g:1836:4: ( (lv_corr_1_0= LeftCurlyBracket ) )
                    // InternalBXtendDSLParser.g:1837:5: (lv_corr_1_0= LeftCurlyBracket )
                    {
                    // InternalBXtendDSLParser.g:1837:5: (lv_corr_1_0= LeftCurlyBracket )
                    // InternalBXtendDSLParser.g:1838:6: lv_corr_1_0= LeftCurlyBracket
                    {
                    lv_corr_1_0=(Token)match(input,LeftCurlyBracket,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_corr_1_0, grammarAccess.getTrgMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTrgMappingFeatureRule());
                      						}
                      						setWithLastConsumed(current, "corr", true, "{");
                      					
                    }

                    }


                    }

                    // InternalBXtendDSLParser.g:1850:4: ( ( ruleFeatureAccess ) )
                    // InternalBXtendDSLParser.g:1851:5: ( ruleFeatureAccess )
                    {
                    // InternalBXtendDSLParser.g:1851:5: ( ruleFeatureAccess )
                    // InternalBXtendDSLParser.g:1852:6: ruleFeatureAccess
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTrgMappingFeatureRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    ruleFeatureAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,Colon,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTrgMappingFeatureAccess().getColonKeyword_1_2());
                      			
                    }
                    // InternalBXtendDSLParser.g:1870:4: ( (lv_corrs_4_0= ruleCorrespondence ) )
                    // InternalBXtendDSLParser.g:1871:5: (lv_corrs_4_0= ruleCorrespondence )
                    {
                    // InternalBXtendDSLParser.g:1871:5: (lv_corrs_4_0= ruleCorrespondence )
                    // InternalBXtendDSLParser.g:1872:6: lv_corrs_4_0= ruleCorrespondence
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_corrs_4_0=ruleCorrespondence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTrgMappingFeatureRule());
                      						}
                      						add(
                      							current,
                      							"corrs",
                      							lv_corrs_4_0,
                      							"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Correspondence");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBXtendDSLParser.g:1889:4: (otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==Comma) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1890:5: otherlv_5= Comma ( (lv_corrs_6_0= ruleCorrespondence ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getTrgMappingFeatureAccess().getCommaKeyword_1_4_0());
                    	      				
                    	    }
                    	    // InternalBXtendDSLParser.g:1894:5: ( (lv_corrs_6_0= ruleCorrespondence ) )
                    	    // InternalBXtendDSLParser.g:1895:6: (lv_corrs_6_0= ruleCorrespondence )
                    	    {
                    	    // InternalBXtendDSLParser.g:1895:6: (lv_corrs_6_0= ruleCorrespondence )
                    	    // InternalBXtendDSLParser.g:1896:7: lv_corrs_6_0= ruleCorrespondence
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_corrs_6_0=ruleCorrespondence();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTrgMappingFeatureRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"corrs",
                    	      								lv_corrs_6_0,
                    	      								"de.ubt.ai1.m2m.bxtenddsl.BXtendDSL.Correspondence");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTrgMappingFeatureAccess().getRightCurlyBracketKeyword_1_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrgMappingFeature"


    // $ANTLR start "entryRuleCorrespondence"
    // InternalBXtendDSLParser.g:1923:1: entryRuleCorrespondence returns [EObject current=null] : iv_ruleCorrespondence= ruleCorrespondence EOF ;
    public final EObject entryRuleCorrespondence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCorrespondence = null;


        try {
            // InternalBXtendDSLParser.g:1923:55: (iv_ruleCorrespondence= ruleCorrespondence EOF )
            // InternalBXtendDSLParser.g:1924:2: iv_ruleCorrespondence= ruleCorrespondence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCorrespondenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCorrespondence=ruleCorrespondence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCorrespondence; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCorrespondence"


    // $ANTLR start "ruleCorrespondence"
    // InternalBXtendDSLParser.g:1930:1: ruleCorrespondence returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )? ) ;
    public final EObject ruleCorrespondence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:1936:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )? ) )
            // InternalBXtendDSLParser.g:1937:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )? )
            {
            // InternalBXtendDSLParser.g:1937:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )? )
            // InternalBXtendDSLParser.g:1938:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )?
            {
            // InternalBXtendDSLParser.g:1938:3: ( (otherlv_0= RULE_ID ) )
            // InternalBXtendDSLParser.g:1939:4: (otherlv_0= RULE_ID )
            {
            // InternalBXtendDSLParser.g:1939:4: (otherlv_0= RULE_ID )
            // InternalBXtendDSLParser.g:1940:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCorrespondenceRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getCorrespondenceAccess().getRuleTransformationRuleCrossReference_0_0());
              				
            }

            }


            }

            // InternalBXtendDSLParser.g:1951:3: (otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LeftSquareBracket) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBXtendDSLParser.g:1952:4: otherlv_1= LeftSquareBracket ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* otherlv_5= RightSquareBracket
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCorrespondenceAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalBXtendDSLParser.g:1956:4: ( (otherlv_2= RULE_ID ) )
                    // InternalBXtendDSLParser.g:1957:5: (otherlv_2= RULE_ID )
                    {
                    // InternalBXtendDSLParser.g:1957:5: (otherlv_2= RULE_ID )
                    // InternalBXtendDSLParser.g:1958:6: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCorrespondenceRule());
                      						}
                      					
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    // InternalBXtendDSLParser.g:1969:4: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==Comma) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalBXtendDSLParser.g:1970:5: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCorrespondenceAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalBXtendDSLParser.g:1974:5: ( (otherlv_4= RULE_ID ) )
                    	    // InternalBXtendDSLParser.g:1975:6: (otherlv_4= RULE_ID )
                    	    {
                    	    // InternalBXtendDSLParser.g:1975:6: (otherlv_4= RULE_ID )
                    	    // InternalBXtendDSLParser.g:1976:7: otherlv_4= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getCorrespondenceRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_4, grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getCorrespondenceAccess().getRightSquareBracketKeyword_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCorrespondence"


    // $ANTLR start "entryRuleFeatureAccess"
    // InternalBXtendDSLParser.g:1997:1: entryRuleFeatureAccess returns [String current=null] : iv_ruleFeatureAccess= ruleFeatureAccess EOF ;
    public final String entryRuleFeatureAccess() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureAccess = null;


        try {
            // InternalBXtendDSLParser.g:1997:53: (iv_ruleFeatureAccess= ruleFeatureAccess EOF )
            // InternalBXtendDSLParser.g:1998:2: iv_ruleFeatureAccess= ruleFeatureAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureAccess=ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureAccess.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureAccess"


    // $ANTLR start "ruleFeatureAccess"
    // InternalBXtendDSLParser.g:2004:1: ruleFeatureAccess returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleFeatureAccess() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:2010:2: ( (this_ID_0= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+ ) )
            // InternalBXtendDSLParser.g:2011:2: (this_ID_0= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+ )
            {
            // InternalBXtendDSLParser.g:2011:2: (this_ID_0= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+ )
            // InternalBXtendDSLParser.g:2012:3: this_ID_0= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalBXtendDSLParser.g:2019:3: ( ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==FullStop) && (synpred1_InternalBXtendDSLParser())) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:2020:4: ( ( FullStop )=>kw= FullStop ) this_ID_2= RULE_ID
            	    {
            	    // InternalBXtendDSLParser.g:2020:4: ( ( FullStop )=>kw= FullStop )
            	    // InternalBXtendDSLParser.g:2021:5: ( FullStop )=>kw= FullStop
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current.merge(kw);
            	      					newLeafNode(kw, grammarAccess.getFeatureAccessAccess().getFullStopKeyword_1_0());
            	      				
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureAccess"


    // $ANTLR start "ruleDirection"
    // InternalBXtendDSLParser.g:2040:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign ) | (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus ) | (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalBXtendDSLParser.g:2046:2: ( ( (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign ) | (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus ) | (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) ) )
            // InternalBXtendDSLParser.g:2047:2: ( (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign ) | (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus ) | (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) )
            {
            // InternalBXtendDSLParser.g:2047:2: ( (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign ) | (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus ) | (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case HyphenMinusHyphenMinusGreaterThanSign:
                {
                alt29=1;
                }
                break;
            case LessThanSignHyphenMinusHyphenMinus:
                {
                alt29=2;
                }
                break;
            case LessThanSignHyphenMinusHyphenMinusGreaterThanSign:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalBXtendDSLParser.g:2048:3: (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign )
                    {
                    // InternalBXtendDSLParser.g:2048:3: (enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign )
                    // InternalBXtendDSLParser.g:2049:4: enumLiteral_0= HyphenMinusHyphenMinusGreaterThanSign
                    {
                    enumLiteral_0=(Token)match(input,HyphenMinusHyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDirectionAccess().getFWDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getFWDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:2056:3: (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus )
                    {
                    // InternalBXtendDSLParser.g:2056:3: (enumLiteral_1= LessThanSignHyphenMinusHyphenMinus )
                    // InternalBXtendDSLParser.g:2057:4: enumLiteral_1= LessThanSignHyphenMinusHyphenMinus
                    {
                    enumLiteral_1=(Token)match(input,LessThanSignHyphenMinusHyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDirectionAccess().getBWDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getBWDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:2064:3: (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign )
                    {
                    // InternalBXtendDSLParser.g:2064:3: (enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign )
                    // InternalBXtendDSLParser.g:2065:4: enumLiteral_2= LessThanSignHyphenMinusHyphenMinusGreaterThanSign
                    {
                    enumLiteral_2=(Token)match(input,LessThanSignHyphenMinusHyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDirectionAccess().getBXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDirectionAccess().getBXEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirection"

    // $ANTLR start synpred1_InternalBXtendDSLParser
    public final void synpred1_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:2021:5: ( FullStop )
        // InternalBXtendDSLParser.g:2021:6: FullStop
        {
        match(input,FullStop,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalBXtendDSLParser

    // Delegated rules

    public final boolean synpred1_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String dfa_1s = "\u00c1\uffff";
    static final String dfa_2s = "\1\2\2\uffff\1\11\1\12\1\15\1\17\1\21\12\uffff\1\12\1\uffff\1\21\1\15\2\17\1\11\1\21\1\uffff\1\15\1\12\1\11\1\21\1\uffff\1\17\1\15\1\11\1\21\1\12\1\uffff\1\17\1\11\1\uffff\1\12\1\15\24\uffff\1\17\1\uffff\1\21\1\uffff\1\15\1\17\2\uffff\1\12\1\15\1\12\1\uffff\1\21\1\uffff\1\17\1\15\1\uffff\1\21\1\12\1\uffff\1\15\1\11\1\21\2\uffff\1\17\1\11\2\uffff\1\15\1\17\1\11\1\21\2\uffff\1\17\1\11\1\uffff\1\12\1\uffff\1\12\1\11\1\21\2\uffff\1\15\1\11\1\uffff\1\12\37\uffff\1\15\1\uffff\1\21\2\uffff\1\17\3\uffff\1\15\1\17\1\uffff\1\21\2\uffff\1\15\2\uffff\1\12\1\uffff\1\12\3\uffff\1\17\1\12\1\uffff\1\21\2\uffff\1\21\1\11\3\uffff\1\15\1\11\3\uffff\1\17\1\11\3\uffff\1\12\1\11\3\uffff";
    static final String dfa_3s = "\1\30\1\6\1\uffff\5\25\1\6\2\uffff\2\6\1\uffff\1\6\1\uffff\1\6\1\uffff\31\25\24\6\62\25\36\6\62\25";
    static final String dfa_4s = "\1\34\1\15\1\uffff\5\30\1\15\2\uffff\2\15\1\uffff\1\15\1\uffff\1\15\1\uffff\1\30\1\25\6\30\1\25\4\30\1\25\5\30\1\25\2\30\1\25\2\30\24\15\1\30\1\25\1\30\1\25\2\30\2\25\3\30\1\25\1\30\1\25\2\30\1\25\2\30\1\25\3\30\2\25\2\30\2\25\4\30\2\25\2\30\1\25\1\30\1\25\3\30\2\25\2\30\1\25\1\30\1\25\36\15\1\30\1\25\1\30\2\25\1\30\3\25\2\30\1\25\1\30\2\25\1\30\2\25\1\30\1\25\1\30\3\25\2\30\1\25\1\30\2\25\2\30\3\25\2\30\3\25\2\30\3\25\2\30\3\25";
    static final String dfa_5s = "\2\uffff\1\6\6\uffff\1\1\1\3\2\uffff\1\4\1\uffff\1\5\1\uffff\1\2\u00af\uffff";
    static final String dfa_6s = "\u00c1\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\3\uffff\1\1",
            "\1\5\1\6\1\uffff\1\7\1\3\2\uffff\1\4",
            "",
            "\1\10\2\uffff\1\11",
            "\1\13\2\uffff\1\12",
            "\1\14\2\uffff\1\15",
            "\1\16\2\uffff\1\17",
            "\1\20\2\uffff\1\21",
            "\1\25\1\26\1\uffff\1\24\1\23\2\uffff\1\22",
            "",
            "",
            "\1\33\1\27\1\uffff\1\31\1\30\2\uffff\1\32",
            "\1\37\1\40\1\uffff\1\36\1\35\2\uffff\1\34",
            "",
            "\1\41\1\45\1\uffff\1\43\1\42\2\uffff\1\44",
            "",
            "\1\52\1\46\1\uffff\1\50\1\47\2\uffff\1\51",
            "",
            "\1\53\2\uffff\1\12",
            "\1\10",
            "\1\54\2\uffff\1\21",
            "\1\55\2\uffff\1\15",
            "\1\56\2\uffff\1\17",
            "\1\57\2\uffff\1\17",
            "\1\60\2\uffff\1\11",
            "\1\61\2\uffff\1\21",
            "\1\13",
            "\1\62\2\uffff\1\15",
            "\1\63\2\uffff\1\12",
            "\1\64\2\uffff\1\11",
            "\1\65\2\uffff\1\21",
            "\1\14",
            "\1\66\2\uffff\1\17",
            "\1\67\2\uffff\1\15",
            "\1\70\2\uffff\1\11",
            "\1\71\2\uffff\1\21",
            "\1\72\2\uffff\1\12",
            "\1\16",
            "\1\73\2\uffff\1\17",
            "\1\74\2\uffff\1\11",
            "\1\20",
            "\1\75\2\uffff\1\12",
            "\1\76\2\uffff\1\15",
            "\1\103\1\77\1\uffff\1\101\1\100\2\uffff\1\102",
            "\1\110\1\104\1\uffff\1\106\1\105\2\uffff\1\107",
            "\1\114\1\115\1\uffff\1\113\1\112\2\uffff\1\111",
            "\1\116\1\122\1\uffff\1\120\1\117\2\uffff\1\121",
            "\1\123\1\127\1\uffff\1\125\1\124\2\uffff\1\126",
            "\1\103\1\77\1\uffff\1\101\1\100\2\uffff\1\102",
            "\1\134\1\130\1\uffff\1\132\1\131\2\uffff\1\133",
            "\1\141\1\135\1\uffff\1\137\1\136\2\uffff\1\140",
            "\1\141\1\135\1\uffff\1\137\1\136\2\uffff\1\140",
            "\1\114\1\115\1\uffff\1\113\1\112\2\uffff\1\111",
            "\1\146\1\142\1\uffff\1\144\1\143\2\uffff\1\145",
            "\1\152\1\153\1\uffff\1\151\1\150\2\uffff\1\147",
            "\1\152\1\153\1\uffff\1\151\1\150\2\uffff\1\147",
            "\1\116\1\122\1\uffff\1\120\1\117\2\uffff\1\121",
            "\1\154\1\160\1\uffff\1\156\1\155\2\uffff\1\157",
            "\1\123\1\127\1\uffff\1\125\1\124\2\uffff\1\126",
            "\1\154\1\160\1\uffff\1\156\1\155\2\uffff\1\157",
            "\1\110\1\104\1\uffff\1\106\1\105\2\uffff\1\107",
            "\1\134\1\130\1\uffff\1\132\1\131\2\uffff\1\133",
            "\1\146\1\142\1\uffff\1\144\1\143\2\uffff\1\145",
            "\1\161\2\uffff\1\17",
            "\1\60",
            "\1\162\2\uffff\1\21",
            "\1\53",
            "\1\163\2\uffff\1\15",
            "\1\164\2\uffff\1\17",
            "\1\74",
            "\1\54",
            "\1\165\2\uffff\1\12",
            "\1\166\2\uffff\1\15",
            "\1\167\2\uffff\1\12",
            "\1\64",
            "\1\170\2\uffff\1\21",
            "\1\55",
            "\1\171\2\uffff\1\17",
            "\1\172\2\uffff\1\15",
            "\1\70",
            "\1\173\2\uffff\1\21",
            "\1\174\2\uffff\1\12",
            "\1\56",
            "\1\175\2\uffff\1\15",
            "\1\176\2\uffff\1\11",
            "\1\177\2\uffff\1\21",
            "\1\72",
            "\1\57",
            "\1\u0080\2\uffff\1\17",
            "\1\u0081\2\uffff\1\11",
            "\1\61",
            "\1\75",
            "\1\u0082\2\uffff\1\15",
            "\1\u0083\2\uffff\1\17",
            "\1\u0084\2\uffff\1\11",
            "\1\u0085\2\uffff\1\21",
            "\1\63",
            "\1\62",
            "\1\u0086\2\uffff\1\17",
            "\1\u0087\2\uffff\1\11",
            "\1\65",
            "\1\u0088\2\uffff\1\12",
            "\1\76",
            "\1\u0089\2\uffff\1\12",
            "\1\u008a\2\uffff\1\11",
            "\1\u008b\2\uffff\1\21",
            "\1\67",
            "\1\66",
            "\1\u008c\2\uffff\1\15",
            "\1\u008d\2\uffff\1\11",
            "\1\71",
            "\1\u008e\2\uffff\1\12",
            "\1\73",
            "\1\u008f\1\u0093\1\uffff\1\u0091\1\u0090\2\uffff\1\u0092",
            "\1\u0098\1\u0094\1\uffff\1\u0096\1\u0095\2\uffff\1\u0097",
            "\1\u009d\1\u0099\1\uffff\1\u009b\1\u009a\2\uffff\1\u009c",
            "\1\u009e\1\u00a2\1\uffff\1\u00a0\1\u009f\2\uffff\1\u00a1",
            "\1\u0098\1\u0094\1\uffff\1\u0096\1\u0095\2\uffff\1\u0097",
            "\1\u00a6\1\u00a7\1\uffff\1\u00a5\1\u00a4\2\uffff\1\u00a3",
            "\1\u009d\1\u0099\1\uffff\1\u009b\1\u009a\2\uffff\1\u009c",
            "\1\u00a6\1\u00a7\1\uffff\1\u00a5\1\u00a4\2\uffff\1\u00a3",
            "\1\u00ab\1\u00ac\1\uffff\1\u00aa\1\u00a9\2\uffff\1\u00a8",
            "\1\u00ab\1\u00ac\1\uffff\1\u00aa\1\u00a9\2\uffff\1\u00a8",
            "\1\u009e\1\u00a2\1\uffff\1\u00a0\1\u009f\2\uffff\1\u00a1",
            "\1\u008f\1\u0093\1\uffff\1\u0091\1\u0090\2\uffff\1\u0092",
            "\1\u00b0\1\u00b1\1\uffff\1\u00ad\1\u00ae\2\uffff\1\u00af",
            "\1\u008f\1\u0093\1\uffff\1\u0091\1\u0090\2\uffff\1\u0092",
            "\1\u00b2\1\u00b6\1\uffff\1\u00b4\1\u00b3\2\uffff\1\u00b5",
            "\1\u00b2\1\u00b6\1\uffff\1\u00b4\1\u00b3\2\uffff\1\u00b5",
            "\1\u0098\1\u0094\1\uffff\1\u0096\1\u0095\2\uffff\1\u0097",
            "\1\u00bb\1\u00b7\1\uffff\1\u00b9\1\u00b8\2\uffff\1\u00ba",
            "\1\u00b0\1\u00b1\1\uffff\1\u00ad\1\u00ae\2\uffff\1\u00af",
            "\1\u009d\1\u0099\1\uffff\1\u009b\1\u009a\2\uffff\1\u009c",
            "\1\u00bb\1\u00b7\1\uffff\1\u00b9\1\u00b8\2\uffff\1\u00ba",
            "\1\u00bf\1\u00c0\1\uffff\1\u00be\1\u00bd\2\uffff\1\u00bc",
            "\1\u00a6\1\u00a7\1\uffff\1\u00a5\1\u00a4\2\uffff\1\u00a3",
            "\1\u00bb\1\u00b7\1\uffff\1\u00b9\1\u00b8\2\uffff\1\u00ba",
            "\1\u00b0\1\u00b1\1\uffff\1\u00ad\1\u00ae\2\uffff\1\u00af",
            "\1\u00ab\1\u00ac\1\uffff\1\u00aa\1\u00a9\2\uffff\1\u00a8",
            "\1\u00bf\1\u00c0\1\uffff\1\u00be\1\u00bd\2\uffff\1\u00bc",
            "\1\u00bf\1\u00c0\1\uffff\1\u00be\1\u00bd\2\uffff\1\u00bc",
            "\1\u009e\1\u00a2\1\uffff\1\u00a0\1\u009f\2\uffff\1\u00a1",
            "\1\u00b2\1\u00b6\1\uffff\1\u00b4\1\u00b3\2\uffff\1\u00b5",
            "\1\21\2\uffff\1\15",
            "\1\176",
            "\1\15\2\uffff\1\21",
            "\1\174",
            "\1\161",
            "\1\15\2\uffff\1\17",
            "\1\u0081",
            "\1\162",
            "\1\165",
            "\1\17\2\uffff\1\15",
            "\1\21\2\uffff\1\17",
            "\1\u0084",
            "\1\17\2\uffff\1\21",
            "\1\167",
            "\1\163",
            "\1\12\2\uffff\1\15",
            "\1\u008d",
            "\1\173",
            "\1\15\2\uffff\1\12",
            "\1\164",
            "\1\17\2\uffff\1\12",
            "\1\u0087",
            "\1\170",
            "\1\166",
            "\1\12\2\uffff\1\17",
            "\1\21\2\uffff\1\12",
            "\1\u008a",
            "\1\12\2\uffff\1\21",
            "\1\172",
            "\1\171",
            "\1\11\2\uffff\1\21",
            "\1\21\2\uffff\1\11",
            "\1\u0089",
            "\1\175",
            "\1\u0083",
            "\1\11\2\uffff\1\15",
            "\1\15\2\uffff\1\11",
            "\1\177",
            "\1\u008e",
            "\1\u0080",
            "\1\11\2\uffff\1\17",
            "\1\17\2\uffff\1\11",
            "\1\u0085",
            "\1\u0088",
            "\1\u0082",
            "\1\11\2\uffff\1\12",
            "\1\12\2\uffff\1\11",
            "\1\u008b",
            "\1\u008c",
            "\1\u0086"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "811:3: ( (otherlv_1= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_filter_3_0= Filter ) ) otherlv_4= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_5_0= Sort ) ) otherlv_6= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_7_0= Creation ) ) otherlv_8= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_9_0= Deletion ) ) otherlv_10= Comma ) ) ) ) )* ) ) ) ( (lv_group_11_0= Group ) ) ) | (otherlv_12= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_14_0= Group ) ) otherlv_15= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_16_0= Sort ) ) otherlv_17= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_18_0= Creation ) ) otherlv_19= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_20_0= Deletion ) ) otherlv_21= Comma ) ) ) ) )* ) ) ) ( (lv_filter_22_0= Filter ) ) ) | (otherlv_23= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_25_0= Group ) ) otherlv_26= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_27_0= Filter ) ) otherlv_28= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_29_0= Creation ) ) otherlv_30= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_31_0= Deletion ) ) otherlv_32= Comma ) ) ) ) )* ) ) ) ( (lv_sort_33_0= Sort ) ) ) | (otherlv_34= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_36_0= Group ) ) otherlv_37= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_38_0= Filter ) ) otherlv_39= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_40_0= Sort ) ) otherlv_41= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_deletion_42_0= Deletion ) ) otherlv_43= Comma ) ) ) ) )* ) ) ) ( (lv_creation_44_0= Creation ) ) ) | (otherlv_45= VerticalLine ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_group_47_0= Group ) ) otherlv_48= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_filter_49_0= Filter ) ) otherlv_50= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_sort_51_0= Sort ) ) otherlv_52= Comma ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_creation_53_0= Creation ) ) otherlv_54= Comma ) ) ) ) )* ) ) ) ( (lv_deletion_55_0= Deletion ) ) ) )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001000030000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001848000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001048000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000000026C0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000004800C800L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000049000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000400002L});

}
