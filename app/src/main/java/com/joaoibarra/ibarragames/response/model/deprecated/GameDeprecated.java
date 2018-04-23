package com.joaoibarra.ibarragames.response.model.deprecated;

import com.google.gson.annotations.SerializedName;

public class GameDeprecated {
    @SerializedName("_id")
    String id;

    Box box;

    @SerializedName("giantbomb_id")
    String giantbombId;

    Logo logo;

    String name;
    String popularity;

    public String getId() {
        return id;
    }

    public Box getBox() {
        return box;
    }

    public String getGiantbombId() {
        return giantbombId;
    }

    public Logo getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getPopularity() {
        return popularity;
    }
}
