package com.armadillo.api.billingservice.dto;


import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.format.annotation.DateTimeFormat;

import com.armadillo.api.billingservice.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;





/**
 */
public class ReportOutputDto {


	@JsonProperty("string_val1")
	private String stringVal1;

	@JsonProperty("string_val2")
	private String stringVal2;
	
	@JsonProperty("string_val3")
	private String stringVal3;

	@JsonProperty("string_val4")
	private String stringVal4;

	@JsonProperty("string_val5")
	private String stringVal5;

	@JsonProperty("string_val6")
	private String stringVal6;

	@JsonProperty("string_val7")
	private String stringVal7;

	@JsonProperty("string_val8")
	private String stringVal8;

	@JsonProperty("string_val9")
	private String stringVal9;
	
	@JsonProperty("string_val10")
	private String stringVal10;
	
	

	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("date_val1")
	private java.util.Date dateVal1;

	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("date_val2")
	private java.util.Date dateVal2;
	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("date_val3")
	private java.util.Date dateVal3;
	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("date_val4")
	private java.util.Date dateVal4;
	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-MM-dd", timezone=Constants.TIME_ZONE)
	// Allows yyyy-MM-dd date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("date_val5")
	private java.util.Date dateVal5;
	
	
	
	@JsonProperty("integer_val1")
	private BigInteger integerVal1;

	@JsonProperty("integer_val2")
	private BigInteger integerVal2;
	
	@JsonProperty("integer_val3")
	private BigInteger integerVal3;
	
	@JsonProperty("integer_val4")
	private BigInteger integerVal4;
	
	@JsonProperty("integer_val5")
	private BigInteger integerVal5;
	
	@JsonProperty("integer_val6")
	private BigInteger integerVal6;
	
	@JsonProperty("integer_val7")
	private BigInteger integerVal7;
	
	@JsonProperty("integer_val8")
	private BigInteger integerVal8;
	
	@JsonProperty("integer_val9")
	private BigInteger integerVal9;
	
	@JsonProperty("integer_val10")
	private BigInteger integerVal10;
	

	
	@JsonProperty("decimal_val1")
	private BigDecimal decimalVal1;

	@JsonProperty("decimal_val2")
	private BigDecimal decimalVal2;
	
	@JsonProperty("decimal_val3")
	private BigDecimal decimalVal3;
	
	@JsonProperty("decimal_val4")
	private BigDecimal decimalVal4;
	
	@JsonProperty("decimal_val5")
	private BigDecimal decimalVal5;
	
	@JsonProperty("decimal_val6")
	private BigDecimal decimalVal6;
	
	@JsonProperty("decimal_val7")
	private BigDecimal decimalVal7;
	
	@JsonProperty("decimal_val8")
	private BigDecimal decimalVal8;
	
	@JsonProperty("decimal_val9")
	private BigDecimal decimalVal9;
	
	@JsonProperty("decimal_val10")
	private BigDecimal decimalVal10;
	
	
	
	
	
	@JsonProperty("user_id")
	private String userId;    



	
	


	public ReportOutputDto() {
	}







	public String getStringVal1() {
		return stringVal1;
	}







	public void setStringVal1(String stringVal1) {
		this.stringVal1 = stringVal1;
	}







	public String getStringVal2() {
		return stringVal2;
	}







	public void setStringVal2(String stringVal2) {
		this.stringVal2 = stringVal2;
	}







	public String getStringVal3() {
		return stringVal3;
	}







	public void setStringVal3(String stringVal3) {
		this.stringVal3 = stringVal3;
	}







	public String getStringVal4() {
		return stringVal4;
	}







	public void setStringVal4(String stringVal4) {
		this.stringVal4 = stringVal4;
	}







	public String getStringVal5() {
		return stringVal5;
	}







	public void setStringVal5(String stringVal5) {
		this.stringVal5 = stringVal5;
	}







	public String getStringVal6() {
		return stringVal6;
	}







	public void setStringVal6(String stringVal6) {
		this.stringVal6 = stringVal6;
	}







	public String getStringVal7() {
		return stringVal7;
	}







	public void setStringVal7(String stringVal7) {
		this.stringVal7 = stringVal7;
	}







	public String getStringVal8() {
		return stringVal8;
	}







	public void setStringVal8(String stringVal8) {
		this.stringVal8 = stringVal8;
	}







	public String getStringVal9() {
		return stringVal9;
	}







	public void setStringVal9(String stringVal9) {
		this.stringVal9 = stringVal9;
	}







	public String getStringVal10() {
		return stringVal10;
	}







	public void setStringVal10(String stringVal10) {
		this.stringVal10 = stringVal10;
	}







	public java.util.Date getDateVal1() {
		return dateVal1;
	}







	public void setDateVal1(java.util.Date dateVal1) {
		this.dateVal1 = dateVal1;
	}







	public java.util.Date getDateVal2() {
		return dateVal2;
	}







	public void setDateVal2(java.util.Date dateVal2) {
		this.dateVal2 = dateVal2;
	}







	public java.util.Date getDateVal3() {
		return dateVal3;
	}







	public void setDateVal3(java.util.Date dateVal3) {
		this.dateVal3 = dateVal3;
	}







	public java.util.Date getDateVal4() {
		return dateVal4;
	}







	public void setDateVal4(java.util.Date dateVal4) {
		this.dateVal4 = dateVal4;
	}







	public java.util.Date getDateVal5() {
		return dateVal5;
	}







	public void setDateVal5(java.util.Date dateVal5) {
		this.dateVal5 = dateVal5;
	}







	public BigInteger getIntegerVal1() {
		return integerVal1;
	}







