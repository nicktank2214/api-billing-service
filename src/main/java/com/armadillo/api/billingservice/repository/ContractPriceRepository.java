package com.armadillo.api.billingservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.ContractPrice;


/**
 * Contract Price Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ContractPriceRepository extends CrudRepository<ContractPrice,Integer> {
	
	
	// find by id
	//<GET>http://localhost:8080/contractprice/1

	// find ALL
	//<GET>http://localhost:8080/contractprice/list

	
	//find by Account / Product - key1 
	ContractPrice findByAccountAndProduct(String account, String product);

	//find by Account / Product - key1 
	ContractPrice findByAccountAndProductAndCountry(String account, String product, String country);
	
	//find by Account / Product - key1 
	List<ContractPrice> findByAccount(String account);
	
    	
}
