package crudApp.service;

import crudApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User save(User user);

    Optional<User> findById(Long id);

    User findByLogin(String login);
}
