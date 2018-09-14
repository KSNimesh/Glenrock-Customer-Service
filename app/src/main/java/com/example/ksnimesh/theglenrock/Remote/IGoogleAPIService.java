package com.example.ksnimesh.theglenrock.Remote;

import com.example.ksnimesh.theglenrock.Model.MyPlace;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IGoogleAPIService {

    @GET
    Call<MyPlace>getNearByPlace(@Url String url);
}
