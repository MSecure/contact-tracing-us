package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class z2 extends a3 {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2752d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2753e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a3 f2754f;

    public z2(a3 a3Var, int i2, int i3) {
        this.f2754f = a3Var;
        this.f2752d = i2;
        this.f2753e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        b.y1(i2, this.f2753e, "index");
        return this.f2754f.get(i2 + this.f2752d);
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2754f.j() + this.f2752d + this.f2753e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int j() {
        return this.f2754f.j() + this.f2752d;
    }

    @Override // f.b.a.c.e.c.x2
    public final boolean m() {
        return true;
    }

    @Override // f.b.a.c.e.c.x2
    public final Object[] n() {
        return this.f2754f.n();
    }

    @Override // f.b.a.c.e.c.a3
    /* renamed from: o */
    public final a3 subList(int i2, int i3) {
        b.E1(i2, i3, this.f2753e);
        a3 a3Var = this.f2754f;
        int i4 = this.f2752d;
        return a3Var.subList(i2 + i4, i3 + i4);
    }

    public final int size() {
        return this.f2753e;
    }
}
