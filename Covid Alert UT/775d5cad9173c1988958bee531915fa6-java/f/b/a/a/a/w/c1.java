package f.b.a.a.a.w;

import e.q.f0;
import g.b.a.c.b.c;
import g.b.a.c.c.a;
import g.b.b.b;
import java.util.Objects;

public abstract class c1 extends y0 implements b {
    public volatile a t;
    public final Object u = new Object();
    public boolean v = false;

    public c1() {
        n(new b1(this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.t == null) {
            synchronized (this.u) {
                if (this.t == null) {
                    this.t = new a(this);
                }
            }
        }
        return this.t.e();
    }

    @Override // androidx.activity.ComponentActivity, e.q.g
    public f0.b l() {
        f0.b l2 = super.l();
        c a = ((g.b.a.c.b.a) f.b.a.c.b.o.b.t0(this, g.b.a.c.b.a.class)).a();
        Objects.requireNonNull(a);
        return a.a(this, getIntent() != null ? getIntent().getExtras() : null, l2);
    }
}
