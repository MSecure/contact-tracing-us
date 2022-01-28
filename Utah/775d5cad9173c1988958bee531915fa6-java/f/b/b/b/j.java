package f.b.b.b;

import java.util.Objects;

public final class j<E> extends e<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient E f3158e;

    /* renamed from: f  reason: collision with root package name */
    public transient int f3159f;

    public j(E e2) {
        Objects.requireNonNull(e2);
        this.f3158e = e2;
    }

    public j(E e2, int i2) {
        this.f3158e = e2;
        this.f3159f = i2;
    }

    @Override // f.b.b.b.b
    public boolean contains(Object obj) {
        return this.f3158e.equals(obj);
    }

    @Override // f.b.b.b.e
    public final int hashCode() {
        int i2 = this.f3159f;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.f3158e.hashCode();
        this.f3159f = hashCode;
        return hashCode;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        objArr[i2] = this.f3158e;
        return i2 + 1;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    @Override // f.b.b.b.b
    /* renamed from: n */
    public k<E> iterator() {
        return new f(this.f3158e);
    }

    @Override // f.b.b.b.e
    public c<E> r() {
        return c.v(this.f3158e);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return this.f3159f != 0;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.f3158e.toString() + ']';
    }
}
