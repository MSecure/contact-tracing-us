package f.b.a.a.a.j0;

import android.content.Context;
import android.content.res.Resources;
import f.b.b.a.k;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class b {
    public int a;
    public String b;
    public int c;

    /* renamed from: d */
    public int f2286d;

    /* renamed from: e */
    public int f2287e;

    /* renamed from: f */
    public int f2288f;

    /* renamed from: g */
    public int f2289g;

    /* renamed from: h */
    public int f2290h;

    /* renamed from: i */
    public int f2291i;

    public b(Context context, int i2) {
        int i3;
        this.a = i2;
        Resources resources = context.getResources();
        if (i2 == 1) {
            this.b = resources.getString(R.string.enx_classificationName_1);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_1);
            this.f2286d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_1);
            this.f2287e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_1);
            this.f2288f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_1);
            this.f2289g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_1);
            this.f2290h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_1);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_1;
        } else if (i2 == 2) {
            this.b = resources.getString(R.string.enx_classificationName_2);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_2);
            this.f2286d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_2);
            this.f2287e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_2);
            this.f2288f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_2);
            this.f2289g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_2);
            this.f2290h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_2);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_2;
        } else if (i2 == 3) {
            this.b = resources.getString(R.string.enx_classificationName_3);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_3);
            this.f2286d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_3);
            this.f2287e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_3);
            this.f2288f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_3);
            this.f2289g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_3);
            this.f2290h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_3);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_3;
        } else if (i2 == 4) {
            this.b = resources.getString(R.string.enx_classificationName_4);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_4);
            this.f2286d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_4);
            this.f2287e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_4);
            this.f2288f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_4);
            this.f2289g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_4);
            this.f2290h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_4);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_4;
        } else {
            throw new IllegalArgumentException("classificationIndex must be between 1 and 4 (inclusive)");
        }
        this.f2291i = resources.getInteger(i3);
    }

    public String toString() {
        k u1 = f.b.a.c.b.o.b.u1(this);
        u1.a("classificationIndex", this.a);
        u1.d("classificationName", this.b);
        u1.a("confirmedTestPerDaySumERVThreshold", this.c);
        u1.a("clinicalDiagnosisPerDaySumERVThreshold", this.f2286d);
        u1.a("selfReportPerDaySumERVThreshold", this.f2287e);
        u1.a("recursivePerDaySumERVThreshold", this.f2288f);
        u1.a("perDaySumERVThreshold", this.f2289g);
        u1.a("perDayMaxERVThreshold", this.f2290h);
        u1.a("weightedDurationAtAttenuationThreshold", this.f2291i);
        return u1.toString();
    }
}
