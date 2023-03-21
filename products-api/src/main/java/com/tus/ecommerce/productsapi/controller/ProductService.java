package com.tus.ecommerce.productsapi.controller;



import com.tus.ecommerce.productsapi.dao.ProductRepository;
import com.tus.ecommerce.productsapi.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	@GetMapping(value="/products")
	List<Product> getProductForCategory() {
		return prodRepo.findAll();
	}
	
	@GetMapping("/product/{id}")
	Optional<Product> getProduct(@PathVariable("id") Long id) {
		return prodRepo.findById(id);
	}
	
	@PostMapping(value = "/product")
	ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		Product savedProduct = prodRepo.save(product);
		return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/product/{id}")
	ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		
		// First fetch an existing product and then delete it. 
		Optional<Product> optionalProduct = prodRepo.findById(id); 
		Product existingProduct=optionalProduct.get();
		// Return the deleted product 
		prodRepo.delete(existingProduct);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT) ;		
	}
	
	@PutMapping(value="/product/{id}")
	ResponseEntity updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		
		// First fetch an existing product and then modify it. 
		Optional<Product> optionalProduct = prodRepo.findById(id); 
		Product existingProduct=optionalProduct.get();
		// Now update it back 
		existingProduct.setCatId(product.getCatId());
		existingProduct.setName(product.getName());
		existingProduct.setImageURL(product.getImageURL());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		Product savedProduct = prodRepo.save(existingProduct) ;
		// Return the updated product  
		return new ResponseEntity<Product>(savedProduct, HttpStatus.OK) ;		
	}
	
	
}
