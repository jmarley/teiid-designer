/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.ui.wizards;

import org.teiid.designer.core.association.AssociationDescriptor;

/**
 * INewAssociationWizard
 */
public interface INewAssociationWizard extends INewObjectWizard {

    void setAssociationDescriptor(AssociationDescriptor descriptor);
    
}