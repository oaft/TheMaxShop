package com.example.inquallity.themaxshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.adapter.AdvertisingPageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 19-Feb-18.
 */

public class MainFragment extends Fragment {

    ArrayList<Integer> mPagesCollectionArrayList = new ArrayList(3);

    @BindView(R.id.view_pager_main) ViewPager mViewPager;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        mPagesCollectionArrayList.add(R.drawable.pager_main_autor_bouquet_102);
        mPagesCollectionArrayList.add(R.drawable.pager_main_tulpany_302);
        mPagesCollectionArrayList.add(R.drawable.pager_main_roses_202);

        AdvertisingPageAdapter advertisingPageAdapter = new AdvertisingPageAdapter(getActivity().getSupportFragmentManager());
        advertisingPageAdapter.setPagesCollection(mPagesCollectionArrayList);
        mViewPager.setAdapter(advertisingPageAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
