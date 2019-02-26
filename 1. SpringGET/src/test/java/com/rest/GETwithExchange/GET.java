package com.rest.GETwithExchange;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GET
{
	private RestTemplate restTemplate;
	private String URL = "https://jsonview.com/example.json";

	@Before
	public void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void GETwithExchange()
	{
// create request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);

// exchage() is used for an arbitrary HTTP method
        ResponseEntity<String> response = restTemplate.exchange(URL,
                     HttpMethod.GET, requestEntity, String.class);

// response header
         MediaType responseHeader = response.getHeaders().getContentType();
         System.out.println("Content-Type: " + responseHeader);

// response body        
         String body = response.getBody();
         System.out.println("Body: " + body);

// status code         
         int statusCode = response.getStatusCodeValue();
         System.out.println("Status code: " + statusCode);
	}
}
