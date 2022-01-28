package c.b.a.a.g.e;

public final class va<E> extends qa<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient E f3790d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f3791e;

    public va(E e2) {
        if (e2 != null) {
            this.f3790d = e2;
            return;
        }
        throw null;
    }

    public va(E e2, int i) {
        this.f3790d = e2;
        this.f3791e = i;
    }

    @Override // c.b.a.a.g.e.ma
    public final int a(Object[] objArr, int i) {
        objArr[0] = this.f3790d;
        return 1;
    }

    @Override // c.b.a.a.g.e.ma
    /* renamed from: c */
    public final xa<E> iterator() {
        return new sa(this.f3790d);
    }

    public final boolean contains(Object obj) {
        return this.f3790d.equals(obj);
    }

    @Override // c.b.a.a.g.e.qa
    public final int hashCode() {
        int i = this.f3791e;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f3790d.hashCode();
        this.f3791e = hashCode;
        return hashCode;
    }

    @Override // c.b.a.a.g.e.ma
    public final boolean l() {
        return false;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f3790d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // c.b.a.a.g.e.qa
    public final boolean u() {
        return this.f3791e != 0;
    }

    @Override // c.b.a.a.g.e.qa
    public final na<E> v() {
        return na.p(this.f3790d);
    }
}
