package de.ubt.ai1.m2m.bxtenddsl.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBXtendDSLParser extends AbstractInternalContentAssistParser {
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
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("Semicolon", "';'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("VerticalLine", "'|'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("As", "'as'");
    		tokenNameToValue.put("HyphenMinusHyphenMinusGreaterThanSign", "'-->'");
    		tokenNameToValue.put("LessThanSignHyphenMinusHyphenMinus", "'<--'");
    		tokenNameToValue.put("Get", "'get'");
    		tokenNameToValue.put("Set", "'set'");
    		tokenNameToValue.put("Src", "'src'");
    		tokenNameToValue.put("Trg", "'trg'");
    		tokenNameToValue.put("LessThanSignHyphenMinusHyphenMinusGreaterThanSign", "'<-->'");
    		tokenNameToValue.put("Rule", "'rule'");
    		tokenNameToValue.put("Sort", "'sort'");
    		tokenNameToValue.put("Group", "'group'");
    		tokenNameToValue.put("Filter", "'filter'");
    		tokenNameToValue.put("Options", "'options'");
    		tokenNameToValue.put("Creation", "'creation'");
    		tokenNameToValue.put("Deletion", "'deletion'");
    		tokenNameToValue.put("Sourcemodel", "'sourcemodel'");
    		tokenNameToValue.put("Targetmodel", "'targetmodel'");
    	}

    	public void setGrammarAccess(BXtendDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleBXtendDSL"
    // InternalBXtendDSLParser.g:82:1: entryRuleBXtendDSL : ruleBXtendDSL EOF ;
    public final void entryRuleBXtendDSL() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:83:1: ( ruleBXtendDSL EOF )
            // InternalBXtendDSLParser.g:84:1: ruleBXtendDSL EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBXtendDSL();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBXtendDSL"


    // $ANTLR start "ruleBXtendDSL"
    // InternalBXtendDSLParser.g:91:1: ruleBXtendDSL : ( ( rule__BXtendDSL__Group__0 ) ) ;
    public final void ruleBXtendDSL() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:95:2: ( ( ( rule__BXtendDSL__Group__0 ) ) )
            // InternalBXtendDSLParser.g:96:2: ( ( rule__BXtendDSL__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:96:2: ( ( rule__BXtendDSL__Group__0 ) )
            // InternalBXtendDSLParser.g:97:3: ( rule__BXtendDSL__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:98:3: ( rule__BXtendDSL__Group__0 )
            // InternalBXtendDSLParser.g:98:4: rule__BXtendDSL__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBXtendDSL"


    // $ANTLR start "entryRuleMetamodels"
    // InternalBXtendDSLParser.g:107:1: entryRuleMetamodels : ruleMetamodels EOF ;
    public final void entryRuleMetamodels() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:108:1: ( ruleMetamodels EOF )
            // InternalBXtendDSLParser.g:109:1: ruleMetamodels EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMetamodels();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetamodels"


    // $ANTLR start "ruleMetamodels"
    // InternalBXtendDSLParser.g:116:1: ruleMetamodels : ( ( rule__Metamodels__Group__0 ) ) ;
    public final void ruleMetamodels() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:120:2: ( ( ( rule__Metamodels__Group__0 ) ) )
            // InternalBXtendDSLParser.g:121:2: ( ( rule__Metamodels__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:121:2: ( ( rule__Metamodels__Group__0 ) )
            // InternalBXtendDSLParser.g:122:3: ( rule__Metamodels__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:123:3: ( rule__Metamodels__Group__0 )
            // InternalBXtendDSLParser.g:123:4: rule__Metamodels__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetamodels"


    // $ANTLR start "entryRuleCustomizedElement"
    // InternalBXtendDSLParser.g:132:1: entryRuleCustomizedElement : ruleCustomizedElement EOF ;
    public final void entryRuleCustomizedElement() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:133:1: ( ruleCustomizedElement EOF )
            // InternalBXtendDSLParser.g:134:1: ruleCustomizedElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedElementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCustomizedElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedElementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCustomizedElement"


    // $ANTLR start "ruleCustomizedElement"
    // InternalBXtendDSLParser.g:141:1: ruleCustomizedElement : ( ( rule__CustomizedElement__Alternatives ) ) ;
    public final void ruleCustomizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:145:2: ( ( ( rule__CustomizedElement__Alternatives ) ) )
            // InternalBXtendDSLParser.g:146:2: ( ( rule__CustomizedElement__Alternatives ) )
            {
            // InternalBXtendDSLParser.g:146:2: ( ( rule__CustomizedElement__Alternatives ) )
            // InternalBXtendDSLParser.g:147:3: ( rule__CustomizedElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedElementAccess().getAlternatives()); 
            }
            // InternalBXtendDSLParser.g:148:3: ( rule__CustomizedElement__Alternatives )
            // InternalBXtendDSLParser.g:148:4: rule__CustomizedElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedElement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedElementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCustomizedElement"


    // $ANTLR start "entryRuleCustomizedGetter"
    // InternalBXtendDSLParser.g:157:1: entryRuleCustomizedGetter : ruleCustomizedGetter EOF ;
    public final void entryRuleCustomizedGetter() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:158:1: ( ruleCustomizedGetter EOF )
            // InternalBXtendDSLParser.g:159:1: ruleCustomizedGetter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCustomizedGetter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCustomizedGetter"


    // $ANTLR start "ruleCustomizedGetter"
    // InternalBXtendDSLParser.g:166:1: ruleCustomizedGetter : ( ( rule__CustomizedGetter__Group__0 ) ) ;
    public final void ruleCustomizedGetter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:170:2: ( ( ( rule__CustomizedGetter__Group__0 ) ) )
            // InternalBXtendDSLParser.g:171:2: ( ( rule__CustomizedGetter__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:171:2: ( ( rule__CustomizedGetter__Group__0 ) )
            // InternalBXtendDSLParser.g:172:3: ( rule__CustomizedGetter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:173:3: ( rule__CustomizedGetter__Group__0 )
            // InternalBXtendDSLParser.g:173:4: rule__CustomizedGetter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCustomizedGetter"


    // $ANTLR start "entryRuleCustomizedSetter"
    // InternalBXtendDSLParser.g:182:1: entryRuleCustomizedSetter : ruleCustomizedSetter EOF ;
    public final void entryRuleCustomizedSetter() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:183:1: ( ruleCustomizedSetter EOF )
            // InternalBXtendDSLParser.g:184:1: ruleCustomizedSetter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCustomizedSetter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCustomizedSetter"


    // $ANTLR start "ruleCustomizedSetter"
    // InternalBXtendDSLParser.g:191:1: ruleCustomizedSetter : ( ( rule__CustomizedSetter__Group__0 ) ) ;
    public final void ruleCustomizedSetter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:195:2: ( ( ( rule__CustomizedSetter__Group__0 ) ) )
            // InternalBXtendDSLParser.g:196:2: ( ( rule__CustomizedSetter__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:196:2: ( ( rule__CustomizedSetter__Group__0 ) )
            // InternalBXtendDSLParser.g:197:3: ( rule__CustomizedSetter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:198:3: ( rule__CustomizedSetter__Group__0 )
            // InternalBXtendDSLParser.g:198:4: rule__CustomizedSetter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCustomizedSetter"


    // $ANTLR start "entryRuleConfig"
    // InternalBXtendDSLParser.g:207:1: entryRuleConfig : ruleConfig EOF ;
    public final void entryRuleConfig() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:208:1: ( ruleConfig EOF )
            // InternalBXtendDSLParser.g:209:1: ruleConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // InternalBXtendDSLParser.g:216:1: ruleConfig : ( ( rule__Config__Group__0 ) ) ;
    public final void ruleConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:220:2: ( ( ( rule__Config__Group__0 ) ) )
            // InternalBXtendDSLParser.g:221:2: ( ( rule__Config__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:221:2: ( ( rule__Config__Group__0 ) )
            // InternalBXtendDSLParser.g:222:3: ( rule__Config__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:223:3: ( rule__Config__Group__0 )
            // InternalBXtendDSLParser.g:223:4: rule__Config__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Config__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRuleTransformationRule"
    // InternalBXtendDSLParser.g:232:1: entryRuleTransformationRule : ruleTransformationRule EOF ;
    public final void entryRuleTransformationRule() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:233:1: ( ruleTransformationRule EOF )
            // InternalBXtendDSLParser.g:234:1: ruleTransformationRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTransformationRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformationRule"


    // $ANTLR start "ruleTransformationRule"
    // InternalBXtendDSLParser.g:241:1: ruleTransformationRule : ( ( rule__TransformationRule__Group__0 ) ) ;
    public final void ruleTransformationRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:245:2: ( ( ( rule__TransformationRule__Group__0 ) ) )
            // InternalBXtendDSLParser.g:246:2: ( ( rule__TransformationRule__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:246:2: ( ( rule__TransformationRule__Group__0 ) )
            // InternalBXtendDSLParser.g:247:3: ( rule__TransformationRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:248:3: ( rule__TransformationRule__Group__0 )
            // InternalBXtendDSLParser.g:248:4: rule__TransformationRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformationRule"


    // $ANTLR start "entryRuleSrcClassMatcher"
    // InternalBXtendDSLParser.g:257:1: entryRuleSrcClassMatcher : ruleSrcClassMatcher EOF ;
    public final void entryRuleSrcClassMatcher() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:258:1: ( ruleSrcClassMatcher EOF )
            // InternalBXtendDSLParser.g:259:1: ruleSrcClassMatcher EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSrcClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSrcClassMatcher"


    // $ANTLR start "ruleSrcClassMatcher"
    // InternalBXtendDSLParser.g:266:1: ruleSrcClassMatcher : ( ( rule__SrcClassMatcher__Group__0 ) ) ;
    public final void ruleSrcClassMatcher() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:270:2: ( ( ( rule__SrcClassMatcher__Group__0 ) ) )
            // InternalBXtendDSLParser.g:271:2: ( ( rule__SrcClassMatcher__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:271:2: ( ( rule__SrcClassMatcher__Group__0 ) )
            // InternalBXtendDSLParser.g:272:3: ( rule__SrcClassMatcher__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:273:3: ( rule__SrcClassMatcher__Group__0 )
            // InternalBXtendDSLParser.g:273:4: rule__SrcClassMatcher__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSrcClassMatcher"


    // $ANTLR start "entryRuleTrgClassMatcher"
    // InternalBXtendDSLParser.g:282:1: entryRuleTrgClassMatcher : ruleTrgClassMatcher EOF ;
    public final void entryRuleTrgClassMatcher() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:283:1: ( ruleTrgClassMatcher EOF )
            // InternalBXtendDSLParser.g:284:1: ruleTrgClassMatcher EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTrgClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrgClassMatcher"


    // $ANTLR start "ruleTrgClassMatcher"
    // InternalBXtendDSLParser.g:291:1: ruleTrgClassMatcher : ( ( rule__TrgClassMatcher__Group__0 ) ) ;
    public final void ruleTrgClassMatcher() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:295:2: ( ( ( rule__TrgClassMatcher__Group__0 ) ) )
            // InternalBXtendDSLParser.g:296:2: ( ( rule__TrgClassMatcher__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:296:2: ( ( rule__TrgClassMatcher__Group__0 ) )
            // InternalBXtendDSLParser.g:297:3: ( rule__TrgClassMatcher__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:298:3: ( rule__TrgClassMatcher__Group__0 )
            // InternalBXtendDSLParser.g:298:4: rule__TrgClassMatcher__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrgClassMatcher"


    // $ANTLR start "entryRuleClassMatcherModifier"
    // InternalBXtendDSLParser.g:307:1: entryRuleClassMatcherModifier : ruleClassMatcherModifier EOF ;
    public final void entryRuleClassMatcherModifier() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:308:1: ( ruleClassMatcherModifier EOF )
            // InternalBXtendDSLParser.g:309:1: ruleClassMatcherModifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassMatcherModifier"


    // $ANTLR start "ruleClassMatcherModifier"
    // InternalBXtendDSLParser.g:316:1: ruleClassMatcherModifier : ( ( rule__ClassMatcherModifier__Group__0 ) ) ;
    public final void ruleClassMatcherModifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:320:2: ( ( ( rule__ClassMatcherModifier__Group__0 ) ) )
            // InternalBXtendDSLParser.g:321:2: ( ( rule__ClassMatcherModifier__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:321:2: ( ( rule__ClassMatcherModifier__Group__0 ) )
            // InternalBXtendDSLParser.g:322:3: ( rule__ClassMatcherModifier__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:323:3: ( rule__ClassMatcherModifier__Group__0 )
            // InternalBXtendDSLParser.g:323:4: rule__ClassMatcherModifier__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassMatcherModifier"


    // $ANTLR start "entryRuleFeatureMapping"
    // InternalBXtendDSLParser.g:332:1: entryRuleFeatureMapping : ruleFeatureMapping EOF ;
    public final void entryRuleFeatureMapping() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:333:1: ( ruleFeatureMapping EOF )
            // InternalBXtendDSLParser.g:334:1: ruleFeatureMapping EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFeatureMapping();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureMapping"


    // $ANTLR start "ruleFeatureMapping"
    // InternalBXtendDSLParser.g:341:1: ruleFeatureMapping : ( ( rule__FeatureMapping__Group__0 ) ) ;
    public final void ruleFeatureMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:345:2: ( ( ( rule__FeatureMapping__Group__0 ) ) )
            // InternalBXtendDSLParser.g:346:2: ( ( rule__FeatureMapping__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:346:2: ( ( rule__FeatureMapping__Group__0 ) )
            // InternalBXtendDSLParser.g:347:3: ( rule__FeatureMapping__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:348:3: ( rule__FeatureMapping__Group__0 )
            // InternalBXtendDSLParser.g:348:4: rule__FeatureMapping__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureMapping"


    // $ANTLR start "entryRuleSrcMappingFeature"
    // InternalBXtendDSLParser.g:357:1: entryRuleSrcMappingFeature : ruleSrcMappingFeature EOF ;
    public final void entryRuleSrcMappingFeature() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:358:1: ( ruleSrcMappingFeature EOF )
            // InternalBXtendDSLParser.g:359:1: ruleSrcMappingFeature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSrcMappingFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSrcMappingFeature"


    // $ANTLR start "ruleSrcMappingFeature"
    // InternalBXtendDSLParser.g:366:1: ruleSrcMappingFeature : ( ( rule__SrcMappingFeature__Alternatives ) ) ;
    public final void ruleSrcMappingFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:370:2: ( ( ( rule__SrcMappingFeature__Alternatives ) ) )
            // InternalBXtendDSLParser.g:371:2: ( ( rule__SrcMappingFeature__Alternatives ) )
            {
            // InternalBXtendDSLParser.g:371:2: ( ( rule__SrcMappingFeature__Alternatives ) )
            // InternalBXtendDSLParser.g:372:3: ( rule__SrcMappingFeature__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getAlternatives()); 
            }
            // InternalBXtendDSLParser.g:373:3: ( rule__SrcMappingFeature__Alternatives )
            // InternalBXtendDSLParser.g:373:4: rule__SrcMappingFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSrcMappingFeature"


    // $ANTLR start "entryRuleTrgMappingFeature"
    // InternalBXtendDSLParser.g:382:1: entryRuleTrgMappingFeature : ruleTrgMappingFeature EOF ;
    public final void entryRuleTrgMappingFeature() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:383:1: ( ruleTrgMappingFeature EOF )
            // InternalBXtendDSLParser.g:384:1: ruleTrgMappingFeature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTrgMappingFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrgMappingFeature"


    // $ANTLR start "ruleTrgMappingFeature"
    // InternalBXtendDSLParser.g:391:1: ruleTrgMappingFeature : ( ( rule__TrgMappingFeature__Alternatives ) ) ;
    public final void ruleTrgMappingFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:395:2: ( ( ( rule__TrgMappingFeature__Alternatives ) ) )
            // InternalBXtendDSLParser.g:396:2: ( ( rule__TrgMappingFeature__Alternatives ) )
            {
            // InternalBXtendDSLParser.g:396:2: ( ( rule__TrgMappingFeature__Alternatives ) )
            // InternalBXtendDSLParser.g:397:3: ( rule__TrgMappingFeature__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getAlternatives()); 
            }
            // InternalBXtendDSLParser.g:398:3: ( rule__TrgMappingFeature__Alternatives )
            // InternalBXtendDSLParser.g:398:4: rule__TrgMappingFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrgMappingFeature"


    // $ANTLR start "entryRuleCorrespondence"
    // InternalBXtendDSLParser.g:407:1: entryRuleCorrespondence : ruleCorrespondence EOF ;
    public final void entryRuleCorrespondence() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:408:1: ( ruleCorrespondence EOF )
            // InternalBXtendDSLParser.g:409:1: ruleCorrespondence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCorrespondence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCorrespondence"


    // $ANTLR start "ruleCorrespondence"
    // InternalBXtendDSLParser.g:416:1: ruleCorrespondence : ( ( rule__Correspondence__Group__0 ) ) ;
    public final void ruleCorrespondence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:420:2: ( ( ( rule__Correspondence__Group__0 ) ) )
            // InternalBXtendDSLParser.g:421:2: ( ( rule__Correspondence__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:421:2: ( ( rule__Correspondence__Group__0 ) )
            // InternalBXtendDSLParser.g:422:3: ( rule__Correspondence__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:423:3: ( rule__Correspondence__Group__0 )
            // InternalBXtendDSLParser.g:423:4: rule__Correspondence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCorrespondence"


    // $ANTLR start "entryRuleFeatureAccess"
    // InternalBXtendDSLParser.g:432:1: entryRuleFeatureAccess : ruleFeatureAccess EOF ;
    public final void entryRuleFeatureAccess() throws RecognitionException {
        try {
            // InternalBXtendDSLParser.g:433:1: ( ruleFeatureAccess EOF )
            // InternalBXtendDSLParser.g:434:1: ruleFeatureAccess EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureAccess"


    // $ANTLR start "ruleFeatureAccess"
    // InternalBXtendDSLParser.g:441:1: ruleFeatureAccess : ( ( rule__FeatureAccess__Group__0 ) ) ;
    public final void ruleFeatureAccess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:445:2: ( ( ( rule__FeatureAccess__Group__0 ) ) )
            // InternalBXtendDSLParser.g:446:2: ( ( rule__FeatureAccess__Group__0 ) )
            {
            // InternalBXtendDSLParser.g:446:2: ( ( rule__FeatureAccess__Group__0 ) )
            // InternalBXtendDSLParser.g:447:3: ( rule__FeatureAccess__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getGroup()); 
            }
            // InternalBXtendDSLParser.g:448:3: ( rule__FeatureAccess__Group__0 )
            // InternalBXtendDSLParser.g:448:4: rule__FeatureAccess__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureAccess__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureAccess"


    // $ANTLR start "ruleDirection"
    // InternalBXtendDSLParser.g:457:1: ruleDirection : ( ( rule__Direction__Alternatives ) ) ;
    public final void ruleDirection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:461:1: ( ( ( rule__Direction__Alternatives ) ) )
            // InternalBXtendDSLParser.g:462:2: ( ( rule__Direction__Alternatives ) )
            {
            // InternalBXtendDSLParser.g:462:2: ( ( rule__Direction__Alternatives ) )
            // InternalBXtendDSLParser.g:463:3: ( rule__Direction__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectionAccess().getAlternatives()); 
            }
            // InternalBXtendDSLParser.g:464:3: ( rule__Direction__Alternatives )
            // InternalBXtendDSLParser.g:464:4: rule__Direction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Direction__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirection"


    // $ANTLR start "rule__CustomizedElement__Alternatives"
    // InternalBXtendDSLParser.g:472:1: rule__CustomizedElement__Alternatives : ( ( ruleCustomizedGetter ) | ( ruleCustomizedSetter ) );
    public final void rule__CustomizedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:476:1: ( ( ruleCustomizedGetter ) | ( ruleCustomizedSetter ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Get) ) {
                alt1=1;
            }
            else if ( (LA1_0==Set) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBXtendDSLParser.g:477:2: ( ruleCustomizedGetter )
                    {
                    // InternalBXtendDSLParser.g:477:2: ( ruleCustomizedGetter )
                    // InternalBXtendDSLParser.g:478:3: ruleCustomizedGetter
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCustomizedElementAccess().getCustomizedGetterParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCustomizedGetter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCustomizedElementAccess().getCustomizedGetterParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:483:2: ( ruleCustomizedSetter )
                    {
                    // InternalBXtendDSLParser.g:483:2: ( ruleCustomizedSetter )
                    // InternalBXtendDSLParser.g:484:3: ruleCustomizedSetter
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCustomizedElementAccess().getCustomizedSetterParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCustomizedSetter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCustomizedElementAccess().getCustomizedSetterParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedElement__Alternatives"


    // $ANTLR start "rule__ClassMatcherModifier__Alternatives_1"
    // InternalBXtendDSLParser.g:493:1: rule__ClassMatcherModifier__Alternatives_1 : ( ( ( rule__ClassMatcherModifier__Group_1_0__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_1__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_2__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_3__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_4__0 ) ) );
    public final void rule__ClassMatcherModifier__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:497:1: ( ( ( rule__ClassMatcherModifier__Group_1_0__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_1__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_2__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_3__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_4__0 ) ) )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalBXtendDSLParser.g:498:2: ( ( rule__ClassMatcherModifier__Group_1_0__0 ) )
                    {
                    // InternalBXtendDSLParser.g:498:2: ( ( rule__ClassMatcherModifier__Group_1_0__0 ) )
                    // InternalBXtendDSLParser.g:499:3: ( rule__ClassMatcherModifier__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:500:3: ( rule__ClassMatcherModifier__Group_1_0__0 )
                    // InternalBXtendDSLParser.g:500:4: rule__ClassMatcherModifier__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:504:2: ( ( rule__ClassMatcherModifier__Group_1_1__0 ) )
                    {
                    // InternalBXtendDSLParser.g:504:2: ( ( rule__ClassMatcherModifier__Group_1_1__0 ) )
                    // InternalBXtendDSLParser.g:505:3: ( rule__ClassMatcherModifier__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:506:3: ( rule__ClassMatcherModifier__Group_1_1__0 )
                    // InternalBXtendDSLParser.g:506:4: rule__ClassMatcherModifier__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:510:2: ( ( rule__ClassMatcherModifier__Group_1_2__0 ) )
                    {
                    // InternalBXtendDSLParser.g:510:2: ( ( rule__ClassMatcherModifier__Group_1_2__0 ) )
                    // InternalBXtendDSLParser.g:511:3: ( rule__ClassMatcherModifier__Group_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:512:3: ( rule__ClassMatcherModifier__Group_1_2__0 )
                    // InternalBXtendDSLParser.g:512:4: rule__ClassMatcherModifier__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:516:2: ( ( rule__ClassMatcherModifier__Group_1_3__0 ) )
                    {
                    // InternalBXtendDSLParser.g:516:2: ( ( rule__ClassMatcherModifier__Group_1_3__0 ) )
                    // InternalBXtendDSLParser.g:517:3: ( rule__ClassMatcherModifier__Group_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:518:3: ( rule__ClassMatcherModifier__Group_1_3__0 )
                    // InternalBXtendDSLParser.g:518:4: rule__ClassMatcherModifier__Group_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalBXtendDSLParser.g:522:2: ( ( rule__ClassMatcherModifier__Group_1_4__0 ) )
                    {
                    // InternalBXtendDSLParser.g:522:2: ( ( rule__ClassMatcherModifier__Group_1_4__0 ) )
                    // InternalBXtendDSLParser.g:523:3: ( rule__ClassMatcherModifier__Group_1_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4()); 
                    }
                    // InternalBXtendDSLParser.g:524:3: ( rule__ClassMatcherModifier__Group_1_4__0 )
                    // InternalBXtendDSLParser.g:524:4: rule__ClassMatcherModifier__Group_1_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Alternatives_1"


    // $ANTLR start "rule__FeatureMapping__Alternatives_0"
    // InternalBXtendDSLParser.g:532:1: rule__FeatureMapping__Alternatives_0 : ( ( ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 ) ) | ( ( rule__FeatureMapping__SrcClassesAssignment_0_1 ) ) );
    public final void rule__FeatureMapping__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:536:1: ( ( ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 ) ) | ( ( rule__FeatureMapping__SrcClassesAssignment_0_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==EOF||LA3_1==LessThanSignHyphenMinusHyphenMinusGreaterThanSign||(LA3_1>=HyphenMinusHyphenMinusGreaterThanSign && LA3_1<=LessThanSignHyphenMinusHyphenMinus)||LA3_1==LeftCurlyBracket||LA3_1==RULE_ID) ) {
                    alt3=2;
                }
                else if ( (LA3_1==FullStop) ) {
                    alt3=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==LeftCurlyBracket) ) {
                alt3=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBXtendDSLParser.g:537:2: ( ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 ) )
                    {
                    // InternalBXtendDSLParser.g:537:2: ( ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 ) )
                    // InternalBXtendDSLParser.g:538:3: ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureMappingAccess().getSrcFeaturesAssignment_0_0()); 
                    }
                    // InternalBXtendDSLParser.g:539:3: ( rule__FeatureMapping__SrcFeaturesAssignment_0_0 )
                    // InternalBXtendDSLParser.g:539:4: rule__FeatureMapping__SrcFeaturesAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureMapping__SrcFeaturesAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureMappingAccess().getSrcFeaturesAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:543:2: ( ( rule__FeatureMapping__SrcClassesAssignment_0_1 ) )
                    {
                    // InternalBXtendDSLParser.g:543:2: ( ( rule__FeatureMapping__SrcClassesAssignment_0_1 ) )
                    // InternalBXtendDSLParser.g:544:3: ( rule__FeatureMapping__SrcClassesAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureMappingAccess().getSrcClassesAssignment_0_1()); 
                    }
                    // InternalBXtendDSLParser.g:545:3: ( rule__FeatureMapping__SrcClassesAssignment_0_1 )
                    // InternalBXtendDSLParser.g:545:4: rule__FeatureMapping__SrcClassesAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureMapping__SrcClassesAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureMappingAccess().getSrcClassesAssignment_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Alternatives_0"


    // $ANTLR start "rule__FeatureMapping__Alternatives_2"
    // InternalBXtendDSLParser.g:553:1: rule__FeatureMapping__Alternatives_2 : ( ( ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 ) ) | ( ( rule__FeatureMapping__TrgClassesAssignment_2_1 ) ) );
    public final void rule__FeatureMapping__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:557:1: ( ( ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 ) ) | ( ( rule__FeatureMapping__TrgClassesAssignment_2_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||LA4_1==Semicolon||LA4_1==LeftCurlyBracket||LA4_1==RULE_ID) ) {
                    alt4=2;
                }
                else if ( (LA4_1==FullStop) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==LeftCurlyBracket) ) {
                alt4=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBXtendDSLParser.g:558:2: ( ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 ) )
                    {
                    // InternalBXtendDSLParser.g:558:2: ( ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 ) )
                    // InternalBXtendDSLParser.g:559:3: ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureMappingAccess().getTrgFeaturesAssignment_2_0()); 
                    }
                    // InternalBXtendDSLParser.g:560:3: ( rule__FeatureMapping__TrgFeaturesAssignment_2_0 )
                    // InternalBXtendDSLParser.g:560:4: rule__FeatureMapping__TrgFeaturesAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureMapping__TrgFeaturesAssignment_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureMappingAccess().getTrgFeaturesAssignment_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:564:2: ( ( rule__FeatureMapping__TrgClassesAssignment_2_1 ) )
                    {
                    // InternalBXtendDSLParser.g:564:2: ( ( rule__FeatureMapping__TrgClassesAssignment_2_1 ) )
                    // InternalBXtendDSLParser.g:565:3: ( rule__FeatureMapping__TrgClassesAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureMappingAccess().getTrgClassesAssignment_2_1()); 
                    }
                    // InternalBXtendDSLParser.g:566:3: ( rule__FeatureMapping__TrgClassesAssignment_2_1 )
                    // InternalBXtendDSLParser.g:566:4: rule__FeatureMapping__TrgClassesAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureMapping__TrgClassesAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureMappingAccess().getTrgClassesAssignment_2_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Alternatives_2"


    // $ANTLR start "rule__SrcMappingFeature__Alternatives"
    // InternalBXtendDSLParser.g:574:1: rule__SrcMappingFeature__Alternatives : ( ( ( rule__SrcMappingFeature__FeatureAssignment_0 ) ) | ( ( rule__SrcMappingFeature__Group_1__0 ) ) );
    public final void rule__SrcMappingFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:578:1: ( ( ( rule__SrcMappingFeature__FeatureAssignment_0 ) ) | ( ( rule__SrcMappingFeature__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==LeftCurlyBracket) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBXtendDSLParser.g:579:2: ( ( rule__SrcMappingFeature__FeatureAssignment_0 ) )
                    {
                    // InternalBXtendDSLParser.g:579:2: ( ( rule__SrcMappingFeature__FeatureAssignment_0 ) )
                    // InternalBXtendDSLParser.g:580:3: ( rule__SrcMappingFeature__FeatureAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSrcMappingFeatureAccess().getFeatureAssignment_0()); 
                    }
                    // InternalBXtendDSLParser.g:581:3: ( rule__SrcMappingFeature__FeatureAssignment_0 )
                    // InternalBXtendDSLParser.g:581:4: rule__SrcMappingFeature__FeatureAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SrcMappingFeature__FeatureAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSrcMappingFeatureAccess().getFeatureAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:585:2: ( ( rule__SrcMappingFeature__Group_1__0 ) )
                    {
                    // InternalBXtendDSLParser.g:585:2: ( ( rule__SrcMappingFeature__Group_1__0 ) )
                    // InternalBXtendDSLParser.g:586:3: ( rule__SrcMappingFeature__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSrcMappingFeatureAccess().getGroup_1()); 
                    }
                    // InternalBXtendDSLParser.g:587:3: ( rule__SrcMappingFeature__Group_1__0 )
                    // InternalBXtendDSLParser.g:587:4: rule__SrcMappingFeature__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SrcMappingFeature__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSrcMappingFeatureAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Alternatives"


    // $ANTLR start "rule__TrgMappingFeature__Alternatives"
    // InternalBXtendDSLParser.g:595:1: rule__TrgMappingFeature__Alternatives : ( ( ( rule__TrgMappingFeature__FeatureAssignment_0 ) ) | ( ( rule__TrgMappingFeature__Group_1__0 ) ) );
    public final void rule__TrgMappingFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:599:1: ( ( ( rule__TrgMappingFeature__FeatureAssignment_0 ) ) | ( ( rule__TrgMappingFeature__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==LeftCurlyBracket) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBXtendDSLParser.g:600:2: ( ( rule__TrgMappingFeature__FeatureAssignment_0 ) )
                    {
                    // InternalBXtendDSLParser.g:600:2: ( ( rule__TrgMappingFeature__FeatureAssignment_0 ) )
                    // InternalBXtendDSLParser.g:601:3: ( rule__TrgMappingFeature__FeatureAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTrgMappingFeatureAccess().getFeatureAssignment_0()); 
                    }
                    // InternalBXtendDSLParser.g:602:3: ( rule__TrgMappingFeature__FeatureAssignment_0 )
                    // InternalBXtendDSLParser.g:602:4: rule__TrgMappingFeature__FeatureAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrgMappingFeature__FeatureAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTrgMappingFeatureAccess().getFeatureAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:606:2: ( ( rule__TrgMappingFeature__Group_1__0 ) )
                    {
                    // InternalBXtendDSLParser.g:606:2: ( ( rule__TrgMappingFeature__Group_1__0 ) )
                    // InternalBXtendDSLParser.g:607:3: ( rule__TrgMappingFeature__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTrgMappingFeatureAccess().getGroup_1()); 
                    }
                    // InternalBXtendDSLParser.g:608:3: ( rule__TrgMappingFeature__Group_1__0 )
                    // InternalBXtendDSLParser.g:608:4: rule__TrgMappingFeature__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrgMappingFeature__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTrgMappingFeatureAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Alternatives"


    // $ANTLR start "rule__Direction__Alternatives"
    // InternalBXtendDSLParser.g:616:1: rule__Direction__Alternatives : ( ( ( HyphenMinusHyphenMinusGreaterThanSign ) ) | ( ( LessThanSignHyphenMinusHyphenMinus ) ) | ( ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) ) );
    public final void rule__Direction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:620:1: ( ( ( HyphenMinusHyphenMinusGreaterThanSign ) ) | ( ( LessThanSignHyphenMinusHyphenMinus ) ) | ( ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case HyphenMinusHyphenMinusGreaterThanSign:
                {
                alt7=1;
                }
                break;
            case LessThanSignHyphenMinusHyphenMinus:
                {
                alt7=2;
                }
                break;
            case LessThanSignHyphenMinusHyphenMinusGreaterThanSign:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalBXtendDSLParser.g:621:2: ( ( HyphenMinusHyphenMinusGreaterThanSign ) )
                    {
                    // InternalBXtendDSLParser.g:621:2: ( ( HyphenMinusHyphenMinusGreaterThanSign ) )
                    // InternalBXtendDSLParser.g:622:3: ( HyphenMinusHyphenMinusGreaterThanSign )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDirectionAccess().getFWDEnumLiteralDeclaration_0()); 
                    }
                    // InternalBXtendDSLParser.g:623:3: ( HyphenMinusHyphenMinusGreaterThanSign )
                    // InternalBXtendDSLParser.g:623:4: HyphenMinusHyphenMinusGreaterThanSign
                    {
                    match(input,HyphenMinusHyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDirectionAccess().getFWDEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:627:2: ( ( LessThanSignHyphenMinusHyphenMinus ) )
                    {
                    // InternalBXtendDSLParser.g:627:2: ( ( LessThanSignHyphenMinusHyphenMinus ) )
                    // InternalBXtendDSLParser.g:628:3: ( LessThanSignHyphenMinusHyphenMinus )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDirectionAccess().getBWDEnumLiteralDeclaration_1()); 
                    }
                    // InternalBXtendDSLParser.g:629:3: ( LessThanSignHyphenMinusHyphenMinus )
                    // InternalBXtendDSLParser.g:629:4: LessThanSignHyphenMinusHyphenMinus
                    {
                    match(input,LessThanSignHyphenMinusHyphenMinus,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDirectionAccess().getBWDEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:633:2: ( ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) )
                    {
                    // InternalBXtendDSLParser.g:633:2: ( ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign ) )
                    // InternalBXtendDSLParser.g:634:3: ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDirectionAccess().getBXEnumLiteralDeclaration_2()); 
                    }
                    // InternalBXtendDSLParser.g:635:3: ( LessThanSignHyphenMinusHyphenMinusGreaterThanSign )
                    // InternalBXtendDSLParser.g:635:4: LessThanSignHyphenMinusHyphenMinusGreaterThanSign
                    {
                    match(input,LessThanSignHyphenMinusHyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDirectionAccess().getBXEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Direction__Alternatives"


    // $ANTLR start "rule__BXtendDSL__Group__0"
    // InternalBXtendDSLParser.g:643:1: rule__BXtendDSL__Group__0 : rule__BXtendDSL__Group__0__Impl rule__BXtendDSL__Group__1 ;
    public final void rule__BXtendDSL__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:647:1: ( rule__BXtendDSL__Group__0__Impl rule__BXtendDSL__Group__1 )
            // InternalBXtendDSLParser.g:648:2: rule__BXtendDSL__Group__0__Impl rule__BXtendDSL__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__BXtendDSL__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__0"


    // $ANTLR start "rule__BXtendDSL__Group__0__Impl"
    // InternalBXtendDSLParser.g:655:1: rule__BXtendDSL__Group__0__Impl : ( ( rule__BXtendDSL__MetamodelsAssignment_0 ) ) ;
    public final void rule__BXtendDSL__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:659:1: ( ( ( rule__BXtendDSL__MetamodelsAssignment_0 ) ) )
            // InternalBXtendDSLParser.g:660:1: ( ( rule__BXtendDSL__MetamodelsAssignment_0 ) )
            {
            // InternalBXtendDSLParser.g:660:1: ( ( rule__BXtendDSL__MetamodelsAssignment_0 ) )
            // InternalBXtendDSLParser.g:661:2: ( rule__BXtendDSL__MetamodelsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getMetamodelsAssignment_0()); 
            }
            // InternalBXtendDSLParser.g:662:2: ( rule__BXtendDSL__MetamodelsAssignment_0 )
            // InternalBXtendDSLParser.g:662:3: rule__BXtendDSL__MetamodelsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__MetamodelsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getMetamodelsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__0__Impl"


    // $ANTLR start "rule__BXtendDSL__Group__1"
    // InternalBXtendDSLParser.g:670:1: rule__BXtendDSL__Group__1 : rule__BXtendDSL__Group__1__Impl rule__BXtendDSL__Group__2 ;
    public final void rule__BXtendDSL__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:674:1: ( rule__BXtendDSL__Group__1__Impl rule__BXtendDSL__Group__2 )
            // InternalBXtendDSLParser.g:675:2: rule__BXtendDSL__Group__1__Impl rule__BXtendDSL__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__BXtendDSL__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__1"


    // $ANTLR start "rule__BXtendDSL__Group__1__Impl"
    // InternalBXtendDSLParser.g:682:1: rule__BXtendDSL__Group__1__Impl : ( ( rule__BXtendDSL__ConfigAssignment_1 ) ) ;
    public final void rule__BXtendDSL__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:686:1: ( ( ( rule__BXtendDSL__ConfigAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:687:1: ( ( rule__BXtendDSL__ConfigAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:687:1: ( ( rule__BXtendDSL__ConfigAssignment_1 ) )
            // InternalBXtendDSLParser.g:688:2: ( rule__BXtendDSL__ConfigAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getConfigAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:689:2: ( rule__BXtendDSL__ConfigAssignment_1 )
            // InternalBXtendDSLParser.g:689:3: rule__BXtendDSL__ConfigAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__ConfigAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getConfigAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__1__Impl"


    // $ANTLR start "rule__BXtendDSL__Group__2"
    // InternalBXtendDSLParser.g:697:1: rule__BXtendDSL__Group__2 : rule__BXtendDSL__Group__2__Impl ;
    public final void rule__BXtendDSL__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:701:1: ( rule__BXtendDSL__Group__2__Impl )
            // InternalBXtendDSLParser.g:702:2: rule__BXtendDSL__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BXtendDSL__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__2"


    // $ANTLR start "rule__BXtendDSL__Group__2__Impl"
    // InternalBXtendDSLParser.g:708:1: rule__BXtendDSL__Group__2__Impl : ( ( rule__BXtendDSL__RulesAssignment_2 )* ) ;
    public final void rule__BXtendDSL__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:712:1: ( ( ( rule__BXtendDSL__RulesAssignment_2 )* ) )
            // InternalBXtendDSLParser.g:713:1: ( ( rule__BXtendDSL__RulesAssignment_2 )* )
            {
            // InternalBXtendDSLParser.g:713:1: ( ( rule__BXtendDSL__RulesAssignment_2 )* )
            // InternalBXtendDSLParser.g:714:2: ( rule__BXtendDSL__RulesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getRulesAssignment_2()); 
            }
            // InternalBXtendDSLParser.g:715:2: ( rule__BXtendDSL__RulesAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Rule) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:715:3: rule__BXtendDSL__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__BXtendDSL__RulesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getRulesAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__Group__2__Impl"


    // $ANTLR start "rule__Metamodels__Group__0"
    // InternalBXtendDSLParser.g:724:1: rule__Metamodels__Group__0 : rule__Metamodels__Group__0__Impl rule__Metamodels__Group__1 ;
    public final void rule__Metamodels__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:728:1: ( rule__Metamodels__Group__0__Impl rule__Metamodels__Group__1 )
            // InternalBXtendDSLParser.g:729:2: rule__Metamodels__Group__0__Impl rule__Metamodels__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Metamodels__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__0"


    // $ANTLR start "rule__Metamodels__Group__0__Impl"
    // InternalBXtendDSLParser.g:736:1: rule__Metamodels__Group__0__Impl : ( Sourcemodel ) ;
    public final void rule__Metamodels__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:740:1: ( ( Sourcemodel ) )
            // InternalBXtendDSLParser.g:741:1: ( Sourcemodel )
            {
            // InternalBXtendDSLParser.g:741:1: ( Sourcemodel )
            // InternalBXtendDSLParser.g:742:2: Sourcemodel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getSourcemodelKeyword_0()); 
            }
            match(input,Sourcemodel,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getSourcemodelKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__0__Impl"


    // $ANTLR start "rule__Metamodels__Group__1"
    // InternalBXtendDSLParser.g:751:1: rule__Metamodels__Group__1 : rule__Metamodels__Group__1__Impl rule__Metamodels__Group__2 ;
    public final void rule__Metamodels__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:755:1: ( rule__Metamodels__Group__1__Impl rule__Metamodels__Group__2 )
            // InternalBXtendDSLParser.g:756:2: rule__Metamodels__Group__1__Impl rule__Metamodels__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Metamodels__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__1"


    // $ANTLR start "rule__Metamodels__Group__1__Impl"
    // InternalBXtendDSLParser.g:763:1: rule__Metamodels__Group__1__Impl : ( ( rule__Metamodels__SourcemodelAssignment_1 ) ) ;
    public final void rule__Metamodels__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:767:1: ( ( ( rule__Metamodels__SourcemodelAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:768:1: ( ( rule__Metamodels__SourcemodelAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:768:1: ( ( rule__Metamodels__SourcemodelAssignment_1 ) )
            // InternalBXtendDSLParser.g:769:2: ( rule__Metamodels__SourcemodelAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getSourcemodelAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:770:2: ( rule__Metamodels__SourcemodelAssignment_1 )
            // InternalBXtendDSLParser.g:770:3: rule__Metamodels__SourcemodelAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__SourcemodelAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getSourcemodelAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__1__Impl"


    // $ANTLR start "rule__Metamodels__Group__2"
    // InternalBXtendDSLParser.g:778:1: rule__Metamodels__Group__2 : rule__Metamodels__Group__2__Impl rule__Metamodels__Group__3 ;
    public final void rule__Metamodels__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:782:1: ( rule__Metamodels__Group__2__Impl rule__Metamodels__Group__3 )
            // InternalBXtendDSLParser.g:783:2: rule__Metamodels__Group__2__Impl rule__Metamodels__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Metamodels__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__2"


    // $ANTLR start "rule__Metamodels__Group__2__Impl"
    // InternalBXtendDSLParser.g:790:1: rule__Metamodels__Group__2__Impl : ( ( rule__Metamodels__Group_2__0 )? ) ;
    public final void rule__Metamodels__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:794:1: ( ( ( rule__Metamodels__Group_2__0 )? ) )
            // InternalBXtendDSLParser.g:795:1: ( ( rule__Metamodels__Group_2__0 )? )
            {
            // InternalBXtendDSLParser.g:795:1: ( ( rule__Metamodels__Group_2__0 )? )
            // InternalBXtendDSLParser.g:796:2: ( rule__Metamodels__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getGroup_2()); 
            }
            // InternalBXtendDSLParser.g:797:2: ( rule__Metamodels__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBXtendDSLParser.g:797:3: rule__Metamodels__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodels__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__2__Impl"


    // $ANTLR start "rule__Metamodels__Group__3"
    // InternalBXtendDSLParser.g:805:1: rule__Metamodels__Group__3 : rule__Metamodels__Group__3__Impl rule__Metamodels__Group__4 ;
    public final void rule__Metamodels__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:809:1: ( rule__Metamodels__Group__3__Impl rule__Metamodels__Group__4 )
            // InternalBXtendDSLParser.g:810:2: rule__Metamodels__Group__3__Impl rule__Metamodels__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Metamodels__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__3"


    // $ANTLR start "rule__Metamodels__Group__3__Impl"
    // InternalBXtendDSLParser.g:817:1: rule__Metamodels__Group__3__Impl : ( Targetmodel ) ;
    public final void rule__Metamodels__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:821:1: ( ( Targetmodel ) )
            // InternalBXtendDSLParser.g:822:1: ( Targetmodel )
            {
            // InternalBXtendDSLParser.g:822:1: ( Targetmodel )
            // InternalBXtendDSLParser.g:823:2: Targetmodel
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTargetmodelKeyword_3()); 
            }
            match(input,Targetmodel,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTargetmodelKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__3__Impl"


    // $ANTLR start "rule__Metamodels__Group__4"
    // InternalBXtendDSLParser.g:832:1: rule__Metamodels__Group__4 : rule__Metamodels__Group__4__Impl rule__Metamodels__Group__5 ;
    public final void rule__Metamodels__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:836:1: ( rule__Metamodels__Group__4__Impl rule__Metamodels__Group__5 )
            // InternalBXtendDSLParser.g:837:2: rule__Metamodels__Group__4__Impl rule__Metamodels__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Metamodels__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__4"


    // $ANTLR start "rule__Metamodels__Group__4__Impl"
    // InternalBXtendDSLParser.g:844:1: rule__Metamodels__Group__4__Impl : ( ( rule__Metamodels__TargetmodelAssignment_4 ) ) ;
    public final void rule__Metamodels__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:848:1: ( ( ( rule__Metamodels__TargetmodelAssignment_4 ) ) )
            // InternalBXtendDSLParser.g:849:1: ( ( rule__Metamodels__TargetmodelAssignment_4 ) )
            {
            // InternalBXtendDSLParser.g:849:1: ( ( rule__Metamodels__TargetmodelAssignment_4 ) )
            // InternalBXtendDSLParser.g:850:2: ( rule__Metamodels__TargetmodelAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTargetmodelAssignment_4()); 
            }
            // InternalBXtendDSLParser.g:851:2: ( rule__Metamodels__TargetmodelAssignment_4 )
            // InternalBXtendDSLParser.g:851:3: rule__Metamodels__TargetmodelAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__TargetmodelAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTargetmodelAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__4__Impl"


    // $ANTLR start "rule__Metamodels__Group__5"
    // InternalBXtendDSLParser.g:859:1: rule__Metamodels__Group__5 : rule__Metamodels__Group__5__Impl ;
    public final void rule__Metamodels__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:863:1: ( rule__Metamodels__Group__5__Impl )
            // InternalBXtendDSLParser.g:864:2: rule__Metamodels__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__5"


    // $ANTLR start "rule__Metamodels__Group__5__Impl"
    // InternalBXtendDSLParser.g:870:1: rule__Metamodels__Group__5__Impl : ( ( rule__Metamodels__Group_5__0 )? ) ;
    public final void rule__Metamodels__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:874:1: ( ( ( rule__Metamodels__Group_5__0 )? ) )
            // InternalBXtendDSLParser.g:875:1: ( ( rule__Metamodels__Group_5__0 )? )
            {
            // InternalBXtendDSLParser.g:875:1: ( ( rule__Metamodels__Group_5__0 )? )
            // InternalBXtendDSLParser.g:876:2: ( rule__Metamodels__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getGroup_5()); 
            }
            // InternalBXtendDSLParser.g:877:2: ( rule__Metamodels__Group_5__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBXtendDSLParser.g:877:3: rule__Metamodels__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodels__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group__5__Impl"


    // $ANTLR start "rule__Metamodels__Group_2__0"
    // InternalBXtendDSLParser.g:886:1: rule__Metamodels__Group_2__0 : rule__Metamodels__Group_2__0__Impl rule__Metamodels__Group_2__1 ;
    public final void rule__Metamodels__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:890:1: ( rule__Metamodels__Group_2__0__Impl rule__Metamodels__Group_2__1 )
            // InternalBXtendDSLParser.g:891:2: rule__Metamodels__Group_2__0__Impl rule__Metamodels__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__Metamodels__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__0"


    // $ANTLR start "rule__Metamodels__Group_2__0__Impl"
    // InternalBXtendDSLParser.g:898:1: rule__Metamodels__Group_2__0__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__Metamodels__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:902:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:903:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:903:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:904:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2_0()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__0__Impl"


    // $ANTLR start "rule__Metamodels__Group_2__1"
    // InternalBXtendDSLParser.g:913:1: rule__Metamodels__Group_2__1 : rule__Metamodels__Group_2__1__Impl rule__Metamodels__Group_2__2 ;
    public final void rule__Metamodels__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:917:1: ( rule__Metamodels__Group_2__1__Impl rule__Metamodels__Group_2__2 )
            // InternalBXtendDSLParser.g:918:2: rule__Metamodels__Group_2__1__Impl rule__Metamodels__Group_2__2
            {
            pushFollow(FOLLOW_10);
            rule__Metamodels__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__1"


    // $ANTLR start "rule__Metamodels__Group_2__1__Impl"
    // InternalBXtendDSLParser.g:925:1: rule__Metamodels__Group_2__1__Impl : ( ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) ) ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* ) ) ;
    public final void rule__Metamodels__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:929:1: ( ( ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) ) ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* ) ) )
            // InternalBXtendDSLParser.g:930:1: ( ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) ) ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* ) )
            {
            // InternalBXtendDSLParser.g:930:1: ( ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) ) ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* ) )
            // InternalBXtendDSLParser.g:931:2: ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) ) ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* )
            {
            // InternalBXtendDSLParser.g:931:2: ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 ) )
            // InternalBXtendDSLParser.g:932:3: ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsAssignment_2_1()); 
            }
            // InternalBXtendDSLParser.g:933:3: ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )
            // InternalBXtendDSLParser.g:933:4: rule__Metamodels__CustomizedSrcElementsAssignment_2_1
            {
            pushFollow(FOLLOW_11);
            rule__Metamodels__CustomizedSrcElementsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsAssignment_2_1()); 
            }

            }

            // InternalBXtendDSLParser.g:936:2: ( ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )* )
            // InternalBXtendDSLParser.g:937:3: ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsAssignment_2_1()); 
            }
            // InternalBXtendDSLParser.g:938:3: ( rule__Metamodels__CustomizedSrcElementsAssignment_2_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=Get && LA11_0<=Set)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:938:4: rule__Metamodels__CustomizedSrcElementsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Metamodels__CustomizedSrcElementsAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsAssignment_2_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__1__Impl"


    // $ANTLR start "rule__Metamodels__Group_2__2"
    // InternalBXtendDSLParser.g:947:1: rule__Metamodels__Group_2__2 : rule__Metamodels__Group_2__2__Impl ;
    public final void rule__Metamodels__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:951:1: ( rule__Metamodels__Group_2__2__Impl )
            // InternalBXtendDSLParser.g:952:2: rule__Metamodels__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__2"


    // $ANTLR start "rule__Metamodels__Group_2__2__Impl"
    // InternalBXtendDSLParser.g:958:1: rule__Metamodels__Group_2__2__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__Metamodels__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:962:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:963:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:963:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:964:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_2_2()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_2__2__Impl"


    // $ANTLR start "rule__Metamodels__Group_5__0"
    // InternalBXtendDSLParser.g:974:1: rule__Metamodels__Group_5__0 : rule__Metamodels__Group_5__0__Impl rule__Metamodels__Group_5__1 ;
    public final void rule__Metamodels__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:978:1: ( rule__Metamodels__Group_5__0__Impl rule__Metamodels__Group_5__1 )
            // InternalBXtendDSLParser.g:979:2: rule__Metamodels__Group_5__0__Impl rule__Metamodels__Group_5__1
            {
            pushFollow(FOLLOW_9);
            rule__Metamodels__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__0"


    // $ANTLR start "rule__Metamodels__Group_5__0__Impl"
    // InternalBXtendDSLParser.g:986:1: rule__Metamodels__Group_5__0__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__Metamodels__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:990:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:991:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:991:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:992:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__0__Impl"


    // $ANTLR start "rule__Metamodels__Group_5__1"
    // InternalBXtendDSLParser.g:1001:1: rule__Metamodels__Group_5__1 : rule__Metamodels__Group_5__1__Impl rule__Metamodels__Group_5__2 ;
    public final void rule__Metamodels__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1005:1: ( rule__Metamodels__Group_5__1__Impl rule__Metamodels__Group_5__2 )
            // InternalBXtendDSLParser.g:1006:2: rule__Metamodels__Group_5__1__Impl rule__Metamodels__Group_5__2
            {
            pushFollow(FOLLOW_10);
            rule__Metamodels__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__1"


    // $ANTLR start "rule__Metamodels__Group_5__1__Impl"
    // InternalBXtendDSLParser.g:1013:1: rule__Metamodels__Group_5__1__Impl : ( ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) ) ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* ) ) ;
    public final void rule__Metamodels__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1017:1: ( ( ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) ) ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* ) ) )
            // InternalBXtendDSLParser.g:1018:1: ( ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) ) ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* ) )
            {
            // InternalBXtendDSLParser.g:1018:1: ( ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) ) ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* ) )
            // InternalBXtendDSLParser.g:1019:2: ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) ) ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* )
            {
            // InternalBXtendDSLParser.g:1019:2: ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 ) )
            // InternalBXtendDSLParser.g:1020:3: ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsAssignment_5_1()); 
            }
            // InternalBXtendDSLParser.g:1021:3: ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )
            // InternalBXtendDSLParser.g:1021:4: rule__Metamodels__CustomizedTrgElementsAssignment_5_1
            {
            pushFollow(FOLLOW_11);
            rule__Metamodels__CustomizedTrgElementsAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsAssignment_5_1()); 
            }

            }

            // InternalBXtendDSLParser.g:1024:2: ( ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )* )
            // InternalBXtendDSLParser.g:1025:3: ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsAssignment_5_1()); 
            }
            // InternalBXtendDSLParser.g:1026:3: ( rule__Metamodels__CustomizedTrgElementsAssignment_5_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=Get && LA12_0<=Set)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1026:4: rule__Metamodels__CustomizedTrgElementsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Metamodels__CustomizedTrgElementsAssignment_5_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsAssignment_5_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__1__Impl"


    // $ANTLR start "rule__Metamodels__Group_5__2"
    // InternalBXtendDSLParser.g:1035:1: rule__Metamodels__Group_5__2 : rule__Metamodels__Group_5__2__Impl ;
    public final void rule__Metamodels__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1039:1: ( rule__Metamodels__Group_5__2__Impl )
            // InternalBXtendDSLParser.g:1040:2: rule__Metamodels__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodels__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__2"


    // $ANTLR start "rule__Metamodels__Group_5__2__Impl"
    // InternalBXtendDSLParser.g:1046:1: rule__Metamodels__Group_5__2__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__Metamodels__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1050:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:1051:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:1051:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:1052:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__Group_5__2__Impl"


    // $ANTLR start "rule__CustomizedGetter__Group__0"
    // InternalBXtendDSLParser.g:1062:1: rule__CustomizedGetter__Group__0 : rule__CustomizedGetter__Group__0__Impl rule__CustomizedGetter__Group__1 ;
    public final void rule__CustomizedGetter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1066:1: ( rule__CustomizedGetter__Group__0__Impl rule__CustomizedGetter__Group__1 )
            // InternalBXtendDSLParser.g:1067:2: rule__CustomizedGetter__Group__0__Impl rule__CustomizedGetter__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__CustomizedGetter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__0"


    // $ANTLR start "rule__CustomizedGetter__Group__0__Impl"
    // InternalBXtendDSLParser.g:1074:1: rule__CustomizedGetter__Group__0__Impl : ( Get ) ;
    public final void rule__CustomizedGetter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1078:1: ( ( Get ) )
            // InternalBXtendDSLParser.g:1079:1: ( Get )
            {
            // InternalBXtendDSLParser.g:1079:1: ( Get )
            // InternalBXtendDSLParser.g:1080:2: Get
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getGetKeyword_0()); 
            }
            match(input,Get,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getGetKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__0__Impl"


    // $ANTLR start "rule__CustomizedGetter__Group__1"
    // InternalBXtendDSLParser.g:1089:1: rule__CustomizedGetter__Group__1 : rule__CustomizedGetter__Group__1__Impl rule__CustomizedGetter__Group__2 ;
    public final void rule__CustomizedGetter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1093:1: ( rule__CustomizedGetter__Group__1__Impl rule__CustomizedGetter__Group__2 )
            // InternalBXtendDSLParser.g:1094:2: rule__CustomizedGetter__Group__1__Impl rule__CustomizedGetter__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__CustomizedGetter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__1"


    // $ANTLR start "rule__CustomizedGetter__Group__1__Impl"
    // InternalBXtendDSLParser.g:1101:1: rule__CustomizedGetter__Group__1__Impl : ( ( rule__CustomizedGetter__ElementAssignment_1 ) ) ;
    public final void rule__CustomizedGetter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1105:1: ( ( ( rule__CustomizedGetter__ElementAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:1106:1: ( ( rule__CustomizedGetter__ElementAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:1106:1: ( ( rule__CustomizedGetter__ElementAssignment_1 ) )
            // InternalBXtendDSLParser.g:1107:2: ( rule__CustomizedGetter__ElementAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getElementAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:1108:2: ( rule__CustomizedGetter__ElementAssignment_1 )
            // InternalBXtendDSLParser.g:1108:3: rule__CustomizedGetter__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__ElementAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getElementAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__1__Impl"


    // $ANTLR start "rule__CustomizedGetter__Group__2"
    // InternalBXtendDSLParser.g:1116:1: rule__CustomizedGetter__Group__2 : rule__CustomizedGetter__Group__2__Impl rule__CustomizedGetter__Group__3 ;
    public final void rule__CustomizedGetter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1120:1: ( rule__CustomizedGetter__Group__2__Impl rule__CustomizedGetter__Group__3 )
            // InternalBXtendDSLParser.g:1121:2: rule__CustomizedGetter__Group__2__Impl rule__CustomizedGetter__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__CustomizedGetter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__2"


    // $ANTLR start "rule__CustomizedGetter__Group__2__Impl"
    // InternalBXtendDSLParser.g:1128:1: rule__CustomizedGetter__Group__2__Impl : ( As ) ;
    public final void rule__CustomizedGetter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1132:1: ( ( As ) )
            // InternalBXtendDSLParser.g:1133:1: ( As )
            {
            // InternalBXtendDSLParser.g:1133:1: ( As )
            // InternalBXtendDSLParser.g:1134:2: As
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getAsKeyword_2()); 
            }
            match(input,As,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getAsKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__2__Impl"


    // $ANTLR start "rule__CustomizedGetter__Group__3"
    // InternalBXtendDSLParser.g:1143:1: rule__CustomizedGetter__Group__3 : rule__CustomizedGetter__Group__3__Impl ;
    public final void rule__CustomizedGetter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1147:1: ( rule__CustomizedGetter__Group__3__Impl )
            // InternalBXtendDSLParser.g:1148:2: rule__CustomizedGetter__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__3"


    // $ANTLR start "rule__CustomizedGetter__Group__3__Impl"
    // InternalBXtendDSLParser.g:1154:1: rule__CustomizedGetter__Group__3__Impl : ( ( rule__CustomizedGetter__CustomIdAssignment_3 ) ) ;
    public final void rule__CustomizedGetter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1158:1: ( ( ( rule__CustomizedGetter__CustomIdAssignment_3 ) ) )
            // InternalBXtendDSLParser.g:1159:1: ( ( rule__CustomizedGetter__CustomIdAssignment_3 ) )
            {
            // InternalBXtendDSLParser.g:1159:1: ( ( rule__CustomizedGetter__CustomIdAssignment_3 ) )
            // InternalBXtendDSLParser.g:1160:2: ( rule__CustomizedGetter__CustomIdAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getCustomIdAssignment_3()); 
            }
            // InternalBXtendDSLParser.g:1161:2: ( rule__CustomizedGetter__CustomIdAssignment_3 )
            // InternalBXtendDSLParser.g:1161:3: rule__CustomizedGetter__CustomIdAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedGetter__CustomIdAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getCustomIdAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__Group__3__Impl"


    // $ANTLR start "rule__CustomizedSetter__Group__0"
    // InternalBXtendDSLParser.g:1170:1: rule__CustomizedSetter__Group__0 : rule__CustomizedSetter__Group__0__Impl rule__CustomizedSetter__Group__1 ;
    public final void rule__CustomizedSetter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1174:1: ( rule__CustomizedSetter__Group__0__Impl rule__CustomizedSetter__Group__1 )
            // InternalBXtendDSLParser.g:1175:2: rule__CustomizedSetter__Group__0__Impl rule__CustomizedSetter__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__CustomizedSetter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__0"


    // $ANTLR start "rule__CustomizedSetter__Group__0__Impl"
    // InternalBXtendDSLParser.g:1182:1: rule__CustomizedSetter__Group__0__Impl : ( Set ) ;
    public final void rule__CustomizedSetter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1186:1: ( ( Set ) )
            // InternalBXtendDSLParser.g:1187:1: ( Set )
            {
            // InternalBXtendDSLParser.g:1187:1: ( Set )
            // InternalBXtendDSLParser.g:1188:2: Set
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getSetKeyword_0()); 
            }
            match(input,Set,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getSetKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__0__Impl"


    // $ANTLR start "rule__CustomizedSetter__Group__1"
    // InternalBXtendDSLParser.g:1197:1: rule__CustomizedSetter__Group__1 : rule__CustomizedSetter__Group__1__Impl rule__CustomizedSetter__Group__2 ;
    public final void rule__CustomizedSetter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1201:1: ( rule__CustomizedSetter__Group__1__Impl rule__CustomizedSetter__Group__2 )
            // InternalBXtendDSLParser.g:1202:2: rule__CustomizedSetter__Group__1__Impl rule__CustomizedSetter__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__CustomizedSetter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__1"


    // $ANTLR start "rule__CustomizedSetter__Group__1__Impl"
    // InternalBXtendDSLParser.g:1209:1: rule__CustomizedSetter__Group__1__Impl : ( ( rule__CustomizedSetter__ElementAssignment_1 ) ) ;
    public final void rule__CustomizedSetter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1213:1: ( ( ( rule__CustomizedSetter__ElementAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:1214:1: ( ( rule__CustomizedSetter__ElementAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:1214:1: ( ( rule__CustomizedSetter__ElementAssignment_1 ) )
            // InternalBXtendDSLParser.g:1215:2: ( rule__CustomizedSetter__ElementAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getElementAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:1216:2: ( rule__CustomizedSetter__ElementAssignment_1 )
            // InternalBXtendDSLParser.g:1216:3: rule__CustomizedSetter__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__ElementAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getElementAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__1__Impl"


    // $ANTLR start "rule__CustomizedSetter__Group__2"
    // InternalBXtendDSLParser.g:1224:1: rule__CustomizedSetter__Group__2 : rule__CustomizedSetter__Group__2__Impl rule__CustomizedSetter__Group__3 ;
    public final void rule__CustomizedSetter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1228:1: ( rule__CustomizedSetter__Group__2__Impl rule__CustomizedSetter__Group__3 )
            // InternalBXtendDSLParser.g:1229:2: rule__CustomizedSetter__Group__2__Impl rule__CustomizedSetter__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__CustomizedSetter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__2"


    // $ANTLR start "rule__CustomizedSetter__Group__2__Impl"
    // InternalBXtendDSLParser.g:1236:1: rule__CustomizedSetter__Group__2__Impl : ( As ) ;
    public final void rule__CustomizedSetter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1240:1: ( ( As ) )
            // InternalBXtendDSLParser.g:1241:1: ( As )
            {
            // InternalBXtendDSLParser.g:1241:1: ( As )
            // InternalBXtendDSLParser.g:1242:2: As
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getAsKeyword_2()); 
            }
            match(input,As,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getAsKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__2__Impl"


    // $ANTLR start "rule__CustomizedSetter__Group__3"
    // InternalBXtendDSLParser.g:1251:1: rule__CustomizedSetter__Group__3 : rule__CustomizedSetter__Group__3__Impl ;
    public final void rule__CustomizedSetter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1255:1: ( rule__CustomizedSetter__Group__3__Impl )
            // InternalBXtendDSLParser.g:1256:2: rule__CustomizedSetter__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__3"


    // $ANTLR start "rule__CustomizedSetter__Group__3__Impl"
    // InternalBXtendDSLParser.g:1262:1: rule__CustomizedSetter__Group__3__Impl : ( ( rule__CustomizedSetter__CustomIdAssignment_3 ) ) ;
    public final void rule__CustomizedSetter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1266:1: ( ( ( rule__CustomizedSetter__CustomIdAssignment_3 ) ) )
            // InternalBXtendDSLParser.g:1267:1: ( ( rule__CustomizedSetter__CustomIdAssignment_3 ) )
            {
            // InternalBXtendDSLParser.g:1267:1: ( ( rule__CustomizedSetter__CustomIdAssignment_3 ) )
            // InternalBXtendDSLParser.g:1268:2: ( rule__CustomizedSetter__CustomIdAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getCustomIdAssignment_3()); 
            }
            // InternalBXtendDSLParser.g:1269:2: ( rule__CustomizedSetter__CustomIdAssignment_3 )
            // InternalBXtendDSLParser.g:1269:3: rule__CustomizedSetter__CustomIdAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CustomizedSetter__CustomIdAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getCustomIdAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__Group__3__Impl"


    // $ANTLR start "rule__Config__Group__0"
    // InternalBXtendDSLParser.g:1278:1: rule__Config__Group__0 : rule__Config__Group__0__Impl rule__Config__Group__1 ;
    public final void rule__Config__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1282:1: ( rule__Config__Group__0__Impl rule__Config__Group__1 )
            // InternalBXtendDSLParser.g:1283:2: rule__Config__Group__0__Impl rule__Config__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Config__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Config__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group__0"


    // $ANTLR start "rule__Config__Group__0__Impl"
    // InternalBXtendDSLParser.g:1290:1: rule__Config__Group__0__Impl : ( () ) ;
    public final void rule__Config__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1294:1: ( ( () ) )
            // InternalBXtendDSLParser.g:1295:1: ( () )
            {
            // InternalBXtendDSLParser.g:1295:1: ( () )
            // InternalBXtendDSLParser.g:1296:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getConfigAction_0()); 
            }
            // InternalBXtendDSLParser.g:1297:2: ()
            // InternalBXtendDSLParser.g:1297:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getConfigAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group__0__Impl"


    // $ANTLR start "rule__Config__Group__1"
    // InternalBXtendDSLParser.g:1305:1: rule__Config__Group__1 : rule__Config__Group__1__Impl ;
    public final void rule__Config__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1309:1: ( rule__Config__Group__1__Impl )
            // InternalBXtendDSLParser.g:1310:2: rule__Config__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Config__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group__1"


    // $ANTLR start "rule__Config__Group__1__Impl"
    // InternalBXtendDSLParser.g:1316:1: rule__Config__Group__1__Impl : ( ( rule__Config__Group_1__0 )? ) ;
    public final void rule__Config__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1320:1: ( ( ( rule__Config__Group_1__0 )? ) )
            // InternalBXtendDSLParser.g:1321:1: ( ( rule__Config__Group_1__0 )? )
            {
            // InternalBXtendDSLParser.g:1321:1: ( ( rule__Config__Group_1__0 )? )
            // InternalBXtendDSLParser.g:1322:2: ( rule__Config__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getGroup_1()); 
            }
            // InternalBXtendDSLParser.g:1323:2: ( rule__Config__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Options) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBXtendDSLParser.g:1323:3: rule__Config__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Config__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group__1__Impl"


    // $ANTLR start "rule__Config__Group_1__0"
    // InternalBXtendDSLParser.g:1332:1: rule__Config__Group_1__0 : rule__Config__Group_1__0__Impl rule__Config__Group_1__1 ;
    public final void rule__Config__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1336:1: ( rule__Config__Group_1__0__Impl rule__Config__Group_1__1 )
            // InternalBXtendDSLParser.g:1337:2: rule__Config__Group_1__0__Impl rule__Config__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Config__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Config__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__0"


    // $ANTLR start "rule__Config__Group_1__0__Impl"
    // InternalBXtendDSLParser.g:1344:1: rule__Config__Group_1__0__Impl : ( Options ) ;
    public final void rule__Config__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1348:1: ( ( Options ) )
            // InternalBXtendDSLParser.g:1349:1: ( Options )
            {
            // InternalBXtendDSLParser.g:1349:1: ( Options )
            // InternalBXtendDSLParser.g:1350:2: Options
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getOptionsKeyword_1_0()); 
            }
            match(input,Options,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getOptionsKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__0__Impl"


    // $ANTLR start "rule__Config__Group_1__1"
    // InternalBXtendDSLParser.g:1359:1: rule__Config__Group_1__1 : rule__Config__Group_1__1__Impl rule__Config__Group_1__2 ;
    public final void rule__Config__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1363:1: ( rule__Config__Group_1__1__Impl rule__Config__Group_1__2 )
            // InternalBXtendDSLParser.g:1364:2: rule__Config__Group_1__1__Impl rule__Config__Group_1__2
            {
            pushFollow(FOLLOW_12);
            rule__Config__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Config__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__1"


    // $ANTLR start "rule__Config__Group_1__1__Impl"
    // InternalBXtendDSLParser.g:1371:1: rule__Config__Group_1__1__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__Config__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1375:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:1376:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:1376:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:1377:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_1_1()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__1__Impl"


    // $ANTLR start "rule__Config__Group_1__2"
    // InternalBXtendDSLParser.g:1386:1: rule__Config__Group_1__2 : rule__Config__Group_1__2__Impl rule__Config__Group_1__3 ;
    public final void rule__Config__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1390:1: ( rule__Config__Group_1__2__Impl rule__Config__Group_1__3 )
            // InternalBXtendDSLParser.g:1391:2: rule__Config__Group_1__2__Impl rule__Config__Group_1__3
            {
            pushFollow(FOLLOW_10);
            rule__Config__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Config__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__2"


    // $ANTLR start "rule__Config__Group_1__2__Impl"
    // InternalBXtendDSLParser.g:1398:1: rule__Config__Group_1__2__Impl : ( ( ( rule__Config__OptionsAssignment_1_2 ) ) ( ( rule__Config__OptionsAssignment_1_2 )* ) ) ;
    public final void rule__Config__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1402:1: ( ( ( ( rule__Config__OptionsAssignment_1_2 ) ) ( ( rule__Config__OptionsAssignment_1_2 )* ) ) )
            // InternalBXtendDSLParser.g:1403:1: ( ( ( rule__Config__OptionsAssignment_1_2 ) ) ( ( rule__Config__OptionsAssignment_1_2 )* ) )
            {
            // InternalBXtendDSLParser.g:1403:1: ( ( ( rule__Config__OptionsAssignment_1_2 ) ) ( ( rule__Config__OptionsAssignment_1_2 )* ) )
            // InternalBXtendDSLParser.g:1404:2: ( ( rule__Config__OptionsAssignment_1_2 ) ) ( ( rule__Config__OptionsAssignment_1_2 )* )
            {
            // InternalBXtendDSLParser.g:1404:2: ( ( rule__Config__OptionsAssignment_1_2 ) )
            // InternalBXtendDSLParser.g:1405:3: ( rule__Config__OptionsAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getOptionsAssignment_1_2()); 
            }
            // InternalBXtendDSLParser.g:1406:3: ( rule__Config__OptionsAssignment_1_2 )
            // InternalBXtendDSLParser.g:1406:4: rule__Config__OptionsAssignment_1_2
            {
            pushFollow(FOLLOW_14);
            rule__Config__OptionsAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getOptionsAssignment_1_2()); 
            }

            }

            // InternalBXtendDSLParser.g:1409:2: ( ( rule__Config__OptionsAssignment_1_2 )* )
            // InternalBXtendDSLParser.g:1410:3: ( rule__Config__OptionsAssignment_1_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getOptionsAssignment_1_2()); 
            }
            // InternalBXtendDSLParser.g:1411:3: ( rule__Config__OptionsAssignment_1_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1411:4: rule__Config__OptionsAssignment_1_2
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Config__OptionsAssignment_1_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getOptionsAssignment_1_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__2__Impl"


    // $ANTLR start "rule__Config__Group_1__3"
    // InternalBXtendDSLParser.g:1420:1: rule__Config__Group_1__3 : rule__Config__Group_1__3__Impl ;
    public final void rule__Config__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1424:1: ( rule__Config__Group_1__3__Impl )
            // InternalBXtendDSLParser.g:1425:2: rule__Config__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Config__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__3"


    // $ANTLR start "rule__Config__Group_1__3__Impl"
    // InternalBXtendDSLParser.g:1431:1: rule__Config__Group_1__3__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__Config__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1435:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:1436:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:1436:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:1437:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_1_3()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__3__Impl"


    // $ANTLR start "rule__TransformationRule__Group__0"
    // InternalBXtendDSLParser.g:1447:1: rule__TransformationRule__Group__0 : rule__TransformationRule__Group__0__Impl rule__TransformationRule__Group__1 ;
    public final void rule__TransformationRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1451:1: ( rule__TransformationRule__Group__0__Impl rule__TransformationRule__Group__1 )
            // InternalBXtendDSLParser.g:1452:2: rule__TransformationRule__Group__0__Impl rule__TransformationRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__TransformationRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__0"


    // $ANTLR start "rule__TransformationRule__Group__0__Impl"
    // InternalBXtendDSLParser.g:1459:1: rule__TransformationRule__Group__0__Impl : ( Rule ) ;
    public final void rule__TransformationRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1463:1: ( ( Rule ) )
            // InternalBXtendDSLParser.g:1464:1: ( Rule )
            {
            // InternalBXtendDSLParser.g:1464:1: ( Rule )
            // InternalBXtendDSLParser.g:1465:2: Rule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getRuleKeyword_0()); 
            }
            match(input,Rule,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getRuleKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__0__Impl"


    // $ANTLR start "rule__TransformationRule__Group__1"
    // InternalBXtendDSLParser.g:1474:1: rule__TransformationRule__Group__1 : rule__TransformationRule__Group__1__Impl rule__TransformationRule__Group__2 ;
    public final void rule__TransformationRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1478:1: ( rule__TransformationRule__Group__1__Impl rule__TransformationRule__Group__2 )
            // InternalBXtendDSLParser.g:1479:2: rule__TransformationRule__Group__1__Impl rule__TransformationRule__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TransformationRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__1"


    // $ANTLR start "rule__TransformationRule__Group__1__Impl"
    // InternalBXtendDSLParser.g:1486:1: rule__TransformationRule__Group__1__Impl : ( ( rule__TransformationRule__NameAssignment_1 ) ) ;
    public final void rule__TransformationRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1490:1: ( ( ( rule__TransformationRule__NameAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:1491:1: ( ( rule__TransformationRule__NameAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:1491:1: ( ( rule__TransformationRule__NameAssignment_1 ) )
            // InternalBXtendDSLParser.g:1492:2: ( rule__TransformationRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getNameAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:1493:2: ( rule__TransformationRule__NameAssignment_1 )
            // InternalBXtendDSLParser.g:1493:3: rule__TransformationRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__1__Impl"


    // $ANTLR start "rule__TransformationRule__Group__2"
    // InternalBXtendDSLParser.g:1501:1: rule__TransformationRule__Group__2 : rule__TransformationRule__Group__2__Impl rule__TransformationRule__Group__3 ;
    public final void rule__TransformationRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1505:1: ( rule__TransformationRule__Group__2__Impl rule__TransformationRule__Group__3 )
            // InternalBXtendDSLParser.g:1506:2: rule__TransformationRule__Group__2__Impl rule__TransformationRule__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__TransformationRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__2"


    // $ANTLR start "rule__TransformationRule__Group__2__Impl"
    // InternalBXtendDSLParser.g:1513:1: rule__TransformationRule__Group__2__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__TransformationRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1517:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:1518:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:1518:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:1519:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__2__Impl"


    // $ANTLR start "rule__TransformationRule__Group__3"
    // InternalBXtendDSLParser.g:1528:1: rule__TransformationRule__Group__3 : rule__TransformationRule__Group__3__Impl rule__TransformationRule__Group__4 ;
    public final void rule__TransformationRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1532:1: ( rule__TransformationRule__Group__3__Impl rule__TransformationRule__Group__4 )
            // InternalBXtendDSLParser.g:1533:2: rule__TransformationRule__Group__3__Impl rule__TransformationRule__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__TransformationRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__3"


    // $ANTLR start "rule__TransformationRule__Group__3__Impl"
    // InternalBXtendDSLParser.g:1540:1: rule__TransformationRule__Group__3__Impl : ( Src ) ;
    public final void rule__TransformationRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1544:1: ( ( Src ) )
            // InternalBXtendDSLParser.g:1545:1: ( Src )
            {
            // InternalBXtendDSLParser.g:1545:1: ( Src )
            // InternalBXtendDSLParser.g:1546:2: Src
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcKeyword_3()); 
            }
            match(input,Src,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__3__Impl"


    // $ANTLR start "rule__TransformationRule__Group__4"
    // InternalBXtendDSLParser.g:1555:1: rule__TransformationRule__Group__4 : rule__TransformationRule__Group__4__Impl rule__TransformationRule__Group__5 ;
    public final void rule__TransformationRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1559:1: ( rule__TransformationRule__Group__4__Impl rule__TransformationRule__Group__5 )
            // InternalBXtendDSLParser.g:1560:2: rule__TransformationRule__Group__4__Impl rule__TransformationRule__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__TransformationRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__4"


    // $ANTLR start "rule__TransformationRule__Group__4__Impl"
    // InternalBXtendDSLParser.g:1567:1: rule__TransformationRule__Group__4__Impl : ( ( rule__TransformationRule__SrcMatcherAssignment_4 ) ) ;
    public final void rule__TransformationRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1571:1: ( ( ( rule__TransformationRule__SrcMatcherAssignment_4 ) ) )
            // InternalBXtendDSLParser.g:1572:1: ( ( rule__TransformationRule__SrcMatcherAssignment_4 ) )
            {
            // InternalBXtendDSLParser.g:1572:1: ( ( rule__TransformationRule__SrcMatcherAssignment_4 ) )
            // InternalBXtendDSLParser.g:1573:2: ( rule__TransformationRule__SrcMatcherAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_4()); 
            }
            // InternalBXtendDSLParser.g:1574:2: ( rule__TransformationRule__SrcMatcherAssignment_4 )
            // InternalBXtendDSLParser.g:1574:3: rule__TransformationRule__SrcMatcherAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__SrcMatcherAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__4__Impl"


    // $ANTLR start "rule__TransformationRule__Group__5"
    // InternalBXtendDSLParser.g:1582:1: rule__TransformationRule__Group__5 : rule__TransformationRule__Group__5__Impl rule__TransformationRule__Group__6 ;
    public final void rule__TransformationRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1586:1: ( rule__TransformationRule__Group__5__Impl rule__TransformationRule__Group__6 )
            // InternalBXtendDSLParser.g:1587:2: rule__TransformationRule__Group__5__Impl rule__TransformationRule__Group__6
            {
            pushFollow(FOLLOW_16);
            rule__TransformationRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__5"


    // $ANTLR start "rule__TransformationRule__Group__5__Impl"
    // InternalBXtendDSLParser.g:1594:1: rule__TransformationRule__Group__5__Impl : ( ( rule__TransformationRule__Group_5__0 )? ) ;
    public final void rule__TransformationRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1598:1: ( ( ( rule__TransformationRule__Group_5__0 )? ) )
            // InternalBXtendDSLParser.g:1599:1: ( ( rule__TransformationRule__Group_5__0 )? )
            {
            // InternalBXtendDSLParser.g:1599:1: ( ( rule__TransformationRule__Group_5__0 )? )
            // InternalBXtendDSLParser.g:1600:2: ( rule__TransformationRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getGroup_5()); 
            }
            // InternalBXtendDSLParser.g:1601:2: ( rule__TransformationRule__Group_5__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBXtendDSLParser.g:1601:3: rule__TransformationRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TransformationRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__5__Impl"


    // $ANTLR start "rule__TransformationRule__Group__6"
    // InternalBXtendDSLParser.g:1609:1: rule__TransformationRule__Group__6 : rule__TransformationRule__Group__6__Impl rule__TransformationRule__Group__7 ;
    public final void rule__TransformationRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1613:1: ( rule__TransformationRule__Group__6__Impl rule__TransformationRule__Group__7 )
            // InternalBXtendDSLParser.g:1614:2: rule__TransformationRule__Group__6__Impl rule__TransformationRule__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__TransformationRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__6"


    // $ANTLR start "rule__TransformationRule__Group__6__Impl"
    // InternalBXtendDSLParser.g:1621:1: rule__TransformationRule__Group__6__Impl : ( Trg ) ;
    public final void rule__TransformationRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1625:1: ( ( Trg ) )
            // InternalBXtendDSLParser.g:1626:1: ( Trg )
            {
            // InternalBXtendDSLParser.g:1626:1: ( Trg )
            // InternalBXtendDSLParser.g:1627:2: Trg
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgKeyword_6()); 
            }
            match(input,Trg,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__6__Impl"


    // $ANTLR start "rule__TransformationRule__Group__7"
    // InternalBXtendDSLParser.g:1636:1: rule__TransformationRule__Group__7 : rule__TransformationRule__Group__7__Impl rule__TransformationRule__Group__8 ;
    public final void rule__TransformationRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1640:1: ( rule__TransformationRule__Group__7__Impl rule__TransformationRule__Group__8 )
            // InternalBXtendDSLParser.g:1641:2: rule__TransformationRule__Group__7__Impl rule__TransformationRule__Group__8
            {
            pushFollow(FOLLOW_17);
            rule__TransformationRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__7"


    // $ANTLR start "rule__TransformationRule__Group__7__Impl"
    // InternalBXtendDSLParser.g:1648:1: rule__TransformationRule__Group__7__Impl : ( ( rule__TransformationRule__TrgMatcherAssignment_7 ) ) ;
    public final void rule__TransformationRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1652:1: ( ( ( rule__TransformationRule__TrgMatcherAssignment_7 ) ) )
            // InternalBXtendDSLParser.g:1653:1: ( ( rule__TransformationRule__TrgMatcherAssignment_7 ) )
            {
            // InternalBXtendDSLParser.g:1653:1: ( ( rule__TransformationRule__TrgMatcherAssignment_7 ) )
            // InternalBXtendDSLParser.g:1654:2: ( rule__TransformationRule__TrgMatcherAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_7()); 
            }
            // InternalBXtendDSLParser.g:1655:2: ( rule__TransformationRule__TrgMatcherAssignment_7 )
            // InternalBXtendDSLParser.g:1655:3: rule__TransformationRule__TrgMatcherAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__TrgMatcherAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__7__Impl"


    // $ANTLR start "rule__TransformationRule__Group__8"
    // InternalBXtendDSLParser.g:1663:1: rule__TransformationRule__Group__8 : rule__TransformationRule__Group__8__Impl rule__TransformationRule__Group__9 ;
    public final void rule__TransformationRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1667:1: ( rule__TransformationRule__Group__8__Impl rule__TransformationRule__Group__9 )
            // InternalBXtendDSLParser.g:1668:2: rule__TransformationRule__Group__8__Impl rule__TransformationRule__Group__9
            {
            pushFollow(FOLLOW_17);
            rule__TransformationRule__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__8"


    // $ANTLR start "rule__TransformationRule__Group__8__Impl"
    // InternalBXtendDSLParser.g:1675:1: rule__TransformationRule__Group__8__Impl : ( ( rule__TransformationRule__Group_8__0 )? ) ;
    public final void rule__TransformationRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1679:1: ( ( ( rule__TransformationRule__Group_8__0 )? ) )
            // InternalBXtendDSLParser.g:1680:1: ( ( rule__TransformationRule__Group_8__0 )? )
            {
            // InternalBXtendDSLParser.g:1680:1: ( ( rule__TransformationRule__Group_8__0 )? )
            // InternalBXtendDSLParser.g:1681:2: ( rule__TransformationRule__Group_8__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getGroup_8()); 
            }
            // InternalBXtendDSLParser.g:1682:2: ( rule__TransformationRule__Group_8__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_TAB_INDENTED_BLOCK_BEGIN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBXtendDSLParser.g:1682:3: rule__TransformationRule__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TransformationRule__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getGroup_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__8__Impl"


    // $ANTLR start "rule__TransformationRule__Group__9"
    // InternalBXtendDSLParser.g:1690:1: rule__TransformationRule__Group__9 : rule__TransformationRule__Group__9__Impl rule__TransformationRule__Group__10 ;
    public final void rule__TransformationRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1694:1: ( rule__TransformationRule__Group__9__Impl rule__TransformationRule__Group__10 )
            // InternalBXtendDSLParser.g:1695:2: rule__TransformationRule__Group__9__Impl rule__TransformationRule__Group__10
            {
            pushFollow(FOLLOW_17);
            rule__TransformationRule__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__9"


    // $ANTLR start "rule__TransformationRule__Group__9__Impl"
    // InternalBXtendDSLParser.g:1702:1: rule__TransformationRule__Group__9__Impl : ( ( rule__TransformationRule__MappingsAssignment_9 )* ) ;
    public final void rule__TransformationRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1706:1: ( ( ( rule__TransformationRule__MappingsAssignment_9 )* ) )
            // InternalBXtendDSLParser.g:1707:1: ( ( rule__TransformationRule__MappingsAssignment_9 )* )
            {
            // InternalBXtendDSLParser.g:1707:1: ( ( rule__TransformationRule__MappingsAssignment_9 )* )
            // InternalBXtendDSLParser.g:1708:2: ( rule__TransformationRule__MappingsAssignment_9 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getMappingsAssignment_9()); 
            }
            // InternalBXtendDSLParser.g:1709:2: ( rule__TransformationRule__MappingsAssignment_9 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==LeftCurlyBracket||LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1709:3: rule__TransformationRule__MappingsAssignment_9
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__TransformationRule__MappingsAssignment_9();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getMappingsAssignment_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__9__Impl"


    // $ANTLR start "rule__TransformationRule__Group__10"
    // InternalBXtendDSLParser.g:1717:1: rule__TransformationRule__Group__10 : rule__TransformationRule__Group__10__Impl ;
    public final void rule__TransformationRule__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1721:1: ( rule__TransformationRule__Group__10__Impl )
            // InternalBXtendDSLParser.g:1722:2: rule__TransformationRule__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__10"


    // $ANTLR start "rule__TransformationRule__Group__10__Impl"
    // InternalBXtendDSLParser.g:1728:1: rule__TransformationRule__Group__10__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__TransformationRule__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1732:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:1733:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:1733:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:1734:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_10()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_10()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group__10__Impl"


    // $ANTLR start "rule__TransformationRule__Group_5__0"
    // InternalBXtendDSLParser.g:1744:1: rule__TransformationRule__Group_5__0 : rule__TransformationRule__Group_5__0__Impl rule__TransformationRule__Group_5__1 ;
    public final void rule__TransformationRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1748:1: ( rule__TransformationRule__Group_5__0__Impl rule__TransformationRule__Group_5__1 )
            // InternalBXtendDSLParser.g:1749:2: rule__TransformationRule__Group_5__0__Impl rule__TransformationRule__Group_5__1
            {
            pushFollow(FOLLOW_12);
            rule__TransformationRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__0"


    // $ANTLR start "rule__TransformationRule__Group_5__0__Impl"
    // InternalBXtendDSLParser.g:1756:1: rule__TransformationRule__Group_5__0__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__TransformationRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1760:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:1761:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:1761:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:1762:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__0__Impl"


    // $ANTLR start "rule__TransformationRule__Group_5__1"
    // InternalBXtendDSLParser.g:1771:1: rule__TransformationRule__Group_5__1 : rule__TransformationRule__Group_5__1__Impl rule__TransformationRule__Group_5__2 ;
    public final void rule__TransformationRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1775:1: ( rule__TransformationRule__Group_5__1__Impl rule__TransformationRule__Group_5__2 )
            // InternalBXtendDSLParser.g:1776:2: rule__TransformationRule__Group_5__1__Impl rule__TransformationRule__Group_5__2
            {
            pushFollow(FOLLOW_10);
            rule__TransformationRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__1"


    // $ANTLR start "rule__TransformationRule__Group_5__1__Impl"
    // InternalBXtendDSLParser.g:1783:1: rule__TransformationRule__Group_5__1__Impl : ( ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) ) ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* ) ) ;
    public final void rule__TransformationRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1787:1: ( ( ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) ) ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* ) ) )
            // InternalBXtendDSLParser.g:1788:1: ( ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) ) ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* ) )
            {
            // InternalBXtendDSLParser.g:1788:1: ( ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) ) ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* ) )
            // InternalBXtendDSLParser.g:1789:2: ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) ) ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* )
            {
            // InternalBXtendDSLParser.g:1789:2: ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 ) )
            // InternalBXtendDSLParser.g:1790:3: ( rule__TransformationRule__SrcMatcherAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_5_1()); 
            }
            // InternalBXtendDSLParser.g:1791:3: ( rule__TransformationRule__SrcMatcherAssignment_5_1 )
            // InternalBXtendDSLParser.g:1791:4: rule__TransformationRule__SrcMatcherAssignment_5_1
            {
            pushFollow(FOLLOW_14);
            rule__TransformationRule__SrcMatcherAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_5_1()); 
            }

            }

            // InternalBXtendDSLParser.g:1794:2: ( ( rule__TransformationRule__SrcMatcherAssignment_5_1 )* )
            // InternalBXtendDSLParser.g:1795:3: ( rule__TransformationRule__SrcMatcherAssignment_5_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_5_1()); 
            }
            // InternalBXtendDSLParser.g:1796:3: ( rule__TransformationRule__SrcMatcherAssignment_5_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1796:4: rule__TransformationRule__SrcMatcherAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__TransformationRule__SrcMatcherAssignment_5_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcMatcherAssignment_5_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__1__Impl"


    // $ANTLR start "rule__TransformationRule__Group_5__2"
    // InternalBXtendDSLParser.g:1805:1: rule__TransformationRule__Group_5__2 : rule__TransformationRule__Group_5__2__Impl ;
    public final void rule__TransformationRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1809:1: ( rule__TransformationRule__Group_5__2__Impl )
            // InternalBXtendDSLParser.g:1810:2: rule__TransformationRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__2"


    // $ANTLR start "rule__TransformationRule__Group_5__2__Impl"
    // InternalBXtendDSLParser.g:1816:1: rule__TransformationRule__Group_5__2__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__TransformationRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1820:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:1821:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:1821:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:1822:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_5__2__Impl"


    // $ANTLR start "rule__TransformationRule__Group_8__0"
    // InternalBXtendDSLParser.g:1832:1: rule__TransformationRule__Group_8__0 : rule__TransformationRule__Group_8__0__Impl rule__TransformationRule__Group_8__1 ;
    public final void rule__TransformationRule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1836:1: ( rule__TransformationRule__Group_8__0__Impl rule__TransformationRule__Group_8__1 )
            // InternalBXtendDSLParser.g:1837:2: rule__TransformationRule__Group_8__0__Impl rule__TransformationRule__Group_8__1
            {
            pushFollow(FOLLOW_12);
            rule__TransformationRule__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__0"


    // $ANTLR start "rule__TransformationRule__Group_8__0__Impl"
    // InternalBXtendDSLParser.g:1844:1: rule__TransformationRule__Group_8__0__Impl : ( RULE_TAB_INDENTED_BLOCK_BEGIN ) ;
    public final void rule__TransformationRule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1848:1: ( ( RULE_TAB_INDENTED_BLOCK_BEGIN ) )
            // InternalBXtendDSLParser.g:1849:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            {
            // InternalBXtendDSLParser.g:1849:1: ( RULE_TAB_INDENTED_BLOCK_BEGIN )
            // InternalBXtendDSLParser.g:1850:2: RULE_TAB_INDENTED_BLOCK_BEGIN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_8_0()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_BEGIN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_BEGINTerminalRuleCall_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__0__Impl"


    // $ANTLR start "rule__TransformationRule__Group_8__1"
    // InternalBXtendDSLParser.g:1859:1: rule__TransformationRule__Group_8__1 : rule__TransformationRule__Group_8__1__Impl rule__TransformationRule__Group_8__2 ;
    public final void rule__TransformationRule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1863:1: ( rule__TransformationRule__Group_8__1__Impl rule__TransformationRule__Group_8__2 )
            // InternalBXtendDSLParser.g:1864:2: rule__TransformationRule__Group_8__1__Impl rule__TransformationRule__Group_8__2
            {
            pushFollow(FOLLOW_10);
            rule__TransformationRule__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_8__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__1"


    // $ANTLR start "rule__TransformationRule__Group_8__1__Impl"
    // InternalBXtendDSLParser.g:1871:1: rule__TransformationRule__Group_8__1__Impl : ( ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) ) ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* ) ) ;
    public final void rule__TransformationRule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1875:1: ( ( ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) ) ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* ) ) )
            // InternalBXtendDSLParser.g:1876:1: ( ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) ) ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* ) )
            {
            // InternalBXtendDSLParser.g:1876:1: ( ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) ) ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* ) )
            // InternalBXtendDSLParser.g:1877:2: ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) ) ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* )
            {
            // InternalBXtendDSLParser.g:1877:2: ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 ) )
            // InternalBXtendDSLParser.g:1878:3: ( rule__TransformationRule__TrgMatcherAssignment_8_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_8_1()); 
            }
            // InternalBXtendDSLParser.g:1879:3: ( rule__TransformationRule__TrgMatcherAssignment_8_1 )
            // InternalBXtendDSLParser.g:1879:4: rule__TransformationRule__TrgMatcherAssignment_8_1
            {
            pushFollow(FOLLOW_14);
            rule__TransformationRule__TrgMatcherAssignment_8_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_8_1()); 
            }

            }

            // InternalBXtendDSLParser.g:1882:2: ( ( rule__TransformationRule__TrgMatcherAssignment_8_1 )* )
            // InternalBXtendDSLParser.g:1883:3: ( rule__TransformationRule__TrgMatcherAssignment_8_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_8_1()); 
            }
            // InternalBXtendDSLParser.g:1884:3: ( rule__TransformationRule__TrgMatcherAssignment_8_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:1884:4: rule__TransformationRule__TrgMatcherAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__TransformationRule__TrgMatcherAssignment_8_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgMatcherAssignment_8_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__1__Impl"


    // $ANTLR start "rule__TransformationRule__Group_8__2"
    // InternalBXtendDSLParser.g:1893:1: rule__TransformationRule__Group_8__2 : rule__TransformationRule__Group_8__2__Impl ;
    public final void rule__TransformationRule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1897:1: ( rule__TransformationRule__Group_8__2__Impl )
            // InternalBXtendDSLParser.g:1898:2: rule__TransformationRule__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransformationRule__Group_8__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__2"


    // $ANTLR start "rule__TransformationRule__Group_8__2__Impl"
    // InternalBXtendDSLParser.g:1904:1: rule__TransformationRule__Group_8__2__Impl : ( RULE_TAB_INDENTED_BLOCK_END ) ;
    public final void rule__TransformationRule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1908:1: ( ( RULE_TAB_INDENTED_BLOCK_END ) )
            // InternalBXtendDSLParser.g:1909:1: ( RULE_TAB_INDENTED_BLOCK_END )
            {
            // InternalBXtendDSLParser.g:1909:1: ( RULE_TAB_INDENTED_BLOCK_END )
            // InternalBXtendDSLParser.g:1910:2: RULE_TAB_INDENTED_BLOCK_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_8_2()); 
            }
            match(input,RULE_TAB_INDENTED_BLOCK_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTAB_INDENTED_BLOCK_ENDTerminalRuleCall_8_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__Group_8__2__Impl"


    // $ANTLR start "rule__SrcClassMatcher__Group__0"
    // InternalBXtendDSLParser.g:1920:1: rule__SrcClassMatcher__Group__0 : rule__SrcClassMatcher__Group__0__Impl rule__SrcClassMatcher__Group__1 ;
    public final void rule__SrcClassMatcher__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1924:1: ( rule__SrcClassMatcher__Group__0__Impl rule__SrcClassMatcher__Group__1 )
            // InternalBXtendDSLParser.g:1925:2: rule__SrcClassMatcher__Group__0__Impl rule__SrcClassMatcher__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__SrcClassMatcher__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__0"


    // $ANTLR start "rule__SrcClassMatcher__Group__0__Impl"
    // InternalBXtendDSLParser.g:1932:1: rule__SrcClassMatcher__Group__0__Impl : ( ( rule__SrcClassMatcher__ClazzAssignment_0 ) ) ;
    public final void rule__SrcClassMatcher__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1936:1: ( ( ( rule__SrcClassMatcher__ClazzAssignment_0 ) ) )
            // InternalBXtendDSLParser.g:1937:1: ( ( rule__SrcClassMatcher__ClazzAssignment_0 ) )
            {
            // InternalBXtendDSLParser.g:1937:1: ( ( rule__SrcClassMatcher__ClazzAssignment_0 ) )
            // InternalBXtendDSLParser.g:1938:2: ( rule__SrcClassMatcher__ClazzAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getClazzAssignment_0()); 
            }
            // InternalBXtendDSLParser.g:1939:2: ( rule__SrcClassMatcher__ClazzAssignment_0 )
            // InternalBXtendDSLParser.g:1939:3: rule__SrcClassMatcher__ClazzAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__ClazzAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getClazzAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__0__Impl"


    // $ANTLR start "rule__SrcClassMatcher__Group__1"
    // InternalBXtendDSLParser.g:1947:1: rule__SrcClassMatcher__Group__1 : rule__SrcClassMatcher__Group__1__Impl rule__SrcClassMatcher__Group__2 ;
    public final void rule__SrcClassMatcher__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1951:1: ( rule__SrcClassMatcher__Group__1__Impl rule__SrcClassMatcher__Group__2 )
            // InternalBXtendDSLParser.g:1952:2: rule__SrcClassMatcher__Group__1__Impl rule__SrcClassMatcher__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__SrcClassMatcher__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__1"


    // $ANTLR start "rule__SrcClassMatcher__Group__1__Impl"
    // InternalBXtendDSLParser.g:1959:1: rule__SrcClassMatcher__Group__1__Impl : ( ( rule__SrcClassMatcher__NameAssignment_1 ) ) ;
    public final void rule__SrcClassMatcher__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1963:1: ( ( ( rule__SrcClassMatcher__NameAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:1964:1: ( ( rule__SrcClassMatcher__NameAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:1964:1: ( ( rule__SrcClassMatcher__NameAssignment_1 ) )
            // InternalBXtendDSLParser.g:1965:2: ( rule__SrcClassMatcher__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getNameAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:1966:2: ( rule__SrcClassMatcher__NameAssignment_1 )
            // InternalBXtendDSLParser.g:1966:3: rule__SrcClassMatcher__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__1__Impl"


    // $ANTLR start "rule__SrcClassMatcher__Group__2"
    // InternalBXtendDSLParser.g:1974:1: rule__SrcClassMatcher__Group__2 : rule__SrcClassMatcher__Group__2__Impl rule__SrcClassMatcher__Group__3 ;
    public final void rule__SrcClassMatcher__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1978:1: ( rule__SrcClassMatcher__Group__2__Impl rule__SrcClassMatcher__Group__3 )
            // InternalBXtendDSLParser.g:1979:2: rule__SrcClassMatcher__Group__2__Impl rule__SrcClassMatcher__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__SrcClassMatcher__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__2"


    // $ANTLR start "rule__SrcClassMatcher__Group__2__Impl"
    // InternalBXtendDSLParser.g:1986:1: rule__SrcClassMatcher__Group__2__Impl : ( ( rule__SrcClassMatcher__ModifierAssignment_2 ) ) ;
    public final void rule__SrcClassMatcher__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:1990:1: ( ( ( rule__SrcClassMatcher__ModifierAssignment_2 ) ) )
            // InternalBXtendDSLParser.g:1991:1: ( ( rule__SrcClassMatcher__ModifierAssignment_2 ) )
            {
            // InternalBXtendDSLParser.g:1991:1: ( ( rule__SrcClassMatcher__ModifierAssignment_2 ) )
            // InternalBXtendDSLParser.g:1992:2: ( rule__SrcClassMatcher__ModifierAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getModifierAssignment_2()); 
            }
            // InternalBXtendDSLParser.g:1993:2: ( rule__SrcClassMatcher__ModifierAssignment_2 )
            // InternalBXtendDSLParser.g:1993:3: rule__SrcClassMatcher__ModifierAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__ModifierAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getModifierAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__2__Impl"


    // $ANTLR start "rule__SrcClassMatcher__Group__3"
    // InternalBXtendDSLParser.g:2001:1: rule__SrcClassMatcher__Group__3 : rule__SrcClassMatcher__Group__3__Impl ;
    public final void rule__SrcClassMatcher__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2005:1: ( rule__SrcClassMatcher__Group__3__Impl )
            // InternalBXtendDSLParser.g:2006:2: rule__SrcClassMatcher__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SrcClassMatcher__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__3"


    // $ANTLR start "rule__SrcClassMatcher__Group__3__Impl"
    // InternalBXtendDSLParser.g:2012:1: rule__SrcClassMatcher__Group__3__Impl : ( Semicolon ) ;
    public final void rule__SrcClassMatcher__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2016:1: ( ( Semicolon ) )
            // InternalBXtendDSLParser.g:2017:1: ( Semicolon )
            {
            // InternalBXtendDSLParser.g:2017:1: ( Semicolon )
            // InternalBXtendDSLParser.g:2018:2: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getSemicolonKeyword_3()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__Group__3__Impl"


    // $ANTLR start "rule__TrgClassMatcher__Group__0"
    // InternalBXtendDSLParser.g:2028:1: rule__TrgClassMatcher__Group__0 : rule__TrgClassMatcher__Group__0__Impl rule__TrgClassMatcher__Group__1 ;
    public final void rule__TrgClassMatcher__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2032:1: ( rule__TrgClassMatcher__Group__0__Impl rule__TrgClassMatcher__Group__1 )
            // InternalBXtendDSLParser.g:2033:2: rule__TrgClassMatcher__Group__0__Impl rule__TrgClassMatcher__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__TrgClassMatcher__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__0"


    // $ANTLR start "rule__TrgClassMatcher__Group__0__Impl"
    // InternalBXtendDSLParser.g:2040:1: rule__TrgClassMatcher__Group__0__Impl : ( ( rule__TrgClassMatcher__ClazzAssignment_0 ) ) ;
    public final void rule__TrgClassMatcher__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2044:1: ( ( ( rule__TrgClassMatcher__ClazzAssignment_0 ) ) )
            // InternalBXtendDSLParser.g:2045:1: ( ( rule__TrgClassMatcher__ClazzAssignment_0 ) )
            {
            // InternalBXtendDSLParser.g:2045:1: ( ( rule__TrgClassMatcher__ClazzAssignment_0 ) )
            // InternalBXtendDSLParser.g:2046:2: ( rule__TrgClassMatcher__ClazzAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getClazzAssignment_0()); 
            }
            // InternalBXtendDSLParser.g:2047:2: ( rule__TrgClassMatcher__ClazzAssignment_0 )
            // InternalBXtendDSLParser.g:2047:3: rule__TrgClassMatcher__ClazzAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__ClazzAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getClazzAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__0__Impl"


    // $ANTLR start "rule__TrgClassMatcher__Group__1"
    // InternalBXtendDSLParser.g:2055:1: rule__TrgClassMatcher__Group__1 : rule__TrgClassMatcher__Group__1__Impl rule__TrgClassMatcher__Group__2 ;
    public final void rule__TrgClassMatcher__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2059:1: ( rule__TrgClassMatcher__Group__1__Impl rule__TrgClassMatcher__Group__2 )
            // InternalBXtendDSLParser.g:2060:2: rule__TrgClassMatcher__Group__1__Impl rule__TrgClassMatcher__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__TrgClassMatcher__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__1"


    // $ANTLR start "rule__TrgClassMatcher__Group__1__Impl"
    // InternalBXtendDSLParser.g:2067:1: rule__TrgClassMatcher__Group__1__Impl : ( ( rule__TrgClassMatcher__NameAssignment_1 ) ) ;
    public final void rule__TrgClassMatcher__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2071:1: ( ( ( rule__TrgClassMatcher__NameAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:2072:1: ( ( rule__TrgClassMatcher__NameAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:2072:1: ( ( rule__TrgClassMatcher__NameAssignment_1 ) )
            // InternalBXtendDSLParser.g:2073:2: ( rule__TrgClassMatcher__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getNameAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:2074:2: ( rule__TrgClassMatcher__NameAssignment_1 )
            // InternalBXtendDSLParser.g:2074:3: rule__TrgClassMatcher__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__1__Impl"


    // $ANTLR start "rule__TrgClassMatcher__Group__2"
    // InternalBXtendDSLParser.g:2082:1: rule__TrgClassMatcher__Group__2 : rule__TrgClassMatcher__Group__2__Impl rule__TrgClassMatcher__Group__3 ;
    public final void rule__TrgClassMatcher__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2086:1: ( rule__TrgClassMatcher__Group__2__Impl rule__TrgClassMatcher__Group__3 )
            // InternalBXtendDSLParser.g:2087:2: rule__TrgClassMatcher__Group__2__Impl rule__TrgClassMatcher__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__TrgClassMatcher__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__2"


    // $ANTLR start "rule__TrgClassMatcher__Group__2__Impl"
    // InternalBXtendDSLParser.g:2094:1: rule__TrgClassMatcher__Group__2__Impl : ( ( rule__TrgClassMatcher__ModifierAssignment_2 ) ) ;
    public final void rule__TrgClassMatcher__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2098:1: ( ( ( rule__TrgClassMatcher__ModifierAssignment_2 ) ) )
            // InternalBXtendDSLParser.g:2099:1: ( ( rule__TrgClassMatcher__ModifierAssignment_2 ) )
            {
            // InternalBXtendDSLParser.g:2099:1: ( ( rule__TrgClassMatcher__ModifierAssignment_2 ) )
            // InternalBXtendDSLParser.g:2100:2: ( rule__TrgClassMatcher__ModifierAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getModifierAssignment_2()); 
            }
            // InternalBXtendDSLParser.g:2101:2: ( rule__TrgClassMatcher__ModifierAssignment_2 )
            // InternalBXtendDSLParser.g:2101:3: rule__TrgClassMatcher__ModifierAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__ModifierAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getModifierAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__2__Impl"


    // $ANTLR start "rule__TrgClassMatcher__Group__3"
    // InternalBXtendDSLParser.g:2109:1: rule__TrgClassMatcher__Group__3 : rule__TrgClassMatcher__Group__3__Impl ;
    public final void rule__TrgClassMatcher__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2113:1: ( rule__TrgClassMatcher__Group__3__Impl )
            // InternalBXtendDSLParser.g:2114:2: rule__TrgClassMatcher__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrgClassMatcher__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__3"


    // $ANTLR start "rule__TrgClassMatcher__Group__3__Impl"
    // InternalBXtendDSLParser.g:2120:1: rule__TrgClassMatcher__Group__3__Impl : ( Semicolon ) ;
    public final void rule__TrgClassMatcher__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2124:1: ( ( Semicolon ) )
            // InternalBXtendDSLParser.g:2125:1: ( Semicolon )
            {
            // InternalBXtendDSLParser.g:2125:1: ( Semicolon )
            // InternalBXtendDSLParser.g:2126:2: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getSemicolonKeyword_3()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__Group__3__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group__0"
    // InternalBXtendDSLParser.g:2136:1: rule__ClassMatcherModifier__Group__0 : rule__ClassMatcherModifier__Group__0__Impl rule__ClassMatcherModifier__Group__1 ;
    public final void rule__ClassMatcherModifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2140:1: ( rule__ClassMatcherModifier__Group__0__Impl rule__ClassMatcherModifier__Group__1 )
            // InternalBXtendDSLParser.g:2141:2: rule__ClassMatcherModifier__Group__0__Impl rule__ClassMatcherModifier__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__ClassMatcherModifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group__0__Impl"
    // InternalBXtendDSLParser.g:2148:1: rule__ClassMatcherModifier__Group__0__Impl : ( () ) ;
    public final void rule__ClassMatcherModifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2152:1: ( ( () ) )
            // InternalBXtendDSLParser.g:2153:1: ( () )
            {
            // InternalBXtendDSLParser.g:2153:1: ( () )
            // InternalBXtendDSLParser.g:2154:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getClassMatcherModifierAction_0()); 
            }
            // InternalBXtendDSLParser.g:2155:2: ()
            // InternalBXtendDSLParser.g:2155:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getClassMatcherModifierAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group__1"
    // InternalBXtendDSLParser.g:2163:1: rule__ClassMatcherModifier__Group__1 : rule__ClassMatcherModifier__Group__1__Impl ;
    public final void rule__ClassMatcherModifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2167:1: ( rule__ClassMatcherModifier__Group__1__Impl )
            // InternalBXtendDSLParser.g:2168:2: rule__ClassMatcherModifier__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group__1__Impl"
    // InternalBXtendDSLParser.g:2174:1: rule__ClassMatcherModifier__Group__1__Impl : ( ( rule__ClassMatcherModifier__Alternatives_1 )? ) ;
    public final void rule__ClassMatcherModifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2178:1: ( ( ( rule__ClassMatcherModifier__Alternatives_1 )? ) )
            // InternalBXtendDSLParser.g:2179:1: ( ( rule__ClassMatcherModifier__Alternatives_1 )? )
            {
            // InternalBXtendDSLParser.g:2179:1: ( ( rule__ClassMatcherModifier__Alternatives_1 )? )
            // InternalBXtendDSLParser.g:2180:2: ( rule__ClassMatcherModifier__Alternatives_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getAlternatives_1()); 
            }
            // InternalBXtendDSLParser.g:2181:2: ( rule__ClassMatcherModifier__Alternatives_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==VerticalLine) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBXtendDSLParser.g:2181:3: rule__ClassMatcherModifier__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Alternatives_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__0"
    // InternalBXtendDSLParser.g:2190:1: rule__ClassMatcherModifier__Group_1_0__0 : rule__ClassMatcherModifier__Group_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2194:1: ( rule__ClassMatcherModifier__Group_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0__1 )
            // InternalBXtendDSLParser.g:2195:2: rule__ClassMatcherModifier__Group_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0__1
            {
            pushFollow(FOLLOW_21);
            rule__ClassMatcherModifier__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__0__Impl"
    // InternalBXtendDSLParser.g:2202:1: rule__ClassMatcherModifier__Group_1_0__0__Impl : ( VerticalLine ) ;
    public final void rule__ClassMatcherModifier__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2206:1: ( ( VerticalLine ) )
            // InternalBXtendDSLParser.g:2207:1: ( VerticalLine )
            {
            // InternalBXtendDSLParser.g:2207:1: ( VerticalLine )
            // InternalBXtendDSLParser.g:2208:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_0_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__1"
    // InternalBXtendDSLParser.g:2217:1: rule__ClassMatcherModifier__Group_1_0__1 : rule__ClassMatcherModifier__Group_1_0__1__Impl rule__ClassMatcherModifier__Group_1_0__2 ;
    public final void rule__ClassMatcherModifier__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2221:1: ( rule__ClassMatcherModifier__Group_1_0__1__Impl rule__ClassMatcherModifier__Group_1_0__2 )
            // InternalBXtendDSLParser.g:2222:2: rule__ClassMatcherModifier__Group_1_0__1__Impl rule__ClassMatcherModifier__Group_1_0__2
            {
            pushFollow(FOLLOW_22);
            rule__ClassMatcherModifier__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__1__Impl"
    // InternalBXtendDSLParser.g:2229:1: rule__ClassMatcherModifier__Group_1_0__1__Impl : ( ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2233:1: ( ( ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 ) ) )
            // InternalBXtendDSLParser.g:2234:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 ) )
            {
            // InternalBXtendDSLParser.g:2234:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 ) )
            // InternalBXtendDSLParser.g:2235:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1()); 
            }
            // InternalBXtendDSLParser.g:2236:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1 )
            // InternalBXtendDSLParser.g:2236:3: rule__ClassMatcherModifier__UnorderedGroup_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__2"
    // InternalBXtendDSLParser.g:2244:1: rule__ClassMatcherModifier__Group_1_0__2 : rule__ClassMatcherModifier__Group_1_0__2__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2248:1: ( rule__ClassMatcherModifier__Group_1_0__2__Impl )
            // InternalBXtendDSLParser.g:2249:2: rule__ClassMatcherModifier__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__2"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0__2__Impl"
    // InternalBXtendDSLParser.g:2255:1: rule__ClassMatcherModifier__Group_1_0__2__Impl : ( ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2259:1: ( ( ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 ) ) )
            // InternalBXtendDSLParser.g:2260:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 ) )
            {
            // InternalBXtendDSLParser.g:2260:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 ) )
            // InternalBXtendDSLParser.g:2261:2: ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_0_2()); 
            }
            // InternalBXtendDSLParser.g:2262:2: ( rule__ClassMatcherModifier__GroupAssignment_1_0_2 )
            // InternalBXtendDSLParser.g:2262:3: rule__ClassMatcherModifier__GroupAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__GroupAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0__2__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_0__0"
    // InternalBXtendDSLParser.g:2271:1: rule__ClassMatcherModifier__Group_1_0_1_0__0 : rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2275:1: ( rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0_1_0__1 )
            // InternalBXtendDSLParser.g:2276:2: rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl rule__ClassMatcherModifier__Group_1_0_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl"
    // InternalBXtendDSLParser.g:2283:1: rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl : ( ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2287:1: ( ( ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 ) ) )
            // InternalBXtendDSLParser.g:2288:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 ) )
            {
            // InternalBXtendDSLParser.g:2288:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 ) )
            // InternalBXtendDSLParser.g:2289:2: ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_0_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:2290:2: ( rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 )
            // InternalBXtendDSLParser.g:2290:3: rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_0__1"
    // InternalBXtendDSLParser.g:2298:1: rule__ClassMatcherModifier__Group_1_0_1_0__1 : rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2302:1: ( rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl )
            // InternalBXtendDSLParser.g:2303:2: rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl"
    // InternalBXtendDSLParser.g:2309:1: rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2313:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2314:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2314:1: ( Comma )
            // InternalBXtendDSLParser.g:2315:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_0_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_1__0"
    // InternalBXtendDSLParser.g:2325:1: rule__ClassMatcherModifier__Group_1_0_1_1__0 : rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl rule__ClassMatcherModifier__Group_1_0_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2329:1: ( rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl rule__ClassMatcherModifier__Group_1_0_1_1__1 )
            // InternalBXtendDSLParser.g:2330:2: rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl rule__ClassMatcherModifier__Group_1_0_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl"
    // InternalBXtendDSLParser.g:2337:1: rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl : ( ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2341:1: ( ( ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 ) ) )
            // InternalBXtendDSLParser.g:2342:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 ) )
            {
            // InternalBXtendDSLParser.g:2342:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 ) )
            // InternalBXtendDSLParser.g:2343:2: ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_0_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:2344:2: ( rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 )
            // InternalBXtendDSLParser.g:2344:3: rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_1__1"
    // InternalBXtendDSLParser.g:2352:1: rule__ClassMatcherModifier__Group_1_0_1_1__1 : rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2356:1: ( rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl )
            // InternalBXtendDSLParser.g:2357:2: rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl"
    // InternalBXtendDSLParser.g:2363:1: rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2367:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2368:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2368:1: ( Comma )
            // InternalBXtendDSLParser.g:2369:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_1_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_2__0"
    // InternalBXtendDSLParser.g:2379:1: rule__ClassMatcherModifier__Group_1_0_1_2__0 : rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl rule__ClassMatcherModifier__Group_1_0_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2383:1: ( rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl rule__ClassMatcherModifier__Group_1_0_1_2__1 )
            // InternalBXtendDSLParser.g:2384:2: rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl rule__ClassMatcherModifier__Group_1_0_1_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl"
    // InternalBXtendDSLParser.g:2391:1: rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl : ( ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2395:1: ( ( ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 ) ) )
            // InternalBXtendDSLParser.g:2396:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 ) )
            {
            // InternalBXtendDSLParser.g:2396:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 ) )
            // InternalBXtendDSLParser.g:2397:2: ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_0_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:2398:2: ( rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 )
            // InternalBXtendDSLParser.g:2398:3: rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_0_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_2__1"
    // InternalBXtendDSLParser.g:2406:1: rule__ClassMatcherModifier__Group_1_0_1_2__1 : rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2410:1: ( rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl )
            // InternalBXtendDSLParser.g:2411:2: rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl"
    // InternalBXtendDSLParser.g:2417:1: rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2421:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2422:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2422:1: ( Comma )
            // InternalBXtendDSLParser.g:2423:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_2_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_3__0"
    // InternalBXtendDSLParser.g:2433:1: rule__ClassMatcherModifier__Group_1_0_1_3__0 : rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl rule__ClassMatcherModifier__Group_1_0_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2437:1: ( rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl rule__ClassMatcherModifier__Group_1_0_1_3__1 )
            // InternalBXtendDSLParser.g:2438:2: rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl rule__ClassMatcherModifier__Group_1_0_1_3__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl"
    // InternalBXtendDSLParser.g:2445:1: rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl : ( ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2449:1: ( ( ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 ) ) )
            // InternalBXtendDSLParser.g:2450:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 ) )
            {
            // InternalBXtendDSLParser.g:2450:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 ) )
            // InternalBXtendDSLParser.g:2451:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_0_1_3_0()); 
            }
            // InternalBXtendDSLParser.g:2452:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 )
            // InternalBXtendDSLParser.g:2452:3: rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_0_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_3__1"
    // InternalBXtendDSLParser.g:2460:1: rule__ClassMatcherModifier__Group_1_0_1_3__1 : rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2464:1: ( rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl )
            // InternalBXtendDSLParser.g:2465:2: rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl"
    // InternalBXtendDSLParser.g:2471:1: rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2475:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2476:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2476:1: ( Comma )
            // InternalBXtendDSLParser.g:2477:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_3_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_0_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_0_1_3__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__0"
    // InternalBXtendDSLParser.g:2487:1: rule__ClassMatcherModifier__Group_1_1__0 : rule__ClassMatcherModifier__Group_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2491:1: ( rule__ClassMatcherModifier__Group_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1__1 )
            // InternalBXtendDSLParser.g:2492:2: rule__ClassMatcherModifier__Group_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1__1
            {
            pushFollow(FOLLOW_24);
            rule__ClassMatcherModifier__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__0__Impl"
    // InternalBXtendDSLParser.g:2499:1: rule__ClassMatcherModifier__Group_1_1__0__Impl : ( VerticalLine ) ;
    public final void rule__ClassMatcherModifier__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2503:1: ( ( VerticalLine ) )
            // InternalBXtendDSLParser.g:2504:1: ( VerticalLine )
            {
            // InternalBXtendDSLParser.g:2504:1: ( VerticalLine )
            // InternalBXtendDSLParser.g:2505:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_1_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__1"
    // InternalBXtendDSLParser.g:2514:1: rule__ClassMatcherModifier__Group_1_1__1 : rule__ClassMatcherModifier__Group_1_1__1__Impl rule__ClassMatcherModifier__Group_1_1__2 ;
    public final void rule__ClassMatcherModifier__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2518:1: ( rule__ClassMatcherModifier__Group_1_1__1__Impl rule__ClassMatcherModifier__Group_1_1__2 )
            // InternalBXtendDSLParser.g:2519:2: rule__ClassMatcherModifier__Group_1_1__1__Impl rule__ClassMatcherModifier__Group_1_1__2
            {
            pushFollow(FOLLOW_25);
            rule__ClassMatcherModifier__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__1__Impl"
    // InternalBXtendDSLParser.g:2526:1: rule__ClassMatcherModifier__Group_1_1__1__Impl : ( ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2530:1: ( ( ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 ) ) )
            // InternalBXtendDSLParser.g:2531:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 ) )
            {
            // InternalBXtendDSLParser.g:2531:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 ) )
            // InternalBXtendDSLParser.g:2532:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1()); 
            }
            // InternalBXtendDSLParser.g:2533:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1 )
            // InternalBXtendDSLParser.g:2533:3: rule__ClassMatcherModifier__UnorderedGroup_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__2"
    // InternalBXtendDSLParser.g:2541:1: rule__ClassMatcherModifier__Group_1_1__2 : rule__ClassMatcherModifier__Group_1_1__2__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2545:1: ( rule__ClassMatcherModifier__Group_1_1__2__Impl )
            // InternalBXtendDSLParser.g:2546:2: rule__ClassMatcherModifier__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1__2__Impl"
    // InternalBXtendDSLParser.g:2552:1: rule__ClassMatcherModifier__Group_1_1__2__Impl : ( ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2556:1: ( ( ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 ) ) )
            // InternalBXtendDSLParser.g:2557:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 ) )
            {
            // InternalBXtendDSLParser.g:2557:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 ) )
            // InternalBXtendDSLParser.g:2558:2: ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_1_2()); 
            }
            // InternalBXtendDSLParser.g:2559:2: ( rule__ClassMatcherModifier__FilterAssignment_1_1_2 )
            // InternalBXtendDSLParser.g:2559:3: rule__ClassMatcherModifier__FilterAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__FilterAssignment_1_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1__2__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_0__0"
    // InternalBXtendDSLParser.g:2568:1: rule__ClassMatcherModifier__Group_1_1_1_0__0 : rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl rule__ClassMatcherModifier__Group_1_1_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2572:1: ( rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl rule__ClassMatcherModifier__Group_1_1_1_0__1 )
            // InternalBXtendDSLParser.g:2573:2: rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl rule__ClassMatcherModifier__Group_1_1_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl"
    // InternalBXtendDSLParser.g:2580:1: rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl : ( ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2584:1: ( ( ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 ) ) )
            // InternalBXtendDSLParser.g:2585:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 ) )
            {
            // InternalBXtendDSLParser.g:2585:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 ) )
            // InternalBXtendDSLParser.g:2586:2: ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:2587:2: ( rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 )
            // InternalBXtendDSLParser.g:2587:3: rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_0__1"
    // InternalBXtendDSLParser.g:2595:1: rule__ClassMatcherModifier__Group_1_1_1_0__1 : rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2599:1: ( rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl )
            // InternalBXtendDSLParser.g:2600:2: rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl"
    // InternalBXtendDSLParser.g:2606:1: rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2610:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2611:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2611:1: ( Comma )
            // InternalBXtendDSLParser.g:2612:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_0_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_1__0"
    // InternalBXtendDSLParser.g:2622:1: rule__ClassMatcherModifier__Group_1_1_1_1__0 : rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2626:1: ( rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1_1_1__1 )
            // InternalBXtendDSLParser.g:2627:2: rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl rule__ClassMatcherModifier__Group_1_1_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl"
    // InternalBXtendDSLParser.g:2634:1: rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl : ( ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2638:1: ( ( ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 ) ) )
            // InternalBXtendDSLParser.g:2639:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 ) )
            {
            // InternalBXtendDSLParser.g:2639:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 ) )
            // InternalBXtendDSLParser.g:2640:2: ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_1_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:2641:2: ( rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 )
            // InternalBXtendDSLParser.g:2641:3: rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_1__1"
    // InternalBXtendDSLParser.g:2649:1: rule__ClassMatcherModifier__Group_1_1_1_1__1 : rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2653:1: ( rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl )
            // InternalBXtendDSLParser.g:2654:2: rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl"
    // InternalBXtendDSLParser.g:2660:1: rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2664:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2665:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2665:1: ( Comma )
            // InternalBXtendDSLParser.g:2666:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_1_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_2__0"
    // InternalBXtendDSLParser.g:2676:1: rule__ClassMatcherModifier__Group_1_1_1_2__0 : rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl rule__ClassMatcherModifier__Group_1_1_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2680:1: ( rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl rule__ClassMatcherModifier__Group_1_1_1_2__1 )
            // InternalBXtendDSLParser.g:2681:2: rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl rule__ClassMatcherModifier__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl"
    // InternalBXtendDSLParser.g:2688:1: rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl : ( ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2692:1: ( ( ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 ) ) )
            // InternalBXtendDSLParser.g:2693:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 ) )
            {
            // InternalBXtendDSLParser.g:2693:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 ) )
            // InternalBXtendDSLParser.g:2694:2: ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_1_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:2695:2: ( rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 )
            // InternalBXtendDSLParser.g:2695:3: rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_1_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_2__1"
    // InternalBXtendDSLParser.g:2703:1: rule__ClassMatcherModifier__Group_1_1_1_2__1 : rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2707:1: ( rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl )
            // InternalBXtendDSLParser.g:2708:2: rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl"
    // InternalBXtendDSLParser.g:2714:1: rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2718:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2719:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2719:1: ( Comma )
            // InternalBXtendDSLParser.g:2720:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_2_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_3__0"
    // InternalBXtendDSLParser.g:2730:1: rule__ClassMatcherModifier__Group_1_1_1_3__0 : rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl rule__ClassMatcherModifier__Group_1_1_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2734:1: ( rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl rule__ClassMatcherModifier__Group_1_1_1_3__1 )
            // InternalBXtendDSLParser.g:2735:2: rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl rule__ClassMatcherModifier__Group_1_1_1_3__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl"
    // InternalBXtendDSLParser.g:2742:1: rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl : ( ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2746:1: ( ( ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 ) ) )
            // InternalBXtendDSLParser.g:2747:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 ) )
            {
            // InternalBXtendDSLParser.g:2747:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 ) )
            // InternalBXtendDSLParser.g:2748:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_1_1_3_0()); 
            }
            // InternalBXtendDSLParser.g:2749:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 )
            // InternalBXtendDSLParser.g:2749:3: rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_1_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_3__1"
    // InternalBXtendDSLParser.g:2757:1: rule__ClassMatcherModifier__Group_1_1_1_3__1 : rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2761:1: ( rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl )
            // InternalBXtendDSLParser.g:2762:2: rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl"
    // InternalBXtendDSLParser.g:2768:1: rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2772:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2773:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2773:1: ( Comma )
            // InternalBXtendDSLParser.g:2774:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_3_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_1_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_1_1_3__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__0"
    // InternalBXtendDSLParser.g:2784:1: rule__ClassMatcherModifier__Group_1_2__0 : rule__ClassMatcherModifier__Group_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2788:1: ( rule__ClassMatcherModifier__Group_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2__1 )
            // InternalBXtendDSLParser.g:2789:2: rule__ClassMatcherModifier__Group_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2__1
            {
            pushFollow(FOLLOW_26);
            rule__ClassMatcherModifier__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__0__Impl"
    // InternalBXtendDSLParser.g:2796:1: rule__ClassMatcherModifier__Group_1_2__0__Impl : ( VerticalLine ) ;
    public final void rule__ClassMatcherModifier__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2800:1: ( ( VerticalLine ) )
            // InternalBXtendDSLParser.g:2801:1: ( VerticalLine )
            {
            // InternalBXtendDSLParser.g:2801:1: ( VerticalLine )
            // InternalBXtendDSLParser.g:2802:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_2_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__1"
    // InternalBXtendDSLParser.g:2811:1: rule__ClassMatcherModifier__Group_1_2__1 : rule__ClassMatcherModifier__Group_1_2__1__Impl rule__ClassMatcherModifier__Group_1_2__2 ;
    public final void rule__ClassMatcherModifier__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2815:1: ( rule__ClassMatcherModifier__Group_1_2__1__Impl rule__ClassMatcherModifier__Group_1_2__2 )
            // InternalBXtendDSLParser.g:2816:2: rule__ClassMatcherModifier__Group_1_2__1__Impl rule__ClassMatcherModifier__Group_1_2__2
            {
            pushFollow(FOLLOW_27);
            rule__ClassMatcherModifier__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__1__Impl"
    // InternalBXtendDSLParser.g:2823:1: rule__ClassMatcherModifier__Group_1_2__1__Impl : ( ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2827:1: ( ( ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 ) ) )
            // InternalBXtendDSLParser.g:2828:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 ) )
            {
            // InternalBXtendDSLParser.g:2828:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 ) )
            // InternalBXtendDSLParser.g:2829:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1()); 
            }
            // InternalBXtendDSLParser.g:2830:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1 )
            // InternalBXtendDSLParser.g:2830:3: rule__ClassMatcherModifier__UnorderedGroup_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__2"
    // InternalBXtendDSLParser.g:2838:1: rule__ClassMatcherModifier__Group_1_2__2 : rule__ClassMatcherModifier__Group_1_2__2__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2842:1: ( rule__ClassMatcherModifier__Group_1_2__2__Impl )
            // InternalBXtendDSLParser.g:2843:2: rule__ClassMatcherModifier__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__2"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2__2__Impl"
    // InternalBXtendDSLParser.g:2849:1: rule__ClassMatcherModifier__Group_1_2__2__Impl : ( ( rule__ClassMatcherModifier__SortAssignment_1_2_2 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2853:1: ( ( ( rule__ClassMatcherModifier__SortAssignment_1_2_2 ) ) )
            // InternalBXtendDSLParser.g:2854:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_2_2 ) )
            {
            // InternalBXtendDSLParser.g:2854:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_2_2 ) )
            // InternalBXtendDSLParser.g:2855:2: ( rule__ClassMatcherModifier__SortAssignment_1_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_2_2()); 
            }
            // InternalBXtendDSLParser.g:2856:2: ( rule__ClassMatcherModifier__SortAssignment_1_2_2 )
            // InternalBXtendDSLParser.g:2856:3: rule__ClassMatcherModifier__SortAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__SortAssignment_1_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2__2__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_0__0"
    // InternalBXtendDSLParser.g:2865:1: rule__ClassMatcherModifier__Group_1_2_1_0__0 : rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl rule__ClassMatcherModifier__Group_1_2_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2869:1: ( rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl rule__ClassMatcherModifier__Group_1_2_1_0__1 )
            // InternalBXtendDSLParser.g:2870:2: rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl rule__ClassMatcherModifier__Group_1_2_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl"
    // InternalBXtendDSLParser.g:2877:1: rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl : ( ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2881:1: ( ( ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 ) ) )
            // InternalBXtendDSLParser.g:2882:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 ) )
            {
            // InternalBXtendDSLParser.g:2882:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 ) )
            // InternalBXtendDSLParser.g:2883:2: ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_2_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:2884:2: ( rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 )
            // InternalBXtendDSLParser.g:2884:3: rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_2_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_0__1"
    // InternalBXtendDSLParser.g:2892:1: rule__ClassMatcherModifier__Group_1_2_1_0__1 : rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2896:1: ( rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl )
            // InternalBXtendDSLParser.g:2897:2: rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl"
    // InternalBXtendDSLParser.g:2903:1: rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2907:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2908:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2908:1: ( Comma )
            // InternalBXtendDSLParser.g:2909:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_0_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_1__0"
    // InternalBXtendDSLParser.g:2919:1: rule__ClassMatcherModifier__Group_1_2_1_1__0 : rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl rule__ClassMatcherModifier__Group_1_2_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2923:1: ( rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl rule__ClassMatcherModifier__Group_1_2_1_1__1 )
            // InternalBXtendDSLParser.g:2924:2: rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl rule__ClassMatcherModifier__Group_1_2_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl"
    // InternalBXtendDSLParser.g:2931:1: rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl : ( ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2935:1: ( ( ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 ) ) )
            // InternalBXtendDSLParser.g:2936:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 ) )
            {
            // InternalBXtendDSLParser.g:2936:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 ) )
            // InternalBXtendDSLParser.g:2937:2: ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_2_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:2938:2: ( rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 )
            // InternalBXtendDSLParser.g:2938:3: rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_2_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_1__1"
    // InternalBXtendDSLParser.g:2946:1: rule__ClassMatcherModifier__Group_1_2_1_1__1 : rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2950:1: ( rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl )
            // InternalBXtendDSLParser.g:2951:2: rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl"
    // InternalBXtendDSLParser.g:2957:1: rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2961:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:2962:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:2962:1: ( Comma )
            // InternalBXtendDSLParser.g:2963:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_1_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_2__0"
    // InternalBXtendDSLParser.g:2973:1: rule__ClassMatcherModifier__Group_1_2_1_2__0 : rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2977:1: ( rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2_1_2__1 )
            // InternalBXtendDSLParser.g:2978:2: rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl rule__ClassMatcherModifier__Group_1_2_1_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl"
    // InternalBXtendDSLParser.g:2985:1: rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl : ( ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:2989:1: ( ( ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 ) ) )
            // InternalBXtendDSLParser.g:2990:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 ) )
            {
            // InternalBXtendDSLParser.g:2990:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 ) )
            // InternalBXtendDSLParser.g:2991:2: ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_2_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:2992:2: ( rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 )
            // InternalBXtendDSLParser.g:2992:3: rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_2_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_2__1"
    // InternalBXtendDSLParser.g:3000:1: rule__ClassMatcherModifier__Group_1_2_1_2__1 : rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3004:1: ( rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl )
            // InternalBXtendDSLParser.g:3005:2: rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl"
    // InternalBXtendDSLParser.g:3011:1: rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3015:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3016:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3016:1: ( Comma )
            // InternalBXtendDSLParser.g:3017:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_2_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_3__0"
    // InternalBXtendDSLParser.g:3027:1: rule__ClassMatcherModifier__Group_1_2_1_3__0 : rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl rule__ClassMatcherModifier__Group_1_2_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3031:1: ( rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl rule__ClassMatcherModifier__Group_1_2_1_3__1 )
            // InternalBXtendDSLParser.g:3032:2: rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl rule__ClassMatcherModifier__Group_1_2_1_3__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl"
    // InternalBXtendDSLParser.g:3039:1: rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl : ( ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3043:1: ( ( ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 ) ) )
            // InternalBXtendDSLParser.g:3044:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 ) )
            {
            // InternalBXtendDSLParser.g:3044:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 ) )
            // InternalBXtendDSLParser.g:3045:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_2_1_3_0()); 
            }
            // InternalBXtendDSLParser.g:3046:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 )
            // InternalBXtendDSLParser.g:3046:3: rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_2_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_3__1"
    // InternalBXtendDSLParser.g:3054:1: rule__ClassMatcherModifier__Group_1_2_1_3__1 : rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3058:1: ( rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl )
            // InternalBXtendDSLParser.g:3059:2: rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl"
    // InternalBXtendDSLParser.g:3065:1: rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3069:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3070:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3070:1: ( Comma )
            // InternalBXtendDSLParser.g:3071:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_3_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_2_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_2_1_3__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__0"
    // InternalBXtendDSLParser.g:3081:1: rule__ClassMatcherModifier__Group_1_3__0 : rule__ClassMatcherModifier__Group_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3085:1: ( rule__ClassMatcherModifier__Group_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3__1 )
            // InternalBXtendDSLParser.g:3086:2: rule__ClassMatcherModifier__Group_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3__1
            {
            pushFollow(FOLLOW_28);
            rule__ClassMatcherModifier__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__0__Impl"
    // InternalBXtendDSLParser.g:3093:1: rule__ClassMatcherModifier__Group_1_3__0__Impl : ( VerticalLine ) ;
    public final void rule__ClassMatcherModifier__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3097:1: ( ( VerticalLine ) )
            // InternalBXtendDSLParser.g:3098:1: ( VerticalLine )
            {
            // InternalBXtendDSLParser.g:3098:1: ( VerticalLine )
            // InternalBXtendDSLParser.g:3099:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_3_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__1"
    // InternalBXtendDSLParser.g:3108:1: rule__ClassMatcherModifier__Group_1_3__1 : rule__ClassMatcherModifier__Group_1_3__1__Impl rule__ClassMatcherModifier__Group_1_3__2 ;
    public final void rule__ClassMatcherModifier__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3112:1: ( rule__ClassMatcherModifier__Group_1_3__1__Impl rule__ClassMatcherModifier__Group_1_3__2 )
            // InternalBXtendDSLParser.g:3113:2: rule__ClassMatcherModifier__Group_1_3__1__Impl rule__ClassMatcherModifier__Group_1_3__2
            {
            pushFollow(FOLLOW_29);
            rule__ClassMatcherModifier__Group_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__1__Impl"
    // InternalBXtendDSLParser.g:3120:1: rule__ClassMatcherModifier__Group_1_3__1__Impl : ( ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3124:1: ( ( ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 ) ) )
            // InternalBXtendDSLParser.g:3125:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 ) )
            {
            // InternalBXtendDSLParser.g:3125:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 ) )
            // InternalBXtendDSLParser.g:3126:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1()); 
            }
            // InternalBXtendDSLParser.g:3127:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1 )
            // InternalBXtendDSLParser.g:3127:3: rule__ClassMatcherModifier__UnorderedGroup_1_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__2"
    // InternalBXtendDSLParser.g:3135:1: rule__ClassMatcherModifier__Group_1_3__2 : rule__ClassMatcherModifier__Group_1_3__2__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3139:1: ( rule__ClassMatcherModifier__Group_1_3__2__Impl )
            // InternalBXtendDSLParser.g:3140:2: rule__ClassMatcherModifier__Group_1_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__2"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3__2__Impl"
    // InternalBXtendDSLParser.g:3146:1: rule__ClassMatcherModifier__Group_1_3__2__Impl : ( ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3150:1: ( ( ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 ) ) )
            // InternalBXtendDSLParser.g:3151:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 ) )
            {
            // InternalBXtendDSLParser.g:3151:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 ) )
            // InternalBXtendDSLParser.g:3152:2: ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_3_2()); 
            }
            // InternalBXtendDSLParser.g:3153:2: ( rule__ClassMatcherModifier__CreationAssignment_1_3_2 )
            // InternalBXtendDSLParser.g:3153:3: rule__ClassMatcherModifier__CreationAssignment_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__CreationAssignment_1_3_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3__2__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_0__0"
    // InternalBXtendDSLParser.g:3162:1: rule__ClassMatcherModifier__Group_1_3_1_0__0 : rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl rule__ClassMatcherModifier__Group_1_3_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3166:1: ( rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl rule__ClassMatcherModifier__Group_1_3_1_0__1 )
            // InternalBXtendDSLParser.g:3167:2: rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl rule__ClassMatcherModifier__Group_1_3_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl"
    // InternalBXtendDSLParser.g:3174:1: rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl : ( ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3178:1: ( ( ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 ) ) )
            // InternalBXtendDSLParser.g:3179:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 ) )
            {
            // InternalBXtendDSLParser.g:3179:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 ) )
            // InternalBXtendDSLParser.g:3180:2: ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_3_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:3181:2: ( rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 )
            // InternalBXtendDSLParser.g:3181:3: rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_3_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_0__1"
    // InternalBXtendDSLParser.g:3189:1: rule__ClassMatcherModifier__Group_1_3_1_0__1 : rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3193:1: ( rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl )
            // InternalBXtendDSLParser.g:3194:2: rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl"
    // InternalBXtendDSLParser.g:3200:1: rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3204:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3205:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3205:1: ( Comma )
            // InternalBXtendDSLParser.g:3206:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_0_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_1__0"
    // InternalBXtendDSLParser.g:3216:1: rule__ClassMatcherModifier__Group_1_3_1_1__0 : rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl rule__ClassMatcherModifier__Group_1_3_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3220:1: ( rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl rule__ClassMatcherModifier__Group_1_3_1_1__1 )
            // InternalBXtendDSLParser.g:3221:2: rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl rule__ClassMatcherModifier__Group_1_3_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl"
    // InternalBXtendDSLParser.g:3228:1: rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl : ( ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3232:1: ( ( ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 ) ) )
            // InternalBXtendDSLParser.g:3233:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 ) )
            {
            // InternalBXtendDSLParser.g:3233:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 ) )
            // InternalBXtendDSLParser.g:3234:2: ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_3_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:3235:2: ( rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 )
            // InternalBXtendDSLParser.g:3235:3: rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_1__1"
    // InternalBXtendDSLParser.g:3243:1: rule__ClassMatcherModifier__Group_1_3_1_1__1 : rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3247:1: ( rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl )
            // InternalBXtendDSLParser.g:3248:2: rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl"
    // InternalBXtendDSLParser.g:3254:1: rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3258:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3259:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3259:1: ( Comma )
            // InternalBXtendDSLParser.g:3260:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_1_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_2__0"
    // InternalBXtendDSLParser.g:3270:1: rule__ClassMatcherModifier__Group_1_3_1_2__0 : rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl rule__ClassMatcherModifier__Group_1_3_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3274:1: ( rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl rule__ClassMatcherModifier__Group_1_3_1_2__1 )
            // InternalBXtendDSLParser.g:3275:2: rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl rule__ClassMatcherModifier__Group_1_3_1_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl"
    // InternalBXtendDSLParser.g:3282:1: rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl : ( ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3286:1: ( ( ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 ) ) )
            // InternalBXtendDSLParser.g:3287:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 ) )
            {
            // InternalBXtendDSLParser.g:3287:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 ) )
            // InternalBXtendDSLParser.g:3288:2: ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_3_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:3289:2: ( rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 )
            // InternalBXtendDSLParser.g:3289:3: rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_3_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_2__1"
    // InternalBXtendDSLParser.g:3297:1: rule__ClassMatcherModifier__Group_1_3_1_2__1 : rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3301:1: ( rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl )
            // InternalBXtendDSLParser.g:3302:2: rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl"
    // InternalBXtendDSLParser.g:3308:1: rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3312:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3313:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3313:1: ( Comma )
            // InternalBXtendDSLParser.g:3314:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_2_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_3__0"
    // InternalBXtendDSLParser.g:3324:1: rule__ClassMatcherModifier__Group_1_3_1_3__0 : rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3328:1: ( rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3_1_3__1 )
            // InternalBXtendDSLParser.g:3329:2: rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl rule__ClassMatcherModifier__Group_1_3_1_3__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl"
    // InternalBXtendDSLParser.g:3336:1: rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl : ( ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3340:1: ( ( ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 ) ) )
            // InternalBXtendDSLParser.g:3341:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 ) )
            {
            // InternalBXtendDSLParser.g:3341:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 ) )
            // InternalBXtendDSLParser.g:3342:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_3_1_3_0()); 
            }
            // InternalBXtendDSLParser.g:3343:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 )
            // InternalBXtendDSLParser.g:3343:3: rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_3_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_3__1"
    // InternalBXtendDSLParser.g:3351:1: rule__ClassMatcherModifier__Group_1_3_1_3__1 : rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3355:1: ( rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl )
            // InternalBXtendDSLParser.g:3356:2: rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl"
    // InternalBXtendDSLParser.g:3362:1: rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3366:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3367:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3367:1: ( Comma )
            // InternalBXtendDSLParser.g:3368:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_3_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_3_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_3_1_3__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__0"
    // InternalBXtendDSLParser.g:3378:1: rule__ClassMatcherModifier__Group_1_4__0 : rule__ClassMatcherModifier__Group_1_4__0__Impl rule__ClassMatcherModifier__Group_1_4__1 ;
    public final void rule__ClassMatcherModifier__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3382:1: ( rule__ClassMatcherModifier__Group_1_4__0__Impl rule__ClassMatcherModifier__Group_1_4__1 )
            // InternalBXtendDSLParser.g:3383:2: rule__ClassMatcherModifier__Group_1_4__0__Impl rule__ClassMatcherModifier__Group_1_4__1
            {
            pushFollow(FOLLOW_30);
            rule__ClassMatcherModifier__Group_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__0__Impl"
    // InternalBXtendDSLParser.g:3390:1: rule__ClassMatcherModifier__Group_1_4__0__Impl : ( VerticalLine ) ;
    public final void rule__ClassMatcherModifier__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3394:1: ( ( VerticalLine ) )
            // InternalBXtendDSLParser.g:3395:1: ( VerticalLine )
            {
            // InternalBXtendDSLParser.g:3395:1: ( VerticalLine )
            // InternalBXtendDSLParser.g:3396:2: VerticalLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_4_0()); 
            }
            match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getVerticalLineKeyword_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__1"
    // InternalBXtendDSLParser.g:3405:1: rule__ClassMatcherModifier__Group_1_4__1 : rule__ClassMatcherModifier__Group_1_4__1__Impl rule__ClassMatcherModifier__Group_1_4__2 ;
    public final void rule__ClassMatcherModifier__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3409:1: ( rule__ClassMatcherModifier__Group_1_4__1__Impl rule__ClassMatcherModifier__Group_1_4__2 )
            // InternalBXtendDSLParser.g:3410:2: rule__ClassMatcherModifier__Group_1_4__1__Impl rule__ClassMatcherModifier__Group_1_4__2
            {
            pushFollow(FOLLOW_31);
            rule__ClassMatcherModifier__Group_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__1__Impl"
    // InternalBXtendDSLParser.g:3417:1: rule__ClassMatcherModifier__Group_1_4__1__Impl : ( ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3421:1: ( ( ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 ) ) )
            // InternalBXtendDSLParser.g:3422:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 ) )
            {
            // InternalBXtendDSLParser.g:3422:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 ) )
            // InternalBXtendDSLParser.g:3423:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1()); 
            }
            // InternalBXtendDSLParser.g:3424:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1 )
            // InternalBXtendDSLParser.g:3424:3: rule__ClassMatcherModifier__UnorderedGroup_1_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__2"
    // InternalBXtendDSLParser.g:3432:1: rule__ClassMatcherModifier__Group_1_4__2 : rule__ClassMatcherModifier__Group_1_4__2__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3436:1: ( rule__ClassMatcherModifier__Group_1_4__2__Impl )
            // InternalBXtendDSLParser.g:3437:2: rule__ClassMatcherModifier__Group_1_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__2"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4__2__Impl"
    // InternalBXtendDSLParser.g:3443:1: rule__ClassMatcherModifier__Group_1_4__2__Impl : ( ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3447:1: ( ( ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 ) ) )
            // InternalBXtendDSLParser.g:3448:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 ) )
            {
            // InternalBXtendDSLParser.g:3448:1: ( ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 ) )
            // InternalBXtendDSLParser.g:3449:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_4_2()); 
            }
            // InternalBXtendDSLParser.g:3450:2: ( rule__ClassMatcherModifier__DeletionAssignment_1_4_2 )
            // InternalBXtendDSLParser.g:3450:3: rule__ClassMatcherModifier__DeletionAssignment_1_4_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__DeletionAssignment_1_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionAssignment_1_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4__2__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_0__0"
    // InternalBXtendDSLParser.g:3459:1: rule__ClassMatcherModifier__Group_1_4_1_0__0 : rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl rule__ClassMatcherModifier__Group_1_4_1_0__1 ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3463:1: ( rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl rule__ClassMatcherModifier__Group_1_4_1_0__1 )
            // InternalBXtendDSLParser.g:3464:2: rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl rule__ClassMatcherModifier__Group_1_4_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_0__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl"
    // InternalBXtendDSLParser.g:3471:1: rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl : ( ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3475:1: ( ( ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 ) ) )
            // InternalBXtendDSLParser.g:3476:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 ) )
            {
            // InternalBXtendDSLParser.g:3476:1: ( ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 ) )
            // InternalBXtendDSLParser.g:3477:2: ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_4_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:3478:2: ( rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 )
            // InternalBXtendDSLParser.g:3478:3: rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupAssignment_1_4_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_0__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_0__1"
    // InternalBXtendDSLParser.g:3486:1: rule__ClassMatcherModifier__Group_1_4_1_0__1 : rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3490:1: ( rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl )
            // InternalBXtendDSLParser.g:3491:2: rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_0__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl"
    // InternalBXtendDSLParser.g:3497:1: rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3501:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3502:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3502:1: ( Comma )
            // InternalBXtendDSLParser.g:3503:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_0_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_0__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_1__0"
    // InternalBXtendDSLParser.g:3513:1: rule__ClassMatcherModifier__Group_1_4_1_1__0 : rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl rule__ClassMatcherModifier__Group_1_4_1_1__1 ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3517:1: ( rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl rule__ClassMatcherModifier__Group_1_4_1_1__1 )
            // InternalBXtendDSLParser.g:3518:2: rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl rule__ClassMatcherModifier__Group_1_4_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl"
    // InternalBXtendDSLParser.g:3525:1: rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl : ( ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3529:1: ( ( ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 ) ) )
            // InternalBXtendDSLParser.g:3530:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 ) )
            {
            // InternalBXtendDSLParser.g:3530:1: ( ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 ) )
            // InternalBXtendDSLParser.g:3531:2: ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_4_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:3532:2: ( rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 )
            // InternalBXtendDSLParser.g:3532:3: rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterAssignment_1_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_1__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_1__1"
    // InternalBXtendDSLParser.g:3540:1: rule__ClassMatcherModifier__Group_1_4_1_1__1 : rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3544:1: ( rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl )
            // InternalBXtendDSLParser.g:3545:2: rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl"
    // InternalBXtendDSLParser.g:3551:1: rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3555:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3556:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3556:1: ( Comma )
            // InternalBXtendDSLParser.g:3557:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_1_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_2__0"
    // InternalBXtendDSLParser.g:3567:1: rule__ClassMatcherModifier__Group_1_4_1_2__0 : rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl rule__ClassMatcherModifier__Group_1_4_1_2__1 ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3571:1: ( rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl rule__ClassMatcherModifier__Group_1_4_1_2__1 )
            // InternalBXtendDSLParser.g:3572:2: rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl rule__ClassMatcherModifier__Group_1_4_1_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_2__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl"
    // InternalBXtendDSLParser.g:3579:1: rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl : ( ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3583:1: ( ( ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 ) ) )
            // InternalBXtendDSLParser.g:3584:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 ) )
            {
            // InternalBXtendDSLParser.g:3584:1: ( ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 ) )
            // InternalBXtendDSLParser.g:3585:2: ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_4_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:3586:2: ( rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 )
            // InternalBXtendDSLParser.g:3586:3: rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortAssignment_1_4_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_2__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_2__1"
    // InternalBXtendDSLParser.g:3594:1: rule__ClassMatcherModifier__Group_1_4_1_2__1 : rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3598:1: ( rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl )
            // InternalBXtendDSLParser.g:3599:2: rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_2__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl"
    // InternalBXtendDSLParser.g:3605:1: rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3609:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3610:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3610:1: ( Comma )
            // InternalBXtendDSLParser.g:3611:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_2_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_2__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_3__0"
    // InternalBXtendDSLParser.g:3621:1: rule__ClassMatcherModifier__Group_1_4_1_3__0 : rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl rule__ClassMatcherModifier__Group_1_4_1_3__1 ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3625:1: ( rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl rule__ClassMatcherModifier__Group_1_4_1_3__1 )
            // InternalBXtendDSLParser.g:3626:2: rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl rule__ClassMatcherModifier__Group_1_4_1_3__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_3__0"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl"
    // InternalBXtendDSLParser.g:3633:1: rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl : ( ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 ) ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3637:1: ( ( ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 ) ) )
            // InternalBXtendDSLParser.g:3638:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 ) )
            {
            // InternalBXtendDSLParser.g:3638:1: ( ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 ) )
            // InternalBXtendDSLParser.g:3639:2: ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_4_1_3_0()); 
            }
            // InternalBXtendDSLParser.g:3640:2: ( rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 )
            // InternalBXtendDSLParser.g:3640:3: rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationAssignment_1_4_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_3__0__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_3__1"
    // InternalBXtendDSLParser.g:3648:1: rule__ClassMatcherModifier__Group_1_4_1_3__1 : rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3652:1: ( rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl )
            // InternalBXtendDSLParser.g:3653:2: rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_3__1"


    // $ANTLR start "rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl"
    // InternalBXtendDSLParser.g:3659:1: rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl : ( Comma ) ;
    public final void rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3663:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3664:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3664:1: ( Comma )
            // InternalBXtendDSLParser.g:3665:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_3_1()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCommaKeyword_1_4_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__Group_1_4_1_3__1__Impl"


    // $ANTLR start "rule__FeatureMapping__Group__0"
    // InternalBXtendDSLParser.g:3675:1: rule__FeatureMapping__Group__0 : rule__FeatureMapping__Group__0__Impl rule__FeatureMapping__Group__1 ;
    public final void rule__FeatureMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3679:1: ( rule__FeatureMapping__Group__0__Impl rule__FeatureMapping__Group__1 )
            // InternalBXtendDSLParser.g:3680:2: rule__FeatureMapping__Group__0__Impl rule__FeatureMapping__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__FeatureMapping__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__0"


    // $ANTLR start "rule__FeatureMapping__Group__0__Impl"
    // InternalBXtendDSLParser.g:3687:1: rule__FeatureMapping__Group__0__Impl : ( ( ( rule__FeatureMapping__Alternatives_0 ) ) ( ( rule__FeatureMapping__Alternatives_0 )* ) ) ;
    public final void rule__FeatureMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3691:1: ( ( ( ( rule__FeatureMapping__Alternatives_0 ) ) ( ( rule__FeatureMapping__Alternatives_0 )* ) ) )
            // InternalBXtendDSLParser.g:3692:1: ( ( ( rule__FeatureMapping__Alternatives_0 ) ) ( ( rule__FeatureMapping__Alternatives_0 )* ) )
            {
            // InternalBXtendDSLParser.g:3692:1: ( ( ( rule__FeatureMapping__Alternatives_0 ) ) ( ( rule__FeatureMapping__Alternatives_0 )* ) )
            // InternalBXtendDSLParser.g:3693:2: ( ( rule__FeatureMapping__Alternatives_0 ) ) ( ( rule__FeatureMapping__Alternatives_0 )* )
            {
            // InternalBXtendDSLParser.g:3693:2: ( ( rule__FeatureMapping__Alternatives_0 ) )
            // InternalBXtendDSLParser.g:3694:3: ( rule__FeatureMapping__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getAlternatives_0()); 
            }
            // InternalBXtendDSLParser.g:3695:3: ( rule__FeatureMapping__Alternatives_0 )
            // InternalBXtendDSLParser.g:3695:4: rule__FeatureMapping__Alternatives_0
            {
            pushFollow(FOLLOW_18);
            rule__FeatureMapping__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getAlternatives_0()); 
            }

            }

            // InternalBXtendDSLParser.g:3698:2: ( ( rule__FeatureMapping__Alternatives_0 )* )
            // InternalBXtendDSLParser.g:3699:3: ( rule__FeatureMapping__Alternatives_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getAlternatives_0()); 
            }
            // InternalBXtendDSLParser.g:3700:3: ( rule__FeatureMapping__Alternatives_0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==LeftCurlyBracket||LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:3700:4: rule__FeatureMapping__Alternatives_0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__FeatureMapping__Alternatives_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getAlternatives_0()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__0__Impl"


    // $ANTLR start "rule__FeatureMapping__Group__1"
    // InternalBXtendDSLParser.g:3709:1: rule__FeatureMapping__Group__1 : rule__FeatureMapping__Group__1__Impl rule__FeatureMapping__Group__2 ;
    public final void rule__FeatureMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3713:1: ( rule__FeatureMapping__Group__1__Impl rule__FeatureMapping__Group__2 )
            // InternalBXtendDSLParser.g:3714:2: rule__FeatureMapping__Group__1__Impl rule__FeatureMapping__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__FeatureMapping__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__1"


    // $ANTLR start "rule__FeatureMapping__Group__1__Impl"
    // InternalBXtendDSLParser.g:3721:1: rule__FeatureMapping__Group__1__Impl : ( ( rule__FeatureMapping__DirectionAssignment_1 ) ) ;
    public final void rule__FeatureMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3725:1: ( ( ( rule__FeatureMapping__DirectionAssignment_1 ) ) )
            // InternalBXtendDSLParser.g:3726:1: ( ( rule__FeatureMapping__DirectionAssignment_1 ) )
            {
            // InternalBXtendDSLParser.g:3726:1: ( ( rule__FeatureMapping__DirectionAssignment_1 ) )
            // InternalBXtendDSLParser.g:3727:2: ( rule__FeatureMapping__DirectionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getDirectionAssignment_1()); 
            }
            // InternalBXtendDSLParser.g:3728:2: ( rule__FeatureMapping__DirectionAssignment_1 )
            // InternalBXtendDSLParser.g:3728:3: rule__FeatureMapping__DirectionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__DirectionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getDirectionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__1__Impl"


    // $ANTLR start "rule__FeatureMapping__Group__2"
    // InternalBXtendDSLParser.g:3736:1: rule__FeatureMapping__Group__2 : rule__FeatureMapping__Group__2__Impl rule__FeatureMapping__Group__3 ;
    public final void rule__FeatureMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3740:1: ( rule__FeatureMapping__Group__2__Impl rule__FeatureMapping__Group__3 )
            // InternalBXtendDSLParser.g:3741:2: rule__FeatureMapping__Group__2__Impl rule__FeatureMapping__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__FeatureMapping__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__2"


    // $ANTLR start "rule__FeatureMapping__Group__2__Impl"
    // InternalBXtendDSLParser.g:3748:1: rule__FeatureMapping__Group__2__Impl : ( ( ( rule__FeatureMapping__Alternatives_2 ) ) ( ( rule__FeatureMapping__Alternatives_2 )* ) ) ;
    public final void rule__FeatureMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3752:1: ( ( ( ( rule__FeatureMapping__Alternatives_2 ) ) ( ( rule__FeatureMapping__Alternatives_2 )* ) ) )
            // InternalBXtendDSLParser.g:3753:1: ( ( ( rule__FeatureMapping__Alternatives_2 ) ) ( ( rule__FeatureMapping__Alternatives_2 )* ) )
            {
            // InternalBXtendDSLParser.g:3753:1: ( ( ( rule__FeatureMapping__Alternatives_2 ) ) ( ( rule__FeatureMapping__Alternatives_2 )* ) )
            // InternalBXtendDSLParser.g:3754:2: ( ( rule__FeatureMapping__Alternatives_2 ) ) ( ( rule__FeatureMapping__Alternatives_2 )* )
            {
            // InternalBXtendDSLParser.g:3754:2: ( ( rule__FeatureMapping__Alternatives_2 ) )
            // InternalBXtendDSLParser.g:3755:3: ( rule__FeatureMapping__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getAlternatives_2()); 
            }
            // InternalBXtendDSLParser.g:3756:3: ( rule__FeatureMapping__Alternatives_2 )
            // InternalBXtendDSLParser.g:3756:4: rule__FeatureMapping__Alternatives_2
            {
            pushFollow(FOLLOW_18);
            rule__FeatureMapping__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getAlternatives_2()); 
            }

            }

            // InternalBXtendDSLParser.g:3759:2: ( ( rule__FeatureMapping__Alternatives_2 )* )
            // InternalBXtendDSLParser.g:3760:3: ( rule__FeatureMapping__Alternatives_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getAlternatives_2()); 
            }
            // InternalBXtendDSLParser.g:3761:3: ( rule__FeatureMapping__Alternatives_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==LeftCurlyBracket||LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:3761:4: rule__FeatureMapping__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__FeatureMapping__Alternatives_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getAlternatives_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__2__Impl"


    // $ANTLR start "rule__FeatureMapping__Group__3"
    // InternalBXtendDSLParser.g:3770:1: rule__FeatureMapping__Group__3 : rule__FeatureMapping__Group__3__Impl ;
    public final void rule__FeatureMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3774:1: ( rule__FeatureMapping__Group__3__Impl )
            // InternalBXtendDSLParser.g:3775:2: rule__FeatureMapping__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureMapping__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__3"


    // $ANTLR start "rule__FeatureMapping__Group__3__Impl"
    // InternalBXtendDSLParser.g:3781:1: rule__FeatureMapping__Group__3__Impl : ( Semicolon ) ;
    public final void rule__FeatureMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3785:1: ( ( Semicolon ) )
            // InternalBXtendDSLParser.g:3786:1: ( Semicolon )
            {
            // InternalBXtendDSLParser.g:3786:1: ( Semicolon )
            // InternalBXtendDSLParser.g:3787:2: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getSemicolonKeyword_3()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__Group__3__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__0"
    // InternalBXtendDSLParser.g:3797:1: rule__SrcMappingFeature__Group_1__0 : rule__SrcMappingFeature__Group_1__0__Impl rule__SrcMappingFeature__Group_1__1 ;
    public final void rule__SrcMappingFeature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3801:1: ( rule__SrcMappingFeature__Group_1__0__Impl rule__SrcMappingFeature__Group_1__1 )
            // InternalBXtendDSLParser.g:3802:2: rule__SrcMappingFeature__Group_1__0__Impl rule__SrcMappingFeature__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__SrcMappingFeature__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__0"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__0__Impl"
    // InternalBXtendDSLParser.g:3809:1: rule__SrcMappingFeature__Group_1__0__Impl : ( ( rule__SrcMappingFeature__CorrAssignment_1_0 ) ) ;
    public final void rule__SrcMappingFeature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3813:1: ( ( ( rule__SrcMappingFeature__CorrAssignment_1_0 ) ) )
            // InternalBXtendDSLParser.g:3814:1: ( ( rule__SrcMappingFeature__CorrAssignment_1_0 ) )
            {
            // InternalBXtendDSLParser.g:3814:1: ( ( rule__SrcMappingFeature__CorrAssignment_1_0 ) )
            // InternalBXtendDSLParser.g:3815:2: ( rule__SrcMappingFeature__CorrAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrAssignment_1_0()); 
            }
            // InternalBXtendDSLParser.g:3816:2: ( rule__SrcMappingFeature__CorrAssignment_1_0 )
            // InternalBXtendDSLParser.g:3816:3: rule__SrcMappingFeature__CorrAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__CorrAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__0__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__1"
    // InternalBXtendDSLParser.g:3824:1: rule__SrcMappingFeature__Group_1__1 : rule__SrcMappingFeature__Group_1__1__Impl rule__SrcMappingFeature__Group_1__2 ;
    public final void rule__SrcMappingFeature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3828:1: ( rule__SrcMappingFeature__Group_1__1__Impl rule__SrcMappingFeature__Group_1__2 )
            // InternalBXtendDSLParser.g:3829:2: rule__SrcMappingFeature__Group_1__1__Impl rule__SrcMappingFeature__Group_1__2
            {
            pushFollow(FOLLOW_34);
            rule__SrcMappingFeature__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__1"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__1__Impl"
    // InternalBXtendDSLParser.g:3836:1: rule__SrcMappingFeature__Group_1__1__Impl : ( ( rule__SrcMappingFeature__FeatureAssignment_1_1 ) ) ;
    public final void rule__SrcMappingFeature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3840:1: ( ( ( rule__SrcMappingFeature__FeatureAssignment_1_1 ) ) )
            // InternalBXtendDSLParser.g:3841:1: ( ( rule__SrcMappingFeature__FeatureAssignment_1_1 ) )
            {
            // InternalBXtendDSLParser.g:3841:1: ( ( rule__SrcMappingFeature__FeatureAssignment_1_1 ) )
            // InternalBXtendDSLParser.g:3842:2: ( rule__SrcMappingFeature__FeatureAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getFeatureAssignment_1_1()); 
            }
            // InternalBXtendDSLParser.g:3843:2: ( rule__SrcMappingFeature__FeatureAssignment_1_1 )
            // InternalBXtendDSLParser.g:3843:3: rule__SrcMappingFeature__FeatureAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__FeatureAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getFeatureAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__1__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__2"
    // InternalBXtendDSLParser.g:3851:1: rule__SrcMappingFeature__Group_1__2 : rule__SrcMappingFeature__Group_1__2__Impl rule__SrcMappingFeature__Group_1__3 ;
    public final void rule__SrcMappingFeature__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3855:1: ( rule__SrcMappingFeature__Group_1__2__Impl rule__SrcMappingFeature__Group_1__3 )
            // InternalBXtendDSLParser.g:3856:2: rule__SrcMappingFeature__Group_1__2__Impl rule__SrcMappingFeature__Group_1__3
            {
            pushFollow(FOLLOW_12);
            rule__SrcMappingFeature__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__2"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__2__Impl"
    // InternalBXtendDSLParser.g:3863:1: rule__SrcMappingFeature__Group_1__2__Impl : ( Colon ) ;
    public final void rule__SrcMappingFeature__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3867:1: ( ( Colon ) )
            // InternalBXtendDSLParser.g:3868:1: ( Colon )
            {
            // InternalBXtendDSLParser.g:3868:1: ( Colon )
            // InternalBXtendDSLParser.g:3869:2: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getColonKeyword_1_2()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getColonKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__2__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__3"
    // InternalBXtendDSLParser.g:3878:1: rule__SrcMappingFeature__Group_1__3 : rule__SrcMappingFeature__Group_1__3__Impl rule__SrcMappingFeature__Group_1__4 ;
    public final void rule__SrcMappingFeature__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3882:1: ( rule__SrcMappingFeature__Group_1__3__Impl rule__SrcMappingFeature__Group_1__4 )
            // InternalBXtendDSLParser.g:3883:2: rule__SrcMappingFeature__Group_1__3__Impl rule__SrcMappingFeature__Group_1__4
            {
            pushFollow(FOLLOW_35);
            rule__SrcMappingFeature__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__3"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__3__Impl"
    // InternalBXtendDSLParser.g:3890:1: rule__SrcMappingFeature__Group_1__3__Impl : ( ( rule__SrcMappingFeature__CorrsAssignment_1_3 ) ) ;
    public final void rule__SrcMappingFeature__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3894:1: ( ( ( rule__SrcMappingFeature__CorrsAssignment_1_3 ) ) )
            // InternalBXtendDSLParser.g:3895:1: ( ( rule__SrcMappingFeature__CorrsAssignment_1_3 ) )
            {
            // InternalBXtendDSLParser.g:3895:1: ( ( rule__SrcMappingFeature__CorrsAssignment_1_3 ) )
            // InternalBXtendDSLParser.g:3896:2: ( rule__SrcMappingFeature__CorrsAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrsAssignment_1_3()); 
            }
            // InternalBXtendDSLParser.g:3897:2: ( rule__SrcMappingFeature__CorrsAssignment_1_3 )
            // InternalBXtendDSLParser.g:3897:3: rule__SrcMappingFeature__CorrsAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__CorrsAssignment_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrsAssignment_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__3__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__4"
    // InternalBXtendDSLParser.g:3905:1: rule__SrcMappingFeature__Group_1__4 : rule__SrcMappingFeature__Group_1__4__Impl rule__SrcMappingFeature__Group_1__5 ;
    public final void rule__SrcMappingFeature__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3909:1: ( rule__SrcMappingFeature__Group_1__4__Impl rule__SrcMappingFeature__Group_1__5 )
            // InternalBXtendDSLParser.g:3910:2: rule__SrcMappingFeature__Group_1__4__Impl rule__SrcMappingFeature__Group_1__5
            {
            pushFollow(FOLLOW_35);
            rule__SrcMappingFeature__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__4"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__4__Impl"
    // InternalBXtendDSLParser.g:3917:1: rule__SrcMappingFeature__Group_1__4__Impl : ( ( rule__SrcMappingFeature__Group_1_4__0 )* ) ;
    public final void rule__SrcMappingFeature__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3921:1: ( ( ( rule__SrcMappingFeature__Group_1_4__0 )* ) )
            // InternalBXtendDSLParser.g:3922:1: ( ( rule__SrcMappingFeature__Group_1_4__0 )* )
            {
            // InternalBXtendDSLParser.g:3922:1: ( ( rule__SrcMappingFeature__Group_1_4__0 )* )
            // InternalBXtendDSLParser.g:3923:2: ( rule__SrcMappingFeature__Group_1_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getGroup_1_4()); 
            }
            // InternalBXtendDSLParser.g:3924:2: ( rule__SrcMappingFeature__Group_1_4__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Comma) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:3924:3: rule__SrcMappingFeature__Group_1_4__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__SrcMappingFeature__Group_1_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getGroup_1_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__4__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__5"
    // InternalBXtendDSLParser.g:3932:1: rule__SrcMappingFeature__Group_1__5 : rule__SrcMappingFeature__Group_1__5__Impl ;
    public final void rule__SrcMappingFeature__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3936:1: ( rule__SrcMappingFeature__Group_1__5__Impl )
            // InternalBXtendDSLParser.g:3937:2: rule__SrcMappingFeature__Group_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__5"


    // $ANTLR start "rule__SrcMappingFeature__Group_1__5__Impl"
    // InternalBXtendDSLParser.g:3943:1: rule__SrcMappingFeature__Group_1__5__Impl : ( RightCurlyBracket ) ;
    public final void rule__SrcMappingFeature__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3947:1: ( ( RightCurlyBracket ) )
            // InternalBXtendDSLParser.g:3948:1: ( RightCurlyBracket )
            {
            // InternalBXtendDSLParser.g:3948:1: ( RightCurlyBracket )
            // InternalBXtendDSLParser.g:3949:2: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getRightCurlyBracketKeyword_1_5()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getRightCurlyBracketKeyword_1_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1__5__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1_4__0"
    // InternalBXtendDSLParser.g:3959:1: rule__SrcMappingFeature__Group_1_4__0 : rule__SrcMappingFeature__Group_1_4__0__Impl rule__SrcMappingFeature__Group_1_4__1 ;
    public final void rule__SrcMappingFeature__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3963:1: ( rule__SrcMappingFeature__Group_1_4__0__Impl rule__SrcMappingFeature__Group_1_4__1 )
            // InternalBXtendDSLParser.g:3964:2: rule__SrcMappingFeature__Group_1_4__0__Impl rule__SrcMappingFeature__Group_1_4__1
            {
            pushFollow(FOLLOW_12);
            rule__SrcMappingFeature__Group_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1_4__0"


    // $ANTLR start "rule__SrcMappingFeature__Group_1_4__0__Impl"
    // InternalBXtendDSLParser.g:3971:1: rule__SrcMappingFeature__Group_1_4__0__Impl : ( Comma ) ;
    public final void rule__SrcMappingFeature__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3975:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:3976:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:3976:1: ( Comma )
            // InternalBXtendDSLParser.g:3977:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCommaKeyword_1_4_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCommaKeyword_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1_4__0__Impl"


    // $ANTLR start "rule__SrcMappingFeature__Group_1_4__1"
    // InternalBXtendDSLParser.g:3986:1: rule__SrcMappingFeature__Group_1_4__1 : rule__SrcMappingFeature__Group_1_4__1__Impl ;
    public final void rule__SrcMappingFeature__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:3990:1: ( rule__SrcMappingFeature__Group_1_4__1__Impl )
            // InternalBXtendDSLParser.g:3991:2: rule__SrcMappingFeature__Group_1_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__Group_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1_4__1"


    // $ANTLR start "rule__SrcMappingFeature__Group_1_4__1__Impl"
    // InternalBXtendDSLParser.g:3997:1: rule__SrcMappingFeature__Group_1_4__1__Impl : ( ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 ) ) ;
    public final void rule__SrcMappingFeature__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4001:1: ( ( ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 ) ) )
            // InternalBXtendDSLParser.g:4002:1: ( ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 ) )
            {
            // InternalBXtendDSLParser.g:4002:1: ( ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 ) )
            // InternalBXtendDSLParser.g:4003:2: ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrsAssignment_1_4_1()); 
            }
            // InternalBXtendDSLParser.g:4004:2: ( rule__SrcMappingFeature__CorrsAssignment_1_4_1 )
            // InternalBXtendDSLParser.g:4004:3: rule__SrcMappingFeature__CorrsAssignment_1_4_1
            {
            pushFollow(FOLLOW_2);
            rule__SrcMappingFeature__CorrsAssignment_1_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrsAssignment_1_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__Group_1_4__1__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__0"
    // InternalBXtendDSLParser.g:4013:1: rule__TrgMappingFeature__Group_1__0 : rule__TrgMappingFeature__Group_1__0__Impl rule__TrgMappingFeature__Group_1__1 ;
    public final void rule__TrgMappingFeature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4017:1: ( rule__TrgMappingFeature__Group_1__0__Impl rule__TrgMappingFeature__Group_1__1 )
            // InternalBXtendDSLParser.g:4018:2: rule__TrgMappingFeature__Group_1__0__Impl rule__TrgMappingFeature__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__TrgMappingFeature__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__0"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__0__Impl"
    // InternalBXtendDSLParser.g:4025:1: rule__TrgMappingFeature__Group_1__0__Impl : ( ( rule__TrgMappingFeature__CorrAssignment_1_0 ) ) ;
    public final void rule__TrgMappingFeature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4029:1: ( ( ( rule__TrgMappingFeature__CorrAssignment_1_0 ) ) )
            // InternalBXtendDSLParser.g:4030:1: ( ( rule__TrgMappingFeature__CorrAssignment_1_0 ) )
            {
            // InternalBXtendDSLParser.g:4030:1: ( ( rule__TrgMappingFeature__CorrAssignment_1_0 ) )
            // InternalBXtendDSLParser.g:4031:2: ( rule__TrgMappingFeature__CorrAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrAssignment_1_0()); 
            }
            // InternalBXtendDSLParser.g:4032:2: ( rule__TrgMappingFeature__CorrAssignment_1_0 )
            // InternalBXtendDSLParser.g:4032:3: rule__TrgMappingFeature__CorrAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__CorrAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__0__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__1"
    // InternalBXtendDSLParser.g:4040:1: rule__TrgMappingFeature__Group_1__1 : rule__TrgMappingFeature__Group_1__1__Impl rule__TrgMappingFeature__Group_1__2 ;
    public final void rule__TrgMappingFeature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4044:1: ( rule__TrgMappingFeature__Group_1__1__Impl rule__TrgMappingFeature__Group_1__2 )
            // InternalBXtendDSLParser.g:4045:2: rule__TrgMappingFeature__Group_1__1__Impl rule__TrgMappingFeature__Group_1__2
            {
            pushFollow(FOLLOW_34);
            rule__TrgMappingFeature__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__1"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__1__Impl"
    // InternalBXtendDSLParser.g:4052:1: rule__TrgMappingFeature__Group_1__1__Impl : ( ( rule__TrgMappingFeature__FeatureAssignment_1_1 ) ) ;
    public final void rule__TrgMappingFeature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4056:1: ( ( ( rule__TrgMappingFeature__FeatureAssignment_1_1 ) ) )
            // InternalBXtendDSLParser.g:4057:1: ( ( rule__TrgMappingFeature__FeatureAssignment_1_1 ) )
            {
            // InternalBXtendDSLParser.g:4057:1: ( ( rule__TrgMappingFeature__FeatureAssignment_1_1 ) )
            // InternalBXtendDSLParser.g:4058:2: ( rule__TrgMappingFeature__FeatureAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getFeatureAssignment_1_1()); 
            }
            // InternalBXtendDSLParser.g:4059:2: ( rule__TrgMappingFeature__FeatureAssignment_1_1 )
            // InternalBXtendDSLParser.g:4059:3: rule__TrgMappingFeature__FeatureAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__FeatureAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getFeatureAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__1__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__2"
    // InternalBXtendDSLParser.g:4067:1: rule__TrgMappingFeature__Group_1__2 : rule__TrgMappingFeature__Group_1__2__Impl rule__TrgMappingFeature__Group_1__3 ;
    public final void rule__TrgMappingFeature__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4071:1: ( rule__TrgMappingFeature__Group_1__2__Impl rule__TrgMappingFeature__Group_1__3 )
            // InternalBXtendDSLParser.g:4072:2: rule__TrgMappingFeature__Group_1__2__Impl rule__TrgMappingFeature__Group_1__3
            {
            pushFollow(FOLLOW_12);
            rule__TrgMappingFeature__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__2"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__2__Impl"
    // InternalBXtendDSLParser.g:4079:1: rule__TrgMappingFeature__Group_1__2__Impl : ( Colon ) ;
    public final void rule__TrgMappingFeature__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4083:1: ( ( Colon ) )
            // InternalBXtendDSLParser.g:4084:1: ( Colon )
            {
            // InternalBXtendDSLParser.g:4084:1: ( Colon )
            // InternalBXtendDSLParser.g:4085:2: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getColonKeyword_1_2()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getColonKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__2__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__3"
    // InternalBXtendDSLParser.g:4094:1: rule__TrgMappingFeature__Group_1__3 : rule__TrgMappingFeature__Group_1__3__Impl rule__TrgMappingFeature__Group_1__4 ;
    public final void rule__TrgMappingFeature__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4098:1: ( rule__TrgMappingFeature__Group_1__3__Impl rule__TrgMappingFeature__Group_1__4 )
            // InternalBXtendDSLParser.g:4099:2: rule__TrgMappingFeature__Group_1__3__Impl rule__TrgMappingFeature__Group_1__4
            {
            pushFollow(FOLLOW_35);
            rule__TrgMappingFeature__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__3"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__3__Impl"
    // InternalBXtendDSLParser.g:4106:1: rule__TrgMappingFeature__Group_1__3__Impl : ( ( rule__TrgMappingFeature__CorrsAssignment_1_3 ) ) ;
    public final void rule__TrgMappingFeature__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4110:1: ( ( ( rule__TrgMappingFeature__CorrsAssignment_1_3 ) ) )
            // InternalBXtendDSLParser.g:4111:1: ( ( rule__TrgMappingFeature__CorrsAssignment_1_3 ) )
            {
            // InternalBXtendDSLParser.g:4111:1: ( ( rule__TrgMappingFeature__CorrsAssignment_1_3 ) )
            // InternalBXtendDSLParser.g:4112:2: ( rule__TrgMappingFeature__CorrsAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrsAssignment_1_3()); 
            }
            // InternalBXtendDSLParser.g:4113:2: ( rule__TrgMappingFeature__CorrsAssignment_1_3 )
            // InternalBXtendDSLParser.g:4113:3: rule__TrgMappingFeature__CorrsAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__CorrsAssignment_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrsAssignment_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__3__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__4"
    // InternalBXtendDSLParser.g:4121:1: rule__TrgMappingFeature__Group_1__4 : rule__TrgMappingFeature__Group_1__4__Impl rule__TrgMappingFeature__Group_1__5 ;
    public final void rule__TrgMappingFeature__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4125:1: ( rule__TrgMappingFeature__Group_1__4__Impl rule__TrgMappingFeature__Group_1__5 )
            // InternalBXtendDSLParser.g:4126:2: rule__TrgMappingFeature__Group_1__4__Impl rule__TrgMappingFeature__Group_1__5
            {
            pushFollow(FOLLOW_35);
            rule__TrgMappingFeature__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__4"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__4__Impl"
    // InternalBXtendDSLParser.g:4133:1: rule__TrgMappingFeature__Group_1__4__Impl : ( ( rule__TrgMappingFeature__Group_1_4__0 )* ) ;
    public final void rule__TrgMappingFeature__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4137:1: ( ( ( rule__TrgMappingFeature__Group_1_4__0 )* ) )
            // InternalBXtendDSLParser.g:4138:1: ( ( rule__TrgMappingFeature__Group_1_4__0 )* )
            {
            // InternalBXtendDSLParser.g:4138:1: ( ( rule__TrgMappingFeature__Group_1_4__0 )* )
            // InternalBXtendDSLParser.g:4139:2: ( rule__TrgMappingFeature__Group_1_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getGroup_1_4()); 
            }
            // InternalBXtendDSLParser.g:4140:2: ( rule__TrgMappingFeature__Group_1_4__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Comma) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:4140:3: rule__TrgMappingFeature__Group_1_4__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__TrgMappingFeature__Group_1_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getGroup_1_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__4__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__5"
    // InternalBXtendDSLParser.g:4148:1: rule__TrgMappingFeature__Group_1__5 : rule__TrgMappingFeature__Group_1__5__Impl ;
    public final void rule__TrgMappingFeature__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4152:1: ( rule__TrgMappingFeature__Group_1__5__Impl )
            // InternalBXtendDSLParser.g:4153:2: rule__TrgMappingFeature__Group_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__5"


    // $ANTLR start "rule__TrgMappingFeature__Group_1__5__Impl"
    // InternalBXtendDSLParser.g:4159:1: rule__TrgMappingFeature__Group_1__5__Impl : ( RightCurlyBracket ) ;
    public final void rule__TrgMappingFeature__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4163:1: ( ( RightCurlyBracket ) )
            // InternalBXtendDSLParser.g:4164:1: ( RightCurlyBracket )
            {
            // InternalBXtendDSLParser.g:4164:1: ( RightCurlyBracket )
            // InternalBXtendDSLParser.g:4165:2: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getRightCurlyBracketKeyword_1_5()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getRightCurlyBracketKeyword_1_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1__5__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1_4__0"
    // InternalBXtendDSLParser.g:4175:1: rule__TrgMappingFeature__Group_1_4__0 : rule__TrgMappingFeature__Group_1_4__0__Impl rule__TrgMappingFeature__Group_1_4__1 ;
    public final void rule__TrgMappingFeature__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4179:1: ( rule__TrgMappingFeature__Group_1_4__0__Impl rule__TrgMappingFeature__Group_1_4__1 )
            // InternalBXtendDSLParser.g:4180:2: rule__TrgMappingFeature__Group_1_4__0__Impl rule__TrgMappingFeature__Group_1_4__1
            {
            pushFollow(FOLLOW_12);
            rule__TrgMappingFeature__Group_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1_4__0"


    // $ANTLR start "rule__TrgMappingFeature__Group_1_4__0__Impl"
    // InternalBXtendDSLParser.g:4187:1: rule__TrgMappingFeature__Group_1_4__0__Impl : ( Comma ) ;
    public final void rule__TrgMappingFeature__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4191:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:4192:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:4192:1: ( Comma )
            // InternalBXtendDSLParser.g:4193:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCommaKeyword_1_4_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCommaKeyword_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1_4__0__Impl"


    // $ANTLR start "rule__TrgMappingFeature__Group_1_4__1"
    // InternalBXtendDSLParser.g:4202:1: rule__TrgMappingFeature__Group_1_4__1 : rule__TrgMappingFeature__Group_1_4__1__Impl ;
    public final void rule__TrgMappingFeature__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4206:1: ( rule__TrgMappingFeature__Group_1_4__1__Impl )
            // InternalBXtendDSLParser.g:4207:2: rule__TrgMappingFeature__Group_1_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__Group_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1_4__1"


    // $ANTLR start "rule__TrgMappingFeature__Group_1_4__1__Impl"
    // InternalBXtendDSLParser.g:4213:1: rule__TrgMappingFeature__Group_1_4__1__Impl : ( ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 ) ) ;
    public final void rule__TrgMappingFeature__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4217:1: ( ( ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 ) ) )
            // InternalBXtendDSLParser.g:4218:1: ( ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 ) )
            {
            // InternalBXtendDSLParser.g:4218:1: ( ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 ) )
            // InternalBXtendDSLParser.g:4219:2: ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrsAssignment_1_4_1()); 
            }
            // InternalBXtendDSLParser.g:4220:2: ( rule__TrgMappingFeature__CorrsAssignment_1_4_1 )
            // InternalBXtendDSLParser.g:4220:3: rule__TrgMappingFeature__CorrsAssignment_1_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TrgMappingFeature__CorrsAssignment_1_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrsAssignment_1_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__Group_1_4__1__Impl"


    // $ANTLR start "rule__Correspondence__Group__0"
    // InternalBXtendDSLParser.g:4229:1: rule__Correspondence__Group__0 : rule__Correspondence__Group__0__Impl rule__Correspondence__Group__1 ;
    public final void rule__Correspondence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4233:1: ( rule__Correspondence__Group__0__Impl rule__Correspondence__Group__1 )
            // InternalBXtendDSLParser.g:4234:2: rule__Correspondence__Group__0__Impl rule__Correspondence__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__Correspondence__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group__0"


    // $ANTLR start "rule__Correspondence__Group__0__Impl"
    // InternalBXtendDSLParser.g:4241:1: rule__Correspondence__Group__0__Impl : ( ( rule__Correspondence__RuleAssignment_0 ) ) ;
    public final void rule__Correspondence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4245:1: ( ( ( rule__Correspondence__RuleAssignment_0 ) ) )
            // InternalBXtendDSLParser.g:4246:1: ( ( rule__Correspondence__RuleAssignment_0 ) )
            {
            // InternalBXtendDSLParser.g:4246:1: ( ( rule__Correspondence__RuleAssignment_0 ) )
            // InternalBXtendDSLParser.g:4247:2: ( rule__Correspondence__RuleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getRuleAssignment_0()); 
            }
            // InternalBXtendDSLParser.g:4248:2: ( rule__Correspondence__RuleAssignment_0 )
            // InternalBXtendDSLParser.g:4248:3: rule__Correspondence__RuleAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__RuleAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getRuleAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group__0__Impl"


    // $ANTLR start "rule__Correspondence__Group__1"
    // InternalBXtendDSLParser.g:4256:1: rule__Correspondence__Group__1 : rule__Correspondence__Group__1__Impl ;
    public final void rule__Correspondence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4260:1: ( rule__Correspondence__Group__1__Impl )
            // InternalBXtendDSLParser.g:4261:2: rule__Correspondence__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group__1"


    // $ANTLR start "rule__Correspondence__Group__1__Impl"
    // InternalBXtendDSLParser.g:4267:1: rule__Correspondence__Group__1__Impl : ( ( rule__Correspondence__Group_1__0 )? ) ;
    public final void rule__Correspondence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4271:1: ( ( ( rule__Correspondence__Group_1__0 )? ) )
            // InternalBXtendDSLParser.g:4272:1: ( ( rule__Correspondence__Group_1__0 )? )
            {
            // InternalBXtendDSLParser.g:4272:1: ( ( rule__Correspondence__Group_1__0 )? )
            // InternalBXtendDSLParser.g:4273:2: ( rule__Correspondence__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getGroup_1()); 
            }
            // InternalBXtendDSLParser.g:4274:2: ( rule__Correspondence__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LeftSquareBracket) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBXtendDSLParser.g:4274:3: rule__Correspondence__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Correspondence__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group__1__Impl"


    // $ANTLR start "rule__Correspondence__Group_1__0"
    // InternalBXtendDSLParser.g:4283:1: rule__Correspondence__Group_1__0 : rule__Correspondence__Group_1__0__Impl rule__Correspondence__Group_1__1 ;
    public final void rule__Correspondence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4287:1: ( rule__Correspondence__Group_1__0__Impl rule__Correspondence__Group_1__1 )
            // InternalBXtendDSLParser.g:4288:2: rule__Correspondence__Group_1__0__Impl rule__Correspondence__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Correspondence__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__0"


    // $ANTLR start "rule__Correspondence__Group_1__0__Impl"
    // InternalBXtendDSLParser.g:4295:1: rule__Correspondence__Group_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__Correspondence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4299:1: ( ( LeftSquareBracket ) )
            // InternalBXtendDSLParser.g:4300:1: ( LeftSquareBracket )
            {
            // InternalBXtendDSLParser.g:4300:1: ( LeftSquareBracket )
            // InternalBXtendDSLParser.g:4301:2: LeftSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getLeftSquareBracketKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__0__Impl"


    // $ANTLR start "rule__Correspondence__Group_1__1"
    // InternalBXtendDSLParser.g:4310:1: rule__Correspondence__Group_1__1 : rule__Correspondence__Group_1__1__Impl rule__Correspondence__Group_1__2 ;
    public final void rule__Correspondence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4314:1: ( rule__Correspondence__Group_1__1__Impl rule__Correspondence__Group_1__2 )
            // InternalBXtendDSLParser.g:4315:2: rule__Correspondence__Group_1__1__Impl rule__Correspondence__Group_1__2
            {
            pushFollow(FOLLOW_38);
            rule__Correspondence__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__1"


    // $ANTLR start "rule__Correspondence__Group_1__1__Impl"
    // InternalBXtendDSLParser.g:4322:1: rule__Correspondence__Group_1__1__Impl : ( ( rule__Correspondence__MatchersAssignment_1_1 ) ) ;
    public final void rule__Correspondence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4326:1: ( ( ( rule__Correspondence__MatchersAssignment_1_1 ) ) )
            // InternalBXtendDSLParser.g:4327:1: ( ( rule__Correspondence__MatchersAssignment_1_1 ) )
            {
            // InternalBXtendDSLParser.g:4327:1: ( ( rule__Correspondence__MatchersAssignment_1_1 ) )
            // InternalBXtendDSLParser.g:4328:2: ( rule__Correspondence__MatchersAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersAssignment_1_1()); 
            }
            // InternalBXtendDSLParser.g:4329:2: ( rule__Correspondence__MatchersAssignment_1_1 )
            // InternalBXtendDSLParser.g:4329:3: rule__Correspondence__MatchersAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__MatchersAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__1__Impl"


    // $ANTLR start "rule__Correspondence__Group_1__2"
    // InternalBXtendDSLParser.g:4337:1: rule__Correspondence__Group_1__2 : rule__Correspondence__Group_1__2__Impl rule__Correspondence__Group_1__3 ;
    public final void rule__Correspondence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4341:1: ( rule__Correspondence__Group_1__2__Impl rule__Correspondence__Group_1__3 )
            // InternalBXtendDSLParser.g:4342:2: rule__Correspondence__Group_1__2__Impl rule__Correspondence__Group_1__3
            {
            pushFollow(FOLLOW_38);
            rule__Correspondence__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__2"


    // $ANTLR start "rule__Correspondence__Group_1__2__Impl"
    // InternalBXtendDSLParser.g:4349:1: rule__Correspondence__Group_1__2__Impl : ( ( rule__Correspondence__Group_1_2__0 )* ) ;
    public final void rule__Correspondence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4353:1: ( ( ( rule__Correspondence__Group_1_2__0 )* ) )
            // InternalBXtendDSLParser.g:4354:1: ( ( rule__Correspondence__Group_1_2__0 )* )
            {
            // InternalBXtendDSLParser.g:4354:1: ( ( rule__Correspondence__Group_1_2__0 )* )
            // InternalBXtendDSLParser.g:4355:2: ( rule__Correspondence__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getGroup_1_2()); 
            }
            // InternalBXtendDSLParser.g:4356:2: ( rule__Correspondence__Group_1_2__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Comma) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:4356:3: rule__Correspondence__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__Correspondence__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getGroup_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__2__Impl"


    // $ANTLR start "rule__Correspondence__Group_1__3"
    // InternalBXtendDSLParser.g:4364:1: rule__Correspondence__Group_1__3 : rule__Correspondence__Group_1__3__Impl ;
    public final void rule__Correspondence__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4368:1: ( rule__Correspondence__Group_1__3__Impl )
            // InternalBXtendDSLParser.g:4369:2: rule__Correspondence__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__3"


    // $ANTLR start "rule__Correspondence__Group_1__3__Impl"
    // InternalBXtendDSLParser.g:4375:1: rule__Correspondence__Group_1__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Correspondence__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4379:1: ( ( RightSquareBracket ) )
            // InternalBXtendDSLParser.g:4380:1: ( RightSquareBracket )
            {
            // InternalBXtendDSLParser.g:4380:1: ( RightSquareBracket )
            // InternalBXtendDSLParser.g:4381:2: RightSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getRightSquareBracketKeyword_1_3()); 
            }
            match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getRightSquareBracketKeyword_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1__3__Impl"


    // $ANTLR start "rule__Correspondence__Group_1_2__0"
    // InternalBXtendDSLParser.g:4391:1: rule__Correspondence__Group_1_2__0 : rule__Correspondence__Group_1_2__0__Impl rule__Correspondence__Group_1_2__1 ;
    public final void rule__Correspondence__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4395:1: ( rule__Correspondence__Group_1_2__0__Impl rule__Correspondence__Group_1_2__1 )
            // InternalBXtendDSLParser.g:4396:2: rule__Correspondence__Group_1_2__0__Impl rule__Correspondence__Group_1_2__1
            {
            pushFollow(FOLLOW_12);
            rule__Correspondence__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1_2__0"


    // $ANTLR start "rule__Correspondence__Group_1_2__0__Impl"
    // InternalBXtendDSLParser.g:4403:1: rule__Correspondence__Group_1_2__0__Impl : ( Comma ) ;
    public final void rule__Correspondence__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4407:1: ( ( Comma ) )
            // InternalBXtendDSLParser.g:4408:1: ( Comma )
            {
            // InternalBXtendDSLParser.g:4408:1: ( Comma )
            // InternalBXtendDSLParser.g:4409:2: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getCommaKeyword_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1_2__0__Impl"


    // $ANTLR start "rule__Correspondence__Group_1_2__1"
    // InternalBXtendDSLParser.g:4418:1: rule__Correspondence__Group_1_2__1 : rule__Correspondence__Group_1_2__1__Impl ;
    public final void rule__Correspondence__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4422:1: ( rule__Correspondence__Group_1_2__1__Impl )
            // InternalBXtendDSLParser.g:4423:2: rule__Correspondence__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1_2__1"


    // $ANTLR start "rule__Correspondence__Group_1_2__1__Impl"
    // InternalBXtendDSLParser.g:4429:1: rule__Correspondence__Group_1_2__1__Impl : ( ( rule__Correspondence__MatchersAssignment_1_2_1 ) ) ;
    public final void rule__Correspondence__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4433:1: ( ( ( rule__Correspondence__MatchersAssignment_1_2_1 ) ) )
            // InternalBXtendDSLParser.g:4434:1: ( ( rule__Correspondence__MatchersAssignment_1_2_1 ) )
            {
            // InternalBXtendDSLParser.g:4434:1: ( ( rule__Correspondence__MatchersAssignment_1_2_1 ) )
            // InternalBXtendDSLParser.g:4435:2: ( rule__Correspondence__MatchersAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersAssignment_1_2_1()); 
            }
            // InternalBXtendDSLParser.g:4436:2: ( rule__Correspondence__MatchersAssignment_1_2_1 )
            // InternalBXtendDSLParser.g:4436:3: rule__Correspondence__MatchersAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Correspondence__MatchersAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersAssignment_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__Group_1_2__1__Impl"


    // $ANTLR start "rule__FeatureAccess__Group__0"
    // InternalBXtendDSLParser.g:4445:1: rule__FeatureAccess__Group__0 : rule__FeatureAccess__Group__0__Impl rule__FeatureAccess__Group__1 ;
    public final void rule__FeatureAccess__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4449:1: ( rule__FeatureAccess__Group__0__Impl rule__FeatureAccess__Group__1 )
            // InternalBXtendDSLParser.g:4450:2: rule__FeatureAccess__Group__0__Impl rule__FeatureAccess__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__FeatureAccess__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureAccess__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group__0"


    // $ANTLR start "rule__FeatureAccess__Group__0__Impl"
    // InternalBXtendDSLParser.g:4457:1: rule__FeatureAccess__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FeatureAccess__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4461:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:4462:1: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:4462:1: ( RULE_ID )
            // InternalBXtendDSLParser.g:4463:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group__0__Impl"


    // $ANTLR start "rule__FeatureAccess__Group__1"
    // InternalBXtendDSLParser.g:4472:1: rule__FeatureAccess__Group__1 : rule__FeatureAccess__Group__1__Impl ;
    public final void rule__FeatureAccess__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4476:1: ( rule__FeatureAccess__Group__1__Impl )
            // InternalBXtendDSLParser.g:4477:2: rule__FeatureAccess__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureAccess__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group__1"


    // $ANTLR start "rule__FeatureAccess__Group__1__Impl"
    // InternalBXtendDSLParser.g:4483:1: rule__FeatureAccess__Group__1__Impl : ( ( ( rule__FeatureAccess__Group_1__0 ) ) ( ( rule__FeatureAccess__Group_1__0 )* ) ) ;
    public final void rule__FeatureAccess__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4487:1: ( ( ( ( rule__FeatureAccess__Group_1__0 ) ) ( ( rule__FeatureAccess__Group_1__0 )* ) ) )
            // InternalBXtendDSLParser.g:4488:1: ( ( ( rule__FeatureAccess__Group_1__0 ) ) ( ( rule__FeatureAccess__Group_1__0 )* ) )
            {
            // InternalBXtendDSLParser.g:4488:1: ( ( ( rule__FeatureAccess__Group_1__0 ) ) ( ( rule__FeatureAccess__Group_1__0 )* ) )
            // InternalBXtendDSLParser.g:4489:2: ( ( rule__FeatureAccess__Group_1__0 ) ) ( ( rule__FeatureAccess__Group_1__0 )* )
            {
            // InternalBXtendDSLParser.g:4489:2: ( ( rule__FeatureAccess__Group_1__0 ) )
            // InternalBXtendDSLParser.g:4490:3: ( rule__FeatureAccess__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getGroup_1()); 
            }
            // InternalBXtendDSLParser.g:4491:3: ( rule__FeatureAccess__Group_1__0 )
            // InternalBXtendDSLParser.g:4491:4: rule__FeatureAccess__Group_1__0
            {
            pushFollow(FOLLOW_40);
            rule__FeatureAccess__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getGroup_1()); 
            }

            }

            // InternalBXtendDSLParser.g:4494:2: ( ( rule__FeatureAccess__Group_1__0 )* )
            // InternalBXtendDSLParser.g:4495:3: ( rule__FeatureAccess__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getGroup_1()); 
            }
            // InternalBXtendDSLParser.g:4496:3: ( rule__FeatureAccess__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==FullStop) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBXtendDSLParser.g:4496:4: rule__FeatureAccess__Group_1__0
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__FeatureAccess__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getGroup_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group__1__Impl"


    // $ANTLR start "rule__FeatureAccess__Group_1__0"
    // InternalBXtendDSLParser.g:4506:1: rule__FeatureAccess__Group_1__0 : rule__FeatureAccess__Group_1__0__Impl rule__FeatureAccess__Group_1__1 ;
    public final void rule__FeatureAccess__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4510:1: ( rule__FeatureAccess__Group_1__0__Impl rule__FeatureAccess__Group_1__1 )
            // InternalBXtendDSLParser.g:4511:2: rule__FeatureAccess__Group_1__0__Impl rule__FeatureAccess__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__FeatureAccess__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureAccess__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group_1__0"


    // $ANTLR start "rule__FeatureAccess__Group_1__0__Impl"
    // InternalBXtendDSLParser.g:4518:1: rule__FeatureAccess__Group_1__0__Impl : ( ( FullStop ) ) ;
    public final void rule__FeatureAccess__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4522:1: ( ( ( FullStop ) ) )
            // InternalBXtendDSLParser.g:4523:1: ( ( FullStop ) )
            {
            // InternalBXtendDSLParser.g:4523:1: ( ( FullStop ) )
            // InternalBXtendDSLParser.g:4524:2: ( FullStop )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getFullStopKeyword_1_0()); 
            }
            // InternalBXtendDSLParser.g:4525:2: ( FullStop )
            // InternalBXtendDSLParser.g:4525:3: FullStop
            {
            match(input,FullStop,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group_1__0__Impl"


    // $ANTLR start "rule__FeatureAccess__Group_1__1"
    // InternalBXtendDSLParser.g:4533:1: rule__FeatureAccess__Group_1__1 : rule__FeatureAccess__Group_1__1__Impl ;
    public final void rule__FeatureAccess__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4537:1: ( rule__FeatureAccess__Group_1__1__Impl )
            // InternalBXtendDSLParser.g:4538:2: rule__FeatureAccess__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureAccess__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group_1__1"


    // $ANTLR start "rule__FeatureAccess__Group_1__1__Impl"
    // InternalBXtendDSLParser.g:4544:1: rule__FeatureAccess__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FeatureAccess__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4548:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:4549:1: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:4549:1: ( RULE_ID )
            // InternalBXtendDSLParser.g:4550:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccessAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureAccess__Group_1__1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1"
    // InternalBXtendDSLParser.g:4560:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1 : ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());
        	
        try {
            // InternalBXtendDSLParser.g:4565:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 )? )
            // InternalBXtendDSLParser.g:4566:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 )?
            {
            // InternalBXtendDSLParser.g:4566:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( LA28_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                alt28=1;
            }
            else if ( LA28_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                alt28=1;
            }
            else if ( LA28_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                alt28=1;
            }
            else if ( LA28_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl"
    // InternalBXtendDSLParser.g:4574:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl : ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) ) ) ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBXtendDSLParser.g:4579:1: ( ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) ) ) )
            // InternalBXtendDSLParser.g:4580:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) ) )
            {
            // InternalBXtendDSLParser.g:4580:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) ) )
            int alt29=4;
            int LA29_0 = input.LA(1);

            if ( LA29_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                alt29=1;
            }
            else if ( LA29_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                alt29=2;
            }
            else if ( LA29_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                alt29=3;
            }
            else if ( LA29_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                alt29=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalBXtendDSLParser.g:4581:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4581:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4582:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0)");
                    }
                    // InternalBXtendDSLParser.g:4582:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) )
                    // InternalBXtendDSLParser.g:4583:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0);
                    selected = true;
                    // InternalBXtendDSLParser.g:4589:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) )
                    // InternalBXtendDSLParser.g:4590:6: ( rule__ClassMatcherModifier__Group_1_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:4591:6: ( rule__ClassMatcherModifier__Group_1_0_1_0__0 )
                    // InternalBXtendDSLParser.g:4591:7: rule__ClassMatcherModifier__Group_1_0_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:4596:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4596:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4597:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1)");
                    }
                    // InternalBXtendDSLParser.g:4597:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) )
                    // InternalBXtendDSLParser.g:4598:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1);
                    selected = true;
                    // InternalBXtendDSLParser.g:4604:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) )
                    // InternalBXtendDSLParser.g:4605:6: ( rule__ClassMatcherModifier__Group_1_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:4606:6: ( rule__ClassMatcherModifier__Group_1_0_1_1__0 )
                    // InternalBXtendDSLParser.g:4606:7: rule__ClassMatcherModifier__Group_1_0_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:4611:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4611:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4612:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2)");
                    }
                    // InternalBXtendDSLParser.g:4612:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) )
                    // InternalBXtendDSLParser.g:4613:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2);
                    selected = true;
                    // InternalBXtendDSLParser.g:4619:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) )
                    // InternalBXtendDSLParser.g:4620:6: ( rule__ClassMatcherModifier__Group_1_0_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:4621:6: ( rule__ClassMatcherModifier__Group_1_0_1_2__0 )
                    // InternalBXtendDSLParser.g:4621:7: rule__ClassMatcherModifier__Group_1_0_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_0_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:4626:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4626:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4627:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3)");
                    }
                    // InternalBXtendDSLParser.g:4627:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) ) )
                    // InternalBXtendDSLParser.g:4628:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3);
                    selected = true;
                    // InternalBXtendDSLParser.g:4634:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_3__0 ) )
                    // InternalBXtendDSLParser.g:4635:6: ( rule__ClassMatcherModifier__Group_1_0_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:4636:6: ( rule__ClassMatcherModifier__Group_1_0_1_3__0 )
                    // InternalBXtendDSLParser.g:4636:7: rule__ClassMatcherModifier__Group_1_0_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_0_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0"
    // InternalBXtendDSLParser.g:4649:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 : rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4653:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 )? )
            // InternalBXtendDSLParser.g:4654:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 )?
            {
            pushFollow(FOLLOW_41);
            rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4655:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( LA30_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                alt30=1;
            }
            else if ( LA30_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                alt30=1;
            }
            else if ( LA30_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                alt30=1;
            }
            else if ( LA30_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1"
    // InternalBXtendDSLParser.g:4661:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 : rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4665:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 )? )
            // InternalBXtendDSLParser.g:4666:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 )?
            {
            pushFollow(FOLLOW_41);
            rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4667:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( LA31_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                alt31=1;
            }
            else if ( LA31_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                alt31=1;
            }
            else if ( LA31_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2"
    // InternalBXtendDSLParser.g:4673:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 : rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4677:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 )? )
            // InternalBXtendDSLParser.g:4678:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 )?
            {
            pushFollow(FOLLOW_41);
            rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4679:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( LA32_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
                alt32=1;
            }
            else if ( LA32_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
                alt32=1;
            }
            else if ( LA32_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 3) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3"
    // InternalBXtendDSLParser.g:4685:1: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 : rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4689:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl )
            // InternalBXtendDSLParser.g:4690:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1"
    // InternalBXtendDSLParser.g:4697:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1 : ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());
        	
        try {
            // InternalBXtendDSLParser.g:4702:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 )? )
            // InternalBXtendDSLParser.g:4703:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 )?
            {
            // InternalBXtendDSLParser.g:4703:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( LA33_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                alt33=1;
            }
            else if ( LA33_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                alt33=1;
            }
            else if ( LA33_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl"
    // InternalBXtendDSLParser.g:4711:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl : ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) ) ) ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBXtendDSLParser.g:4716:1: ( ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) ) ) )
            // InternalBXtendDSLParser.g:4717:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) ) )
            {
            // InternalBXtendDSLParser.g:4717:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) ) )
            int alt34=4;
            int LA34_0 = input.LA(1);

            if ( LA34_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                alt34=2;
            }
            else if ( LA34_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                alt34=3;
            }
            else if ( LA34_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                alt34=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalBXtendDSLParser.g:4718:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4718:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4719:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0)");
                    }
                    // InternalBXtendDSLParser.g:4719:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) )
                    // InternalBXtendDSLParser.g:4720:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0);
                    selected = true;
                    // InternalBXtendDSLParser.g:4726:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) )
                    // InternalBXtendDSLParser.g:4727:6: ( rule__ClassMatcherModifier__Group_1_1_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:4728:6: ( rule__ClassMatcherModifier__Group_1_1_1_0__0 )
                    // InternalBXtendDSLParser.g:4728:7: rule__ClassMatcherModifier__Group_1_1_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_1_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:4733:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4733:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4734:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1)");
                    }
                    // InternalBXtendDSLParser.g:4734:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) )
                    // InternalBXtendDSLParser.g:4735:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1);
                    selected = true;
                    // InternalBXtendDSLParser.g:4741:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) )
                    // InternalBXtendDSLParser.g:4742:6: ( rule__ClassMatcherModifier__Group_1_1_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:4743:6: ( rule__ClassMatcherModifier__Group_1_1_1_1__0 )
                    // InternalBXtendDSLParser.g:4743:7: rule__ClassMatcherModifier__Group_1_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_1_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:4748:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4748:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4749:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2)");
                    }
                    // InternalBXtendDSLParser.g:4749:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) )
                    // InternalBXtendDSLParser.g:4750:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2);
                    selected = true;
                    // InternalBXtendDSLParser.g:4756:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) )
                    // InternalBXtendDSLParser.g:4757:6: ( rule__ClassMatcherModifier__Group_1_1_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:4758:6: ( rule__ClassMatcherModifier__Group_1_1_1_2__0 )
                    // InternalBXtendDSLParser.g:4758:7: rule__ClassMatcherModifier__Group_1_1_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_1_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:4763:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4763:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4764:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3)");
                    }
                    // InternalBXtendDSLParser.g:4764:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) ) )
                    // InternalBXtendDSLParser.g:4765:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3);
                    selected = true;
                    // InternalBXtendDSLParser.g:4771:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_3__0 ) )
                    // InternalBXtendDSLParser.g:4772:6: ( rule__ClassMatcherModifier__Group_1_1_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:4773:6: ( rule__ClassMatcherModifier__Group_1_1_1_3__0 )
                    // InternalBXtendDSLParser.g:4773:7: rule__ClassMatcherModifier__Group_1_1_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_1_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0"
    // InternalBXtendDSLParser.g:4786:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 : rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4790:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 )? )
            // InternalBXtendDSLParser.g:4791:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 )?
            {
            pushFollow(FOLLOW_42);
            rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4792:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( LA35_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                alt35=1;
            }
            else if ( LA35_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                alt35=1;
            }
            else if ( LA35_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                alt35=1;
            }
            else if ( LA35_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1"
    // InternalBXtendDSLParser.g:4798:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 : rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4802:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 )? )
            // InternalBXtendDSLParser.g:4803:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 )?
            {
            pushFollow(FOLLOW_42);
            rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4804:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( LA36_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                alt36=1;
            }
            else if ( LA36_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                alt36=1;
            }
            else if ( LA36_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                alt36=1;
            }
            else if ( LA36_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2"
    // InternalBXtendDSLParser.g:4810:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 : rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4814:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 )? )
            // InternalBXtendDSLParser.g:4815:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 )?
            {
            pushFollow(FOLLOW_42);
            rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4816:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( LA37_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
                alt37=1;
            }
            else if ( LA37_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
                alt37=1;
            }
            else if ( LA37_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
                alt37=1;
            }
            else if ( LA37_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 3) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3"
    // InternalBXtendDSLParser.g:4822:1: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 : rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4826:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl )
            // InternalBXtendDSLParser.g:4827:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_1_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1"
    // InternalBXtendDSLParser.g:4834:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1 : ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());
        	
        try {
            // InternalBXtendDSLParser.g:4839:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 )? )
            // InternalBXtendDSLParser.g:4840:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 )?
            {
            // InternalBXtendDSLParser.g:4840:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                alt38=1;
            }
            else if ( LA38_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                alt38=1;
            }
            else if ( LA38_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl"
    // InternalBXtendDSLParser.g:4848:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl : ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) ) ) ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBXtendDSLParser.g:4853:1: ( ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) ) ) )
            // InternalBXtendDSLParser.g:4854:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) ) )
            {
            // InternalBXtendDSLParser.g:4854:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) ) )
            int alt39=4;
            int LA39_0 = input.LA(1);

            if ( LA39_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                alt39=2;
            }
            else if ( LA39_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                alt39=3;
            }
            else if ( LA39_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                alt39=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalBXtendDSLParser.g:4855:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4855:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4856:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0)");
                    }
                    // InternalBXtendDSLParser.g:4856:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) )
                    // InternalBXtendDSLParser.g:4857:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0);
                    selected = true;
                    // InternalBXtendDSLParser.g:4863:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) )
                    // InternalBXtendDSLParser.g:4864:6: ( rule__ClassMatcherModifier__Group_1_2_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:4865:6: ( rule__ClassMatcherModifier__Group_1_2_1_0__0 )
                    // InternalBXtendDSLParser.g:4865:7: rule__ClassMatcherModifier__Group_1_2_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_2_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:4870:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4870:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4871:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1)");
                    }
                    // InternalBXtendDSLParser.g:4871:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) )
                    // InternalBXtendDSLParser.g:4872:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1);
                    selected = true;
                    // InternalBXtendDSLParser.g:4878:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) )
                    // InternalBXtendDSLParser.g:4879:6: ( rule__ClassMatcherModifier__Group_1_2_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:4880:6: ( rule__ClassMatcherModifier__Group_1_2_1_1__0 )
                    // InternalBXtendDSLParser.g:4880:7: rule__ClassMatcherModifier__Group_1_2_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_2_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:4885:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4885:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4886:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2)");
                    }
                    // InternalBXtendDSLParser.g:4886:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) )
                    // InternalBXtendDSLParser.g:4887:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2);
                    selected = true;
                    // InternalBXtendDSLParser.g:4893:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) )
                    // InternalBXtendDSLParser.g:4894:6: ( rule__ClassMatcherModifier__Group_1_2_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:4895:6: ( rule__ClassMatcherModifier__Group_1_2_1_2__0 )
                    // InternalBXtendDSLParser.g:4895:7: rule__ClassMatcherModifier__Group_1_2_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_2_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:4900:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4900:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4901:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3)");
                    }
                    // InternalBXtendDSLParser.g:4901:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) ) )
                    // InternalBXtendDSLParser.g:4902:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3);
                    selected = true;
                    // InternalBXtendDSLParser.g:4908:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_3__0 ) )
                    // InternalBXtendDSLParser.g:4909:6: ( rule__ClassMatcherModifier__Group_1_2_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:4910:6: ( rule__ClassMatcherModifier__Group_1_2_1_3__0 )
                    // InternalBXtendDSLParser.g:4910:7: rule__ClassMatcherModifier__Group_1_2_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_2_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0"
    // InternalBXtendDSLParser.g:4923:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 : rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4927:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 )? )
            // InternalBXtendDSLParser.g:4928:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 )?
            {
            pushFollow(FOLLOW_43);
            rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4929:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                alt40=1;
            }
            else if ( LA40_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                alt40=1;
            }
            else if ( LA40_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                alt40=1;
            }
            else if ( LA40_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1"
    // InternalBXtendDSLParser.g:4935:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 : rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4939:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 )? )
            // InternalBXtendDSLParser.g:4940:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 )?
            {
            pushFollow(FOLLOW_43);
            rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4941:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( LA41_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                alt41=1;
            }
            else if ( LA41_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                alt41=1;
            }
            else if ( LA41_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2"
    // InternalBXtendDSLParser.g:4947:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 : rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4951:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 )? )
            // InternalBXtendDSLParser.g:4952:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 )?
            {
            pushFollow(FOLLOW_43);
            rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:4953:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
                alt42=1;
            }
            else if ( LA42_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
                alt42=1;
            }
            else if ( LA42_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 3) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3"
    // InternalBXtendDSLParser.g:4959:1: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 : rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:4963:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl )
            // InternalBXtendDSLParser.g:4964:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_2_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1"
    // InternalBXtendDSLParser.g:4971:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1 : ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());
        	
        try {
            // InternalBXtendDSLParser.g:4976:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 )? )
            // InternalBXtendDSLParser.g:4977:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 )?
            {
            // InternalBXtendDSLParser.g:4977:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                alt43=1;
            }
            else if ( LA43_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                alt43=1;
            }
            else if ( LA43_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl"
    // InternalBXtendDSLParser.g:4985:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl : ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) ) ) ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBXtendDSLParser.g:4990:1: ( ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) ) ) )
            // InternalBXtendDSLParser.g:4991:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) ) )
            {
            // InternalBXtendDSLParser.g:4991:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) ) )
            int alt44=4;
            int LA44_0 = input.LA(1);

            if ( LA44_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                alt44=2;
            }
            else if ( LA44_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                alt44=3;
            }
            else if ( LA44_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                alt44=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalBXtendDSLParser.g:4992:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:4992:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) )
                    // InternalBXtendDSLParser.g:4993:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0)");
                    }
                    // InternalBXtendDSLParser.g:4993:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) )
                    // InternalBXtendDSLParser.g:4994:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0);
                    selected = true;
                    // InternalBXtendDSLParser.g:5000:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) )
                    // InternalBXtendDSLParser.g:5001:6: ( rule__ClassMatcherModifier__Group_1_3_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:5002:6: ( rule__ClassMatcherModifier__Group_1_3_1_0__0 )
                    // InternalBXtendDSLParser.g:5002:7: rule__ClassMatcherModifier__Group_1_3_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:5007:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5007:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5008:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1)");
                    }
                    // InternalBXtendDSLParser.g:5008:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) )
                    // InternalBXtendDSLParser.g:5009:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1);
                    selected = true;
                    // InternalBXtendDSLParser.g:5015:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) )
                    // InternalBXtendDSLParser.g:5016:6: ( rule__ClassMatcherModifier__Group_1_3_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:5017:6: ( rule__ClassMatcherModifier__Group_1_3_1_1__0 )
                    // InternalBXtendDSLParser.g:5017:7: rule__ClassMatcherModifier__Group_1_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_3_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:5022:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5022:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5023:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2)");
                    }
                    // InternalBXtendDSLParser.g:5023:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) )
                    // InternalBXtendDSLParser.g:5024:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2);
                    selected = true;
                    // InternalBXtendDSLParser.g:5030:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) )
                    // InternalBXtendDSLParser.g:5031:6: ( rule__ClassMatcherModifier__Group_1_3_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:5032:6: ( rule__ClassMatcherModifier__Group_1_3_1_2__0 )
                    // InternalBXtendDSLParser.g:5032:7: rule__ClassMatcherModifier__Group_1_3_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_3_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:5037:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5037:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5038:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3)");
                    }
                    // InternalBXtendDSLParser.g:5038:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) ) )
                    // InternalBXtendDSLParser.g:5039:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3);
                    selected = true;
                    // InternalBXtendDSLParser.g:5045:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_3__0 ) )
                    // InternalBXtendDSLParser.g:5046:6: ( rule__ClassMatcherModifier__Group_1_3_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:5047:6: ( rule__ClassMatcherModifier__Group_1_3_1_3__0 )
                    // InternalBXtendDSLParser.g:5047:7: rule__ClassMatcherModifier__Group_1_3_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_3_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0"
    // InternalBXtendDSLParser.g:5060:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 : rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5064:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 )? )
            // InternalBXtendDSLParser.g:5065:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 )?
            {
            pushFollow(FOLLOW_44);
            rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5066:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1"
    // InternalBXtendDSLParser.g:5072:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 : rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5076:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 )? )
            // InternalBXtendDSLParser.g:5077:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 )?
            {
            pushFollow(FOLLOW_44);
            rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5078:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                alt46=1;
            }
            else if ( LA46_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                alt46=1;
            }
            else if ( LA46_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2"
    // InternalBXtendDSLParser.g:5084:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 : rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5088:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 )? )
            // InternalBXtendDSLParser.g:5089:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 )?
            {
            pushFollow(FOLLOW_44);
            rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5090:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
                alt47=1;
            }
            else if ( LA47_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
                alt47=1;
            }
            else if ( LA47_0 == Deletion && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 3) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3"
    // InternalBXtendDSLParser.g:5096:1: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 : rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5100:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl )
            // InternalBXtendDSLParser.g:5101:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1"
    // InternalBXtendDSLParser.g:5108:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1 : ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());
        	
        try {
            // InternalBXtendDSLParser.g:5113:1: ( ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 )? )
            // InternalBXtendDSLParser.g:5114:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 )?
            {
            // InternalBXtendDSLParser.g:5114:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                alt48=1;
            }
            else if ( LA48_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                alt48=1;
            }
            else if ( LA48_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl"
    // InternalBXtendDSLParser.g:5122:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl : ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) ) ) ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBXtendDSLParser.g:5127:1: ( ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) ) ) )
            // InternalBXtendDSLParser.g:5128:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) ) )
            {
            // InternalBXtendDSLParser.g:5128:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) ) )
            int alt49=4;
            int LA49_0 = input.LA(1);

            if ( LA49_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                alt49=1;
            }
            else if ( LA49_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                alt49=2;
            }
            else if ( LA49_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                alt49=3;
            }
            else if ( LA49_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                alt49=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalBXtendDSLParser.g:5129:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5129:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5130:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0)");
                    }
                    // InternalBXtendDSLParser.g:5130:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) )
                    // InternalBXtendDSLParser.g:5131:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0);
                    selected = true;
                    // InternalBXtendDSLParser.g:5137:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) )
                    // InternalBXtendDSLParser.g:5138:6: ( rule__ClassMatcherModifier__Group_1_4_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_0()); 
                    }
                    // InternalBXtendDSLParser.g:5139:6: ( rule__ClassMatcherModifier__Group_1_4_1_0__0 )
                    // InternalBXtendDSLParser.g:5139:7: rule__ClassMatcherModifier__Group_1_4_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_4_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLParser.g:5144:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5144:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5145:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1)");
                    }
                    // InternalBXtendDSLParser.g:5145:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) )
                    // InternalBXtendDSLParser.g:5146:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1);
                    selected = true;
                    // InternalBXtendDSLParser.g:5152:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) )
                    // InternalBXtendDSLParser.g:5153:6: ( rule__ClassMatcherModifier__Group_1_4_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_1()); 
                    }
                    // InternalBXtendDSLParser.g:5154:6: ( rule__ClassMatcherModifier__Group_1_4_1_1__0 )
                    // InternalBXtendDSLParser.g:5154:7: rule__ClassMatcherModifier__Group_1_4_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_4_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBXtendDSLParser.g:5159:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5159:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5160:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2)");
                    }
                    // InternalBXtendDSLParser.g:5160:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) )
                    // InternalBXtendDSLParser.g:5161:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2);
                    selected = true;
                    // InternalBXtendDSLParser.g:5167:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) )
                    // InternalBXtendDSLParser.g:5168:6: ( rule__ClassMatcherModifier__Group_1_4_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_2()); 
                    }
                    // InternalBXtendDSLParser.g:5169:6: ( rule__ClassMatcherModifier__Group_1_4_1_2__0 )
                    // InternalBXtendDSLParser.g:5169:7: rule__ClassMatcherModifier__Group_1_4_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_4_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBXtendDSLParser.g:5174:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) )
                    {
                    // InternalBXtendDSLParser.g:5174:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) ) )
                    // InternalBXtendDSLParser.g:5175:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3)");
                    }
                    // InternalBXtendDSLParser.g:5175:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) ) )
                    // InternalBXtendDSLParser.g:5176:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3);
                    selected = true;
                    // InternalBXtendDSLParser.g:5182:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_3__0 ) )
                    // InternalBXtendDSLParser.g:5183:6: ( rule__ClassMatcherModifier__Group_1_4_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_3()); 
                    }
                    // InternalBXtendDSLParser.g:5184:6: ( rule__ClassMatcherModifier__Group_1_4_1_3__0 )
                    // InternalBXtendDSLParser.g:5184:7: rule__ClassMatcherModifier__Group_1_4_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__Group_1_4_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0"
    // InternalBXtendDSLParser.g:5197:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 : rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5201:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 )? )
            // InternalBXtendDSLParser.g:5202:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 )?
            {
            pushFollow(FOLLOW_45);
            rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5203:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( LA50_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                alt50=1;
            }
            else if ( LA50_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                alt50=1;
            }
            else if ( LA50_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                alt50=1;
            }
            else if ( LA50_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1"
    // InternalBXtendDSLParser.g:5209:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 : rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5213:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 )? )
            // InternalBXtendDSLParser.g:5214:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 )?
            {
            pushFollow(FOLLOW_45);
            rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5215:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( LA51_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                alt51=1;
            }
            else if ( LA51_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                alt51=1;
            }
            else if ( LA51_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                alt51=1;
            }
            else if ( LA51_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2"
    // InternalBXtendDSLParser.g:5221:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 : rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 )? ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5225:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 )? )
            // InternalBXtendDSLParser.g:5226:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 )?
            {
            pushFollow(FOLLOW_45);
            rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBXtendDSLParser.g:5227:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( LA52_0 == Group && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
                alt52=1;
            }
            else if ( LA52_0 == Filter && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
                alt52=1;
            }
            else if ( LA52_0 == Sort && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
                alt52=1;
            }
            else if ( LA52_0 == Creation && getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 3) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBXtendDSLParser.g:0:0: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2"


    // $ANTLR start "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3"
    // InternalBXtendDSLParser.g:5233:1: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 : rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl ;
    public final void rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5237:1: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl )
            // InternalBXtendDSLParser.g:5238:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMatcherModifier__UnorderedGroup_1_4_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3"


    // $ANTLR start "rule__BXtendDSL__MetamodelsAssignment_0"
    // InternalBXtendDSLParser.g:5245:1: rule__BXtendDSL__MetamodelsAssignment_0 : ( ruleMetamodels ) ;
    public final void rule__BXtendDSL__MetamodelsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5249:1: ( ( ruleMetamodels ) )
            // InternalBXtendDSLParser.g:5250:2: ( ruleMetamodels )
            {
            // InternalBXtendDSLParser.g:5250:2: ( ruleMetamodels )
            // InternalBXtendDSLParser.g:5251:3: ruleMetamodels
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getMetamodelsMetamodelsParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMetamodels();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getMetamodelsMetamodelsParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__MetamodelsAssignment_0"


    // $ANTLR start "rule__BXtendDSL__ConfigAssignment_1"
    // InternalBXtendDSLParser.g:5260:1: rule__BXtendDSL__ConfigAssignment_1 : ( ruleConfig ) ;
    public final void rule__BXtendDSL__ConfigAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5264:1: ( ( ruleConfig ) )
            // InternalBXtendDSLParser.g:5265:2: ( ruleConfig )
            {
            // InternalBXtendDSLParser.g:5265:2: ( ruleConfig )
            // InternalBXtendDSLParser.g:5266:3: ruleConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getConfigConfigParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getConfigConfigParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__ConfigAssignment_1"


    // $ANTLR start "rule__BXtendDSL__RulesAssignment_2"
    // InternalBXtendDSLParser.g:5275:1: rule__BXtendDSL__RulesAssignment_2 : ( ruleTransformationRule ) ;
    public final void rule__BXtendDSL__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5279:1: ( ( ruleTransformationRule ) )
            // InternalBXtendDSLParser.g:5280:2: ( ruleTransformationRule )
            {
            // InternalBXtendDSLParser.g:5280:2: ( ruleTransformationRule )
            // InternalBXtendDSLParser.g:5281:3: ruleTransformationRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBXtendDSLAccess().getRulesTransformationRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTransformationRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBXtendDSLAccess().getRulesTransformationRuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BXtendDSL__RulesAssignment_2"


    // $ANTLR start "rule__Metamodels__SourcemodelAssignment_1"
    // InternalBXtendDSLParser.g:5290:1: rule__Metamodels__SourcemodelAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Metamodels__SourcemodelAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5294:1: ( ( RULE_STRING ) )
            // InternalBXtendDSLParser.g:5295:2: ( RULE_STRING )
            {
            // InternalBXtendDSLParser.g:5295:2: ( RULE_STRING )
            // InternalBXtendDSLParser.g:5296:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getSourcemodelSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getSourcemodelSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__SourcemodelAssignment_1"


    // $ANTLR start "rule__Metamodels__CustomizedSrcElementsAssignment_2_1"
    // InternalBXtendDSLParser.g:5305:1: rule__Metamodels__CustomizedSrcElementsAssignment_2_1 : ( ruleCustomizedElement ) ;
    public final void rule__Metamodels__CustomizedSrcElementsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5309:1: ( ( ruleCustomizedElement ) )
            // InternalBXtendDSLParser.g:5310:2: ( ruleCustomizedElement )
            {
            // InternalBXtendDSLParser.g:5310:2: ( ruleCustomizedElement )
            // InternalBXtendDSLParser.g:5311:3: ruleCustomizedElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsCustomizedElementParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCustomizedElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedSrcElementsCustomizedElementParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__CustomizedSrcElementsAssignment_2_1"


    // $ANTLR start "rule__Metamodels__TargetmodelAssignment_4"
    // InternalBXtendDSLParser.g:5320:1: rule__Metamodels__TargetmodelAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Metamodels__TargetmodelAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5324:1: ( ( RULE_STRING ) )
            // InternalBXtendDSLParser.g:5325:2: ( RULE_STRING )
            {
            // InternalBXtendDSLParser.g:5325:2: ( RULE_STRING )
            // InternalBXtendDSLParser.g:5326:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getTargetmodelSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getTargetmodelSTRINGTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__TargetmodelAssignment_4"


    // $ANTLR start "rule__Metamodels__CustomizedTrgElementsAssignment_5_1"
    // InternalBXtendDSLParser.g:5335:1: rule__Metamodels__CustomizedTrgElementsAssignment_5_1 : ( ruleCustomizedElement ) ;
    public final void rule__Metamodels__CustomizedTrgElementsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5339:1: ( ( ruleCustomizedElement ) )
            // InternalBXtendDSLParser.g:5340:2: ( ruleCustomizedElement )
            {
            // InternalBXtendDSLParser.g:5340:2: ( ruleCustomizedElement )
            // InternalBXtendDSLParser.g:5341:3: ruleCustomizedElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsCustomizedElementParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCustomizedElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetamodelsAccess().getCustomizedTrgElementsCustomizedElementParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodels__CustomizedTrgElementsAssignment_5_1"


    // $ANTLR start "rule__CustomizedGetter__ElementAssignment_1"
    // InternalBXtendDSLParser.g:5350:1: rule__CustomizedGetter__ElementAssignment_1 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__CustomizedGetter__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5354:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:5355:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:5355:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:5356:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getElementEStructuralFeatureCrossReference_1_0()); 
            }
            // InternalBXtendDSLParser.g:5357:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:5358:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getElementEStructuralFeatureFeatureAccessParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getElementEStructuralFeatureFeatureAccessParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getElementEStructuralFeatureCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__ElementAssignment_1"


    // $ANTLR start "rule__CustomizedGetter__CustomIdAssignment_3"
    // InternalBXtendDSLParser.g:5369:1: rule__CustomizedGetter__CustomIdAssignment_3 : ( RULE_ID ) ;
    public final void rule__CustomizedGetter__CustomIdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5373:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5374:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5374:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5375:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedGetterAccess().getCustomIdIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedGetterAccess().getCustomIdIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedGetter__CustomIdAssignment_3"


    // $ANTLR start "rule__CustomizedSetter__ElementAssignment_1"
    // InternalBXtendDSLParser.g:5384:1: rule__CustomizedSetter__ElementAssignment_1 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__CustomizedSetter__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5388:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:5389:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:5389:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:5390:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getElementEStructuralFeatureCrossReference_1_0()); 
            }
            // InternalBXtendDSLParser.g:5391:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:5392:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getElementEStructuralFeatureFeatureAccessParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getElementEStructuralFeatureFeatureAccessParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getElementEStructuralFeatureCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__ElementAssignment_1"


    // $ANTLR start "rule__CustomizedSetter__CustomIdAssignment_3"
    // InternalBXtendDSLParser.g:5403:1: rule__CustomizedSetter__CustomIdAssignment_3 : ( RULE_ID ) ;
    public final void rule__CustomizedSetter__CustomIdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5407:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5408:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5408:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5409:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCustomizedSetterAccess().getCustomIdIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCustomizedSetterAccess().getCustomIdIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CustomizedSetter__CustomIdAssignment_3"


    // $ANTLR start "rule__Config__OptionsAssignment_1_2"
    // InternalBXtendDSLParser.g:5418:1: rule__Config__OptionsAssignment_1_2 : ( RULE_ID ) ;
    public final void rule__Config__OptionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5422:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5423:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5423:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5424:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigAccess().getOptionsIDTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigAccess().getOptionsIDTerminalRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__OptionsAssignment_1_2"


    // $ANTLR start "rule__TransformationRule__NameAssignment_1"
    // InternalBXtendDSLParser.g:5433:1: rule__TransformationRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TransformationRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5437:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5438:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5438:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5439:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__NameAssignment_1"


    // $ANTLR start "rule__TransformationRule__SrcMatcherAssignment_4"
    // InternalBXtendDSLParser.g:5448:1: rule__TransformationRule__SrcMatcherAssignment_4 : ( ruleSrcClassMatcher ) ;
    public final void rule__TransformationRule__SrcMatcherAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5452:1: ( ( ruleSrcClassMatcher ) )
            // InternalBXtendDSLParser.g:5453:2: ( ruleSrcClassMatcher )
            {
            // InternalBXtendDSLParser.g:5453:2: ( ruleSrcClassMatcher )
            // InternalBXtendDSLParser.g:5454:3: ruleSrcClassMatcher
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSrcClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__SrcMatcherAssignment_4"


    // $ANTLR start "rule__TransformationRule__SrcMatcherAssignment_5_1"
    // InternalBXtendDSLParser.g:5463:1: rule__TransformationRule__SrcMatcherAssignment_5_1 : ( ruleSrcClassMatcher ) ;
    public final void rule__TransformationRule__SrcMatcherAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5467:1: ( ( ruleSrcClassMatcher ) )
            // InternalBXtendDSLParser.g:5468:2: ( ruleSrcClassMatcher )
            {
            // InternalBXtendDSLParser.g:5468:2: ( ruleSrcClassMatcher )
            // InternalBXtendDSLParser.g:5469:3: ruleSrcClassMatcher
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSrcClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getSrcMatcherSrcClassMatcherParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__SrcMatcherAssignment_5_1"


    // $ANTLR start "rule__TransformationRule__TrgMatcherAssignment_7"
    // InternalBXtendDSLParser.g:5478:1: rule__TransformationRule__TrgMatcherAssignment_7 : ( ruleTrgClassMatcher ) ;
    public final void rule__TransformationRule__TrgMatcherAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5482:1: ( ( ruleTrgClassMatcher ) )
            // InternalBXtendDSLParser.g:5483:2: ( ruleTrgClassMatcher )
            {
            // InternalBXtendDSLParser.g:5483:2: ( ruleTrgClassMatcher )
            // InternalBXtendDSLParser.g:5484:3: ruleTrgClassMatcher
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTrgClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__TrgMatcherAssignment_7"


    // $ANTLR start "rule__TransformationRule__TrgMatcherAssignment_8_1"
    // InternalBXtendDSLParser.g:5493:1: rule__TransformationRule__TrgMatcherAssignment_8_1 : ( ruleTrgClassMatcher ) ;
    public final void rule__TransformationRule__TrgMatcherAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5497:1: ( ( ruleTrgClassMatcher ) )
            // InternalBXtendDSLParser.g:5498:2: ( ruleTrgClassMatcher )
            {
            // InternalBXtendDSLParser.g:5498:2: ( ruleTrgClassMatcher )
            // InternalBXtendDSLParser.g:5499:3: ruleTrgClassMatcher
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_8_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTrgClassMatcher();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getTrgMatcherTrgClassMatcherParserRuleCall_8_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__TrgMatcherAssignment_8_1"


    // $ANTLR start "rule__TransformationRule__MappingsAssignment_9"
    // InternalBXtendDSLParser.g:5508:1: rule__TransformationRule__MappingsAssignment_9 : ( ruleFeatureMapping ) ;
    public final void rule__TransformationRule__MappingsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5512:1: ( ( ruleFeatureMapping ) )
            // InternalBXtendDSLParser.g:5513:2: ( ruleFeatureMapping )
            {
            // InternalBXtendDSLParser.g:5513:2: ( ruleFeatureMapping )
            // InternalBXtendDSLParser.g:5514:3: ruleFeatureMapping
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRuleAccess().getMappingsFeatureMappingParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureMapping();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRuleAccess().getMappingsFeatureMappingParserRuleCall_9_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationRule__MappingsAssignment_9"


    // $ANTLR start "rule__SrcClassMatcher__ClazzAssignment_0"
    // InternalBXtendDSLParser.g:5523:1: rule__SrcClassMatcher__ClazzAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SrcClassMatcher__ClazzAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5527:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:5528:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:5528:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5529:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getClazzEClassCrossReference_0_0()); 
            }
            // InternalBXtendDSLParser.g:5530:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:5531:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getClazzEClassIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getClazzEClassIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getClazzEClassCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__ClazzAssignment_0"


    // $ANTLR start "rule__SrcClassMatcher__NameAssignment_1"
    // InternalBXtendDSLParser.g:5542:1: rule__SrcClassMatcher__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SrcClassMatcher__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5546:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5547:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5547:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5548:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__NameAssignment_1"


    // $ANTLR start "rule__SrcClassMatcher__ModifierAssignment_2"
    // InternalBXtendDSLParser.g:5557:1: rule__SrcClassMatcher__ModifierAssignment_2 : ( ruleClassMatcherModifier ) ;
    public final void rule__SrcClassMatcher__ModifierAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5561:1: ( ( ruleClassMatcherModifier ) )
            // InternalBXtendDSLParser.g:5562:2: ( ruleClassMatcherModifier )
            {
            // InternalBXtendDSLParser.g:5562:2: ( ruleClassMatcherModifier )
            // InternalBXtendDSLParser.g:5563:3: ruleClassMatcherModifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcClassMatcher__ModifierAssignment_2"


    // $ANTLR start "rule__TrgClassMatcher__ClazzAssignment_0"
    // InternalBXtendDSLParser.g:5572:1: rule__TrgClassMatcher__ClazzAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__TrgClassMatcher__ClazzAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5576:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:5577:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:5577:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5578:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getClazzEClassCrossReference_0_0()); 
            }
            // InternalBXtendDSLParser.g:5579:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:5580:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getClazzEClassIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getClazzEClassIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getClazzEClassCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__ClazzAssignment_0"


    // $ANTLR start "rule__TrgClassMatcher__NameAssignment_1"
    // InternalBXtendDSLParser.g:5591:1: rule__TrgClassMatcher__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TrgClassMatcher__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5595:1: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:5596:2: ( RULE_ID )
            {
            // InternalBXtendDSLParser.g:5596:2: ( RULE_ID )
            // InternalBXtendDSLParser.g:5597:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__NameAssignment_1"


    // $ANTLR start "rule__TrgClassMatcher__ModifierAssignment_2"
    // InternalBXtendDSLParser.g:5606:1: rule__TrgClassMatcher__ModifierAssignment_2 : ( ruleClassMatcherModifier ) ;
    public final void rule__TrgClassMatcher__ModifierAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5610:1: ( ( ruleClassMatcherModifier ) )
            // InternalBXtendDSLParser.g:5611:2: ( ruleClassMatcherModifier )
            {
            // InternalBXtendDSLParser.g:5611:2: ( ruleClassMatcherModifier )
            // InternalBXtendDSLParser.g:5612:3: ruleClassMatcherModifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClassMatcherModifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgClassMatcherAccess().getModifierClassMatcherModifierParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgClassMatcher__ModifierAssignment_2"


    // $ANTLR start "rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0"
    // InternalBXtendDSLParser.g:5621:1: rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0 : ( ( Filter ) ) ;
    public final void rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5625:1: ( ( ( Filter ) ) )
            // InternalBXtendDSLParser.g:5626:2: ( ( Filter ) )
            {
            // InternalBXtendDSLParser.g:5626:2: ( ( Filter ) )
            // InternalBXtendDSLParser.g:5627:3: ( Filter )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0()); 
            }
            // InternalBXtendDSLParser.g:5628:3: ( Filter )
            // InternalBXtendDSLParser.g:5629:4: Filter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0()); 
            }
            match(input,Filter,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_0_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__FilterAssignment_1_0_1_0_0"


    // $ANTLR start "rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0"
    // InternalBXtendDSLParser.g:5640:1: rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0 : ( ( Sort ) ) ;
    public final void rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5644:1: ( ( ( Sort ) ) )
            // InternalBXtendDSLParser.g:5645:2: ( ( Sort ) )
            {
            // InternalBXtendDSLParser.g:5645:2: ( ( Sort ) )
            // InternalBXtendDSLParser.g:5646:3: ( Sort )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:5647:3: ( Sort )
            // InternalBXtendDSLParser.g:5648:4: Sort
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0()); 
            }
            match(input,Sort,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_0_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__SortAssignment_1_0_1_1_0"


    // $ANTLR start "rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0"
    // InternalBXtendDSLParser.g:5659:1: rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0 : ( ( Creation ) ) ;
    public final void rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5663:1: ( ( ( Creation ) ) )
            // InternalBXtendDSLParser.g:5664:2: ( ( Creation ) )
            {
            // InternalBXtendDSLParser.g:5664:2: ( ( Creation ) )
            // InternalBXtendDSLParser.g:5665:3: ( Creation )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0()); 
            }
            // InternalBXtendDSLParser.g:5666:3: ( Creation )
            // InternalBXtendDSLParser.g:5667:4: Creation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0()); 
            }
            match(input,Creation,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_0_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__CreationAssignment_1_0_1_2_0"


    // $ANTLR start "rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0"
    // InternalBXtendDSLParser.g:5678:1: rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0 : ( ( Deletion ) ) ;
    public final void rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5682:1: ( ( ( Deletion ) ) )
            // InternalBXtendDSLParser.g:5683:2: ( ( Deletion ) )
            {
            // InternalBXtendDSLParser.g:5683:2: ( ( Deletion ) )
            // InternalBXtendDSLParser.g:5684:3: ( Deletion )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0()); 
            }
            // InternalBXtendDSLParser.g:5685:3: ( Deletion )
            // InternalBXtendDSLParser.g:5686:4: Deletion
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0()); 
            }
            match(input,Deletion,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_0_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__DeletionAssignment_1_0_1_3_0"


    // $ANTLR start "rule__ClassMatcherModifier__GroupAssignment_1_0_2"
    // InternalBXtendDSLParser.g:5697:1: rule__ClassMatcherModifier__GroupAssignment_1_0_2 : ( ( Group ) ) ;
    public final void rule__ClassMatcherModifier__GroupAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5701:1: ( ( ( Group ) ) )
            // InternalBXtendDSLParser.g:5702:2: ( ( Group ) )
            {
            // InternalBXtendDSLParser.g:5702:2: ( ( Group ) )
            // InternalBXtendDSLParser.g:5703:3: ( Group )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0()); 
            }
            // InternalBXtendDSLParser.g:5704:3: ( Group )
            // InternalBXtendDSLParser.g:5705:4: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__GroupAssignment_1_0_2"


    // $ANTLR start "rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0"
    // InternalBXtendDSLParser.g:5716:1: rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0 : ( ( Group ) ) ;
    public final void rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5720:1: ( ( ( Group ) ) )
            // InternalBXtendDSLParser.g:5721:2: ( ( Group ) )
            {
            // InternalBXtendDSLParser.g:5721:2: ( ( Group ) )
            // InternalBXtendDSLParser.g:5722:3: ( Group )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0()); 
            }
            // InternalBXtendDSLParser.g:5723:3: ( Group )
            // InternalBXtendDSLParser.g:5724:4: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_1_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__GroupAssignment_1_1_1_0_0"


    // $ANTLR start "rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0"
    // InternalBXtendDSLParser.g:5735:1: rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0 : ( ( Sort ) ) ;
    public final void rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5739:1: ( ( ( Sort ) ) )
            // InternalBXtendDSLParser.g:5740:2: ( ( Sort ) )
            {
            // InternalBXtendDSLParser.g:5740:2: ( ( Sort ) )
            // InternalBXtendDSLParser.g:5741:3: ( Sort )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:5742:3: ( Sort )
            // InternalBXtendDSLParser.g:5743:4: Sort
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0()); 
            }
            match(input,Sort,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_1_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__SortAssignment_1_1_1_1_0"


    // $ANTLR start "rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0"
    // InternalBXtendDSLParser.g:5754:1: rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0 : ( ( Creation ) ) ;
    public final void rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5758:1: ( ( ( Creation ) ) )
            // InternalBXtendDSLParser.g:5759:2: ( ( Creation ) )
            {
            // InternalBXtendDSLParser.g:5759:2: ( ( Creation ) )
            // InternalBXtendDSLParser.g:5760:3: ( Creation )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0()); 
            }
            // InternalBXtendDSLParser.g:5761:3: ( Creation )
            // InternalBXtendDSLParser.g:5762:4: Creation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0()); 
            }
            match(input,Creation,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_1_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__CreationAssignment_1_1_1_2_0"


    // $ANTLR start "rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0"
    // InternalBXtendDSLParser.g:5773:1: rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0 : ( ( Deletion ) ) ;
    public final void rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5777:1: ( ( ( Deletion ) ) )
            // InternalBXtendDSLParser.g:5778:2: ( ( Deletion ) )
            {
            // InternalBXtendDSLParser.g:5778:2: ( ( Deletion ) )
            // InternalBXtendDSLParser.g:5779:3: ( Deletion )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0()); 
            }
            // InternalBXtendDSLParser.g:5780:3: ( Deletion )
            // InternalBXtendDSLParser.g:5781:4: Deletion
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0()); 
            }
            match(input,Deletion,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_1_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__DeletionAssignment_1_1_1_3_0"


    // $ANTLR start "rule__ClassMatcherModifier__FilterAssignment_1_1_2"
    // InternalBXtendDSLParser.g:5792:1: rule__ClassMatcherModifier__FilterAssignment_1_1_2 : ( ( Filter ) ) ;
    public final void rule__ClassMatcherModifier__FilterAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5796:1: ( ( ( Filter ) ) )
            // InternalBXtendDSLParser.g:5797:2: ( ( Filter ) )
            {
            // InternalBXtendDSLParser.g:5797:2: ( ( Filter ) )
            // InternalBXtendDSLParser.g:5798:3: ( Filter )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0()); 
            }
            // InternalBXtendDSLParser.g:5799:3: ( Filter )
            // InternalBXtendDSLParser.g:5800:4: Filter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0()); 
            }
            match(input,Filter,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__FilterAssignment_1_1_2"


    // $ANTLR start "rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0"
    // InternalBXtendDSLParser.g:5811:1: rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0 : ( ( Group ) ) ;
    public final void rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5815:1: ( ( ( Group ) ) )
            // InternalBXtendDSLParser.g:5816:2: ( ( Group ) )
            {
            // InternalBXtendDSLParser.g:5816:2: ( ( Group ) )
            // InternalBXtendDSLParser.g:5817:3: ( Group )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0()); 
            }
            // InternalBXtendDSLParser.g:5818:3: ( Group )
            // InternalBXtendDSLParser.g:5819:4: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_2_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__GroupAssignment_1_2_1_0_0"


    // $ANTLR start "rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0"
    // InternalBXtendDSLParser.g:5830:1: rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0 : ( ( Filter ) ) ;
    public final void rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5834:1: ( ( ( Filter ) ) )
            // InternalBXtendDSLParser.g:5835:2: ( ( Filter ) )
            {
            // InternalBXtendDSLParser.g:5835:2: ( ( Filter ) )
            // InternalBXtendDSLParser.g:5836:3: ( Filter )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:5837:3: ( Filter )
            // InternalBXtendDSLParser.g:5838:4: Filter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0()); 
            }
            match(input,Filter,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_2_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__FilterAssignment_1_2_1_1_0"


    // $ANTLR start "rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0"
    // InternalBXtendDSLParser.g:5849:1: rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0 : ( ( Creation ) ) ;
    public final void rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5853:1: ( ( ( Creation ) ) )
            // InternalBXtendDSLParser.g:5854:2: ( ( Creation ) )
            {
            // InternalBXtendDSLParser.g:5854:2: ( ( Creation ) )
            // InternalBXtendDSLParser.g:5855:3: ( Creation )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0()); 
            }
            // InternalBXtendDSLParser.g:5856:3: ( Creation )
            // InternalBXtendDSLParser.g:5857:4: Creation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0()); 
            }
            match(input,Creation,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_2_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__CreationAssignment_1_2_1_2_0"


    // $ANTLR start "rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0"
    // InternalBXtendDSLParser.g:5868:1: rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0 : ( ( Deletion ) ) ;
    public final void rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5872:1: ( ( ( Deletion ) ) )
            // InternalBXtendDSLParser.g:5873:2: ( ( Deletion ) )
            {
            // InternalBXtendDSLParser.g:5873:2: ( ( Deletion ) )
            // InternalBXtendDSLParser.g:5874:3: ( Deletion )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0()); 
            }
            // InternalBXtendDSLParser.g:5875:3: ( Deletion )
            // InternalBXtendDSLParser.g:5876:4: Deletion
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0()); 
            }
            match(input,Deletion,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_2_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__DeletionAssignment_1_2_1_3_0"


    // $ANTLR start "rule__ClassMatcherModifier__SortAssignment_1_2_2"
    // InternalBXtendDSLParser.g:5887:1: rule__ClassMatcherModifier__SortAssignment_1_2_2 : ( ( Sort ) ) ;
    public final void rule__ClassMatcherModifier__SortAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5891:1: ( ( ( Sort ) ) )
            // InternalBXtendDSLParser.g:5892:2: ( ( Sort ) )
            {
            // InternalBXtendDSLParser.g:5892:2: ( ( Sort ) )
            // InternalBXtendDSLParser.g:5893:3: ( Sort )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0()); 
            }
            // InternalBXtendDSLParser.g:5894:3: ( Sort )
            // InternalBXtendDSLParser.g:5895:4: Sort
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0()); 
            }
            match(input,Sort,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__SortAssignment_1_2_2"


    // $ANTLR start "rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0"
    // InternalBXtendDSLParser.g:5906:1: rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0 : ( ( Group ) ) ;
    public final void rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5910:1: ( ( ( Group ) ) )
            // InternalBXtendDSLParser.g:5911:2: ( ( Group ) )
            {
            // InternalBXtendDSLParser.g:5911:2: ( ( Group ) )
            // InternalBXtendDSLParser.g:5912:3: ( Group )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0()); 
            }
            // InternalBXtendDSLParser.g:5913:3: ( Group )
            // InternalBXtendDSLParser.g:5914:4: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_3_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__GroupAssignment_1_3_1_0_0"


    // $ANTLR start "rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0"
    // InternalBXtendDSLParser.g:5925:1: rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0 : ( ( Filter ) ) ;
    public final void rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5929:1: ( ( ( Filter ) ) )
            // InternalBXtendDSLParser.g:5930:2: ( ( Filter ) )
            {
            // InternalBXtendDSLParser.g:5930:2: ( ( Filter ) )
            // InternalBXtendDSLParser.g:5931:3: ( Filter )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:5932:3: ( Filter )
            // InternalBXtendDSLParser.g:5933:4: Filter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0()); 
            }
            match(input,Filter,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_3_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__FilterAssignment_1_3_1_1_0"


    // $ANTLR start "rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0"
    // InternalBXtendDSLParser.g:5944:1: rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0 : ( ( Sort ) ) ;
    public final void rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5948:1: ( ( ( Sort ) ) )
            // InternalBXtendDSLParser.g:5949:2: ( ( Sort ) )
            {
            // InternalBXtendDSLParser.g:5949:2: ( ( Sort ) )
            // InternalBXtendDSLParser.g:5950:3: ( Sort )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0()); 
            }
            // InternalBXtendDSLParser.g:5951:3: ( Sort )
            // InternalBXtendDSLParser.g:5952:4: Sort
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0()); 
            }
            match(input,Sort,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_3_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__SortAssignment_1_3_1_2_0"


    // $ANTLR start "rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0"
    // InternalBXtendDSLParser.g:5963:1: rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0 : ( ( Deletion ) ) ;
    public final void rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5967:1: ( ( ( Deletion ) ) )
            // InternalBXtendDSLParser.g:5968:2: ( ( Deletion ) )
            {
            // InternalBXtendDSLParser.g:5968:2: ( ( Deletion ) )
            // InternalBXtendDSLParser.g:5969:3: ( Deletion )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0()); 
            }
            // InternalBXtendDSLParser.g:5970:3: ( Deletion )
            // InternalBXtendDSLParser.g:5971:4: Deletion
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0()); 
            }
            match(input,Deletion,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_3_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__DeletionAssignment_1_3_1_3_0"


    // $ANTLR start "rule__ClassMatcherModifier__CreationAssignment_1_3_2"
    // InternalBXtendDSLParser.g:5982:1: rule__ClassMatcherModifier__CreationAssignment_1_3_2 : ( ( Creation ) ) ;
    public final void rule__ClassMatcherModifier__CreationAssignment_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:5986:1: ( ( ( Creation ) ) )
            // InternalBXtendDSLParser.g:5987:2: ( ( Creation ) )
            {
            // InternalBXtendDSLParser.g:5987:2: ( ( Creation ) )
            // InternalBXtendDSLParser.g:5988:3: ( Creation )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0()); 
            }
            // InternalBXtendDSLParser.g:5989:3: ( Creation )
            // InternalBXtendDSLParser.g:5990:4: Creation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0()); 
            }
            match(input,Creation,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__CreationAssignment_1_3_2"


    // $ANTLR start "rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0"
    // InternalBXtendDSLParser.g:6001:1: rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0 : ( ( Group ) ) ;
    public final void rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6005:1: ( ( ( Group ) ) )
            // InternalBXtendDSLParser.g:6006:2: ( ( Group ) )
            {
            // InternalBXtendDSLParser.g:6006:2: ( ( Group ) )
            // InternalBXtendDSLParser.g:6007:3: ( Group )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0()); 
            }
            // InternalBXtendDSLParser.g:6008:3: ( Group )
            // InternalBXtendDSLParser.g:6009:4: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getGroupGroupKeyword_1_4_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__GroupAssignment_1_4_1_0_0"


    // $ANTLR start "rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0"
    // InternalBXtendDSLParser.g:6020:1: rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0 : ( ( Filter ) ) ;
    public final void rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6024:1: ( ( ( Filter ) ) )
            // InternalBXtendDSLParser.g:6025:2: ( ( Filter ) )
            {
            // InternalBXtendDSLParser.g:6025:2: ( ( Filter ) )
            // InternalBXtendDSLParser.g:6026:3: ( Filter )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:6027:3: ( Filter )
            // InternalBXtendDSLParser.g:6028:4: Filter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0()); 
            }
            match(input,Filter,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getFilterFilterKeyword_1_4_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__FilterAssignment_1_4_1_1_0"


    // $ANTLR start "rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0"
    // InternalBXtendDSLParser.g:6039:1: rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0 : ( ( Sort ) ) ;
    public final void rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6043:1: ( ( ( Sort ) ) )
            // InternalBXtendDSLParser.g:6044:2: ( ( Sort ) )
            {
            // InternalBXtendDSLParser.g:6044:2: ( ( Sort ) )
            // InternalBXtendDSLParser.g:6045:3: ( Sort )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0()); 
            }
            // InternalBXtendDSLParser.g:6046:3: ( Sort )
            // InternalBXtendDSLParser.g:6047:4: Sort
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0()); 
            }
            match(input,Sort,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getSortSortKeyword_1_4_1_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__SortAssignment_1_4_1_2_0"


    // $ANTLR start "rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0"
    // InternalBXtendDSLParser.g:6058:1: rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0 : ( ( Creation ) ) ;
    public final void rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6062:1: ( ( ( Creation ) ) )
            // InternalBXtendDSLParser.g:6063:2: ( ( Creation ) )
            {
            // InternalBXtendDSLParser.g:6063:2: ( ( Creation ) )
            // InternalBXtendDSLParser.g:6064:3: ( Creation )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0()); 
            }
            // InternalBXtendDSLParser.g:6065:3: ( Creation )
            // InternalBXtendDSLParser.g:6066:4: Creation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0()); 
            }
            match(input,Creation,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getCreationCreationKeyword_1_4_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__CreationAssignment_1_4_1_3_0"


    // $ANTLR start "rule__ClassMatcherModifier__DeletionAssignment_1_4_2"
    // InternalBXtendDSLParser.g:6077:1: rule__ClassMatcherModifier__DeletionAssignment_1_4_2 : ( ( Deletion ) ) ;
    public final void rule__ClassMatcherModifier__DeletionAssignment_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6081:1: ( ( ( Deletion ) ) )
            // InternalBXtendDSLParser.g:6082:2: ( ( Deletion ) )
            {
            // InternalBXtendDSLParser.g:6082:2: ( ( Deletion ) )
            // InternalBXtendDSLParser.g:6083:3: ( Deletion )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0()); 
            }
            // InternalBXtendDSLParser.g:6084:3: ( Deletion )
            // InternalBXtendDSLParser.g:6085:4: Deletion
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0()); 
            }
            match(input,Deletion,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassMatcherModifierAccess().getDeletionDeletionKeyword_1_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMatcherModifier__DeletionAssignment_1_4_2"


    // $ANTLR start "rule__FeatureMapping__SrcFeaturesAssignment_0_0"
    // InternalBXtendDSLParser.g:6096:1: rule__FeatureMapping__SrcFeaturesAssignment_0_0 : ( ruleSrcMappingFeature ) ;
    public final void rule__FeatureMapping__SrcFeaturesAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6100:1: ( ( ruleSrcMappingFeature ) )
            // InternalBXtendDSLParser.g:6101:2: ( ruleSrcMappingFeature )
            {
            // InternalBXtendDSLParser.g:6101:2: ( ruleSrcMappingFeature )
            // InternalBXtendDSLParser.g:6102:3: ruleSrcMappingFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getSrcFeaturesSrcMappingFeatureParserRuleCall_0_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSrcMappingFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getSrcFeaturesSrcMappingFeatureParserRuleCall_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__SrcFeaturesAssignment_0_0"


    // $ANTLR start "rule__FeatureMapping__SrcClassesAssignment_0_1"
    // InternalBXtendDSLParser.g:6111:1: rule__FeatureMapping__SrcClassesAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureMapping__SrcClassesAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6115:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:6116:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:6116:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:6117:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getSrcClassesClassMatcherCrossReference_0_1_0()); 
            }
            // InternalBXtendDSLParser.g:6118:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:6119:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getSrcClassesClassMatcherIDTerminalRuleCall_0_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getSrcClassesClassMatcherIDTerminalRuleCall_0_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getSrcClassesClassMatcherCrossReference_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__SrcClassesAssignment_0_1"


    // $ANTLR start "rule__FeatureMapping__DirectionAssignment_1"
    // InternalBXtendDSLParser.g:6130:1: rule__FeatureMapping__DirectionAssignment_1 : ( ruleDirection ) ;
    public final void rule__FeatureMapping__DirectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6134:1: ( ( ruleDirection ) )
            // InternalBXtendDSLParser.g:6135:2: ( ruleDirection )
            {
            // InternalBXtendDSLParser.g:6135:2: ( ruleDirection )
            // InternalBXtendDSLParser.g:6136:3: ruleDirection
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getDirectionDirectionEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDirection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getDirectionDirectionEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__DirectionAssignment_1"


    // $ANTLR start "rule__FeatureMapping__TrgFeaturesAssignment_2_0"
    // InternalBXtendDSLParser.g:6145:1: rule__FeatureMapping__TrgFeaturesAssignment_2_0 : ( ruleTrgMappingFeature ) ;
    public final void rule__FeatureMapping__TrgFeaturesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6149:1: ( ( ruleTrgMappingFeature ) )
            // InternalBXtendDSLParser.g:6150:2: ( ruleTrgMappingFeature )
            {
            // InternalBXtendDSLParser.g:6150:2: ( ruleTrgMappingFeature )
            // InternalBXtendDSLParser.g:6151:3: ruleTrgMappingFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getTrgFeaturesTrgMappingFeatureParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTrgMappingFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getTrgFeaturesTrgMappingFeatureParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__TrgFeaturesAssignment_2_0"


    // $ANTLR start "rule__FeatureMapping__TrgClassesAssignment_2_1"
    // InternalBXtendDSLParser.g:6160:1: rule__FeatureMapping__TrgClassesAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureMapping__TrgClassesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6164:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:6165:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:6165:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:6166:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getTrgClassesClassMatcherCrossReference_2_1_0()); 
            }
            // InternalBXtendDSLParser.g:6167:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:6168:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureMappingAccess().getTrgClassesClassMatcherIDTerminalRuleCall_2_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getTrgClassesClassMatcherIDTerminalRuleCall_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureMappingAccess().getTrgClassesClassMatcherCrossReference_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureMapping__TrgClassesAssignment_2_1"


    // $ANTLR start "rule__SrcMappingFeature__FeatureAssignment_0"
    // InternalBXtendDSLParser.g:6179:1: rule__SrcMappingFeature__FeatureAssignment_0 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__SrcMappingFeature__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6183:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:6184:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:6184:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:6185:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0()); 
            }
            // InternalBXtendDSLParser.g:6186:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:6187:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__FeatureAssignment_0"


    // $ANTLR start "rule__SrcMappingFeature__CorrAssignment_1_0"
    // InternalBXtendDSLParser.g:6198:1: rule__SrcMappingFeature__CorrAssignment_1_0 : ( ( LeftCurlyBracket ) ) ;
    public final void rule__SrcMappingFeature__CorrAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6202:1: ( ( ( LeftCurlyBracket ) ) )
            // InternalBXtendDSLParser.g:6203:2: ( ( LeftCurlyBracket ) )
            {
            // InternalBXtendDSLParser.g:6203:2: ( ( LeftCurlyBracket ) )
            // InternalBXtendDSLParser.g:6204:3: ( LeftCurlyBracket )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:6205:3: ( LeftCurlyBracket )
            // InternalBXtendDSLParser.g:6206:4: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__CorrAssignment_1_0"


    // $ANTLR start "rule__SrcMappingFeature__FeatureAssignment_1_1"
    // InternalBXtendDSLParser.g:6217:1: rule__SrcMappingFeature__FeatureAssignment_1_1 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__SrcMappingFeature__FeatureAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6221:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:6222:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:6222:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:6223:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:6224:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:6225:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_1_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__FeatureAssignment_1_1"


    // $ANTLR start "rule__SrcMappingFeature__CorrsAssignment_1_3"
    // InternalBXtendDSLParser.g:6236:1: rule__SrcMappingFeature__CorrsAssignment_1_3 : ( ruleCorrespondence ) ;
    public final void rule__SrcMappingFeature__CorrsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6240:1: ( ( ruleCorrespondence ) )
            // InternalBXtendDSLParser.g:6241:2: ( ruleCorrespondence )
            {
            // InternalBXtendDSLParser.g:6241:2: ( ruleCorrespondence )
            // InternalBXtendDSLParser.g:6242:3: ruleCorrespondence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCorrespondence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__CorrsAssignment_1_3"


    // $ANTLR start "rule__SrcMappingFeature__CorrsAssignment_1_4_1"
    // InternalBXtendDSLParser.g:6251:1: rule__SrcMappingFeature__CorrsAssignment_1_4_1 : ( ruleCorrespondence ) ;
    public final void rule__SrcMappingFeature__CorrsAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6255:1: ( ( ruleCorrespondence ) )
            // InternalBXtendDSLParser.g:6256:2: ( ruleCorrespondence )
            {
            // InternalBXtendDSLParser.g:6256:2: ( ruleCorrespondence )
            // InternalBXtendDSLParser.g:6257:3: ruleCorrespondence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCorrespondence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSrcMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SrcMappingFeature__CorrsAssignment_1_4_1"


    // $ANTLR start "rule__TrgMappingFeature__FeatureAssignment_0"
    // InternalBXtendDSLParser.g:6266:1: rule__TrgMappingFeature__FeatureAssignment_0 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__TrgMappingFeature__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6270:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:6271:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:6271:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:6272:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0()); 
            }
            // InternalBXtendDSLParser.g:6273:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:6274:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__FeatureAssignment_0"


    // $ANTLR start "rule__TrgMappingFeature__CorrAssignment_1_0"
    // InternalBXtendDSLParser.g:6285:1: rule__TrgMappingFeature__CorrAssignment_1_0 : ( ( LeftCurlyBracket ) ) ;
    public final void rule__TrgMappingFeature__CorrAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6289:1: ( ( ( LeftCurlyBracket ) ) )
            // InternalBXtendDSLParser.g:6290:2: ( ( LeftCurlyBracket ) )
            {
            // InternalBXtendDSLParser.g:6290:2: ( ( LeftCurlyBracket ) )
            // InternalBXtendDSLParser.g:6291:3: ( LeftCurlyBracket )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }
            // InternalBXtendDSLParser.g:6292:3: ( LeftCurlyBracket )
            // InternalBXtendDSLParser.g:6293:4: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrLeftCurlyBracketKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__CorrAssignment_1_0"


    // $ANTLR start "rule__TrgMappingFeature__FeatureAssignment_1_1"
    // InternalBXtendDSLParser.g:6304:1: rule__TrgMappingFeature__FeatureAssignment_1_1 : ( ( ruleFeatureAccess ) ) ;
    public final void rule__TrgMappingFeature__FeatureAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6308:1: ( ( ( ruleFeatureAccess ) ) )
            // InternalBXtendDSLParser.g:6309:2: ( ( ruleFeatureAccess ) )
            {
            // InternalBXtendDSLParser.g:6309:2: ( ( ruleFeatureAccess ) )
            // InternalBXtendDSLParser.g:6310:3: ( ruleFeatureAccess )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:6311:3: ( ruleFeatureAccess )
            // InternalBXtendDSLParser.g:6312:4: ruleFeatureAccess
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_1_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureAccess();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureFeatureAccessParserRuleCall_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getFeatureEStructuralFeatureCrossReference_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__FeatureAssignment_1_1"


    // $ANTLR start "rule__TrgMappingFeature__CorrsAssignment_1_3"
    // InternalBXtendDSLParser.g:6323:1: rule__TrgMappingFeature__CorrsAssignment_1_3 : ( ruleCorrespondence ) ;
    public final void rule__TrgMappingFeature__CorrsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6327:1: ( ( ruleCorrespondence ) )
            // InternalBXtendDSLParser.g:6328:2: ( ruleCorrespondence )
            {
            // InternalBXtendDSLParser.g:6328:2: ( ruleCorrespondence )
            // InternalBXtendDSLParser.g:6329:3: ruleCorrespondence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCorrespondence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__CorrsAssignment_1_3"


    // $ANTLR start "rule__TrgMappingFeature__CorrsAssignment_1_4_1"
    // InternalBXtendDSLParser.g:6338:1: rule__TrgMappingFeature__CorrsAssignment_1_4_1 : ( ruleCorrespondence ) ;
    public final void rule__TrgMappingFeature__CorrsAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6342:1: ( ( ruleCorrespondence ) )
            // InternalBXtendDSLParser.g:6343:2: ( ruleCorrespondence )
            {
            // InternalBXtendDSLParser.g:6343:2: ( ruleCorrespondence )
            // InternalBXtendDSLParser.g:6344:3: ruleCorrespondence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCorrespondence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrgMappingFeatureAccess().getCorrsCorrespondenceParserRuleCall_1_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrgMappingFeature__CorrsAssignment_1_4_1"


    // $ANTLR start "rule__Correspondence__RuleAssignment_0"
    // InternalBXtendDSLParser.g:6353:1: rule__Correspondence__RuleAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Correspondence__RuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6357:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:6358:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:6358:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:6359:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getRuleTransformationRuleCrossReference_0_0()); 
            }
            // InternalBXtendDSLParser.g:6360:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:6361:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getRuleTransformationRuleIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getRuleTransformationRuleIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getRuleTransformationRuleCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__RuleAssignment_0"


    // $ANTLR start "rule__Correspondence__MatchersAssignment_1_1"
    // InternalBXtendDSLParser.g:6372:1: rule__Correspondence__MatchersAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Correspondence__MatchersAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6376:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:6377:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:6377:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:6378:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_1_0()); 
            }
            // InternalBXtendDSLParser.g:6379:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:6380:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherIDTerminalRuleCall_1_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherIDTerminalRuleCall_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__MatchersAssignment_1_1"


    // $ANTLR start "rule__Correspondence__MatchersAssignment_1_2_1"
    // InternalBXtendDSLParser.g:6391:1: rule__Correspondence__MatchersAssignment_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Correspondence__MatchersAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBXtendDSLParser.g:6395:1: ( ( ( RULE_ID ) ) )
            // InternalBXtendDSLParser.g:6396:2: ( ( RULE_ID ) )
            {
            // InternalBXtendDSLParser.g:6396:2: ( ( RULE_ID ) )
            // InternalBXtendDSLParser.g:6397:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_2_1_0()); 
            }
            // InternalBXtendDSLParser.g:6398:3: ( RULE_ID )
            // InternalBXtendDSLParser.g:6399:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherIDTerminalRuleCall_1_2_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherIDTerminalRuleCall_1_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCorrespondenceAccess().getMatchersClassMatcherCrossReference_1_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Correspondence__MatchersAssignment_1_2_1"

    // $ANTLR start synpred32_InternalBXtendDSLParser
    public final void synpred32_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4566:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0 )
        // InternalBXtendDSLParser.g:4566:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalBXtendDSLParser

    // $ANTLR start synpred33_InternalBXtendDSLParser
    public final void synpred33_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4581:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4581:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4581:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) ) )
        // InternalBXtendDSLParser.g:4582:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0)");
        }
        // InternalBXtendDSLParser.g:4582:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) ) )
        // InternalBXtendDSLParser.g:4583:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 0);
        // InternalBXtendDSLParser.g:4589:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_0__0 ) )
        // InternalBXtendDSLParser.g:4590:6: ( rule__ClassMatcherModifier__Group_1_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_0()); 
        }
        // InternalBXtendDSLParser.g:4591:6: ( rule__ClassMatcherModifier__Group_1_0_1_0__0 )
        // InternalBXtendDSLParser.g:4591:7: rule__ClassMatcherModifier__Group_1_0_1_0__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred33_InternalBXtendDSLParser

    // $ANTLR start synpred34_InternalBXtendDSLParser
    public final void synpred34_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4596:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4596:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4596:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) ) )
        // InternalBXtendDSLParser.g:4597:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1)");
        }
        // InternalBXtendDSLParser.g:4597:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) ) )
        // InternalBXtendDSLParser.g:4598:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 1);
        // InternalBXtendDSLParser.g:4604:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_1__0 ) )
        // InternalBXtendDSLParser.g:4605:6: ( rule__ClassMatcherModifier__Group_1_0_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_1()); 
        }
        // InternalBXtendDSLParser.g:4606:6: ( rule__ClassMatcherModifier__Group_1_0_1_1__0 )
        // InternalBXtendDSLParser.g:4606:7: rule__ClassMatcherModifier__Group_1_0_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_0_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_InternalBXtendDSLParser

    // $ANTLR start synpred35_InternalBXtendDSLParser
    public final void synpred35_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4611:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4611:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4611:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) ) )
        // InternalBXtendDSLParser.g:4612:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2)");
        }
        // InternalBXtendDSLParser.g:4612:120: ( ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) ) )
        // InternalBXtendDSLParser.g:4613:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_0_1(), 2);
        // InternalBXtendDSLParser.g:4619:5: ( ( rule__ClassMatcherModifier__Group_1_0_1_2__0 ) )
        // InternalBXtendDSLParser.g:4620:6: ( rule__ClassMatcherModifier__Group_1_0_1_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_0_1_2()); 
        }
        // InternalBXtendDSLParser.g:4621:6: ( rule__ClassMatcherModifier__Group_1_0_1_2__0 )
        // InternalBXtendDSLParser.g:4621:7: rule__ClassMatcherModifier__Group_1_0_1_2__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_0_1_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalBXtendDSLParser

    // $ANTLR start synpred36_InternalBXtendDSLParser
    public final void synpred36_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4655:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1 )
        // InternalBXtendDSLParser.g:4655:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalBXtendDSLParser

    // $ANTLR start synpred37_InternalBXtendDSLParser
    public final void synpred37_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4667:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2 )
        // InternalBXtendDSLParser.g:4667:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_0_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalBXtendDSLParser

    // $ANTLR start synpred38_InternalBXtendDSLParser
    public final void synpred38_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4679:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3 )
        // InternalBXtendDSLParser.g:4679:2: rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_0_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalBXtendDSLParser

    // $ANTLR start synpred39_InternalBXtendDSLParser
    public final void synpred39_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4703:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0 )
        // InternalBXtendDSLParser.g:4703:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalBXtendDSLParser

    // $ANTLR start synpred40_InternalBXtendDSLParser
    public final void synpred40_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4718:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4718:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4718:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) ) )
        // InternalBXtendDSLParser.g:4719:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred40_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0)");
        }
        // InternalBXtendDSLParser.g:4719:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) ) )
        // InternalBXtendDSLParser.g:4720:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 0);
        // InternalBXtendDSLParser.g:4726:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_0__0 ) )
        // InternalBXtendDSLParser.g:4727:6: ( rule__ClassMatcherModifier__Group_1_1_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_0()); 
        }
        // InternalBXtendDSLParser.g:4728:6: ( rule__ClassMatcherModifier__Group_1_1_1_0__0 )
        // InternalBXtendDSLParser.g:4728:7: rule__ClassMatcherModifier__Group_1_1_1_0__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_1_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred40_InternalBXtendDSLParser

    // $ANTLR start synpred41_InternalBXtendDSLParser
    public final void synpred41_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4733:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4733:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4733:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) ) )
        // InternalBXtendDSLParser.g:4734:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred41_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1)");
        }
        // InternalBXtendDSLParser.g:4734:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) ) )
        // InternalBXtendDSLParser.g:4735:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 1);
        // InternalBXtendDSLParser.g:4741:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_1__0 ) )
        // InternalBXtendDSLParser.g:4742:6: ( rule__ClassMatcherModifier__Group_1_1_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_1()); 
        }
        // InternalBXtendDSLParser.g:4743:6: ( rule__ClassMatcherModifier__Group_1_1_1_1__0 )
        // InternalBXtendDSLParser.g:4743:7: rule__ClassMatcherModifier__Group_1_1_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_1_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred41_InternalBXtendDSLParser

    // $ANTLR start synpred42_InternalBXtendDSLParser
    public final void synpred42_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4748:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4748:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4748:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) ) )
        // InternalBXtendDSLParser.g:4749:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2)");
        }
        // InternalBXtendDSLParser.g:4749:120: ( ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) ) )
        // InternalBXtendDSLParser.g:4750:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_1_1(), 2);
        // InternalBXtendDSLParser.g:4756:5: ( ( rule__ClassMatcherModifier__Group_1_1_1_2__0 ) )
        // InternalBXtendDSLParser.g:4757:6: ( rule__ClassMatcherModifier__Group_1_1_1_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_1_1_2()); 
        }
        // InternalBXtendDSLParser.g:4758:6: ( rule__ClassMatcherModifier__Group_1_1_1_2__0 )
        // InternalBXtendDSLParser.g:4758:7: rule__ClassMatcherModifier__Group_1_1_1_2__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_1_1_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred42_InternalBXtendDSLParser

    // $ANTLR start synpred43_InternalBXtendDSLParser
    public final void synpred43_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4792:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1 )
        // InternalBXtendDSLParser.g:4792:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_1_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalBXtendDSLParser

    // $ANTLR start synpred44_InternalBXtendDSLParser
    public final void synpred44_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4804:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2 )
        // InternalBXtendDSLParser.g:4804:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_1_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalBXtendDSLParser

    // $ANTLR start synpred45_InternalBXtendDSLParser
    public final void synpred45_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4816:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3 )
        // InternalBXtendDSLParser.g:4816:2: rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_1_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalBXtendDSLParser

    // $ANTLR start synpred46_InternalBXtendDSLParser
    public final void synpred46_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4840:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0 )
        // InternalBXtendDSLParser.g:4840:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_2_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalBXtendDSLParser

    // $ANTLR start synpred47_InternalBXtendDSLParser
    public final void synpred47_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4855:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4855:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4855:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) ) )
        // InternalBXtendDSLParser.g:4856:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred47_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0)");
        }
        // InternalBXtendDSLParser.g:4856:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) ) )
        // InternalBXtendDSLParser.g:4857:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 0);
        // InternalBXtendDSLParser.g:4863:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_0__0 ) )
        // InternalBXtendDSLParser.g:4864:6: ( rule__ClassMatcherModifier__Group_1_2_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_0()); 
        }
        // InternalBXtendDSLParser.g:4865:6: ( rule__ClassMatcherModifier__Group_1_2_1_0__0 )
        // InternalBXtendDSLParser.g:4865:7: rule__ClassMatcherModifier__Group_1_2_1_0__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_2_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred47_InternalBXtendDSLParser

    // $ANTLR start synpred48_InternalBXtendDSLParser
    public final void synpred48_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4870:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4870:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4870:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) ) )
        // InternalBXtendDSLParser.g:4871:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred48_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1)");
        }
        // InternalBXtendDSLParser.g:4871:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) ) )
        // InternalBXtendDSLParser.g:4872:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 1);
        // InternalBXtendDSLParser.g:4878:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_1__0 ) )
        // InternalBXtendDSLParser.g:4879:6: ( rule__ClassMatcherModifier__Group_1_2_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_1()); 
        }
        // InternalBXtendDSLParser.g:4880:6: ( rule__ClassMatcherModifier__Group_1_2_1_1__0 )
        // InternalBXtendDSLParser.g:4880:7: rule__ClassMatcherModifier__Group_1_2_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_2_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred48_InternalBXtendDSLParser

    // $ANTLR start synpred49_InternalBXtendDSLParser
    public final void synpred49_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4885:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4885:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4885:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) ) )
        // InternalBXtendDSLParser.g:4886:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred49_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2)");
        }
        // InternalBXtendDSLParser.g:4886:120: ( ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) ) )
        // InternalBXtendDSLParser.g:4887:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_2_1(), 2);
        // InternalBXtendDSLParser.g:4893:5: ( ( rule__ClassMatcherModifier__Group_1_2_1_2__0 ) )
        // InternalBXtendDSLParser.g:4894:6: ( rule__ClassMatcherModifier__Group_1_2_1_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_2_1_2()); 
        }
        // InternalBXtendDSLParser.g:4895:6: ( rule__ClassMatcherModifier__Group_1_2_1_2__0 )
        // InternalBXtendDSLParser.g:4895:7: rule__ClassMatcherModifier__Group_1_2_1_2__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_2_1_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred49_InternalBXtendDSLParser

    // $ANTLR start synpred50_InternalBXtendDSLParser
    public final void synpred50_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4929:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1 )
        // InternalBXtendDSLParser.g:4929:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_2_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalBXtendDSLParser

    // $ANTLR start synpred51_InternalBXtendDSLParser
    public final void synpred51_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4941:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2 )
        // InternalBXtendDSLParser.g:4941:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_2_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_InternalBXtendDSLParser

    // $ANTLR start synpred52_InternalBXtendDSLParser
    public final void synpred52_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4953:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3 )
        // InternalBXtendDSLParser.g:4953:2: rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_2_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalBXtendDSLParser

    // $ANTLR start synpred53_InternalBXtendDSLParser
    public final void synpred53_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4977:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0 )
        // InternalBXtendDSLParser.g:4977:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_3_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalBXtendDSLParser

    // $ANTLR start synpred54_InternalBXtendDSLParser
    public final void synpred54_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:4992:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:4992:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:4992:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) ) )
        // InternalBXtendDSLParser.g:4993:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred54_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0)");
        }
        // InternalBXtendDSLParser.g:4993:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) ) )
        // InternalBXtendDSLParser.g:4994:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 0);
        // InternalBXtendDSLParser.g:5000:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_0__0 ) )
        // InternalBXtendDSLParser.g:5001:6: ( rule__ClassMatcherModifier__Group_1_3_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_0()); 
        }
        // InternalBXtendDSLParser.g:5002:6: ( rule__ClassMatcherModifier__Group_1_3_1_0__0 )
        // InternalBXtendDSLParser.g:5002:7: rule__ClassMatcherModifier__Group_1_3_1_0__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_3_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred54_InternalBXtendDSLParser

    // $ANTLR start synpred55_InternalBXtendDSLParser
    public final void synpred55_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5007:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:5007:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:5007:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) ) )
        // InternalBXtendDSLParser.g:5008:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred55_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1)");
        }
        // InternalBXtendDSLParser.g:5008:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) ) )
        // InternalBXtendDSLParser.g:5009:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 1);
        // InternalBXtendDSLParser.g:5015:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_1__0 ) )
        // InternalBXtendDSLParser.g:5016:6: ( rule__ClassMatcherModifier__Group_1_3_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_1()); 
        }
        // InternalBXtendDSLParser.g:5017:6: ( rule__ClassMatcherModifier__Group_1_3_1_1__0 )
        // InternalBXtendDSLParser.g:5017:7: rule__ClassMatcherModifier__Group_1_3_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_3_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred55_InternalBXtendDSLParser

    // $ANTLR start synpred56_InternalBXtendDSLParser
    public final void synpred56_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5022:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:5022:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:5022:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) ) )
        // InternalBXtendDSLParser.g:5023:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred56_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2)");
        }
        // InternalBXtendDSLParser.g:5023:120: ( ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) ) )
        // InternalBXtendDSLParser.g:5024:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_3_1(), 2);
        // InternalBXtendDSLParser.g:5030:5: ( ( rule__ClassMatcherModifier__Group_1_3_1_2__0 ) )
        // InternalBXtendDSLParser.g:5031:6: ( rule__ClassMatcherModifier__Group_1_3_1_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_3_1_2()); 
        }
        // InternalBXtendDSLParser.g:5032:6: ( rule__ClassMatcherModifier__Group_1_3_1_2__0 )
        // InternalBXtendDSLParser.g:5032:7: rule__ClassMatcherModifier__Group_1_3_1_2__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_3_1_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred56_InternalBXtendDSLParser

    // $ANTLR start synpred57_InternalBXtendDSLParser
    public final void synpred57_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5066:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1 )
        // InternalBXtendDSLParser.g:5066:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_3_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalBXtendDSLParser

    // $ANTLR start synpred58_InternalBXtendDSLParser
    public final void synpred58_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5078:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2 )
        // InternalBXtendDSLParser.g:5078:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_3_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalBXtendDSLParser

    // $ANTLR start synpred59_InternalBXtendDSLParser
    public final void synpred59_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5090:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3 )
        // InternalBXtendDSLParser.g:5090:2: rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_3_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalBXtendDSLParser

    // $ANTLR start synpred60_InternalBXtendDSLParser
    public final void synpred60_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5114:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0 )
        // InternalBXtendDSLParser.g:5114:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_4_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalBXtendDSLParser

    // $ANTLR start synpred61_InternalBXtendDSLParser
    public final void synpred61_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5129:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:5129:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:5129:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) ) )
        // InternalBXtendDSLParser.g:5130:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0)");
        }
        // InternalBXtendDSLParser.g:5130:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) ) )
        // InternalBXtendDSLParser.g:5131:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 0);
        // InternalBXtendDSLParser.g:5137:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_0__0 ) )
        // InternalBXtendDSLParser.g:5138:6: ( rule__ClassMatcherModifier__Group_1_4_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_0()); 
        }
        // InternalBXtendDSLParser.g:5139:6: ( rule__ClassMatcherModifier__Group_1_4_1_0__0 )
        // InternalBXtendDSLParser.g:5139:7: rule__ClassMatcherModifier__Group_1_4_1_0__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_4_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred61_InternalBXtendDSLParser

    // $ANTLR start synpred62_InternalBXtendDSLParser
    public final void synpred62_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5144:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:5144:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:5144:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) ) )
        // InternalBXtendDSLParser.g:5145:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred62_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1)");
        }
        // InternalBXtendDSLParser.g:5145:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) ) )
        // InternalBXtendDSLParser.g:5146:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 1);
        // InternalBXtendDSLParser.g:5152:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_1__0 ) )
        // InternalBXtendDSLParser.g:5153:6: ( rule__ClassMatcherModifier__Group_1_4_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_1()); 
        }
        // InternalBXtendDSLParser.g:5154:6: ( rule__ClassMatcherModifier__Group_1_4_1_1__0 )
        // InternalBXtendDSLParser.g:5154:7: rule__ClassMatcherModifier__Group_1_4_1_1__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_4_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred62_InternalBXtendDSLParser

    // $ANTLR start synpred63_InternalBXtendDSLParser
    public final void synpred63_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5159:3: ( ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) ) )
        // InternalBXtendDSLParser.g:5159:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) )
        {
        // InternalBXtendDSLParser.g:5159:3: ({...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) ) )
        // InternalBXtendDSLParser.g:5160:4: {...}? => ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_InternalBXtendDSLParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2)");
        }
        // InternalBXtendDSLParser.g:5160:120: ( ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) ) )
        // InternalBXtendDSLParser.g:5161:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getClassMatcherModifierAccess().getUnorderedGroup_1_4_1(), 2);
        // InternalBXtendDSLParser.g:5167:5: ( ( rule__ClassMatcherModifier__Group_1_4_1_2__0 ) )
        // InternalBXtendDSLParser.g:5168:6: ( rule__ClassMatcherModifier__Group_1_4_1_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClassMatcherModifierAccess().getGroup_1_4_1_2()); 
        }
        // InternalBXtendDSLParser.g:5169:6: ( rule__ClassMatcherModifier__Group_1_4_1_2__0 )
        // InternalBXtendDSLParser.g:5169:7: rule__ClassMatcherModifier__Group_1_4_1_2__0
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__Group_1_4_1_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred63_InternalBXtendDSLParser

    // $ANTLR start synpred64_InternalBXtendDSLParser
    public final void synpred64_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5203:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1 )
        // InternalBXtendDSLParser.g:5203:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_4_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalBXtendDSLParser

    // $ANTLR start synpred65_InternalBXtendDSLParser
    public final void synpred65_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5215:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2 )
        // InternalBXtendDSLParser.g:5215:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_4_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_InternalBXtendDSLParser

    // $ANTLR start synpred66_InternalBXtendDSLParser
    public final void synpred66_InternalBXtendDSLParser_fragment() throws RecognitionException {   
        // InternalBXtendDSLParser.g:5227:2: ( rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3 )
        // InternalBXtendDSLParser.g:5227:2: rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3
        {
        pushFollow(FOLLOW_2);
        rule__ClassMatcherModifier__UnorderedGroup_1_4_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalBXtendDSLParser

    // Delegated rules

    public final boolean synpred56_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalBXtendDSLParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalBXtendDSLParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\u0179\uffff";
    static final String dfa_2s = "\2\uffff\1\10\1\11\1\14\1\16\1\17\12\uffff\1\17\1\uffff\1\11\1\16\1\14\1\17\1\10\1\uffff\1\16\1\14\1\10\1\11\1\uffff\1\16\2\17\1\11\1\14\1\uffff\1\10\1\uffff\1\10\1\14\1\16\1\11\33\uffff\1\11\1\16\1\14\1\17\1\uffff\1\11\1\16\1\14\1\17\2\uffff\1\14\1\16\1\uffff\1\11\1\14\1\uffff\2\17\2\uffff\1\16\1\11\1\uffff\1\10\1\uffff\1\16\1\14\1\17\1\uffff\1\14\1\16\2\10\1\uffff\1\14\1\uffff\2\17\2\uffff\1\16\1\10\1\17\1\10\1\uffff\1\16\1\11\1\10\1\11\2\uffff\1\17\1\uffff\1\10\1\uffff\1\16\1\11\1\uffff\1\10\1\11\1\uffff\1\14\1\10\1\11\1\14\1\uffff\1\17\1\uffff\1\10\1\11\1\16\1\14\71\uffff\1\14\1\16\1\11\3\uffff\1\16\1\14\2\uffff\1\11\1\uffff\1\14\3\uffff\1\16\1\11\1\17\1\uffff\1\14\1\16\1\11\1\17\2\uffff\1\16\1\14\1\17\1\uffff\1\11\1\uffff\1\14\1\17\2\uffff\1\16\1\11\1\17\3\uffff\1\16\1\17\3\uffff\1\14\1\17\3\uffff\1\11\2\uffff\1\14\1\16\1\10\1\uffff\1\10\2\uffff\1\14\1\uffff\1\10\2\uffff\1\16\1\17\1\10\1\uffff\1\16\1\14\1\17\1\10\2\uffff\1\16\1\17\1\10\2\uffff\1\14\1\10\3\uffff\1\17\1\uffff\1\11\1\uffff\1\16\1\10\1\17\1\10\1\uffff\1\16\1\11\1\10\1\11\2\uffff\1\17\1\uffff\1\11\2\uffff\1\10\1\uffff\1\11\1\14\1\uffff\1\10\1\17\1\10\1\11\1\uffff\1\14\1\uffff\1\11\1\14\1\16\1\10\67\uffff";
    static final String dfa_3s = "\1\34\1\6\5\25\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\31\25\31\6\113\25\67\6\175\25\2\6\1\7\6\6\2\7\1\6\1\7\4\6\1\7\2\6\1\12\1\7\1\12\2\7\1\6\1\12\2\6\1\7\3\6\2\7\2\6\2\7\1\11\1\6\2\11\2\7\1\11\1\7\4\11\4\6";
    static final String dfa_4s = "\1\34\1\15\5\30\1\15\2\uffff\2\15\1\uffff\1\15\2\uffff\1\15\1\30\1\25\5\30\1\25\4\30\1\25\5\30\1\25\1\30\1\25\4\30\31\15\2\25\4\30\1\25\4\30\2\25\2\30\1\25\2\30\1\25\2\30\2\25\2\30\1\25\1\30\1\25\3\30\1\25\4\30\1\25\1\30\1\25\2\30\2\25\4\30\1\25\4\30\2\25\1\30\1\25\1\30\1\25\2\30\1\25\2\30\1\25\4\30\1\25\1\30\1\25\4\30\67\15\2\25\3\30\3\25\2\30\2\25\1\30\1\25\1\30\3\25\3\30\1\25\4\30\2\25\3\30\1\25\1\30\1\25\2\30\2\25\3\30\3\25\2\30\3\25\2\30\3\25\1\30\2\25\3\30\1\25\1\30\2\25\1\30\1\25\1\30\2\25\3\30\1\25\4\30\2\25\3\30\2\25\2\30\3\25\1\30\1\25\1\30\1\25\4\30\1\25\4\30\2\25\1\30\1\25\1\30\2\25\1\30\1\25\2\30\1\25\4\30\1\25\1\30\1\25\4\30\4\15\3\7\7\15\4\12\1\15\1\12\3\15\3\12\1\15\10\11\10\12\14\15";
    static final String dfa_5s = "\10\uffff\1\2\1\3\2\uffff\1\4\1\uffff\1\5\1\1\u0169\uffff";
    static final String dfa_6s = "\u0179\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\4\1\5\1\uffff\1\2\1\6\2\uffff\1\3",
            "\1\7\2\uffff\1\10",
            "\1\12\2\uffff\1\11",
            "\1\13\2\uffff\1\14",
            "\1\15\2\uffff\1\16",
            "\1\20\2\uffff\1\17",
            "\1\25\1\24\1\uffff\1\22\1\21\2\uffff\1\23",
            "",
            "",
            "\1\32\1\31\1\uffff\1\27\1\26\2\uffff\1\30",
            "\1\35\1\36\1\uffff\1\33\1\37\2\uffff\1\34",
            "",
            "\1\42\1\43\1\uffff\1\44\1\40\2\uffff\1\41",
            "",
            "",
            "\1\47\1\50\1\uffff\1\46\1\45\2\uffff\1\51",
            "\1\52\2\uffff\1\17",
            "\1\53",
            "\1\54\2\uffff\1\11",
            "\1\55\2\uffff\1\16",
            "\1\56\2\uffff\1\14",
            "\1\57\2\uffff\1\17",
            "\1\60\2\uffff\1\10",
            "\1\61",
            "\1\62\2\uffff\1\16",
            "\1\63\2\uffff\1\14",
            "\1\64\2\uffff\1\10",
            "\1\65\2\uffff\1\11",
            "\1\66",
            "\1\67\2\uffff\1\16",
            "\1\70\2\uffff\1\17",
            "\1\71\2\uffff\1\17",
            "\1\72\2\uffff\1\11",
            "\1\73\2\uffff\1\14",
            "\1\74",
            "\1\75\2\uffff\1\10",
            "\1\76",
            "\1\77\2\uffff\1\10",
            "\1\100\2\uffff\1\14",
            "\1\101\2\uffff\1\16",
            "\1\102\2\uffff\1\11",
            "\1\107\1\106\1\uffff\1\104\1\103\2\uffff\1\105",
            "\1\114\1\113\1\uffff\1\111\1\110\2\uffff\1\112",
            "\1\120\1\121\1\uffff\1\116\1\115\2\uffff\1\117",
            "\1\124\1\125\1\uffff\1\122\1\126\2\uffff\1\123",
            "\1\131\1\132\1\uffff\1\130\1\127\2\uffff\1\133",
            "\1\140\1\137\1\uffff\1\135\1\134\2\uffff\1\136",
            "\1\120\1\121\1\uffff\1\116\1\115\2\uffff\1\117",
            "\1\143\1\144\1\uffff\1\145\1\141\2\uffff\1\142",
            "\1\150\1\151\1\uffff\1\146\1\152\2\uffff\1\147",
            "\1\155\1\156\1\uffff\1\157\1\153\2\uffff\1\154",
            "\1\131\1\132\1\uffff\1\130\1\127\2\uffff\1\133",
            "\1\155\1\156\1\uffff\1\157\1\153\2\uffff\1\154",
            "\1\162\1\163\1\uffff\1\161\1\160\2\uffff\1\164",
            "\1\167\1\170\1\uffff\1\165\1\171\2\uffff\1\166",
            "\1\174\1\175\1\uffff\1\173\1\172\2\uffff\1\176",
            "\1\u0083\1\u0082\1\uffff\1\u0080\1\177\2\uffff\1\u0081",
            "\1\150\1\151\1\uffff\1\146\1\152\2\uffff\1\147",
            "\1\167\1\170\1\uffff\1\165\1\171\2\uffff\1\166",
            "\1\u0086\1\u0087\1\uffff\1\u0084\1\u0088\2\uffff\1\u0085",
            "\1\124\1\125\1\uffff\1\122\1\126\2\uffff\1\123",
            "\1\u008d\1\u008c\1\uffff\1\u008a\1\u0089\2\uffff\1\u008b",
            "\1\107\1\106\1\uffff\1\104\1\103\2\uffff\1\105",
            "\1\174\1\175\1\uffff\1\173\1\172\2\uffff\1\176",
            "\1\u0083\1\u0082\1\uffff\1\u0080\1\177\2\uffff\1\u0081",
            "\1\140\1\137\1\uffff\1\135\1\134\2\uffff\1\136",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090\2\uffff\1\11",
            "\1\u0091\2\uffff\1\16",
            "\1\u0092\2\uffff\1\14",
            "\1\u008e\2\uffff\1\17",
            "\1\u0093",
            "\1\u0094\2\uffff\1\11",
            "\1\u0095\2\uffff\1\16",
            "\1\u0096\2\uffff\1\14",
            "\1\u0097\2\uffff\1\17",
            "\1\u0098",
            "\1\u0094",
            "\1\u0099\2\uffff\1\14",
            "\1\u009a\2\uffff\1\16",
            "\1\u009b",
            "\1\u009c\2\uffff\1\11",
            "\1\u009d\2\uffff\1\14",
            "\1\u0095",
            "\1\u009e\2\uffff\1\17",
            "\1\u009f\2\uffff\1\17",
            "\1\u00a0",
            "\1\u0096",
            "\1\u00a1\2\uffff\1\16",
            "\1\u00a2\2\uffff\1\11",
            "\1\u00a3",
            "\1\u00a4\2\uffff\1\10",
            "\1\u00a5",
            "\1\u00a6\2\uffff\1\16",
            "\1\u00a7\2\uffff\1\14",
            "\1\u00a3\2\uffff\1\17",
            "\1\u00a8",
            "\1\u00a9\2\uffff\1\14",
            "\1\u00aa\2\uffff\1\16",
            "\1\u0098\2\uffff\1\10",
            "\1\u00ab\2\uffff\1\10",
            "\1\u00ac",
            "\1\u00ad\2\uffff\1\14",
            "\1\u00aa",
            "\1\u00ae\2\uffff\1\17",
            "\1\u00af\2\uffff\1\17",
            "\1\u00b0",
            "\1\u00a9",
            "\1\u00b1\2\uffff\1\16",
            "\1\u00b2\2\uffff\1\10",
            "\1\u00b3\2\uffff\1\17",
            "\1\u00a0\2\uffff\1\10",
            "\1\u00b4",
            "\1\u00b5\2\uffff\1\16",
            "\1\u00b0\2\uffff\1\11",
            "\1\u00b6\2\uffff\1\10",
            "\1\u00b7\2\uffff\1\11",
            "\1\u00b8",
            "\1\u00b5",
            "\1\u00b9\2\uffff\1\17",
            "\1\u00b3",
            "\1\u00ba\2\uffff\1\10",
            "\1\u00bb",
            "\1\u00bc\2\uffff\1\16",
            "\1\u00bd\2\uffff\1\11",
            "\1\u00be",
            "\1\u00bf\2\uffff\1\10",
            "\1\u00c0\2\uffff\1\11",
            "\1\u00c1",
            "\1\u00c2\2\uffff\1\14",
            "\1\u009b\2\uffff\1\10",
            "\1\u00ac\2\uffff\1\11",
            "\1\u00b8\2\uffff\1\14",
            "\1\u00c3",
            "\1\u00be\2\uffff\1\17",
            "\1\u00c4",
            "\1\u008f\2\uffff\1\10",
            "\1\u00a5\2\uffff\1\11",
            "\1\u00c1\2\uffff\1\16",
            "\1\u00bb\2\uffff\1\14",
            "\1\u00c7\1\u00c8\1\uffff\1\u00c6\1\u00c5\2\uffff\1\u00c9",
            "\1\u00c7\1\u00c8\1\uffff\1\u00c6\1\u00c5\2\uffff\1\u00c9",
            "\1\u00ce\1\u00cd\1\uffff\1\u00cb\1\u00ca\2\uffff\1\u00cc",
            "\1\u00d3\1\u00d2\1\uffff\1\u00d0\1\u00cf\2\uffff\1\u00d1",
            "\1\u00d6\1\u00d7\1\uffff\1\u00d5\1\u00d4\2\uffff\1\u00d8",
            "\1\u00db\1\u00dc\1\uffff\1\u00da\1\u00d9\2\uffff\1\u00dd",
            "\1\u00e2\1\u00e1\1\uffff\1\u00df\1\u00de\2\uffff\1\u00e0",
            "\1\u00e7\1\u00e6\1\uffff\1\u00e4\1\u00e3\2\uffff\1\u00e5",
            "\1\u00ea\1\u00eb\1\uffff\1\u00e9\1\u00e8\2\uffff\1\u00ec",
            "\1\u00ce\1\u00cd\1\uffff\1\u00cb\1\u00ca\2\uffff\1\u00cc",
            "\1\u00e2\1\u00e1\1\uffff\1\u00df\1\u00de\2\uffff\1\u00e0",
            "\1\u00f0\1\u00f1\1\uffff\1\u00ee\1\u00ed\2\uffff\1\u00ef",
            "\1\u00f6\1\u00f5\1\uffff\1\u00f3\1\u00f2\2\uffff\1\u00f4",
            "\1\u00e7\1\u00e6\1\uffff\1\u00e4\1\u00e3\2\uffff\1\u00e5",
            "\1\u00f6\1\u00f5\1\uffff\1\u00f3\1\u00f2\2\uffff\1\u00f4",
            "\1\u00f9\1\u00fa\1\uffff\1\u00f8\1\u00f7\2\uffff\1\u00fb",
            "\1\u00d3\1\u00d2\1\uffff\1\u00d0\1\u00cf\2\uffff\1\u00d1",
            "\1\u00d6\1\u00d7\1\uffff\1\u00d5\1\u00d4\2\uffff\1\u00d8",
            "\1\u00ea\1\u00eb\1\uffff\1\u00e9\1\u00e8\2\uffff\1\u00ec",
            "\1\u00f9\1\u00fa\1\uffff\1\u00f8\1\u00f7\2\uffff\1\u00fb",
            "\1\u00f0\1\u00f1\1\uffff\1\u00ee\1\u00ed\2\uffff\1\u00ef",
            "\1\u00fe\1\u00ff\1\uffff\1\u0100\1\u00fc\2\uffff\1\u00fd",
            "\1\u00ce\1\u00cd\1\uffff\1\u00cb\1\u00ca\2\uffff\1\u00cc",
            "\1\u00fe\1\u00ff\1\uffff\1\u0100\1\u00fc\2\uffff\1\u00fd",
            "\1\u0105\1\u0104\1\uffff\1\u0102\1\u0101\2\uffff\1\u0103",
            "\1\u0109\1\u010a\1\uffff\1\u0107\1\u0106\2\uffff\1\u0108",
            "\1\u010f\1\u010e\1\uffff\1\u010c\1\u010b\2\uffff\1\u010d",
            "\1\u0113\1\u0114\1\uffff\1\u0111\1\u0110\2\uffff\1\u0112",
            "\1\u0119\1\u0118\1\uffff\1\u0116\1\u0115\2\uffff\1\u0117",
            "\1\u00f6\1\u00f5\1\uffff\1\u00f3\1\u00f2\2\uffff\1\u00f4",
            "\1\u0119\1\u0118\1\uffff\1\u0116\1\u0115\2\uffff\1\u0117",
            "\1\u011c\1\u011d\1\uffff\1\u011a\1\u011e\2\uffff\1\u011b",
            "\1\u0105\1\u0104\1\uffff\1\u0102\1\u0101\2\uffff\1\u0103",
            "\1\u0109\1\u010a\1\uffff\1\u0107\1\u0106\2\uffff\1\u0108",
            "\1\u0113\1\u0114\1\uffff\1\u0111\1\u0110\2\uffff\1\u0112",
            "\1\u011c\1\u011d\1\uffff\1\u011a\1\u011e\2\uffff\1\u011b",
            "\1\u00f0\1\u00f1\1\uffff\1\u00ee\1\u00ed\2\uffff\1\u00ef",
            "\1\u0121\1\u0122\1\uffff\1\u0123\1\u011f\2\uffff\1\u0120",
            "\1\u0126\1\u0127\1\uffff\1\u0125\1\u0124\2\uffff\1\u0128",
            "\1\u012b\1\u012c\1\uffff\1\u0129\1\u012d\2\uffff\1\u012a",
            "\1\u00f9\1\u00fa\1\uffff\1\u00f8\1\u00f7\2\uffff\1\u00fb",
            "\1\u011c\1\u011d\1\uffff\1\u011a\1\u011e\2\uffff\1\u011b",
            "\1\u012b\1\u012c\1\uffff\1\u0129\1\u012d\2\uffff\1\u012a",
            "\1\u0130\1\u0131\1\uffff\1\u0132\1\u012e\2\uffff\1\u012f",
            "\1\u00d6\1\u00d7\1\uffff\1\u00d5\1\u00d4\2\uffff\1\u00d8",
            "\1\u0121\1\u0122\1\uffff\1\u0123\1\u011f\2\uffff\1\u0120",
            "\1\u0130\1\u0131\1\uffff\1\u0132\1\u012e\2\uffff\1\u012f",
            "\1\u0109\1\u010a\1\uffff\1\u0107\1\u0106\2\uffff\1\u0108",
            "\1\u0135\1\u0136\1\uffff\1\u0137\1\u0133\2\uffff\1\u0134",
            "\1\u00d3\1\u00d2\1\uffff\1\u00d0\1\u00cf\2\uffff\1\u00d1",
            "\1\u0105\1\u0104\1\uffff\1\u0102\1\u0101\2\uffff\1\u0103",
            "\1\u0135\1\u0136\1\uffff\1\u0137\1\u0133\2\uffff\1\u0134",
            "\1\u0130\1\u0131\1\uffff\1\u0132\1\u012e\2\uffff\1\u012f",
            "\1\u013c\1\u013b\1\uffff\1\u0139\1\u0138\2\uffff\1\u013a",
            "\1\u013f\1\u0140\1\uffff\1\u0141\1\u013d\2\uffff\1\u013e",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144\2\uffff\1\14",
            "\1\u0145\2\uffff\1\16",
            "\1\u0146\2\uffff\1\11",
            "\1\u0147",
            "\1\u0148",
            "\1\u0146",
            "\1\14\2\uffff\1\16",
            "\1\16\2\uffff\1\14",
            "\1\u0149",
            "\1\u014a",
            "\1\14\2\uffff\1\11",
            "\1\u0145",
            "\1\11\2\uffff\1\14",
            "\1\u014b",
            "\1\u014c",
            "\1\u0144",
            "\1\11\2\uffff\1\16",
            "\1\16\2\uffff\1\11",
            "\1\u0142\2\uffff\1\17",
            "\1\u014d",
            "\1\u014e\2\uffff\1\14",
            "\1\u014f\2\uffff\1\16",
            "\1\u0150\2\uffff\1\11",
            "\1\u0147\2\uffff\1\17",
            "\1\u0151",
            "\1\u0150",
            "\1\u0152\2\uffff\1\16",
            "\1\u0153\2\uffff\1\14",
            "\1\u0149\2\uffff\1\17",
            "\1\u0154",
            "\1\u0155\2\uffff\1\11",
            "\1\u014f",
            "\1\u0156\2\uffff\1\14",
            "\1\u014b\2\uffff\1\17",
            "\1\u0157",
            "\1\u014e",
            "\1\u0158\2\uffff\1\16",
            "\1\u0159\2\uffff\1\11",
            "\1\16\2\uffff\1\17",
            "\1\u015a",
            "\1\u0159",
            "\1\u0153",
            "\1\17\2\uffff\1\16",
            "\1\14\2\uffff\1\17",
            "\1\u015b",
            "\1\u0155",
            "\1\u0152",
            "\1\17\2\uffff\1\14",
            "\1\11\2\uffff\1\17",
            "\1\u015c",
            "\1\u0156",
            "\1\u0158",
            "\1\17\2\uffff\1\11",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f\2\uffff\1\14",
            "\1\u0160\2\uffff\1\16",
            "\1\u0148\2\uffff\1\10",
            "\1\u0161",
            "\1\14\2\uffff\1\10",
            "\1\u0162",
            "\1\u0160",
            "\1\10\2\uffff\1\14",
            "\1\u0163",
            "\1\16\2\uffff\1\10",
            "\1\u0164",
            "\1\u015f",
            "\1\10\2\uffff\1\16",
            "\1\u015d\2\uffff\1\17",
            "\1\u0151\2\uffff\1\10",
            "\1\u0165",
            "\1\u0166\2\uffff\1\16",
            "\1\u0167\2\uffff\1\14",
            "\1\u0163\2\uffff\1\17",
            "\1\u015a\2\uffff\1\10",
            "\1\u0168",
            "\1\u0167",
            "\1\u0169\2\uffff\1\16",
            "\1\u0161\2\uffff\1\17",
            "\1\u015b\2\uffff\1\10",
            "\1\u016a",
            "\1\u0166",
            "\1\u016b\2\uffff\1\14",
            "\1\17\2\uffff\1\10",
            "\1\u016c",
            "\1\u016b",
            "\1\u0169",
            "\1\10\2\uffff\1\17",
            "\1\u016d",
            "\1\u0164\2\uffff\1\11",
            "\1\u016e",
            "\1\u016f\2\uffff\1\16",
            "\1\u014c\2\uffff\1\10",
            "\1\u016d\2\uffff\1\17",
            "\1\u0157\2\uffff\1\10",
            "\1\u0170",
            "\1\u0171\2\uffff\1\16",
            "\1\u0168\2\uffff\1\11",
            "\1\u015c\2\uffff\1\10",
            "\1\u016c\2\uffff\1\11",
            "\1\u0172",
            "\1\u0171",
            "\1\u0173\2\uffff\1\17",
            "\1\u0173",
            "\1\10\2\uffff\1\11",
            "\1\u0174",
            "\1\u016f",
            "\1\11\2\uffff\1\10",
            "\1\u0175",
            "\1\u0162\2\uffff\1\11",
            "\1\u0174\2\uffff\1\14",
            "\1\u0176",
            "\1\u014a\2\uffff\1\10",
            "\1\u0175\2\uffff\1\17",
            "\1\u0154\2\uffff\1\10",
            "\1\u016a\2\uffff\1\11",
            "\1\u0177",
            "\1\u0172\2\uffff\1\14",
            "\1\u0178",
            "\1\u015e\2\uffff\1\11",
            "\1\u016e\2\uffff\1\14",
            "\1\u0176\2\uffff\1\16",
            "\1\u0143\2\uffff\1\10",
            "\1\14\1\16\5\uffff\1\11",
            "\1\14\1\16\5\uffff\1\11",
            "\1\16\5\uffff\1\11",
            "\1\14\6\uffff\1\11",
            "\1\14\1\16",
            "\1\14\1\16",
            "\1\14\1\16",
            "\1\14\6\uffff\1\11",
            "\1\14\6\uffff\1\11",
            "\1\16\5\uffff\1\11",
            "\1\16\5\uffff\1\11",
            "\1\14\1\16\2\uffff\1\17\2\uffff\1\11",
            "\1\16\2\uffff\1\17\2\uffff\1\11",
            "\1\14\3\uffff\1\17\2\uffff\1\11",
            "\1\14\1\16\2\uffff\1\17",
            "\1\14\1\16\2\uffff\1\17",
            "\1\14\3\uffff\1\17",
            "\1\16\2\uffff\1\17",
            "\1\14\3\uffff\1\17\2\uffff\1\11",
            "\1\14\3\uffff\1\17",
            "\1\17\2\uffff\1\11",
            "\1\16\2\uffff\1\17\2\uffff\1\11",
            "\1\17\2\uffff\1\11",
            "\1\16\2\uffff\1\17",
            "\1\16\2\uffff\1\17",
            "\1\14\3\uffff\1\17",
            "\1\17\2\uffff\1\11",
            "\1\14\1\16\1\uffff\1\10",
            "\1\14\1\16\1\uffff\1\10",
            "\1\16\1\uffff\1\10",
            "\1\14\2\uffff\1\10",
            "\1\14\2\uffff\1\10",
            "\1\14\2\uffff\1\10",
            "\1\16\1\uffff\1\10",
            "\1\16\1\uffff\1\10",
            "\1\14\1\16\1\uffff\1\10\1\17",
            "\1\14\2\uffff\1\10\1\17",
            "\1\16\1\uffff\1\10\1\17",
            "\1\16\1\uffff\1\10\1\17",
            "\1\10\1\17",
            "\1\14\2\uffff\1\10\1\17",
            "\1\10\1\17",
            "\1\10\1\17",
            "\1\16\1\uffff\1\10\3\uffff\1\11",
            "\1\16\1\uffff\1\10\3\uffff\1\11",
            "\1\10\3\uffff\1\11",
            "\1\16\1\uffff\1\10\1\17\2\uffff\1\11",
            "\1\10\1\17\2\uffff\1\11",
            "\1\10\1\17\2\uffff\1\11",
            "\1\10\3\uffff\1\11",
            "\1\10\3\uffff\1\11",
            "\1\14\2\uffff\1\10\3\uffff\1\11",
            "\1\14\2\uffff\1\10\3\uffff\1\11",
            "\1\14\2\uffff\1\10\1\17\2\uffff\1\11",
            "\1\14\1\16\1\uffff\1\10\3\uffff\1\11"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "493:1: rule__ClassMatcherModifier__Alternatives_1 : ( ( ( rule__ClassMatcherModifier__Group_1_0__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_1__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_2__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_3__0 ) ) | ( ( rule__ClassMatcherModifier__Group_1_4__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001848000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000048000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000000022C0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000000024C0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000000006C0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000002680L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000002640L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000000000C800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000000022C2L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00000000000024C2L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000000006C2L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000002682L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000002642L});

}
