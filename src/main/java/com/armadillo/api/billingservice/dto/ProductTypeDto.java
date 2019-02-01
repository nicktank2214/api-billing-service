package com.armadillo.api.billingservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;






/**
 * Data Transfer Object 
 */
public class ProductTypeDto {

	
	
	@JsonProperty("type")
	private String type;

	@JsonProperty("description")
	private String description;


   
    
	public ProductTypeDto(
			String type,
			String description
			) {
		this.type=type;
		this.description=description;	
	}
	protected ProductTypeDto() {
	}
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
	@Override
	public String toString() {
		return "ProductTypeDto [type=" + type + ", description=" + description + "]";
	}
	



	
}
