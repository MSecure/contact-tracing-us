package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;

@Deprecated
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class GoogleApiClient {

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    @RecentlyNonNull
    public abstract <A extends Api.AnyClient, R extends Result, T extends BaseImplementation$ApiMethodImpl<R, A>> T enqueue(@RecentlyNonNull T t);

    @RecentlyNonNull
    public abstract Looper getLooper();
}
