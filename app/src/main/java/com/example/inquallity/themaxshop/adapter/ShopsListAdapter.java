package com.example.inquallity.themaxshop.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Aleksandrova on 07-May-18.
 */
public class ShopsListAdapter extends RecyclerView.Adapter<ShopItemViewHolder> {

    private ShopsListAdapter.OnCardClickListener mListener;
    private List<ShopItem> mShopItemList = new ArrayList<>();

    public void setOnCardClickListener(ShopsListAdapter.OnCardClickListener listener) {
        mListener = listener;
    }

    @Override
    public ShopItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_shop_item, parent, false);
        return new ShopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopItemViewHolder holder, int position) {
        holder.setOnCardClickListener(mListener);
        final ShopItem shopItem = mShopItemList.get(position);
        holder.bindItem(shopItem);
    }

    @Override
    public int getItemCount() {
        return mShopItemList.size();
    }

    public void changeItems(List<ShopItem> shopItemList) {
        if (shopItemList != null && !shopItemList.isEmpty()) {
            mShopItemList = shopItemList;
        }
        notifyDataSetChanged();
    }

    public interface OnCardClickListener {
        void onCardClick(@NonNull ShopItem shopItem);
    }
}
