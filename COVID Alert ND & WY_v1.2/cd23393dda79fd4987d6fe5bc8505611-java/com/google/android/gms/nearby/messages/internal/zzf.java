package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzf extends AbstractSafeParcelable implements Distance {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    private final int zza;
    private final int zzb;
    private final double zzc;

    zzf(int i, int i2, double d) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = d;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeDouble(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzf(int i, double d) {
        this(1, 1, Double.NaN);
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final int getAccuracy() {
        return this.zzb;
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final double getMeters() {
        return this.zzc;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.zzc);
        objArr[1] = this.zzb != 1 ? "UNKNOWN" : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
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
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzf = (zzf) obj;
        return getAccuracy() == zzf.getAccuracy() && compareTo(zzf) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getAccuracy()), Double.valueOf(getMeters()));
    }
}
