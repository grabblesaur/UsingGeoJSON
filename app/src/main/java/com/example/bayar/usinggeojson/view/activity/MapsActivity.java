package com.example.bayar.usinggeojson.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.api.ApiClient;
import com.example.bayar.usinggeojson.api.ApiService;
import com.example.bayar.usinggeojson.api.model.firms.cluster.Feature;
import com.example.bayar.usinggeojson.api.model.firms.cluster.FirmsCluster;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bayar.usinggeojson.view.activity.MainActivity.API_KEY;
import static com.example.bayar.usinggeojson.view.activity.MainActivity.LAYER_FIRMS_CLUSTER;

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
        fetchCluster();
    }

    private void fetchCluster() {
        ApiService service = ApiClient.getClient().create(ApiService.class);

        service.getFirmsCluster(LAYER_FIRMS_CLUSTER, API_KEY)
                .enqueue(new Callback<FirmsCluster>() {
                    @Override
                    public void onResponse(Call<FirmsCluster> call, Response<FirmsCluster> response) {
                        featureSet.addAll(response.body().getFeatures());
                        Toast.makeText(MapsActivity.this,
                                "Cluster layer was downloaded, current list size: " + featureSet.size(),
                                Toast.LENGTH_SHORT).show();
                        Log.i(MainActivity.TAG, "onResponse: success " + featureSet.size());
                        startDraw();
                    }

                    @Override
                    public void onFailure(Call<FirmsCluster> call, Throwable t) {
                        Toast.makeText(MapsActivity.this, "Failed to download cluster", Toast.LENGTH_SHORT).show();
                        Log.i(MainActivity.TAG, "onFailure: ");
                    }
                });
    }

    private void startDraw() {
        if (!featureSet.isEmpty() && mMap != null) {
            for (Feature feature : featureSet) {
                Double latitude = feature.getGeometry().getCoordinates().get(0);
                Double longitude = feature.getGeometry().getCoordinates().get(1);

                CircleOptions options = new CircleOptions()
                        .center(new LatLng(latitude, longitude))
                        .radius(feature.getProperties().getMaxArea() * feature.getProperties().getHotSpotCount())
                        .visible(true);
                mMap.addCircle(options);
            }
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
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
