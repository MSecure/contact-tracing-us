package e.h.a.i.l;

import e.b.a.m;
import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n {

    /* renamed from: f  reason: collision with root package name */
    public static int f1436f;
    public int b;
    public int c;
    public ArrayList<d> a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1437d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1438e = -1;

    /* loaded from: classes.dex */
    public class a {
        public a(n nVar, d dVar, e.h.a.d dVar2, int i2) {
            new WeakReference(dVar);
            dVar2.o(dVar.I);
            dVar2.o(dVar.J);
            dVar2.o(dVar.K);
            dVar2.o(dVar.L);
            dVar2.o(dVar.M);
        }
    }

    public n(int i2) {
        this.b = -1;
        this.c = 0;
        int i3 = f1436f;
        f1436f = i3 + 1;
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
        if (this.f1438e != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                n nVar = arrayList.get(i2);
                if (this.f1438e == nVar.b) {
                    d(this.c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c(e.h.a.d dVar, int i2) {
        int i3;
        c cVar;
        if (this.a.size() == 0) {
            return 0;
        }
        ArrayList<d> arrayList = this.a;
        e eVar = (e) arrayList.get(0).U;
        dVar.u();
        eVar.d(dVar, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).d(dVar, false);
        }
        if (i2 == 0 && eVar.z0 > 0) {
            m.e.b(eVar, dVar, arrayList, 0);
        }
        if (i2 == 1 && eVar.A0 > 0) {
            m.e.b(eVar, dVar, arrayList, 1);
        }
        try {
            dVar.q();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f1437d = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f1437d.add(new a(this, arrayList.get(i5), dVar, i2));
        }
        if (i2 == 0) {
            i3 = dVar.o(eVar.I);
            cVar = eVar.K;
        } else {
            i3 = dVar.o(eVar.J);
            cVar = eVar.L;
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
                next.o0 = nVar.b;
            } else {
                next.p0 = nVar.b;
            }
        }
        this.f1438e = nVar.b;
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
            i3.append(it.next().i0);
            sb2 = i3.toString();
        }
        return f.a.a.a.a.x(sb2, " >");
    }
}
