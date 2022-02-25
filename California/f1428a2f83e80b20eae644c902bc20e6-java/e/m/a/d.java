package e.m.a;

import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.b.a.m;
import e.e.g;
import e.i.e.a;
import e.i.i.k;
import e.m.a.l;
import e.m.a.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class d extends z0 {

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<z0.d, HashSet<e.i.e.a>> f1581f = new HashMap<>();

    public class a implements Runnable {
        public final /* synthetic */ z0.d b;

        public a(d dVar, z0.d dVar2) {
            this.b = dVar2;
        }

        public void run() {
            z0.d dVar = this.b;
            if (dVar.a == z0.d.c.VISIBLE) {
                l.b bVar = dVar.c.I;
                View view = bVar == null ? null : bVar.f1634k;
                if (view != null) {
                    view.requestFocus();
                    this.b.c.f().f1634k = null;
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ List b;
        public final /* synthetic */ z0.d c;

        public b(List list, z0.d dVar) {
            this.b = list;
            this.c = dVar;
        }

        public void run() {
            if (this.b.contains(this.c)) {
                this.b.remove(this.c);
                d dVar = d.this;
                z0.d dVar2 = this.c;
                Objects.requireNonNull(dVar);
                dVar2.a.a(dVar2.c.F);
            }
        }
    }

    public class c implements a.AbstractC0031a {
        public final /* synthetic */ z0.d a;

        public c(z0.d dVar) {
            this.a = dVar;
        }

        @Override // e.i.e.a.AbstractC0031a
        public void a() {
            d dVar = d.this;
            HashSet<e.i.e.a> remove = dVar.f1581f.remove(this.a);
            if (remove != null) {
                Iterator<e.i.e.a> it = remove.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
    }

    /* renamed from: e.m.a.d$d  reason: collision with other inner class name */
    public static class C0044d {
        public final z0.d a;
        public final e.i.e.a b;

        public C0044d(z0.d dVar, e.i.e.a aVar) {
            this.a = dVar;
            this.b = aVar;
        }
    }

    public static class e {
        public final z0.d a;
        public final e.i.e.a b;
        public final Object c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1583d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f1584e;

        public e(z0.d dVar, e.i.e.a aVar, boolean z, boolean z2) {
            Object obj;
            Object obj2;
            this.a = dVar;
            this.b = aVar;
            if (dVar.a == z0.d.c.VISIBLE) {
                if (z) {
                    obj2 = dVar.c.u();
                } else {
                    dVar.c.m();
                    obj2 = null;
                }
                this.c = obj2;
                if (z) {
                    l.b bVar = dVar.c.I;
                } else {
                    l.b bVar2 = dVar.c.I;
                }
            } else {
                if (z) {
                    obj = dVar.c.w();
                } else {
                    dVar.c.o();
                    obj = null;
                }
                this.c = obj;
            }
            this.f1583d = true;
            if (z2) {
                if (z) {
                    this.f1584e = dVar.c.y();
                    return;
                }
                dVar.c.x();
            }
            this.f1584e = null;
        }

        public final u0 a(Object obj) {
            if (obj == null) {
                return null;
            }
            u0 u0Var = s0.b;
            if (obj instanceof Transition) {
                return u0Var;
            }
            u0 u0Var2 = s0.c;
            if (u0Var2 != null && u0Var2.e(obj)) {
                return u0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
        }

        public boolean b() {
            z0.d.c cVar;
            z0.d.c c2 = z0.d.c.c(this.a.c.F);
            z0.d.c cVar2 = this.a.a;
            return c2 == cVar2 || !(c2 == (cVar = z0.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    public d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // e.m.a.z0
    public void b(List<z0.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap hashMap;
        Boolean bool;
        z0.d.c cVar;
        z0.d.c cVar2;
        String str;
        StringBuilder sb;
        Object obj;
        Boolean bool2;
        z0.d.c cVar3;
        View view;
        e.e.a aVar;
        ArrayList arrayList3;
        Boolean bool3;
        z0.d.c cVar4;
        z0.d dVar;
        z0.d dVar2;
        HashMap hashMap2;
        u0 u0Var;
        Boolean bool4;
        ArrayList<View> arrayList4;
        ArrayList<View> arrayList5;
        Rect rect;
        View view2;
        ArrayList<String> arrayList6;
        ArrayList<String> arrayList7;
        ArrayList<String> arrayList8;
        ArrayList<String> arrayList9;
        View view3;
        View view4;
        Iterator it;
        boolean z2 = z;
        Boolean bool5 = Boolean.TRUE;
        z0.d.c cVar5 = z0.d.c.VISIBLE;
        z0.d dVar3 = null;
        z0.d dVar4 = null;
        for (z0.d dVar5 : list) {
            z0.d.c c2 = z0.d.c.c(dVar5.c.F);
            int ordinal = dVar5.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (c2 != cVar5) {
                    dVar4 = dVar5;
                }
            }
            if (c2 == cVar5 && dVar3 == null) {
                dVar3 = dVar5;
            }
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(list);
        Iterator<z0.d> it2 = list.iterator();
        while (it2.hasNext()) {
            z0.d next = it2.next();
            e.i.e.a aVar2 = new e.i.e.a();
            g(next, aVar2);
            arrayList10.add(new C0044d(next, aVar2));
            e.i.e.a aVar3 = new e.i.e.a();
            g(next, aVar3);
            arrayList11.add(new e(next, aVar3, z2, !z2 ? next == dVar4 : next == dVar3));
            next.f1699e.add(new a(this, next));
            next.f1699e.add(new b(arrayList12, next));
            next.f1698d.c(new c(next));
        }
        Boolean bool6 = Boolean.FALSE;
        HashMap hashMap3 = new HashMap();
        Iterator it3 = arrayList11.iterator();
        u0 u0Var2 = null;
        while (it3.hasNext()) {
            e eVar = (e) it3.next();
            if (eVar.b()) {
                it = it3;
            } else {
                u0 a2 = eVar.a(eVar.c);
                u0 a3 = eVar.a(eVar.f1584e);
                it = it3;
                if (a2 == null || a3 == null || a2 == a3) {
                    if (a2 == null) {
                        a2 = a3;
                    }
                    if (u0Var2 == null) {
                        u0Var2 = a2;
                    } else if (!(a2 == null || u0Var2 == a2)) {
                        StringBuilder h2 = f.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        h2.append(eVar.a.c);
                        h2.append(" returned Transition ");
                        h2.append(eVar.c);
                        h2.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(h2.toString());
                    }
                } else {
                    StringBuilder h3 = f.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    h3.append(eVar.a.c);
                    h3.append(" returned Transition ");
                    h3.append(eVar.c);
                    h3.append(" which uses a different Transition  type than its shared element transition ");
                    h3.append(eVar.f1584e);
                    throw new IllegalArgumentException(h3.toString());
                }
            }
            it3 = it;
        }
        if (u0Var2 == null) {
            Iterator it4 = arrayList11.iterator();
            while (it4.hasNext()) {
                e eVar2 = (e) it4.next();
                hashMap3.put(eVar2.a, bool6);
                j(eVar2.a, eVar2.b);
            }
            hashMap = hashMap3;
            cVar = cVar5;
            arrayList = arrayList10;
            arrayList2 = arrayList12;
            bool = bool5;
        } else {
            View view5 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList13 = new ArrayList<>();
            ArrayList<View> arrayList14 = new ArrayList<>();
            arrayList2 = arrayList12;
            e.e.a aVar4 = new e.e.a();
            Iterator it5 = arrayList11.iterator();
            Rect rect3 = rect2;
            arrayList = arrayList10;
            Object obj2 = null;
            View view6 = null;
            boolean z3 = false;
            View view7 = view5;
            HashMap hashMap4 = hashMap3;
            z0.d dVar6 = dVar3;
            z0.d dVar7 = dVar4;
            while (it5.hasNext()) {
                Object obj3 = ((e) it5.next()).f1584e;
                if (!(obj3 != null) || dVar6 == null || dVar7 == null) {
                    arrayList5 = arrayList13;
                    cVar4 = cVar5;
                    arrayList3 = arrayList11;
                    aVar = aVar4;
                    bool3 = bool6;
                    view2 = view7;
                    bool4 = bool5;
                    dVar2 = dVar3;
                    dVar = dVar4;
                    hashMap2 = hashMap4;
                    arrayList4 = arrayList14;
                    u0Var = u0Var2;
                    rect = rect3;
                    view6 = view6;
                } else {
                    Object y = u0Var2.y(u0Var2.g(obj3));
                    l.b bVar = dVar7.c.I;
                    if (bVar == null || (arrayList6 = bVar.f1628e) == null) {
                        arrayList6 = new ArrayList<>();
                    }
                    l.b bVar2 = dVar6.c.I;
                    if (bVar2 == null || (arrayList7 = bVar2.f1628e) == null) {
                        arrayList7 = new ArrayList<>();
                    }
                    cVar4 = cVar5;
                    l.b bVar3 = dVar6.c.I;
                    if (bVar3 == null || (arrayList8 = bVar3.f1629f) == null) {
                        arrayList8 = new ArrayList<>();
                    }
                    arrayList3 = arrayList11;
                    bool3 = bool6;
                    int i2 = 0;
                    while (i2 < arrayList8.size()) {
                        int indexOf = arrayList6.indexOf(arrayList8.get(i2));
                        if (indexOf != -1) {
                            arrayList6.set(indexOf, arrayList7.get(i2));
                        }
                        i2++;
                        arrayList8 = arrayList8;
                    }
                    l.b bVar4 = dVar7.c.I;
                    if (bVar4 == null || (arrayList9 = bVar4.f1629f) == null) {
                        arrayList9 = new ArrayList<>();
                    }
                    if (!z2) {
                        dVar6.c.p();
                        dVar7.c.n();
                    } else {
                        dVar6.c.n();
                        dVar7.c.p();
                    }
                    int i3 = 0;
                    for (int size = arrayList6.size(); i3 < size; size = size) {
                        aVar4.put(arrayList6.get(i3), arrayList9.get(i3));
                        i3++;
                    }
                    e.e.a<String, View> aVar5 = new e.e.a<>();
                    i(aVar5, dVar6.c.F);
                    g.k(aVar5, arrayList6);
                    g.k(aVar4, aVar5.keySet());
                    e.e.a<String, View> aVar6 = new e.e.a<>();
                    i(aVar6, dVar7.c.F);
                    g.k(aVar6, arrayList9);
                    g.k(aVar6, aVar4.values());
                    s0.m(aVar4, aVar6);
                    k(aVar5, aVar4.keySet());
                    k(aVar6, aVar4.values());
                    if (aVar4.isEmpty()) {
                        arrayList13.clear();
                        arrayList14.clear();
                        obj2 = null;
                        rect = rect3;
                        arrayList5 = arrayList13;
                        bool4 = bool5;
                        dVar2 = dVar3;
                        aVar = aVar4;
                        view2 = view7;
                        u0Var = u0Var2;
                        view6 = view6;
                        arrayList4 = arrayList14;
                        dVar = dVar4;
                        hashMap2 = hashMap4;
                    } else {
                        s0.c(dVar7.c, dVar6.c, z2, aVar5, true);
                        arrayList5 = arrayList13;
                        aVar = aVar4;
                        arrayList4 = arrayList14;
                        u0Var = u0Var2;
                        k.a(this.a, new h(this, dVar4, dVar3, z, aVar6));
                        Iterator it6 = ((g.e) aVar5.values()).iterator();
                        while (true) {
                            g.a aVar7 = (g.a) it6;
                            if (!aVar7.hasNext()) {
                                break;
                            }
                            h(arrayList5, (View) aVar7.next());
                        }
                        if (!arrayList6.isEmpty()) {
                            view3 = aVar5.get(arrayList6.get(0));
                            u0Var.t(y, view3);
                        } else {
                            view3 = view6;
                        }
                        Iterator it7 = ((g.e) aVar6.values()).iterator();
                        while (true) {
                            g.a aVar8 = (g.a) it7;
                            if (!aVar8.hasNext()) {
                                break;
                            }
                            h(arrayList4, (View) aVar8.next());
                        }
                        if (arrayList9.isEmpty() || (view4 = aVar6.get(arrayList9.get(0))) == null) {
                            rect = rect3;
                        } else {
                            rect = rect3;
                            k.a(this.a, new i(this, u0Var, view4, rect));
                            z3 = true;
                        }
                        view2 = view7;
                        u0Var.w(y, view2, arrayList5);
                        u0Var.r(y, null, null, null, null, y, arrayList4);
                        bool4 = bool5;
                        dVar2 = dVar3;
                        hashMap2 = hashMap4;
                        hashMap2.put(dVar2, bool4);
                        dVar = dVar4;
                        hashMap2.put(dVar, bool4);
                        obj2 = y;
                        dVar6 = dVar2;
                        dVar7 = dVar;
                        view6 = view3;
                    }
                }
                view7 = view2;
                rect3 = rect;
                arrayList13 = arrayList5;
                arrayList14 = arrayList4;
                bool5 = bool4;
                u0Var2 = u0Var;
                hashMap4 = hashMap2;
                dVar3 = dVar2;
                dVar4 = dVar;
                cVar5 = cVar4;
                bool6 = bool3;
                arrayList11 = arrayList3;
                aVar4 = aVar;
                z2 = z;
            }
            z0.d.c cVar6 = cVar5;
            View view8 = view6;
            Boolean bool7 = bool6;
            bool = bool5;
            z0.d dVar8 = dVar4;
            hashMap = hashMap4;
            ArrayList arrayList15 = new ArrayList();
            Iterator it8 = arrayList11.iterator();
            Object obj4 = null;
            Object obj5 = null;
            while (it8.hasNext()) {
                e eVar3 = (e) it8.next();
                if (eVar3.b()) {
                    hashMap.put(eVar3.a, bool7);
                    j(eVar3.a, eVar3.b);
                    it8 = it8;
                    obj5 = obj5;
                    dVar8 = dVar8;
                } else {
                    Object g2 = u0Var2.g(eVar3.c);
                    z0.d dVar9 = eVar3.a;
                    boolean z4 = obj2 != null && (dVar9 == dVar6 || dVar9 == dVar7);
                    if (g2 == null) {
                        if (!z4) {
                            hashMap.put(dVar9, bool7);
                            j(dVar9, eVar3.b);
                        }
                        obj = obj2;
                        bool2 = bool7;
                        obj5 = obj5;
                        view = view8;
                        cVar3 = cVar6;
                        obj4 = obj4;
                    } else {
                        bool2 = bool7;
                        ArrayList<View> arrayList16 = new ArrayList<>();
                        obj = obj2;
                        h(arrayList16, dVar9.c.F);
                        if (z4) {
                            if (dVar9 == dVar6) {
                                arrayList16.removeAll(arrayList13);
                            } else {
                                arrayList16.removeAll(arrayList14);
                            }
                        }
                        if (arrayList16.isEmpty()) {
                            u0Var2.a(g2, view7);
                        } else {
                            u0Var2.b(g2, arrayList16);
                            u0Var2.r(g2, g2, arrayList16, null, null, null, null);
                            if (dVar9.a == z0.d.c.GONE) {
                                u0Var2.q(g2, dVar9.c.F, arrayList16);
                                k.a(this.a, new j(this, arrayList16));
                            }
                        }
                        cVar3 = cVar6;
                        if (dVar9.a == cVar3) {
                            arrayList15.addAll(arrayList16);
                            if (z3) {
                                u0Var2.s(g2, rect3);
                            }
                            view = view8;
                        } else {
                            view = view8;
                            u0Var2.t(g2, view);
                        }
                        hashMap.put(dVar9, bool);
                        if (eVar3.f1583d) {
                            obj4 = u0Var2.m(obj4, g2, null);
                            obj5 = obj5;
                        } else {
                            obj4 = obj4;
                            obj5 = u0Var2.m(obj5, g2, null);
                        }
                    }
                    it8 = it8;
                    view8 = view;
                    cVar6 = cVar3;
                    dVar7 = dVar8;
                    dVar8 = dVar7;
                    bool7 = bool2;
                    obj2 = obj;
                }
            }
            cVar = cVar6;
            Object l2 = u0Var2.l(obj4, obj5, obj2);
            Iterator it9 = arrayList11.iterator();
            while (it9.hasNext()) {
                e eVar4 = (e) it9.next();
                if (!eVar4.b() && eVar4.c != null) {
                    u0Var2.u(eVar4.a.c, l2, eVar4.b, new c(this, eVar4));
                }
            }
            s0.o(arrayList15, 4);
            ArrayList<String> n = u0Var2.n(arrayList14);
            u0Var2.c(this.a, l2);
            u0Var2.v(this.a, arrayList13, arrayList14, n, aVar4);
            s0.o(arrayList15, 0);
            u0Var2.x(obj2, arrayList13, arrayList14);
        }
        boolean containsValue = hashMap.containsValue(bool);
        Iterator it10 = arrayList.iterator();
        while (it10.hasNext()) {
            C0044d dVar10 = (C0044d) it10.next();
            z0.d dVar11 = dVar10.a;
            boolean booleanValue = hashMap.containsKey(dVar11) ? ((Boolean) hashMap.get(dVar11)).booleanValue() : false;
            e.i.e.a aVar9 = dVar10.b;
            ViewGroup viewGroup = this.a;
            Context context = viewGroup.getContext();
            l lVar = dVar11.c;
            View view9 = lVar.F;
            z0.d.c c3 = z0.d.c.c(view9);
            z0.d.c cVar7 = dVar11.a;
            if (c3 != cVar7 && (c3 == cVar || cVar7 == cVar)) {
                s z0 = m.h.z0(context, lVar, cVar7 == cVar);
                if (z0 != null) {
                    if (!containsValue || z0.a == null) {
                        if (!booleanValue) {
                            viewGroup.startViewTransition(view9);
                            if (z0.a != null) {
                                Animation uVar = dVar11.a == cVar ? new u(z0.a) : new t(z0.a, viewGroup, view9);
                                cVar2 = cVar;
                                uVar.setAnimationListener(new e(this, viewGroup, view9, dVar11, aVar9));
                                view9.startAnimation(uVar);
                            } else {
                                cVar2 = cVar;
                                z0.b.addListener(new f(this, viewGroup, view9, dVar11, aVar9));
                                z0.b.setTarget(view9);
                                z0.b.start();
                            }
                            aVar9.c(new g(this, view9));
                            cVar = cVar2;
                        } else if (c0.Q(2)) {
                            sb = new StringBuilder();
                            sb.append("Ignoring Animator set on ");
                            sb.append(lVar);
                            str = " as this Fragment was involved in a Transition.";
                        }
                    } else if (c0.Q(2)) {
                        sb = new StringBuilder();
                        sb.append("Ignoring Animation set on ");
                        sb.append(lVar);
                        str = " as Animations cannot run alongside Transitions.";
                    }
                    sb.append(str);
                    sb.toString();
                }
            }
            cVar2 = cVar;
            j(dVar11, aVar9);
            cVar = cVar2;
        }
        Iterator it11 = arrayList2.iterator();
        while (it11.hasNext()) {
            z0.d dVar12 = (z0.d) it11.next();
            dVar12.a.a(dVar12.c.F);
        }
        arrayList2.clear();
    }

    public final void g(z0.d dVar, e.i.e.a aVar) {
        if (this.f1581f.get(dVar) == null) {
            this.f1581f.put(dVar, new HashSet<>());
        }
        this.f1581f.get(dVar).add(aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.ArrayList<android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    public void h(ArrayList<View> arrayList, View view) {
        boolean z = view instanceof ViewGroup;
        ViewGroup viewGroup = view;
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            boolean isTransitionGroup = viewGroup2.isTransitionGroup();
            viewGroup = viewGroup2;
            if (!isTransitionGroup) {
                int childCount = viewGroup2.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt.getVisibility() == 0) {
                        h(arrayList, childAt);
                    }
                }
                return;
            }
        }
        arrayList.add(viewGroup == 1 ? 1 : 0);
    }

    public void i(Map<String, View> map, View view) {
        AtomicInteger atomicInteger = e.i.i.l.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    i(map, childAt);
                }
            }
        }
    }

    public void j(z0.d dVar, e.i.e.a aVar) {
        HashSet<e.i.e.a> hashSet = this.f1581f.get(dVar);
        if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
            this.f1581f.remove(dVar);
            dVar.a();
        }
    }

    public void k(e.e.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((g.b) aVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                AtomicInteger atomicInteger = e.i.i.l.a;
                if (!collection.contains(((View) dVar.getValue()).getTransitionName())) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
