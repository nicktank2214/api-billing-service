package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.ProductTypeDocDto;
import com.armadillo.api.billingservice.service.ProductTypeDocService;

import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Product Doc Controller
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
@RequestMapping(path = "/producttypedoc")
public class ProductTypeDocController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ProductTypeDocService productTypeDocService;

	@Autowired
	public ProductTypeDocController(ProductTypeDocService productTypeDocService) {
		this.productTypeDocService = productTypeDocService;
	}

	protected ProductTypeDocController() {
	}


	/**
	 * find contract price object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/producttypedoc/1
	public ProductTypeDocDto findProductDocById(@PathVariable(value = "id") Integer id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocById - Parameters [id=" + id+ "]");

		ProductTypeDocDto dto = productTypeDocService.getProductTypeDocById(id);
		return dto;
	}



	/**
	 * list contract prices
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/producttypedoc/list 
	public List<ProductTypeDocDto> findAllProductTypeDocs()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllProductTypeDocs");
 
		List<ProductTypeDocDto> dtoList = productTypeDocService.getAllProductTypeDocs();
		return dtoList;
	}   


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbylanguage")
	//<GET>http://localhost:8080/producttypedoc/findbylanguage?language=EN
	public List<ProductTypeDocDto> findProductTypeDocsByLanguage(
    		@RequestParam(value = "language") String language
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductTypeDocsByLanguage - Parameters [language=" + language+ "]");

		List<ProductTypeDocDto> dtoList = productTypeDocService.findProductTypeDocsByLanguage(language);
		return dtoList;
	}

	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyproduct")
	//<GET>http://localhost:8080/producttypedoc/findbyproduct?product=TRACE
	public List<ProductTypeDocDto> findProductTypeDocsByProduct(
    		@RequestParam(value = "product") String product
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductTypeDocsByProduct - Parameters [product=" + product+ "]");

		List<ProductTypeDocDto> dtoList = productTypeDocService.findProductTypeDocsByProductType(product);
		return dtoList;
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/findbylanguageandproduct")
    //<GET>http://localhost:8080/producttypedoc/findbylanguageandproduct?language=EN&product=TRACE
    public ProductTypeDocDto findProductTypeDocByAccountProduct(
    		@RequestParam(value = "language") String language, 
    		@RequestParam(value = "product") String product
    		) throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductTypeDocByAccountProduct "+
				"- Parameters [language=" + language+	", product=" + product+
				"]");
    	
		ProductTypeDocDto dto = productTypeDocService.findProductTypeDocByLanguageProduct(language, product);
		return dto;
    }
    
	
	/**
	 * list records by language or Product 
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/search1")    
	//<GET>http://localhost:8080/producttypedoc/search1?val=EN&opr=Language
	public List<ProductTypeDocDto> productTypeDocSearch1(
			@RequestParam(value = "val") String searchValue,
			@RequestParam(value = "opr") String searchOperator
			)  throws ApplicationException {		

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" productTypeDocSearch1 - Parameters ["
				+"searchValue=" + searchValue +", "+"searchOperator=" + searchOperator
				+ "]");

		List<ProductTypeDocDto> dtoList = null;
		if (searchOperator.equals("Language")) {
			dtoList = productTypeDocService.findProductTypeDocsByLanguage(searchValue);			
		}
		if (searchOperator.equals("ProductType")) {
			dtoList = productTypeDocService.findProductTypeDocsByProductType(searchValue);			
		}

		return dtoList;
	}       
	/**
	 * Create a product
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/producttypedoc
	//{
	//    "product_type_doc_id": 1,
	//    "product_type": "TRACE",
	//    "description": "Trace Report",
	//    "language": "EN"
	//}
	public ProductTypeDocDto createProductTypeDoc(@RequestBody @Validated ProductTypeDocDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createProductTypeDoc - " + dto.toString()+ "]");
		
		ProductTypeDocDto productDto = productTypeDocService.createProductTypeDoc(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/producttypedoc/1 
	public ProductTypeDocDto updateProductTypeDoc(@PathVariable(value = "id") Integer id, @RequestBody @Validated ProductTypeDocDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateProductTypeDoc - " + dto.toString()+ "]");
		
		ProductTypeDocDto productDto = productTypeDocService.updateProductTypeDoc(id, dto);

		return productDto;
	}


	/**
	 * Delete using POST
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/harddeletebyid/{id}")
	//<POST>http://localhost:8080/producttypedoc/harddeletebyid/330  
	public boolean hardDeleteById(@PathVariable(value = "id") int id)	throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" hardDeleteById - Parameters [id = "+id+" ]");
		
		productTypeDocService.hardDeleteById(id);
		
		return true;
	} 

	
	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleProductDocServiceException(ApplicationException exception ) {
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
