package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class zzq extends a {
    public static final Parcelable.Creator<zzq> CREATOR = new zzs();
    public byte[] zza;
    public int zzb;
    public int zzc;

    public zzq() {
    }

    public zzq(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzq) {
            zzq zzq = (zzq) obj;
            return Arrays.equals(this.zza, zzq.zza) && t.j1(Integer.valueOf(this.zzb), Integer.valueOf(zzq.zzb)) && t.j1(Integer.valueOf(this.zzc), Integer.valueOf(zzq.zzc));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zza);
        int i = this.zzb;
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 71);
        sb.append("UwbSenderInfo{address=");
        sb.append(arrays);
        sb.append(", channel=");
        sb.append(i);
        sb.append(", preambleIndex=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.l3(parcel, 1, this.zza, false);
        t.q3(parcel, 2, this.zzb);
        t.q3(parcel, 3, this.zzc);
        t.w4(parcel, m);
    }
}
