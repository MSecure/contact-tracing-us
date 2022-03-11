package e.o.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import e.j.f.a;
import e.j.j.v;
import e.o.a.e0;
import e.o.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a1 {
    public final ViewGroup a;
    public final ArrayList<d> b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();

    /* renamed from: d */
    public boolean f1743d = false;

    /* renamed from: e */
    public boolean f1744e = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            a1.this = r1;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a1.this.b.contains(this.b)) {
                c cVar = this.b;
                cVar.a.a(cVar.c.F);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            a1.this = r1;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.b.remove(this.b);
            a1.this.c.remove(this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {

        /* renamed from: h */
        public final k0 f1745h;

        public c(d.c cVar, d.b bVar, k0 k0Var, e.j.f.a aVar) {
            super(cVar, bVar, k0Var.c, aVar);
            this.f1745h = k0Var;
        }

        @Override // e.o.a.a1.d
        public void b() {
            super.b();
            this.f1745h.k();
        }

        @Override // e.o.a.a1.d
        public void d() {
            if (this.b == d.b.ADDING) {
                m mVar = this.f1745h.c;
                View findFocus = mVar.F.findFocus();
                if (findFocus != null) {
                    mVar.f().o = findFocus;
                    if (e0.P(2)) {
                        String str = "requestFocus: Saved focused view " + findFocus + " for Fragment " + mVar;
                    }
                }
                View w0 = this.c.w0();
                if (w0.getParent() == null) {
                    this.f1745h.b();
                    w0.setAlpha(0.0f);
                }
                if (w0.getAlpha() == 0.0f && w0.getVisibility() == 0) {
                    w0.setVisibility(4);
                }
                m.d dVar = mVar.I;
                w0.setAlpha(dVar == null ? 1.0f : dVar.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public c a;
        public b b;
        public final m c;

        /* renamed from: d */
        public final List<Runnable> f1746d = new ArrayList();

        /* renamed from: e */
        public final HashSet<e.j.f.a> f1747e = new HashSet<>();

        /* renamed from: f */
        public boolean f1748f = false;

        /* renamed from: g */
        public boolean f1749g = false;

        /* loaded from: classes.dex */
        public class a implements a.AbstractC0038a {
            public a() {
                d.this = r1;
            }

            @Override // e.j.f.a.AbstractC0038a
            public void a() {
                d.this.a();
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(f.a.a.a.a.u("Unknown visibility ", i2));
            }

            public static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public void a(View view) {
                int i2;
                int ordinal = ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        if (e0.P(2)) {
                            String str = "SpecialEffectsController: Setting view " + view + " to VISIBLE";
                        }
                        i2 = 0;
                    } else if (ordinal == 2) {
                        if (e0.P(2)) {
                            String str2 = "SpecialEffectsController: Setting view " + view + " to GONE";
                        }
                        i2 = 8;
                    } else if (ordinal == 3) {
                        if (e0.P(2)) {
                            String str3 = "SpecialEffectsController: Setting view " + view + " to INVISIBLE";
                        }
                        i2 = 4;
                    } else {
                        return;
                    }
                    view.setVisibility(i2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (e0.P(2)) {
                        String str4 = "SpecialEffectsController: Removing view " + view + " from container " + viewGroup;
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        public d(c cVar, b bVar, m mVar, e.j.f.a aVar) {
            this.a = cVar;
            this.b = bVar;
            this.c = mVar;
            aVar.b(new a());
        }

        public final void a() {
            if (!this.f1748f) {
                this.f1748f = true;
                if (this.f1747e.isEmpty()) {
                    b();
                    return;
                }
                Iterator it = new ArrayList(this.f1747e).iterator();
                while (it.hasNext()) {
                    ((e.j.f.a) it.next()).a();
                }
            }
        }

        public void b() {
            if (!this.f1749g) {
                if (e0.P(2)) {
                    String str = "SpecialEffectsController: " + this + " has called complete.";
                }
                this.f1749g = true;
                for (Runnable runnable : this.f1746d) {
                    runnable.run();
                }
            }
        }

        public final void c(c cVar, b bVar) {
            b bVar2;
            c cVar2 = c.REMOVED;
            int ordinal = bVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        if (e0.P(2)) {
                            StringBuilder h2 = f.a.a.a.a.h("SpecialEffectsController: For fragment ");
                            h2.append(this.c);
                            h2.append(" mFinalState = ");
                            h2.append(this.a);
                            h2.append(" -> REMOVED. mLifecycleImpact  = ");
                            h2.append(this.b);
                            h2.append(" to REMOVING.");
                            h2.toString();
                        }
                        this.a = cVar2;
                        bVar2 = b.REMOVING;
                    } else {
                        return;
                    }
                } else if (this.a == cVar2) {
                    if (e0.P(2)) {
                        StringBuilder h3 = f.a.a.a.a.h("SpecialEffectsController: For fragment ");
                        h3.append(this.c);
                        h3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        h3.append(this.b);
                        h3.append(" to ADDING.");
                        h3.toString();
                    }
                    this.a = c.VISIBLE;
                    bVar2 = b.ADDING;
                } else {
                    return;
                }
                this.b = bVar2;
            } else if (this.a != cVar2) {
                if (e0.P(2)) {
                    StringBuilder h4 = f.a.a.a.a.h("SpecialEffectsController: For fragment ");
                    h4.append(this.c);
                    h4.append(" mFinalState = ");
                    h4.append(this.a);
                    h4.append(" -> ");
                    h4.append(cVar);
                    h4.append(". ");
                    h4.toString();
                }
                this.a = cVar;
            }
        }

        public void d() {
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("Operation ", "{");
            i2.append(Integer.toHexString(System.identityHashCode(this)));
            i2.append("} ");
            i2.append("{");
            i2.append("mFinalState = ");
            i2.append(this.a);
            i2.append("} ");
            i2.append("{");
            i2.append("mLifecycleImpact = ");
            i2.append(this.b);
            i2.append("} ");
            i2.append("{");
            i2.append("mFragment = ");
            i2.append(this.c);
            i2.append("}");
            return i2.toString();
        }
    }

    public a1(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static a1 f(ViewGroup viewGroup, e0 e0Var) {
        return g(viewGroup, e0Var.N());
    }

    public static a1 g(ViewGroup viewGroup, b1 b1Var) {
        int i2 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof a1) {
            return (a1) tag;
        }
        Objects.requireNonNull((e0.f) b1Var);
        c cVar = new c(viewGroup);
        viewGroup.setTag(i2, cVar);
        return cVar;
    }

    public final void a(d.c cVar, d.b bVar, k0 k0Var) {
        synchronized (this.b) {
            e.j.f.a aVar = new e.j.f.a();
            d d2 = d(k0Var.c);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, k0Var, aVar);
            this.b.add(cVar2);
            cVar2.f1746d.add(new a(cVar2));
            cVar2.f1746d.add(new b(cVar2));
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (!this.f1744e) {
            ViewGroup viewGroup = this.a;
            AtomicInteger atomicInteger = v.a;
            if (!v.g.b(viewGroup)) {
                e();
                this.f1743d = false;
                return;
            }
            synchronized (this.b) {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (e0.P(2)) {
                            String str = "SpecialEffectsController: Cancelling operation " + dVar;
                        }
                        dVar.a();
                        if (!dVar.f1749g) {
                            this.c.add(dVar);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).d();
                    }
                    b(arrayList2, this.f1743d);
                    this.f1743d = false;
                }
            }
        }
    }

    public final d d(m mVar) {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c.equals(mVar) && !next.f1748f) {
                return next;
            }
        }
        return null;
    }

    public void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.a;
        AtomicInteger atomicInteger = v.a;
        boolean b2 = v.g.b(viewGroup);
        synchronized (this.b) {
            i();
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (e0.P(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (b2) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(dVar);
                    sb.toString();
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.b).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (e0.P(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (b2) {
                        str = "";
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(dVar2);
                    sb2.toString();
                }
                dVar2.a();
            }
        }
    }

    public void h() {
        synchronized (this.b) {
            i();
            this.f1744e = false;
            int size = this.b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.b.get(size);
                d.c c2 = d.c.c(dVar.c.F);
                d.c cVar = dVar.a;
                d.c cVar2 = d.c.VISIBLE;
                if (cVar == cVar2 && c2 != cVar2) {
                    this.f1744e = dVar.c.K();
                    break;
                }
                size--;
            }
        }
    }

    public final void i() {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.b == d.b.ADDING) {
                next.c(d.c.b(next.c.w0().getVisibility()), d.b.NONE);
            }
        }
    }
}
