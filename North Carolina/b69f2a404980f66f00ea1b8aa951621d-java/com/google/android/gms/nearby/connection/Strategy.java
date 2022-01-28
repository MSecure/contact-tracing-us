package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;
import java.util.Locale;

public final class Strategy extends a {
    public static final Parcelable.Creator<Strategy> CREATOR = new zzp();
    public static final Strategy P2P_CLUSTER = new Strategy(1, 3);
    public static final Strategy P2P_POINT_TO_POINT = new Strategy(1, 1);
    public static final Strategy P2P_STAR = new Strategy(1, 2);
    public final int zza;
    public final int zzb;

    public Strategy(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zza == strategy.zza && this.zzb == strategy.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = P2P_CLUSTER.equals(this) ? "P2P_CLUSTER" : P2P_STAR.equals(this) ? "P2P_STAR" : P2P_POINT_TO_POINT.equals(this) ? "P2P_POINT_TO_POINT" : "UNKNOWN";
        objArr[1] = Integer.valueOf(this.zza);
        objArr[2] = Integer.valueOf(this.zzb);
        return String.format(locale, "Strategy(%s){connectionType=%d, topology=%d}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 3, this.zza);
        i.j.u1(parcel, 4, this.zzb);
        i.j.F1(parcel, e2);
    }
}
