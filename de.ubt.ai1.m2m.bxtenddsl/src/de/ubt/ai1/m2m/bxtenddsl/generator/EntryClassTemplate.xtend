package de.ubt.ai1.m2m.bxtenddsl.generator

import java.util.List
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL

/**
 * Template for the entry class of the transformation.
 */
final class EntryClassTemplate {
	/**
	 * Returns the content of the entry class for the given transformation and adds all rules.
	 */
	def static String getCode(BXtendDSL dsl, String trafo, String rootPackage, List<String> rules) {
		'''
package «rootPackage».trafo

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import «rootPackage».rules.Elem2Elem
«FOR rule : rules»
	import «rootPackage».rules.«rule»
«ENDFOR»

class «trafo» extends Abstract«trafo» {
	«FOR option : dsl.config.options»
		public static val OPT_«option» = "«option»"
	«ENDFOR»
	static val options = #{«dsl.config.options.map["OPT_" + it].join(", ")»}
	
	val configuration = new HashMap<String, Object>()
	
	new() {
		super()
	}
	new(Resource source, Resource target, Resource correspondence) {
		super(source, target, correspondence)
	}
	
	override Object getOption(String option) {
		if (!options.contains(option)) {
			throw new IllegalArgumentException("Invalid option '" + option + "'! Valid options are " + options + ".")
		}
		return configuration.get(option)
	}
	override void setOption(String option, Object value) {
		if (!options.contains(option)) {
			throw new IllegalArgumentException("Invalid option '" + option + "'! Valid options are " + options + ".")
		}
		configuration.put(option, value)
	}
	
	override protected List<Elem2Elem> createRules() {
		var result = new ArrayList<Elem2Elem>()
		«FOR rule : rules»
			result += new «rule»(this)
		«ENDFOR»
		return result
	}
}
		'''
	}
	
	private new() {
	}
}