package c.b.a.a.g.e;

import b.e.c;
import b.x.t;
import c.b.a.a.d.k.o.k;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Set;

public final class g4 extends h7 {

    /* renamed from: a  reason: collision with root package name */
    public final k<EndpointDiscoveryCallback> f3576a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f3577b = new c();

    public g4(k<EndpointDiscoveryCallback> kVar) {
        t.C(kVar);
        this.f3576a = kVar;
    }

    public static boolean e0(h8 h8Var) {
        if (h8Var.f3592e == null) {
            return false;
        }
        String str = h8Var.f3589b;
        return str == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(str);
    }

    @Override // c.b.a.a.g.e.e7
    public final synchronized void T(f8 f8Var) {
        this.f3576a.a(new f4(f8Var));
    }

    @Override // c.b.a.a.g.e.e7
    public final synchronized void Y(h8 h8Var) {
        if (!e0(h8Var)) {
            this.f3577b.add(h8Var.f3589b);
        }
        this.f3576a.a(new i4(h8Var));
    }

    @Override // c.b.a.a.g.e.e7
    public final void a0(s8 s8Var) {
    }

    @Override // c.b.a.a.g.e.e7
    public final synchronized void d0(j8 j8Var) {
        this.f3577b.remove(j8Var.f3617b);
        this.f3576a.a(new h4(j8Var));
    }
}
