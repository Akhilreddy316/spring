package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public List<Product>getAllProducts();
	public Product getProductById(long id);
	public String deleteProduct(long id);
	public Product editProduct(long id,Product product);

}
