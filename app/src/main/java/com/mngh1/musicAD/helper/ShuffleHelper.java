package com.mngh1.musicAD.helper;

import android.support.annotation.NonNull;

import com.mngh1.musicAD.model.Song;

import java.util.Collections;
import java.util.List;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class ShuffleHelper {

    public static void makeShuffleList(@NonNull List<Song> listToShuffle, final int current) {
        if (listToShuffle.isEmpty()) return;
        if (current >= 0) {
            Song song = listToShuffle.remove(current);
            Collections.shuffle(listToShuffle);
            listToShuffle.add(0, song);
        } else {
            Collections.shuffle(listToShuffle);
        }
    }
}
