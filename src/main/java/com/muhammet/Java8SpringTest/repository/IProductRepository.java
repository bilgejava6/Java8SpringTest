package com.muhammet.Java8SpringTest.repository;

import com.muhammet.Java8SpringTest.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByUsername(String username);
}
