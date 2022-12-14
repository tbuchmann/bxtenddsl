/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.CorrespondenceImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.CorrespondenceImpl#getMatchers <em>Matchers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CorrespondenceImpl extends MinimalEObjectImpl.Container implements Correspondence
{
  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected TransformationRule rule;

  /**
   * The cached value of the '{@link #getMatchers() <em>Matchers</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatchers()
   * @generated
   * @ordered
   */
  protected EList<ClassMatcher> matchers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CorrespondenceImpl()
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
    return BXtendDSLPackage.Literals.CORRESPONDENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TransformationRule getRule()
  {
    if (rule != null && rule.eIsProxy())
    {
      InternalEObject oldRule = (InternalEObject)rule;
      rule = (TransformationRule)eResolveProxy(oldRule);
      if (rule != oldRule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXtendDSLPackage.CORRESPONDENCE__RULE, oldRule, rule));
      }
    }
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationRule basicGetRule()
  {
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRule(TransformationRule newRule)
  {
    TransformationRule oldRule = rule;
    rule = newRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXtendDSLPackage.CORRESPONDENCE__RULE, oldRule, rule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClassMatcher> getMatchers()
  {
    if (matchers == null)
    {
      matchers = new EObjectResolvingEList<ClassMatcher>(ClassMatcher.class, this, BXtendDSLPackage.CORRESPONDENCE__MATCHERS);
    }
    return matchers;
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
      case BXtendDSLPackage.CORRESPONDENCE__RULE:
        if (resolve) return getRule();
        return basicGetRule();
      case BXtendDSLPackage.CORRESPONDENCE__MATCHERS:
        return getMatchers();
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
      case BXtendDSLPackage.CORRESPONDENCE__RULE:
        setRule((TransformationRule)newValue);
        return;
      case BXtendDSLPackage.CORRESPONDENCE__MATCHERS:
        getMatchers().clear();
        getMatchers().addAll((Collection<? extends ClassMatcher>)newValue);
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
      case BXtendDSLPackage.CORRESPONDENCE__RULE:
        setRule((TransformationRule)null);
        return;
      case BXtendDSLPackage.CORRESPONDENCE__MATCHERS:
        getMatchers().clear();
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
      case BXtendDSLPackage.CORRESPONDENCE__RULE:
        return rule != null;
      case BXtendDSLPackage.CORRESPONDENCE__MATCHERS:
        return matchers != null && !matchers.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CorrespondenceImpl
