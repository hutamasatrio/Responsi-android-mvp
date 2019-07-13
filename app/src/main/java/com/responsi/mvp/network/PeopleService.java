package com.responsi.mvp.network;

import com.responsi.mvp.model.People;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleService {

    @GET("people")
    Call<People> getData();

//    @GET("people")
//    Call<People> getData(@Query("results") String result,
//                         @Query("nat") String nat);
}
