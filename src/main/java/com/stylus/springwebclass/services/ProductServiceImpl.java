package com.stylus.springwebclass.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylus.springwebclass.domain.Product;
import com.stylus.springwebclass.repositories.ProductRepository;
@Service
public class ProductServiceImpl //implements ProductService 
{

	@Autowired
	private ProductRepository productRepository;

	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Integer id) {		
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	


}
