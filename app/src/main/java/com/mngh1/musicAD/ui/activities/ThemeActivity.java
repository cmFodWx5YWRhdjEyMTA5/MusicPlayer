package com.mngh1.musicAD.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.kabouzeid.appthemehelper.ThemeStore;
import com.mngh1.musicAD.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThemeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.theme)
    LinearLayout theme;

    @BindView(R.id.theme1)
    ImageView theme1;

    @BindView(R.id.theme2)
    ImageView theme2;

    @BindView(R.id.theme3)
    ImageView theme3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);

        setUpToolbar();

        theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape1);
            }
        });

        theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape2);
            }
        });

        theme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape3);
            }
        });

    }

    private void setUpToolbar() {
        toolbar.setBackgroundColor(ThemeStore.primaryColor(this));
        toolbar.setTitle("Themes");
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
