package e.b.j;

import e.b.h.i;
import e.b.h.m;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final i f4926a;

    /* renamed from: b  reason: collision with root package name */
    public final c f4927b;

    /* renamed from: c  reason: collision with root package name */
    public final d f4928c;

    public a(i iVar, c cVar, d dVar) {
        this.f4926a = iVar;
        this.f4927b = cVar;
        this.f4928c = dVar;
    }

    @Override // e.b.j.f
    public void a(m mVar, int i) {
    }

    @Override // e.b.j.f
    public void b(m mVar, int i) {
        if (mVar instanceof i) {
            i iVar = (i) mVar;
            if (this.f4928c.a(this.f4926a, iVar)) {
                this.f4927b.add(iVar);
            }
        }
    }
}
