package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    public UnsupportedApiCallException(@RecentlyNonNull Feature feature) {
        this.zza = feature;
    }

    @RecentlyNonNull
    public final String getMessage() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
