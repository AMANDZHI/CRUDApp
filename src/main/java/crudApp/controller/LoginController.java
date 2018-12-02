package crudApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getStart(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String goLogin() {
        return "userPage";
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }

    @GetMapping("/")
    public String home() {
        return "userPage";
    }
}
