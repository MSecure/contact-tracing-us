package com.google.android.gms.nearby.messages;

import com.google.android.gms.nearby.messages.internal.zzf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public interface Distance extends Comparable<Distance> {
    public static final Distance UNKNOWN = new zzf(1, Double.NaN);

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public @interface Accuracy {
        public static final int LOW = 1;
    }

    int compareTo(Distance distance);

    int getAccuracy();

    double getMeters();
}
