package com.woofWalkers.repository;


import com.woofWalkers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    User findUserById(Long Id);
}
