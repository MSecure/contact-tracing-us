package f.b.a.c.i;

import e.b.a.m;
import java.util.Objects;

public class i<TResult> {
    public final c0<TResult> a = new c0<>();

    public boolean a(Exception exc) {
        c0<TResult> c0Var = this.a;
        Objects.requireNonNull(c0Var);
        m.h.p(exc, "Exception must not be null");
        synchronized (c0Var.a) {
            if (c0Var.c) {
                return false;
            }
            c0Var.c = true;
            c0Var.f2742f = exc;
            c0Var.b.a(c0Var);
            return true;
        }
    }

    public boolean b(TResult tresult) {
        c0<TResult> c0Var = this.a;
        synchronized (c0Var.a) {
            if (c0Var.c) {
                return false;
            }
            c0Var.c = true;
            c0Var.f2741e = tresult;
            c0Var.b.a(c0Var);
            return true;
        }
    }
}
