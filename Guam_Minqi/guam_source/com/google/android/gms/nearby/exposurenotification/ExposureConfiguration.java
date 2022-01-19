package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class ExposureConfiguration extends AbstractSafeParcelable {
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

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
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
        if (!(obj instanceof ExposureConfiguration)) {
            return false;
        }
        ExposureConfiguration exposureConfiguration = (ExposureConfiguration) obj;
        if (!ReactYogaConfigProvider.equal(Integer.valueOf(this.zza), Integer.valueOf(exposureConfiguration.zza))) {
            return false;
        }
        int[] iArr = this.zzb;
        int[] iArr2 = exposureConfiguration.zzb;
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !ReactYogaConfigProvider.equal(Integer.valueOf(this.zzc), Integer.valueOf(exposureConfiguration.zzc))) {
            return false;
        }
        int[] iArr3 = this.zzd;
        int[] iArr4 = exposureConfiguration.zzd;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !ReactYogaConfigProvider.equal(Integer.valueOf(this.zze), Integer.valueOf(exposureConfiguration.zze))) {
            return false;
        }
        int[] iArr5 = this.zzf;
        int[] iArr6 = exposureConfiguration.zzf;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !ReactYogaConfigProvider.equal(Integer.valueOf(this.zzg), Integer.valueOf(exposureConfiguration.zzg))) {
            return false;
        }
        int[] iArr7 = this.zzh;
        int[] iArr8 = exposureConfiguration.zzh;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !ReactYogaConfigProvider.equal(Integer.valueOf(this.zzi), Integer.valueOf(exposureConfiguration.zzi))) {
            return false;
        }
        int[] iArr9 = this.zzj;
        int[] iArr10 = exposureConfiguration.zzj;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Integer.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Integer.valueOf(this.zzi), this.zzj});
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.zza), Arrays.toString(this.zzb), Integer.valueOf(this.zzc), Arrays.toString(this.zzd), Integer.valueOf(this.zze), Arrays.toString(this.zzf), Integer.valueOf(this.zzg), Arrays.toString(this.zzh), Integer.valueOf(this.zzi), Arrays.toString(this.zzj));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zza);
        int[] iArr = this.zzb;
        ReactYogaConfigProvider.writeIntArray(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zzc);
        int[] iArr2 = this.zzd;
        ReactYogaConfigProvider.writeIntArray(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        ReactYogaConfigProvider.writeInt(parcel, 5, this.zze);
        int[] iArr3 = this.zzf;
        ReactYogaConfigProvider.writeIntArray(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        ReactYogaConfigProvider.writeInt(parcel, 7, this.zzg);
        int[] iArr4 = this.zzh;
        ReactYogaConfigProvider.writeIntArray(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        ReactYogaConfigProvider.writeInt(parcel, 9, this.zzi);
        int[] iArr5 = this.zzj;
        ReactYogaConfigProvider.writeIntArray(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
