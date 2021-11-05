package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.i;
import c.b.a.a.c.k.o.d;
import c.b.a.a.c.k.o.e;
import c.b.a.a.c.k.o.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;

public abstract class zzbw extends d<Status, zzai> {
    public final k<e<Status>> zza;

    public zzbw(c.b.a.a.c.k.e eVar) {
        super(Nearby.MESSAGES_API, eVar);
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ i createFailedResult(Status status) {
        return status;
    }

    @Override // c.b.a.a.c.k.o.d, c.b.a.a.c.k.o.e
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((i) obj);
    }

    public final k<e<Status>> zza() {
        return this.zza;
    }
}
