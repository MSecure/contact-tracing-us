package b.g.a.h;

import b.g.a.h.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f919a;

    /* renamed from: b  reason: collision with root package name */
    public int f920b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f921c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f922d = false;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f923e = {-1, -1};
    public List<d> f = new ArrayList();
    public List<d> g = new ArrayList();
    public HashSet<d> h = new HashSet<>();
    public HashSet<d> i = new HashSet<>();
    public List<d> j = new ArrayList();
    public List<d> k = new ArrayList();

    public f(List<d> list) {
        this.f919a = list;
    }

    public f(List<d> list, boolean z) {
        this.f919a = list;
        this.f922d = z;
    }

    public void a(d dVar, int i2) {
        HashSet<d> hashSet;
        if (i2 == 0) {
            hashSet = this.h;
        } else if (i2 == 1) {
            hashSet = this.i;
        } else {
            return;
        }
        hashSet.add(dVar);
    }

    public final void b(ArrayList<d> arrayList, d dVar) {
        d dVar2;
        if (!dVar.d0) {
            arrayList.add(dVar);
            dVar.d0 = true;
            if (!dVar.q()) {
                if (dVar instanceof h) {
                    h hVar = (h) dVar;
                    int i2 = hVar.k0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        b(arrayList, hVar.j0[i3]);
                    }
                }
                int length = dVar.A.length;
                for (int i4 = 0; i4 < length; i4++) {
                    c cVar = dVar.A[i4].f900d;
                    if (!(cVar == null || (dVar2 = cVar.f898b) == dVar.D)) {
                        b(arrayList, dVar2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    public final void c(d dVar) {
        int i2;
        c cVar;
        if (dVar.b0 && !dVar.q()) {
            boolean z = false;
            boolean z2 = dVar.u.f900d != null;
            c cVar2 = (z2 ? dVar.u : dVar.s).f900d;
            if (cVar2 != null) {
                d dVar2 = cVar2.f898b;
                if (!dVar2.c0) {
                    c(dVar2);
                }
                c.b bVar = cVar2.f899c;
                if (bVar == c.b.RIGHT) {
                    d dVar3 = cVar2.f898b;
                    i2 = dVar3.n() + dVar3.I;
                } else if (bVar == c.b.LEFT) {
                    i2 = cVar2.f898b.I;
                }
                int b2 = !z2 ? i2 - dVar.u.b() : i2 + dVar.n() + dVar.s.b();
                dVar.x(b2 - dVar.n(), b2);
                cVar = dVar.w.f900d;
                if (cVar == null) {
                    d dVar4 = cVar.f898b;
                    if (!dVar4.c0) {
                        c(dVar4);
                    }
                    d dVar5 = cVar.f898b;
                    int i3 = (dVar5.J + dVar5.Q) - dVar.Q;
                    dVar.A(i3, dVar.F + i3);
                    dVar.c0 = true;
                    return;
                }
                if (dVar.v.f900d != null) {
                    z = true;
                }
                c cVar3 = (z ? dVar.v : dVar.t).f900d;
                if (cVar3 != null) {
                    d dVar6 = cVar3.f898b;
                    if (!dVar6.c0) {
                        c(dVar6);
                    }
                    c.b bVar2 = cVar3.f899c;
                    if (bVar2 == c.b.BOTTOM) {
                        d dVar7 = cVar3.f898b;
                        b2 = dVar7.J + dVar7.h();
                    } else if (bVar2 == c.b.TOP) {
                        b2 = cVar3.f898b.J;
                    }
                }
                int b3 = z ? b2 - dVar.v.b() : b2 + dVar.h() + dVar.t.b();
                dVar.A(b3 - dVar.h(), b3);
                dVar.c0 = true;
                return;
            }
            i2 = 0;
            if (!z2) {
            }
            dVar.x(b2 - dVar.n(), b2);
            cVar = dVar.w.f900d;
            if (cVar == null) {
            }
        }
    }
}
