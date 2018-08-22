package com.aaj.androidesgi;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.aaj.androidesgi.model.MovieResult;

import java.util.ArrayList;
import java.util.List;

public abstract class FilmsFragment extends ListFragment {
    private static final String FILMS = "films";
    private static final String CURENT_PAGE = "current_page";
    protected List<MovieResult> films;
    ListView listViewFilm;
    FilmAdapter adapter;
    int currentMaxPage = 0;
    boolean flag_loading;
    FragmentTransaction fragmentTransaction;

    public FilmsFragment(){

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(FILMS, (ArrayList<? extends Parcelable>) films);
        outState.putInt(CURENT_PAGE, currentMaxPage);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            films = savedInstanceState.getParcelableArrayList(FILMS);
            currentMaxPage = savedInstanceState.getInt(CURENT_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.film_list_fragment, container, false);
        if (films == null){
            films = new ArrayList<MovieResult>();
            loadMovies();
        }
        else if (currentMaxPage < 2)
            currentMaxPage = 1;

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
                    if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
                    {
                        if(flag_loading == false)
                        {
                            flag_loading = true;
                            loadMovies();
                        }
                    }
                }


            });
        }
        return view;
    }

    public void setFilms(List<MovieResult> movies){
        films = movies;
        if (adapter != null){
            adapter.updateReceiptsList(films);
        }
    }

    abstract void loadMovies();
}
