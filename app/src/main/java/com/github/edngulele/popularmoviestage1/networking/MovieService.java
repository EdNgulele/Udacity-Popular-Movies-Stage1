package com.github.edngulele.popularmoviestage1.networking;

import com.github.edngulele.popularmoviestage1.model.MovieResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    //Top rated movies
    @GET("movie/top_rated")
    Call<MovieResults> getTopRatedMovies(@Query("page") int page, @Query("api_key") String apiKey);

    //Most popular movies
    @GET("movie/popular")
    Call<MovieResults> getPopularMovies(@Query("page") int page, @Query("api_key") String apiKey);
}
