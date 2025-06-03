package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping()
	public List<Product> getAllProducts(){
		return service.getAllProducts();
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getProductById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product created=service.craeteProduct(product);
		return ResponseEntity.status(201).body(created);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		 Product updatedProduct =service.updateProduct(id, productDetails);
		 return ResponseEntity.ok(updatedProduct);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		service.deleteProductById(id);
		return ResponseEntity.ok("Book was Deleted By Id");
	}
}
