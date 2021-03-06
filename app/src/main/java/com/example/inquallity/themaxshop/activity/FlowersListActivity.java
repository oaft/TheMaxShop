package com.example.inquallity.themaxshop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.fragment.FlowersListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class FlowersListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_list_item) Toolbar mToolbar;

    @Override
    public void onBackPressed() {
        if (!getFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
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
        final Bundle extras2 = new Bundle();
        extras2.putInt("LIST_NUMBER", extras.getInt("LIST_NUMBER"));
        Fragment fragment = new FlowersListFragment();
        fragment.setArguments(extras2);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_items_list_content, fragment)
                .commit();
    }
}
