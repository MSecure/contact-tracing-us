package b.v;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.i.l.m;
import b.l.d.l0;
import b.v.i;
import b.v.m;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
public class d extends l0 {

    public class a extends i.c {
        public a(d dVar, Rect rect) {
        }
    }

    public class b implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1783a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1784b;

        public b(d dVar, View view, ArrayList arrayList) {
            this.f1783a = view;
            this.f1784b = arrayList;
        }

        @Override // b.v.i.d
        public void a(i iVar) {
        }

        @Override // b.v.i.d
        public void b(i iVar) {
        }

        @Override // b.v.i.d
        public void c(i iVar) {
        }

        @Override // b.v.i.d
        public void d(i iVar) {
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            iVar.w(this);
            this.f1783a.setVisibility(8);
            int size = this.f1784b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f1784b.get(i)).setVisibility(0);
            }
        }
    }

    public class c extends l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f1785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f1787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1788d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f1789e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1785a = obj;
            this.f1786b = arrayList;
            this.f1787c = obj2;
            this.f1788d = arrayList2;
            this.f1789e = obj3;
            this.f = arrayList3;
        }

        @Override // b.v.l, b.v.i.d
        public void c(i iVar) {
            Object obj = this.f1785a;
            if (obj != null) {
                d.this.o(obj, this.f1786b, null);
            }
            Object obj2 = this.f1787c;
            if (obj2 != null) {
                d.this.o(obj2, this.f1788d, null);
            }
            Object obj3 = this.f1789e;
            if (obj3 != null) {
                d.this.o(obj3, this.f, null);
            }
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            iVar.w(this);
        }
    }

    /* renamed from: b.v.d$d  reason: collision with other inner class name */
    public class C0046d extends i.c {
        public C0046d(d dVar, Rect rect) {
        }
    }

    public static boolean x(i iVar) {
        return !l0.k(iVar.f) || !l0.k(iVar.h) || !l0.k(iVar.i);
    }

    @Override // b.l.d.l0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((i) obj).b(view);
        }
    }

    @Override // b.l.d.l0
    public void b(Object obj, ArrayList<View> arrayList) {
        i iVar = (i) obj;
        if (iVar != null) {
            int i = 0;
            if (iVar instanceof o) {
                o oVar = (o) iVar;
                int size = oVar.J.size();
                while (i < size) {
                    b(oVar.J(i), arrayList);
                    i++;
                }
            } else if (!x(iVar) && l0.k(iVar.g)) {
                int size2 = arrayList.size();
                while (i < size2) {
                    iVar.b(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    @Override // b.l.d.l0
    public void c(ViewGroup viewGroup, Object obj) {
        i iVar = (i) obj;
        if (!m.f1815c.contains(viewGroup) && m.B(viewGroup)) {
            m.f1815c.add(viewGroup);
            i k = iVar.clone();
            ArrayList<i> orDefault = m.a().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator<i> it = orDefault.iterator();
                while (it.hasNext()) {
                    it.next().v(viewGroup);
                }
            }
            if (k != null) {
                k.i(viewGroup, true);
            }
            if (((h) viewGroup.getTag(f.transition_current_scene)) == null) {
                viewGroup.setTag(f.transition_current_scene, null);
                if (k != null) {
                    m.a aVar = new m.a(k, viewGroup);
                    viewGroup.addOnAttachStateChangeListener(aVar);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    @Override // b.l.d.l0
    public boolean e(Object obj) {
        return obj instanceof i;
    }

    @Override // b.l.d.l0
    public Object g(Object obj) {
        if (obj != null) {
            return ((i) obj).clone();
        }
        return null;
    }

    @Override // b.l.d.l0
    public Object l(Object obj, Object obj2, Object obj3) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        i iVar3 = (i) obj3;
        if (iVar != null && iVar2 != null) {
            o oVar = new o();
            oVar.I(iVar);
            oVar.I(iVar2);
            oVar.K(1);
            iVar = oVar;
        } else if (iVar == null) {
            iVar = iVar2 != null ? iVar2 : null;
        }
        if (iVar3 == null) {
            return iVar;
        }
        o oVar2 = new o();
        if (iVar != null) {
            oVar2.I(iVar);
        }
        oVar2.I(iVar3);
        return oVar2;
    }

    @Override // b.l.d.l0
    public Object m(Object obj, Object obj2, Object obj3) {
        o oVar = new o();
        if (obj != null) {
            oVar.I((i) obj);
        }
        if (obj2 != null) {
            oVar.I((i) obj2);
        }
        if (obj3 != null) {
            oVar.I((i) obj3);
        }
        return oVar;
    }

    @Override // b.l.d.l0
    public void n(Object obj, View view) {
        if (obj != null) {
            ((i) obj).x(view);
        }
    }

    @Override // b.l.d.l0
    public void o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        i iVar = (i) obj;
        int i = 0;
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            int size = oVar.J.size();
            while (i < size) {
                o(oVar.J(i), arrayList, arrayList2);
                i++;
            }
        } else if (!x(iVar)) {
            ArrayList<View> arrayList3 = iVar.g;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size2) {
                    iVar.b(arrayList2.get(i));
                    i++;
                }
                int size3 = arrayList.size();
                while (true) {
                    size3--;
                    if (size3 >= 0) {
                        iVar.x(arrayList.get(size3));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // b.l.d.l0
    public void p(Object obj, View view, ArrayList<View> arrayList) {
        ((i) obj).a(new b(this, view, arrayList));
    }

    @Override // b.l.d.l0
    public void q(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((i) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // b.l.d.l0
    public void r(Object obj, Rect rect) {
        if (obj != null) {
            ((i) obj).B(new C0046d(this, rect));
        }
    }

    @Override // b.l.d.l0
    public void s(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((i) obj).B(new a(this, rect));
        }
    }

    @Override // b.l.d.l0
    public void u(Object obj, View view, ArrayList<View> arrayList) {
        o oVar = (o) obj;
        ArrayList<View> arrayList2 = oVar.g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            l0.d(arrayList2, arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(oVar, arrayList);
    }

    @Override // b.l.d.l0
    public void v(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        o oVar = (o) obj;
        if (oVar != null) {
            oVar.g.clear();
            oVar.g.addAll(arrayList2);
            o(oVar, arrayList, arrayList2);
        }
    }

    @Override // b.l.d.l0
    public Object w(Object obj) {
        if (obj == null) {
            return null;
        }
        o oVar = new o();
        oVar.I((i) obj);
        return oVar;
    }
}
