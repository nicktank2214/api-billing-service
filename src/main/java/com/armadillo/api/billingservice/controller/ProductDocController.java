package com.armadillo.api.billingservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.billingservice.dto.ProductDocDto;
import com.armadillo.api.billingservice.service.ProductDocService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Product Line Doc Controller
 * ---------------------------
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
@RequestMapping(path = "/productdoc")
public class ProductDocController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ProductDocService productDocService;

	@Autowired
	public ProductDocController(ProductDocService productDocService) {
		this.productDocService = productDocService;
	}

	protected ProductDocController() {
	}


	/**
	 * find contract price object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/productdoc/1
	public ProductDocDto findProductDocById(@PathVariable(value = "id") Integer id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocById - Parameters [id=" + id+ "]");

		ProductDocDto dto = productDocService.getProductDocById(id);
		return dto;
	}



	/**
	 * list contract prices
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/productdoc/list 
	public List<ProductDocDto> findAllProductDocs()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllProductDocs");
 
		List<ProductDocDto> dtoList = productDocService.getAllProductDocs();
		return dtoList;
	}   


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccount")
	//<GET>http://localhost:8080/productdoc/findbyaccount?account=A055
	public List<ProductDocDto> findProductDocsByAccount(
    		@RequestParam(value = "account") String account
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocsByAccount - Parameters [account=" + account+ "]");

		List<ProductDocDto> dtoList = productDocService.findProductDocsByAccount(account);
		return dtoList;
	}

	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandcountry")
	//<GET>http://localhost:8080/productdoc/findbyaccountandcountry?account=A055&country=CH
	public List<ProductDocDto> findProductDocsByAccountCountry(
    		@RequestParam(value = "account") String account,
    		@RequestParam(value = "country") String country
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocsByAccountCountry - Parameters [account=" + account+	", country=" + country+
				"]");

		List<ProductDocDto> dtoList = productDocService.findProductDocsByAccountCountry(account, country);
		return dtoList;
	}

	
	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandcountryandlanguage")
	//<GET>http://localhost:8080/productdoc/findbyaccountandcountry?account=A055&country=CH&language=EN
	public List<ProductDocDto> findProductDocsByAccountCountryLanguage(
    		@RequestParam(value = "account") String account,
    		@RequestParam(value = "country") String country,
    		@RequestParam(value = "language") String language    		
    		 ) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocsByAccountCountry - Parameters [account=" + account+	", country=" + country+
				"]");

		List<ProductDocDto> dtoList = productDocService.findProductDocsByAccountCountryLanguage(account, country, language);
		return dtoList;
	}
	
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandcountryandproduct")
    //<GET>http://localhost:8080/productdoc/findbyaccountandcountryandproduct?account=A055&country=GB&product=TRACE
    public ProductDocDto findProductDocByAccountCountryProduct(
    		@RequestParam(value = "account") String account,
    		@RequestParam(value = "country") String country,     		
    		@RequestParam(value = "product") String product
    		) throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findProductDocByAccountCountryProduct "+
				"- Parameters [account=" + account+	", country=" + country+", product=" + product+
				"]");
    	
		ProductDocDto dto = productDocService.findProductDocByAccountCountryProduct(account, country, product);
		return dto;
    }
    
	
	/**
	 * Create a product line doc
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/productdoc
	//{
	//    "productlinedocid": 41,
	//    "product": "CERT_INC",
	//    "account": "A055",
	//    "country": "LK",
	//    "price": 183,
	//    "cost": 0,
	//    "credits": 0	
	//}
	public ProductDocDto createProductDoc(@RequestBody @Validated ProductDocDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createProductDoc - " + dto.toString()+ "]");
		
		ProductDocDto productDto = productDocService.createProductDoc(dto);
		return productDto;
	}


	/**
	 * Update product object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/productdoc/1 
	public ProductDocDto updateProductDoc(@PathVariable(value = "id") Integer id, @RequestBody @Validated ProductDocDto dto)
			throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateProductDoc - " + dto.toString()+ "]");
		
		ProductDocDto productDto = productDocService.updateProductDoc(id, dto);

		return productDto;
	}


	/**
	 * Delete using POST
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/harddeletebyid/{id}")
	//<POST>http://localhost:8080/productdoc/harddeletebyid/330  
	public boolean hardDeleteById(@PathVariable(value = "id") int id)	throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" hardDeleteById - Parameters [id = "+id+" ]");
		
		productDocService.hardDeleteProductDocById(id);
		
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
