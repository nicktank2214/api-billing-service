package com.armadillo.api.billingservice.domain;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "bill")
public class Bill implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue
	@Column (name="billid")	
	private Integer billId;


	@Column(name = "client")
	private Integer client;

	@Column(name = "billdate")
	private java.util.Date billDate;

	@Column(name = "subject_id")
	private String subjectId;

	@Column(name = "product")
	private String product;

	@Column(name = "product_detail")
	private String productDetail;

	@Column(name = "billtime")
	private String billTime;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "reference")
	private String reference;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "vat")
	private BigDecimal vat;

	@Column(name = "price_inc_vat")
	private BigDecimal priceIncVat;

	@Column(name = "invoiced")
	private String invoiced;

	@Column(name = "billtype")
	private String billType;

	@Column(name = "account")
	private String account;

	@Column(name = "invoice")
	private String invoice;

	@Column(name = "country")
	private String country;

	@Column(name = "businessid")
	private String businessId;
	
	@Column(name = "companyid")
	private String companyId;
	
	@Column(name = "departmentid")
	private String departmentId;
	
	@Column(name = "contractpriceid")
	private Integer contractPriceId;
	
	@Column(name = "productdocid")
	private Integer productDocId;
	
	@Column(name = "productlinedocid")
	private Integer productLineDocId;

	@Column(name = "userid")
	private String userId;
	
	@Column(name = "credits")
	private BigDecimal credits;

	@Column(name = "producttype")
	private String productType;
	
	@Column(name = "cost")
	private BigDecimal cost;

	@Column(name = "invoiceid")
	private Integer invoiceId;

	@Column(name = "cost2")
	private BigDecimal cost2;
	@Column(name = "cost3")
	private BigDecimal cost3;
	@Column(name = "cost4")
	private BigDecimal cost4;
	@Column(name = "cost5")
	private BigDecimal cost5;
	
	@Column(name = "clientname")
	private String clientName;
	
	

	public Bill(
			Integer client,
			java.util.Date billDate,
			String subjectId,
			String product,
			String productDetail,
			String billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			String invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId,
			Integer contractPriceId,
			Integer productDocId,
			Integer productLineDocId,
			String userId,
			BigDecimal credits,
			String productType,
			BigDecimal cost,
			Integer invoiceId,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5,
			String clientName
			) {
		this.client=client;
		this.billDate=billDate;
		this.subjectId=subjectId;
		this.product=product;
		this.productDetail=productDetail;
		this.billTime=billTime;
		this.subjectName=subjectName;
		this.reference=reference;
		this.description=description;
		this.price=price;
		this.vat=vat;
		this.priceIncVat=priceIncVat;
		this.invoiced=invoiced;
		this.billType=billType;
		this.account=account;
		this.invoice=invoice;
		this.country=country;
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;
		this.contractPriceId=contractPriceId;
		this.productDocId=productDocId;
		this.productLineDocId=productLineDocId;
		this.userId=userId;	
		this.credits=credits;
		this.productType = productType;
		this.cost = cost;
		this.invoiceId = invoiceId;
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;		
		this.clientName = clientName;
	}
	public Bill(
			Integer billId,			
			Integer client,
			java.util.Date billDate,
			String subjectId,
			String product,
			String productDetail,
			String billTime,
			String subjectName,
			String reference,
			String description,
			BigDecimal price,
			BigDecimal vat,
			BigDecimal priceIncVat,
			String invoiced,
			String billType,
			String account,
			String invoice,
			String country,
			String businessId,
			String companyId,
			String departmentId,
			Integer contractPriceId,
			Integer productDocId,
			Integer productLineDocId,
			String userId,
			BigDecimal credits,
			String productType,
			BigDecimal cost,
			Integer invoiceId,
			BigDecimal cost2,
			BigDecimal cost3,
			BigDecimal cost4,
			BigDecimal cost5,
			String clientName
			) {
		this.billId=billId;		
		this.client=client;
		this.billDate=billDate;
		this.subjectId=subjectId;
		this.product=product;
		this.productDetail=productDetail;
		this.billTime=billTime;
		this.subjectName=subjectName;
		this.reference=reference;
		this.description=description;
		this.price=price;
		this.vat=vat;
		this.priceIncVat=priceIncVat;
		this.invoiced=invoiced;
		this.billType=billType;
		this.account=account;
		this.invoice=invoice;
		this.country=country;
		this.businessId=businessId;
		this.companyId=companyId;
		this.departmentId=departmentId;	
		this.contractPriceId=contractPriceId;	
		this.productDocId=productDocId;
		this.productLineDocId=productLineDocId;	
		this.userId=userId;	
		this.credits=credits;
		this.productType = productType;	
		this.cost = cost;
		this.invoiceId = invoiceId;	
		this.cost2 = cost2;
		this.cost3 = cost3;
		this.cost4 = cost4;
		this.cost5 = cost5;
		this.clientName = clientName;		
	}
	public Bill() {
	}
	
	
	
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public java.util.Date getBillDate() {
		return billDate;
	}
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public BigDecimal getPriceIncVat() {
		return priceIncVat;
	}
	public void setPriceIncVat(BigDecimal priceIncVat) {
		this.priceIncVat = priceIncVat;
	}
	public String getInvoiced() {
		return invoiced;
	}
	public void setInvoiced(String invoiced) {
		this.invoiced = invoiced;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	

	
	
	
	public Integer getContractPriceId() {
		return contractPriceId;
	}
	public void setContractPriceId(Integer contractPriceId) {
		this.contractPriceId = contractPriceId;
	}
	

	
	public Integer getProductDocId() {
		return productDocId;
	}
	public void setProductDocId(Integer productDocId) {
		this.productDocId = productDocId;
	}
	public Integer getProductLineDocId() {
		return productLineDocId;
	}
	public void setProductLineDocId(Integer productLineDocId) {
		this.productLineDocId = productLineDocId;
	}
	

	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getCredits() {
		return credits;
	}
	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}
	
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
	
	
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
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
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((billTime == null) ? 0 : billTime.hashCode());
		result = prime * result + ((billType == null) ? 0 : billType.hashCode());
		result = prime * result + ((businessId == null) ? 0 : businessId.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((contractPriceId == null) ? 0 : contractPriceId.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((cost2 == null) ? 0 : cost2.hashCode());
		result = prime * result + ((cost3 == null) ? 0 : cost3.hashCode());
		result = prime * result + ((cost4 == null) ? 0 : cost4.hashCode());
		result = prime * result + ((cost5 == null) ? 0 : cost5.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		result = prime * result + ((invoiced == null) ? 0 : invoiced.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceIncVat == null) ? 0 : priceIncVat.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productDetail == null) ? 0 : productDetail.hashCode());
		result = prime * result + ((productDocId == null) ? 0 : productDocId.hashCode());
		result = prime * result + ((productLineDocId == null) ? 0 : productLineDocId.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Bill other = (Bill) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (billTime == null) {
			if (other.billTime != null)
				return false;
		} else if (!billTime.equals(other.billTime))
			return false;
		if (billType == null) {
			if (other.billType != null)
				return false;
		} else if (!billType.equals(other.billType))
			return false;
		if (businessId == null) {
			if (other.businessId != null)
				return false;
		} else if (!businessId.equals(other.businessId))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
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
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (invoiced == null) {
			if (other.invoiced != null)
				return false;
		} else if (!invoiced.equals(other.invoiced))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceIncVat == null) {
			if (other.priceIncVat != null)
				return false;
		} else if (!priceIncVat.equals(other.priceIncVat))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productDetail == null) {
			if (other.productDetail != null)
				return false;
		} else if (!productDetail.equals(other.productDetail))
			return false;
		if (productDocId == null) {
			if (other.productDocId != null)
				return false;
		} else if (!productDocId.equals(other.productDocId))
			return false;
		if (productLineDocId == null) {
			if (other.productLineDocId != null)
				return false;
		} else if (!productLineDocId.equals(other.productLineDocId))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
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
		return "Bill [billId=" + billId + ", client=" + client + ", billDate=" + billDate + ", subjectId=" + subjectId
				+ ", product=" + product + ", productDetail=" + productDetail + ", billTime=" + billTime
				+ ", subjectName=" + subjectName + ", reference=" + reference + ", description=" + description
				+ ", price=" + price + ", vat=" + vat + ", priceIncVat=" + priceIncVat + ", invoiced=" + invoiced
				+ ", billType=" + billType + ", account=" + account + ", invoice=" + invoice + ", country=" + country
				+ ", businessId=" + businessId + ", companyId=" + companyId + ", departmentId=" + departmentId
				+ ", contractPriceId=" + contractPriceId + ", productDocId=" + productDocId + ", productLineDocId="
				+ productLineDocId + ", userId=" + userId + ", credits=" + credits + ", productType=" + productType
				+ ", cost=" + cost + ", invoiceId=" + invoiceId + ", cost2=" + cost2 + ", cost3=" + cost3 + ", cost4="
				+ cost4 + ", cost5=" + cost5 + ", clientName=" + clientName + "]";
	}
	
	
	
	


	
}