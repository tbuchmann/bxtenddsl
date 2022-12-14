package de.ubt.ai1.m2m.bxtenddsl.wizard;

/**
 * Data class for all the user input from the BXtendDSLWizardPage.
 */
public class WizardInput {
	public final String project;
	public final String rootPackage;
	public final String trafo;
	
	public final String source;
	public final String sourceBundle;
	public final String target;
	public final String targetBundle;
	
	public WizardInput(String project, String rootPackage, String trafo, String source, String sourceBundle,
			String target, String targetBundle) {
		this.project = project;
		this.rootPackage = rootPackage;
		this.trafo = trafo;
		this.source = source;
		this.sourceBundle = sourceBundle;
		this.target = target;
		this.targetBundle = targetBundle;
	}
}
