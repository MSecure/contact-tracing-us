package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.f.b.g;
import f.b.a.c.f.b.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DailySummariesConfig extends f.b.a.c.b.m.n.a implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new g();
    public List<Double> b;
    public List<Double> c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f426d;

    /* renamed from: e  reason: collision with root package name */
    public List<Double> f427e;

    /* renamed from: f  reason: collision with root package name */
    public int f428f;

    /* renamed from: g  reason: collision with root package name */
    public double f429g;

    public static final class a {
        public Double[] a = new Double[6];
        public Double[] b;
        public List<Integer> c;

        /* renamed from: d  reason: collision with root package name */
        public List<Double> f430d;

        /* renamed from: e  reason: collision with root package name */
        public int f431e;

        public a() {
            k.values();
            this.b = new Double[3];
            this.f431e = 0;
            Double valueOf = Double.valueOf(0.0d);
            Arrays.fill(this.a, valueOf);
            Arrays.fill(this.b, valueOf);
        }

        public static void c(double d2, String str) {
            m.h.j(d2 >= 0.0d && d2 <= 2.5d, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        public static void d(List list, int i2, String str) {
            boolean z = list != null;
            Locale locale = Locale.ENGLISH;
            m.h.j(z, String.format(locale, "%s must not be null", str));
            m.h.j(list.size() == i2, String.format(locale, "%s must must contains %d elements", str, Integer.valueOf(i2)));
        }

        public final a a(int i2, double d2) {
            k a2 = k.a(i2);
            m.h.j((a2 == null || a2 == k.INFECTIOUSNESS_NONE) ? false : true, "Incorrect value of infectiousness");
            c(d2, "infectiousnessWeights");
            this.b[i2] = Double.valueOf(d2);
            return this;
        }

        public final a b(int i2, double d2) {
            m.h.j(i2 > 0 && i2 < 5, "Incorrect value of reportType");
            c(d2, "reportTypeWeights");
            this.a[i2] = Double.valueOf(d2);
            return this;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class b {
        public static final /* synthetic */ int[] a = {1, 2, 3, 4};
    }

    public DailySummariesConfig(List<Double> list, List<Double> list2, List<Integer> list3, List<Double> list4, int i2, double d2) {
        this.b = list;
        this.c = list2;
        this.f426d = list3;
        this.f427e = list4;
        this.f428f = i2;
        this.f429g = d2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            return this.b.equals(dailySummariesConfig.b) && this.c.equals(dailySummariesConfig.c) && this.f426d.equals(dailySummariesConfig.f426d) && this.f427e.equals(dailySummariesConfig.f427e) && this.f428f == dailySummariesConfig.f428f && this.f429g == dailySummariesConfig.f429g;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f426d, this.f427e, Integer.valueOf(this.f428f), Double.valueOf(this.f429g)});
    }

    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.b, this.c, this.f426d, this.f427e, Integer.valueOf(this.f428f), Double.valueOf(this.f429g));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.A1(parcel, 1, new ArrayList(this.b), false);
        m.h.A1(parcel, 2, new ArrayList(this.c), false);
        m.h.D1(parcel, 3, new ArrayList(this.f426d), false);
        m.h.A1(parcel, 4, new ArrayList(this.f427e), false);
        int i3 = this.f428f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(i3);
        double d2 = this.f429g;
        m.h.M1(parcel, 6, 8);
        parcel.writeDouble(d2);
        m.h.N1(parcel, I1);
    }
}
