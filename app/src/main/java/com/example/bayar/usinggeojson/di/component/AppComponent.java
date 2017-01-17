package com.example.bayar.usinggeojson.di.component;

import com.example.bayar.usinggeojson.di.module.AppModule;
import com.example.bayar.usinggeojson.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);

}
