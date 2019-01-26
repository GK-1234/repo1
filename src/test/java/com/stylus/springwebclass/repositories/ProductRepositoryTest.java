package com.stylus.springwebclass.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stylus.springwebclass.configuration.RepositoryConfiguration;
import com.stylus.springwebclass.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

	   @Autowired
	   private ProductRepository productRepository;

	   
	    @Test
	    public void testSaveProduct(){
	        //setup product
	        Product product = new Product();
	        product.setDescription("Spring Microservices in Action");
	        product.setPrice(new BigDecimal("18.95"));
	        product.setProductId("1234");

	        //save product, verify has ID value after save
	        assertNull(product.getId()); //null before save
	        productRepository.save(product);
	        assertNotNull(product.getId()); //not null after save
	        //fetch from DB
	        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);

	        //should not be null
	        assertNotNull(fetchedProduct);

	        //should equal
	        assertEquals(product.getId(), fetchedProduct.getId());
	        assertEquals(product.getDescription(), fetchedProduct.getDescription());

	        //update description and save
	        fetchedProduct.setDescription("New Description");
	        productRepository.save(fetchedProduct);

	        //get from DB, should be updated
	        Product fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
	        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

	        //verify count of products in DB
	        long productCount = productRepository.count();
	        assertEquals(productCount, 1);

	        //get all products, list should only have one
	        Iterable<Product> products = productRepository.findAll();

	        int count = 0;

	        for(Product p : products){
	            count++;
	        }

	        assertEquals(count, 1);
	    }
}
