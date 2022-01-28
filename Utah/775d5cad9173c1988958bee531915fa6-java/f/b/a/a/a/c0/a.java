package f.b.a.a.a.c0;

import f.b.a.a.a.c0.d;

public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public final d.b f2169d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2170e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2171f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2172g;

    public static final class b extends d.a {
        public d.b a;
        public Integer b;
        public Integer c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f2173d;

        @Override // f.b.a.a.a.c0.d.a
        public d.a b(int i2) {
            this.b = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.c0.d.a
        public d.a d(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.c0.d.a
        public d.a e(int i2) {
            this.f2173d = Integer.valueOf(i2);
            return this;
        }
    }

    public a(d.b bVar, int i2, int i3, int i4, C0070a aVar) {
        this.f2169d = bVar;
        this.f2170e = i2;
        this.f2171f = i3;
        this.f2172g = i4;
    }

    @Override // f.b.a.a.a.c0.d
    public int a() {
        return this.f2170e;
    }

    @Override // f.b.a.a.a.c0.d
    public d.b b() {
        return this.f2169d;
    }

    @Override // f.b.a.a.a.c0.d
    public int d() {
        return this.f2171f;
    }

    @Override // f.b.a.a.a.c0.d
    public int e() {
        return this.f2172g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2169d.equals(dVar.b()) && this.f2170e == dVar.a() && this.f2171f == dVar.d() && this.f2172g == dVar.e();
    }

    public int hashCode() {
        return ((((((this.f2169d.hashCode() ^ 1000003) * 1000003) ^ this.f2170e) * 1000003) ^ this.f2171f) * 1000003) ^ this.f2172g;
    }
}
