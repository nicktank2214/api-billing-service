package com.armadillo.api.billingservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.domain.ProductType;
import com.armadillo.api.billingservice.dto.ProductTypeDto;
import com.armadillo.api.billingservice.repository.ProductTypeRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Product Type Service
 * --------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ProductTypeService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ProductTypeRepository productTypeRepository;



	//constructor
	@Autowired 
	public ProductTypeService(ProductTypeRepository productTypeRepository) {
		this.productTypeRepository = productTypeRepository;	
	}




	/**
	 * Create a productType
	 */
	public ProductTypeDto createProductType(ProductTypeDto dto)  throws ApplicationException {

		ProductType productTypeExists= productTypeRepository.findOne(dto.getType());
		if (productTypeExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getType(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getType(), exceptionResponse);			
		}

		ProductType newProductType = new ProductType( 
				dto.getType(),			
				dto.getDescription()
				);

		validate(newProductType);

		ProductType productType = productTypeRepository.save(newProductType);
		return toDto(productType);
	}


	/**
	 * Update productType
	 */    
	public ProductTypeDto updateProductType(String id, ProductTypeDto dto)  throws ApplicationException {
		ProductType productType = null;
		productType = this.verifyProductType(id);
		
		if (dto.getDescription()!=null) {		
			productType.setDescription(dto.getDescription());
		}
	
		validate(productType);

		return toDto(productTypeRepository.save(productType));
	}


	/**
	 *
	 */ 
	public ProductTypeDto getProductTypeById(String id)  throws ApplicationException {
		ProductType productType = null;
		productType = this.verifyProductType(id);

		return toDto(productType);
	}    


	/**
	 * 
	 */   
	public List<ProductTypeDto> getAllProductTypes()  throws ApplicationException {
		Iterable<ProductType> listIterable = productTypeRepository.findAll();
		List<ProductTypeDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_productType -> toDto(_productType)).collect(Collectors.toList()
						);    
		return dtoList;
	}   


	/**
	 * Convert the productType entity to a ProductTypeDto
	 */
	private ProductTypeDto toDto(ProductType productType) {  
		ProductTypeDto dto = new ProductTypeDto(
				productType.getType(),			
				productType.getDescription()
				);

		return dto;
	}



	/**
	 * Verify and return the ProductType given an id.
	 */
	private ProductType verifyProductType(String id) throws ApplicationException {
		ProductType productType= productTypeRepository.findOne(id);
		if (productType==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return productType;
	}






	private void validate(ProductType productType) {
		// Details omitted
	}

}
