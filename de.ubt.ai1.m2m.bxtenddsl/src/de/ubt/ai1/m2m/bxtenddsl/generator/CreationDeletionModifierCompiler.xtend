package de.ubt.ai1.m2m.bxtenddsl.generator

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule
import java.util.ArrayList
import com.google.inject.Inject
import java.util.Set
import java.util.HashSet
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils

/**
 * A compiler for creation and deletion modifier.
 */
class CreationDeletionModifierCompiler {
	/**
	 * Compiles all selected creation and deletion modifiers of the given transformation rule.
	 */
	def String compile(boolean srcModifiers, boolean trgModifiers, TransformationRule rule, IdentifierScope ruleScope) {
		return '''
		«IF srcModifiers»
			«compileModifier(true, true, rule, ruleScope)»
			«compileModifier(true, false, rule, ruleScope)»
		«ENDIF»
		«IF trgModifiers»
			«compileModifier(false, true, rule, ruleScope)»
			«compileModifier(false, false, rule, ruleScope)»
		«ENDIF»
		'''
	}
	
	/**
	 * Returns if the compilation of this rule contains any abstract method.
	 */
	def boolean anyAbstractMethod(boolean srcModifiers, boolean trgModifiers, TransformationRule rule) {
		return (srcModifiers && anyModifierSet(true, true, rule))
				|| (trgModifiers && anyModifierSet(false, true, rule))
				|| (srcModifiers && anyModifierSet(true, false, rule))
				|| (trgModifiers && anyModifierSet(false, false, rule))
	}
	/**
	 * Returns all imports that the compilation of this rule needs.
	 */
	def Set<String> neededImports(boolean srcModifiers, boolean trgModifiers, TransformationRule rule) {
		var imports = new HashSet<String>()
		if ((srcModifiers && anyModifierSet(true, true, rule))
				|| (trgModifiers && anyModifierSet(false, true, rule))
				|| (srcModifiers && anyModifierSet(true, false, rule))
				|| (trgModifiers && anyModifierSet(false, false, rule))) {
			imports += "import org.eclipse.emf.ecore.EObject"
		}
		return imports
	}
	
	@Inject extension Utils
	
	def private boolean anyModifierSet(boolean srcModifier, boolean creation, TransformationRule rule) {
		val matcher = if (srcModifier) rule.srcMatcher else rule.trgMatcher
		if (creation) {
			return matcher.exists[modifier.creation]
		} else {
			return matcher.exists[modifier.deletion]
		}
	}
	
	def private String compileModifier(boolean srcModifier, boolean creation, TransformationRule rule,
			IdentifierScope ruleScope) {
		if (!anyModifierSet(srcModifier, creation, rule)) {
			return ''''''
		}
		
		val matcher = if (srcModifier) rule.srcMatcher else rule.trgMatcher
		val action = if (creation) "Creation" else "Deletion"
		val overrideId = if (creation) {
			if (srcModifier) "onSrcElemCreation" else "onTrgElemCreation"
		} else {
			if (srcModifier) "onSrcElemDeletion" else "onTrgElemDeletion"
		}
		val overrideParam = if (srcModifier) "srcElem" else "trgElem"
		
		var hooks = new ArrayList<String>()
		var hookCalls = new ArrayList<String>()
		for (var i = 0; i < matcher.size(); i++) {
			val current = matcher.get(i)
			if ((creation && current.modifier.creation) || (!creation && current.modifier.deletion)) {
				val currentId = if (!current.modifier.group) current.name else current.name + "Elem"
				val hookIdSuggestion = "on" + currentId.toFirstUpper() + action
				val hookId = ruleScope.addIdentifier(hookIdSuggestion, IdentifierScope.Group.METHOD)
				val hookParam = current.clazz.qualifiedName + " " + currentId
				hooks += '''def protected abstract void «hookId»(«hookParam»);'''
				hookCalls += '''case «i»: «hookId»(«overrideParam» as «current.clazz.qualifiedName»)'''
			}
		}
		
		return '''
		
		override void «overrideId»(EObject «overrideParam») {
			switch («overrideParam».corrElemPosition) {
				«FOR call : hookCalls»
					«call»
				«ENDFOR»
			}
		}
		«FOR hook : hooks»
			«hook»
		«ENDFOR»
		'''
	}
}