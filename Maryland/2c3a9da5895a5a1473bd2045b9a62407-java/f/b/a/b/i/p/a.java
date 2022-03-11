package f.b.a.b.i.p;

import f.b.a.b.i.f;
import java.util.Arrays;

public final class a extends f {
    public final Iterable<f> a;
    public final byte[] b;

    public a(Iterable iterable, byte[] bArr, C0080a aVar) {
        this.a = iterable;
        this.b = bArr;
    }

    @Override // f.b.a.b.i.p.f
    public Iterable<f> a() {
        return this.a;
    }

    @Override // f.b.a.b.i.p.f
    public byte[] b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a.equals(fVar.a())) {
            if (Arrays.equals(this.b, fVar instanceof a ? ((a) fVar).b : fVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("BackendRequest{events=");
        h2.append(this.a);
        h2.append(", extras=");
        h2.append(Arrays.toString(this.b));
        h2.append("}");
        return h2.toString();
    }
}
