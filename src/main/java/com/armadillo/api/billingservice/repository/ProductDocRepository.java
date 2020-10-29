package com.armadillo.api.billingservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.ProductDoc;


/**
 * Product Line Doc Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ProductDocRepository extends CrudRepository<ProductDoc,Integer> {
	
	
	// find by id
	//<GET>http://localhost:8080/productlinedoc/1

	// find ALL
	//<GET>http://localhost:8080/productlinedoc/list


	//find by account / country / product- key1 
	ProductDoc findByAccountAndCountryAndProductType(String account, String country, String productType);
	
	//find by account - key1 
	List<ProductDoc> findByAccountOrderByCountryAscProductTypeAsc(String account);
	
	//find by account / country - key1 
	List<ProductDoc> findByAccountAndCountryOrderByProductTypeAsc(String account, String country);
	
	
}
