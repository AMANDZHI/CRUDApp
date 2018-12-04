package crudApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }

}