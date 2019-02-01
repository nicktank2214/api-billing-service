package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.ProductTypeDto;
import com.armadillo.api.billingservice.service.ProductTypeService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Product Type Controller
 * -----------------------
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
@RequestMapping(path = "/producttype")
public class ProductTypeController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ProductTypeService productTypeService;

	@Autowired
	public ProductTypeController(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	protected ProductTypeController() {
	}


	/**
	 * find product type object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/producttype/RM
	public ProductTypeDto findProductTypeById(@PathVariable(value = "id") String id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductTypeById - Parameters [id=" + id+ "]");

		ProductTypeDto productDto = productTypeService.getProductTypeById(id);
		return productDto;
	}



	/**
	 * list product types
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/producttype/list 
	public List<ProductTypeDto> findAllProductTypes()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllProductTypes");
 
		List<ProductTypeDto> dtoList = productTypeService.getAllProductTypes();
		return dtoList;
	}   


	/**
	 * Create a product type
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/producttype
    //{
    //	"type": "RM",
    //	"description": "RM Online",
    //}
	public ProductTypeDto createProductType(@RequestBody @Validated ProductTypeDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createProductType - " + dto.toString()+ "]");
		
		ProductTypeDto productDto = productTypeService.createProductType(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/producttype/RM 
	public ProductTypeDto updateProductType(@PathVariable(value = "id") String id, @RequestBody @Validated ProductTypeDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateProductType - " + dto.toString()+ "]");
		
		ProductTypeDto productDto = productTypeService.updateProductType(id, dto);

		return productDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleProductTypeServiceException(ApplicationException exception ) {
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
