package com.stylus.springwebclass.bootstrap;

import java.math.BigDecimal;

import com.stylus.springwebclass.domain.Product;
import com.stylus.springwebclass.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product book1 = new Product();
        book1.setDescription("Spring Microservices in Action");
        book1.setPrice(new BigDecimal("18.95"));
        book1.setImageUrl("/product/IMG_3221.JPG");
        book1.setProductId("235268845711068308");
        productRepository.save(book1);

        log.info("Saved Book - id: " + book1.getId());

        Product book2 = new Product();
        book2.setDescription("Spring Framework Guru Mug");
        book2.setImageUrl("/product/IMG_3222.JPG");
        book2.setProductId("168639393495335947");
        book2.setPrice(new BigDecimal("11.95"));
        productRepository.save(book2);

        log.info("Saved Book - id:" + book2.getId());
    }
}
