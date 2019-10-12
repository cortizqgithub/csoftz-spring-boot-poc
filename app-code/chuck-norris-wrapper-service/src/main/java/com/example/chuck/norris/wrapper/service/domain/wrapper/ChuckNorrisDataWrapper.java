/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISDATAWRAPPER.JAVA                                 */
/* Description:   Domain model to map information from Chuck Norris Apiv      */
/*                endpoint.                                                   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.11/2019                                                 */
/* Last Modified: Oct.11/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.service.domain.wrapper;

import com.example.chuck.norris.wrapper.service.domain.ChuckNorrisData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model to wrap information around {@link ChuckNorrisData}.
 * Here we add a UUID id.
 *
 * @see <a href="https://www.baeldung.com/java-uuid">Guide to UUID in Java!</a>}
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2019
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
