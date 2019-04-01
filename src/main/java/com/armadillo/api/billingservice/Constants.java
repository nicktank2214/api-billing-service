package com.armadillo.api.billingservice;




/**
 */
public class Constants {


	public static final String TIME_ZONE = "Etc/GMT-1";
			
			

	//ERROR MESSAGES
	public static final String ERROR_MESSAGE_CODE_001 = "001";
	public static final String ERROR_MESSAGE_TEXT_001 = "RECORD NOT FOUND FOR ID:  ";
	public static final String ERROR_MESSAGE_TYPE_001 = "ERROR";			

	public static final String ERROR_MESSAGE_CODE_002 = "002";
	public static final String ERROR_MESSAGE_TEXT_002 = "USER NAME ALREADY EXISTS:  ";
	public static final String ERROR_MESSAGE_TYPE_002 = "ERROR";	
	
	public static final String ERROR_MESSAGE_CODE_003 = "003";
	public static final String ERROR_MESSAGE_TEXT_003 = "ID ALREADY EXISTS:  ";
	public static final String ERROR_MESSAGE_TYPE_003 = "ERROR";	

	
	public static final String ERROR_MESSAGE_CODE_010 = "010";
	public static final String ERROR_MESSAGE_TEXT_010 = "API CONNECTION ERROR:  ";
	public static final String ERROR_MESSAGE_TYPE_010 = "ERROR";	
	
	
	
	
	//INFORMATION MESSAGES
	public static final String INFORMATION_001 = 
			"\"message_code\":\"001\","
			+ "\"message_text\":\"Sucessfully Processed\","
			+ "\"message_type\":\"INFORMATION\""			
			;
	

	//TokenAuthenticationService Constants
	public static final long EXPIRATION_TIME = 86_400_000; // 1 days
	public static final String SECRET = "ThisIsASecret";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_CORS = "Access-Control-Allow-Origin";




}
