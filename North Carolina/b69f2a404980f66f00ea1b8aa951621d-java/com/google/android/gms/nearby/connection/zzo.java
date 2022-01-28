package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class zzo extends a {
    public static final Parcelable.Creator<zzo> CREATOR = new zzr();
    public int zza;
    public int zzb;
    public int zzc;
    public boolean zzd;

    public zzo() {
    }

    public zzo(int i, int i2, int i3, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzo) {
            zzo zzo = (zzo) obj;
            return i.j.X(Integer.valueOf(this.zza), Integer.valueOf(zzo.zza)) && i.j.X(Integer.valueOf(this.zzb), Integer.valueOf(zzo.zzb)) && i.j.X(Integer.valueOf(this.zzc), Integer.valueOf(zzo.zzc)) && i.j.X(Boolean.valueOf(this.zzd), Boolean.valueOf(zzo.zzd));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd)});
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        boolean z = this.zzd;
        StringBuilder sb = new StringBuilder(146);
        sb.append("UwbRangingData{rawDistance=");
        sb.append(i);
        sb.append(", rawAngleOfArrivalAzimuth=");
        sb.append(i2);
        sb.append(", rawAngleOfArrivalPolar=");
        sb.append(i3);
        sb.append(", isValidAngleOfArrivalData=");
        sb.append(z);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.u1(parcel, 2, this.zzb);
        i.j.u1(parcel, 3, this.zzc);
        i.j.o1(parcel, 4, this.zzd);
        i.j.F1(parcel, e2);
    }
}
