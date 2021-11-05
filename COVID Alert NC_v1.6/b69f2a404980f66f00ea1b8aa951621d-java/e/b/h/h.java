package e.b.h;

import e.b.j.f;

public class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringBuilder f4845a;

    public h(i iVar, StringBuilder sb) {
        this.f4845a = sb;
    }

    @Override // e.b.j.f
    public void a(m mVar, int i) {
        if ((mVar instanceof i) && ((i) mVar).f4846d.f4891d && (mVar.r() instanceof o) && !o.E(this.f4845a)) {
            this.f4845a.append(' ');
        }
    }

    @Override // e.b.j.f
    public void b(m mVar, int i) {
        if (mVar instanceof o) {
            i.C(this.f4845a, (o) mVar);
        } else if (mVar instanceof i) {
            i iVar = (i) mVar;
            if (this.f4845a.length() > 0) {
                e.b.i.h hVar = iVar.f4846d;
                if ((hVar.f4891d || hVar.f4889b.equals("br")) && !o.E(this.f4845a)) {
                    this.f4845a.append(' ');
                }
            }
        }
    }
}
