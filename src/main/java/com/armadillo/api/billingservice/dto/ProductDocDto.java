package com.armadillo.api.billingservice.dto;


import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Data Transfer Object 
 */
public class ProductDocDto {



	@JsonProperty ("product_doc_id")	
	private Integer productDocId;


	@JsonProperty("product_type")
	private String productType;

	@JsonProperty("account")
	private String account;

	@JsonProperty("country")
	private String country;
	
	@JsonProperty("price")
	private BigDecimal price;
	
	@JsonProperty("cost")
	private BigDecimal cost;
	
	@JsonProperty("credits")
	private BigDecimal credits;	

	@JsonProperty("cost2")
	private BigDecimal cost2;
	@JsonProperty("cost3")
	private BigDecimal cost3;
	@JsonProperty("cost4")
	private BigDecimal cost4;
	@JsonProperty("cost5")
	private BigDecimal cost5;


	@JsonProperty("product_description")
	private String productDescription;
	
	
	
	public ProductDocDto(
			String productType,
			String account,
			String country,
			BigDecimal price,
			BigDecimal cost,
			BigDecimal credits,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5
			) {
		this.productType = productType;
		this.account = account;
		this.country = country;
		this.price = price;
		this.cost = cost;
		this.credits = credits;
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;
	}
	public ProductDocDto(
			Integer productDocId,	
			String productType,
			String account,
			String country,
			BigDecimal price,
			BigDecimal cost,
			BigDecimal credits,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5		
			) {
		this.productDocId = productDocId;	
		this.productType = productType;
		this.account = account;
		this.country = country;	
		this.price = price;
		this.cost = cost;
		this.credits = credits;	
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;		
	}
	public ProductDocDto() {
	}
	
	
	
	
	public Integer getProductDocId() {
		return productDocId;
	}
	public void setProductDocId(Integer productDocId) {
		this.productDocId = productDocId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getCredits() {
		return credits;
	}
	public void setCredits(BigDecimal credits) {
		this.credits = credits;
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductDocDto [productDocId=" + productDocId + ", productType=" + productType + ", account=" + account
				+ ", country=" + country + ", price=" + price + ", cost=" + cost + ", credits=" + credits + ", cost2="
				+ cost2 + ", cost3=" + cost3 + ", cost4=" + cost4 + ", cost5=" + cost5 + ", productDescription="
				+ productDescription + "]";
	}
	
	


	

}