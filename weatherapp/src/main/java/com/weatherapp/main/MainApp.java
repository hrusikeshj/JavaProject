package com.weatherapp.main;

import java.util.Scanner;

import com.weatherapp.processor.WeatherPredictProcessor;

public class MainApp {

	public static void main(String[] args) {

		String zipCode;
		Scanner input = new Scanner(System.in);
		if(args.length <1){		
		System.out.println("Please enter zip code");
		zipCode = input.next();
		}else zipCode = args[0];
		new WeatherPredictProcessor().process(zipCode);
		input.close();
	}

}
