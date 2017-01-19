package com.example.bayar.usinggeojson.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.api.model.firms.cluster.Feature;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashSet;
import java.util.Set;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String FEATURE_LIST = "feature_list";
    private GoogleMap mMap;
    private Set<Feature> featureSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        featureSet = new HashSet<>();
        if (getIntent().hasExtra(FEATURE_LIST)) {
            featureSet = (Set<Feature>) getIntent().getSerializableExtra(FEATURE_LIST);
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));

        CircleOptions co = new CircleOptions()
                .center(sydney)
                .radius(15)
                .strokeColor(Color.RED);

        mMap.addCircle(co);

        if (!featureSet.isEmpty()) {
            for (Feature feature : featureSet) {
                Double latitude = feature.getGeometry().getCoordinates().get(0);
                Double longitude = feature.getGeometry().getCoordinates().get(1);

                CircleOptions options = new CircleOptions()
                        .center(new LatLng(latitude, longitude))
                        .radius(feature.getProperties().getMaxArea())
                        .visible(true);
                mMap.addCircle(options);
            }
        }

    }
}
