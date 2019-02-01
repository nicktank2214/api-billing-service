package com.armadillo.api.billingservice.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.billingservice.domain.Bill;



/**
 * Contract Price Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface BillJpaRepository extends JpaRepository<Bill,Integer> {
	
	

    /**
     */
    @Query(value="SELECT "+
    		"bill.client,"+ 
    		"bill.billdate," + 
    		"bill.billtime," +
    		"bill.billttype," +     		
    		"bill.subject_id," + 
    		"bill.product " +  		
    		"FROM bill bill WHERE "+
    		"UPPER(bill.billttype) LIKE UPPER(:billttype) AND "+
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ "ORDER BY company.companyName", 
    		nativeQuery=true)
    public List<Object[]> findByBilltypeLikeAndBilldateBetween(
    		@Param("billttype") String billttype,  		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
	
    	
}
