package f.b.a.a.a.c0;

import f.b.a.a.a.c0.l1;
import java.util.List;
/* loaded from: classes.dex */
public final class j1 extends l1 {
    public final int a;
    public final l1.a b;
    public final List<l1.a> c;

    public j1(int i2, l1.a aVar, List list, a aVar2) {
        this.a = i2;
        this.b = aVar;
        this.c = list;
    }

    @Override // f.b.a.a.a.c0.l1
    public int a() {
        return this.a;
    }

    @Override // f.b.a.a.a.c0.l1
    public List<l1.a> b() {
        return this.c;
    }

    @Override // f.b.a.a.a.c0.l1
    public l1.a c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.a == l1Var.a() && this.b.equals(l1Var.c()) && this.c.equals(l1Var.b());
    }

    public int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("DailySummaryWrapper{daysSinceEpoch=");
        h2.append(this.a);
        h2.append(", summaryData=");
        h2.append(this.b);
        h2.append(", reportSummaries=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
