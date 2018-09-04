package com.mngh1.gramophone.glide.artistimage;

/**
 * @author Karim Abou Zeid (mngh1)
 */
public class ArtistImage {
    public final String artistName;
    public final boolean skipOkHttpCache;

    public ArtistImage(String artistName, boolean skipOkHttpCache) {
        this.artistName = artistName;
        this.skipOkHttpCache = skipOkHttpCache;
    }
}
