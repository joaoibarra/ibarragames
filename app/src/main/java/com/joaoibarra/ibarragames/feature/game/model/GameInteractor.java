package com.joaoibarra.ibarragames.feature.game.model;

import com.joaoibarra.ibarragames.api.GameApi;
import com.joaoibarra.ibarragames.feature.game.contract.GameContract;
import com.joaoibarra.ibarragames.feature.game.contract.GameListContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameInteractor implements GameContract.Interactor{
    GameContract.OnGetGameResponseListener onGetGameResponseListener;

    public GameInteractor(GameContract.OnGetGameResponseListener onGetGameResponseListener){
        this.onGetGameResponseListener = onGetGameResponseListener;
    }

    @Override
    public void getGame(String id) {
        Call<com.joaoibarra.ibarragames.response.Response> call = GameApi.getApi().getGameById(id);
        call.enqueue(new Callback<com.joaoibarra.ibarragames.response.Response>() {
            @Override
            public void onResponse(Call<com.joaoibarra.ibarragames.response.Response> call, Response<com.joaoibarra.ibarragames.response.Response> response) {
                onGetGameResponseListener.onSuccess(response.message(), response.body().getData().get(0));
            }

            @Override
            public void onFailure(Call<com.joaoibarra.ibarragames.response.Response> call, Throwable t) {
                onGetGameResponseListener.onFailure(t.getMessage());
            }
        });
    }
}
