package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjn> CREATOR = new zzjo();
    private zzhr zza;
    private zzgw zzb;
    private zzhc zzc;
    private String zzd;
    private String zze;
    private byte[] zzf;
    private zzhb zzg;
    private byte[] zzh;
    private ConnectionOptions zzi;

    private zzjn() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzjn(IBinder iBinder, IBinder iBinder2, IBinder iBinder3, String str, String str2, byte[] bArr, IBinder iBinder4, byte[] bArr2, ConnectionOptions connectionOptions) {
        this(r7, r8, r9, str, str2, bArr, r4, bArr2, connectionOptions);
        zzhr zzhr;
        zzgw zzgw;
        zzhc zzhc;
        zzhc zzhc2;
        zzgw zzgw2;
        zzhr zzhr2;
        zzhb zzhb = null;
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
        if (iBinder3 == null) {
            zzhc = null;
        } else {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            if (queryLocalInterface3 instanceof zzhc) {
                zzhc2 = (zzhc) queryLocalInterface3;
            } else {
                zzhc2 = new zzhe(iBinder3);
            }
            zzhc = zzhc2;
        }
        if (iBinder4 != null) {
            IInterface queryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            if (queryLocalInterface4 instanceof zzhb) {
                zzhb = (zzhb) queryLocalInterface4;
            } else {
                zzhb = new zzhd(iBinder4);
            }
        }
    }

    private zzjn(zzhr zzhr, zzgw zzgw, zzhc zzhc, String str, String str2, byte[] bArr, zzhb zzhb, byte[] bArr2, ConnectionOptions connectionOptions) {
        this.zza = zzhr;
        this.zzb = zzgw;
        this.zzc = zzhc;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = zzhb;
        this.zzh = bArr2;
        this.zzi = connectionOptions;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjn) {
            zzjn zzjn = (zzjn) obj;
            return Objects.equal(this.zza, zzjn.zza) && Objects.equal(this.zzb, zzjn.zzb) && Objects.equal(this.zzc, zzjn.zzc) && Objects.equal(this.zzd, zzjn.zzd) && Objects.equal(this.zze, zzjn.zze) && Arrays.equals(this.zzf, zzjn.zzf) && Objects.equal(this.zzg, zzjn.zzg) && Arrays.equals(this.zzh, zzjn.zzh) && Objects.equal(this.zzi, zzjn.zzi);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhr zzhr = this.zza;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhr == null ? null : zzhr.asBinder(), false);
        zzgw zzgw = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzgw == null ? null : zzgw.asBinder(), false);
        zzhc zzhc = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzhc == null ? null : zzhc.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        zzhb zzhb = this.zzg;
        if (zzhb != null) {
            iBinder = zzhb.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
