package f.b.a.a.a.x;

import android.content.Context;
import android.content.res.Resources;
import f.b.b.a.k;
import gov.co.cdphe.exposurenotifications.R;

public class b {
    public int a;
    public String b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2457d;

    /* renamed from: e  reason: collision with root package name */
    public int f2458e;

    /* renamed from: f  reason: collision with root package name */
    public int f2459f;

    /* renamed from: g  reason: collision with root package name */
    public int f2460g;

    /* renamed from: h  reason: collision with root package name */
    public int f2461h;

    /* renamed from: i  reason: collision with root package name */
    public int f2462i;

    public b(Context context, int i2) {
        int i3;
        this.a = i2;
        Resources resources = context.getResources();
        if (i2 == 1) {
            this.b = resources.getString(R.string.enx_classificationName_1);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_1);
            this.f2457d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_1);
            this.f2458e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_1);
            this.f2459f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_1);
            this.f2460g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_1);
            this.f2461h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_1);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_1;
        } else if (i2 == 2) {
            this.b = resources.getString(R.string.enx_classificationName_2);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_2);
            this.f2457d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_2);
            this.f2458e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_2);
            this.f2459f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_2);
            this.f2460g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_2);
            this.f2461h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_2);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_2;
        } else if (i2 == 3) {
            this.b = resources.getString(R.string.enx_classificationName_3);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_3);
            this.f2457d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_3);
            this.f2458e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_3);
            this.f2459f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_3);
            this.f2460g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_3);
            this.f2461h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_3);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_3;
        } else if (i2 == 4) {
            this.b = resources.getString(R.string.enx_classificationName_4);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_4);
            this.f2457d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_4);
            this.f2458e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_4);
            this.f2459f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_4);
            this.f2460g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_4);
            this.f2461h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_4);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_4;
        } else {
            throw new IllegalArgumentException("classificationIndex must be between 1 and 4 (inclusive)");
        }
        this.f2462i = resources.getInteger(i3);
    }

    public String toString() {
        k q1 = f.b.a.c.b.o.b.q1(this);
        q1.a("classificationIndex", this.a);
        q1.d("classificationName", this.b);
        q1.a("confirmedTestPerDaySumERVThreshold", this.c);
        q1.a("clinicalDiagnosisPerDaySumERVThreshold", this.f2457d);
        q1.a("selfReportPerDaySumERVThreshold", this.f2458e);
        q1.a("recursivePerDaySumERVThreshold", this.f2459f);
        q1.a("perDaySumERVThreshold", this.f2460g);
        q1.a("perDayMaxERVThreshold", this.f2461h);
        q1.a("weightedDurationAtAttenuationThreshold", this.f2462i);
        return q1.toString();
    }
}
