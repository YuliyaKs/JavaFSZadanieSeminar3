package com.github.yuliyaks.controllers;

import com.github.yuliyaks.domain.User;
import com.github.yuliyaks.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    // Метод выводит список всех операций
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    // Метод сортирует пользователей по возрасту
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    // Метод отображает пользователей старше указанного возраста
    @GetMapping("/filter/{age}")//localhost:8080/tasks/filter/{age}
    public List<User> filterUsersByAge(@PathVariable("age") int age)
    {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    // Метод выводит средний возраст всех пользователей
    @GetMapping("/calc")//localhost:8080/tasks/calc
    public Double calculateAverageAge()
    {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }

}
