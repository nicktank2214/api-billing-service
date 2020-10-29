package com.armadillo.api.billingservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object 
 */
public class ProductTypeDocDto {



	@JsonProperty ("product_type_doc_id")	
	private Integer productTypeDocId;


	@JsonProperty("product_type")
	private String productType;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;
	



	public ProductTypeDocDto(
			String productType,
			String description,
			String language
			) {
		this.productType = productType;
		this.description = description;
		this.language = language;		
	}
	public ProductTypeDocDto(
			Integer productTypeDocId,	
			String productType,
			String description,
			String language
			) {
		this.productTypeDocId = productTypeDocId;	
		this.productType = productType;
		this.description = description;
		this.language = language;	
	}
	public ProductTypeDocDto() {
	}
	
	
	
	
	public Integer getProductTypeDocId() {
		return productTypeDocId;
	}
	public void setProductTypeDocId(Integer productTypeDocId) {
		this.productTypeDocId = productTypeDocId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

	
	@Override
	public String toString() {
		return "ProductTypeDoc [productTypeDocId=" + productTypeDocId + ", productType=" + productType + ", description=" + description
				+ ", language=" + language + "]";
	}
	
	

}