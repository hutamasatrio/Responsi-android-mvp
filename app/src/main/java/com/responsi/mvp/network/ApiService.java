package com.responsi.mvp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private Retrofit retrofit;
    private final String BASE_API_URL = "https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";

    public Retrofit getNetwork() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
