package h.a.j1;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import h.a.c;
import h.a.h0;
import h.a.n0;
import h.a.o0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class h2 extends h0.f {
    public final c a;
    public final n0 b;
    public final o0<?, ?> c;

    public h2(o0<?, ?> o0Var, n0 n0Var, c cVar) {
        b.A(o0Var, "method");
        this.c = o0Var;
        b.A(n0Var, "headers");
        this.b = n0Var;
        b.A(cVar, "callOptions");
        this.a = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h2.class != obj.getClass()) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return b.n0(this.a, h2Var.a) && b.n0(this.b, h2Var.b) && b.n0(this.c, h2Var.c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        StringBuilder h2 = a.h("[method=");
        h2.append(this.c);
        h2.append(" headers=");
        h2.append(this.b);
        h2.append(" callOptions=");
        h2.append(this.a);
        h2.append("]");
        return h2.toString();
    }
}
