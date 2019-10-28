package com.rest.GETsimple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

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

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		PostCode response = restTemplate.getForObject(URL, PostCode.class);
		System.out.println(response.getPost_code());
		System.out.println(response.getCountry_abbreviation());
		System.out.println(response.getPlaces().get(0).getPlace_name());
	}
}
