/**
 * generated by Xtext 2.15.0
 */
package de.ubt.ai1.m2m.bxtenddsl;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class BXtendDSLStandaloneSetup extends BXtendDSLStandaloneSetupGenerated {
  public static void doSetup() {
    new BXtendDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
