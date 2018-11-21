package crudApp;

import crudApp.model.Role;
import crudApp.model.User;
import crudApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/greeting")
    public String greeting(HttpServletRequest request, Model model) {
        return "greeting";
    }

    @RequestMapping("/")
    public String main(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "newUser";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestParam String email, @RequestParam String login, @RequestParam String password, @RequestParam String role, Model model) {
        repository.save(new User(email, login, password, Role.valueOf(role)));
        return "greeting";
    }
}