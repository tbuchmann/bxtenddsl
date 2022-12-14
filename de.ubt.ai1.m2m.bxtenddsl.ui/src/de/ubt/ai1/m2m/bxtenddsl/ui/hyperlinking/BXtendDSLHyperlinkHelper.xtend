package de.ubt.ai1.m2m.bxtenddsl.ui.hyperlinking

import com.google.inject.Inject
import de.ubt.ai1.m2m.bxtenddsl.services.BXtendDSLGrammarAccess
import de.ubt.ai1.m2m.bxtenddsl.utils.MetamodelLoader
import java.io.IOException
import java.util.Collection
import java.util.Collections
import java.util.HashSet
import java.util.List
import org.eclipse.core.filesystem.EFS
import org.eclipse.core.filesystem.IFileStore
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Path
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.presentation.EcoreEditor
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.text.Region
import org.eclipse.jface.viewers.TreePath
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.widgets.Tree
import org.eclipse.swt.widgets.TreeItem
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.PartInitException
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper

/*******************************************************************************
 * @author    Jonas Fraas <jonas.fraas(at)uni-bayreuth.de>
 * @date      2019-06-14
 ******************************************************************************/
class BXtendDSLHyperlinkHelper extends HyperlinkHelper {
	override createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		val currentNode = NodeModelUtils.findLeafNodeAtOffset(resource.parseResult.rootNode, offset)
		val crossReferencedElement = resource.resolveCrossReferencedElementAt(offset)
		
		val linkRegion = new Region(currentNode.offset, currentNode.length)
		val ecoreTarget =
		if (currentNode.grammarElement == grammerAccess.metamodelsAccess.sourcemodelSTRINGTerminalRuleCall_1_0
				|| currentNode.grammarElement == grammerAccess.metamodelsAccess.targetmodelSTRINGTerminalRuleCall_4_0) {
			val uri = currentNode.text.substring(1, currentNode.text.length - 1)
			try {
				MetamodelLoader.load(uri, new ResourceSetImpl()).contents.get(0)
			} catch (IOException exc) {
				null
			}
			
		} else if (crossReferencedElement !== null && !crossReferencedElement.eIsProxy()
				&& (crossReferencedElement instanceof EPackage
					|| crossReferencedElement instanceof EClassifier
					|| crossReferencedElement instanceof EStructuralFeature
					|| crossReferencedElement instanceof EEnumLiteral
				)) {
			crossReferencedElement
		}
		