	public void setIntegerVal1(BigInteger integerVal1) {
		this.integerVal1 = integerVal1;
	}







	public BigInteger getIntegerVal2() {
		return integerVal2;
	}







	public void setIntegerVal2(BigInteger integerVal2) {
		this.integerVal2 = integerVal2;
	}







	public BigInteger getIntegerVal3() {
		return integerVal3;
	}







	public void setIntegerVal3(BigInteger integerVal3) {
		this.integerVal3 = integerVal3;
	}







	public BigInteger getIntegerVal4() {
		return integerVal4;
	}







	public void setIntegerVal4(BigInteger integerVal4) {
		this.integerVal4 = integerVal4;
	}







	public BigInteger getIntegerVal5() {
		return integerVal5;
	}







	public void setIntegerVal5(BigInteger integerVal5) {
		this.integerVal5 = integerVal5;
	}







	public BigInteger getIntegerVal6() {
		return integerVal6;
	}







	public void setIntegerVal6(BigInteger integerVal6) {
		this.integerVal6 = integerVal6;
	}







	public BigInteger getIntegerVal7() {
		return integerVal7;
	}







	public void setIntegerVal7(BigInteger integerVal7) {
		this.integerVal7 = integerVal7;
	}







	public BigInteger getIntegerVal8() {
		return integerVal8;
	}







	public void setIntegerVal8(BigInteger integerVal8) {
		this.integerVal8 = integerVal8;
	}







	public BigInteger getIntegerVal9() {
		return integerVal9;
	}







	public void setIntegerVal9(BigInteger integerVal9) {
		this.integerVal9 = integerVal9;
	}







	public BigInteger getIntegerVal10() {
		return integerVal10;
	}







	public void setIntegerVal10(BigInteger integerVal10) {
		this.integerVal10 = integerVal10;
	}







	public BigDecimal getDecimalVal1() {
		return decimalVal1;
	}







	public void setDecimalVal1(BigDecimal decimalVal1) {
		this.decimalVal1 = decimalVal1;
	}







	public BigDecimal getDecimalVal2() {
		return decimalVal2;
	}







	public void setDecimalVal2(BigDecimal decimalVal2) {
		this.decimalVal2 = decimalVal2;
	}







	public BigDecimal getDecimalVal3() {
		return decimalVal3;
	}







	public void setDecimalVal3(BigDecimal decimalVal3) {
		this.decimalVal3 = decimalVal3;
	}







	public BigDecimal getDecimalVal4() {
		return decimalVal4;
	}







	public void setDecimalVal4(BigDecimal decimalVal4) {
		this.decimalVal4 = decimalVal4;
	}







	public BigDecimal getDecimalVal5() {
		return decimalVal5;
	}







	public void setDecimalVal5(BigDecimal decimalVal5) {
		this.decimalVal5 = decimalVal5;
	}







	public BigDecimal getDecimalVal6() {
		return decimalVal6;
	}







	public void setDecimalVal6(BigDecimal decimalVal6) {
		this.decimalVal6 = decimalVal6;
	}







	public BigDecimal getDecimalVal7() {
		return decimalVal7;
	}







	public void setDecimalVal7(BigDecimal decimalVal7) {
		this.decimalVal7 = decimalVal7;
	}







	public BigDecimal getDecimalVal8() {
		return decimalVal8;
	}







	public void setDecimalVal8(BigDecimal decimalVal8) {
		this.decimalVal8 = decimalVal8;
	}







	public BigDecimal getDecimalVal9() {
		return decimalVal9;
	}







	public void setDecimalVal9(BigDecimal decimalVal9) {
		this.decimalVal9 = decimalVal9;
	}







	public BigDecimal getDecimalVal10() {
		return decimalVal10;
	}







	public void setDecimalVal10(BigDecimal decimalVal10) {
		this.decimalVal10 = decimalVal10;
	}







	public String getUserId() {
		return userId;
	}







	public void setUserId(String userId) {
		this.userId = userId;
	}







	@Override
	public String toString() {
		return "ReportOuputDto [stringVal1=" + stringVal1 + ", stringVal2=" + stringVal2 + ", stringVal3=" + stringVal3
				+ ", stringVal4=" + stringVal4 + ", stringVal5=" + stringVal5 + ", stringVal6=" + stringVal6
				+ ", stringVal7=" + stringVal7 + ", stringVal8=" + stringVal8 + ", stringVal9=" + stringVal9
				+ ", stringVal10=" + stringVal10 + ", dateVal1=" + dateVal1 + ", dateVal2=" + dateVal2 + ", dateVal3="
				+ dateVal3 + ", dateVal4=" + dateVal4 + ", dateVal5=" + dateVal5 + ", integerVal1=" + integerVal1
				+ ", integerVal2=" + integerVal2 + ", integerVal3=" + integerVal3 + ", integerVal4=" + integerVal4
				+ ", integerVal5=" + integerVal5 + ", integerVal6=" + integerVal6 + ", integerVal7=" + integerVal7
				+ ", integerVal8=" + integerVal8 + ", integerVal9=" + integerVal9 + ", integerVal10=" + integerVal10
				+ ", decimalVal1=" + decimalVal1 + ", decimalVal2=" + decimalVal2 + ", decimalVal3=" + decimalVal3
				+ ", decimalVal4=" + decimalVal4 + ", decimalVal5=" + decimalVal5 + ", decimalVal6=" + decimalVal6
				+ ", decimalVal7=" + decimalVal7 + ", decimalVal8=" + decimalVal8 + ", decimalVal9=" + decimalVal9
				+ ", decimalVal10=" + decimalVal10 + ", userId=" + userId + "]";
	}






	
	
	

	

}
