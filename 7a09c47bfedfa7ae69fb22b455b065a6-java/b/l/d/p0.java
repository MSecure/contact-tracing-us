package b.l.d;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.e.g;
import b.i.d.o;
import b.i.l.k;
import b.i.l.m;
import b.l.d.i0;
import b.l.d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2096a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    public static final r0 f2097b = new q0();

    /* renamed from: c  reason: collision with root package name */
    public static final r0 f2098c;

    public interface a {
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f2099a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2100b;

        /* renamed from: c  reason: collision with root package name */
        public a f2101c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f2102d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2103e;

        /* renamed from: f  reason: collision with root package name */
        public a f2104f;
    }

    static {
        r0 r0Var;
        try {
            r0Var = (r0) Class.forName("b.x.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            r0Var = null;
        }
        f2098c = r0Var;
    }

    public static void a(ArrayList<View> arrayList, b.e.a<String, View> aVar, Collection<String> collection) {
        for (int i = aVar.f1413d - 1; i >= 0; i--) {
            View k = aVar.k(i);
            if (collection.contains(m.v(k))) {
                arrayList.add(k);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0075, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0086, code lost:
        if (r0.mHidden == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0088, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static void b(a aVar, i0.a aVar2, SparseArray<b> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        b bVar;
        boolean z5;
        Fragment fragment = aVar2.f2043b;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            int i2 = z ? f2096a[aVar2.f2042a] : aVar2.f2042a;
            boolean z6 = false;
            boolean z7 = true;
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    z3 = false;
                                    z7 = false;
                                    z4 = false;
                                    bVar = sparseArray.get(i);
                                    if (z6) {
                                        if (bVar == null) {
                                            b bVar2 = new b();
                                            sparseArray.put(i, bVar2);
                                            bVar = bVar2;
                                        }
                                        bVar.f2099a = fragment;
                                        bVar.f2100b = z;
                                        bVar.f2101c = aVar;
                                    }
                                    if (!z2 && z7) {
                                        if (bVar != null && bVar.f2102d == fragment) {
                                            bVar.f2102d = null;
                                        }
                                        if (!aVar.p) {
                                            z zVar = aVar.r;
                                            zVar.f2180c.j(zVar.i(fragment));
                                            zVar.V(fragment, zVar.p);
                                        }
                                    }
                                    if (z3 && (bVar == null || bVar.f2102d == null)) {
                                        if (bVar == null) {
                                            b bVar3 = new b();
                                            sparseArray.put(i, bVar3);
                                            bVar = bVar3;
                                        }
                                        bVar.f2102d = fragment;
                                        bVar.f2103e = z;
                                        bVar.f2104f = aVar;
                                    }
                                    if (z2 && z4 && bVar != null && bVar.f2099a == fragment) {
                                        bVar.f2099a = null;
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
                            z5 = false;
                            z4 = false;
                            z6 = z5;
                            z3 = false;
                            bVar = sparseArray.get(i);
                            if (z6) {
                            }
                            bVar.f2102d = null;
                            if (!aVar.p) {
                            }
                            if (bVar == null) {
                            }
                            bVar.f2102d = fragment;
                            bVar.f2103e = z;
                            bVar.f2104f = aVar;
                            if (z2) {
                                return;
                            }
                            return;
                        } else {
                            z5 = fragment.mHidden;
                            z4 = false;
                            z6 = z5;
                            z3 = false;
                            bVar = sparseArray.get(i);
                            if (z6) {
                            }
                            bVar.f2102d = null;
                            if (!aVar.p) {
                            }
                            if (bVar == null) {
                            }
                            bVar.f2102d = fragment;
                            bVar.f2103e = z;
                            bVar.f2104f = aVar;
                            if (z2) {
                            }
                        }
                    } else if (!z2) {
                        z3 = false;
                        z4 = true;
                        z7 = false;
                        bVar = sparseArray.get(i);
                        if (z6) {
                        }
                        bVar.f2102d = null;
                        if (!aVar.p) {
                        }
                        if (bVar == null) {
                        }
                        bVar.f2102d = fragment;
                        bVar.f2103e = z;
                        bVar.f2104f = aVar;
                        if (z2) {
                        }
                    } else {
                        z3 = false;
                        z4 = true;
                        z7 = false;
                        bVar = sparseArray.get(i);
                        if (z6) {
                        }
                        bVar.f2102d = null;
                        if (!aVar.p) {
                        }
                        if (bVar == null) {
                        }
                        bVar.f2102d = fragment;
                        bVar.f2103e = z;
                        bVar.f2104f = aVar;
                        if (z2) {
                        }
                    }
                }
                boolean z8 = fragment.mAdded;
                if (!z2) {
                    z3 = false;
                    z4 = true;
                    z7 = false;
                    bVar = sparseArray.get(i);
                    if (z6) {
                    }
                    bVar.f2102d = null;
                    if (!aVar.p) {
                    }
                    if (bVar == null) {
                    }
                    bVar.f2102d = fragment;
                    bVar.f2103e = z;
                    bVar.f2104f = aVar;
                    if (z2) {
                    }
                } else {
                    z3 = false;
                    z4 = true;
                    z7 = false;
                    bVar = sparseArray.get(i);
                    if (z6) {
                    }
                    bVar.f2102d = null;
                    if (!aVar.p) {
                    }
                    if (bVar == null) {
                    }
                    bVar.f2102d = fragment;
                    bVar.f2103e = z;
                    bVar.f2104f = aVar;
                    if (z2) {
                    }
                }
            }
            if (z2) {
                z5 = fragment.mIsNewlyAdded;
                z4 = false;
                z6 = z5;
                z3 = false;
                bVar = sparseArray.get(i);
                if (z6) {
                }
                bVar.f2102d = null;
                if (!aVar.p) {
                }
                if (bVar == null) {
                }
                bVar.f2102d = fragment;
                bVar.f2103e = z;
                bVar.f2104f = aVar;
                if (z2) {
                }
            } else {
                if (!fragment.mAdded) {
                }
                z5 = false;
                z4 = false;
                z6 = z5;
                z3 = false;
                bVar = sparseArray.get(i);
                if (z6) {
                }
                bVar.f2102d = null;
                if (!aVar.p) {
                }
                if (bVar == null) {
                }
                bVar.f2102d = fragment;
                bVar.f2103e = z;
                bVar.f2104f = aVar;
                if (z2) {
                }
            }
        }
    }

    public static void c(Fragment fragment, Fragment fragment2, boolean z, b.e.a<String, View> aVar, boolean z2) {
        if ((z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback()) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = aVar == null ? 0 : aVar.f1413d;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(aVar.h(i2));
                arrayList.add(aVar.k(i2));
            }
            throw null;
        }
    }

    public static boolean d(r0 r0Var, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!r0Var.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static b.e.a<String, View> e(r0 r0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        o oVar;
        ArrayList<String> arrayList;
        Fragment fragment = bVar.f2099a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        b.e.a<String, View> aVar2 = new b.e.a<>();
        r0Var.i(aVar2, view);
        a aVar3 = bVar.f2101c;
        if (bVar.f2100b) {
            oVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.n;
        } else {
            oVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
            g.k(aVar2, aVar.values());
        }
        if (oVar == null) {
            n(aVar, aVar2);
            return aVar2;
        }
        throw null;
    }

    public static b.e.a<String, View> f(r0 r0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        o oVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.f2102d;
        b.e.a<String, View> aVar2 = new b.e.a<>();
        r0Var.i(aVar2, fragment.requireView());
        a aVar3 = bVar.f2104f;
        if (bVar.f2103e) {
            oVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.o;
        } else {
            oVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
        }
        if (oVar == null) {
            g.k(aVar, aVar2.keySet());
            return aVar2;
        }
        throw null;
    }

    public static r0 g(Fragment fragment, Fragment fragment2) {
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
        if (d(f2097b, arrayList)) {
            return f2097b;
        }
        r0 r0Var = f2098c;
        if (r0Var != null && d(r0Var, arrayList)) {
            return f2098c;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> h(r0 r0Var, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            r0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        r0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object i(r0 r0Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return r0Var.g(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    public static Object j(r0 r0Var, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return r0Var.g(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static View k(b.e.a<String, View> aVar, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a aVar2 = bVar.f2101c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.n : aVar2.o).get(0));
    }

    public static Object l(r0 r0Var, Fragment fragment, Fragment fragment2, boolean z) {
        return r0Var.y(r0Var.g(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    public static Object m(r0 r0Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? r0Var.m(obj2, obj, obj3) : r0Var.l(obj2, obj, obj3);
    }

    public static void n(b.e.a<String, String> aVar, b.e.a<String, View> aVar2) {
        int i = aVar.f1413d;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            if (!aVar2.containsKey(aVar.k(i))) {
                aVar.i(i);
            }
        }
    }

    public static void o(r0 r0Var, Object obj, Object obj2, b.e.a<String, View> aVar, boolean z, a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
            r0Var.t(obj, view);
            if (obj2 != null) {
                r0Var.t(obj2, view);
            }
        }
    }

    public static void p(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0426 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x023c A[ADDED_TO_REGION] */
    public static void q(Context context, s sVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, a aVar) {
        int i3;
        SparseArray sparseArray;
        int i4;
        int i5;
        ViewGroup viewGroup;
        int i6;
        int i7;
        b.e.a aVar2;
        Fragment fragment;
        b bVar;
        ArrayList<View> arrayList3;
        Object obj;
        Fragment fragment2;
        ArrayList<View> arrayList4;
        r0 r0Var;
        Object obj2;
        Object obj3;
        Object m;
        Object obj4;
        b.e.a aVar3;
        Object obj5;
        Object obj6;
        Fragment fragment3;
        boolean z2;
        b.e.a aVar4;
        Fragment fragment4;
        Rect rect;
        ArrayList<View> arrayList5;
        b.e.a aVar5;
        Fragment fragment5;
        boolean z3;
        Object obj7;
        Object m2;
        Object obj8;
        Object obj9;
        Rect rect2;
        View view;
        ArrayList<String> arrayList6;
        ArrayList<String> arrayList7;
        ArrayList<a> arrayList8 = arrayList;
        ArrayList<Boolean> arrayList9 = arrayList2;
        int i8 = i2;
        boolean z4 = z;
        SparseArray sparseArray2 = new SparseArray();
        int i9 = i;
        while (true) {
            i3 = 0;
            if (i9 >= i8) {
                break;
            }
            a aVar6 = arrayList8.get(i9);
            if (!arrayList9.get(i9).booleanValue()) {
                int size = aVar6.f2035a.size();
                for (int i10 = 0; i10 < size; i10++) {
                    b(aVar6, aVar6.f2035a.get(i10), sparseArray2, false, z4);
                }
            } else if (aVar6.r.r.c()) {
                for (int size2 = aVar6.f2035a.size() - 1; size2 >= 0; size2--) {
                    b(aVar6, aVar6.f2035a.get(size2), sparseArray2, true, z4);
                }
            }
            i9++;
        }
        if (sparseArray2.size() != 0) {
            View view2 = new View(context);
            int size3 = sparseArray2.size();
            int i11 = 0;
            while (i11 < size3) {
                int keyAt = sparseArray2.keyAt(i11);
                b.e.a aVar7 = new b.e.a();
                int i12 = i8 - 1;
                while (i12 >= i) {
                    a aVar8 = arrayList8.get(i12);
                    if (aVar8.p(keyAt)) {
                        boolean booleanValue = arrayList9.get(i12).booleanValue();
                        ArrayList<String> arrayList10 = aVar8.n;
                        if (arrayList10 != null) {
                            int size4 = arrayList10.size();
                            if (booleanValue) {
                                arrayList6 = aVar8.n;
                                arrayList7 = aVar8.o;
                            } else {
                                ArrayList<String> arrayList11 = aVar8.n;
                                arrayList6 = aVar8.o;
                                arrayList7 = arrayList11;
                            }
                            while (i3 < size4) {
                                String str = arrayList7.get(i3);
                                String str2 = arrayList6.get(i3);
                                String str3 = (String) aVar7.remove(str2);
                                if (str3 != null) {
                                    aVar7.put(str, str3);
                                } else {
                                    aVar7.put(str, str2);
                                }
                                i3++;
                            }
                        }
                    }
                    i12--;
                    arrayList8 = arrayList;
                    arrayList9 = arrayList2;
                    i3 = 0;
                }
                b bVar2 = (b) sparseArray2.valueAt(i11);
                if (!sVar.c() || (viewGroup = (ViewGroup) sVar.b(keyAt)) == null) {
                    sparseArray = sparseArray2;
                    i5 = i11;
                    i4 = size3;
                } else {
                    if (z4) {
                        Fragment fragment6 = bVar2.f2099a;
                        Fragment fragment7 = bVar2.f2102d;
                        r0 g2 = g(fragment7, fragment6);
                        if (g2 == null) {
                            sparseArray = sparseArray2;
                            i7 = i11;
                            i6 = size3;
                        } else {
                            boolean z5 = bVar2.f2100b;
                            boolean z6 = bVar2.f2103e;
                            ArrayList<View> arrayList12 = new ArrayList<>();
                            ArrayList<View> arrayList13 = new ArrayList<>();
                            Object i13 = i(g2, fragment6, z5);
                            Object j = j(g2, fragment7, z6);
                            sparseArray = sparseArray2;
                            Fragment fragment8 = bVar2.f2099a;
                            Fragment fragment9 = bVar2.f2102d;
                            i7 = i11;
                            if (fragment8 != null) {
                                i6 = size3;
                                fragment8.requireView().setVisibility(0);
                            } else {
                                i6 = size3;
                            }
                            if (fragment8 == null || fragment9 == null) {
                                arrayList5 = arrayList12;
                                fragment5 = fragment6;
                                z3 = z5;
                            } else {
                                boolean z7 = bVar2.f2100b;
                                if (aVar7.isEmpty()) {
                                    z3 = z5;
                                    obj8 = null;
                                } else {
                                    obj8 = l(g2, fragment8, fragment9, z7);
                                    z3 = z5;
                                }
                                b.e.a<String, View> f2 = f(g2, aVar7, obj8, bVar2);
                                fragment5 = fragment6;
                                b.e.a<String, View> e2 = e(g2, aVar7, obj8, bVar2);
                                if (aVar7.isEmpty()) {
                                    if (f2 != null) {
                                        f2.clear();
                                    }
                                    if (e2 != null) {
                                        e2.clear();
                                    }
                                    obj9 = null;
                                } else {
                                    a(arrayList13, f2, aVar7.keySet());
                                    a(arrayList12, e2, aVar7.values());
                                    obj9 = obj8;
                                }
                                if (i13 == null && j == null && obj9 == null) {
                                    arrayList5 = arrayList12;
                                } else {
                                    aVar5 = aVar7;
                                    c(fragment8, fragment9, z7, f2, true);
                                    if (obj9 != null) {
                                        arrayList12.add(view2);
                                        g2.w(obj9, view2, arrayList13);
                                        arrayList5 = arrayList12;
                                        o(g2, obj9, j, f2, bVar2.f2103e, bVar2.f2104f);
                                        Rect rect3 = new Rect();
                                        View k = k(e2, bVar2, i13, z7);
                                        if (k != null) {
                                            g2.s(i13, rect3);
                                        }
                                        view = k;
                                        rect2 = rect3;
                                    } else {
                                        arrayList5 = arrayList12;
                                        view = null;
                                        rect2 = null;
                                    }
                                    k.a(viewGroup, new n0(fragment8, fragment9, z7, e2, view, g2, rect2));
                                    obj7 = obj9;
                                    if (!(i13 == null && obj7 == null && j == null)) {
                                        ArrayList<View> h = h(g2, j, fragment7, arrayList13, view2);
                                        ArrayList<View> h2 = h(g2, i13, fragment5, arrayList5, view2);
                                        p(h2, 4);
                                        m2 = m(g2, i13, j, obj7, fragment5, z3);
                                        if (!(fragment7 == null || h == null || (h.size() <= 0 && arrayList13.size() <= 0))) {
                                            b.i.h.a aVar9 = new b.i.h.a();
                                            z.d dVar = (z.d) aVar;
                                            dVar.b(fragment7, aVar9);
                                            g2.u(fragment7, m2, aVar9, new j0(dVar, fragment7, aVar9));
                                        }
                                        if (m2 != null) {
                                            if (fragment7 != null && j != null && fragment7.mAdded && fragment7.mHidden && fragment7.mHiddenChanged) {
                                                fragment7.setHideReplaced(true);
                                                g2.q(j, fragment7.getView(), h);
                                                k.a(fragment7.mContainer, new k0(h));
                                            }
                                            ArrayList<String> n = g2.n(arrayList5);
                                            g2.r(m2, i13, h2, j, h, obj7, arrayList5);
                                            g2.c(viewGroup, m2);
                                            g2.v(viewGroup, arrayList13, arrayList5, n, aVar5);
                                            p(h2, 0);
                                            g2.x(obj7, arrayList13, arrayList5);
                                        }
                                    }
                                }
                            }
                            aVar5 = aVar7;
                            obj7 = null;
                            ArrayList<View> h3 = h(g2, j, fragment7, arrayList13, view2);
                            ArrayList<View> h22 = h(g2, i13, fragment5, arrayList5, view2);
                            p(h22, 4);
                            m2 = m(g2, i13, j, obj7, fragment5, z3);
                            b.i.h.a aVar92 = new b.i.h.a();
                            z.d dVar2 = (z.d) aVar;
                            dVar2.b(fragment7, aVar92);
                            g2.u(fragment7, m2, aVar92, new j0(dVar2, fragment7, aVar92));
                            if (m2 != null) {
                            }
                        }
                    } else {
                        sparseArray = sparseArray2;
                        i7 = i11;
                        i6 = size3;
                        Fragment fragment10 = bVar2.f2099a;
                        Fragment fragment11 = bVar2.f2102d;
                        r0 g3 = g(fragment11, fragment10);
                        if (g3 != null) {
                            boolean z8 = bVar2.f2100b;
                            boolean z9 = bVar2.f2103e;
                            Object i14 = i(g3, fragment10, z8);
                            Object j2 = j(g3, fragment11, z9);
                            ArrayList<View> arrayList14 = new ArrayList<>();
                            ArrayList<View> arrayList15 = new ArrayList<>();
                            Fragment fragment12 = bVar2.f2099a;
                            Fragment fragment13 = bVar2.f2102d;
                            if (fragment12 == null || fragment13 == null) {
                                bVar = bVar2;
                                fragment2 = fragment10;
                                fragment = fragment11;
                                arrayList3 = arrayList15;
                                arrayList4 = arrayList14;
                                obj3 = j2;
                                obj4 = i14;
                                r0Var = g3;
                                i5 = i7;
                                i4 = i6;
                                aVar2 = aVar7;
                            } else {
                                boolean z10 = bVar2.f2100b;
                                if (aVar7.isEmpty()) {
                                    aVar3 = aVar7;
                                    obj5 = null;
                                } else {
                                    obj5 = l(g3, fragment12, fragment13, z10);
                                    aVar3 = aVar7;
                                }
                                b.e.a<String, View> f3 = f(g3, aVar3, obj5, bVar2);
                                if (aVar3.isEmpty()) {
                                    obj6 = null;
                                } else {
                                    arrayList14.addAll(f3.values());
                                    obj6 = obj5;
                                }
                                if (i14 == null && j2 == null && obj6 == null) {
                                    bVar = bVar2;
                                    fragment2 = fragment10;
                                    fragment = fragment11;
                                    aVar2 = aVar3;
                                    arrayList3 = arrayList15;
                                    arrayList4 = arrayList14;
                                    obj3 = j2;
                                    obj4 = i14;
                                    r0Var = g3;
                                    i5 = i7;
                                    i4 = i6;
                                } else {
                                    fragment2 = fragment10;
                                    c(fragment12, fragment13, z10, f3, true);
                                    if (obj6 != null) {
                                        rect = new Rect();
                                        g3.w(obj6, view2, arrayList14);
                                        obj = obj6;
                                        aVar4 = aVar3;
                                        z2 = z10;
                                        fragment3 = fragment13;
                                        fragment4 = fragment12;
                                        arrayList3 = arrayList15;
                                        o(g3, obj, j2, f3, bVar2.f2103e, bVar2.f2104f);
                                        if (i14 != null) {
                                            g3.s(i14, rect);
                                        }
                                    } else {
                                        obj = obj6;
                                        aVar4 = aVar3;
                                        z2 = z10;
                                        fragment3 = fragment13;
                                        fragment4 = fragment12;
                                        arrayList3 = arrayList15;
                                        rect = null;
                                    }
                                    arrayList4 = arrayList14;
                                    bVar = bVar2;
                                    obj3 = j2;
                                    aVar2 = aVar4;
                                    i5 = i7;
                                    fragment = fragment11;
                                    r0Var = g3;
                                    i4 = i6;
                                    k.a(viewGroup, new o0(g3, aVar4, obj, bVar2, arrayList3, view2, fragment4, fragment3, z2, arrayList4, i14, rect));
                                    obj2 = i14;
                                    if (obj2 == null || obj != null || obj3 != null) {
                                        ArrayList<View> h4 = h(r0Var, obj3, fragment, arrayList4, view2);
                                        if (h4 == null || h4.isEmpty()) {
                                            obj3 = null;
                                        }
                                        r0Var.a(obj2, view2);
                                        m = m(r0Var, obj2, obj3, obj, fragment2, bVar.f2100b);
                                        if (!(fragment == null || h4 == null || (h4.size() <= 0 && arrayList4.size() <= 0))) {
                                            b.i.h.a aVar10 = new b.i.h.a();
                                            z.d dVar3 = (z.d) aVar;
                                            dVar3.b(fragment, aVar10);
                                            r0Var.u(fragment, m, aVar10, new l0(dVar3, fragment, aVar10));
                                        }
                                        if (m == null) {
                                            ArrayList<View> arrayList16 = new ArrayList<>();
                                            r0Var.r(m, obj2, arrayList16, obj3, h4, obj, arrayList3);
                                            k.a(viewGroup, new m0(obj2, r0Var, view2, fragment2, arrayList3, arrayList16, h4, obj3));
                                            k.a(viewGroup, new s0(r0Var, arrayList3, aVar2));
                                            r0Var.c(viewGroup, m);
                                            k.a(viewGroup, new t0(r0Var, arrayList3, aVar2));
                                        }
                                    }
                                }
                            }
                            obj2 = obj4;
                            obj = null;
                            if (obj2 == null) {
                            }
                            ArrayList<View> h42 = h(r0Var, obj3, fragment, arrayList4, view2);
                            obj3 = null;
                            r0Var.a(obj2, view2);
                            m = m(r0Var, obj2, obj3, obj, fragment2, bVar.f2100b);
                            b.i.h.a aVar102 = new b.i.h.a();
                            z.d dVar32 = (z.d) aVar;
                            dVar32.b(fragment, aVar102);
                            r0Var.u(fragment, m, aVar102, new l0(dVar32, fragment, aVar102));
                            if (m == null) {
                            }
                        }
                    }
                    i5 = i7;
                    i4 = i6;
                }
                i11 = i5 + 1;
                arrayList8 = arrayList;
                arrayList9 = arrayList2;
                i8 = i2;
                z4 = z;
                size3 = i4;
                sparseArray2 = sparseArray;
                i3 = 0;
            }
        }
    }
}
