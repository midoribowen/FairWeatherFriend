package com.epicodus.guest.fairweatherfriend;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
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

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("zip", location);
        urlBuilder.addQueryParameter("appid", API_KEY);
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
                String locationName = weatherJSON.getString("name");

                Double doubleTemp = ((Double.parseDouble(weatherJSON.getJSONObject("main").getString("temp")) - 273) * 1.8) + 32;
                int tempAsInt = doubleTemp.intValue();
                String temperature = Integer.toString(tempAsInt) + "\u00B0 F";




                Weather weather = new Weather(temperature, locationName);
                weathers.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}


