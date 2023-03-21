package com.tus.ecommerce.productsapi.dao;

import com.tus.ecommerce.productsapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
