package com.acme.simple.validation.controller.api.v1;

import com.themusketeers.sbnative.domain.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User API Controller.
 * <p><b>Path:</b>{@code api/v1/users}</p>
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@RestController
@RequestMapping("api/v1/users")
public record UserController() {

    @PostMapping
    public User insertUser(@Valid @RequestBody User user) {
        return new User(user.id(), user.name() + " NEWST", user.address() + " NEWST");
    }


}
