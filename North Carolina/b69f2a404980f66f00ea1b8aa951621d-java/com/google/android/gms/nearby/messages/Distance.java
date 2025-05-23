package com.google.android.gms.nearby.messages;

import com.google.android.gms.nearby.messages.internal.zzd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Distance extends Comparable<Distance> {
    public static final Distance UNKNOWN = new zzd(1, Double.NaN);

    @Retention(RetentionPolicy.SOURCE)
    public @interface Accuracy {
        public static final int LOW = 1;
    }

    int compareTo(Distance distance);

    int getAccuracy();

    double getMeters();
}
