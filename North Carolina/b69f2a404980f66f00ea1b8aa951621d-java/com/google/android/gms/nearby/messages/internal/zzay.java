package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.b;
import c.b.a.a.c.k.o.e;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;

public final class zzay implements e<Status> {
    public final /* synthetic */ i zza;

    public zzay(zzaj zzaj, i iVar) {
        this.zza = iVar;
    }

    @Override // c.b.a.a.c.k.o.e
    public final void setFailedResult(Status status) {
        i iVar = this.zza;
        iVar.f2856a.h(new b(status));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.a.a.c.k.o.e
    public final void setResult(Status status) {
        this.zza.f2856a.i(null);
    }
}
