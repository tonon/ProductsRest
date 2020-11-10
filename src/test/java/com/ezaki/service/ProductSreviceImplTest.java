package com.ezaki.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.ezaki.model.Product;
import com.ezaki.products.ProductsApp;
import com.ezaki.repository.ProductRepository;

@ContextConfiguration
@SpringBootTest (classes = ProductsApp.class)
class ProductSreviceImplTest {

	
	@MockBean
	ProductService productservice;
	
	@MockBean
	ProductRepository productRepository;
	
	static final int QTY = 20;


	
	@Before
	public void init() {
		productRepository.deleteAll();
		for (int i = 0; i < QTY; i++) {

			Long id = (long) (Math.random() * 5);
			Product product = new Product();
					product.setName("Name " + i);
					product.setDescription("Description " + i);
					product.setPrice((double)id);
					product.setId(id);
					product.setCategory("category "+  id);
					
					productservice.save(product);
			
			
		}
	}
	
	
	@Test
	public void productSaveTest() {
		for (int i = 0; i < QTY; i++) {

			Long id = (long) (Math.random() * 5);
			Product product = new Product();
					product.setName("Name " + i);
					product.setDescription("Description " + i);
					product.setPrice((double)id);
					product.setId(id);
					product.setCategory("category "+  id);
					
					productservice.save(product);
			
			
		}
		List<Product> list = productservice.findAll();
		assertEquals(QTY, list.size());
	}

}
