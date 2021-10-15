package b.l.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.i.l.m;
import b.l.d.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f2146a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<d> f2147b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<d> f2148c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f2149d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2150e = false;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2151b;

        public a(c cVar) {
            this.f2151b = cVar;
        }

        public void run() {
            if (w0.this.f2147b.contains(this.f2151b)) {
                c cVar = this.f2151b;
                cVar.f2155a.b(cVar.f2157c.mView);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2153b;

        public b(c cVar) {
            this.f2153b = cVar;
        }

        public void run() {
            w0.this.f2147b.remove(this.f2153b);
            w0.this.f2148c.remove(this.f2153b);
        }
    }

    public static class c extends d {
        public final g0 h;

        public c(d.c cVar, d.b bVar, g0 g0Var, b.i.h.a aVar) {
            super(cVar, bVar, g0Var.f2021c, aVar);
            this.h = g0Var;
        }

        @Override // b.l.d.w0.d
        public void b() {
            super.b();
            this.h.k();
        }

        @Override // b.l.d.w0.d
        public void d() {
            if (this.f2156b == d.b.ADDING) {
                Fragment fragment = this.h.f2021c;
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (z.P(2)) {
                        String str = "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment;
                    }
                }
                View requireView = this.f2157c.requireView();
                if (requireView.getParent() == null) {
                    this.h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public c f2155a;

        /* renamed from: b  reason: collision with root package name */
        public b f2156b;

        /* renamed from: c  reason: collision with root package name */
        public final Fragment f2157c;

        /* renamed from: d  reason: collision with root package name */
        public final List<Runnable> f2158d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<b.i.h.a> f2159e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f2160f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2161g = false;

        public class a implements a.AbstractC0030a {
            public a() {
            }

            @Override // b.i.h.a.AbstractC0030a
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

            public static c d(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(c.a.a.a.a.n("Unknown visibility ", i));
            }

            public static c f(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : d(view.getVisibility());
            }

            public void b(View view) {
                int i;
                int ordinal = ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        if (z.P(2)) {
                            String str = "SpecialEffectsController: Setting view " + view + " to VISIBLE";
                        }
                        i = 0;
                    } else if (ordinal == 2) {
                        if (z.P(2)) {
                            String str2 = "SpecialEffectsController: Setting view " + view + " to GONE";
                        }
                        i = 8;
                    } else if (ordinal == 3) {
                        if (z.P(2)) {
                            String str3 = "SpecialEffectsController: Setting view " + view + " to INVISIBLE";
                        }
                        i = 4;
                    } else {
                        return;
                    }
                    view.setVisibility(i);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (z.P(2)) {
                        String str4 = "SpecialEffectsController: Removing view " + view + " from container " + viewGroup;
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        public d(c cVar, b bVar, Fragment fragment, b.i.h.a aVar) {
            this.f2155a = cVar;
            this.f2156b = bVar;
            this.f2157c = fragment;
            aVar.b(new a());
        }

        public final void a() {
            if (!this.f2160f) {
                this.f2160f = true;
                if (this.f2159e.isEmpty()) {
                    b();
                    return;
                }
                Iterator it = new ArrayList(this.f2159e).iterator();
                while (it.hasNext()) {
                    ((b.i.h.a) it.next()).a();
                }
            }
        }

        public void b() {
            if (!this.f2161g) {
                if (z.P(2)) {
                    String str = "SpecialEffectsController: " + this + " has called complete.";
                }
                this.f2161g = true;
                for (Runnable runnable : this.f2158d) {
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
                        if (z.P(2)) {
                            StringBuilder h = c.a.a.a.a.h("SpecialEffectsController: For fragment ");
                            h.append(this.f2157c);
                            h.append(" mFinalState = ");
                            h.append(this.f2155a);
                            h.append(" -> REMOVED. mLifecycleImpact  = ");
                            h.append(this.f2156b);
                            h.append(" to REMOVING.");
                            h.toString();
                        }
                        this.f2155a = cVar2;
                        bVar2 = b.REMOVING;
                    } else {
                        return;
                    }
                } else if (this.f2155a == cVar2) {
                    if (z.P(2)) {
                        StringBuilder h2 = c.a.a.a.a.h("SpecialEffectsController: For fragment ");
                        h2.append(this.f2157c);
                        h2.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        h2.append(this.f2156b);
                        h2.append(" to ADDING.");
                        h2.toString();
                    }
                    this.f2155a = c.VISIBLE;
                    bVar2 = b.ADDING;
                } else {
                    return;
                }
                this.f2156b = bVar2;
            } else if (this.f2155a != cVar2) {
                if (z.P(2)) {
                    StringBuilder h3 = c.a.a.a.a.h("SpecialEffectsController: For fragment ");
                    h3.append(this.f2157c);
                    h3.append(" mFinalState = ");
                    h3.append(this.f2155a);
                    h3.append(" -> ");
                    h3.append(cVar);
                    h3.append(". ");
                    h3.toString();
                }
                this.f2155a = cVar;
            }
        }

        public void d() {
        }

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f2155a + "} " + "{" + "mLifecycleImpact = " + this.f2156b + "} " + "{" + "mFragment = " + this.f2157c + "}";
        }
    }

    public w0(ViewGroup viewGroup) {
        this.f2146a = viewGroup;
    }

    public static w0 f(ViewGroup viewGroup, z zVar) {
        return g(viewGroup, zVar.N());
    }

    public static w0 g(ViewGroup viewGroup, x0 x0Var) {
        Object tag = viewGroup.getTag(b.l.b.special_effects_controller_view_tag);
        if (tag instanceof w0) {
            return (w0) tag;
        }
        if (((z.f) x0Var) != null) {
            c cVar = new c(viewGroup);
            viewGroup.setTag(b.l.b.special_effects_controller_view_tag, cVar);
            return cVar;
        }
        throw null;
    }

    public final void a(d.c cVar, d.b bVar, g0 g0Var) {
        synchronized (this.f2147b) {
            b.i.h.a aVar = new b.i.h.a();
            d d2 = d(g0Var.f2021c);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, g0Var, aVar);
            this.f2147b.add(cVar2);
            cVar2.f2158d.add(new a(cVar2));
            cVar2.f2158d.add(new b(cVar2));
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (!this.f2150e) {
            if (!m.B(this.f2146a)) {
                e();
                this.f2149d = false;
                return;
            }
            synchronized (this.f2147b) {
                if (!this.f2147b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2148c);
                    this.f2148c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (z.P(2)) {
                            String str = "SpecialEffectsController: Cancelling operation " + dVar;
                        }
                        dVar.a();
                        if (!dVar.f2161g) {
                            this.f2148c.add(dVar);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.f2147b);
                    this.f2147b.clear();
                    this.f2148c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).d();
                    }
                    b(arrayList2, this.f2149d);
                    this.f2149d = false;
                }
            }
        }
    }

    public final d d(Fragment fragment) {
        Iterator<d> it = this.f2147b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f2157c.equals(fragment) && !next.f2160f) {
                return next;
            }
        }
        return null;
    }

    public void e() {
        String str;
        String str2;
        boolean B = m.B(this.f2146a);
        synchronized (this.f2147b) {
            i();
            Iterator<d> it = this.f2147b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.f2148c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (z.P(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (B) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2146a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(dVar);
                    sb.toString();
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.f2147b).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (z.P(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (B) {
                        str = "";
                    } else {
                        str = "Container " + this.f2146a + " is not attached to window. ";
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
        d.c cVar = d.c.VISIBLE;
        synchronized (this.f2147b) {
            i();
            this.f2150e = false;
            int size = this.f2147b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.f2147b.get(size);
                d.c f2 = d.c.f(dVar.f2157c.mView);
                if (dVar.f2155a == cVar && f2 != cVar) {
                    this.f2150e = dVar.f2157c.isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void i() {
        Iterator<d> it = this.f2147b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f2156b == d.b.ADDING) {
                next.c(d.c.d(next.f2157c.requireView().getVisibility()), d.b.NONE);
            }
        }
    }
}
