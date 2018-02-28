package com.supdevinci.temperature.Temperature;

/**
 * Created by rajek on 27/02/2018.
 */
public class TemperatureConvert {

    public static String convertFahrenheitToCelsius(double fahrenheit) {
        return Double.valueOf ((fahrenheit - 32) * 5 / 9).toString();
    }

    // converts to fahrenheit
    public static String convertCelsiusToFahrenheit(double celsius) {
        return Double.valueOf(((celsius * 9) / 5)+ 32).toString();
    }
}
