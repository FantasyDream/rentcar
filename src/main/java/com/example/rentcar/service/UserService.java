package com.example.rentcar.service;

import com.example.rentcar.model.User;

public interface UserService {
    boolean exits(String username);

    User loginCheck(User user);

    boolean register(User user);
}
