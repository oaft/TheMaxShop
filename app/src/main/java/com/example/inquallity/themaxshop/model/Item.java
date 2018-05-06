package com.example.inquallity.themaxshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class Item {

    @SerializedName("title") private String mTitle;
    @SerializedName("price") private String mPrice;
    @SerializedName("image_url") private String mImageUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public Item(String title, String price, String imageUrl) {
        mTitle = title;
        mPrice = price;
        mImageUrl = imageUrl;
    }
}

