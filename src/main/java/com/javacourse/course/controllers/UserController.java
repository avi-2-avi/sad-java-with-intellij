package com.javacourse.course.controllers;

import com.javacourse.course.dao.UserDao;
import com.javacourse.course.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/user/{id}")
    public User getUser(@PathVariable Long id) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "api/users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/userasdfsa")
    public User updateUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "api/userasdl")
    public User deleteUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "api/userjfj")
    public User searchUser() {
        User newUser = new User();
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

}
