package com.example.inquallity.themaxshop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.activity.ShopMapActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * @author Olga Aleksandrova on 07-May-18.
 */
public class ShopMapFragment extends Fragment implements OnMapReadyCallback {

    private static final float DEFAULT_ZOOM = 12.f;

    private MapView mMapView;
    private GoogleMap mMap;

    private TextView mAddress;

    @NonNull
    public static Fragment newInstance() {
        return new ShopMapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_shop_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mMapView = view.findViewById(R.id.map);
        mAddress = view.findViewById(R.id.address);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMapView.getMapAsync(this);
        mMapView.onCreate(savedInstanceState);

        final Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            final String address = extras.getString(ShopMapActivity.KEY_ADDRESS);
            mAddress.setText(address);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        final Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            final String title = extras.getString(ShopMapActivity.KEY_TITLE);
            getActivity().setTitle(title);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        showShopPosition();
    }

    private void showShopPosition() {
        final Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            final double lat = extras.getDouble(ShopMapActivity.KEY_LAT);
            final double lon = extras.getDouble(ShopMapActivity.KEY_LON);
            final LatLng latLng = new LatLng(lat, lon);
            final CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM);
            final MarkerOptions marker = new MarkerOptions().position(latLng);
            if (mMap != null) {
                mMap.addMarker(marker);
                mMap.moveCamera(cameraUpdate);
            }
        }
    }
}
