package f.b.a.b.i.s.i;

public final class a extends d {
    public final long b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2562d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2563e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2564f;

    public a(long j2, int i2, int i3, long j3, int i4, C0081a aVar) {
        this.b = j2;
        this.c = i2;
        this.f2562d = i3;
        this.f2563e = j3;
        this.f2564f = i4;
    }

    @Override // f.b.a.b.i.s.i.d
    public int a() {
        return this.f2562d;
    }

    @Override // f.b.a.b.i.s.i.d
    public long b() {
        return this.f2563e;
    }

    @Override // f.b.a.b.i.s.i.d
    public int c() {
        return this.c;
    }

    @Override // f.b.a.b.i.s.i.d
    public int d() {
        return this.f2564f;
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
        return this.b == dVar.e() && this.c == dVar.c() && this.f2562d == dVar.a() && this.f2563e == dVar.b() && this.f2564f == dVar.d();
    }

    public int hashCode() {
        long j2 = this.b;
        long j3 = this.f2563e;
        return this.f2564f ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.f2562d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("EventStoreConfig{maxStorageSizeInBytes=");
        i2.append(this.b);
        i2.append(", loadBatchSize=");
        i2.append(this.c);
        i2.append(", criticalSectionEnterTimeoutMs=");
        i2.append(this.f2562d);
        i2.append(", eventCleanUpAge=");
        i2.append(this.f2563e);
        i2.append(", maxBlobByteSizePerRow=");
        i2.append(this.f2564f);
        i2.append("}");
        return i2.toString();
    }
}
