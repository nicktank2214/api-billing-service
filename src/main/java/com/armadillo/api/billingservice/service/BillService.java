package com.armadillo.api.billingservice.service;




import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.billingservice.Constants;

import com.armadillo.api.billingservice.domain.Bill;
import com.armadillo.api.billingservice.dto.BillDto;
import com.armadillo.api.billingservice.repository.BillRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.util.Util;




/**
 * Bill Service
 * ------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class BillService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private BillRepository billRepository;



	//constructor
	@Autowired 
	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;	
	}




	/**
	 * Create a bill
	 */
	public BillDto createBill(BillDto dto)  throws ApplicationException {

		Calendar c = Calendar.getInstance();
		java.util.Date billDate=c.getTime();
		String billTime=Util.toTime(c);
		
		Bill newBill = new Bill( 
				dto.getClient(),
				billDate,
				dto.getSubjectId(),
				dto.getProduct(),
				dto.getProductDetail(),
				billTime,
				dto.getSubjectName(),
				dto.getReference(),
				dto.getDescription(),
				dto.getPrice(),
				dto.getVat(),
				dto.getPriceIncVat(),
				dto.getInvoiced(),
				dto.getBillType(),
				dto.getAccount(),
				dto.getInvoice(),
				dto.getCountry(),
				dto.getBusinessId(),
				dto.getInvoice(),
				dto.getCountry()				
				);

		validate(newBill);

		Bill bill = billRepository.save(newBill);
		return toDto(bill);
	}


	/**
	 * Update bill
	 */    
	public BillDto updateBill(Integer id, BillDto dto)  throws ApplicationException {
		Bill bill = null;
		bill = this.verifyBill(id);
		
		if (dto.getPrice()!=null) {		
			bill.setPrice(dto.getPrice());
		}
		if (dto.getVat()!=null) {		
			bill.setVat(dto.getVat());
		}
		
		dto.getClient(),

		dto.getSubjectId(),
		dto.getProduct(),
		dto.getProductDetail(),

		dto.getSubjectName(),
		dto.getReference(),
		dto.getDescription(),
		dto.getPrice(),
		dto.getVat(),
		dto.getPriceIncVat(),
		dto.getInvoiced(),
		dto.getBillType(),
		dto.getAccount(),
		dto.getInvoice(),
		dto.getCountry()
		
		if (dto.getDiscountPrice()!=null) {		
			bill.setDiscountPrice(dto.getDiscountPrice());
		}
		if (dto.getDiscountVat()!=null) {		
			bill.setDiscountVat(dto.getDiscountVat());
		}
		if (dto.getDiscountMultiple()!=null) {		
			bill.setDiscountMultiple(dto.getDiscountMultiple());
		}
		
		validate(bill);

		return toDto(billRepository.save(bill));
	}


	/**
	 *
	 */ 
	public BillDto getBillById(Integer id)  throws ApplicationException {
		Bill bill = null;
		bill = this.verifyBill(id);

		return toDto(bill);
	}    


    public BillDto findBillByAccountProduct(
    		String account,
    		String product
    		)  throws ApplicationException {
    	
    	Bill bill = null;
        bill = billRepository.findByAccountAndProduct(account, product);
        
        return toDto(bill);
    }
    
	
	/**
	 * 
	 */   
	public List<BillDto> getAllBills()  throws ApplicationException {
		Iterable<Bill> listIterable = billRepository.findAll();
		List<BillDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_bill -> toDto(_bill)).collect(Collectors.toList()
						);    
		return dtoList;
	}   

	
	/**
	 */
	public List<BillDto> findBillsByAccount(
    		String account
    		)  throws ApplicationException {

		Iterable<Bill> listIterable = billRepository.findByAccount(account);
		List<BillDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_dao -> toDto(_dao)).collect(Collectors.toList()
						);    

		return dtoList;
	}
	

	/**
	 * Convert the bill entity to a BillDto
	 */
	private BillDto toDto(Bill bill) {  
		BillDto dto = new BillDto(
				bill.getBillId(),
				bill.getAccount(),
				bill.getProduct(),
				bill.getCountry(),
				bill.getPrice(),
				bill.getVat(),
				bill.getDiscountPrice(),
				bill.getDiscountVat(),
				bill.getDiscountMultiple()
				);

		return dto;
	}



	/**
	 * Verify and return the Bill given an id.
	 */
	private Bill verifyBill(Integer id) throws ApplicationException {
		Bill bill= billRepository.findOne(id);
		if (bill==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return bill;
	}






	private void validate(Bill bill) {
		// Details omitted
	}

}
