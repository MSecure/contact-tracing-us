package e.o.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import e.j.j.v;
import e.o.a.a1;
import e.o.a.m;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.j;
import e.r.l;
import e.w.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class k0 {
    public final d0 a;
    public final l0 b;
    public final m c;

    /* renamed from: d */
    public boolean f1807d = false;

    /* renamed from: e */
    public int f1808e = -1;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View b;

        public a(k0 k0Var, View view) {
            this.b = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.b.removeOnAttachStateChangeListener(this);
            View view2 = this.b;
            AtomicInteger atomicInteger = v.a;
            v.h.c(view2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public k0(d0 d0Var, l0 l0Var, m mVar) {
        this.a = d0Var;
        this.b = l0Var;
        this.c = mVar;
    }

    public k0(d0 d0Var, l0 l0Var, m mVar, j0 j0Var) {
        this.a = d0Var;
        this.b = l0Var;
        this.c = mVar;
        mVar.f1809d = null;
        mVar.f1810e = null;
        mVar.r = 0;
        mVar.o = false;
        mVar.f1817l = false;
        m mVar2 = mVar.f1813h;
        mVar.f1814i = mVar2 != null ? mVar2.f1811f : null;
        mVar.f1813h = null;
        Bundle bundle = j0Var.n;
        mVar.c = bundle == null ? new Bundle() : bundle;
    }

    public k0(d0 d0Var, l0 l0Var, ClassLoader classLoader, a0 a0Var, j0 j0Var) {
        this.a = d0Var;
        this.b = l0Var;
        m a2 = a0Var.a(classLoader, j0Var.b);
        this.c = a2;
        Bundle bundle = j0Var.f1805k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.A0(j0Var.f1805k);
        a2.f1811f = j0Var.c;
        a2.n = j0Var.f1798d;
        a2.p = true;
        a2.w = j0Var.f1799e;
        a2.x = j0Var.f1800f;
        a2.y = j0Var.f1801g;
        a2.B = j0Var.f1802h;
        a2.m = j0Var.f1803i;
        a2.A = j0Var.f1804j;
        a2.z = j0Var.f1806l;
        a2.N = h.b.values()[j0Var.m];
        Bundle bundle2 = j0Var.n;
        a2.c = bundle2 == null ? new Bundle() : bundle2;
        if (e0.P(2)) {
            String str = "Instantiated fragment " + a2;
        }
    }

    public void a() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ACTIVITY_CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        Bundle bundle = mVar.c;
        mVar.u.W();
        mVar.b = 3;
        mVar.D = false;
        mVar.M();
        if (mVar.D) {
            if (e0.P(3)) {
                String str = "moveto RESTORE_VIEW_STATE: " + mVar;
            }
            View view = mVar.F;
            if (view != null) {
                Bundle bundle2 = mVar.c;
                SparseArray<Parcelable> sparseArray = mVar.f1809d;
                if (sparseArray != null) {
                    view.restoreHierarchyState(sparseArray);
                    mVar.f1809d = null;
                }
                if (mVar.F != null) {
                    mVar.P.f1888f.a(mVar.f1810e);
                    mVar.f1810e = null;
                }
                mVar.D = false;
                mVar.n0(bundle2);
                if (!mVar.D) {
                    throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onViewStateRestored()"));
                } else if (mVar.F != null) {
                    mVar.P.b(h.a.ON_CREATE);
                }
            }
            mVar.c = null;
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1796h = false;
            e0Var.w(4);
            d0 d0Var = this.a;
            m mVar2 = this.c;
            d0Var.a(mVar2, mVar2.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onActivityCreated()"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1 >= r0.a.size()) goto L_0x004f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        r4 = r0.a.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r4.E != r2) goto L_0x0031;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        r4 = r4.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r4 == null) goto L_0x0031;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        r3 = r2.indexOfChild(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void b() {
        View view;
        l0 l0Var = this.b;
        m mVar = this.c;
        Objects.requireNonNull(l0Var);
        ViewGroup viewGroup = mVar.E;
        int i2 = -1;
        if (viewGroup != null) {
            int indexOf = l0Var.a.indexOf(mVar);
            int i3 = indexOf - 1;
            while (true) {
                if (i3 >= 0) {
                    m mVar2 = l0Var.a.get(i3);
                    if (mVar2.E == viewGroup && (view = mVar2.F) != null) {
                        i2 = viewGroup.indexOfChild(view) + 1;
                        break;
                    }
                    i3--;
                }
            }
        }
        m mVar3 = this.c;
        mVar3.E.addView(mVar3.F, i2);
    }

    public void c() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        m mVar2 = mVar.f1813h;
        k0 k0Var = null;
        if (mVar2 != null) {
            k0 h3 = this.b.h(mVar2.f1811f);
            if (h3 != null) {
                m mVar3 = this.c;
                mVar3.f1814i = mVar3.f1813h.f1811f;
                mVar3.f1813h = null;
                k0Var = h3;
            } else {
                StringBuilder h4 = f.a.a.a.a.h("Fragment ");
                h4.append(this.c);
                h4.append(" declared target fragment ");
                h4.append(this.c.f1813h);
                h4.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(h4.toString());
            }
        } else {
            String str = mVar.f1814i;
            if (str != null && (k0Var = this.b.h(str)) == null) {
                StringBuilder h5 = f.a.a.a.a.h("Fragment ");
                h5.append(this.c);
                h5.append(" declared target fragment ");
                throw new IllegalStateException(f.a.a.a.a.e(h5, this.c.f1814i, " that does not belong to this FragmentManager!"));
            }
        }
        if (k0Var != null) {
            k0Var.k();
        }
        m mVar4 = this.c;
        e0 e0Var = mVar4.s;
        mVar4.t = e0Var.q;
        mVar4.v = e0Var.s;
        this.a.g(mVar4, false);
        m mVar5 = this.c;
        Iterator<m.f> it = mVar5.U.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        mVar5.U.clear();
        mVar5.u.b(mVar5.t, mVar5.b(), mVar5);
        mVar5.b = 0;
        mVar5.D = false;
        mVar5.P(mVar5.t.c);
        if (mVar5.D) {
            e0 e0Var2 = mVar5.s;
            Iterator<i0> it2 = e0Var2.o.iterator();
            while (it2.hasNext()) {
                it2.next().b(e0Var2, mVar5);
            }
            e0 e0Var3 = mVar5.u;
            e0Var3.B = false;
            e0Var3.C = false;
            e0Var3.J.f1796h = false;
            e0Var3.w(0);
            this.a.b(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar5, " did not call through to super.onAttach()"));
    }

    public int d() {
        m mVar = this.c;
        if (mVar.s == null) {
            return mVar.b;
        }
        int i2 = this.f1808e;
        int ordinal = mVar.N.ordinal();
        if (ordinal == 1) {
            i2 = Math.min(i2, 0);
        } else if (ordinal == 2) {
            i2 = Math.min(i2, 1);
        } else if (ordinal == 3) {
            i2 = Math.min(i2, 5);
        } else if (ordinal != 4) {
            i2 = Math.min(i2, -1);
        }
        m mVar2 = this.c;
        if (mVar2.n) {
            if (mVar2.o) {
                i2 = Math.max(this.f1808e, 2);
                View view = this.c.F;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f1808e < 4 ? Math.min(i2, mVar2.b) : Math.min(i2, 1);
            }
        }
        if (!this.c.f1817l) {
            i2 = Math.min(i2, 1);
        }
        m mVar3 = this.c;
        ViewGroup viewGroup = mVar3.E;
        a1.d.b bVar = null;
        a1.d dVar = null;
        if (viewGroup != null) {
            a1 g2 = a1.g(viewGroup, mVar3.w().N());
            Objects.requireNonNull(g2);
            a1.d d2 = g2.d(this.c);
            a1.d.b bVar2 = d2 != null ? d2.b : null;
            m mVar4 = this.c;
            Iterator<a1.d> it = g2.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a1.d next = it.next();
                if (next.c.equals(mVar4) && !next.f1748f) {
                    dVar = next;
                    break;
                }
            }
            bVar = (dVar == null || !(bVar2 == null || bVar2 == a1.d.b.NONE)) ? bVar2 : dVar.b;
        }
        if (bVar == a1.d.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (bVar == a1.d.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            m mVar5 = this.c;
            if (mVar5.m) {
                i2 = mVar5.J() ? Math.min(i2, 1) : Math.min(i2, -1);
            }
        }
        m mVar6 = this.c;
        if (mVar6.G && mVar6.b < 5) {
            i2 = Math.min(i2, 4);
        }
        if (e0.P(2)) {
            String str = "computeExpectedState() of " + i2 + " for " + this.c;
        }
        return i2;
    }

    public void e() {
        Parcelable parcelable;
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        if (!mVar.M) {
            this.a.h(mVar, mVar.c, false);
            m mVar2 = this.c;
            Bundle bundle = mVar2.c;
            mVar2.u.W();
            mVar2.b = 1;
            mVar2.D = false;
            mVar2.O.a(new j() { // from class: androidx.fragment.app.Fragment$5
                @Override // e.r.j
                public void d(l lVar, h.a aVar) {
                    View view;
                    if (aVar == h.a.ON_STOP && (view = m.this.F) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
            mVar2.S.a(bundle);
            mVar2.S(bundle);
            mVar2.M = true;
            if (mVar2.D) {
                mVar2.O.e(h.a.ON_CREATE);
                d0 d0Var = this.a;
                m mVar3 = this.c;
                d0Var.c(mVar3, mVar3.c, false);
                return;
            }
            throw new c1(f.a.a.a.a.w("Fragment ", mVar2, " did not call through to super.onCreate()"));
        }
        Bundle bundle2 = mVar.c;
        if (!(bundle2 == null || (parcelable = bundle2.getParcelable("android:support:fragments")) == null)) {
            mVar.u.e0(parcelable);
            mVar.u.m();
        }
        this.c.b = 1;
    }

    public void f() {
        String str;
        if (!this.c.n) {
            if (e0.P(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            m mVar = this.c;
            LayoutInflater q0 = mVar.q0(mVar.c);
            ViewGroup viewGroup = null;
            m mVar2 = this.c;
            ViewGroup viewGroup2 = mVar2.E;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i2 = mVar2.x;
                if (i2 != 0) {
                    if (i2 != -1) {
                        viewGroup = (ViewGroup) mVar2.s.r.e(i2);
                        if (viewGroup == null) {
                            m mVar3 = this.c;
                            if (!mVar3.p) {
                                try {
                                    str = mVar3.B().getResourceName(this.c.x);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder h3 = f.a.a.a.a.h("No view found for id 0x");
                                h3.append(Integer.toHexString(this.c.x));
                                h3.append(" (");
                                h3.append(str);
                                h3.append(") for fragment ");
                                h3.append(this.c);
                                throw new IllegalArgumentException(h3.toString());
                            }
                        }
                    } else {
                        StringBuilder h4 = f.a.a.a.a.h("Cannot create fragment ");
                        h4.append(this.c);
                        h4.append(" for a container view with no id");
                        throw new IllegalArgumentException(h4.toString());
                    }
                }
            }
            m mVar4 = this.c;
            mVar4.E = viewGroup;
            mVar4.o0(q0, viewGroup, mVar4.c);
            View view = this.c.F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                m mVar5 = this.c;
                mVar5.F.setTag(R$id.fragment_container_view_tag, mVar5);
                if (viewGroup != null) {
                    b();
                }
                m mVar6 = this.c;
                if (mVar6.z) {
                    mVar6.F.setVisibility(8);
                }
                View view2 = this.c.F;
                AtomicInteger atomicInteger = v.a;
                if (v.g.b(view2)) {
                    v.h.c(this.c.F);
                } else {
                    View view3 = this.c.F;
                    view3.addOnAttachStateChangeListener(new a(this, view3));
                }
                m mVar7 = this.c;
                mVar7.m0(mVar7.F, mVar7.c);
                mVar7.u.w(2);
                d0 d0Var = this.a;
                m mVar8 = this.c;
                d0Var.m(mVar8, mVar8.F, mVar8.c, false);
                int visibility = this.c.F.getVisibility();
                this.c.f().n = this.c.F.getAlpha();
                m mVar9 = this.c;
                if (mVar9.E != null && visibility == 0) {
                    View findFocus = mVar9.F.findFocus();
                    if (findFocus != null) {
                        this.c.f().o = findFocus;
                        if (e0.P(2)) {
                            String str2 = "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c;
                        }
                    }
                    this.c.F.setAlpha(0.0f);
                }
            }
            this.c.b = 2;
        }
    }

    public void g() {
        m d2;
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        boolean z = true;
        boolean z2 = mVar.m && !mVar.J();
        if (z2 || this.b.c.d(this.c)) {
            b0<?> b0Var = this.c.t;
            if (b0Var instanceof h0) {
                z = this.b.c.f1795g;
            } else {
                Context context = b0Var.c;
                if (context instanceof Activity) {
                    z = true ^ ((Activity) context).isChangingConfigurations();
                }
            }
            if (z2 || z) {
                h0 h0Var = this.b.c;
                m mVar2 = this.c;
                Objects.requireNonNull(h0Var);
                if (e0.P(3)) {
                    String str = "Clearing non-config state for " + mVar2;
                }
                h0 h0Var2 = h0Var.f1792d.get(mVar2.f1811f);
                if (h0Var2 != null) {
                    h0Var2.a();
                    h0Var.f1792d.remove(mVar2.f1811f);
                }
                g0 g0Var = h0Var.f1793e.get(mVar2.f1811f);
                if (g0Var != null) {
                    g0Var.a();
                    h0Var.f1793e.remove(mVar2.f1811f);
                }
            }
            m mVar3 = this.c;
            mVar3.u.o();
            mVar3.O.e(h.a.ON_DESTROY);
            mVar3.b = 0;
            mVar3.D = false;
            mVar3.M = false;
            mVar3.W();
            if (mVar3.D) {
                this.a.d(this.c, false);
                Iterator it = ((ArrayList) this.b.f()).iterator();
                while (it.hasNext()) {
                    k0 k0Var = (k0) it.next();
                    if (k0Var != null) {
                        m mVar4 = k0Var.c;
                        if (this.c.f1811f.equals(mVar4.f1814i)) {
                            mVar4.f1813h = this.c;
                            mVar4.f1814i = null;
                        }
                    }
                }
                m mVar5 = this.c;
                String str2 = mVar5.f1814i;
                if (str2 != null) {
                    mVar5.f1813h = this.b.d(str2);
                }
                this.b.k(this);
                return;
            }
            throw new c1(f.a.a.a.a.w("Fragment ", mVar3, " did not call through to super.onDestroy()"));
        }
        String str3 = this.c.f1814i;
        if (!(str3 == null || (d2 = this.b.d(str3)) == null || !d2.B)) {
            this.c.f1813h = d2;
        }
        this.c.b = 0;
    }

    public void h() {
        View view;
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom CREATE_VIEW: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        ViewGroup viewGroup = mVar.E;
        if (!(viewGroup == null || (view = mVar.F) == null)) {
            viewGroup.removeView(view);
        }
        this.c.p0();
        this.a.n(this.c, false);
        m mVar2 = this.c;
        mVar2.E = null;
        mVar2.F = null;
        mVar2.P = null;
        mVar2.Q.l(null);
        this.c.o = false;
    }

    public void i() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.b = -1;
        mVar.D = false;
        mVar.Y();
        mVar.L = null;
        if (mVar.D) {
            e0 e0Var = mVar.u;
            if (!e0Var.D) {
                e0Var.o();
                mVar.u = new f0();
            }
            this.a.e(this.c, false);
            m mVar2 = this.c;
            mVar2.b = -1;
            mVar2.t = null;
            mVar2.v = null;
            mVar2.s = null;
            if ((mVar2.m && !mVar2.J()) || this.b.c.d(this.c)) {
                if (e0.P(3)) {
                    StringBuilder h3 = f.a.a.a.a.h("initState called for fragment: ");
                    h3.append(this.c);
                    h3.toString();
                }
                m mVar3 = this.c;
                Objects.requireNonNull(mVar3);
                mVar3.O = new e.r.m(mVar3);
                mVar3.S = new b(mVar3);
                mVar3.R = null;
                mVar3.f1811f = UUID.randomUUID().toString();
                mVar3.f1817l = false;
                mVar3.m = false;
                mVar3.n = false;
                mVar3.o = false;
                mVar3.p = false;
                mVar3.r = 0;
                mVar3.s = null;
                mVar3.u = new f0();
                mVar3.t = null;
                mVar3.w = 0;
                mVar3.x = 0;
                mVar3.y = null;
                mVar3.z = false;
                mVar3.A = false;
                return;
            }
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onDetach()"));
    }

    public void j() {
        m mVar = this.c;
        if (mVar.n && mVar.o && !mVar.q) {
            if (e0.P(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            m mVar2 = this.c;
            mVar2.o0(mVar2.q0(mVar2.c), null, this.c.c);
            View view = this.c.F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                m mVar3 = this.c;
                mVar3.F.setTag(R$id.fragment_container_view_tag, mVar3);
                m mVar4 = this.c;
                if (mVar4.z) {
                    mVar4.F.setVisibility(8);
                }
                m mVar5 = this.c;
                mVar5.m0(mVar5.F, mVar5.c);
                mVar5.u.w(2);
                d0 d0Var = this.a;
                m mVar6 = this.c;
                d0Var.m(mVar6, mVar6.F, mVar6.c, false);
                this.c.b = 2;
            }
        }
    }

    public void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        a1.d.b bVar = a1.d.b.NONE;
        if (!this.f1807d) {
            try {
                this.f1807d = true;
                while (true) {
                    int d2 = d();
                    m mVar = this.c;
                    int i2 = mVar.b;
                    if (d2 == i2) {
                        if (mVar.J) {
                            if (!(mVar.F == null || (viewGroup = mVar.E) == null)) {
                                a1 g2 = a1.g(viewGroup, mVar.w().N());
                                if (this.c.z) {
                                    Objects.requireNonNull(g2);
                                    if (e0.P(2)) {
                                        String str = "SpecialEffectsController: Enqueuing hide operation for fragment " + this.c;
                                    }
                                    g2.a(a1.d.c.GONE, bVar, this);
                                } else {
                                    Objects.requireNonNull(g2);
                                    if (e0.P(2)) {
                                        String str2 = "SpecialEffectsController: Enqueuing show operation for fragment " + this.c;
                                    }
                                    g2.a(a1.d.c.VISIBLE, bVar, this);
                                }
                            }
                            m mVar2 = this.c;
                            e0 e0Var = mVar2.s;
                            if (e0Var != null && mVar2.f1817l && e0Var.Q(mVar2)) {
                                e0Var.A = true;
                            }
                            m mVar3 = this.c;
                            mVar3.J = false;
                            mVar3.a0();
                        }
                        return;
                    } else if (d2 > i2) {
                        switch (i2 + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (!(mVar.F == null || (viewGroup2 = mVar.E) == null)) {
                                    a1 g3 = a1.g(viewGroup2, mVar.w().N());
                                    a1.d.c b = a1.d.c.b(this.c.F.getVisibility());
                                    Objects.requireNonNull(g3);
                                    if (e0.P(2)) {
                                        String str3 = "SpecialEffectsController: Enqueuing add operation for fragment " + this.c;
                                    }
                                    g3.a(b, a1.d.b.ADDING, this);
                                }
                                this.c.b = 4;
                                continue;
                            case 5:
                                p();
                                continue;
                            case 6:
                                mVar.b = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (i2 - 1) {
                            case -1:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.c.b = 1;
                                continue;
                            case 2:
                                mVar.o = false;
                                mVar.b = 2;
                                continue;
                            case 3:
                                if (e0.P(3)) {
                                    String str4 = "movefrom ACTIVITY_CREATED: " + this.c;
                                }
                                m mVar4 = this.c;
                                if (mVar4.F != null && mVar4.f1809d == null) {
                                    o();
                                }
                                m mVar5 = this.c;
                                if (!(mVar5.F == null || (viewGroup3 = mVar5.E) == null)) {
                                    a1 g4 = a1.g(viewGroup3, mVar5.w().N());
                                    Objects.requireNonNull(g4);
                                    if (e0.P(2)) {
                                        String str5 = "SpecialEffectsController: Enqueuing remove operation for fragment " + this.c;
                                    }
                                    g4.a(a1.d.c.REMOVED, a1.d.b.REMOVING, this);
                                }
                                this.c.b = 3;
                                continue;
                            case 4:
                                q();
                                continue;
                            case 5:
                                mVar.b = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.f1807d = false;
            }
        } else if (e0.P(2)) {
            StringBuilder h2 = f.a.a.a.a.h("Ignoring re-entrant call to moveToExpectedState() for ");
            h2.append(this.c);
            h2.toString();
        }
    }

    public void l() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.u.w(5);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_PAUSE);
        }
        mVar.O.e(h.a.ON_PAUSE);
        mVar.b = 6;
        mVar.D = false;
        mVar.e0();
        if (mVar.D) {
            this.a.f(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onPause()"));
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.c.c;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            m mVar = this.c;
            mVar.f1809d = mVar.c.getSparseParcelableArray("android:view_state");
            m mVar2 = this.c;
            mVar2.f1810e = mVar2.c.getBundle("android:view_registry_state");
            m mVar3 = this.c;
            mVar3.f1814i = mVar3.c.getString("android:target_state");
            m mVar4 = this.c;
            if (mVar4.f1814i != null) {
                mVar4.f1815j = mVar4.c.getInt("android:target_req_state", 0);
            }
            m mVar5 = this.c;
            Objects.requireNonNull(mVar5);
            mVar5.H = mVar5.c.getBoolean("android:user_visible_hint", true);
            m mVar6 = this.c;
            if (!mVar6.H) {
                mVar6.G = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void n() {
        boolean z;
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        m.d dVar = mVar.I;
        View view = dVar == null ? null : dVar.o;
        if (view != null) {
            if (view != mVar.F) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != this.c.F) {
                    }
                }
                z = false;
                if (z) {
                    boolean requestFocus = view.requestFocus();
                    if (e0.P(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestFocus: Restoring focused view ");
                        sb.append(view);
                        sb.append(" ");
                        sb.append(requestFocus ? "succeeded" : "failed");
                        sb.append(" on Fragment ");
                        sb.append(this.c);
                        sb.append(" resulting in focused view ");
                        sb.append(this.c.F.findFocus());
                        sb.toString();
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        this.c.B0(null);
        m mVar2 = this.c;
        mVar2.u.W();
        mVar2.u.C(true);
        mVar2.b = 7;
        mVar2.D = false;
        mVar2.i0();
        if (mVar2.D) {
            e.r.m mVar3 = mVar2.O;
            h.a aVar = h.a.ON_RESUME;
            mVar3.e(aVar);
            if (mVar2.F != null) {
                mVar2.P.b(aVar);
            }
            e0 e0Var = mVar2.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1796h = false;
            e0Var.w(7);
            this.a.i(this.c, false);
            m mVar4 = this.c;
            mVar4.c = null;
            mVar4.f1809d = null;
            mVar4.f1810e = null;
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar2, " did not call through to super.onResume()"));
    }

    public void o() {
        if (this.c.F != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.F.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.f1809d = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.P.f1888f.b(bundle);
            if (!bundle.isEmpty()) {
                this.c.f1810e = bundle;
            }
        }
    }

    public void p() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.u.W();
        mVar.u.C(true);
        mVar.b = 5;
        mVar.D = false;
        mVar.k0();
        if (mVar.D) {
            e.r.m mVar2 = mVar.O;
            h.a aVar = h.a.ON_START;
            mVar2.e(aVar);
            if (mVar.F != null) {
                mVar.P.b(aVar);
            }
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1796h = false;
            e0Var.w(5);
            this.a.k(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onStart()"));
    }

    public void q() {
        if (e0.P(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        e0 e0Var = mVar.u;
        e0Var.C = true;
        e0Var.J.f1796h = true;
        e0Var.w(4);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_STOP);
        }
        mVar.O.e(h.a.ON_STOP);
        mVar.b = 4;
        mVar.D = false;
        mVar.l0();
        if (mVar.D) {
            this.a.l(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", mVar, " did not call through to super.onStop()"));
    }
}
