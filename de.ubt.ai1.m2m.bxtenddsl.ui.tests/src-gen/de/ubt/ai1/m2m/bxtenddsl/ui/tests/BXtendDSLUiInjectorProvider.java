/*
 * generated by Xtext 2.21.0
 */
package de.ubt.ai1.m2m.bxtenddsl.ui.tests;

import com.google.inject.Injector;
import de.ubt.ai1.m2m.bxtenddsl.ui.internal.BxtenddslActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class BXtendDSLUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return BxtenddslActivator.getInstance().getInjector("de.ubt.ai1.m2m.bxtenddsl.BXtendDSL");
	}

}
