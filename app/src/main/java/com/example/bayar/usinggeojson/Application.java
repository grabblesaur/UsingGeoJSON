package com.example.bayar.usinggeojson;


import android.content.Context;

import com.example.bayar.usinggeojson.di.component.AppComponent;
import com.example.bayar.usinggeojson.di.component.DaggerAppComponent;
import com.example.bayar.usinggeojson.di.module.AppModule;

public class Application extends android.app.Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        appComponent = createComponent();
    }

    private AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent(Context context) {
        return ((Application) context.getApplicationContext()).appComponent;
    }
}
