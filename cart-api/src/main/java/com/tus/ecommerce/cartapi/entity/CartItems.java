package com.tus.ecommerce.cartapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_Items")
public class CartItems {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItems_id")
	private Integer cartItems_id;
	
	@Column(name = "product_id")
	private Integer product_id;
	
	@Column(name = "quantity")
    private Integer quantity;
    
    @Column(name = "price")
    private Integer price;
	
    public CartItems()
    {
    }
    
	public CartItems(Integer cartItems_id, Integer product_id, Integer quantity, Integer price) {
		this.cartItems_id = cartItems_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getCartItems_Id() {
		return cartItems_id;
	}
	public void setCartItems_Id(Integer cartItems_id) {
        this.cartItems_id = cartItems_id;
    }
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
    
}
