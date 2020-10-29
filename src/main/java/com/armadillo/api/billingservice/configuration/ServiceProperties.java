package com.armadillo.api.billingservice.configuration;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:service.properties")
@ConfigurationProperties(prefix = "service.host.url")
public class ServiceProperties {

	
    private String billingService;
    private String clientService;
    
    
    
	public String getBillingService() {
		return billingService;
	}
	public void setBillingService(String billingService) {
		this.billingService = billingService;
	}
	public String getClientService() {
		return clientService;
	}
	public void setClientService(String clientService) {
		this.clientService = clientService;
	}
	
	
	
	@Override
	public String toString() {
		return "ServiceProperties [billingService=" + billingService + ", clientService=" + clientService + "]";
	}


}