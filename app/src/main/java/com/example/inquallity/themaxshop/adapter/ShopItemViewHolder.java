package com.example.inquallity.themaxshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.model.ShopItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Aleksandrova on 07-May-18.
 */
public class ShopItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_shop_item_title) TextView mShopTitle;
    @BindView(R.id.tv_shop_item_address) TextView mShopAddress;
    private ShopItem mShopItem;
    private ShopsListAdapter.OnCardClickListener mListener;


    public ShopItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindItem(ShopItem shopItem) {
        mShopItem = shopItem;
        mShopTitle.setText(mShopItem.getTitle());
        mShopAddress.setText(mShopItem.getAddress());
    }

    @Override
    public void onClick(View v) {
        mListener.onCardClick(mShopItem);
    }

    public void setOnCardClickListener(ShopsListAdapter.OnCardClickListener listener) {
        this.mListener = listener;
    }
}
