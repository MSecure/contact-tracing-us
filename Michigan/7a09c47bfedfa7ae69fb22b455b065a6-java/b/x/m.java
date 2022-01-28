package b.x;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b.e.e;
import b.x.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static i f2702a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<WeakReference<b.e.a<ViewGroup, ArrayList<i>>>> f2703b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<ViewGroup> f2704c = new ArrayList<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public i f2705b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f2706c;

        /* renamed from: b.x.m$a$a  reason: collision with other inner class name */
        public class C0057a extends l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.e.a f2707a;

            public C0057a(b.e.a aVar) {
                this.f2707a = aVar;
            }

            @Override // b.x.i.d
            public void e(i iVar) {
                ((ArrayList) this.f2707a.get(a.this.f2706c)).remove(iVar);
                iVar.y(this);
            }
        }

        public a(i iVar, ViewGroup viewGroup) {
            this.f2705b = iVar;
            this.f2706c = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x02b5  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
        public boolean onPreDraw() {
            ArrayList arrayList;
            i iVar;
            i.b orDefault;
            r rVar;
            q qVar;
            View view;
            View view2;
            r rVar2;
            this.f2706c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2706c.removeOnAttachStateChangeListener(this);
            int i = 1;
            if (!m.f2704c.remove(this.f2706c)) {
                return true;
            }
            b.e.a<ViewGroup, ArrayList<i>> a2 = m.a();
            ArrayList<i> arrayList2 = a2.get(this.f2706c);
            boolean z = false;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                a2.put(this.f2706c, arrayList2);
            } else if (arrayList2.size() > 0) {
                arrayList = new ArrayList(arrayList2);
                arrayList2.add(this.f2705b);
                this.f2705b.a(new C0057a(a2));
                int i2 = 0;
                this.f2705b.i(this.f2706c, false);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((i) it.next()).A(this.f2706c);
                    }
                }
                iVar = this.f2705b;
                ViewGroup viewGroup = this.f2706c;
                if (iVar == null) {
                    iVar.u = new ArrayList<>();
                    iVar.v = new ArrayList<>();
                    r rVar3 = iVar.q;
                    r rVar4 = iVar.r;
                    b.e.a aVar = new b.e.a(rVar3.f2715a);
                    b.e.a aVar2 = new b.e.a(rVar4.f2715a);
                    int i3 = 0;
                    while (true) {
                        int[] iArr = iVar.t;
                        if (i3 >= iArr.length) {
                            break;
                        }
                        int i4 = iArr[i3];
                        if (i4 == i) {
                            rVar = rVar3;
                            int i5 = aVar.f1413d;
                            while (true) {
                                i5--;
                                if (i5 < 0) {
                                    break;
                                }
                                View view3 = (View) aVar.h(i5);
                                if (view3 != null && iVar.u(view3) && (qVar = (q) aVar2.remove(view3)) != null && iVar.u(qVar.f2713b)) {
                                    iVar.u.add((q) aVar.i(i5));
                                    iVar.v.add(qVar);
                                }
                            }
                        } else if (i4 == 2) {
                            rVar = rVar3;
                            b.e.a<String, View> aVar3 = rVar.f2718d;
                            b.e.a<String, View> aVar4 = rVar4.f2718d;
                            int i6 = aVar3.f1413d;
                            for (int i7 = 0; i7 < i6; i7++) {
                                View k = aVar3.k(i7);
                                if (k != null && iVar.u(k) && (view = aVar4.get(aVar3.h(i7))) != null && iVar.u(view)) {
                                    q qVar2 = (q) aVar.getOrDefault(k, null);
                                    q qVar3 = (q) aVar2.getOrDefault(view, null);
                                    if (!(qVar2 == null || qVar3 == null)) {
                                        iVar.u.add(qVar2);
                                        iVar.v.add(qVar3);
                                        aVar.remove(k);
                                        aVar2.remove(view);
                                    }
                                }
                            }
                        } else if (i4 != 3) {
                            if (i4 == 4) {
                                e<View> eVar = rVar3.f2717c;
                                e<View> eVar2 = rVar4.f2717c;
                                int h = eVar.h();
                                int i8 = i2;
                                while (i8 < h) {
                                    View i9 = eVar.i(i8);
                                    if (i9 == null || !iVar.u(i9)) {
                                        rVar2 = rVar3;
                                    } else {
                                        if (eVar.f1382b) {
                                            eVar.d();
                                        }
                                        rVar2 = rVar3;
                                        View e2 = eVar2.e(eVar.f1383c[i8]);
                                        if (e2 != null && iVar.u(e2)) {
                                            q qVar4 = (q) aVar.getOrDefault(i9, z);
                                            q qVar5 = (q) aVar2.getOrDefault(e2, z);
                                            if (!(qVar4 == null || qVar5 == null)) {
                                                iVar.u.add(qVar4);
                                                iVar.v.add(qVar5);
                                                aVar.remove(i9);
                                                aVar2.remove(e2);
                                            }
                                        }
                                    }
                                    i8++;
                                    rVar3 = rVar2;
                                    z = false;
                                }
                            }
                            rVar = rVar3;
                        } else {
                            rVar = rVar3;
                            SparseArray<View> sparseArray = rVar.f2716b;
                            SparseArray<View> sparseArray2 = rVar4.f2716b;
                            int size = sparseArray.size();
                            for (int i10 = 0; i10 < size; i10++) {
                                View valueAt = sparseArray.valueAt(i10);
                                if (valueAt != null && iVar.u(valueAt) && (view2 = sparseArray2.get(sparseArray.keyAt(i10))) != null && iVar.u(view2)) {
                                    q qVar6 = (q) aVar.getOrDefault(valueAt, null);
                                    q qVar7 = (q) aVar2.getOrDefault(view2, null);
                                    if (!(qVar6 == null || qVar7 == null)) {
                                        iVar.u.add(qVar6);
                                        iVar.v.add(qVar7);
                                        aVar.remove(valueAt);
                                        aVar2.remove(view2);
                                    }
                                }
                            }
                        }
                        i3++;
                        rVar3 = rVar;
                        i = 1;
                        z = false;
                        i2 = 0;
                    }
                    for (int i11 = 0; i11 < aVar.f1413d; i11++) {
                        q qVar8 = (q) aVar.k(i11);
                        if (iVar.u(qVar8.f2713b)) {
                            iVar.u.add(qVar8);
                            iVar.v.add(null);
                        }
                    }
                    for (int i12 = 0; i12 < aVar2.f1413d; i12++) {
                        q qVar9 = (q) aVar2.k(i12);
                        if (iVar.u(qVar9.f2713b)) {
                            iVar.v.add(qVar9);
                            iVar.u.add(null);
                        }
                    }
                    b.e.a<Animator, i.b> q = i.q();
                    int i13 = q.f1413d;
                    g0 c2 = w.c(viewGroup);
                    for (int i14 = i13 - 1; i14 >= 0; i14--) {
                        Animator h2 = q.h(i14);
                        if (!(h2 == null || (orDefault = q.getOrDefault(h2, null)) == null || orDefault.f2694a == null || !c2.equals(orDefault.f2697d))) {
                            q qVar10 = orDefault.f2696c;
                            View view4 = orDefault.f2694a;
                            q s = iVar.s(view4, true);
                            q o = iVar.o(view4, true);
                            if (s == null && o == null) {
                                o = iVar.r.f2715a.get(view4);
                            }
                            if (!(s == null && o == null) && orDefault.f2698e.t(qVar10, o)) {
                                if (h2.isRunning() || h2.isStarted()) {
                                    h2.cancel();
                                } else {
                                    q.remove(h2);
                                }
                            }
                        }
                    }
                    iVar.m(viewGroup, iVar.q, iVar.r, iVar.u, iVar.v);
                    iVar.B();
                    return true;
                }
                throw null;
            }
            arrayList = null;
            arrayList2.add(this.f2705b);
            this.f2705b.a(new C0057a(a2));
            int i22 = 0;
            this.f2705b.i(this.f2706c, false);
            if (arrayList != null) {
            }
            iVar = this.f2705b;
            ViewGroup viewGroup2 = this.f2706c;
            if (iVar == null) {
            }
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.f2706c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2706c.removeOnAttachStateChangeListener(this);
            m.f2704c.remove(this.f2706c);
            ArrayList<i> arrayList = m.a().get(this.f2706c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<i> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().A(this.f2706c);
                }
            }
            this.f2705b.j(true);
        }
    }

    public static b.e.a<ViewGroup, ArrayList<i>> a() {
        b.e.a<ViewGroup, ArrayList<i>> aVar;
        WeakReference<b.e.a<ViewGroup, ArrayList<i>>> weakReference = f2703b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        b.e.a<ViewGroup, ArrayList<i>> aVar2 = new b.e.a<>();
        f2703b.set(new WeakReference<>(aVar2));
        return aVar2;
    }
}
