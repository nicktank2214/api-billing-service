package com.armadillo.api.billingservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.billingservice.Constants;
import com.armadillo.api.billingservice.domain.Product;
import com.armadillo.api.billingservice.dto.ProductDto;
import com.armadillo.api.billingservice.repository.ProductRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Product Service
 * ---------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ProductService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ProductRepository productRepository;



	//constructor
	@Autowired 
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;	
	}




	/**
	 * Create a product
	 */
	public ProductDto createProduct(ProductDto dto)  throws ApplicationException {

		Product productExists= productRepository.findOne(dto.getProduct());
		if (productExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getProduct(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getProduct(), exceptionResponse);			
		}

		Product newProduct = new Product( 
				dto.getProduct(),			
				dto.getDescription(),
				dto.getDefaultPrice(),
				dto.getDefaultVat(),
				dto.getLevel1(),
				dto.getVatLevel1(),
				dto.getLevel2(),
				dto.getVatLevel2(),
				dto.getLevel3(),
				dto.getVatLevel3(),
				dto.getLevel4(),
				dto.getVatLevel4(),
				dto.getLevel5(),
				dto.getVatLevel5(),
				dto.getLevel6(),
				dto.getVatLevel6(),
				dto.getLevel7(),
				dto.getVatLevel7(),
				dto.getLevel8(),
				dto.getVatLevel8()
				);

		validate(newProduct);

		Product product = productRepository.save(newProduct);
		return toDto(product);
	}


	/**
	 * Update product
	 */    
	public ProductDto updateProduct(String id, ProductDto dto)  throws ApplicationException {
		Product product = null;
		product = this.verifyProduct(id);
		
		if (dto.getDescription()!=null) {		
			product.setDescription(dto.getDescription());
		}
		if (dto.getDefaultPrice()!=null) {		
			product.setDefaultPrice(dto.getDefaultPrice());
		}		
		if (dto.getDefaultVat()!=null) {		
			product.setDefaultVat(dto.getDefaultVat());
		}	
		if (dto.getLevel1()!=null) {		
			product.setLevel1(dto.getLevel1());
		}	
		if (dto.getVatLevel1()!=null) {		
			product.setVatLevel1(dto.getVatLevel1());
		}	
		if (dto.getLevel2()!=null) {		
			product.setLevel2(dto.getLevel2());
		}			
		if (dto.getVatLevel2()!=null) {		
			product.setVatLevel2(dto.getVatLevel2());
		}	
		if (dto.getLevel3()!=null) {		
			product.setLevel3(dto.getLevel3());
		}			
		if (dto.getVatLevel3()!=null) {		
			product.setVatLevel3(dto.getVatLevel3());
		}	
		if (dto.getLevel4()!=null) {		
			product.setLevel4(dto.getLevel4());
		}			
		if (dto.getVatLevel4()!=null) {		
			product.setVatLevel4(dto.getVatLevel4());
		}	
		if (dto.getLevel5()!=null) {		
			product.setLevel5(dto.getLevel5());
		}			
		if (dto.getVatLevel5()!=null) {		
			product.setVatLevel5(dto.getVatLevel5());
		}
		if (dto.getLevel6()!=null) {		
			product.setLevel6(dto.getLevel6());
		}			
		if (dto.getVatLevel6()!=null) {		
			product.setVatLevel6(dto.getVatLevel6());
		}
		if (dto.getLevel7()!=null) {		
			product.setLevel7(dto.getLevel7());
		}			
		if (dto.getVatLevel7()!=null) {		
			product.setVatLevel7(dto.getVatLevel7());
		}
		if (dto.getLevel8()!=null) {		
			product.setLevel8(dto.getLevel8());
		}			
		if (dto.getVatLevel8()!=null) {		
			product.setVatLevel8(dto.getVatLevel8());
		}
		
		validate(product);

		return toDto(productRepository.save(product));
	}


	/**
	 *
	 */ 
	public ProductDto getProductById(String id)  throws ApplicationException {
		Product product = null;
		product = this.verifyProduct(id);

		return toDto(product);
	}    


	/**
	 * 
	 */   
	public List<ProductDto> getAllProducts()  throws ApplicationException {
		Iterable<Product> listIterable = productRepository.findAll();
		List<ProductDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_product -> toDto(_product)).collect(Collectors.toList()
						);    
		return dtoList;
	}   


	/**
	 * Convert the product entity to a ProductDto
	 */
	private ProductDto toDto(Product product) {  
		ProductDto dto = new ProductDto(
				product.getProduct(),			
				product.getDescription(),
				product.getDefaultPrice(),
				product.getDefaultVat(),
				product.getLevel1(),
				product.getVatLevel1(),
				product.getLevel2(),
				product.getVatLevel2(),
				product.getLevel3(),
				product.getVatLevel3(),
				product.getLevel4(),
				product.getVatLevel4(),
				product.getLevel5(),
				product.getVatLevel5(),
				product.getLevel6(),
				product.getVatLevel6(),
				product.getLevel7(),
				product.getVatLevel7(),
				product.getLevel8(),
				product.getVatLevel8()
				);

		return dto;
	}



	/**
	 * Verify and return the Product given an id.
	 */
	private Product verifyProduct(String id) throws ApplicationException {
		Product product= productRepository.findOne(id);
		if (product==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return product;
	}






	private void validate(Product product) {
		// Details omitted
	}

}
