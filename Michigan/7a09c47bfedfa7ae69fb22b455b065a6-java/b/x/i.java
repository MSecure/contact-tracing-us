package b.x;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import b.e.e;
import b.i.l.m;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class i implements Cloneable {
    public static final int[] G = {2, 1, 3, 4};
    public static final e H = new a();
    public static ThreadLocal<b.e.a<Animator, b>> I = new ThreadLocal<>();
    public boolean A = false;
    public ArrayList<d> B = null;
    public ArrayList<Animator> C = new ArrayList<>();
    public n D;
    public c E;
    public e F = H;

    /* renamed from: b  reason: collision with root package name */
    public String f2688b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    public long f2689c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f2690d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f2691e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f2692f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<View> f2693g = new ArrayList<>();
    public ArrayList<String> h = null;
    public ArrayList<Class<?>> i = null;
    public ArrayList<Integer> j = null;
    public ArrayList<View> k = null;
    public ArrayList<Class<?>> l = null;
    public ArrayList<String> m = null;
    public ArrayList<Integer> n = null;
    public ArrayList<View> o = null;
    public ArrayList<Class<?>> p = null;
    public r q = new r();
    public r r = new r();
    public o s = null;
    public int[] t = G;
    public ArrayList<q> u;
    public ArrayList<q> v;
    public boolean w = false;
    public ArrayList<Animator> x = new ArrayList<>();
    public int y = 0;
    public boolean z = false;

    public static class a extends e {
        @Override // b.x.e
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f2694a;

        /* renamed from: b  reason: collision with root package name */
        public String f2695b;

        /* renamed from: c  reason: collision with root package name */
        public q f2696c;

        /* renamed from: d  reason: collision with root package name */
        public g0 f2697d;

        /* renamed from: e  reason: collision with root package name */
        public i f2698e;

        public b(View view, String str, i iVar, g0 g0Var, q qVar) {
            this.f2694a = view;
            this.f2695b = str;
            this.f2696c = qVar;
            this.f2697d = g0Var;
            this.f2698e = iVar;
        }
    }

    public static abstract class c {
    }

    public interface d {
        void a(i iVar);

        void b(i iVar);

        void c(i iVar);

        void d(i iVar);

        void e(i iVar);
    }

    public static void c(r rVar, View view, q qVar) {
        rVar.f2715a.put(view, qVar);
        int id = view.getId();
        if (id >= 0) {
            if (rVar.f2716b.indexOfKey(id) >= 0) {
                rVar.f2716b.put(id, null);
            } else {
                rVar.f2716b.put(id, view);
            }
        }
        String v2 = m.v(view);
        if (v2 != null) {
            if (rVar.f2718d.e(v2) >= 0) {
                rVar.f2718d.put(v2, null);
            } else {
                rVar.f2718d.put(v2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e<View> eVar = rVar.f2717c;
                if (eVar.f1382b) {
                    eVar.d();
                }
                if (b.e.d.b(eVar.f1383c, eVar.f1385e, itemIdAtPosition) >= 0) {
                    View e2 = rVar.f2717c.e(itemIdAtPosition);
                    if (e2 != null) {
                        e2.setHasTransientState(false);
                        rVar.f2717c.g(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                rVar.f2717c.g(itemIdAtPosition, view);
            }
        }
    }

    public static b.e.a<Animator, b> q() {
        b.e.a<Animator, b> aVar = I.get();
        if (aVar != null) {
            return aVar;
        }
        b.e.a<Animator, b> aVar2 = new b.e.a<>();
        I.set(aVar2);
        return aVar2;
    }

    public static boolean v(q qVar, q qVar2, String str) {
        Object obj = qVar.f2712a.get(str);
        Object obj2 = qVar2.f2712a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void A(View view) {
        if (this.z) {
            if (!this.A) {
                b.e.a<Animator, b> q2 = q();
                int i2 = q2.f1413d;
                g0 c2 = w.c(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b k2 = q2.k(i3);
                    if (k2.f2694a != null && c2.equals(k2.f2697d)) {
                        q2.h(i3).resume();
                    }
                }
                ArrayList<d> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((d) arrayList2.get(i4)).b(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public void B() {
        I();
        b.e.a<Animator, b> q2 = q();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q2.containsKey(next)) {
                I();
                if (next != null) {
                    next.addListener(new j(this, q2));
                    long j2 = this.f2690d;
                    if (j2 >= 0) {
                        next.setDuration(j2);
                    }
                    long j3 = this.f2689c;
                    if (j3 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f2691e;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new k(this));
                    next.start();
                }
            }
        }
        this.C.clear();
        n();
    }

    public i C(long j2) {
        this.f2690d = j2;
        return this;
    }

    public void D(c cVar) {
        this.E = cVar;
    }

    public i E(TimeInterpolator timeInterpolator) {
        this.f2691e = timeInterpolator;
        return this;
    }

    public void F(e eVar) {
        if (eVar == null) {
            eVar = H;
        }
        this.F = eVar;
    }

    public void G(n nVar) {
        this.D = nVar;
    }

    public i H(long j2) {
        this.f2689c = j2;
        return this;
    }

    public void I() {
        if (this.y == 0) {
            ArrayList<d> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).c(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public String J(String str) {
        StringBuilder h2 = c.a.a.a.a.h(str);
        h2.append(getClass().getSimpleName());
        h2.append("@");
        h2.append(Integer.toHexString(hashCode()));
        h2.append(": ");
        String sb = h2.toString();
        if (this.f2690d != -1) {
            sb = sb + "dur(" + this.f2690d + ") ";
        }
        if (this.f2689c != -1) {
            sb = sb + "dly(" + this.f2689c + ") ";
        }
        if (this.f2691e != null) {
            sb = sb + "interp(" + this.f2691e + ") ";
        }
        if (this.f2692f.size() <= 0 && this.f2693g.size() <= 0) {
            return sb;
        }
        String q2 = c.a.a.a.a.q(sb, "tgts(");
        if (this.f2692f.size() > 0) {
            for (int i2 = 0; i2 < this.f2692f.size(); i2++) {
                if (i2 > 0) {
                    q2 = c.a.a.a.a.q(q2, ", ");
                }
                StringBuilder h3 = c.a.a.a.a.h(q2);
                h3.append(this.f2692f.get(i2));
                q2 = h3.toString();
            }
        }
        if (this.f2693g.size() > 0) {
            for (int i3 = 0; i3 < this.f2693g.size(); i3++) {
                if (i3 > 0) {
                    q2 = c.a.a.a.a.q(q2, ", ");
                }
                StringBuilder h4 = c.a.a.a.a.h(q2);
                h4.append(this.f2693g.get(i3));
                q2 = h4.toString();
            }
        }
        return c.a.a.a.a.q(q2, ")");
    }

    public i a(d dVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(dVar);
        return this;
    }

    public i b(View view) {
        this.f2693g.add(view);
        return this;
    }

    public void d() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<d> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((d) arrayList2.get(i2)).d(this);
            }
        }
    }

    public abstract void e(q qVar);

    public final void f(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.j;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.k;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.l;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.l.get(i2).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        q qVar = new q(view);
                        if (z2) {
                            h(qVar);
                        } else {
                            e(qVar);
                        }
                        qVar.f2714c.add(this);
                        g(qVar);
                        c(z2 ? this.q : this.r, view, qVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.n;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.o;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.p;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if (this.p.get(i3).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    f(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void g(q qVar) {
    }

    public abstract void h(q qVar);

    public void i(ViewGroup viewGroup, boolean z2) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        j(z2);
        if ((this.f2692f.size() > 0 || this.f2693g.size() > 0) && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.i) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f2692f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f2692f.get(i2).intValue());
                if (findViewById != null) {
                    q qVar = new q(findViewById);
                    if (z2) {
                        h(qVar);
                    } else {
                        e(qVar);
                    }
                    qVar.f2714c.add(this);
                    g(qVar);
                    c(z2 ? this.q : this.r, findViewById, qVar);
                }
            }
            for (int i3 = 0; i3 < this.f2693g.size(); i3++) {
                View view = this.f2693g.get(i3);
                q qVar2 = new q(view);
                if (z2) {
                    h(qVar2);
                } else {
                    e(qVar2);
                }
                qVar2.f2714c.add(this);
                g(qVar2);
                c(z2 ? this.q : this.r, view, qVar2);
            }
            return;
        }
        f(viewGroup, z2);
    }

    public void j(boolean z2) {
        r rVar;
        if (z2) {
            this.q.f2715a.clear();
            this.q.f2716b.clear();
            rVar = this.q;
        } else {
            this.r.f2715a.clear();
            this.r.f2716b.clear();
            rVar = this.r;
        }
        rVar.f2717c.b();
    }

    /* renamed from: k */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.C = new ArrayList<>();
            iVar.q = new r();
            iVar.r = new r();
            iVar.u = null;
            iVar.v = null;
            return iVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        return null;
    }

    public void m(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        int i2;
        Animator animator;
        q qVar;
        View view;
        q qVar2;
        Animator animator2;
        b.e.a<Animator, b> q2 = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            q qVar3 = arrayList.get(i3);
            q qVar4 = arrayList2.get(i3);
            if (qVar3 != null && !qVar3.f2714c.contains(this)) {
                qVar3 = null;
            }
            if (qVar4 != null && !qVar4.f2714c.contains(this)) {
                qVar4 = null;
            }
            if (!(qVar3 == null && qVar4 == null)) {
                if (qVar3 == null || qVar4 == null || t(qVar3, qVar4)) {
                    Animator l2 = l(viewGroup, qVar3, qVar4);
                    if (l2 != null) {
                        if (qVar4 != null) {
                            View view2 = qVar4.f2713b;
                            String[] r2 = r();
                            if (r2 != null && r2.length > 0) {
                                qVar2 = new q(view2);
                                q qVar5 = rVar2.f2715a.get(view2);
                                if (qVar5 != null) {
                                    int i4 = 0;
                                    while (i4 < r2.length) {
                                        qVar2.f2712a.put(r2[i4], qVar5.f2712a.get(r2[i4]));
                                        i4++;
                                        l2 = l2;
                                        size = size;
                                        qVar5 = qVar5;
                                    }
                                }
                                i2 = size;
                                int i5 = q2.f1413d;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= i5) {
                                        animator2 = l2;
                                        break;
                                    }
                                    b bVar = q2.get(q2.h(i6));
                                    if (bVar.f2696c != null && bVar.f2694a == view2 && bVar.f2695b.equals(this.f2688b) && bVar.f2696c.equals(qVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                i2 = size;
                                animator2 = l2;
                                qVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            qVar = qVar2;
                        } else {
                            i2 = size;
                            view = qVar3.f2713b;
                            animator = l2;
                            qVar = null;
                        }
                        if (animator != null) {
                            q2.put(animator, new b(view, this.f2688b, this, w.c(viewGroup), qVar));
                            this.C.add(animator);
                        }
                        i3++;
                        size = i2;
                    }
                    i2 = size;
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
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i7)) - Long.MAX_VALUE));
            }
        }
    }

    public void n() {
        int i2 = this.y - 1;
        this.y = i2;
        if (i2 == 0) {
            ArrayList<d> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((d) arrayList2.get(i3)).e(this);
                }
            }
            for (int i4 = 0; i4 < this.q.f2717c.h(); i4++) {
                View i5 = this.q.f2717c.i(i4);
                if (i5 != null) {
                    m.a0(i5, false);
                }
            }
            for (int i6 = 0; i6 < this.r.f2717c.h(); i6++) {
                View i7 = this.r.f2717c.i(i6);
                if (i7 != null) {
                    m.a0(i7, false);
                }
            }
            this.A = true;
        }
    }

    public q o(View view, boolean z2) {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.o(view, z2);
        }
        ArrayList<q> arrayList = z2 ? this.u : this.v;
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
            q qVar = arrayList.get(i3);
            if (qVar == null) {
                return null;
            }
            if (qVar.f2713b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.v : this.u).get(i2);
    }

    public String[] r() {
        return null;
    }

    public q s(View view, boolean z2) {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.s(view, z2);
        }
        return (z2 ? this.q : this.r).f2715a.getOrDefault(view, null);
    }

    public boolean t(q qVar, q qVar2) {
        if (qVar == null || qVar2 == null) {
            return false;
        }
        String[] r2 = r();
        if (r2 != null) {
            for (String str : r2) {
                if (!v(qVar, qVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : qVar.f2712a.keySet()) {
            if (v(qVar, qVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public String toString() {
        return J("");
    }

    public boolean u(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.m == null || m.v(view) == null || !this.m.contains(view.getTransitionName()))) {
            return false;
        }
        if ((this.f2692f.size() == 0 && this.f2693g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f2692f.contains(Integer.valueOf(id)) || this.f2693g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(m.v(view))) {
            return true;
        }
        if (this.i != null) {
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                if (this.i.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void w(View view) {
        if (!this.A) {
            b.e.a<Animator, b> q2 = q();
            int i2 = q2.f1413d;
            g0 c2 = w.c(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b k2 = q2.k(i3);
                if (k2.f2694a != null && c2.equals(k2.f2697d)) {
                    q2.h(i3).pause();
                }
            }
            ArrayList<d> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((d) arrayList2.get(i4)).a(this);
                }
            }
            this.z = true;
        }
    }

    public i y(d dVar) {
        ArrayList<d> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public i z(View view) {
        this.f2693g.remove(view);
        return this;
    }
}
