package com.weatherapp.json;

import java.io.Serializable;

public class CoOrdinate implements Serializable{
	private static final long serialVersionUID=19084937837L;

	private String lon;
	private String lat;
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
		
}
