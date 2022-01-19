package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class ApiException extends Exception {
    @RecentlyNonNull
    @Deprecated
    public final Status mStatus;

    /* JADX WARNING: Illegal instructions before constructor call */
    public ApiException(@RecentlyNonNull Status status) {
        super(r3.toString());
        int i = status.zzc;
        String str = status.zzd;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        this.mStatus = status;
    }
}
