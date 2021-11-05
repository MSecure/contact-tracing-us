package c.b.a.a.e.c;

import c.b.a.a.g.e;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final /* synthetic */ class d5 implements e {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f2547a;

    /* renamed from: b  reason: collision with root package name */
    public final DiscoveryOptions f2548b;

    public d5(u4 u4Var, DiscoveryOptions discoveryOptions) {
        this.f2547a = u4Var;
        this.f2548b = discoveryOptions;
    }

    @Override // c.b.a.a.g.e
    public final void onSuccess(Object obj) {
        s7 s7Var;
        u4 u4Var = this.f2547a;
        DiscoveryOptions discoveryOptions = this.f2548b;
        Void r3 = (Void) obj;
        if (u4Var == null) {
            throw null;
        } else if (discoveryOptions.zza() && (s7Var = u4Var.f2751b) != null) {
            s7Var.f2724e = true;
            s7Var.b();
        }
    }
}
