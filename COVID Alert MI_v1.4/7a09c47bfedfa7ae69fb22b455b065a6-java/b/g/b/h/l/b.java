package b.g.b.h.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.h.d;
import b.g.b.h.e;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<d> f1524a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f1525b = new a();

    /* renamed from: c  reason: collision with root package name */
    public e f1526c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.a f1527a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f1528b;

        /* renamed from: c  reason: collision with root package name */
        public int f1529c;

        /* renamed from: d  reason: collision with root package name */
        public int f1530d;

        /* renamed from: e  reason: collision with root package name */
        public int f1531e;

        /* renamed from: f  reason: collision with root package name */
        public int f1532f;

        /* renamed from: g  reason: collision with root package name */
        public int f1533g;
        public boolean h;
        public boolean i;
        public boolean j;
    }

    /* renamed from: b.g.b.h.l.b$b  reason: collision with other inner class name */
    public interface AbstractC0025b {
    }

    public b(e eVar) {
        this.f1526c = eVar;
    }

    public final boolean a(AbstractC0025b bVar, d dVar, boolean z) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.MATCH_CONSTRAINT;
        this.f1525b.f1527a = dVar.j();
        this.f1525b.f1528b = dVar.n();
        this.f1525b.f1529c = dVar.o();
        this.f1525b.f1530d = dVar.i();
        a aVar3 = this.f1525b;
        aVar3.i = false;
        aVar3.j = z;
        d.a aVar4 = aVar3.f1527a;
        boolean z2 = true;
        boolean z3 = aVar4 == aVar2;
        boolean z4 = this.f1525b.f1528b == aVar2;
        boolean z5 = z3 && dVar.L > 0.0f;
        boolean z6 = z4 && dVar.L > 0.0f;
        if (z5 && dVar.l[0] == 4) {
            this.f1525b.f1527a = aVar;
        }
        if (z6 && dVar.l[1] == 4) {
            this.f1525b.f1528b = aVar;
        }
        ((ConstraintLayout.b) bVar).a(dVar, this.f1525b);
        dVar.B(this.f1525b.f1531e);
        dVar.w(this.f1525b.f1532f);
        a aVar5 = this.f1525b;
        dVar.w = aVar5.h;
        int i = aVar5.f1533g;
        dVar.P = i;
        if (i <= 0) {
            z2 = false;
        }
        dVar.w = z2;
        a aVar6 = this.f1525b;
        aVar6.j = false;
        return aVar6.i;
    }

    public final void b(e eVar, int i, int i2) {
        int i3 = eVar.Q;
        int i4 = eVar.R;
        eVar.z(0);
        eVar.y(0);
        eVar.J = i;
        int i5 = eVar.Q;
        if (i < i5) {
            eVar.J = i5;
        }
        eVar.K = i2;
        int i6 = eVar.R;
        if (i2 < i6) {
            eVar.K = i6;
        }
        eVar.z(i3);
        eVar.y(i4);
        this.f1526c.E();
    }
}
