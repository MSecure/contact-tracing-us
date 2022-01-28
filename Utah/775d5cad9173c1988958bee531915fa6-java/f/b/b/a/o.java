package f.b.b.a;

import f.a.a.a.a;

public final class o<T> extends l<T> {
    public final T b;

    public o(T t) {
        this.b = t;
    }

    @Override // f.b.b.a.l
    public T a() {
        return this.b;
    }

    @Override // f.b.b.a.l
    public boolean b() {
        return true;
    }

    @Override // f.b.b.a.l
    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.b.equals(((o) obj).b);
        }
        return false;
    }

    @Override // f.b.b.a.l
    public int hashCode() {
        return this.b.hashCode() + 1502476572;
    }

    public String toString() {
        StringBuilder h2 = a.h("Optional.of(");
        h2.append((Object) this.b);
        h2.append(")");
        return h2.toString();
    }
}
