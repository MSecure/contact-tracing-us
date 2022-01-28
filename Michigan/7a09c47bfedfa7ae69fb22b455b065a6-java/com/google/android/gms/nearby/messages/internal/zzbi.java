package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.g.e.ha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

public final class zzbi extends ha<SubscribeCallback> {
    @Override // c.b.a.a.d.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((SubscribeCallback) obj).onExpired();
    }
}
