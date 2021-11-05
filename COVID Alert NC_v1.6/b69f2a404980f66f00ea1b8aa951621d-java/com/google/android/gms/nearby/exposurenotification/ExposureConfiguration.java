package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
public final class ExposureConfiguration extends a {
    public static final Parcelable.Creator<ExposureConfiguration> CREATOR = new zzd();
    public int zza;
    public int[] zzb;
    public int zzc;
    public int[] zzd;
    public int zze;
    public int[] zzf;
    public int zzg;
    public int[] zzh;
    public int zzi;
    public int[] zzj;

    public static final class ExposureConfigurationBuilder {
        public int zza = 4;
        public int[] zzb = {4, 4, 4, 4, 4, 4, 4, 4};
        public int zzc = 50;
        public int[] zzd = {4, 4, 4, 4, 4, 4, 4, 4};
        public int zze = 50;
        public int[] zzf = {4, 4, 4, 4, 4, 4, 4, 4};
        public int zzg = 50;
        public int[] zzh = {4, 4, 4, 4, 4, 4, 4, 4};
        public int zzi = 50;
        public int[] zzj = {50, 74};

        public final ExposureConfiguration build() {
            return new ExposureConfiguration(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj);
        }

        public final ExposureConfigurationBuilder setAttenuationScores(int... iArr) {
            i.j.j(iArr.length == 8, "attenuationScores (%s) must have exactly 8 elements", Arrays.toString(iArr));
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0 && i2 <= 8, "attenuationScore (%s) must be >= 0 and <= 8", Integer.valueOf(i2));
            }
            this.zzb = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureConfigurationBuilder setAttenuationWeight(int i) {
            i.j.j(i >= 0 && i <= 100, "attenuationWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public final ExposureConfigurationBuilder setDaysSinceLastExposureScores(int... iArr) {
            i.j.j(iArr.length == 8, "daysSinceLastExposureScores (%s) must have exactly 8 elements", Arrays.toString(iArr));
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0 && i2 <= 8, "daysSinceLastExposureScore (%s) must be >= 0 and <= 8", Integer.valueOf(i2));
            }
            this.zzd = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureConfigurationBuilder setDaysSinceLastExposureWeight(int i) {
            i.j.j(i >= 0 && i <= 100, "daysSinceLastExposureWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i));
            this.zze = i;
            return this;
        }

        public final ExposureConfigurationBuilder setDurationAtAttenuationThresholds(int... iArr) {
            i.j.j(iArr.length == 2, "durationAtAttenuationThresholds (%s) must have exactly 2 elements", Arrays.toString(iArr));
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0 && i2 <= 255, "durationAtAttenuationThreshold (%s) must be >= 0 and <= 255", Integer.valueOf(i2));
            }
            i.j.j(iArr[0] <= iArr[1], "durationAtAttenuationThresholds[0] (%s) must be <= than durationAtAttenuationThresholds[1] (%s)", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            this.zzj = iArr;
            return this;
        }

