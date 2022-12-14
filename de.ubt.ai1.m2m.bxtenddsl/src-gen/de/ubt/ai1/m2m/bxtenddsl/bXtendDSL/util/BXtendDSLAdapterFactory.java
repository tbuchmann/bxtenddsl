/**
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.util;

import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage
 * @generated
 */
public class BXtendDSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BXtendDSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BXtendDSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = BXtendDSLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BXtendDSLSwitch<Adapter> modelSwitch =
    new BXtendDSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseBXtendDSL(BXtendDSL object)
      {
        return createBXtendDSLAdapter();
      }
      @Override
      public Adapter caseMetamodels(Metamodels object)
      {
        return createMetamodelsAdapter();
      }
      @Override
      public Adapter caseCustomizedElement(CustomizedElement object)
      {
        return createCustomizedElementAdapter();
      }
      @Override
      public Adapter caseCustomizedGetter(CustomizedGetter object)
      {
        return createCustomizedGetterAdapter();
      }
      @Override
      public Adapter caseCustomizedSetter(CustomizedSetter object)
      {
        return createCustomizedSetterAdapter();
      }
      @Override
      public Adapter caseConfig(Config object)
      {
        return createConfigAdapter();
      }
      @Override
      public Adapter caseTransformationRule(TransformationRule object)
      {
        return createTransformationRuleAdapter();
      }
      @Override
      public Adapter caseClassMatcher(ClassMatcher object)
      {
        return createClassMatcherAdapter();
      }
      @Override
      public Adapter caseSrcClassMatcher(SrcClassMatcher object)
      {
        return createSrcClassMatcherAdapter();
      }
      @Override
      public Adapter caseTrgClassMatcher(TrgClassMatcher object)
      {
        return createTrgClassMatcherAdapter();
      }
      @Override
      public Adapter caseClassMatcherModifier(ClassMatcherModifier object)
      {
        return createClassMatcherModifierAdapter();
      }
      @Override
      public Adapter caseFeatureMapping(FeatureMapping object)
      {
        return createFeatureMappingAdapter();
      }
      @Override
      public Adapter caseMappingFeature(MappingFeature object)
      {
        return createMappingFeatureAdapter();
      }
      @Override
      public Adapter caseSrcMappingFeature(SrcMappingFeature object)
      {
        return createSrcMappingFeatureAdapter();
      }
      @Override
      public Adapter caseTrgMappingFeature(TrgMappingFeature object)
      {
        return createTrgMappingFeatureAdapter();
      }
      @Override
      public Adapter caseCorrespondence(Correspondence object)
      {
        return createCorrespondenceAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL <em>BXtend DSL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSL
   * @generated
   */
  public Adapter createBXtendDSLAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels <em>Metamodels</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Metamodels
   * @generated
   */
  public Adapter createMetamodelsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedElement <em>Customized Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedElement
   * @generated
   */
  public Adapter createCustomizedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedGetter <em>Customized Getter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedGetter
   * @generated
   */
  public Adapter createCustomizedGetterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedSetter <em>Customized Setter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.CustomizedSetter
   * @generated
   */
  public Adapter createCustomizedSetterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Config <em>Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Config
   * @generated
   */
  public Adapter createConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule <em>Transformation Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TransformationRule
   * @generated
   */
  public Adapter createTransformationRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher <em>Class Matcher</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher
   * @generated
   */
  public Adapter createClassMatcherAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher <em>Src Class Matcher</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcClassMatcher
   * @generated
   */
  public Adapter createSrcClassMatcherAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher <em>Trg Class Matcher</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgClassMatcher
   * @generated
   */
  public Adapter createTrgClassMatcherAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcherModifier <em>Class Matcher Modifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcherModifier
   * @generated
   */
  public Adapter createClassMatcherModifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping <em>Feature Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.FeatureMapping
   * @generated
   */
  public Adapter createFeatureMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature <em>Mapping Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature
   * @generated
   */
  public Adapter createMappingFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature <em>Src Mapping Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.SrcMappingFeature
   * @generated
   */
  public Adapter createSrcMappingFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature <em>Trg Mapping Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.TrgMappingFeature
   * @generated
   */
  public Adapter createTrgMappingFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence <em>Correspondence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.Correspondence
   * @generated
   */
  public Adapter createCorrespondenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //BXtendDSLAdapterFactory
