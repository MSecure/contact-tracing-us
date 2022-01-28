package b.l.d;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import b.b.k.i;
import b.e.g;
import b.i.d.o;
import b.i.l.k;
import b.i.l.m;
import b.l.d.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c extends w0 {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1982b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ w0.d f1983c;

        public a(List list, w0.d dVar) {
            this.f1982b = list;
            this.f1983c = dVar;
        }

        public void run() {
            if (this.f1982b.contains(this.f1983c)) {
                this.f1982b.remove(this.f1983c);
                c cVar = c.this;
                w0.d dVar = this.f1983c;
                if (cVar != null) {
                    dVar.f2155a.b(dVar.f2157c.mView);
                    return;
                }
                throw null;
            }
        }
    }

    public static class b extends C0041c {

        /* renamed from: c  reason: collision with root package name */
        public boolean f1985c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1986d = false;

        /* renamed from: e  reason: collision with root package name */
        public q f1987e;

        public b(w0.d dVar, b.i.h.a aVar, boolean z) {
            super(dVar, aVar);
            this.f1985c = z;
        }

        public q c(Context context) {
            if (this.f1986d) {
                return this.f1987e;
            }
            w0.d dVar = this.f1988a;
            q N = i.j.N(context, dVar.f2157c, dVar.f2155a == w0.d.c.VISIBLE, this.f1985c);
            this.f1987e = N;
            this.f1986d = true;
            return N;
        }
    }

    /* renamed from: b.l.d.c$c  reason: collision with other inner class name */
    public static class C0041c {

        /* renamed from: a  reason: collision with root package name */
        public final w0.d f1988a;

        /* renamed from: b  reason: collision with root package name */
        public final b.i.h.a f1989b;

        public C0041c(w0.d dVar, b.i.h.a aVar) {
            this.f1988a = dVar;
            this.f1989b = aVar;
        }

        public void a() {
            w0.d dVar = this.f1988a;
            if (dVar.f2159e.remove(this.f1989b) && dVar.f2159e.isEmpty()) {
                dVar.b();
            }
        }

        public boolean b() {
            w0.d.c cVar;
            w0.d.c f2 = w0.d.c.f(this.f1988a.f2157c.mView);
            w0.d.c cVar2 = this.f1988a.f2155a;
            return f2 == cVar2 || !(f2 == (cVar = w0.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    public static class d extends C0041c {

        /* renamed from: c  reason: collision with root package name */
        public final Object f1990c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1991d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f1992e;

        public d(w0.d dVar, b.i.h.a aVar, boolean z, boolean z2) {
            super(dVar, aVar);
            boolean z3;
            Object obj;
            Object obj2;
            Object obj3;
            if (dVar.f2155a == w0.d.c.VISIBLE) {
                if (z) {
                    obj3 = dVar.f2157c.getReenterTransition();
                } else {
                    obj3 = dVar.f2157c.getEnterTransition();
                }
                this.f1990c = obj3;
                if (z) {
                    z3 = dVar.f2157c.getAllowReturnTransitionOverlap();
                } else {
                    z3 = dVar.f2157c.getAllowEnterTransitionOverlap();
                }
            } else {
                if (z) {
                    obj2 = dVar.f2157c.getReturnTransition();
                } else {
                    obj2 = dVar.f2157c.getExitTransition();
                }
                this.f1990c = obj2;
                z3 = true;
            }
            this.f1991d = z3;
            if (z2) {
                obj = z ? dVar.f2157c.getSharedElementReturnTransition() : dVar.f2157c.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.f1992e = obj;
        }

        public final r0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            r0 r0Var = p0.f2097b;
            if (obj instanceof Transition) {
                return r0Var;
            }
            r0 r0Var2 = p0.f2098c;
            if (r0Var2 != null && r0Var2.e(obj)) {
                return p0.f2098c;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f1988a.f2157c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // b.l.d.w0
    public void b(List<w0.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        w0.d.c cVar;
        boolean z2;
        HashMap hashMap;
        String str;
        StringBuilder sb;
        q c2;
        boolean z3;
        Object obj;
        Object obj2;
        View view;
        w0.d.c cVar2;
        w0.d.c cVar3;
        View view2;
        b.e.a aVar;
        ArrayList arrayList3;
        w0.d.c cVar4;
        w0.d.c cVar5;
        ArrayList<View> arrayList4;
        ArrayList<View> arrayList5;
        w0.d dVar;
        HashMap hashMap2;
        r0 r0Var;
        Rect rect;
        w0.d dVar2;
        View view3;
        o oVar;
        o oVar2;
        View view4;
        boolean z4 = z;
        w0.d.c cVar6 = w0.d.c.GONE;
        w0.d.c cVar7 = w0.d.c.VISIBLE;
        w0.d dVar3 = null;
        w0.d dVar4 = null;
        for (w0.d dVar5 : list) {
            w0.d.c f2 = w0.d.c.f(dVar5.f2157c.mView);
            int ordinal = dVar5.f2155a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (f2 != cVar7) {
                    dVar4 = dVar5;
                }
            }
            if (f2 == cVar7 && dVar3 == null) {
                dVar3 = dVar5;
            }
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList(list);
        Iterator<w0.d> it = list.iterator();
        while (it.hasNext()) {
            w0.d next = it.next();
            b.i.h.a aVar2 = new b.i.h.a();
            next.d();
            next.f2159e.add(aVar2);
            arrayList6.add(new b(next, aVar2, z4));
            b.i.h.a aVar3 = new b.i.h.a();
            next.d();
            next.f2159e.add(aVar3);
            arrayList7.add(new d(next, aVar3, z4, !z4 ? next == dVar4 : next == dVar3));
            next.f2158d.add(new a(arrayList8, next));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it2 = arrayList7.iterator();
        r0 r0Var2 = null;
        while (it2.hasNext()) {
            d dVar6 = (d) it2.next();
            if (!dVar6.b()) {
                r0 c3 = dVar6.c(dVar6.f1990c);
                r0 c4 = dVar6.c(dVar6.f1992e);
                if (c3 == null || c4 == null || c3 == c4) {
                    if (c3 == null) {
                        c3 = c4;
                    }
                    if (r0Var2 == null) {
                        r0Var2 = c3;
                    } else if (!(c3 == null || r0Var2 == c3)) {
                        StringBuilder h = c.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        h.append(dVar6.f1988a.f2157c);
                        h.append(" returned Transition ");
                        h.append(dVar6.f1990c);
                        h.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(h.toString());
                    }
                } else {
                    StringBuilder h2 = c.a.a.a.a.h("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    h2.append(dVar6.f1988a.f2157c);
                    h2.append(" returned Transition ");
                    h2.append(dVar6.f1990c);
                    h2.append(" which uses a different Transition  type than its shared element transition ");
                    h2.append(dVar6.f1992e);
                    throw new IllegalArgumentException(h2.toString());
                }
            }
        }
        if (r0Var2 == null) {
            Iterator it3 = arrayList7.iterator();
            while (it3.hasNext()) {
                d dVar7 = (d) it3.next();
                hashMap3.put(dVar7.f1988a, Boolean.FALSE);
                dVar7.a();
            }
            z2 = false;
            cVar = cVar6;
            arrayList = arrayList6;
            arrayList2 = arrayList8;
            hashMap = hashMap3;
        } else {
            View view5 = new View(this.f2146a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList9 = new ArrayList<>();
            ArrayList<View> arrayList10 = new ArrayList<>();
            b.e.a aVar4 = new b.e.a();
            Iterator it4 = arrayList7.iterator();
            Rect rect3 = rect2;
            arrayList2 = arrayList8;
            Object obj3 = null;
            View view6 = null;
            boolean z5 = false;
            View view7 = view5;
            w0.d dVar8 = dVar4;
            while (it4.hasNext()) {
                d dVar9 = (d) it4.next();
                if (!(dVar9.f1992e != null) || dVar3 == null || dVar8 == null) {
                    aVar = aVar4;
                    r0Var = r0Var2;
                    cVar4 = cVar6;
                    cVar5 = cVar7;
                    dVar = dVar4;
                    arrayList3 = arrayList7;
                    hashMap2 = hashMap3;
                    view3 = view7;
                    rect = rect3;
                    arrayList4 = arrayList9;
                    dVar2 = dVar3;
                    arrayList5 = arrayList10;
                    view6 = view6;
                } else {
                    Object y = r0Var2.y(r0Var2.g(dVar9.f1992e));
                    ArrayList<String> sharedElementSourceNames = dVar8.f2157c.getSharedElementSourceNames();
                    ArrayList<String> sharedElementSourceNames2 = dVar3.f2157c.getSharedElementSourceNames();
                    cVar4 = cVar6;
                    cVar5 = cVar7;
                    int i = 0;
                    for (ArrayList<String> sharedElementTargetNames = dVar3.f2157c.getSharedElementTargetNames(); i < sharedElementTargetNames.size(); sharedElementTargetNames = sharedElementTargetNames) {
                        int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                        if (indexOf != -1) {
                            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                        }
                        i++;
                    }
                    ArrayList<String> sharedElementTargetNames2 = dVar8.f2157c.getSharedElementTargetNames();
                    if (!z4) {
                        oVar2 = dVar3.f2157c.getExitTransitionCallback();
                        oVar = dVar8.f2157c.getEnterTransitionCallback();
                    } else {
                        oVar2 = dVar3.f2157c.getEnterTransitionCallback();
                        oVar = dVar8.f2157c.getExitTransitionCallback();
                    }
                    int size = sharedElementSourceNames.size();
                    arrayList3 = arrayList7;
                    int i2 = 0;
                    while (i2 < size) {
                        aVar4.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                        i2++;
                        size = size;
                        hashMap3 = hashMap3;
                    }
                    b.e.a<String, View> aVar5 = new b.e.a<>();
                    k(aVar5, dVar3.f2157c.mView);
                    g.k(aVar5, sharedElementSourceNames);
                    if (oVar2 == null) {
                        g.k(aVar4, aVar5.keySet());
                        b.e.a<String, View> aVar6 = new b.e.a<>();
                        k(aVar6, dVar8.f2157c.mView);
                        g.k(aVar6, sharedElementTargetNames2);
                        g.k(aVar6, aVar4.values());
                        if (oVar == null) {
                            p0.n(aVar4, aVar6);
                            l(aVar5, aVar4.keySet());
                            l(aVar6, aVar4.values());
                            if (aVar4.isEmpty()) {
                                arrayList9.clear();
                                arrayList10.clear();
                                obj3 = null;
                                rect = rect3;
                                aVar = aVar4;
                                dVar = dVar4;
                                view3 = view7;
                                r0Var = r0Var2;
                                view6 = view6;
                                hashMap2 = hashMap3;
                                arrayList4 = arrayList9;
                                dVar2 = dVar3;
                                arrayList5 = arrayList10;
                            } else {
                                p0.c(dVar8.f2157c, dVar3.f2157c, z4, aVar5, true);
                                aVar = aVar4;
                                arrayList4 = arrayList9;
                                arrayList5 = arrayList10;
                                r0Var = r0Var2;
                                k.a(this.f2146a, new h(this, dVar4, dVar3, z, aVar6));
                                Iterator it5 = ((g.e) aVar5.values()).iterator();
                                while (true) {
                                    g.a aVar7 = (g.a) it5;
                                    if (!aVar7.hasNext()) {
                                        break;
                                    }
                                    j(arrayList4, (View) aVar7.next());
                                }
                                if (!sharedElementSourceNames.isEmpty()) {
                                    view6 = aVar5.get(sharedElementSourceNames.get(0));
                                    r0Var.t(y, view6);
                                } else {
                                    view6 = view6;
                                }
                                Iterator it6 = ((g.e) aVar6.values()).iterator();
                                while (true) {
                                    g.a aVar8 = (g.a) it6;
                                    if (!aVar8.hasNext()) {
                                        break;
                                    }
                                    j(arrayList5, (View) aVar8.next());
                                }
                                if (sharedElementTargetNames2.isEmpty() || (view4 = aVar6.get(sharedElementTargetNames2.get(0))) == null) {
                                    rect = rect3;
                                } else {
                                    rect = rect3;
                                    k.a(this.f2146a, new i(this, r0Var, view4, rect));
                                    z5 = true;
                                }
                                view3 = view7;
                                r0Var.w(y, view3, arrayList4);
                                r0Var.r(y, null, null, null, null, y, arrayList5);
                                hashMap2 = hashMap3;
                                dVar2 = dVar3;
                                hashMap2.put(dVar2, Boolean.TRUE);
                                dVar = dVar4;
                                hashMap2.put(dVar, Boolean.TRUE);
                                dVar8 = dVar;
                                obj3 = y;
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
                view7 = view3;
                rect3 = rect;
                r0Var2 = r0Var;
                hashMap3 = hashMap2;
                arrayList10 = arrayList5;
                arrayList6 = arrayList6;
                cVar6 = cVar4;
                arrayList7 = arrayList3;
                aVar4 = aVar;
                z4 = z;
                dVar3 = dVar2;
                arrayList9 = arrayList4;
                dVar4 = dVar;
                cVar7 = cVar5;
            }
            w0.d.c cVar8 = cVar6;
            w0.d.c cVar9 = cVar7;
            w0.d dVar10 = dVar4;
            arrayList = arrayList6;
            View view8 = view6;
            hashMap = hashMap3;
            View view9 = view7;
            ArrayList arrayList11 = new ArrayList();
            Iterator it7 = arrayList7.iterator();
            Object obj4 = null;
            Object obj5 = null;
            while (it7.hasNext()) {
                d dVar11 = (d) it7.next();
                if (dVar11.b()) {
                    hashMap.put(dVar11.f1988a, Boolean.FALSE);
                    dVar11.a();
                    it7 = it7;
                    dVar10 = dVar10;
                } else {
                    Object g2 = r0Var2.g(dVar11.f1990c);
                    w0.d dVar12 = dVar11.f1988a;
                    boolean z6 = obj3 != null && (dVar12 == dVar3 || dVar12 == dVar8);
                    if (g2 == null) {
                        if (!z6) {
                            hashMap.put(dVar12, Boolean.FALSE);
                            dVar11.a();
                        }
                        view = view9;
                        obj2 = obj3;
                        obj = obj4;
                        view2 = view8;
                        cVar3 = cVar9;
                        cVar2 = cVar8;
                    } else {
                        obj2 = obj3;
                        ArrayList<View> arrayList12 = new ArrayList<>();
                        obj = obj4;
                        j(arrayList12, dVar12.f2157c.mView);
                        if (z6) {
                            if (dVar12 == dVar3) {
                                arrayList12.removeAll(arrayList9);
                            } else {
                                arrayList12.removeAll(arrayList10);
                            }
                        }
                        if (arrayList12.isEmpty()) {
                            r0Var2.a(g2, view9);
                            view = view9;
                            cVar2 = cVar8;
                        } else {
                            r0Var2.b(g2, arrayList12);
                            r0Var2.r(g2, g2, arrayList12, null, null, null, null);
                            cVar2 = cVar8;
                            if (dVar12.f2155a == cVar2) {
                                r0Var2.q(g2, dVar12.f2157c.mView, arrayList12);
                                view = view9;
                                k.a(this.f2146a, new j(this, arrayList12));
                            } else {
                                view = view9;
                            }
                        }
                        cVar3 = cVar9;
                        if (dVar12.f2155a == cVar3) {
                            arrayList11.addAll(arrayList12);
                            if (z5) {
                                r0Var2.s(g2, rect3);
                            }
                            view2 = view8;
                        } else {
                            view2 = view8;
                            r0Var2.t(g2, view2);
                        }
                        hashMap.put(dVar12, Boolean.TRUE);
                        if (dVar11.f1991d) {
                            obj5 = r0Var2.m(obj5, g2, null);
                        } else {
                            obj = r0Var2.m(obj, g2, null);
                        }
                    }
                    it7 = it7;
                    view8 = view2;
                    cVar9 = cVar3;
                    cVar8 = cVar2;
                    view9 = view;
                    obj3 = obj2;
                    obj4 = obj;
                    dVar8 = dVar10;
                    dVar10 = dVar8;
                }
            }
            w0.d dVar13 = dVar10;
            cVar = cVar8;
            Object l = r0Var2.l(obj5, obj4, obj3);
            Iterator it8 = arrayList7.iterator();
            while (it8.hasNext()) {
                d dVar14 = (d) it8.next();
                if (!dVar14.b()) {
                    Object obj6 = dVar14.f1990c;
                    w0.d dVar15 = dVar14.f1988a;
                    boolean z7 = obj3 != null && (dVar15 == dVar3 || dVar15 == dVar13);
                    if (obj6 != null || z7) {
                        if (!m.C(this.f2146a)) {
                            if (z.P(2)) {
                                StringBuilder h3 = c.a.a.a.a.h("SpecialEffectsController: Container ");
                                h3.append(this.f2146a);
                                h3.append(" has not been laid out. Completing operation ");
                                h3.append(dVar15);
                                h3.toString();
                            }
                            dVar14.a();
                        } else {
                            r0Var2.u(dVar14.f1988a.f2157c, l, dVar14.f1989b, new k(this, dVar14));
                        }
                    }
                    dVar13 = dVar13;
                }
            }
            if (!m.C(this.f2146a)) {
                z3 = false;
            } else {
                p0.p(arrayList11, 4);
                ArrayList<String> n = r0Var2.n(arrayList10);
                r0Var2.c(this.f2146a, l);
                r0Var2.v(this.f2146a, arrayList9, arrayList10, n, aVar4);
                z3 = false;
                p0.p(arrayList11, 0);
                r0Var2.x(obj3, arrayList9, arrayList10);
            }
            z2 = z3;
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.f2146a;
        Context context = viewGroup.getContext();
        ArrayList arrayList13 = new ArrayList();
        Iterator it9 = arrayList.iterator();
        boolean z8 = z2;
        while (it9.hasNext()) {
            b bVar = (b) it9.next();
            if (!bVar.b() && (c2 = bVar.c(context)) != null) {
                Animator animator = c2.f2106b;
                if (animator == null) {
                    arrayList13.add(bVar);
                } else {
                    w0.d dVar16 = bVar.f1988a;
                    Fragment fragment = dVar16.f2157c;
                    if (!Boolean.TRUE.equals(hashMap.get(dVar16))) {
                        boolean z9 = dVar16.f2155a == cVar ? true : z2;
                        if (z9) {
                            arrayList2.remove(dVar16);
                        }
                        View view10 = fragment.mView;
                        viewGroup.startViewTransition(view10);
                        animator.addListener(new d(this, viewGroup, view10, z9, dVar16, bVar));
                        animator.setTarget(view10);
                        animator.start();
                        bVar.f1989b.b(new e(this, animator));
                        z8 = true;
                        z2 = z2;
                        arrayList2 = arrayList2;
                        hashMap = hashMap;
                    } else if (z.P(2)) {
                        String str2 = "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.";
                    }
                }
            }
            bVar.a();
        }
        Iterator it10 = arrayList13.iterator();
        while (it10.hasNext()) {
            b bVar2 = (b) it10.next();
            w0.d dVar17 = bVar2.f1988a;
            Fragment fragment2 = dVar17.f2157c;
            if (containsValue) {
                if (z.P(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragment2);
                    str = " as Animations cannot run alongside Transitions.";
                }
                bVar2.a();
            } else if (z8) {
                if (z.P(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragment2);
                    str = " as Animations cannot run alongside Animators.";
                }
                bVar2.a();
            } else {
                View view11 = fragment2.mView;
                q c5 = bVar2.c(context);
                i.j.g(c5);
                Animation animation = c5.f2105a;
                i.j.g(animation);
                if (dVar17.f2155a != w0.d.c.REMOVED) {
                    view11.startAnimation(animation);
                    bVar2.a();
                } else {
                    viewGroup.startViewTransition(view11);
                    r rVar = new r(animation, viewGroup, view11);
                    rVar.setAnimationListener(new f(this, viewGroup, view11, bVar2));
                    view11.startAnimation(rVar);
                }
                bVar2.f1989b.b(new g(this, view11, viewGroup, bVar2));
            }
            sb.append(str);
            sb.toString();
            bVar2.a();
        }
        Iterator it11 = arrayList2.iterator();
        while (it11.hasNext()) {
            w0.d dVar18 = (w0.d) it11.next();
            dVar18.f2155a.b(dVar18.f2157c.mView);
        }
        arrayList2.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.ArrayList<android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    public void j(ArrayList<View> arrayList, View view) {
        ViewGroup viewGroup;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            boolean isTransitionGroup = viewGroup2.isTransitionGroup();
            viewGroup = viewGroup2;
            if (!isTransitionGroup) {
                int childCount = viewGroup2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup2.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        j(arrayList, childAt);
                    }
                }
                return;
            }
        } else {
            boolean contains = arrayList.contains(view);
            viewGroup = view;
            if (contains) {
                return;
            }
        }
        arrayList.add(viewGroup == 1 ? 1 : 0);
    }

    public void k(Map<String, View> map, View view) {
        String v = m.v(view);
        if (v != null) {
            map.put(v, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(map, childAt);
                }
            }
        }
    }

    public void l(b.e.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((g.b) aVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                if (!collection.contains(m.v((View) dVar.getValue()))) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
