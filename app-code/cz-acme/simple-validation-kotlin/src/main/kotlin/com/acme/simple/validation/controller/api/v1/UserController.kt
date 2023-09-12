package com.acme.simple.validation.controller.api.v1

import com.acme.simple.validation.domain.User
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController {
    @PostMapping
    fun insertUser(@RequestBody @Valid user:  User): User {
        return User(user.id, user.name + " NEWST", user.address + " NEWST")
    }
}
