package com.woofWalkers.services;

import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    @Override
    public List<User> getAllUsers() { return usersRepository.findAll();}

    @Override
    public void saveUser(User user)
    { usersRepository.save(user); }

    @Override
    public User findByEmail(String email){
        return usersRepository.findByEmail(email);
    }


    @Override
    public User getUserById(long id) {
        Optional<User> optional = usersRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id :: " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.usersRepository.deleteById(id);
    }
}
