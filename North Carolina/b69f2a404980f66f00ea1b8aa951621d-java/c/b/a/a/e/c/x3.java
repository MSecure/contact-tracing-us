package c.b.a.a.e.c;

import b.b.k.i;
import b.e.c;
import c.b.a.a.c.k.o.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

public final class x3 extends a7 {

    /* renamed from: a  reason: collision with root package name */
    public final k<ConnectionLifecycleCallback> f2800a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f2801b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f2802c = new c();

    public x3(k<ConnectionLifecycleCallback> kVar) {
        i.j.s(kVar);
        this.f2800a = kVar;
    }

    @Override // c.b.a.a.e.c.x6
    public final synchronized void A(z7 z7Var) {
        this.f2801b.add(z7Var.f2822b);
        this.f2800a.a(new a4(z7Var));
    }

    @Override // c.b.a.a.e.c.x6
    public final synchronized void L(b8 b8Var) {
        this.f2801b.remove(b8Var.f2528b);
        Status c2 = v3.c(b8Var.f2529c);
        if (c2.p()) {
            this.f2802c.add(b8Var.f2528b);
        }
        this.f2800a.a(new z3(b8Var, c2));
    }

    @Override // c.b.a.a.e.c.x6
    public final synchronized void R(d8 d8Var) {
        this.f2802c.remove(d8Var.f2551b);
        this.f2800a.a(new c4(d8Var));
    }

    @Override // c.b.a.a.e.c.x6
    public final void w(x7 x7Var) {
        this.f2800a.a(new b4(x7Var));
    }
}
