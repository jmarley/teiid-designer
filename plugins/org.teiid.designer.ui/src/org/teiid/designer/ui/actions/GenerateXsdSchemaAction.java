/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.core.workspace.ModelResource;
import org.teiid.designer.core.workspace.ModelWorkspaceException;
import org.teiid.designer.metamodels.relational.Procedure;
import org.teiid.designer.metamodels.relational.Table;
import org.teiid.designer.ui.UiConstants;
import org.teiid.designer.ui.UiPlugin;
import org.teiid.designer.ui.common.eventsupport.SelectionUtilities;
import org.teiid.designer.ui.common.widget.ListMessageDialog;
import org.teiid.designer.ui.viewsupport.ModelUtilities;
import org.teiid.designer.ui.wizards.GenerateXsdWizard;


/**
 * This action is specifically NOT extending ActionDelegate due to the fact
 * that it must operate on BOTH ModelObjects AND Resources.
 * 
 * This Action is added to both the Edit Menu and Context menus to drive
 * generation of XSD Schemas for usage as output documents for WebService deployments. 
 * @since 8.0
 */
public class GenerateXsdSchemaAction extends ActionDelegate implements
	IWorkbenchWindowActionDelegate, IViewActionDelegate {
    
    private ISelection selection;

	
	///////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
    public GenerateXsdSchemaAction() {
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // METHODS
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
     */
    @Override
    public void selectionChanged(IAction action,
                                 ISelection theSelection) {
        this.selection = theSelection;
        action.setEnabled(isValidSelection());
    }

    @Override
    public void run(IAction action) {
        final GenerateXsdWizard wizard = new GenerateXsdWizard();
        wizard.init(UiPlugin.getDefault().getCurrentWorkbenchWindow().getWorkbench(), (IStructuredSelection)this.selection );
        final WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
        int rc = dialog.open();
        
        if(rc!=Window.CANCEL) {
            final MultiStatus result = wizard.getResult();
            final int severity = result.getSeverity();
            if(severity == IStatus.ERROR) {
                final String errTitle = UiConstants.Util.getString("GenerateXsdSchemaAction.errTitle"); //$NON-NLS-1$
                final String err = UiConstants.Util.getString("GenerateXsdSchemaAction.errFinish"); //$NON-NLS-1$
                ErrorDialog.openError(wizard.getShell(), errTitle, err, result);
            }else if(severity == IStatus.WARNING) {
                final String warnTitle = UiConstants.Util.getString("GenerateXsdSchemaAction.warnTitle"); //$NON-NLS-1$
                final String warn = UiConstants.Util.getString("GenerateXsdSchemaAction.warnFinish"); //$NON-NLS-1$
                ErrorDialog.openError(wizard.getShell(), warnTitle, warn, result);            
            }else {
                final String okTitle = UiConstants.Util.getString("GenerateXsdSchemaAction.successTitle"); //$NON-NLS-1$
                final String ok = UiConstants.Util.getString("GenerateXsdSchemaAction.successFinish"); //$NON-NLS-1$
    
                List msgs = new ArrayList(result.getChildren().length);
                for( int i=0; i<result.getChildren().length; i++) {
                    msgs.add(result.getChildren()[i].getMessage());
                }
                // Defect 20589 - Thread off this dialog, so it shows up AFTER auto-build and other jobs which are 
                // causing more Progress monitors to appear (lots of flashing).
                final List messgs = msgs;
                Display.getCurrent().asyncExec(new Runnable() {  
                    @Override
					public void run() {   
                            ListMessageDialog.openInformation(wizard.getShell(), okTitle, null, ok, messgs , null);
                    }
                });                          
            }
        }

    }
    
    /**
     * Valid selections include Relational Tables, Procedures or Relational Models.
     * The roots instance variable will populated with all Tables and Procedures contained
     * within the current selection. 
     * @return
     * @since 4.1
     */
    private boolean isValidSelection() {
        boolean isValid = true;
        if (SelectionUtilities.isEmptySelection(selection)) {
            isValid = false;
        }
        
        if ( isValid ) {
            final Collection objs = SelectionUtilities.getSelectedObjects(selection);
            final Iterator selections = objs.iterator();
            while (selections.hasNext() && isValid) {
                final Object next = selections.next();
                if (next instanceof Table) {
                    isValid = true;
                }else if(next instanceof Procedure) {
                    isValid = true;
                }else if (next instanceof IFile) {
                    final ModelResource modelResource = ModelerCore.getModelWorkspace().findModelResource((IFile) next);
                    if (modelResource != null) {
                        try {
                            // defect 19183 - do not load models on selection:
                            isValid = ModelUtilities.isRelationalModel(modelResource);
                        } catch (ModelWorkspaceException err) {
                            UiConstants.Util.log(err);
                            isValid = false;
                        }
                    } else {
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }
                
                // stop processing if no longer valid:
                if (!isValid) {
                    break;
                } // endif -- valid
            } // endwhile -- all selected
        } // endif -- is empty sel

        return isValid;
    }        

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
     */
    @Override
	public void init(IWorkbenchWindow window) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
     */
    @Override
	public void init(IViewPart view) {
    }
    
}
