/*----------------------------------------------------------------------------*/
/* Source File:   CSVPROCESSORSERVICE.JAVA                                    */
/* Copyright (c), 2023 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Sep.12/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.csv.service.intr;

import com.acme.csv.domain.document.LanguageDocument;

/**
 * Defines the contract for processing language topics.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public interface LanguageProcessorService {
    /**
     * Executes the processing for the Language requirements.
     */
    void process();
}
