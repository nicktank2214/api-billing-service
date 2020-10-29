package com.armadillo.api.billingservice.domain;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "product")
public class Product implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "product")
	private String product;


	@Column(name = "description")
	private String description;

	@Column(name = "default_price")
	private BigDecimal defaultPrice;

	@Column(name = "default_vat")
	private BigDecimal defaultVat;

	@Column(name = "level_1")
	private BigDecimal level1;

	@Column(name = "vatlevel_1")
	private BigDecimal vatLevel1;

	@Column(name = "level_2")
	private BigDecimal level2;

	@Column(name = "vatlevel_2")
	private BigDecimal vatLevel2;

	@Column(name = "level_3")
	private BigDecimal level3;

	@Column(name = "vatlevel_3")
	private BigDecimal vatLevel3;

	@Column(name = "level_4")
	private BigDecimal level4;

	@Column(name = "vatlevel_4")
	private BigDecimal vatLevel4;

	@Column(name = "level_5")
	private BigDecimal level5;

	@Column(name = "vatlevel_5")
	private BigDecimal vatLevel5;

	@Column(name = "level_6")
	private BigDecimal level6;

	@Column(name = "vatlevel_6")
	private BigDecimal vatLevel6;

	@Column(name = "level_7")
	private BigDecimal level7;

	@Column(name = "vatlevel_7")
	private BigDecimal vatLevel7;

	@Column(name = "level_8")
	private BigDecimal level8;	

	@Column(name = "vatlevel_8")
	private BigDecimal vatLevel8;

	@Column(name = "country")
	private String country;
	
	@Column(name = "credits")
	private BigDecimal credits;	
	
	

	public Product(
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
			BigDecimal vatLevel8,
			BigDecimal credits
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
		this.credits = credits;			
	}
	public Product(
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
			BigDecimal vatLevel8,
			BigDecimal credits	
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
		this.credits = credits;		
	}
	public Product() {
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
	public BigDecimal getCredits() {
		return credits;
	}
	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((defaultPrice == null) ? 0 : defaultPrice.hashCode());
		result = prime * result + ((defaultVat == null) ? 0 : defaultVat.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((level1 == null) ? 0 : level1.hashCode());
		result = prime * result + ((level2 == null) ? 0 : level2.hashCode());
		result = prime * result + ((level3 == null) ? 0 : level3.hashCode());
		result = prime * result + ((level4 == null) ? 0 : level4.hashCode());
		result = prime * result + ((level5 == null) ? 0 : level5.hashCode());
		result = prime * result + ((level6 == null) ? 0 : level6.hashCode());
		result = prime * result + ((level7 == null) ? 0 : level7.hashCode());
		result = prime * result + ((level8 == null) ? 0 : level8.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((vatLevel1 == null) ? 0 : vatLevel1.hashCode());
		result = prime * result + ((vatLevel2 == null) ? 0 : vatLevel2.hashCode());
		result = prime * result + ((vatLevel3 == null) ? 0 : vatLevel3.hashCode());
		result = prime * result + ((vatLevel4 == null) ? 0 : vatLevel4.hashCode());
		result = prime * result + ((vatLevel5 == null) ? 0 : vatLevel5.hashCode());
		result = prime * result + ((vatLevel6 == null) ? 0 : vatLevel6.hashCode());
		result = prime * result + ((vatLevel7 == null) ? 0 : vatLevel7.hashCode());
		result = prime * result + ((vatLevel8 == null) ? 0 : vatLevel8.hashCode());
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
		Product other = (Product) obj;
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
		if (defaultPrice == null) {
			if (other.defaultPrice != null)
				return false;
		} else if (!defaultPrice.equals(other.defaultPrice))
			return false;
		if (defaultVat == null) {
			if (other.defaultVat != null)
				return false;
		} else if (!defaultVat.equals(other.defaultVat))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (level1 == null) {
			if (other.level1 != null)
				return false;
		} else if (!level1.equals(other.level1))
			return false;
		if (level2 == null) {
			if (other.level2 != null)
				return false;
		} else if (!level2.equals(other.level2))
			return false;
		if (level3 == null) {
			if (other.level3 != null)
				return false;
		} else if (!level3.equals(other.level3))
			return false;
		if (level4 == null) {
			if (other.level4 != null)
				return false;
		} else if (!level4.equals(other.level4))
			return false;
		if (level5 == null) {
			if (other.level5 != null)
				return false;
		} else if (!level5.equals(other.level5))
			return false;
		if (level6 == null) {
			if (other.level6 != null)
				return false;
		} else if (!level6.equals(other.level6))
			return false;
		if (level7 == null) {
			if (other.level7 != null)
				return false;
		} else if (!level7.equals(other.level7))
			return false;
		if (level8 == null) {
			if (other.level8 != null)
				return false;
		} else if (!level8.equals(other.level8))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (vatLevel1 == null) {
			if (other.vatLevel1 != null)
				return false;
		} else if (!vatLevel1.equals(other.vatLevel1))
			return false;
		if (vatLevel2 == null) {
			if (other.vatLevel2 != null)
				return false;
		} else if (!vatLevel2.equals(other.vatLevel2))
			return false;
		if (vatLevel3 == null) {
			if (other.vatLevel3 != null)
				return false;
		} else if (!vatLevel3.equals(other.vatLevel3))
			return false;
		if (vatLevel4 == null) {
			if (other.vatLevel4 != null)
				return false;
		} else if (!vatLevel4.equals(other.vatLevel4))
			return false;
		if (vatLevel5 == null) {
			if (other.vatLevel5 != null)
				return false;
		} else if (!vatLevel5.equals(other.vatLevel5))
			return false;
		if (vatLevel6 == null) {
			if (other.vatLevel6 != null)
				return false;
		} else if (!vatLevel6.equals(other.vatLevel6))
			return false;
		if (vatLevel7 == null) {
			if (other.vatLevel7 != null)
				return false;
		} else if (!vatLevel7.equals(other.vatLevel7))
			return false;
		if (vatLevel8 == null) {
			if (other.vatLevel8 != null)
				return false;
		} else if (!vatLevel8.equals(other.vatLevel8))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [product=" + product + ", description=" + description + ", defaultPrice=" + defaultPrice
				+ ", defaultVat=" + defaultVat + ", level1=" + level1 + ", vatLevel1=" + vatLevel1 + ", level2="
				+ level2 + ", vatLevel2=" + vatLevel2 + ", level3=" + level3 + ", vatLevel3=" + vatLevel3 + ", level4="
				+ level4 + ", vatLevel4=" + vatLevel4 + ", level5=" + level5 + ", vatLevel5=" + vatLevel5 + ", level6="
				+ level6 + ", vatLevel6=" + vatLevel6 + ", level7=" + level7 + ", vatLevel7=" + vatLevel7 + ", level8="
				+ level8 + ", vatLevel8=" + vatLevel8 + ", country=" + country + ", credits=" + credits + "]";
	}
		
	


}
