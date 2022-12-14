/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature#getFeature <em>Feature</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature#isCorr <em>Corr</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature#getCorrs <em>Corrs</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMappingFeature()
 * @model
 * @generated
 */
public interface MappingFeature extends EObject
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(EStructuralFeature)
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMappingFeature_Feature()
   * @model
   * @generated
   */
  EStructuralFeature getFeature();

  /**
   * Sets the value of the '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(EStructuralFeature value);

  /**
   * Returns the value of the '<em><b>Corr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Corr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Corr</em>' attribute.
   * @see #setCorr(boolean)
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMappingFeature_Corr()
   * @model
   * @generated
   */
  boolean isCorr();

  /**
   * Sets the value of the '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature#isCorr <em>Corr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Corr</em>' attribute.
   * @see #isCorr()
   * @generated
   */
  void setCorr(boolean value);

  /**
   * Returns the value of the '<em><b>Corrs</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Corrs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Corrs</em>' containment reference list.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMappingFeature_Corrs()
   * @model containment="true"
   * @generated
   */
  EList<Correspondence> getCorrs();

} // MappingFeature