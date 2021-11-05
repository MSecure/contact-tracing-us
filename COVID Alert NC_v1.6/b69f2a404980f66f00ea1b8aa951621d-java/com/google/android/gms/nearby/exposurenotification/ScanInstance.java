package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class ScanInstance extends a {
    public static final Parcelable.Creator<ScanInstance> CREATOR = new zzn();
    public int zza;
    public int zzb;
    public int zzc;

    public static class Builder {
        public int zza = 0;
        public int zzb = 0;
        public int zzc = 0;

        public ScanInstance build() {
            return new ScanInstance(this.zza, this.zzb, this.zzc);
        }

        public Builder setMinAttenuationDb(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setSecondsSinceLastScan(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setTypicalAttenuationDb(int i) {
            this.zza = i;
            return this;
        }
    }

    public ScanInstance(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ScanInstance.class == obj.getClass()) {
            ScanInstance scanInstance = (ScanInstance) obj;
            return this.zza == scanInstance.zza && this.zzb == scanInstance.zzb && this.zzc == scanInstance.zzc;
        }
    }

    public final int getMinAttenuationDb() {
        return this.zzb;
    }

    public final int getSecondsSinceLastScan() {
        return this.zzc;
    }

    public final int getTypicalAttenuationDb() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        StringBuilder sb = new StringBuilder(110);
        sb.append("ScanInstance{typicalAttenuationDb=");
        sb.append(i);
        sb.append(", minAttenuationDb=");
        sb.append(i2);
        sb.append(", secondsSinceLastScan=");
        sb.append(i3);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, getTypicalAttenuationDb());
        i.j.u1(parcel, 2, getMinAttenuationDb());
        i.j.u1(parcel, 3, getSecondsSinceLastScan());
        i.j.F1(parcel, e2);
    }
}
