package com.armadillo.api.billingservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;






/**
 * Data Transfer Object 
 */
public class ProductDto {

	
	
	@JsonProperty("product")
	private String product;

	@JsonProperty("description")
	private String description;

	@JsonProperty("default_price")
	private BigDecimal defaultPrice;

	@JsonProperty("default_vat")
	private BigDecimal defaultVat;

	@JsonProperty("level_1")
	private BigDecimal level1;

	@JsonProperty("vatlevel_1")
	private BigDecimal vatLevel1;

	@JsonProperty("level_2")
	private BigDecimal level2;

	@JsonProperty("vatlevel_2")
	private BigDecimal vatLevel2;

	@JsonProperty("level_3")
	private BigDecimal level3;

	@JsonProperty("vatlevel_3")
	private BigDecimal vatLevel3;

	@JsonProperty("level_4")
	private BigDecimal level4;

	@JsonProperty("vatlevel_4")
	private BigDecimal vatLevel4;

	@JsonProperty("level_5")
	private BigDecimal level5;

	@JsonProperty("vatlevel_5")
	private BigDecimal vatLevel5;

	@JsonProperty("level_6")
	private BigDecimal level6;

	@JsonProperty("vatlevel_6")
	private BigDecimal vatLevel6;

	@JsonProperty("level_7")
	private BigDecimal level7;

	@JsonProperty("vatlevel_7")
	private BigDecimal vatLevel7;

	@JsonProperty("level_8")
	private BigDecimal level8;	

	@JsonProperty("vatlevel_8")
	private BigDecimal vatLevel8;
	
	

	


    
    
