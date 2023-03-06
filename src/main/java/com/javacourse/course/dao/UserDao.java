package com.javacourse.course.dao;

import com.javacourse.course.models.User;

import java.util.List;

public interface UserDao {
    List<User> get();

    void delete(Long id);

    void register(User user);

    User obtainUserByCredentials(User user);
}
