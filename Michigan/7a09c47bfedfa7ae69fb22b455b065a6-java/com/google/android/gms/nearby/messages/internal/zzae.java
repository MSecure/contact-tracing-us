package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
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
            return t.j1(this.zzb, zzae.zzb) && t.j1(this.zzc, zzae.zzc);
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
        int m = t.m(parcel);
        t.w3(parcel, 1, this.zzb, false);
        t.w3(parcel, 2, this.zzc, false);
        t.q3(parcel, 1000, this.zza);
        t.w4(parcel, m);
    }
}
