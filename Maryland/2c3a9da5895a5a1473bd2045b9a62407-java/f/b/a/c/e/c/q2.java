package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class q2 extends r2 {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2590d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2591e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ r2 f2592f;

    public q2(r2 r2Var, int i2, int i3) {
        this.f2592f = r2Var;
        this.f2590d = i2;
        this.f2591e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        b.c2(i2, this.f2591e, "index");
        return this.f2592f.get(i2 + this.f2590d);
    }

    @Override // f.b.a.c.e.c.o2
    public final Object[] i() {
        return this.f2592f.i();
    }

    @Override // f.b.a.c.e.c.o2
    public final int j() {
        return this.f2592f.j() + this.f2590d;
    }

    @Override // f.b.a.c.e.c.o2
    public final int k() {
        return this.f2592f.j() + this.f2590d + this.f2591e;
    }

    @Override // f.b.a.c.e.c.o2
    public final boolean m() {
        return true;
    }

    @Override // f.b.a.c.e.c.r2
    /* renamed from: o */
    public final r2 subList(int i2, int i3) {
        b.e2(i2, i3, this.f2591e);
        r2 r2Var = this.f2592f;
        int i4 = this.f2590d;
        return r2Var.subList(i2 + i4, i3 + i4);
    }

    public final int size() {
        return this.f2591e;
    }
}
