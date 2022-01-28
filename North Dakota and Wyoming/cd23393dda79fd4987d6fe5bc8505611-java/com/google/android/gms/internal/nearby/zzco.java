package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzco implements OnFailureListener {
    private final /* synthetic */ GoogleApi zza;
    private final /* synthetic */ ListenerHolder.ListenerKey zzb;
    private final /* synthetic */ zzcp zzc;

    zzco(zzcp zzcp, GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey) {
        this.zzc = zzcp;
        this.zza = googleApi;
        this.zzb = listenerKey;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.zzc) {
            this.zzc.zza(this.zza, this.zzb);
        }
    }
}
