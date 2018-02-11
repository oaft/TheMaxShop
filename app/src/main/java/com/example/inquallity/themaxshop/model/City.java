package com.example.inquallity.themaxshop.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Inquallity on 11-Feb-18.
 */

public class City {

    @SerializedName("name") private String mCityName;

    @SerializedName("weather") private List<Weather> mWeather;

    @SerializedName("main") private Main mMain;


    public String getCityName() {
        return mCityName;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public Main getMain() {
        return mMain;
    }

}
