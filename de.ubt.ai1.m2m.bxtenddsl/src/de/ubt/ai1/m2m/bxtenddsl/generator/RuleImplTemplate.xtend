package de.ubt.ai1.m2m.bxtenddsl.generator

/**
 * Template for a rule implementation stub.
 */
final class RuleImplTemplate {
	/**
	 * Returns the content of a rule implementation stub file.
	 */
	def static String getCode(String rule, String trafo, String rootPackage) {
		'''
package «rootPackage».rules;

import «rootPackage».trafo.«trafo»

class «rule»Impl extends «rule» {	
	new(«trafo» trafo) {
		super(trafo)
	}
}
		'''
	}
	
	private new() {
	}
}