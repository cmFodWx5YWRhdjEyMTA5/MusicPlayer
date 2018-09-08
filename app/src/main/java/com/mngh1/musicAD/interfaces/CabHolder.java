package com.mngh1.musicAD.interfaces;

import android.support.annotation.NonNull;

import com.afollestad.materialcab.MaterialCab;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public interface CabHolder {

    @NonNull
    MaterialCab openCab(final int menuRes, final MaterialCab.Callback callback);
}
