// must have Jackson libraries as dependencies
package com.rest.GETsimple;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.web.client.RestTemplate;

import com.rest.GETsimple.pages.TimezonePage;

public class GETsimple
{
	private RestTemplate restTemplate;
	private String URL = "http://worldtimeapi.org/api/timezone/America/Los_Angeles";

	@BeforeEach
	public void setUp()
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void GETasString()
	{
		String response = restTemplate.getForObject(URL, String.class);
		System.out.println(response);
	}

	@Test
	public void GETasPOJO()
	{
		TimezonePage response = restTemplate.getForObject(URL, TimezonePage.class);
		assertEquals("PDT", response.getAbbreviation());
		assertTrue(response.getDst());
	}
}
