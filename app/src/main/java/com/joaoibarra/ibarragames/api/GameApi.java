package com.joaoibarra.ibarragames.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameApi {
    private static String URL = "https://api.twitch.tv";
    private static String KEY = "81he3r8o4dreicx6klubgyddweioi2";

    public static Api getApi() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        builder.addInterceptor(interceptor);

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("client-id", KEY).build();
            return chain.proceed(request);
        });

        OkHttpClient client = builder
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(Api.class);
    }
}
