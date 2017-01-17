package com.example.bayar.usinggeojson.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bayar.usinggeojson.Application;
import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}
