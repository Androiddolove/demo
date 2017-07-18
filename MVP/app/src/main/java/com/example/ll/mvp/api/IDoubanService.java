package com.example.ll.mvp.api;

import com.example.ll.mvp.beans.HotMoviesInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LL on 2017/7/5.
 */

public interface IDoubanService {
    String  BASE_URL = "https://api.douban.com/v2/";
    @GET("movie/in_theaters")
    Call<HotMoviesInfo> searchHotMovies();
}
