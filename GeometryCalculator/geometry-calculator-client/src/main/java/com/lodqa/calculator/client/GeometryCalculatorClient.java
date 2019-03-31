package com.lodqa.calculator.client;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.UUID;

public interface GeometryCalculatorClient {

    @POST("countSurface/{id}")
    Call<Void> countSurface(@Path("id") UUID id);

    @POST("countVolume/{id}")
    Call<Void> countVolume(@Path("id") UUID id);
}
