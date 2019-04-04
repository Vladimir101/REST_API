package com.rest;
// Parser is org.json (JSON In Java)
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
// Since response contains Japanese characters, it will be encoded in
// in Unicode. The first character will be byte order mark 65279, and not {
// https://en.wikipedia.org/wiki/Byte_order_mark

// int first = page.charAt(0);
// System.out.println(first);		
// We'll get 65279, as expected
		
// Parser will process JSON response as a JSONObject only if it starts with '{' 
// in the first position
		int pos = page.indexOf("{");
		page = page.substring(pos);

		JSONObject response = new JSONObject(page);
		System.out.println(response.getString("hey"));

		int anumber = response.getInt("anumber");
		System.out.println(anumber);

		JSONObject anobject = response.getJSONObject("anobject");
		JSONArray anarray = anobject.getJSONArray("anarray");
		
		int element1 = anarray.getInt(1);
		System.out.println("Element 1: " + element1);
		
		String element2 = anarray.getString(2);
		System.out.println("Element 2: " + element2);
	}
}
