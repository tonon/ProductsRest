package com.zup.jaxrs.service;

import javax.ws.rs.core.Response;

import com.zup.jaxrs.model.Product;

public interface ProductService {

	public Response addProduct(Product e);
	
	public Response deleteProduct(int id);
	
	public Product getProduct(int id);
	
	public Product[] getAllProducts();

}
