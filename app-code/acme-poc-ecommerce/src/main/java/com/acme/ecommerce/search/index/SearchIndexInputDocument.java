/*----------------------------------------------------------------------------*/
/* Source File:   SEARCHINDEXINPUTDOCUMENT.JAVA                               */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.search.index;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchIndexInputDocument {

    // fieldName -> fieldValue
    private Map<String, Object> fields;

    public SearchIndexInputDocument() {
        fields = new HashMap<>();
    }

    public void addField(String fieldName, Object fieldValue) {
        fields.put(fieldName, fieldValue);
    }

    public Map<String, Object> getFields() {
        return fields.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }
}
