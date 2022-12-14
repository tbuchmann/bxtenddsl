package de.ubt.ai1.m2m.bxtenddsl.generator

import java.util.HashSet

/**
 * A set of unique identifiers.
 */
class IdentifierScope {
	enum Group {CLASS, METHOD, VARIABLE}
	
	/**
	 * Adds an identifier similar to suggestion to the scope.
	 * The added identifier is unique regarding its group.
	 * Returns the added identifier.
	 */
	def String addIdentifier(String suggestion, Group group) {
		val scope = switch group {
			case CLASS: classScope
			case METHOD: methodScope
			case VARIABLE: variableScope
			default: throw new AssertionError("Group should be CLASS, METHOD or VARIABLE!")
		}
		
		if (!scope.contains(suggestion)) {
			scope.add(suggestion)
			return suggestion
			
		} else {
			for (var i = 2; i <= 65536; i++) {
				val uniqueSuggestion = suggestion + "_" + i
				if (!scope.contains(uniqueSuggestion)) {
					scope.add(uniqueSuggestion)
					return uniqueSuggestion
				}
			}
			
			throw new AssertionError("Only 65536 different identifiers can be computed for a suggestion!")
		}
	}
	
	val HashSet<String> classScope = new HashSet<String>();
	val HashSet<String> methodScope = new HashSet<String>();
	val HashSet<String> variableScope = new HashSet<String>();
}