package com.armadillo.api.billingservice.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "producttypedoc")
public class ProductTypeDoc implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue
	@Column (name="producttypedocid")	
	private Integer productTypeDocId;


	@Column(name = "producttype")
	private String productType;

	@Column(name = "description")
	private String description;

	@Column(name = "language")
	private String language;
	



	public ProductTypeDoc(
			String productType,
			String description,
			String language
			) {
		this.productType = productType;
		this.description = description;
		this.language = language;		
	}
	public ProductTypeDoc(
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
	public ProductTypeDoc() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((productTypeDocId == null) ? 0 : productTypeDocId.hashCode());
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
		ProductTypeDoc other = (ProductTypeDoc) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (productTypeDocId == null) {
			if (other.productTypeDocId != null)
				return false;
		} else if (!productTypeDocId.equals(other.productTypeDocId))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductDoc [productTypeDocId=" + productTypeDocId + ", productType=" + productType + ", description=" + description
				+ ", language=" + language + "]";
	}
	
	

}