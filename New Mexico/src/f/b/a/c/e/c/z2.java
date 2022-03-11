package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public final class z2 extends a3 {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2793d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2794e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a3 f2795f;

    public z2(a3 a3Var, int i2, int i3) {
        this.f2795f = a3Var;
        this.f2793d = i2;
        this.f2794e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        b.z1(i2, this.f2794e, "index");
        return this.f2795f.get(i2 + this.f2793d);
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2795f.j() + this.f2793d + this.f2794e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int j() {
        return this.f2795f.j() + this.f2793d;
    }

    @Override // f.b.a.c.e.c.x2
    public final boolean m() {
        return true;
    }

    @Override // f.b.a.c.e.c.x2
    public final Object[] n() {
        return this.f2795f.n();
    }

    @Override // f.b.a.c.e.c.a3
    /* renamed from: o */
    public final a3 subList(int i2, int i3) {
        b.U1(i2, i3, this.f2794e);
        a3 a3Var = this.f2795f;
        int i4 = this.f2793d;
        return a3Var.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2794e;
    }
}
