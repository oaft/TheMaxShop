package com.example.inquallity.themaxshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class ItemsListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private OnCardClickListener mListener;
    private List<Item> mItemList = new ArrayList<>();

    public void setOnCardClickListener(OnCardClickListener listener) {
        mListener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.setOnCardClickListener(mListener);
        holder.bindItem(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void changeItems(List<Item> items) {
        if (items!= null && !items.isEmpty()) {
            mItemList = items;
        }
        notifyDataSetChanged();
    }

    public interface OnCardClickListener {
        void onCardClick(View view, String title, int imageRes, String price);
    }
}
