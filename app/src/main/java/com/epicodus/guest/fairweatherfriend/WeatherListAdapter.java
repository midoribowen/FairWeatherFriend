package com.epicodus.guest.fairweatherfriend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.ButterKnife;


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


        @Bind(R.id.imageUrl) ImageView mImageUrl;
        @Bind(R.id.dateTime) TextView mDateTime;
        @Bind(R.id.dayTemp) TextView mDayTemp;
        @Bind(R.id.dayTempLow) TextView mDayTempLow;
        @Bind(R.id.dayTempHigh) TextView mDayTempHigh;
        @Bind(R.id.pressure) TextView mPressure;
        @Bind(R.id.humidity) TextView mHumidity;
        @Bind(R.id.mainDescription) TextView mMainDescription;
        @Bind(R.id.suppDescription) TextView mSuppDescription;
        @Bind(R.id.windSpeed) TextView mWindSpeed;
        @Bind(R.id.windDirection) TextView mWindDirection;
        @Bind(R.id.clouds) TextView mClouds;


        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindWeather(Weather weather) {

            Picasso.with(mContext).load("http://openweathermap.org/img/w/" + weather.getImageUrl() + ".png").into(mImageUrl);

            int dateTimeUnixSeconds = Integer.parseInt(weather.getDateTime());
            String dateTime = DateFormat.getDateTimeInstance().format(dateTimeUnixSeconds*1000L);
            mDateTime.setText(dateTime);

            mDayTemp.setText(weather.getDayTemp());

            mDayTempLow.setText(weather.getDayTempLow());

            mDayTempHigh.setText(weather.getDayTempHigh());

            mPressure.setText(weather.getPressure());

            mHumidity.setText(weather.getHumidity());

            mMainDescription.setText(weather.getMainDescription());

            mSuppDescription.setText(weather.getSuppDescription());

            mWindSpeed.setText(weather.getWindSpeed());

            mWindDirection.setText(weather.getWindDirection());

            mClouds.setText(weather.getClouds());

        }
    }
}
