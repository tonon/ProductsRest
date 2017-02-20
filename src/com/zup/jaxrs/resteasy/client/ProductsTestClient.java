package com.zup.jaxrs.resteasy.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.zup.jaxrs.model.Product;
import com.zup.jaxrs.model.GenericResponse;

public class ProductsTestClient {

	public static void main(String[] args) {

		ResteasyClient client = new ResteasyClientBuilder().build();
		
		//GET example
		ResteasyWebTarget getId = client.target("http://localhost:8080/Products/product/99/getId");
		
		Response getIdResponse = getId.request().get();
		
		String value = getIdResponse.readEntity(String.class);
        System.out.println(value);
        getIdResponse.close();  
        
        //POST example
		ResteasyWebTarget add = client.target("http://localhost:8080/Products/product/add");
		Product p = new Product();
		p.setCategory("Sport");
		p.setName("Garmin 010-01338-00 fenix 3 Multisport Training GPS Watch in Gray");
		p.setId(01000);
		p.setPrice(385.00);
		p.setDescription("Fenix 3 is the rugged, capable and smart multisport training GPS watch.");
		Response addResponse = add.request().post(Entity.entity(p, MediaType.APPLICATION_XML));
		System.out.println(addResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+addResponse.getStatus());
		addResponse.close();
		
		addResponse = add.request().post(Entity.entity(p, MediaType.APPLICATION_XML));
		System.out.println(addResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+addResponse.getStatus());
		addResponse.close();
		
		//DELETE example
		ResteasyWebTarget delete = client.target("http://localhost:8080/Products/product/50/delete");
		Response deleteResponse = delete.request().delete();
		System.out.println(deleteResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
		deleteResponse.close();
		
		deleteResponse = delete.request().delete();
		System.out.println(deleteResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
		deleteResponse.close();
	}

}
