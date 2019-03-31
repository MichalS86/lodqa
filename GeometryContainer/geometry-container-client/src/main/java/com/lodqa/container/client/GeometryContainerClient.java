package com.lodqa.container.client;

import com.lodqa.container.model.GeometryFigure;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.UUID;

public interface GeometryContainerClient {

    @POST("addGeometry")
    Call<UUID> addGeometry(@Body GeometryFigure geometryFigure);

    @GET("getGeometry/{id}")
    Call<GeometryFigure> getGeometry(@Path("id") UUID id);

    @POST("updateSurface/{id}/{surface}")
    Call<Void> updateSurface(@Path("id") UUID id, @Path("surface") double surface);

    @POST("updateVolume/{id}/{volume}")
    Call<Void> updateVolume(@Path("id") UUID id, @Path("volume") double volume);

    @DELETE("deleteGeometry/{id}")
    Call<Void> deleteGeometry(@Path("id") UUID id);
}
