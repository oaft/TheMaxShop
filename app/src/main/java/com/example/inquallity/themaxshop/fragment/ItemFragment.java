package com.example.inquallity.themaxshop.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.loader.AssetLoader;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Inquallity on 05-Feb-18.
 */

public class ItemFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.iv_item_image)
    ImageView mItemImage;
    @BindView(R.id.tv_price_view)
    TextView mItemPrice;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        final String title = getArguments().getString("KEY_TITLE", "TITLE NOT FOUND");
        getActivity().setTitle(title);
        mItemPrice.setText(getArguments().getString("KEY_PRICE", getString(R.string.not_exist_now)));
        String path = getArguments().getString("KEY_IMG_RES");

        final AssetLoader al = new AssetLoader(getActivity());
        final Bitmap bmp = al.loadImage(path);
        mItemImage.setImageBitmap(bmp);

//        if (!TextUtils.isEmpty(path)) {
//            path = path.trim();
//            try {
//                final InputStream is = getActivity().getAssets().open(path);
//                final Bitmap bitmap = BitmapFactory.decodeStream(is);
//                mItemImage.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
