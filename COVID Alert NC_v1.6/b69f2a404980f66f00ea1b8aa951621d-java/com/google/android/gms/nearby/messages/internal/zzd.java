package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Arrays;
import java.util.Locale;

public final class zzd extends a implements Distance {
    public static final Parcelable.Creator<zzd> CREATOR = new zzg();
    public final int zza;
    public final int zzb;
    public final double zzc;

    public zzd(int i, double d2) {
        this(1, 1, Double.NaN);
    }

    public zzd(int i, int i2, double d2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = d2;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final int compareTo(Distance distance) {
        if (!Double.isNaN(getMeters()) || !Double.isNaN(distance.getMeters())) {
            return Double.compare(getMeters(), distance.getMeters());
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzd = (zzd) obj;
        return getAccuracy() == zzd.getAccuracy() && compareTo(zzd) == 0;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final int getAccuracy() {
        return this.zzb;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final double getMeters() {
        return this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getAccuracy()), Double.valueOf(getMeters())});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.zzc);
        objArr[1] = this.zzb != 1 ? "UNKNOWN" : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.u1(parcel, 2, this.zzb);
        i.j.r1(parcel, 3, this.zzc);
        i.j.F1(parcel, e2);
    }
}
