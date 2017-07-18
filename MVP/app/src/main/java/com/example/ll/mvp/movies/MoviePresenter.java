package com.example.ll.mvp.movies;

import android.util.Log;

import com.example.ll.mvp.api.IDoubanService;
import com.example.ll.mvp.beans.HotMoviesInfo;
import com.example.ll.mvp.beans.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LL on 2017/7/6.
 */

public class MoviePresenter implements MoviesContract.Presenter {
    private  MoviesContract.View mMovieView;
    private  IDoubanService mIDoubanService;
    private boolean mFirstLoad = true;

    public MoviePresenter(IDoubanService mMovieService,MoviesContract.View movieFragment){
        mMovieView = movieFragment;
        mIDoubanService = mMovieService;
        movieFragment.setPresenter(this);
    }
    @Override
    public void start() {
        loadMovies(false);
    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        loadMovies(forceUpdate||mFirstLoad,true);
        mFirstLoad = false;
    }

    @Override
    public void openMovieDetails(Movie clickedMovie) {

    }

    public void loadMovies(boolean forceUpdate,final boolean showLoadingUI){
        if (showLoadingUI){
            mMovieView.setLoadingIndicator(true);
        }
        if (forceUpdate){
            mIDoubanService.searchHotMovies().enqueue(new Callback<HotMoviesInfo>() {
                @Override
                public void onResponse(Call<HotMoviesInfo> call, Response<HotMoviesInfo> response) {
                    List<Movie> movieList = response.body().getMovies();
                    //获取数据成功
                    if (showLoadingUI)
                        mMovieView.setLoadingIndicator(false);
                    processMovies(movieList);
                }

                @Override
                public void onFailure(Call<HotMoviesInfo> call, Throwable t) {
                    Log.d("tag", "ThreadID + " + Thread.currentThread().getId() + "erro:" + t.getMessage());
                    if (showLoadingUI)
                        mMovieView.setLoadingIndicator(false);
                    processEmptyTasks();
                }
            });
        }
    }
    private void processMovies(List<Movie> movies){
        if (movies.isEmpty()){
            processEmptyTasks();
        }else{
            mMovieView.showMovies(movies);
        }
    }
    private void processEmptyTasks(){
        //MoviesFragment 需要提示没有数据
        mMovieView.showNoMovies();
    }
}
