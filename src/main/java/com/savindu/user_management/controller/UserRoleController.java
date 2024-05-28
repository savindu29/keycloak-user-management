package com.savindu.user_management.controller;



import com.savindu.user_management.response.Role;
import com.savindu.user_management.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@SecurityRequirement(name = "keycloak")
public class UserRoleController {

    private final RoleService roleService;


    @PutMapping("/assign-role/user/{userId}")
    public ResponseEntity<?>  assignRole(@PathVariable String userId, @RequestParam String roleName){

        roleService.assignRole(userId, roleName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(value = "/roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping(value = "/roles/{roleName}")
    public Role getRole(@PathVariable("roleName") String roleName) {
        return roleService.getRole(roleName);
    }

    @PostMapping(value = "/role")
    public Response createRole(Role role) {
       return roleService.createRole(role);
    }

    @PutMapping(value = "/role")
    public Response updateRole(Role role) {
       return roleService.updateRole(role);
    }

    @DeleteMapping(value = "/roles/{roleName}")
    public Response deleteUser(@PathVariable("roleName") String roleName) {
       return roleService.deleteUser(roleName);
    }

}
