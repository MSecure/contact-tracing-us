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
/* loaded from: classes.dex */
public class DailySummariesConfig extends f.b.a.c.b.m.n.a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new h();
    public List<Double> b;
    public List<Double> c;

    /* renamed from: d */
    public List<Integer> f476d;

    /* renamed from: e */
    public List<Double> f477e;

    /* renamed from: f */
    public int f478f;

    /* renamed from: g */
    public double f479g;

    /* loaded from: classes.dex */
    public static final class a {
        public List<Integer> c;

        /* renamed from: d */
        public List<Double> f480d;
        public Double[] a = new Double[6];
        public Double[] b = new Double[3];

        /* renamed from: e */
        public int f481e = 0;

        public a() {
            l.values();
            Double[] dArr = this.a;
            Double valueOf = Double.valueOf(0.0d);
            Arrays.fill(dArr, valueOf);
            Arrays.fill(this.b, valueOf);
        }

        public static void c(List list, int i2, String str) {
            boolean z = list != null;
            Locale locale = Locale.ENGLISH;
            m.e.k(z, String.format(locale, "%s must not be null", str));
            m.e.k(list.size() == i2, String.format(locale, "%s must must contains %d elements", str, Integer.valueOf(i2)));
        }

        public static void d(double d2, String str) {
            m.e.k(d2 >= 0.0d && d2 <= 2.5d, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        public a a(int i2, double d2) {
            l a = l.a(i2);
            boolean z = false;
            if (!(a == null || a == l.INFECTIOUSNESS_NONE)) {
                z = true;
            }
            m.e.k(z, "Incorrect value of infectiousness");
            d(d2, "infectiousnessWeights");
            this.b[i2] = Double.valueOf(d2);
            return this;
        }

        public a b(int i2, double d2) {
            boolean z = false;
            if (i2 > 0 && i2 < 5) {
                z = true;
            }
            m.e.k(z, "Incorrect value of reportType");
            d(d2, "reportTypeWeights");
            this.a[i2] = Double.valueOf(d2);
            return this;
        }
    }

    public DailySummariesConfig(List<Double> list, List<Double> list2, List<Integer> list3, List<Double> list4, int i2, double d2) {
        this.b = list;
        this.c = list2;
        this.f476d = list3;
        this.f477e = list4;
        this.f478f = i2;
        this.f479g = d2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            if (this.b.equals(dailySummariesConfig.b) && this.c.equals(dailySummariesConfig.c) && this.f476d.equals(dailySummariesConfig.f476d) && this.f477e.equals(dailySummariesConfig.f477e) && this.f478f == dailySummariesConfig.f478f && this.f479g == dailySummariesConfig.f479g) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f476d, this.f477e, Integer.valueOf(this.f478f), Double.valueOf(this.f479g)});
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.b, this.c, this.f476d, this.f477e, Integer.valueOf(this.f478f), Double.valueOf(this.f479g));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.b2(parcel, 1, new ArrayList(this.b), false);
        m.e.b2(parcel, 2, new ArrayList(this.c), false);
        m.e.e2(parcel, 3, new ArrayList(this.f476d), false);
        m.e.b2(parcel, 4, new ArrayList(this.f477e), false);
        int i3 = this.f478f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i3);
        double d2 = this.f479g;
        m.e.n2(parcel, 6, 8);
        parcel.writeDouble(d2);
        m.e.o2(parcel, j2);
    }
}
