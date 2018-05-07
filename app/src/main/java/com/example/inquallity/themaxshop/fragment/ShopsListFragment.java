package com.example.inquallity.themaxshop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.activity.ShopMapActivity;
import com.example.inquallity.themaxshop.adapter.ShopsListAdapter;
import com.example.inquallity.themaxshop.loader.AssetLoader;
import com.example.inquallity.themaxshop.model.ShopItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 19-Dec-17.
 */

public class ShopsListFragment extends Fragment implements ShopsListAdapter.OnCardClickListener {

    @BindView(R.id.rv_shops_list) RecyclerView mRecyclerView;
    private ShopsListAdapter mShopsListAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_shops, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        final List<ShopItem> shopItems = loadFromAsset("shops/shops_list.json");

        mLinearLayoutManager = new LinearLayoutManager(view.getContext());
        mShopsListAdapter = new ShopsListAdapter();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mShopsListAdapter.setOnCardClickListener(this);
        mRecyclerView.setAdapter(mShopsListAdapter);
        mShopsListAdapter.changeItems(shopItems);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @NonNull
    private List<ShopItem> loadFromAsset(String path) {
        final String json = new AssetLoader(getActivity()).readJson(path);
        if (!TextUtils.isEmpty(json)) {
            return new Gson().fromJson(json, new TypeToken<List<ShopItem>>() {
            }.getType());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void onCardClick(@NonNull ShopItem shop) {
        final Intent intent = ShopMapActivity.makeIntent(getActivity(), shop);
        startActivity(intent);
    }
}
