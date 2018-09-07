package com.weatherapp.json;

import java.io.Serializable;
import java.util.List;

public class WeatherDetails implements Serializable,Comparable<WeatherDetails>{
	private static final long serialVersionUID=19084937837L;
	private String dt;
	private TempDetails main;
	private List<Weather> weather;
	private Clouds clouds;
	private Wind wind;
	private Rain rain;
	private Sys sys;
	private String dt_txt;
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public TempDetails getMain() {
		return main;
	}
	public void setMain(TempDetails main) {
		this.main = main;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
		
	public Rain getRain() {
		return rain;
	}
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	public int compareTo(WeatherDetails o) {

		return this.dt_txt.compareTo(o.dt_txt);
				
	}
	
	
	
	
}
