package com.example.inquallity.themaxshop.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.FlowerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class FlowerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_flower_item_name) TextView mTitle;
    @BindView(R.id.tv_flower_item_price) TextView mPrice;
    @BindView(R.id.iv_flower_item) ImageView mImage;
    private FlowersListAdapter.OnCardClickListener mListener;
    private FlowerItem mFlowerItem;

    public FlowerItemViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindItem(FlowerItem flowerItem) {
        mFlowerItem = flowerItem;
        mTitle.setText(flowerItem.getTitle());
        mPrice.setText(flowerItem.getPrice());
    }

    @Override
    public void onClick(View v) {
        mListener.onCardClick(v, mFlowerItem.getTitle(), mFlowerItem.getImageUrl(), mFlowerItem.getPrice());
    }

    public void setOnCardClickListener(FlowersListAdapter.OnCardClickListener listener) {
        this.mListener = listener;
    }

    public void bindImage(Bitmap bitmap) {
        mImage.setImageBitmap(bitmap);
    }
}
