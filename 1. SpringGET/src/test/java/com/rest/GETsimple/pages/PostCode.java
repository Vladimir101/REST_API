// JSON keys contain 2 words with spaces
// We have to use @JsonSetter for setters
package com.rest.GETsimple.pages;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSetter;

public class PostCode
{

	private String post_code;
	private String country;
	private String country_abbreviation;
	ArrayList<Place> places;// = new ArrayList<Place>();

	public ArrayList<Place> getPlaces()
	{
		return places;
	}

	public void setPlaces(ArrayList<Place> places)
	{
		this.places = places;
	}

	// Getter Methods
	public String getPost_code()
	{
		return post_code;
	}

	public String getCountry()
	{
		return country;
	}

	public String getCountry_abbreviation()
	{
		return country_abbreviation;
	}

	// Setter Methods
	@JsonSetter("post code")
	public void setPost_code(String post_code)
	{
		this.post_code = post_code;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	@JsonSetter("country abbreviation")
	public void setCountry_abbreviation(String country_abbreviation)
	{
		this.country_abbreviation = country_abbreviation;
	}
}