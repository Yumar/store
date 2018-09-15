/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polasoft.online.store.controller;

import com.polasoft.online.store.model.entity.Product;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.polasoft.online.store.model.repository.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author yumar
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository repo;

    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) repo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        Optional<Product> product = repo.findById(id);

        if (!product.isPresent()) {
            //throw new NotFoundException("id-" + id);
        }

        return product.get();
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product savedProduct = repo.save(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id){
        repo.deleteById(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable long id){
        Optional<Product> productOptional = repo.findById(id);
        
        if(!productOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        product.setId(id);
        repo.save(product);
        
        return ResponseEntity.noContent().build();
    }
}
