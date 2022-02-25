package f.b.a.a.a.t;

import java.util.Objects;

public final class a extends d {
    public final int a;
    public final String b;
    public final long c;

    public a(int i2, String str, long j2) {
        this.a = i2;
        Objects.requireNonNull(str, "Null classificationName");
        this.b = str;
        this.c = j2;
    }

    @Override // f.b.a.a.a.t.d
    public long a() {
        return this.c;
    }

    @Override // f.b.a.a.a.t.d
    public int b() {
        return this.a;
    }

    @Override // f.b.a.a.a.t.d
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.b() && this.b.equals(dVar.c()) && this.c == dVar.a();
    }

    public int hashCode() {
        long j2 = this.c;
        return ((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ExposureClassification{classificationIndex=");
        h2.append(this.a);
        h2.append(", classificationName=");
        h2.append(this.b);
        h2.append(", classificationDate=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
