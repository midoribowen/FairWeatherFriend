package com.epicodus.guest.fairweatherfriend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 3/21/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers) {
        mWeathers = weathers;
        mContext = context;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.locationName) TextView mLocationName;
        @Bind(R.id.temperature) TextView mTemperature;
        @Bind(R.id.description) TextView mDescription;
        @Bind(R.id.sunrise) TextView mSunrise;
        @Bind(R.id.sunset) TextView mSunset;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindWeather(Weather weather) {
            mLocationName.setText(weather.getLocationName());
            mTemperature.setText(weather.getTemperature());
            mDescription.setText(weather.getDescription());
            mSunrise.setText(weather.getSunrise());
            mSunset.setText(weather.getSunset());
        }
    }
}
