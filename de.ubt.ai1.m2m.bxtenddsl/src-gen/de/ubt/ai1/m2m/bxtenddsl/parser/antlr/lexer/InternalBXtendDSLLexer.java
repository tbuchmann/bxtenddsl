package de.ubt.ai1.m2m.bxtenddsl.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBXtendDSLLexer extends Lexer {
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

    public InternalBXtendDSLLexer() {;} 
    public InternalBXtendDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBXtendDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBXtendDSLLexer.g"; }

    // $ANTLR start "Sourcemodel"
    public final void mSourcemodel() throws RecognitionException {
        try {
            int _type = Sourcemodel;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:14:13: ( 'sourcemodel' )
            // InternalBXtendDSLLexer.g:14:15: 'sourcemodel'
            {
            match("sourcemodel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sourcemodel"

    // $ANTLR start "Targetmodel"
    public final void mTargetmodel() throws RecognitionException {
        try {
            int _type = Targetmodel;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:16:13: ( 'targetmodel' )
            // InternalBXtendDSLLexer.g:16:15: 'targetmodel'
            {
            match("targetmodel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Targetmodel"

    // $ANTLR start "Creation"
    public final void mCreation() throws RecognitionException {
        try {
            int _type = Creation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:18:10: ( 'creation' )
            // InternalBXtendDSLLexer.g:18:12: 'creation'
            {
            match("creation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Creation"

    // $ANTLR start "Deletion"
    public final void mDeletion() throws RecognitionException {
        try {
            int _type = Deletion;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:20:10: ( 'deletion' )
            // InternalBXtendDSLLexer.g:20:12: 'deletion'
            {
            match("deletion"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Deletion"

    // $ANTLR start "Options"
    public final void mOptions() throws RecognitionException {
        try {
            int _type = Options;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:22:9: ( 'options' )
            // InternalBXtendDSLLexer.g:22:11: 'options'
            {
            match("options"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Options"

    // $ANTLR start "Filter"
    public final void mFilter() throws RecognitionException {
        try {
            int _type = Filter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:24:8: ( 'filter' )
            // InternalBXtendDSLLexer.g:24:10: 'filter'
            {
            match("filter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Filter"

    // $ANTLR start "Group"
    public final void mGroup() throws RecognitionException {
        try {
            int _type = Group;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:26:7: ( 'group' )
            // InternalBXtendDSLLexer.g:26:9: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Group"

    // $ANTLR start "LessThanSignHyphenMinusHyphenMinusGreaterThanSign"
    public final void mLessThanSignHyphenMinusHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignHyphenMinusHyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:28:51: ( '<-->' )
            // InternalBXtendDSLLexer.g:28:53: '<-->'
            {
            match("<-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignHyphenMinusHyphenMinusGreaterThanSign"

    // $ANTLR start "Rule"
    public final void mRule() throws RecognitionException {
        try {
            int _type = Rule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:30:6: ( 'rule' )
            // InternalBXtendDSLLexer.g:30:8: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rule"

    // $ANTLR start "Sort"
    public final void mSort() throws RecognitionException {
        try {
            int _type = Sort;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:32:6: ( 'sort' )
            // InternalBXtendDSLLexer.g:32:8: 'sort'
            {
            match("sort"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sort"

    // $ANTLR start "HyphenMinusHyphenMinusGreaterThanSign"
    public final void mHyphenMinusHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:34:39: ( '-->' )
            // InternalBXtendDSLLexer.g:34:41: '-->'
            {
            match("-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusHyphenMinusGreaterThanSign"

    // $ANTLR start "LessThanSignHyphenMinusHyphenMinus"
    public final void mLessThanSignHyphenMinusHyphenMinus() throws RecognitionException {
        try {
            int _type = LessThanSignHyphenMinusHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:36:36: ( '<--' )
            // InternalBXtendDSLLexer.g:36:38: '<--'
            {
            match("<--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignHyphenMinusHyphenMinus"

    // $ANTLR start "Get"
    public final void mGet() throws RecognitionException {
        try {
            int _type = Get;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:38:5: ( 'get' )
            // InternalBXtendDSLLexer.g:38:7: 'get'
            {
            match("get"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Get"

    // $ANTLR start "Set"
    public final void mSet() throws RecognitionException {
        try {
            int _type = Set;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:40:5: ( 'set' )
            // InternalBXtendDSLLexer.g:40:7: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Set"

    // $ANTLR start "Src"
    public final void mSrc() throws RecognitionException {
        try {
            int _type = Src;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:42:5: ( 'src' )
            // InternalBXtendDSLLexer.g:42:7: 'src'
            {
            match("src"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Src"

    // $ANTLR start "Trg"
    public final void mTrg() throws RecognitionException {
        try {
            int _type = Trg;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:44:5: ( 'trg' )
            // InternalBXtendDSLLexer.g:44:7: 'trg'
            {
            match("trg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Trg"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:46:4: ( 'as' )
            // InternalBXtendDSLLexer.g:46:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:48:7: ( ',' )
            // InternalBXtendDSLLexer.g:48:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:50:10: ( '.' )
            // InternalBXtendDSLLexer.g:50:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:52:7: ( ':' )
            // InternalBXtendDSLLexer.g:52:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:54:11: ( ';' )
            // InternalBXtendDSLLexer.g:54:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:56:19: ( '[' )
            // InternalBXtendDSLLexer.g:56:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:58:20: ( ']' )
            // InternalBXtendDSLLexer.g:58:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:60:18: ( '{' )
            // InternalBXtendDSLLexer.g:60:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:62:14: ( '|' )
            // InternalBXtendDSLLexer.g:62:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:64:19: ( '}' )
            // InternalBXtendDSLLexer.g:64:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:66:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBXtendDSLLexer.g:66:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalBXtendDSLLexer.g:66:35: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBXtendDSLLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:68:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBXtendDSLLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBXtendDSLLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBXtendDSLLexer.g:68:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBXtendDSLLexer.g:68:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBXtendDSLLexer.g:68:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLLexer.g:68:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalBXtendDSLLexer.g:68:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBXtendDSLLexer.g:68:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBXtendDSLLexer.g:68:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBXtendDSLLexer.g:68:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:70:9: ( ( ' ' )+ )
            // InternalBXtendDSLLexer.g:70:11: ( ' ' )+
            {
            // InternalBXtendDSLLexer.g:70:11: ( ' ' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBXtendDSLLexer.g:70:11: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_INDENTATION"
    public final void mRULE_INDENTATION() throws RecognitionException {
        try {
            int _type = RULE_INDENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:72:18: ( ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )* )
            // InternalBXtendDSLLexer.g:72:20: ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )*
            {
            // InternalBXtendDSLLexer.g:72:20: ( '\\r\\n' | '\\n' | '\\r' )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=3;}
            }
            else if ( (LA6_0=='\n') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBXtendDSLLexer.g:72:21: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLLexer.g:72:28: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // InternalBXtendDSLLexer.g:72:33: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            // InternalBXtendDSLLexer.g:72:39: ( '\\t' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBXtendDSLLexer.g:72:39: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INDENTATION"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBXtendDSLLexer.g:74:17: ( ( '//' (~ ( ( '\\n' | '\\r' ) ) )* | ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )* '//' (~ ( ( '\\n' | '\\r' ) ) )* ) )
            // InternalBXtendDSLLexer.g:74:19: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* | ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )* '//' (~ ( ( '\\n' | '\\r' ) ) )* )
            {
            // InternalBXtendDSLLexer.g:74:19: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* | ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )* '//' (~ ( ( '\\n' | '\\r' ) ) )* )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='/') ) {
                alt12=1;
            }
            else if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBXtendDSLLexer.g:74:20: '//' (~ ( ( '\\n' | '\\r' ) ) )*
                    {
                    match("//"); 

                    // InternalBXtendDSLLexer.g:74:25: (~ ( ( '\\n' | '\\r' ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalBXtendDSLLexer.g:74:25: ~ ( ( '\\n' | '\\r' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalBXtendDSLLexer.g:74:41: ( '\\r\\n' | '\\n' | '\\r' ) ( '\\t' )* '//' (~ ( ( '\\n' | '\\r' ) ) )*
                    {
                    // InternalBXtendDSLLexer.g:74:41: ( '\\r\\n' | '\\n' | '\\r' )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1=='\n') ) {
                            alt9=1;
                        }
                        else if ( (LA9_1=='\t'||LA9_1=='/') ) {
                            alt9=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA9_0=='\n') ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalBXtendDSLLexer.g:74:42: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // InternalBXtendDSLLexer.g:74:49: '\\n'
                            {
                            match('\n'); 

                            }
                            break;
                        case 3 :
                            // InternalBXtendDSLLexer.g:74:54: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    // InternalBXtendDSLLexer.g:74:60: ( '\\t' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\t') ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalBXtendDSLLexer.g:74:60: '\\t'
                    	    {
                    	    match('\t'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match("//"); 

                    // InternalBXtendDSLLexer.g:74:71: (~ ( ( '\\n' | '\\r' ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalBXtendDSLLexer.g:74:71: ~ ( ( '\\n' | '\\r' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_TAB_INDENTED_BLOCK_BEGIN"
    public final void mRULE_TAB_INDENTED_BLOCK_BEGIN() throws RecognitionException {
        try {
            // InternalBXtendDSLLexer.g:76:40: ()
            // InternalBXtendDSLLexer.g:76:42: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAB_INDENTED_BLOCK_BEGIN"

    // $ANTLR start "RULE_TAB_INDENTED_BLOCK_END"
    public final void mRULE_TAB_INDENTED_BLOCK_END() throws RecognitionException {
        try {
            // InternalBXtendDSLLexer.g:78:38: ()
            // InternalBXtendDSLLexer.g:78:40: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAB_INDENTED_BLOCK_END"

    public void mTokens() throws RecognitionException {
        // InternalBXtendDSLLexer.g:1:8: ( Sourcemodel | Targetmodel | Creation | Deletion | Options | Filter | Group | LessThanSignHyphenMinusHyphenMinusGreaterThanSign | Rule | Sort | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignHyphenMinusHyphenMinus | Get | Set | Src | Trg | As | Comma | FullStop | Colon | Semicolon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_INDENTATION | RULE_SL_COMMENT )
        int alt13=31;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalBXtendDSLLexer.g:1:10: Sourcemodel
                {
                mSourcemodel(); 

                }
                break;
            case 2 :
                // InternalBXtendDSLLexer.g:1:22: Targetmodel
                {
                mTargetmodel(); 

                }
                break;
            case 3 :
                // InternalBXtendDSLLexer.g:1:34: Creation
                {
                mCreation(); 

                }
                break;
            case 4 :
                // InternalBXtendDSLLexer.g:1:43: Deletion
                {
                mDeletion(); 

                }
                break;
            case 5 :
                // InternalBXtendDSLLexer.g:1:52: Options
                {
                mOptions(); 

                }
                break;
            case 6 :
                // InternalBXtendDSLLexer.g:1:60: Filter
                {
                mFilter(); 

                }
                break;
            case 7 :
                // InternalBXtendDSLLexer.g:1:67: Group
                {
                mGroup(); 

                }
                break;
            case 8 :
                // InternalBXtendDSLLexer.g:1:73: LessThanSignHyphenMinusHyphenMinusGreaterThanSign
                {
                mLessThanSignHyphenMinusHyphenMinusGreaterThanSign(); 

                }
                break;
            case 9 :
                // InternalBXtendDSLLexer.g:1:123: Rule
                {
                mRule(); 

                }
                break;
            case 10 :
                // InternalBXtendDSLLexer.g:1:128: Sort
                {
                mSort(); 

                }
                break;
            case 11 :
                // InternalBXtendDSLLexer.g:1:133: HyphenMinusHyphenMinusGreaterThanSign
                {
                mHyphenMinusHyphenMinusGreaterThanSign(); 

                }
                break;
            case 12 :
                // InternalBXtendDSLLexer.g:1:171: LessThanSignHyphenMinusHyphenMinus
                {
                mLessThanSignHyphenMinusHyphenMinus(); 

                }
                break;
            case 13 :
                // InternalBXtendDSLLexer.g:1:206: Get
                {
                mGet(); 

                }
                break;
            case 14 :
                // InternalBXtendDSLLexer.g:1:210: Set
                {
                mSet(); 

                }
                break;
            case 15 :
                // InternalBXtendDSLLexer.g:1:214: Src
                {
                mSrc(); 

                }
                break;
            case 16 :
                // InternalBXtendDSLLexer.g:1:218: Trg
                {
                mTrg(); 

                }
                break;
            case 17 :
                // InternalBXtendDSLLexer.g:1:222: As
                {
                mAs(); 

                }
                break;
            case 18 :
                // InternalBXtendDSLLexer.g:1:225: Comma
                {
                mComma(); 

                }
                break;
            case 19 :
                // InternalBXtendDSLLexer.g:1:231: FullStop
                {
                mFullStop(); 

                }
                break;
            case 20 :
                // InternalBXtendDSLLexer.g:1:240: Colon
                {
                mColon(); 

                }
                break;
            case 21 :
                // InternalBXtendDSLLexer.g:1:246: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 22 :
                // InternalBXtendDSLLexer.g:1:256: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 23 :
                // InternalBXtendDSLLexer.g:1:274: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 24 :
                // InternalBXtendDSLLexer.g:1:293: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 25 :
                // InternalBXtendDSLLexer.g:1:310: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 26 :
                // InternalBXtendDSLLexer.g:1:323: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 27 :
                // InternalBXtendDSLLexer.g:1:341: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 28 :
                // InternalBXtendDSLLexer.g:1:349: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 29 :
                // InternalBXtendDSLLexer.g:1:361: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // InternalBXtendDSLLexer.g:1:369: RULE_INDENTATION
                {
                mRULE_INDENTATION(); 

                }
                break;
            case 31 :
                // InternalBXtendDSLLexer.g:1:386: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\7\25\1\uffff\1\25\1\uffff\1\25\14\uffff\2\53\1\uffff\13\25\1\uffff\1\25\1\72\2\53\1\uffff\2\25\1\75\1\76\1\25\1\100\5\25\1\106\1\110\1\25\1\uffff\1\25\1\113\2\uffff\1\25\1\uffff\5\25\3\uffff\1\122\1\25\1\uffff\5\25\1\131\1\uffff\5\25\1\137\1\uffff\4\25\1\144\1\uffff\2\25\1\147\1\150\1\uffff\2\25\2\uffff\2\25\1\155\1\156\2\uffff";
    static final String DFA13_eofS =
        "\157\uffff";
    static final String DFA13_minS =
        "\1\12\1\145\1\141\1\162\1\145\1\160\1\151\1\145\1\55\1\165\1\uffff\1\163\14\uffff\2\11\1\uffff\1\162\1\164\1\143\1\162\1\147\1\145\1\154\1\164\1\154\1\157\1\164\1\55\1\154\1\60\2\11\1\uffff\1\162\1\164\2\60\1\147\1\60\1\141\1\145\1\151\1\164\1\165\1\60\1\76\1\145\1\uffff\1\143\1\60\2\uffff\1\145\1\uffff\2\164\1\157\1\145\1\160\3\uffff\1\60\1\145\1\uffff\1\164\2\151\1\156\1\162\1\60\1\uffff\2\155\2\157\1\163\1\60\1\uffff\2\157\2\156\1\60\1\uffff\2\144\2\60\1\uffff\2\145\2\uffff\2\154\2\60\2\uffff";
    static final String DFA13_maxS =
        "\1\175\3\162\1\145\1\160\1\151\1\162\1\55\1\165\1\uffff\1\163\14\uffff\2\57\1\uffff\1\165\1\164\1\143\1\162\1\147\1\145\1\154\1\164\1\154\1\157\1\164\1\55\1\154\1\172\2\57\1\uffff\1\162\1\164\2\172\1\147\1\172\1\141\1\145\1\151\1\164\1\165\1\172\1\76\1\145\1\uffff\1\143\1\172\2\uffff\1\145\1\uffff\2\164\1\157\1\145\1\160\3\uffff\1\172\1\145\1\uffff\1\164\2\151\1\156\1\162\1\172\1\uffff\2\155\2\157\1\163\1\172\1\uffff\2\157\2\156\1\172\1\uffff\2\144\2\172\1\uffff\2\145\2\uffff\2\154\2\172\2\uffff";
    static final String DFA13_acceptS =
        "\12\uffff\1\13\1\uffff\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\37\20\uffff\1\36\16\uffff\1\21\2\uffff\1\16\1\17\1\uffff\1\20\5\uffff\1\15\1\10\1\14\2\uffff\1\12\6\uffff\1\11\6\uffff\1\7\5\uffff\1\6\4\uffff\1\5\2\uffff\1\3\1\4\4\uffff\1\1\1\2";
    static final String DFA13_specialS =
        "\157\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\31\2\uffff\1\30\22\uffff\1\27\1\uffff\1\26\4\uffff\1\26\4\uffff\1\14\1\12\1\15\1\32\12\uffff\1\16\1\17\1\10\4\uffff\32\25\1\20\1\uffff\1\21\1\uffff\1\25\1\uffff\1\13\1\25\1\3\1\4\1\25\1\6\1\7\7\25\1\5\2\25\1\11\1\1\1\2\6\25\1\22\1\23\1\24",
            "\1\34\11\uffff\1\33\2\uffff\1\35",
            "\1\36\20\uffff\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\14\uffff\1\44",
            "\1\46",
            "\1\47",
            "",
            "\1\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52\1\51\44\uffff\1\32",
            "\1\52\45\uffff\1\32",
            "",
            "\1\55\2\uffff\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\52\45\uffff\1\32",
            "\1\52\45\uffff\1\32",
            "",
            "\1\73",
            "\1\74",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\77",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\107",
            "\1\111",
            "",
            "\1\112",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\123",
            "",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\145",
            "\1\146",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\151",
            "\1\152",
            "",
            "",
            "\1\153",
            "\1\154",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Sourcemodel | Targetmodel | Creation | Deletion | Options | Filter | Group | LessThanSignHyphenMinusHyphenMinusGreaterThanSign | Rule | Sort | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignHyphenMinusHyphenMinus | Get | Set | Src | Trg | As | Comma | FullStop | Colon | Semicolon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_INDENTATION | RULE_SL_COMMENT );";
        }
    }
 

}