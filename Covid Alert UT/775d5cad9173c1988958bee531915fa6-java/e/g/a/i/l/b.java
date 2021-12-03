package e.g.a.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.g.a.i.d;
import e.g.a.i.e;
import java.util.ArrayList;

public class b {
    public final ArrayList<d> a = new ArrayList<>();
    public a b = new a();
    public e c;

    public static class a {
        public d.a a;
        public d.a b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1319d;

        /* renamed from: e  reason: collision with root package name */
        public int f1320e;

        /* renamed from: f  reason: collision with root package name */
        public int f1321f;

        /* renamed from: g  reason: collision with root package name */
        public int f1322g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1323h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f1324i;

        /* renamed from: j  reason: collision with root package name */
        public int f1325j;
    }

    /* renamed from: e.g.a.i.l.b$b  reason: collision with other inner class name */
    public interface AbstractC0028b {
    }

    public b(e eVar) {
        this.c = eVar;
    }

    public final boolean a(AbstractC0028b bVar, d dVar, int i2) {
        d.a aVar = d.a.FIXED;
        this.b.a = dVar.m();
        this.b.b = dVar.q();
        this.b.c = dVar.r();
        this.b.f1319d = dVar.l();
        a aVar2 = this.b;
        aVar2.f1324i = false;
        aVar2.f1325j = i2;
        d.a aVar3 = aVar2.a;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar3 == aVar4;
        boolean z2 = aVar2.b == aVar4;
        boolean z3 = z && dVar.X > 0.0f;
        boolean z4 = z2 && dVar.X > 0.0f;
        if (z3 && dVar.s[0] == 4) {
            aVar2.a = aVar;
        }
        if (z4 && dVar.s[1] == 4) {
            aVar2.b = aVar;
        }
        ((ConstraintLayout.b) bVar).b(dVar, aVar2);
        dVar.N(this.b.f1320e);
        dVar.I(this.b.f1321f);
        a aVar5 = this.b;
        dVar.D = aVar5.f1323h;
        dVar.F(aVar5.f1322g);
        a aVar6 = this.b;
        aVar6.f1325j = 0;
        return aVar6.f1324i;
    }

    public final void b(e eVar, int i2, int i3, int i4) {
        int i5 = eVar.c0;
        int i6 = eVar.d0;
        eVar.L(0);
        eVar.K(0);
        eVar.V = i3;
        int i7 = eVar.c0;
        if (i3 < i7) {
            eVar.V = i7;
        }
        eVar.W = i4;
        int i8 = eVar.d0;
        if (i4 < i8) {
            eVar.W = i8;
        }
        eVar.L(i5);
        eVar.K(i6);
        e eVar2 = this.c;
        eVar2.t0 = i2;
        eVar2.Q();
    }

    public void c(e eVar) {
        this.a.clear();
        int size = eVar.q0.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = eVar.q0.get(i2);
            d.a m = dVar.m();
            d.a aVar = d.a.MATCH_CONSTRAINT;
            if (m == aVar || dVar.q() == aVar) {
                this.a.add(dVar);
            }
        }
        eVar.Y();
    }
}
