package com.mngh1.musicAD.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.bullhead.equalizer.EqualizerFragment;
import com.kabouzeid.appthemehelper.ThemeStore;
import com.mngh1.musicAD.R;
import com.mngh1.musicAD.helper.MusicPlayerRemote;


public class EqualizerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.black_color));

        int color = ThemeStore.accentColor(this);
        int sessionId = MusicPlayerRemote.getAudioSessionId();
        MusicPlayerRemote.setLooping(true);
        EqualizerFragment equalizerFragment = EqualizerFragment.newBuilder()
                .setAccentColor(color)
                .setAudioSessionId(sessionId)
                .build();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.eqFrame, equalizerFragment)
                .commit();
    }
}
