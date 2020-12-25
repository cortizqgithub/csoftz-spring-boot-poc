/*----------------------------------------------------------------------------*/
/* Source File:   PROPERTYENVIRONMENTEXTRACTORSERVICEIMPL.JAVA                */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.25/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples.service.extractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

/**
 * Implements the contract to extract properties from a file containing the 'environment' json property.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.25/2020
 * @since 15 (JDK), Dec.25/2020
 */
public class PropertyEnvironmentExtractorServiceImpl implements PropertyEnvironmentExtractorService {
    private static final String JPATH_QUERY_ENVIRONMENT = "$.environment";

    @Override
    public List<String> extractPropertiesFrom(String fileName) throws IOException {

        String fileContent;
        try (var lines = Files.lines(Path.of(fileName))) {
            fileContent = lines.collect(Collectors.joining());
        }

        return JsonPath.parse(fileContent).<JSONArray>read(JPATH_QUERY_ENVIRONMENT)
            .stream()
            .map(extractProperties())
            .collect(Collectors.toList());
    }

    /**
     * Helps convert the node
     * <pre>
     *     {
     *      "name": "next",
     *      "value": "one"
     *     }
     * </pre>
     * Into a string with the value by the key name concatenated with '=' and the value of the key value.
     *
     * @return String with the values of the name, value keys.
     */
    @SuppressWarnings("unchecked")
    private Function<Object, String> extractProperties() {
        return e -> {
            var map = (Map<String, String>) e;
            return map.get("name") + "=" + map.get("value");
        };
    }
}
