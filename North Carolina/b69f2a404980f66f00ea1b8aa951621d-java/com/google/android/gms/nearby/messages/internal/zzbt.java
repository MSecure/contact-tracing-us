package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.e.c.ha;
import com.google.android.gms.nearby.messages.PublishCallback;

public final class zzbt extends ha<PublishCallback> {
    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PublishCallback) obj).onExpired();
    }
}
