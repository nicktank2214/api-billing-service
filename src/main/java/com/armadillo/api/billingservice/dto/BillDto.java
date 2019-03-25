package com.armadillo.api.billingservice.dto;




import com.armadillo.api.billingservice.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;






/**
 * Data Transfer Object 
 */
public class BillDto {

	
	
	

	@JsonProperty ("bill_id")	
	private Integer billId;


	@JsonProperty("client")
	private Integer client;

	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("bill_date")
	private Date billDate;

	@JsonProperty("subject_id")
	private String subjectId;

	@JsonProperty("product")
	private String product;

	@JsonProperty("product_detail")
	private String productDetail;

	@JsonProperty("bill_time")
	private String billTime;

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
	private String invoice;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("business_id")
	private String businessId;
	
	@JsonProperty("company_id")
	private String companyId;
	
	@JsonProperty("department_id")
	private String departmentId;
	
	@JsonProperty("contract_price_id")
	private Integer contractPriceId;
	
	@JsonProperty("product_doc_id")
	private Integer productDocId;
	
	@JsonProperty("product_line_doc_id")
	private Integer productLineDocId;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("credits")
	private BigDecimal credits;
	
	@JsonProperty("client_name")
	private String clientName;
	
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("vat_exempt")
	private String vatExempt;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("product_type")
	private String productType;
	
	@JsonProperty("cost")
	private BigDecimal cost;
	
	@JsonProperty("invoice_id")
	private Integer invoiceId;

	
	@JsonProperty("cost2")
	private BigDecimal cost2;
	@JsonProperty("cost3")
	private BigDecimal cost3;
	@JsonProperty("cost4")
	private BigDecimal cost4;
	@JsonProperty("cost5")
	private BigDecimal cost5;


	@JsonProperty("cost_total")
	private BigDecimal costTotal;
	
	
	@JsonProperty("profit")
	private BigDecimal profit;

	@JsonProperty("count_total")
	private BigInteger countTotal;
	
	
	
	public BillDto(
			Integer client,
			Date billDate,
			String subjectId,
			String product,
			String productDetail,
			String billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			String invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId	,
			Integer contractPriceId,
			Integer productDocId,
			Integer productLineDocId,
			String userId,
			BigDecimal credits,
			String productType,
			BigDecimal cost,
			Integer invoiceId,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5
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
		this.contractPriceId=contractPriceId;
		this.productDocId=productDocId;
		this.productLineDocId=productLineDocId;	
		this.userId=userId;	
		this.credits=credits;
		this.productType=productType;	
		this.cost = cost;
		this.invoiceId = invoiceId;
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;		
	}
	public BillDto(
			Integer billId,			
			Integer client,
			Date billDate,
			String subjectId,
			String product,
			String productDetail,
			String billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			String invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId,
			Integer contractPriceId,
			Integer productDocId,
			Integer productLineDocId,
			String userId,
			BigDecimal credits,
			String productType,
			BigDecimal cost,
			Integer invoiceId,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5					
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
		this.contractPriceId=contractPriceId;
		this.productDocId=productDocId;
		this.productLineDocId=productLineDocId;
		this.userId=userId;	
		this.credits=credits;	
		this.productType=productType;	
		this.cost = cost;
		this.invoiceId = invoiceId;	
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;			
	}
	public BillDto() {
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
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
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
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
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
	
	
	
	public Integer getContractPriceId() {
		return contractPriceId;
	}
	public void setContractPriceId(Integer contractPriceId) {
		this.contractPriceId = contractPriceId;
	}
	
	
	
	
	public Integer getProductDocId() {
		return productDocId;
	}
	public void setProductDocId(Integer productDocId) {
		this.productDocId = productDocId;
	}
	public Integer getProductLineDocId() {
		return productLineDocId;
	}
	public void setProductLineDocId(Integer productLineDocId) {
		this.productLineDocId = productLineDocId;
	}
	
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getCredits() {
		return credits;
	}
	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getVatExempt() {
		return vatExempt;
	}
	public void setVatExempt(String vatExempt) {
		this.vatExempt = vatExempt;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	
	
	
	public BigDecimal getCost2() {
		return cost2;
	}
	public void setCost2(BigDecimal cost2) {
		this.cost2 = cost2;
	}
	public BigDecimal getCost3() {
		return cost3;
	}
	public void setCost3(BigDecimal cost3) {
		this.cost3 = cost3;
	}
	public BigDecimal getCost4() {
		return cost4;
	}
	public void setCost4(BigDecimal cost4) {
		this.cost4 = cost4;
	}
	public BigDecimal getCost5() {
		return cost5;
	}
	public void setCost5(BigDecimal cost5) {
		this.cost5 = cost5;
	}
	
	
	
	
	public BigDecimal getCostTotal() {
		return costTotal;
	}
	public void setCostTotal(BigDecimal costTotal) {
		this.costTotal = costTotal;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
	
	
	
	
	public BigInteger getCountTotal() {
		return countTotal;
	}
	public void setCountTotal(BigInteger countTotal) {
		this.countTotal = countTotal;
	}
	
	
	
	@Override
	public String toString() {
		return "BillDto [billId=" + billId + ", client=" + client + ", billDate=" + billDate + ", subjectId="
				+ subjectId + ", product=" + product + ", productDetail=" + productDetail + ", billTime=" + billTime
				+ ", subjectName=" + subjectName + ", reference=" + reference + ", description=" + description
				+ ", price=" + price + ", vat=" + vat + ", priceIncVat=" + priceIncVat + ", invoiced=" + invoiced
				+ ", billType=" + billType + ", account=" + account + ", invoice=" + invoice + ", country=" + country
				+ ", businessId=" + businessId + ", companyId=" + companyId + ", departmentId=" + departmentId
				+ ", contractPriceId=" + contractPriceId + ", productDocId=" + productDocId + ", productLineDocId="
				+ productLineDocId + ", userId=" + userId + ", credits=" + credits + ", clientName=" + clientName
				+ ", companyName=" + companyName + ", vatExempt=" + vatExempt + ", productName=" + productName
				+ ", productType=" + productType + ", cost=" + cost + ", invoiceId=" + invoiceId + ", cost2=" + cost2
				+ ", cost3=" + cost3 + ", cost4=" + cost4 + ", cost5=" + cost5 + ", costTotal=" + costTotal
				+ ", profit=" + profit + ", countTotal=" + countTotal + "]";
	}
	
	


	
}
