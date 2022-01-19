package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public class DailySummary extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummary> CREATOR = new zzb();
    public int zza;
    public List<ExposureSummaryData> zzb;
    public ExposureSummaryData zzc;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
    public static class ExposureSummaryData extends AbstractSafeParcelable implements ReflectedParcelable {
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new zzk();
        public double zza;
        public double zzb;
        public double zzc;

        public ExposureSummaryData(double d, double d2, double d3) {
            this.zza = d;
            this.zzb = d2;
            this.zzc = d3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                if (this.zza == exposureSummaryData.zza && this.zzb == exposureSummaryData.zzb && this.zzc == exposureSummaryData.zzc) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc)});
        }

        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc));
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
            ReactYogaConfigProvider.writeDouble(parcel, 1, this.zza);
            ReactYogaConfigProvider.writeDouble(parcel, 2, this.zzb);
            ReactYogaConfigProvider.writeDouble(parcel, 3, this.zzc);
            ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
        }
    }

    public DailySummary(int i, List<ExposureSummaryData> list, ExposureSummaryData exposureSummaryData) {
        this.zza = i;
        this.zzb = list;
        this.zzc = exposureSummaryData;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummary) {
            DailySummary dailySummary = (DailySummary) obj;
            if (this.zza != dailySummary.zza || !this.zzb.equals(dailySummary.zzb) || !ReactYogaConfigProvider.equal(this.zzc, dailySummary.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, this.zzc});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s>", Integer.valueOf(this.zza), this.zzb, this.zzc);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zza);
        ReactYogaConfigProvider.writeTypedList(parcel, 2, this.zzb, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, this.zzc, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
