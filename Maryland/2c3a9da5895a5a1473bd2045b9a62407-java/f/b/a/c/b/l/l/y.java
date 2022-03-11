package f.b.a.c.b.l.l;

import android.util.Log;
import com.google.android.gms.common.api.Scope;
import f.b.a.c.b.a;
import f.b.a.c.b.l.l.e;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.v;
import f.b.a.c.h.b.n;
import java.util.Objects;
import java.util.Set;

public final class y implements Runnable {
    public final /* synthetic */ n b;
    public final /* synthetic */ x c;

    public y(x xVar, n nVar) {
        this.c = xVar;
        this.b = nVar;
    }

    public final void run() {
        x xVar = this.c;
        n nVar = this.b;
        Objects.requireNonNull(xVar);
        a aVar = nVar.c;
        if (aVar.d()) {
            v vVar = nVar.f2648d;
            Objects.requireNonNull(vVar, "null reference");
            aVar = vVar.f2571d;
            if (!aVar.d()) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
            } else {
                a0 a0Var = xVar.f2520g;
                h d2 = vVar.d();
                Set<Scope> set = xVar.f2517d;
                e.c cVar = (e.c) a0Var;
                Objects.requireNonNull(cVar);
                if (d2 == null || set == null) {
                    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                    cVar.b(new a(4));
                    xVar.f2519f.j();
                }
                cVar.c = d2;
                cVar.f2512d = set;
                if (cVar.f2513e) {
                    cVar.a.h(d2, set);
                }
                xVar.f2519f.j();
            }
        }
        ((e.c) xVar.f2520g).b(aVar);
        xVar.f2519f.j();
    }
}
