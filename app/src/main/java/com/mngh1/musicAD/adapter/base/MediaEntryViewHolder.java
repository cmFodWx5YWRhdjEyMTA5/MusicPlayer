package com.mngh1.musicAD.adapter.base;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mngh1.musicAD.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.claucookie.miniequalizerlibrary.EqualizerView;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class MediaEntryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    @Nullable
    @BindView(R.id.image)
    public ImageView image;

    @Nullable
    @BindView(R.id.image_text)
    public TextView imageText;

    @Nullable
    @BindView(R.id.title)
    public TextView title;

    @Nullable
    @BindView(R.id.text)
    public TextView text;

    @Nullable
    @BindView(R.id.menu)
    public View menu;

    @Nullable
    @BindView(R.id.equalizer_view)
    public EqualizerView equalizer_view;

    @Nullable
    @BindView(R.id.separator)
    public View separator;

    @Nullable
    @BindView(R.id.short_separator)
    public View shortSeparator;

    @Nullable
    @BindView(R.id.drag_view)
    public View dragView;

    @Nullable
    @BindView(R.id.palette_color_container)
    public View paletteColorContainer;

    public MediaEntryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    protected void setImageTransitionName(@NonNull String transitionName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && image != null) {
            image.setTransitionName(transitionName);
        }
    }



    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }

    public interface setUpEqualizer{
        void setEqualizer();
    }
}
