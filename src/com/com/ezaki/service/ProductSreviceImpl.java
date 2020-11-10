package com.ezaki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ezaki.model.Product;
import com.ezaki.repository.ProductRepository;

@Service
@Qualifier("com.ezaki")
public class ProductSreviceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {    	
		return productRepository.findById(id);

	}
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product update(Product newProduct, Long id)  {
		Optional<Product> oldProduct = findById(id);
		Product product = oldProduct.get();
		if(oldProduct.isPresent()){			
			product.setName(newProduct.getName());
			save(product);
			
		}
		return product;
	}
}
