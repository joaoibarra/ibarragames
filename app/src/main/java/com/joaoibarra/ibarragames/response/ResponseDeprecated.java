package com.joaoibarra.ibarragames.response;

import com.google.gson.annotations.SerializedName;
import com.joaoibarra.ibarragames.response.model.deprecated.TopDeprecated;

import java.util.List;

public class ResponseDeprecated {
    @SerializedName("_total")
    String total;

    List<TopDeprecated> top;

    public String getTotal() {
        return total;
    }

    public List<TopDeprecated> getTop() {
        return top;
    }
}
