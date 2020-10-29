package com.armadillo.api.billingservice.service;





import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.dto.CcyexrateDto;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;
import com.google.gson.Gson;





/**
 * Currency Exchange Rate Service
 * ------------------------------
 * 
 */
@Service
public class CcyexrateService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	private final String RESOURCE_URL="https://ratesapi.io/api/";
	private final String API_KEY="";


	@Autowired
	RestTemplate restTemplate;



   


	/**
	 *
	 */ 
	public CcyexrateDto findLatestCcyexrateByFromccyAndToccy(String fromCcy, String toCcy)  throws ApplicationException {

		CcyexrateDto dto = null;
		try {

			String url = RESOURCE_URL + "latest?base=" + fromCcy+"&symbols="+toCcy;

/*			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findLatestCcyexrateByFromccyAndToccy - Parameters ["  
					+"fromCcy=" + fromCcy
					+", toCcy=" + toCcy									
					+", url=" + url									
					+ "]");*/

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("apiKey", API_KEY);

			String result = "";
			result = restTemplate.exchange(
					url, 
					HttpMethod.GET, 
					null, 
					String.class
					).getBody();

			dto = this.toCcyexrateDto(result);

		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);						 			
		}	

		return dto;
	}


	/**
	 *
	 */ 
	public CcyexrateDto findCcyexrateByDateAndFromccyAndToccy(String date, String fromCcy, String toCcy)  throws ApplicationException {

		CcyexrateDto dto = null;
		try {

			String url = RESOURCE_URL + date + "?base=" + fromCcy+"&symbols="+toCcy;

/*			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findCcyexrateByDateAndFromccyAndToccy - Parameters ["  
					+"date=" + date
					+"fromCcy=" + fromCcy
					+", toCcy=" + toCcy		
					+", url=" + url									
					+ "]");*/

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("apiKey", API_KEY);

			String result = "";
			result = restTemplate.exchange(
					url, 
					HttpMethod.GET, 
					null, 
					String.class
					).getBody();

			dto = this.toCcyexrateDto(result);

		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);						 			
		}

		return dto;
	}



	/**
	 *
	 */ 
	public CcyexrateDto convertLatestCcyexrateByFromccyAndToccy(String fromCcy, String toCcy, BigDecimal inAmount)  throws ApplicationException {

		CcyexrateDto dto = null;
		try {

			String url = RESOURCE_URL + "latest?base=" + fromCcy+"&symbols="+toCcy;

/*			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" convertLatestCcyexrateByFromccyAndToccy - Parameters ["  
					+"fromCcy=" + fromCcy
					+", toCcy=" + toCcy
					+", inAmount=" + inAmount
					+", url=" + url									
					+ "]");*/

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("apiKey", API_KEY);

			String result = "";
			result = restTemplate.exchange(
					url, 
					HttpMethod.GET, 
					null, 
					String.class
					).getBody();

			dto = this.toCcyexrateDto(result);
			dto.setInAmount(inAmount);
			dto.setOutAmount(dto.getExRate().multiply(dto.getInAmount()));
			
		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);						 			
		}	

		return dto;
	}


	/**
	 *
	 */ 
	public CcyexrateDto convertCcyexrateByDateAndFromccyAndToccy(String date, String fromCcy, String toCcy, BigDecimal inAmount)  throws ApplicationException {

		CcyexrateDto dto = null;
		try {

			String url = RESOURCE_URL + date + "?base=" + fromCcy+"&symbols="+toCcy;

/*			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" convertCcyexrateByDateAndFromccyAndToccy - Parameters ["  
					+"date=" + date
					+"fromCcy=" + fromCcy
					+", toCcy=" + toCcy	
					+", inAmount=" + inAmount					
					+", url=" + url									
					+ "]");*/

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("apiKey", API_KEY);

			String result = "";
			result = restTemplate.exchange(
					url, 
					HttpMethod.GET, 
					null, 
					String.class
					).getBody();

			dto = this.toCcyexrateDto(result);
			dto.setInAmount(inAmount);
			dto.setOutAmount(dto.getExRate().multiply(dto.getInAmount()));
			
		} catch (HttpStatusCodeException e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					e.getStatusCode().toString(), 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);			
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					"", 
					e.getMessage(),  
					"ERROR"
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_010, exceptionResponse);						 			
		}

		return dto;
	}
	
	
	
	
	
	/**
	 * Convert the JSON to a Dto
	 */
	private CcyexrateDto toCcyexrateDto(String data) {  
		CcyexrateDto dto = new CcyexrateDto();
		Gson gson = new Gson();
		dto = gson.fromJson(data, CcyexrateDto.class);

		//extra settings
		Map.Entry<String,BigDecimal> entry = dto.getRates().entrySet().iterator().next();
		dto.setFromCcy(dto.getBase());		
		dto.setToCcy(entry.getKey());
		dto.setExRate(entry.getValue());

		return dto;
	}


}
