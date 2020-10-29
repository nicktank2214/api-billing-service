package com.armadillo.api.billingservice.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;



/**
 * Data Transfer Object for users
 */
public class CcyexrateDto {

	
    @JsonProperty("base")
    private String base;
    
    @JsonProperty("date")
    private String date;

    @JsonProperty("from_ccy")
    private String fromCcy;

    @JsonProperty("to_ccy")
    private String toCcy;

    @JsonProperty("ex_rate")
    private BigDecimal exRate;

    @JsonProperty("in_amount")
    private BigDecimal inAmount;
    
    @JsonProperty("out_amount")
    private BigDecimal outAmount;
    
    @JsonProperty("rates")    
    private Map<String, BigDecimal> rates = new TreeMap<>();
	
    
    
	public CcyexrateDto() {
		this.base = "";
		this.date = "";
		this.fromCcy = "";
		this.toCcy = "";
		this.exRate = new BigDecimal(0);
		this.inAmount = new BigDecimal(0);
		this.outAmount = new BigDecimal(0);
	}

	
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, BigDecimal> getRates() {
		return rates;
	}
	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}
	
	
	
	
	public String getFromCcy() {
		return fromCcy;
	}



	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}



	public String getToCcy() {
		return toCcy;
	}



	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}



	public BigDecimal getExRate() {
		return exRate;
	}



	public void setExRate(BigDecimal exRate) {
		this.exRate = exRate;
	}



	public BigDecimal getInAmount() {
		return inAmount;
	}



	public void setInAmount(BigDecimal inAmount) {
		this.inAmount = inAmount;
	}



	public BigDecimal getOutAmount() {
		return outAmount;
	}



	public void setOutAmount(BigDecimal outAmount) {
		this.outAmount = outAmount;
	}



	@Override
	public String toString() {
		return "CcyexrateDto [base=" + base + ", date=" + date + ", fromCcy=" + fromCcy + ", toCcy=" + toCcy
				+ ", exRate=" + exRate + ", inAmount=" + inAmount + ", outAmount=" + outAmount + ", rates=" + rates
				+ "]";
	}





	
}
