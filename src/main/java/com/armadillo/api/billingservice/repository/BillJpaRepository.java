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
    		"bill.billtype," +     		
    		"bill.subject_id," + 
    		"bill.product " +  		
    		"FROM bill bill WHERE "+
    		"UPPER(bill.billtype) LIKE UPPER(:billtype) AND "+
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ "ORDER BY bill.billtype, bill.billdate", 
    		nativeQuery=true)
    public List<Object[]> findByBilltypeLikeAndBilldateBetween(
    		@Param("billtype") String billtype,  		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    

    /**
     */
    @Query(value="SELECT "+
			"bill.billid,"+
			"bill.client,"+
			"bill.billdate,"+
			"bill.subject_id,"+
			"bill.product,"+
			"bill.product_detail,"+
			"bill.billtime,"+
			"bill.subject_name,"+
			"bill.reference,"+
			"bill.description,"+
			"bill.price,"+
			"bill.vat,"+
			"bill.price_inc_vat,"+
			"bill.invoiced,"+
			"bill.billtype,"+
			"bill.account,"+
			"bill.invoice,"+
			"bill.country,"+
			"bill.businessid,"+
			"bill.companyid,"+
			"bill.departmentid,"+
			"bill.contractpriceid,"+
			"bill.productdocid,"+
			"bill.productlinedocid,"+
			"bill.userid,"+
			"bill.credits,"+
			"bill.producttype,"+
			"bill.cost,"+
			"bill.invoiceid,"+
			"bill.cost2,"+
			"bill.cost3,"+
			"bill.cost4,"+
			"bill.cost5, "+
			"bill.clientname "+			
    		"FROM bill bill WHERE "+
    		"bill.client = (:client) AND "+
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ "ORDER BY bill.client, bill.billdate", 
    		nativeQuery=true)
    public List<Object[]> findByClientAndBilldateBetween(
    		@Param("client") Integer client,  		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);

    
    /**
     */
    @Query(value="SELECT "+
			"bill.billid,"+
			"bill.client,"+
			"bill.billdate,"+
			"bill.subject_id,"+
			"bill.product,"+
			"bill.product_detail,"+
			"bill.billtime,"+
			"bill.subject_name,"+
			"bill.reference,"+
			"bill.description,"+
			"bill.price,"+
			"bill.vat,"+
			"bill.price_inc_vat,"+
			"bill.invoiced,"+
			"bill.billtype,"+
			"bill.account,"+
			"bill.invoice,"+
			"bill.country,"+
			"bill.businessid,"+
			"bill.companyid,"+
			"bill.departmentid,"+
			"bill.contractpriceid,"+
			"bill.productdocid,"+
			"bill.productlinedocid,"+
			"bill.userid,"+
			"bill.credits,"+
			"bill.producttype,"+
			"bill.cost,"+
			"bill.invoiceid,"+
			"bill.cost2,"+
			"bill.cost3,"+
			"bill.cost4,"+
			"bill.cost5, "+
			"bill.clientname "+
    		"FROM bill bill WHERE "+
    		"UPPER(bill.account) = UPPER(:account) AND "+
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ "ORDER BY bill.account, bill.billdate", 
    		nativeQuery=true)
    public List<Object[]> findByAccountAndBilldateBetween(
    		@Param("account") String account,  		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
    /**
     */
    @Query(value="SELECT "+
			"bill.billid,"+
			"bill.client,"+
			"bill.billdate,"+
			"bill.subject_id,"+
			"bill.product,"+
			"bill.product_detail,"+
			"bill.billtime,"+
			"bill.subject_name,"+
			"bill.reference,"+
			"bill.description,"+
			"bill.price,"+
			"bill.vat,"+
			"bill.price_inc_vat,"+
			"bill.invoiced,"+
			"bill.billtype,"+
			"bill.account,"+
			"bill.invoice,"+
			"bill.country,"+
			"bill.businessid,"+
			"bill.companyid,"+
			"bill.departmentid,"+
			"bill.contractpriceid,"+
			"bill.productdocid,"+
			"bill.productlinedocid,"+
			"bill.userid,"+
			"bill.credits,"+
			"bill.producttype,"+
			"bill.cost,"+
			"bill.invoiceid,"+
			"bill.cost2,"+
			"bill.cost3,"+
			"bill.cost4,"+
			"bill.cost5, "+
			"bill.clientname "+			
    		"FROM bill bill WHERE "+
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ "ORDER BY bill.billdate", 
    		nativeQuery=true)
    public List<Object[]> findByBilldateBetween(
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    	
    /**
     */
    @Query(value="SELECT "+
			"bill.account,"+  		
			"sum(bill.price),"+    		
			"sum(bill.cost),"+
			"sum(bill.cost2),"+
			"sum(bill.cost3),"+
			"sum(bill.cost4),"+
			"sum(bill.cost5), "+	
			"count(*) "+			
    		"FROM bill bill WHERE "+			
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ " GROUP BY bill.account", 
    		nativeQuery=true)
    public List<Object[]> accountSummaryByBilldateBetween(    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
    /**
     */
    @Query(value="SELECT "+
			"bill.account,"+  		
			"sum(bill.price),"+    		
			"sum(bill.cost),"+
			"sum(bill.cost2),"+
			"sum(bill.cost3),"+
			"sum(bill.cost4),"+
			"sum(bill.cost5), "+	
			"count(*) "+			
    		"FROM bill bill WHERE "+
    		"UPPER(bill.account) = UPPER(:account) AND "+			
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "
    		+ " GROUP BY bill.account", 
    		nativeQuery=true)
    public List<Object[]> accountSummaryByAccountAndBilldateBetween(
    		@Param("account") String account,  	    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
   
    
    /**
     */
    @Query(value="SELECT "+
			"bill.billdate,"+  
			"bill.userid,"+
			"bill.billtype,"+  			
			"sum(bill.price),"+    		
			"count(*) "+
    		"FROM bill bill WHERE "+
    		"UPPER(bill.userid) = UPPER(:user) AND "+			
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) " +
    		"GROUP BY bill.billdate, bill.userid, bill.billtype ", 
    		nativeQuery=true)
    public List<Object[]> userBillByUserAndBilldateBetween(
    		@Param("user") String user,  	    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
    /**
     */
    @Query(value="SELECT "+
			"bill.billdate,"+  
			"bill.userid,"+
			"bill.billtype,"+  			
			"sum(bill.price),"+    		
			"count(*) "+
    		"FROM bill bill WHERE "+		
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) " +
    		"GROUP BY bill.billdate, bill.userid, bill.billtype ", 
    		nativeQuery=true)
    public List<Object[]> userBillByBilldateBetween(	    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
    /**
     */
    @Query(value="SELECT "+
			"bill.account,"+
			"bill.country,"+
			"bill.product,"+ 		
			"sum(bill.price),"+    		
			"sum(bill.cost),"+
			"sum(bill.cost2),"+
			"sum(bill.cost3),"+
			"sum(bill.cost4),"+
			"sum(bill.cost5), "+
			"count(*) "+
    		"FROM bill bill WHERE "+			
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "+
    		"GROUP BY bill.account, bill.country, bill.product ", 
    		nativeQuery=true)
    public List<Object[]> productSummaryByBilldateBetween(    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
    /**
     */
    @Query(value="SELECT "+
			"bill.account,"+
			"bill.country,"+
			"bill.product,"+ 			
			"sum(bill.price),"+    		
			"sum(bill.cost),"+
			"sum(bill.cost2),"+
			"sum(bill.cost3),"+
			"sum(bill.cost4),"+
			"sum(bill.cost5), "+	
			"count(*) "+			
    		"FROM bill bill WHERE "+
    		"UPPER(bill.account) = UPPER(:account) AND "+			
    		"bill.billdate BETWEEN (:fromDate) AND (:toDate) "+
    		"GROUP BY bill.account, bill.country, bill.product ", 
    		nativeQuery=true)
    public List<Object[]> productSummaryByAccountAndBilldateBetween(
    		@Param("account") String account,  	    		
    		@Param("fromDate") Date fromDate,
    		@Param("toDate") Date toDate
    		);
    
    
}



