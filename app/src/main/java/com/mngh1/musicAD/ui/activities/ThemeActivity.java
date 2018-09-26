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
    @BindView(R.id.theme4)
    ImageView theme4;
    @BindView(R.id.theme5)
    ImageView theme5;
    @BindView(R.id.theme6)
    ImageView theme6;
    @BindView(R.id.theme7)
    ImageView theme7;
    @BindView(R.id.theme8)
    ImageView theme8;
    @BindView(R.id.theme9)
    ImageView theme9;
    @BindView(R.id.theme10)
    ImageView theme10;
    @BindView(R.id.theme11)
    ImageView theme11;



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
                theme.setBackgroundResource(R.drawable.bg1);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them1");
            }
        });

        theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg2);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them2");
            }
        });

        theme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg3);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them3");
            }
        });

        theme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg4);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them4");
            }
        });

        theme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg5);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them5");
            }
        });

        theme6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg6);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them6");
            }
        });

        theme7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg7);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them7");
            }
        });

        theme8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg8);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them8");
            }
        });

        theme9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg9);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them9");
            }
        });

        theme10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg10);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them10");
            }
        });

        theme11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme.setBackgroundResource(R.drawable.bg11);
                PreferenceUtil.getInstance(getParent()).setChangeTheme("them11");
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
                theme.setBackgroundResource(R.drawable.bg1);
                break;
            case "them2":
                theme.setBackgroundResource(R.drawable.bg2);
                break;
            case "them3":
                theme.setBackgroundResource(R.drawable.bg3);
                break;
            case "them4":
                theme.setBackgroundResource(R.drawable.bg4);
                break;
            case "them5":
                theme.setBackgroundResource(R.drawable.bg5);
                break;
            default:
                theme.setBackgroundResource(R.drawable.bg1);
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
