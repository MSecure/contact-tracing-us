package e.m.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import e.e.g;
import e.i.i.l;
import e.i.i.m;
import e.m.a.e0;
import e.m.a.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class t0 {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final v0 b = new u0();
    public static final v0 c;

    public interface a {
    }

    public static class b {
        public m a;
        public boolean b;
        public a c;

        /* renamed from: d  reason: collision with root package name */
        public m f1511d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1512e;

        /* renamed from: f  reason: collision with root package name */
        public a f1513f;
    }

    static {
        v0 v0Var;
        try {
            v0Var = (v0) Class.forName("e.w.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            v0Var = null;
        }
        c = v0Var;
    }

    public static void a(ArrayList<View> arrayList, e.e.a<String, View> aVar, Collection<String> collection) {
        for (int i2 = aVar.f1022d - 1; i2 >= 0; i2--) {
            View k2 = aVar.k(i2);
            AtomicInteger atomicInteger = m.a;
            if (collection.contains(k2.getTransitionName())) {
                arrayList.add(k2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        if (r0.f1459l != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0074, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0084, code lost:
        if (r0.z != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0086, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static void b(a aVar, m0.a aVar2, SparseArray<b> sparseArray, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        b bVar;
        boolean z5;
        m mVar = aVar2.b;
        if (mVar != null && (i2 = mVar.x) != 0) {
            int i3 = z ? a[aVar2.a] : aVar2.a;
            boolean z6 = true;
            boolean z7 = false;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 7) {
                                    z5 = false;
                                    z6 = false;
                                }
                            }
                        } else if (z2) {
                            if (mVar.J) {
                                if (!mVar.z) {
                                }
                            }
                            z5 = false;
                        } else {
                            z5 = mVar.z;
                        }
                        z7 = z5;
                        z3 = z6;
                        z6 = false;
                        z4 = false;
                        bVar = sparseArray.get(i2);
                        if (z7) {
                            if (bVar == null) {
                                b bVar2 = new b();
                                sparseArray.put(i2, bVar2);
                                bVar = bVar2;
                            }
                            bVar.a = mVar;
                            bVar.b = z;
                            bVar.c = aVar;
                        }
                        if (!z2 && z3) {
                            if (bVar != null && bVar.f1511d == mVar) {
                                bVar.f1511d = null;
                            }
                            if (!aVar.p) {
                                e0 e0Var = aVar.q;
                                e0Var.c.j(e0Var.h(mVar));
                                e0Var.U(mVar, e0Var.p);
                            }
                        }
                        if (z4 && (bVar == null || bVar.f1511d == null)) {
                            if (bVar == null) {
                                b bVar3 = new b();
                                sparseArray.put(i2, bVar3);
                                bVar = bVar3;
                            }
                            bVar.f1511d = mVar;
                            bVar.f1512e = z;
                            bVar.f1513f = aVar;
                        }
                        if (!z2 && z6 && bVar != null && bVar.a == mVar) {
                            bVar.a = null;
                            return;
                        }
                        return;
                    } else if (!z2) {
                        boolean z8 = false;
                        z4 = z8;
                        z3 = false;
                        bVar = sparseArray.get(i2);
                        if (z7) {
                        }
                        bVar.f1511d = null;
                        if (!aVar.p) {
                        }
                        if (bVar == null) {
                        }
                        bVar.f1511d = mVar;
                        bVar.f1512e = z;
                        bVar.f1513f = aVar;
                        if (!z2) {
                            return;
                        }
                        return;
                    } else {
                        boolean z82 = false;
                        z4 = z82;
                        z3 = false;
                        bVar = sparseArray.get(i2);
                        if (z7) {
                        }
                        bVar.f1511d = null;
                        if (!aVar.p) {
                        }
                        if (bVar == null) {
                        }
                        bVar.f1511d = mVar;
                        bVar.f1512e = z;
                        bVar.f1513f = aVar;
                        if (!z2) {
                        }
                    }
                }
                boolean z9 = mVar.f1459l;
                if (!z2) {
                    boolean z822 = false;
                    z4 = z822;
                    z3 = false;
                    bVar = sparseArray.get(i2);
                    if (z7) {
                    }
                    bVar.f1511d = null;
                    if (!aVar.p) {
                    }
                    if (bVar == null) {
                    }
                    bVar.f1511d = mVar;
                    bVar.f1512e = z;
                    bVar.f1513f = aVar;
                    if (!z2) {
                    }
                } else {
                    boolean z8222 = false;
                    z4 = z8222;
                    z3 = false;
                    bVar = sparseArray.get(i2);
                    if (z7) {
                    }
                    bVar.f1511d = null;
                    if (!aVar.p) {
                    }
                    if (bVar == null) {
                    }
                    bVar.f1511d = mVar;
                    bVar.f1512e = z;
                    bVar.f1513f = aVar;
                    if (!z2) {
                    }
                }
            }
            if (!z2) {
                if (!mVar.f1459l) {
                }
            }
            z5 = false;
            z7 = z5;
            z3 = z6;
            z6 = false;
            z4 = false;
            bVar = sparseArray.get(i2);
            if (z7) {
            }
            bVar.f1511d = null;
            if (!aVar.p) {
            }
            if (bVar == null) {
            }
            bVar.f1511d = mVar;
            bVar.f1512e = z;
            bVar.f1513f = aVar;
            if (!z2) {
            }
        }
    }

    public static void c(m mVar, m mVar2, boolean z, e.e.a<String, View> aVar, boolean z2) {
        if (z) {
            mVar2.m();
        } else {
            mVar.m();
        }
    }

    public static boolean d(v0 v0Var, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!v0Var.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static e.e.a<String, View> e(v0 v0Var, e.e.a<String, String> aVar, Object obj, b bVar) {
        ArrayList<String> arrayList;
        m mVar = bVar.a;
        View view = mVar.F;
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        e.e.a<String, View> aVar2 = new e.e.a<>();
        v0Var.i(aVar2, view);
        a aVar3 = bVar.c;
        if (bVar.b) {
            mVar.o();
            arrayList = aVar3.n;
        } else {
            mVar.m();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
            g.k(aVar2, aVar.values());
        }
        m(aVar, aVar2);
        return aVar2;
    }

    public static e.e.a<String, View> f(v0 v0Var, e.e.a<String, String> aVar, Object obj, b bVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        m mVar = bVar.f1511d;
        e.e.a<String, View> aVar2 = new e.e.a<>();
        v0Var.i(aVar2, mVar.q0());
        a aVar3 = bVar.f1513f;
        if (bVar.f1512e) {
            mVar.m();
            arrayList = aVar3.o;
        } else {
            mVar.o();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            g.k(aVar2, arrayList);
        }
        g.k(aVar, aVar2.keySet());
        return aVar2;
    }

    public static v0 g(m mVar, m mVar2) {
        ArrayList arrayList = new ArrayList();
        if (mVar != null) {
            mVar.n();
            Object x = mVar.x();
            if (x != null) {
                arrayList.add(x);
            }
            Object z = mVar.z();
            if (z != null) {
                arrayList.add(z);
            }
        }
        if (mVar2 != null) {
            mVar2.k();
            Object v = mVar2.v();
            if (v != null) {
                arrayList.add(v);
            }
            mVar2.y();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        v0 v0Var = b;
        if (d(v0Var, arrayList)) {
            return v0Var;
        }
        v0 v0Var2 = c;
        if (v0Var2 != null && d(v0Var2, arrayList)) {
            return v0Var2;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> h(v0 v0Var, Object obj, m mVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = mVar.F;
        if (view2 != null) {
            v0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        v0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object i(v0 v0Var, m mVar, boolean z) {
        Object obj = null;
        if (mVar == null) {
            return null;
        }
        if (z) {
            obj = mVar.v();
        } else {
            mVar.k();
        }
        return v0Var.g(obj);
    }

    public static Object j(v0 v0Var, m mVar, boolean z) {
        Object obj = null;
        if (mVar == null) {
            return null;
        }
        if (z) {
            obj = mVar.x();
        } else {
            mVar.n();
        }
        return v0Var.g(obj);
    }

    public static View k(e.e.a<String, View> aVar, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a aVar2 = bVar.c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.n : aVar2.o).get(0));
    }

    public static Object l(v0 v0Var, m mVar, m mVar2, boolean z) {
        Object obj;
        if (z) {
            obj = mVar2.z();
        } else {
            mVar.y();
            obj = null;
        }
        return v0Var.y(v0Var.g(obj));
    }

    public static void m(e.e.a<String, String> aVar, e.e.a<String, View> aVar2) {
        int i2 = aVar.f1022d;
        while (true) {
            i2--;
            if (i2 < 0) {
                return;
            }
            if (!aVar2.containsKey(aVar.k(i2))) {
                aVar.i(i2);
            }
        }
    }

    public static void n(v0 v0Var, Object obj, Object obj2, e.e.a<String, View> aVar, boolean z, a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
            v0Var.t(obj, view);
            if (obj2 != null) {
                v0Var.t(obj2, view);
            }
        }
    }

    public static void o(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03f5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0230 A[ADDED_TO_REGION] */
    public static void p(Context context, x xVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, a aVar) {
        int i4;
        SparseArray sparseArray;
        int i5;
        int i6;
        ViewGroup viewGroup;
        int i7;
        int i8;
        m mVar;
        ArrayList<View> arrayList3;
        ArrayList<View> arrayList4;
        m mVar2;
        Object obj;
        Object obj2;
        Object m;
        e.e.a aVar2;
        Object obj3;
        Object obj4;
        Object obj5;
        m mVar3;
        boolean z2;
        e.e.a aVar3;
        m mVar4;
        Rect rect;
        ArrayList<View> arrayList5;
        e.e.a aVar4;
        m mVar5;
        Object obj6;
        Object m2;
        Object obj7;
        Object obj8;
        Rect rect2;
        View view;
        ArrayList<String> arrayList6;
        ArrayList<String> arrayList7;
        ArrayList<a> arrayList8 = arrayList;
        ArrayList<Boolean> arrayList9 = arrayList2;
        int i9 = i3;
        boolean z3 = z;
        SparseArray sparseArray2 = new SparseArray();
        int i10 = i2;
        while (true) {
            i4 = 0;
            if (i10 >= i9) {
                break;
            }
            a aVar5 = arrayList8.get(i10);
            if (!arrayList9.get(i10).booleanValue()) {
                int size = aVar5.a.size();
                for (int i11 = 0; i11 < size; i11++) {
                    b(aVar5, aVar5.a.get(i11), sparseArray2, false, z3);
                }
            } else if (aVar5.q.r.g()) {
                for (int size2 = aVar5.a.size() - 1; size2 >= 0; size2--) {
                    b(aVar5, aVar5.a.get(size2), sparseArray2, true, z3);
                }
            }
            i10++;
        }
        if (sparseArray2.size() != 0) {
            View view2 = new View(context);
            int size3 = sparseArray2.size();
            int i12 = 0;
            while (i12 < size3) {
                int keyAt = sparseArray2.keyAt(i12);
                e.e.a aVar6 = new e.e.a();
                int i13 = i9 - 1;
                while (i13 >= i2) {
                    a aVar7 = arrayList8.get(i13);
                    if (aVar7.l(keyAt)) {
                        boolean booleanValue = arrayList9.get(i13).booleanValue();
                        ArrayList<String> arrayList10 = aVar7.n;
                        if (arrayList10 != null) {
                            int size4 = arrayList10.size();
                            if (booleanValue) {
                                arrayList6 = aVar7.n;
                                arrayList7 = aVar7.o;
                            } else {
                                ArrayList<String> arrayList11 = aVar7.n;
                                arrayList6 = aVar7.o;
                                arrayList7 = arrayList11;
                            }
                            while (i4 < size4) {
                                String str = arrayList7.get(i4);
                                String str2 = arrayList6.get(i4);
                                String str3 = (String) aVar6.remove(str2);
                                if (str3 != null) {
                                    aVar6.put(str, str3);
                                } else {
                                    aVar6.put(str, str2);
                                }
                                i4++;
                            }
                        }
                    }
                    i13--;
                    arrayList8 = arrayList;
                    arrayList9 = arrayList2;
                    i4 = 0;
                }
                b bVar = (b) sparseArray2.valueAt(i12);
                if (!xVar.g() || (viewGroup = (ViewGroup) xVar.e(keyAt)) == null) {
                    sparseArray = sparseArray2;
                    i6 = i12;
                    i5 = size3;
                } else {
                    if (z3) {
                        m mVar6 = bVar.a;
                        m mVar7 = bVar.f1511d;
                        v0 g2 = g(mVar7, mVar6);
                        if (g2 == null) {
                            sparseArray = sparseArray2;
                            i8 = i12;
                            i7 = size3;
                        } else {
                            boolean z4 = bVar.b;
                            boolean z5 = bVar.f1512e;
                            ArrayList<View> arrayList12 = new ArrayList<>();
                            ArrayList<View> arrayList13 = new ArrayList<>();
                            Object i14 = i(g2, mVar6, z4);
                            Object j2 = j(g2, mVar7, z5);
                            m mVar8 = bVar.a;
                            sparseArray = sparseArray2;
                            m mVar9 = bVar.f1511d;
                            if (mVar8 != null) {
                                i8 = i12;
                                mVar8.q0().setVisibility(0);
                            } else {
                                i8 = i12;
                            }
                            if (mVar8 == null || mVar9 == null) {
                                arrayList5 = arrayList12;
                                mVar5 = mVar6;
                                aVar4 = aVar6;
                                i7 = size3;
                            } else {
                                boolean z6 = bVar.b;
                                if (aVar6.isEmpty()) {
                                    i7 = size3;
                                    obj7 = null;
                                } else {
                                    obj7 = l(g2, mVar8, mVar9, z6);
                                    i7 = size3;
                                }
                                e.e.a<String, View> f2 = f(g2, aVar6, obj7, bVar);
                                mVar5 = mVar6;
                                e.e.a<String, View> e2 = e(g2, aVar6, obj7, bVar);
                                if (aVar6.isEmpty()) {
                                    if (f2 != null) {
                                        f2.clear();
                                    }
                                    if (e2 != null) {
                                        e2.clear();
                                    }
                                    obj8 = null;
                                } else {
                                    a(arrayList13, f2, aVar6.keySet());
                                    a(arrayList12, e2, aVar6.values());
                                    obj8 = obj7;
                                }
                                if (i14 == null && j2 == null && obj8 == null) {
                                    arrayList5 = arrayList12;
                                    aVar4 = aVar6;
                                } else {
                                    aVar4 = aVar6;
                                    c(mVar8, mVar9, z6, f2, true);
                                    if (obj8 != null) {
                                        arrayList12.add(view2);
                                        g2.w(obj8, view2, arrayList13);
                                        arrayList5 = arrayList12;
                                        n(g2, obj8, j2, f2, bVar.f1512e, bVar.f1513f);
                                        Rect rect3 = new Rect();
                                        View k2 = k(e2, bVar, i14, z6);
                                        if (k2 != null) {
                                            g2.s(i14, rect3);
                                        }
                                        view = k2;
                                        rect2 = rect3;
                                    } else {
                                        arrayList5 = arrayList12;
                                        view = null;
                                        rect2 = null;
                                    }
                                    l.a(viewGroup, new r0(mVar8, mVar9, z6, e2, view, g2, rect2));
                                    obj6 = obj8;
                                    if (!(i14 == null && obj6 == null && j2 == null)) {
                                        ArrayList<View> h2 = h(g2, j2, mVar7, arrayList13, view2);
                                        ArrayList<View> h3 = h(g2, i14, mVar5, arrayList5, view2);
                                        o(h3, 4);
                                        m2 = g2.m(j2, i14, obj6);
                                        if (!(mVar7 == null || h2 == null || (h2.size() <= 0 && arrayList13.size() <= 0))) {
                                            e.i.e.a aVar8 = new e.i.e.a();
                                            e0.d dVar = (e0.d) aVar;
                                            dVar.b(mVar7, aVar8);
                                            g2.u(mVar7, m2, aVar8, new n0(dVar, mVar7, aVar8));
                                        }
                                        if (m2 != null) {
                                            if (mVar7 != null && j2 != null && mVar7.f1459l && mVar7.z && mVar7.J) {
                                                mVar7.v0(true);
                                                g2.q(j2, mVar7.F, h2);
                                                l.a(mVar7.E, new o0(h2));
                                            }
                                            ArrayList<String> n = g2.n(arrayList5);
                                            g2.r(m2, i14, h3, j2, h2, obj6, arrayList5);
                                            g2.c(viewGroup, m2);
                                            g2.v(viewGroup, arrayList13, arrayList5, n, aVar4);
                                            o(h3, 0);
                                            g2.x(obj6, arrayList13, arrayList5);
                                        }
                                    }
                                }
                            }
                            obj6 = null;
                            ArrayList<View> h22 = h(g2, j2, mVar7, arrayList13, view2);
                            ArrayList<View> h32 = h(g2, i14, mVar5, arrayList5, view2);
                            o(h32, 4);
                            m2 = g2.m(j2, i14, obj6);
                            e.i.e.a aVar82 = new e.i.e.a();
                            e0.d dVar2 = (e0.d) aVar;
                            dVar2.b(mVar7, aVar82);
                            g2.u(mVar7, m2, aVar82, new n0(dVar2, mVar7, aVar82));
                            if (m2 != null) {
                            }
                        }
                    } else {
                        sparseArray = sparseArray2;
                        e.e.a aVar9 = aVar6;
                        i8 = i12;
                        i7 = size3;
                        m mVar10 = bVar.a;
                        m mVar11 = bVar.f1511d;
                        v0 g3 = g(mVar11, mVar10);
                        if (g3 != null) {
                            boolean z7 = bVar.b;
                            boolean z8 = bVar.f1512e;
                            Object i15 = i(g3, mVar10, z7);
                            Object j3 = j(g3, mVar11, z8);
                            ArrayList<View> arrayList14 = new ArrayList<>();
                            ArrayList<View> arrayList15 = new ArrayList<>();
                            m mVar12 = bVar.a;
                            m mVar13 = bVar.f1511d;
                            if (mVar12 == null || mVar13 == null) {
                                mVar2 = mVar10;
                                mVar = mVar11;
                            } else {
                                boolean z9 = bVar.b;
                                if (aVar9.isEmpty()) {
                                    aVar2 = aVar9;
                                    obj3 = null;
                                } else {
                                    obj3 = l(g3, mVar12, mVar13, z9);
                                    aVar2 = aVar9;
                                }
                                e.e.a<String, View> f3 = f(g3, aVar2, obj3, bVar);
                                if (aVar2.isEmpty()) {
                                    obj4 = null;
                                } else {
                                    arrayList14.addAll(f3.values());
                                    obj4 = obj3;
                                }
                                if (i15 == null && j3 == null && obj4 == null) {
                                    mVar2 = mVar10;
                                    mVar = mVar11;
                                    aVar9 = aVar2;
                                } else {
                                    mVar2 = mVar10;
                                    c(mVar12, mVar13, z9, f3, true);
                                    if (obj4 != null) {
                                        rect = new Rect();
                                        g3.w(obj4, view2, arrayList14);
                                        obj5 = obj4;
                                        aVar3 = aVar2;
                                        z2 = z9;
                                        mVar3 = mVar13;
                                        mVar4 = mVar12;
                                        arrayList4 = arrayList15;
                                        n(g3, obj5, j3, f3, bVar.f1512e, bVar.f1513f);
                                        if (i15 != null) {
                                            g3.s(i15, rect);
                                        }
                                    } else {
                                        obj5 = obj4;
                                        aVar3 = aVar2;
                                        z2 = z9;
                                        mVar3 = mVar13;
                                        mVar4 = mVar12;
                                        arrayList4 = arrayList15;
                                        rect = null;
                                    }
                                    aVar9 = aVar3;
                                    arrayList3 = arrayList14;
                                    i6 = i8;
                                    mVar = mVar11;
                                    obj2 = j3;
                                    i5 = i7;
                                    l.a(viewGroup, new s0(g3, aVar3, obj5, bVar, arrayList4, view2, mVar4, mVar3, z2, arrayList3, i15, rect));
                                    obj = obj5;
                                    if (i15 == null || obj != null || obj2 != null) {
                                        ArrayList<View> h4 = h(g3, obj2, mVar, arrayList3, view2);
                                        if (h4 == null || h4.isEmpty()) {
                                            obj2 = null;
                                        }
                                        g3.a(i15, view2);
                                        m = g3.m(obj2, i15, obj);
                                        if (!(mVar == null || h4 == null || (h4.size() <= 0 && arrayList3.size() <= 0))) {
                                            e.i.e.a aVar10 = new e.i.e.a();
                                            e0.d dVar3 = (e0.d) aVar;
                                            dVar3.b(mVar, aVar10);
                                            g3.u(mVar, m, aVar10, new p0(dVar3, mVar, aVar10));
                                        }
                                        if (m == null) {
                                            ArrayList<View> arrayList16 = new ArrayList<>();
                                            g3.r(m, i15, arrayList16, obj2, h4, obj, arrayList4);
                                            l.a(viewGroup, new q0(i15, g3, view2, mVar2, arrayList4, arrayList16, h4, obj2));
                                            l.a(viewGroup, new w0(g3, arrayList4, aVar9));
                                            g3.c(viewGroup, m);
                                            l.a(viewGroup, new x0(g3, arrayList4, aVar9));
                                        }
                                    }
                                }
                            }
                            arrayList4 = arrayList15;
                            arrayList3 = arrayList14;
                            obj2 = j3;
                            i6 = i8;
                            i5 = i7;
                            obj = null;
                            if (i15 == null) {
                            }
                            ArrayList<View> h42 = h(g3, obj2, mVar, arrayList3, view2);
                            obj2 = null;
                            g3.a(i15, view2);
                            m = g3.m(obj2, i15, obj);
                            e.i.e.a aVar102 = new e.i.e.a();
                            e0.d dVar32 = (e0.d) aVar;
                            dVar32.b(mVar, aVar102);
                            g3.u(mVar, m, aVar102, new p0(dVar32, mVar, aVar102));
                            if (m == null) {
                            }
                        }
                    }
                    i6 = i8;
                    i5 = i7;
                }
                i12 = i6 + 1;
                arrayList8 = arrayList;
                arrayList9 = arrayList2;
                i9 = i3;
                z3 = z;
                size3 = i5;
                sparseArray2 = sparseArray;
                i4 = 0;
            }
        }
    }
}
