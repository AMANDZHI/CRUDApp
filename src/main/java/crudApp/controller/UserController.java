package crudApp.controller;

import crudApp.model.User;
import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home() {
        return "userPage";
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }

    @GetMapping("/findById")
    @ResponseBody
    public User findById(Long id) {
        return service.findById(id).get();
    }
}