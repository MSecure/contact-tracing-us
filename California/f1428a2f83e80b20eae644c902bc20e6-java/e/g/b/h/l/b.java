package e.g.b.h.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.g.b.h.d;
import e.g.b.h.e;
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
        public int f1286d;

        /* renamed from: e  reason: collision with root package name */
        public int f1287e;

        /* renamed from: f  reason: collision with root package name */
        public int f1288f;

        /* renamed from: g  reason: collision with root package name */
        public int f1289g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1290h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f1291i;

        /* renamed from: j  reason: collision with root package name */
        public int f1292j;
    }

    /* renamed from: e.g.b.h.l.b$b  reason: collision with other inner class name */
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
        this.b.f1286d = dVar.l();
        a aVar2 = this.b;
        aVar2.f1291i = false;
        aVar2.f1292j = i2;
        d.a aVar3 = aVar2.a;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar3 == aVar4;
        boolean z2 = aVar2.b == aVar4;
        boolean z3 = z && dVar.S > 0.0f;
        boolean z4 = z2 && dVar.S > 0.0f;
        if (z3 && dVar.n[0] == 4) {
            aVar2.a = aVar;
        }
        if (z4 && dVar.n[1] == 4) {
            aVar2.b = aVar;
        }
        ((ConstraintLayout.b) bVar).b(dVar, aVar2);
        dVar.M(this.b.f1287e);
        dVar.H(this.b.f1288f);
        a aVar5 = this.b;
        dVar.y = aVar5.f1290h;
        dVar.E(aVar5.f1289g);
        a aVar6 = this.b;
        aVar6.f1292j = 0;
        return aVar6.f1291i;
    }

    public final void b(e eVar, int i2, int i3) {
        int i4 = eVar.X;
        int i5 = eVar.Y;
        eVar.K(0);
        eVar.J(0);
        eVar.Q = i2;
        int i6 = eVar.X;
        if (i2 < i6) {
            eVar.Q = i6;
        }
        eVar.R = i3;
        int i7 = eVar.Y;
        if (i3 < i7) {
            eVar.R = i7;
        }
        eVar.K(i4);
        eVar.J(i5);
        this.c.P();
    }

    public void c(e eVar) {
        this.a.clear();
        int size = eVar.l0.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = eVar.l0.get(i2);
            d.a m = dVar.m();
            d.a aVar = d.a.MATCH_CONSTRAINT;
            if (m == aVar || dVar.q() == aVar) {
                this.a.add(dVar);
            }
        }
        eVar.W();
    }
}
