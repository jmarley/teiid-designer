/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.diagram.ui.pakkage.actions;

import org.teiid.designer.ui.actions.IModelerActionConstants;

/**
 * IPackageDiagramActionConstants
 *
 * @since 8.0
 */
public interface IPackageDiagramActionConstants {

    /** Keys for accessing transformation actions. */
    String ADD_TO_DIAGRAM = AddToDiagramAction.class.getName();
    String REMOVE_FROM_DIAGRAM = RemoveFromDiagramAction.class.getName();
    String CLEAR_DIAGRAM = ClearDiagramAction.class.getName();

    interface ContextMenu {

        /** The identifier for the diagram editor's context menu. */
        String DIAGRAM_EDITOR_PAGE = "diagramEditorPage" + IModelerActionConstants.ContextMenu.MENU_ID_SUFFIX; //$NON-NLS-1$

        /** Name of group for start of transformation menu items. */
        String DIAGRAM_START = "diagramStart"; //$NON-NLS-1$

        /** Name of group for end of transformation menu items. */
        String DIAGRAM_END = "diagramEnd"; //$NON-NLS-1$
    }

}
