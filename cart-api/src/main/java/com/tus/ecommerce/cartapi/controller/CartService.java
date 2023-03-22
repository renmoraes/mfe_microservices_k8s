package com.tus.ecommerce.cartapi.controller;

import com.tus.ecommerce.cartapi.dao.CartRepository;
import com.tus.ecommerce.cartapi.entity.Cart;
import com.tus.ecommerce.cartapi.entity.CartItems;
import com.tus.ecommerce.cartapi.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@GetMapping(value="/carts")
	public List<Cart> getCartItems() {
		return cartRepo.findAll();
	}
	
	@GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable(value = "cart_id") Integer cart_Id) throws ResourceNotFoundException {
        Optional<Cart> cart = cartRepo.findById(cart_Id);
        if(cart.isPresent())
            return ResponseEntity.ok().body(cart.get());
        else
            throw new ResourceNotFoundException("Cart not found :: " + cart_Id);
    }

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartRepo.save(cart);
    }
    
    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable(value = "cart_id") Integer cart_Id) {
    	Optional<Cart> existingCart = cartRepo.findById(cart_Id);
    	if (existingCart.isPresent()) {
    		Cart cart = existingCart.get();
    		cartRepo.delete(cart);
    	}
    }

    @GetMapping("/dummyCart")
    public Cart createDummy() {
        CartItems cartItems1 = new CartItems(1,2,5,10);
        CartItems cartItems2 = new CartItems(2,3,4,20);
        List<CartItems> cart_cartItems = new ArrayList<>();
        cart_cartItems.add(cartItems1);
        cart_cartItems.add(cartItems2);
        Cart cart = new Cart(1,5);
        cart.setCartItems(cart_cartItems);
        return cartRepo.save(cart);
    }
	
}

