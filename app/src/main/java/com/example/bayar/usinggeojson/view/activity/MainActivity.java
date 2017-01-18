package com.example.bayar.usinggeojson.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bayar.usinggeojson.Application;
import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.api.ApiClient;
import com.example.bayar.usinggeojson.api.ApiService;
import com.example.bayar.usinggeojson.api.model.Feature;
import com.example.bayar.usinggeojson.api.model.FirmsCluster;
import com.example.bayar.usinggeojson.presenter.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String LAYER_SCANEX_THERMAL_POINTS = "";
    public static final String LAYER_SCANDEX_CLUSTER = "";
    public static final String LAYER_FIRMS_THERMAL_POINTS = "";
    public static final String LAYER_FIRMS_CLUSTER = "3E88643A8AC94AFAB4FD44941220B1CE";
    public static final String API_KEY = "B73WTOPAW2";

    @Inject
    MainActivityPresenter presenter;

    private List<Feature> featureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Application.getComponent(this).inject(this);

        // временная мера
        featureList = new ArrayList<>();

        fetchCluster();
    }

    private void fetchCluster() {
        ApiService service = ApiClient.getClient().create(ApiService.class);

        service.getFirmsCluster(LAYER_FIRMS_CLUSTER, API_KEY)
                .enqueue(new Callback<FirmsCluster>() {
                    @Override
                    public void onResponse(Call<FirmsCluster> call, Response<FirmsCluster> response) {
                        featureList.addAll(response.body().getFeatures());
                        Toast.makeText(MainActivity.this,
                                "Cluster layer was downloaded, current list size: " + featureList.size(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<FirmsCluster> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failed to download cluster", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick(R.id.am_btn_show_on_map)
    public void showOnMapClicked() {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}
