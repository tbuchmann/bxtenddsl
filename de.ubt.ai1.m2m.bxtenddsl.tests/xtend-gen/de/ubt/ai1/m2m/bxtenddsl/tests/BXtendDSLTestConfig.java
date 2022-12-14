package de.ubt.ai1.m2m.bxtenddsl.tests;

/**
 * Workspace relative paths are necessary here, because the tests are not executed in an eclipse context.
 */
@SuppressWarnings("all")
public final class BXtendDSLTestConfig {
  public static final String workspace = "C:/Users/Matthias/Desktop/Masterarbeit/BXtendDSL";
  
  public static final String pdb1Uri = "platform:/resource/Benchmarx/examples/pdb1topdb2/metamodels/PDB1/model/PersonsDB1.ecore";
  
  public static final String pdb1InvalidUri = "platform:/resource/InvalidTestModels/PersonsDB1Invalid.ecore";
  
  public static final String pdb1EClassUri = "platform:/resource/InvalidTestModels/PersonsDB1EClass.ecore";
  
  public static final String pdb2Uri = "platform:/resource/Benchmarx/examples/pdb1topdb2/metamodels/PDB2/model/PersonsDB2.ecore";
  
  public static final String GanttUri = "platform:/resource/Benchmarx/examples/gantttocpm/metamodels/Gantt/model/Gantt.ecore";
  
  public static final String CpmUri = "platform:/resource/Benchmarx/examples/gantttocpm/metamodels/CPM/model/CPM.ecore";
  
  public static final String bags1Uri = "platform:/resource/Benchmarx/examples/bag1tobag2/metamodels/Bag1/model/Bags1.ecore";
  
  public static final String bags2Uri = "platform:/resource/Benchmarx/examples/bag1tobag2/metamodels/Bag2/model/Bags2.ecore";
  
  public static final String PnUri = "platform:/resource/Benchmarx/examples/pntopnw/metamodels/Petrinet/model/PetriNet.ecore";
  
  public static final String PnwUri = "platform:/resource/Benchmarx/examples/pntopnw/metamodels/PetrinetWeighted/model/PetriNetWeighted.ecore";
  
  public static final String SqlUri = "platform:/resource/Benchmarx/examples/ecoretosql/metamodels/SQL/model/SQL.ecore";
  
  private BXtendDSLTestConfig() {
  }
}
