package com.mngh1.flatmusic.helper.menu;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.mngh1.flatmusic.R;
import com.mngh1.flatmusic.dialogs.AddToPlaylistDialog;
import com.mngh1.flatmusic.dialogs.DeleteSongsDialog;
import com.mngh1.flatmusic.helper.MusicPlayerRemote;
import com.mngh1.flatmusic.model.Song;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class SongsMenuHelper {
    public static boolean handleMenuClick(@NonNull FragmentActivity activity, @NonNull ArrayList<Song> songs, int menuItemId) {
        switch (menuItemId) {
            case R.id.action_play_next:
                MusicPlayerRemote.playNext(songs);
                return true;
            case R.id.action_add_to_current_playing:
                MusicPlayerRemote.enqueue(songs);
                return true;
            case R.id.action_add_to_playlist:
                AddToPlaylistDialog.create(songs).show(activity.getSupportFragmentManager(), "ADD_PLAYLIST");
                return true;
            case R.id.action_delete_from_device:
                DeleteSongsDialog.create(songs).show(activity.getSupportFragmentManager(), "DELETE_SONGS");
                return true;
        }
        return false;
    }
}
