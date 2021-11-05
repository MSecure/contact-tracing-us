package c.b.a.a.c.k.o;

import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.d;
import java.util.Arrays;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2312a = true;

    /* renamed from: b  reason: collision with root package name */
    public final int f2313b;

    /* renamed from: c  reason: collision with root package name */
    public final a<O> f2314c;

    /* renamed from: d  reason: collision with root package name */
    public final O f2315d;

    public b(a<O> aVar) {
        this.f2314c = aVar;
        this.f2315d = null;
        this.f2313b = System.identityHashCode(this);
    }

    public b(a<O> aVar, O o) {
        this.f2314c = aVar;
        this.f2315d = o;
        this.f2313b = Arrays.hashCode(new Object[]{aVar, o});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return !this.f2312a && !bVar.f2312a && i.j.X(this.f2314c, bVar.f2314c) && i.j.X(this.f2315d, bVar.f2315d);
    }

    public final int hashCode() {
        return this.f2313b;
    }
}
