package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.b;
import c.b.a.a.d.k.o.e;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;

public final class zzay implements e<Status> {
    public final /* synthetic */ j zza;

    public zzay(zzaj zzaj, j jVar) {
        this.zza = jVar;
    }

    @Override // c.b.a.a.d.k.o.e
    public final void setFailedResult(Status status) {
        j jVar = this.zza;
        jVar.f4109a.h(new b(status));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.a.a.d.k.o.e
    public final void setResult(Status status) {
        this.zza.f4109a.i(null);
    }
}
