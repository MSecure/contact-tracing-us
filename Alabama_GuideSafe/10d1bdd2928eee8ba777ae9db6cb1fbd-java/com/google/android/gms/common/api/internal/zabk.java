package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zabk<O extends Api.ApiOptions> extends zaz {
    @NotOnlyInitialized
    public final GoogleApi<O> zaa;

    public zabk(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zaa = googleApi;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation$ApiMethodImpl<R, A>> T enqueue(T t) {
        GoogleApi<O> googleApi = this.zaa;
        if (googleApi != null) {
            t.zap = t.zap || BasePendingResult.zaa.get().booleanValue();
            GoogleApiManager googleApiManager = googleApi.zaj;
            if (googleApiManager != null) {
                zad zad = new zad(0, t);
                Handler handler = googleApiManager.zaq;
                handler.sendMessage(handler.obtainMessage(4, new zabr(zad, googleApiManager.zal.get(), googleApi)));
                return t;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zaa.zaf;
    }
}
