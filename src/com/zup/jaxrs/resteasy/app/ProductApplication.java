package com.zup.jaxrs.resteasy.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.zup.jaxrs.service.ProductServiceImpl;

public class ProductApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public ProductApplication() {
		singletons.add(new ProductServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
