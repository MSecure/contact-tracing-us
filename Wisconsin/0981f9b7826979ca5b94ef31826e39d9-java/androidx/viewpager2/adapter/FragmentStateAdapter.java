package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import e.a0.a.c;
import e.a0.a.d;
import e.a0.a.f;
import e.a0.a.g;
import e.e.e;
import e.m.a.b0;
import e.m.a.c0;
import e.m.a.j0;
import e.m.a.l;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import f.b.a.a.a.p.f3;
import f.b.a.a.a.v.t0;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentStateAdapter extends RecyclerView.e<f> implements g {
    public final e.p.g c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f280d;

    /* renamed from: e  reason: collision with root package name */
    public final e<l> f281e = new e<>();

    /* renamed from: f  reason: collision with root package name */
    public final e<l.f> f282f = new e<>();

    /* renamed from: g  reason: collision with root package name */
    public final e<Integer> f283g = new e<>();

    /* renamed from: h  reason: collision with root package name */
    public b f284h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f285i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f286j = false;

    public static abstract class a extends RecyclerView.g {
        public a(e.a0.a.a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void b(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void c(int i2, int i3, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void d(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void e(int i2, int i3) {
            a();
        }
    }

    public class b {
        public ViewPager2.e a;
        public RecyclerView.g b;
        public h c;

        /* renamed from: d  reason: collision with root package name */
        public ViewPager2 f287d;

        /* renamed from: e  reason: collision with root package name */
        public long f288e = -1;

        public b() {
        }

        public final ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(boolean z) {
            l f2;
            if (!FragmentStateAdapter.this.w() && this.f287d.getScrollState() == 0 && !FragmentStateAdapter.this.f281e.h()) {
                Objects.requireNonNull(FragmentStateAdapter.this);
                int currentItem = this.f287d.getCurrentItem();
                Objects.requireNonNull(FragmentStateAdapter.this);
                if (currentItem < 3) {
                    Objects.requireNonNull(FragmentStateAdapter.this);
                    long j2 = (long) currentItem;
                    if ((j2 != this.f288e || z) && (f2 = FragmentStateAdapter.this.f281e.f(j2)) != null && f2.C()) {
                        this.f288e = j2;
                        e.m.a.a aVar = new e.m.a.a(FragmentStateAdapter.this.f280d);
                        l lVar = null;
                        for (int i2 = 0; i2 < FragmentStateAdapter.this.f281e.l(); i2++) {
                            long i3 = FragmentStateAdapter.this.f281e.i(i2);
                            l m = FragmentStateAdapter.this.f281e.m(i2);
                            if (m.C()) {
                                if (i3 != this.f288e) {
                                    aVar.p(m, g.b.STARTED);
                                } else {
                                    lVar = m;
                                }
                                boolean z2 = i3 == this.f288e;
                                if (m.C != z2) {
                                    m.C = z2;
                                }
                            }
                        }
                        if (lVar != null) {
                            aVar.p(lVar, g.b.RESUMED);
                        }
                        if (!aVar.a.isEmpty()) {
                            aVar.d();
                        }
                    }
                }
            }
        }
    }

    public FragmentStateAdapter(l lVar) {
        c0 j2 = lVar.j();
        k kVar = lVar.P;
        this.f280d = j2;
        this.c = kVar;
        o(true);
    }

    public static boolean s(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    @Override // e.a0.a.g
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f282f.l() + this.f281e.l());
        for (int i2 = 0; i2 < this.f281e.l(); i2++) {
            long i3 = this.f281e.i(i2);
            l f2 = this.f281e.f(i3);
            if (f2 != null && f2.C()) {
                this.f280d.d0(bundle, "f#" + i3, f2);
            }
        }
        for (int i4 = 0; i4 < this.f282f.l(); i4++) {
            long i5 = this.f282f.i(i4);
            if (q(i5)) {
                bundle.putParcelable("s#" + i5, this.f282f.f(i5));
            }
        }
        return bundle;
    }

    @Override // e.a0.a.g
    public final void b(Parcelable parcelable) {
        e eVar;
        long j2;
        Object obj;
        if (!this.f282f.h() || !this.f281e.h()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (s(str, "f#")) {
                j2 = Long.parseLong(str.substring(2));
                obj = this.f280d.K(bundle, str);
                eVar = this.f281e;
            } else if (s(str, "s#")) {
                j2 = Long.parseLong(str.substring(2));
                obj = (l.f) bundle.getParcelable(str);
                if (q(j2)) {
                    eVar = this.f282f;
                }
            } else {
                throw new IllegalArgumentException(f.a.a.a.a.t("Unexpected key in savedState: ", str));
            }
            eVar.j(j2, obj);
        }
        if (!this.f281e.h()) {
            this.f286j = true;
            this.f285i = true;
            r();
            final Handler handler = new Handler(Looper.getMainLooper());
            final c cVar = new c(this);
            this.c.a(new h(this) {
                /* class androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass5 */

                @Override // e.p.h
                public void d(j jVar, g.a aVar) {
                    if (aVar == g.a.ON_DESTROY) {
                        handler.removeCallbacks(cVar);
                        k kVar = (k) jVar.a();
                        kVar.d("removeObserver");
                        kVar.a.l(this);
                    }
                }
            });
            handler.postDelayed(cVar, 10000);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long d(int i2) {
        return (long) i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void f(RecyclerView recyclerView) {
        if (this.f284h == null) {
            b bVar = new b();
            this.f284h = bVar;
            ViewPager2 a2 = bVar.a(recyclerView);
            bVar.f287d = a2;
            d dVar = new d(bVar);
            bVar.a = dVar;
            a2.f290d.a.add(dVar);
            e.a0.a.e eVar = new e.a0.a.e(bVar);
            bVar.b = eVar;
            FragmentStateAdapter.this.a.registerObserver(eVar);
            FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(bVar);
            bVar.c = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
            FragmentStateAdapter.this.c.a(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void g(f fVar, int i2) {
        Bundle bundle;
        f fVar2 = fVar;
        long j2 = fVar2.f213e;
        int id = ((FrameLayout) fVar2.a).getId();
        Long t = t(id);
        if (!(t == null || t.longValue() == j2)) {
            v(t.longValue());
            this.f283g.k(t.longValue());
        }
        this.f283g.j(j2, Integer.valueOf(id));
        long j3 = (long) i2;
        if (!this.f281e.d(j3)) {
            l f3Var = i2 != 0 ? i2 != 2 ? new f3() : new t0() : new f.b.a.a.a.i.l();
            l.f f2 = this.f282f.f(j3);
            if (f3Var.s == null) {
                if (f2 == null || (bundle = f2.b) == null) {
                    bundle = null;
                }
                f3Var.c = bundle;
                this.f281e.j(j3, f3Var);
            } else {
                throw new IllegalStateException("Fragment already added");
            }
        }
        FrameLayout frameLayout = (FrameLayout) fVar2.a;
        AtomicInteger atomicInteger = e.i.i.l.a;
        if (frameLayout.isAttachedToWindow()) {
            if (frameLayout.getParent() == null) {
                frameLayout.addOnLayoutChangeListener(new e.a0.a.a(this, frameLayout, fVar2));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        r();
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public f i(ViewGroup viewGroup, int i2) {
        int i3 = f.t;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AtomicInteger atomicInteger = e.i.i.l.a;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new f(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void j(RecyclerView recyclerView) {
        b bVar = this.f284h;
        ViewPager2 a2 = bVar.a(recyclerView);
        a2.f290d.a.remove(bVar.a);
        FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
        fragmentStateAdapter.a.unregisterObserver(bVar.b);
        FragmentStateAdapter.this.c.b(bVar.c);
        bVar.f287d = null;
        this.f284h = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public /* bridge */ /* synthetic */ boolean k(f fVar) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void l(f fVar) {
        u(fVar);
        r();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void n(f fVar) {
        Long t = t(((FrameLayout) fVar.a).getId());
        if (t != null) {
            v(t.longValue());
            this.f283g.k(t.longValue());
        }
    }

    public void p(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean q(long j2) {
        return j2 >= 0 && j2 < ((long) 3);
    }

    public void r() {
        l g2;
        View view;
        if (this.f286j && !w()) {
            e.e.c cVar = new e.e.c(0);
            for (int i2 = 0; i2 < this.f281e.l(); i2++) {
                long i3 = this.f281e.i(i2);
                if (!q(i3)) {
                    cVar.add(Long.valueOf(i3));
                    this.f283g.k(i3);
                }
            }
            if (!this.f285i) {
                this.f286j = false;
                for (int i4 = 0; i4 < this.f281e.l(); i4++) {
                    long i5 = this.f281e.i(i4);
                    boolean z = true;
                    if (!this.f283g.d(i5) && ((g2 = this.f281e.g(i5, null)) == null || (view = g2.F) == null || view.getParent() == null)) {
                        z = false;
                    }
                    if (!z) {
                        cVar.add(Long.valueOf(i5));
                    }
                }
            }
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                v(((Long) it.next()).longValue());
            }
        }
    }

    public final Long t(int i2) {
        Long l2 = null;
        for (int i3 = 0; i3 < this.f283g.l(); i3++) {
            if (this.f283g.m(i3).intValue() == i2) {
                if (l2 == null) {
                    l2 = Long.valueOf(this.f283g.i(i3));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l2;
    }

    public void u(final f fVar) {
        l f2 = this.f281e.f(fVar.f213e);
        if (f2 != null) {
            FrameLayout frameLayout = (FrameLayout) fVar.a;
            View view = f2.F;
            if (!f2.C() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (f2.C() && view == null) {
                this.f280d.n.a.add(new b0.a(new e.a0.a.b(this, f2, frameLayout), false));
            } else if (!f2.C() || view.getParent() == null) {
                if (f2.C()) {
                    p(view, frameLayout);
                } else if (!w()) {
                    this.f280d.n.a.add(new b0.a(new e.a0.a.b(this, f2, frameLayout), false));
                    e.m.a.a aVar = new e.m.a.a(this.f280d);
                    StringBuilder h2 = f.a.a.a.a.h("f");
                    h2.append(fVar.f213e);
                    aVar.e(0, f2, h2.toString(), 1);
                    aVar.p(f2, g.b.STARTED);
                    aVar.d();
                    this.f284h.b(false);
                } else if (!this.f280d.D) {
                    this.c.a(new h() {
                        /* class androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass2 */

                        @Override // e.p.h
                        public void d(j jVar, g.a aVar) {
                            if (!FragmentStateAdapter.this.w()) {
                                k kVar = (k) jVar.a();
                                kVar.d("removeObserver");
                                kVar.a.l(this);
                                AtomicInteger atomicInteger = e.i.i.l.a;
                                if (((FrameLayout) fVar.a).isAttachedToWindow()) {
                                    FragmentStateAdapter.this.u(fVar);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != frameLayout) {
                p(view, frameLayout);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public final void v(long j2) {
        Bundle n;
        ViewParent parent;
        l.f fVar = null;
        l g2 = this.f281e.g(j2, null);
        if (g2 != null) {
            View view = g2.F;
            if (!(view == null || (parent = view.getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!q(j2)) {
                this.f282f.k(j2);
            }
            if (!g2.C()) {
                this.f281e.k(j2);
            } else if (w()) {
                this.f286j = true;
            } else {
                if (g2.C() && q(j2)) {
                    e<l.f> eVar = this.f282f;
                    c0 c0Var = this.f280d;
                    j0 i2 = c0Var.c.i(g2.f1619f);
                    if (i2 == null || !i2.c.equals(g2)) {
                        c0Var.p0(new IllegalStateException(f.a.a.a.a.s("Fragment ", g2, " is not currently in the FragmentManager")));
                        throw null;
                    }
                    if (i2.c.b > -1 && (n = i2.n()) != null) {
                        fVar = new l.f(n);
                    }
                    eVar.j(j2, fVar);
                }
                e.m.a.a aVar = new e.m.a.a(this.f280d);
                aVar.o(g2);
                aVar.d();
                this.f281e.k(j2);
            }
        }
    }

    public boolean w() {
        return this.f280d.U();
    }
}
