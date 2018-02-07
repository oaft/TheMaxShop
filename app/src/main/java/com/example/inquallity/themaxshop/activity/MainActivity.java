package com.example.inquallity.themaxshop.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import com.example.inquallity.themaxshop.fragment.ShopsFragment;
import com.example.inquallity.themaxshop.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar mToolbar;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        mDrawerLayout = findViewById(R.id.drawer_layout_main_menu);
        mNavigationView = findViewById(R.id.navigation_view_main);
        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.drawer_opened, R.string.drawer_closed);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment targetFragment;
        switch (item.getItemId()){
            case R.id.menu_item_about_us:
                targetFragment = new AboutShopFragment();
                getSupportActionBar().setTitle(R.string.mi_about_shop);
                break;
            case R.id.menu_item_catalog:
                targetFragment = new CatalogFragment();
                getSupportActionBar().setTitle(R.string.mi_catalog);
                break;
            case R.id.menu_item_shops:
                targetFragment = new ShopsFragment();
                getSupportActionBar().setTitle(R.string.mi_our_shops);
                break;
            case R.id.menu_item_weather:
                targetFragment = new WeatherFragment();
                getSupportActionBar().setTitle(R.string.mi_weather);
                break;
                default:
                    targetFragment = null;
                    break;
        }

        if (targetFragment != null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fl_content, targetFragment)
                    .commit();
        }
        mDrawerLayout.closeDrawers();
        return targetFragment != null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setTitle("ololo");
        mNavigationView.setNavigationItemSelectedListener(this);

    }
}
