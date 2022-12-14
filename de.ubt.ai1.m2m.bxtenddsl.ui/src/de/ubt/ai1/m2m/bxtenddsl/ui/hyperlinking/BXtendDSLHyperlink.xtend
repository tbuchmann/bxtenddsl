package de.ubt.ai1.m2m.bxtenddsl.ui.hyperlinking

import org.eclipse.jface.text.IRegion
import org.eclipse.jface.text.hyperlink.IHyperlink

/*******************************************************************************
 * @author    Jonas Fraas <jonas.fraas(at)uni-bayreuth.de>
 * @date      2019-06-14
 ******************************************************************************/
class BXtendDSLHyperlink implements IHyperlink{
	val IRegion hyperlinkRegion
	val String label
	val () => void callback
	
	new(IRegion hyperlinkRegion, String label, () => void callback) {
		this.hyperlinkRegion = hyperlinkRegion
		this.callback = callback
		this.label = label
	}
	
	override getHyperlinkRegion() {
		hyperlinkRegion
	}
	
	override getHyperlinkText() {
		label
	}
	
	override getTypeLabel() {
		label
	}
	
	override open() {
		if (callback !== null)
			callback.apply()
	}
}
