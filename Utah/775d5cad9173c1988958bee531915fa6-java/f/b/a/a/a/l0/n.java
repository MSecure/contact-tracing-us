package f.b.a.a.a.l0;

public final class n extends u0 {
    public final long a;
    public final double b;

    public n(long j2, double d2, a aVar) {
        this.a = j2;
        this.b = d2;
    }

    @Override // f.b.a.a.a.l0.u0
    public long b() {
        return this.a;
    }

    @Override // f.b.a.a.a.l0.u0
    public double c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.a == u0Var.b() && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(u0Var.c());
    }

    public int hashCode() {
        long j2 = this.a;
        return ((int) ((Double.doubleToLongBits(this.b) >>> 32) ^ Double.doubleToLongBits(this.b))) ^ ((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ExposureEntity{dateDaysSinceEpoch=");
        h2.append(this.a);
        h2.append(", exposureScore=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
