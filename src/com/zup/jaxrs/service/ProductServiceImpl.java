package com.zup.jaxrs.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zup.jaxrs.model.Product;
import com.zup.jaxrs.model.GenericResponse;

@Path("/product")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProductServiceImpl implements ProductService {

	private static Map<Integer,Product> product = new HashMap<Integer,Product>();
	
	@Override
	@POST
    @Path("/add")
	public Response addProduct(Product e) {
		GenericResponse response = new GenericResponse();
		if(product.get(e.getId()) != null){
			response.setStatus(false);
			response.setMessage("Product Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		product.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Product created successfully");
		return Response.ok(response).build();
	}

	@Override
	@DELETE
    @Path("/{id}/delete")
	public Response deleteProduct(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(product.get(id) == null){
			response.setStatus(false);
			response.setMessage("Product Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		product.remove(id);
		response.setStatus(true);
		response.setMessage("Product deleted successfully");
		return Response.ok(response).build();
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Product getProduct(@PathParam("id") int id) {
		return product.get(id);
	}
	
	@GET
	@Path("/{id}/getId")
	public Product getIdProduct(@PathParam("id") int id) {
		Product p = new Product();
		p.setCategory("Sport");
		p.setName("Garmin 010-01338-00 fenix 3 Multisport Training GPS Watch in Gray");
		p.setId(id);
		p.setPrice(385.00);
		p.setDescription("Fenix 3 is the rugged, capable and smart multisport training GPS watch.");
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Product[] getAllProducts() {
		Set<Integer> ids = product.keySet();
		Product[] p = new Product[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = product.get(id);
			i++;
		}
		return p;
	}

}
