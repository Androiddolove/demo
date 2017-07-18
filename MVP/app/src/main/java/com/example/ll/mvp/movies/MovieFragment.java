package com.example.ll.mvp.movies;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ll.mvp.R;
import com.example.ll.mvp.beans.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MoviesContract.View{
    @BindView(R.id.tv_movie)
    TextView mTvMovie;
    @BindView(R.id.rcv_movie)
    RecyclerView mRcvMovie;
    Unbinder unbinder;
    private List<Movie> mMovieList = new ArrayList<>();
    private MovieAdapter adapter;
    private MoviesContract.Presenter moviePresenter;
    private View mNoMoiveView;


    public MovieFragment() {
        // Required empty public constructor
    }
    public static MovieFragment newInstance(){
        return new MovieFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("tag", "onAttach MovieFragment");
        if (moviePresenter!=null){
            moviePresenter.start();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mRcvMovie!=null){
            mRcvMovie.setHasFixedSize(true);
            GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
            mRcvMovie.setLayoutManager(layoutManager);
            adapter = new MovieAdapter(getActivity(),mMovieList,R.layout.item_movie);
            mRcvMovie.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        moviePresenter = presenter;

    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.setData(movies);
    }

    @Override
    public void showNoMovies() {
        mRcvMovie.setVisibility(View.GONE);
    }

    @Override
    public void showMovieDetailUi(String movieName) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView()==null)return;
        final ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.pb_loading);
        if (active){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    static class MovieAdapter extends RecyclerView.Adapter<MoviesViewHolder>{
        private List<Movie> movies;
        private Context context;
        @LayoutRes
        private int layoutResId;
        public MovieAdapter(Context context,List<Movie> movieData,int layoutId){
            this.context = context;
            this.layoutResId = layoutId;
            this.movies = movieData;
        }
        public void setData(List<Movie> data){
            this.movies = data;
            notifyDataSetChanged();
        }

        @Override
        public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(layoutResId,parent,false);
            return new MoviesViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MoviesViewHolder holder, int position) {
            if (holder==null)return;
            holder.updataMovie(movies.get(position));
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }
    }
    static class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvRatingAverage;
        RatingBar movieRatingBar;
        Movie movie;
        public MoviesViewHolder(View itemView) {
            super(itemView);
            ivMovie = (ImageView) itemView.findViewById(R.id.iv_item_movie);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            tvRatingAverage = (TextView) itemView.findViewById(R.id.tv_movie_rating_average);
            movieRatingBar = (RatingBar) itemView.findViewById(R.id.rt_movie_star);
            itemView.setOnClickListener(this);
        }

        public void updataMovie(Movie movie){
            if (movie==null) return;
            this.movie = movie;
            Context context = itemView.getContext();
            Picasso.with(context)
                    .load(movie.getImages().getLarge())
                    .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                    .into(ivMovie);
            tvTitle.setText(movie.getTitle());
            final  double average = movie.getRating().getAverage();
            if (average==0.0){
                movieRatingBar.setVisibility(View.GONE);
                tvRatingAverage.setText(context.getResources().getString(R.string.no_rating));
            }else{
                movieRatingBar.setVisibility(View.VISIBLE);
                tvRatingAverage.setText(String.valueOf(average));
                movieRatingBar.setStepSize(0.5f);
                movieRatingBar.setRating((float)movie.getRating().getAverage()/2);
            }


        }

        @Override
        public void onClick(View v) {
            if (movie==null)return;
            if (itemView==null)return;
            Context context = itemView.getContext();
            if (context==null)return;
            Intent intent = new Intent(context,MovieDetailActivity.class);
            intent.putExtra("movie",movie);
            if (context instanceof Activity){
                Activity activity = (Activity) context;
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,ivMovie,"cover").toBundle();
                ActivityCompat.startActivity(activity,intent,bundle);
            }
        }
    }
}
