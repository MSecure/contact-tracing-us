package f.b.b.b;

import java.util.Objects;
/* loaded from: classes.dex */
public final class j<E> extends e<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient E f3413e;

    /* renamed from: f  reason: collision with root package name */
    public transient int f3414f;

    public j(E e2) {
        Objects.requireNonNull(e2);
        this.f3413e = e2;
    }

    public j(E e2, int i2) {
        this.f3413e = e2;
        this.f3414f = i2;
    }

    @Override // f.b.b.b.b, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f3413e.equals(obj);
    }

    @Override // f.b.b.b.e, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int i2 = this.f3414f;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.f3413e.hashCode();
        this.f3414f = hashCode;
        return hashCode;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        objArr[i2] = this.f3413e;
        return i2 + 1;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    @Override // f.b.b.b.b
    /* renamed from: n */
    public k<E> iterator() {
        return new f(this.f3413e);
    }

    @Override // f.b.b.b.e
    public c<E> r() {
        return c.v(this.f3413e);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return this.f3414f != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return '[' + this.f3413e.toString() + ']';
    }
}
