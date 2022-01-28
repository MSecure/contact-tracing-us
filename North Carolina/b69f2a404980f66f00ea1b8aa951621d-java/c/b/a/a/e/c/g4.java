package c.b.a.a.e.c;

import b.b.k.i;
import b.e.c;
import c.b.a.a.c.k.o.k;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Set;

public final class g4 extends h7 {

    /* renamed from: a  reason: collision with root package name */
    public final k<EndpointDiscoveryCallback> f2591a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f2592b = new c();

    public g4(k<EndpointDiscoveryCallback> kVar) {
        i.j.s(kVar);
        this.f2591a = kVar;
    }

    public static boolean c(h8 h8Var) {
        if (h8Var.f2607e == null) {
            return false;
        }
        String str = h8Var.f2604b;
        return str == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(str);
    }

    @Override // c.b.a.a.e.c.e7
    public final synchronized void W(f8 f8Var) {
        this.f2591a.a(new f4(f8Var));
    }

    @Override // c.b.a.a.e.c.e7
    public final synchronized void b0(h8 h8Var) {
        if (!c(h8Var)) {
            this.f2592b.add(h8Var.f2604b);
        }
        this.f2591a.a(new i4(h8Var));
    }

    @Override // c.b.a.a.e.c.e7
    public final void d0(s8 s8Var) {
    }

    @Override // c.b.a.a.e.c.e7
    public final synchronized void f0(j8 j8Var) {
        this.f2592b.remove(j8Var.f2629b);
        this.f2591a.a(new h4(j8Var));
    }
}
