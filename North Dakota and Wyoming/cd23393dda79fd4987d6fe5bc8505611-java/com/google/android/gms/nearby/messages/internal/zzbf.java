package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.PublishCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
class zzbf extends zzu {
    private static final zzkv<PublishCallback> zza = new zzbe();
    private final ListenerHolder<PublishCallback> zzb;

    public zzbf(ListenerHolder<PublishCallback> listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzv
    public void a_() {
        ListenerHolder<PublishCallback> listenerHolder = this.zzb;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(zza);
        }
    }
}
