package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzav();
    private zzbp zza;
    private String zzb;

    private zzaq() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzaq(IBinder iBinder, String str) {
        this(r3, str);
        zzbp zzbp;
        if (iBinder == null) {
            zzbp = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            if (queryLocalInterface instanceof zzbp) {
                zzbp = (zzbp) queryLocalInterface;
            } else {
                zzbp = new zzbr(iBinder);
            }
        }
    }

    private zzaq(zzbp zzbp, String str) {
        this.zza = zzbp;
        this.zzb = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaq) {
            zzaq zzaq = (zzaq) obj;
            return Objects.equal(this.zza, zzaq.zza) && Objects.equal(this.zzb, zzaq.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
