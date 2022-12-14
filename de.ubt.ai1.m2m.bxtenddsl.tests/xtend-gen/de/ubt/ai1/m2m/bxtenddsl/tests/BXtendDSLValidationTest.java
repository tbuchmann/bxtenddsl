package de.ubt.ai1.m2m.bxtenddsl.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader;
import de.ubt.ai1.m2m.bxtenddsl.validation.BXtendDSLValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BXtendDSLInjectorProvider.class)
@SuppressWarnings("all")
public class BXtendDSLValidationTest {
  @Inject
  @Extension
  private ParseHelper<BXtendDSL> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Before
  public void before() {
    MetamodelLoader.testMode = true;
    this.globalScope = BXtendDSLTestUtils.buildGlobalScope(this.resourceSetProvider.get(), 
      BXtendDSLTestConfig.pdb1Uri, BXtendDSLTestConfig.pdb1InvalidUri, BXtendDSLTestConfig.pdb1EClassUri, 
      BXtendDSLTestConfig.pdb2Uri, BXtendDSLTestConfig.GanttUri, BXtendDSLTestConfig.CpmUri, 
      BXtendDSLTestConfig.bags1Uri, BXtendDSLTestConfig.bags2Uri, BXtendDSLTestConfig.SqlUri);
  }
  
