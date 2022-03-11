package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.i;
import f.b.a.c.f.b.m;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class DailySummary extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummary> CREATOR = new i();
    public int b;
    public List<ExposureSummaryData> c;

    /* renamed from: d */
    public ExposureSummaryData f482d;

    /* renamed from: e */
    public String f483e;

    /* loaded from: classes.dex */
    public static class ExposureSummaryData extends a implements ReflectedParcelable {
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new m();
        public double b;
        public double c;

        /* renamed from: d */
        public double f484d;

        public ExposureSummaryData(double d2, double d3, double d4) {
            this.b = d2;
            this.c = d3;
            this.f484d = d4;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                if (this.b == exposureSummaryData.b && this.c == exposureSummaryData.c && this.f484d == exposureSummaryData.f484d) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Arrays.hashCode(new Object[]{Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.f484d)});
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.f484d));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int j2 = m.e.j2(parcel, 20293);
            double d2 = this.b;
            m.e.n2(parcel, 1, 8);
            parcel.writeDouble(d2);
            double d3 = this.c;
            m.e.n2(parcel, 2, 8);
            parcel.writeDouble(d3);
            double d4 = this.f484d;
            m.e.n2(parcel, 3, 8);
            parcel.writeDouble(d4);
            m.e.o2(parcel, j2);
        }
    }

    public DailySummary(int i2, List<ExposureSummaryData> list, ExposureSummaryData exposureSummaryData, String str) {
        this.b = i2;
        this.c = list;
        this.f482d = exposureSummaryData;
        this.f483e = str;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof DailySummary) {
            DailySummary dailySummary = (DailySummary) obj;
            if (this.b == dailySummary.b && this.c.equals(dailySummary.c) && m.e.X(this.f482d, dailySummary.f482d) && m.e.X(this.f483e, dailySummary.f483e)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, this.f482d, this.f483e});
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s, deviceName: %s>", Integer.valueOf(this.b), this.c, this.f482d, this.f483e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.i2(parcel, 2, this.c, false);
        m.e.f2(parcel, 3, this.f482d, i2, false);
        m.e.g2(parcel, 4, this.f483e, false);
        m.e.o2(parcel, j2);
    }
}
