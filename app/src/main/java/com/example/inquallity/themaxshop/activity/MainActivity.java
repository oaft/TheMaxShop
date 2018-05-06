package com.example.inquallity.themaxshop.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.fragment.AboutShopFragment;
import com.example.inquallity.themaxshop.fragment.CatalogFragment;
import com.example.inquallity.themaxshop.fragment.MainFragment;
import com.example.inquallity.themaxshop.fragment.ShopsFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout_main_menu) DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view_main) NavigationView mNavigationView;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast toast = Toast.makeText(this, R.string.back_pressed_text, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();
        }
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment targetFragment;
        switch (item.getItemId()) {
            case R.id.mi_about_us:
                targetFragment = new AboutShopFragment();
                getSupportActionBar().setTitle(R.string.mi_about_shop);
                break;
            case R.id.mi_catalog:
                targetFragment = new CatalogFragment();
                getSupportActionBar().setTitle(R.string.mi_catalog);
                break;
            case R.id.mi_shops:
                targetFragment = new ShopsFragment();
                getSupportActionBar().setTitle(R.string.mi_our_shops);
                break;
            case R.id.mi_main:
                targetFragment = new MainFragment();
                getSupportActionBar().setTitle(R.string.mi_main);
                break;
            default:
                targetFragment = null;
                break;
        }

        if (targetFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_content, targetFragment)
                    .commit();
        }
        mDrawerLayout.closeDrawers();
        return targetFragment != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        mDrawerLayout = findViewById(R.id.drawer_layout_main_menu);
        mNavigationView = findViewById(R.id.navigation_view_main);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.mi_main);
        setSupportActionBar(mToolbar);


        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.drawer_opened, R.string.drawer_closed);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content, fragment)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }
}
