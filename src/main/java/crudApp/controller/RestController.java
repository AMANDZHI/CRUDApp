package crudApp.controller;

import crudApp.model.Role;
import crudApp.model.User;
import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@PreAuthorize("hasAuthority('ADMIN')")
public class RestController {

    @Autowired
    private UserService service;

    @GetMapping("/mainRest")
    public List<User> main() {
        return service.findAll();
    }

    @GetMapping("/findById")
    public User findById(@RequestParam Long value) {
        return service.findById(value).get();
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestParam String id, @RequestParam String email, @RequestParam String username, @RequestParam String password, @RequestParam String role) throws ServletException, IOException {
        User updatedUser = service.save(new User(Long.parseLong(id), email, username, password, true, Collections.singleton(Role.valueOf(role))));
        return updatedUser;
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestParam String email, @RequestParam String username, @RequestParam String password, @RequestParam String role) throws ServletException, IOException {
        User newUser = service.save(new User(email, username, password, true, Collections.singleton(Role.valueOf(role))));
        return newUser;
    }
}
