package com.armadillo.api.billingservice.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "producttype")
public class ProductType implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "type")
	private String type;

	@Column(name = "description")
	private String description;

	


	public ProductType(
			String type,
			String description
			) {
		this.type=type;
		this.description=description;
	}
	public ProductType() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ProductType other = (ProductType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "ProductType [type=" + type + ", description=" + description + "]";
	}
	




}
