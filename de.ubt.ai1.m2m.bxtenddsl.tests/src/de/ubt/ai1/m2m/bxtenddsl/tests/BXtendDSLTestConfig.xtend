package de.ubt.ai1.m2m.bxtenddsl.tests

/**
 * Workspace relative paths are necessary here, because the tests are not executed in an eclipse context.
 */
final class BXtendDSLTestConfig {
	val public static workspace = "C:/Users/Matthias/Desktop/Masterarbeit/BXtendDSL"
	
	val public static String pdb1Uri = "platform:/resource/Benchmarx/examples/pdb1topdb2/metamodels/PDB1/model/PersonsDB1.ecore"
	val public static String pdb1InvalidUri = "platform:/resource/InvalidTestModels/PersonsDB1Invalid.ecore"
	val public static String pdb1EClassUri = "platform:/resource/InvalidTestModels/PersonsDB1EClass.ecore"
	val public static String pdb2Uri = "platform:/resource/Benchmarx/examples/pdb1topdb2/metamodels/PDB2/model/PersonsDB2.ecore"
	val public static String GanttUri = "platform:/resource/Benchmarx/examples/gantttocpm/metamodels/Gantt/model/Gantt.ecore"
	val public static String CpmUri = "platform:/resource/Benchmarx/examples/gantttocpm/metamodels/CPM/model/CPM.ecore"
	val public static String bags1Uri = "platform:/resource/Benchmarx/examples/bag1tobag2/metamodels/Bag1/model/Bags1.ecore"
	val public static String bags2Uri = "platform:/resource/Benchmarx/examples/bag1tobag2/metamodels/Bag2/model/Bags2.ecore"
	val public static String PnUri = "platform:/resource/Benchmarx/examples/pntopnw/metamodels/Petrinet/model/PetriNet.ecore"
	val public static String PnwUri = "platform:/resource/Benchmarx/examples/pntopnw/metamodels/PetrinetWeighted/model/PetriNetWeighted.ecore"
	val public static String SqlUri = "platform:/resource/Benchmarx/examples/ecoretosql/metamodels/SQL/model/SQL.ecore"
	
	private new() {
	}
}