package com.joaoibarra.ibarragames.feature.game.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoibarra.ibarragames.R;
import com.joaoibarra.ibarragames.response.model.deprecated.GameDeprecated;
import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;
import com.joaoibarra.ibarragames.response.model.newapi.Game;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private Context context;
    private List<TopDeprecated> list = new ArrayList<>();
    public GameAdapter(Context context, List<TopDeprecated> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_adapter_item,parent,false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(GameAdapter.ViewHolder holder, int position) {
        holder.position = position;
        GameDeprecated game = list.get(position).getGame();
        if(game != null) {
            holder.tvGameName.setText(game.getName());
            if (!game.getBox().getSmall().isEmpty()) {
                Picasso.get().load(game.getBox().getLarge()).into(holder.gameImageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gameImageView)
        ImageView gameImageView;

        @BindView(R.id.tvTitle)
        TextView tvGameName;

        @BindView(R.id.cardView)
        CardView cardView;

        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        public void cardViewClick(){
            EventBus.getDefault().postSticky(list.get(position));
            Intent intent = new Intent(context, GameActivity.class);
            Pair<View, String> p1 = Pair.create((View) gameImageView, "gameImage");
            Pair<View, String> p2 = Pair.create((View) tvGameName, "gameName");
            Activity activity = (Activity) context;
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(activity,p1, p2);
            context.startActivity(intent, options.toBundle());
        }
    }
}
