package com.example.inquallity.themaxshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.Item;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTitle;
    private TextView mPrice;
    private ImageView mImage;
    private ItemsListAdapter.OnCardClickListener mListener;
    private Item mItem;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.tv_item_name);
        mPrice = itemView.findViewById(R.id.tv_item_price);
        mImage = itemView.findViewById(R.id.iv_item);
        itemView.setOnClickListener(this);
    }

    public void bindItem(Item item) {
        mItem = item;
        mTitle.setText(item.getTitle());
        mImage.setImageResource(item.getImageRes());
        mPrice.setText(item.getPrice());
    }

    @Override
    public void onClick(View v) {
        mListener.onCardClick(v, mItem.getTitle(), mItem.getImageRes());
    }

    public void setOnCardClickListener(ItemsListAdapter.OnCardClickListener listener) {
        this.mListener = listener;
    }
}
