package com.aaj.androidesgi;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.aaj.androidesgi.model.MovieResult;
import com.aaj.androidesgi.model.MoviesPlusResult;

import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Rainbow on 18/07/2015.
 */
public class NowPlayingFragment extends FilmsFragment {

    private static final String TAG = "NowPlayingFilmList";

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        MovieResult film = (MovieResult) adapter.getItem(position);
        FilmDetailFragment filmDetailFragment = (FilmDetailFragment) getChildFragmentManager().findFragmentById(R.id.filmDetailFragment);
        if (filmDetailFragment != null && filmDetailFragment.isInLayout()){
            Log.v(TAG, "landscape ");
            filmDetailFragment.setMovie(film);
        }
        else {
            fragmentTransaction = getFragmentManager().beginTransaction();
            filmDetailFragment = new FilmDetailFragment();
            filmDetailFragment.setMovie(film);
            fragmentTransaction.replace(R.id.content_fragment, filmDetailFragment, "filmDetailFragmentJava");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    void loadMovies() {
        currentMaxPage++;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(MainActivity.url)
                .build();

        MovieDBWebService service = restAdapter.create(MovieDBWebService.class);

        service.moviesPlaying(currentMaxPage, Locale.getDefault().getLanguage(), new Callback<MoviesPlusResult>() {
            @Override
            public void success(MoviesPlusResult movie, Response response) {
                films.addAll(movie.getResults());
                flag_loading = false;
                adapter.notifyDataSetChanged();
                Log.e("retrofit", "success");
                Toast.makeText(getActivity(), getResources().getString(R.string.toast_welcome), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("retrofit", "failure");
            }
        });
    }
}
