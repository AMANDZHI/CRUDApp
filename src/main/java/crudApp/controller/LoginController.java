package crudApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/checkStrength")
    @ResponseBody
    public String checkStrength(@RequestParam String password) {
        if (password.length() < 4) {
            return "слабый";
        } else {
            return "сильный";
        }
    }
}
