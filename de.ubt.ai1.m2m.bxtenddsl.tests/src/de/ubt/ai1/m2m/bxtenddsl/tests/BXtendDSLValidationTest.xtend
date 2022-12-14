package de.ubt.ai1.m2m.bxtenddsl.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.junit.Test
import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.testing.util.ParseHelper
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage
import de.ubt.ai1.m2m.bxtenddsl.validation.BXtendDSLValidator
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import org.junit.Before
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader

@RunWith(XtextRunner)
@InjectWith(BXtendDSLInjectorProvider)
class BXtendDSLValidationTest {
	@Inject extension ParseHelper<BXtendDSL>
	@Inject extension ValidationTestHelper
	@Inject Provider<ResourceSet> resourceSetProvider;
	
	@Before
	def void before() {
		MetamodelLoader.testMode = true
		globalScope = BXtendDSLTestUtils.buildGlobalScope(resourceSetProvider.get(),
				BXtendDSLTestConfig.pdb1Uri, BXtendDSLTestConfig.pdb1InvalidUri, BXtendDSLTestConfig.pdb1EClassUri,
				BXtendDSLTestConfig.pdb2Uri, BXtendDSLTestConfig.GanttUri, BXtendDSLTestConfig.CpmUri,
				BXtendDSLTestConfig.bags1Uri, BXtendDSLTestConfig.bags2Uri, BXtendDSLTestConfig.SqlUri)
    }
	
