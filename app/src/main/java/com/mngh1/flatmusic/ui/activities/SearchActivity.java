package com.mngh1.flatmusic.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.mngh1.flatmusic.R;
import com.mngh1.flatmusic.adapter.SearchAdapter;
import com.mngh1.flatmusic.interfaces.LoaderIds;
import com.mngh1.flatmusic.loader.AlbumLoader;
import com.mngh1.flatmusic.loader.ArtistLoader;
import com.mngh1.flatmusic.loader.SongLoader;
import com.mngh1.flatmusic.misc.WrappedAsyncTaskLoader;
import com.mngh1.flatmusic.ui.activities.base.AbsMusicServiceActivity;
import com.mngh1.flatmusic.util.PreferenceUtil;
import com.mngh1.flatmusic.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AbsMusicServiceActivity implements SharedPreferences.OnSharedPreferenceChangeListener,SearchView.OnQueryTextListener, LoaderManager.LoaderCallbacks<List<Object>> {
    public static final String TAG = SearchActivity.class.getSimpleName();
    public static final String QUERY = "query";
    private static final int LOADER_ID = LoaderIds.SEARCH_ACTIVITY;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(android.R.id.empty)
    TextView empty;
    @BindView(R.id.search_layout)
    LinearLayout search_layout;

    SearchView searchView;

    private SearchAdapter adapter;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setDrawUnderStatusbar(true);
        ButterKnife.bind(this);

        setStatusbarColorAuto();
        setNavigationbarColorAuto();
        setTaskDescriptionColorAuto();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchAdapter(this, Collections.emptyList());
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                empty.setVisibility(adapter.getItemCount() < 1 ? View.VISIBLE : View.GONE);
            }
        });
        recyclerView.setAdapter(adapter);

        recyclerView.setOnTouchListener((v, event) -> {
            hideSoftKeyboard();
            return false;
        });

        setUpToolBar();
        setUpBackground();

        if (savedInstanceState != null) {
            query = savedInstanceState.getString(QUERY);
        }

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (PreferenceUtil.CHANGE_THEME.equals(s)){
            setUpBackground();
        }
    }

    private void setUpBackground() {
        String bg = PreferenceUtil.getInstance(this).getChangeTheme();
        switch (bg) {
            case "them1":
                search_layout.setBackgroundResource(R.drawable.bg1);
                break;
            case "them2":
                search_layout.setBackgroundResource(R.drawable.bg2);
                break;
            case "them3":
                search_layout.setBackgroundResource(R.drawable.bg3);
                break;
            case "them4":
                search_layout.setBackgroundResource(R.drawable.bg4);
                break;
            case "them5":
                search_layout.setBackgroundResource(R.drawable.bg5);
                break;
            case "them6":
                search_layout.setBackgroundResource(R.drawable.bg6);
                break;
            case "them8":
                search_layout.setBackgroundResource(R.drawable.bg8);
                break;
            case "them7":
                search_layout.setBackgroundResource(R.drawable.bg7);
                break;
            case "them9":
                search_layout.setBackgroundResource(R.drawable.bg9);
                break;
            case "them10":
                search_layout.setBackgroundResource(R.drawable.bg10);
                break;
            case "them11":
                search_layout.setBackgroundResource(R.drawable.bg11);
                break;
            default:
                search_layout.setBackgroundResource(R.drawable.bg1);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(QUERY, query);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setUpToolBar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.statusbar_color));
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem searchItem = menu.findItem(R.id.search);
//        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView = (SearchView) searchItem.getActionView();

        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchItem.expandActionView();
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                onBackPressed();
                return false;
            }
        });

//        MenuItemCompat.expandActionView(searchItem);
//        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                onBackPressed();
//                return false;
//            }
//        });

        searchView.setQuery(query, false);
        searchView.post(() -> searchView.setOnQueryTextListener(SearchActivity.this));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void search(@NonNull String query) {
        this.query = query;
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }

    @Override
    public void onMediaStoreChanged() {
        super.onMediaStoreChanged();
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        hideSoftKeyboard();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        search(newText);
        return false;
    }

    private void hideSoftKeyboard() {
        Util.hideSoftKeyboard(SearchActivity.this);
        if (searchView != null) {
            searchView.clearFocus();
        }
    }

    @NonNull
    @Override
    public Loader<List<Object>> onCreateLoader(int id, Bundle args) {
        return new AsyncSearchResultLoader(this, query);
    }


    @Override
    public void onLoadFinished(@NonNull Loader<List<Object>> loader, List<Object> data) {
        adapter.swapDataSet(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Object>> loader) {
        adapter.swapDataSet(Collections.emptyList());
    }

    private static class AsyncSearchResultLoader extends WrappedAsyncTaskLoader<List<Object>> {
        private final String query;

        public AsyncSearchResultLoader(Context context, String query) {
            super(context);
            this.query = query;
        }

        @Override
        public List<Object> loadInBackground() {
            List<Object> results = new ArrayList<>();
            if (!TextUtils.isEmpty(query)) {
                List songs = SongLoader.getSongs(getContext(), query.trim());
                if (!songs.isEmpty()) {
                    results.add(getContext().getResources().getString(R.string.songs));
                    results.addAll(songs);
                }

                List artists = ArtistLoader.getArtists(getContext(), query.trim());
                if (!artists.isEmpty()) {
                    results.add(getContext().getResources().getString(R.string.artists));
                    results.addAll(artists);
                }

                List albums = AlbumLoader.getAlbums(getContext(), query.trim());
                if (!albums.isEmpty()) {
                    results.add(getContext().getResources().getString(R.string.albums));
                    results.addAll(albums);
                }
            }
            return results;
        }
    }
}
