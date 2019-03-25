package com.armadillo.api.billingservice.security;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




/* 
 * Notes
 * -----
 * 
 * We are ready to start securing our routes. 
 * First of all, we want to avoid exposing /users to everyone, 
 * so we will create a configuration that restricts its access. 
 * We will accomplish this by adding a new class called WebSecurityConfig 
 * that extends the WebSecurityConfigurerAdapter class from Spring Security. 
 * 
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Autowired
	private DataSource dataSource;



	private final String USERS_QUERY = "select UserName, Password, ActiveFlag from users where UserName=?";
	private final String ROLES_QUERY = 
			"select u.UserName, ur.Role " + 
					"from userrole ur " + 
					"inner join users u on u.UserId = ur.UserId " + 
					"where u.UserName=?";




	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Here we have decided that everyone can access the / route, 
		//and that the /login route is only publicly available for POST requests. 
		//For all other routes, authentication is required.
		http.cors().and()
			.csrf().disable()			
			//There are multiple children to the http.authorizeRequests() method 
			//each matcher is considered in the order they were declared.			
			.authorizeRequests()
				.antMatchers("/").permitAll()
				//.antMatchers(HttpMethod.POST, "/login").permitAll()	 	            
				.anyRequest().authenticated()
				.and()
		//We will create them soon, but their goal is to filter for the /login route, 
		//and every other route, to decide what should happen when someone access these routes. 
		//In this class, we also added a default account that we can use to test our application.		
		// We filter the api/login requests
				//.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),	UsernamePasswordAuthenticationFilter.class)
		// And filter other requests to check the presence of JWT in header
				.addFilterBefore(new JWTAuthenticationFilter(),	UsernamePasswordAuthenticationFilter.class)
				;
		//The great thing here is that we have now secured our application 
		//without having to change code for existing routes. 
		//We did not alter our previously created Controllers, nor did we have to write any xml-configuration.

	}


	//You can also exclude some parts of the application from authentication by configuring the WebSecurity. 
	//Note that configuring the WebSecurity is not tied to one of the HttpSecurity
	//configurations as those add their own filter chain, only the order might be different. 
	//If you add a pattern in both configurations it will even operate on the same instance of WebSecurity.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        	.antMatchers("/user/**")
        	.antMatchers("/userrole/**")
        	.antMatchers("/systemcode/**")
			.antMatchers(HttpMethod.GET, "/**")
			//.antMatchers(HttpMethod.POST, "/**")	 			
        	;
    }
    

	/** THIS SOLUTION IS CHECKING THE DATABASE **/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(this.passwordEncoder())
			.usersByUsernameQuery(USERS_QUERY)
			.authoritiesByUsernameQuery(ROLES_QUERY)
			;

	}


	/** THIS WORKS AS DEFAULT ACCOUNTS TO TEST THE SECURITY BUT I WANT A SOLUTION WHICH COMES FROM A DATABASE **/
	/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder =
			     PasswordEncoderFactories.createDelegatingPasswordEncoder();

		// Create a default account
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password(encoder.encode("password"))
			.roles("ADMIN");

		// Create another account
		auth.inMemoryAuthentication()
			.withUser("nick")
			.password(encoder.encode("tankard"))
			.roles("ADMIN");
			;

	}	*/



}
