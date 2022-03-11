package f.b.f;

import java.nio.charset.Charset;
import java.util.Objects;

public final class n implements a2 {
    public final m a;

    public n(m mVar) {
        Charset charset = c0.a;
        this.a = mVar;
        mVar.a = this;
    }

    public void a(int i2, double d2) {
        m mVar = this.a;
        Objects.requireNonNull(mVar);
        mVar.O(i2, Double.doubleToRawLongBits(d2));
    }

    public void b(int i2, float f2) {
        m mVar = this.a;
        Objects.requireNonNull(mVar);
        mVar.M(i2, Float.floatToRawIntBits(f2));
    }

    public void c(int i2, Object obj, j1 j1Var) {
        m mVar = this.a;
        mVar.Y(i2, 3);
        j1Var.h((t0) obj, mVar.a);
        mVar.Y(i2, 4);
    }

    public void d(int i2, Object obj, j1 j1Var) {
        this.a.S(i2, (t0) obj, j1Var);
    }

    public final void e(int i2, Object obj) {
        if (obj instanceof j) {
            this.a.V(i2, (j) obj);
        } else {
            this.a.U(i2, (t0) obj);
        }
    }

    public void f(int i2, int i3) {
        this.a.Z(i2, m.D(i3));
    }

    public void g(int i2, long j2) {
        this.a.b0(i2, m.E(j2));
    }
}
