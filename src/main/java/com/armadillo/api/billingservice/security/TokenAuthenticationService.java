package com.armadillo.api.billingservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.armadillo.api.billingservice.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;



/*
 * Notes
 * -----
 * 
 * Creating a JWT Service on Spring Boot - 
 * Our JWT service will deal with the creation and verification of our tokens. 
 * In this example, we will create a token based on a username and an expiration time, 
 * and then sign it with a secret (using an HMAC). 
 * We will use io.jsonwebtoken.Jwts here for creating and verifying our tokens; 
 * they also provide a bunch of algorithms we can use to sign our secret.
 * 
 */
class TokenAuthenticationService {

	static void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + Constants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, Constants.SECRET)
				.compact();
		res.addHeader(Constants.HEADER_AUTHORIZATION, Constants.TOKEN_PREFIX + " " + JWT);
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		res.addHeader("Access-Control-Max-Age", "3600");
		res.addHeader("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
	            "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");		
		String resMessage = "{"+Constants.INFORMATION_001+","+"\"bearer_token\":\""+JWT+"\"}";
		try{res.getOutputStream().write(resMessage.getBytes());}catch(Exception e){}	
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(Constants.HEADER_AUTHORIZATION);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser()
					.setSigningKey(Constants.SECRET)
					.parseClaimsJws(token.replace(Constants.TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();

			return (user != null 
					? new UsernamePasswordAuthenticationToken(user, null, emptyList()) 
					: null);
		}
		return null;
	}
}
