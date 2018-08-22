package com.aaj.androidesgi;


import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SearchView;

import com.aaj.androidesgi.model.MovieResult;
import com.aaj.androidesgi.model.MoviesResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SearchFragment extends ListFragment {
    private static final String FILMS = "films";
    private static final String CURENT_PAGE = "current_page";
    private static final String QUERY = "query";
    protected List<MovieResult> films;
    ListView listViewFilm;
    FilmAdapter adapter;
    boolean flag_loading;
    FragmentTransaction fragmentTransaction;
    int currentPage = 0;
    String query;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(FILMS, (ArrayList<? extends Parcelable>) films);
        outState.putInt(CURENT_PAGE, currentPage);
        outState.putString(QUERY, query);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            films = savedInstanceState.getParcelableArrayList(FILMS);
            currentPage = savedInstanceState.getInt(CURENT_PAGE);
            query = savedInstanceState.getString(QUERY);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        MovieResult film = (MovieResult) adapter.getItem(position);
        FilmDetailFragment filmDetailFragment = (FilmDetailFragment) getChildFragmentManager().findFragmentById(R.id.filmDetailFragment2);
        if (filmDetailFragment != null && filmDetailFragment.isInLayout()){
            filmDetailFragment.setMovie(film);
        }
        else {
            fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
            filmDetailFragment = new FilmDetailFragment();
            filmDetailFragment.setMovie(film);
            fragmentTransaction.replace(R.id.content_fragment, filmDetailFragment, "filmDetailFragmentJava");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        //searchFragment = (SearchFragment) getChildFragmentManager().findFragmentById(R.id.searchListFragment);
        final SearchView search = (SearchView) view.findViewById(R.id.searchFilm);

        if (films == null){
            films = new ArrayList<MovieResult>();
        }

        adapter = new FilmAdapter(getActivity(), films);
        listViewFilm = (ListView) view.findViewById(android.R.id.list);
        listViewFilm.setAdapter(adapter);

        if (listViewFilm != null){
            listViewFilm.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0) {
                        if (flag_loading == false) {
                            flag_loading = true;
                            loadMovies();
                        }
                    }
                }


            });
        }

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                Log.v("SearchSubmit", query);
                setQuery(query);
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(MainActivity.url)
                        .build();

                MovieDBWebService service = restAdapter.create(MovieDBWebService.class);

                service.moviesSearch(query, ++currentPage, Locale.getDefault().getLanguage(), new Callback<MoviesResult>() {
                    @Override
                    public void success(MoviesResult movie, Response response) {
                        films.addAll(movie.getResults());
                        flag_loading = false;
                        adapter.notifyDataSetChanged();
                        Log.e("retrofit", "success");
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("retrofit", "failure");
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

    void loadMovies() {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(MainActivity.url)
                    .build();

            MovieDBWebService service = restAdapter.create(MovieDBWebService.class);

            service.moviesSearch(query, ++currentPage, Locale.getDefault().getLanguage(), new Callback<MoviesResult>() {
                @Override
                public void success(MoviesResult movie, Response response) {
                    films.addAll(movie.getResults());
                    flag_loading = false;
                    adapter.notifyDataSetChanged();
                    Log.e("retrofit", "success");
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("retrofit", "failure");
                }
            });
        }

    public void setQuery(String query) {
        this.query = query;
    }
}
