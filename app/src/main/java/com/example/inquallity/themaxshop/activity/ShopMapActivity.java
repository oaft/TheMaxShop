package com.example.inquallity.themaxshop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.fragment.ShopMapFragment;
import com.example.inquallity.themaxshop.model.ShopItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Aleksandrova on 07-May-18.
 */
public class ShopMapActivity extends AppCompatActivity {
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_ADDRESS = "ADDRESS";
    public static final String KEY_LAT = "LAT";
    public static final String KEY_LON = "LON";

    @BindView(R.id.toolbar_list_item) Toolbar mToolbar;

    @NonNull
    public static Intent makeIntent(@NonNull Context ctx, @NonNull ShopItem shop) {
        final Intent intent = new Intent(ctx, ShopMapActivity.class);
        intent.putExtra(KEY_TITLE, shop.getTitle());
        intent.putExtra(KEY_ADDRESS, shop.getAddress());
        intent.putExtra(KEY_LAT, shop.getLat());
        intent.putExtra(KEY_LON, shop.getLon());
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_items_list);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Fragment fmt = ShopMapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_items_list_content, fmt)
                    .commit();
        }
    }
}
