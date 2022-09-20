package com.validate.service;

import com.validate.model.User;

import java.util.List;

public interface IUserService {

    void save(User user);

    List<User> findAll();
}
