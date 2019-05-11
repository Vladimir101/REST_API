package com.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POST
{
	private RestTemplate restTemplate;
	private String URL = "http://www.htmlgoon.com/api/POST_JSON_Service.php";
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void POSTwithEntityBody() throws Exception
	{
// specify request headers 
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
// server returns Content-Type: text/html		
		requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_HTML)); 
// an example of a custom header		
		requestHeaders.set("MyRequestHeader", "MyValue"); 
		
// specify entity body
		Map<String, String> body = new HashMap<String, String>(); 
		body.put("firstname", "Vladimir"); 
		body.put("lastname", "Belorusets"); 
		body.put("city", "Foster City"); 
		
// requestEntity includes both headers and body
// Map refers to the entity body		
		HttpEntity<Map<String, String>> requestEntity = 
				new HttpEntity<Map<String, String>>( body, requestHeaders); 

		String response = restTemplate.postForObject(URL, requestEntity, String.class);
		System.out.println(response);

// Using Jackson library for mapping		
		JsonNode root = objectMapper.readTree(response);
		System.out.println(root.get("status"));
		System.out.println(root.get("message"));
		System.out.println(root.get("data"));
// get nested data		
		System.out.println(root.get("data").get(0).get("firstname"));
	}
}
