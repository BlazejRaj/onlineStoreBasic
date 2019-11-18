package com.projekt.projektkoncowy.repository;

import com.projekt.projektkoncowy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByUserUsername (String username);
}
