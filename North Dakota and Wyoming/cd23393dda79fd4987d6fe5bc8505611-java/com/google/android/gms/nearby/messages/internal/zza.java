package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.BleSignal;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable.Creator<zza> CREATOR = new zzc();
    private final int zza;
    private final int zzb;
    private final int zzc;

    zza(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = (-169 >= i3 || i3 >= 87) ? Integer.MIN_VALUE : i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.zzc;
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

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }
}
