package crudApp;

import crudApp.model.Role;
import crudApp.model.User;
import crudApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/newUser")
    public String newUser(Model model) {
        return "newUser";
    }

    @GetMapping("/")
    public String main(Model model) {
        Iterable<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/getUsers")
    public String getUsers(Model model) {
        Iterable<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/addNewUser")
    public void addNewUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String email, @RequestParam String login, @RequestParam String password, @RequestParam String role, Model model) throws ServletException, IOException {
        repository.save(new User(email, login, password, Role.valueOf(role)));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getUsers");
        requestDispatcher.forward(request, response);
    }

    @PostMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String id, @RequestParam String email, @RequestParam String login, @RequestParam String password, @RequestParam String role, Model model) throws ServletException, IOException {
        repository.save(new User(Long.parseLong(id), email, login, password, Role.valueOf(role)));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getUsers");
        requestDispatcher.forward(request, response);
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }

    @GetMapping("/findById")
    @ResponseBody
    public User findById(Long id) {
        return repository.findById(id).get();
    }

}