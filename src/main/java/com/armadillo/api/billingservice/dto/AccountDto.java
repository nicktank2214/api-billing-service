package com.armadillo.api.billingservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import javax.validation.constraints.Size;




/**
 * Data Transfer Object 
 */
public class AccountDto {

		
	

	@JsonProperty("account")
	private String account;

	@JsonProperty("partner")
	private String partner;

    @Size(max = 10)
	@JsonProperty("sales_id")
	private String salesId;

    @Size(max = 10)
	@JsonProperty("card_type")
	private String cardType;

    @Size(max = 20)
	@JsonProperty("card_number")
	private String cardNumber;

	@JsonProperty("card_validfrom")
	private String cardValidfrom;

	@JsonProperty("card_expiry")
	private String cardExpiry;

    @Size(max = 3)
	@JsonProperty("switch_number")
	private String switchNumber;

	@JsonProperty("cardholder_name")
	private String cardholderName;

    @Size(max = 3)
	@JsonProperty("save_card")
	private String saveCard;

	@JsonProperty("billing_company")
	private String billingCompany;

	@JsonProperty("billing_telephone")
	private String billingTelephone;

	@JsonProperty("billing_fax")
	private String billingFax;

	@JsonProperty("billing_addr1")
	private String billingAddr1;

	@JsonProperty("billing_addr2")
	private String billingAddr2;

	@JsonProperty("billing_town")
	private String billingTown;

	@JsonProperty("billing_county")
	private String billingCounty;

	@JsonProperty("billing_country")
	private String billingCountry;

	@JsonProperty("billing_postcode")
	private String billingPostcode;

	@JsonProperty("billing_contact")
	private String billingContact;

	@JsonProperty("billing_email")
	private String billingEmail;

	@JsonProperty("billing_email_cc")
	private String billingEmailCc;

	@JsonProperty("invoice_period")
	private String invoicePeriod;

    @Size(max = 20)
	@JsonProperty("payment_type")
	private String paymentType;

	@JsonProperty("vat_number")
	private String vatNumber;

    @Size(max = 3)
	@JsonProperty("vat_exempt")
	private String vatExempt;

	@JsonProperty("price_band")
	private Integer priceBand;

    @Size(max = 3)    
	@JsonProperty("good_customer")
	private String goodCustomer;

	@JsonProperty("international_discount_percent")
	private BigDecimal internationalDiscountpercent;

	@JsonProperty("companies_house_discount_percent")
	private BigDecimal companieshouseDiscountpercent;

    @Size(max = 20)
	@JsonProperty("invoice_method")
	private String invoiceMethod;
	
	@JsonProperty("action_type")
	private String actionType;
	
