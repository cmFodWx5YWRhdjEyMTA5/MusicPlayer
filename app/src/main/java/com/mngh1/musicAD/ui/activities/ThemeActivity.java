package com.mngh1.musicAD.ui.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.kabouzeid.appthemehelper.ThemeStore;
import com.mngh1.musicAD.R;
import com.mngh1.musicAD.ui.activities.base.AbsBaseActivity;
import com.mngh1.musicAD.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThemeActivity extends AbsBaseActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

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

//    private SharedPreferences sp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);
        setDrawUnderStatusbar(true);
        setStatusbarColorAuto();
        setUpToolbar();
        setUpBackground();

        theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape1);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them1");
            }
        });

        theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape2);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them2");
            }
        });

        theme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.landscape3);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them3");
            }
        });

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (PreferenceUtil.CHANGE_THEME.equals(s)){
            setUpBackground();
        }
    }

    private void setUpBackground() {
        String bg = PreferenceUtil.getInstance(this).getChangeTheme();
        switch (bg) {
            case "them1":
                theme.setBackgroundResource(R.drawable.landscape1);
                break;
            case "them2":
                theme.setBackgroundResource(R.drawable.landscape2);
                break;
            case "them3":
                theme.setBackgroundResource(R.drawable.landscape3);
                break;
            default:
                theme.setBackgroundResource(R.drawable.landscape1);
                break;
        }
    }

    private void setUpToolbar() {
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        toolbar.setTitle("Themes");
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
