package com.joaoibarra.ibarragames.api;

import com.joaoibarra.ibarragames.response.Response;
import com.joaoibarra.ibarragames.response.ResponseDeprecated;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/kraken/games/top")
    Call<ResponseDeprecated> getTopGamesDeprecated();

    @GET("/helix/games/top")
    Call<Response> getTopGames();

    @GET("/helix/games/")
    Call<Response> getGameById(@Query("id") String Id);

}
