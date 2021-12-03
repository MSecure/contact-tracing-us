package f.b.a.a.a.q;

import com.google.android.gms.nearby.exposurenotification.DailySummary;
import f.b.a.a.a.q.e1;
import f.b.a.c.i.a;
import f.b.b.b.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class h implements a {
    public final /* synthetic */ i1 a;

    public /* synthetic */ h(i1 i1Var) {
        this.a = i1Var;
    }

    @Override // f.b.a.c.i.a
    public final Object a(f.b.a.c.i.h hVar) {
        Objects.requireNonNull(this.a);
        List<DailySummary> list = (List) hVar.l();
        ArrayList arrayList = new ArrayList(list.size());
        for (DailySummary dailySummary : list) {
            ArrayList arrayList2 = new ArrayList(6);
            for (int i2 = 0; i2 < 6; i2++) {
                arrayList2.add(e1.a.d().a());
            }
            Integer valueOf = Integer.valueOf(dailySummary.b);
            DailySummary.ExposureSummaryData exposureSummaryData = dailySummary.f476d;
            e1.a.AbstractC0071a d2 = e1.a.d();
            d2.b(exposureSummaryData.b);
            d2.c(exposureSummaryData.c);
            d2.d(exposureSummaryData.f478d);
            e1.a a2 = d2.a();
            f.b.b.b.a t = c.y(0, 1, 2, 3, 4, 5).listIterator();
            while (t.hasNext()) {
                int intValue = ((Integer) t.next()).intValue();
                DailySummary.ExposureSummaryData exposureSummaryData2 = dailySummary.c.get(intValue);
                e1.a.AbstractC0071a d3 = e1.a.d();
                d3.b(exposureSummaryData2.b);
                d3.c(exposureSummaryData2.c);
                d3.d(exposureSummaryData2.f478d);
                arrayList2.set(intValue, d3.a());
            }
            String str = valueOf == null ? " daysSinceEpoch" : "";
            if (str.isEmpty()) {
                arrayList.add(new c1(valueOf.intValue(), a2, arrayList2, null));
            } else {
                throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
            }
        }
        return c.s(arrayList);
    }
}
