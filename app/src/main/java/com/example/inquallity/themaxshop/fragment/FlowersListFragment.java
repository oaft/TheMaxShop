package com.example.inquallity.themaxshop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.adapter.FlowersListAdapter;
import com.example.inquallity.themaxshop.loader.AssetLoader;
import com.example.inquallity.themaxshop.model.FlowerItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 05-Feb-18.
 */

public class FlowersListFragment extends Fragment implements FlowersListAdapter.OnCardClickListener {

    private static SparseArray<String> sAssets = new SparseArray<>();

    static {
        sAssets.put(1, "flowers/classic.json");
        sAssets.put(2, "flowers/original.json");
        sAssets.put(3, "flowers/round_bouquet.json");
        sAssets.put(4, "flowers/vertical_bouquet.json");
        sAssets.put(5, "flowers/origin_bouquet.json");
        sAssets.put(6, "flowers/flower_basket.json");
        sAssets.put(7, "flowers/house_plant.json");
        sAssets.put(8, "flowers/open_soil_plant.json");
    }

    @BindView(R.id.rv_list_item) RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FlowersListAdapter mFlowersListAdapter;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_items_list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        final Bundle bundle = this.getArguments();
        int i = bundle.getInt("LIST_NUMBER");

        final List<FlowerItem> flowerItems = loadFromAsset(i);

        mFlowersListAdapter = new FlowersListAdapter(getActivity());
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mFlowersListAdapter.setOnCardClickListener(this);
        mRecyclerView.setAdapter(mFlowersListAdapter);
        mFlowersListAdapter.changeItems(flowerItems);
    }

    @Override
    public void onCardClick(View view, String title, String imgUrl, String price) {
        Fragment fragment = new FlowerItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TITLE", title);
        bundle.putString("KEY_IMG_RES", imgUrl);
        bundle.putString("KEY_PRICE", price);
        fragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_items_list_content, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        final String title = getActivity().getIntent().getExtras().getString("TITLE");
        getActivity().setTitle(title);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @NonNull
    private List<FlowerItem> loadFromAsset(int position) {
        final String json = new AssetLoader(getActivity()).readJson(sAssets.get(position));
        if (!TextUtils.isEmpty(json)) {
            return new Gson().fromJson(json, new TypeToken<List<FlowerItem>>() {
            }.getType());
        } else {
            return Collections.emptyList();
        }
    }
}
