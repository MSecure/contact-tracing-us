package f.b.a.b.i.s.i;

public final class a extends d {
    public final long b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2393d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2394e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2395f;

    public a(long j2, int i2, int i3, long j3, int i4, C0079a aVar) {
        this.b = j2;
        this.c = i2;
        this.f2393d = i3;
        this.f2394e = j3;
        this.f2395f = i4;
    }

    @Override // f.b.a.b.i.s.i.d
    public int a() {
        return this.f2393d;
    }

    @Override // f.b.a.b.i.s.i.d
    public long b() {
        return this.f2394e;
    }

    @Override // f.b.a.b.i.s.i.d
    public int c() {
        return this.c;
    }

    @Override // f.b.a.b.i.s.i.d
    public int d() {
        return this.f2395f;
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
        return this.b == dVar.e() && this.c == dVar.c() && this.f2393d == dVar.a() && this.f2394e == dVar.b() && this.f2395f == dVar.d();
    }

    public int hashCode() {
        long j2 = this.b;
        long j3 = this.f2394e;
        return this.f2395f ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.f2393d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("EventStoreConfig{maxStorageSizeInBytes=");
        h2.append(this.b);
        h2.append(", loadBatchSize=");
        h2.append(this.c);
        h2.append(", criticalSectionEnterTimeoutMs=");
        h2.append(this.f2393d);
        h2.append(", eventCleanUpAge=");
        h2.append(this.f2394e);
        h2.append(", maxBlobByteSizePerRow=");
        h2.append(this.f2395f);
        h2.append("}");
        return h2.toString();
    }
}
