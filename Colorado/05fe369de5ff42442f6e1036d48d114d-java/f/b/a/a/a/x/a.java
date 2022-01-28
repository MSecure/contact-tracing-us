package f.b.a.a.a.x;

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

    @Override // f.b.a.a.a.x.d
    public long a() {
        return this.c;
    }

    @Override // f.b.a.a.a.x.d
    public int b() {
        return this.a;
    }

    @Override // f.b.a.a.a.x.d
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
        StringBuilder i2 = f.a.a.a.a.i("ExposureClassification{classificationIndex=");
        i2.append(this.a);
        i2.append(", classificationName=");
        i2.append(this.b);
        i2.append(", classificationDate=");
        i2.append(this.c);
        i2.append("}");
        return i2.toString();
    }
}
