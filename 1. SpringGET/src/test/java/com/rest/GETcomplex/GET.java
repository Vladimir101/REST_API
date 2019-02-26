package com.rest.GETcomplex;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class GET
{
	@Test
	public void GET_JSONasPOJO()
	{
		RestTemplate restTemplate = new RestTemplate();
		ExamplePage page = restTemplate.getForObject("https://jsonview.com/example.json", 
				ExamplePage.class);
		System.out.println(page.getNotLink());
		System.out.println(page.getAnobject().getMore());
	}
}