package com.armadillo.api.billingservice.domain;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "contract_price")
public class ContractPrice implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue	
	@Column(name = "contractpriceid")
	private Integer contractPriceId;


	@Column(name = "account")
	private String account;

	@Column(name = "product")
	private String product;

	@Column(name = "country")
	private String country;
	
	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "vat")
	private BigDecimal vat;

	@Column(name = "discount_price")
	private BigDecimal discountPrice;

	@Column(name = "discount_vat")
	private BigDecimal discountVat;

	@Column(name = "discount_multiple")
	private Integer discountMultiple;

	@Column(name = "businessid")
	private String businessId;
	
	@Column(name = "companyid")
	private String companyId;
	
	@Column(name = "departmentid")
	private String departmentId;
	
	


	public ContractPrice(
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
	public ContractPrice(
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
	public ContractPrice() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((businessId == null) ? 0 : businessId.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((contractPriceId == null) ? 0 : contractPriceId.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((discountMultiple == null) ? 0 : discountMultiple.hashCode());
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
		result = prime * result + ((discountVat == null) ? 0 : discountVat.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((vat == null) ? 0 : vat.hashCode());
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
		ContractPrice other = (ContractPrice) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (businessId == null) {
			if (other.businessId != null)
				return false;
		} else if (!businessId.equals(other.businessId))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (contractPriceId == null) {
			if (other.contractPriceId != null)
				return false;
		} else if (!contractPriceId.equals(other.contractPriceId))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (discountMultiple == null) {
			if (other.discountMultiple != null)
				return false;
		} else if (!discountMultiple.equals(other.discountMultiple))
			return false;
		if (discountPrice == null) {
			if (other.discountPrice != null)
				return false;
		} else if (!discountPrice.equals(other.discountPrice))
			return false;
		if (discountVat == null) {
			if (other.discountVat != null)
				return false;
		} else if (!discountVat.equals(other.discountVat))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (vat == null) {
			if (other.vat != null)
				return false;
		} else if (!vat.equals(other.vat))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "ContractPrice [contractPriceId=" + contractPriceId + ", account=" + account + ", product=" + product
				+ ", country=" + country + ", price=" + price + ", vat=" + vat + ", discountPrice=" + discountPrice
				+ ", discountVat=" + discountVat + ", discountMultiple=" + discountMultiple + ", businessId="
				+ businessId + ", companyId=" + companyId + ", departmentId=" + departmentId + "]";
	}
	
	
	


}
