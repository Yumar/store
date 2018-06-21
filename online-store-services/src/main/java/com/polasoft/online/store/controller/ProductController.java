/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polasoft.online.store.controller;

import com.polasoft.online.store.model.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yumar
 */

@RestController
public class ProductController {
    
    @RequestMapping("/products")
    public List<Product> getProducts(){
        return null;
    }
    
}
