package com.rest.GETwithParameters;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class GET
{
	private RestTemplate restTemplate;
	private String URL = "http://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}";

	@Before
	public void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void GETwithParameters()
	{
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("q", "San Francisco");
		params.put("appid", "a176e0999da6ade934326ce91abde8ea");
		String page = restTemplate.getForObject(URL, String.class, params);
		System.out.println(page);
	}
}
