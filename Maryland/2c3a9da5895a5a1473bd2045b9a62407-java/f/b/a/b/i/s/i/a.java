package f.b.a.b.i.s.i;

public final class a extends d {
    public final long b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2473d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2474e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2475f;

    public a(long j2, int i2, int i3, long j3, int i4, C0082a aVar) {
        this.b = j2;
        this.c = i2;
        this.f2473d = i3;
        this.f2474e = j3;
        this.f2475f = i4;
    }

    @Override // f.b.a.b.i.s.i.d
    public int a() {
        return this.f2473d;
    }

    @Override // f.b.a.b.i.s.i.d
    public long b() {
        return this.f2474e;
    }

    @Override // f.b.a.b.i.s.i.d
    public int c() {
        return this.c;
    }

    @Override // f.b.a.b.i.s.i.d
    public int d() {
        return this.f2475f;
    }

    @Override // f.b.a.b.i.s.i.d
    public long e() {
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
        return this.b == dVar.e() && this.c == dVar.c() && this.f2473d == dVar.a() && this.f2474e == dVar.b() && this.f2475f == dVar.d();
    }

    public int hashCode() {
        long j2 = this.b;
        long j3 = this.f2474e;
        return this.f2475f ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.f2473d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("EventStoreConfig{maxStorageSizeInBytes=");
        h2.append(this.b);
        h2.append(", loadBatchSize=");
        h2.append(this.c);
        h2.append(", criticalSectionEnterTimeoutMs=");
        h2.append(this.f2473d);
        h2.append(", eventCleanUpAge=");
        h2.append(this.f2474e);
        h2.append(", maxBlobByteSizePerRow=");
        h2.append(this.f2475f);
        h2.append("}");
        return h2.toString();
    }
}
