package e.w;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import e.e.e;
import e.w.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class l {
    public static h a = new a();
    public static ThreadLocal<WeakReference<e.e.a<ViewGroup, ArrayList<h>>>> b = new ThreadLocal<>();
    public static ArrayList<ViewGroup> c = new ArrayList<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public h b;
        public ViewGroup c;

        /* renamed from: e.w.l$a$a  reason: collision with other inner class name */
        public class C0060a extends k {
            public final /* synthetic */ e.e.a a;

            public C0060a(e.e.a aVar) {
                this.a = aVar;
            }

            @Override // e.w.h.d
            public void e(h hVar) {
                ((ArrayList) this.a.get(a.this.c)).remove(hVar);
                hVar.v(this);
            }
        }

        public a(h hVar, ViewGroup viewGroup) {
            this.b = hVar;
            this.c = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0242  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01ef A[EDGE_INSN: B:133:0x01ef->B:88:0x01ef ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0215  */
        public boolean onPreDraw() {
            ArrayList arrayList;
            h hVar;
            q qVar;
            e.e.a aVar;
            e.e.a aVar2;
            int i2;
            int[] iArr;
            int i3;
            int i4;
            int i5;
            h.b orDefault;
            q qVar2;
            p pVar;
            View view;
            View view2;
            q qVar3;
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
            int i6 = 1;
            if (!l.c.remove(this.c)) {
                return true;
            }
            e.e.a<ViewGroup, ArrayList<h>> a = l.a();
            ArrayList<h> arrayList2 = a.get(this.c);
            boolean z = false;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                a.put(this.c, arrayList2);
            } else if (arrayList2.size() > 0) {
                arrayList = new ArrayList(arrayList2);
                arrayList2.add(this.b);
                this.b.a(new C0060a(a));
                this.b.h(this.c, false);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).x(this.c);
                    }
                }
                hVar = this.b;
                ViewGroup viewGroup = this.c;
                Objects.requireNonNull(hVar);
                hVar.f1929l = new ArrayList<>();
                hVar.m = new ArrayList<>();
                qVar = hVar.f1925h;
                q qVar4 = hVar.f1926i;
                aVar = new e.e.a(qVar.a);
                aVar2 = new e.e.a(qVar4.a);
                i2 = 0;
                while (true) {
                    iArr = hVar.f1928k;
                    if (i2 < iArr.length) {
                        break;
                    }
                    int i7 = iArr[i2];
                    if (i7 == i6) {
                        qVar2 = qVar;
                        int i8 = aVar.f1199d;
                        while (true) {
                            i8--;
                            if (i8 < 0) {
                                break;
                            }
                            View view3 = (View) aVar.h(i8);
                            if (view3 != null && hVar.s(view3) && (pVar = (p) aVar2.remove(view3)) != null && hVar.s(pVar.b)) {
                                hVar.f1929l.add((p) aVar.i(i8));
                                hVar.m.add(pVar);
                            }
                        }
                    } else if (i7 == 2) {
                        qVar2 = qVar;
                        e.e.a<String, View> aVar3 = qVar2.f1932d;
                        e.e.a<String, View> aVar4 = qVar4.f1932d;
                        int i9 = aVar3.f1199d;
                        for (int i10 = 0; i10 < i9; i10++) {
                            View k2 = aVar3.k(i10);
                            if (k2 != null && hVar.s(k2) && (view = aVar4.get(aVar3.h(i10))) != null && hVar.s(view)) {
                                p pVar2 = (p) aVar.getOrDefault(k2, null);
                                p pVar3 = (p) aVar2.getOrDefault(view, null);
                                if (!(pVar2 == null || pVar3 == null)) {
                                    hVar.f1929l.add(pVar2);
                                    hVar.m.add(pVar3);
                                    aVar.remove(k2);
                                    aVar2.remove(view);
                                }
                            }
                        }
                    } else if (i7 != 3) {
                        if (i7 == 4) {
                            e<View> eVar = qVar.c;
                            e<View> eVar2 = qVar4.c;
                            int l2 = eVar.l();
                            int i11 = 0;
                            while (i11 < l2) {
                                View m = eVar.m(i11);
                                if (m == null || !hVar.s(m)) {
                                    qVar3 = qVar;
                                } else {
                                    qVar3 = qVar;
                                    View f2 = eVar2.f(eVar.i(i11));
                                    if (f2 != null && hVar.s(f2)) {
                                        p pVar4 = (p) aVar.getOrDefault(m, z);
                                        p pVar5 = (p) aVar2.getOrDefault(f2, z);
                                        if (!(pVar4 == null || pVar5 == null)) {
                                            hVar.f1929l.add(pVar4);
                                            hVar.m.add(pVar5);
                                            aVar.remove(m);
                                            aVar2.remove(f2);
                                        }
                                    }
                                }
                                i11++;
                                qVar = qVar3;
                                z = false;
                            }
                        }
                        qVar2 = qVar;
                    } else {
                        qVar2 = qVar;
                        SparseArray<View> sparseArray = qVar2.b;
                        SparseArray<View> sparseArray2 = qVar4.b;
                        int size = sparseArray.size();
                        for (int i12 = 0; i12 < size; i12++) {
                            View valueAt = sparseArray.valueAt(i12);
                            if (valueAt != null && hVar.s(valueAt) && (view2 = sparseArray2.get(sparseArray.keyAt(i12))) != null && hVar.s(view2)) {
                                p pVar6 = (p) aVar.getOrDefault(valueAt, null);
                                p pVar7 = (p) aVar2.getOrDefault(view2, null);
                                if (!(pVar6 == null || pVar7 == null)) {
                                    hVar.f1929l.add(pVar6);
                                    hVar.m.add(pVar7);
                                    aVar.remove(valueAt);
                                    aVar2.remove(view2);
                                }
                            }
                        }
                    }
                    i2++;
                    qVar = qVar2;
                    i6 = 1;
                    z = false;
                }
                for (i3 = 0; i3 < aVar.f1199d; i3++) {
                    p pVar8 = (p) aVar.k(i3);
                    if (hVar.s(pVar8.b)) {
                        hVar.f1929l.add(pVar8);
                        hVar.m.add(null);
                    }
                }
                for (i4 = 0; i4 < aVar2.f1199d; i4++) {
                    p pVar9 = (p) aVar2.k(i4);
                    if (hVar.s(pVar9.b)) {
                        hVar.m.add(pVar9);
                        hVar.f1929l.add(null);
                    }
                }
                e.e.a<Animator, h.b> o = h.o();
                int i13 = o.f1199d;
                y yVar = s.a;
                b0 b0Var = new b0(viewGroup);
                for (i5 = i13 - 1; i5 >= 0; i5--) {
                    Animator h2 = o.h(i5);
                    if (!(h2 == null || (orDefault = o.getOrDefault(h2, null)) == null || orDefault.a == null || !b0Var.equals(orDefault.f1930d))) {
                        p pVar10 = orDefault.c;
                        View view4 = orDefault.a;
                        p q = hVar.q(view4, true);
                        p n = hVar.n(view4, true);
                        if (q == null && n == null) {
                            n = hVar.f1926i.a.get(view4);
                        }
                        if (!(q == null && n == null) && orDefault.f1931e.r(pVar10, n)) {
                            if (h2.isRunning() || h2.isStarted()) {
                                h2.cancel();
                            } else {
                                o.remove(h2);
                            }
                        }
                    }
                }
                hVar.l(viewGroup, hVar.f1925h, hVar.f1926i, hVar.f1929l, hVar.m);
                hVar.y();
                return true;
            }
            arrayList = null;
            arrayList2.add(this.b);
            this.b.a(new C0060a(a));
            this.b.h(this.c, false);
            if (arrayList != null) {
            }
            hVar = this.b;
            ViewGroup viewGroup2 = this.c;
            Objects.requireNonNull(hVar);
            hVar.f1929l = new ArrayList<>();
            hVar.m = new ArrayList<>();
            qVar = hVar.f1925h;
            q qVar42 = hVar.f1926i;
            aVar = new e.e.a(qVar.a);
            aVar2 = new e.e.a(qVar42.a);
            i2 = 0;
            while (true) {
                iArr = hVar.f1928k;
                if (i2 < iArr.length) {
                }
                i2++;
                qVar = qVar2;
                i6 = 1;
                z = false;
            }
            while (i3 < aVar.f1199d) {
            }
            while (i4 < aVar2.f1199d) {
            }
            e.e.a<Animator, h.b> o2 = h.o();
            int i132 = o2.f1199d;
            y yVar2 = s.a;
            b0 b0Var2 = new b0(viewGroup2);
            while (i5 >= 0) {
            }
            hVar.l(viewGroup2, hVar.f1925h, hVar.f1926i, hVar.f1929l, hVar.m);
            hVar.y();
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
            l.c.remove(this.c);
            ArrayList<h> arrayList = l.a().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().x(this.c);
                }
            }
            this.b.i(true);
        }
    }

    public static e.e.a<ViewGroup, ArrayList<h>> a() {
        e.e.a<ViewGroup, ArrayList<h>> aVar;
        WeakReference<e.e.a<ViewGroup, ArrayList<h>>> weakReference = b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        e.e.a<ViewGroup, ArrayList<h>> aVar2 = new e.e.a<>();
        b.set(new WeakReference<>(aVar2));
        return aVar2;
    }
}
