package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcu> CREATOR = new zzcz();
    private zzhr zza;
    private long zzb;

    private zzcu() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzcu(IBinder iBinder, long j) {
        this(r3, j);
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

    private zzcu(zzhr zzhr, long j) {
        this.zza = zzhr;
        this.zzb = j;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcu) {
            zzcu zzcu = (zzcu) obj;
            return Objects.equal(this.zza, zzcu.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzcu.zzb));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
