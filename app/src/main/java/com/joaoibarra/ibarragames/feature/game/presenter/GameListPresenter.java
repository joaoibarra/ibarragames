package com.joaoibarra.ibarragames.feature.game.presenter;

import com.joaoibarra.ibarragames.feature.game.contract.GameListContract;
import com.joaoibarra.ibarragames.feature.game.model.GameListInteractor;
import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;
import com.joaoibarra.ibarragames.response.model.newapi.Game;

import java.util.List;

public class GameListPresenter implements GameListContract.Presenter, GameListContract.OnGetGameResponseListener{
    private GameListContract.View gameListView;
    private GameListInteractor gameListInteractor;

    public GameListPresenter(GameListContract.View gameListView){
        this.gameListView = gameListView;
        this.gameListInteractor = new GameListInteractor(this);
    }

    @Override
    public void getGames() {
        gameListInteractor.getGames();
    }

    @Override
    public void onSuccess(String message, List<TopDeprecated> list) {
        gameListView.onGetDataSuccess(message, list);
    }

    @Override
    public void onFailure(String message) {
        gameListView.onGetDataFailure(message);
    }
}
