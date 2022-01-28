package f.b.a.b;

import java.util.Objects;

public final class a<T> extends c<T> {
    public final T a;
    public final d b;

    public a(Integer num, T t, d dVar) {
        Objects.requireNonNull(t, "Null payload");
        this.a = t;
        this.b = dVar;
    }

    @Override // f.b.a.b.c
    public Integer a() {
        return null;
    }

    @Override // f.b.a.b.c
    public T b() {
        return this.a;
    }

    @Override // f.b.a.b.c
    public d c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.a() == null && this.a.equals(cVar.b()) && this.b.equals(cVar.c());
    }

    public int hashCode() {
        return this.b.hashCode() ^ ((-721379959 ^ this.a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + ((Object) this.a) + ", priority=" + this.b + "}";
    }
}
