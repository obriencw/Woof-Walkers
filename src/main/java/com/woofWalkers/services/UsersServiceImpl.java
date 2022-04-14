package com.woofWalkers.services;

import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {this.usersRepository = usersRepository; }

    @Override
    public List<User> getAllUsers() { return usersRepository.findAll();}

    @Override
    public void saveUser(User user)
    { usersRepository.save(user); }


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
