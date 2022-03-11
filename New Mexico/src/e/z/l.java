package e.z;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.R$id;
import e.f.e;
import e.j.j.v;
import e.z.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class l {
    public static h a = new a();
    public static ThreadLocal<WeakReference<e.f.a<ViewGroup, ArrayList<h>>>> b = new ThreadLocal<>();
    public static ArrayList<ViewGroup> c = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public h b;
        public ViewGroup c;

        /* renamed from: e.z.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0069a extends k {
            public final /* synthetic */ e.f.a a;

            public C0069a(e.f.a aVar) {
                this.a = aVar;
            }

            @Override // e.z.h.d
            public void e(h hVar) {
                ((ArrayList) this.a.get(a.this.c)).remove(hVar);
                hVar.v(this);
            }
        }

        public a(h hVar, ViewGroup viewGroup) {
            this.b = hVar;
            this.c = viewGroup;
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0247  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x01f4 A[EDGE_INSN: B:138:0x01f4->B:93:0x01f4 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x01f9  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /* Code decompiled incorrectly, please refer to instructions dump */
        public boolean onPreDraw() {
            ArrayList arrayList;
            h hVar;
            q qVar;
            e.f.a aVar;
            e.f.a aVar2;
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
            e.f.a<ViewGroup, ArrayList<h>> b = l.b();
            ArrayList<h> arrayList2 = b.get(this.c);
            boolean z = false;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                b.put(this.c, arrayList2);
            } else if (arrayList2.size() > 0) {
                arrayList = new ArrayList(arrayList2);
                arrayList2.add(this.b);
                this.b.a(new C0069a(b));
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
                hVar.f2139l = new ArrayList<>();
                hVar.m = new ArrayList<>();
                qVar = hVar.f2135h;
                q qVar4 = hVar.f2136i;
                aVar = new e.f.a(qVar.a);
                aVar2 = new e.f.a(qVar4.a);
                i2 = 0;
                while (true) {
                    iArr = hVar.f2138k;
                    if (i2 < iArr.length) {
                        break;
                    }
                    int i7 = iArr[i2];
                    if (i7 == i6) {
                        qVar2 = qVar;
                        int i8 = aVar.f1316d;
                        while (true) {
                            i8--;
                            if (i8 >= 0) {
                                View view3 = (View) aVar.h(i8);
                                if (view3 != null && hVar.s(view3) && (pVar = (p) aVar2.remove(view3)) != null && hVar.s(pVar.b)) {
                                    hVar.f2139l.add((p) aVar.i(i8));
                                    hVar.m.add(pVar);
                                }
                            }
                        }
                    } else if (i7 == 2) {
                        qVar2 = qVar;
                        e.f.a<String, View> aVar3 = qVar2.f2142d;
                        e.f.a<String, View> aVar4 = qVar4.f2142d;
                        int i9 = aVar3.f1316d;
                        for (int i10 = 0; i10 < i9; i10++) {
                            View k2 = aVar3.k(i10);
                            if (k2 != null && hVar.s(k2) && (view = aVar4.get(aVar3.h(i10))) != null && hVar.s(view)) {
                                p pVar2 = (p) aVar.getOrDefault(k2, null);
                                p pVar3 = (p) aVar2.getOrDefault(view, null);
                                if (!(pVar2 == null || pVar3 == null)) {
                                    hVar.f2139l.add(pVar2);
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
                            int h2 = eVar.h();
                            int i11 = 0;
                            while (i11 < h2) {
                                View i12 = eVar.i(i11);
                                if (i12 == null || !hVar.s(i12)) {
                                    qVar3 = qVar;
                                } else {
                                    if (eVar.b) {
                                        eVar.d();
                                    }
                                    qVar3 = qVar;
                                    View e2 = eVar2.e(eVar.c[i11]);
                                    if (e2 != null && hVar.s(e2)) {
                                        p pVar4 = (p) aVar.getOrDefault(i12, z);
                                        p pVar5 = (p) aVar2.getOrDefault(e2, z);
                                        if (!(pVar4 == null || pVar5 == null)) {
                                            hVar.f2139l.add(pVar4);
                                            hVar.m.add(pVar5);
                                            aVar.remove(i12);
                                            aVar2.remove(e2);
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
                        for (int i13 = 0; i13 < size; i13++) {
                            View valueAt = sparseArray.valueAt(i13);
                            if (valueAt != null && hVar.s(valueAt) && (view2 = sparseArray2.get(sparseArray.keyAt(i13))) != null && hVar.s(view2)) {
                                p pVar6 = (p) aVar.getOrDefault(valueAt, null);
                                p pVar7 = (p) aVar2.getOrDefault(view2, null);
                                if (!(pVar6 == null || pVar7 == null)) {
                                    hVar.f2139l.add(pVar6);
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
                for (i3 = 0; i3 < aVar.f1316d; i3++) {
                    p pVar8 = (p) aVar.k(i3);
                    if (hVar.s(pVar8.b)) {
                        hVar.f2139l.add(pVar8);
                        hVar.m.add(null);
                    }
                }
                for (i4 = 0; i4 < aVar2.f1316d; i4++) {
                    p pVar9 = (p) aVar2.k(i4);
                    if (hVar.s(pVar9.b)) {
                        hVar.m.add(pVar9);
                        hVar.f2139l.add(null);
                    }
                }
                e.f.a<Animator, h.b> o = h.o();
                int i14 = o.f1316d;
                y yVar = s.a;
                b0 b0Var = new b0(viewGroup);
                for (i5 = i14 - 1; i5 >= 0; i5--) {
                    Animator h3 = o.h(i5);
                    if (!(h3 == null || (orDefault = o.getOrDefault(h3, null)) == null || orDefault.a == null || !b0Var.equals(orDefault.f2140d))) {
                        p pVar10 = orDefault.c;
                        View view4 = orDefault.a;
                        p q = hVar.q(view4, true);
                        p n = hVar.n(view4, true);
                        if (q == null && n == null) {
                            n = hVar.f2136i.a.get(view4);
                        }
                        if (!(q == null && n == null) && orDefault.f2141e.r(pVar10, n)) {
                            if (h3.isRunning() || h3.isStarted()) {
                                h3.cancel();
                            } else {
                                o.remove(h3);
                            }
                        }
                    }
                }
                hVar.l(viewGroup, hVar.f2135h, hVar.f2136i, hVar.f2139l, hVar.m);
                hVar.y();
                return true;
            }
            arrayList = null;
            arrayList2.add(this.b);
            this.b.a(new C0069a(b));
            this.b.h(this.c, false);
            if (arrayList != null) {
            }
            hVar = this.b;
            ViewGroup viewGroup2 = this.c;
            Objects.requireNonNull(hVar);
            hVar.f2139l = new ArrayList<>();
            hVar.m = new ArrayList<>();
            qVar = hVar.f2135h;
            q qVar42 = hVar.f2136i;
            aVar = new e.f.a(qVar.a);
            aVar2 = new e.f.a(qVar42.a);
            i2 = 0;
            while (true) {
                iArr = hVar.f2138k;
                if (i2 < iArr.length) {
                }
                i2++;
                qVar = qVar2;
                i6 = 1;
                z = false;
            }
            while (i3 < aVar.f1316d) {
            }
            while (i4 < aVar2.f1316d) {
            }
            e.f.a<Animator, h.b> o2 = h.o();
            int i142 = o2.f1316d;
            y yVar2 = s.a;
            b0 b0Var2 = new b0(viewGroup2);
            while (i5 >= 0) {
            }
            hVar.l(viewGroup2, hVar.f2135h, hVar.f2136i, hVar.f2139l, hVar.m);
            hVar.y();
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
            l.c.remove(this.c);
            ArrayList<h> arrayList = l.b().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().x(this.c);
                }
            }
            this.b.i(true);
        }
    }

    public static void a(ViewGroup viewGroup, h hVar) {
        if (!c.contains(viewGroup)) {
            AtomicInteger atomicInteger = v.a;
            if (v.g.c(viewGroup)) {
                c.add(viewGroup);
                if (hVar == null) {
                    hVar = a;
                }
                h j2 = hVar.clone();
                ArrayList<h> orDefault = b().getOrDefault(viewGroup, null);
                if (orDefault != null && orDefault.size() > 0) {
                    Iterator<h> it = orDefault.iterator();
                    while (it.hasNext()) {
                        it.next().u(viewGroup);
                    }
                }
                if (j2 != null) {
                    j2.h(viewGroup, true);
                }
                int i2 = R$id.transition_current_scene;
                if (((g) viewGroup.getTag(i2)) == null) {
                    viewGroup.setTag(i2, null);
                    if (j2 != null) {
                        a aVar = new a(j2, viewGroup);
                        viewGroup.addOnAttachStateChangeListener(aVar);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public static e.f.a<ViewGroup, ArrayList<h>> b() {
        e.f.a<ViewGroup, ArrayList<h>> aVar;
        WeakReference<e.f.a<ViewGroup, ArrayList<h>>> weakReference = b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        e.f.a<ViewGroup, ArrayList<h>> aVar2 = new e.f.a<>();
        b.set(new WeakReference<>(aVar2));
        return aVar2;
    }
}
