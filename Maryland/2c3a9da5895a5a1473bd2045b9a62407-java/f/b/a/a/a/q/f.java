package f.b.a.a.a.q;

import f.a.b.n;
import f.a.b.o;
import java.util.Objects;

public class f extends g {
    public final /* synthetic */ o a;

    public f(o oVar) {
        this.a = oVar;
    }

    @Override // f.b.a.a.a.q.g
    public <T> n<T> a(n<T> nVar) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        nVar.f2058i = oVar;
        synchronized (oVar.b) {
            oVar.b.add(nVar);
        }
        nVar.f2057h = Integer.valueOf(oVar.a.incrementAndGet());
        nVar.a("add-to-queue");
        (!nVar.f2059j ? oVar.f2066d : oVar.c).add(nVar);
        return nVar;
    }
}
