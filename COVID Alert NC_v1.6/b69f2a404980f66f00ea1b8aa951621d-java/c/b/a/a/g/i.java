package c.b.a.a.g;

import b.b.k.i;

public class i<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final a0<TResult> f2856a = new a0<>();

    public boolean a(Exception exc) {
        a0<TResult> a0Var = this.f2856a;
        if (a0Var != null) {
            i.j.t(exc, "Exception must not be null");
            synchronized (a0Var.f2849a) {
                if (a0Var.f2851c) {
                    return false;
                }
                a0Var.f2851c = true;
                a0Var.f = exc;
                a0Var.f2850b.a(a0Var);
                return true;
            }
        }
        throw null;
    }
}
