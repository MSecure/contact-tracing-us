package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.j.d;
import c.b.a.a.j.i;
import c.b.a.a.j.j;

public final class zzax implements d<Boolean> {
    public final /* synthetic */ j zza;

    public zzax(zzaj zzaj, j jVar) {
        this.zza = jVar;
    }

    @Override // c.b.a.a.j.d
    public final void onComplete(i<Boolean> iVar) {
        if (iVar.g()) {
            this.zza.f4109a.i(null);
            return;
        }
        j jVar = this.zza;
        jVar.f4109a.h(iVar.e());
    }
}
