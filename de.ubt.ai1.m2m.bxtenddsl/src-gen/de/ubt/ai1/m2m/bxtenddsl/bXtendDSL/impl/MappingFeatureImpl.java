/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.MappingFeatureImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.MappingFeatureImpl#isCorr <em>Corr</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.MappingFeatureImpl#getCorrs <em>Corrs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingFeatureImpl extends MinimalEObjectImpl.Container implements MappingFeature
{
  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected EStructuralFeature feature;

  /**
   * The default value of the '{@link #isCorr() <em>Corr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCorr()
   * @generated
   * @ordered
   */
  protected static final boolean CORR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCorr() <em>Corr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCorr()
   * @generated
   * @ordered
   */
  protected boolean corr = CORR_EDEFAULT;

  /**
   * The cached value of the '{@link #getCorrs() <em>Corrs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrs()
   * @generated
   * @ordered
   */
  protected EList<Correspondence> corrs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MappingFeatureImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return BXtendDSLPackage.Literals.MAPPING_FEATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EStructuralFeature getFeature()
  {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (EStructuralFeature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXtendDSLPackage.MAPPING_FEATURE__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EStructuralFeature basicGetFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeature(EStructuralFeature newFeature)
  {
    EStructuralFeature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXtendDSLPackage.MAPPING_FEATURE__FEATURE, oldFeature, feature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCorr()
  {
    return corr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCorr(boolean newCorr)
  {
    boolean oldCorr = corr;
    corr = newCorr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXtendDSLPackage.MAPPING_FEATURE__CORR, oldCorr, corr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Correspondence> getCorrs()
  {
    if (corrs == null)
    {
      corrs = new EObjectContainmentEList<Correspondence>(Correspondence.class, this, BXtendDSLPackage.MAPPING_FEATURE__CORRS);
    }
    return corrs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case BXtendDSLPackage.MAPPING_FEATURE__CORRS:
        return ((InternalEList<?>)getCorrs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case BXtendDSLPackage.MAPPING_FEATURE__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case BXtendDSLPackage.MAPPING_FEATURE__CORR:
        return isCorr();
      case BXtendDSLPackage.MAPPING_FEATURE__CORRS:
        return getCorrs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case BXtendDSLPackage.MAPPING_FEATURE__FEATURE:
        setFeature((EStructuralFeature)newValue);
        return;
      case BXtendDSLPackage.MAPPING_FEATURE__CORR:
        setCorr((Boolean)newValue);
        return;
      case BXtendDSLPackage.MAPPING_FEATURE__CORRS:
        getCorrs().clear();
        getCorrs().addAll((Collection<? extends Correspondence>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case BXtendDSLPackage.MAPPING_FEATURE__FEATURE:
        setFeature((EStructuralFeature)null);
        return;
      case BXtendDSLPackage.MAPPING_FEATURE__CORR:
        setCorr(CORR_EDEFAULT);
        return;
      case BXtendDSLPackage.MAPPING_FEATURE__CORRS:
        getCorrs().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case BXtendDSLPackage.MAPPING_FEATURE__FEATURE:
        return feature != null;
      case BXtendDSLPackage.MAPPING_FEATURE__CORR:
        return corr != CORR_EDEFAULT;
      case BXtendDSLPackage.MAPPING_FEATURE__CORRS:
        return corrs != null && !corrs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (corr: ");
    result.append(corr);
    result.append(')');
    return result.toString();
  }

} //MappingFeatureImpl
