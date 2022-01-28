package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class zzae extends a {
    public static final Parcelable.Creator<zzae> CREATOR = new zzad();
    public final int zza;
    public final String zzb;
    public final String zzc;

    public zzae(int i, String str, String str2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
    }

    public zzae(String str, String str2) {
        this(1, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzae) && hashCode() == obj.hashCode()) {
            zzae zzae = (zzae) obj;
            return i.j.X(this.zzb, zzae.zzb) && i.j.X(this.zzc, zzae.zzc);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc});
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 17);
        sb.append("namespace=");
        sb.append(str);
        sb.append(", type=");
        sb.append(str2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.zzb, false);
        i.j.z1(parcel, 2, this.zzc, false);
        i.j.u1(parcel, 1000, this.zza);
        i.j.F1(parcel, e2);
    }
}
