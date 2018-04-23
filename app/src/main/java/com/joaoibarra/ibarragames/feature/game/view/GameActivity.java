package com.joaoibarra.ibarragames.feature.game.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoibarra.ibarragames.R;
import com.joaoibarra.ibarragames.feature.game.contract.GameContract;
import com.joaoibarra.ibarragames.feature.game.presenter.GamePresenter;
import com.joaoibarra.ibarragames.response.model.deprecated.GameDeprecated;
import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;
import com.joaoibarra.ibarragames.response.model.newapi.Game;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements GameContract.View{
    @BindView(R.id.gameImageView)
    ImageView gameImageView;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvViewers)
    TextView tvViewers;

    @BindView(R.id.tvChannels)
    TextView tvChannels;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    GamePresenter gamePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void setProduct(TopDeprecated topDeprecated) {
        GameDeprecated game = topDeprecated.getGame();
        tvTitle.setText(game.getName());
        tvViewers.setText(topDeprecated.getViewers());
        tvChannels.setText(topDeprecated.getChannels());
        tvDescription.setText(getString(R.string.mussum_ipsum));
        collapsingToolbarLayout.setTitle(game.getName());

        if (!game.getBox().getSmall().isEmpty()) {
            Picasso.get().load(game.getBox().getTemplate("855","1220" )).into(gameImageView);
        }

        gamePresenter.getGame(game.getId());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }


    @Override
    public void onGetDataSuccess(String message, Game game) {
    }

    @Override
    public void onGetDataFailure(String message) {
        //swipeRefreshLayout.setRefreshing(false);
    }

    protected SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //gameListPresenter.getGames();
        }
    };

}
