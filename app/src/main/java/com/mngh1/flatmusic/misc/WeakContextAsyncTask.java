package com.mngh1.flatmusic.misc;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public abstract class WeakContextAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private WeakReference<Context> contextWeakReference;

    public WeakContextAsyncTask(Context context) {
        contextWeakReference = new WeakReference<>(context);
    }

    @Nullable
    protected Context getContext() {
        return contextWeakReference.get();
    }
}
