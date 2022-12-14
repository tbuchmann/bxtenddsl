package de.ubt.ai1.m2m.bxtenddsl.framework;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Template for the abstract entry class of the transformation.
 */
@SuppressWarnings("all")
public final class AbstractEntryClassTemplate {
  /**
   * Returns Xtend source code for the abstract entry class.
   */
  public static String getCode(final FrameworkConfig config) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _rootPackage = config.getRootPackage();
    _builder.append(_rootPackage);
    _builder.append(".trafo");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _rootPackage_1 = config.getRootPackage();
    _builder.append(_rootPackage_1);
    _builder.append(".corrmodel.Corr");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _rootPackage_2 = config.getRootPackage();
    _builder.append(_rootPackage_2);
    _builder.append(".corrmodel.CorrModelFactory");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _rootPackage_3 = config.getRootPackage();
    _builder.append(_rootPackage_3);
    _builder.append(".corrmodel.Transformation");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _rootPackage_4 = config.getRootPackage();
    _builder.append(_rootPackage_4);
    _builder.append(".rules.Elem2Elem");
    _builder.newLineIfNotEmpty();
    _builder.append("import de.ubt.ai1.m2m.bxtenddsl.BXtendTransformation");
    _builder.newLine();
    _builder.append("import java.util.HashMap");
    _builder.newLine();
    _builder.append("import java.util.HashSet");
    _builder.newLine();
    _builder.append("import java.util.Iterator");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.common.util.URI");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.Resource");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.ResourceSet");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.util.EcoreUtil");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Abstract");
    String _trafo = config.getTrafo();
    _builder.append(_trafo);
    _builder.append(" implements BXtendTransformation {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("val protected Resource sourceModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val protected Resource targetModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val protected Resource corrModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val List<Elem2Elem> rules");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ResourceSet set = new ResourceSetImpl()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set.resourceFactoryRegistry.extensionToFactoryMap.put(\"xmi\", new XMIResourceFactoryImpl())");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sourceModel = set.createResource(URI.createURI(\"source.xmi\"))");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("targetModel = set.createResource(URI.createURI(\"target.xmi\"))");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("corrModel = set.createResource(URI.createURI(\"corr.xmi\"))");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("corrModel.contents.add(CorrModelFactory.eINSTANCE.createTransformation)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("rules = createRules()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Resource source, Resource target, Resource correspondence) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sourceModel = source");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("targetModel = target");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("corrModel = correspondence");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (corrModel.contents.size() == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("corrModel.contents.add(CorrModelFactory.eINSTANCE.createTransformation)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("rules = createRules()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override void sourceToTarget() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val createdElems = new HashMap<Elem2Elem, List<EObject>>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val spareElems = new HashMap<Elem2Elem, List<EObject>>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var Set<EObject> detachedCorrElems = new HashSet<EObject>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val delta = rule.sourceToTarget(detachedCorrElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("createdElems.put(rule, delta.createdElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("spareElems.put(rule, delta.spareElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("detachedCorrElems = delta.detachedCorrElems");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Corr corr : (corrModel.contents.get(0) as Transformation).correspondences) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (EObject trg : corr.flatTrg.filter[eContainer === null]) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("targetModel.contents += trg");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (createdElem : createdElems.get(rule)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("rule.onTrgElemCreation(createdElem)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (spareElem : spareElems.get(rule)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("rule.onTrgElemDeletion(spareElem)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("EcoreUtil.delete(spareElem, false)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("deleteUnreferencedTargetElements()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override void targetToSource() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val createdElems = new HashMap<Elem2Elem, List<EObject>>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val spareElems = new HashMap<Elem2Elem, List<EObject>>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var Set<EObject> detachedCorrElems = new HashSet<EObject>()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val delta = rule.targetToSource(detachedCorrElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("createdElems.put(rule, delta.createdElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("spareElems.put(rule, delta.spareElems)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("detachedCorrElems = delta.detachedCorrElems");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Corr corr : (corrModel.contents.get(0) as Transformation).correspondences) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (EObject src : corr.flatSrc.filter[eContainer === null]) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("sourceModel.contents += src");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (createdElem : createdElems.get(rule)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("rule.onSrcElemCreation(createdElem)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (rule : rules) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (spareElem : spareElems.get(rule)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("rule.onSrcElemDeletion(spareElem)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("EcoreUtil.delete(spareElem, false)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("deleteUnreferencedSourceElements()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override Resource getCorr() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return corrModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override Resource getSource() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return sourceModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override Resource getTarget() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return targetModel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def protected abstract List<Elem2Elem> createRules();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private Iterator<Corr> detectSourceDeletions() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("corrModel.allContents.filter(typeof(Corr)).filter[c |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("c.flatSrc.empty");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private Iterator<Corr> detectTargetDeletions() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("corrModel.allContents.filter(typeof(Corr)).filter[c |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("c.flatTrg.empty");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private void deleteUnreferencedTargetElements() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<EObject> deletionList = newArrayList;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("detectSourceDeletions().forEach[c |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val rule = rules.findFirst[ruleId == c.ruleId]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("c.flatTrg.forEach[rule.onTrgElemDeletion(it)]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("deletionList += c.flatTrg");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("deletionList += c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("deletionList.forEach[e | EcoreUtil.delete(e, true)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private void deleteUnreferencedSourceElements() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<EObject> deletionList = newArrayList; ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("detectTargetDeletions().forEach[c |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val rule = rules.findFirst[ruleId == c.ruleId]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("c.flatSrc.forEach[rule.onSrcElemDeletion(it)]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("deletionList += c.flatSrc");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("deletionList += c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("deletionList.forEach[e | EcoreUtil.delete(e, true)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private AbstractEntryClassTemplate() {
  }
}
