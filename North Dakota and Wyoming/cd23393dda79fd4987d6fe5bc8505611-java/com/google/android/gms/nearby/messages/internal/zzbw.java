package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zzkv;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzbw extends zzkv<SubscribeCallback> {
    zzbw() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((SubscribeCallback) obj).onExpired();
    }
}
