package com.example.bayar.usinggeojson.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.bayar.usinggeojson.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        addPolyline();
        addPolygon();
        addCircle();
    }

    private void addPolyline() {
        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(-34, 151))
                .add(new LatLng(-34, 151.1))
                .add(new LatLng(-34.1, 151.2))
                .add(new LatLng(-34.1, 151.3));

        Polyline polyline = mMap.addPolyline(rectOptions);
        polyline.setColor(Color.BLUE);
    }

    private void addPolygon() {
        PolygonOptions options = new PolygonOptions()
                .add(new LatLng(-34, 151), new LatLng(-34, 151.02), new LatLng(-34.02, 151.02));
        Polygon polygon = mMap.addPolygon(options);
        polygon.setStrokeColor(Color.RED);
        polygon.setFillColor(Color.GREEN);
    }

    private void addCircle() {

    }

}
