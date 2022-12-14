package de.ubt.ai1.m2m.bxtenddsl.framework;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Generator for the framework classes, which are CorrModel, Transformation and Elem2Elem.
 */
@SuppressWarnings("all")
public final class FrameworkGenerator {
  /**
   * Regenerates the framework classes for the given project, properties and dsl.
   */
  public static void generate(final IProject project, final Properties properties, final BXtendDSL dsl) throws CoreException {
    FrameworkGenerator.regenerateBxtendFolder(project);
    FrameworkGenerator.createFiles(project, properties, dsl);
  }
  
  private static void regenerateBxtendFolder(final IProject project) throws CoreException {
    final IFolder framework = project.getFolder("BXtend");
    framework.delete(true, null);
    framework.create(true, true, null);
    final IJavaProject javaProject = JavaCore.create(project);
    final ArrayList<IClasspathEntry> classpath = CollectionLiterals.<IClasspathEntry>newArrayList(javaProject.getRawClasspath());
    boolean _contains = classpath.contains(JavaCore.newSourceEntry(framework.getFullPath()));
    boolean _not = (!_contains);
    if (_not) {
      classpath.add(1, JavaCore.newSourceEntry(framework.getFullPath()));
    }
    javaProject.setRawClasspath(((IClasspathEntry[])Conversions.unwrapArray(classpath, IClasspathEntry.class)), null);
  }
  
  private static void createFiles(final IProject project, final Properties properties, final BXtendDSL dsl) throws CoreException {
    final FrameworkConfig config = new FrameworkConfig(project, properties, dsl);
    CorrModelGenerator.generate(config);
    String _replace = config.getRootPackage().replace(".", "/");
    String _plus = ("BXtend/" + _replace);
    String _plus_1 = (_plus + "/trafo");
    final IFolder trafo = project.getFolder(_plus_1);
    trafo.create(true, true, null);
    String _property = properties.getProperty("trafo");
    String _plus_2 = ("Abstract" + _property);
    String _plus_3 = (_plus_2 + ".xtend");
    final IFile entryClass = trafo.getFile(_plus_3);
    byte[] _bytes = AbstractEntryClassTemplate.getCode(config).getBytes();
    final ByteArrayInputStream entryClassSource = new ByteArrayInputStream(_bytes);
    entryClass.create(entryClassSource, true, null);
    String _replace_1 = config.getRootPackage().replace(".", "/");
    String _plus_4 = ("BXtend/" + _replace_1);
    String _plus_5 = (_plus_4 + "/rules");
    final IFolder rules = project.getFolder(_plus_5);
    rules.create(true, true, null);
    final IFile baseClass = rules.getFile("Elem2Elem.xtend");
    byte[] _bytes_1 = BaseClassTemplate.getCode(config).getBytes();
    final ByteArrayInputStream baseClassSource = new ByteArrayInputStream(_bytes_1);
    baseClass.create(baseClassSource, true, null);
  }
  
  private FrameworkGenerator() {
  }
}
