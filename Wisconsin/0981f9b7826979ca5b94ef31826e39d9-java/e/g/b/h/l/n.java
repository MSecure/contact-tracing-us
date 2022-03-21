package e.g.b.h.l;

import e.b.a.m;
import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class n {

    /* renamed from: f  reason: collision with root package name */
    public static int f1318f;
    public ArrayList<d> a = new ArrayList<>();
    public int b = -1;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1319d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1320e = -1;

    public class a {
        public a(n nVar, d dVar, e.g.b.d dVar2, int i2) {
            new WeakReference(dVar);
            dVar2.o(dVar.D);
            dVar2.o(dVar.E);
            dVar2.o(dVar.F);
            dVar2.o(dVar.G);
            dVar2.o(dVar.H);
        }
    }

    public n(int i2) {
        int i3 = f1318f;
        f1318f = i3 + 1;
        this.b = i3;
        this.c = i2;
    }

    public boolean a(d dVar) {
        if (this.a.contains(dVar)) {
            return false;
        }
        this.a.add(dVar);
        return true;
    }

    public void b(ArrayList<n> arrayList) {
        int size = this.a.size();
        if (this.f1320e != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                n nVar = arrayList.get(i2);
                if (this.f1320e == nVar.b) {
                    d(this.c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c(e.g.b.d dVar, int i2) {
        int i3;
        c cVar;
        if (this.a.size() == 0) {
            return 0;
        }
        ArrayList<d> arrayList = this.a;
        e eVar = (e) arrayList.get(0).P;
        dVar.u();
        eVar.d(dVar, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).d(dVar, false);
        }
        if (i2 == 0 && eVar.t0 > 0) {
            m.h.b(eVar, dVar, arrayList, 0);
        }
        if (i2 == 1 && eVar.u0 > 0) {
            m.h.b(eVar, dVar, arrayList, 1);
        }
        try {
            dVar.q();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f1319d = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f1319d.add(new a(this, arrayList.get(i5), dVar, i2));
        }
        if (i2 == 0) {
            i3 = dVar.o(eVar.D);
            cVar = eVar.F;
        } else {
            i3 = dVar.o(eVar.E);
            cVar = eVar.G;
        }
        int o = dVar.o(cVar);
        dVar.u();
        return o - i3;
    }

    public void d(int i2, n nVar) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            d next = it.next();
            nVar.a(next);
            if (i2 == 0) {
                next.j0 = nVar.b;
            } else {
                next.k0 = nVar.b;
            }
        }
        this.f1320e = nVar.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.c;
        sb.append(i2 == 0 ? "Horizontal" : i2 == 1 ? "Vertical" : i2 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.b);
        sb.append("] <");
        String sb2 = sb.toString();
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            StringBuilder i3 = f.a.a.a.a.i(sb2, " ");
            i3.append(it.next().d0);
            sb2 = i3.toString();
        }
        return f.a.a.a.a.t(sb2, " >");
    }
}
