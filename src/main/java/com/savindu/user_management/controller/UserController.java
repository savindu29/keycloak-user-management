package com.savindu.user_management.controller;

import com.savindu.user_management.response.UserRegistrationRecord;
import com.savindu.user_management.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@SecurityRequirement(name = "keycloak")
public class UserController {
    private final UserService userService;
    @PostMapping("/create-user")
    public UserRegistrationRecord createUser(@RequestBody UserRegistrationRecord userRegistrationRecord) {

        return userService.createUser(userRegistrationRecord);
    }

    @GetMapping("/get-user")
    public UserRepresentation getUser(Principal principal) {

        return userService.getUserById(principal.getName());
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }


    @PutMapping("/{userId}/send-verify-email")
    public void sendVerificationEmail(@PathVariable String userId) {
        userService.emailVerification(userId);
    }
    @PutMapping("/update-password")
    public void updatePassword(Principal principal) {
        userService.updatePassword(principal.getName());
    }
}

