package b.v;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
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
    public String f1801b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    public long f1802c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f1803d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f1804e = null;
    public ArrayList<Integer> f = new ArrayList<>();
    public ArrayList<View> g = new ArrayList<>();
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
        @Override // b.v.e
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f1805a;

        /* renamed from: b  reason: collision with root package name */
        public String f1806b;

        /* renamed from: c  reason: collision with root package name */
        public q f1807c;

        /* renamed from: d  reason: collision with root package name */
        public f0 f1808d;

        /* renamed from: e  reason: collision with root package name */
        public i f1809e;

        public b(View view, String str, i iVar, f0 f0Var, q qVar) {
            this.f1805a = view;
            this.f1806b = str;
            this.f1807c = qVar;
            this.f1808d = f0Var;
            this.f1809e = iVar;
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
        rVar.f1826a.put(view, qVar);
        int id = view.getId();
        if (id >= 0) {
            if (rVar.f1827b.indexOfKey(id) >= 0) {
                rVar.f1827b.put(id, null);
            } else {
                rVar.f1827b.put(id, view);
            }
        }
        String u2 = m.u(view);
        if (u2 != null) {
            if (rVar.f1829d.e(u2) >= 0) {
                rVar.f1829d.put(u2, null);
            } else {
                rVar.f1829d.put(u2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e<View> eVar = rVar.f1828c;
                if (eVar.f803b) {
                    eVar.d();
                }
                if (b.e.d.b(eVar.f804c, eVar.f806e, itemIdAtPosition) >= 0) {
                    View e2 = rVar.f1828c.e(itemIdAtPosition);
                    if (e2 != null) {
                        e2.setHasTransientState(false);
                        rVar.f1828c.g(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                rVar.f1828c.g(itemIdAtPosition, view);
            }
        }
    }

    public static b.e.a<Animator, b> p() {
        b.e.a<Animator, b> aVar = I.get();
        if (aVar != null) {
            return aVar;
        }
        b.e.a<Animator, b> aVar2 = new b.e.a<>();
        I.set(aVar2);
        return aVar2;
    }

    public static boolean u(q qVar, q qVar2, String str) {
        Object obj = qVar.f1823a.get(str);
        Object obj2 = qVar2.f1823a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public i A(long j2) {
        this.f1803d = j2;
        return this;
    }

    public void B(c cVar) {
        this.E = cVar;
    }

    public i C(TimeInterpolator timeInterpolator) {
        this.f1804e = timeInterpolator;
        return this;
    }

    public void D(e eVar) {
        if (eVar == null) {
            eVar = H;
        }
        this.F = eVar;
    }

    public void E(n nVar) {
        this.D = nVar;
    }

    public i F(long j2) {
        this.f1802c = j2;
        return this;
    }

    public void G() {
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

    public String H(String str) {
        StringBuilder g2 = c.a.a.a.a.g(str);
        g2.append(getClass().getSimpleName());
        g2.append("@");
        g2.append(Integer.toHexString(hashCode()));
        g2.append(": ");
        String sb = g2.toString();
        if (this.f1803d != -1) {
            sb = sb + "dur(" + this.f1803d + ") ";
        }
        if (this.f1802c != -1) {
            sb = sb + "dly(" + this.f1802c + ") ";
        }
        if (this.f1804e != null) {
            sb = sb + "interp(" + this.f1804e + ") ";
        }
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            return sb;
        }
        String o2 = c.a.a.a.a.o(sb, "tgts(");
        if (this.f.size() > 0) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (i2 > 0) {
                    o2 = c.a.a.a.a.o(o2, ", ");
                }
                StringBuilder g3 = c.a.a.a.a.g(o2);
                g3.append(this.f.get(i2));
                o2 = g3.toString();
            }
        }
        if (this.g.size() > 0) {
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                if (i3 > 0) {
                    o2 = c.a.a.a.a.o(o2, ", ");
                }
                StringBuilder g4 = c.a.a.a.a.g(o2);
                g4.append(this.g.get(i3));
                o2 = g4.toString();
            }
        }
        return c.a.a.a.a.o(o2, ")");
    }

    public i a(d dVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(dVar);
        return this;
    }

    public i b(View view) {
        this.g.add(view);
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
                        qVar.f1825c.add(this);
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
        if ((this.f.size() > 0 || this.g.size() > 0) && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.i) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f.get(i2).intValue());
                if (findViewById != null) {
                    q qVar = new q(findViewById);
                    if (z2) {
                        h(qVar);
                    } else {
                        e(qVar);
                    }
                    qVar.f1825c.add(this);
                    g(qVar);
                    c(z2 ? this.q : this.r, findViewById, qVar);
                }
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                View view = this.g.get(i3);
                q qVar2 = new q(view);
                if (z2) {
                    h(qVar2);
                } else {
                    e(qVar2);
                }
                qVar2.f1825c.add(this);
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
            this.q.f1826a.clear();
            this.q.f1827b.clear();
            rVar = this.q;
        } else {
            this.r.f1826a.clear();
            this.r.f1827b.clear();
            rVar = this.r;
        }
        rVar.f1828c.b();
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
        b.e.a<Animator, b> p2 = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            q qVar3 = arrayList.get(i3);
            q qVar4 = arrayList2.get(i3);
            if (qVar3 != null && !qVar3.f1825c.contains(this)) {
                qVar3 = null;
            }
            if (qVar4 != null && !qVar4.f1825c.contains(this)) {
                qVar4 = null;
            }
            if (!(qVar3 == null && qVar4 == null)) {
                if (qVar3 == null || qVar4 == null || s(qVar3, qVar4)) {
                    Animator l2 = l(viewGroup, qVar3, qVar4);
                    if (l2 != null) {
                        if (qVar4 != null) {
                            View view2 = qVar4.f1824b;
                            String[] q2 = q();
                            if (q2 != null && q2.length > 0) {
                                qVar2 = new q(view2);
                                q qVar5 = rVar2.f1826a.get(view2);
                                if (qVar5 != null) {
                                    int i4 = 0;
                                    while (i4 < q2.length) {
                                        qVar2.f1823a.put(q2[i4], qVar5.f1823a.get(q2[i4]));
                                        i4++;
                                        l2 = l2;
                                        size = size;
                                        qVar5 = qVar5;
                                    }
                                }
                                i2 = size;
                                int i5 = p2.f829d;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= i5) {
                                        animator2 = l2;
                                        break;
                                    }
                                    b bVar = p2.get(p2.h(i6));
                                    if (bVar.f1807c != null && bVar.f1805a == view2 && bVar.f1806b.equals(this.f1801b) && bVar.f1807c.equals(qVar2)) {
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
                            view = qVar3.f1824b;
                            animator = l2;
                            qVar = null;
                        }
                        if (animator != null) {
                            p2.put(animator, new b(view, this.f1801b, this, v.c(viewGroup), qVar));
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
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i7)) - RecyclerView.FOREVER_NS));
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
            for (int i4 = 0; i4 < this.q.f1828c.h(); i4++) {
                View i5 = this.q.f1828c.i(i4);
                if (i5 != null) {
                    m.Z(i5, false);
                }
            }
            for (int i6 = 0; i6 < this.r.f1828c.h(); i6++) {
                View i7 = this.r.f1828c.i(i6);
                if (i7 != null) {
                    m.Z(i7, false);
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
            if (qVar.f1824b == view) {
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

    public String[] q() {
        return null;
    }

    public q r(View view, boolean z2) {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.r(view, z2);
        }
        return (z2 ? this.q : this.r).f1826a.getOrDefault(view, null);
    }

    public boolean s(q qVar, q qVar2) {
        if (qVar == null || qVar2 == null) {
            return false;
        }
        String[] q2 = q();
        if (q2 != null) {
            for (String str : q2) {
                if (!u(qVar, qVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : qVar.f1823a.keySet()) {
            if (u(qVar, qVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean t(View view) {
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
        if (!(this.m == null || m.u(view) == null || !this.m.contains(view.getTransitionName()))) {
            return false;
        }
        if ((this.f.size() == 0 && this.g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f.contains(Integer.valueOf(id)) || this.g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(m.u(view))) {
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

    public String toString() {
        return H("");
    }

    public void v(View view) {
        if (!this.A) {
            b.e.a<Animator, b> p2 = p();
            int i2 = p2.f829d;
            f0 c2 = v.c(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b k2 = p2.k(i3);
                if (k2.f1805a != null && c2.equals(k2.f1808d)) {
                    p2.h(i3).pause();
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

    public i w(d dVar) {
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

    public i x(View view) {
        this.g.remove(view);
        return this;
    }

    public void y(View view) {
        if (this.z) {
            if (!this.A) {
                b.e.a<Animator, b> p2 = p();
                int i2 = p2.f829d;
                f0 c2 = v.c(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b k2 = p2.k(i3);
                    if (k2.f1805a != null && c2.equals(k2.f1808d)) {
                        p2.h(i3).resume();
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

    public void z() {
        G();
        b.e.a<Animator, b> p2 = p();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (p2.containsKey(next)) {
                G();
                if (next != null) {
                    next.addListener(new j(this, p2));
                    long j2 = this.f1803d;
                    if (j2 >= 0) {
                        next.setDuration(j2);
                    }
                    long j3 = this.f1802c;
                    if (j3 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f1804e;
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
}
