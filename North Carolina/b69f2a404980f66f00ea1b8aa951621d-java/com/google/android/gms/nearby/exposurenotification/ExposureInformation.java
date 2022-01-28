package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Deprecated
public final class ExposureInformation extends a {
    public static final Parcelable.Creator<ExposureInformation> CREATOR = new zze();
    public long zza;
    public int zzb;
    public int zzc;
    @RiskLevel
    public int zzd;
    public int zze;
    public int[] zzf;

    public static final class ExposureInformationBuilder {
        public long zza = 0;
        public int zzb = 0;
        public int zzc = 0;
        @RiskLevel
        public int zzd = 0;
        public int zze = 0;
        public int[] zzf = {0, 0};

        public final ExposureInformation build() {
            return new ExposureInformation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }

        public final ExposureInformationBuilder setAttenuationDurations(int[] iArr) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i2));
            }
            this.zzf = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureInformationBuilder setAttenuationValue(int i) {
            i.j.j(i >= 0 && i <= 255, "attenuationValue (%s) must be >= 0 and <= 255", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public final ExposureInformationBuilder setDateMillisSinceEpoch(long j) {
            i.j.j(j >= 0, "dateMillisSinceEpoch (%s) must be >= 0", Long.valueOf(j));
            this.zza = j;
            return this;
        }

        public final ExposureInformationBuilder setDurationMinutes(int i) {
            i.j.j(i % 5 == 0, "durationMinutes (%s) must be an increment of 5", Integer.valueOf(i));
            i.j.j(i <= 30, "durationMinutes (%s) must be <= 30", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public final ExposureInformationBuilder setTotalRiskScore(int i) {
            i.j.j(i >= 0 && i <= 4096, "totalRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i));
            this.zze = i;
            return this;
        }

        public final ExposureInformationBuilder setTransmissionRiskLevel(@RiskLevel int i) {
            i.j.j(i >= 0 && i <= 8, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }
    }

    public ExposureInformation(long j, int i, int i2, int i3, int i4, int[] iArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = iArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExposureInformation) {
            ExposureInformation exposureInformation = (ExposureInformation) obj;
            return i.j.X(Long.valueOf(this.zza), Long.valueOf(exposureInformation.getDateMillisSinceEpoch())) && i.j.X(Integer.valueOf(this.zzb), Integer.valueOf(exposureInformation.getDurationMinutes())) && i.j.X(Integer.valueOf(this.zzc), Integer.valueOf(exposureInformation.getAttenuationValue())) && i.j.X(Integer.valueOf(this.zzd), Integer.valueOf(exposureInformation.getTransmissionRiskLevel())) && i.j.X(Integer.valueOf(this.zze), Integer.valueOf(exposureInformation.getTotalRiskScore())) && Arrays.equals(this.zzf, exposureInformation.getAttenuationDurationsInMinutes());
        }
    }

    public final int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.zzf;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getAttenuationValue() {
        return this.zzc;
    }

    public final long getDateMillisSinceEpoch() {
        return this.zza;
    }

    public final int getDurationMinutes() {
        return this.zzb;
    }

    public final int getTotalRiskScore() {
        return this.zze;
    }

    @RiskLevel
    public final int getTransmissionRiskLevel() {
        return this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf});
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureInformation<date: %s, dateMillisSinceEpoch: %d, durationMinutes: %d, attenuationValue: %d, transmissionRiskLevel: %d, totalRiskScore: %d, attenuationDurations: %s>", new Date(this.zza), Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Arrays.toString(this.zzf));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.x1(parcel, 1, getDateMillisSinceEpoch());
        i.j.u1(parcel, 2, getDurationMinutes());
        i.j.u1(parcel, 3, getAttenuationValue());
        i.j.u1(parcel, 4, getTransmissionRiskLevel());
        i.j.u1(parcel, 5, getTotalRiskScore());
        i.j.v1(parcel, 6, getAttenuationDurationsInMinutes(), false);
        i.j.F1(parcel, e2);
    }
}
