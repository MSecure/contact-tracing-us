package e.c0.a0;

import e.c0.q;
import e.r.s;
/* loaded from: classes.dex */
public class c implements q {
    public final s<q.b> c = new s<>();

    /* renamed from: d  reason: collision with root package name */
    public final e.c0.a0.t.s.c<q.b.c> f1081d = new e.c0.a0.t.s.c<>();

    public c() {
        a(q.b);
    }

    public void a(q.b bVar) {
        this.c.j(bVar);
        if (bVar instanceof q.b.c) {
            this.f1081d.j((q.b.c) bVar);
        } else if (bVar instanceof q.b.a) {
            this.f1081d.k(((q.b.a) bVar).a);
        }
    }
}
