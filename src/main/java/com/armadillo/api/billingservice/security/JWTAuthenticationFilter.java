package com.armadillo.api.billingservice.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/*
 * Notes
 * -----
 * 
 * Now we will implement the JWTAuthenticationFilter class -
 * What this filter does is to intercept all requests to validate the 
 * presence of the JWT–that is, the ones that are not issued to / nor /users. 
 * This validation is done with the help of the TokenAuthenticationService class.
 * 
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response,
			FilterChain filterChain
			) throws IOException, ServletException {
		Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest)request);
		
		try {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" doFilter - authentication [ name=" + authentication.getName() + ", details="+ authentication.getDetails()+ "]");
		} catch (Exception e) {
			log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
					" doFilter - Exception [ " + e.getMessage()+ "]");			
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request,response);
	}
	
}