        public final ExposureConfigurationBuilder setDurationScores(int... iArr) {
            i.j.j(iArr.length == 8, "durationScores (%s) must have exactly 8 elements", Arrays.toString(iArr));
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0 && i2 <= 8, "durationScore (%s) must be >= 0 and <= 8", Integer.valueOf(i2));
            }
            this.zzf = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureConfigurationBuilder setDurationWeight(int i) {
            i.j.j(i >= 0 && i <= 100, "durationWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i));
            this.zzg = i;
            return this;
        }

        public final ExposureConfigurationBuilder setMinimumRiskScore(int i) {
            i.j.j(i > 0 && i <= 4096, "minimumRiskScore (%s) must be >= 1 and <= 4096", Integer.valueOf(i));
            this.zza = i;
            return this;
        }

        public final ExposureConfigurationBuilder setTransmissionRiskScores(int... iArr) {
            i.j.j(iArr.length == 8, "transmissionRiskScores (%s) must have exactly 8 elements", Arrays.toString(iArr));
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0 && i2 <= 8, "transmissionRiskScore (%s) must be >= 0 and <= 8", Integer.valueOf(i2));
            }
            this.zzh = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureConfigurationBuilder setTransmissionRiskWeight(int i) {
            i.j.j(i >= 0 && i <= 100, "transmissionRiskWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i));
            this.zzi = i;
            return this;
        }
    }

    public ExposureConfiguration(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4, int[] iArr4, int i5, int[] iArr5) {
        this.zza = i;
        this.zzb = iArr;
        this.zzc = i2;
        this.zzd = iArr2;
        this.zze = i3;
        this.zzf = iArr3;
        this.zzg = i4;
        this.zzh = iArr4;
        this.zzi = i5;
        this.zzj = iArr5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExposureConfiguration) {
            ExposureConfiguration exposureConfiguration = (ExposureConfiguration) obj;
            return i.j.X(Integer.valueOf(this.zza), Integer.valueOf(exposureConfiguration.getMinimumRiskScore())) && Arrays.equals(this.zzb, exposureConfiguration.getAttenuationScores()) && i.j.X(Integer.valueOf(this.zzc), Integer.valueOf(exposureConfiguration.getAttenuationWeight())) && Arrays.equals(this.zzd, exposureConfiguration.getDaysSinceLastExposureScores()) && i.j.X(Integer.valueOf(this.zze), Integer.valueOf(exposureConfiguration.getDaysSinceLastExposureWeight())) && Arrays.equals(this.zzf, exposureConfiguration.getDurationScores()) && i.j.X(Integer.valueOf(this.zzg), Integer.valueOf(exposureConfiguration.getDurationWeight())) && Arrays.equals(this.zzh, exposureConfiguration.getTransmissionRiskScores()) && i.j.X(Integer.valueOf(this.zzi), Integer.valueOf(exposureConfiguration.getTransmissionRiskWeight())) && Arrays.equals(this.zzj, exposureConfiguration.getDurationAtAttenuationThresholds());
        }
    }

    public final int[] getAttenuationScores() {
        int[] iArr = this.zzb;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getAttenuationWeight() {
        return this.zzc;
    }

    public final int[] getDaysSinceLastExposureScores() {
        int[] iArr = this.zzd;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getDaysSinceLastExposureWeight() {
        return this.zze;
    }

    public final int[] getDurationAtAttenuationThresholds() {
        int[] iArr = this.zzj;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int[] getDurationScores() {
        int[] iArr = this.zzf;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getDurationWeight() {
        return this.zzg;
    }

    public final int getMinimumRiskScore() {
        return this.zza;
    }

    public final int[] getTransmissionRiskScores() {
        int[] iArr = this.zzh;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getTransmissionRiskWeight() {
        return this.zzi;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Integer.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Integer.valueOf(this.zzi), this.zzj});
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.zza), Arrays.toString(this.zzb), Integer.valueOf(this.zzc), Arrays.toString(this.zzd), Integer.valueOf(this.zze), Arrays.toString(this.zzf), Integer.valueOf(this.zzg), Arrays.toString(this.zzh), Integer.valueOf(this.zzi), Arrays.toString(this.zzj));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, getMinimumRiskScore());
        i.j.v1(parcel, 2, getAttenuationScores(), false);
        i.j.u1(parcel, 3, getAttenuationWeight());
        i.j.v1(parcel, 4, getDaysSinceLastExposureScores(), false);
        i.j.u1(parcel, 5, getDaysSinceLastExposureWeight());
        i.j.v1(parcel, 6, getDurationScores(), false);
        i.j.u1(parcel, 7, getDurationWeight());
        i.j.v1(parcel, 8, getTransmissionRiskScores(), false);
        i.j.u1(parcel, 9, getTransmissionRiskWeight());
        i.j.v1(parcel, 10, getDurationAtAttenuationThresholds(), false);
        i.j.F1(parcel, e2);
    }
}
