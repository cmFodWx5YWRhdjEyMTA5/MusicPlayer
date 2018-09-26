package com.mngh1.musicAD.helper.menu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.mngh1.musicAD.R;
import com.mngh1.musicAD.dialogs.AddToPlaylistDialog;
import com.mngh1.musicAD.dialogs.DeleteSongsDialog;
import com.mngh1.musicAD.dialogs.SongDetailDialog;
import com.mngh1.musicAD.helper.MusicPlayerRemote;
import com.mngh1.musicAD.interfaces.PaletteColorHolder;
import com.mngh1.musicAD.model.Song;
import com.mngh1.musicAD.ui.activities.tageditor.AbsTagEditorActivity;
import com.mngh1.musicAD.ui.activities.tageditor.SongTagEditorActivity;
import com.mngh1.musicAD.util.MusicUtil;
import com.mngh1.musicAD.util.NavigationUtil;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class SongMenuHelper {
    public static final int MENU_RES = R.menu.menu_item_song;

    public static boolean handleMenuClick(@NonNull FragmentActivity activity, @NonNull Song song, int menuItemId) {
        switch (menuItemId) {
            case R.id.action_set_as_ringtone:
                if (!MusicUtil.checkSystemWritePermission(activity)) return false;
                MusicUtil.setRingtone(activity, song.id);
                return true;
            case R.id.action_share:
                activity.startActivity(Intent.createChooser(MusicUtil.createShareSongFileIntent(song, activity), null));
                return true;
            case R.id.action_delete_from_device:
                DeleteSongsDialog.create(song).show(activity.getSupportFragmentManager(), "DELETE_SONGS");
                return true;
            case R.id.action_add_to_playlist:
                AddToPlaylistDialog.create(song).show(activity.getSupportFragmentManager(), "ADD_PLAYLIST");
                return true;
            case R.id.action_play_next:
                MusicPlayerRemote.playNext(song);
                return true;
            case R.id.action_add_to_current_playing:
                MusicPlayerRemote.enqueue(song);
                return true;
            case R.id.action_tag_editor:
                if (!MusicUtil.checkWriteExternalStoragePermission(activity)) return false;
                else {
                    Intent tagEditorIntent = new Intent(activity, SongTagEditorActivity.class);
                    tagEditorIntent.putExtra(AbsTagEditorActivity.EXTRA_ID, song.id);
                    if (activity instanceof PaletteColorHolder)
                        tagEditorIntent.putExtra(AbsTagEditorActivity.EXTRA_PALETTE, ((PaletteColorHolder) activity).getPaletteColor());
                    activity.startActivity(tagEditorIntent);
                    return true;
                }

            case R.id.action_details:
                SongDetailDialog.create(song).show(activity.getSupportFragmentManager(), "SONG_DETAILS");
                return true;
            case R.id.action_go_to_album:
                NavigationUtil.goToAlbum(activity, song.albumId);
                return true;
            case R.id.action_go_to_artist:
                NavigationUtil.goToArtist(activity, song.artistId);
                return true;
        }
        return false;
    }

    public static abstract class OnClickSongMenu implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        private AppCompatActivity activity;

        public OnClickSongMenu(@NonNull AppCompatActivity activity) {
            this.activity = activity;
        }

        public int getMenuRes() {
            return MENU_RES;
        }

        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(activity, v);
            popupMenu.inflate(getMenuRes());
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return handleMenuClick(activity, getSong(), item.getItemId());
        }

        public abstract Song getSong();
    }
}
