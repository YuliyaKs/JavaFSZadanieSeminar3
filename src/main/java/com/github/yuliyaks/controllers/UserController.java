package com.github.yuliyaks.controllers;

import com.github.yuliyaks.domain.User;
import com.github.yuliyaks.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {

    @Autowired
    private RegistrationService service;

    // Метод выводит список всех пользователей
    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    // Метод создает нового пользователя и добавляет его в репозиторий
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

}
