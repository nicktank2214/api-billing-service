package com.armadillo.api.billingservice.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.Bill;


/**
 * Bill Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface BillRepository extends CrudRepository<Bill,Integer> {
	
	
	// find by id
	//<GET>http://localhost:8080/bill/1

	// find ALL
	//<GET>http://localhost:8080/bill/list

	
	//find by account
	List<Bill>  findByAccount(String Account);
	
	//find by Account / Product - key1 
	List<Bill> findByClient(Integer client);


	
    	
}
