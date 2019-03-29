// must have Jackson libraries as dependencies
package com.rest.GETsimple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class GET
{
	private RestTemplate restTemplate;
	private String URL = "http://worldtimeapi.org/api/timezone/America/Los_Angeles";

	@Before
	public void setUp()
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void GETasString()
	{
		String page = restTemplate.getForObject(URL, String.class);
		System.out.println(page);
	}

	@Test
	public void GET_JSONasPOJO()
	{
		TimezonePage page = restTemplate.getForObject(URL, TimezonePage.class);
		assertEquals("PST", page.getAbbreviation());
		assertFalse(page.getDst());
	}
}
