package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
public final class ExposureSummary extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<ExposureSummary> CREATOR = new zzk();
    public int zza;
    public int zzb;
    public int zzc;
    public int[] zzd;
    public int zze;

    public static final class ExposureSummaryBuilder {
        public int zza = 0;
        public int zzb = 0;
        public int zzc = 0;
        public int[] zzd = {0, 0, 0};
        public int zze = 0;

        public final ExposureSummary build() {
            return new ExposureSummary(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public final ExposureSummaryBuilder setAttenuationDurations(int[] iArr) {
            i.j.i(iArr.length == 3);
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                i.j.j(i2 >= 0, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i2));
            }
            this.zzd = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public final ExposureSummaryBuilder setDaysSinceLastExposure(int i) {
            i.j.j(i >= 0, "daysSinceLastExposure (%s) must be >= 0", Integer.valueOf(i));
            this.zza = i;
            return this;
        }

        public final ExposureSummaryBuilder setMatchedKeyCount(int i) {
            i.j.j(i >= 0, "matchedKeyCount (%s) must be >= 0", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public final ExposureSummaryBuilder setMaximumRiskScore(int i) {
            i.j.j(i >= 0 && i <= 4096, "maximumRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public final ExposureSummaryBuilder setSummationRiskScore(int i) {
            i.j.j(i >= 0, "summationRiskScore (%s) must be >= 0", Integer.valueOf(i));
            this.zze = i;
            return this;
        }
    }

    public ExposureSummary(int i, int i2, int i3, int[] iArr, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = i4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExposureSummary) {
            ExposureSummary exposureSummary = (ExposureSummary) obj;
            return i.j.X(Integer.valueOf(this.zza), Integer.valueOf(exposureSummary.getDaysSinceLastExposure())) && i.j.X(Integer.valueOf(this.zzb), Integer.valueOf(exposureSummary.getMatchedKeyCount())) && i.j.X(Integer.valueOf(this.zzc), Integer.valueOf(exposureSummary.getMaximumRiskScore())) && Arrays.equals(this.zzd, exposureSummary.getAttenuationDurationsInMinutes()) && i.j.X(Integer.valueOf(this.zze), Integer.valueOf(exposureSummary.getSummationRiskScore()));
        }
    }

    public final int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.zzd;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final int getDaysSinceLastExposure() {
        return this.zza;
    }

    public final int getMatchedKeyCount() {
        return this.zzb;
    }

    public final int getMaximumRiskScore() {
        return this.zzc;
    }

    public final int getSummationRiskScore() {
        return this.zze;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, Integer.valueOf(this.zze)});
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureSummary<daysSinceLastExposure: %d, matchedKeyCount: %d, maximumRiskScore: %d, attenuationDurations: %s, summationRiskScore: %d>", Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Arrays.toString(this.zzd), Integer.valueOf(this.zze));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, getDaysSinceLastExposure());
        i.j.u1(parcel, 2, getMatchedKeyCount());
        i.j.u1(parcel, 3, getMaximumRiskScore());
        i.j.v1(parcel, 4, getAttenuationDurationsInMinutes(), false);
        i.j.u1(parcel, 5, getSummationRiskScore());
        i.j.F1(parcel, e2);
    }
}
