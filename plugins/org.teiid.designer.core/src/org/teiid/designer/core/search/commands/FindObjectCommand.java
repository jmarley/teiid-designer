/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.core.search.commands;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.teiid.designer.core.index.IndexSelector;
import org.teiid.designer.core.search.MetadataSearch;

/**
 * This interface is used to find typed objects based on datatype criteria.
 *
 * @since 8.0
 */
public interface FindObjectCommand extends SearchCommand {

    /**
     * Return a collection of record
     * objects that are found on this command execution. 
     * @return a collection of records
     */
    Collection getRecordInfo();
    
    /**
     * Set the IndexSelector that will be used to obtain models that will be searched.
     * @param selector the index selector that should be used, or null if the 
     * {@link org.teiid.designer.core.index.ModelWorkspaceIndexSelector} should be used
     */
    void setIndexSelector( IndexSelector selector );

    /**
     * Set the metamodel class to use in the search. 
     * @param metaClass
     * @since 4.1
     */
    public void setMetaClass(EClass metaClass);
    
    /**
     * Set the property matching criteria for the search.  The pattern may be null, zero-length
     * or {@link MetadataSearch#TEXT_PATTERN_ANY_STRING "*"} if the text is not to be used in the criteria.  If the text
     * is to be evaluated against the criteria, then the pattern should consist of combinations of literal
     * characters to be match, the {@link MetadataSearch#TEXT_PATTERN_ANY_STRING "*"} for matching any number of characters,
     * the {@link MetadataSearch#TEXT_PATTERN_ANY_CHAR "?"} for matching any single character, and
     * {@link MetadataSearch#TEXT_PATTERN_ESCAPE_CHAR "\"} for escaping the "*", "?" or "\" characters.
     * @param featureName the feature name for the search
     * @param textPattern the text matching pattern
     * @param containsPattern true if the specified pattern is to be matched, or false if matches are to be excluded
     * in the results 
     */
    public void setFeatureCriteria( String featureName, String textPattern, boolean containsPattern );

}
