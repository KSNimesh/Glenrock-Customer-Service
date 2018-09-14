package com.example.ksnimesh.theglenrock;

import com.example.ksnimesh.theglenrock.Remote.IGoogleAPIService;
import com.example.ksnimesh.theglenrock.Remote.RetrofitClient;

public class Common {

    private static final String GOOGLE_API_URL = "http://maps.googleapis.com/";

    public static IGoogleAPIService googleAPIService()
    {

        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }

}
