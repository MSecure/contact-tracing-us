package f.b.b.b;

import java.util.Objects;

public final class j<E> extends e<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient E f3095e;

    /* renamed from: f  reason: collision with root package name */
    public transient int f3096f;

    public j(E e2) {
        Objects.requireNonNull(e2);
        this.f3095e = e2;
    }

    public j(E e2, int i2) {
        this.f3095e = e2;
        this.f3096f = i2;
    }

    @Override // f.b.b.b.b
    public boolean contains(Object obj) {
        return this.f3095e.equals(obj);
    }

    @Override // f.b.b.b.e
    public final int hashCode() {
        int i2 = this.f3096f;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.f3095e.hashCode();
        this.f3096f = hashCode;
        return hashCode;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        objArr[i2] = this.f3095e;
        return i2 + 1;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    @Override // f.b.b.b.b
    /* renamed from: n */
    public k<E> iterator() {
        return new f(this.f3095e);
    }

    @Override // f.b.b.b.e
    public c<E> r() {
        return c.v(this.f3095e);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return this.f3096f != 0;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.f3095e.toString() + ']';
    }
}
