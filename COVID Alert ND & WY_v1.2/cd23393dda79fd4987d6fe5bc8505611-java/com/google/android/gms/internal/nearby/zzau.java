package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzaz();
    private zzbs zza;
    private zzbu zzb;

    private zzau() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzau(IBinder iBinder, IBinder iBinder2) {
        this(r1, r0);
        zzbs zzbs;
        zzbu zzbu = null;
        if (iBinder == null) {
            zzbs = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            if (queryLocalInterface instanceof zzbs) {
                zzbs = (zzbs) queryLocalInterface;
            } else {
                zzbs = new zzbv(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            if (queryLocalInterface2 instanceof zzbu) {
                zzbu = (zzbu) queryLocalInterface2;
            } else {
                zzbu = new zzbw(iBinder2);
            }
        }
    }

    private zzau(zzbs zzbs, zzbu zzbu) {
        this.zza = zzbs;
        this.zzb = zzbu;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzau) {
            zzau zzau = (zzau) obj;
            return Objects.equal(this.zza, zzau.zza) && Objects.equal(this.zzb, zzau.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzbs zzbs = this.zza;
        if (zzbs == null) {
            iBinder = null;
        } else {
            iBinder = zzbs.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
