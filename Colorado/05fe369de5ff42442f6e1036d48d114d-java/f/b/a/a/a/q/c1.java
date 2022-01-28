package f.b.a.a.a.q;

import f.b.a.a.a.q.e1;
import java.util.List;

public final class c1 extends e1 {
    public final int a;
    public final e1.a b;
    public final List<e1.a> c;

    public c1(int i2, e1.a aVar, List list, a aVar2) {
        this.a = i2;
        this.b = aVar;
        this.c = list;
    }

    @Override // f.b.a.a.a.q.e1
    public int a() {
        return this.a;
    }

    @Override // f.b.a.a.a.q.e1
    public List<e1.a> b() {
        return this.c;
    }

    @Override // f.b.a.a.a.q.e1
    public e1.a c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.a == e1Var.a() && this.b.equals(e1Var.c()) && this.c.equals(e1Var.b());
    }

    public int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("DailySummaryWrapper{daysSinceEpoch=");
        i2.append(this.a);
        i2.append(", summaryData=");
        i2.append(this.b);
        i2.append(", reportSummaries=");
        i2.append(this.c);
        i2.append("}");
        return i2.toString();
    }
}
