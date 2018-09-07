package com.weatherapp.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.constants.WeatherAPIConstants;
import com.weatherapp.json.WeatherDetails;
import com.weatherapp.json.WeatherFinalJSON;
import com.weatherapp.util.Converter;

public class WeatherPredictProcessor {

	public void process(String zipCode){
		
		HttpURLConnection conn = null;
		try{	

		String weatherAPIURL = "https://api.openweathermap.org/data/2.5/forecast?zip="+zipCode+",us&appid="+WeatherAPIConstants.apiKey;
		URL url = new URL(weatherAPIURL);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if(conn.getResponseCode() == WeatherAPIConstants.SUCCESS)
		{
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		StringBuffer buffer = new StringBuffer();
		while ((output = br.readLine()) != null) {			
			buffer.append(output);
		}

		ObjectMapper mapper = new ObjectMapper();
		WeatherFinalJSON weatherFinalJSON = mapper.readValue(buffer.toString(), WeatherFinalJSON.class);
		List<WeatherDetails> weatherList = weatherFinalJSON.getList();
		Collections.sort(weatherList);
		List<WeatherDetails> tomorrowWeatherList = new ArrayList<WeatherDetails>();
		for(WeatherDetails weatherDetailsObj : weatherList){
			tomorrowWeatherList.add(weatherDetailsObj);
			if(weatherDetailsObj.getDt_txt().contains("21:00:00")) //Exiting for loop to take temp count till 21hr only for tomorrow
			break;
			
		}
		
		Collections.sort(tomorrowWeatherList);
		    
		System.out.println("Predicted temperature for tomorrow for each 3hr ::");
	    System.out.println("City: " +weatherFinalJSON.getCity().getName()+"\n");
	    System.out.println("Date & Time     \t\t    Min Temp(in Fahrenheit)   \t Max Temp(in Fahrenheit) \t Humidity(%)  \t\t  Description ");
		System.out.println("====================================================================================================================================================================");
		tomorrowWeatherList.forEach(item->
		{	
			System.out.println(item.getDt_txt() +"  \t\t  "+ Converter.kelvinToFahrenheit(Float.parseFloat(item.getMain().getTemp_min()))+"     \t\t    "+Converter.kelvinToFahrenheit(Float.parseFloat(item.getMain().getTemp_max() )) +" \t\t\t\t\t\t "+ item.getMain().getHumidity()+"  \t\t\t  "+ item.getWeather().get(0).getDescription());
			
		});
		}
		else if (conn.getResponseCode() == WeatherAPIConstants.ERR_404)
			System.out.println("Invalid ZIP code");
		else 
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }finally {		  
		  conn.disconnect();
	  }
		
		
	}
	
	
}
