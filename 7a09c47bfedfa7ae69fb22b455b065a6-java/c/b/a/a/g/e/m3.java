package c.b.a.a.g.e;

import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.d;
import java.util.Arrays;

public final class m3 {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f3653a;

    /* renamed from: b  reason: collision with root package name */
    public final a.d f3654b = null;

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/d/k/d<*>;Lc/b/a/a/d/k/a$d;)V */
    public m3(d dVar) {
        this.f3653a = dVar.getClass();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m3) {
            m3 m3Var = (m3) obj;
            return t.j1(this.f3653a, m3Var.f3653a) && t.j1(this.f3654b, m3Var.f3654b);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3653a, this.f3654b});
    }
}