  @Test
  public void testCheckMetamodelUri_notResolvable() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"PersonsDB1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.ast.ecore\"");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE, 
      "not resolvable:", 
      "\'PersonsDB1.ecore\' not found in the package registry or workspace!");
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE, 
      "not resolvable:", 
      "\'http://de.ubt.ai1.bw.qvt.examples.ast.ecore\' not found in the package registry or workspace!");
  }
  
  @Test
  public void testCheckMetamodelUri_loadingFailed() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1invalid.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.LOADING_METAMODEL_FAILED, 
      "Loading metamodel failed: lineNumber: 18; columnNumber: 3;", "Elementtyp \"eClassifiers\" muss", 
      "PersonsDB1Invalid.ecore");
  }
  
  @Test
  public void testCheckMetamodelUri_notApplicable() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1eclass.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.METAMODEL_NOT_APPLICABLE, 
      "Metamodel not applicable: ", "The metamodel root must be an EPackage!");
  }
  
  @Test
  public void testCheckMetamodelUri() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE);
    this._validationTestHelper.assertNoErrors(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.LOADING_METAMODEL_FAILED);
    this._validationTestHelper.assertNoErrors(parsed, BXtendDSLPackage.eINSTANCE.getMetamodels(), BXtendDSLValidator.METAMODEL_NOT_APPLICABLE);
  }
  
  @Test
  public void testCheckForbiddenOptionName_ForbiddenChar() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("PREFERED_SPACE", "Prefered_Space"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getConfig(), BXtendDSLValidator.FORBIDDEN_OPTION_NAME, 
      "Forbidden option name: ", "\'Prefered_Space\'.", 
      " Only upper case letters, digits and underscores are allowed.");
  }
  
  @Test
  public void testCheckForbiddenOptionName_FirstChar() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("PREFERED_SPACE", "_PREFERED_SPACE"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getConfig(), BXtendDSLValidator.FORBIDDEN_OPTION_NAME, 
      "Forbidden option name: ", "\'_PREFERED_SPACE\'.", 
      " The first character must be an upper case letter.");
  }
  
  @Test
  public void testCheckAmbigiuousOptionName() throws Exception {
    String _pdb12pdb2 = this.pdb12pdb2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("options");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("PREFERED_SPACE");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("options");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PREFERED_SPACE");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PREFERED_SPACE");
    final BXtendDSL parsed = this._parseHelper.parse(_pdb12pdb2.replaceFirst(_builder.toString(), _builder_1.toString()), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getConfig(), BXtendDSLValidator.AMBIGUOUS_OPTION_NAME, 
      "Ambiguous option name: ", "\'PREFERED_SPACE\'");
  }
  
  @Test
  public void testCheckRuleNameNotForbidden_Elem2Elem() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("Person2Person", "Elem2Elem"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getTransformationRule(), BXtendDSLValidator.FORBIDDEN_RULE_NAME, 
      "Forbidden rule name: ", "\'Elem2Elem\' is the name of the base class for transformation rules!");
  }
  
  @Test
  public void testCheckRuleNameNotForbidden_Impl() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("Person2Person", "Person2PersonImpl"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getTransformationRule(), BXtendDSLValidator.FORBIDDEN_RULE_NAME, 
      "Forbidden rule name: ", "Rule names ending with \'Impl\' are reserved for rule specialization!");
  }
  
  @Test
  public void testCheckRuleNameUnique() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("Database2Database", "Person2Person"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getTransformationRule(), BXtendDSLValidator.AMBIGUOUS_RULE_NAME, 
      "Ambiguous rule name: ", "\'Person2Person\'");
  }
  
  @Test
  public void testCheckClassMatcherNameNotForbidden() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("Person s", "Person _s"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getClassMatcher(), BXtendDSLValidator.FORBIDDEN_CLASS_MATCHER_NAME, 
      "Forbidden class matcher name: ", "Class matcher names may not start with an underscore!");
  }
  
  @Test
  public void testCheckClassMatcherNameUnique() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replaceFirst("Person t", "Person s"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getClassMatcher(), BXtendDSLValidator.AMBIGUOUS_CLASS_MATCHER_NAME, 
      "Ambiguous class matcher name: ", "\'s\'");
  }
  
  @Test
  public void testCheckDuplicatedMappingParam_srcClass() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.bags12bags2().replace("s <-->", "s s <-->"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.DUPLICATED_MAPPING_PARAM, 
      189, (-1), "Duplicated mapping parameter: ", "\'s\'");
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.DUPLICATED_MAPPING_PARAM, 
      191, (-1), "Duplicated mapping parameter: ", "\'s\'");
  }
  
  @Test
  public void testCheckDuplicatedMappingParam_trgFeature() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.bags12bags2().replace("t.value", "t.value t.value"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.DUPLICATED_MAPPING_PARAM, 
      196, (-1), "Duplicated mapping parameter: ", "\'t.value\'");
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.DUPLICATED_MAPPING_PARAM, 
      204, (-1), "Duplicated mapping parameter: ", "\'t.value\'");
  }
  
  @Test
  public void testCheckDuplicatedMappingParam_corrFeature() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.bags12bags2().replace(
      "{s.elements : Element2Element}", 
      "{s.elements : Element2Element} s.elements"), this.globalScope);
    this._validationTestHelper.assertNoIssues(parsed);
  }
  
  @Test
  public void testCheckMappingParamAlreadySet_featureParamClassParam() throws Exception {
    String _bags12bags2 = this.bags12bags2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("trg Element t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s <--> t.value t.multiplicity;");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("trg Element t;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s <--> t.value t.multiplicity;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s <--> t.value t.multiplicity;");
    final BXtendDSL parsed = this._parseHelper.parse(_bags12bags2.replace(_builder, _builder_1), this.globalScope);
    this._validationTestHelper.assertWarning(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET, 
      "Mapping parameter already set: ", "\'s\'");
    this._validationTestHelper.assertWarning(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET, 
      "Mapping parameter already set: ", "\'t.value\'");
    this._validationTestHelper.assertWarning(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET, 
      "Mapping parameter already set: ", "\'t.multiplicity\'");
  }
  
  @Test
  public void testCheckMappingParamAlreadySet_considerDirection() throws Exception {
    String _bags12bags2 = this.bags12bags2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("trg Element t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s <--> t.value t.multiplicity;");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("trg Element t;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s --> t.value;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s --> t.multiplicity;");
    final BXtendDSL parsed = this._parseHelper.parse(_bags12bags2.replace(_builder, _builder_1), this.globalScope);
    this._validationTestHelper.assertNoIssues(parsed);
  }
  
  @Test
  public void testCheckMappingParamAlreadySet_inOnlyParam() throws Exception {
    String _pdb12pdb2 = this.pdb12pdb2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("trg Person t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.birthday <--> t.birthday;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.placeOfBirth <--> t.placeOfBirth;");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("trg Person t;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s.birthday <--> s t.birthday;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s.placeOfBirth <--> s t.placeOfBirth;");
    final BXtendDSL parsed = this._parseHelper.parse(_pdb12pdb2.replace(_builder, _builder_1), this.globalScope);
    this._validationTestHelper.assertNoIssues(parsed);
  }
  
  @Test
  public void testCheckUnchangeableMappingFeature_output() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.ecore2sql().replace("} --> {", "} <--> {"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.UNCHANGEABLE_MAPPING_FEATURE, 
      "Unchangeable mapping feature: ", "\'in.ePackage\'", "It must not be used as out parameter of a mapping.");
  }
  
  @Test
  public void testCheckUnchangeableMappingFeature_input() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.ecore2sql().replace("} --> {", "} --> {"), this.globalScope);
    this._validationTestHelper.assertNoIssues(parsed);
  }
  
  @Test
  public void testCheckAttributeCorrMappingFeature() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.bags12bags2().replace("t.value", "{t.value : Element2Element}"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMappingFeature(), BXtendDSLValidator.ATTRIBUTE_CORR_MAPPING_FEATURE, 
      "Attribute corr mapping feature: ", "\'{t.value : ...}\'");
  }
  
  @Test
  public void testCheckDuplicatedCorrMappingRule() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.bags12bags2().replace(
      "{s.elements : Element2Element}", 
      "{s.elements : Element2Element, Element2Element}"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMappingFeature(), BXtendDSLValidator.DUPLICATED_CORR_MAPPING_RULE, 
      "Duplicated corr mapping rule: ", "\'Element2Element\'");
  }
  
  @Test
  public void testCheckUnresolvableCorrMappingRule() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replace(
      "{s.persons : Person2Person[t]}", 
      "{s.persons : Database2Database[t]}"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMappingFeature(), BXtendDSLValidator.UNRESOLVABLE_CORR_MAPPING_RULE, 
      "Unresolvable corr mapping rule: ", 
      "No src matcher of \'Database2Database\' fits to the type of \'s.persons\'.");
  }
  
  @Test
  public void testCheckCorrMappingRuleBeforeRule() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replace(
      "s.birthday <--> t.birthday;", 
      "{s.database : Database2Database} <--> {t.database : Database2Database};"), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getMappingFeature(), BXtendDSLValidator.CORR_MAPPING_RULE_BEFORE_RULE, 
      "Corr mapping rule before rule: ", 
      "\'Database2Database\' can\'t be resolved, because it is executed after \'Person2Person\'.");
  }
  
  @Test
  public void testCheckDuplicatedCorrMappingMatcher() throws Exception {
    final BXtendDSL parsed = this._parseHelper.parse(this.pdb12pdb2().replace(
      "{s.persons : Person2Person[t]}", 
      "{s.persons : Person2Person[t, t]}"), this.globalScope);
    final String code = BXtendDSLValidator.DUPLICATED_CORR_MAPPING_MATCHER;
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getCorrespondence(), code, 
      "Duplicated corr mapping matcher: ", "\'t\'");
  }
  
  @Test
  public void testCheckForbiddenClassMappingParam() throws Exception {
    String _pdb12pdb2 = this.pdb12pdb2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("trg Person t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.birthday <--> t.birthday;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.placeOfBirth <--> t.placeOfBirth;");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("trg Person t;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s.birthday <--> t t.birthday;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s.placeOfBirth s <--> t.placeOfBirth;");
    final BXtendDSL parsed = this._parseHelper.parse(_pdb12pdb2.replace(_builder, _builder_1), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.FORBIDDEN_CLASS_MAPPING_PARAM, 
      "Forbidden class mapping parameter: ", "\'t\'");
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getFeatureMapping(), BXtendDSLValidator.FORBIDDEN_CLASS_MAPPING_PARAM, 
      "Forbidden class mapping parameter: ", "\'s\'");
  }
  
  @Test
  public void testCheckNoOutMappingParam() throws Exception {
    String _bags12bags2 = this.bags12bags2();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("trg MyBag t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{s.elements : Element2Element} <--> {t.elements : Element2Element};");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("trg MyBag t;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("{s.elements : Element2Element} --> s;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("t <-- {t.elements : Element2Element};");
    final BXtendDSL parsed = this._parseHelper.parse(_bags12bags2.replace(_builder, _builder_1), this.globalScope);
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getTransformationRule(), BXtendDSLValidator.NO_OUT_MAPPING_PARAM, 
      "No out mapping parameter: ", "<-- is specified, but the lhs");
    this._validationTestHelper.assertError(parsed, BXtendDSLPackage.eINSTANCE.getTransformationRule(), BXtendDSLValidator.NO_OUT_MAPPING_PARAM, 
      "No out mapping parameter: ", "--> is specified, but the rhs");
  }
  
  @Test
  public void testCheckPdb12pdb2() throws Exception {
    this._validationTestHelper.assertNoIssues(this._parseHelper.parse(this.pdb12pdb2(), this.globalScope));
  }
  
  @Test
  public void testCheckBags12bags2() throws Exception {
    this._validationTestHelper.assertNoIssues(this._parseHelper.parse(this.bags12bags2(), this.globalScope));
  }
  
  @Test
  public void testCheckEcore2sql() throws Exception {
    this._validationTestHelper.assertNoIssues(this._parseHelper.parse(this.ecore2sql(), this.globalScope));
  }
  
  private String pdb12pdb2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("options");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("PREFERED_SPACE");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Person2Person");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Person s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Person t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.birthday <--> t.birthday;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.placeOfBirth <--> t.placeOfBirth;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.id <--> t.id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.firstName s.lastName <--> t.name;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Database2Database");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Database s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Database t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.name <--> t.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{s.persons : Person2Person[t]} <--> {t.persons : Person2Person[s]};");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String bags12bags2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.bags1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.bags2.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Element2Element");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Element s | group;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Element t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s <--> t.value t.multiplicity;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Bag2Bag");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src MyBag s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg MyBag t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{s.elements : Element2Element} <--> {t.elements : Element2Element};");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String ecore2sql() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://www.eclipse.org/emf/2002/Ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.sql.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule EPackage2Schema");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src EPackage in;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Schema out;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("in.name <--> out.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("rule EClass2Table");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src EClass in;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Table out;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("in.name <--> out.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{in.ePackage : EPackage2Schema} --> {out.owningSchema : EPackage2Schema};");
    _builder.newLine();
    return _builder.toString();
  }
  
  private ResourceSet globalScope;
}
