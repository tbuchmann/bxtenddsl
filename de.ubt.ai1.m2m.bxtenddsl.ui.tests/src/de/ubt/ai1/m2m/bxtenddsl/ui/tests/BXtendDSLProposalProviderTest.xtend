package de.ubt.ai1.m2m.bxtenddsl.ui.tests

import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.eclipse.xtext.testing.XtextRunner
import org.junit.jupiter.api.Test
import org.eclipse.xtext.testing.InjectWith
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(BXtendDSLUiInjectorProvider))
class BXtendDSLProposalProviderTest extends AbstractContentAssistTest {
	@Test def void testCompleteSrcClassMatcher_Clazz() throws Exception {
		// throws NullPointerException, injector is null
		newBuilder.append(pdb12pdb2Until("Person s")).assertText("Person", "Database", "Elefant")
	}
	
	def private String pdb12pdb2Until(String until) {
		val pdb12pdb2 = '''
sourcemodel "http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore"
targetmodel "http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore"

rule Person2Person
	src Person s
	trg Person t
	s.birthday <--> t.birthday;
	s.placeOfBirth <--> t.placeOfBirth;
	s.id <--> t.id;
	s.firstName s.lastName <--> t.name;

rule Database2Database
	src Database s
	trg Database t
	s.name <--> t.name;
	{s.persons : Person} <--> {t.persons : Person};

		'''
		val untilIndex = if (pdb12pdb2.indexOf(until) > 0) pdb12pdb2.indexOf(until) else pdb12pdb2.length()
		return pdb12pdb2.substring(0, untilIndex)
	}
}