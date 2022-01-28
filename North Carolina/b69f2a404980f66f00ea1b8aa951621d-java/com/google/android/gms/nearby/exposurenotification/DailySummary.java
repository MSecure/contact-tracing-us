package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
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
            int e2 = i.j.e(parcel);
            i.j.r1(parcel, 1, getMaximumScore());
            i.j.r1(parcel, 2, getScoreSum());
            i.j.r1(parcel, 3, getWeightedDurationSum());
            i.j.F1(parcel, e2);
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
            return this.zza == dailySummary.zza && this.zzb.equals(dailySummary.zzb) && i.j.X(this.zzc, dailySummary.zzc);
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
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, getDaysSinceEpoch());
        i.j.B1(parcel, 2, this.zzb, false);
        i.j.y1(parcel, 3, getSummaryData(), i, false);
        i.j.F1(parcel, e2);
    }
}
