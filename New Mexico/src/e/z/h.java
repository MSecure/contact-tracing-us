package e.z;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import e.f.e;
import e.j.j.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class h implements Cloneable {
    public static final int[] v = {2, 1, 3, 4};
    public static final e w = new a();
    public static ThreadLocal<e.f.a<Animator, b>> x = new ThreadLocal<>();

    /* renamed from: l */
    public ArrayList<p> f2139l;
    public ArrayList<p> m;
    public c t;
    public String b = getClass().getName();
    public long c = -1;

    /* renamed from: d */
    public long f2131d = -1;

    /* renamed from: e */
    public TimeInterpolator f2132e = null;

    /* renamed from: f */
    public ArrayList<Integer> f2133f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<View> f2134g = new ArrayList<>();

    /* renamed from: h */
    public q f2135h = new q();

    /* renamed from: i */
    public q f2136i = new q();

    /* renamed from: j */
    public n f2137j = null;

    /* renamed from: k */
    public int[] f2138k = v;
    public ArrayList<Animator> n = new ArrayList<>();
    public int o = 0;
    public boolean p = false;
    public boolean q = false;
    public ArrayList<d> r = null;
    public ArrayList<Animator> s = new ArrayList<>();
    public e u = w;

    /* loaded from: classes.dex */
    public static class a extends e {
        @Override // e.z.e
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public View a;
        public String b;
        public p c;

        /* renamed from: d */
        public c0 f2140d;

        /* renamed from: e */
        public h f2141e;

        public b(View view, String str, h hVar, c0 c0Var, p pVar) {
            this.a = view;
            this.b = str;
            this.c = pVar;
            this.f2140d = c0Var;
            this.f2141e = hVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
    }

    /* loaded from: classes.dex */
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
        AtomicInteger atomicInteger = v.a;
        String k2 = v.i.k(view);
        if (k2 != null) {
            if (qVar.f2142d.e(k2) >= 0) {
                qVar.f2142d.put(k2, null);
            } else {
                qVar.f2142d.put(k2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e<View> eVar = qVar.c;
                if (eVar.b) {
                    eVar.d();
                }
                if (e.f.d.b(eVar.c, eVar.f1302e, itemIdAtPosition) >= 0) {
                    View e2 = qVar.c.e(itemIdAtPosition);
                    if (e2 != null) {
                        v.d.r(e2, false);
                        qVar.c.g(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                v.d.r(view, true);
                qVar.c.g(itemIdAtPosition, view);
            }
        }
    }

    public static e.f.a<Animator, b> o() {
        e.f.a<Animator, b> aVar = x.get();
        if (aVar != null) {
            return aVar;
        }
        e.f.a<Animator, b> aVar2 = new e.f.a<>();
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
        this.f2132e = timeInterpolator;
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
        if (this.f2131d != -1) {
            StringBuilder i2 = f.a.a.a.a.i(sb, "dur(");
            i2.append(this.f2131d);
            i2.append(") ");
            sb = i2.toString();
        }
        if (this.c != -1) {
            StringBuilder i3 = f.a.a.a.a.i(sb, "dly(");
            i3.append(this.c);
            i3.append(") ");
            sb = i3.toString();
        }
        if (this.f2132e != null) {
            StringBuilder i4 = f.a.a.a.a.i(sb, "interp(");
            i4.append(this.f2132e);
            i4.append(") ");
            sb = i4.toString();
        }
        if (this.f2133f.size() <= 0 && this.f2134g.size() <= 0) {
            return sb;
        }
        String x2 = f.a.a.a.a.x(sb, "tgts(");
        if (this.f2133f.size() > 0) {
            for (int i5 = 0; i5 < this.f2133f.size(); i5++) {
                if (i5 > 0) {
                    x2 = f.a.a.a.a.x(x2, ", ");
                }
                StringBuilder h3 = f.a.a.a.a.h(x2);
                h3.append(this.f2133f.get(i5));
                x2 = h3.toString();
            }
        }
        if (this.f2134g.size() > 0) {
            for (int i6 = 0; i6 < this.f2134g.size(); i6++) {
                if (i6 > 0) {
                    x2 = f.a.a.a.a.x(x2, ", ");
                }
                StringBuilder h4 = f.a.a.a.a.h(x2);
                h4.append(this.f2134g.get(i6));
                x2 = h4.toString();
            }
        }
        return f.a.a.a.a.x(x2, ")");
    }

    public h a(d dVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(dVar);
        return this;
    }

    public h b(View view) {
        this.f2134g.add(view);
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
                c(z ? this.f2135h : this.f2136i, view, pVar);
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
        if (this.f2133f.size() > 0 || this.f2134g.size() > 0) {
            for (int i2 = 0; i2 < this.f2133f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f2133f.get(i2).intValue());
                if (findViewById != null) {
                    p pVar = new p(findViewById);
                    if (z) {
                        g(pVar);
                    } else {
                        d(pVar);
                    }
                    pVar.c.add(this);
                    f(pVar);
                    c(z ? this.f2135h : this.f2136i, findViewById, pVar);
                }
            }
            for (int i3 = 0; i3 < this.f2134g.size(); i3++) {
                View view = this.f2134g.get(i3);
                p pVar2 = new p(view);
                if (z) {
                    g(pVar2);
                } else {
                    d(pVar2);
                }
                pVar2.c.add(this);
                f(pVar2);
                c(z ? this.f2135h : this.f2136i, view, pVar2);
            }
            return;
        }
        e(viewGroup, z);
    }

    public void i(boolean z) {
        q qVar;
        if (z) {
            this.f2135h.a.clear();
            this.f2135h.b.clear();
            qVar = this.f2135h;
        } else {
            this.f2136i.a.clear();
            this.f2136i.b.clear();
            qVar = this.f2136i;
        }
        qVar.c.b();
    }

    /* renamed from: j */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.s = new ArrayList<>();
            hVar.f2135h = new q();
            hVar.f2136i = new q();
            hVar.f2139l = null;
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
        e.f.a<Animator, b> o = o();
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
                        String[] p = p();
                        if (p != null && p.length > 0) {
                            pVar2 = new p(view2);
                            p pVar5 = qVar2.a.get(view2);
                            if (pVar5 != null) {
                                int i4 = 0;
                                while (i4 < p.length) {
                                    pVar2.a.put(p[i4], pVar5.a.get(p[i4]));
                                    i4++;
                                    k2 = k2;
                                    size = size;
                                    pVar5 = pVar5;
                                }
                            }
                            i2 = size;
                            int i5 = o.f1316d;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    animator2 = k2;
                                    break;
                                }
                                b bVar = o.get(o.h(i6));
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
                        o.put(animator, new b(view, str, this, new b0(viewGroup), pVar));
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
            for (int i4 = 0; i4 < this.f2135h.c.h(); i4++) {
                View i5 = this.f2135h.c.i(i4);
                if (i5 != null) {
                    AtomicInteger atomicInteger = v.a;
                    v.d.r(i5, false);
                }
            }
            for (int i6 = 0; i6 < this.f2136i.c.h(); i6++) {
                View i7 = this.f2136i.c.i(i6);
                if (i7 != null) {
                    AtomicInteger atomicInteger2 = v.a;
                    v.d.r(i7, false);
                }
            }
            this.q = true;
        }
    }

    public p n(View view, boolean z) {
        n nVar = this.f2137j;
        if (nVar != null) {
            return nVar.n(view, z);
        }
        ArrayList<p> arrayList = z ? this.f2139l : this.m;
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
        return (z ? this.m : this.f2139l).get(i2);
    }

    public String[] p() {
        return null;
    }

    public p q(View view, boolean z) {
        n nVar = this.f2137j;
        if (nVar != null) {
            return nVar.q(view, z);
        }
        return (z ? this.f2135h : this.f2136i).a.getOrDefault(view, null);
    }

    public boolean r(p pVar, p pVar2) {
        if (pVar == null || pVar2 == null) {
            return false;
        }
        String[] p = p();
        if (p != null) {
            for (String str : p) {
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
        return (this.f2133f.size() == 0 && this.f2134g.size() == 0) || this.f2133f.contains(Integer.valueOf(view.getId())) || this.f2134g.contains(view);
    }

    @Override // java.lang.Object
    public String toString() {
        return G("");
    }

    public void u(View view) {
        if (!this.q) {
            e.f.a<Animator, b> o = o();
            int i2 = o.f1316d;
            y yVar = s.a;
            b0 b0Var = new b0(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b k2 = o.k(i3);
                if (k2.a != null && b0Var.equals(k2.f2140d)) {
                    o.h(i3).pause();
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
        this.f2134g.remove(view);
        return this;
    }

    public void x(View view) {
        if (this.p) {
            if (!this.q) {
                e.f.a<Animator, b> o = o();
                int i2 = o.f1316d;
                y yVar = s.a;
                b0 b0Var = new b0(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b k2 = o.k(i3);
                    if (k2.a != null && b0Var.equals(k2.f2140d)) {
                        o.h(i3).resume();
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
        e.f.a<Animator, b> o = o();
        Iterator<Animator> it = this.s.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (o.containsKey(next)) {
                F();
                if (next != null) {
                    next.addListener(new i(this, o));
                    long j2 = this.f2131d;
                    if (j2 >= 0) {
                        next.setDuration(j2);
                    }
                    long j3 = this.c;
                    if (j3 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f2132e;
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
        this.f2131d = j2;
        return this;
    }
}
