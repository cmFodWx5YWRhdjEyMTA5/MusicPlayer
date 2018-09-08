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

public class ThemeActivity extends AbsBaseActivity {

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
//        setNavigationbarColorAuto();
//        setTaskDescriptionColorAuto();
        setUpToolbar();
//        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
