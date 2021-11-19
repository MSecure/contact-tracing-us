package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzan();
    private zzbg zza;
    private zzbf zzb;
    private String zzc;

    private zzai() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzai(IBinder iBinder, IBinder iBinder2, String str) {
        this(r1, r0, str);
        zzbg zzbg;
        zzbf zzbf = null;
        if (iBinder == null) {
            zzbg = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationResultListener");
            if (queryLocalInterface instanceof zzbg) {
                zzbg = (zzbg) queryLocalInterface;
            } else {
                zzbg = new zzbj(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
            if (queryLocalInterface2 instanceof zzbf) {
                zzbf = (zzbf) queryLocalInterface2;
            } else {
                zzbf = new zzbh(iBinder2);
            }
        }
    }

    private zzai(zzbg zzbg, zzbf zzbf, String str) {
        this.zza = zzbg;
        this.zzb = zzbf;
        this.zzc = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzai) {
            zzai zzai = (zzai) obj;
            return Objects.equal(this.zza, zzai.zza) && Objects.equal(this.zzb, zzai.zzb) && Objects.equal(this.zzc, zzai.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzbg zzbg = this.zza;
        if (zzbg == null) {
            iBinder = null;
        } else {
            iBinder = zzbg.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
