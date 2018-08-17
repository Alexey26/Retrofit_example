package com.example.developer.myapplication;

import android.app.Application;

import com.example.developer.myapplication.network.UmoriliApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    private UmoriliApi umoriliApi;
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo2138552.mockable.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class);
    }

    public UmoriliApi getUmoriliApi() {
        return umoriliApi;
    }
}
