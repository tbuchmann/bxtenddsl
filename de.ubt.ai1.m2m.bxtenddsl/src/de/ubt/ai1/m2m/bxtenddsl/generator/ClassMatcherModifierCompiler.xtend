package de.ubt.ai1.m2m.bxtenddsl.generator

import org.eclipse.xtend.lib.annotations.Data
import java.util.Collection
import java.util.Map
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
import java.util.List
import java.util.ArrayList
import com.google.inject.Inject
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
import java.util.HashMap
import java.util.Set
import java.util.HashSet
import de.ubt.ai1.m2m.bxtenddsl.utils.Utils

/**
 * A compiler for class matcher modifier. The creation and deletion modifier are compiled by
 * the CreationDeletionModifierCompiler.
 */
class ClassMatcherModifierCompiler {
	@Data static class Group {
		String definitions
		Collection<String> keyFunctions
		Map<ClassMatcher, String> matcherToGroupsId
	}
	@Data static class Filter {
		String call
		String filter
	}
	
	/**
	 * Compiles all group modifiers of the given matchers.
	 */
	def Group compileGroupModifier(List<? extends ClassMatcher> matcher, IdentifierScope ruleScope,
			IdentifierScope localScope) {
		val model = if (matcher.get(0) instanceof SrcClassMatcher) "sourceModel" else "targetModel"
		
		var definitions = new ArrayList<String>()
		var keyFunctions = new ArrayList<String>()
		var matcherToGroupsId = new HashMap<ClassMatcher, String>()
		for (e : matcher.filter[modifier.group]) {
			val keyFunctionIdSuggestion = "group" + e.name.toFirstUpper() + "Elem"
			val keyFunctionId = ruleScope.addIdentifier(keyFunctionIdSuggestion, IdentifierScope.Group.METHOD)
			val matcherType = e.clazz.qualifiedName
			keyFunctions += '''def protected abstract String «keyFunctionId»(«matcherType» «e.name»Elem);'''
			
			val groupsMapId = localScope.addIdentifier("_" + e.name + "GroupsMap", IdentifierScope.Group.VARIABLE)
			val groupsId = localScope.addIdentifier("_" + e.name + "Groups", IdentifierScope.Group.VARIABLE)
			matcherToGroupsId.put(e, groupsId)
			definitions += '''
			val «groupsMapId» = «model».allContents.filter(typeof(«matcherType»)).groupBy[«keyFunctionId»(it)]
			val «groupsId» = new ArrayList<List<«matcherType»>>() => [
				it += new ArrayList<«matcherType»>()
				it += «groupsMapId».filter[key, value | key !== null].values
			]
			'''
		}
		if (!definitions.empty) {
			definitions += System.lineSeparator()
		}
		return new Group(definitions.join(), keyFunctions, matcherToGroupsId)
	}
	
	/**
	 * Compiles the filter modifier of the given matcher.
	 */
	def Filter compileFilterModifier(ClassMatcher current, List<? extends ClassMatcher> before,
			IdentifierScope ruleScope) {
		if (current.modifier.filter) {
			val filterIdSuggestion = "filter" + current.name.toFirstUpper()
			val filterId = ruleScope.addIdentifier(filterIdSuggestion, IdentifierScope.Group.METHOD)
			var filterParams = new ArrayList<String>()
			filterParams += current.qualifiedType() + " " + current.name
			filterParams += (new ArrayList(before)).reverse().map[qualifiedType() + " " + name]
			val filter = '''def protected abstract boolean «filterId»(«filterParams.join(", ")»);'''
			
			var filterCallParams = new ArrayList<String>()
			filterCallParams += "it"
			filterCallParams += (new ArrayList(before)).reverse().map[name]
			val filterCall = '''.filter[«filterId»(«filterCallParams.join(", ")»)]'''
			return new Filter(filterCall, filter)
			
		} else {
			return new Filter("", null)
		}
	}
	
	/**
	 * Returns if the compilation of this matchers contains any abstract method.
	 */
	def boolean anyAbstractMethod(List<? extends ClassMatcher> matcher) {
		return matcher.exists[modifier.group || modifier.filter]
	}
	/**
	 * Returns all imports that the compilation of this matchers needs.
	 */
	def Set<String> neededImports(List<? extends ClassMatcher> matcher) {
		var imports = new HashSet<String>()
		if (matcher.exists[modifier.group && modifier.filter]) {
			imports += "import java.util.List"
		}
		if (matcher.exists[modifier.group]) {
			imports += "import java.util.ArrayList"
		}
		return imports
	}
	
	@Inject extension Utils
}
