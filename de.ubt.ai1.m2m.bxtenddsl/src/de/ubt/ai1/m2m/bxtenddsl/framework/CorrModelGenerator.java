package de.ubt.ai1.m2m.bxtenddsl.framework;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Utility class, responsible for dynamically creating the correspondence model (Ecore),
 * its generator model and generating EMF-compliant model code (Java).
 */
public final class CorrModelGenerator {
	/**
	 * 1. dynamically creates the EMF-based correspondence model
	 * 2. creates the generator model
	 * 3. invokes the model code generation
	 * 
	 * @param config for the correspondence model to generate.
	 * @throws CoreException if saving the correspondence model or its generator model fails.
	 */
	public static void generate(FrameworkConfig config) throws CoreException {
		// creates the correspondence model
		ResourceSet resSet = new ResourceSetImpl();
		
		URI modelURI = URI.createPlatformResourceURI("/" + config.getProject() + "/model/CorrModel.ecore", true);
		Resource modelRes = resSet.createResource(modelURI);
		URI genModelURI = URI.createPlatformResourceURI("/" + config.getProject() + "/model/CorrModel.genmodel", true);
		Resource genModelRes = resSet.createResource(genModelURI);
		
		EPackage root = buildCorrModel(config.getRootPackage());
		modelRes.getContents().add(root);
		try {
			modelRes.save(null);
		} catch (IOException e) {
			String message = "Saving the correspondence model failed!";
			throw new CoreException(new Status(IStatus.ERROR, "de.ubt.ai1.m2m.bxtenddsl", message, e));
		}
		
		// creates the generator model
		URI ecoreGenModelURI = URI.createPlatformPluginURI("org.eclipse.emf.ecore/model/Ecore.genmodel", true);
		Resource ecoreGenModelRes = resSet.getResource(ecoreGenModelURI, true);
		GenPackage ecoreGenPackage = ((GenModel) ecoreGenModelRes.getContents().get(0)).getGenPackages().get(0);
		
		GenModel genModel = createGenModel(config.getProject(), config.getRootPackage(), root,
				modelURI.toPlatformString(true), ecoreGenPackage);
		genModelRes.getContents().add(genModel);
		try {
			genModelRes.save(null);
		} catch (IOException e) {
			String message = "Saving the generator model failed!";
			throw new CoreException(new Status(IStatus.ERROR, "de.ubt.ai1.m2m.bxtenddsl", message, e));
		}
		
		// invokes the model code generation
		Generator gen = new Generator();
		ArrayList<String> args = new ArrayList<String>();
		args.add("-forceOverwrite");
		args.add("-reconcile");
		args.add("-model");
		args.add(genModelURI.toString());
		String[] argsArr = args.toArray(new String[args.size()]);
		
		PrintStream out = System.out;
		try {
			System.setOut(new PrintStream(new OutputStream() { // running the generator is super verbose
				@Override
				public void write(int b) throws IOException {
					// dummy method
				}
			}));
			gen.run(argsArr);
		} finally {
			System.setOut(out);
		}
	}
	
