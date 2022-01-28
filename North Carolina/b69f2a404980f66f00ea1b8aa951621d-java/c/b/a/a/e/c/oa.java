package c.b.a.a.e.c;

import c.b.a.a.c.n.c;

public final class oa extends na<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2683d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2684e;
    public final /* synthetic */ na f;

    public oa(na naVar, int i, int i2) {
        this.f = naVar;
        this.f2683d = i;
        this.f2684e = i2;
    }

    @Override // c.b.a.a.e.c.ma
    public final Object[] e() {
        return this.f.e();
    }

    @Override // java.util.List
    public final E get(int i) {
        c.F2(i, this.f2684e);
        return (E) this.f.get(i + this.f2683d);
    }

    @Override // c.b.a.a.e.c.ma
    public final int h() {
        return this.f.h() + this.f2683d;
    }

    @Override // c.b.a.a.e.c.ma
    public final int j() {
        return this.f.h() + this.f2683d + this.f2684e;
    }

    @Override // c.b.a.a.e.c.ma
    public final boolean o() {
        return true;
    }

    @Override // c.b.a.a.e.c.na
    /* renamed from: p */
    public final na<E> subList(int i, int i2) {
        c.L2(i, i2, this.f2684e);
        na naVar = this.f;
        int i3 = this.f2683d;
        return (na) naVar.subList(i + i3, i2 + i3);
    }

    public final int size() {
        return this.f2684e;
    }
}
