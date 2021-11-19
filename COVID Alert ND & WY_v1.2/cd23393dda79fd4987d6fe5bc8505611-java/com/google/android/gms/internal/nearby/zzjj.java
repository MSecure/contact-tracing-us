package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjj> CREATOR = new zzjk();
    private zzhr zza;
    private String zzb;

    private zzjj() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzjj(IBinder iBinder, String str) {
        this(r3, str);
        zzhr zzhr;
        if (iBinder == null) {
            zzhr = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            if (queryLocalInterface instanceof zzhr) {
                zzhr = (zzhr) queryLocalInterface;
            } else {
                zzhr = new zzht(iBinder);
            }
        }
    }

    private zzjj(zzhr zzhr, String str) {
        this.zza = zzhr;
        this.zzb = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjj) {
            zzjj zzjj = (zzjj) obj;
            return Objects.equal(this.zza, zzjj.zza) && Objects.equal(this.zzb, zzjj.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
