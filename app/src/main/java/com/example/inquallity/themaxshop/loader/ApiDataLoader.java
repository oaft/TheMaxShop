package com.example.inquallity.themaxshop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.EditText;

import com.example.inquallity.themaxshop.api.WeatherApi;
import com.example.inquallity.themaxshop.model.City;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Inquallity on 11-Feb-18.
 */

public class ApiDataLoader extends AsyncTaskLoader<City> {
    private EditText mEditTextCityName;

    private final WeatherApi mApi;
    private City mCityCache = null;
    private static final String KEY = "db65325252139963105cfff1e7ea564e";

    public ApiDataLoader(Context context, WeatherApi api, EditText editText) {
        super(context);
        mApi = api;
        mEditTextCityName = editText;
    }

    @Override
    public City loadInBackground() {

        String mCityName = mEditTextCityName.getText().toString();

        final Call<City> cityCall = mApi.getWeather(mCityName, KEY);
        City city = null;
        try {
            final Response<City> cityResponse = cityCall.execute();
            city = cityResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void deliverResult(City data) {
        if (mCityCache == null) {
            mCityCache = data;
        }
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        if (mCityCache != null) {
            deliverResult(mCityCache);
        } else {
            forceLoad();
        }
    }
}
