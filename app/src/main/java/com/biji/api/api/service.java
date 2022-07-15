package com.biji.api.api;

import com.biji.api.model.plane;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface service {
    @Headers("X-RapidAPI-Host: iata-and-icao-codes.p.rapidapi.com")
    @GET("airlines")
        Call<List<plane>> groupList(@Header("X-RapidAPI-Key") String api_key );
}
