package com.example.ll.mvp.movies;

import com.example.ll.mvp.BasePresenter;
import com.example.ll.mvp.BaseView;
import com.example.ll.mvp.beans.Movie;

import java.util.List;

/**
 * Created by LL on 2017/7/6.
 */

public interface MoviesContract {
    interface View extends BaseView<Presenter> {
        void showMovies(List<Movie> movies);
        void showNoMovies();
        void showMovieDetailUi(String movieName);
        void setLoadingIndicator(boolean active);
    }
    interface Presenter extends BasePresenter{
        void loadMovies(boolean forceUpdate);
        void openMovieDetails(Movie clickedMovie);
    }
}
