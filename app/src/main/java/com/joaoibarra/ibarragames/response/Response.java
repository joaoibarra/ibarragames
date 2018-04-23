package com.joaoibarra.ibarragames.response;

import com.joaoibarra.ibarragames.response.model.newapi.Game;
import com.joaoibarra.ibarragames.response.model.newapi.Pagination;

import java.util.List;

public class Response {

    List<Game> data;
    Pagination pagination;

    public List<Game> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
