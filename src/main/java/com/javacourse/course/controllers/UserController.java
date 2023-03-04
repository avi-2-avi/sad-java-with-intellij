package com.javacourse.course.controllers;

import com.javacourse.course.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User newUser = new User();
        newUser.setId(1L);
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");

        User newUser2 = new User();
        newUser2.setId(2L);
        newUser2.setName("Avdksj");
        newUser2.setLast_name("dddon");
        newUser2.setEmail("avi@emdfkjail.com");
        newUser2.setTelephone("123456");

        User newUser3 = new User();
        newUser3.setId(3L);
        newUser3.setName("Avafkds");
        newUser3.setLast_name("Cofdsn");
        newUser3.setEmail("avi@effmail.com");
        newUser3.setTelephone("12dfs3456");

        users.add(newUser);
        users.add(newUser2);
        users.add(newUser3);

        return users;
    }

    @RequestMapping(value = "userasdfsa")
    public User updateUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "userasdl")
    public User deleteUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "userjfj")
    public User searchUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

}
