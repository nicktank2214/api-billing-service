package com.armadillo.api.billingservice.dto;



import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 */
public class SystemCodeDto {


    
    @JsonProperty ("system_code_id")	
    private Integer systemCodeId;

    @JsonProperty ("code_type")
    private String codeType;

    @JsonProperty ("code_value")
    private String codeValue;
	
    @JsonProperty ("description")
    private String description;
    
	@Column (name="system_log_program")
    private String systemLogProgram;
	


	public SystemCodeDto(Integer systemCodeId, String codeType, String codeValue, String description, String systemLogProgram) {
		this.systemCodeId = systemCodeId;
		this.codeType = codeType;
		this.codeValue = codeValue;
		this.description = description;			
		this.systemLogProgram = systemLogProgram;
	}
	public SystemCodeDto(String codeType, String codeValue, String description, String systemLogProgram) {
		this.codeType = codeType;
		this.codeValue = codeValue;
		this.description = description;
		this.systemLogProgram = systemLogProgram;		
	}
	public SystemCodeDto() {
	}
	
	
	
	public Integer getSystemCodeId() {
		return systemCodeId;
	}
	public void setSystemCodeId(Integer systemCodeId) {
		this.systemCodeId = systemCodeId;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	public String getSystemLogProgram() {
		return systemLogProgram;
	}
	public void setSystemLogProgram(String systemLogProgram) {
		this.systemLogProgram = systemLogProgram;
	}
	
	
	
	
	@Override
	public String toString() {
		return "SystemCodeDto [systemCodeId=" + systemCodeId + ", codeType=" + codeType + ", codeValue=" + codeValue
				+ ", description=" + description + ", systemLogProgram=" + systemLogProgram + "]";
	}
	
	


	
}
