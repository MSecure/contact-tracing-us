package c.b.a.a.e.c;

public final class va<E> extends qa<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient E f2785d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f2786e;

    public va(E e2) {
        if (e2 != null) {
            this.f2785d = e2;
            return;
        }
        throw null;
    }

    public va(E e2, int i) {
        this.f2785d = e2;
        this.f2786e = i;
    }

    @Override // c.b.a.a.e.c.ma
    public final int a(Object[] objArr, int i) {
        objArr[0] = this.f2785d;
        return 1;
    }

    @Override // c.b.a.a.e.c.ma
    /* renamed from: c */
    public final xa<E> iterator() {
        return new sa(this.f2785d);
    }

    public final boolean contains(Object obj) {
        return this.f2785d.equals(obj);
    }

    @Override // c.b.a.a.e.c.qa
    public final int hashCode() {
        int i = this.f2786e;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f2785d.hashCode();
        this.f2786e = hashCode;
        return hashCode;
    }

    @Override // c.b.a.a.e.c.ma
    public final boolean o() {
        return false;
    }

    @Override // c.b.a.a.e.c.qa
    public final boolean s() {
        return this.f2786e != 0;
    }

    public final int size() {
        return 1;
    }

    @Override // c.b.a.a.e.c.qa
    public final na<E> t() {
        return na.q(this.f2785d);
    }

    public final String toString() {
        String obj = this.f2785d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
