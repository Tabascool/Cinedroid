package com.aaj.androidesgi;

import android.app.ActionBar;
import android.content.Intent;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.aaj.androidesgi.model.MoviesResult;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";
    public static final String url = "http://api.themoviedb.org/3";

    private String[] menuItemTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private boolean doubleBackToExitPressedOnce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        menuItemTitles = getResources().getStringArray(R.array.menu_items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, menuItemTitles));
        // Set the list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        initializeFragmentList(getIntent());
    }

    private void initializeFragmentList(Intent intent){
                /*fragment Film List */
        fragmentManager = this.getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        PopularFilmListFragment popularFilmListFragment = new PopularFilmListFragment();
        MoviesResult moviesResult = intent.getParcelableExtra(SplashScreen.MOVIE_RESULT);
        if (moviesResult != null)
            popularFilmListFragment.setFilms(moviesResult.getResults());
        else popularFilmListFragment.setFilms(null);
        fragmentTransaction.add(R.id.content_fragment, popularFilmListFragment, "FilmListFragmentJava");
        fragmentTransaction.commit();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        while (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStackImmediate();
        }



        //setFavoriteButtonVisible(false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (position) {
            case 0 :
                SearchFragment searchFragment= new SearchFragment();
                transaction.replace(R.id.content_fragment, searchFragment);
                transaction.commit();
                break;
            case 1 :
                NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
                transaction.replace(R.id.content_fragment, nowPlayingFragment);
                transaction.commit();
                break;
            case 2 :
                FavoritesFragment favoritesFragment = new FavoritesFragment();
                transaction.replace(R.id.content_fragment, favoritesFragment);
                transaction.commit();
                break;
            default:
                break;
        }
        // Highlight the selected item, update the title, and close the drawer
        drawerList.setItemChecked(position, true);
        setActionBarTitle(menuItemTitles[position]);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }

    /*public void setFavoriteButtonVisible(boolean state) {
        View v = getSupportActionBar().getCustomView();
        ImageButton imgFav = (ImageButton) v.findViewById(R.id.imgFav);
        imgFav.setVisibility(state?View.VISIBLE:View.GONE);
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
            //setFavoriteButtonVisible(false);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getResources().getString(R.string.double_back_message), Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }
}