	public ProductDto(
			String description,
			BigDecimal defaultPrice,
			BigDecimal defaultVat,
			BigDecimal level1,
			BigDecimal vatLevel1,
			BigDecimal level2,
			BigDecimal vatLevel2,
			BigDecimal level3,
			BigDecimal vatLevel3,
			BigDecimal level4,
			BigDecimal vatLevel4,
			BigDecimal level5,
			BigDecimal vatLevel5,
			BigDecimal level6,
			BigDecimal vatLevel6,
			BigDecimal level7,
			BigDecimal vatLevel7,
			BigDecimal level8,
			BigDecimal vatLevel8
			) {
		this.description=description;
		this.defaultPrice=defaultPrice;
		this.defaultVat=defaultVat;
		this.level1=level1;
		this.vatLevel1=vatLevel1;	
		this.level2=level2;
		this.vatLevel2=vatLevel2;	
		this.level3=level3;
		this.vatLevel3=vatLevel3;	
		this.level4=level4;
		this.vatLevel4=vatLevel4;	
		this.level5=level5;
		this.vatLevel5=vatLevel5;	
		this.level6=level6;
		this.vatLevel6=vatLevel6;	
		this.level7=level7;
		this.vatLevel7=vatLevel7;	
		this.level8=level8;
		this.vatLevel8=vatLevel8;	
	}
	public ProductDto(
			String product,			
			String description,
			BigDecimal defaultPrice,
			BigDecimal defaultVat,
			BigDecimal level1,
			BigDecimal vatLevel1,
			BigDecimal level2,
			BigDecimal vatLevel2,
			BigDecimal level3,
			BigDecimal vatLevel3,
			BigDecimal level4,
			BigDecimal vatLevel4,
			BigDecimal level5,
			BigDecimal vatLevel5,
			BigDecimal level6,
			BigDecimal vatLevel6,
			BigDecimal level7,
			BigDecimal vatLevel7,
			BigDecimal level8,
			BigDecimal vatLevel8
			) {	
		this.product=product;		
		this.description=description;
		this.defaultPrice=defaultPrice;
		this.defaultVat=defaultVat;
		this.level1=level1;
		this.vatLevel1=vatLevel1;	
		this.level2=level2;
		this.vatLevel2=vatLevel2;	
		this.level3=level3;
		this.vatLevel3=vatLevel3;	
		this.level4=level4;
		this.vatLevel4=vatLevel4;	
		this.level5=level5;
		this.vatLevel5=vatLevel5;	
		this.level6=level6;
		this.vatLevel6=vatLevel6;	
		this.level7=level7;
		this.vatLevel7=vatLevel7;	
		this.level8=level8;
		this.vatLevel8=vatLevel8;			
	}
	protected ProductDto() {
	}
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	public BigDecimal getDefaultVat() {
		return defaultVat;
	}
	public void setDefaultVat(BigDecimal defaultVat) {
		this.defaultVat = defaultVat;
	}
	public BigDecimal getLevel1() {
		return level1;
	}
	public void setLevel1(BigDecimal level1) {
		this.level1 = level1;
	}
	public BigDecimal getVatLevel1() {
		return vatLevel1;
	}
	public void setVatLevel1(BigDecimal vatLevel1) {
		this.vatLevel1 = vatLevel1;
	}
	public BigDecimal getLevel2() {
		return level2;
	}
	public void setLevel2(BigDecimal level2) {
		this.level2 = level2;
	}
	public BigDecimal getVatLevel2() {
		return vatLevel2;
	}
	public void setVatLevel2(BigDecimal vatLevel2) {
		this.vatLevel2 = vatLevel2;
	}
	public BigDecimal getLevel3() {
		return level3;
	}
	public void setLevel3(BigDecimal level3) {
		this.level3 = level3;
	}
	public BigDecimal getVatLevel3() {
		return vatLevel3;
	}
	public void setVatLevel3(BigDecimal vatLevel3) {
		this.vatLevel3 = vatLevel3;
	}
	public BigDecimal getLevel4() {
		return level4;
	}
	public void setLevel4(BigDecimal level4) {
		this.level4 = level4;
	}
	public BigDecimal getVatLevel4() {
		return vatLevel4;
	}
	public void setVatLevel4(BigDecimal vatLevel4) {
		this.vatLevel4 = vatLevel4;
	}
	public BigDecimal getLevel5() {
		return level5;
	}
	public void setLevel5(BigDecimal level5) {
		this.level5 = level5;
	}
	public BigDecimal getVatLevel5() {
		return vatLevel5;
	}
	public void setVatLevel5(BigDecimal vatLevel5) {
		this.vatLevel5 = vatLevel5;
	}
	public BigDecimal getLevel6() {
		return level6;
	}
	public void setLevel6(BigDecimal level6) {
		this.level6 = level6;
	}
	public BigDecimal getVatLevel6() {
		return vatLevel6;
	}
	public void setVatLevel6(BigDecimal vatLevel6) {
		this.vatLevel6 = vatLevel6;
	}
	public BigDecimal getLevel7() {
		return level7;
	}
	public void setLevel7(BigDecimal level7) {
		this.level7 = level7;
	}
	public BigDecimal getVatLevel7() {
		return vatLevel7;
	}
	public void setVatLevel7(BigDecimal vatLevel7) {
		this.vatLevel7 = vatLevel7;
	}
	public BigDecimal getLevel8() {
		return level8;
	}
	public void setLevel8(BigDecimal level8) {
		this.level8 = level8;
	}
	public BigDecimal getVatLevel8() {
		return vatLevel8;
	}
	public void setVatLevel8(BigDecimal vatLevel8) {
		this.vatLevel8 = vatLevel8;
	}
	
	
	@Override
	public String toString() {
		return "ProductDto [product=" + product + ", description=" + description + ", defaultPrice=" + defaultPrice
				+ ", defaultVat=" + defaultVat + ", level1=" + level1 + ", vatLevel1=" + vatLevel1 + ", level2="
				+ level2 + ", vatLevel2=" + vatLevel2 + ", level3=" + level3 + ", vatLevel3=" + vatLevel3 + ", level4="
				+ level4 + ", vatLevel4=" + vatLevel4 + ", level5=" + level5 + ", vatLevel5=" + vatLevel5 + ", level6="
				+ level6 + ", vatLevel6=" + vatLevel6 + ", level7=" + level7 + ", vatLevel7=" + vatLevel7 + ", level8="
				+ level8 + ", vatLevel8=" + vatLevel8 + "]";
	}
	
	

	
}