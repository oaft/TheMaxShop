package com.example.inquallity.themaxshop.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.loader.AssetLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 05-Feb-18.
 */

public class FlowerItemFragment extends Fragment {

    @BindView(R.id.iv_item_image) ImageView mItemImage;
    @BindView(R.id.tv_price_view) TextView mItemPrice;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        final String title = getArguments().getString("KEY_TITLE", getString(R.string.default_title));
        getActivity().setTitle(title);

        final String price = getArguments().getString("KEY_PRICE", getString(R.string.not_exist_now));
        mItemPrice.setText(price);

        String path = getArguments().getString("KEY_IMG_RES");
        final AssetLoader al = new AssetLoader(getActivity());
        final Bitmap bmp = al.loadImage(path);
        mItemImage.setImageBitmap(bmp);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
