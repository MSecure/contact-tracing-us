package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.e;
import c.b.a.a.d.m.c;
import com.google.android.gms.nearby.messages.MessagesOptions;

public final class zzat extends a.AbstractC0062a<zzai, MessagesOptions> {
    /* Return type fixed from 'c.b.a.a.d.k.a$f' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, c.b.a.a.d.m.c, java.lang.Object, c.b.a.a.d.k.e$a, c.b.a.a.d.k.e$b] */
    @Override // c.b.a.a.d.k.a.AbstractC0062a
    public final /* synthetic */ zzai buildClient(Context context, Looper looper, c cVar, MessagesOptions messagesOptions, e.a aVar, e.b bVar) {
        return new zzai(context, looper, aVar, bVar, cVar, messagesOptions);
    }

    @Override // c.b.a.a.d.k.a.e
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
