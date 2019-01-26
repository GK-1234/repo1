package com.stylus.springwebclass.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stylus.springwebclass.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
