package com.aaj.androidesgi;

/**
 * Created by Rainbow on 21/07/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aaj.androidesgi.model.Cast;
import com.aaj.androidesgi.model.Crew;
import com.aaj.androidesgi.model.Genre;
import com.aaj.androidesgi.model.MovieResult;

import java.util.LinkedList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AndroidESGIDB";

    private static final String KEY_ID = "_id";

    private static final String TABLE_MOVIES = "movies";
    private static final String KEY_BACKDROP_PATH = "backdrop_path";
    private static final String KEY_OVERVIEW = "overview";
    private static final String KEY_POSTER_PATH = "poster_path";
    private static final String KEY_RELEASE_DATE = "release_date";
    private static final String KEY_RUNTIME = "runtime";
    private static final String KEY_TITLE = "title";
    private static final String KEY_VOTE_AVERAGE = "vote_average";

    private static final String TABLE_GENRES_MOVIES = "genres_movies";
    private static final String KEY_ID_GENRE = "id_genre";
    private static final String KEY_ID_MOVIE = "id_movie";

    private static final String TABLE_GENRES = "genres";
    private static final String KEY_NAME = "name";

    private static final String TABLE_CASTS_MOVIES = "casts_movies";
    private static final String KEY_ID_CAST = "id_cast";

    private static final String TABLE_CASTS = "casts";

    private static final String TABLE_REALISATORS_MOVIES = "realisators_movies";
    private static final String KEY_ID_REALISATOR = "id_realisator";

    private static final String TABLE_REALISATORS = "realisators";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_MOVIES + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_BACKDROP_PATH +" TEXT, "+
                KEY_OVERVIEW +" TEXT, "+
                KEY_POSTER_PATH +" TEXT, "+
                KEY_RELEASE_DATE +" TEXT, "+
                KEY_RUNTIME +" INTEGER, "+
                KEY_TITLE +" TEXT, "+
                KEY_VOTE_AVERAGE +" INTEGER)";

        String CREATE_GENRES_MOVIES_TABLE = "CREATE TABLE " + TABLE_GENRES_MOVIES + " ( " +
                KEY_ID_GENRE +" INTEGER, "+
                KEY_ID_MOVIE +" INTEGER,"+
                "PRIMARY KEY (" + KEY_ID_GENRE + ", " + KEY_ID_MOVIE +"))";

        String CREATE_GENRE_TABLE = "CREATE TABLE " + TABLE_GENRES + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME +" TEXT)";

        String CREATE_CASTS_MOVIES_TABLE = "CREATE TABLE " + TABLE_CASTS_MOVIES + " ( " +
                KEY_ID_CAST +" INTEGER, "+
                KEY_ID_MOVIE +" INTEGER,"+
                "PRIMARY KEY (" + KEY_ID_CAST + ", " + KEY_ID_MOVIE +"))";

        String CREATE_CAST_TABLE = "CREATE TABLE " + TABLE_CASTS + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME +" TEXT)";

        String CREATE_REALISATORS_MOVIES_TABLE = "CREATE TABLE " + TABLE_REALISATORS_MOVIES + " ( " +
                KEY_ID_REALISATOR +" INTEGER, "+
                KEY_ID_MOVIE +" INTEGER,"+
                "PRIMARY KEY (" + KEY_ID_REALISATOR + ", " + KEY_ID_MOVIE +"))";

        String CREATE_REALISATOR_TABLE = "CREATE TABLE " + TABLE_REALISATORS + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME +" TEXT)";

        db.execSQL(CREATE_MOVIE_TABLE);
        db.execSQL(CREATE_GENRES_MOVIES_TABLE);
        db.execSQL(CREATE_GENRE_TABLE);
        db.execSQL(CREATE_CASTS_MOVIES_TABLE);
        db.execSQL(CREATE_CAST_TABLE);
        db.execSQL(CREATE_REALISATORS_MOVIES_TABLE);
        db.execSQL(CREATE_REALISATOR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENRES_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENRES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASTS_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REALISATORS_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);

        // create fresh books table
        this.onCreate(db);
    }

    public void addMovie(MovieResult movie) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues movieValues = new ContentValues();
        movieValues.put(KEY_ID, movie.getId());
        movieValues.put(KEY_BACKDROP_PATH, movie.getBackdrop_path());
        movieValues.put(KEY_OVERVIEW, movie.getOverview());
        movieValues.put(KEY_POSTER_PATH, movie.getPoster_path());
        movieValues.put(KEY_RELEASE_DATE, movie.getRelease_date());
        movieValues.put(KEY_RUNTIME, movie.getRuntime());
        movieValues.put(KEY_TITLE, movie.getTitle());
        movieValues.put(KEY_VOTE_AVERAGE, movie.getVote_average());

        db.insertWithOnConflict(TABLE_MOVIES,
                null,
                movieValues, SQLiteDatabase.CONFLICT_IGNORE);


        ContentValues genreValues;
        for (Genre genre : movie.getGenres()) {
            genreValues = new ContentValues();
            genreValues.put(KEY_ID, genre.getId());
            genreValues.put(KEY_NAME, genre.getName());
            db.insertWithOnConflict(TABLE_GENRES, null, genreValues, SQLiteDatabase.CONFLICT_IGNORE);

            genreValues = new ContentValues();
            genreValues.put(KEY_ID_GENRE, genre.getId());
            genreValues.put(KEY_ID_MOVIE, movie.getId());
            db.insertWithOnConflict(TABLE_GENRES_MOVIES, null, genreValues, SQLiteDatabase.CONFLICT_IGNORE);
        }

        db.close();
    }

    public void addRealisators(List<Crew> crew, int idMovie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues crewValues;
        for (Crew c : crew) {
            crewValues = new ContentValues();
            crewValues.put(KEY_ID, c.getId());
            crewValues.put(KEY_NAME, c.getName());
            db.insertWithOnConflict(TABLE_REALISATORS, null, crewValues, SQLiteDatabase.CONFLICT_IGNORE);

            crewValues = new ContentValues();
            crewValues.put(KEY_ID_REALISATOR, c.getId());
            crewValues.put(KEY_ID_MOVIE, idMovie);
            db.insertWithOnConflict(TABLE_REALISATORS_MOVIES, null, crewValues, SQLiteDatabase.CONFLICT_IGNORE);
        }

        db.close();
    }

    public void addCast(List<Cast> cast, int idMovie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues crewValues;
        for (Cast c : cast) {
            crewValues = new ContentValues();
            crewValues.put(KEY_ID, c.getId());
            crewValues.put(KEY_NAME, c.getName());
            db.insertWithOnConflict(TABLE_CASTS, null, crewValues, SQLiteDatabase.CONFLICT_IGNORE);

            crewValues = new ContentValues();
            crewValues.put(KEY_ID_CAST, c.getId());
            crewValues.put(KEY_ID_MOVIE, idMovie);
            db.insertWithOnConflict(TABLE_CASTS_MOVIES, null, crewValues, SQLiteDatabase.CONFLICT_IGNORE);
        }

        db.close();
    }

    public List<MovieResult> getAllMovies() {
        List<MovieResult> movies = new LinkedList<MovieResult>();

        String query = "SELECT  * FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        MovieResult movie = null;
        if (cursor.moveToFirst()) {
            do {
                movie = new MovieResult();
                movie.setId(Integer.parseInt(cursor.getString(0)));
                movie.setBackdrop_path(cursor.getString(1));
                movie.setOverview(cursor.getString(2));
                movie.setPoster_path(cursor.getString(3));
                movie.setRelease_date(cursor.getString(4));
                movie.setRuntime(Integer.parseInt(cursor.getString(5)));
                movie.setTitle(cursor.getString(6));
                movie.setVote_average(Double.parseDouble(cursor.getString(7)));


                List<Genre> genres = new LinkedList<Genre>();
                String query2 = "SELECT " + TABLE_GENRES + "." + KEY_ID + "," + TABLE_GENRES + "." + KEY_NAME + " FROM " + TABLE_GENRES + ", " + TABLE_GENRES_MOVIES + " WHERE " + TABLE_GENRES_MOVIES + "." + KEY_ID_GENRE + "=" + TABLE_GENRES + "." + KEY_ID + " AND " + TABLE_GENRES_MOVIES + "." + KEY_ID_MOVIE + "=" + cursor.getString(0);

                Cursor cursor2 = db.rawQuery(query2, null);
                Genre genre = null;
                if(cursor2.moveToFirst()) {
                    do{
                        genre = new Genre();
                        genre.setId(Integer.parseInt(cursor2.getString(0)));
                        genre.setName(cursor2.getString(1));

                        genres.add(genre);
                    } while (cursor2.moveToNext());
                }

                movie.setGenres(genres);

                // Add book to books
                movies.add(movie);
            } while (cursor.moveToNext());
        }

        // return books
        return movies;
    }

    public List<Crew> getCrew(int idMovie) {
        List<Crew> crew = new LinkedList<Crew>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query2 = "SELECT " + TABLE_REALISATORS + "." + KEY_ID + "," + TABLE_REALISATORS + "." + KEY_NAME + " FROM " + TABLE_REALISATORS + ", " + TABLE_REALISATORS_MOVIES + " WHERE " + TABLE_REALISATORS_MOVIES + "." + KEY_ID_REALISATOR + "=" + TABLE_REALISATORS + "." + KEY_ID + " AND " + TABLE_REALISATORS_MOVIES + "." + KEY_ID_MOVIE + "=" + idMovie;

        Cursor cursor = db.rawQuery(query2, null);
        Crew c = null;
        if(cursor.moveToFirst()) {
            do{
                c = new Crew();
                c.setId(Integer.parseInt(cursor.getString(0)));
                c.setName(cursor.getString(1));

                crew.add(c);
            } while (cursor.moveToNext());
        }
        return crew;
    }

    public List<Cast> getCast(int idMovie) {
        List<Cast> cast = new LinkedList<Cast>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query2 = "SELECT " + TABLE_CASTS + "." + KEY_ID + "," + TABLE_CASTS + "." + KEY_NAME + " FROM " + TABLE_CASTS + ", " + TABLE_CASTS_MOVIES + " WHERE " + TABLE_CASTS_MOVIES + "." + KEY_ID_CAST + "=" + TABLE_CASTS + "." + KEY_ID + " AND " + TABLE_CASTS_MOVIES + "." + KEY_ID_MOVIE + "=" + idMovie;

        Cursor cursor = db.rawQuery(query2, null);
        Cast c = null;
        if(cursor.moveToFirst()) {
            do{
                c = new Cast();
                c.setId(Integer.parseInt(cursor.getString(0)));
                c.setName(cursor.getString(1));

                cast.add(c);
            } while (cursor.moveToNext());
        }
        return cast;
    }

    public void deleteMovie(MovieResult movie) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_MOVIES, KEY_ID + " = ?", new String[]{String.valueOf(movie.getId())});
        String query1 = "DELETE FROM " + TABLE_GENRES + " WHERE " + KEY_ID + " IN (SELECT " + KEY_ID_GENRE + " FROM " + TABLE_GENRES_MOVIES + " WHERE " + KEY_ID_MOVIE + " = " + movie.getId() + ")";
        db.execSQL(query1);
        db.delete(TABLE_GENRES_MOVIES, KEY_ID_MOVIE+" = ?", new String[] {String.valueOf(movie.getId())});
        String query2 = "DELETE FROM " + TABLE_REALISATORS + " WHERE " + KEY_ID + " IN (SELECT " + KEY_ID_REALISATOR + " FROM " + TABLE_REALISATORS_MOVIES + " WHERE " + KEY_ID_MOVIE + " = " + movie.getId() + ")";
        db.execSQL(query2);
        db.delete(TABLE_REALISATORS_MOVIES, KEY_ID_MOVIE+" = ?", new String[] {String.valueOf(movie.getId())});
        String query3 = "DELETE FROM " + TABLE_CASTS + " WHERE " + KEY_ID + " IN (SELECT " + KEY_ID_CAST + " FROM " + TABLE_CASTS_MOVIES + " WHERE " + KEY_ID_MOVIE + " = " + movie.getId() + ")";
        db.execSQL(query3);
        db.delete(TABLE_CASTS_MOVIES, KEY_ID_MOVIE+" = ?", new String[] {String.valueOf(movie.getId())});

        db.close();
    }

    public boolean isInFavorite(MovieResult movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + TABLE_MOVIES + " Where " + KEY_ID + " = " + movie.getId();
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

}