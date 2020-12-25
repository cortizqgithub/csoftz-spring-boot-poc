/*----------------------------------------------------------------------------*/
/* Source File:   PROPERTYENVIRONMENTEXTRACTORSERVICE.JAVA                    */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.25/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples.service.extractor;

import java.io.IOException;
import java.util.List;

/**
 * Contract to extract properties from a file containing the 'environment' json property.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.25/2020
 * @since 15 (JDK), Dec.25/2020
 */
public interface PropertyEnvironmentExtractorService {
    /**
     * Inspects the given filename contents in JSON format to retrieve the environment node out of it. As shown in
     * the example below.
     * <br/><br/>
     * <pre>
     *     "environment": [
     *     {
     *       "name": "carlos",
     *       "value": "ortiz"
     *     },
     *     {
     *       "name": "next",
     *       "value": "one"
     *     }
     *   ]
     * </pre>
     * <br/><br/>
     * The result would be a list containing the following values.
     * <pre>
     *     carlos=ortiz
     *     next=one
     * </pre>
     *
     * @param fileName Points to a valid JSON file containing the node described above.
     * @return List of name=value.
     * @throws IOException
     */
    List<String> extractPropertiesFrom(String fileName) throws IOException;
}
