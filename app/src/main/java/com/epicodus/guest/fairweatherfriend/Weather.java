package com.epicodus.guest.fairweatherfriend;

import java.util.ArrayList;

/**
 * Created by Guest on 3/21/16.
 */
public class Weather {

    private String mTemperature;
    private String mLocationName;
    private String mDescription;
    private String mSunrise;
    private String mSunset;

    public Weather(String temperature, String locationName, String description, String sunrise, String sunset) {
        this.mTemperature = temperature;
        this.mLocationName = locationName;
        this.mDescription = description;
        this.mSunrise = sunrise;
        this.mSunset = sunset;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public String getLocationName() { return mLocationName; }

    public String getDescription() {
        return mDescription;
    }

    public String getSunrise() {
        return mSunrise;
    }

    public String getSunset() {
        return mSunset;
    }
}
