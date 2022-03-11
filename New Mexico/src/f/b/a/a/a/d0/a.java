package f.b.a.a.a.d0;

import f.b.a.a.a.d0.d;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public final d.b f2206d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2207e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2208f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2209g;

    /* loaded from: classes.dex */
    public static final class b extends d.a {
        public d.b a;
        public Integer b;
        public Integer c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f2210d;

        @Override // f.b.a.a.a.d0.d.a
        public d.a b(int i2) {
            this.b = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.d0.d.a
        public d.a d(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // f.b.a.a.a.d0.d.a
        public d.a e(int i2) {
            this.f2210d = Integer.valueOf(i2);
            return this;
        }
    }

    public a(d.b bVar, int i2, int i3, int i4, C0072a aVar) {
        this.f2206d = bVar;
        this.f2207e = i2;
        this.f2208f = i3;
        this.f2209g = i4;
    }

    @Override // f.b.a.a.a.d0.d
    public int a() {
        return this.f2207e;
    }

    @Override // f.b.a.a.a.d0.d
    public d.b b() {
        return this.f2206d;
    }

    @Override // f.b.a.a.a.d0.d
    public int d() {
        return this.f2208f;
    }

    @Override // f.b.a.a.a.d0.d
    public int e() {
        return this.f2209g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2206d.equals(dVar.b()) && this.f2207e == dVar.a() && this.f2208f == dVar.d() && this.f2209g == dVar.e();
    }

    public int hashCode() {
        return ((((((this.f2206d.hashCode() ^ 1000003) * 1000003) ^ this.f2207e) * 1000003) ^ this.f2208f) * 1000003) ^ this.f2209g;
    }
}
