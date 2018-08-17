package com.example.developer.myapplication.network;

import com.example.developer.myapplication.model.ResponseWrap;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UmoriliApi {

    @GET("getPeople")
    Observable<ResponseWrap> getData();
}
