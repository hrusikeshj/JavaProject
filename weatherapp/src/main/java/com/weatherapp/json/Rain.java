package com.weatherapp.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain implements Serializable{
	private static final long serialVersionUID=19084937837L;
	
	private String threehrs;
	
    @JsonProperty("3h")
	public String getThreehrs() {
		return threehrs;
	}
    @JsonProperty("3h")
	public void setThreehrs(String threehrs) {
		this.threehrs = threehrs;
	}

	
	

}
