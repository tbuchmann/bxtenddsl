package de.ubt.ai1.m2m.bxtenddsl.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

/**
 * Superclass for file generators.
 */
public abstract class FileGenerator {
	/**
	 * @param name of the file to generate.
	 * @param container where to generate the file into.
	 */
	public FileGenerator(String name, IContainer container) {
		this.name = name;
		this.container = container;
	}
	
	/**
	 * Performs the actual file generation.
	 * 
	 * @param input
	 * @throws CoreException if file generation fails.
	 */
	public void generate(WizardInput input) throws CoreException {
		if (!container.exists() && container instanceof IFolder) {
			((IFolder) container).create(true, true, null);
		}
		IFile file = container.getFile(new Path(name));
		try (InputStream content = new ByteArrayInputStream(getContent(input).getBytes(file.getCharset()))) {
			file.create(content, true, null);
		} catch (IOException e) {
			String message = "Generating the file " + name + " failed!";
			throw new CoreException(new Status(IStatus.ERROR, "de.ubt.ai1.m2m.bxtenddsl.wizard", message, e));
		}
	}
	
	/**
	 * @param input
	 * @return the content of the file to generate.
	 */
	abstract String getContent(WizardInput input);
	
	final String name;
	final IContainer container;
}
