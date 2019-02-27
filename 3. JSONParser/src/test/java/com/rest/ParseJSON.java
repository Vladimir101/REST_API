package com.rest;
/*JSON Response
{
    "hey": "guy",
    "anumber": 243,
    "anobject": {
        "whoa": "nuts",
        "anarray": [
            1,
            2,
            "thr<h1>ee"
        ],
        "more": "stuff"
    },
    "awesome": true,
    "bogus": false,
    "meaning": null,
    "japanese": "明日がある。",
    "link": "http://jsonview.com",
    "notLink": "http://jsonview.com is great"
}*/

import java.io.IOException;
import org.json.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ParseJSON
{
	private RestTemplate restTemplate;
	private String URL = "https://jsonview.com/example.json";

	@Before
	public void setUp() throws Exception
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void parseGet() throws IOException
	{
		String page = restTemplate.getForObject(URL, String.class);
		
// Parser validates the JSON response.
// It will process it as a JSONObject if it starts with '{' as the first character
		int pos = page.indexOf("{");
		page = page.substring(pos);
		
		JSONObject response = new JSONObject(page);
		System.out.println(response.getString("hey"));
		
		JSONObject anobject = response.getJSONObject("anobject");
		JSONArray jsonArray = anobject.getJSONArray("anarray");
		int element1 = (Integer) jsonArray.get(1);
		System.out.println("Element 1: " + element1);
		  
		String element2 = jsonArray.get(2).toString();
		System.out.println("Element 2: " + element2);
	}
}
