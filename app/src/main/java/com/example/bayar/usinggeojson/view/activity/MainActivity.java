package com.example.bayar.usinggeojson.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bayar.usinggeojson.Application;
import com.example.bayar.usinggeojson.R;
import com.example.bayar.usinggeojson.presenter.MainActivityPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Application.getComponent(this).inject(this);
    }
}
