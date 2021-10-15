package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.b.a.a.g.e.a0;
import c.b.a.a.g.e.s1;
import java.util.List;

public final class zzn extends a0 implements zzl {
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zza(zzag zzag) {
        Parcel a_ = a_();
        s1.b(a_, zzag);
        zzc(1, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zza(List<Update> list) {
        Parcel a_ = a_();
        a_.writeTypedList(list);
        zzc(4, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zzb(zzag zzag) {
        Parcel a_ = a_();
        s1.b(a_, zzag);
        zzc(2, a_);
    }
}
