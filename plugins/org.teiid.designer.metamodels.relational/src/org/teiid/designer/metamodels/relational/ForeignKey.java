/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.relational;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.teiid.designer.metamodels.relational.ForeignKey#getForeignKeyMultiplicity <em>Foreign Key Multiplicity</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.ForeignKey#getPrimaryKeyMultiplicity <em>Primary Key Multiplicity</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.ForeignKey#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.ForeignKey#getUniqueKey <em>Unique Key</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.ForeignKey#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey()
 * @model
 * @generated
 *
 * @since 8.0
 */
public interface ForeignKey extends Relationship{
    /**
     * Returns the value of the '<em><b>Foreign Key Multiplicity</b></em>' attribute.
     * The default value is <code>"ZERO_TO_MANY"</code>.
     * The literals are from the enumeration {@link org.teiid.designer.metamodels.relational.MultiplicityKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Key Multiplicity</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreign Key Multiplicity</em>' attribute.
     * @see org.teiid.designer.metamodels.relational.MultiplicityKind
     * @see #setForeignKeyMultiplicity(MultiplicityKind)
     * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey_ForeignKeyMultiplicity()
     * @model default="ZERO_TO_MANY"
     * @generated
     */
    MultiplicityKind getForeignKeyMultiplicity();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getForeignKeyMultiplicity <em>Foreign Key Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreign Key Multiplicity</em>' attribute.
     * @see org.teiid.designer.metamodels.relational.MultiplicityKind
     * @see #getForeignKeyMultiplicity()
     * @generated
     */
    void setForeignKeyMultiplicity(MultiplicityKind value);

    /**
     * Returns the value of the '<em><b>Primary Key Multiplicity</b></em>' attribute.
     * The default value is <code>"ONE"</code>.
     * The literals are from the enumeration {@link org.teiid.designer.metamodels.relational.MultiplicityKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Key Multiplicity</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Key Multiplicity</em>' attribute.
     * @see org.teiid.designer.metamodels.relational.MultiplicityKind
     * @see #setPrimaryKeyMultiplicity(MultiplicityKind)
     * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey_PrimaryKeyMultiplicity()
     * @model default="ONE"
     * @generated
     */
    MultiplicityKind getPrimaryKeyMultiplicity();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getPrimaryKeyMultiplicity <em>Primary Key Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Key Multiplicity</em>' attribute.
     * @see org.teiid.designer.metamodels.relational.MultiplicityKind
     * @see #getPrimaryKeyMultiplicity()
     * @generated
     */
    void setPrimaryKeyMultiplicity(MultiplicityKind value);

    /**
     * Returns the value of the '<em><b>Columns</b></em>' reference list.
     * The list contents are of type {@link org.teiid.designer.metamodels.relational.Column}.
     * It is bidirectional and its opposite is '{@link org.teiid.designer.metamodels.relational.Column#getForeignKeys <em>Foreign Keys</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' reference list.
     * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey_Columns()
     * @see org.teiid.designer.metamodels.relational.Column#getForeignKeys
     * @model type="org.teiid.designer.metamodels.relational.Column" opposite="foreignKeys" required="true"
     * @generated
     */
    EList getColumns();

    /**
     * Returns the value of the '<em><b>Unique Key</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.teiid.designer.metamodels.relational.UniqueKey#getForeignKeys <em>Foreign Keys</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unique Key</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unique Key</em>' reference.
     * @see #isSetUniqueKey()
     * @see #unsetUniqueKey()
     * @see #setUniqueKey(UniqueKey)
     * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey_UniqueKey()
     * @see org.teiid.designer.metamodels.relational.UniqueKey#getForeignKeys
     * @model opposite="foreignKeys" unsettable="true" required="true"
     * @generated
     */
    UniqueKey getUniqueKey();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getUniqueKey <em>Unique Key</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Unique Key</em>' reference.
     * @see #isSetUniqueKey()
     * @see #unsetUniqueKey()
     * @see #getUniqueKey()
     * @generated
     */
    void setUniqueKey(UniqueKey value);

    /**
     * Unsets the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getUniqueKey <em>Unique Key</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetUniqueKey()
     * @see #getUniqueKey()
     * @see #setUniqueKey(UniqueKey)
     * @generated
     */
    void unsetUniqueKey();

    /**
     * Returns whether the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getUniqueKey <em>Unique Key</em>}' reference is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Unique Key</em>' reference is set.
     * @see #unsetUniqueKey()
     * @see #getUniqueKey()
     * @see #setUniqueKey(UniqueKey)
     * @generated
     */
    boolean isSetUniqueKey();

    /**
     * Returns the value of the '<em><b>Table</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.teiid.designer.metamodels.relational.BaseTable#getForeignKeys <em>Foreign Keys</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table</em>' container reference.
     * @see #setTable(BaseTable)
     * @see org.teiid.designer.metamodels.relational.RelationalPackage#getForeignKey_Table()
     * @see org.teiid.designer.metamodels.relational.BaseTable#getForeignKeys
     * @model opposite="foreignKeys"
     * @generated
     */
    BaseTable getTable();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.ForeignKey#getTable <em>Table</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table</em>' container reference.
     * @see #getTable()
     * @generated
     */
    void setTable(BaseTable value);

} // ForeignKey
