package com.epicodus.guest.fairweatherfriend.services;

import android.content.Context;

import com.epicodus.guest.fairweatherfriend.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 3/21/16.
 */
public class OpenWeatherService {

    private Context mContext;
    public static final String TAG = OpenWeatherService.class.getSimpleName();

    public OpenWeatherService(Context context) {
        this.mContext = context;
    }

    public void findWeather(String location, Callback callback) {
        String API_KEY = "e3157abb1472106b7c6deea26b11cbfe";

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/forecast?&units=imperial").newBuilder();
        urlBuilder.addQueryParameter("q", location);
        urlBuilder.addQueryParameter("appid", API_KEY);
        urlBuilder.addQueryParameter("units", "imperial");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weathers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray listJSON = weatherJSON.getJSONArray("list");
                for (int i = 0; i < listJSON.length(); i++) {
                    JSONObject dayJSON = listJSON.getJSONObject(i);
                    String locationName = weatherJSON.getJSONObject("city").getString("name");
                    String locationId = weatherJSON.getJSONObject("city").getString("id");
                    String dateTime = dayJSON.getString("dt");
                    String dayTemp = dayJSON.getJSONObject("main").getString("temp");
                    String dayTempLow = dayJSON.getJSONObject("main").getString("temp_min");
                    String dayTempHigh = dayJSON.getJSONObject("main").getString("temp_max");
                    String pressure = dayJSON.getJSONObject("main").getString("pressure");
                    String humidity = dayJSON.getJSONObject("main").getString("humidity");
                    String mainDescription = dayJSON.getJSONArray("weather").getJSONObject(0).getString("main");
                    String suppDescription = dayJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    String descriptionIcon = dayJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
                    String windSpeed = dayJSON.getJSONObject("wind").getString("speed");
                    String windDirection = dayJSON.getJSONObject("wind").getString("deg");
                    String clouds = dayJSON.getJSONObject("clouds").getString("all");

                    Weather dayOfWeather = new Weather(locationName, locationId, dateTime, dayTemp, dayTempLow, dayTempHigh, pressure, humidity, mainDescription, suppDescription, descriptionIcon, windSpeed, windDirection, clouds);
                    weathers.add(dayOfWeather);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}


