package com.mngh1.flatmusic.model;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (mngh1)
 */

public abstract class AbsCustomPlaylist extends Playlist {
    public AbsCustomPlaylist(int id, String name) {
        super(id, name);
    }

    public AbsCustomPlaylist() {
    }

    public AbsCustomPlaylist(Parcel in) {
        super(in);
    }

    @NonNull
    public abstract ArrayList<Song> getSongs(Context context);
}
