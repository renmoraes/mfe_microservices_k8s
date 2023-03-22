package com.tus.ecommerce.cartapi.entity;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cart_id;
	
	@Column(name = "customer_id")
	private Integer customer_id;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_Cart_Items",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "cartItems_id"))
    private List<CartItems> cartItems;
	
	public Cart()
    {
    }
	public Cart(Integer cart_id, Integer customer_id) {
		this.cart_id = cart_id;
		this.customer_id = customer_id;
		
	}

	public Integer getCart_Id() {
		return cart_id;
	}

	public void setCart_Id(Integer cart_id) {
        this.cart_id = cart_id;
    }
	
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	
	public List<CartItems> getCartItems()
    {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems)
    {
        this.cartItems = cartItems;
    }
	
	
	
    
	

}

