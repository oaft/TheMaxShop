package com.example.inquallity.themaxshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_item_name)
    TextView mTitle;
    @BindView(R.id.tv_item_price)
    TextView mPrice;
    @BindView(R.id.iv_item)
    ImageView mImage;
    private ItemsListAdapter.OnCardClickListener mListener;
    private Item mItem;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
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
        mListener.onCardClick(v, mItem.getTitle(), mItem.getImageRes(), mItem.getPrice());
    }

    public void setOnCardClickListener(ItemsListAdapter.OnCardClickListener listener) {
        this.mListener = listener;
    }
}
