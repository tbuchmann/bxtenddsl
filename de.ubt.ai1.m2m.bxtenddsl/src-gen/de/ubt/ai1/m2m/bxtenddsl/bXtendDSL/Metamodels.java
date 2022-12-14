/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodels</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getSourcemodel <em>Sourcemodel</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getCustomizedSrcElements <em>Customized Src Elements</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getTargetmodel <em>Targetmodel</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getCustomizedTrgElements <em>Customized Trg Elements</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMetamodels()
 * @model
 * @generated
 */
public interface Metamodels extends EObject
{
  /**
   * Returns the value of the '<em><b>Sourcemodel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sourcemodel</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sourcemodel</em>' attribute.
   * @see #setSourcemodel(String)
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMetamodels_Sourcemodel()
   * @model
   * @generated
   */
  String getSourcemodel();

  /**
   * Sets the value of the '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getSourcemodel <em>Sourcemodel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sourcemodel</em>' attribute.
   * @see #getSourcemodel()
   * @generated
   */
  void setSourcemodel(String value);

  /**
   * Returns the value of the '<em><b>Customized Src Elements</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Customized Src Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Customized Src Elements</em>' containment reference list.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMetamodels_CustomizedSrcElements()
   * @model containment="true"
   * @generated
   */
  EList<CustomizedElement> getCustomizedSrcElements();

  /**
   * Returns the value of the '<em><b>Targetmodel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targetmodel</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targetmodel</em>' attribute.
   * @see #setTargetmodel(String)
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMetamodels_Targetmodel()
   * @model
   * @generated
   */
  String getTargetmodel();

  /**
   * Sets the value of the '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels#getTargetmodel <em>Targetmodel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Targetmodel</em>' attribute.
   * @see #getTargetmodel()
   * @generated
   */
  void setTargetmodel(String value);

  /**
   * Returns the value of the '<em><b>Customized Trg Elements</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Customized Trg Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Customized Trg Elements</em>' containment reference list.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage#getMetamodels_CustomizedTrgElements()
   * @model containment="true"
   * @generated
   */
  EList<CustomizedElement> getCustomizedTrgElements();

} // Metamodels
