package com.example.inquallity.themaxshop.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.inquallity.themaxshop.fragment.AdvertisingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Aleksandrova on 27-Apr-18.
 */

public class AdvertisingPageAdapter extends FragmentStatePagerAdapter {

    public static final String KEY_IMAGE = "IMAGE";
    private List<Integer> mPagesCollectionArrayList = new ArrayList<>();

    public AdvertisingPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new AdvertisingFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_IMAGE, mPagesCollectionArrayList.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mPagesCollectionArrayList.size();
    }

    public void setPagesCollection(ArrayList<Integer> pagesCollectionArrayList) {
        mPagesCollectionArrayList = pagesCollectionArrayList;
        notifyDataSetChanged();
    }
}
