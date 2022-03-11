package f.b.a.a.a.t;

import android.content.Context;
import android.content.res.Resources;
import f.b.b.a.k;
import gov.wa.doh.exposurenotifications.R;

public class b {
    public int a;
    public String b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2243d;

    /* renamed from: e  reason: collision with root package name */
    public int f2244e;

    /* renamed from: f  reason: collision with root package name */
    public int f2245f;

    /* renamed from: g  reason: collision with root package name */
    public int f2246g;

    /* renamed from: h  reason: collision with root package name */
    public int f2247h;

    /* renamed from: i  reason: collision with root package name */
    public int f2248i;

    public b(Context context, int i2) {
        int i3;
        this.a = i2;
        Resources resources = context.getResources();
        if (i2 == 1) {
            this.b = resources.getString(R.string.enx_classificationName_1);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_1);
            this.f2243d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_1);
            this.f2244e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_1);
            this.f2245f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_1);
            this.f2246g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_1);
            this.f2247h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_1);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_1;
        } else if (i2 == 2) {
            this.b = resources.getString(R.string.enx_classificationName_2);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_2);
            this.f2243d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_2);
            this.f2244e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_2);
            this.f2245f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_2);
            this.f2246g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_2);
            this.f2247h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_2);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_2;
        } else if (i2 == 3) {
            this.b = resources.getString(R.string.enx_classificationName_3);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_3);
            this.f2243d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_3);
            this.f2244e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_3);
            this.f2245f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_3);
            this.f2246g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_3);
            this.f2247h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_3);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_3;
        } else if (i2 == 4) {
            this.b = resources.getString(R.string.enx_classificationName_4);
            this.c = resources.getInteger(R.integer.enx_confirmedTestPerDaySumERVThreshold_4);
            this.f2243d = resources.getInteger(R.integer.enx_clinicalDiagnosisPerDaySumERVThreshold_4);
            this.f2244e = resources.getInteger(R.integer.enx_selfReportPerDaySumERVThreshold_4);
            this.f2245f = resources.getInteger(R.integer.enx_recursivePerDaySumERVThreshold_4);
            this.f2246g = resources.getInteger(R.integer.enx_perDaySumERVThreshold_4);
            this.f2247h = resources.getInteger(R.integer.enx_perDayMaxERVThreshold_4);
            i3 = R.integer.enx_weightedDurationAtAttenuationThreshold_4;
        } else {
            throw new IllegalArgumentException("classificationIndex must be between 1 and 4 (inclusive)");
        }
        this.f2248i = resources.getInteger(i3);
    }

    public String toString() {
        k U1 = f.b.a.c.b.o.b.U1(this);
        U1.a("classificationIndex", this.a);
        U1.d("classificationName", this.b);
        U1.a("confirmedTestPerDaySumERVThreshold", this.c);
        U1.a("clinicalDiagnosisPerDaySumERVThreshold", this.f2243d);
        U1.a("selfReportPerDaySumERVThreshold", this.f2244e);
        U1.a("recursivePerDaySumERVThreshold", this.f2245f);
        U1.a("perDaySumERVThreshold", this.f2246g);
        U1.a("perDayMaxERVThreshold", this.f2247h);
        U1.a("weightedDurationAtAttenuationThreshold", this.f2248i);
        return U1.toString();
    }
}
