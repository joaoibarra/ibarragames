package com.joaoibarra.ibarragames.feature.game.presenter;

import com.joaoibarra.ibarragames.feature.game.contract.GameContract;
import com.joaoibarra.ibarragames.feature.game.model.GameInteractor;
import com.joaoibarra.ibarragames.response.model.newapi.Game;

public class GamePresenter implements GameContract.Presenter, GameContract.OnGetGameResponseListener{
    private GameContract.View gameView;
    private GameInteractor gameInteractor;

    public GamePresenter(GameContract.View gameListView){
        this.gameView = gameListView;
        this.gameInteractor = new GameInteractor(this);
    }

    @Override
    public void getGame(String id) {
        gameInteractor.getGame(id);
    }

    @Override
    public void onSuccess(String message, Game game) {
        gameView.onGetDataSuccess(message, game);
    }

    @Override
    public void onFailure(String message) {
        gameView.onGetDataFailure(message);
    }
}
