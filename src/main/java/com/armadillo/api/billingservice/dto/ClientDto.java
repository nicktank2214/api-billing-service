package com.armadillo.api.billingservice.dto;




import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;




/**
 * Data Transfer Object 
 */
public class ClientDto {

	
	

	@JsonProperty("client")
	private Integer client;


	@JsonProperty("password")
	private String password;

    @Size(max = 20)
	@JsonProperty("account")
	private String account;

	@JsonProperty("group_id")
	private Integer groupId;

	@JsonProperty("email")
	private String email;

	@JsonProperty("title")
	private String title;

	@JsonProperty("forename")
	private String forename;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("addr1")
	private String addr1;

	@JsonProperty("addr2")
	private String addr2;

	@JsonProperty("town")
	private String town;

	@JsonProperty("county")
	private String county;

	@JsonProperty("country")
	private String country;

	@JsonProperty("postcode")
	private String postcode;	

	@JsonProperty("company")
	private String company;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("fax")
	private String fax;

	@JsonProperty("cardholder_name")
	private String cardholderName;

    @Size(max = 3)
	@JsonProperty("save_card")
	private String saveCard;

	@JsonProperty("contact")
	private String contact;

	@JsonProperty("ch_monthfeedue")
	private Integer chMonthfeedue;

    @Size(max = 3)    
	@JsonProperty("ch_paid")
	private String chPaid;

    @Size(max = 3)
	@JsonProperty("ch_user")
	private String chUser;
	
	@JsonProperty("action_type")
	private String actionType;
	
	@JsonProperty("client_type")
	private String clientType;

	
	
    
	public ClientDto(
			Integer client,
			String password,
			String account,
			Integer groupId,
			String email,
			String title,
			String forename,
			String surname,
			String addr1,
			String addr2,
			String town,
			String county,
			String country,
			String postcode,	
			String company,
			String telephone,
			String fax,
			String cardholderName,
			String saveCard,
			String contact,
			Integer chMonthfeedue,
			String chPaid,
			String chUser,
			String clientType,
			String actionType
			) {
		this.client=client;
		this.password=password;
		this.account=account;
		this.groupId=groupId;
		this.email=email;
		this.title=title;
		this.forename=forename;
		this.surname=surname;
		this.addr1=addr1;
		this.addr2=addr2;
		this.town=town;
		this.county=county;
		this.country=country;
		this.postcode=postcode;	
		this.company=company;
		this.telephone=telephone;
		this.fax=fax;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.contact=contact;
		this.chMonthfeedue=chMonthfeedue;
		this.chPaid=chPaid;
		this.chUser=chUser;
		this.clientType=clientType;			
		this.actionType=actionType;
	}
	public ClientDto(
			String password,
			String account,
			Integer groupId,
			String email,
			String title,
			String forename,
			String surname,
			String addr1,
			String addr2,
			String town,
			String county,
			String country,
			String postcode,	
			String company,
			String telephone,
			String fax,
			String cardholderName,
			String saveCard,
			String contact,
			Integer chMonthfeedue,
			String chPaid,
			String chUser,
			String clientType,
			String actionType
			) {	
		this.password=password;
		this.account=account;
		this.groupId=groupId;
		this.email=email;
		this.title=title;
		this.forename=forename;
		this.surname=surname;
		this.addr1=addr1;
		this.addr2=addr2;
		this.town=town;
		this.county=county;
		this.country=country;
		this.postcode=postcode;	
		this.company=company;
		this.telephone=telephone;
		this.fax=fax;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.contact=contact;
		this.chMonthfeedue=chMonthfeedue;
		this.chPaid=chPaid;
		this.chUser=chUser;	
		this.clientType=clientType;			
		this.actionType=actionType;	
	}
	protected ClientDto() {
	}
	
	
	
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getChMonthfeedue() {
		return chMonthfeedue;
	}
	public void setChMonthfeedue(Integer chMonthfeedue) {
		this.chMonthfeedue = chMonthfeedue;
	}
	public String getChPaid() {
		return chPaid;
	}
	public void setChPaid(String chPaid) {
		this.chPaid = chPaid;
	}
	public String getChUser() {
		return chUser;
	}
	public void setChUser(String chUser) {
		this.chUser = chUser;
	}
	
	

	
	
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	
	
	@Override
	public String toString() {
		return "ClientDto [client=" + client + ", password=" + password + ", account=" + account + ", groupId="
				+ groupId + ", email=" + email + ", title=" + title + ", forename=" + forename + ", surname=" + surname
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", town=" + town + ", county=" + county + ", country="
				+ country + ", postcode=" + postcode + ", company=" + company + ", telephone=" + telephone + ", fax="
				+ fax + ", cardholderName=" + cardholderName + ", saveCard=" + saveCard + ", contact=" + contact
				+ ", chMonthfeedue=" + chMonthfeedue + ", chPaid=" + chPaid + ", chUser=" + chUser + ", actionType="
				+ actionType + ", clientType=" + clientType + "]";
	}
	
	
	
	


	
}
