package com.aaj.androidesgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aaj.androidesgi.model.MovieResult;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends BaseAdapter {
    protected List<MovieResult> movies;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public FilmAdapter (Context context, List<MovieResult> mr){
        mContext = context;
        movies = mr;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layoutItem;
        ProgressBar progressBar = null;
        if (convertView == null){
            layoutItem = (RelativeLayout) mInflater.inflate(R.layout.film_item, parent, false);
        }else {
            layoutItem = (RelativeLayout) convertView;
        }

        progressBar = (ProgressBar) layoutItem.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        TextView filmTitle = (TextView) layoutItem.findViewById(R.id.filmTitle);
        ImageView filmPoster = (ImageView) layoutItem.findViewById(R.id.filmPoster);

        filmTitle.setText(movies.get(position).getTitle());

        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w92" + movies.get(position).getPoster_path()).into(filmPoster, new ImageLoadedCallback(progressBar) {
            @Override
            public void onSuccess() {
                if(this.progressBar != null) {
                    this.progressBar.setVisibility(View.GONE);
                }
            }
        });

        return layoutItem;
    }

    public void updateReceiptsList(List<MovieResult> newlist) {
        movies.clear();
        movies.addAll(newlist);
        this.notifyDataSetChanged();
    }

    protected class ImageLoadedCallback implements Callback {
        protected ProgressBar progressBar;

        public  ImageLoadedCallback(ProgressBar progBar){
            progressBar = progBar;
        }

        @Override
        public void onSuccess() {

        }

        @Override
        public void onError() {

        }
    }
}

