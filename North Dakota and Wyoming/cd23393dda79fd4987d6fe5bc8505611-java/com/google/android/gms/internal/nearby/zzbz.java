package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
    private zzbd zza;
    private zzay zzb;

    private zzbz() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzbz(IBinder iBinder, IBinder iBinder2) {
        this(r1, r0);
        zzbd zzbd;
        zzay zzay = null;
        if (iBinder == null) {
            zzbd = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            if (queryLocalInterface instanceof zzbd) {
                zzbd = (zzbd) queryLocalInterface;
            } else {
                zzbd = new zzbc(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            if (queryLocalInterface2 instanceof zzay) {
                zzay = (zzay) queryLocalInterface2;
            } else {
                zzay = new zzba(iBinder2);
            }
        }
    }

    private zzbz(zzbd zzbd, zzay zzay) {
        this.zza = zzbd;
        this.zzb = zzay;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbz) {
            zzbz zzbz = (zzbz) obj;
            return Objects.equal(this.zza, zzbz.zza) && Objects.equal(this.zzb, zzbz.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzbd zzbd = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzbd == null ? null : zzbd.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
