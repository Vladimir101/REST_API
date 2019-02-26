package com.rest.GETsimple;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class GET
{
	@Test
	public void GET_JSONasString()
	{
		RestTemplate restTemplate = new RestTemplate();
		String page = restTemplate.getForObject("http://worldtimeapi.org/api/timezone/America/Los_Angeles", 
				String.class);
		System.out.println(page);
	}
	
	@Test
	public void GET_JSONasPOJO()
	{
		RestTemplate restTemplate = new RestTemplate();
		TimezonePage page = restTemplate.getForObject("http://worldtimeapi.org/api/timezone/America/Los_Angeles", 
				TimezonePage.class);
		assertEquals("PST", page.getAbbreviation());
		assertFalse(page.getDst());
	}
}
