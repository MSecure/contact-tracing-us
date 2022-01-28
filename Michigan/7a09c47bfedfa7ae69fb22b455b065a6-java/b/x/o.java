package b.x;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.x.i;
import java.util.ArrayList;
import java.util.Iterator;

public class o extends i {
    public ArrayList<i> J = new ArrayList<>();
    public boolean K = true;
    public int L;
    public boolean M = false;
    public int N = 0;

    public class a extends l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f2709a;

        public a(o oVar, i iVar) {
            this.f2709a = iVar;
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            this.f2709a.B();
            iVar.y(this);
        }
    }

    public static class b extends l {

        /* renamed from: a  reason: collision with root package name */
        public o f2710a;

        public b(o oVar) {
            this.f2710a = oVar;
        }

        @Override // b.x.l, b.x.i.d
        public void c(i iVar) {
            o oVar = this.f2710a;
            if (!oVar.M) {
                oVar.I();
                this.f2710a.M = true;
            }
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            o oVar = this.f2710a;
            int i = oVar.L - 1;
            oVar.L = i;
            if (i == 0) {
                oVar.M = false;
                oVar.n();
            }
            iVar.y(this);
        }
    }

    @Override // b.x.i
    public void A(View view) {
        super.A(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).A(view);
        }
    }

    @Override // b.x.i
    public void B() {
        if (this.J.isEmpty()) {
            I();
            n();
            return;
        }
        b bVar = new b(this);
        Iterator<i> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.L = this.J.size();
        if (!this.K) {
            for (int i = 1; i < this.J.size(); i++) {
                this.J.get(i - 1).a(new a(this, this.J.get(i)));
            }
            i iVar = this.J.get(0);
            if (iVar != null) {
                iVar.B();
                return;
            }
            return;
        }
        Iterator<i> it2 = this.J.iterator();
        while (it2.hasNext()) {
            it2.next().B();
        }
    }

    @Override // b.x.i
    public i C(long j) {
        ArrayList<i> arrayList;
        this.f2690d = j;
        if (j >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).C(j);
            }
        }
        return this;
    }

    @Override // b.x.i
    public void D(i.c cVar) {
        this.E = cVar;
        this.N |= 8;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).D(cVar);
        }
    }

    @Override // b.x.i
    public i E(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<i> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).E(timeInterpolator);
            }
        }
        this.f2691e = timeInterpolator;
        return this;
    }

    @Override // b.x.i
    public void F(e eVar) {
        this.F = eVar == null ? i.H : eVar;
        this.N |= 4;
        if (this.J != null) {
            for (int i = 0; i < this.J.size(); i++) {
                this.J.get(i).F(eVar);
            }
        }
    }

    @Override // b.x.i
    public void G(n nVar) {
        this.D = nVar;
        this.N |= 2;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).G(nVar);
        }
    }

    @Override // b.x.i
    public i H(long j) {
        this.f2689c = j;
        return this;
    }

    @Override // b.x.i
    public String J(String str) {
        String J2 = super.J(str);
        for (int i = 0; i < this.J.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(J2);
            sb.append("\n");
            sb.append(this.J.get(i).J(str + "  "));
            J2 = sb.toString();
        }
        return J2;
    }

    public o K(i iVar) {
        this.J.add(iVar);
        iVar.s = this;
        long j = this.f2690d;
        if (j >= 0) {
            iVar.C(j);
        }
        if ((this.N & 1) != 0) {
            iVar.E(this.f2691e);
        }
        if ((this.N & 2) != 0) {
            iVar.G(null);
        }
        if ((this.N & 4) != 0) {
            iVar.F(this.F);
        }
        if ((this.N & 8) != 0) {
            iVar.D(this.E);
        }
        return this;
    }

    public i L(int i) {
        if (i < 0 || i >= this.J.size()) {
            return null;
        }
        return this.J.get(i);
    }

    public o M(int i) {
        if (i == 0) {
            this.K = true;
        } else if (i == 1) {
            this.K = false;
        } else {
            throw new AndroidRuntimeException(c.a.a.a.a.n("Invalid parameter for TransitionSet ordering: ", i));
        }
        return this;
    }

    @Override // b.x.i
    public i a(i.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // b.x.i
    public i b(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).b(view);
        }
        this.f2693g.add(view);
        return this;
    }

    @Override // b.x.i
    public void d() {
        super.d();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).d();
        }
    }

    @Override // b.x.i
    public void e(q qVar) {
        if (u(qVar.f2713b)) {
            Iterator<i> it = this.J.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.u(qVar.f2713b)) {
                    next.e(qVar);
                    qVar.f2714c.add(next);
                }
            }
        }
    }

    @Override // b.x.i
    public void g(q qVar) {
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).g(qVar);
        }
    }

    @Override // b.x.i
    public void h(q qVar) {
        if (u(qVar.f2713b)) {
            Iterator<i> it = this.J.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.u(qVar.f2713b)) {
                    next.h(qVar);
                    qVar.f2714c.add(next);
                }
            }
        }
    }

    @Override // b.x.i
    /* renamed from: k */
    public i clone() {
        o oVar = (o) super.clone();
        oVar.J = new ArrayList<>();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            i k = this.J.get(i).clone();
            oVar.J.add(k);
            k.s = oVar;
        }
        return oVar;
    }

    @Override // b.x.i
    public void m(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long j = this.f2689c;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.J.get(i);
            if (j > 0 && (this.K || i == 0)) {
                long j2 = iVar.f2689c;
                if (j2 > 0) {
                    iVar.H(j2 + j);
                } else {
                    iVar.H(j);
                }
            }
            iVar.m(viewGroup, rVar, rVar2, arrayList, arrayList2);
        }
    }

    @Override // b.x.i
    public void w(View view) {
        super.w(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).w(view);
        }
    }

    @Override // b.x.i
    public i y(i.d dVar) {
        super.y(dVar);
        return this;
    }

    @Override // b.x.i
    public i z(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).z(view);
        }
        this.f2693g.remove(view);
        return this;
    }
}
