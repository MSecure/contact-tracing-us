package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class SafeParcelReader$ParseException extends RuntimeException {
    /* JADX WARNING: Illegal instructions before constructor call */
    public SafeParcelReader$ParseException(@RecentlyNonNull String str, @RecentlyNonNull Parcel parcel) {
        super(r2.toString());
        int dataPosition = parcel.dataPosition();
        int dataSize = parcel.dataSize();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
        sb.append(str);
        sb.append(" Parcel: pos=");
        sb.append(dataPosition);
        sb.append(" size=");
        sb.append(dataSize);
    }
}
