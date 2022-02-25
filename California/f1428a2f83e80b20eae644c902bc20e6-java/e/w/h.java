package e.w;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import e.e.e;
import e.i.i.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class h implements Cloneable {
    public static final int[] v = {2, 1, 3, 4};
    public static final e w = new a();
    public static ThreadLocal<e.e.a<Animator, b>> x = new ThreadLocal<>();
    public String b = getClass().getName();
    public long c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f1921d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f1922e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f1923f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<View> f1924g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public q f1925h = new q();

    /* renamed from: i  reason: collision with root package name */
    public q f1926i = new q();

    /* renamed from: j  reason: collision with root package name */
    public n f1927j = null;

    /* renamed from: k  reason: collision with root package name */
    public int[] f1928k = v;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<p> f1929l;
    public ArrayList<p> m;
    public ArrayList<Animator> n = new ArrayList<>();
    public int o = 0;
    public boolean p = false;
    public boolean q = false;
    public ArrayList<d> r = null;
    public ArrayList<Animator> s = new ArrayList<>();
    public c t;
    public e u = w;

    public static class a extends e {
        @Override // e.w.e
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    public static class b {
        public View a;
        public String b;
        public p c;

        /* renamed from: d  reason: collision with root package name */
        public c0 f1930d;

        /* renamed from: e  reason: collision with root package name */
        public h f1931e;

        public b(View view, String str, h hVar, c0 c0Var, p pVar) {
            this.a = view;
            this.b = str;
            this.c = pVar;
            this.f1930d = c0Var;
            this.f1931e = hVar;
        }
    }

    public static abstract class c {
    }

    public interface d {
        void a(h hVar);

        void b(h hVar);

        void c(h hVar);

        void d(h hVar);

        void e(h hVar);
    }

    public static void c(q qVar, View view, p pVar) {
        qVar.a.put(view, pVar);
        int id = view.getId();
        if (id >= 0) {
            if (qVar.b.indexOfKey(id) >= 0) {
                qVar.b.put(id, null);
            } else {
                qVar.b.put(id, view);
            }
        }
        AtomicInteger atomicInteger = l.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (qVar.f1932d.e(transitionName) >= 0) {
                qVar.f1932d.put(transitionName, null);
            } else {
                qVar.f1932d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e<View> eVar = qVar.c;
                if (eVar.b) {
                    eVar.e();
                }
                if (e.e.d.b(eVar.c, eVar.f1185e, itemIdAtPosition) >= 0) {
                    View f2 = qVar.c.f(itemIdAtPosition);
                    if (f2 != null) {
                        f2.setHasTransientState(false);
                        qVar.c.j(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                qVar.c.j(itemIdAtPosition, view);
            }
        }
    }

    public static e.e.a<Animator, b> o() {
        e.e.a<Animator, b> aVar = x.get();
        if (aVar != null) {
            return aVar;
        }
        e.e.a<Animator, b> aVar2 = new e.e.a<>();
        x.set(aVar2);
        return aVar2;
    }

    public static boolean t(p pVar, p pVar2, String str) {
        Object obj = pVar.a.get(str);
        Object obj2 = pVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void A(c cVar) {
        this.t = cVar;
    }

    public h B(TimeInterpolator timeInterpolator) {
        this.f1922e = timeInterpolator;
        return this;
    }

    public void C(e eVar) {
        if (eVar == null) {
            eVar = w;
        }
        this.u = eVar;
    }

    public void D(m mVar) {
    }

    public h E(long j2) {
        this.c = j2;
        return this;
    }

    public void F() {
        if (this.o == 0) {
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).c(this);
                }
            }
            this.q = false;
        }
        this.o++;
    }

    public String G(String str) {
        StringBuilder h2 = f.a.a.a.a.h(str);
        h2.append(getClass().getSimpleName());
        h2.append("@");
        h2.append(Integer.toHexString(hashCode()));
        h2.append(": ");
        String sb = h2.toString();
        if (this.f1921d != -1) {
            StringBuilder i2 = f.a.a.a.a.i(sb, "dur(");
            i2.append(this.f1921d);
            i2.append(") ");
            sb = i2.toString();
        }
        if (this.c != -1) {
            StringBuilder i3 = f.a.a.a.a.i(sb, "dly(");
            i3.append(this.c);
            i3.append(") ");
            sb = i3.toString();
        }
        if (this.f1922e != null) {
            StringBuilder i4 = f.a.a.a.a.i(sb, "interp(");
            i4.append(this.f1922e);
            i4.append(") ");
            sb = i4.toString();
        }
        if (this.f1923f.size() <= 0 && this.f1924g.size() <= 0) {
            return sb;
        }
        String t2 = f.a.a.a.a.t(sb, "tgts(");
        if (this.f1923f.size() > 0) {
            for (int i5 = 0; i5 < this.f1923f.size(); i5++) {
                if (i5 > 0) {
                    t2 = f.a.a.a.a.t(t2, ", ");
                }
                StringBuilder h3 = f.a.a.a.a.h(t2);
                h3.append(this.f1923f.get(i5));
                t2 = h3.toString();
            }
        }
        if (this.f1924g.size() > 0) {
            for (int i6 = 0; i6 < this.f1924g.size(); i6++) {
                if (i6 > 0) {
                    t2 = f.a.a.a.a.t(t2, ", ");
                }
                StringBuilder h4 = f.a.a.a.a.h(t2);
                h4.append(this.f1924g.get(i6));
                t2 = h4.toString();
            }
        }
        return f.a.a.a.a.t(t2, ")");
    }

    public h a(d dVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(dVar);
        return this;
    }

    public h b(View view) {
        this.f1924g.add(view);
        return this;
    }

    public abstract void d(p pVar);

    public final void e(View view, boolean z) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                p pVar = new p(view);
                if (z) {
                    g(pVar);
                } else {
                    d(pVar);
                }
                pVar.c.add(this);
                f(pVar);
                c(z ? this.f1925h : this.f1926i, view, pVar);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    e(viewGroup.getChildAt(i2), z);
                }
            }
        }
    }

    public void f(p pVar) {
    }

    public abstract void g(p pVar);

    public void h(ViewGroup viewGroup, boolean z) {
        i(z);
        if (this.f1923f.size() > 0 || this.f1924g.size() > 0) {
            for (int i2 = 0; i2 < this.f1923f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f1923f.get(i2).intValue());
                if (findViewById != null) {
                    p pVar = new p(findViewById);
                    if (z) {
                        g(pVar);
                    } else {
                        d(pVar);
                    }
                    pVar.c.add(this);
                    f(pVar);
                    c(z ? this.f1925h : this.f1926i, findViewById, pVar);
                }
            }
            for (int i3 = 0; i3 < this.f1924g.size(); i3++) {
                View view = this.f1924g.get(i3);
                p pVar2 = new p(view);
                if (z) {
                    g(pVar2);
                } else {
                    d(pVar2);
                }
                pVar2.c.add(this);
                f(pVar2);
                c(z ? this.f1925h : this.f1926i, view, pVar2);
            }
            return;
        }
        e(viewGroup, z);
    }

    public void i(boolean z) {
        q qVar;
        if (z) {
            this.f1925h.a.clear();
            this.f1925h.b.clear();
            qVar = this.f1925h;
        } else {
            this.f1926i.a.clear();
            this.f1926i.b.clear();
            qVar = this.f1926i;
        }
        qVar.c.b();
    }

    /* renamed from: j */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.s = new ArrayList<>();
            hVar.f1925h = new q();
            hVar.f1926i = new q();
            hVar.f1929l = null;
            hVar.m = null;
            return hVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, p pVar, p pVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, q qVar, q qVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        int i2;
        Animator k2;
        Animator animator;
        p pVar;
        View view;
        p pVar2;
        Animator animator2;
        e.e.a<Animator, b> o2 = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            p pVar3 = arrayList.get(i3);
            p pVar4 = arrayList2.get(i3);
            if (pVar3 != null && !pVar3.c.contains(this)) {
                pVar3 = null;
            }
            if (pVar4 != null && !pVar4.c.contains(this)) {
                pVar4 = null;
            }
            if (!(pVar3 == null && pVar4 == null)) {
                if ((pVar3 == null || pVar4 == null || r(pVar3, pVar4)) && (k2 = k(viewGroup, pVar3, pVar4)) != null) {
                    if (pVar4 != null) {
                        View view2 = pVar4.b;
                        String[] p2 = p();
                        if (p2 != null && p2.length > 0) {
                            pVar2 = new p(view2);
                            p pVar5 = qVar2.a.get(view2);
                            if (pVar5 != null) {
                                int i4 = 0;
                                while (i4 < p2.length) {
                                    pVar2.a.put(p2[i4], pVar5.a.get(p2[i4]));
                                    i4++;
                                    k2 = k2;
                                    size = size;
                                    pVar5 = pVar5;
                                }
                            }
                            i2 = size;
                            int i5 = o2.f1199d;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    animator2 = k2;
                                    break;
                                }
                                b bVar = o2.get(o2.h(i6));
                                if (bVar.c != null && bVar.a == view2 && bVar.b.equals(this.b) && bVar.c.equals(pVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            animator2 = k2;
                            pVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        pVar = pVar2;
                    } else {
                        i2 = size;
                        view = pVar3.b;
                        animator = k2;
                        pVar = null;
                    }
                    if (animator != null) {
                        String str = this.b;
                        y yVar = s.a;
                        o2.put(animator, new b(view, str, this, new b0(viewGroup), pVar));
                        this.s.add(animator);
                    }
                    i3++;
                    size = i2;
                }
            }
            i2 = size;
            i3++;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.s.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i7)) - Long.MAX_VALUE));
            }
        }
    }

    public void m() {
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 == 0) {
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((d) arrayList2.get(i3)).e(this);
                }
            }
            for (int i4 = 0; i4 < this.f1925h.c.l(); i4++) {
                View m2 = this.f1925h.c.m(i4);
                if (m2 != null) {
                    AtomicInteger atomicInteger = l.a;
                    m2.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.f1926i.c.l(); i5++) {
                View m3 = this.f1926i.c.m(i5);
                if (m3 != null) {
                    AtomicInteger atomicInteger2 = l.a;
                    m3.setHasTransientState(false);
                }
            }
            this.q = true;
        }
    }

    public p n(View view, boolean z) {
        n nVar = this.f1927j;
        if (nVar != null) {
            return nVar.n(view, z);
        }
        ArrayList<p> arrayList = z ? this.f1929l : this.m;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            p pVar = arrayList.get(i3);
            if (pVar == null) {
                return null;
            }
            if (pVar.b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z ? this.m : this.f1929l).get(i2);
    }

    public String[] p() {
        return null;
    }

    public p q(View view, boolean z) {
        n nVar = this.f1927j;
        if (nVar != null) {
            return nVar.q(view, z);
        }
        return (z ? this.f1925h : this.f1926i).a.getOrDefault(view, null);
    }

    public boolean r(p pVar, p pVar2) {
        if (pVar == null || pVar2 == null) {
            return false;
        }
        String[] p2 = p();
        if (p2 != null) {
            for (String str : p2) {
                if (!t(pVar, pVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : pVar.a.keySet()) {
            if (t(pVar, pVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean s(View view) {
        return (this.f1923f.size() == 0 && this.f1924g.size() == 0) || this.f1923f.contains(Integer.valueOf(view.getId())) || this.f1924g.contains(view);
    }

    public String toString() {
        return G("");
    }

    public void u(View view) {
        if (!this.q) {
            e.e.a<Animator, b> o2 = o();
            int i2 = o2.f1199d;
            y yVar = s.a;
            b0 b0Var = new b0(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b k2 = o2.k(i3);
                if (k2.a != null && b0Var.equals(k2.f1930d)) {
                    o2.h(i3).pause();
                }
            }
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((d) arrayList2.get(i4)).a(this);
                }
            }
            this.p = true;
        }
    }

    public h v(d dVar) {
        ArrayList<d> arrayList = this.r;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.r.size() == 0) {
            this.r = null;
        }
        return this;
    }

    public h w(View view) {
        this.f1924g.remove(view);
        return this;
    }

    public void x(View view) {
        if (this.p) {
            if (!this.q) {
                e.e.a<Animator, b> o2 = o();
                int i2 = o2.f1199d;
                y yVar = s.a;
                b0 b0Var = new b0(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b k2 = o2.k(i3);
                    if (k2.a != null && b0Var.equals(k2.f1930d)) {
                        o2.h(i3).resume();
                    }
                }
                ArrayList<d> arrayList = this.r;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.r.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((d) arrayList2.get(i4)).b(this);
                    }
                }
            }
            this.p = false;
        }
    }

    public void y() {
        F();
        e.e.a<Animator, b> o2 = o();
        Iterator<Animator> it = this.s.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (o2.containsKey(next)) {
                F();
                if (next != null) {
                    next.addListener(new i(this, o2));
                    long j2 = this.f1921d;
                    if (j2 >= 0) {
                        next.setDuration(j2);
                    }
                    long j3 = this.c;
                    if (j3 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f1922e;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new j(this));
                    next.start();
                }
            }
        }
        this.s.clear();
        m();
    }

    public h z(long j2) {
        this.f1921d = j2;
        return this;
    }
}
