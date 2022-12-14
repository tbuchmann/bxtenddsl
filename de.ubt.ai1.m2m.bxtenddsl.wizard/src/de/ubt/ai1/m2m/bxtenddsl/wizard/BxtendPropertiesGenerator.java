package de.ubt.ai1.m2m.bxtenddsl.wizard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IProject;

/**
 * Generator for the BXtend.properties file. This file contains all informations collected in the wizard
 * that are needed after the wizard.
 */
public class BxtendPropertiesGenerator extends FileGenerator {
	public BxtendPropertiesGenerator(IProject project) {
		super("BXtend.properties", project);
	}
	
	@Override
	String getContent(WizardInput input) {
		Properties properties = new Properties();
		
		properties.setProperty("project", input.project);
		properties.setProperty("package", input.rootPackage);
		properties.setProperty("trafo", input.trafo);
		
		try (ByteArrayOutputStream propertiesStream = new ByteArrayOutputStream()) {
			properties.store(propertiesStream, null);
			return propertiesStream.toString("ISO-8859-1");
			
		} catch (IOException e) {
			throw new AssertionError("No actual i/o, so stream shouldn't throw.", e);
		}
	}
}
