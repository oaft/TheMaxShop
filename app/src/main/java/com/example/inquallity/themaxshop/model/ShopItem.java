package com.example.inquallity.themaxshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Olga Aleksandrova on 07-May-18.
 */
public class ShopItem {

    @SerializedName("title")
    private String mTitleShop;

    @SerializedName("address")
    private String mAddressShop;

    @SerializedName("lat")
    private double mLat;

    @SerializedName("lon")
    private double mLon;

    public String getAddress() {
        return mAddressShop;
    }

    public void setAddressShop(String addressShop) {
        mAddressShop = addressShop;
    }

    public String getTitle() {
        return mTitleShop;
    }

    public void setTitleShop(String titleShop) {
        mTitleShop = titleShop;
    }

    public ShopItem(String title, String address) {
        mTitleShop = title;
        mAddressShop = address;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        mLon = lon;
    }
}
