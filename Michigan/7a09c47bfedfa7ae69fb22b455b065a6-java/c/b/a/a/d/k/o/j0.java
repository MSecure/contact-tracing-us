package c.b.a.a.d.k.o;

import android.util.Log;
import b.x.t;
import c.b.a.a.d.a;
import c.b.a.a.d.k.o.g;
import c.b.a.a.d.m.h;
import c.b.a.a.d.m.x;
import c.b.a.a.i.b.n;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f3012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i0 f3013c;

    public j0(i0 i0Var, n nVar) {
        this.f3013c = i0Var;
        this.f3012b = nVar;
    }

    public final void run() {
        i0 i0Var = this.f3013c;
        n nVar = this.f3012b;
        if (i0Var != null) {
            a aVar = nVar.f4095c;
            if (aVar.x()) {
                x xVar = nVar.f4096d;
                t.C(xVar);
                aVar = xVar.f3166d;
                if (!aVar.x()) {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                } else {
                    l0 l0Var = i0Var.f3008g;
                    h t = xVar.t();
                    Set<Scope> set = i0Var.f3005d;
                    g.c cVar = (g.c) l0Var;
                    if (cVar == null) {
                        throw null;
                    } else if (t == null || set == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        cVar.b(new a(4));
                        i0Var.f3007f.disconnect();
                        return;
                    } else {
                        cVar.f2994c = t;
                        cVar.f2995d = set;
                        if (cVar.f2996e) {
                            cVar.f2992a.getRemoteService(t, set);
                        }
                        i0Var.f3007f.disconnect();
                        return;
                    }
                }
            }
            ((g.c) i0Var.f3008g).b(aVar);
            i0Var.f3007f.disconnect();
            return;
        }
        throw null;
    }
}
