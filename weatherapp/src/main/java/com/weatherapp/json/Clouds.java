package com.weatherapp.json;

import java.io.Serializable;

public class Clouds implements Serializable{
	private static final long serialVersionUID=19084937837L;

	private String all;

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
	
}
