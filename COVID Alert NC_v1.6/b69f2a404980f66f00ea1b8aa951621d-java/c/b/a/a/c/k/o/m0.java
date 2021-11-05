package c.b.a.a.c.k.o;

import android.util.Log;
import c.b.a.a.c.a;
import c.b.a.a.c.k.o.g;
import c.b.a.a.c.l.j;
import c.b.a.a.c.l.q;
import c.b.a.a.f.b.n;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f2386b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l0 f2387c;

    public m0(l0 l0Var, n nVar) {
        this.f2387c = l0Var;
        this.f2386b = nVar;
    }

    public final void run() {
        l0 l0Var = this.f2387c;
        n nVar = this.f2386b;
        if (l0Var != null) {
            a aVar = nVar.f2843c;
            if (aVar.q()) {
                q qVar = nVar.f2844d;
                aVar = qVar.f2480d;
                if (!aVar.q()) {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                } else {
                    o0 o0Var = l0Var.g;
                    j p = qVar.p();
                    Set<Scope> set = l0Var.f2384d;
                    g.c cVar = (g.c) o0Var;
                    if (cVar == null) {
                        throw null;
                    } else if (p == null || set == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        cVar.b(new a(4));
                        l0Var.f.disconnect();
                        return;
                    } else {
                        cVar.f2350c = p;
                        cVar.f2351d = set;
                        if (cVar.f2352e) {
                            cVar.f2348a.getRemoteService(p, set);
                        }
                        l0Var.f.disconnect();
                        return;
                    }
                }
            }
            ((g.c) l0Var.g).b(aVar);
            l0Var.f.disconnect();
            return;
        }
        throw null;
    }
}
