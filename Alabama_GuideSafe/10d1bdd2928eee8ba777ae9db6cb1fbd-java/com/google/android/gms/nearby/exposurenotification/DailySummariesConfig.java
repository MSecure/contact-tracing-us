package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public class DailySummariesConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new zza();
    public List<Double> zza;
    public List<Double> zzb;
    public List<Integer> zzc;
    public List<Double> zzd;
    public int zze;
    public double zzf;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
    public static final class zza {
        public static final /* synthetic */ int[] zze = {1, 2, 3, 4};
    }

    public DailySummariesConfig(List<Double> list, List<Double> list2, List<Integer> list3, List<Double> list4, int i, double d) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = list3;
        this.zzd = list4;
        this.zze = i;
        this.zzf = d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            if (!this.zza.equals(dailySummariesConfig.zza) || !this.zzb.equals(dailySummariesConfig.zzb) || !this.zzc.equals(dailySummariesConfig.zzc) || !this.zzd.equals(dailySummariesConfig.zzd) || this.zze != dailySummariesConfig.zze || this.zzf != dailySummariesConfig.zzf) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf)});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeDoubleList(parcel, 1, new ArrayList(this.zza), false);
        ReactYogaConfigProvider.writeDoubleList(parcel, 2, new ArrayList(this.zzb), false);
        ReactYogaConfigProvider.writeIntegerList(parcel, 3, new ArrayList(this.zzc), false);
        ReactYogaConfigProvider.writeDoubleList(parcel, 4, new ArrayList(this.zzd), false);
        ReactYogaConfigProvider.writeInt(parcel, 5, this.zze);
        ReactYogaConfigProvider.writeDouble(parcel, 6, this.zzf);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
    public static final class DailySummariesConfigBuilder {
        public Double[] zza = new Double[6];
        public Double[] zzb = new Double[zzg.values().length];
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

        public static void zza(List list, int i, String str) {
            ReactYogaConfigProvider.checkArgument(list != null, String.format(Locale.ENGLISH, "%s must not be null", str));
            ReactYogaConfigProvider.checkArgument(list.size() == i, String.format(Locale.ENGLISH, "%s must must contains %d elements", str, Integer.valueOf(i)));
        }

        public final DailySummariesConfigBuilder setInfectiousnessWeight(int i, double d) {
            zzg zza2 = zzg.zza(i);
            ReactYogaConfigProvider.checkArgument((zza2 == null || zza2 == zzg.INFECTIOUSNESS_NONE) ? false : true, "Incorrect value of infectiousness");
            zza(d, "infectiousnessWeights");
            this.zzb[i] = Double.valueOf(d);
            return this;
        }

        public final DailySummariesConfigBuilder setReportTypeWeight(int i, double d) {
            ReactYogaConfigProvider.checkArgument(i > 0 && i < 5, "Incorrect value of reportType");
            zza(d, "reportTypeWeights");
            this.zza[i] = Double.valueOf(d);
            return this;
        }

        public static void zza(double d, String str) {
            ReactYogaConfigProvider.checkArgument(d >= 0.0d && d <= 2.5d, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }
    }
}
