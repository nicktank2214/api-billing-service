package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.ContractPriceDto;
import com.armadillo.api.billingservice.service.ContractPriceService;
import com.armadillo.api.exception.ExceptionResponse;

import com.armadillo.api.exception.ApplicationException;






/**
 * Contract Price Controller
 * -------------------------
 * 
 * Keep your @Controller’s clean and focused - 
 * Controllers are supposed to be very thin. 
 * You want Controllers to coordinate and delegate, rather than to execute actual business logic. Here are the key practices:
 * 
 * Controllers should be stateless! Controllers are by default singletons and giving them any state can cause massive issues.
 * Controllers should not execute business logic but rely on delegation.
 * Controllers should deal with the HTTP layer of the application. This should not be passed down to Services.
 * Controllers should be oriented around a use-case / business-capability.
 * 
 */
@RestController
@RequestMapping(path = "/contractprice")
public class ContractPriceController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ContractPriceService contractPriceService;

	@Autowired
	public ContractPriceController(ContractPriceService contractPriceService) {
		this.contractPriceService = contractPriceService;
	}

	protected ContractPriceController() {
	}


	/**
	 * find contract price object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/contractprice/1
	public ContractPriceDto findContractPriceById(@PathVariable(value = "id") Integer id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findContractPriceById - Parameters [id=" + id+ "]");

		ContractPriceDto dto = contractPriceService.getContractPriceById(id);
		return dto;
	}



	/**
	 * list contract prices
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/contractprice/list 
	public List<ContractPriceDto> findAllContractPrices()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllContractPrices");
 
		List<ContractPriceDto> dtoList = contractPriceService.getAllContractPrices();
		return dtoList;
	}   


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccount")
	//<GET>http://localhost:8080/contractprice/findbyaccount?account=C449
	public List<ContractPriceDto> findContractPricesByAccount(
    		@RequestParam(value = "account") String account
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findContractPricesByAccount - Parameters [account=" + account+ "]");

		List<ContractPriceDto> dtoList = contractPriceService.findContractPricesByAccount(account);
		return dtoList;
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandproduct")
    //<GET>http://localhost:8080/contractprice/findbyaccountandproduct?account=C449&product=H_15
    public ContractPriceDto findContractPriceByAccountProduct(
    		@RequestParam(value = "account") String account, 
    		@RequestParam(value = "product") String product
    		) throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemCodesByCodeTypeCodeValue "+
				"- Parameters [account=" + account+	", product=" + product+
				"]");
    	
		ContractPriceDto dto = contractPriceService.findContractPriceByAccountProduct(account, product);
		return dto;
    }
    
	
	/**
	 * Create a product
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/contractprice
	//{
	//    "contract_price_id": 1,
	//    "account": "C449",
	//    "product": "H_15",
	//    "price": 27.5,
	//    "vat": 33,
	//    "discount_price": 0,
	//    "discount_vat": 0,
	//    "discount_multiple": 0
	//}
	public ContractPriceDto createContractPrice(@RequestBody @Validated ContractPriceDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createContractPrice - " + dto.toString()+ "]");
		
		ContractPriceDto productDto = contractPriceService.createContractPrice(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/contractprice/1 
	public ContractPriceDto updateContractPrice(@PathVariable(value = "id") Integer id, @RequestBody @Validated ContractPriceDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateContractPrice - " + dto.toString()+ "]");
		
		ContractPriceDto productDto = contractPriceService.updateContractPrice(id, dto);

		return productDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleContractPriceServiceException(ApplicationException exception ) {
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
