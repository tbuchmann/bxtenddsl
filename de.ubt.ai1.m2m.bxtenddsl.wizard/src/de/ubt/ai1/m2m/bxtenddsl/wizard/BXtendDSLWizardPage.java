package de.ubt.ai1.m2m.bxtenddsl.wizard;

import java.util.function.Consumer;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Wizard page to get the required user input to create a BXtendDSL project.
 */
public class BXtendDSLWizardPage extends WizardPage {
	public BXtendDSLWizardPage(IStructuredSelection selection) {
		super("mainPage");
		
		setTitle("BXtendDSL Project");
		setDescription("Enter project properties and metamodels.");
		setPageComplete(false);
	}
	
	public WizardInput getInput() {
		return input;
	}
	
	@Override
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout(1, true);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(layout);
		
		createPropertiesControl(container);
		createMetamodelsControl(container);
		container.pack();
		
		setControl(container);
	}
	
	private Text project;
	private Text rootPackage;
	private Text trafo;
	
	private Text source;
	private String sourceBundle;
	private Text target;
	private String targetBundle;
	
	private WizardInput input;
	
	private void dialogChanged() {
		WizardInput input = new WizardInput(project.getText(), rootPackage.getText(), trafo.getText(), source.getText(),
				sourceBundle, target.getText(), targetBundle);
		this.input = null;
		
		if (input.project.isEmpty()) {
			updateStatus("'Project' is empty.");
		} else if (!ResourcesPlugin.getWorkspace().validateName(input.project, IResource.PROJECT).isOK()) {
			updateStatus("'Project' is not a valid project name.");
		} else if (ResourcesPlugin.getWorkspace().getRoot().getProject(input.project).exists()) {
			updateStatus("'Project' already exists.");
			
		} else if (input.rootPackage.isEmpty()) {
			updateStatus("'Package' is empty.");
		} else if (!input.rootPackage.matches("[a-z][0-9a-z]*(\\.[a-z][0-9a-z]*)*")) {
			updateStatus("'Package' is not consisting of dot separated '[a-z][0-9a-z]*' segments.");
			
		} else if (input.trafo.isEmpty()) {
			updateStatus("'Trafo' is empty.");
		} else if (!input.trafo.matches("[A-Z][0-9A-Za-z]*")) {
			updateStatus("'Trafo' is no '[A-Z][0-9A-Za-z]*' identifier.");
			
		} else if (input.source.isEmpty()) {
			updateStatus("No metamodel 'Source' selected.");
		} else if (input.target.isEmpty()) {
			updateStatus("No metamodel 'Target' selected.");
			
		} else {
			this.input = input;
			updateStatus(null);
		}
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	private void createPropertiesControl(Composite container) {
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 9;
		Group properties = new Group(container, SWT.SHADOW_NONE);
		properties.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		properties.setLayout(layout);
		properties.setText("Properties");
		
		project = createPropertyInput(properties, "Project:", "The name of the created eclipse project.");
		rootPackage = createPropertyInput(properties, "Package:", "The root package of all source code.");
		trafo = createPropertyInput(properties, "Transformation:", "The name of the transformation class.");
	}
	private Text createPropertyInput(Composite container, String labelText, String toolTip) {
		Label label = new Label(container, SWT.NONE);
		label.setText(labelText);
		label.setToolTipText(toolTip);
		
		Text input = new Text(container, SWT.BORDER | SWT.SINGLE);
		input.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		input.addModifyListener(e -> dialogChanged());
		
		return input;
	}
	
	private void createMetamodelsControl(Composite container) {
		GridLayout layout = new GridLayout(3, false);
		layout.verticalSpacing = 9;
		Group metamodels = new Group(container, SWT.SHADOW_NONE);
		metamodels.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		metamodels.setLayout(layout);
		metamodels.setText("Metamodels");
		
		source = createMetamodelInput(metamodels, "Source: ", bundle -> sourceBundle = bundle);
		target = createMetamodelInput(metamodels, "Target: ", bundle -> targetBundle = bundle);
	}
	private Text createMetamodelInput(Composite container, String labelText, Consumer<String> bundleSetter) {
		Label label = new Label(container, SWT.NONE);
		label.setText(labelText);
		
		Text input = new Text(container, SWT.BORDER | SWT.SINGLE);
		input.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		input.setEditable(false);
		input.addModifyListener(e -> dialogChanged());
		
		Button browse = new Button(container, SWT.PUSH);
		browse.setText("Browse");
		browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MetamodelSelectionDialog selection = new MetamodelSelectionDialog(getShell());
				if (selection.open() == MetamodelSelectionDialog.OK && selection.getResult().length > 0) {
					bundleSetter.accept(selection.getRequiredBundle());
					input.setText((String) selection.getResult()[0]);
				}
			}
		});
		
		return input;
	}
}
