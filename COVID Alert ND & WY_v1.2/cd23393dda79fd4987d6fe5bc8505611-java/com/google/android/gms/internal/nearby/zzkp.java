package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzk;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzkp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkp> CREATOR = new zzkr();
    private final int zza;
    private final int zzb;
    private final byte[] zzc;
    private final boolean zzd;

    zzkp(int i, int i2, byte[] bArr, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzkp(int i, byte[] bArr) {
        this(1, i, bArr, false);
    }

    public static zzkp zza(String str, String str2) {
        String valueOf = String.valueOf(str);
        if (str2 == null) {
            str2 = "";
        }
        String valueOf2 = String.valueOf(str2);
        return new zzkp(2, new zzh(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zza());
    }

    public static zzkp zza(UUID uuid, Short sh, Short sh2) {
        return new zzkp(3, new zzk(uuid, sh, sh2).zza());
    }
}
