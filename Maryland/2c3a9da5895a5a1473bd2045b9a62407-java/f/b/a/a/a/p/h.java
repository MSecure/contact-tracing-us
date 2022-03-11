package f.b.a.a.a.p;

import com.google.android.gms.nearby.exposurenotification.DailySummary;
import f.b.a.a.a.p.b0;
import f.b.a.c.i.a;
import f.b.b.b.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class h implements a {
    public final /* synthetic */ f0 a;

    public /* synthetic */ h(f0 f0Var) {
        this.a = f0Var;
    }

    @Override // f.b.a.c.i.a
    public final Object a(f.b.a.c.i.h hVar) {
        Objects.requireNonNull(this.a);
        List<DailySummary> list = (List) hVar.k();
        ArrayList arrayList = new ArrayList(list.size());
        for (DailySummary dailySummary : list) {
            ArrayList arrayList2 = new ArrayList(6);
            for (int i2 = 0; i2 < 6; i2++) {
                arrayList2.add(b0.a.d().a());
            }
            Integer valueOf = Integer.valueOf(dailySummary.b);
            DailySummary.ExposureSummaryData exposureSummaryData = dailySummary.f448d;
            b0.a.AbstractC0073a d2 = b0.a.d();
            d2.b(exposureSummaryData.b);
            d2.c(exposureSummaryData.c);
            d2.d(exposureSummaryData.f450d);
            b0.a a2 = d2.a();
            f.b.b.b.a t = c.v(0, 1, 2, 3, 4, 5).listIterator();
            while (t.hasNext()) {
                int intValue = ((Integer) t.next()).intValue();
                DailySummary.ExposureSummaryData exposureSummaryData2 = dailySummary.c.get(intValue);
                b0.a.AbstractC0073a d3 = b0.a.d();
                d3.b(exposureSummaryData2.b);
                d3.c(exposureSummaryData2.c);
                d3.d(exposureSummaryData2.f450d);
                arrayList2.set(intValue, d3.a());
            }
            String str = valueOf == null ? " daysSinceEpoch" : "";
            if (str.isEmpty()) {
                arrayList.add(new z(valueOf.intValue(), a2, arrayList2, null));
            } else {
                throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
            }
        }
        return c.s(arrayList);
    }
}
