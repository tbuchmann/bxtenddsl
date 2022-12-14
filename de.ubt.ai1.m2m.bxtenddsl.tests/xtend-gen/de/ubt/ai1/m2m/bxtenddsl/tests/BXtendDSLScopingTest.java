package de.ubt.ai1.m2m.bxtenddsl.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature;
import de.ubt.ai1.m2m.bxtenddsl.scoping.BXtendDSLScopeProvider;
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BXtendDSLInjectorProvider.class)
@SuppressWarnings("all")
public class BXtendDSLScopingTest {
  @Inject
  @Extension
  private ParseHelper<BXtendDSL> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  private BXtendDSLScopeProvider scopeProvider;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Before
  public void before() {
    MetamodelLoader.testMode = true;
    this.globalScope = BXtendDSLTestUtils.buildGlobalScope(this.resourceSetProvider.get(), 
      BXtendDSLTestConfig.pdb1Uri, BXtendDSLTestConfig.pdb2Uri, 
      BXtendDSLTestConfig.GanttUri, BXtendDSLTestConfig.CpmUri, 
      BXtendDSLTestConfig.PnUri, BXtendDSLTestConfig.PnwUri, 
      BXtendDSLTestConfig.bags1Uri, BXtendDSLTestConfig.bags2Uri);
  }
  
  @Test
  public void testGetScope_srcClassMatcher() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.gantt.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.cpm.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Dependency2Activity");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Dependency s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Activity t | filter;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.successor s.predecessor --> t.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.offset <--> t.duration;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final SrcClassMatcher context = IterableExtensions.<SrcClassMatcher>last(IterableExtensions.<TransformationRule>head(parsed.getRules()).getSrcMatcher());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getClassMatcher_Clazz(), 
      "Activity", "GanttDiagram", "Dependency", "Element");
  }
  
  @Test
  public void testGetScope_trgClassMatcher() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.gantt.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.cpm.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Dependency2Activity");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Dependency s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Activity t | filter;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.successor s.predecessor --> t.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.offset <--> t.duration;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final TrgClassMatcher context = IterableExtensions.<TrgClassMatcher>head(IterableExtensions.<TransformationRule>head(parsed.getRules()).getTrgMatcher());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getClassMatcher_Clazz(), 
      "Activity", "Event", "CPMNetwork", "Element");
  }
  
  @Test
  public void testGetScope_srcFeatureMappingFeature() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
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
    _builder.append("s.firstName s.lastName <--> t.name;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final SrcMappingFeature context = IterableExtensions.<SrcMappingFeature>last(IterableExtensions.<FeatureMapping>head(IterableExtensions.<TransformationRule>head(parsed.getRules()).getMappings()).getSrcFeatures());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getMappingFeature_Feature(), 
      "s.firstName", "s.lastName", "s.birthday", "s.placeOfBirth", "s.id", "s.database", "s.incrementalID");
  }
  
  @Test
  public void testGetScope_trgFeatureMappingFeature() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
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
    _builder.append("s.firstName s.lastName <--> t.name;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final TrgMappingFeature context = IterableExtensions.<TrgMappingFeature>head(IterableExtensions.<FeatureMapping>head(IterableExtensions.<TransformationRule>head(parsed.getRules()).getMappings()).getTrgFeatures());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getMappingFeature_Feature(), 
      "t.name", "t.birthday", "t.placeOfBirth", "t.id", "t.database", "t.incrementalID");
  }
  
  @Test
  public void testGetScope_featureMappingInheritedFeatures() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pn.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pnw.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Place2Place");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Place s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Place t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.noOfTokens <--> t.noOfTokens;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final TrgMappingFeature context = IterableExtensions.<TrgMappingFeature>head(IterableExtensions.<FeatureMapping>head(IterableExtensions.<TransformationRule>head(parsed.getRules()).getMappings()).getTrgFeatures());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getMappingFeature_Feature(), 
      "t.name", "t.net", "t.noOfTokens", "t.inTPEdges", "t.outPTEdges");
  }
  
  @Test
  public void testGetScope_featureMappingNoGroupMatchers() throws Exception {
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
    _builder.append("\t\t");
    _builder.append("Element r;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Element t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s r.value <--> t.value t.multiplicity;");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final SrcMappingFeature context = IterableExtensions.<SrcMappingFeature>head(IterableExtensions.<FeatureMapping>head(IterableExtensions.<TransformationRule>head(parsed.getRules()).getMappings()).getSrcFeatures());
    this.assertScope(context, BXtendDSLPackage.eINSTANCE.getMappingFeature_Feature(), "r.value", "r.bag", "r.incrementalID");
  }
  
  @Test
  public void testGetScope_Correspondence() throws Exception {
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
    _builder.append("src Database srcDb;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Database trgDb;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("srcDb.name <--> trgDb.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{srcDb.persons : Person2Person[t]} <--> {trgDb.persons : Person2Person[s]};");
    _builder.newLine();
    final BXtendDSL parsed = this._parseHelper.parse(_builder, this.globalScope);
    this._validationTestHelper.assertNoErrors(parsed);
    final Correspondence trgMatcher = IterableExtensions.<Correspondence>head(IterableExtensions.<SrcMappingFeature>head(IterableExtensions.<FeatureMapping>last(IterableExtensions.<TransformationRule>last(parsed.getRules()).getMappings()).getSrcFeatures()).getCorrs());
    this.assertScope(trgMatcher, BXtendDSLPackage.eINSTANCE.getCorrespondence_Matchers(), "t");
    final Correspondence srcMatcher = IterableExtensions.<Correspondence>head(IterableExtensions.<TrgMappingFeature>head(IterableExtensions.<FeatureMapping>last(IterableExtensions.<TransformationRule>last(parsed.getRules()).getMappings()).getTrgFeatures()).getCorrs());
    this.assertScope(srcMatcher, BXtendDSLPackage.eINSTANCE.getCorrespondence_Matchers(), "s");
  }
  
  private ResourceSet globalScope;
  
  private void assertScope(final EObject context, final EReference reference, final String... expected) {
    final IScope scope = this.scopeProvider.getScope(context, reference);
    final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
      return it.getName().toString();
    };
    Assert.<List<String>>assertThat(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(scope.getAllElements(), _function)), CoreMatchers.<List<String>>is(IterableExtensions.<String>sort(((Iterable<String>)Conversions.doWrapArray(expected)))));
  }
}
