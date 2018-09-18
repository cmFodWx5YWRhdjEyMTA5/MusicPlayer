package com.mngh1.musicAD.ui.fragments.mainactivity.library.pager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;

import com.mngh1.musicAD.R;
import com.mngh1.musicAD.adapter.PlaylistAdapter;
import com.mngh1.musicAD.interfaces.LoaderIds;
import com.mngh1.musicAD.loader.PlaylistLoader;
import com.mngh1.musicAD.misc.WrappedAsyncTaskLoader;
import com.mngh1.musicAD.model.Playlist;
import com.mngh1.musicAD.model.smartplaylist.HistoryPlaylist;
import com.mngh1.musicAD.model.smartplaylist.LastAddedPlaylist;
import com.mngh1.musicAD.model.smartplaylist.MyTopTracksPlaylist;
import com.mngh1.musicAD.model.smartplaylist.ShuffleAllPlaylist;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class PlaylistsFragment extends AbsLibraryPagerRecyclerViewFragment<PlaylistAdapter, LinearLayoutManager> implements LoaderManager.LoaderCallbacks<ArrayList<Playlist>> {

    public static final String TAG = PlaylistsFragment.class.getSimpleName();

    private static final int LOADER_ID = LoaderIds.PLAYLISTS_FRAGMENT;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @NonNull
    @Override
    protected LinearLayoutManager createLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @NonNull
    @Override
    protected PlaylistAdapter createAdapter() {
        ArrayList<Playlist> dataSet = getAdapter() == null ? new ArrayList<>() : getAdapter().getDataSet();
        return new PlaylistAdapter(getLibraryFragment().getMainActivity(), dataSet, R.layout.item_list_single_row, getLibraryFragment());
    }

    @Override
    protected int getEmptyMessage() {
        return R.string.no_playlists;
    }

    @Override
    public void onMediaStoreChanged() {
        getLoaderManager().restartLoader(LOADER_ID, null, this);
    }

    @NonNull
    @Override
    public Loader<ArrayList<Playlist>> onCreateLoader(int id, Bundle args) {
        return new AsyncPlaylistLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Playlist>> loader, ArrayList<Playlist> data) {
        getAdapter().swapDataSet(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Playlist>> loader) {
        getAdapter().swapDataSet(new ArrayList<>());
    }

    private static class AsyncPlaylistLoader extends WrappedAsyncTaskLoader<ArrayList<Playlist>> {
        private AsyncPlaylistLoader(Context context) {
            super(context);
        }

        private static ArrayList<Playlist> getAllPlaylists(Context context) {
            ArrayList<Playlist> playlists = new ArrayList<>();

            playlists.add(new LastAddedPlaylist(context));
            playlists.add(new HistoryPlaylist(context));
            playlists.add(new MyTopTracksPlaylist(context));
//            playlists.add(new ShuffleAllPlaylist(context));

            playlists.addAll(PlaylistLoader.getAllPlaylists(context));

            return playlists;
        }

        @Override
        public ArrayList<Playlist> loadInBackground() {
            return getAllPlaylists(getContext());
        }
    }
}