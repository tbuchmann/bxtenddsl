package de.ubt.ai1.m2m.bxtenddsl.ui.hyperlinking;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess;
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author    Jonas Fraas <jonas.fraas(at)uni-bayreuth.de>
 * @date      2019-06-14
 */
@SuppressWarnings("all")
public class BXtendDSLHyperlinkHelper extends HyperlinkHelper {
  @Override
  public IHyperlink[] createHyperlinksByOffset(final XtextResource resource, final int offset, final boolean createMultipleHyperlinks) {
    final ILeafNode currentNode = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
    final EObject crossReferencedElement = this.eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    int _offset = currentNode.getOffset();
    int _length = currentNode.getLength();
    final Region linkRegion = new Region(_offset, _length);
    EObject _xifexpression = null;
    if ((Objects.equal(currentNode.getGrammarElement(), this.grammerAccess.getMetamodelsAccess().getSourcemodelSTRINGTerminalRuleCall_1_0()) || Objects.equal(currentNode.getGrammarElement(), this.grammerAccess.getMetamodelsAccess().getTargetmodelSTRINGTerminalRuleCall_4_0()))) {
      EObject _xblockexpression = null;
      {
        String _text = currentNode.getText();
        int _length_1 = currentNode.getText().length();
        int _minus = (_length_1 - 1);
        final String uri = _text.substring(1, _minus);
        EObject _xtrycatchfinallyexpression = null;
        try {
          ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
          _xtrycatchfinallyexpression = MetamodelLoader.load(uri, _resourceSetImpl).getContents().get(0);
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      _xifexpression = _xblockexpression;
    } else {
      EObject _xifexpression_1 = null;
      if ((((crossReferencedElement != null) && (!crossReferencedElement.eIsProxy())) && ((((crossReferencedElement instanceof EPackage) || (crossReferencedElement instanceof EClassifier)) || (crossReferencedElement instanceof EStructuralFeature)) || (crossReferencedElement instanceof EEnumLiteral)))) {
        _xifexpression_1 = crossReferencedElement;
      }
      _xifexpression = _xifexpression_1;
    }
    final EObject ecoreTarget = _xifexpression;
    if ((ecoreTarget != null)) {
      final Procedure0 _function = () -> {
        this.openEcoreEditorAndSelectItem(ecoreTarget);
      };
      BXtendDSLHyperlink _bXtendDSLHyperlink = new BXtendDSLHyperlink(linkRegion, "Open element in Ecore Model Editor", _function);
      return new IHyperlink[] { _bXtendDSLHyperlink };
    } else {
      EObject _grammarElement = currentNode.getGrammarElement();
      RuleCall _nameIDTerminalRuleCall_1_0 = this.grammerAccess.getTransformationRuleAccess().getNameIDTerminalRuleCall_1_0();
      boolean _equals = Objects.equal(_grammarElement, _nameIDTerminalRuleCall_1_0);
      if (_equals) {
        final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(URI.decode(resource.getURI().segment(1)));
        final Function1<IResource, Boolean> _function_1 = (IResource it) -> {
          String _name = it.getName();
          String _text = currentNode.getText();
          String _plus = (_text + ".xtend");
          return Boolean.valueOf(Objects.equal(_name, _plus));
        };
        final IResource rule = IterableExtensions.<IResource>findFirst(this.allMembers(project.getFolder("src-gen")), _function_1);
        final Function1<IResource, Boolean> _function_2 = (IResource it) -> {
          String _name = it.getName();
          String _text = currentNode.getText();
          String _plus = (_text + "Impl.xtend");
          return Boolean.valueOf(Objects.equal(_name, _plus));
        };
        final IResource ruleImpl = IterableExtensions.<IResource>findFirst(this.allMembers(project.getFolder("src")), _function_2);
        final Function1<IFileStore, IEditorPart> _function_3 = (IFileStore fileStore) -> {
          IEditorPart _xifexpression_2 = null;
          if (((!fileStore.fetchInfo().isDirectory()) && fileStore.fetchInfo().exists())) {
            IEditorPart _xblockexpression_1 = null;
            {
              final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
              IWorkbenchPage _activePage = null;
              if (activeWindow!=null) {
                _activePage=activeWindow.getActivePage();
              }
              final IWorkbenchPage activePage = _activePage;
              IEditorPart _xifexpression_3 = null;
              if ((activePage != null)) {
                IEditorPart _xtrycatchfinallyexpression = null;
                try {
                  _xtrycatchfinallyexpression = IDE.openEditorOnFileStore(activePage, fileStore);
                } catch (final Throwable _t) {
                  if (_t instanceof PartInitException) {
                    final PartInitException e = (PartInitException)_t;
                    e.printStackTrace();
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
                _xifexpression_3 = _xtrycatchfinallyexpression;
              }
              _xblockexpression_1 = _xifexpression_3;
            }
            _xifexpression_2 = _xblockexpression_1;
          }
          return _xifexpression_2;
        };
        final Function1<IFileStore, IEditorPart> openEditor = _function_3;
        final ArrayList<BXtendDSLHyperlink> links = CollectionLiterals.<BXtendDSLHyperlink>newArrayList();
        if ((ruleImpl != null)) {
          final Procedure0 _function_4 = () -> {
            openEditor.apply(EFS.getLocalFileSystem().getStore(ruleImpl.getRawLocation()));
          };
          BXtendDSLHyperlink _bXtendDSLHyperlink_1 = new BXtendDSLHyperlink(linkRegion, "Open rule implementation in Xtend Editor", _function_4);
          links.add(_bXtendDSLHyperlink_1);
        }
        if ((rule != null)) {
          final Procedure0 _function_5 = () -> {
            openEditor.apply(EFS.getLocalFileSystem().getStore(rule.getRawLocation()));
          };
          BXtendDSLHyperlink _bXtendDSLHyperlink_2 = new BXtendDSLHyperlink(linkRegion, "Open generated rule code in Xtend Editor", _function_5);
          links.add(_bXtendDSLHyperlink_2);
        }
        return ((IHyperlink[])Conversions.unwrapArray(links, IHyperlink.class));
      } else {
        return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks);
      }
    }
  }
  
  private void openEcoreEditorAndSelectItem(final EObject item) {
    if (((item != null) && (EcoreUtil2.<EPackage>getContainerOfType(item, EPackage.class) != null))) {
      final URI file = this.packageToFile(EcoreUtil2.<EPackage>getContainerOfType(item, EPackage.class));
      EcoreEditor _xtrycatchfinallyexpression = null;
      try {
        EcoreEditor _openEcoreEditor = null;
        if (file!=null) {
          _openEcoreEditor=this.openEcoreEditor(file);
        }
        _xtrycatchfinallyexpression = _openEcoreEditor;
      } catch (final Throwable _t) {
        if (_t instanceof PartInitException) {
          final PartInitException e = (PartInitException)_t;
          e.printStackTrace();
          return;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final EcoreEditor editor = _xtrycatchfinallyexpression;
      final TreePath treePath = this.getTreePathToObject(editor, item);
      this.expandTreePath(editor, treePath);
    }
  }
  
  private URI packageToFile(final EPackage ePackage) {
    final GenModel genModel = MetamodelLoader.genModel(ePackage.getNsURI());
    final String relativeModelPath = genModel.getForeignModel().get(0);
    final ResourceSetImpl resSet = new ResourceSetImpl();
    final URI genModelUri = resSet.getURIConverter().normalize(genModel.eResource().getURI());
    final String modelUri = genModelUri.toFileString().replaceFirst("\\\\(\\w)*\\.genmodel", ("\\\\" + relativeModelPath));
    return URI.createFileURI(modelUri);
  }
  
  private EcoreEditor openEcoreEditor(final URI resource) throws PartInitException {
    final String trimmedFileURI = resource.toFileString().replaceFirst("\\\\(\\w)*\\.ecore", "\\\\");
    IFileSystem _localFileSystem = EFS.getLocalFileSystem();
    Path _path = new Path(trimmedFileURI);
    final IFileStore fileStoreContainer = _localFileSystem.getStore(_path);
    String _last = IterableExtensions.<String>last(resource.segmentsList());
    Path _path_1 = new Path(_last);
    final IFileStore fileStore = fileStoreContainer.getFileStore(_path_1);
    if (((!fileStore.fetchInfo().isDirectory()) && fileStore.fetchInfo().exists())) {
      final IWorkbenchWindow activeWindows = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
      IWorkbenchPage _activePage = null;
      if (activeWindows!=null) {
        _activePage=activeWindows.getActivePage();
      }
      final IWorkbenchPage activePage = _activePage;
      if ((activePage != null)) {
        IEditorPart _openEditorOnFileStore = IDE.openEditorOnFileStore(activePage, fileStore);
        return ((EcoreEditor) _openEditorOnFileStore);
      }
    }
    return null;
  }
  
  private TreePath getTreePathToObject(final IEditorPart editor, final EObject crossLinkedEObject) {
    if ((editor instanceof EcoreEditor)) {
      final List<?> path = ((EcoreEditor)editor).getEditingDomain().getTreePath(crossLinkedEObject);
      return new TreePath(((Object[])Conversions.unwrapArray(path, Object.class)));
    }
    return null;
  }
  
  private void expandTreePath(final EcoreEditor ecoreEditor, final TreePath treePath) {
    for (int i = 0; (i < treePath.getSegmentCount()); i++) {
      Object _segment = treePath.getSegment(i);
      boolean _not = (!(_segment instanceof ENamedElement));
      if (_not) {
        Viewer _viewer = ecoreEditor.getViewer();
        final TreeViewer treeViewer = ((TreeViewer) _viewer);
        treeViewer.setExpandedState((treeViewer.getTree().getItems()[0]).getData(), true);
      } else {
        Object _segment_1 = treePath.getSegment(i);
        final ENamedElement element = ((ENamedElement) _segment_1);
        Viewer _viewer_1 = ecoreEditor.getViewer();
        final TreeViewer treeViewer_1 = ((TreeViewer) _viewer_1);
        final HashSet<TreeItem> treeItems = this.getAllItems(treeViewer_1.getTree());
        final ENamedElement item = this.findMatchingTreeItem(element, treeItems);
        ecoreEditor.setSelectionToViewer(Collections.<ENamedElement>singleton(item));
        int _segmentCount = treePath.getSegmentCount();
        int _minus = (_segmentCount - 1);
        boolean _notEquals = (i != _minus);
        if (_notEquals) {
          treeViewer_1.setExpandedState(item, true);
        }
      }
    }
  }
  
  private HashSet<TreeItem> getAllItems(final Tree tree) {
    final HashSet<TreeItem> items = new HashSet<TreeItem>();
    TreeItem[] _items = tree.getItems();
    for (final TreeItem item : _items) {
      {
        items.add(item);
        Collection<TreeItem> _allItems = this.getAllItems(item);
        Iterables.<TreeItem>addAll(items, _allItems);
      }
    }
    return items;
  }
  
  private Collection<TreeItem> getAllItems(final TreeItem currentItem) {
    final TreeItem[] children = currentItem.getItems();
    final HashSet<TreeItem> items = new HashSet<TreeItem>();
    for (int i = 0; (i < children.length); i++) {
      {
        TreeItem _get = children[i];
        items.add(_get);
        Collection<TreeItem> _allItems = this.getAllItems(children[i]);
        Iterables.<TreeItem>addAll(items, _allItems);
      }
    }
    return items;
  }
  
  private ENamedElement findMatchingTreeItem(final ENamedElement namedElement, final Collection<TreeItem> items) {
    final Function1<TreeItem, Object> _function = (TreeItem it) -> {
      return it.getData();
    };
    final Function1<ENamedElement, Boolean> _function_1 = (ENamedElement it) -> {
      String _name = namedElement.getName();
      String _name_1 = it.getName();
      return Boolean.valueOf(Objects.equal(_name, _name_1));
    };
    return IterableExtensions.<ENamedElement>findFirst(Iterables.<ENamedElement>filter(IterableExtensions.<TreeItem, Object>map(items, _function), ENamedElement.class), _function_1);
  }
  
  private List<IResource> allMembers(final IResource resource) {
    if ((!(resource instanceof IContainer))) {
      return Collections.<IResource>unmodifiableList(CollectionLiterals.<IResource>newArrayList(resource));
    }
    IResource[] _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = ((IContainer) resource).members();
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        return Collections.<IResource>unmodifiableList(CollectionLiterals.<IResource>newArrayList());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final IResource[] members = _xtrycatchfinallyexpression;
    final Function1<IResource, List<IResource>> _function = (IResource it) -> {
      return this.allMembers(it);
    };
    return IterableExtensions.<IResource>toList(Iterables.<IResource>concat(ListExtensions.<IResource, List<IResource>>map(((List<IResource>)Conversions.doWrapArray(members)), _function)));
  }
  
  @Inject
  @Extension
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;
  
  @Inject
  private BXtendDSLGrammarAccess grammerAccess;
}
