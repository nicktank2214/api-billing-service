package com.armadillo.api.billingservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.armadillo.api.billingservice.Constants;

import com.armadillo.api.billingservice.domain.ProductTypeDoc;
import com.armadillo.api.billingservice.dto.ProductTypeDocDto;
import com.armadillo.api.billingservice.repository.ProductTypeDocRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Product Doc Service
 * ----------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ProductTypeDocService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ProductTypeDocRepository productTypeDocRepository;



	//constructor
	@Autowired 
	public ProductTypeDocService(ProductTypeDocRepository productTypeDocRepository) {
		this.productTypeDocRepository = productTypeDocRepository;	
	}




	/**
	 * Create a productTypeDoc
	 */
	public ProductTypeDocDto createProductTypeDoc(ProductTypeDocDto dto)  throws ApplicationException {

		ProductTypeDoc productTypeDocExists= productTypeDocRepository.findByLanguageAndProductType(dto.getLanguage(), dto.getProductType());
		if (productTypeDocExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getLanguage()+" / "+dto.getProductType(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getLanguage()+" / "+dto.getProductType(), exceptionResponse);			
		}

		ProductTypeDoc newProductDoc = new ProductTypeDoc( 
				dto.getProductType(),
				dto.getDescription(),
				dto.getLanguage()			
				);

		validate(newProductDoc);

		ProductTypeDoc productTypeDoc = productTypeDocRepository.save(newProductDoc);
		return toDto(productTypeDoc);
	}


	/**
	 * Update productTypeDoc
	 */    
	public ProductTypeDocDto updateProductTypeDoc(Integer id, ProductTypeDocDto dto)  throws ApplicationException {
		ProductTypeDoc productTypeDoc = null;
		productTypeDoc = this.verifyProductTypeDoc(id);
		
		if (dto.getProductType()!=null) {		
			productTypeDoc.setProductType(dto.getProductType());
		}
		if (dto.getDescription()!=null) {		
			productTypeDoc.setDescription(dto.getDescription());
		}
		if (dto.getLanguage()!=null) {		
			productTypeDoc.setLanguage(dto.getLanguage());
		}

		validate(productTypeDoc);

		return toDto(productTypeDocRepository.save(productTypeDoc));
	}


	/**
	 * Delete 
	 */
	public void hardDeleteById(@PathVariable(value = "id") int id)  throws ApplicationException {
		ProductTypeDoc productTypeDoc = this.verifyProductTypeDoc(id);       
		if (productTypeDoc != null) {
			productTypeDocRepository.delete(productTypeDoc);
		} 
	} 

	
	/**
	 *
	 */ 
	public ProductTypeDocDto getProductTypeDocById(Integer id)  throws ApplicationException {
		ProductTypeDoc productTypeDoc = null;
		productTypeDoc = this.verifyProductTypeDoc(id);

		return toDto(productTypeDoc);
	}    


    public ProductTypeDocDto findProductTypeDocByLanguageProduct(
    		String language,
    		String productType
    		)  throws ApplicationException {
    	
    	ProductTypeDoc productTypeDoc = null;
        productTypeDoc = productTypeDocRepository.findByLanguageAndProductType(language, productType);
        
        return toDto(productTypeDoc);
    }
    
	
	/**
	 * 
	 */   
	public List<ProductTypeDocDto> getAllProductTypeDocs()  throws ApplicationException {
		Iterable<ProductTypeDoc> listIterable = productTypeDocRepository.findAll();
		List<ProductTypeDocDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_productTypeDoc -> toDto(_productTypeDoc)).collect(Collectors.toList()
						);    
		return dtoList;
	}   

	
	/**
	 */
	public List<ProductTypeDocDto> findProductTypeDocsByLanguage(
    		String country
    		)  throws ApplicationException {

		Iterable<ProductTypeDoc> listIterable = productTypeDocRepository.findByLanguage(country);
		List<ProductTypeDocDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_dao -> toDto(_dao))
				.collect(Collectors.toList()
				);    

		return dtoList;
	}

	
	/**
	 */
	public List<ProductTypeDocDto> findProductTypeDocsByProductType(
    		String product
    		)  throws ApplicationException {

		Iterable<ProductTypeDoc> listIterable = productTypeDocRepository.findByProductType(product);
		List<ProductTypeDocDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_dao -> toDto(_dao))
				.collect(Collectors.toList()
				);    

		return dtoList;
	}

	
	/**
	 * Convert the productTypeDoc entity to a ProductDocDto
	 */
	private ProductTypeDocDto toDto(ProductTypeDoc productTypeDoc) {  
		ProductTypeDocDto dto = new ProductTypeDocDto(
				productTypeDoc.getProductTypeDocId(),
				productTypeDoc.getProductType(),
				productTypeDoc.getDescription(),
				productTypeDoc.getLanguage()					
				);

		return dto;
	}



	/**
	 * Verify and return the ProductDoc given an id.
	 */
	private ProductTypeDoc verifyProductTypeDoc(Integer id) throws ApplicationException {
		ProductTypeDoc productTypeDoc= productTypeDocRepository.findById(id).get();
		if (productTypeDoc==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return productTypeDoc;
	}






	private void validate(ProductTypeDoc productTypeDoc) {
		// Details omitted
	}

}
