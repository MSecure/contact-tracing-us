package b.b0.y;

import b.b0.p;

public class c implements p {

    /* renamed from: c  reason: collision with root package name */
    public final b.o.p<p.b> f1065c = new b.o.p<>();

    /* renamed from: d  reason: collision with root package name */
    public final b.b0.y.s.r.c<p.b.c> f1066d = new b.b0.y.s.r.c<>();

    public c() {
        a(p.f1048b);
    }

    public void a(p.b bVar) {
        this.f1065c.postValue(bVar);
        if (bVar instanceof p.b.c) {
            this.f1066d.k((p.b.c) bVar);
        } else if (bVar instanceof p.b.a) {
            this.f1066d.l(((p.b.a) bVar).f1049a);
        }
    }
}
