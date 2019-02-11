package com.example.android.cleanarchitecturepractice.presentation.view.weathers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.cleanarchitecturepractice.R;
import com.example.android.cleanarchitecturepractice.presentation.view.model.WeatherUIModel;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

class WeatherViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView mWeatherDate, mMaxTemperature, mLowTemperature, mWeatherDescription;
    private WeatherUIModel mWeather;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mWeatherDate = itemView.findViewById(R.id.weather_date_text_view);
        mMaxTemperature = itemView.findViewById(R.id.weather_max_temperature_text_view);
        mLowTemperature = itemView.findViewById(R.id.weather_low_temperature_text_view);
        mWeatherDescription = itemView.findViewById(R.id.weather_description_text_view);
        imageView = itemView.findViewById(R.id.weather_icon);
    }

    public void bind(WeatherUIModel weather) {
        mWeather = weather;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM");
        mMaxTemperature.setText(String.valueOf(mWeather.getMaxTemp()));
        mLowTemperature.setText(String.valueOf(mWeather.getMinTemp()));
        mWeatherDescription.setText(mWeather.getText());
        mWeatherDate.setText(sdf.format(new Date(mWeather.getEpoch() * 1000)));
        String url = "http:" + mWeather.getUrlIcon();
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
