package com.armadillo.api.billingservice.domain;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "productdoc")
public class ProductDoc implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue
	@Column (name="productdocid")	
	private Integer productDocId;


	@Column(name = "producttype")
	private String productType;

	@Column(name = "account")
	private String account;

	@Column(name = "country")
	private String country;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "cost")
	private BigDecimal cost;
	
	@Column(name = "credits")
	private BigDecimal credits;	

	@Column(name = "cost2")
	private BigDecimal cost2;
	@Column(name = "cost3")
	private BigDecimal cost3;
	@Column(name = "cost4")
	private BigDecimal cost4;
	@Column(name = "cost5")
	private BigDecimal cost5;

	
	
	public ProductDoc(
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
	public ProductDoc(
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
	public ProductDoc() {
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((cost2 == null) ? 0 : cost2.hashCode());
		result = prime * result + ((cost3 == null) ? 0 : cost3.hashCode());
		result = prime * result + ((cost4 == null) ? 0 : cost4.hashCode());
		result = prime * result + ((cost5 == null) ? 0 : cost5.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productDocId == null) ? 0 : productDocId.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDoc other = (ProductDoc) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (cost2 == null) {
			if (other.cost2 != null)
				return false;
		} else if (!cost2.equals(other.cost2))
			return false;
		if (cost3 == null) {
			if (other.cost3 != null)
				return false;
		} else if (!cost3.equals(other.cost3))
			return false;
		if (cost4 == null) {
			if (other.cost4 != null)
				return false;
		} else if (!cost4.equals(other.cost4))
			return false;
		if (cost5 == null) {
			if (other.cost5 != null)
				return false;
		} else if (!cost5.equals(other.cost5))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (credits == null) {
			if (other.credits != null)
				return false;
		} else if (!credits.equals(other.credits))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productDocId == null) {
			if (other.productDocId != null)
				return false;
		} else if (!productDocId.equals(other.productDocId))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductDoc [productDocId=" + productDocId + ", productType=" + productType + ", account=" + account
				+ ", country=" + country + ", price=" + price + ", cost=" + cost + ", credits=" + credits + ", cost2="
				+ cost2 + ", cost3=" + cost3 + ", cost4=" + cost4 + ", cost5=" + cost5 + "]";
	}
	
	


}