package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class Strategy extends AbstractSafeParcelable {
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzg();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    private static final Strategy zza;
    private final int zzb;
    @Deprecated
    private final int zzc;
    private final int zzd;
    private final int zze;
    @Deprecated
    private final boolean zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;

    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.zzb = i;
        this.zzc = i2;
        if (i2 == 0) {
            this.zzh = i6;
        } else if (i2 == 2) {
            this.zzh = 1;
        } else if (i2 != 3) {
            this.zzh = 3;
        } else {
            this.zzh = 2;
        }
        this.zze = i4;
        this.zzf = z;
        if (z) {
            this.zzg = 2;
            this.zzd = Integer.MAX_VALUE;
        } else {
            this.zzd = i3;
            if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) {
                this.zzg = -1;
            } else {
                this.zzg = i5;
            }
        }
        this.zzi = i7;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private int zza = 3;
        private int zzb = Strategy.TTL_SECONDS_DEFAULT;
        private int zzc = 0;
        private int zzd = -1;
        private int zze = 0;

        public Builder setDiscoveryMode(int i) {
            this.zza = i;
            return this;
        }

        public final Builder zza(int i) {
            this.zzd = 2;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            Preconditions.checkArgument(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), Integer.valueOf((int) Strategy.TTL_SECONDS_MAX));
            this.zzb = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.zzc = i;
            return this;
        }

        public Strategy build() {
            if (this.zzd != 2 || this.zzc != 1) {
                return new Strategy(2, 0, this.zzb, this.zzc, false, this.zzd, this.zza, 0);
            }
            throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
        }
    }

    public final int zza() {
        return this.zzi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzc);
        SafeParcelWriter.writeInt(parcel, 2, this.zzd);
        SafeParcelWriter.writeInt(parcel, 3, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 6, this.zzh);
        SafeParcelWriter.writeInt(parcel, 7, this.zzi);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zzb == strategy.zzb && this.zzh == strategy.zzh && this.zzd == strategy.zzd && this.zze == strategy.zze && this.zzg == strategy.zzg && this.zzi == strategy.zzi;
    }

    public int hashCode() {
        return (((((((((this.zzb * 31) + this.zzh) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzg) * 31) + this.zzi;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        int i = this.zzd;
        int i2 = this.zze;
        String str4 = "DEFAULT";
        if (i2 == 0) {
            str = str4;
        } else if (i2 != 1) {
            StringBuilder sb = new StringBuilder(19);
            sb.append("UNKNOWN:");
            sb.append(i2);
            str = sb.toString();
        } else {
            str = "EARSHOT";
        }
        int i3 = this.zzg;
        if (i3 == -1) {
            str2 = str4;
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append("UNKNOWN:");
                sb2.append(i3);
                str2 = sb2.toString();
            } else {
                str2 = arrayList.toString();
            }
        }
        int i4 = this.zzh;
        if (i4 == 3) {
            str3 = str4;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                StringBuilder sb3 = new StringBuilder(19);
                sb3.append("UNKNOWN:");
                sb3.append(i4);
                str3 = sb3.toString();
            } else {
                str3 = arrayList2.toString();
            }
        }
        int i5 = this.zzi;
        if (i5 != 0) {
            if (i5 != 1) {
                StringBuilder sb4 = new StringBuilder(20);
                sb4.append("UNKNOWN: ");
                sb4.append(i5);
                str4 = sb4.toString();
            } else {
                str4 = "ALWAYS_ON";
            }
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 102 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb5.append("Strategy{ttlSeconds=");
        sb5.append(i);
        sb5.append(", distanceType=");
        sb5.append(str);
        sb5.append(", discoveryMedium=");
        sb5.append(str2);
        sb5.append(", discoveryMode=");
        sb5.append(str3);
        sb5.append(", backgroundScanMode=");
        sb5.append(str4);
        sb5.append('}');
        return sb5.toString();
    }

    static {
        Strategy build = new Builder().zza(2).setTtlSeconds(Integer.MAX_VALUE).build();
        BLE_ONLY = build;
        zza = build;
    }
}
