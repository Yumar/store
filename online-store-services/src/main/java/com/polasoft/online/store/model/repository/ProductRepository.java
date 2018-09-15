/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polasoft.online.store.model.repository;

import com.polasoft.online.store.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author yumar
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
 
}
