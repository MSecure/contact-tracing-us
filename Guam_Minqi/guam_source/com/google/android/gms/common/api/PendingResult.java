package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class PendingResult<R extends Result> {

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface StatusListener {
        void onComplete(@RecentlyNonNull Status status);
    }
}
