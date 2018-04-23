package com.joaoibarra.ibarragames.feature.game.model;

import com.joaoibarra.ibarragames.api.GameApi;
import com.joaoibarra.ibarragames.feature.game.contract.GameListContract;
import com.joaoibarra.ibarragames.response.ResponseDeprecated;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameListInteractor implements GameListContract.Interactor{
    GameListContract.OnGetGameResponseListener onGetGameResponseListener;

    public GameListInteractor(GameListContract.OnGetGameResponseListener onGetGameResponseListener){
        this.onGetGameResponseListener = onGetGameResponseListener;
    }

    @Override
    public void getGames() {
        retrofit2.Call<ResponseDeprecated> call = GameApi.getApi().getTopGamesDeprecated();
        call.enqueue(new Callback<ResponseDeprecated>() {
            @Override
            public void onResponse(Call<ResponseDeprecated> call, Response<ResponseDeprecated> response) {
                onGetGameResponseListener.onSuccess(response.message(), response.body().getTop());
            }

            @Override
            public void onFailure(Call<ResponseDeprecated> call, Throwable t) {
                onGetGameResponseListener.onFailure(t.getMessage());
            }
        });
    }
}
