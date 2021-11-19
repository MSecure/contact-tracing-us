package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjr> CREATOR = new zzjs();
    private zzhr zza;
    private String[] zzb;
    private zzjc zzc;
    private boolean zzd;

    private zzjr() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzjr(IBinder iBinder, String[] strArr, zzjc zzjc, boolean z) {
        this(r3, strArr, zzjc, z);
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

    private zzjr(zzhr zzhr, String[] strArr, zzjc zzjc, boolean z) {
        this.zza = zzhr;
        this.zzb = strArr;
        this.zzc = zzjc;
        this.zzd = z;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, Boolean.valueOf(this.zzd));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjr) {
            zzjr zzjr = (zzjr) obj;
            return Objects.equal(this.zza, zzjr.zza) && Arrays.equals(this.zzb, zzjr.zzb) && Objects.equal(this.zzc, zzjr.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzjr.zzd));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
