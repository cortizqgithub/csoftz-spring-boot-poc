/*----------------------------------------------------------------------------*/
/* Source File:   USER.JAVA                                                   */
/* Copyright (c), 2023 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.30/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.themusketeers.sbnative.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;

/**
 * Represents User information.
 *
 * @param id      Identifies the User.
 * @param name    Indicates the User's name (mandatory).
 * @param address Indicates the location of the User (mandatory).
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "address"
})
public record User(String id,
                   @NotEmpty(message = "Name User is mandatory") String name,
                   @NotEmpty(message = "Address is mandatory") String address) {
}
