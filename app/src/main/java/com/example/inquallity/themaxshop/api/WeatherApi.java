package com.example.inquallity.themaxshop.api;

import com.example.inquallity.themaxshop.model.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Inquallity on 11-Feb-18.
 */

public interface WeatherApi {

    @GET("data/2.5/weather")
    Call<City> getWeather(@Query("q") String cityName, @Query("APPID") String key);
}
