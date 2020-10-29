package com.armadillo.api.billingservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.billingservice.Constants;

import com.armadillo.api.billingservice.domain.ContractPrice;
import com.armadillo.api.billingservice.dto.ContractPriceDto;
import com.armadillo.api.billingservice.repository.ContractPriceRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Contract Price Service
 * ----------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ContractPriceService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ContractPriceRepository contractPriceRepository;



	//constructor
	@Autowired 
	public ContractPriceService(ContractPriceRepository contractPriceRepository) {
		this.contractPriceRepository = contractPriceRepository;	
	}




	/**
	 * Create a contractPrice
	 */
	public ContractPriceDto createContractPrice(ContractPriceDto dto)  throws ApplicationException {

		ContractPrice contractPriceExists= contractPriceRepository.findByAccountAndProduct(dto.getAccount(), dto.getProduct());
		if (contractPriceExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getAccount()+" / "+dto.getProduct(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getAccount()+" / "+dto.getProduct(), exceptionResponse);			
		}

		ContractPrice newContractPrice = new ContractPrice( 
				dto.getAccount(),
				dto.getProduct(),
				dto.getCountry(),
				dto.getPrice(),
				dto.getVat(),
				dto.getDiscountPrice(),
				dto.getDiscountVat(),
				dto.getDiscountMultiple(),
				dto.getBusinessId(),
				dto.getCompanyId(),
				dto.getDepartmentId()				
				);

		validate(newContractPrice);

		ContractPrice contractPrice = contractPriceRepository.save(newContractPrice);
		return toDto(contractPrice);
	}


	/**
	 * Update contractPrice
	 */    
	public ContractPriceDto updateContractPrice(Integer id, ContractPriceDto dto)  throws ApplicationException {
		ContractPrice contractPrice = null;
		contractPrice = this.verifyContractPrice(id);
		
		if (dto.getPrice()!=null) {		
			contractPrice.setPrice(dto.getPrice());
		}
		if (dto.getVat()!=null) {		
			contractPrice.setVat(dto.getVat());
		}
		if (dto.getDiscountPrice()!=null) {		
			contractPrice.setDiscountPrice(dto.getDiscountPrice());
		}
		if (dto.getDiscountVat()!=null) {		
			contractPrice.setDiscountVat(dto.getDiscountVat());
		}
		if (dto.getDiscountMultiple()!=null) {		
			contractPrice.setDiscountMultiple(dto.getDiscountMultiple());
		}
		if (dto.getBusinessId()!=null) {		
			contractPrice.setBusinessId(dto.getBusinessId());
		}
		if (dto.getCompanyId()!=null) {		
			contractPrice.setCompanyId(dto.getCompanyId());
		}
		if (dto.getDepartmentId()!=null) {		
			contractPrice.setDepartmentId(dto.getDepartmentId());
		}				
		
		validate(contractPrice);

		return toDto(contractPriceRepository.save(contractPrice));
	}


	/**
	 *
	 */ 
	public ContractPriceDto getContractPriceById(Integer id)  throws ApplicationException {
		ContractPrice contractPrice = null;
		contractPrice = this.verifyContractPrice(id);

		return toDto(contractPrice);
	}    


    public ContractPriceDto findContractPriceByAccountProduct(
    		String account,
    		String product
    		)  throws ApplicationException {
    	
    	ContractPrice contractPrice = null;
        contractPrice = contractPriceRepository.findByAccountAndProduct(account, product);
        
        return toDto(contractPrice);
    }
    
	
	/**
	 * 
	 */   
	public List<ContractPriceDto> getAllContractPrices()  throws ApplicationException {
		Iterable<ContractPrice> listIterable = contractPriceRepository.findAll();
		List<ContractPriceDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_contractPrice -> toDto(_contractPrice)).collect(Collectors.toList()
						);    
		return dtoList;
	}   

	
	/**
	 */
	public List<ContractPriceDto> findContractPricesByAccount(
    		String account
    		)  throws ApplicationException {

		Iterable<ContractPrice> listIterable = contractPriceRepository.findByAccount(account);
		List<ContractPriceDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_dao -> toDto(_dao)).collect(Collectors.toList()
						);    

		return dtoList;
	}
	

	/**
	 * Convert the contractPrice entity to a ContractPriceDto
	 */
	private ContractPriceDto toDto(ContractPrice contractPrice) {  
		ContractPriceDto dto = new ContractPriceDto(
				contractPrice.getContractPriceId(),
				contractPrice.getAccount(),
				contractPrice.getProduct(),
				contractPrice.getCountry(),
				contractPrice.getPrice(),
				contractPrice.getVat(),
				contractPrice.getDiscountPrice(),
				contractPrice.getDiscountVat(),
				contractPrice.getDiscountMultiple(),
				contractPrice.getBusinessId(),
				contractPrice.getCompanyId(),
				contractPrice.getDepartmentId()					
				);

		return dto;
	}



	/**
	 * Verify and return the ContractPrice given an id.
	 */
	private ContractPrice verifyContractPrice(Integer id) throws ApplicationException {
		ContractPrice contractPrice= contractPriceRepository.findById(id).get();
		if (contractPrice==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return contractPrice;
	}






	private void validate(ContractPrice contractPrice) {
		// Details omitted
	}

}
