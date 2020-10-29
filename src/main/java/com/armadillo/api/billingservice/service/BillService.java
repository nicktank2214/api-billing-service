package com.armadillo.api.billingservice.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.billingservice.Constants;

import com.armadillo.api.billingservice.domain.Bill;
import com.armadillo.api.billingservice.dto.AccountDto;
import com.armadillo.api.billingservice.dto.BillDto;
import com.armadillo.api.billingservice.dto.ClientDto;
import com.armadillo.api.billingservice.dto.ProductTypeDocDto;
import com.armadillo.api.billingservice.dto.ReportOutputDto;
import com.armadillo.api.billingservice.repository.BillJpaRepository;
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


	private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private BillRepository billRepository;
	private BillJpaRepository billJpaRepository;
	private AccountService accountService; 
	private ClientService clientService;
	private SystemCodeService systemCodeService;
	private ProductTypeDocService productTypeDocService; 	



	//constructor
	@Autowired 
	public BillService(
			BillRepository billRepository, 
			BillJpaRepository billJpaRepository,
			AccountService accountService,
			ClientService clientService,
			SystemCodeService systemCodeService,
			ProductTypeDocService productTypeDocService			
			) {
		this.billRepository = billRepository;
		this.billJpaRepository = billJpaRepository;
		this.accountService = accountService;
		this.clientService = clientService;
		this.systemCodeService = systemCodeService;
		this.productTypeDocService = productTypeDocService;			
	}




	/**
	 * Create a bill
	 */
	public BillDto createBill(BillDto dto)  throws ApplicationException {

		Calendar c = Calendar.getInstance();
		java.util.Date billDate=c.getTime();
		String billTime=Util.toTime(c);

		//init fields
		String invoice = "";
		String invoiced = "no";
		Integer invoiceId = 0;


		//lookup account
		AccountDto accountDto = null;
		try {
			accountDto = accountService.getAccountById(dto.getAccount());
		} catch (Exception e) {}

		//derive fields
		BigDecimal vatRate = new BigDecimal(0);
		try {
			if (!accountDto.getVatExempt().equals("")) {
				vatRate = new BigDecimal(systemCodeService.findSystemCodeByCodeTypeAndCodeValue(
						"VAT_EXEMPT", 
						accountDto.getVatExempt()
						).getSystemLogProgram());
			}			
		} catch (Exception e) {}
		BigDecimal priceIncVat = new BigDecimal(0);
		BigDecimal vat = new BigDecimal(0);
		try {
			vat = dto.getPrice().multiply(vatRate).divide(new BigDecimal(100)); 
		} catch (Exception e) {}		
		try {
			priceIncVat=dto.getPrice().add(vat); 
		} catch (Exception e) {}

		ProductTypeDocDto productTypeDocDto = productTypeDocService.findProductTypeDocByLanguageProduct("EN", dto.getProductType());		
		String description = "";
		DecimalFormat df = new DecimalFormat("###0.00");
		description = dto.getCountry()+" / "+productTypeDocDto.getDescription()+" @ "+df.format(dto.getPrice());

		String product = productTypeDocDto.getDescription();
		String productDetail = dto.getClient()+"_"+billDate.getTime()+"_"+dto.getProductDetail();

		Bill newBill = new Bill( 
				dto.getClient(),
				billDate,
				dto.getSubjectId(),
				product,
				productDetail,
				billTime,
				dto.getSubjectName(),
				dto.getReference(),
				description,
				dto.getPrice(),
				vat,
				priceIncVat,
				invoiced,
				dto.getBillType(),
				dto.getAccount(),
				invoice,
				dto.getCountry(),
				dto.getBusinessId(),
				dto.getCompanyId(),
				dto.getDepartmentId(),
				dto.getContractPriceId(),
				dto.getProductDocId(),
				dto.getProductLineDocId(),
				dto.getUserId(),
				dto.getCredits(),
				dto.getProductType(),
				dto.getCost(),
				invoiceId,
				dto.getCost2(),
				dto.getCost3(),
				dto.getCost4(),
				dto.getCost5(),
				dto.getClientName()
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
		if (dto.getClient()!=null) {		
			bill.setClient(dto.getClient());
		}
		if (dto.getBillDate()!=null) {		
			bill.setBillDate(dto.getBillDate());
		}
		if (dto.getSubjectId()!=null) {		
			bill.setSubjectId(dto.getSubjectId());
		}
		if (dto.getProduct()!=null) {		
			bill.setProduct(dto.getProduct());
		}
		if (dto.getProductDetail()!=null) {		
			bill.setProductDetail(dto.getProductDetail());
		}
		if (dto.getBillTime()!=null) {		
			bill.setBillTime(dto.getBillTime());
		}
		if (dto.getSubjectName()!=null) {		
			bill.setSubjectName(dto.getSubjectName());
		}
		if (dto.getReference()!=null) {		
			bill.setReference(dto.getReference());
		}
		if (dto.getDescription()!=null) {		
			bill.setDescription(dto.getDescription());
		}
		if (dto.getPriceIncVat()!=null) {		
			bill.setPriceIncVat(dto.getPriceIncVat());
		}
		if (dto.getInvoiced()!=null) {		
			bill.setInvoiced(dto.getInvoiced());
		}
		if (dto.getBillType()!=null) {		
			bill.setBillType(dto.getBillType());
		}
		if (dto.getAccount()!=null) {		
			bill.setAccount(dto.getAccount());
		}
		if (dto.getInvoice()!=null) {		
			bill.setInvoice(dto.getInvoice());
		}
		if (dto.getCountry()!=null) {		
			bill.setCountry(dto.getCountry());
		}	
		if (dto.getBusinessId()!=null) {		
			bill.setBusinessId(dto.getBusinessId());
		}
		if (dto.getCompanyId()!=null) {		
			bill.setCompanyId(dto.getCompanyId());
		}
		if (dto.getDepartmentId()!=null) {		
			bill.setDepartmentId(dto.getDepartmentId());
		}	
		if (dto.getContractPriceId()!=null) {		
			bill.setContractPriceId(dto.getContractPriceId());
		}	

		if (dto.getCost()!=null) {		
			bill.setCost(dto.getCost());
		}	
		if (dto.getCost2()!=null) {		
			bill.setCost2(dto.getCost2());
		}	
		if (dto.getCost3()!=null) {		
			bill.setCost3(dto.getCost3());
		}	
		if (dto.getCost4()!=null) {		
			bill.setCost4(dto.getCost4());
		}	
		if (dto.getCost5()!=null) {		
			bill.setCost5(dto.getCost5());
		}	
		if (dto.getCredits()!=null) {		
			bill.setCredits(dto.getCredits());
		}			
		if (dto.getClientName()!=null) {		
			bill.setClientName(dto.getClientName());
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

		return toDtoWithLookupData(bill);
	}    


	/**
	 * 
	 */   
	public List<BillDto> getAllBills()  throws ApplicationException {
		Iterable<Bill> listIterable = billRepository.findAll();
		List<BillDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Bill b) -> toDto(b))
				.collect(Collectors.toList());    
		return dtoList;
	}   


	/**
	 */
	public List<BillDto> findBillsByAccount(
			String account
			)  throws ApplicationException {

		Iterable<Bill> listIterable = billRepository.findByAccount(account);
		List<BillDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Bill b) -> toDto(b)).collect(Collectors.toList());    

		return dtoList;
	}


	/**
	 */
	public List<BillDto> findBillsByClient(
			Integer client
			)  throws ApplicationException {

		Iterable<Bill> listIterable = billRepository.findByClient(client);
		List<BillDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Bill b) -> toDto(b)).collect(Collectors.toList());    

		return dtoList;
	}


	/**
	 */
	public List<BillDto> findBillsByClientWithLookupData(
			Integer client
			)  throws ApplicationException {
 
		Iterable<Bill> listIterable = billRepository.findByClient(client);
		List<BillDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Bill b) -> toDtoWithLookupData(b)).collect(Collectors.toList());  
		
		return dtoList;
	}

	
	/**
	 */
	public List<BillDto> findBillsByAccountWithLookupData(
			String account
			)  throws ApplicationException {
 
		Iterable<Bill> listIterable = billRepository.findByAccount(account);
		List<BillDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Bill b) -> toDtoWithLookupData(b)).collect(Collectors.toList());  
		
		return dtoList;
	}
	
	
	/**
	 */
	public List<BillDto> findBillsByAccountAndBillDateWithLookupData(
			String account,
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.findByAccountAndBilldateBetween(account, fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = toDto(b);
					String companyName = "";
					try {
						companyName = accountService.getAccountById((String)b[15]).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);

/*					String clientName = "";
					try {
						ClientDto clientDto = clientService.getClientById((Integer)b[1]);
						clientName = clientDto.getForename()+" "+clientDto.getSurname();
					} catch (Exception e) {}
					dto.setClientName(clientName);	*/				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}


	/**
	 */
	public List<BillDto> findBillsByClientAndBillDateWithLookupData(
			Integer client,
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.findByClientAndBilldateBetween(client, fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = toDto(b);
					String companyName = "";
					try {
						companyName = accountService.getAccountById((String)b[15]).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);

/*					String clientName = "";
					try {
						ClientDto clientDto = clientService.getClientById((Integer)b[1]);
						clientName = clientDto.getForename()+" "+clientDto.getSurname();
					} catch (Exception e) {}
					dto.setClientName(clientName);	*/				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}


	/**
	 */
	public List<BillDto> findBillsByBillDateWithLookupData(
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.findByBilldateBetween(fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = toDto(b);
					String companyName = "";
					try {
						companyName = accountService.getAccountById((String)b[15]).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);

/*					String clientName = "";
					try {
						ClientDto clientDto = clientService.getClientById((Integer)b[1]);
						clientName = clientDto.getForename()+" "+clientDto.getSurname();
					} catch (Exception e) {}
					dto.setClientName(clientName);*/					
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}
	
	
	
	/**
	 */
	public List<BillDto> accountSummaryByBilldateBetween(
			Date fromDate,
			Date toDate		
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.accountSummaryByBilldateBetween(fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" accountSummaryByBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = new BillDto();
					
					dto.setAccount((String)b[0]);
					dto.setPrice((BigDecimal)b[1]);
					dto.setCost((BigDecimal)b[2]);
					dto.setCost2((BigDecimal)b[3]);
					dto.setCost3((BigDecimal)b[4]);
					dto.setCost4((BigDecimal)b[5]);
					dto.setCost5((BigDecimal)b[6]);
					dto.setCountTotal((BigInteger)b[7]);					

					try {
						dto.setCostTotal(
								dto.getCost().add(dto.getCost2()).add(dto.getCost3()).add(dto.getCost4()).add(dto.getCost5())
								);
					} catch (Exception e) {
					}

					try {
						dto.setProfit(
								dto.getPrice().subtract(dto.getCostTotal())
								);
					} catch (Exception e) {
					}
					
					String companyName = "";
					try {
						companyName = accountService.getAccountById(dto.getAccount()).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);
					
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}

	
	/**
	 */
	public List<BillDto> accountSummaryByAccountAndBilldateBetween(
			String account,			
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.accountSummaryByAccountAndBilldateBetween(account, fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" accountSummaryByAccountAndBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = new BillDto();
					
					dto.setAccount((String)b[0]);
					dto.setPrice((BigDecimal)b[1]);
					dto.setCost((BigDecimal)b[2]);
					dto.setCost2((BigDecimal)b[3]);
					dto.setCost3((BigDecimal)b[4]);
					dto.setCost4((BigDecimal)b[5]);
					dto.setCost5((BigDecimal)b[6]);
					dto.setCountTotal((BigInteger)b[7]);					

					try {
						dto.setCostTotal(
								dto.getCost().add(dto.getCost2()).add(dto.getCost3()).add(dto.getCost4()).add(dto.getCost5())
								);
					} catch (Exception e) {
					}

					try {
						dto.setProfit(
								dto.getPrice().subtract(dto.getCostTotal())
								);
					} catch (Exception e) {
					}
					
					String companyName = "";
					try {
						companyName = accountService.getAccountById(dto.getAccount()).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);
				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}
	
	
	/**
	 */
	public List<BillDto> productSummaryByBilldateBetween(
			Date fromDate,
			Date toDate		
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.productSummaryByBilldateBetween(fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" productSummaryByBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = new BillDto();
					
					dto.setAccount((String)b[0]);
					dto.setCountry((String)b[1]);
					dto.setProduct((String)b[2]);					
					dto.setPrice((BigDecimal)b[3]);
					dto.setCost((BigDecimal)b[4]);
					dto.setCost2((BigDecimal)b[5]);
					dto.setCost3((BigDecimal)b[6]);
					dto.setCost4((BigDecimal)b[7]);
					dto.setCost5((BigDecimal)b[8]);
					dto.setCountTotal((BigInteger)b[9]);					

					try {
						dto.setCostTotal(
								dto.getCost().add(dto.getCost2()).add(dto.getCost3()).add(dto.getCost4()).add(dto.getCost5())
								);
					} catch (Exception e) {
					}

					try {
						dto.setProfit(
								dto.getPrice().subtract(dto.getCostTotal())
								);
					} catch (Exception e) {
					}
					
					String companyName = "";
					try {
						companyName = accountService.getAccountById(dto.getAccount()).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);
					
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}

	
	/**
	 */
	public List<BillDto> productSummaryByAccountAndBilldateBetween(
			String account,			
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.productSummaryByAccountAndBilldateBetween(account, fromDate, toDate);

		List<BillDto> dtoList = new LinkedList<BillDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" productSummaryByAccountAndBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = new BillDto();
					
					dto.setAccount((String)b[0]);
					dto.setCountry((String)b[1]);
					dto.setProduct((String)b[2]);					
					dto.setPrice((BigDecimal)b[3]);
					dto.setCost((BigDecimal)b[4]);
					dto.setCost2((BigDecimal)b[5]);
					dto.setCost3((BigDecimal)b[6]);
					dto.setCost4((BigDecimal)b[7]);
					dto.setCost5((BigDecimal)b[8]);
					dto.setCountTotal((BigInteger)b[9]);
					
					try {
						dto.setCostTotal(
								dto.getCost().add(dto.getCost2()).add(dto.getCost3()).add(dto.getCost4()).add(dto.getCost5())
								);
					} catch (Exception e) {
					}

					try {
						dto.setProfit(
								dto.getPrice().subtract(dto.getCostTotal())
								);
					} catch (Exception e) {
					}
					
					String companyName = "";
					try {
						companyName = accountService.getAccountById(dto.getAccount()).getBillingCompany();
					} catch (Exception e) {}
					dto.setCompanyName(companyName);
				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}
	
	
	/**
	 */
	public List<ReportOutputDto> userBillByUserAndBilldateBetween(
			String user,			
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.userBillByUserAndBilldateBetween(user, fromDate, toDate);

		List<ReportOutputDto> dtoList = new LinkedList<ReportOutputDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" userBillByUserAndBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					ReportOutputDto dto = new ReportOutputDto();
					
					dto.setDateVal1((Date)b[0]);
					dto.setStringVal1((String)b[1]);
					dto.setStringVal2((String)b[2]);
					dto.setDecimalVal1((BigDecimal)b[3]);
					dto.setIntegerVal1((BigInteger)b[4]);
				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}
	

	/**
	 */
	public List<ReportOutputDto> userBillByBilldateBetween(			
			Date fromDate,
			Date toDate
			)  throws ApplicationException {

		List<Object[]> resultsList = null;
		resultsList = billJpaRepository.userBillByBilldateBetween(fromDate, toDate);

		List<ReportOutputDto> dtoList = new LinkedList<ReportOutputDto>();
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" userBillByUserAndBilldateBetween - [size: "+ resultsList.size()+"]]");
		
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					ReportOutputDto dto = new ReportOutputDto();
					
					dto.setDateVal1((Date)b[0]);
					dto.setStringVal1((String)b[1]);
					dto.setStringVal2((String)b[2]);
					dto.setDecimalVal1((BigDecimal)b[3]);
					dto.setIntegerVal1((BigInteger)b[4]);
				
					return dto;
				}
			).collect(Collectors.toList());  

		return dtoList;
	}
	
	
	public List<BillDto> getInvoiceData(
			String billType, 
			Date fromDate, 
			Date toDate			 
			) {			

		List<Object[]> resultsList = null;
		resultsList=billJpaRepository.findByBilltypeLikeAndBilldateBetween(
				billType, 
				fromDate, 
				toDate
				);	

		List<BillDto> dtoList = new LinkedList<BillDto>();	
		dtoList = resultsList.stream()
				.map((Object[] b) -> {
					BillDto dto = toDto(b);
					return dto;
				}
			).collect(Collectors.toList());     


		return dtoList;
	}


	
	/**
	 * Convert the bill OBJECT to a BillDto
	 */
	private BillDto toDto(Object[] b) {  
		BillDto dto = new BillDto(
				(Integer)b[0],
				(Integer)b[1],
				(Date)b[2],	

				(String)b[3],
				(String)b[4],
				(String)b[5],								
				((Time)b[6]).toString(),
				(String)b[7],								         
				(String)b[8],	
				(String)b[9],	
				(BigDecimal)b[10],	
				(BigDecimal)b[11],	
				(BigDecimal)b[12],	

				(String)b[13],	
				(String)b[14],	
				(String)b[15],	
				(String)b[16],	
				(String)b[17],	

				(String)b[18],	
				(String)b[19],	
				(String)b[20],	

				(Integer)b[21],
				(Integer)b[22],
				(Integer)b[23],

				(String)b[24],	
				(BigDecimal)b[25],	

				(String)b[26],
				(BigDecimal)b[27],	
				(Integer)b[28],
				(BigDecimal)b[29],	
				(BigDecimal)b[30],	
				(BigDecimal)b[31],	
				(BigDecimal)b[32],
				(String)b[33]
				);

		return dto;
	}



	
	
	/**
	 * Convert the bill entity to a BillDto
	 */
	private BillDto toDto(Bill bill) {  
		BillDto dto = new BillDto(
				bill.getBillId(),
				bill.getClient(),
				bill.getBillDate(),
				bill.getSubjectId(),
				bill.getProduct(),
				bill.getProductDetail(),
				bill.getBillTime(),
				bill.getSubjectName(),
				bill.getReference(),
				bill.getDescription(),
				bill.getPrice(),
				bill.getVat(),
				bill.getPriceIncVat(),
				bill.getInvoiced(),
				bill.getBillType(),
				bill.getAccount(),
				bill.getInvoice(),
				bill.getCountry(),
				bill.getBusinessId(),
				bill.getCompanyId(),
				bill.getDepartmentId(),
				bill.getContractPriceId(),
				bill.getProductDocId(),
				bill.getProductLineDocId(),
				bill.getUserId(),
				bill.getCredits(),
				bill.getProductType(),
				bill.getCost(),
				bill.getInvoiceId(),
				bill.getCost2(),
				bill.getCost3(),
				bill.getCost4(),
				bill.getCost5(),
				bill.getClientName()
				);

		return dto;
	}


	/**
	 * Convert the bill entity to a BillDto
	 */
	private BillDto toDtoWithLookupData(Bill bill) {  
		BillDto dto = toDto(bill);

		String companyName = "";
		try {
			companyName = accountService.getAccountById(bill.getAccount()).getBillingCompany();
		} catch (Exception e) {}
		dto.setCompanyName(companyName);

		String clientName = "";
		try {
			ClientDto clientDto = clientService.getClientById(bill.getClient());
			clientName = clientDto.getForename()+" "+clientDto.getSurname();
		} catch (Exception e) {}
		dto.setClientName(clientName);

		return dto;
	}




	/**
	 * Verify and return the Bill given an id.
	 */
	private Bill verifyBill(Integer id) throws ApplicationException {
		Bill bill= billRepository.findById(id).get();
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
