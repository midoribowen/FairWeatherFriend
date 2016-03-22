package com.epicodus.guest.fairweatherfriend;

public class Weather {

    private String mLocationName;
    private String mLocationId;
    private String mDateTime;
    private String mDayTemp;
    private String mDayTempLow;
    private String mDayTempHigh;
    private String mPressure;
    private String mHumidity;
    private String mMainDescription;
    private String mSuppDescription;
    private String mImageUrl;
    private String mWindSpeed;
    private String mWindDirection;
    private String mClouds;

    public Weather(String locationName, String locationId, String dateTime, String dayTemp, String dayTempLow, String dayTempHigh, String pressure, String humidity, String mainDescription, String suppDescription, String imageUrl, String windSpeed, String windDirection, String clouds) {
        this.mLocationName = locationName;
        this.mLocationId = locationId;
        this.mDateTime = dateTime;
        this.mDayTemp = dayTemp;
        this.mDayTempLow = dayTempLow;
        this.mDayTempHigh = dayTempHigh;
        this.mPressure = pressure;
        this.mHumidity = humidity;
        this.mMainDescription = mainDescription;
        this.mSuppDescription = suppDescription;
        this.mImageUrl = imageUrl;
        this.mWindSpeed = windSpeed;
        this.mWindDirection = windDirection;
        this.mClouds = clouds;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationId() {
        return mLocationId;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public String getDayTemp() {
        return mDayTemp;
    }

    public String getDayTempLow() {
        return mDayTempLow;
    }

    public String getDayTempHigh() {
        return mDayTempHigh;
    }

    public String getPressure() {
        return mPressure;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getMainDescription() {
        return mMainDescription;
    }

    public String getSuppDescription() {
        return mSuppDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getWindSpeed() {
        return mWindSpeed;
    }

    public String getWindDirection() {
        return mWindDirection;
    }

    public String getClouds() {
        return mClouds;
    }

}
