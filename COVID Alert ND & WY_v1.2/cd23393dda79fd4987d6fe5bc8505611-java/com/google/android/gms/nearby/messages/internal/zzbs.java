package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.PublishCallback;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbs extends zzu {
    private static final zzkv<PublishCallback> zza = new zzbv();
    private final ListenerHolder<PublishCallback> zzb;

    public zzbs(ListenerHolder<PublishCallback> listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzv
    public final void a_() {
        this.zzb.notifyListener(zza);
    }
}
