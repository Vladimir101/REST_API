package com.rest.GETsimple.pages;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Place
{
	private String place_name;
	private String longitude;
	private String state;
	private String state_abbreviation;
	private String latitude;

	// Getter Methods
	public String getPlace_name()
	{
		return place_name;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public String getState()
	{
		return state;
	}

	public String getState_abbreviation()
	{
		return state_abbreviation;
	}

	public String getLatitude()
	{
		return latitude;
	}

	// Setter Methods
	@JsonSetter("place name")
	public void setPlace_name(String place_name)
	{
		this.place_name = place_name;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	@JsonSetter("state abbreviation")
	public void setState_abbreviation(String state_abbreviation)
	{
		this.state_abbreviation = state_abbreviation;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}
}