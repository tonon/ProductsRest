package com.ezaki.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ezaki.repository.ProductRepository;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)

public class ProductsApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApp.class, args);
	
	}
	

}
