package ru.levelp;

import ru.levelp.dao.UserDAO;

public class AuthController {
    private UserDAO userService;

    public AuthController(UserDAO userService) {
        this.userService = userService;
    }

    //...
}