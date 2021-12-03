package f.b.a.d.a;

import f.b.a.d.a.i0.b;

public final class p extends y {
    public final f.b.a.d.a.i0.a a;
    public final b b;

    public p(f.b.a.d.a.i0.a aVar, b bVar, a aVar2) {
        this.a = aVar;
        this.b = bVar;
    }

    @Override // f.b.a.d.a.y
    public f.b.a.d.a.i0.a a() {
        return this.a;
    }

    @Override // f.b.a.d.a.y
    public b b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a.equals(yVar.a()) && this.b.equals(yVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("PrioPacketPayload{createPacketsParameters=");
        i2.append(this.a);
        i2.append(", createPacketsResponse=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
