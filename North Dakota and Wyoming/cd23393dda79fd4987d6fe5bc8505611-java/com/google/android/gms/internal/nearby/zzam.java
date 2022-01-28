package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new zzar();
    private zzbn zza;
    private zzbi zzb;
    private String zzc;

    private zzam() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzam(IBinder iBinder, IBinder iBinder2, String str) {
        this(r1, r0, str);
        zzbn zzbn;
        zzbi zzbi = null;
        if (iBinder == null) {
            zzbn = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryResultListener");
            if (queryLocalInterface instanceof zzbn) {
                zzbn = (zzbn) queryLocalInterface;
            } else {
                zzbn = new zzbm(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
            if (queryLocalInterface2 instanceof zzbi) {
                zzbi = (zzbi) queryLocalInterface2;
            } else {
                zzbi = new zzbk(iBinder2);
            }
        }
    }

    private zzam(zzbn zzbn, zzbi zzbi, String str) {
        this.zza = zzbn;
        this.zzb = zzbi;
        this.zzc = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzam) {
            zzam zzam = (zzam) obj;
            return Objects.equal(this.zza, zzam.zza) && Objects.equal(this.zzb, zzam.zzb) && Objects.equal(this.zzc, zzam.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzbn zzbn = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzbn == null ? null : zzbn.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
