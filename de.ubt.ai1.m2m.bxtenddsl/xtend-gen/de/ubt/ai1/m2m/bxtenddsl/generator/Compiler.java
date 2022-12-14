package de.ubt.ai1.m2m.bxtenddsl.generator;

import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Super class for compilers. A compiler translates BXtendDSL code to Xtend fragments.
 */
@SuppressWarnings("all")
public abstract class Compiler {
  /**
   * Returns all imports necessary for the Xtend fragments that were compiled since the last call to this method.
   */
  public Set<String> neededImports(final String rootPackage) {
    final Function1<String, String> _function = (String it) -> {
      return it.replace("*rootPackage.", (rootPackage + "."));
    };
    final Set<String> neededImports = IterableExtensions.<String>toSet(IterableExtensions.<String, String>map(this.neededImports, _function));
    this.neededImports = CollectionLiterals.<String>newHashSet();
    return neededImports;
  }
  
  protected Set<String> neededImports = CollectionLiterals.<String>newHashSet();
}
