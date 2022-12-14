package de.ubt.ai1.m2m.bxtenddsl.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import de.ubt.ai1.m2m.bxtenddsl.scoping.BXtendDSLScopeProvider
import org.junit.Test
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
import org.eclipse.xtext.testing.util.ParseHelper
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.junit.Before
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader

@RunWith(XtextRunner)
@InjectWith(BXtendDSLInjectorProvider)
class BXtendDSLScopingTest {
	@Inject extension ParseHelper<BXtendDSL>
	@Inject extension ValidationTestHelper
	@Inject BXtendDSLScopeProvider scopeProvider;
	@Inject Provider<ResourceSet> resourceSetProvider;
	
	@Before
	def void before() {
		MetamodelLoader.testMode = true
		globalScope = BXtendDSLTestUtils.buildGlobalScope(resourceSetProvider.get(),
				BXtendDSLTestConfig.pdb1Uri, BXtendDSLTestConfig.pdb2Uri,
				BXtendDSLTestConfig.GanttUri, BXtendDSLTestConfig.CpmUri,
				BXtendDSLTestConfig.PnUri, BXtendDSLTestConfig.PnwUri,
				BXtendDSLTestConfig.bags1Uri, BXtendDSLTestConfig.bags2Uri)
    }
	
	@Test
	def void testGetScope_srcClassMatcher() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.gantt.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.cpm.ecore"
		
		rule Dependency2Activity
			src Dependency s;
			trg Activity t | filter;
			s.successor s.predecessor --> t.name;
			s.offset <--> t.duration;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().srcMatcher.last()
		assertScope(context, BXtendDSLPackage.eINSTANCE.classMatcher_Clazz,
				"Activity", "GanttDiagram", "Dependency", "Element")
	}
	
	@Test
	def void testGetScope_trgClassMatcher() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.gantt.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.cpm.ecore"
		
		rule Dependency2Activity
			src Dependency s;
			trg Activity t | filter;
			s.successor s.predecessor --> t.name;
			s.offset <--> t.duration;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().trgMatcher.head()
		assertScope(context, BXtendDSLPackage.eINSTANCE.classMatcher_Clazz,
				"Activity", "Event", "CPMNetwork", "Element")
	}
	
	@Test
	def void testGetScope_srcFeatureMappingFeature() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		
		rule Person2Person
			src Person s;
			trg Person t;
			s.firstName s.lastName <--> t.name;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().mappings.head().srcFeatures.last()
		assertScope(context, BXtendDSLPackage.eINSTANCE.mappingFeature_Feature,
				"s.firstName", "s.lastName", "s.birthday", "s.placeOfBirth", "s.id", "s.database", "s.incrementalID")
	}
	
	@Test
	def void testGetScope_trgFeatureMappingFeature() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"
		
		rule Person2Person
			src Person s;
			trg Person t;
			s.firstName s.lastName <--> t.name;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().mappings.head().trgFeatures.head()
		assertScope(context, BXtendDSLPackage.eINSTANCE.mappingFeature_Feature,
				"t.name", "t.birthday", "t.placeOfBirth", "t.id", "t.database", "t.incrementalID")
	}
	
	@Test
	def void testGetScope_featureMappingInheritedFeatures() throws Exception {
		val parsed = '''
		sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pn.ecore"
		targetmodel "http://de.ubt.ai1.bw.qvt.examples.pnw.ecore"
		
		rule Place2Place
			src Place s;
			trg Place t;
			s.noOfTokens <--> t.noOfTokens;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().mappings.head().trgFeatures.head()
		assertScope(context, BXtendDSLPackage.eINSTANCE.mappingFeature_Feature,
				"t.name", "t.net", "t.noOfTokens", "t.inTPEdges", "t.outPTEdges")
	}
	
	@Test
	def void testGetScope_featureMappingNoGroupMatchers() throws Exception {
		val parsed = '''
			sourcemodel "http://de.ubt.ai1.bw.qvt.examples.bags1.ecore"
			targetmodel "http://de.ubt.ai1.bw.qvt.examples.bags2.ecore"
			
			rule Element2Element
				src Element s | group;
					Element r;
				trg Element t;
				s r.value <--> t.value t.multiplicity;
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val context = parsed.rules.head().mappings.head().srcFeatures.head()
		assertScope(context, BXtendDSLPackage.eINSTANCE.mappingFeature_Feature, "r.value", "r.bag", "r.incrementalID")
	}
	
	@Test
	def void testGetScope_Correspondence() throws Exception {
		val parsed = '''
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
				src Database srcDb;
				trg Database trgDb;
				srcDb.name <--> trgDb.name;
				{srcDb.persons : Person2Person[t]} <--> {trgDb.persons : Person2Person[s]};
		'''.parse(globalScope)
		parsed.assertNoErrors()
		
		val trgMatcher = parsed.rules.last().mappings.last().srcFeatures.head().corrs.head()
		assertScope(trgMatcher, BXtendDSLPackage.eINSTANCE.correspondence_Matchers, "t")
		val srcMatcher = parsed.rules.last().mappings.last().trgFeatures.head().corrs.head()
		assertScope(srcMatcher, BXtendDSLPackage.eINSTANCE.correspondence_Matchers, "s")
	}
	
	var ResourceSet globalScope
	
	def private assertScope(EObject context, EReference reference, String... expected) {
		val scope = scopeProvider.getScope(context, reference)
		assertThat(scope.allElements.map[name.toString].sort(), is(expected.sort()))
	}
}
