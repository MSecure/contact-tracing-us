package c.b.a.a.j;

import b.x.t;

public class j<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final b0<TResult> f4109a = new b0<>();

    public boolean a(Exception exc) {
        b0<TResult> b0Var = this.f4109a;
        if (b0Var != null) {
            t.D(exc, "Exception must not be null");
            synchronized (b0Var.f4101a) {
                if (b0Var.f4103c) {
                    return false;
                }
                b0Var.f4103c = true;
                b0Var.f4106f = exc;
                b0Var.f4102b.a(b0Var);
                return true;
            }
        }
        throw null;
    }
}
