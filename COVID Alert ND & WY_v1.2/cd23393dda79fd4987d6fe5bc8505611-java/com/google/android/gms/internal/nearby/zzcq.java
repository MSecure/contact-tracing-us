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
public final class zzcq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcq> CREATOR = new zzcv();
    private zzhr zza;
    private zzgw zzb;
    private String zzc;
    private byte[] zzd;
    private zzhm zze;

    private zzcq() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzcq(IBinder iBinder, IBinder iBinder2, String str, byte[] bArr, IBinder iBinder3) {
        this(r3, r4, str, bArr, r0);
        zzhr zzhr;
        zzgw zzgw;
        zzgw zzgw2;
        zzhr zzhr2;
        zzhm zzhm = null;
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
            zzgw = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            if (queryLocalInterface2 instanceof zzgw) {
                zzgw2 = (zzgw) queryLocalInterface2;
            } else {
                zzgw2 = new zzgy(iBinder2);
            }
            zzgw = zzgw2;
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            if (queryLocalInterface3 instanceof zzhm) {
                zzhm = (zzhm) queryLocalInterface3;
            } else {
                zzhm = new zzho(iBinder3);
            }
        }
    }

    private zzcq(zzhr zzhr, zzgw zzgw, String str, byte[] bArr, zzhm zzhm) {
        this.zza = zzhr;
        this.zzb = zzgw;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzhm;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)), this.zze);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcq) {
            zzcq zzcq = (zzcq) obj;
            return Objects.equal(this.zza, zzcq.zza) && Objects.equal(this.zzb, zzcq.zzb) && Objects.equal(this.zzc, zzcq.zzc) && Arrays.equals(this.zzd, zzcq.zzd) && Objects.equal(this.zze, zzcq.zze);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        zzgw zzgw = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzgw == null ? null : zzgw.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        zzhm zzhm = this.zze;
        if (zzhm != null) {
            iBinder = zzhm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
