package com.weatherapp.util;


public class Converter {
	
	public static double kelvinToFahrenheit(float kelvin){
		
		float celsius = kelvin - 273.15F;
		double fahrenheit = (9*celsius/5) + 32;
		
		
		return Math.round(fahrenheit*100.0)/100.0;
		
	}

}
