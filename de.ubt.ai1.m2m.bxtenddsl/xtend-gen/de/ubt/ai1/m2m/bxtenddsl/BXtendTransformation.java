package de.ubt.ai1.m2m.bxtenddsl;

import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public interface BXtendTransformation {
  void sourceToTarget();
  
  void targetToSource();
  
  Object getOption(final String option);
  
  void setOption(final String option, final Object value);
  
  Resource getSource();
  
  Resource getTarget();
  
  Resource getCorr();
}
