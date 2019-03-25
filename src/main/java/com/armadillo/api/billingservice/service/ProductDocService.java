package com.armadillo.api.billingservice.service;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.domain.ProductDoc;
import com.armadillo.api.billingservice.dto.ProductDocDto;
import com.armadillo.api.billingservice.repository.ProductDocRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Product Line Doc Service
 * ------------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ProductDocService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ProductDocRepository productDocRepository;



	//constructor
	@Autowired 
	public ProductDocService(ProductDocRepository productDocRepository) {
		this.productDocRepository = productDocRepository;	
	}




	/**
	 * Create a productDoc
	 */
	public ProductDocDto createProductDoc(ProductDocDto dto)  throws ApplicationException {

		ProductDoc productDocExists= productDocRepository.findByAccountAndCountryAndProductType(dto.getAccount(), dto.getCountry(), dto.getProductType());
		if (productDocExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getAccount()+" / "+dto.getCountry()+" / "+dto.getProductType(),    
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getAccount()+" / "+dto.getCountry()+" / "+dto.getProductType(), exceptionResponse);			
		}

		ProductDoc newProductDoc = new ProductDoc( 
				dto.getProductType(),
				dto.getAccount(),
				dto.getCountry(),
				dto.getPrice(),
				dto.getCost(),
				dto.getCredits(),
				dto.getCost2(),
				dto.getCost3(),
				dto.getCost4(),
				dto.getCost5()
				);

		validate(newProductDoc);

		ProductDoc productDoc = productDocRepository.save(newProductDoc);
		return toDto(productDoc);
	}


	/**
	 * Update productDoc
	 */    
	public ProductDocDto updateProductDoc(Integer id, ProductDocDto dto)  throws ApplicationException {
		ProductDoc productDoc = null;
		productDoc = this.verifyProductDoc(id);
		
		if (dto.getProductType()!=null) {		
			productDoc.setProductType(dto.getProductType());
		}
		if (dto.getAccount()!=null) {		
			productDoc.setAccount(dto.getAccount());
		}
		if (dto.getCountry()!=null) {		
			productDoc.setCountry(dto.getCountry());
		}
		if (dto.getPrice()!=null) {		
			productDoc.setPrice(dto.getPrice());
		}
		if (dto.getCost()!=null) {		
			productDoc.setCost(dto.getCost());
		}		
		if (dto.getCredits()!=null) {		
			productDoc.setCredits(dto.getCredits());
		}
		if (dto.getCost2()!=null) {		
			productDoc.setCost2(dto.getCost2());
		}	
		if (dto.getCost3()!=null) {		
			productDoc.setCost3(dto.getCost3());
		}	
		if (dto.getCost4()!=null) {		
			productDoc.setCost4(dto.getCost4());
		}	
		if (dto.getCost5()!=null) {		
			productDoc.setCost5(dto.getCost5());
		}	
		
		validate(productDoc);

		return toDto(productDocRepository.save(productDoc));
	}

	
	/**
	 * Delete 
	 */
	public void hardDeleteProductDocById(@PathVariable(value = "id") int id)  throws ApplicationException {
		ProductDoc productDoc = null;
		productDoc = this.verifyProductDoc(id);       
		if (productDoc != null) {
			productDocRepository.delete(productDoc);
		} 
	} 
	
	

	/**
	 *
	 */ 
	public ProductDocDto getProductDocById(Integer id)  throws ApplicationException {
		ProductDoc productDoc = null;
		productDoc = this.verifyProductDoc(id);

		return toDto(productDoc);
	}    


    public ProductDocDto findProductDocByAccountCountryProduct(
    		String account,
    		String country,    		
    		String product
    		)  throws ApplicationException {
    	
    	ProductDoc productDoc = null;
        productDoc = productDocRepository.findByAccountAndCountryAndProductType(account, country, product);
        
        return toDto(productDoc);
    }
    
	
	/**
	 * 
	 */   
	public List<ProductDocDto> getAllProductDocs()  throws ApplicationException {
		Iterable<ProductDoc> listIterable = productDocRepository.findAll();
		List<ProductDocDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_productDoc -> toDto(_productDoc)).collect(Collectors.toList()
						);    
		return dtoList;
	}   

	
	/**
	 */
	public List<ProductDocDto> findProductDocsByAccount(
    		String account
    		)  throws ApplicationException {

		Iterable<ProductDoc> listIterable = productDocRepository.findByAccountOrderByCountryAscProductTypeAsc(account);
		List<ProductDocDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_dao -> toDto(_dao))
				.collect(Collectors.toList()
				);    

		return dtoList;
	}
	
	
	/**
	 */
	public List<ProductDocDto> findProductDocsByAccountCountry(
    		String account,
    		String country
    		)  throws ApplicationException {

		Iterable<ProductDoc> listIterable = productDocRepository.findByAccountAndCountryOrderByProductTypeAsc(account, country);
		List<ProductDocDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_dao -> toDto(_dao))
				.collect(Collectors.toList()
				);    

		return dtoList;
	}
	
	
	/**
	 * Convert the productDoc entity to a ProductDocDto
	 */
	private ProductDocDto toDto(ProductDoc productDoc) {  
		ProductDocDto dto = new ProductDocDto(
				productDoc.getProductDocId(),
				productDoc.getProductType(),
				productDoc.getAccount(),
				productDoc.getCountry(),
				productDoc.getPrice(),
				productDoc.getCost(),
				productDoc.getCredits(),
				productDoc.getCost2(),
				productDoc.getCost3(),
				productDoc.getCost4(),
				productDoc.getCost5()				
				);

		return dto;
	}



	/**
	 * Verify and return the ProductDoc given an id.
	 */
	private ProductDoc verifyProductDoc(Integer id) throws ApplicationException {
		ProductDoc productDoc= productDocRepository.findById(id).get();
		if (productDoc==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return productDoc;
	}






	private void validate(ProductDoc productDoc) {
		// Details omitted
	}

}
