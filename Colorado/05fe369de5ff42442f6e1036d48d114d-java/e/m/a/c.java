package e.m.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.b.a.m;
import e.e.g;
import e.i.i.l;
import e.m.a.a1;
import e.m.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends a1 {

    public class a implements Runnable {
        public final /* synthetic */ List b;
        public final /* synthetic */ a1.d c;

        public a(List list, a1.d dVar) {
            this.b = list;
            this.c = dVar;
        }

        public void run() {
            if (this.b.contains(this.c)) {
                this.b.remove(this.c);
                c cVar = c.this;
                a1.d dVar = this.c;
                Objects.requireNonNull(cVar);
                dVar.a.a(dVar.c.F);
            }
        }
    }

    public static class b extends C0043c {
        public boolean c = false;

        /* renamed from: d  reason: collision with root package name */
        public v f1410d;

        public b(a1.d dVar, e.i.e.a aVar) {
            super(dVar, aVar);
        }

        public v c(Context context) {
            if (this.c) {
                return this.f1410d;
            }
            a1.d dVar = this.a;
            v E0 = m.h.E0(context, dVar.c, dVar.a == a1.d.c.VISIBLE);
            this.f1410d = E0;
            this.c = true;
            return E0;
        }
    }

    /* renamed from: e.m.a.c$c  reason: collision with other inner class name */
    public static class C0043c {
        public final a1.d a;
        public final e.i.e.a b;

        public C0043c(a1.d dVar, e.i.e.a aVar) {
            this.a = dVar;
            this.b = aVar;
        }

        public void a() {
            a1.d dVar = this.a;
            if (dVar.f1390e.remove(this.b) && dVar.f1390e.isEmpty()) {
                dVar.b();
            }
        }

        public boolean b() {
            a1.d.c cVar;
            a1.d.c c = a1.d.c.c(this.a.c.F);
            a1.d.c cVar2 = this.a.a;
            return c == cVar2 || !(c == (cVar = a1.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    public static class d extends C0043c {
        public final Object c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1411d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f1412e;

        public d(a1.d dVar, e.i.e.a aVar, boolean z, boolean z2) {
            super(dVar, aVar);
            Object obj;
            Object obj2;
            if (dVar.a == a1.d.c.VISIBLE) {
                if (z) {
                    obj2 = dVar.c.v();
                } else {
                    dVar.c.k();
                    obj2 = null;
                }
                this.c = obj2;
                if (z) {
                    m.d dVar2 = dVar.c.I;
                } else {
                    m.d dVar3 = dVar.c.I;
                }
            } else {
                if (z) {
                    obj = dVar.c.x();
                } else {
                    dVar.c.n();
                    obj = null;
                }
                this.c = obj;
            }
            this.f1411d = true;
            if (z2) {
                if (z) {
                    this.f1412e = dVar.c.z();
                    return;
                }
                dVar.c.y();
            }
            this.f1412e = null;
        }

        public final v0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            v0 v0Var = t0.b;
            if (obj instanceof Transition) {
                return v0Var;
            }
            v0 v0Var2 = t0.c;
            if (v0Var2 != null && v0Var2.e(obj)) {
                return v0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // e.m.a.a1
    public void b(List<a1.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        a1.d.c cVar;
        HashMap hashMap;
        String str;
        StringBuilder sb;
        v c;
        Iterator it;
        a1.d dVar;
        Object obj;
        View view;
        a1.d.c cVar2;
        a1.d.c cVar3;
        a1.d dVar2;
        Object obj2;
        View view2;
        e.e.a aVar;
        ArrayList arrayList3;
        a1.d.c cVar4;
        a1.d.c cVar5;
        ArrayList<View> arrayList4;
        v0 v0Var;
        a1.d dVar3;
        HashMap hashMap2;
        ArrayList<View> arrayList5;
        Rect rect;
        View view3;
        ArrayList<String> arrayList6;
        ArrayList<String> arrayList7;
        ArrayList<String> arrayList8;
        ArrayList<String> arrayList9;
        View view4;
        View view5;
        boolean z2 = z;
        a1.d.c cVar6 = a1.d.c.GONE;
        a1.d.c cVar7 = a1.d.c.VISIBLE;
        a1.d dVar4 = null;
        a1.d dVar5 = null;
        for (a1.d dVar6 : list) {
            a1.d.c c2 = a1.d.c.c(dVar6.c.F);
            int ordinal = dVar6.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (c2 != cVar7) {
                    dVar5 = dVar6;
                }
            }
            if (c2 == cVar7 && dVar4 == null) {
                dVar4 = dVar6;
            }
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(list);
        Iterator<a1.d> it2 = list.iterator();
        while (it2.hasNext()) {
            a1.d next = it2.next();
            e.i.e.a aVar2 = new e.i.e.a();
            next.d();
            next.f1390e.add(aVar2);
            arrayList10.add(new b(next, aVar2));
            e.i.e.a aVar3 = new e.i.e.a();
            next.d();
            next.f1390e.add(aVar3);
            arrayList11.add(new d(next, aVar3, z2, !z2 ? next == dVar5 : next == dVar4));
            next.f1389d.add(new a(arrayList12, next));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it3 = arrayList11.iterator();
        v0 v0Var2 = null;
        while (it3.hasNext()) {
            d dVar7 = (d) it3.next();
            if (!dVar7.b()) {
                v0 c3 = dVar7.c(dVar7.c);
                v0 c4 = dVar7.c(dVar7.f1412e);
                if (c3 == null || c4 == null || c3 == c4) {
                    if (c3 == null) {
                        c3 = c4;
                    }
                    if (v0Var2 == null) {
                        v0Var2 = c3;
                    } else if (!(c3 == null || v0Var2 == c3)) {
                        StringBuilder i2 = f.a.a.a.a.i("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        i2.append(dVar7.a.c);
                        i2.append(" returned Transition ");
                        i2.append(dVar7.c);
                        i2.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(i2.toString());
                    }
                } else {
                    StringBuilder i3 = f.a.a.a.a.i("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    i3.append(dVar7.a.c);
                    i3.append(" returned Transition ");
                    i3.append(dVar7.c);
                    i3.append(" which uses a different Transition  type than its shared element transition ");
                    i3.append(dVar7.f1412e);
                    throw new IllegalArgumentException(i3.toString());
                }
            }
        }
        if (v0Var2 == null) {
            Iterator it4 = arrayList11.iterator();
            while (it4.hasNext()) {
                d dVar8 = (d) it4.next();
                hashMap3.put(dVar8.a, Boolean.FALSE);
                dVar8.a();
            }
            arrayList = arrayList10;
            arrayList2 = arrayList12;
            cVar = cVar6;
            hashMap = hashMap3;
        } else {
            View view6 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList13 = new ArrayList<>();
            ArrayList<View> arrayList14 = new ArrayList<>();
            e.e.a aVar4 = new e.e.a();
            Iterator it5 = arrayList11.iterator();
            Rect rect3 = rect2;
            arrayList = arrayList10;
            arrayList2 = arrayList12;
            Object obj3 = null;
            View view7 = null;
            boolean z3 = false;
            View view8 = view6;
            a1.d dVar9 = dVar4;
            a1.d dVar10 = dVar5;
            while (it5.hasNext()) {
                Object obj4 = ((d) it5.next()).f1412e;
                if (!(obj4 != null) || dVar9 == null || dVar10 == null) {
                    aVar = aVar4;
                    arrayList5 = arrayList13;
                    cVar4 = cVar6;
                    cVar5 = cVar7;
                    dVar3 = dVar4;
                    arrayList3 = arrayList11;
                    hashMap2 = hashMap3;
                    arrayList4 = arrayList14;
                    v0Var = v0Var2;
                    view3 = view8;
                    rect = rect3;
                } else {
                    Object y = v0Var2.y(v0Var2.g(obj4));
                    m.d dVar11 = dVar10.c.I;
                    if (dVar11 == null || (arrayList6 = dVar11.f1461e) == null) {
                        arrayList6 = new ArrayList<>();
                    }
                    m.d dVar12 = dVar9.c.I;
                    if (dVar12 == null || (arrayList7 = dVar12.f1461e) == null) {
                        arrayList7 = new ArrayList<>();
                    }
                    cVar5 = cVar7;
                    m.d dVar13 = dVar9.c.I;
                    if (dVar13 == null || (arrayList8 = dVar13.f1462f) == null) {
                        arrayList8 = new ArrayList<>();
                    }
                    cVar4 = cVar6;
                    arrayList3 = arrayList11;
                    int i4 = 0;
                    while (i4 < arrayList8.size()) {
                        int indexOf = arrayList6.indexOf(arrayList8.get(i4));
                        if (indexOf != -1) {
                            arrayList6.set(indexOf, arrayList7.get(i4));
                        }
                        i4++;
                        arrayList8 = arrayList8;
                    }
                    m.d dVar14 = dVar10.c.I;
                    if (dVar14 == null || (arrayList9 = dVar14.f1462f) == null) {
                        arrayList9 = new ArrayList<>();
                    }
                    if (!z2) {
                        dVar9.c.o();
                        dVar10.c.m();
                    } else {
                        dVar9.c.m();
                        dVar10.c.o();
                    }
                    int i5 = 0;
                    for (int size = arrayList6.size(); i5 < size; size = size) {
                        aVar4.put(arrayList6.get(i5), arrayList9.get(i5));
                        i5++;
                    }
                    e.e.a<String, View> aVar5 = new e.e.a<>();
                    j(aVar5, dVar9.c.F);
                    g.k(aVar5, arrayList6);
                    g.k(aVar4, aVar5.keySet());
                    e.e.a<String, View> aVar6 = new e.e.a<>();
                    j(aVar6, dVar10.c.F);
                    g.k(aVar6, arrayList9);
                    g.k(aVar6, aVar4.values());
                    t0.m(aVar4, aVar6);
                    k(aVar5, aVar4.keySet());
                    k(aVar6, aVar4.values());
                    if (aVar4.isEmpty()) {
                        arrayList13.clear();
                        arrayList14.clear();
                        obj3 = null;
                        rect = rect3;
                        aVar = aVar4;
                        arrayList5 = arrayList13;
                        dVar3 = dVar4;
                        hashMap2 = hashMap3;
                        v0Var = v0Var2;
                        arrayList4 = arrayList14;
                        view3 = view8;
                    } else {
                        t0.c(dVar10.c, dVar9.c, z2, aVar5, true);
                        aVar = aVar4;
                        arrayList5 = arrayList13;
                        arrayList4 = arrayList14;
                        v0Var = v0Var2;
                        l.a(this.a, new h(this, dVar5, dVar4, z, aVar6));
                        Iterator it6 = ((g.e) aVar5.values()).iterator();
                        while (true) {
                            g.a aVar7 = (g.a) it6;
                            if (!aVar7.hasNext()) {
                                break;
                            }
                            i(arrayList5, (View) aVar7.next());
                        }
                        if (!arrayList6.isEmpty()) {
                            view4 = aVar5.get(arrayList6.get(0));
                            v0Var.t(y, view4);
                        } else {
                            view4 = view7;
                        }
                        Iterator it7 = ((g.e) aVar6.values()).iterator();
                        while (true) {
                            g.a aVar8 = (g.a) it7;
                            if (!aVar8.hasNext()) {
                                break;
                            }
                            i(arrayList4, (View) aVar8.next());
                        }
                        if (arrayList9.isEmpty() || (view5 = aVar6.get(arrayList9.get(0))) == null) {
                            rect = rect3;
                        } else {
                            rect = rect3;
                            l.a(this.a, new i(this, v0Var, view5, rect));
                            z3 = true;
                        }
                        view3 = view8;
                        v0Var.w(y, view3, arrayList5);
                        v0Var.r(y, null, null, null, null, y, arrayList4);
                        Boolean bool = Boolean.TRUE;
                        dVar3 = dVar4;
                        hashMap2 = hashMap3;
                        hashMap2.put(dVar3, bool);
                        dVar5 = dVar5;
                        hashMap2.put(dVar5, bool);
                        dVar9 = dVar3;
                        dVar10 = dVar5;
                        obj3 = y;
                        view7 = view4;
                        view8 = view3;
                        rect3 = rect;
                        arrayList13 = arrayList5;
                        v0Var2 = v0Var;
                        arrayList14 = arrayList4;
                        arrayList11 = arrayList3;
                        aVar4 = aVar;
                        z2 = z;
                        hashMap3 = hashMap2;
                        dVar4 = dVar3;
                        cVar7 = cVar5;
                        cVar6 = cVar4;
                    }
                }
                view7 = view7;
                view8 = view3;
                rect3 = rect;
                arrayList13 = arrayList5;
                v0Var2 = v0Var;
                arrayList14 = arrayList4;
                arrayList11 = arrayList3;
                aVar4 = aVar;
                z2 = z;
                hashMap3 = hashMap2;
                dVar4 = dVar3;
                cVar7 = cVar5;
                cVar6 = cVar4;
            }
            a1.d.c cVar8 = cVar6;
            a1.d.c cVar9 = cVar7;
            View view9 = view7;
            hashMap = hashMap3;
            View view10 = view8;
            ArrayList arrayList15 = new ArrayList();
            Iterator it8 = arrayList11.iterator();
            Object obj5 = null;
            Object obj6 = null;
            while (it8.hasNext()) {
                d dVar15 = (d) it8.next();
                if (dVar15.b()) {
                    it = it8;
                    dVar = dVar5;
                    hashMap.put(dVar15.a, Boolean.FALSE);
                    dVar15.a();
                    view = view10;
                    obj = obj3;
                    obj2 = obj5;
                    dVar2 = dVar10;
                    view2 = view9;
                    cVar3 = cVar9;
                    cVar2 = cVar8;
                } else {
                    it = it8;
                    dVar = dVar5;
                    Object g2 = v0Var2.g(dVar15.c);
                    a1.d dVar16 = dVar15.a;
                    boolean z4 = obj3 != null && (dVar16 == dVar9 || dVar16 == dVar10);
                    if (g2 == null) {
                        if (!z4) {
                            hashMap.put(dVar16, Boolean.FALSE);
                            dVar15.a();
                        }
                        view = view10;
                        obj = obj3;
                        obj2 = obj5;
                        view2 = view9;
                        cVar3 = cVar9;
                        cVar2 = cVar8;
                    } else {
                        obj = obj3;
                        ArrayList<View> arrayList16 = new ArrayList<>();
                        i(arrayList16, dVar16.c.F);
                        if (z4) {
                            if (dVar16 == dVar9) {
                                arrayList16.removeAll(arrayList13);
                            } else {
                                arrayList16.removeAll(arrayList14);
                            }
                        }
                        if (arrayList16.isEmpty()) {
                            v0Var2.a(g2, view10);
                            view = view10;
                            cVar2 = cVar8;
                        } else {
                            v0Var2.b(g2, arrayList16);
                            v0Var2.r(g2, g2, arrayList16, null, null, null, null);
                            cVar2 = cVar8;
                            if (dVar16.a == cVar2) {
                                v0Var2.q(g2, dVar16.c.F, arrayList16);
                                view = view10;
                                l.a(this.a, new j(this, arrayList16));
                            } else {
                                view = view10;
                            }
                        }
                        cVar3 = cVar9;
                        if (dVar16.a == cVar3) {
                            arrayList15.addAll(arrayList16);
                            if (z3) {
                                v0Var2.s(g2, rect3);
                            }
                            view2 = view9;
                        } else {
                            view2 = view9;
                            v0Var2.t(g2, view2);
                        }
                        hashMap.put(dVar16, Boolean.TRUE);
                        if (dVar15.f1411d) {
                            obj6 = v0Var2.m(obj6, g2, null);
                            obj2 = obj5;
                        } else {
                            obj2 = v0Var2.m(obj5, g2, null);
                        }
                    }
                    dVar2 = dVar;
                }
                view9 = view2;
                cVar9 = cVar3;
                cVar8 = cVar2;
                view10 = view;
                dVar5 = dVar;
                obj5 = obj2;
                dVar10 = dVar2;
                obj3 = obj;
                it8 = it;
            }
            a1.d dVar17 = dVar5;
            cVar = cVar8;
            Object l2 = v0Var2.l(obj6, obj5, obj3);
            Iterator it9 = arrayList11.iterator();
            while (it9.hasNext()) {
                d dVar18 = (d) it9.next();
                if (!dVar18.b()) {
                    Object obj7 = dVar18.c;
                    a1.d dVar19 = dVar18.a;
                    boolean z5 = obj3 != null && (dVar19 == dVar9 || dVar19 == dVar17);
                    if (obj7 != null || z5) {
                        v0Var2.u(dVar19.c, l2, dVar18.b, new k(this, dVar18));
                    }
                    dVar17 = dVar17;
                }
            }
            t0.o(arrayList15, 4);
            ArrayList<String> n = v0Var2.n(arrayList14);
            v0Var2.c(this.a, l2);
            v0Var2.v(this.a, arrayList13, arrayList14, n, aVar4);
            t0.o(arrayList15, 0);
            v0Var2.x(obj3, arrayList13, arrayList14);
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.a;
        Context context = viewGroup.getContext();
        ArrayList arrayList17 = new ArrayList();
        Iterator it10 = arrayList.iterator();
        boolean z6 = false;
        while (it10.hasNext()) {
            b bVar = (b) it10.next();
            if (!bVar.b() && (c = bVar.c(context)) != null) {
                Animator animator = c.b;
                if (animator == null) {
                    arrayList17.add(bVar);
                } else {
                    a1.d dVar20 = bVar.a;
                    m mVar = dVar20.c;
                    if (!Boolean.TRUE.equals(hashMap.get(dVar20))) {
                        boolean z7 = dVar20.a == cVar;
                        if (z7) {
                            arrayList2.remove(dVar20);
                        }
                        View view11 = mVar.F;
                        viewGroup.startViewTransition(view11);
                        animator.addListener(new d(this, viewGroup, view11, z7, dVar20, bVar));
                        animator.setTarget(view11);
                        animator.start();
                        bVar.b.b(new e(this, animator));
                        z6 = true;
                        arrayList2 = arrayList2;
                        cVar = cVar;
                        hashMap = hashMap;
                    } else if (e0.O(2)) {
                        String str2 = "Ignoring Animator set on " + mVar + " as this Fragment was involved in a Transition.";
                    }
                }
            }
            bVar.a();
        }
        Iterator it11 = arrayList17.iterator();
        while (it11.hasNext()) {
            b bVar2 = (b) it11.next();
            a1.d dVar21 = bVar2.a;
            m mVar2 = dVar21.c;
            if (containsValue) {
                if (e0.O(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str = " as Animations cannot run alongside Transitions.";
                }
                bVar2.a();
            } else if (z6) {
                if (e0.O(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str = " as Animations cannot run alongside Animators.";
                }
                bVar2.a();
            } else {
                View view12 = mVar2.F;
                v c5 = bVar2.c(context);
                Objects.requireNonNull(c5);
                Animation animation = c5.a;
                Objects.requireNonNull(animation);
                if (dVar21.a != a1.d.c.REMOVED) {
                    view12.startAnimation(animation);
                    bVar2.a();
                } else {
                    viewGroup.startViewTransition(view12);
                    w wVar = new w(animation, viewGroup, view12);
                    wVar.setAnimationListener(new f(this, viewGroup, view12, bVar2));
                    view12.startAnimation(wVar);
                }
                bVar2.b.b(new g(this, view12, viewGroup, bVar2));
            }
            sb.append(str);
            sb.toString();
            bVar2.a();
        }
        Iterator it12 = arrayList2.iterator();
        while (it12.hasNext()) {
            a1.d dVar22 = (a1.d) it12.next();
            dVar22.a.a(dVar22.c.F);
        }
        arrayList2.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.ArrayList<android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    public void i(ArrayList<View> arrayList, View view) {
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
                        i(arrayList, childAt);
                    }
                }
                return;
            }
        }
        arrayList.add(viewGroup == 1 ? 1 : 0);
    }

    public void j(Map<String, View> map, View view) {
        AtomicInteger atomicInteger = e.i.i.m.a;
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
                    j(map, childAt);
                }
            }
        }
    }

    public void k(e.e.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((g.b) aVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (!collection.contains(((View) dVar.getValue()).getTransitionName())) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
