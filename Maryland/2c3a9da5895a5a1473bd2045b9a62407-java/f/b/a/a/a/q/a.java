package f.b.a.a.a.q;

import f.b.a.a.a.q.d;

public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public final d.b f2239d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2240e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2241f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2242g;

    public static final class b extends d.a {
        public d.b a;
        public Integer b;
        public Integer c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f2243d;

        @Override // f.b.a.a.a.q.d.a
        public d.a b(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.q.d.a
        public d.a c(int i2) {
            this.f2243d = Integer.valueOf(i2);
            return this;
        }
    }

    public a(d.b bVar, int i2, int i3, int i4, C0074a aVar) {
        this.f2239d = bVar;
        this.f2240e = i2;
        this.f2241f = i3;
        this.f2242g = i4;
    }

    @Override // f.b.a.a.a.q.d
    public int a() {
        return this.f2240e;
    }

    @Override // f.b.a.a.a.q.d
    public d.b b() {
        return this.f2239d;
    }

    @Override // f.b.a.a.a.q.d
    public int d() {
        return this.f2241f;
    }

    @Override // f.b.a.a.a.q.d
    public int e() {
        return this.f2242g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2239d.equals(dVar.b()) && this.f2240e == dVar.a() && this.f2241f == dVar.d() && this.f2242g == dVar.e();
    }

    public int hashCode() {
        return ((((((this.f2239d.hashCode() ^ 1000003) * 1000003) ^ this.f2240e) * 1000003) ^ this.f2241f) * 1000003) ^ this.f2242g;
    }
}
