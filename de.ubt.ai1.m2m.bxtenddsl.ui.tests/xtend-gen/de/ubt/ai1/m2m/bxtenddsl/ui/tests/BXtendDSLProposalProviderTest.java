package de.ubt.ai1.m2m.bxtenddsl.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BXtendDSLUiInjectorProvider.class)
@SuppressWarnings("all")
public class BXtendDSLProposalProviderTest extends AbstractContentAssistTest {
  @Test
  public void testCompleteSrcClassMatcher_Clazz() throws Exception {
    this.newBuilder().append(this.pdb12pdb2Until("Person s")).assertText("Person", "Database", "Elefant");
  }
  
  private String pdb12pdb2Until(final String until) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sourcemodel \"http://de.ubt.ai1.bw.qvt.examples.pdb1.ecore\"");
    _builder.newLine();
    _builder.append("targetmodel \"http://de.ubt.ai1.bw.qvt.examples.pdb2.ecore\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule Person2Person");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src Person s");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Person t");
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
    _builder.append("src Database s");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("trg Database t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s.name <--> t.name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{s.persons : Person} <--> {t.persons : Person};");
    _builder.newLine();
    _builder.newLine();
    final String pdb12pdb2 = _builder.toString();
    int _xifexpression = (int) 0;
    int _indexOf = pdb12pdb2.indexOf(until);
    boolean _greaterThan = (_indexOf > 0);
    if (_greaterThan) {
      _xifexpression = pdb12pdb2.indexOf(until);
    } else {
      _xifexpression = pdb12pdb2.length();
    }
    final int untilIndex = _xifexpression;
    return pdb12pdb2.substring(0, untilIndex);
  }
}
