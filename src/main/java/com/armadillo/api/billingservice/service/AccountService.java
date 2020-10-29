package com.armadillo.api.billingservice.service;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.configuration.ServiceProperties;
import com.armadillo.api.billingservice.dto.AccountDto;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;





/**
 * Account Service
 * ------------
 * 
 * This Service is designed to make calls to another service using a RestTemplate
 * 
 */
@Service
public class AccountService {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@Autowired
	RestTemplate restTemplate;


	@Autowired
	private ServiceProperties serviceProperties;

 

	/**
	 *
	 */ 
	public AccountDto getAccountById(String id)  throws ApplicationException {
		        
		AccountDto accountDto = null;
		try {

	        String url = serviceProperties.getClientService()  + "/account/" + id;
	        
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" getAccountById - Parameters ["  
									+"id=" + id
									+", url=" + url									
									+ "]");
			
	        accountDto = restTemplate.getForObject(url, AccountDto.class);
	        
		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);						 			
		}	

		return accountDto;
	}    

	


}
