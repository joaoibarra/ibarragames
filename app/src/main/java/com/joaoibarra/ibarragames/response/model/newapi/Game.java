package com.joaoibarra.ibarragames.response.model.newapi;

import com.google.gson.annotations.SerializedName;

public class Game {
    String id;
    String name;

    @SerializedName("box_art_url")
    String boxArtUrl;

    public String getBoxArtUrl(String height, String width){
        return boxArtUrl.replace("{width}", width).replace("{height}",height);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
