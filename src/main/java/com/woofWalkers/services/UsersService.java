package com.woofWalkers.services;

import com.woofWalkers.userRegistrationSecurity.User;
import java.util.List;

public interface UsersService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User findByEmail(String email);

}