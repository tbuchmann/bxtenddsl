package de.ubt.ai1.m2m.bxtenddsl.generator

import java.util.List
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import java.util.ArrayList
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils
import com.google.inject.Inject

/**
 * A compiler for correspondence model element definitions.
 */
class CorrElemDefinitionCompiler extends Compiler {
	/**
	 * Compiles all correspondence model element definitions needed for the given matchers in the direction srcToTrg.
	 */
	def String compile(boolean srcToTrg, List<? extends ClassMatcher> relSrcMatcher,
			List<? extends ClassMatcher> relTrgMatcher, List<? extends ClassMatcher> usedRelTrgMatcher,
			IdentifierScope localScope) {
		val corrMethod = if (srcToTrg) "updateOrCreateCorrSrc" else "updateOrCreateCorrTrg"
		val corrElemMethod = if (srcToTrg) "getOrCreateTrg" else "getOrCreateSrc"
		val relTrgSuggestion = if (srcToTrg) "_trg" else "_src"
		
		for (matcher : relTrgMatcher) {
			localScope.addIdentifier(matcher.name, IdentifierScope.Group.VARIABLE) // matcher names are unique
		}
		
		val corr = localScope.addIdentifier("_corr", IdentifierScope.Group.VARIABLE)
		val additionalRelSrcElems = relSrcMatcher.subList(1, relSrcMatcher.size()).map['''wrap(«name»)'''].join(", ")
		
		var typeIds = new ArrayList<String>()
		var types = new ArrayList<String>()
		for (matcher : relTrgMatcher) {
			val typeId = localScope.addIdentifier("_" + matcher.name + "Type", IdentifierScope.Group.VARIABLE)
			typeIds += typeId
			types += '''val «typeId» = new CorrElemType("«matcher.clazz.name»", «matcher.modifier.group»)'''
		}
		
		val relTrg = localScope.addIdentifier(relTrgSuggestion, IdentifierScope.Group.VARIABLE)
		
		var relTrgElements = new ArrayList<String>()
		for (var i = 0; i < usedRelTrgMatcher.size(); i++) {
			val corrElemClass = if (!usedRelTrgMatcher.get(i).modifier.group) {
				neededImports += '''import *rootPackage.corrmodel.SingleElem'''
				"SingleElem"
			} else {
				neededImports += '''import *rootPackage.corrmodel.MultiElem'''
				neededImports += '''import java.util.List'''
				"MultiElem"
			}
			relTrgElements += '''val «usedRelTrgMatcher.get(i).name» = unwrap(«relTrg».get(«i») as «corrElemClass»)«
					» as «usedRelTrgMatcher.get(i).qualifiedType»'''
		}
		
		return '''
		val «corr» = wrap(«relSrcMatcher.get(0).name»).«corrMethod»(«additionalRelSrcElems»)
		«FOR type : types»
			«type»
		«ENDFOR»
		«IF !relTrgElements.empty»val «relTrg» = «ENDIF»«corr».«corrElemMethod»(«typeIds.join(", ")»)
		«FOR relTrgElement : relTrgElements»
			«relTrgElement»
		«ENDFOR»
		'''
	}
	
	@Inject extension Utils
}
