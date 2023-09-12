package com.acme.validate.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

/**
 * Represents Movie Record information.
 *
 * @param id    Identifies the Movie Record.
 * @param title Indicates the name of the Movie Record (mandatory)
 * @param year  Indicates the inception year of the Movie Record (mandatory).
 * @param genre Indicates the classification given (mandatory).
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "title", "year", "genre")
data class MovieRecord(
    @field:NotEmpty(message = "Movie Record Id is mandatory") val id: String?,
    @field:NotEmpty(message = "Movie Record Title is mandatory") val title: String?,
    @field:NotNull(message = "Movie Record Year is mandatory")
    @field:Min(value = 1900, message = "Movie Record Year must be after 1900")
    @field:Max(value = 9999, message = "Movie Record Year must be before 9999")
    val year: Int?,
    @field:NotEmpty(message = "Movie Record Genre is mandatory") val genre: String?
)
