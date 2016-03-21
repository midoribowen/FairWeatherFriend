package com.epicodus.guest.fairweatherfriend;

import java.util.ArrayList;

/**
 * Created by Guest on 3/21/16.
 */
public class Weather {

    private String mTemperature;
    private String mWeatherName;

    public Weather(String temperature, String weatherName) {
        this.mTemperature = temperature;
        this.mWeatherName = weatherName;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public String getmWeatherName() { return mWeatherName; }


}
