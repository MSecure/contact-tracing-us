package c.b.a.a.g.e;

import b.x.t;

public final class oa extends na<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f3675d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f3676e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ na f3677f;

    public oa(na naVar, int i, int i2) {
        this.f3677f = naVar;
        this.f3675d = i;
        this.f3676e = i2;
    }

    @Override // c.b.a.a.g.e.ma
    public final Object[] e() {
        return this.f3677f.e();
    }

    @Override // c.b.a.a.g.e.ma
    public final int g() {
        return this.f3677f.g() + this.f3675d;
    }

    @Override // java.util.List
    public final E get(int i) {
        t.E3(i, this.f3676e);
        return (E) this.f3677f.get(i + this.f3675d);
    }

    @Override // c.b.a.a.g.e.ma
    public final int h() {
        return this.f3677f.g() + this.f3675d + this.f3676e;
    }

    @Override // c.b.a.a.g.e.ma
    public final boolean l() {
        return true;
    }

    @Override // c.b.a.a.g.e.na
    /* renamed from: o */
    public final na<E> subList(int i, int i2) {
        t.e4(i, i2, this.f3676e);
        na naVar = this.f3677f;
        int i3 = this.f3675d;
        return (na) naVar.subList(i + i3, i2 + i3);
    }

    public final int size() {
        return this.f3676e;
    }
}
