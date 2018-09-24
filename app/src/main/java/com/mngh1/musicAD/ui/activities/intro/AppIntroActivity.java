package com.mngh1.musicAD.ui.activities.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.mngh1.musicAD.R;
import com.mngh1.musicAD.ui.activities.EqualizerActivity;
import com.mngh1.musicAD.ui.activities.MainActivity;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class AppIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        new Handler().postDelayed(() -> startActivity(new Intent(AppIntroActivity.this, MainActivity.class)), 1500);
        finish();
    }
}
