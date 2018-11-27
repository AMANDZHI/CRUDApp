package crudApp.controller;

import crudApp.model.Role;
import crudApp.model.User;
import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

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
        Iterable<User> users = service.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("/getUsers")
    public String getUsers(Model model) {
        Iterable<User> users = service.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("/addNewUser")
    public void addNewUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String email, @RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) throws ServletException, IOException {
        service.save(new User(email, username, password, true, Collections.singleton(Role.valueOf(role))));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getUsers");
        requestDispatcher.forward(request, response);
    }

    @PostMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String id, @RequestParam String email, @RequestParam String login, @RequestParam String password, @RequestParam String role, Model model) throws ServletException, IOException {
        service.save(new User(Long.parseLong(id), email, login, password, true, Collections.singleton(Role.valueOf(role))));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getUsers");
        requestDispatcher.forward(request, response);
    }
}
