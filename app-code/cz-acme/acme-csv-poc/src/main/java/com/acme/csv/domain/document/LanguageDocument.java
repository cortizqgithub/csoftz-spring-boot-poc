/*----------------------------------------------------------------------------*/
/* Source File:   LANGUAGEDOCUMENT.JAVA                                       */
/* Copyright (c), 2023 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Sep.12/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.csv.domain.document;

import java.util.Map;

/**
 * Information to use when a CSV file is mapped.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public record LanguageDocument(Map<String, String> values, String languageCode) {
}
