package com.armadillo.api.billingservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.ProductType;


/**
 * Product type Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ProductTypeRepository extends CrudRepository<ProductType,String> {
	
	
	// find by id
	//<GET>http://localhost:8080/producttype/RM

	// find ALL
	//<GET>http://localhost:8080/producttype/list
    
    	
}