	@Test
	def void testCheckMetamodelUri_notResolvable() throws Exception {
		val parsed = '''
		sourcemodel "PersonsDB1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.ast.ecore"
		'''.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE,
				"not resolvable:",
				"'PersonsDB1.ecore' not found in the package registry or workspace!")
		parsed.assertError(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE,
				"not resolvable:",
				"'http://de.ubt.ai1.bw.qvt.examples.ast.ecore' not found in the package registry or workspace!")
	}
	
	@Test
	def void testCheckMetamodelUri_loadingFailed() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1invalid.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		'''.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.LOADING_METAMODEL_FAILED,
				"Loading metamodel failed: lineNumber: 18; columnNumber: 3;", "Elementtyp \"eClassifiers\" muss",
				"PersonsDB1Invalid.ecore")
	}
	
	@Test
	def void testCheckMetamodelUri_notApplicable() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1eclass.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		'''.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.METAMODEL_NOT_APPLICABLE,
				"Metamodel not applicable: ", "The metamodel root must be an EPackage!")
	}
	
	@Test
	def void testCheckMetamodelUri() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		'''.parse(globalScope)
		
		parsed.assertNoErrors(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.METAMODEL_NOT_RESOLVABLE)
		parsed.assertNoErrors(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.LOADING_METAMODEL_FAILED)
		parsed.assertNoErrors(BXtendDSLPackage.eINSTANCE.metamodels, BXtendDSLValidator.METAMODEL_NOT_APPLICABLE)
	}
	
	@Test
	def void testCheckForbiddenOptionName_ForbiddenChar() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("PREFERED_SPACE", "Prefered_Space").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.config, BXtendDSLValidator.FORBIDDEN_OPTION_NAME,
				"Forbidden option name: ", "'Prefered_Space'.",
				" Only upper case letters, digits and underscores are allowed.")
	}
	@Test
	def void testCheckForbiddenOptionName_FirstChar() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("PREFERED_SPACE", "_PREFERED_SPACE").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.config, BXtendDSLValidator.FORBIDDEN_OPTION_NAME,
				"Forbidden option name: ", "'_PREFERED_SPACE'.",
				" The first character must be an upper case letter.")
	}
	@Test
	def void testCheckAmbigiuousOptionName() throws Exception {
		val parsed = pdb12pdb2.replaceFirst(
				'''
				options
					PREFERED_SPACE''',
				'''
				options
					PREFERED_SPACE
					PREFERED_SPACE''')
				.parse(globalScope)
				
		parsed.assertError(BXtendDSLPackage.eINSTANCE.config, BXtendDSLValidator.AMBIGUOUS_OPTION_NAME,
				"Ambiguous option name: ", "'PREFERED_SPACE'")
	}
	
	@Test
	def void testCheckRuleNameNotForbidden_Elem2Elem() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("Person2Person", "Elem2Elem").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.transformationRule, BXtendDSLValidator.FORBIDDEN_RULE_NAME,
				"Forbidden rule name: ", "'Elem2Elem' is the name of the base class for transformation rules!")
	}
	@Test
	def void testCheckRuleNameNotForbidden_Impl() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("Person2Person", "Person2PersonImpl").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.transformationRule, BXtendDSLValidator.FORBIDDEN_RULE_NAME,
				"Forbidden rule name: ", "Rule names ending with 'Impl' are reserved for rule specialization!")
	}
	@Test
	def void testCheckRuleNameUnique() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("Database2Database", "Person2Person").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.transformationRule, BXtendDSLValidator.AMBIGUOUS_RULE_NAME,
				"Ambiguous rule name: ", "'Person2Person'")
	}
	
	@Test
	def void testCheckClassMatcherNameNotForbidden() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("Person s", "Person _s").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.classMatcher, BXtendDSLValidator.FORBIDDEN_CLASS_MATCHER_NAME,
				"Forbidden class matcher name: ", "Class matcher names may not start with an underscore!")
	}
	@Test
	def void testCheckClassMatcherNameUnique() throws Exception {
		val parsed = pdb12pdb2.replaceFirst("Person t", "Person s").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.classMatcher, BXtendDSLValidator.AMBIGUOUS_CLASS_MATCHER_NAME,
				"Ambiguous class matcher name: ", "'s'")
	}
	
	@Test
	def void testCheckDuplicatedMappingParam_srcClass() throws Exception {
		val parsed = bags12bags2.replace("s <-->", "s s <-->").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.DUPLICATED_MAPPING_PARAM,
				189, -1, "Duplicated mapping parameter: ", "'s'")
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.DUPLICATED_MAPPING_PARAM,
				191, -1, "Duplicated mapping parameter: ", "'s'")
	}
	@Test
	def void testCheckDuplicatedMappingParam_trgFeature() throws Exception {
		val parsed = bags12bags2.replace("t.value", "t.value t.value").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.DUPLICATED_MAPPING_PARAM,
				196, -1, "Duplicated mapping parameter: ", "'t.value'")
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.DUPLICATED_MAPPING_PARAM,
				204, -1, "Duplicated mapping parameter: ", "'t.value'")
	}
	@Test
	def void testCheckDuplicatedMappingParam_corrFeature() throws Exception {
		val parsed = bags12bags2.replace(
				"{s.elements : Element2Element}",
				"{s.elements : Element2Element} s.elements")
				.parse(globalScope)
		
		parsed.assertNoIssues()
	}
	
	@Test
	def void testCheckMappingParamAlreadySet_featureParamClassParam() throws Exception {
		val parsed = bags12bags2.replace(
				'''
				trg Element t;
					s <--> t.value t.multiplicity;''',
				'''
				trg Element t;
					s <--> t.value t.multiplicity;
					s <--> t.value t.multiplicity;''')
				.parse(globalScope)
		
		parsed.assertWarning(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET,
				"Mapping parameter already set: ", "'s'")
		parsed.assertWarning(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET,
				"Mapping parameter already set: ", "'t.value'")
		parsed.assertWarning(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.MAPPING_PARAM_ALREADY_SET,
				"Mapping parameter already set: ", "'t.multiplicity'")
	}
	@Test
	def void testCheckMappingParamAlreadySet_considerDirection() throws Exception {
		val parsed = bags12bags2.replace(
				'''
				trg Element t;
					s <--> t.value t.multiplicity;''',
				'''
				trg Element t;
					s --> t.value;
					s --> t.multiplicity;''')
				.parse(globalScope)
		
		parsed.assertNoIssues()
	}
	@Test
	def void testCheckMappingParamAlreadySet_inOnlyParam() throws Exception {
		val parsed = pdb12pdb2.replace(
				'''
				trg Person t;
					s.birthday <--> t.birthday;
					s.placeOfBirth <--> t.placeOfBirth;''',
				'''
				trg Person t;
					s.birthday <--> s t.birthday;
					s.placeOfBirth <--> s t.placeOfBirth;''')
				.parse(globalScope)
		
		parsed.assertNoIssues()
	}
	
	@Test
	def void testCheckUnchangeableMappingFeature_output() throws Exception {
		val parsed = ecore2sql.replace("} --> {", "} <--> {").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.UNCHANGEABLE_MAPPING_FEATURE,
				"Unchangeable mapping feature: ", "'in.ePackage'", "It must not be used as out parameter of a mapping.")
	}
	@Test
	def void testCheckUnchangeableMappingFeature_input() throws Exception {
		val parsed = ecore2sql.replace("} --> {", "} --> {").parse(globalScope)
		
		parsed.assertNoIssues()
	}
	
	@Test
	def void testCheckAttributeCorrMappingFeature() throws Exception {
		val parsed = bags12bags2.replace("t.value", "{t.value : Element2Element}").parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.mappingFeature, BXtendDSLValidator.ATTRIBUTE_CORR_MAPPING_FEATURE,
				"Attribute corr mapping feature: ", "'{t.value : ...}'")
	}
	
	@Test
	def void testCheckDuplicatedCorrMappingRule() throws Exception {
		val parsed = bags12bags2.replace(
				"{s.elements : Element2Element}",
				"{s.elements : Element2Element, Element2Element}")
				.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.mappingFeature, BXtendDSLValidator.DUPLICATED_CORR_MAPPING_RULE,
				"Duplicated corr mapping rule: ", "'Element2Element'")
	}
	
	@Test
	def void testCheckUnresolvableCorrMappingRule() throws Exception {
		val parsed = pdb12pdb2.replace(
				"{s.persons : Person2Person[t]}",
				"{s.persons : Database2Database[t]}")
				.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.mappingFeature, BXtendDSLValidator.UNRESOLVABLE_CORR_MAPPING_RULE,
				"Unresolvable corr mapping rule: ",
				"No src matcher of 'Database2Database' fits to the type of 's.persons'.")
	}
	
	@Test
	def void testCheckCorrMappingRuleBeforeRule() throws Exception {
		val parsed = pdb12pdb2.replace(
				"s.birthday <--> t.birthday;",
				"{s.database : Database2Database} <--> {t.database : Database2Database};")
				.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.mappingFeature, BXtendDSLValidator.CORR_MAPPING_RULE_BEFORE_RULE,
				"Corr mapping rule before rule: ",
				"'Database2Database' can't be resolved, because it is executed after 'Person2Person'.")
	}
	
	@Test
	def void testCheckDuplicatedCorrMappingMatcher() throws Exception {
		val parsed = pdb12pdb2.replace(
				"{s.persons : Person2Person[t]}",
				"{s.persons : Person2Person[t, t]}")
				.parse(globalScope)
		
		val code = BXtendDSLValidator.DUPLICATED_CORR_MAPPING_MATCHER
		parsed.assertError(BXtendDSLPackage.eINSTANCE.correspondence, code,
				"Duplicated corr mapping matcher: ", "'t'")
	}
	
	@Test
	def void testCheckForbiddenClassMappingParam() throws Exception {
		val parsed = pdb12pdb2.replace(
				'''
				trg Person t;
					s.birthday <--> t.birthday;
					s.placeOfBirth <--> t.placeOfBirth;''',
				'''
				trg Person t;
					s.birthday <--> t t.birthday;
					s.placeOfBirth s <--> t.placeOfBirth;''')
				.parse(globalScope)
		
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.FORBIDDEN_CLASS_MAPPING_PARAM,
				"Forbidden class mapping parameter: ", "'t'")
		parsed.assertError(BXtendDSLPackage.eINSTANCE.featureMapping, BXtendDSLValidator.FORBIDDEN_CLASS_MAPPING_PARAM,
				"Forbidden class mapping parameter: ", "'s'")
	}
	
	@Test
	def void testCheckNoOutMappingParam() throws Exception {
		val parsed = bags12bags2.replace(
				'''
				trg MyBag t;
					{s.elements : Element2Element} <--> {t.elements : Element2Element};''',
				'''
				trg MyBag t;
					{s.elements : Element2Element} --> s;
					t <-- {t.elements : Element2Element};''')
				.parse(globalScope)
				
		parsed.assertError(BXtendDSLPackage.eINSTANCE.transformationRule, BXtendDSLValidator.NO_OUT_MAPPING_PARAM,
				"No out mapping parameter: ", "<-- is specified, but the lhs")
		parsed.assertError(BXtendDSLPackage.eINSTANCE.transformationRule, BXtendDSLValidator.NO_OUT_MAPPING_PARAM,
				"No out mapping parameter: ", "--> is specified, but the rhs")
	}
	
	@Test
	def void testCheckPdb12pdb2() throws Exception {
		pdb12pdb2.parse(globalScope).assertNoIssues()
	}
	@Test
	def void testCheckBags12bags2() throws Exception {
		bags12bags2.parse(globalScope).assertNoIssues()
	}
	@Test
	def void testCheckEcore2sql() throws Exception {
		ecore2sql.parse(globalScope).assertNoIssues()
	}
	
	def private String pdb12pdb2() {
		'''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		
		options
			PREFERED_SPACE
		
		rule Person2Person
			src Person s;
			trg Person t;
			s.birthday <--> t.birthday;
			s.placeOfBirth <--> t.placeOfBirth;
			s.id <--> t.id;
			s.firstName s.lastName <--> t.name;
		
		rule Database2Database
			src Database s;
			trg Database t;
			s.name <--> t.name;
			{s.persons : Person2Person[t]} <--> {t.persons : Person2Person[s]};
		'''
	}
	def private String bags12bags2() {
		'''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.bags1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.bags2.ecore"
		
		rule Element2Element
			src Element s | group;
			trg Element t;
			s <--> t.value t.multiplicity;
		
		rule Bag2Bag
			src MyBag s;
			trg MyBag t;
			{s.elements : Element2Element} <--> {t.elements : Element2Element};
		'''
	}
	def private String ecore2sql() {
		'''
		sourcemodel "http://www.eclipse.org/emf/2002/Ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.sql.ecore"
		
		rule EPackage2Schema
			src EPackage in;
			trg Schema out;
			in.name <--> out.name;
			
		rule EClass2Table
			src EClass in;
			trg Table out;
			in.name <--> out.name;
			{in.ePackage : EPackage2Schema} --> {out.owningSchema : EPackage2Schema};
		'''
	}
	
	var ResourceSet globalScope
}
