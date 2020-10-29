package com.armadillo.api.billingservice.controller;





import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.armadillo.api.billingservice.dto.BillDto;
import com.armadillo.api.billingservice.dto.ReportDto;
import com.armadillo.api.billingservice.dto.ReportOutputDto;
import com.armadillo.api.billingservice.service.BillService;
import com.armadillo.api.billingservice.service.ReportService;
import com.armadillo.api.exception.ApplicationException;





/**
 * Controller
 * 
 */
@RestController
@RequestMapping(path = "/report")
public class ReportController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	ReportService reportService;
	BillService billService;


	@Autowired
	public ReportController(
			ReportService reportService, 
			BillService billService
			) {
		this.reportService = reportService;
		this.billService = billService;		
	}

	protected ReportController() {
	}





	/**
	 * list billings records using different operators
	 */   
	@RequestMapping(method = RequestMethod.POST, path = "/billextract1")    
	//<POST>http://localhost:8080/report/billextract1
	public List<BillDto> billExtract1(
			@RequestBody @Validated ReportDto reportDto		
			)  throws ApplicationException {		

		//convert dates 
		reportDto.setFromDateVal(this.setFromDate(reportDto.getFromDateVal()));
		reportDto.setToDateVal(this.setToDate(reportDto.getToDateVal()));

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" billExtract1 - "+ reportDto.toString()+		
				"]");

		List<BillDto> dtoList = null;

		if (reportDto.getSearchOpr().equals("Account")) {
			dtoList = billService.findBillsByAccountAndBillDateWithLookupData(reportDto.getSearchVal(),reportDto.getFromDateVal(),reportDto.getToDateVal());			
		}
		if (reportDto.getSearchOpr().equals("Client")) {
			dtoList = billService.findBillsByClientAndBillDateWithLookupData(new Integer(reportDto.getSearchVal()),reportDto.getFromDateVal(),reportDto.getToDateVal());			
		}		
		if (reportDto.getSearchOpr().equals("All")) {
			dtoList = billService.findBillsByBillDateWithLookupData(reportDto.getFromDateVal(),reportDto.getToDateVal());	
		}

		return dtoList;
	}   



	/**
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/invoicedata")
	//<POST>http://localhost:8080/bill/invoicereport
	//{
	//	"company_name_opr": "StartingWith",
	//	"company_name_val": "a",
	//	"client_name_opr": "StartingWith",
	//	"client_name_val": "client name",
	//	"client_reference_opr": "StartingWith",
	//	"client_reference_val": "Z",		
	//	"from_date_val": "2000-01-01",
	//	"to_date_val": "2018-06-01",
	//	"date_opr": "DateOfCreation"
	//
	//}
	public List<BillDto> runInvoiceData(@RequestBody @Validated ReportDto dto) {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" runInvoiceData - "+dto.toString());

		String billtype = "RES";

		List<BillDto> dtoList = null;
		dtoList=billService.getInvoiceData(billtype, dto.getFromDateVal(), dto.getToDateVal());

		return dtoList;

	}


	/**
	 */   
	@RequestMapping(method = RequestMethod.POST, path = "/profitanalysis1")    
	//<POST>http://localhost:8080/report/profitanalysis1
	public List<BillDto> profitAnalysis1(
			@RequestBody @Validated ReportDto reportDto		
			)  throws ApplicationException {		

		//convert dates 
		reportDto.setFromDateVal(this.setFromDate(reportDto.getFromDateVal()));
		reportDto.setToDateVal(this.setToDate(reportDto.getToDateVal()));

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" profitAnalysis1 - "+ reportDto.toString()+		
				"]");

		List<BillDto> dtoList = null;

		if (reportDto.getGroupOpr().equals("AccountSummary")) {
			if (reportDto.getSearchOpr().equals("Account")) {
				dtoList = billService.accountSummaryByAccountAndBilldateBetween(reportDto.getSearchVal(), reportDto.getFromDateVal(), reportDto.getToDateVal());			
			}
			if (reportDto.getSearchOpr().equals("All")) {
				dtoList = billService.accountSummaryByBilldateBetween(reportDto.getFromDateVal(), reportDto.getToDateVal());			
			}
		}

		if (reportDto.getGroupOpr().equals("ProductSummary")) {
			if (reportDto.getSearchOpr().equals("Account")) {
				dtoList = billService.productSummaryByAccountAndBilldateBetween(reportDto.getSearchVal(), reportDto.getFromDateVal(), reportDto.getToDateVal());			
			}
			if (reportDto.getSearchOpr().equals("All")) {
				dtoList = billService.productSummaryByBilldateBetween(reportDto.getFromDateVal(), reportDto.getToDateVal());			
			}
		}
		
		return dtoList;
	}   



	/**
	 */   
	@RequestMapping(method = RequestMethod.POST, path = "/userbill1")    
	//<POST>http://localhost:8080/report/userbill1
	public List<ReportOutputDto> userBill1(
			@RequestBody @Validated ReportDto reportDto		
			)  throws ApplicationException {		

		//convert dates 
		reportDto.setFromDateVal(this.setFromDate(reportDto.getFromDateVal()));
		reportDto.setToDateVal(this.setToDate(reportDto.getToDateVal()));

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" userBill1 - "+ reportDto.toString()+		
				"]");

		List<ReportOutputDto> dtoList = null;

		if (reportDto.getSearchOpr().equals("User")) {
			dtoList = billService.userBillByUserAndBilldateBetween(reportDto.getSearchVal(), reportDto.getFromDateVal(), reportDto.getToDateVal());			
		}
		if (reportDto.getSearchOpr().equals("All")) {
			dtoList = billService.userBillByBilldateBetween(reportDto.getFromDateVal(), reportDto.getToDateVal());			
		}

		return dtoList;
	} 


	public Date setFromDate(Date date) {
		Calendar calDate = Calendar. getInstance();
		calDate.setTime(date);		
		calDate.set(Calendar.HOUR, 0);
		calDate.set(Calendar.MINUTE, 0);
		calDate.set(Calendar.SECOND, 0);
		return calDate.getTime(); 
	}

	
	public Date setToDate(Date date) {
		Calendar calDate = Calendar. getInstance();
		calDate.setTime(date);		
		calDate.set(Calendar.HOUR, 23);
		calDate.set(Calendar.MINUTE, 59);
		calDate.set(Calendar.SECOND, 59);
		return calDate.getTime(); 
	}

	
	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}

}
