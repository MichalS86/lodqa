package com.lodqa.calculator.client;


import com.lodqa.calculator.model.GeometryCalculatorService;
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

public class WebGeometryCalculatorClient implements GeometryCalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(WebGeometryCalculatorClient.class);
    private final GeometryCalculatorClient client;

    public WebGeometryCalculatorClient(String url, int connectionTimeout, int readTimeout, Consumer<OkHttpClient.Builder> builder) {
        final OkHttpClient.Builder defaultBuilder = new OkHttpClient.Builder()
                .connectTimeout(connectionTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS);

        builder.accept(defaultBuilder);

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(defaultBuilder.build())
                .build();

        client = retro.create(GeometryCalculatorClient.class);
    }

    public WebGeometryCalculatorClient(String url, int connectionTimout, int readTimout) {
        this(url, connectionTimout, readTimout, builder -> {
        });
    }

    @Override
    public void countSurface(UUID id) {
        final Call<Void> roomsCall = client.countSurface(id);
        try {
            Response<Void> execute = roomsCall.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void countVolume(UUID id) {
        final Call<Void> roomsCall = client.countVolume(id);
        try {
            Response<Void> execute = roomsCall.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
