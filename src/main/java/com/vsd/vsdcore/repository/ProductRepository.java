package com.vsd.vsdcore.repository;

import com.vsd.vsdcore.model.Product;
import com.vsd.vsdcore.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByName(String name);
}
