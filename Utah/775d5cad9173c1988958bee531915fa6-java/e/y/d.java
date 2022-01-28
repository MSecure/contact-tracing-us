package e.y;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import e.n.a.v0;
import e.y.h;
import java.util.ArrayList;

public class d extends v0 {

    public class a extends h.c {
        public a(d dVar, Rect rect) {
        }
    }

    public class b implements h.d {
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrayList b;

        public b(d dVar, View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        @Override // e.y.h.d
        public void a(h hVar) {
        }

        @Override // e.y.h.d
        public void b(h hVar) {
        }

        @Override // e.y.h.d
        public void c(h hVar) {
        }

        @Override // e.y.h.d
        public void d(h hVar) {
        }

        @Override // e.y.h.d
        public void e(h hVar) {
            hVar.v(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.b.get(i2)).setVisibility(0);
            }
        }
    }

    public class c extends k {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ Object c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2042d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f2043e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2044f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.f2042d = arrayList2;
            this.f2043e = obj3;
            this.f2044f = arrayList3;
        }

        @Override // e.y.k, e.y.h.d
        public void c(h hVar) {
            Object obj = this.a;
            if (obj != null) {
                d.this.p(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                d.this.p(obj2, this.f2042d, null);
            }
            Object obj3 = this.f2043e;
            if (obj3 != null) {
                d.this.p(obj3, this.f2044f, null);
            }
        }

        @Override // e.y.h.d
        public void e(h hVar) {
            hVar.v(this);
        }
    }

    /* renamed from: e.y.d$d  reason: collision with other inner class name */
    public class C0064d extends h.c {
        public C0064d(d dVar, Rect rect) {
        }
    }

    public static boolean z(h hVar) {
        return !v0.k(hVar.f2048f) || !v0.k(null) || !v0.k(null);
    }

    @Override // e.n.a.v0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((h) obj).b(view);
        }
    }

    @Override // e.n.a.v0
    public void b(Object obj, ArrayList<View> arrayList) {
        h hVar = (h) obj;
        if (hVar != null) {
            int i2 = 0;
            if (hVar instanceof n) {
                n nVar = (n) hVar;
                int size = nVar.y.size();
                while (i2 < size) {
                    b(nVar.I(i2), arrayList);
                    i2++;
                }
            } else if (!z(hVar) && v0.k(hVar.f2049g)) {
                int size2 = arrayList.size();
                while (i2 < size2) {
                    hVar.b(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    @Override // e.n.a.v0
    public void c(ViewGroup viewGroup, Object obj) {
        l.a(viewGroup, (h) obj);
    }

    @Override // e.n.a.v0
    public boolean e(Object obj) {
        return obj instanceof h;
    }

    @Override // e.n.a.v0
    public Object g(Object obj) {
        if (obj != null) {
            return ((h) obj).clone();
        }
        return null;
    }

    @Override // e.n.a.v0
    public Object l(Object obj, Object obj2, Object obj3) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        h hVar3 = (h) obj3;
        if (hVar != null && hVar2 != null) {
            n nVar = new n();
            nVar.H(hVar);
            nVar.H(hVar2);
            nVar.J(1);
            hVar = nVar;
        } else if (hVar == null) {
            hVar = hVar2 != null ? hVar2 : null;
        }
        if (hVar3 == null) {
            return hVar;
        }
        n nVar2 = new n();
        if (hVar != null) {
            nVar2.H(hVar);
        }
        nVar2.H(hVar3);
        return nVar2;
    }

    @Override // e.n.a.v0
    public Object m(Object obj, Object obj2, Object obj3) {
        n nVar = new n();
        if (obj != null) {
            nVar.H((h) obj);
        }
        if (obj2 != null) {
            nVar.H((h) obj2);
        }
        if (obj3 != null) {
            nVar.H((h) obj3);
        }
        return nVar;
    }

    @Override // e.n.a.v0
    public void o(Object obj, View view) {
        if (obj != null) {
            ((h) obj).w(view);
        }
    }

    @Override // e.n.a.v0
    public void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        h hVar = (h) obj;
        int i2 = 0;
        if (hVar instanceof n) {
            n nVar = (n) hVar;
            int size = nVar.y.size();
            while (i2 < size) {
                p(nVar.I(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!z(hVar)) {
            ArrayList<View> arrayList3 = hVar.f2049g;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size2) {
                    hVar.b(arrayList2.get(i2));
                    i2++;
                }
                int size3 = arrayList.size();
                while (true) {
                    size3--;
                    if (size3 >= 0) {
                        hVar.w(arrayList.get(size3));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // e.n.a.v0
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((h) obj).a(new b(this, view, arrayList));
    }

    @Override // e.n.a.v0
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((h) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // e.n.a.v0
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((h) obj).A(new C0064d(this, rect));
        }
    }

    @Override // e.n.a.v0
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((h) obj).A(new a(this, rect));
        }
    }

    @Override // e.n.a.v0
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        n nVar = (n) obj;
        ArrayList<View> arrayList2 = nVar.f2049g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v0.d(arrayList2, arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(nVar, arrayList);
    }

    @Override // e.n.a.v0
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        n nVar = (n) obj;
        if (nVar != null) {
            nVar.f2049g.clear();
            nVar.f2049g.addAll(arrayList2);
            p(nVar, arrayList, arrayList2);
        }
    }

    @Override // e.n.a.v0
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        n nVar = new n();
        nVar.H((h) obj);
        return nVar;
    }
}
