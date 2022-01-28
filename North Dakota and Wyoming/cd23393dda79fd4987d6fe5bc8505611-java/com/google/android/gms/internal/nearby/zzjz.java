package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjz> CREATOR = new zzka();
    private zzhr zza;
    private zzhh zzb;
    private String zzc;
    private long zzd;
    private DiscoveryOptions zze;
    private zzhj zzf;

    private zzjz() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzjz(IBinder iBinder, IBinder iBinder2, String str, long j, DiscoveryOptions discoveryOptions, IBinder iBinder3) {
        this(r6, r7, str, j, discoveryOptions, r3);
        zzhr zzhr;
        zzhh zzhh;
        zzhh zzhh2;
        zzhr zzhr2;
        zzhj zzhj = null;
        if (iBinder == null) {
            zzhr = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            if (queryLocalInterface instanceof zzhr) {
                zzhr2 = (zzhr) queryLocalInterface;
            } else {
                zzhr2 = new zzht(iBinder);
            }
            zzhr = zzhr2;
        }
        if (iBinder2 == null) {
            zzhh = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            if (queryLocalInterface2 instanceof zzhh) {
                zzhh2 = (zzhh) queryLocalInterface2;
            } else {
                zzhh2 = new zzhg(iBinder2);
            }
            zzhh = zzhh2;
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            if (queryLocalInterface3 instanceof zzhj) {
                zzhj = (zzhj) queryLocalInterface3;
            } else {
                zzhj = new zzhl(iBinder3);
            }
        }
    }

    private zzjz(zzhr zzhr, zzhh zzhh, String str, long j, DiscoveryOptions discoveryOptions, zzhj zzhj) {
        this.zza = zzhr;
        this.zzb = zzhh;
        this.zzc = str;
        this.zzd = j;
        this.zze = discoveryOptions;
        this.zzf = zzhj;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjz) {
            zzjz zzjz = (zzjz) obj;
            return Objects.equal(this.zza, zzjz.zza) && Objects.equal(this.zzb, zzjz.zzb) && Objects.equal(this.zzc, zzjz.zzc) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(zzjz.zzd)) && Objects.equal(this.zze, zzjz.zze) && Objects.equal(this.zzf, zzjz.zzf);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        zzhh zzhh = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzhh == null ? null : zzhh.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        zzhj zzhj = this.zzf;
        if (zzhj != null) {
            iBinder = zzhj.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
