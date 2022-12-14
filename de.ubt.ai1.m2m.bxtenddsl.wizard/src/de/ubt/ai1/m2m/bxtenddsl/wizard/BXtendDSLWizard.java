package de.ubt.ai1.m2m.bxtenddsl.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard that generates a new BXtendDSL project.
 */
public class BXtendDSLWizard extends Wizard implements INewWizard {
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		
		setWindowTitle("New BXtendDSL Project");
		// accelerating MetamodelSelectionDialog, the first execution of this in a fresh eclipse takes very long
		new Thread(() -> EcorePlugin.getEPackageNsURIToGenModelLocationMap(true)).start();
	}
	
	@Override
	public void addPages() {
		page = new BXtendDSLWizardPage(selection);
		addPage(page);
	}
	
	@Override
	public boolean performFinish() {
		WizardInput input = page.getInput();
		if (finishing || input == null) {
			return false;
		}
		finishing = true; // performFinish can be called multiple times from the same thread by clicking 'Finish'
		
		try {
			IProject project = createProject(input);
			(new DslStubGenerator(project, input)).generate(input);
			(new ManifestGenerator(project)).generate(input);
			(new BuildPropertiesGenerator(project)).generate(input);
			(new BxtendPropertiesGenerator(project)).generate(input);
			project.touch(null);
			
		} catch (CoreException e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			finishing = false;
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			finishing = false;
			throw e;
		}
		
		finishing = false;
		return true;
	}
	
	private IProject createProject(WizardInput input) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(input.project);
		project.create(createProjectDescription(input), null);
		project.open(null);
		configureClasspath(project, input);

		IWorkspaceDescription workspaceDescription = ResourcesPlugin.getWorkspace().getDescription();
		if (!workspaceDescription.isAutoBuilding()) {
			workspaceDescription.setAutoBuilding(true);
			ResourcesPlugin.getWorkspace().setDescription(workspaceDescription);
		}
		
		return project;
	}
	private IProjectDescription createProjectDescription(WizardInput input) {
		IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(input.project);
		
		String pluginNature = "org.eclipse.pde.PluginNature";
		String xtextNature = "org.eclipse.xtext.ui.shared.xtextNature";
		projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, pluginNature, xtextNature });
		
		ICommand xtextCommand = projectDescription.newCommand();
		xtextCommand.setBuilderName("org.eclipse.xtext.ui.shared.xtextBuilder");
		ICommand javaCommand = projectDescription.newCommand();
		javaCommand.setBuilderName(JavaCore.BUILDER_ID);
		ICommand manifestCommand = projectDescription.newCommand();
		manifestCommand.setBuilderName("org.eclipse.pde.ManifestBuilder");
		ICommand schemaCommand = projectDescription.newCommand();
		schemaCommand.setBuilderName("org.eclipse.pde.SchemaBuilder");
		projectDescription.setBuildSpec(new ICommand[] { xtextCommand, javaCommand, manifestCommand, schemaCommand });
		
		return projectDescription;
	}
	private void configureClasspath(IProject project, WizardInput input) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		
		List<IClasspathEntry> classpath = new ArrayList<>();
		classpath.add(JavaCore.newSourceEntry(project.getFolder("src").getFullPath()));
		classpath.add(JavaCore.newSourceEntry(project.getFolder("src-gen").getFullPath()));
		classpath.add(JavaCore.newSourceEntry(project.getFolder("xtend-gen").getFullPath()));
		String JreSystemLibrary = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8";
		classpath.add(JavaCore.newContainerEntry(new Path(JreSystemLibrary)));
		String PluginDependencies = "org.eclipse.pde.core.requiredPlugins";
		classpath.add(JavaCore.newContainerEntry(new Path(PluginDependencies)));
		javaProject.setRawClasspath(classpath.toArray(new IClasspathEntry[0]), null);
		
		javaProject.setOutputLocation(new Path("/" + input.project + "/bin"), null);
	}
	
	private IStructuredSelection selection;
	private BXtendDSLWizardPage page;
	private boolean finishing = false;
}
