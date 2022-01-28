package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.PublishCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzbv extends zzkv<PublishCallback> {
    zzbv() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PublishCallback) obj).onExpired();
    }
}
