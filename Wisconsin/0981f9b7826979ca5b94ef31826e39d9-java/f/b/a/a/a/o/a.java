package f.b.a.a.a.o;

import f.b.a.a.a.o.d;

public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public final d.b f2156d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2157e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2158f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2159g;

    public static final class b extends d.a {
        public d.b a;
        public Integer b;
        public Integer c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f2160d;

        @Override // f.b.a.a.a.o.d.a
        public d.a b(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.o.d.a
        public d.a c(int i2) {
            this.f2160d = Integer.valueOf(i2);
            return this;
        }
    }

    public a(d.b bVar, int i2, int i3, int i4, C0071a aVar) {
        this.f2156d = bVar;
        this.f2157e = i2;
        this.f2158f = i3;
        this.f2159g = i4;
    }

    @Override // f.b.a.a.a.o.d
    public int a() {
        return this.f2157e;
    }

    @Override // f.b.a.a.a.o.d
    public d.b b() {
        return this.f2156d;
    }

    @Override // f.b.a.a.a.o.d
    public int d() {
        return this.f2158f;
    }

    @Override // f.b.a.a.a.o.d
    public int e() {
        return this.f2159g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2156d.equals(dVar.b()) && this.f2157e == dVar.a() && this.f2158f == dVar.d() && this.f2159g == dVar.e();
    }

    public int hashCode() {
        return ((((((this.f2156d.hashCode() ^ 1000003) * 1000003) ^ this.f2157e) * 1000003) ^ this.f2158f) * 1000003) ^ this.f2159g;
    }
}
