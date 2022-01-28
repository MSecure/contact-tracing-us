package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjv> CREATOR = new zzjw();
    private zzhs zza;
    private zzgv zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private AdvertisingOptions zzf;
    private zzhb zzg;
    private byte[] zzh;

    private zzjv() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    zzjv(IBinder iBinder, IBinder iBinder2, String str, String str2, long j, AdvertisingOptions advertisingOptions, IBinder iBinder3, byte[] bArr) {
        this(r6, r7, str, str2, j, advertisingOptions, r3, bArr);
        zzhs zzhs;
        zzgv zzgv;
        zzgv zzgv2;
        zzhs zzhs2;
        zzhb zzhb = null;
        if (iBinder == null) {
            zzhs = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            if (queryLocalInterface instanceof zzhs) {
                zzhs2 = (zzhs) queryLocalInterface;
            } else {
                zzhs2 = new zzhu(iBinder);
            }
            zzhs = zzhs2;
        }
        if (iBinder2 == null) {
            zzgv = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            if (queryLocalInterface2 instanceof zzgv) {
                zzgv2 = (zzgv) queryLocalInterface2;
            } else {
                zzgv2 = new zzgx(iBinder2);
            }
            zzgv = zzgv2;
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            if (queryLocalInterface3 instanceof zzhb) {
                zzhb = (zzhb) queryLocalInterface3;
            } else {
                zzhb = new zzhd(iBinder3);
            }
        }
    }

    private zzjv(zzhs zzhs, zzgv zzgv, String str, String str2, long j, AdvertisingOptions advertisingOptions, zzhb zzhb, byte[] bArr) {
        this.zza = zzhs;
        this.zzb = zzgv;
        this.zzc = str;
        this.zzd = str2;
        this.zze = j;
        this.zzf = advertisingOptions;
        this.zzg = zzhb;
        this.zzh = bArr;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Long.valueOf(this.zze), this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjv) {
            zzjv zzjv = (zzjv) obj;
            return Objects.equal(this.zza, zzjv.zza) && Objects.equal(this.zzb, zzjv.zzb) && Objects.equal(this.zzc, zzjv.zzc) && Objects.equal(this.zzd, zzjv.zzd) && Objects.equal(Long.valueOf(this.zze), Long.valueOf(zzjv.zze)) && Objects.equal(this.zzf, zzjv.zzf) && Objects.equal(this.zzg, zzjv.zzg) && Arrays.equals(this.zzh, zzjv.zzh);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzhs zzhs = this.zza;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzhs == null ? null : zzhs.asBinder(), false);
        zzgv zzgv = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzgv == null ? null : zzgv.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        zzhb zzhb = this.zzg;
        if (zzhb != null) {
            iBinder = zzhb.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
