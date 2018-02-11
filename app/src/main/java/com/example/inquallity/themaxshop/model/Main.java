package com.example.inquallity.themaxshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inquallity on 11-Feb-18.
 */

public class Main {

    @SerializedName("temp")
    private double mTemp;

    public int getTemp() {

        int temp = (int) (mTemp - 273.15);
        return temp;
    }
}
