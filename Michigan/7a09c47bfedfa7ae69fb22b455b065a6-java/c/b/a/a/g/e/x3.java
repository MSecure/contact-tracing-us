package c.b.a.a.g.e;

import b.e.c;
import b.x.t;
import c.b.a.a.d.k.o.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

public final class x3 extends a7 {

    /* renamed from: a  reason: collision with root package name */
    public final k<ConnectionLifecycleCallback> f3807a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f3808b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f3809c = new c();

    public x3(k<ConnectionLifecycleCallback> kVar) {
        t.C(kVar);
        this.f3807a = kVar;
    }

    @Override // c.b.a.a.g.e.x6
    public final synchronized void I(b8 b8Var) {
        this.f3808b.remove(b8Var.f3513b);
        Status c2 = v3.c(b8Var.f3514c);
        if (c2.t()) {
            this.f3809c.add(b8Var.f3513b);
        }
        this.f3807a.a(new z3(b8Var, c2));
    }

    @Override // c.b.a.a.g.e.x6
    public final synchronized void O(d8 d8Var) {
        this.f3809c.remove(d8Var.f3536b);
        this.f3807a.a(new c4(d8Var));
    }

    @Override // c.b.a.a.g.e.x6
    public final void t(x7 x7Var) {
        this.f3807a.a(new b4(x7Var));
    }

    @Override // c.b.a.a.g.e.x6
    public final synchronized void x(z7 z7Var) {
        this.f3808b.add(z7Var.f3829b);
        this.f3807a.a(new a4(z7Var));
    }
}
