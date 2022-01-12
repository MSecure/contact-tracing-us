package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzdu extends zzb implements zzdv {
    public zzdu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzer zzer) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzer);
        zzc(1, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzev zzev) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzev);
        zzc(2, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzef zzef) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzef);
        zzc(3, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzce zzce) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzce);
        zzc(4, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzej zzej) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzej);
        zzc(5, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzci zzci) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzci);
        zzc(14, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzbc zzbc) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzbc);
        zzc(16, a_);
    }

    @Override // com.google.android.gms.internal.nearby.zzdv
    public final void zza(zzen zzen) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzen);
        zzc(17, a_);
    }
}
