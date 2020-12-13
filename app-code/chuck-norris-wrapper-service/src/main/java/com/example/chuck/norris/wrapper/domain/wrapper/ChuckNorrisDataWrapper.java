/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISDATAWRAPPER.JAVA                                 */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.domain.wrapper;

import com.example.chuck.norris.wrapper.domain.ChuckNorrisData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model to wrap information around {@link ChuckNorrisData}.
 * Here we add a UUID id.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @see <a href="https://www.baeldung.com/java-uuid">Guide to UUID in Java!</a>}
 * @since 11 (JDK), Oct.11/2019
 */

@Data
@Builder
public class ChuckNorrisDataWrapper {
    @JsonProperty("wrap_id")
    private String wrapId;

    @JsonProperty("chuck_norris_data")
    private ChuckNorrisData chuckNorrisData;
}
