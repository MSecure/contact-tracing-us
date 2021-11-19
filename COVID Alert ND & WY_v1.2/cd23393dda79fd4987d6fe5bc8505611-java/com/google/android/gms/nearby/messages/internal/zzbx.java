package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbx extends zzaa {
    private static final zzkv<SubscribeCallback> zza = new zzbw();
    private final ListenerHolder<SubscribeCallback> zzb;

    public zzbx(ListenerHolder<SubscribeCallback> listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzab
    public final void b_() {
        this.zzb.notifyListener(zza);
    }
}
