package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<?>saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(service.saveProduct(product),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<?>getAllProducts(){
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getProductsById(@PathVariable long id){
		return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteProduct(@PathVariable long id){
		
		return new ResponseEntity<>(service.deleteProduct(id),HttpStatus.OK);
		
	}
	
	@PostMapping("/editproduct/{id}")
	public ResponseEntity<?>editProduct(@PathVariable long id,@RequestBody Product product){
		return new ResponseEntity<>(service.saveProduct(product),HttpStatus.CREATED);
	}
	
	
	
	
}
