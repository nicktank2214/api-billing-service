package com.armadillo.api.billingservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.Product;


/**
 * Product Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ProductRepository extends CrudRepository<Product,String> {
	
	
	// find by id
	//<GET>http://localhost:8080/product/H_40

	// find ALL
	//<GET>http://localhost:8080/product/list
    
	
	//find by Product / Country - key1 
	Product findByProductAndCountry(String product, String country);
    	
}
