/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.mapping.ui.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.teiid.designer.diagram.ui.DiagramUiPlugin;
import org.teiid.designer.mapping.factory.ModelMapperFactory;
import org.teiid.designer.ui.actions.IModelObjectActionContributor;
import org.teiid.designer.ui.common.eventsupport.SelectionUtilities;



/** 
 * @since 8.0
 */
public class MappingDiagramPermanentActionContributor  implements IModelObjectActionContributor {
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // FIELDS
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    private FindXsdComponentAction findXsdComponentAction;
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public MappingDiagramPermanentActionContributor() {
        initActions();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // METHODS
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    /* (non-Javadoc)
     * @See org.teiid.designer.ui.actions.IModelObjectActionContributor#contributeToContextMenu(org.eclipse.jface.action.IMenuManager, org.eclipse.jface.viewers.ISelection)
     */
    @Override
	public void contributeToContextMenu(IMenuManager theMenuMgr, ISelection theSelection) {
        
        // Need to check the selection first.   
    }
    
    /**
     *  
     * @see org.teiid.designer.ui.actions.IModelObjectActionContributor#getAdditionalModelingActions(org.eclipse.jface.viewers.ISelection)
     * @since 5.0
     */
    @Override
	public List<IAction> getAdditionalModelingActions(ISelection theSelection) {
        List addedActions = new ArrayList();
        
        // Need to check the selection first.
        
        if( SelectionUtilities.isSingleSelection(theSelection) ) {
            Object selectedObject = SelectionUtilities.getSelectedObject(theSelection);
            if( selectedObject instanceof EObject && isXmlComponent((EObject)selectedObject)) {
                addedActions.add(findXsdComponentAction);
            }
        }
        
        return addedActions;
    }

    /**
     * Construct and register actions.
     */
    private void initActions() {
        findXsdComponentAction = new FindXsdComponentAction();
        DiagramUiPlugin.registerDiagramActionForSelection(findXsdComponentAction);
    
    }
    
    private boolean isXmlComponent(EObject eObject) {
        if( ModelMapperFactory.isXmlTreeNode(eObject) && !ModelMapperFactory.isTreeRoot(eObject)) {
            return true;
        }
        return false;
    }
}


