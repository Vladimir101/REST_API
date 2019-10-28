package com.rest.GETcomplex;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class GET
{
	@Test
	public void GETasPOJO()
	{
		RestTemplate restTemplate = new RestTemplate();
		ExamplePage response = restTemplate.getForObject("https://jsonview.com/example.json", 
				ExamplePage.class);

		System.out.println(response.getJapanese());
		System.out.println(response.getNotLink());
		System.out.println(response.getAnobject().getMore());
// Since an array was mapped to the ArrayList of Objects, we must cast the its values 
// to the correct data type		
		System.out.println((Integer)response.getAnobject().getAnarray().get(0));
		System.out.println((String)response.getAnobject().getAnarray().get(2));	
	}
}