	@JsonProperty("account_type")
	private String accountType;
	
	
    
    
	public AccountDto(
			String account,
			String partner,
			String salesId,
			String cardType,
			String cardNumber,
			String cardValidfrom,
			String cardExpiry,
			String switchNumber,
			String cardholderName,
			String saveCard,
			String billingCompany,
			String billingTelephone,
			String billingFax,
			String billingAddr1,
			String billingAddr2,
			String billingTown,
			String billingCounty,
			String billingCountry,
			String billingPostcode,
			String billingContact,
			String billingEmail,
			String billingEmailCc,
			String invoicePeriod,
			String paymentType,
			String vatNumber,
			String vatExempt,
			Integer priceBand,
			String goodCustomer,
			BigDecimal internationalDiscountpercent,
			BigDecimal companieshouseDiscountpercent,
			String invoiceMethod,
			String accountType,
			String actionType
			) {
		this.account=account;		
		this.partner=partner;
		this.salesId=salesId;
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.cardValidfrom=cardValidfrom;
		this.cardExpiry=cardExpiry;
		this.switchNumber=switchNumber;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.billingCompany=billingCompany;
		this.billingTelephone=billingTelephone;
		this.billingFax=billingFax;
		this.billingAddr1=billingAddr1;
		this.billingAddr2=billingAddr2;
		this.billingTown=billingTown;
		this.billingCounty=billingCounty;
		this.billingCountry=billingCountry;
		this.billingPostcode=billingPostcode;
		this.billingContact=billingContact;
		this.billingEmail=billingEmail;
		this.billingEmailCc=billingEmailCc;
		this.invoicePeriod=invoicePeriod;
		this.paymentType=paymentType;
		this.vatNumber=vatNumber;
		this.vatExempt=vatExempt;
		this.priceBand=priceBand;
		this.goodCustomer=goodCustomer;
		this.internationalDiscountpercent=internationalDiscountpercent;
		this.companieshouseDiscountpercent=companieshouseDiscountpercent;
		this.invoiceMethod=invoiceMethod;
		this.accountType=accountType;			
		this.actionType=actionType;		
	}
	public AccountDto(
			String partner,
			String salesId,
			String cardType,
			String cardNumber,
			String cardValidfrom,
			String cardExpiry,
			String switchNumber,
			String cardholderName,
			String saveCard,
			String billingCompany,
			String billingTelephone,
			String billingFax,
			String billingAddr1,
			String billingAddr2,
			String billingTown,
			String billingCounty,
			String billingCountry,
			String billingPostcode,
			String billingContact,
			String billingEmail,
			String billingEmailCc,
			String invoicePeriod,
			String paymentType,
			String vatNumber,
			String vatExempt,
			Integer priceBand,
			String goodCustomer,
			BigDecimal internationalDiscountpercent,
			BigDecimal companieshouseDiscountpercent,
			String invoiceMethod,
			String accountType,			
			String actionType
			) {	
		this.partner=partner;
		this.salesId=salesId;
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.cardValidfrom=cardValidfrom;
		this.cardExpiry=cardExpiry;
		this.switchNumber=switchNumber;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.billingCompany=billingCompany;
		this.billingTelephone=billingTelephone;
		this.billingFax=billingFax;
		this.billingAddr1=billingAddr1;
		this.billingAddr2=billingAddr2;
		this.billingTown=billingTown;
		this.billingCounty=billingCounty;
		this.billingCountry=billingCountry;
		this.billingPostcode=billingPostcode;
		this.billingContact=billingContact;
		this.billingEmail=billingEmail;
		this.billingEmailCc=billingEmailCc;
		this.invoicePeriod=invoicePeriod;
		this.paymentType=paymentType;
		this.vatNumber=vatNumber;
		this.vatExempt=vatExempt;
		this.priceBand=priceBand;
		this.goodCustomer=goodCustomer;
		this.internationalDiscountpercent=internationalDiscountpercent;
		this.companieshouseDiscountpercent=companieshouseDiscountpercent;
		this.invoiceMethod=invoiceMethod;
		this.accountType=accountType;			
		this.actionType=actionType;		
	}
	protected AccountDto() {
	}
	
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardValidfrom() {
		return cardValidfrom;
	}
	public void setCardValidfrom(String cardValidfrom) {
		this.cardValidfrom = cardValidfrom;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getSwitchNumber() {
		return switchNumber;
	}
	public void setSwitchNumber(String switchNumber) {
		this.switchNumber = switchNumber;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public String getSaveCard() {
		return saveCard;
	}
	public void setSaveCard(String saveCard) {
		this.saveCard = saveCard;
	}
	public String getBillingCompany() {
		return billingCompany;
	}
	public void setBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
	}
	public String getBillingTelephone() {
		return billingTelephone;
	}
	public void setBillingTelephone(String billingTelephone) {
		this.billingTelephone = billingTelephone;
	}
	public String getBillingFax() {
		return billingFax;
	}
	public void setBillingFax(String billingFax) {
		this.billingFax = billingFax;
	}
	public String getBillingAddr1() {
		return billingAddr1;
	}
	public void setBillingAddr1(String billingAddr1) {
		this.billingAddr1 = billingAddr1;
	}
	public String getBillingAddr2() {
		return billingAddr2;
	}
	public void setBillingAddr2(String billingAddr2) {
		this.billingAddr2 = billingAddr2;
	}
	public String getBillingTown() {
		return billingTown;
	}
	public void setBillingTown(String billingTown) {
		this.billingTown = billingTown;
	}
	public String getBillingCounty() {
		return billingCounty;
	}
	public void setBillingCounty(String billingCounty) {
		this.billingCounty = billingCounty;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingPostcode() {
		return billingPostcode;
	}
	public void setBillingPostcode(String billingPostcode) {
		this.billingPostcode = billingPostcode;
	}
	public String getBillingContact() {
		return billingContact;
	}
	public void setBillingContact(String billingContact) {
		this.billingContact = billingContact;
	}
	public String getBillingEmail() {
		return billingEmail;
	}
	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}
	public String getBillingEmailCc() {
		return billingEmailCc;
	}
	public void setBillingEmailCc(String billingEmailCc) {
		this.billingEmailCc = billingEmailCc;
	}
	public String getInvoicePeriod() {
		return invoicePeriod;
	}
	public void setInvoicePeriod(String invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getVatExempt() {
		return vatExempt;
	}
	public void setVatExempt(String vatExempt) {
		this.vatExempt = vatExempt;
	}
	public Integer getPriceBand() {
		return priceBand;
	}
	public void setPriceBand(Integer priceBand) {
		this.priceBand = priceBand;
	}
	public String getGoodCustomer() {
		return goodCustomer;
	}
	public void setGoodCustomer(String goodCustomer) {
		this.goodCustomer = goodCustomer;
	}
	public BigDecimal getInternationalDiscountpercent() {
		return internationalDiscountpercent;
	}
	public void setInternationalDiscountpercent(BigDecimal internationalDiscountpercent) {
		this.internationalDiscountpercent = internationalDiscountpercent;
	}
	public BigDecimal getCompanieshouseDiscountpercent() {
		return companieshouseDiscountpercent;
	}
	public void setCompanieshouseDiscountpercent(BigDecimal companieshouseDiscountpercent) {
		this.companieshouseDiscountpercent = companieshouseDiscountpercent;
	}
	public String getInvoiceMethod() {
		return invoiceMethod;
	}
	public void setInvoiceMethod(String invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
	}
	
	
	
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionType() {
		return actionType;
	}
	
	
	
	@Override
	public String toString() {
		return "AccountDto [account=" + account + ", partner=" + partner + ", salesId=" + salesId + ", cardType="
				+ cardType + ", cardNumber=" + cardNumber + ", cardValidfrom=" + cardValidfrom + ", cardExpiry="
				+ cardExpiry + ", switchNumber=" + switchNumber + ", cardholderName=" + cardholderName + ", saveCard="
				+ saveCard + ", billingCompany=" + billingCompany + ", billingTelephone=" + billingTelephone
				+ ", billingFax=" + billingFax + ", billingAddr1=" + billingAddr1 + ", billingAddr2=" + billingAddr2
				+ ", billingTown=" + billingTown + ", billingCounty=" + billingCounty + ", billingCountry="
				+ billingCountry + ", billingPostcode=" + billingPostcode + ", billingContact=" + billingContact
				+ ", billingEmail=" + billingEmail + ", billingEmailCc=" + billingEmailCc + ", invoicePeriod="
				+ invoicePeriod + ", paymentType=" + paymentType + ", vatNumber=" + vatNumber + ", vatExempt="
				+ vatExempt + ", priceBand=" + priceBand + ", goodCustomer=" + goodCustomer
				+ ", internationalDiscountpercent=" + internationalDiscountpercent + ", companieshouseDiscountpercent="
				+ companieshouseDiscountpercent + ", invoiceMethod=" + invoiceMethod + ", actionType=" + actionType
				+ ", accountType=" + accountType + "]";
	}



	
}
