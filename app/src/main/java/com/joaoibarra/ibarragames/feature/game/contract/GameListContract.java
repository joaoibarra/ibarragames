package com.joaoibarra.ibarragames.feature.game.contract;

import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;
import com.joaoibarra.ibarragames.response.model.newapi.Game;

import java.util.List;

public interface GameListContract {
    public interface View{
        void onGetDataSuccess(String message, List<TopDeprecated> list);
        void onGetDataFailure(String message);
    }
    public interface Presenter{
        void getGames();
    }
    public interface Interactor{
        void getGames();

    }
    public interface OnGetGameResponseListener{
        void onSuccess(String message, List<TopDeprecated> list);
        void onFailure(String message);
    }
}
