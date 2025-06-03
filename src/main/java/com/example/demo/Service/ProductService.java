package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
	}
	
	public Product craeteProduct(Product product) {
		return repository.save(product);
	}
	
	public Product updateProduct(Long id, Product productDetails) {
		Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found/ Not Updated"));
		
		product.setPid(productDetails.getPid());
		product.setPname(productDetails.getPname());
		product.setPprice(productDetails.getPprice());
		return repository.save(product);
	}
	
	public void deleteProductById(Long id) {
		repository.deleteById(id);
	}
}
