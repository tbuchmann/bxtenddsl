package de.ubt.ai1.m2m.bxtenddsl.wizard;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

/**
 * Generator for a .bxtend stub file to start with.
 */
public class DslStubGenerator extends FileGenerator {
	public DslStubGenerator(IProject project, WizardInput input) {
		super(input.trafo + ".bxtend", project.getFolder("src/" + input.rootPackage.replace('.', '/') + "/rules"));
	}
	
	@Override
	public void generate(WizardInput input) throws CoreException {
		IFolder rootPackage = container.getProject().getFolder("src");
		rootPackage.create(true, true, null);
		for (String packageSegment : input.rootPackage.split("\\.")) {
			rootPackage = rootPackage.getFolder(packageSegment);
			rootPackage.create(true, true, null);
		}
		
		super.generate(input);
	}
	
	@Override
	String getContent(WizardInput input) {
		StringBuilder dslStub = new StringBuilder();
		
		dslStub.append("sourcemodel \"" + input.source + "\"" + System.lineSeparator());
		dslStub.append("targetmodel \"" + input.target + "\"" + System.lineSeparator());
		dslStub.append(System.lineSeparator());
		dslStub.append("// TODO: implement the rules of your transformation here." + System.lineSeparator());
		
		return dslStub.toString();
	}
}
