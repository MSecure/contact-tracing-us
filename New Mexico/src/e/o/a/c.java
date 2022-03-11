package e.o.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.b.a.m;
import e.f.g;
import e.j.j.q;
import e.j.j.v;
import e.o.a.a1;
import e.o.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c extends a1 {

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ List b;
        public final /* synthetic */ a1.d c;

        public a(List list, a1.d dVar) {
            c.this = r1;
            this.b = list;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
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

    /* loaded from: classes.dex */
    public static class b extends C0053c {
        public boolean c;

        /* renamed from: d */
        public boolean f1767d = false;

        /* renamed from: e */
        public v f1768e;

        public b(a1.d dVar, e.j.f.a aVar, boolean z) {
            super(dVar, aVar);
            this.c = z;
        }

        public v c(Context context) {
            if (this.f1767d) {
                return this.f1768e;
            }
            a1.d dVar = this.a;
            v V0 = m.e.V0(context, dVar.c, dVar.a == a1.d.c.VISIBLE, this.c);
            this.f1768e = V0;
            this.f1767d = true;
            return V0;
        }
    }

    /* renamed from: e.o.a.c$c */
    /* loaded from: classes.dex */
    public static class C0053c {
        public final a1.d a;
        public final e.j.f.a b;

        public C0053c(a1.d dVar, e.j.f.a aVar) {
            this.a = dVar;
            this.b = aVar;
        }

        public void a() {
            a1.d dVar = this.a;
            if (dVar.f1747e.remove(this.b) && dVar.f1747e.isEmpty()) {
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

    /* loaded from: classes.dex */
    public static class d extends C0053c {
        public final Object c;

        /* renamed from: d */
        public final boolean f1769d;

        /* renamed from: e */
        public final Object f1770e;

        public d(a1.d dVar, e.j.f.a aVar, boolean z, boolean z2) {
            super(dVar, aVar);
            Object obj;
            Object obj2;
            if (dVar.a == a1.d.c.VISIBLE) {
                if (z) {
                    obj2 = dVar.c.A();
                } else {
                    dVar.c.n();
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
                    obj = dVar.c.C();
                } else {
                    dVar.c.q();
                    obj = null;
                }
                this.c = obj;
            }
            this.f1769d = true;
            if (z2) {
                if (z) {
                    this.f1770e = dVar.c.E();
                    return;
                }
                dVar.c.D();
            }
            this.f1770e = null;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.o.a.a1
    public void b(List<a1.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        a1.d.c cVar;
        HashMap hashMap;
        StringBuilder sb;
        String str;
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
        e.f.a aVar;
        ArrayList arrayList3;
        a1.d.c cVar4;
        ArrayList arrayList4;
        ArrayList<View> arrayList5;
        v0 v0Var;
        HashMap hashMap2;
        ArrayList<View> arrayList6;
        Rect rect;
        a1.d dVar3;
        View view3;
        ArrayList<String> arrayList7;
        ArrayList<String> arrayList8;
        ArrayList<String> arrayList9;
        ArrayList<String> arrayList10;
        View view4;
        int i2;
        View view5;
        boolean z2 = z;
        a1.d.c cVar5 = a1.d.c.GONE;
        a1.d.c cVar6 = a1.d.c.VISIBLE;
        a1.d dVar4 = null;
        a1.d dVar5 = null;
        for (a1.d dVar6 : list) {
            a1.d.c c2 = a1.d.c.c(dVar6.c.F);
            int ordinal = dVar6.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (c2 != cVar6) {
                    dVar5 = dVar6;
                }
            }
            if (c2 == cVar6 && dVar4 == null) {
                dVar4 = dVar6;
            }
        }
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList(list);
        Iterator<a1.d> it2 = list.iterator();
        while (it2.hasNext()) {
            a1.d next = it2.next();
            e.j.f.a aVar2 = new e.j.f.a();
            next.d();
            next.f1747e.add(aVar2);
            arrayList11.add(new b(next, aVar2, z2));
            e.j.f.a aVar3 = new e.j.f.a();
            next.d();
            next.f1747e.add(aVar3);
            arrayList12.add(new d(next, aVar3, z2, !z2 ? next == dVar5 : next == dVar4));
            next.f1746d.add(new a(arrayList13, next));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it3 = arrayList12.iterator();
        v0 v0Var2 = null;
        while (it3.hasNext()) {
            d dVar7 = (d) it3.next();
            if (!dVar7.b()) {
                v0 c3 = dVar7.c(dVar7.c);
                v0 c4 = dVar7.c(dVar7.f1770e);
                if (c3 == null || c4 == null || c3 == c4) {
                    if (c3 == null) {
                        c3 = c4;
                    }
                    if (v0Var2 == null) {
                        v0Var2 = c3;
                    } else if (!(c3 == null || v0Var2 == c3)) {
                        StringBuilder h2 = f.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        h2.append(dVar7.a.c);
                        h2.append(" returned Transition ");
                        h2.append(dVar7.c);
                        h2.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(h2.toString());
                    }
                } else {
                    StringBuilder h3 = f.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    h3.append(dVar7.a.c);
                    h3.append(" returned Transition ");
                    h3.append(dVar7.c);
                    h3.append(" which uses a different Transition  type than its shared element transition ");
                    h3.append(dVar7.f1770e);
                    throw new IllegalArgumentException(h3.toString());
                }
            }
        }
        if (v0Var2 == null) {
            Iterator it4 = arrayList12.iterator();
            while (it4.hasNext()) {
                d dVar8 = (d) it4.next();
                hashMap3.put(dVar8.a, Boolean.FALSE);
                dVar8.a();
            }
            arrayList2 = arrayList11;
            arrayList = arrayList13;
            cVar = cVar5;
            hashMap = hashMap3;
        } else {
            View view6 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList14 = new ArrayList<>();
            ArrayList<View> arrayList15 = new ArrayList<>();
            e.f.a aVar4 = new e.f.a();
            Iterator it5 = arrayList12.iterator();
            Object obj3 = null;
            View view7 = null;
            arrayList2 = arrayList11;
            boolean z3 = false;
            a1.d dVar9 = dVar4;
            a1.d dVar10 = dVar5;
            while (it5.hasNext()) {
                Object obj4 = ((d) it5.next()).f1770e;
                if (!(obj4 != null) || dVar9 == null || dVar10 == null) {
                    aVar = aVar4;
                    arrayList6 = arrayList14;
                    cVar4 = cVar5;
                    dVar3 = dVar4;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList13;
                    hashMap2 = hashMap3;
                    view3 = view6;
                    arrayList5 = arrayList15;
                    v0Var = v0Var2;
                    rect = rect2;
                } else {
                    Object y = v0Var2.y(v0Var2.g(obj4));
                    m.d dVar11 = dVar10.c.I;
                    if (dVar11 == null || (arrayList7 = dVar11.f1823i) == null) {
                        arrayList7 = new ArrayList<>();
                    }
                    m.d dVar12 = dVar9.c.I;
                    if (dVar12 == null || (arrayList8 = dVar12.f1823i) == null) {
                        arrayList8 = new ArrayList<>();
                    }
                    arrayList4 = arrayList13;
                    m.d dVar13 = dVar9.c.I;
                    if (dVar13 == null || (arrayList9 = dVar13.f1824j) == null) {
                        arrayList9 = new ArrayList<>();
                    }
                    cVar4 = cVar5;
                    arrayList3 = arrayList12;
                    int i3 = 0;
                    while (i3 < arrayList9.size()) {
                        int indexOf = arrayList7.indexOf(arrayList9.get(i3));
                        if (indexOf != -1) {
                            arrayList7.set(indexOf, arrayList8.get(i3));
                        }
                        i3++;
                        arrayList9 = arrayList9;
                    }
                    m.d dVar14 = dVar10.c.I;
                    if (dVar14 == null || (arrayList10 = dVar14.f1824j) == null) {
                        arrayList10 = new ArrayList<>();
                    }
                    if (!z2) {
                        dVar9.c.r();
                        dVar10.c.o();
                    } else {
                        dVar9.c.o();
                        dVar10.c.r();
                    }
                    int i4 = 0;
                    for (int size = arrayList7.size(); i4 < size; size = size) {
                        aVar4.put(arrayList7.get(i4), arrayList10.get(i4));
                        i4++;
                    }
                    e.f.a<String, View> aVar5 = new e.f.a<>();
                    k(aVar5, dVar9.c.F);
                    g.k(aVar5, arrayList7);
                    g.k(aVar4, aVar5.keySet());
                    e.f.a<String, View> aVar6 = new e.f.a<>();
                    k(aVar6, dVar10.c.F);
                    g.k(aVar6, arrayList10);
                    g.k(aVar6, aVar4.values());
                    t0.m(aVar4, aVar6);
                    l(aVar5, aVar4.keySet());
                    l(aVar6, aVar4.values());
                    if (aVar4.isEmpty()) {
                        arrayList14.clear();
                        arrayList15.clear();
                        obj3 = null;
                        rect = rect2;
                        aVar = aVar4;
                        arrayList6 = arrayList14;
                        dVar3 = dVar4;
                        hashMap2 = hashMap3;
                        view3 = view6;
                        v0Var = v0Var2;
                        arrayList5 = arrayList15;
                    } else {
                        t0.c(dVar10.c, dVar9.c, z2, aVar5, true);
                        aVar = aVar4;
                        arrayList6 = arrayList14;
                        arrayList5 = arrayList15;
                        v0Var = v0Var2;
                        q.a(this.a, new h(this, dVar5, dVar4, z, aVar6));
                        arrayList6.addAll(aVar5.values());
                        if (!arrayList7.isEmpty()) {
                            i2 = 0;
                            view4 = aVar5.get(arrayList7.get(0));
                            v0Var.t(y, view4);
                        } else {
                            i2 = 0;
                            view4 = view7;
                        }
                        arrayList5.addAll(aVar6.values());
                        if (arrayList10.isEmpty() || (view5 = aVar6.get(arrayList10.get(i2))) == null) {
                            rect = rect2;
                        } else {
                            rect = rect2;
                            q.a(this.a, new i(this, v0Var, view5, rect));
                            z3 = true;
                        }
                        view3 = view6;
                        v0Var.w(y, view3, arrayList6);
                        v0Var.r(y, null, null, null, null, y, arrayList5);
                        Boolean bool = Boolean.TRUE;
                        dVar3 = dVar4;
                        hashMap2 = hashMap3;
                        hashMap2.put(dVar3, bool);
                        dVar5 = dVar5;
                        hashMap2.put(dVar5, bool);
                        dVar9 = dVar3;
                        obj3 = y;
                        view7 = view4;
                        dVar10 = dVar5;
                    }
                }
                view6 = view3;
                rect2 = rect;
                v0Var2 = v0Var;
                arrayList15 = arrayList5;
                cVar6 = cVar6;
                arrayList13 = arrayList4;
                arrayList12 = arrayList3;
                aVar4 = aVar;
                dVar4 = dVar3;
                arrayList14 = arrayList6;
                hashMap3 = hashMap2;
                cVar5 = cVar4;
                z2 = z;
            }
            a1.d.c cVar7 = cVar5;
            a1.d.c cVar8 = cVar6;
            arrayList = arrayList13;
            hashMap = hashMap3;
            View view8 = view6;
            ArrayList arrayList16 = new ArrayList();
            Iterator it6 = arrayList12.iterator();
            Object obj5 = null;
            Object obj6 = null;
            while (it6.hasNext()) {
                d dVar15 = (d) it6.next();
                if (dVar15.b()) {
                    it = it6;
                    dVar = dVar5;
                    hashMap.put(dVar15.a, Boolean.FALSE);
                    dVar15.a();
                    view = view8;
                    obj = obj3;
                    obj2 = obj5;
                    dVar2 = dVar10;
                    view2 = view7;
                    cVar3 = cVar8;
                    cVar2 = cVar7;
                } else {
                    it = it6;
                    dVar = dVar5;
                    Object g2 = v0Var2.g(dVar15.c);
                    a1.d dVar16 = dVar15.a;
                    boolean z4 = obj3 != null && (dVar16 == dVar9 || dVar16 == dVar10);
                    if (g2 == null) {
                        if (!z4) {
                            hashMap.put(dVar16, Boolean.FALSE);
                            dVar15.a();
                        }
                        view = view8;
                        obj = obj3;
                        obj2 = obj5;
                        view2 = view7;
                        cVar3 = cVar8;
                        cVar2 = cVar7;
                    } else {
                        obj = obj3;
                        ArrayList<View> arrayList17 = new ArrayList<>();
                        j(arrayList17, dVar16.c.F);
                        if (z4) {
                            if (dVar16 == dVar9) {
                                arrayList17.removeAll(arrayList14);
                            } else {
                                arrayList17.removeAll(arrayList15);
                            }
                        }
                        if (arrayList17.isEmpty()) {
                            v0Var2.a(g2, view8);
                            view = view8;
                            cVar2 = cVar7;
                        } else {
                            v0Var2.b(g2, arrayList17);
                            v0Var2.r(g2, g2, arrayList17, null, null, null, null);
                            cVar2 = cVar7;
                            if (dVar16.a == cVar2) {
                                arrayList.remove(dVar16);
                                view = view8;
                                ArrayList<View> arrayList18 = new ArrayList<>(arrayList17);
                                arrayList18.remove(dVar16.c.F);
                                v0Var2.q(g2, dVar16.c.F, arrayList18);
                                q.a(this.a, new j(this, arrayList17));
                            } else {
                                view = view8;
                            }
                        }
                        cVar3 = cVar8;
                        if (dVar16.a == cVar3) {
                            arrayList16.addAll(arrayList17);
                            if (z3) {
                                v0Var2.s(g2, rect2);
                            }
                            view2 = view7;
                        } else {
                            view2 = view7;
                            v0Var2.t(g2, view2);
                        }
                        hashMap.put(dVar16, Boolean.TRUE);
                        if (dVar15.f1769d) {
                            obj6 = v0Var2.m(obj6, g2, null);
                            obj2 = obj5;
                        } else {
                            obj2 = v0Var2.m(obj5, g2, null);
                        }
                    }
                    dVar2 = dVar;
                }
                view7 = view2;
                cVar8 = cVar3;
                cVar7 = cVar2;
                view8 = view;
                dVar5 = dVar;
                obj5 = obj2;
                dVar10 = dVar2;
                obj3 = obj;
                it6 = it;
            }
            a1.d dVar17 = dVar5;
            cVar = cVar7;
            Object l2 = v0Var2.l(obj6, obj5, obj3);
            Iterator it7 = arrayList12.iterator();
            while (it7.hasNext()) {
                d dVar18 = (d) it7.next();
                if (!dVar18.b()) {
                    Object obj7 = dVar18.c;
                    a1.d dVar19 = dVar18.a;
                    boolean z5 = obj3 != null && (dVar19 == dVar9 || dVar19 == dVar17);
                    if (obj7 != null || z5) {
                        ViewGroup viewGroup = this.a;
                        AtomicInteger atomicInteger = v.a;
                        if (!v.g.c(viewGroup)) {
                            if (e0.P(2)) {
                                StringBuilder h4 = f.a.a.a.a.h("SpecialEffectsController: Container ");
                                h4.append(this.a);
                                h4.append(" has not been laid out. Completing operation ");
                                h4.append(dVar19);
                                h4.toString();
                            }
                            dVar18.a();
                        } else {
                            v0Var2.u(dVar18.a.c, l2, dVar18.b, new k(this, dVar18));
                        }
                    }
                    dVar17 = dVar17;
                }
            }
            ViewGroup viewGroup2 = this.a;
            AtomicInteger atomicInteger2 = v.a;
            if (v.g.c(viewGroup2)) {
                t0.o(arrayList16, 4);
                ArrayList<String> n = v0Var2.n(arrayList15);
                v0Var2.c(this.a, l2);
                v0Var2.v(this.a, arrayList14, arrayList15, n, aVar4);
                t0.o(arrayList16, 0);
                v0Var2.x(obj3, arrayList14, arrayList15);
            }
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup3 = this.a;
        Context context = viewGroup3.getContext();
        ArrayList arrayList19 = new ArrayList();
        Iterator it8 = arrayList2.iterator();
        boolean z6 = false;
        while (it8.hasNext()) {
            b bVar = (b) it8.next();
            if (!bVar.b() && (c = bVar.c(context)) != null) {
                Animator animator = c.b;
                if (animator == null) {
                    arrayList19.add(bVar);
                } else {
                    a1.d dVar20 = bVar.a;
                    m mVar = dVar20.c;
                    if (!Boolean.TRUE.equals(hashMap.get(dVar20))) {
                        boolean z7 = dVar20.a == cVar;
                        if (z7) {
                            arrayList.remove(dVar20);
                        }
                        View view9 = mVar.F;
                        viewGroup3.startViewTransition(view9);
                        animator.addListener(new d(this, viewGroup3, view9, z7, dVar20, bVar));
                        animator.setTarget(view9);
                        animator.start();
                        bVar.b.b(new e(this, animator));
                        z6 = true;
                        arrayList = arrayList;
                        cVar = cVar;
                        hashMap = hashMap;
                    } else if (e0.P(2)) {
                        String str2 = "Ignoring Animator set on " + mVar + " as this Fragment was involved in a Transition.";
                    }
                }
            }
            bVar.a();
        }
        Iterator it9 = arrayList19.iterator();
        while (it9.hasNext()) {
            b bVar2 = (b) it9.next();
            a1.d dVar21 = bVar2.a;
            m mVar2 = dVar21.c;
            if (containsValue) {
                if (e0.P(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                    sb.toString();
                }
                bVar2.a();
            } else if (z6) {
                if (e0.P(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str = " as Animations cannot run alongside Animators.";
                    sb.append(str);
                    sb.toString();
                }
                bVar2.a();
            } else {
                View view10 = mVar2.F;
                v c5 = bVar2.c(context);
                Objects.requireNonNull(c5);
                Animation animation = c5.a;
                Objects.requireNonNull(animation);
                if (dVar21.a != a1.d.c.REMOVED) {
                    view10.startAnimation(animation);
                    bVar2.a();
                } else {
                    viewGroup3.startViewTransition(view10);
                    w wVar = new w(animation, viewGroup3, view10);
                    wVar.setAnimationListener(new f(this, viewGroup3, view10, bVar2));
                    view10.startAnimation(wVar);
                }
                bVar2.b.b(new g(this, view10, viewGroup3, bVar2));
            }
        }
        Iterator it10 = arrayList.iterator();
        while (it10.hasNext()) {
            a1.d dVar22 = (a1.d) it10.next();
            dVar22.a.a(dVar22.c.F);
        }
        arrayList.clear();
    }

    public void j(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!viewGroup.isTransitionGroup()) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt.getVisibility() == 0) {
                        j(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void k(Map<String, View> map, View view) {
        AtomicInteger atomicInteger = v.a;
        String k2 = v.i.k(view);
        if (k2 != null) {
            map.put(k2, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    k(map, childAt);
                }
            }
        }
    }

    public void l(e.f.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((g.b) aVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                AtomicInteger atomicInteger = v.a;
                if (!collection.contains(v.i.k((View) dVar.getValue()))) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
