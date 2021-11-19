package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.StatusCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzkx extends zzkv<StatusCallback> {
    private final /* synthetic */ boolean zza;

    zzkx(zzky zzky, boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.zza);
    }
}
