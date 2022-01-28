package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.g.c;
import c.b.a.a.g.h;
import c.b.a.a.g.i;

public final class zzax implements c<Boolean> {
    public final /* synthetic */ i zza;

    public zzax(zzaj zzaj, i iVar) {
        this.zza = iVar;
    }

    @Override // c.b.a.a.g.c
    public final void onComplete(h<Boolean> hVar) {
        if (hVar.g()) {
            this.zza.f2856a.i(null);
            return;
        }
        i iVar = this.zza;
        iVar.f2856a.h(hVar.e());
    }
}
