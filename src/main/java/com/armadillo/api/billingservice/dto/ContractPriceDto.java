package com.armadillo.api.billingservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;






/**
 * Data Transfer Object 
 */
public class ContractPriceDto {

	
	
	@JsonProperty("contract_price_id")
	private Integer contractPriceId;


	@JsonProperty("account")
	private String account;

	@JsonProperty("product")
	private String product;

	@JsonProperty("country")
	private String country;
	
	@JsonProperty("price")
	private BigDecimal price;

	@JsonProperty("vat")
	private BigDecimal vat;

	@JsonProperty("discount_price")
	private BigDecimal discountPrice;

	@JsonProperty("discount_vat")
	private BigDecimal discountVat;

	@JsonProperty("discount_multiple")
	private Integer discountMultiple;

	@JsonProperty("business_id")
	private String businessId;
	
	@JsonProperty("company_id")
	private String companyId;
	
	@JsonProperty("department_id")
	private String departmentId;
	
    
    
	public ContractPriceDto(
			Integer contractPriceId,
			String account,
			String product,
			String country,			
			BigDecimal price,
			BigDecimal vat,
			BigDecimal discountPrice,
			BigDecimal discountVat,
			Integer discountMultiple,
			String businessId,
			String companyId,
			String departmentId					
			) {
		this.contractPriceId=contractPriceId;
		this.account=account;
		this.product=product;
		this.country=country;		
		this.price=price;
		this.vat=vat;
		this.discountPrice=discountPrice;
		this.discountVat=discountVat;
		this.discountMultiple=discountMultiple;	
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;				
	}
	public ContractPriceDto(
			String account,
			String product,
			String country,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal discountPrice,
			BigDecimal discountVat,
			Integer discountMultiple,
			String businessId,
			String companyId,
			String departmentId					
			) {	
		this.account=account;
		this.product=product;
		this.country=country;
		this.price=price;
		this.vat=vat;
		this.discountPrice=discountPrice;
		this.discountVat=discountVat;
		this.discountMultiple=discountMultiple;		
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;				
	}
	protected ContractPriceDto() {
	}
	
	
	
	public Integer getContractPriceId() {
		return contractPriceId;
	}
	public void setContractPriceId(Integer contractPriceId) {
		this.contractPriceId = contractPriceId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
	public BigDecimal getDiscountVat() {
		return discountVat;
	}
	public void setDiscountVat(BigDecimal discountVat) {
		this.discountVat = discountVat;
	}
	public Integer getDiscountMultiple() {
		return discountMultiple;
	}
	public void setDiscountMultiple(Integer discountMultiple) {
		this.discountMultiple = discountMultiple;
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
		return "ContractPriceDto [contractPriceId=" + contractPriceId + ", account=" + account + ", product=" + product
				+ ", country=" + country + ", price=" + price + ", vat=" + vat + ", discountPrice=" + discountPrice
				+ ", discountVat=" + discountVat + ", discountMultiple=" + discountMultiple + ", businessId="
				+ businessId + ", companyId=" + companyId + ", departmentId=" + departmentId + "]";
	}
	
	
	
}
