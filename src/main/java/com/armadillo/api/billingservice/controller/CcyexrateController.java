package com.armadillo.api.billingservice.controller;



import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.armadillo.api.billingservice.dto.CcyexrateDto;
import com.armadillo.api.billingservice.service.CcyexrateService;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;




/**
 * Currency Exchange Rate Controller
 * 
 * 
 */
@RestController
@RequestMapping(path = "/ccyexrate")
public class CcyexrateController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	CcyexrateService ccyexrateService;

	@Autowired
	public CcyexrateController(CcyexrateService ccyexrateService) {
		this.ccyexrateService = ccyexrateService;
	}
	

	protected CcyexrateController() {
	}



	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findlatest")
	//<GET>http://localhost:8080/ccyexrate/findlatest?from_ccy=USD?to_ccy=GBP
	//{
	//	"base":"USD",
	//	"date":"2019-03-27",
	//	"rates":
	//		{"GBP":0.7559}
	//}	
	public CcyexrateDto findLatestCcyexrateByFromccyAndToccy(
			@RequestParam(value = "from_ccy") String fromCcy,
			@RequestParam(value = "to_ccy") String toCcy			
			) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findLatestCcyexrateByFromccyAndToccy - Parameters [fromCcy=" + fromCcy+ ", toCcy=" + toCcy+ "]"
				);

		CcyexrateDto dto = ccyexrateService.findLatestCcyexrateByFromccyAndToccy(fromCcy, toCcy);
		return dto;
	}
	
	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbydate")
	//<GET>http://localhost:8080/ccyexrate/findbydate?date=219-01-01&from_ccy=USD&to_ccy=GBP
	//{
	//	"base":"USD",
	//	"date":"2019-03-27",
	//	"rates":
	//		{"GBP":0.7559}
	//}	
	public CcyexrateDto findCcyexrateByDateAndFromccyAndToccy(
			@RequestParam(value = "date") String date,			
			@RequestParam(value = "from_ccy") String fromCcy,
			@RequestParam(value = "to_ccy") String toCcy
			) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findCcyexrateByDateAndFromccyAndToccy - Parameters [date=" + date+ ", fromCcy=" + fromCcy+ ", toCcy=" + toCcy+ "]"
				);

		CcyexrateDto dto = ccyexrateService.findCcyexrateByDateAndFromccyAndToccy(date, fromCcy, toCcy);
		return dto;
	}
	
	
	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/convertlatest")
	//<GET>http://localhost:8080/ccyexrate/convertlatest?from_ccy=USD?to_ccy=GBP?in_amount=100
	//{
	//	"base":"USD",
	//	"date":"2019-03-27",
	//	"rates":
	//		{"GBP":0.7559}
	//}	
	public CcyexrateDto convertLatestCcyexrateByFromccyAndToccy(
			@RequestParam(value = "from_ccy") String fromCcy,
			@RequestParam(value = "to_ccy") String toCcy,
			@RequestParam(value = "in_amount") BigDecimal inAmount				
			) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" convertLatestCcyexrateByFromccyAndToccy - Parameters [fromCcy=" + fromCcy+ ", toCcy=" + toCcy+ ", inAmount=" + inAmount +"]"
				);

		CcyexrateDto dto = ccyexrateService.convertLatestCcyexrateByFromccyAndToccy(fromCcy, toCcy, inAmount);
		return dto;
	}
	
	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/convertbydate")
	//<GET>http://localhost:8080/ccyexrate/convertbydate?date=219-01-01&from_ccy=USD&to_ccy=GBP?in_amount=100
	//{
	//	"base":"USD",
	//	"date":"2019-03-27",
	//	"rates":
	//		{"GBP":0.7559}
	//}	
	public CcyexrateDto convertCcyexrateByDateAndFromccyAndToccy(
			@RequestParam(value = "date") String date,			
			@RequestParam(value = "from_ccy") String fromCcy,
			@RequestParam(value = "to_ccy") String toCcy,
			@RequestParam(value = "in_amount") BigDecimal inAmount
			) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" convertLatestCcyexrateByFromccyAndToccy - Parameters [fromCcy=" + fromCcy+ ", toCcy=" + toCcy+ ", inAmount=" + inAmount +"]"
				);

		CcyexrateDto dto = ccyexrateService.convertCcyexrateByDateAndFromccyAndToccy(date, fromCcy, toCcy, inAmount);
		return dto;
	}
	
	
	
	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleBillServiceException(ApplicationException exception ) {
		return exception.getExceptionResponse();
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(Exception exception) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), 
				exception.getMessage(),  
				"ERROR"
				);		

		return exceptionResponse;
	}



}
