package com.aaj.androidesgi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.widget.Toast;

import com.aaj.androidesgi.model.MoviesResult;

import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SplashScreen extends Activity {

    // Temps d'affichage du SplashScreen
    private static int SPLASH_TIME_OUT = 3000;
    public static final String MOVIE_RESULT = "movie_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(MainActivity.url)
                .build();

        MovieDBWebService service = restAdapter.create(MovieDBWebService.class);

        service.moviesPopular(1, Locale.getDefault().getLanguage(), new Callback<MoviesResult>() {
            @Override
            public void success(MoviesResult movie, Response response) {
                launchMainActivity(movie);
                Log.e("retrofit", "success");
            }

            @Override
            public void failure(RetrofitError error) {
                launchMainActivity(null);
                Log.e("retrofit", "failure");
            }
        });
    }

    private void launchMainActivity(MoviesResult moviesResult){
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        intent.putExtra(MOVIE_RESULT, (android.os.Parcelable) moviesResult);
        startActivity(intent);
    }
}