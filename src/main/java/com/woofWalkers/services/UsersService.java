package com.woofWalkers.services;

import com.woofWalkers.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UsersService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}