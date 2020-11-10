package com.ezaki.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezaki.model.Product;
import com.ezaki.repository.ProductRepository;
import com.ezaki.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    


    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public List<Product> Get() {
        return productService.findAll();
    }

    @RequestMapping(value = "/Product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Product> Product = productService.findById(id);
        if(Product.isPresent())
            return new ResponseEntity<Product>(Product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/Product", method =  RequestMethod.POST)
    public Product Post(@Valid @RequestBody Product Product)
    {
        return productService.save(Product);
    }

    @RequestMapping(value = "/Product/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Product> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Product newProduct)
    {
        Optional<Product> oldProduct = productService.findById(id);
        if(oldProduct.isPresent()){
            Product Product = oldProduct.get();
            Product.setName(newProduct.getName());
            productService.save(Product);
            return new ResponseEntity<Product>(Product, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/Product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
        	productService.deleteById(product.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
