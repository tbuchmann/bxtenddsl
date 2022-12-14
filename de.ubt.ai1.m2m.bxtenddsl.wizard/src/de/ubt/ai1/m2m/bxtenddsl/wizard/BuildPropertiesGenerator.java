package de.ubt.ai1.m2m.bxtenddsl.wizard;

import org.eclipse.core.resources.IProject;

/**
 * Generator for the build.properties file.
 */
public class BuildPropertiesGenerator extends FileGenerator {
	public BuildPropertiesGenerator(IProject project) {
		super("build.properties", project);
	}

	@Override
	String getContent(WizardInput input) {
		StringBuilder buildProperties = new StringBuilder();
		
		buildProperties.append("source.. =	src/,\\\n");
		buildProperties.append("			BXtend/,\\\n");
		buildProperties.append("			src-gen/,\\\n");
		buildProperties.append("			xtend-gen/\n");
		buildProperties.append("output.. =	bin/\n");
		buildProperties.append("bin.includes =	META-INF/\n");
		
		return buildProperties.toString();
	}
}
