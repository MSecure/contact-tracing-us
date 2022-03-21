package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.h;
import f.b.a.c.f.b.l;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DailySummary extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummary> CREATOR = new h();
    public int b;
    public List<ExposureSummaryData> c;

    /* renamed from: d  reason: collision with root package name */
    public ExposureSummaryData f432d;

    public static class ExposureSummaryData extends a implements ReflectedParcelable {
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new l();
        public double b;
        public double c;

        /* renamed from: d  reason: collision with root package name */
        public double f433d;

        public ExposureSummaryData(double d2, double d3, double d4) {
            this.b = d2;
            this.c = d3;
            this.f433d = d4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                return this.b == exposureSummaryData.b && this.c == exposureSummaryData.c && this.f433d == exposureSummaryData.f433d;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.f433d)});
        }

        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.f433d));
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int H1 = m.h.H1(parcel, 20293);
            double d2 = this.b;
            m.h.L1(parcel, 1, 8);
            parcel.writeDouble(d2);
            double d3 = this.c;
            m.h.L1(parcel, 2, 8);
            parcel.writeDouble(d3);
            double d4 = this.f433d;
            m.h.L1(parcel, 3, 8);
            parcel.writeDouble(d4);
            m.h.M1(parcel, H1);
        }
    }

    public DailySummary(int i2, List<ExposureSummaryData> list, ExposureSummaryData exposureSummaryData) {
        this.b = i2;
        this.c = list;
        this.f432d = exposureSummaryData;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummary) {
            DailySummary dailySummary = (DailySummary) obj;
            return this.b == dailySummary.b && this.c.equals(dailySummary.c) && m.h.U(this.f432d, dailySummary.f432d);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, this.f432d});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s>", Integer.valueOf(this.b), this.c, this.f432d);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.G1(parcel, 2, this.c, false);
        m.h.D1(parcel, 3, this.f432d, i2, false);
        m.h.M1(parcel, H1);
    }
}
