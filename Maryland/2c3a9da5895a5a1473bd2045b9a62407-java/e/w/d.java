package e.w;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import e.i.i.m;
import e.m.a.x0;
import e.w.h;
import e.w.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class d extends x0 {

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

        @Override // e.w.h.d
        public void a(h hVar) {
        }

        @Override // e.w.h.d
        public void b(h hVar) {
        }

        @Override // e.w.h.d
        public void c(h hVar) {
        }

        @Override // e.w.h.d
        public void d(h hVar) {
        }

        @Override // e.w.h.d
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
        public final /* synthetic */ ArrayList f1949d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f1950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1951f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.f1949d = arrayList2;
            this.f1950e = obj3;
            this.f1951f = arrayList3;
        }

        @Override // e.w.k, e.w.h.d
        public void c(h hVar) {
            Object obj = this.a;
            if (obj != null) {
                d.this.p(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                d.this.p(obj2, this.f1949d, null);
            }
            Object obj3 = this.f1950e;
            if (obj3 != null) {
                d.this.p(obj3, this.f1951f, null);
            }
        }

        @Override // e.w.h.d
        public void e(h hVar) {
            hVar.v(this);
        }
    }

    /* renamed from: e.w.d$d  reason: collision with other inner class name */
    public class C0063d extends h.c {
        public C0063d(d dVar, Rect rect) {
        }
    }

    public static boolean z(h hVar) {
        return !x0.k(hVar.f1955f) || !x0.k(null) || !x0.k(null);
    }

    @Override // e.m.a.x0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((h) obj).b(view);
        }
    }

    @Override // e.m.a.x0
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
            } else if (!z(hVar) && x0.k(hVar.f1956g)) {
                int size2 = arrayList.size();
                while (i2 < size2) {
                    hVar.b(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    @Override // e.m.a.x0
    public void c(ViewGroup viewGroup, Object obj) {
        h hVar = (h) obj;
        if (!l.c.contains(viewGroup)) {
            AtomicInteger atomicInteger = m.a;
            if (viewGroup.isLaidOut()) {
                l.c.add(viewGroup);
                if (hVar == null) {
                    hVar = l.a;
                }
                h j2 = hVar.clone();
                ArrayList<h> orDefault = l.a().getOrDefault(viewGroup, null);
                if (orDefault != null && orDefault.size() > 0) {
                    Iterator<h> it = orDefault.iterator();
                    while (it.hasNext()) {
                        it.next().u(viewGroup);
                    }
                }
                if (j2 != null) {
                    j2.h(viewGroup, true);
                }
                int i2 = R$id.transition_current_scene;
                if (((g) viewGroup.getTag(i2)) == null) {
                    viewGroup.setTag(i2, null);
                    if (j2 != null) {
                        l.a aVar = new l.a(j2, viewGroup);
                        viewGroup.addOnAttachStateChangeListener(aVar);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    @Override // e.m.a.x0
    public boolean e(Object obj) {
        return obj instanceof h;
    }

    @Override // e.m.a.x0
    public Object g(Object obj) {
        if (obj != null) {
            return ((h) obj).clone();
        }
        return null;
    }

    @Override // e.m.a.x0
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

    @Override // e.m.a.x0
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

    @Override // e.m.a.x0
    public void o(Object obj, View view) {
        if (obj != null) {
            ((h) obj).w(view);
        }
    }

    @Override // e.m.a.x0
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
            ArrayList<View> arrayList3 = hVar.f1956g;
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

    @Override // e.m.a.x0
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((h) obj).a(new b(this, view, arrayList));
    }

    @Override // e.m.a.x0
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((h) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // e.m.a.x0
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((h) obj).A(new C0063d(this, rect));
        }
    }

    @Override // e.m.a.x0
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((h) obj).A(new a(this, rect));
        }
    }

    @Override // e.m.a.x0
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        n nVar = (n) obj;
        ArrayList<View> arrayList2 = nVar.f1956g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            x0.d(arrayList2, arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(nVar, arrayList);
    }

    @Override // e.m.a.x0
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        n nVar = (n) obj;
        if (nVar != null) {
            nVar.f1956g.clear();
            nVar.f1956g.addAll(arrayList2);
            p(nVar, arrayList, arrayList2);
        }
    }

    @Override // e.m.a.x0
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        n nVar = new n();
        nVar.H((h) obj);
        return nVar;
    }
}
