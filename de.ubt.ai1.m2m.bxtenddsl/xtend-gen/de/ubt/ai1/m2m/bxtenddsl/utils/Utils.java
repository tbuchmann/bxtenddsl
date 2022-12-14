package de.ubt.ai1.m2m.bxtenddsl.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.BXtendDSLPackage;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.ClassMatcher;
import de.ubt.ai1.m2m.bxtenddsl.bXtendDSL.MappingFeature;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Collection of useful functions for the BXtendDSL.
 */
@SuppressWarnings("all")
public class Utils {
  /**
   * Returns null, if there is no root EClass or multiple root EClasses.
   */
  public EClass rootEClass(final Resource res) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    final Iterator<EReference> containments = IteratorExtensions.<EReference>filter(Iterators.<EReference>filter(res.getAllContents(), EReference.class), _function);
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      boolean _contains = it.getEReferenceType().getEReferences().contains(it);
      return Boolean.valueOf((!_contains));
    };
    final Iterator<EReference> nonCyclicContainments = IteratorExtensions.<EReference>filter(containments, _function_1);
    final Function1<EReference, EClass> _function_2 = (EReference it) -> {
      return it.getEReferenceType();
    };
    final List<EClass> containmentsType = IteratorExtensions.<EClass>toList(IteratorExtensions.<EReference, EClass>map(nonCyclicContainments, _function_2));
    final Iterator<EClass> eclasses = Iterators.<EClass>filter(res.getAllContents(), EClass.class);
    final Function1<EClass, Boolean> _function_3 = (EClass eclass) -> {
      final Function1<EClass, Boolean> _function_4 = (EClass it) -> {
        return Boolean.valueOf(it.isSuperTypeOf(eclass));
      };
      boolean _exists = IterableExtensions.<EClass>exists(containmentsType, _function_4);
      return Boolean.valueOf((!_exists));
    };
    final List<EClass> roots = IteratorExtensions.<EClass>toList(IteratorExtensions.<EClass>filter(eclasses, _function_3));
    if (((roots.size() < 1) || (roots.size() > 1))) {
      return null;
    } else {
      return roots.get(0);
    }
  }
  
  /**
   * The qualified name of obj prefixed with the base package from its generator model.
   * The root of obj must be an EPackage that was loaded with the MetamodelLoader.
   */
  public String qualifiedName(final EObject obj) {
    EPackage _xtrycatchfinallyexpression = null;
    try {
      EObject _rootContainer = EcoreUtil2.getRootContainer(obj);
      _xtrycatchfinallyexpression = ((EPackage) _rootContainer);
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        throw new IllegalArgumentException("The root of \'obj\' must be an EPackage!");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final EPackage rootPackage = _xtrycatchfinallyexpression;
    GenModel _xifexpression = null;
    GenModel _genModel = MetamodelLoader.genModel(rootPackage.getNsURI());
    boolean _tripleNotEquals = (_genModel != null);
    if (_tripleNotEquals) {
      _xifexpression = MetamodelLoader.genModel(rootPackage.getNsURI());
    } else {
      throw new IllegalArgumentException("The root of \'obj\' must have been loaded with the MetamodelLoader!");
    }
    final GenModel genModel = _xifexpression;
    if (((!genModel.getGenPackages().isEmpty()) && (genModel.getGenPackages().get(0).getBasePackage() != null))) {
      String _basePackage = genModel.getGenPackages().get(0).getBasePackage();
      String _plus = (_basePackage + ".");
      String _string = this._defaultDeclarativeQualifiedNameProvider.getFullyQualifiedName(obj).toString();
      return (_plus + _string);
    } else {
      return this._defaultDeclarativeQualifiedNameProvider.getFullyQualifiedName(obj).toString();
    }
  }
  
  /**
   * The qualified name of the clazz attribute of the given matcher. Multivalued, if the group modifier is set.
   */
  public String qualifiedType(final ClassMatcher matcher) {
    boolean _isGroup = matcher.getModifier().isGroup();
    boolean _not = (!_isGroup);
    if (_not) {
      return this.qualifiedName(matcher.getClazz());
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("List<");
      String _qualifiedName = this.qualifiedName(matcher.getClazz());
      _builder.append(_qualifiedName);
      _builder.append(">");
      return _builder.toString();
    }
  }
  
  /**
   * The token parsed for the given feature.
   */
  public String token(final MappingFeature feature) {
    final EReference literal = BXtendDSLPackage.Literals.MAPPING_FEATURE__FEATURE;
    final List<INode> node = NodeModelUtils.findNodesForFeature(feature, literal);
    return NodeModelUtils.getTokenText(node.get(0));
  }
  
  /**
   * Returns true, if the given keyword is an Xtend keyword.
   */
  public boolean isXtendKeyword(final String keyword) {
    return (((Objects.equal(keyword, "class") || Objects.equal(keyword, "package")) || Objects.equal(keyword, "abstract")) || Objects.equal(keyword, "interface"));
  }
  
  @Inject
  @Extension
  private DefaultDeclarativeQualifiedNameProvider _defaultDeclarativeQualifiedNameProvider;
}
