package com.tus.ecommerce.productsapi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//@Size(min=4)
	@Column(name = "name")
	private String name;
	
	@Column(name= "cat_id",nullable=false)
	private int catId;
	
	@Column(name= "image",nullable=false)
	private @NotNull String imageURL;
	
	@Column(name= "price",nullable=false)
	private @NotNull double price;
	
	@Column(name= "description",nullable=false)
	private @NotNull String description;
	
	public Product() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getImageURL() {
			return imageURL;
	}

	public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
	}

	public double getPrice() {
			return price;
	}

	public void setPrice(double price) {
			this.price = price;
	}

	public String getDescription() {
			return description;
	}

	public void setDescription(String description) {
			this.description = description;
	}

}
