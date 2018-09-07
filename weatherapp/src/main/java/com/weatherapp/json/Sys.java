package com.weatherapp.json;

import java.io.Serializable;

public class Sys implements Serializable{
	private static final long serialVersionUID=19084937837L;

	private String pod;

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
	
	
}
