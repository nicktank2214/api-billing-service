package com.armadillo.api.billingservice.service;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.configuration.ServiceProperties;
import com.armadillo.api.billingservice.dto.SystemCodeDto;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * SystemCode Service
 * ------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class SystemCodeService {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@Autowired
	RestTemplate restTemplate;

	
	@Autowired
	private ServiceProperties serviceProperties;




	

	
	/**
	 * 
	 */
	public SystemCodeDto findSystemCodeByCodeTypeAndCodeValue(
			String type,
			String value
			)  throws ApplicationException {
		        
		SystemCodeDto dto = null;
		try {

	        String url = serviceProperties.getClientService() + "/systemcode/findbytypeandvalue?codetype="+type+"&codevalue="+value;
	        
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findSystemCodeByCodeTypeAndCodeValue - Parameters ["  
									+"type=" + type
									+", value=" + value
									+", url=" + url									
									+ "]");
			
			dto = restTemplate.getForObject(url, SystemCodeDto.class);
	        
		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + type + "/"+value, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001  + type + "/"+value, exceptionResponse);						 			
		}	

		return dto;
	}  
	
	

	
}
