package com.armadillo.api.billingservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


/*
 * Notes
 * -----
 * 
 * Authenticating with JWTs -
 * We now have everything set up to use JWTs in our authentication process. 
 * We'll first take a look at the JWTLoginFilter class. 
 * This class will intercept POST requests on the /login path and attempt to authenticate the user. 
 * When the user is successfully authenticated, it will return a JWT in the Authorization header of the response. 
 * 
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public JWTLoginFilter(
			String url, 
			AuthenticationManager authManager
			) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	//During the authentication attempt, which is dealt by the attemptAuthentication method, 
	//we retrieve the username and password from the request. 
	//After they are retrieved, we use the AuthenticationManager to verify 
	//that these details match with an existing user. 
	//If it does, we enter the successfulAuthentication method. 
	//In this method we fetch the name from the authenticated user, 
	//and pass it on to TokenAuthenticationService, which will then add a JWT to the response.
	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest req, 
			HttpServletResponse res
			)	throws AuthenticationException, IOException, ServletException {
		
		//get username and password account credentials from http servlet request
		AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
		
		try {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" attemptAuthentication - creds [ username=" + creds.getUsername() + ", password="+ creds.getPassword()+ "]");
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" doFilter - Exception [ " + e.getMessage()+ "]");
		}
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						creds.getUsername(),
						creds.getPassword(),
						Collections.emptyList()
						)
				);
	}

	@Override
	protected void successfulAuthentication(
			HttpServletRequest req,
			HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		try {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" successfulAuthentication - auth [ name=" + auth.getName()+"]");
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" doFilter - Exception [ " + e.getMessage()+ "]");
		}
		
		TokenAuthenticationService.addAuthentication(res, auth.getName());
	}
}
