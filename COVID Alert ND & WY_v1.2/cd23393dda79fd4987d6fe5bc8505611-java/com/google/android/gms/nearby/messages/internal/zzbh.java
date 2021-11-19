package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class zzbh extends zzaa {
    private static final zzkv<SubscribeCallback> zza = new zzbg();
    private final ListenerHolder<SubscribeCallback> zzb;

    public zzbh(ListenerHolder<SubscribeCallback> listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzab
    public void b_() {
        ListenerHolder<SubscribeCallback> listenerHolder = this.zzb;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(zza);
        }
    }
}
