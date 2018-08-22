package com.aaj.androidesgi;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aaj.androidesgi.model.Cast;
import com.aaj.androidesgi.model.CreditsResult;
import com.aaj.androidesgi.model.Crew;
import com.aaj.androidesgi.model.Genre;
import com.aaj.androidesgi.model.MovieResult;
import com.aaj.androidesgi.model.MoviesResult;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FilmDetailFragment extends Fragment {

    private static final String TAG = "Film Detail Fragment";
    private static final String MOVIE = "movie";
    MovieResult simpleMovie;
    boolean flag_loading = false;
    int current_page = 1;
    private LinearLayout layout;
    MySQLiteHelper sqliteHelper;
    boolean isInFavorite;
    boolean loadFavorite;
    Button btnAddFavorite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            simpleMovie=savedInstanceState.getParcelable(MOVIE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putParcelable(MOVIE, simpleMovie);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film_detail, container, false);

        sqliteHelper = new MySQLiteHelper(getActivity());

        btnAddFavorite = (Button) view.findViewById(R.id.button_filmAddFavorite);

        layout = (LinearLayout)view.findViewById(R.id.similarFilms);
        final HorizontalScrollView scrollView = (HorizontalScrollView) view.findViewById(R.id.scrollSimilarFilm);
        if(!loadFavorite) {

            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    int x = scrollView.getScrollX();
                    int sizeScrollView = scrollView.getWidth();
                    int sizeLayout = layout.getWidth();
                    if (x + sizeScrollView > sizeLayout - 300 && !flag_loading) {
                        RestAdapter restAdapter = new RestAdapter.Builder()
                                .setEndpoint(MainActivity.url)
                                .build();

                        MovieDBWebService service = restAdapter.create(MovieDBWebService.class);
                        if (simpleMovie != null) {
                            flag_loading = true;
                            service.moviesSimilar(simpleMovie.getId(), ++current_page, Locale.getDefault().getLanguage(), new Callback<MoviesResult>() {
                                @Override
                                public void success(MoviesResult moviesResult, Response response) {
                                    setMoviesSimilar(moviesResult.getResults());
                                    flag_loading = false;
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    Log.e("retrofit", error.getBody().toString());
                                }
                            });
                        }
                    }
                }
            });
        } else {
            layout.setVisibility(View.GONE);
        }

        if (simpleMovie != null){
            loadMovie(view);
        }
        return view;
    }

    public void setMovie(MovieResult m){
        simpleMovie = m;
        if (getView()!= null)
            loadMovie(getView());
    }

    private void loadMovie(View view){
        ImageView imgViewBackdrop = (ImageView) view.findViewById(R.id.imageViewBackdrop);

        if(!loadFavorite) {
            Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w780" + simpleMovie.getBackdrop_path()).into(imgViewBackdrop);

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(MainActivity.url)
                    .build();

            MovieDBWebService service = restAdapter.create(MovieDBWebService.class);
            service.movie(simpleMovie.getId(), Locale.getDefault().getLanguage(), new Callback<MovieResult>() {
                @Override
                public void success(MovieResult movie, Response response) {
                    simpleMovie = movie;
                    if (getView() != null) {
                        fillUI(movie, getView());
                        Toast.makeText(getActivity(), getResources().getString(R.string.toast_filmDetail) + movie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("retrofit", "failure");
                }
            });
        } else {
            fillUI(simpleMovie, view);
        }

    }

    private void fillUI(MovieResult movie, View view) {
        ImageView imgViewBackdrop = (ImageView) view.findViewById(R.id.imageView_filmPoster);
        TextView txtDate = (TextView) view.findViewById(R.id.textView_filmDate);
        TextView txtTitle = (TextView) view.findViewById(R.id.textView_FilmTitle);
        TextView txtGenre = (TextView) view.findViewById(R.id.textView_filmGenre);
        TextView txtDuree = (TextView) view.findViewById(R.id.textView_filmTime);
        TextView txtResume = (TextView) view.findViewById(R.id.textView_filmResume);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(movie.getRelease_date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        txtDate.setText(formattedDate);

        Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w342" + movie.getPoster_path()).into(imgViewBackdrop);

        txtTitle.setText(movie.getTitle());
        txtDuree.setText(movie.getRuntime() + "mn");
        txtResume.setText(movie.getOverview());
        String genres = "";
        for (Genre g : movie.getGenres()) {
            genres += g.getName() + ", ";
        }
        if(!genres.isEmpty()) {
            genres = genres.substring(0, genres.length()-2);
        }
        txtGenre.setText(genres);

        ratingBar.setRating(movie.getVote_average().floatValue() / 2);

        isInFavorite = sqliteHelper.isInFavorite(simpleMovie);
        if(isInFavorite) {
            btnAddFavorite.setText(getResources().getString(R.string.remove_from_favorite));
        } else {
            btnAddFavorite.setText(getResources().getString(R.string.add_to_favorite));
        }
        btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleMovie != null) {
                    if (isInFavorite) {
                        btnAddFavorite.setText(getResources().getString(R.string.add_to_favorite));
                        sqliteHelper.deleteMovie(simpleMovie);
                    } else {
                        btnAddFavorite.setText(getResources().getString(R.string.remove_from_favorite));
                        sqliteHelper.addMovie(simpleMovie);
                    }
                }
            }
        });

        if(!loadFavorite) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(MainActivity.url)
                    .build();

            MovieDBWebService service = restAdapter.create(MovieDBWebService.class);

            service.movieCredits(simpleMovie.getId(), Locale.getDefault().getLanguage(), new Callback<CreditsResult>() {
                @Override
                public void success(CreditsResult credits, Response response) {
                    if (getView() != null) {
                        fillCredits(credits, getView());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("retrofit", "failure");
                }
            });

            service.moviesSimilar(simpleMovie.getId(), current_page, Locale.getDefault().getLanguage(), new Callback<MoviesResult>() {
                @Override
                public void success(MoviesResult moviesResult, Response response) {
                    if (getView() != null) {
                        setMoviesSimilar(moviesResult.getResults());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("retrofit", error.getBody().toString());
                }
            });
        } else {
            fillCredits(null, view);
        }
    }

    private void setMoviesSimilar(final List<MovieResult> movies){
        if(getActivity() != null) {
            for (int i = 0; i < movies.size(); i++) {
                ImageView filmPoster = new ImageView(getActivity());
                final int finalI = i;
                filmPoster.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieResult film = movies.get(finalI);
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        FilmDetailFragment filmDetailFragment = new FilmDetailFragment();
                        filmDetailFragment.setMovie(film);
                        fragmentTransaction.replace(R.id.content_fragment, filmDetailFragment, "filmDetailFragmentJava");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Log.v(TAG, movies.get(finalI).getId() + "");
                    }
                });

                Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w342" + movies.get(i).getPoster_path()).into(filmPoster, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Log.v(TAG, "error when loading Similar film image");
                    }
                });
                layout.addView(filmPoster);
            }
        }
    }

    private void fillCredits(CreditsResult credits, View view) {
        TextView txtReal = (TextView) view.findViewById(R.id.textView_filmRealisator);
        TextView txtActors = (TextView) view.findViewById(R.id.textView_filmActor);

        if(credits == null) {
            credits = new CreditsResult();
            credits.setcast(sqliteHelper.getCast(simpleMovie.getId()));
            credits.setcrew(sqliteHelper.getCrew(simpleMovie.getId()));
        }


        Cast c = null;
        List<Cast> casts = new LinkedList<Cast>();
        String castStr = "";
        for (int i = 0; i < 5; i++) {
            c = credits.getCast(i);
            casts.add(c);
            castStr += c.getName() + ", ";
        }
        if(!castStr.isEmpty()) {
            castStr = castStr.substring(0, castStr.length()-2);
        }
        if(!casts.isEmpty()) {
            sqliteHelper.addCast(casts, simpleMovie.getId());
        }
        txtActors.setText(castStr);

        List<Crew> crews = new LinkedList<Crew>();
        String crewsStr = "";
        for (Crew crew : credits.getcrew()) {
            if(!loadFavorite) {
                if (crew.getDepartment().equals("Writing")) {
                    crewsStr += crew.getName() + ", ";
                    crews.add(crew);
                }
            } else {
                crewsStr += crew.getName() + ", ";
                crews.add(crew);
            }
        }
        if(!crewsStr.isEmpty()) {
            crewsStr = crewsStr.substring(0, crewsStr.length()-2);
        }
        if(!crews.isEmpty()) {
            sqliteHelper.addRealisators(crews, simpleMovie.getId());
        }
        txtReal.setText(crewsStr);

        View progressView = (View) view.findViewById(R.id.progressLayout);
        progressView.setVisibility(View.GONE);
    }

    public void setLoadFavorite(boolean boo) {
        loadFavorite = boo;
    }

}
