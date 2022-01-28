package b.x;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.i.l.m;
import b.l.d.r0;
import b.x.i;
import b.x.m;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
public class d extends r0 {

    public class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f2660a;

        public a(d dVar, Rect rect) {
            this.f2660a = rect;
        }
    }

    public class b implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2662b;

        public b(d dVar, View view, ArrayList arrayList) {
            this.f2661a = view;
            this.f2662b = arrayList;
        }

        @Override // b.x.i.d
        public void a(i iVar) {
        }

        @Override // b.x.i.d
        public void b(i iVar) {
        }

        @Override // b.x.i.d
        public void c(i iVar) {
        }

        @Override // b.x.i.d
        public void d(i iVar) {
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            iVar.y(this);
            this.f2661a.setVisibility(8);
            int size = this.f2662b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f2662b.get(i)).setVisibility(0);
            }
        }
    }

    public class c extends l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f2663a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f2665c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2666d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f2667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2668f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2663a = obj;
            this.f2664b = arrayList;
            this.f2665c = obj2;
            this.f2666d = arrayList2;
            this.f2667e = obj3;
            this.f2668f = arrayList3;
        }

        @Override // b.x.l, b.x.i.d
        public void c(i iVar) {
            Object obj = this.f2663a;
            if (obj != null) {
                d.this.p(obj, this.f2664b, null);
            }
            Object obj2 = this.f2665c;
            if (obj2 != null) {
                d.this.p(obj2, this.f2666d, null);
            }
            Object obj3 = this.f2667e;
            if (obj3 != null) {
                d.this.p(obj3, this.f2668f, null);
            }
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            iVar.y(this);
        }
    }

    /* renamed from: b.x.d$d  reason: collision with other inner class name */
    public class C0056d extends i.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f2670a;

        public C0056d(d dVar, Rect rect) {
            this.f2670a = rect;
        }
    }

    public static boolean z(i iVar) {
        return !r0.k(iVar.f2692f) || !r0.k(iVar.h) || !r0.k(iVar.i);
    }

    @Override // b.l.d.r0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((i) obj).b(view);
        }
    }

    @Override // b.l.d.r0
    public void b(Object obj, ArrayList<View> arrayList) {
        i iVar = (i) obj;
        if (iVar != null) {
            int i = 0;
            if (iVar instanceof o) {
                o oVar = (o) iVar;
                int size = oVar.J.size();
                while (i < size) {
                    b(oVar.L(i), arrayList);
                    i++;
                }
            } else if (!z(iVar) && r0.k(iVar.f2693g)) {
                int size2 = arrayList.size();
                while (i < size2) {
                    iVar.b(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    @Override // b.l.d.r0
    public void c(ViewGroup viewGroup, Object obj) {
        i iVar = (i) obj;
        if (!m.f2704c.contains(viewGroup) && m.C(viewGroup)) {
            m.f2704c.add(viewGroup);
            if (iVar == null) {
                iVar = m.f2702a;
            }
            i k = iVar.clone();
            ArrayList<i> orDefault = m.a().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator<i> it = orDefault.iterator();
                while (it.hasNext()) {
                    it.next().w(viewGroup);
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

    @Override // b.l.d.r0
    public boolean e(Object obj) {
        return obj instanceof i;
    }

    @Override // b.l.d.r0
    public Object g(Object obj) {
        if (obj != null) {
            return ((i) obj).clone();
        }
        return null;
    }

    @Override // b.l.d.r0
    public Object l(Object obj, Object obj2, Object obj3) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        i iVar3 = (i) obj3;
        if (iVar != null && iVar2 != null) {
            o oVar = new o();
            oVar.K(iVar);
            oVar.K(iVar2);
            oVar.M(1);
            iVar = oVar;
        } else if (iVar == null) {
            iVar = iVar2 != null ? iVar2 : null;
        }
        if (iVar3 == null) {
            return iVar;
        }
        o oVar2 = new o();
        if (iVar != null) {
            oVar2.K(iVar);
        }
        oVar2.K(iVar3);
        return oVar2;
    }

    @Override // b.l.d.r0
    public Object m(Object obj, Object obj2, Object obj3) {
        o oVar = new o();
        if (obj != null) {
            oVar.K((i) obj);
        }
        if (obj2 != null) {
            oVar.K((i) obj2);
        }
        if (obj3 != null) {
            oVar.K((i) obj3);
        }
        return oVar;
    }

    @Override // b.l.d.r0
    public void o(Object obj, View view) {
        if (obj != null) {
            ((i) obj).z(view);
        }
    }

    @Override // b.l.d.r0
    public void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        i iVar = (i) obj;
        int i = 0;
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            int size = oVar.J.size();
            while (i < size) {
                p(oVar.L(i), arrayList, arrayList2);
                i++;
            }
        } else if (!z(iVar)) {
            ArrayList<View> arrayList3 = iVar.f2693g;
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
                        iVar.z(arrayList.get(size3));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // b.l.d.r0
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((i) obj).a(new b(this, view, arrayList));
    }

    @Override // b.l.d.r0
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((i) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // b.l.d.r0
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((i) obj).D(new C0056d(this, rect));
        }
    }

    @Override // b.l.d.r0
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((i) obj).D(new a(this, rect));
        }
    }

    @Override // b.l.d.r0
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        o oVar = (o) obj;
        ArrayList<View> arrayList2 = oVar.f2693g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            r0.d(arrayList2, arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(oVar, arrayList);
    }

    @Override // b.l.d.r0
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        o oVar = (o) obj;
        if (oVar != null) {
            oVar.f2693g.clear();
            oVar.f2693g.addAll(arrayList2);
            p(oVar, arrayList, arrayList2);
        }
    }

    @Override // b.l.d.r0
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        o oVar = new o();
        oVar.K((i) obj);
        return oVar;
    }
}
