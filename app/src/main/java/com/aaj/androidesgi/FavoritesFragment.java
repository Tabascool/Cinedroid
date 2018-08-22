package com.aaj.androidesgi;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aaj.androidesgi.model.MovieResult;

import java.util.List;


/**
 * Created by Rainbow on 18/07/2015.
 */
public class FavoritesFragment extends ListFragment {

    List<MovieResult> films;
    FilmAdapter adapter;
    ListView listViewFilm;
    MySQLiteHelper sqliteHelper;
    FragmentTransaction fragmentTransaction;

    public FavoritesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.film_list_fragment, container, false);

        MySQLiteHelper sqliteHelper = new MySQLiteHelper(getActivity());

        if (films == null){
            films = sqliteHelper.getAllMovies();
        }

        adapter = new FilmAdapter(getActivity(), films);
        listViewFilm = (ListView) view.findViewById(android.R.id.list);
        listViewFilm.setAdapter(adapter);


        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        MovieResult film = (MovieResult) adapter.getItem(position);
        FilmDetailFragment filmDetailFragment = (FilmDetailFragment) getChildFragmentManager().findFragmentById(R.id.filmDetailFragment);
        if (filmDetailFragment != null && filmDetailFragment.isInLayout()) {
            filmDetailFragment.setMovie(film);
        } else {
            fragmentTransaction = getFragmentManager().beginTransaction();
            filmDetailFragment = new FilmDetailFragment();
            filmDetailFragment.setMovie(film);
            filmDetailFragment.setLoadFavorite(true);
            fragmentTransaction.replace(R.id.content_fragment, filmDetailFragment, "filmDetailFragmentJava");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
