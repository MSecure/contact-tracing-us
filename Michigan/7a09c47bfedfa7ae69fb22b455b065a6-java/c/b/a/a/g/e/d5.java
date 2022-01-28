package c.b.a.a.g.e;

import c.b.a.a.j.f;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final /* synthetic */ class d5 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final u4 f3532a;

    /* renamed from: b  reason: collision with root package name */
    public final DiscoveryOptions f3533b;

    public d5(u4 u4Var, DiscoveryOptions discoveryOptions) {
        this.f3532a = u4Var;
        this.f3533b = discoveryOptions;
    }

    @Override // c.b.a.a.j.f
    public final void onSuccess(Object obj) {
        s7 s7Var;
        u4 u4Var = this.f3532a;
        DiscoveryOptions discoveryOptions = this.f3533b;
        Void r3 = (Void) obj;
        if (u4Var == null) {
            throw null;
        } else if (discoveryOptions.zza() && (s7Var = u4Var.f3750b) != null) {
            s7Var.f3719e = true;
            s7Var.b();
        }
    }
}
