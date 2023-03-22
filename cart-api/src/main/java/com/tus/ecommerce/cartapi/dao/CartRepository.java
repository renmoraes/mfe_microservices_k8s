package com.tus.ecommerce.cartapi.dao;


import com.tus.ecommerce.cartapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	}

