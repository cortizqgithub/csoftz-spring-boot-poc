/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISDATA.JAVA                                        */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Domain model to map information from Chuck Norris Api endpoint.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Oct.11/2019
 */
@Data
public class ChuckNorrisData {
    @JsonProperty("categories")
    private Object[] categories;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("icon_url")
    private String iconURL;

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("url")
    private String url;

    @JsonProperty("value")
    private String value;
}
