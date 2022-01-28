package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DailySummary extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummary> CREATOR = new zzb();
    public int zza;
    public List<ExposureSummaryData> zzb;
    public ExposureSummaryData zzc;

    public static class ExposureSummaryData extends a implements ReflectedParcelable {
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new zzj();
        public double zza;
        public double zzb;
        public double zzc;

        public ExposureSummaryData(double d2, double d3, double d4) {
            this.zza = d2;
            this.zzb = d3;
            this.zzc = d4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                return this.zza == exposureSummaryData.zza && this.zzb == exposureSummaryData.zzb && this.zzc == exposureSummaryData.zzc;
            }
        }

        public double getMaximumScore() {
            return this.zza;
        }

        public double getScoreSum() {
            return this.zzb;
        }

        public double getWeightedDurationSum() {
            return this.zzc;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc)});
        }

        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc));
        }

        public void writeToParcel(Parcel parcel, int i) {
            int m = t.m(parcel);
            t.n3(parcel, 1, getMaximumScore());
            t.n3(parcel, 2, getScoreSum());
            t.n3(parcel, 3, getWeightedDurationSum());
            t.w4(parcel, m);
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
            return this.zza == dailySummary.zza && this.zzb.equals(dailySummary.zzb) && t.j1(this.zzc, dailySummary.zzc);
        }
    }

    public int getDaysSinceEpoch() {
        return this.zza;
    }

    public ExposureSummaryData getSummaryData() {
        return this.zzc;
    }

    public ExposureSummaryData getSummaryDataForReportType(@ReportType int i) {
        return this.zzb.get(i);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, this.zzc});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s>", Integer.valueOf(this.zza), this.zzb, this.zzc);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, getDaysSinceEpoch());
        t.z3(parcel, 2, this.zzb, false);
        t.v3(parcel, 3, getSummaryData(), i, false);
        t.w4(parcel, m);
    }
}
