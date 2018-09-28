package com.mngh1.flatmusic.helper;

import android.os.Message;
import android.view.View;

import com.mngh1.flatmusic.adapter.base.MediaEntryViewHolder;
import com.mngh1.flatmusic.adapter.song.SongAdapter;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class PlayPauseButtonOnClickHandler implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        if (MusicPlayerRemote.isPlaying()) {
            MusicPlayerRemote.pauseSong();
        } else {
            MusicPlayerRemote.resumePlaying();
        }

    }
}
