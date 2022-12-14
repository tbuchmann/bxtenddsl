package de.ubt.ai1.m2m.bxtenddsl.generator

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher
import java.util.List
import com.google.inject.Inject
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule

/**
 * Compiler that generates a data class for all source and all target matcher of a rule.
 */
class MatcherDataClassCompiler extends Compiler {
	/**
	 * Compiles a Source and a Target data class from srcMatcher/trgMatcher. Also generates methods to create a
	 * Source/Target instance from a correspondence.
	 */
	def String compile(List<SrcClassMatcher> srcMatcher, List<TrgClassMatcher> trgMatcher, IdentifierScope ruleScope) {
		neededImports += "import org.eclipse.xtend.lib.annotations.Data"
		if (srcMatcher.exists[modifier.group] || trgMatcher.exists[modifier.group]) {
			neededImports += "import java.util.List"
		}
		neededImports += '''import *rootPackage.corrmodel.Corr'''
		
		ruleScope.addIdentifier("Source", IdentifierScope.Group.CLASS)
		ruleScope.addIdentifier("source", IdentifierScope.Group.METHOD)
		ruleScope.addIdentifier("Target", IdentifierScope.Group.CLASS)
		ruleScope.addIdentifier("target", IdentifierScope.Group.METHOD)
		
		return '''
		@Data protected static class Source {
			«FOR matcher : srcMatcher»
				«matcher.qualifiedType» «matcher.name»
			«ENDFOR»
		}
		def protected static Source source(Corr _corr) {
			_corr.assertRuleId("«(srcMatcher.get(0).eContainer as TransformationRule).name»")
			«FOR matcher : srcMatcher»
				val «matcher.name» = unwrap(_corr.source.get(«srcMatcher.indexOf(matcher)»)) as «matcher.qualifiedType»
			«ENDFOR»
			return new Source(«srcMatcher.map[name].join(", ")»)
		}
		@Data protected static class Target {
			«FOR matcher : trgMatcher»
				«matcher.qualifiedType» «matcher.name»
			«ENDFOR»
		}
		def protected static Target target(Corr _corr) {
			_corr.assertRuleId("«(trgMatcher.get(0).eContainer as TransformationRule).name»")
			«FOR matcher : trgMatcher»
				val «matcher.name» = unwrap(_corr.target.get(«trgMatcher.indexOf(matcher)»)) as «matcher.qualifiedType»
			«ENDFOR»
			return new Target(«trgMatcher.map[name].join(", ")»)
		}
		'''
	}
	
	@Inject extension Utils
}
