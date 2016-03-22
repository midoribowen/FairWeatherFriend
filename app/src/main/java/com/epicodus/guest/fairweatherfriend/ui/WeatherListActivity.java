package com.epicodus.guest.fairweatherfriend.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.guest.fairweatherfriend.R;
import com.epicodus.guest.fairweatherfriend.adapters.WeatherListAdapter;
import com.epicodus.guest.fairweatherfriend.models.Weather;
import com.epicodus.guest.fairweatherfriend.services.OpenWeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherListActivity extends AppCompatActivity {
    public ArrayList<Weather> mWeathers = new ArrayList<>();
    public static final String TAG = WeatherListActivity.class.getSimpleName();

    @Bind(R.id.weatherDisplay) RecyclerView mWeatherDisplay;
    private WeatherListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeathers(location);
    }

    private void getWeathers(String location) {
        final OpenWeatherService openWeatherService = new OpenWeatherService(this);

        openWeatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mWeathers = openWeatherService.processResults(response);

                WeatherListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new WeatherListAdapter(getApplicationContext(), mWeathers);
                        mWeatherDisplay.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherListActivity.this);
                        mWeatherDisplay.setLayoutManager(layoutManager);
                        mWeatherDisplay.setHasFixedSize(true);
                    }
                });


            }
        });
    }

}
