package e.w;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import e.w.h;
import java.util.ArrayList;
import java.util.Iterator;

public class n extends h {
    public int A;
    public boolean B = false;
    public int C = 0;
    public ArrayList<h> y = new ArrayList<>();
    public boolean z = true;

    public class a extends k {
        public final /* synthetic */ h a;

        public a(n nVar, h hVar) {
            this.a = hVar;
        }

        @Override // e.w.h.d
        public void e(h hVar) {
            this.a.y();
            hVar.v(this);
        }
    }

    public static class b extends k {
        public n a;

        public b(n nVar) {
            this.a = nVar;
        }

        @Override // e.w.k, e.w.h.d
        public void c(h hVar) {
            n nVar = this.a;
            if (!nVar.B) {
                nVar.F();
                this.a.B = true;
            }
        }

        @Override // e.w.h.d
        public void e(h hVar) {
            n nVar = this.a;
            int i2 = nVar.A - 1;
            nVar.A = i2;
            if (i2 == 0) {
                nVar.B = false;
                nVar.m();
            }
            hVar.v(this);
        }
    }

    @Override // e.w.h
    public void A(h.c cVar) {
        this.t = cVar;
        this.C |= 8;
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).A(cVar);
        }
    }

    @Override // e.w.h
    public h B(TimeInterpolator timeInterpolator) {
        this.C |= 1;
        ArrayList<h> arrayList = this.y;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.y.get(i2).B(timeInterpolator);
            }
        }
        this.f1954e = timeInterpolator;
        return this;
    }

    @Override // e.w.h
    public void C(e eVar) {
        this.u = eVar == null ? h.w : eVar;
        this.C |= 4;
        if (this.y != null) {
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                this.y.get(i2).C(eVar);
            }
        }
    }

    @Override // e.w.h
    public void D(m mVar) {
        this.C |= 2;
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).D(mVar);
        }
    }

    @Override // e.w.h
    public h E(long j2) {
        this.c = j2;
        return this;
    }

    @Override // e.w.h
    public String G(String str) {
        String G = super.G(str);
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            StringBuilder i3 = f.a.a.a.a.i(G, "\n");
            i3.append(this.y.get(i2).G(str + "  "));
            G = i3.toString();
        }
        return G;
    }

    public n H(h hVar) {
        this.y.add(hVar);
        hVar.f1959j = this;
        long j2 = this.f1953d;
        if (j2 >= 0) {
            hVar.z(j2);
        }
        if ((this.C & 1) != 0) {
            hVar.B(this.f1954e);
        }
        if ((this.C & 2) != 0) {
            hVar.D(null);
        }
        if ((this.C & 4) != 0) {
            hVar.C(this.u);
        }
        if ((this.C & 8) != 0) {
            hVar.A(this.t);
        }
        return this;
    }

    public h I(int i2) {
        if (i2 < 0 || i2 >= this.y.size()) {
            return null;
        }
        return this.y.get(i2);
    }

    public n J(int i2) {
        if (i2 == 0) {
            this.z = true;
        } else if (i2 == 1) {
            this.z = false;
        } else {
            throw new AndroidRuntimeException(f.a.a.a.a.q("Invalid parameter for TransitionSet ordering: ", i2));
        }
        return this;
    }

    @Override // e.w.h
    public h a(h.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // e.w.h
    public h b(View view) {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            this.y.get(i2).b(view);
        }
        this.f1956g.add(view);
        return this;
    }

    @Override // e.w.h
    public void d(p pVar) {
        if (s(pVar.b)) {
            Iterator<h> it = this.y.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.s(pVar.b)) {
                    next.d(pVar);
                    pVar.c.add(next);
                }
            }
        }
    }

    @Override // e.w.h
    public void f(p pVar) {
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).f(pVar);
        }
    }

    @Override // e.w.h
    public void g(p pVar) {
        if (s(pVar.b)) {
            Iterator<h> it = this.y.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.s(pVar.b)) {
                    next.g(pVar);
                    pVar.c.add(next);
                }
            }
        }
    }

    @Override // e.w.h
    /* renamed from: j */
    public h clone() {
        n nVar = (n) super.clone();
        nVar.y = new ArrayList<>();
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            h j2 = this.y.get(i2).clone();
            nVar.y.add(j2);
            j2.f1959j = nVar;
        }
        return nVar;
    }

    @Override // e.w.h
    public void l(ViewGroup viewGroup, q qVar, q qVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        long j2 = this.c;
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.y.get(i2);
            if (j2 > 0 && (this.z || i2 == 0)) {
                long j3 = hVar.c;
                if (j3 > 0) {
                    hVar.E(j3 + j2);
                } else {
                    hVar.E(j2);
                }
            }
            hVar.l(viewGroup, qVar, qVar2, arrayList, arrayList2);
        }
    }

    @Override // e.w.h
    public void u(View view) {
        super.u(view);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).u(view);
        }
    }

    @Override // e.w.h
    public h v(h.d dVar) {
        super.v(dVar);
        return this;
    }

    @Override // e.w.h
    public h w(View view) {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            this.y.get(i2).w(view);
        }
        this.f1956g.remove(view);
        return this;
    }

    @Override // e.w.h
    public void x(View view) {
        super.x(view);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).x(view);
        }
    }

    @Override // e.w.h
    public void y() {
        if (this.y.isEmpty()) {
            F();
            m();
            return;
        }
        b bVar = new b(this);
        Iterator<h> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.A = this.y.size();
        if (!this.z) {
            for (int i2 = 1; i2 < this.y.size(); i2++) {
                this.y.get(i2 - 1).a(new a(this, this.y.get(i2)));
            }
            h hVar = this.y.get(0);
            if (hVar != null) {
                hVar.y();
                return;
            }
            return;
        }
        Iterator<h> it2 = this.y.iterator();
        while (it2.hasNext()) {
            it2.next().y();
        }
    }

    @Override // e.w.h
    public h z(long j2) {
        ArrayList<h> arrayList;
        this.f1953d = j2;
        if (j2 >= 0 && (arrayList = this.y) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.y.get(i2).z(j2);
            }
        }
        return this;
    }
}
