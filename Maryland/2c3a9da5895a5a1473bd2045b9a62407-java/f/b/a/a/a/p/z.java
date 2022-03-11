package f.b.a.a.a.p;

import f.b.a.a.a.p.b0;
import java.util.List;

public final class z extends b0 {
    public final int a;
    public final b0.a b;
    public final List<b0.a> c;

    public z(int i2, b0.a aVar, List list, a aVar2) {
        this.a = i2;
        this.b = aVar;
        this.c = list;
    }

    @Override // f.b.a.a.a.p.b0
    public int a() {
        return this.a;
    }

    @Override // f.b.a.a.a.p.b0
    public List<b0.a> b() {
        return this.c;
    }

    @Override // f.b.a.a.a.p.b0
    public b0.a c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.a() && this.b.equals(b0Var.c()) && this.c.equals(b0Var.b());
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
