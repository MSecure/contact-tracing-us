package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzau extends zzbf {
    private final /* synthetic */ ListenerHolder zza;
    private final /* synthetic */ zzal zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzal zzal, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzb = zzal;
        this.zza = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbf, com.google.android.gms.nearby.messages.internal.zzv
    public final void a_() {
        ListenerHolder.ListenerKey<?> listenerKey = this.zza.getListenerKey();
        if (listenerKey != null) {
            this.zzb.doUnregisterEventListener(listenerKey);
        }
        super.a_();
    }
}