		if (ecoreTarget !== null) {
			return #[new BXtendDSLHyperlink(linkRegion, "Open element in Ecore Model Editor") [
				ecoreTarget.openEcoreEditorAndSelectItem()
			]]
			
		} else if (currentNode.grammarElement == grammerAccess.transformationRuleAccess.nameIDTerminalRuleCall_1_0) {
			val project = ResourcesPlugin.workspace.root.getProject(URI.decode(resource.URI.segment(1)))
			val rule = project.getFolder("src-gen").allMembers().findFirst[name == currentNode.text + ".xtend"]
			val ruleImpl = project.getFolder("src").allMembers().findFirst[name == currentNode.text + "Impl.xtend"]
			
			val openEditor = [IFileStore fileStore |
				if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
					val activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					val activePage = activeWindow?.getActivePage()
					if (activePage !== null) {
						try {
							IDE.openEditorOnFileStore(activePage, fileStore)
						} catch (PartInitException e) {
							e.printStackTrace()
						}
					}
				}
			]
			
			val links = newArrayList()
			if (ruleImpl !== null) {
				links += new BXtendDSLHyperlink(linkRegion, "Open rule implementation in Xtend Editor") [
					openEditor.apply(EFS.getLocalFileSystem().getStore(ruleImpl.rawLocation))
				]
			}
			if (rule !== null) {
				links += new BXtendDSLHyperlink(linkRegion, "Open generated rule code in Xtend Editor") [
					openEditor.apply(EFS.getLocalFileSystem().getStore(rule.rawLocation))
				]
			}
			return links
			
		} else {
			return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks)
		}
	}
	
	private def void openEcoreEditorAndSelectItem(EObject item) {
		if (item !== null && EcoreUtil2.getContainerOfType(item, EPackage) !== null) {
			val file = EcoreUtil2.getContainerOfType(item, EPackage).packageToFile()
			val editor = try {
				file?.openEcoreEditor()
			} catch (PartInitException e) {
				e.printStackTrace()
				return
			}
			val treePath = editor.getTreePathToObject(item)
			editor.expandTreePath(treePath)
		}
	}

	// works only for models from workspace, not for models from package registry
	// models from package registry are loaded as plug-in and not available as file
	// perhaps https://stackoverflow.com/questions/9215628/convert-file-located-in-osgi-bundle-to-ifile with different
	// editor or http://blog.vogella.com/2010/07/06/reading-resources-from-plugin/ and save the model in workspace
	// also foreignModel doesn't work as expected for some models from package registry, e.g. UML
	private def URI packageToFile(EPackage ePackage) {
		val GenModel genModel = MetamodelLoader.genModel(ePackage.nsURI)
		val relativeModelPath = genModel.foreignModel.get(0)

		val resSet = new ResourceSetImpl()
		val genModelUri = resSet.URIConverter.normalize(genModel.eResource.URI)
		
		val modelUri = genModelUri.toFileString.replaceFirst("\\\\(\\w)*\\.genmodel", "\\\\" + relativeModelPath)
		return URI.createFileURI(modelUri)
	}

	private def EcoreEditor openEcoreEditor(URI resource) throws PartInitException {
		val trimmedFileURI = resource.toFileString.replaceFirst("\\\\(\\w)*\\.ecore", "\\\\")
		val fileStoreContainer = EFS.getLocalFileSystem().getStore(new Path(trimmedFileURI))
		val fileStore = fileStoreContainer.getFileStore(new Path(resource.segmentsList.last))
		
		if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
			val activeWindows = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			val activePage = activeWindows?.getActivePage()
			if (activePage !== null) {
				return IDE.openEditorOnFileStore(activePage, fileStore) as EcoreEditor
			}
		}
	}
	
	private def getTreePathToObject(IEditorPart editor, EObject crossLinkedEObject) {
		if (editor instanceof EcoreEditor) {
			val path = editor.editingDomain.getTreePath(crossLinkedEObject)
			return new TreePath(path)
		}
	}

	private def expandTreePath(EcoreEditor ecoreEditor, TreePath treePath) {
		for (var i = 0; i < treePath.segmentCount; i++) {
			if (!(treePath.getSegment(i) instanceof ENamedElement)) {
				val treeViewer = ecoreEditor.viewer as TreeViewer
				treeViewer.setExpandedState(treeViewer.tree.items.get(0).data, true)
			} else {
				val element = treePath.getSegment(i) as ENamedElement
				val treeViewer = (ecoreEditor.viewer as TreeViewer)
				val treeItems = treeViewer.tree.allItems
				val item = element.findMatchingTreeItem(treeItems)

				ecoreEditor.selectionToViewer = Collections.singleton(item)
				if (i != treePath.segmentCount - 1)
					treeViewer.setExpandedState(item, true)
			}

		}
	}

	private def getAllItems(Tree tree) {
		val items = new HashSet

		for (item : tree.getItems) {
			items += item
			items += item.allItems
		}
		return items
	}

	private def Collection<TreeItem> getAllItems(TreeItem currentItem) {
		val children = currentItem.getItems
		val items = new HashSet

		for (var i = 0; i < children.length; i++) {
			items += children.get(i)
			items += children.get(i).allItems
		}
		return items
	}

	private def findMatchingTreeItem(ENamedElement namedElement, Collection<TreeItem> items) {
		items.map[data].filter(ENamedElement).findFirst[namedElement.name == it.name]
	}
	
	private def List<IResource> allMembers(IResource resource) {
		if (!(resource instanceof IContainer)) {
			return #[resource]
		}
		
		val members = try {
			(resource as IContainer).members
			
		} catch (CoreException e) {
			return #[]
		}
		
		return members.map[allMembers()].flatten().toList()
	}

	@Inject extension EObjectAtOffsetHelper eObjectAtOffsetHelper
	@Inject BXtendDSLGrammarAccess grammerAccess
}
