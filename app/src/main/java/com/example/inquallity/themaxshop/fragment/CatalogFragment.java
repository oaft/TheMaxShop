package com.example.inquallity.themaxshop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.activity.ItemsListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class CatalogFragment extends android.support.v4.app.Fragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_catalog, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @OnClick({R.id.tv_title_classic, R.id.tv_title_original,
            R.id.tv_title_round_b, R.id.tv_title_vertical_b,
            R.id.tv_title_original_b, R.id.tv_title_fbasket,
            R.id.tv_title_hp, R.id.tv_title_os})
    void onTitleClick(View view) {
        int listNumber;
        switch (view.getId()) {
            case R.id.tv_title_classic:
                listNumber = 1;
                break;
            case R.id.tv_title_original:
                listNumber = 2;
                break;
            case R.id.tv_title_round_b:
                listNumber = 3;
                break;
            case R.id.tv_title_vertical_b:
                listNumber = 4;
                break;
            case R.id.tv_title_original_b:
                listNumber = 5;
                break;
            case R.id.tv_title_fbasket:
                listNumber = 6;
                break;
            case R.id.tv_title_hp:
                listNumber = 7;
                break;
            case R.id.tv_title_os:
                listNumber = 8;
                break;
            default:
                listNumber = 0;
                break;
        }
        Intent intent = new Intent(view.getContext(), ItemsListActivity.class);
        intent.putExtra("LIST_NUMBER", listNumber);
        intent.putExtra("TITLE", ((TextView) view).getText());
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}

