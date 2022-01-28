package f.b.a.a.a.l;

import e.p.t;
import f.b.a.a.a.b0.q0;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class b implements t {
    public final /* synthetic */ j a;
    public final /* synthetic */ i b;

    public /* synthetic */ b(j jVar, i iVar) {
        this.a = jVar;
        this.b = iVar;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        j jVar = this.a;
        i iVar = this.b;
        List<q0> list = (List) obj;
        Objects.requireNonNull(jVar);
        if (list.isEmpty()) {
            jVar.a0.b.setVisibility(8);
            jVar.a0.f2212d.setVisibility(0);
        } else {
            jVar.a0.b.setVisibility(0);
            jVar.a0.f2212d.setVisibility(8);
        }
        iVar.f2248e = list;
        iVar.a.b();
    }
}
