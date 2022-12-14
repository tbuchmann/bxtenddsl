package de.ubt.ai1.m2m.bxtenddsl

import org.eclipse.emf.ecore.resource.Resource

interface BXtendTransformation {
	def void sourceToTarget();
	def void targetToSource();
	
	def Object getOption(String option);
	def void setOption(String option, Object value);
	
	def Resource getSource();
	def Resource getTarget();
	def Resource getCorr();
}
