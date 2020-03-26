package com.rest.GETwithExchange;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GETUsingExchangePASV
{
	private RestTemplate restTemplate;
	private String URL = "https://jsonview.com/example.json";

	@BeforeEach
	public void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void GETwithExchange()
	{
// exchange() is used for an arbitrary HTTP method
        ResponseEntity<String> response = restTemplate.exchange(URL,
                     HttpMethod.GET, null, String.class);

// response headers        
        MediaType responseContentType = response.getHeaders().getContentType();  
        System.out.println("Content-Type: " + responseContentType);
        
        long responseContentLegth = response.getHeaders().getContentLength();
        System.out.println("Content-Length: " + responseContentLegth);

// response body        
         String body = response.getBody();
         System.out.println("Body: \n" + body);

// status code         
         int statusCode = response.getStatusCodeValue();
         System.out.println("Status code: " + statusCode);
	}
}
