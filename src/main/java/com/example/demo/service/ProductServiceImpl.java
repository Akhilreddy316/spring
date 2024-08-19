package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Product;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public Product saveProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		Product product=repo.findById(id).get();
		
		if(product!=null) {
			repo.delete(product);
			return "product deleted Successfully";
		}
		return "something went wrong on server";
	}

	@Override
	public Product editProduct(long id, Product product) {
		Product oldProduct=repo.findById(id).get();
		oldProduct.setName(product.getName());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setStatus(product.getStatus());
		return repo.save(oldProduct);
	}

}
