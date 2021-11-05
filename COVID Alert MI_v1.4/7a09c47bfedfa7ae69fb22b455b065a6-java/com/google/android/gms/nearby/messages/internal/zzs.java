package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.b.a.a.g.e.a0;
import c.b.a.a.g.e.s1;
import com.google.android.gms.common.api.Status;

public final class zzs extends a0 implements zzq {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzq
    public final void zza(Status status) {
        Parcel a_ = a_();
        s1.b(a_, status);
        zzc(1, a_);
    }
}
