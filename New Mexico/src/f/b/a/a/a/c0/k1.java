package f.b.a.a.a.c0;

import f.b.a.a.a.c0.l1;
/* loaded from: classes.dex */
public final class k1 extends l1.a {
    public final double a;
    public final double b;
    public final double c;

    /* loaded from: classes.dex */
    public static final class b extends l1.a.AbstractC0071a {
        public Double a;
        public Double b;
        public Double c;

        @Override // f.b.a.a.a.c0.l1.a.AbstractC0071a
        public l1.a a() {
            String str = this.a == null ? " maximumScore" : "";
            if (this.b == null) {
                str = f.a.a.a.a.x(str, " scoreSum");
            }
            if (this.c == null) {
                str = f.a.a.a.a.x(str, " weightedDurationSum");
            }
            if (str.isEmpty()) {
                return new k1(this.a.doubleValue(), this.b.doubleValue(), this.c.doubleValue(), null);
            }
            throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
        }

        @Override // f.b.a.a.a.c0.l1.a.AbstractC0071a
        public l1.a.AbstractC0071a b(double d2) {
            this.a = Double.valueOf(d2);
            return this;
        }

        @Override // f.b.a.a.a.c0.l1.a.AbstractC0071a
        public l1.a.AbstractC0071a c(double d2) {
            this.b = Double.valueOf(d2);
            return this;
        }

        @Override // f.b.a.a.a.c0.l1.a.AbstractC0071a
        public l1.a.AbstractC0071a d(double d2) {
            this.c = Double.valueOf(d2);
            return this;
        }
    }

    public k1(double d2, double d3, double d4, a aVar) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    @Override // f.b.a.a.a.c0.l1.a
    public double a() {
        return this.a;
    }

    @Override // f.b.a.a.a.c0.l1.a
    public double b() {
        return this.b;
    }

    @Override // f.b.a.a.a.c0.l1.a
    public double c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1.a)) {
            return false;
        }
        l1.a aVar = (l1.a) obj;
        return Double.doubleToLongBits(this.a) == Double.doubleToLongBits(aVar.a()) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(aVar.b()) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(aVar.c());
    }

    public int hashCode() {
        return ((int) ((Double.doubleToLongBits(this.c) >>> 32) ^ Double.doubleToLongBits(this.c))) ^ ((((((int) ((Double.doubleToLongBits(this.a) >>> 32) ^ Double.doubleToLongBits(this.a))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.b) >>> 32) ^ Double.doubleToLongBits(this.b)))) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ExposureSummaryDataWrapper{maximumScore=");
        h2.append(this.a);
        h2.append(", scoreSum=");
        h2.append(this.b);
        h2.append(", weightedDurationSum=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
