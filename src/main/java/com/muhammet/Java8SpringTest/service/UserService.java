package com.muhammet.Java8SpringTest.service;

import com.muhammet.Java8SpringTest.repository.IUserRepository;
import com.muhammet.Java8SpringTest.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;

    public User save(String email, String password,String name){
        if(email == null || password == null)
            throw new IllegalArgumentException("email or password cannot be null");
        return repository.save(
                User.builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .build()
        );
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }
}
