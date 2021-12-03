package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import e.i.e.a;
import e.m.a.e0;
import e.m.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a1 {
    public final ViewGroup a;
    public final ArrayList<d> b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1386d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1387e = false;

    public class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            this.b = cVar;
        }

        public void run() {
            if (a1.this.b.contains(this.b)) {
                c cVar = this.b;
                cVar.a.a(cVar.c.F);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            this.b = cVar;
        }

        public void run() {
            a1.this.b.remove(this.b);
            a1.this.c.remove(this.b);
        }
    }

    public static class c extends d {

        /* renamed from: h  reason: collision with root package name */
        public final k0 f1388h;

        public c(d.c cVar, d.b bVar, k0 k0Var, e.i.e.a aVar) {
            super(cVar, bVar, k0Var.c, aVar);
            this.f1388h = k0Var;
        }

        @Override // e.m.a.a1.d
        public void b() {
            super.b();
            this.f1388h.k();
        }

        @Override // e.m.a.a1.d
        public void d() {
            m mVar = this.f1388h.c;
            View findFocus = mVar.F.findFocus();
            if (findFocus != null) {
                mVar.f().f1467k = findFocus;
                if (e0.O(2)) {
                    String str = "requestFocus: Saved focused view " + findFocus + " for Fragment " + mVar;
                }
            }
            if (this.b == d.b.ADDING) {
                View q0 = this.c.q0();
                if (q0.getParent() == null) {
                    this.f1388h.b();
                    q0.setAlpha(0.0f);
                }
                if (q0.getAlpha() == 0.0f && q0.getVisibility() == 0) {
                    q0.setVisibility(4);
                }
                m.d dVar = mVar.I;
                q0.setAlpha(dVar == null ? 1.0f : dVar.f1466j);
            }
        }
    }

    public static class d {
        public c a;
        public b b;
        public final m c;

        /* renamed from: d  reason: collision with root package name */
        public final List<Runnable> f1389d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<e.i.e.a> f1390e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f1391f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1392g = false;

        public class a implements a.AbstractC0030a {
            public a() {
            }

            @Override // e.i.e.a.AbstractC0030a
            public void a() {
                d.this.a();
            }
        }

        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

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
                throw new IllegalArgumentException(f.a.a.a.a.v("Unknown visibility ", i2));
            }

            public static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public void a(View view) {
                int i2;
                int ordinal = ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        if (e0.O(2)) {
                            String str = "SpecialEffectsController: Setting view " + view + " to VISIBLE";
                        }
                        i2 = 0;
                    } else if (ordinal == 2) {
                        if (e0.O(2)) {
                            String str2 = "SpecialEffectsController: Setting view " + view + " to GONE";
                        }
                        i2 = 8;
                    } else if (ordinal == 3) {
                        if (e0.O(2)) {
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
                    if (e0.O(2)) {
                        String str4 = "SpecialEffectsController: Removing view " + view + " from container " + viewGroup;
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        public d(c cVar, b bVar, m mVar, e.i.e.a aVar) {
            this.a = cVar;
            this.b = bVar;
            this.c = mVar;
            aVar.b(new a());
        }

        public final void a() {
            if (!this.f1391f) {
                this.f1391f = true;
                if (this.f1390e.isEmpty()) {
                    b();
                    return;
                }
                Iterator it = new ArrayList(this.f1390e).iterator();
                while (it.hasNext()) {
                    ((e.i.e.a) it.next()).a();
                }
            }
        }

        public void b() {
            if (!this.f1392g) {
                if (e0.O(2)) {
                    String str = "SpecialEffectsController: " + this + " has called complete.";
                }
                this.f1392g = true;
                for (Runnable runnable : this.f1389d) {
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
                        if (e0.O(2)) {
                            StringBuilder i2 = f.a.a.a.a.i("SpecialEffectsController: For fragment ");
                            i2.append(this.c);
                            i2.append(" mFinalState = ");
                            i2.append(this.a);
                            i2.append(" -> REMOVED. mLifecycleImpact  = ");
                            i2.append(this.b);
                            i2.append(" to REMOVING.");
                            i2.toString();
                        }
                        this.a = cVar2;
                        bVar2 = b.REMOVING;
                    } else {
                        return;
                    }
                } else if (this.a == cVar2) {
                    if (e0.O(2)) {
                        StringBuilder i3 = f.a.a.a.a.i("SpecialEffectsController: For fragment ");
                        i3.append(this.c);
                        i3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        i3.append(this.b);
                        i3.append(" to ADDING.");
                        i3.toString();
                    }
                    this.a = c.VISIBLE;
                    bVar2 = b.ADDING;
                } else {
                    return;
                }
                this.b = bVar2;
            } else if (this.a != cVar2) {
                if (e0.O(2)) {
                    StringBuilder i4 = f.a.a.a.a.i("SpecialEffectsController: For fragment ");
                    i4.append(this.c);
                    i4.append(" mFinalState = ");
                    i4.append(this.a);
                    i4.append(" -> ");
                    i4.append(cVar);
                    i4.append(". ");
                    i4.toString();
                }
                this.a = cVar;
            }
        }

        public void d() {
        }

        public String toString() {
            StringBuilder j2 = f.a.a.a.a.j("Operation ", "{");
            j2.append(Integer.toHexString(System.identityHashCode(this)));
            j2.append("} ");
            j2.append("{");
            j2.append("mFinalState = ");
            j2.append(this.a);
            j2.append("} ");
            j2.append("{");
            j2.append("mLifecycleImpact = ");
            j2.append(this.b);
            j2.append("} ");
            j2.append("{");
            j2.append("mFragment = ");
            j2.append(this.c);
            j2.append("}");
            return j2.toString();
        }
    }

    public a1(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static a1 f(ViewGroup viewGroup, b1 b1Var) {
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
            e.i.e.a aVar = new e.i.e.a();
            d d2 = d(k0Var.c);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, k0Var, aVar);
            this.b.add(cVar2);
            cVar2.f1389d.add(new a(cVar2));
            cVar2.f1389d.add(new b(cVar2));
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (!this.f1387e) {
            ViewGroup viewGroup = this.a;
            AtomicInteger atomicInteger = e.i.i.m.a;
            if (!viewGroup.isAttachedToWindow()) {
                e();
                this.f1386d = false;
                return;
            }
            synchronized (this.b) {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (e0.O(2)) {
                            String str = "SpecialEffectsController: Cancelling operation " + dVar;
                        }
                        dVar.a();
                        if (!dVar.f1392g) {
                            this.c.add(dVar);
                        }
                    }
                    h();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).d();
                    }
                    b(arrayList2, this.f1386d);
                    this.f1386d = false;
                }
            }
        }
    }

    public final d d(m mVar) {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c.equals(mVar) && !next.f1391f) {
                return next;
            }
        }
        return null;
    }

    public void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.a;
        AtomicInteger atomicInteger = e.i.i.m.a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            h();
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (e0.O(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
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
                if (e0.O(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
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

    public void g() {
        synchronized (this.b) {
            h();
            this.f1387e = false;
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
                    this.f1387e = dVar.c.E();
                    break;
                }
                size--;
            }
        }
    }

    public final void h() {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.b == d.b.ADDING) {
                next.c(d.c.b(next.c.q0().getVisibility()), d.b.NONE);
            }
        }
    }
}
