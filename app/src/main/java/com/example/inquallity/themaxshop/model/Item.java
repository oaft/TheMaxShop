package com.example.inquallity.themaxshop.model;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class Item {

    private String mTitle;
    private String mPrice;
    private int mImageRes;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public Item(String title, String price, int imageRes) {
        mTitle = title;
        mPrice = price;
        mImageRes = imageRes;
    }
}

