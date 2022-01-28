package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.b.a.a.e.c.a0;
import c.b.a.a.e.c.s1;

public final class zzu extends a0 implements zzr {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(SubscribeRequest subscribeRequest) {
        Parcel a_ = a_();
        s1.b(a_, subscribeRequest);
        zzc(3, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzca zzca) {
        Parcel a_ = a_();
        s1.b(a_, zzca);
        zzc(1, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzcc zzcc) {
        Parcel a_ = a_();
        s1.b(a_, zzcc);
        zzc(8, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzcf zzcf) {
        Parcel a_ = a_();
        s1.b(a_, zzcf);
        zzc(2, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzch zzch) {
        Parcel a_ = a_();
        s1.b(a_, zzch);
        zzc(4, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzi zzi) {
        Parcel a_ = a_();
        s1.b(a_, zzi);
        zzc(7, a_);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zza(zzk zzk) {
        Parcel a_ = a_();
        s1.b(a_, zzk);
        zzc(9, a_);
    }
}
