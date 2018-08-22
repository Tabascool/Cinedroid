package com.aaj.androidesgi;



import com.aaj.androidesgi.model.CreditsResult;
import com.aaj.androidesgi.model.ImageResult;
import com.aaj.androidesgi.model.MovieResult;
import com.aaj.androidesgi.model.MoviesPlusResult;
import com.aaj.androidesgi.model.MoviesResult;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface MovieDBWebService {

    @GET("/movie/{id}?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void movie(@Path("id") int movieId, @Query("language") String language, Callback<MovieResult> movie);

    @GET("/movie/now_playing?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void moviesPlaying(@Query("page") int pageNum, @Query("language") String language, Callback<MoviesPlusResult> movies);

    @GET("/movie/popular?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void moviesPopular(@Query("page") int pageNum, @Query("language") String language, Callback<MoviesResult> movies);

    @GET("/search/movie?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void moviesSearch(@Query("query") String query, @Query("page") int pageNum, @Query("language") String language, Callback<MoviesResult> movies);

    @GET("/movie/{id}/images?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void movieImage(@Path("id") int movieId, @Query("language") String language, Callback<ImageResult> images);

    @GET("/movie/{id}/similar?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void moviesSimilar(@Path("id") int movieId, @Query("page") int pageNum, @Query("language") String language, Callback<MoviesResult> movies);

    @GET("/movie/{id}/credits?api_key=5c59915d0ced5516f542d6ec01162f8d")
    public void movieCredits(@Path("id") int movieId, @Query("language") String language, Callback<CreditsResult> credits);
}
