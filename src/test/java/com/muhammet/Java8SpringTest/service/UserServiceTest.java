package com.muhammet.Java8SpringTest.service;

import com.muhammet.Java8SpringTest.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * Integration Test
 * Gerçek ortamda uygulamayı spring boot yugulaması olarak nasıl test edebileceğimizi
 * deniyoruz.
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void saveTestSuccess(){
        User user = new User();
        System.out.println("ıd....: "+ user.getId());
        user =  userService.save("muhammet@gmail.com","1234","Muhammet");
        Assertions.assertNotNull(user.getId());
    }

    @Test
    void saveTestFail(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.save(null,"1234","Muhammet");
        });
    }

    @Test
    void findById() {
        userService.save("sadd@dsad.com","2233","Muhammet");
        userService.save("sadd@dsad.com","2233","Muhammet1");
        userService.save("sadd@dsad.com","2233","Muhammet2");
        userService.save("sadd@dsad.com","2233","Muhammet3");
        userService.save("sadd@dsad.com","2233","Muhammet4");
        Optional<User> user = userService.findById(3L);
        Assertions.assertTrue(user.isPresent());
    }
}
