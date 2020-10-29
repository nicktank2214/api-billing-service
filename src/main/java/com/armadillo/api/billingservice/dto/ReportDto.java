package com.armadillo.api.billingservice.dto;


import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.armadillo.api.billingservice.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;





/**
 */
public class ReportDto {


	@Size(max = 50)
	@JsonProperty("company_name_opr")
	private String companyNameOpr;

	@Size(max = 255)
	@JsonProperty("company_name_val")
	private String companyNameVal;

	@Size(max = 50)
	@JsonProperty("client_name_opr")
	private String clientNameOpr;

	@Size(max = 255)
	@JsonProperty("client_name_val")
	private String clientNameVal;

	
	@Size(max = 50)
	@JsonProperty("client_reference_opr")
	private String clientReferenceOpr;

	@Size(max = 255)
	@JsonProperty("client_reference_val")
	private String clientReferenceVal;
	
	
	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("from_date_val")
	private java.util.Date fromDateVal;

	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("to_date_val")
	private java.util.Date toDateVal;
	
	
	@Size(max = 50)
	@JsonProperty("date_opr")
	private String dateOpr;
	
	
	
	@JsonProperty("user_id")
	private String userId;    



	@Size(max = 50)
	@JsonProperty("search_opr")
	private String searchOpr;

	@Size(max = 255)
	@JsonProperty("search_val")
	private String searchVal;
	
	
	@Size(max = 50)
	@JsonProperty("group_opr")
	private String groupOpr;
	
	



	public ReportDto(
			String companyNameOpr,
			String companyNameVal,
			String clientNameOpr,
			String clientNameVal,
			String clientReferenceOpr,
			String clientReferenceVal,			
			Date fromDateVal,
			Date toDateVal,
			String dateOpr,		
			String userId,
			String searchOpr,
			String searchVal,
			String groupOpr
			) {
		this.companyNameOpr = companyNameOpr;
		this.companyNameVal = companyNameVal;
		this.clientNameOpr = clientNameOpr;	
		this.clientNameVal = clientNameVal;
		this.clientReferenceOpr = clientReferenceOpr;	
		this.clientReferenceVal = clientReferenceVal;		
		this.fromDateVal = fromDateVal;
		this.toDateVal = toDateVal;
		this.dateOpr = dateOpr;
		this.userId = userId;	
		this.searchOpr = searchOpr;
		this.searchVal = searchVal;
		this.groupOpr = groupOpr;		
	}

	protected ReportDto() {
	}






	
	public String getCompanyNameOpr() {
		return companyNameOpr;
	}

	public void setCompanyNameOpr(String companyNameOpr) {
		this.companyNameOpr = companyNameOpr;
	}

	public String getCompanyNameVal() {
		return companyNameVal;
	}

	public void setCompanyNameVal(String companyNameVal) {
		this.companyNameVal = companyNameVal;
	}

	public String getClientNameOpr() {
		return clientNameOpr;
	}

	public void setClientNameOpr(String clientNameOpr) {
		this.clientNameOpr = clientNameOpr;
	}

	public String getClientNameVal() {
		return clientNameVal;
	}

	public void setClientNameVal(String clientNameVal) {
		this.clientNameVal = clientNameVal;
	}

	
	
	public String getClientReferenceOpr() {
		return clientReferenceOpr;
	}

	public void setClientReferenceOpr(String clientReferenceOpr) {
		this.clientReferenceOpr = clientReferenceOpr;
	}

	public String getClientReferenceVal() {
		return clientReferenceVal;
	}

	public void setClientReferenceVal(String clientReferenceVal) {
		this.clientReferenceVal = clientReferenceVal;
	}

	public java.util.Date getFromDateVal() {
		return fromDateVal;
	}

	public void setFromDateVal(java.util.Date fromDateVal) {
		this.fromDateVal = fromDateVal;
	}

	public java.util.Date getToDateVal() {
		return toDateVal;
	}

	public void setToDateVal(java.util.Date toDateVal) {
		this.toDateVal = toDateVal;
	}

	public String getDateOpr() {
		return dateOpr;
	}

	public void setDateOpr(String dateOpr) {
		this.dateOpr = dateOpr;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	public String getSearchOpr() {
		return searchOpr;
	}
	public void setSearchOpr(String searchOpr) {
		this.searchOpr = searchOpr;
	}
	public String getSearchVal() {
		return searchVal;
	}
	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	
	
	
	public String getGroupOpr() {
		return groupOpr;
	}

	public void setGroupOpr(String groupOpr) {
		this.groupOpr = groupOpr;
	}

	
	
	
	@Override
	public String toString() {
		return "ReportDto [companyNameOpr=" + companyNameOpr + ", companyNameVal=" + companyNameVal + ", clientNameOpr="
				+ clientNameOpr + ", clientNameVal=" + clientNameVal + ", clientReferenceOpr=" + clientReferenceOpr
				+ ", clientReferenceVal=" + clientReferenceVal + ", fromDateVal=" + fromDateVal + ", toDateVal="
				+ toDateVal + ", dateOpr=" + dateOpr + ", userId=" + userId + ", searchOpr=" + searchOpr
				+ ", searchVal=" + searchVal + ", groupOpr=" + groupOpr + "]";
	}

	
	

	

}
