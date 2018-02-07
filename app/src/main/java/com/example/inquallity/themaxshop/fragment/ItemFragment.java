package com.example.inquallity.themaxshop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;

/**
 * Created by Inquallity on 05-Feb-18.
 */

public class ItemFragment extends Fragment {

    private TextView mTextView;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_item,  container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_item_title);
        mImageView = view.findViewById(R.id.iv_item_image);
        mTextView.setText(getArguments().getString("KEY_TITLE", "TITLE NOT FOUND"));
        mImageView.setImageResource(getArguments().getInt("KEY_IMG_RES"));
    }
}
