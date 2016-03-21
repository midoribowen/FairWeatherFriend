package com.epicodus.guest.fairweatherfriend;

/**
 * Created by Guest on 3/21/16.
 */
public class Weather {

    private String mTemperature;
    private String mDescription;
    private String mWeatherName;

    public Weather(String temperature, String description, String weatherName) {
        this.mTemperature = temperature;
        this.mDescription = description;
        this.mWeatherName = weatherName;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getmWeatherName() { return mWeatherName; }


}
