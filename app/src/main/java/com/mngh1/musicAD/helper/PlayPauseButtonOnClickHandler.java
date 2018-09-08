package com.mngh1.musicAD.helper;

import android.view.View;

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
