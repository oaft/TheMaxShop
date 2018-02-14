package com.example.inquallity.themaxshop.fragment;

import android.app.Fragment;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.api.WeatherApi;
import com.example.inquallity.themaxshop.loader.ApiDataLoader;
import com.example.inquallity.themaxshop.model.City;
import com.example.inquallity.themaxshop.model.Main;
import com.example.inquallity.themaxshop.model.Weather;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Inquallity on 19-Dec-17.
 */

public class WeatherFragment extends Fragment {

    private static final String API_URL = "http://api.openweathermap.org";

    @BindView(R.id.tvCityName)
    TextView mCityName;
    @BindView(R.id.tvTemp)
    TextView mTemp;
    @BindView(R.id.tvMain)
    TextView mMain;
    @BindView(R.id.etCityName)
    EditText mEditTextCityName;

    private Retrofit mRetrofit;
    private String mExtraCityName;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_weather, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        initRetrofit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(5, TimeUnit.SECONDS)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(new HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();
    }

    private void proceedCity(City data) {
        final Weather weather = data.getWeather().get(0);
        final String description = weather.getDescription();
        final String weatherMain = weather.getMain();
        final Main cityMain = data.getMain();

        String temperatureStr = String.valueOf(cityMain.getTemp()) + " °C";

        mTemp.setText(temperatureStr);
        mMain.setText(String.format(Locale.getDefault(), "%s -> %s", weatherMain, description));

        mExtraCityName = data.getCityName();
        mCityName.setText(mExtraCityName);
    }

    @OnClick(R.id.btnProceed)
    void onProceedClick() {
        Log.d("LOG_TAG", "btnProceed was push");
               getLoaderManager().restartLoader(R.id.weather_loader, Bundle.EMPTY, new WeatherLoaderCallbacks());
    }

    private class WeatherLoaderCallbacks implements android.app.LoaderManager.LoaderCallbacks<City> {
        @Override
        public Loader<City> onCreateLoader(int id, Bundle args) {
            return new ApiDataLoader(getActivity(), mRetrofit.create(WeatherApi.class), mEditTextCityName);
        }

        @Override
        public void onLoadFinished(Loader<City> loader, City data) {
            if (data != null) {
                proceedCity(data);
            } else {
                Log.d("LOG_TAG", "data is null");
            }
        }

        @Override
        public void onLoaderReset(Loader<City> loader) {

        }
    }
}



