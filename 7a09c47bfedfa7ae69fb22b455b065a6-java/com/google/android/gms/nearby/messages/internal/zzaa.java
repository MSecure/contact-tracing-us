package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.b.a.a.g.e.a0;
import c.b.a.a.g.e.s1;

public final class zzaa extends a0 implements zzy {
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzy
    public final void zza(boolean z) {
        Parcel a_ = a_();
        s1.c(a_, z);
        zzc(1, a_);
    }
}
