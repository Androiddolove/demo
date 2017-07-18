package com.example.ll.mvp.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LL on 2017/7/4.
 */

public class HotMoviesInfo {

    private int count;
    private int start;
    private int total;
    private String title;
    @SerializedName("subjects")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
