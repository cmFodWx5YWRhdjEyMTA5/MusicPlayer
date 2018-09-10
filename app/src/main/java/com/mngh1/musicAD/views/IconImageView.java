package com.mngh1.musicAD.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.kabouzeid.appthemehelper.util.ATHUtil;
import com.mngh1.musicAD.R;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class IconImageView extends AppCompatImageView {
    public IconImageView(Context context) {
        super(context);
        init(context);
    }

    public IconImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        if (context == null) return;
//        setColorFilter(ATHUtil.resolveColor(context, R.attr.iconColor), PorterDuff.Mode.SRC_IN);
        setColorFilter(getResources().getColor(R.color.text_color_white), PorterDuff.Mode.SRC_IN);
    }
}
