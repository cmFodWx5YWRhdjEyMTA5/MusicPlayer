package com.mngh1.flatmusic.ui.activities.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.mngh1.flatmusic.R;
import com.mngh1.flatmusic.ui.activities.MainActivity;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class AppIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(AppIntroActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);
    }
}
