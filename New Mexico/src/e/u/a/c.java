package e.u.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e.j.j.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c extends x {
    public static TimeInterpolator s;

    /* renamed from: h */
    public ArrayList<RecyclerView.b0> f1968h = new ArrayList<>();

    /* renamed from: i */
    public ArrayList<RecyclerView.b0> f1969i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<e> f1970j = new ArrayList<>();

    /* renamed from: k */
    public ArrayList<d> f1971k = new ArrayList<>();

    /* renamed from: l */
    public ArrayList<ArrayList<RecyclerView.b0>> f1972l = new ArrayList<>();
    public ArrayList<ArrayList<e>> m = new ArrayList<>();
    public ArrayList<ArrayList<d>> n = new ArrayList<>();
    public ArrayList<RecyclerView.b0> o = new ArrayList<>();
    public ArrayList<RecyclerView.b0> p = new ArrayList<>();
    public ArrayList<RecyclerView.b0> q = new ArrayList<>();
    public ArrayList<RecyclerView.b0> r = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ ArrayList b;

        public a(ArrayList arrayList) {
            c.this = r1;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                c cVar = c.this;
                RecyclerView.b0 b0Var = eVar.a;
                int i2 = eVar.b;
                int i3 = eVar.c;
                int i4 = eVar.f1976d;
                int i5 = eVar.f1977e;
                Objects.requireNonNull(cVar);
                View view = b0Var.a;
                int i6 = i4 - i2;
                int i7 = i5 - i3;
                if (i6 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i7 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                cVar.p.add(b0Var);
                animate.setDuration(cVar.f234e).setListener(new f(cVar, b0Var, i6, view, i7, animate)).start();
            }
            this.b.clear();
            c.this.m.remove(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ ArrayList b;

        public b(ArrayList arrayList) {
            c.this = r1;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                c cVar = c.this;
                Objects.requireNonNull(cVar);
                RecyclerView.b0 b0Var = dVar.a;
                View view = null;
                View view2 = b0Var == null ? null : b0Var.a;
                RecyclerView.b0 b0Var2 = dVar.b;
                if (b0Var2 != null) {
                    view = b0Var2.a;
                }
                if (view2 != null) {
                    ViewPropertyAnimator duration = view2.animate().setDuration(cVar.f235f);
                    cVar.r.add(dVar.a);
                    duration.translationX((float) (dVar.f1974e - dVar.c));
                    duration.translationY((float) (dVar.f1975f - dVar.f1973d));
                    duration.alpha(0.0f).setListener(new g(cVar, dVar, duration, view2)).start();
                }
                if (view != null) {
                    ViewPropertyAnimator animate = view.animate();
                    cVar.r.add(dVar.b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(cVar.f235f).alpha(1.0f).setListener(new h(cVar, dVar, animate, view)).start();
                }
            }
            this.b.clear();
            c.this.n.remove(this.b);
        }
    }

    /* renamed from: e.u.a.c$c */
    /* loaded from: classes.dex */
    public class RunnableC0060c implements Runnable {
        public final /* synthetic */ ArrayList b;

        public RunnableC0060c(ArrayList arrayList) {
            c.this = r1;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                RecyclerView.b0 b0Var = (RecyclerView.b0) it.next();
                c cVar = c.this;
                Objects.requireNonNull(cVar);
                View view = b0Var.a;
                ViewPropertyAnimator animate = view.animate();
                cVar.o.add(b0Var);
                animate.alpha(1.0f).setDuration(cVar.c).setListener(new e(cVar, b0Var, view, animate)).start();
            }
            this.b.clear();
            c.this.f1972l.remove(this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public RecyclerView.b0 a;
        public RecyclerView.b0 b;
        public int c;

        /* renamed from: d */
        public int f1973d;

        /* renamed from: e */
        public int f1974e;

        /* renamed from: f */
        public int f1975f;

        public d(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i2, int i3, int i4, int i5) {
            this.a = b0Var;
            this.b = b0Var2;
            this.c = i2;
            this.f1973d = i3;
            this.f1974e = i4;
            this.f1975f = i5;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("ChangeInfo{oldHolder=");
            h2.append(this.a);
            h2.append(", newHolder=");
            h2.append(this.b);
            h2.append(", fromX=");
            h2.append(this.c);
            h2.append(", fromY=");
            h2.append(this.f1973d);
            h2.append(", toX=");
            h2.append(this.f1974e);
            h2.append(", toY=");
            h2.append(this.f1975f);
            h2.append('}');
            return h2.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public RecyclerView.b0 a;
        public int b;
        public int c;

        /* renamed from: d */
        public int f1976d;

        /* renamed from: e */
        public int f1977e;

        public e(RecyclerView.b0 b0Var, int i2, int i3, int i4, int i5) {
            this.a = b0Var;
            this.b = i2;
            this.c = i3;
            this.f1976d = i4;
            this.f1977e = i5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean f(RecyclerView.b0 b0Var, List<Object> list) {
        return !list.isEmpty() || o(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void i(RecyclerView.b0 b0Var) {
        View view = b0Var.a;
        view.animate().cancel();
        int size = this.f1970j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f1970j.get(size).a == b0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                g(b0Var);
                this.f1970j.remove(size);
            }
        }
        r(this.f1971k, b0Var);
        if (this.f1968h.remove(b0Var)) {
            view.setAlpha(1.0f);
            g(b0Var);
        }
        if (this.f1969i.remove(b0Var)) {
            view.setAlpha(1.0f);
            g(b0Var);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<d> arrayList = this.n.get(size2);
            r(arrayList, b0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<e> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).a == b0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    g(b0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.f1972l.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList<RecyclerView.b0> arrayList3 = this.f1972l.get(size5);
                if (arrayList3.remove(b0Var)) {
                    view.setAlpha(1.0f);
                    g(b0Var);
                    if (arrayList3.isEmpty()) {
                        this.f1972l.remove(size5);
                    }
                }
            } else {
                this.q.remove(b0Var);
                this.o.remove(b0Var);
                this.r.remove(b0Var);
                this.p.remove(b0Var);
                q();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void j() {
        int size = this.f1970j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = this.f1970j.get(size);
            View view = eVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            g(eVar.a);
            this.f1970j.remove(size);
        }
        int size2 = this.f1968h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            g(this.f1968h.get(size2));
            this.f1968h.remove(size2);
        }
        int size3 = this.f1969i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.b0 b0Var = this.f1969i.get(size3);
            b0Var.a.setAlpha(1.0f);
            g(b0Var);
            this.f1969i.remove(size3);
        }
        int size4 = this.f1971k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = this.f1971k.get(size4);
            RecyclerView.b0 b0Var2 = dVar.a;
            if (b0Var2 != null) {
                s(dVar, b0Var2);
            }
            RecyclerView.b0 b0Var3 = dVar.b;
            if (b0Var3 != null) {
                s(dVar, b0Var3);
            }
        }
        this.f1971k.clear();
        if (k()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList<e> arrayList = this.m.get(size5);
                int size6 = arrayList.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        e eVar2 = arrayList.get(size6);
                        View view2 = eVar2.a.a;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        g(eVar2.a);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.m.remove(arrayList);
                        }
                    }
                }
            }
            int size7 = this.f1972l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList<RecyclerView.b0> arrayList2 = this.f1972l.get(size7);
                int size8 = arrayList2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.b0 b0Var4 = arrayList2.get(size8);
                        b0Var4.a.setAlpha(1.0f);
                        g(b0Var4);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.f1972l.remove(arrayList2);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList<d> arrayList3 = this.n.get(size9);
                    int size10 = arrayList3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            d dVar2 = arrayList3.get(size10);
                            RecyclerView.b0 b0Var5 = dVar2.a;
                            if (b0Var5 != null) {
                                s(dVar2, b0Var5);
                            }
                            RecyclerView.b0 b0Var6 = dVar2.b;
                            if (b0Var6 != null) {
                                s(dVar2, b0Var6);
                            }
                            if (arrayList3.isEmpty()) {
                                this.n.remove(arrayList3);
                            }
                        }
                    }
                } else {
                    p(this.q);
                    p(this.p);
                    p(this.o);
                    p(this.r);
                    h();
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean k() {
        return !this.f1969i.isEmpty() || !this.f1971k.isEmpty() || !this.f1970j.isEmpty() || !this.f1968h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.f1972l.isEmpty() || !this.n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void m() {
        boolean z = !this.f1968h.isEmpty();
        boolean z2 = !this.f1970j.isEmpty();
        boolean z3 = !this.f1971k.isEmpty();
        boolean z4 = !this.f1969i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.b0> it = this.f1968h.iterator();
            while (it.hasNext()) {
                RecyclerView.b0 next = it.next();
                View view = next.a;
                ViewPropertyAnimator animate = view.animate();
                this.q.add(next);
                animate.setDuration(this.f233d).alpha(0.0f).setListener(new d(this, next, animate, view)).start();
            }
            this.f1968h.clear();
            if (z2) {
                ArrayList<e> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1970j);
                this.m.add(arrayList);
                this.f1970j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    View view2 = arrayList.get(0).a.a;
                    long j2 = this.f233d;
                    AtomicInteger atomicInteger = v.a;
                    v.d.n(view2, aVar, j2);
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1971k);
                this.n.add(arrayList2);
                this.f1971k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    View view3 = arrayList2.get(0).a.a;
                    long j3 = this.f233d;
                    AtomicInteger atomicInteger2 = v.a;
                    v.d.n(view3, bVar, j3);
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.b0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1969i);
                this.f1972l.add(arrayList3);
                this.f1969i.clear();
                RunnableC0060c cVar = new RunnableC0060c(arrayList3);
                if (z || z2 || z3) {
                    long j4 = 0;
                    long j5 = z ? this.f233d : 0;
                    long j6 = z2 ? this.f234e : 0;
                    if (z3) {
                        j4 = this.f235f;
                    }
                    View view4 = arrayList3.get(0).a;
                    AtomicInteger atomicInteger3 = v.a;
                    v.d.n(view4, cVar, Math.max(j6, j4) + j5);
                    return;
                }
                cVar.run();
            }
        }
    }

    @Override // e.u.a.x
    public boolean n(RecyclerView.b0 b0Var, int i2, int i3, int i4, int i5) {
        View view = b0Var.a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) b0Var.a.getTranslationY());
        t(b0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            g(b0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.f1970j.add(new e(b0Var, translationX, translationY, i4, i5));
        return true;
    }

    public void p(List<RecyclerView.b0> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                list.get(size).a.animate().cancel();
            } else {
                return;
            }
        }
    }

    public void q() {
        if (!k()) {
            h();
        }
    }

    public final void r(List<d> list, RecyclerView.b0 b0Var) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = list.get(size);
                if (s(dVar, b0Var) && dVar.a == null && dVar.b == null) {
                    list.remove(dVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean s(d dVar, RecyclerView.b0 b0Var) {
        if (dVar.b == b0Var) {
            dVar.b = null;
        } else if (dVar.a != b0Var) {
            return false;
        } else {
            dVar.a = null;
        }
        b0Var.a.setAlpha(1.0f);
        b0Var.a.setTranslationX(0.0f);
        b0Var.a.setTranslationY(0.0f);
        g(b0Var);
        return true;
    }

    public final void t(RecyclerView.b0 b0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        b0Var.a.animate().setInterpolator(s);
        i(b0Var);
    }
}
