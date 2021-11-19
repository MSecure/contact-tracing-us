package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class ScanInstance extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ScanInstance> CREATOR = new zze();
    private int zza;
    private int zzb;
    private int zzc;

    ScanInstance(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private int zza = 0;
        private int zzb = 0;
        private int zzc = 0;

        public Builder setTypicalAttenuationDb(int i) {
            this.zza = i;
            return this;
        }

        public Builder setMinAttenuationDb(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setSecondsSinceLastScan(int i) {
            this.zzc = i;
            return this;
        }

        public ScanInstance build() {
            return new ScanInstance(this.zza, this.zzb, this.zzc);
        }
    }

    public final int getTypicalAttenuationDb() {
        return this.zza;
    }

    public final int getMinAttenuationDb() {
        return this.zzb;
    }

    public final int getSecondsSinceLastScan() {
        return this.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScanInstance scanInstance = (ScanInstance) obj;
            return this.zza == scanInstance.zza && this.zzb == scanInstance.zzb && this.zzc == scanInstance.zzc;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
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
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getTypicalAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 2, getMinAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 3, getSecondsSinceLastScan());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
