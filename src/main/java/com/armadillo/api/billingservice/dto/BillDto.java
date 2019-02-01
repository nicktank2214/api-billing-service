package com.armadillo.api.billingservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;





/**
 * Data Transfer Object 
 */
public class BillDto {

	
	
	

	@JsonProperty ("bill_id")	
	private Integer billId;


	@JsonProperty("client")
	private Integer client;

	@JsonProperty("bill_date")
	private Date billDate;

	@JsonProperty("subject_id")
	private String subjectId;

	@JsonProperty("product")
	private String product;

	@JsonProperty("product_detail")
	private String productDetail;

	@JsonProperty("bill_time")
	private Time billTime;

	@JsonProperty("subject_name")
	private String subjectName;

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("description")
	private String description;

	@JsonProperty("price")
	private BigDecimal price;

	@JsonProperty("vat")
	private BigDecimal vat;

	@JsonProperty("price_inc_vat")
	private BigDecimal priceIncVat;

	@JsonProperty("invoiced")
	private String invoiced;

	@JsonProperty("bill_type")
	private String billType;

	@JsonProperty("account")
	private String account;

	@JsonProperty("invoice")
	private Integer invoice;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("business_id")
	private String businessId;
	
	@JsonProperty("company_id")
	private String companyId;
	
	@JsonProperty("department_id")
	private String departmentId;
	
	
    
    
	public BillDto(
			Integer client,
			Date billDate,
			String subjectId,
			String product,
			String productDetail,
			Time billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			Integer invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId			
			) {
		this.client=client;
		this.billDate=billDate;
		this.subjectId=subjectId;
		this.product=product;
		this.productDetail=productDetail;
		this.billTime=billTime;
		this.subjectName=subjectName;
		this.reference=reference;
		this.description=description;
		this.price=price;
		this.vat=vat;
		this.priceIncVat=priceIncVat;
		this.invoiced=invoiced;
		this.billType=billType;
		this.account=account;
		this.invoice=invoice;
		this.country=country;		
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;			
	}
	public BillDto(
			Integer billId,			
			Integer client,
			Date billDate,
			String subjectId,
			String product,
			String productDetail,
			Time billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			Integer invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId			
			) {	
		this.billId=billId;		
		this.client=client;
		this.billDate=billDate;
		this.subjectId=subjectId;
		this.product=product;
		this.productDetail=productDetail;
		this.billTime=billTime;
		this.subjectName=subjectName;
		this.reference=reference;
		this.description=description;
		this.price=price;
		this.vat=vat;
		this.priceIncVat=priceIncVat;
		this.invoiced=invoiced;
		this.billType=billType;
		this.account=account;
		this.invoice=invoice;
		this.country=country;
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;			
	}
	protected BillDto() {
	}
	
	
	
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public Time getBillTime() {
		return billTime;
	}
	public void setBillTime(Time billTime) {
		this.billTime = billTime;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getVat() {
		return vat;
	}
	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}
	public BigDecimal getPriceIncVat() {
		return priceIncVat;
	}
	public void setPriceIncVat(BigDecimal priceIncVat) {
		this.priceIncVat = priceIncVat;
	}
	public String getInvoiced() {
		return invoiced;
	}
	public void setInvoiced(String invoiced) {
		this.invoiced = invoiced;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getInvoice() {
		return invoice;
	}
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
	@Override
	public String toString() {
		return "BillDto [billId=" + billId + ", client=" + client + ", billDate=" + billDate + ", subjectId="
				+ subjectId + ", product=" + product + ", productDetail=" + productDetail + ", billTime=" + billTime
				+ ", subjectName=" + subjectName + ", reference=" + reference + ", description=" + description
				+ ", price=" + price + ", vat=" + vat + ", priceIncVat=" + priceIncVat + ", invoiced=" + invoiced
				+ ", billType=" + billType + ", account=" + account + ", invoice=" + invoice + ", country=" + country
				+ ", businessId=" + businessId + ", companyId=" + companyId + ", departmentId=" + departmentId + "]";
	}
	
	


	
}
