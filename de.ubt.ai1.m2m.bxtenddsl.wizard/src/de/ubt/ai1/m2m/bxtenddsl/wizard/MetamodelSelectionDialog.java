package de.ubt.ai1.m2m.bxtenddsl.wizard;

import de.ubt.ai1.m2m.bxtenddsl.utils.GeneratedPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Dialog to select a metamodel URI from workspace or package registry. Also provides the bundle of the selected
 * metamodel.
 */
public class MetamodelSelectionDialog extends ElementListSelectionDialog {
	public MetamodelSelectionDialog(Shell parent) {
		super(parent, new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				Object image = EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage");
				return ExtendedImageRegistry.getInstance().getImage(image);
			}
		});
		
		setTitle("Metamodel Selection");
		setMessage("Select a metamodel URI from workspace/package registry:");
		setFilter("*");
		
		Set<String> metamodels = new HashSet<>(EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).keySet());
		for (GeneratedPackage generatedPackage : GeneratedPackage.fromWorkspace()) {
			metamodels.add(generatedPackage.getEPackage().getNsURI());
			metamodelToProject.put(generatedPackage.getEPackage().getNsURI(), generatedPackage.getProject());
		}
		String[] metamodelsArray = metamodels.toArray(new String[0]);
		Arrays.sort(metamodelsArray);
		setElements(metamodelsArray);
	}
	
	/**
	 * @return the bundle from which the package identified by the result URI was loaded. The bundle is formatted
	 * as expected by Require-Bundle of a manifest file.
	 */
	public String getRequiredBundle() {
		return requiredBundle;
	}
	
	/**
	 * Computes the required bundle for the selected metamodel. To computation heavy for just computing it for every
	 * metamodel in the constructor.
	 */
	@Override
	protected void computeResult() {
		super.computeResult();
		if (getResult().length < 1) {
			return;
		}
		
		String metamodel = (String) getResult()[0];
		if (!metamodelToProject.containsKey(metamodel)) {
			Resource res = (new ResourceSetImpl()).getResource(URI.createURI(metamodel), false);
			Bundle bundle = FrameworkUtil.getBundle(res.getContents().get(0).getClass());
			requiredBundle = bundle.getSymbolicName() + ";bundle-version=\"" + bundle.getVersion() + "\"";
			
		} else {
			IProject project = metamodelToProject.get(metamodel);
			IFile manifestResource = project.getFile(new Path("META-INF/MANIFEST.MF"));
			try (InputStream manifestStream = manifestResource.getContents()) {
				Manifest manifest = new Manifest();
				manifest.read(manifestStream);
				String symbolicName = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
				String version = manifest.getMainAttributes().getValue("Bundle-Version");
				requiredBundle = symbolicName + ";bundle-version=\"" + version + "\"";
				
			} catch (IOException | CoreException e) {
				requiredBundle = project.getName();
			}
		}
	}
	
	private String requiredBundle;
	private Map<String, IProject> metamodelToProject = new HashMap<>();
}
