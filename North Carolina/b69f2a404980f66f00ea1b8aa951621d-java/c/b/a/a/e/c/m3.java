package c.b.a.a.e.c;

import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import java.util.Arrays;

public final class m3 {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f2661a;

    /* renamed from: b  reason: collision with root package name */
    public final a.d f2662b = null;

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/c/k/d<*>;Lc/b/a/a/c/k/a$d;)V */
    public m3(d dVar) {
        this.f2661a = dVar.getClass();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m3) {
            m3 m3Var = (m3) obj;
            return i.j.X(this.f2661a, m3Var.f2661a) && i.j.X(this.f2662b, m3Var.f2662b);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2661a, this.f2662b});
    }
}
