package com.joaoibarra.ibarragames.feature.game.contract;

import com.joaoibarra.ibarragames.response.model.newapi.Game;

public interface GameContract {
    public interface View{
        void onGetDataSuccess(String message, Game game);
        void onGetDataFailure(String message);
    }
    public interface Presenter{
        void getGame(String id);
    }
    public interface Interactor{
        void getGame(String id);

    }
    public interface OnGetGameResponseListener{
        void onSuccess(String message, Game game);
        void onFailure(String message);
    }
}
