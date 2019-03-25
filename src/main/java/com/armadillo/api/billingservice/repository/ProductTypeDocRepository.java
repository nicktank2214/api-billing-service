package com.armadillo.api.billingservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.ProductTypeDoc;


/**
 * Product Doc Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ProductTypeDocRepository extends CrudRepository<ProductTypeDoc,Integer> {
	
	
	// find by id
	//<GET>http://localhost:8080/productdoc/1

	// find ALL
	//<GET>http://localhost:8080/productdoc/list


	//find by country / product - key1 
	ProductTypeDoc findByLanguageAndProductType(String country, String productType);
	
	//find by country - key1 
	List<ProductTypeDoc> findByLanguage(String country);

	//find by product - key2
	List<ProductTypeDoc> findByProductType(String productType);
	
    	
}
