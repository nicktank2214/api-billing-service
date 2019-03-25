package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.ProductDto;
import com.armadillo.api.billingservice.service.ProductService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Product Controller
 * ------------------
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
@RequestMapping(path = "/product")
public class ProductController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	protected ProductController() {
	}


	/**
	 * find product object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/product/H_40    
	public ProductDto findProductById(@PathVariable(value = "id") String id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductById - Parameters [id=" + id+ "]");

		ProductDto productDto = productService.getProductById(id);
		return productDto;
	}



	/**
	 * list products
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/product/list 
	public List<ProductDto> findAllProducts()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllProducts");
 
		List<ProductDto> dtoList = productService.getAllProducts();
		return dtoList;
	}   


	/**
	 * Create a product
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/product
    //{
    //	"product": "H_40",
    //	"description": "Corporate Compliance Report  Level 1 UK",
    //	"default_price": 12,
    //	"default_vat": 14.4,
    //	"level_1": 12,
    //	"vatlevel_1": 14.4,
    //	"level_2": 12,
    //	"vatlevel_2": 14.4,
    //	"level_3": 12,
    //	"vatlevel_3": 14.4,
    //	"level_4": 12,
    //	"vatlevel_4": 14.4,
    //	"level_5": 12,
    //	"vatlevel_5": 14.4,
    //	"level_6": 12,
    //	"vatlevel_6": 14.4,
    //	"level_7": 12,
    //	"vatlevel_7": 14.4,
    //	"level_8": 12,
    //	"vatlevel_8": 14.4,
	//    "credits": 0	
    //}
	public ProductDto createProduct(@RequestBody @Validated ProductDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createProduct - " + dto.toString()+ "]");
		
		ProductDto productDto = productService.createProduct(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/product/H_40   
	public ProductDto updateProduct(@PathVariable(value = "id") String id, @RequestBody @Validated ProductDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateProduct - " + dto.toString()+ "]");
		
		ProductDto productDto = productService.updateProduct(id, dto);

		return productDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleProductServiceException(ApplicationException exception ) {
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
