package com.muhammet.Java8SpringTest.service;

import com.muhammet.Java8SpringTest.repository.IProductRepository;
import com.muhammet.Java8SpringTest.repository.IUserRepository;
import com.muhammet.Java8SpringTest.repository.entity.Product;
import com.muhammet.Java8SpringTest.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository repository;
    private final UserService userService;

    public Product save(String name, Double price, Long userId){
        Optional<User> user = userService.findById(userId);
        if(user.isEmpty()) throw new RuntimeException("User not found");
        return repository.save(
                Product.builder()
                        .name(name)
                        .price(price)
                        .username(user.get().getName())
                        .build()
        );
    }

    public List<Product> findAllByUserId(Long userId){
        if(userId==null)
            throw new IllegalArgumentException("userId cannot be null");
        Optional<User> user = userService.findById(userId);
        if(user.isEmpty()) throw new RuntimeException("User not found");
        return repository.findAllByUsername(user.get().getName());
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public boolean isProductExistByUsername(String username){
        boolean isExist = false;
        List<Product> products = repository.findAllByUsername(username);
        if(!products.isEmpty()) isExist = true;
        return isExist;
    }
}
