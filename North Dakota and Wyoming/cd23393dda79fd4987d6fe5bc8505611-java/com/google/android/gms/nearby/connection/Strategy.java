package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class Strategy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = new zzp();
    public static final Strategy P2P_CLUSTER = new Strategy(1, 3);
    public static final Strategy P2P_POINT_TO_POINT = new Strategy(1, 1);
    public static final Strategy P2P_STAR = new Strategy(1, 2);
    private final int zza;
    private final int zzb;

    Strategy(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 3, this.zza);
        SafeParcelWriter.writeInt(parcel, 4, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
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

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        if (P2P_CLUSTER.equals(this)) {
            str = "P2P_CLUSTER";
        } else if (P2P_STAR.equals(this)) {
            str = "P2P_STAR";
        } else {
            str = P2P_POINT_TO_POINT.equals(this) ? "P2P_POINT_TO_POINT" : "UNKNOWN";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.zza);
        objArr[2] = Integer.valueOf(this.zzb);
        return String.format(locale, "Strategy(%s){connectionType=%d, topology=%d}", objArr);
    }
}
