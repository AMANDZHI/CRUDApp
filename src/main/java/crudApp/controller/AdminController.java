package crudApp.controller;

import crudApp.model.User;
import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserService service;

    @GetMapping("/newUser")
    public String newUser() {
        return "newUser";
    }


    @GetMapping("/main")
    public String main(Model model) {
        return "main";
    }

    @PostMapping("/getUsers")
    public String getUsers(Model model) {
        Iterable<User> users = service.findAll();
        model.addAttribute("users", users);
        return "main";
    }
}
