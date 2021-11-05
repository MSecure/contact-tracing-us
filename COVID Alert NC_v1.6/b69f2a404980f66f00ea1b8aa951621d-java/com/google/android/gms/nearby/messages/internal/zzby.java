package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.e.c.ha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

public final class zzby extends ha<SubscribeCallback> {
    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((SubscribeCallback) obj).onExpired();
    }
}
