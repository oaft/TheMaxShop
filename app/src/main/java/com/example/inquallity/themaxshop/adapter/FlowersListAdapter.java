package com.example.inquallity.themaxshop.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.loader.AssetLoader;
import com.example.inquallity.themaxshop.model.FlowerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class FlowersListAdapter extends RecyclerView.Adapter<FlowerItemViewHolder> {

    private OnCardClickListener mListener;
    private List<FlowerItem> mFlowerItemList = new ArrayList<>();
    private AssetLoader mAssetLoader;

    public FlowersListAdapter(Context context) {
       mAssetLoader = new AssetLoader(context);
    }

    public void setOnCardClickListener(OnCardClickListener listener) {
        mListener = listener;
    }

    @Override
    public FlowerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_flower_item, parent, false);
        return new FlowerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FlowerItemViewHolder holder, int position) {
        holder.setOnCardClickListener(mListener);
        final FlowerItem flowerItem = mFlowerItemList.get(position);
        holder.bindItem(flowerItem);
        Bitmap bitmap = mAssetLoader.loadImage(flowerItem.getImageUrl());
        holder.bindImage(bitmap);
    }

    @Override
    public int getItemCount() {
        return mFlowerItemList.size();
    }

    public void changeItems(List<FlowerItem> flowerItems) {
        if (flowerItems != null && !flowerItems.isEmpty()) {
            mFlowerItemList = flowerItems;
        }
        notifyDataSetChanged();
    }

    public interface OnCardClickListener {
        void onCardClick(View view, String title, String imageUrl, String price);
    }
}
