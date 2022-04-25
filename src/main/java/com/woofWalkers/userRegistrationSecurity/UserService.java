package com.woofWalkers.userRegistrationSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
    List<User> getAllUsers();
}
