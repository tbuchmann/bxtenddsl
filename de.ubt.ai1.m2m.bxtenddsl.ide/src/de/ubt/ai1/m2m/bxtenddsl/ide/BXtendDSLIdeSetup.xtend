/*
 * generated by Xtext 2.15.0
 */
package de.ubt.ai1.m2m.bxtenddsl.ide

import com.google.inject.Guice
import de.ubt.ai1.m2m.bxtenddsl.BXtendDSLRuntimeModule
import de.ubt.ai1.m2m.bxtenddsl.BXtendDSLStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class BXtendDSLIdeSetup extends BXtendDSLStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new BXtendDSLRuntimeModule, new BXtendDSLIdeModule))
	}
	
}
