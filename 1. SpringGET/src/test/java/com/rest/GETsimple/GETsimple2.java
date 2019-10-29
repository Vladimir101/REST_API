package com.rest.GETsimple;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.*;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.GETsimple.pages.PostCode;

class GETsimple2
{
	private RestTemplate restTemplate;
	private String URL = "http://api.zippopotam.us/us/94404";

	@BeforeEach
	void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}

	@Test
	void test1() throws JsonProcessingException
	{
		PostCode response = restTemplate.getForObject(URL, PostCode.class);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		System.out.println(response.getPost_code());
		System.out.println(response.getCountry_abbreviation());
		System.out.println(response.getPlaces().get(0).getPlace_name());
		Approvals.verify(json);
	}
	

	@Test
	void test2()
	{
		String response = restTemplate.getForObject(URL, String.class);
		Approvals.verify(response);
	}
}
