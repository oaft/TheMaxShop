package com.example.inquallity.themaxshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inquallity on 11-Feb-18.
 */

public class Weather {

    @SerializedName("main")
    private String mMain;

    @SerializedName("description")
    private String mDescription;

    public String getMain() {
        return mMain;
    }

    public String getDescription() {
        return mDescription;
    }

}
