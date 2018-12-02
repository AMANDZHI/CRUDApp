package crudApp.controller;

import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @Autowired
    private UserService service;

}