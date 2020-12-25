/*----------------------------------------------------------------------------*/
/* Source File:   TOOLS.JAVA                                                  */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.25/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Internal helper methods for common tasks in unit tests.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.25/2020
 * @since 15 (JDK), Dec.25/2020
 */
public class TestTools {
    /**
     * Retrieve the absolute path where the /src/test/resources are located for reading files.
     *
     * @param name Indicates the file name to use, it can have a part of the path to locate the resource, e.g.,
     *             /extractor/props.json.
     * @return The full file path to the given filenam.
     */
    public static String retrieveSrcTestResourcesDirectoryWith(String name) {
        // https://www.baeldung.com/junit-src-test-resources-directory-path
        Path resourceDirectory = Paths.get("src", "test", "resources");
        return resourceDirectory.toFile().getAbsolutePath() + name;
    }
}
