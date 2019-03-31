package com.lodqa.container.client;

import com.lodqa.container.model.GeometryFigure;
import com.lodqa.container.model.GeometryService;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class WebGeometryContainerClient implements GeometryService {

    private static final Logger LOG = LoggerFactory.getLogger(WebGeometryContainerClient.class);
    private final GeometryContainerClient client;

    public WebGeometryContainerClient(String url, int connectionTimeout, int readTimeout, Consumer<OkHttpClient.Builder> builder) {
        final OkHttpClient.Builder defaultBuilder = new OkHttpClient.Builder()
                .connectTimeout(connectionTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS);

        builder.accept(defaultBuilder);

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(defaultBuilder.build())
                .build();

        client = retro.create(GeometryContainerClient.class);
    }

    public WebGeometryContainerClient(String url, int connectionTimout, int readTimout) {
        this(url, connectionTimout, readTimout, builder -> {
        });
    }

    @Override
    public UUID addGeometry(GeometryFigure geometryFigure) {
        final Call<UUID> roomsCall = client.addGeometry(geometryFigure);
        try {
            Response<UUID> execute = roomsCall.execute();
            return execute.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GeometryFigure getGeometry(UUID id) {
        final Call<GeometryFigure> roomsCall = client.getGeometry(id);
        try {
            Response<GeometryFigure> execute = roomsCall.execute();
            return execute.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSurface(UUID id, double surface) {
        final Call<Void> roomsCall = client.updateSurface(id, surface);
        try {
            Response<Void> execute = roomsCall.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateVolume(UUID id, double volume) {
        final Call<Void> roomsCall = client.updateVolume(id, volume);
        try {
            Response<Void> execute = roomsCall.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteGeometry(UUID id) {
        final Call<Void> roomsCall = client.deleteGeometry(id);
        try {
            Response<Void> execute = roomsCall.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
