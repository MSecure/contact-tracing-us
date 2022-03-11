package f.b.a.c.b.l.l;

import com.google.android.gms.common.api.Scope;
import f.b.a.c.b.a;
import f.b.a.c.b.l.l.e;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.v;
import f.b.a.c.h.b.n;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class y implements Runnable {
    public final /* synthetic */ n b;
    public final /* synthetic */ x c;

    public y(x xVar, n nVar) {
        this.c = xVar;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.c;
        n nVar = this.b;
        Objects.requireNonNull(xVar);
        a aVar = nVar.c;
        if (aVar.d()) {
            v vVar = nVar.f2834d;
            Objects.requireNonNull(vVar, "null reference");
            aVar = vVar.f2755d;
            if (!aVar.d()) {
                String.valueOf(aVar).length();
                new Exception();
            } else {
                a0 a0Var = xVar.f2704g;
                h d2 = vVar.d();
                Set<Scope> set = xVar.f2701d;
                e.c cVar = (e.c) a0Var;
                Objects.requireNonNull(cVar);
                if (d2 == null || set == null) {
                    new Exception();
                    cVar.b(new a(4));
                } else {
                    cVar.c = d2;
                    cVar.f2696d = set;
                    if (cVar.f2697e) {
                        cVar.a.h(d2, set);
                    }
                }
                xVar.f2703f.j();
            }
        }
        ((e.c) xVar.f2704g).b(aVar);
        xVar.f2703f.j();
    }
}
