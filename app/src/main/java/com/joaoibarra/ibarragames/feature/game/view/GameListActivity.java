package com.joaoibarra.ibarragames.feature.game.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joaoibarra.ibarragames.R;
import com.joaoibarra.ibarragames.feature.game.contract.GameListContract;
import com.joaoibarra.ibarragames.feature.game.presenter.GameListPresenter;
import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;
import com.joaoibarra.ibarragames.response.model.newapi.Game;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameListActivity extends AppCompatActivity implements GameListContract.View{
    @BindView(R.id.gameRecyclerView)
    RecyclerView gameRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    GameListPresenter gameListPresenter;
    GameAdapter gameAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gameListPresenter = new GameListPresenter(this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        gameRecyclerView.setLayoutManager(mLayoutManager);
        gameListPresenter.getGames();
    }

    @Override
    public void onGetDataSuccess(String message, List<TopDeprecated> list) {
        gameAdapter = new GameAdapter(this, list);
        gameRecyclerView.setAdapter(gameAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetDataFailure(String message) {
        swipeRefreshLayout.setRefreshing(false);
    }

    protected SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            gameListPresenter.getGames();
        }
    };

}
