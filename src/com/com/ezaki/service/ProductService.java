package com.ezaki.service;

import java.util.List;
import java.util.Optional;

import com.ezaki.model.Product;

public interface ProductService {
	
	public List<Product> findAll();

    public Optional<Product> findById(Long id);
   
    public Product save(Product product) ;

    public Product update(Product newProduct, Long id);
    
    public void deleteById(Long id);

}
