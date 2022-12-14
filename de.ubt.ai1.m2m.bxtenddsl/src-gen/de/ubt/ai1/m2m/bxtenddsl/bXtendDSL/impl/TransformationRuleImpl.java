/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.TransformationRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.TransformationRuleImpl#getSrcMatcher <em>Src Matcher</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.TransformationRuleImpl#getTrgMatcher <em>Trg Matcher</em>}</li>
 *   <li>{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.impl.TransformationRuleImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationRuleImpl extends MinimalEObjectImpl.Container implements TransformationRule
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSrcMatcher() <em>Src Matcher</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrcMatcher()
   * @generated
   * @ordered
   */
  protected EList<SrcClassMatcher> srcMatcher;

  /**
   * The cached value of the '{@link #getTrgMatcher() <em>Trg Matcher</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrgMatcher()
   * @generated
   * @ordered
   */
  protected EList<TrgClassMatcher> trgMatcher;

  /**
   * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappings()
   * @generated
   * @ordered
   */
  protected EList<FeatureMapping> mappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransformationRuleImpl()
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
    return BXtendDSLPackage.Literals.TRANSFORMATION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXtendDSLPackage.TRANSFORMATION_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SrcClassMatcher> getSrcMatcher()
  {
    if (srcMatcher == null)
    {
      srcMatcher = new EObjectContainmentEList<SrcClassMatcher>(SrcClassMatcher.class, this, BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER);
    }
    return srcMatcher;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TrgClassMatcher> getTrgMatcher()
  {
    if (trgMatcher == null)
    {
      trgMatcher = new EObjectContainmentEList<TrgClassMatcher>(TrgClassMatcher.class, this, BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER);
    }
    return trgMatcher;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FeatureMapping> getMappings()
  {
    if (mappings == null)
    {
      mappings = new EObjectContainmentEList<FeatureMapping>(FeatureMapping.class, this, BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS);
    }
    return mappings;
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
      case BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER:
        return ((InternalEList<?>)getSrcMatcher()).basicRemove(otherEnd, msgs);
      case BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER:
        return ((InternalEList<?>)getTrgMatcher()).basicRemove(otherEnd, msgs);
      case BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS:
        return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
      case BXtendDSLPackage.TRANSFORMATION_RULE__NAME:
        return getName();
      case BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER:
        return getSrcMatcher();
      case BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER:
        return getTrgMatcher();
      case BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS:
        return getMappings();
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
      case BXtendDSLPackage.TRANSFORMATION_RULE__NAME:
        setName((String)newValue);
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER:
        getSrcMatcher().clear();
        getSrcMatcher().addAll((Collection<? extends SrcClassMatcher>)newValue);
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER:
        getTrgMatcher().clear();
        getTrgMatcher().addAll((Collection<? extends TrgClassMatcher>)newValue);
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends FeatureMapping>)newValue);
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
      case BXtendDSLPackage.TRANSFORMATION_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER:
        getSrcMatcher().clear();
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER:
        getTrgMatcher().clear();
        return;
      case BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS:
        getMappings().clear();
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
      case BXtendDSLPackage.TRANSFORMATION_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case BXtendDSLPackage.TRANSFORMATION_RULE__SRC_MATCHER:
        return srcMatcher != null && !srcMatcher.isEmpty();
      case BXtendDSLPackage.TRANSFORMATION_RULE__TRG_MATCHER:
        return trgMatcher != null && !trgMatcher.isEmpty();
      case BXtendDSLPackage.TRANSFORMATION_RULE__MAPPINGS:
        return mappings != null && !mappings.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TransformationRuleImpl
