package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DailySummariesConfig extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new zza();
    public List<Double> zza;
    public List<Double> zzb;
    public List<Integer> zzc;
    public List<Double> zzd;
    public int zze;
    public double zzf;

    public static final class DailySummariesConfigBuilder {
        public Double[] zza = new Double[6];
        public Double[] zzb = new Double[zzi.values().length];
        public List<Integer> zzc;
        public List<Double> zzd;
        public int zze = 0;
        public double zzf;

        public DailySummariesConfigBuilder() {
            Double valueOf = Double.valueOf(0.0d);
            this.zzf = 0.0d;
            Arrays.fill(this.zza, valueOf);
            Arrays.fill(this.zzb, valueOf);
        }

        public static void zza(double d2, String str) {
            t.r(d2 >= 0.0d && d2 <= 2.5d, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        public static void zza(List list, int i, String str) {
            t.r(list != null, String.format(Locale.ENGLISH, "%s must not be null", str));
            t.r(list.size() == i, String.format(Locale.ENGLISH, "%s must must contains %d elements", str, Integer.valueOf(i)));
        }

        public final DailySummariesConfig build() {
            boolean z = true;
            t.r(this.zzc != null, "Must set attenuationBucketThresholdDb");
            if (this.zzd == null) {
                z = false;
            }
            t.r(z, "Must set attenuationBucketWeights");
            return new DailySummariesConfig(Arrays.asList(this.zza), Arrays.asList(this.zzb), this.zzc, this.zzd, this.zze, this.zzf);
        }

        public final DailySummariesConfigBuilder setAttenuationBuckets(List<Integer> list, List<Double> list2) {
            zza(list, zza.zza().length - 1, "attenuationBucketThresholdDb");
            for (int i = 0; i < list.size(); i++) {
                t.r(list.get(i).intValue() >= 0 && list.get(i).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
                if (i != 0) {
                    int i2 = i - 1;
                    t.r(list.get(i2).intValue() < list.get(i).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i), Integer.valueOf(i2)));
                }
            }
            this.zzc = new ArrayList(list);
            zza(list2, zza.zza().length, "attenuationBucketWeights");
            for (Double d2 : list2) {
                zza(d2.doubleValue(), "attenuationBucketWeights");
            }
            this.zzd = new ArrayList(list2);
            return this;
        }

        public final DailySummariesConfigBuilder setDaysSinceExposureThreshold(int i) {
            t.r(i >= 0, "daysSinceExposureThreshold must not be negative");
            this.zze = i;
            return this;
        }

        public final DailySummariesConfigBuilder setInfectiousnessWeight(@Infectiousness int i, double d2) {
            zzi zza2 = zzi.zza(i);
            t.r((zza2 == null || zza2 == zzi.INFECTIOUSNESS_NONE) ? false : true, "Incorrect value of infectiousness");
            zza(d2, "infectiousnessWeights");
            this.zzb[i] = Double.valueOf(d2);
            return this;
        }

        public final DailySummariesConfigBuilder setMinimumWindowScore(double d2) {
            t.r(d2 >= 0.0d, "minimumWindowScore must not be negative");
            this.zzf = d2;
            return this;
        }

        public final DailySummariesConfigBuilder setReportTypeWeight(@ReportType int i, double d2) {
            t.r(i > 0 && i < 5, "Incorrect value of reportType");
            zza(d2, "reportTypeWeights");
            this.zza[i] = Double.valueOf(d2);
            return this;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zza {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final /* synthetic */ int[] zze = {1, 2, 3, 4};

        public static int[] zza() {
            return (int[]) zze.clone();
        }
    }

    public DailySummariesConfig(List<Double> list, List<Double> list2, List<Integer> list3, List<Double> list4, int i, double d2) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = list3;
        this.zzd = list4;
        this.zze = i;
        this.zzf = d2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            return this.zza.equals(dailySummariesConfig.zza) && this.zzb.equals(dailySummariesConfig.zzb) && this.zzc.equals(dailySummariesConfig.zzc) && this.zzd.equals(dailySummariesConfig.zzd) && this.zze == dailySummariesConfig.zze && this.zzf == dailySummariesConfig.zzf;
        }
    }

    public List<Integer> getAttenuationBucketThresholdDb() {
        return new ArrayList(this.zzc);
    }

    public List<Double> getAttenuationBucketWeights() {
        return new ArrayList(this.zzd);
    }

    public int getDaysSinceExposureThreshold() {
        return this.zze;
    }

    public Map<Integer, Double> getInfectiousnessWeights() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < this.zzb.size(); i++) {
            if (i != 0) {
                hashMap.put(Integer.valueOf(i), this.zzb.get(i));
            }
        }
        return hashMap;
    }

    public double getMinimumWindowScore() {
        return this.zzf;
    }

    public Map<Integer, Double> getReportTypeWeights() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < this.zza.size(); i++) {
            if (!(i == 0 || i == 5)) {
                hashMap.put(Integer.valueOf(i), this.zza.get(i));
            }
        }
        return hashMap;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf)});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.o3(parcel, 1, new ArrayList(this.zza), false);
        t.o3(parcel, 2, new ArrayList(this.zzb), false);
        t.s3(parcel, 3, getAttenuationBucketThresholdDb(), false);
        t.o3(parcel, 4, getAttenuationBucketWeights(), false);
        t.q3(parcel, 5, getDaysSinceExposureThreshold());
        t.n3(parcel, 6, getMinimumWindowScore());
        t.w4(parcel, m);
    }
}
