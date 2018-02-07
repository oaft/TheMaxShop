package com.example.inquallity.themaxshop.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.activity.ItemsListActivity;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class CatalogFragment extends Fragment {

    private TextView mTitleClassic;
    private TextView mTitleOriginal;
    private TextView mTitleRound;
    private TextView mTitleVertical;
    private TextView mTitleOriginalB;
    private TextView mTitleBasket;
    private TextView mTitleHousePlant;
    private TextView mTitleOpenSoil;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_catalog, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTitleClassic = view.findViewById(R.id.tv_title_classic);
        mTitleOriginal = view.findViewById(R.id.tv_title_original);
        mTitleRound = view.findViewById(R.id.tv_title_round_b);
        mTitleVertical = view.findViewById(R.id.tv_title_vertical_b);
        mTitleOriginalB = view.findViewById(R.id.tv_title_original_b);
        mTitleBasket = view.findViewById(R.id.tv_title_fbasket);
        mTitleHousePlant = view.findViewById(R.id.tv_title_hp);
        mTitleOpenSoil = view.findViewById(R.id.tv_title_os);

        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int listNumber;
                switch (v.getId()) {
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
                Intent intent = new Intent(v.getContext(), ItemsListActivity.class);
                intent.putExtra("LIST_NUMBER", listNumber);
                startActivity(intent);
            }
        };
        mTitleClassic.setOnClickListener(clickListener);
        mTitleOriginal.setOnClickListener(clickListener);
        mTitleRound.setOnClickListener(clickListener);
        mTitleVertical.setOnClickListener(clickListener);
        mTitleOriginalB.setOnClickListener(clickListener);
        mTitleBasket.setOnClickListener(clickListener);
        mTitleHousePlant.setOnClickListener(clickListener);
        mTitleOpenSoil.setOnClickListener(clickListener);
    }
}

