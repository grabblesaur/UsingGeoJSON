package com.example.bayar.usinggeojson.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bayar.usinggeojson.Application;
import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String LAYER_SCANEX_THERMAL_POINTS = "";
    public static final String LAYER_SCANDEX_CLUSTER = "";
    public static final String LAYER_FIRMS_THERMAL_POINTS = "C13B4D9706F7491EBC6DC70DFFA988C0";
    public static final String LAYER_FIRMS_CLUSTER = "3E88643A8AC94AFAB4FD44941220B1CE";
    public static final String API_KEY = "B73WTOPAW2";
    public static final String TAG = "global";

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Application.getComponent(this).inject(this);
    }

    @OnClick(R.id.am_btn_show_on_map)
    public void showOnMapClicked() {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}
