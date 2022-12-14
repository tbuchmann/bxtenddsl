package de.ubt.ai1.m2m.bxtenddsl.generator

import java.util.Set

/**
 * Super class for compilers. A compiler translates BXtendDSL code to Xtend fragments.
 */
abstract class Compiler {
	/**
	 * Returns all imports necessary for the Xtend fragments that were compiled since the last call to this method.
	 */
	def Set<String> neededImports(String rootPackage) {
		val neededImports = this.neededImports.map[replace("*rootPackage.", rootPackage + ".")].toSet()
		this.neededImports = newHashSet()
		return neededImports
	}
	
	protected Set<String> neededImports = newHashSet()
}
