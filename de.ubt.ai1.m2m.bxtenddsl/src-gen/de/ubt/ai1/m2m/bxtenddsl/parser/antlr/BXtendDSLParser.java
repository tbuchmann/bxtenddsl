/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.parser.antlr;

import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.parser.antlr.internal.InternalBXtendDSLParser;
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class BXtendDSLParser extends AbstractAntlrParser {

	@Inject
	private BXtendDSLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_INDENTATION", "RULE_SL_COMMENT");
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new BXtendDSLTokenSource(super.createLexer(stream));
	}
	
	/**
	 * Indentation aware languages do not support partial parsing since the lexer is inherently stateful.
	 * Override and return {@code true} if your terminal splitting is stateless.
	 */
	@Override
	protected boolean isReparseSupported() {
		return false;
	}

	@Override
	protected InternalBXtendDSLParser createParser(XtextTokenStream stream) {
		return new InternalBXtendDSLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "BXtendDSL";
	}

	public BXtendDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BXtendDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
