package com.project.shopapp.repositories;

import com.project.shopapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

import java.awt.print.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existByName(String name); //xem ten san pham co ton tai khong

    Page<Product> findAll(Pageable pageable);

}