	/**
	 * @param basePackage where the correspondence model code should be generated in.
	 * @return the build correspondence model.
	 */
	private static EPackage buildCorrModel(String basePackage) {
		EcoreFactory fac = EcoreFactoryImpl.init();
		
		EPackage root = fac.createEPackage();
		root.setName("corrmodel");
		root.setNsPrefix(basePackage + ".corrmodel");
		root.setNsURI("http://" + basePackage.replace('.', '/') + "/corrmodel.ecore");
		
		EClass trafo = fac.createEClass();
		trafo.setName("Transformation");
		
		EClass corr = fac.createEClass();
		corr.setName("Corr");
		
		EClass corrElem = fac.createEClass();
		corrElem.setName("CorrElem");
		corrElem.setAbstract(true);
		EClass singleElem = fac.createEClass();
		singleElem.setName("SingleElem");
		singleElem.getESuperTypes().add(corrElem);
		EClass multiElem = fac.createEClass();
		multiElem.setName("MultiElem");
		multiElem.getESuperTypes().add(corrElem);
		
		root.getEClassifiers().add(trafo);
		root.getEClassifiers().add(corr);
		root.getEClassifiers().add(corrElem);
		root.getEClassifiers().add(singleElem);
		root.getEClassifiers().add(multiElem);
		
		// creates attributes and references
		EReference corres = fac.createEReference();
		corres.setName("correspondences");
		corres.setEType(corr);
		corres.setUpperBound(-1);
		corres.setContainment(true);
		trafo.getEStructuralFeatures().add(corres);
		
		EAttribute ruleId = fac.createEAttribute();
		ruleId.setName("ruleId");
		ruleId.setEType(EcorePackage.eINSTANCE.getEString());
		EReference src = fac.createEReference();
		src.setName("source");
		src.setEType(corrElem);
		src.setUpperBound(-1);
		src.setContainment(true);
		EReference trg = fac.createEReference();
		trg.setName("target");
		trg.setEType(corrElem);
		trg.setUpperBound(-1);
		trg.setContainment(true);
		corr.getEStructuralFeatures().add(ruleId);
		corr.getEStructuralFeatures().add(src);
		corr.getEStructuralFeatures().add(trg);
		
		EReference element = fac.createEReference();
		element.setName("element");
		element.setEType(EcorePackage.eINSTANCE.getEObject());
		singleElem.getEStructuralFeatures().add(element);
		
		EReference elements = fac.createEReference();
		elements.setName("elements");
		elements.setEType(EcorePackage.eINSTANCE.getEObject());
		elements.setUpperBound(-1);
		multiElem.getEStructuralFeatures().add(elements);
		
		// creates operations
		String newLine = System.lineSeparator();
		String flatSrcBody =
			"EList<EObject> flatSource = new org.eclipse.emf.common.util.BasicEList<>();" + newLine +
			"for (CorrElem element : getSource()) {" + newLine +
			"	if (element instanceof " + root.getNsPrefix() + ".SingleElem) {" + newLine +
			"		if (((" + root.getNsPrefix() + ".SingleElem) element).getElement() != null) {" + newLine +
			"			flatSource.add(((" + root.getNsPrefix() + ".SingleElem) element).getElement());" + newLine +
			"		}" + newLine +
			"	} else {" + newLine +
			"		flatSource.addAll(((" + root.getNsPrefix() + ".MultiElem) element).getElements());" + newLine +
			"	}" + newLine +
			"}" + newLine +
			"return flatSource;"
		;
		
		EOperation flatSrc = fac.createEOperation();
		flatSrc.setName("flatSrc");
		flatSrc.setEType(EcorePackage.eINSTANCE.getEObject());
		flatSrc.setUpperBound(-1);
		EAnnotation genModelSrc = fac.createEAnnotation();
		genModelSrc.setSource("http://www.eclipse.org/emf/2002/GenModel");
		genModelSrc.getDetails().put("body", flatSrcBody);
		flatSrc.getEAnnotations().add(genModelSrc);
		corr.getEOperations().add(flatSrc);
		
		EOperation flatTrg = fac.createEOperation();
		flatTrg.setName("flatTrg");
		flatTrg.setEType(EcorePackage.eINSTANCE.getEObject());
		flatTrg.setUpperBound(-1);
		EAnnotation genModelTrg = fac.createEAnnotation();
		genModelTrg.setSource("http://www.eclipse.org/emf/2002/GenModel");
		genModelTrg.getDetails().put("body", flatSrcBody.replace("Source", "Target"));
		flatTrg.getEAnnotations().add(genModelTrg);
		corr.getEOperations().add(flatTrg);
		
		return root;
	}
	
	/**
	 * @param projectName where the correspondence model is located in.
	 * @param basePackage where the correspondence model code should be generated in.
	 * @param rootPackage of the Ecore model for which the generator model is being built.
	 * @param modelLocation location of the ecore model.
	 * @param ecoreGenPackage the ecore generator package.
	 * @return the created generator model.
	 */
	private static GenModel createGenModel(String projectName, String basePackage, EPackage rootPackage,
			String modelLocation, GenPackage ecoreGenPackage) {
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
		genModel.setModelDirectory(projectName + "/BXtend");
		genModel.getForeignModel().add(new Path(modelLocation).lastSegment());
		genModel.setModelName("CorrModel");
		genModel.setRootExtendsInterface("org.eclipse.emf.ecore.EObject");
		genModel.initialize(Collections.singleton(rootPackage));
		genModel.getUsedGenPackages().add(ecoreGenPackage);
		
		GenPackage genPackage = (GenPackage) genModel.getGenPackages().get(0);
		genPackage.setPrefix("CorrModel");
		genPackage.setBasePackage(basePackage);
		
		return genModel;
	}
	
	private CorrModelGenerator() {
	}
}
