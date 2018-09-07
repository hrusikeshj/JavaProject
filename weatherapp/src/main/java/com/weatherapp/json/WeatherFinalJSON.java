package com.weatherapp.json;

import java.io.Serializable;
import java.util.List;

public class WeatherFinalJSON implements Serializable{
	private static final long serialVersionUID=19084937837L;

	private String cod;
	private String message;
	private String cnt;
	private City city;
	private List<WeatherDetails> list;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<WeatherDetails> getList() {
		return list;
	}
	public void setList(List<WeatherDetails> list) {
		this.list = list;
	}

	
}
