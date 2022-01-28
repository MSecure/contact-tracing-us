package b.v;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.v.i;
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
        public final /* synthetic */ i f1820a;

        public a(o oVar, i iVar) {
            this.f1820a = iVar;
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            this.f1820a.z();
            iVar.w(this);
        }
    }

    public static class b extends l {

        /* renamed from: a  reason: collision with root package name */
        public o f1821a;

        public b(o oVar) {
            this.f1821a = oVar;
        }

        @Override // b.v.l, b.v.i.d
        public void c(i iVar) {
            o oVar = this.f1821a;
            if (!oVar.M) {
                oVar.G();
                this.f1821a.M = true;
            }
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            o oVar = this.f1821a;
            int i = oVar.L - 1;
            oVar.L = i;
            if (i == 0) {
                oVar.M = false;
                oVar.n();
            }
            iVar.w(this);
        }
    }

    @Override // b.v.i
    public i A(long j) {
        ArrayList<i> arrayList;
        this.f1803d = j;
        if (j >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).A(j);
            }
        }
        return this;
    }

    @Override // b.v.i
    public void B(i.c cVar) {
        this.E = cVar;
        this.N |= 8;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).B(cVar);
        }
    }

    @Override // b.v.i
    public i C(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<i> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).C(timeInterpolator);
            }
        }
        this.f1804e = timeInterpolator;
        return this;
    }

    @Override // b.v.i
    public void D(e eVar) {
        this.F = eVar == null ? i.H : eVar;
        this.N |= 4;
        if (this.J != null) {
            for (int i = 0; i < this.J.size(); i++) {
                this.J.get(i).D(eVar);
            }
        }
    }

    @Override // b.v.i
    public void E(n nVar) {
        this.D = nVar;
        this.N |= 2;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).E(nVar);
        }
    }

    @Override // b.v.i
    public i F(long j) {
        this.f1802c = j;
        return this;
    }

    @Override // b.v.i
    public String H(String str) {
        String H = super.H(str);
        for (int i = 0; i < this.J.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(H);
            sb.append("\n");
            sb.append(this.J.get(i).H(str + "  "));
            H = sb.toString();
        }
        return H;
    }

    public o I(i iVar) {
        this.J.add(iVar);
        iVar.s = this;
        long j = this.f1803d;
        if (j >= 0) {
            iVar.A(j);
        }
        if ((this.N & 1) != 0) {
            iVar.C(this.f1804e);
        }
        if ((this.N & 2) != 0) {
            iVar.E(null);
        }
        if ((this.N & 4) != 0) {
            iVar.D(this.F);
        }
        if ((this.N & 8) != 0) {
            iVar.B(this.E);
        }
        return this;
    }

    public i J(int i) {
        if (i < 0 || i >= this.J.size()) {
            return null;
        }
        return this.J.get(i);
    }

    public o K(int i) {
        if (i == 0) {
            this.K = true;
        } else if (i == 1) {
            this.K = false;
        } else {
            throw new AndroidRuntimeException(c.a.a.a.a.l("Invalid parameter for TransitionSet ordering: ", i));
        }
        return this;
    }

    @Override // b.v.i
    public i a(i.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // b.v.i
    public i b(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).b(view);
        }
        this.g.add(view);
        return this;
    }

    @Override // b.v.i
    public void d() {
        super.d();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).d();
        }
    }

    @Override // b.v.i
    public void e(q qVar) {
        if (t(qVar.f1824b)) {
            Iterator<i> it = this.J.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.t(qVar.f1824b)) {
                    next.e(qVar);
                    qVar.f1825c.add(next);
                }
            }
        }
    }

    @Override // b.v.i
    public void g(q qVar) {
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).g(qVar);
        }
    }

    @Override // b.v.i
    public void h(q qVar) {
        if (t(qVar.f1824b)) {
            Iterator<i> it = this.J.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.t(qVar.f1824b)) {
                    next.h(qVar);
                    qVar.f1825c.add(next);
                }
            }
        }
    }

    @Override // b.v.i
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

    @Override // b.v.i
    public void m(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long j = this.f1802c;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.J.get(i);
            if (j > 0 && (this.K || i == 0)) {
                long j2 = iVar.f1802c;
                if (j2 > 0) {
                    iVar.F(j2 + j);
                } else {
                    iVar.F(j);
                }
            }
            iVar.m(viewGroup, rVar, rVar2, arrayList, arrayList2);
        }
    }

    @Override // b.v.i
    public void v(View view) {
        super.v(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).v(view);
        }
    }

    @Override // b.v.i
    public i w(i.d dVar) {
        super.w(dVar);
        return this;
    }

    @Override // b.v.i
    public i x(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).x(view);
        }
        this.g.remove(view);
        return this;
    }

    @Override // b.v.i
    public void y(View view) {
        super.y(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).y(view);
        }
    }

    @Override // b.v.i
    public void z() {
        if (this.J.isEmpty()) {
            G();
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
                iVar.z();
                return;
            }
            return;
        }
        Iterator<i> it2 = this.J.iterator();
        while (it2.hasNext()) {
            it2.next().z();
        }
    }
}
