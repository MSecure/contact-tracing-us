package b.l.d;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.e.g;
import b.i.d.n;
import b.i.l.k;
import b.i.l.m;
import b.l.d.q;
import b.l.d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f1282a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    public static final l0 f1283b = new h0();

    /* renamed from: c  reason: collision with root package name */
    public static final l0 f1284c;

    public interface a {
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f1285a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1286b;

        /* renamed from: c  reason: collision with root package name */
        public a f1287c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f1288d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1289e;
        public a f;
    }

    static {
        l0 l0Var;
        try {
            l0Var = (l0) Class.forName("b.v.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            l0Var = null;
        }
        f1284c = l0Var;
    }

    public static void a(ArrayList<View> arrayList, b.e.a<String, View> aVar, Collection<String> collection) {
        for (int i = aVar.f829d - 1; i >= 0; i--) {
            View k = aVar.k(i);
            if (collection.contains(m.u(k))) {
                arrayList.add(k);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0075, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0087, code lost:
        if (r0.mHidden == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0089, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static void b(a aVar, z.a aVar2, SparseArray<b> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        b bVar;
        q qVar;
        boolean z6;
        Fragment fragment = aVar2.f1371b;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            int i2 = z ? f1282a[aVar2.f1370a] : aVar2.f1370a;
            boolean z7 = false;
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    z3 = false;
                                    z5 = false;
                                    z4 = false;
                                    bVar = sparseArray.get(i);
                                    if (z7) {
                                        if (bVar == null) {
                                            b bVar2 = new b();
                                            sparseArray.put(i, bVar2);
                                            bVar = bVar2;
                                        }
                                        bVar.f1285a = fragment;
                                        bVar.f1286b = z;
                                        bVar.f1287c = aVar;
                                    }
                                    if (!z2 && z3) {
                                        if (bVar != null && bVar.f1288d == fragment) {
                                            bVar.f1288d = null;
                                        }
                                        qVar = aVar.r;
                                        if (fragment.mState < 1 && qVar.m >= 1 && !aVar.p) {
                                            qVar.T(fragment);
                                            qVar.W(fragment, 1);
                                        }
                                    }
                                    if (z4 && (bVar == null || bVar.f1288d == null)) {
                                        if (bVar == null) {
                                            b bVar3 = new b();
                                            sparseArray.put(i, bVar3);
                                            bVar = bVar3;
                                        }
                                        bVar.f1288d = fragment;
                                        bVar.f1289e = z;
                                        bVar.f = aVar;
                                    }
                                    if (z2 && z5 && bVar != null && bVar.f1285a == fragment) {
                                        bVar.f1285a = null;
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else if (z2) {
                            if (fragment.mHiddenChanged) {
                                if (!fragment.mHidden) {
                                }
                            }
                            z6 = false;
                            z5 = false;
                            z4 = false;
                            z7 = z6;
                            z3 = true;
                            bVar = sparseArray.get(i);
                            if (z7) {
                            }
                            bVar.f1288d = null;
                            qVar = aVar.r;
                            qVar.T(fragment);
                            qVar.W(fragment, 1);
                            if (bVar == null) {
                            }
                            bVar.f1288d = fragment;
                            bVar.f1289e = z;
                            bVar.f = aVar;
                            if (z2) {
                                return;
                            }
                            return;
                        } else {
                            z6 = fragment.mHidden;
                            z5 = false;
                            z4 = false;
                            z7 = z6;
                            z3 = true;
                            bVar = sparseArray.get(i);
                            if (z7) {
                            }
                            bVar.f1288d = null;
                            qVar = aVar.r;
                            qVar.T(fragment);
                            qVar.W(fragment, 1);
                            if (bVar == null) {
                            }
                            bVar.f1288d = fragment;
                            bVar.f1289e = z;
                            bVar.f = aVar;
                            if (z2) {
                            }
                        }
                    } else if (!z2) {
                        boolean z8 = false;
                        z4 = z8;
                        z3 = false;
                        z5 = true;
                        bVar = sparseArray.get(i);
                        if (z7) {
                        }
                        bVar.f1288d = null;
                        qVar = aVar.r;
                        qVar.T(fragment);
                        qVar.W(fragment, 1);
                        if (bVar == null) {
                        }
                        bVar.f1288d = fragment;
                        bVar.f1289e = z;
                        bVar.f = aVar;
                        if (z2) {
                        }
                    } else {
                        boolean z82 = false;
                        z4 = z82;
                        z3 = false;
                        z5 = true;
                        bVar = sparseArray.get(i);
                        if (z7) {
                        }
                        bVar.f1288d = null;
                        qVar = aVar.r;
                        qVar.T(fragment);
                        qVar.W(fragment, 1);
                        if (bVar == null) {
                        }
                        bVar.f1288d = fragment;
                        bVar.f1289e = z;
                        bVar.f = aVar;
                        if (z2) {
                        }
                    }
                }
                boolean z9 = fragment.mAdded;
                if (!z2) {
                    boolean z822 = false;
                    z4 = z822;
                    z3 = false;
                    z5 = true;
                    bVar = sparseArray.get(i);
                    if (z7) {
                    }
                    bVar.f1288d = null;
                    qVar = aVar.r;
                    qVar.T(fragment);
                    qVar.W(fragment, 1);
                    if (bVar == null) {
                    }
                    bVar.f1288d = fragment;
                    bVar.f1289e = z;
                    bVar.f = aVar;
                    if (z2) {
                    }
                } else {
                    boolean z8222 = false;
                    z4 = z8222;
                    z3 = false;
                    z5 = true;
                    bVar = sparseArray.get(i);
                    if (z7) {
                    }
                    bVar.f1288d = null;
                    qVar = aVar.r;
                    qVar.T(fragment);
                    qVar.W(fragment, 1);
                    if (bVar == null) {
                    }
                    bVar.f1288d = fragment;
                    bVar.f1289e = z;
                    bVar.f = aVar;
                    if (z2) {
                    }
                }
            }
            if (z2) {
                z6 = fragment.mIsNewlyAdded;
                z5 = false;
                z4 = false;
                z7 = z6;
                z3 = true;
                bVar = sparseArray.get(i);
                if (z7) {
                }
                bVar.f1288d = null;
                qVar = aVar.r;
                qVar.T(fragment);
                qVar.W(fragment, 1);
                if (bVar == null) {
                }
                bVar.f1288d = fragment;
                bVar.f1289e = z;
                bVar.f = aVar;
                if (z2) {
                }
            } else {
                if (!fragment.mAdded) {
                }
                z6 = false;
                z5 = false;
                z4 = false;
                z7 = z6;
                z3 = true;
                bVar = sparseArray.get(i);
                if (z7) {
                }
                bVar.f1288d = null;
                qVar = aVar.r;
                qVar.T(fragment);
                qVar.W(fragment, 1);
                if (bVar == null) {
                }
                bVar.f1288d = fragment;
                bVar.f1289e = z;
                bVar.f = aVar;
                if (z2) {
                }
            }
        }
    }

    public static void c(Fragment fragment, Fragment fragment2, boolean z, b.e.a<String, View> aVar, boolean z2) {
        if ((z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback()) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = aVar == null ? 0 : aVar.f829d;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(aVar.h(i2));
                arrayList.add(aVar.k(i2));
            }
            throw null;
        }
    }

    public static boolean d(l0 l0Var, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!l0Var.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static b.e.a<String, View> e(l0 l0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        n nVar;
        ArrayList<String> arrayList;
        Fragment fragment = bVar.f1285a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        b.e.a<String, View> aVar2 = new b.e.a<>();
        l0Var.i(aVar2, view);
        a aVar3 = bVar.f1287c;
        if (bVar.f1286b) {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.n;
        } else {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
            g.k(aVar2, aVar.values());
        }
        if (nVar == null) {
            int i = aVar.f829d;
            while (true) {
                i--;
                if (i < 0) {
                    return aVar2;
                }
                if (!aVar2.containsKey(aVar.k(i))) {
                    aVar.i(i);
                }
            }
        } else {
            throw null;
        }
    }

    public static b.e.a<String, View> f(l0 l0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        n nVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.f1288d;
        b.e.a<String, View> aVar2 = new b.e.a<>();
        l0Var.i(aVar2, fragment.requireView());
        a aVar3 = bVar.f;
        if (bVar.f1289e) {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.o;
        } else {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
        }
        if (nVar == null) {
            g.k(aVar, aVar2.keySet());
            return aVar2;
        }
        throw null;
    }

    public static l0 g(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (d(f1283b, arrayList)) {
            return f1283b;
        }
        l0 l0Var = f1284c;
        if (l0Var != null && d(l0Var, arrayList)) {
            return f1284c;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> h(l0 l0Var, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            l0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        l0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object i(l0 l0Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return l0Var.g(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    public static Object j(l0 l0Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return l0Var.g(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static View k(b.e.a<String, View> aVar, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a aVar2 = bVar.f1287c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.n : aVar2.o).get(0));
    }

    public static Object l(l0 l0Var, Fragment fragment, Fragment fragment2, boolean z) {
        return l0Var.w(l0Var.g(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    public static Object m(l0 l0Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? l0Var.m(obj2, obj, obj3) : l0Var.l(obj2, obj, obj3);
    }

    public static void n(l0 l0Var, Object obj, Object obj2, b.e.a<String, View> aVar, boolean z, a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
            l0Var.s(obj, view);
            if (obj2 != null) {
                l0Var.s(obj2, view);
            }
        }
    }

    public static void o(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:166:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0494 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0244 A[ADDED_TO_REGION] */
    public static void p(q qVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, a aVar) {
        SparseArray sparseArray;
        int i3;
        int i4;
        int i5;
        int i6;
        Fragment fragment;
        Fragment fragment2;
        l0 g;
        ArrayList<View> arrayList3;
        Object obj;
        ArrayList<View> arrayList4;
        Fragment fragment3;
        Fragment fragment4;
        Object obj2;
        Object obj3;
        b.e.a aVar2;
        Object m;
        Object obj4;
        Fragment fragment5;
        boolean z2;
        ArrayList<View> arrayList5;
        Fragment fragment6;
        Rect rect;
        Fragment fragment7;
        Fragment fragment8;
        l0 g2;
        ArrayList<View> arrayList6;
        b.e.a aVar3;
        Fragment fragment9;
        boolean z3;
        Object obj5;
        Object m2;
        b.e.a aVar4;
        Object obj6;
        Rect rect2;
        View view;
        q qVar2 = qVar;
        ArrayList<a> arrayList7 = arrayList;
        ArrayList<Boolean> arrayList8 = arrayList2;
        int i7 = i2;
        boolean z4 = z;
        if (qVar2.m >= 1) {
            SparseArray sparseArray2 = new SparseArray();
            for (int i8 = i; i8 < i7; i8++) {
                a aVar5 = arrayList7.get(i8);
                if (!arrayList8.get(i8).booleanValue()) {
                    int size = aVar5.f1365a.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        b(aVar5, aVar5.f1365a.get(i9), sparseArray2, false, z4);
                    }
                } else if (aVar5.r.o.b()) {
                    for (int size2 = aVar5.f1365a.size() - 1; size2 >= 0; size2--) {
                        b(aVar5, aVar5.f1365a.get(size2), sparseArray2, true, z4);
                    }
                }
            }
            if (sparseArray2.size() != 0) {
                View view2 = new View(qVar2.n.f1321c);
                int size3 = sparseArray2.size();
                int i10 = 0;
                while (i10 < size3) {
                    int keyAt = sparseArray2.keyAt(i10);
                    b.e.a aVar6 = new b.e.a();
                    int i11 = i7 - 1;
                    while (i11 >= i) {
                        a aVar7 = arrayList7.get(i11);
                        if (aVar7.q(keyAt)) {
                            boolean booleanValue = arrayList8.get(i11).booleanValue();
                            ArrayList<String> arrayList9 = aVar7.n;
                            if (arrayList9 != null) {
                                ArrayList<String> arrayList10 = aVar7.n;
                                ArrayList<String> arrayList11 = aVar7.o;
                                if (!booleanValue) {
                                    arrayList11 = arrayList10;
                                    arrayList10 = arrayList11;
                                }
                                int i12 = 0;
                                for (int size4 = arrayList9.size(); i12 < size4; size4 = size4) {
                                    String str = arrayList11.get(i12);
                                    String str2 = arrayList10.get(i12);
                                    String str3 = (String) aVar6.remove(str2);
                                    if (str3 != null) {
                                        aVar6.put(str, str3);
                                    } else {
                                        aVar6.put(str, str2);
                                    }
                                    i12++;
                                }
                            }
                        }
                        i11--;
                        arrayList7 = arrayList;
                        arrayList8 = arrayList2;
                    }
                    b bVar = (b) sparseArray2.valueAt(i10);
                    if (z4) {
                        ViewGroup viewGroup = qVar2.o.b() ? (ViewGroup) qVar2.o.a(keyAt) : null;
                        if (viewGroup == null || (g2 = g((fragment8 = bVar.f1288d), (fragment7 = bVar.f1285a))) == null) {
                            sparseArray = sparseArray2;
                            i6 = i10;
                            i5 = size3;
                        } else {
                            boolean z5 = bVar.f1286b;
                            boolean z6 = bVar.f1289e;
                            ArrayList<View> arrayList12 = new ArrayList<>();
                            ArrayList<View> arrayList13 = new ArrayList<>();
                            sparseArray = sparseArray2;
                            Object i13 = i(g2, fragment7, z5);
                            Object j = j(g2, fragment8, z6);
                            Fragment fragment10 = bVar.f1285a;
                            i6 = i10;
                            Fragment fragment11 = bVar.f1288d;
                            i5 = size3;
                            if (fragment10 != null) {
                                fragment10.requireView().setVisibility(0);
                            }
                            if (fragment10 == null || fragment11 == null) {
                                arrayList6 = arrayList12;
                                fragment9 = fragment7;
                                z3 = z5;
                            } else {
                                boolean z7 = bVar.f1286b;
                                if (aVar6.isEmpty()) {
                                    z3 = z5;
                                    obj6 = null;
                                } else {
                                    obj6 = l(g2, fragment10, fragment11, z7);
                                    z3 = z5;
                                }
                                b.e.a<String, View> f = f(g2, aVar6, obj6, bVar);
                                fragment9 = fragment7;
                                b.e.a<String, View> e2 = e(g2, aVar6, obj6, bVar);
                                if (aVar6.isEmpty()) {
                                    if (f != null) {
                                        f.clear();
                                    }
                                    if (e2 != null) {
                                        e2.clear();
                                    }
                                    obj5 = null;
                                } else {
                                    a(arrayList13, f, aVar6.keySet());
                                    a(arrayList12, e2, aVar6.values());
                                    obj5 = obj6;
                                }
                                if (i13 == null && j == null && obj5 == null) {
                                    arrayList6 = arrayList12;
                                } else {
                                    aVar3 = aVar6;
                                    c(fragment10, fragment11, z7, f, true);
                                    if (obj5 != null) {
                                        arrayList12.add(view2);
                                        g2.u(obj5, view2, arrayList13);
                                        arrayList6 = arrayList12;
                                        n(g2, obj5, j, f, bVar.f1289e, bVar.f);
                                        Rect rect3 = new Rect();
                                        View k = k(e2, bVar, i13, z7);
                                        if (k != null) {
                                            g2.r(i13, rect3);
                                        }
                                        view = k;
                                        rect2 = rect3;
                                    } else {
                                        arrayList6 = arrayList12;
                                        view = null;
                                        rect2 = null;
                                    }
                                    k.a(viewGroup, new e0(fragment10, fragment11, z7, e2, view, g2, rect2));
                                    if (!(i13 == null && obj5 == null && j == null)) {
                                        ArrayList<View> h = h(g2, j, fragment8, arrayList13, view2);
                                        ArrayList<View> h2 = h(g2, i13, fragment9, arrayList6, view2);
                                        o(h2, 4);
                                        m2 = m(g2, i13, j, obj5, fragment9, z3);
                                        if (!(fragment8 == null || h == null || (h.size() <= 0 && arrayList13.size() <= 0))) {
                                            b.i.h.a aVar8 = new b.i.h.a();
                                            q.b bVar2 = (q.b) aVar;
                                            bVar2.b(fragment8, aVar8);
                                            g2.t(fragment8, m2, aVar8, new a0(bVar2, fragment8, aVar8));
                                        }
                                        if (m2 != null) {
                                            if (fragment8 != null && j != null && fragment8.mAdded && fragment8.mHidden && fragment8.mHiddenChanged) {
                                                fragment8.setHideReplaced(true);
                                                g2.p(j, fragment8.getView(), h);
                                                k.a(fragment8.mContainer, new b0(h));
                                            }
                                            ArrayList arrayList14 = new ArrayList();
                                            int size5 = arrayList6.size();
                                            for (int i14 = 0; i14 < size5; i14++) {
                                                View view3 = arrayList6.get(i14);
                                                arrayList14.add(m.u(view3));
                                                view3.setTransitionName(null);
                                            }
                                            g2.q(m2, i13, h2, j, h, obj5, arrayList6);
                                            g2.c(viewGroup, m2);
                                            int size6 = arrayList6.size();
                                            ArrayList arrayList15 = new ArrayList();
                                            int i15 = 0;
                                            while (i15 < size6) {
                                                View view4 = arrayList13.get(i15);
                                                String u = m.u(view4);
                                                arrayList15.add(u);
                                                if (u == null) {
                                                    aVar4 = aVar3;
                                                } else {
                                                    view4.setTransitionName(null);
                                                    aVar4 = aVar3;
                                                    String str4 = (String) aVar4.getOrDefault(u, null);
                                                    int i16 = 0;
                                                    while (true) {
                                                        if (i16 >= size6) {
                                                            break;
                                                        } else if (str4.equals(arrayList14.get(i16))) {
                                                            arrayList6.get(i16).setTransitionName(u);
                                                            break;
                                                        } else {
                                                            i16++;
                                                        }
                                                    }
                                                }
                                                i15++;
                                                aVar3 = aVar4;
                                            }
                                            k.a(viewGroup, new i0(g2, size6, arrayList6, arrayList14, arrayList13, arrayList15));
                                            o(h2, 0);
                                            g2.v(obj5, arrayList13, arrayList6);
                                        }
                                    }
                                }
                            }
                            aVar3 = aVar6;
                            obj5 = null;
                            ArrayList<View> h3 = h(g2, j, fragment8, arrayList13, view2);
                            ArrayList<View> h22 = h(g2, i13, fragment9, arrayList6, view2);
                            o(h22, 4);
                            m2 = m(g2, i13, j, obj5, fragment9, z3);
                            b.i.h.a aVar82 = new b.i.h.a();
                            q.b bVar22 = (q.b) aVar;
                            bVar22.b(fragment8, aVar82);
                            g2.t(fragment8, m2, aVar82, new a0(bVar22, fragment8, aVar82));
                            if (m2 != null) {
                            }
                        }
                    } else {
                        sparseArray = sparseArray2;
                        i6 = i10;
                        i5 = size3;
                        ViewGroup viewGroup2 = qVar2.o.b() ? (ViewGroup) qVar2.o.a(keyAt) : null;
                        if (!(viewGroup2 == null || (g = g((fragment2 = bVar.f1288d), (fragment = bVar.f1285a))) == null)) {
                            boolean z8 = bVar.f1286b;
                            boolean z9 = bVar.f1289e;
                            Object i17 = i(g, fragment, z8);
                            Object j2 = j(g, fragment2, z9);
                            ArrayList<View> arrayList16 = new ArrayList<>();
                            ArrayList<View> arrayList17 = new ArrayList<>();
                            Fragment fragment12 = bVar.f1285a;
                            Fragment fragment13 = bVar.f1288d;
                            if (!(fragment12 == null || fragment13 == null)) {
                                boolean z10 = bVar.f1286b;
                                Object l = aVar6.isEmpty() ? null : l(g, fragment12, fragment13, z10);
                                b.e.a<String, View> f2 = f(g, aVar6, l, bVar);
                                if (aVar6.isEmpty()) {
                                    obj4 = null;
                                } else {
                                    arrayList16.addAll(f2.values());
                                    obj4 = l;
                                }
                                if (!(i17 == null && j2 == null && obj4 == null)) {
                                    fragment4 = fragment;
                                    c(fragment12, fragment13, z10, f2, true);
                                    if (obj4 != null) {
                                        rect = new Rect();
                                        g.u(obj4, view2, arrayList16);
                                        fragment6 = fragment12;
                                        arrayList5 = arrayList17;
                                        z2 = z10;
                                        fragment5 = fragment13;
                                        n(g, obj4, j2, f2, bVar.f1289e, bVar.f);
                                        if (i17 != null) {
                                            g.r(i17, rect);
                                        }
                                    } else {
                                        fragment6 = fragment12;
                                        arrayList5 = arrayList17;
                                        z2 = z10;
                                        fragment5 = fragment13;
                                        rect = null;
                                    }
                                    fragment3 = fragment2;
                                    obj3 = j2;
                                    aVar2 = aVar6;
                                    arrayList4 = arrayList16;
                                    i4 = i6;
                                    obj = null;
                                    arrayList3 = arrayList5;
                                    i3 = i5;
                                    k.a(viewGroup2, new f0(g, aVar6, obj4, bVar, arrayList5, view2, fragment6, fragment5, z2, arrayList4, i17, rect));
                                    obj2 = obj4;
                                    if (i17 != null && obj2 == null && obj3 == null) {
                                        i10 = i4 + 1;
                                        qVar2 = qVar;
                                        arrayList7 = arrayList;
                                        arrayList8 = arrayList2;
                                        i7 = i2;
                                        z4 = z;
                                        size3 = i3;
                                        sparseArray2 = sparseArray;
                                    } else {
                                        ArrayList<View> h4 = h(g, obj3, fragment3, arrayList4, view2);
                                        if (h4 != null && !h4.isEmpty()) {
                                            obj = obj3;
                                        }
                                        g.a(i17, view2);
                                        m = m(g, i17, obj, obj2, fragment4, bVar.f1286b);
                                        if (!(fragment3 == null || h4 == null || (h4.size() <= 0 && arrayList4.size() <= 0))) {
                                            b.i.h.a aVar9 = new b.i.h.a();
                                            q.b bVar3 = (q.b) aVar;
                                            bVar3.b(fragment3, aVar9);
                                            g.t(fragment3, m, aVar9, new c0(bVar3, fragment3, aVar9));
                                        }
                                        if (m == null) {
                                            ArrayList<View> arrayList18 = new ArrayList<>();
                                            g.q(m, i17, arrayList18, obj, h4, obj2, arrayList3);
                                            k.a(viewGroup2, new d0(i17, g, view2, fragment4, arrayList3, arrayList18, h4, obj));
                                            k.a(viewGroup2, new j0(g, arrayList3, aVar2));
                                            g.c(viewGroup2, m);
                                            k.a(viewGroup2, new k0(g, arrayList3, aVar2));
                                        }
                                        i10 = i4 + 1;
                                        qVar2 = qVar;
                                        arrayList7 = arrayList;
                                        arrayList8 = arrayList2;
                                        i7 = i2;
                                        z4 = z;
                                        size3 = i3;
                                        sparseArray2 = sparseArray;
                                    }
                                }
                            }
                            fragment4 = fragment;
                            fragment3 = fragment2;
                            arrayList4 = arrayList16;
                            obj3 = j2;
                            aVar2 = aVar6;
                            i4 = i6;
                            i3 = i5;
                            obj = null;
                            arrayList3 = arrayList17;
                            obj2 = null;
                            if (i17 != null) {
                            }
                            ArrayList<View> h42 = h(g, obj3, fragment3, arrayList4, view2);
                            obj = obj3;
                            g.a(i17, view2);
                            m = m(g, i17, obj, obj2, fragment4, bVar.f1286b);
                            b.i.h.a aVar92 = new b.i.h.a();
                            q.b bVar32 = (q.b) aVar;
                            bVar32.b(fragment3, aVar92);
                            g.t(fragment3, m, aVar92, new c0(bVar32, fragment3, aVar92));
                            if (m == null) {
                            }
                            i10 = i4 + 1;
                            qVar2 = qVar;
                            arrayList7 = arrayList;
                            arrayList8 = arrayList2;
                            i7 = i2;
                            z4 = z;
                            size3 = i3;
                            sparseArray2 = sparseArray;
                        }
                    }
                    i4 = i6;
                    i3 = i5;
                    i10 = i4 + 1;
                    qVar2 = qVar;
                    arrayList7 = arrayList;
                    arrayList8 = arrayList2;
                    i7 = i2;
                    z4 = z;
                    size3 = i3;
                    sparseArray2 = sparseArray;
                }
            }
        }
    }
}
