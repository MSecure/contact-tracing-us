package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.Arrays;

public final class zzb extends a implements BleSignal {
    public static final Parcelable.Creator<zzb> CREATOR = new zza();
    public final int zza;
    public final int zzb;
    public final int zzc;

    public zzb(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = (-169 >= i3 || i3 >= 87) ? Integer.MIN_VALUE : i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.zzb == bleSignal.getRssi() && this.zzc == bleSignal.getTxPower();
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        int i = this.zzb;
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(48);
        sb.append("BleSignal{rssi=");
        sb.append(i);
        sb.append(", txPower=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.u1(parcel, 2, this.zzb);
        i.j.u1(parcel, 3, this.zzc);
        i.j.F1(parcel, e2);
    }
}
