package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class ExposureInformation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExposureInformation> CREATOR = new zzb();
    private long zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int[] zzf;

    ExposureInformation(long j, int i, int i2, int i3, int i4, int[] iArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = iArr;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static final class ExposureInformationBuilder {
        private long zza = 0;
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 0;
        private int zze = 0;
        private int[] zzf = {0, 0};

        public final ExposureInformationBuilder setDateMillisSinceEpoch(long j) {
            Preconditions.checkArgument(j >= 0, "dateMillisSinceEpoch (%s) must be >= 0", Long.valueOf(j));
            this.zza = j;
            return this;
        }

        public final ExposureInformationBuilder setDurationMinutes(int i) {
            Preconditions.checkArgument(i % 5 == 0, "durationMinutes (%s) must be an increment of 5", Integer.valueOf(i));
            Preconditions.checkArgument(i <= 30, "durationMinutes (%s) must be <= 30", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public final ExposureInformationBuilder setAttenuationValue(int i) {
            Preconditions.checkArgument(i >= 0 && i <= 255, "attenuationValue (%s) must be >= 0 and <= 255", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public final ExposureInformationBuilder setTransmissionRiskLevel(int i) {
            Preconditions.checkArgument(i >= 0 && i <= 8, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }

        public final ExposureInformationBuilder setTotalRiskScore(int i) {
            Preconditions.checkArgument(i >= 0 && i <= 4096, "totalRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i));
            this.zze = i;
            return this;
        }

        public final ExposureInformationBuilder setAttenuationDurations(int[] iArr) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                Preconditions.checkArgument(i2 >= 0, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i2));
            }
            this.zzf = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureInformation build() {
            return new ExposureInformation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeInt(parcel, 2, getDurationMinutes());
        SafeParcelWriter.writeInt(parcel, 3, getAttenuationValue());
        SafeParcelWriter.writeInt(parcel, 4, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 5, getTotalRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 6, getAttenuationDurationsInMinutes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long getDateMillisSinceEpoch() {
        return this.zza;
    }

    public final int getDurationMinutes() {
        return this.zzb;
    }

    public final int getAttenuationValue() {
        return this.zzc;
    }

    public final int getTransmissionRiskLevel() {
        return this.zzd;
    }

    public final int getTotalRiskScore() {
        return this.zze;
    }

    public final int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.zzf;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExposureInformation) {
            ExposureInformation exposureInformation = (ExposureInformation) obj;
            if (!Objects.equal(Long.valueOf(this.zza), Long.valueOf(exposureInformation.getDateMillisSinceEpoch())) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(exposureInformation.getDurationMinutes())) || !Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(exposureInformation.getAttenuationValue())) || !Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(exposureInformation.getTransmissionRiskLevel())) || !Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(exposureInformation.getTotalRiskScore())) || !Arrays.equals(this.zzf, exposureInformation.getAttenuationDurationsInMinutes())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf);
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureInformation<date: %s, dateMillisSinceEpoch: %d, durationMinutes: %d, attenuationValue: %d, transmissionRiskLevel: %d, totalRiskScore: %d, attenuationDurations: %s>", new Date(this.zza), Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Arrays.toString(this.zzf));
    }
}
