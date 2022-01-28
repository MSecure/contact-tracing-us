package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.f.b.h;
import f.b.a.c.f.b.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DailySummariesConfig extends f.b.a.c.b.m.n.a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new h();
    public List<Double> b;
    public List<Double> c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f470d;

    /* renamed from: e  reason: collision with root package name */
    public List<Double> f471e;

    /* renamed from: f  reason: collision with root package name */
    public int f472f;

    /* renamed from: g  reason: collision with root package name */
    public double f473g;

    public static final class a {
        public Double[] a = new Double[6];
        public Double[] b;
        public List<Integer> c;

        /* renamed from: d  reason: collision with root package name */
        public List<Double> f474d;

        /* renamed from: e  reason: collision with root package name */
        public int f475e;

        public a() {
            l.values();
            this.b = new Double[3];
            this.f475e = 0;
            Double[] dArr = this.a;
            Double valueOf = Double.valueOf(0.0d);
            Arrays.fill(dArr, valueOf);
            Arrays.fill(this.b, valueOf);
        }

        public static void c(List list, int i2, String str) {
            boolean z = list != null;
            Locale locale = Locale.ENGLISH;
            m.h.j(z, String.format(locale, "%s must not be null", str));
            m.h.j(list.size() == i2, String.format(locale, "%s must must contains %d elements", str, Integer.valueOf(i2)));
        }

        public static void d(double d2, String str) {
            m.h.j(d2 >= 0.0d && d2 <= 2.5d, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        public a a(int i2, double d2) {
            l a2 = l.a(i2);
            boolean z = false;
            if (!(a2 == null || a2 == l.INFECTIOUSNESS_NONE)) {
                z = true;
            }
            m.h.j(z, "Incorrect value of infectiousness");
            d(d2, "infectiousnessWeights");
            this.b[i2] = Double.valueOf(d2);
            return this;
        }

        public a b(int i2, double d2) {
            boolean z = false;
            if (i2 > 0 && i2 < 5) {
                z = true;
            }
            m.h.j(z, "Incorrect value of reportType");
            d(d2, "reportTypeWeights");
            this.a[i2] = Double.valueOf(d2);
            return this;
        }
    }

    public DailySummariesConfig(List<Double> list, List<Double> list2, List<Integer> list3, List<Double> list4, int i2, double d2) {
        this.b = list;
        this.c = list2;
        this.f470d = list3;
        this.f471e = list4;
        this.f472f = i2;
        this.f473g = d2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            return this.b.equals(dailySummariesConfig.b) && this.c.equals(dailySummariesConfig.c) && this.f470d.equals(dailySummariesConfig.f470d) && this.f471e.equals(dailySummariesConfig.f471e) && this.f472f == dailySummariesConfig.f472f && this.f473g == dailySummariesConfig.f473g;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f470d, this.f471e, Integer.valueOf(this.f472f), Double.valueOf(this.f473g)});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.b, this.c, this.f470d, this.f471e, Integer.valueOf(this.f472f), Double.valueOf(this.f473g));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.G1(parcel, 1, new ArrayList(this.b), false);
        m.h.G1(parcel, 2, new ArrayList(this.c), false);
        m.h.J1(parcel, 3, new ArrayList(this.f470d), false);
        m.h.G1(parcel, 4, new ArrayList(this.f471e), false);
        int i3 = this.f472f;
        m.h.S1(parcel, 5, 4);
        parcel.writeInt(i3);
        double d2 = this.f473g;
        m.h.S1(parcel, 6, 8);
        parcel.writeDouble(d2);
        m.h.T1(parcel, O1);
    }
}
