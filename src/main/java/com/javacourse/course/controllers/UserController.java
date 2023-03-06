package com.javacourse.course.controllers;

import com.javacourse.course.dao.UserDao;
import com.javacourse.course.models.User;
import com.javacourse.course.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validateToken(String token) {
        // TODO: Improve this part using: Spring Security and Error Control management (401 = authorization)

        String userId = jwtUtil.getKey(token);
        return userId != null;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setName("Avi");
        newUser.setLast_name("Con");
        newUser.setEmail("avi@email.com");
        newUser.setTelephone("123456");
        return newUser;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value="Authorization") String token) {
        if (!validateToken(token)) { return null; };

        return userDao.get();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
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

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!validateToken(token)) { return null; };
        userDao.delete(id);
        return null;
    }
}
