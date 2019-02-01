package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.BillDto;
import com.armadillo.api.billingservice.service.BillService;
import com.armadillo.api.exception.ExceptionResponse;

import com.armadillo.api.exception.ApplicationException;






/**
 * Bill Controller
 * ---------------
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
@RequestMapping(path = "/bill")
public class BillController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	BillService billService;

	@Autowired
	public BillController(BillService billService) {
		this.billService = billService;
	}

	protected BillController() {
	}


	/**
	 * find bill object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/bill/1
	public BillDto findBillById(@PathVariable(value = "id") Integer id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findBillById - Parameters [id=" + id+ "]");

		BillDto dto = billService.getBillById(id);
		return dto;
	}



	/**
	 * list bill
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/bill/list 
	public List<BillDto> findAllBills()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllBills");
 
		List<BillDto> dtoList = billService.getAllBills();
		return dtoList;
	}   


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccount")
	//<GET>http://localhost:8080/bill/findbyaccount?account=C449
	public List<BillDto> findBillsByAccount(
    		@RequestParam(value = "account") String account
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findBillsByAccount - Parameters [account=" + account+ "]");

		List<BillDto> dtoList = billService.findBillsByAccount(account);
		return dtoList;
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandproduct")
    //<GET>http://localhost:8080/bill/findbyaccountandproduct?account=C449&product=H_15
    public BillDto findBillByAccountProduct(
    		@RequestParam(value = "account") String account, 
    		@RequestParam(value = "product") String product
    		) throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemCodesByCodeTypeCodeValue "+
				"- Parameters [account=" + account+	", product=" + product+
				"]");
    	
		BillDto dto = billService.findBillByAccountProduct(account, product);
		return dto;
    }
    
	
	/**
	 * Create a bill
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/bill
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
	public BillDto createBill(@RequestBody @Validated BillDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createBill - " + dto.toString()+ "]");
		
		BillDto productDto = billService.createBill(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/bill/1 
	public BillDto updateBill(
			@PathVariable(value = "id") Integer id, @RequestBody @Validated BillDto dto
			)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateBill - " + dto.toString()+ "]");
		
		BillDto billDto = billService.updateBill(id, dto);
		return billDto;
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
