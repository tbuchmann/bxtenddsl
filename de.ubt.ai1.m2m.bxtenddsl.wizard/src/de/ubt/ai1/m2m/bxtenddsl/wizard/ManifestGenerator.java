package de.ubt.ai1.m2m.bxtenddsl.wizard;

import org.eclipse.core.resources.IProject;

/**
 * Generator for the MANIFEST.MF file.
 */
public class ManifestGenerator extends FileGenerator {
	public ManifestGenerator(IProject project) {
		super("MANIFEST.MF", project.getFolder("META-INF"));
	}

	@Override
	String getContent(WizardInput input) {
		StringBuilder manifest = new StringBuilder();
		
		manifest.append("Manifest-Version: 1.0\n");
		manifest.append("Bundle-ManifestVersion: 2\n");
		manifest.append("Bundle-Name: " + input.project + "\n");
		manifest.append("Bundle-SymbolicName: " + input.rootPackage + "\n");
		manifest.append("Bundle-Version: 1.0.0\n");
		manifest.append("Automatic-Module-Name: " + input.rootPackage + "\n");
		manifest.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.8\n");
		manifest.append("Require-Bundle: ");
		manifest.append(" org.eclipse.emf.ecore,\n");
		manifest.append(" org.eclipse.emf.ecore.xmi,\n");
		manifest.append(" org.eclipse.xtext.xbase.lib,\n");
		manifest.append(" org.eclipse.xtend.lib,\n");
		manifest.append(" org.eclipse.xtend.lib.macro,\n");
		manifest.append(" de.ubt.ai1.m2m.bxtenddsl,\n");
		manifest.append(" " + input.sourceBundle + ",\n");
		manifest.append(" " + input.targetBundle + "\n");
		manifest.append("Export-Package: " + input.rootPackage + ".corrmodel,\n");
		manifest.append(" " + input.rootPackage + ".corrmodel.impl,\n");
		manifest.append(" " + input.rootPackage + ".corrmodel.util,\n");
		manifest.append(" " + input.rootPackage + ".rules,\n");
		manifest.append(" " + input.rootPackage + ".trafo\n");

		return manifest.toString();
	}
}
