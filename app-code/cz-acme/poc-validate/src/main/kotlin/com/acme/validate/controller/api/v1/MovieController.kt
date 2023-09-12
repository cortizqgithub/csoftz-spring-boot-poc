package com.acme.validate.controller.api.v1

import com.acme.validate.domain.MovieRecord
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/movie/records")
class MovieController {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun insert(@Valid @RequestBody movieRecord:  MovieRecord): MovieRecord {
        println(movieRecord)

        return movieRecord
    }
}